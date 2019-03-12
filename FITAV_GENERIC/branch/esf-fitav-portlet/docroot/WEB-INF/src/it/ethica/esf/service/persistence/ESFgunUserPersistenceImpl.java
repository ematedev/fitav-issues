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

import it.ethica.esf.NoSuchgunUserException;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFgunUserImpl;
import it.ethica.esf.model.impl.ESFgunUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s fgun user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFgunUserPersistence
 * @see ESFgunUserUtil
 * @generated
 */
public class ESFgunUserPersistenceImpl extends BasePersistenceImpl<ESFgunUser>
	implements ESFgunUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFgunUserUtil} to access the e s fgun user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFgunUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID =
		new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyUserId",
			new String[] { Long.class.getName() },
			ESFgunUserModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERID = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s fgun users where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyUserId(long esfUserId)
		throws SystemException {
		return findBybyUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s fgun users where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @return the range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyUserId(long esfUserId, int start, int end)
		throws SystemException {
		return findBybyUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s fgun users where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyUserId(long esfUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFgunUser> list = (List<ESFgunUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFgunUser esFgunUser : list) {
				if ((esfUserId != esFgunUser.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFgunUser>(list);
				}
				else {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s fgun user in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyUserId_First(esfUserId,
				orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the first e s fgun user in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFgunUser> list = findBybyUserId(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyUserId_Last(esfUserId,
				orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFgunUser> list = findBybyUserId(esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfGunUserId the primary key of the current e s fgun user
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser[] findBybyUserId_PrevAndNext(long esfGunUserId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = findByPrimaryKey(esfGunUserId);

		Session session = null;

		try {
			session = openSession();

			ESFgunUser[] array = new ESFgunUserImpl[3];

			array[0] = getBybyUserId_PrevAndNext(session, esFgunUser,
					esfUserId, orderByComparator, true);

			array[1] = esFgunUser;

			array[2] = getBybyUserId_PrevAndNext(session, esFgunUser,
					esfUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFgunUser getBybyUserId_PrevAndNext(Session session,
		ESFgunUser esFgunUser, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

		query.append(_FINDER_COLUMN_BYUSERID_ESFUSERID_2);

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
			query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esFgunUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFgunUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s fgun users where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyUserId(long esfUserId) throws SystemException {
		for (ESFgunUser esFgunUser : findBybyUserId(esfUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esFgunUser);
		}
	}

	/**
	 * Returns the number of e s fgun users where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyUserId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYUSERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

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

	private static final String _FINDER_COLUMN_BYUSERID_ESFUSERID_2 = "esFgunUser.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYU_C = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyU_C",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_C = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyU_C",
			new String[] { Long.class.getName(), String.class.getName() },
			ESFgunUserModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFgunUserModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYU_C = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyU_C",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the e s fgun users where esfUserId = &#63; and code = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @return the matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyU_C(long esfUserId, String code)
		throws SystemException {
		return findBybyU_C(esfUserId, code, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s fgun users where esfUserId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @return the range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyU_C(long esfUserId, String code, int start,
		int end) throws SystemException {
		return findBybyU_C(esfUserId, code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s fgun users where esfUserId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyU_C(long esfUserId, String code, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_C;
			finderArgs = new Object[] { esfUserId, code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYU_C;
			finderArgs = new Object[] {
					esfUserId, code,
					
					start, end, orderByComparator
				};
		}

		List<ESFgunUser> list = (List<ESFgunUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFgunUser esFgunUser : list) {
				if ((esfUserId != esFgunUser.getEsfUserId()) ||
						!Validator.equals(code, esFgunUser.getCode())) {
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

			query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYU_C_ESFUSERID_2);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_BYU_C_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYU_C_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_BYU_C_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (bindCode) {
					qPos.add(code);
				}

				if (!pagination) {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFgunUser>(list);
				}
				else {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyU_C_First(long esfUserId, String code,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyU_C_First(esfUserId, code,
				orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the first e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyU_C_First(long esfUserId, String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFgunUser> list = findBybyU_C(esfUserId, code, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyU_C_Last(long esfUserId, String code,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyU_C_Last(esfUserId, code,
				orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyU_C_Last(long esfUserId, String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyU_C(esfUserId, code);

		if (count == 0) {
			return null;
		}

		List<ESFgunUser> list = findBybyU_C(esfUserId, code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	 *
	 * @param esfGunUserId the primary key of the current e s fgun user
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser[] findBybyU_C_PrevAndNext(long esfGunUserId,
		long esfUserId, String code, OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = findByPrimaryKey(esfGunUserId);

		Session session = null;

		try {
			session = openSession();

			ESFgunUser[] array = new ESFgunUserImpl[3];

			array[0] = getBybyU_C_PrevAndNext(session, esFgunUser, esfUserId,
					code, orderByComparator, true);

			array[1] = esFgunUser;

			array[2] = getBybyU_C_PrevAndNext(session, esFgunUser, esfUserId,
					code, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFgunUser getBybyU_C_PrevAndNext(Session session,
		ESFgunUser esFgunUser, long esfUserId, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

		query.append(_FINDER_COLUMN_BYU_C_ESFUSERID_2);

		boolean bindCode = false;

		if (code == null) {
			query.append(_FINDER_COLUMN_BYU_C_CODE_1);
		}
		else if (code.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYU_C_CODE_3);
		}
		else {
			bindCode = true;

			query.append(_FINDER_COLUMN_BYU_C_CODE_2);
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
			query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (bindCode) {
			qPos.add(code);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esFgunUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFgunUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s fgun users where esfUserId = &#63; and code = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyU_C(long esfUserId, String code)
		throws SystemException {
		for (ESFgunUser esFgunUser : findBybyU_C(esfUserId, code,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esFgunUser);
		}
	}

	/**
	 * Returns the number of e s fgun users where esfUserId = &#63; and code = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param code the code
	 * @return the number of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyU_C(long esfUserId, String code)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYU_C;

		Object[] finderArgs = new Object[] { esfUserId, code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYU_C_ESFUSERID_2);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_BYU_C_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYU_C_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_BYU_C_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

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

	private static final String _FINDER_COLUMN_BYU_C_ESFUSERID_2 = "esFgunUser.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_BYU_C_CODE_1 = "esFgunUser.code IS NULL";
	private static final String _FINDER_COLUMN_BYU_C_CODE_2 = "esFgunUser.code = ?";
	private static final String _FINDER_COLUMN_BYU_C_CODE_3 = "(esFgunUser.code IS NULL OR esFgunUser.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYU_T = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyU_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_T = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyU_T",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ESFgunUserModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFgunUserModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYU_T = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyU_T",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s fgun users where esfUserId = &#63; and type = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @return the matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyU_T(long esfUserId, int type)
		throws SystemException {
		return findBybyU_T(esfUserId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s fgun users where esfUserId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @return the range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyU_T(long esfUserId, int type, int start,
		int end) throws SystemException {
		return findBybyU_T(esfUserId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s fgun users where esfUserId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyU_T(long esfUserId, int type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_T;
			finderArgs = new Object[] { esfUserId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYU_T;
			finderArgs = new Object[] {
					esfUserId, type,
					
					start, end, orderByComparator
				};
		}

		List<ESFgunUser> list = (List<ESFgunUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFgunUser esFgunUser : list) {
				if ((esfUserId != esFgunUser.getEsfUserId()) ||
						(type != esFgunUser.getType())) {
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

			query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYU_T_ESFUSERID_2);

			query.append(_FINDER_COLUMN_BYU_T_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(type);

				if (!pagination) {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFgunUser>(list);
				}
				else {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyU_T_First(long esfUserId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyU_T_First(esfUserId, type,
				orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the first e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyU_T_First(long esfUserId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFgunUser> list = findBybyU_T(esfUserId, type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyU_T_Last(long esfUserId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyU_T_Last(esfUserId, type,
				orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyU_T_Last(long esfUserId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyU_T(esfUserId, type);

		if (count == 0) {
			return null;
		}

		List<ESFgunUser> list = findBybyU_T(esfUserId, type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	 *
	 * @param esfGunUserId the primary key of the current e s fgun user
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser[] findBybyU_T_PrevAndNext(long esfGunUserId,
		long esfUserId, int type, OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = findByPrimaryKey(esfGunUserId);

		Session session = null;

		try {
			session = openSession();

			ESFgunUser[] array = new ESFgunUserImpl[3];

			array[0] = getBybyU_T_PrevAndNext(session, esFgunUser, esfUserId,
					type, orderByComparator, true);

			array[1] = esFgunUser;

			array[2] = getBybyU_T_PrevAndNext(session, esFgunUser, esfUserId,
					type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFgunUser getBybyU_T_PrevAndNext(Session session,
		ESFgunUser esFgunUser, long esfUserId, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

		query.append(_FINDER_COLUMN_BYU_T_ESFUSERID_2);

		query.append(_FINDER_COLUMN_BYU_T_TYPE_2);

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
			query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esFgunUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFgunUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s fgun users where esfUserId = &#63; and type = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyU_T(long esfUserId, int type)
		throws SystemException {
		for (ESFgunUser esFgunUser : findBybyU_T(esfUserId, type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esFgunUser);
		}
	}

	/**
	 * Returns the number of e s fgun users where esfUserId = &#63; and type = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param type the type
	 * @return the number of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyU_T(long esfUserId, int type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYU_T;

		Object[] finderArgs = new Object[] { esfUserId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYU_T_ESFUSERID_2);

			query.append(_FINDER_COLUMN_BYU_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(type);

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

	private static final String _FINDER_COLUMN_BYU_T_ESFUSERID_2 = "esFgunUser.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_BYU_T_TYPE_2 = "esFgunUser.type = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYT = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyT",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYT = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyT",
			new String[] { Integer.class.getName() },
			ESFgunUserModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYT = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyT",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the e s fgun users where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyT(int type) throws SystemException {
		return findBybyT(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s fgun users where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @return the range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyT(int type, int start, int end)
		throws SystemException {
		return findBybyT(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s fgun users where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyT(int type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYT;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYT;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<ESFgunUser> list = (List<ESFgunUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFgunUser esFgunUser : list) {
				if ((type != esFgunUser.getType())) {
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

			query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYT_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (!pagination) {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFgunUser>(list);
				}
				else {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s fgun user in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyT_First(int type,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyT_First(type, orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the first e s fgun user in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyT_First(int type,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFgunUser> list = findBybyT(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s fgun user in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyT_Last(int type,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyT_Last(type, orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the last e s fgun user in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyT_Last(int type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyT(type);

		if (count == 0) {
			return null;
		}

		List<ESFgunUser> list = findBybyT(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s fgun users before and after the current e s fgun user in the ordered set where type = &#63;.
	 *
	 * @param esfGunUserId the primary key of the current e s fgun user
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser[] findBybyT_PrevAndNext(long esfGunUserId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = findByPrimaryKey(esfGunUserId);

		Session session = null;

		try {
			session = openSession();

			ESFgunUser[] array = new ESFgunUserImpl[3];

			array[0] = getBybyT_PrevAndNext(session, esFgunUser, type,
					orderByComparator, true);

			array[1] = esFgunUser;

			array[2] = getBybyT_PrevAndNext(session, esFgunUser, type,
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

	protected ESFgunUser getBybyT_PrevAndNext(Session session,
		ESFgunUser esFgunUser, int type, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

		query.append(_FINDER_COLUMN_BYT_TYPE_2);

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
			query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esFgunUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFgunUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s fgun users where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyT(int type) throws SystemException {
		for (ESFgunUser esFgunUser : findBybyT(type, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esFgunUser);
		}
	}

	/**
	 * Returns the number of e s fgun users where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyT(int type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYT;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYT_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

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

	private static final String _FINDER_COLUMN_BYT_TYPE_2 = "esFgunUser.type = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYGUNID = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyGunId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGUNID =
		new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyGunId",
			new String[] { Long.class.getName() },
			ESFgunUserModelImpl.ESFGUNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYGUNID = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyGunId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s fgun users where esfGunId = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @return the matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyGunId(long esfGunId)
		throws SystemException {
		return findBybyGunId(esfGunId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s fgun users where esfGunId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunId the esf gun ID
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @return the range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyGunId(long esfGunId, int start, int end)
		throws SystemException {
		return findBybyGunId(esfGunId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s fgun users where esfGunId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunId the esf gun ID
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findBybyGunId(long esfGunId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGUNID;
			finderArgs = new Object[] { esfGunId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYGUNID;
			finderArgs = new Object[] { esfGunId, start, end, orderByComparator };
		}

		List<ESFgunUser> list = (List<ESFgunUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFgunUser esFgunUser : list) {
				if ((esfGunId != esFgunUser.getEsfGunId())) {
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

			query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYGUNID_ESFGUNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunId);

				if (!pagination) {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFgunUser>(list);
				}
				else {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s fgun user in the ordered set where esfGunId = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyGunId_First(long esfGunId,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyGunId_First(esfGunId, orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunId=");
		msg.append(esfGunId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the first e s fgun user in the ordered set where esfGunId = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyGunId_First(long esfGunId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFgunUser> list = findBybyGunId(esfGunId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfGunId = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findBybyGunId_Last(long esfGunId,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchBybyGunId_Last(esfGunId, orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunId=");
		msg.append(esfGunId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfGunId = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchBybyGunId_Last(long esfGunId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyGunId(esfGunId);

		if (count == 0) {
			return null;
		}

		List<ESFgunUser> list = findBybyGunId(esfGunId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfGunId = &#63;.
	 *
	 * @param esfGunUserId the primary key of the current e s fgun user
	 * @param esfGunId the esf gun ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser[] findBybyGunId_PrevAndNext(long esfGunUserId,
		long esfGunId, OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = findByPrimaryKey(esfGunUserId);

		Session session = null;

		try {
			session = openSession();

			ESFgunUser[] array = new ESFgunUserImpl[3];

			array[0] = getBybyGunId_PrevAndNext(session, esFgunUser, esfGunId,
					orderByComparator, true);

			array[1] = esFgunUser;

			array[2] = getBybyGunId_PrevAndNext(session, esFgunUser, esfGunId,
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

	protected ESFgunUser getBybyGunId_PrevAndNext(Session session,
		ESFgunUser esFgunUser, long esfGunId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

		query.append(_FINDER_COLUMN_BYGUNID_ESFGUNID_2);

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
			query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfGunId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esFgunUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFgunUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s fgun users where esfGunId = &#63; from the database.
	 *
	 * @param esfGunId the esf gun ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyGunId(long esfGunId) throws SystemException {
		for (ESFgunUser esFgunUser : findBybyGunId(esfGunId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esFgunUser);
		}
	}

	/**
	 * Returns the number of e s fgun users where esfGunId = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @return the number of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyGunId(long esfGunId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYGUNID;

		Object[] finderArgs = new Object[] { esfGunId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_BYGUNID_ESFGUNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunId);

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

	private static final String _FINDER_COLUMN_BYGUNID_ESFGUNID_2 = "esFgunUser.esfGunId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ESFgunUserModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s fgun users where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findByCode(String code) throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s fgun users where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @return the range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s fgun users where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findByCode(String code, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code, start, end, orderByComparator };
		}

		List<ESFgunUser> list = (List<ESFgunUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFgunUser esFgunUser : list) {
				if (!Validator.equals(code, esFgunUser.getCode())) {
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

			query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFgunUser>(list);
				}
				else {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s fgun user in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchByCode_First(code, orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the first e s fgun user in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFgunUser> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s fgun user in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchByCode_Last(code, orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the last e s fgun user in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ESFgunUser> list = findByCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s fgun users before and after the current e s fgun user in the ordered set where code = &#63;.
	 *
	 * @param esfGunUserId the primary key of the current e s fgun user
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser[] findByCode_PrevAndNext(long esfGunUserId, String code,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = findByPrimaryKey(esfGunUserId);

		Session session = null;

		try {
			session = openSession();

			ESFgunUser[] array = new ESFgunUserImpl[3];

			array[0] = getByCode_PrevAndNext(session, esFgunUser, code,
					orderByComparator, true);

			array[1] = esFgunUser;

			array[2] = getByCode_PrevAndNext(session, esFgunUser, code,
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

	protected ESFgunUser getByCode_PrevAndNext(Session session,
		ESFgunUser esFgunUser, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

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
			query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCode) {
			qPos.add(code);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esFgunUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFgunUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s fgun users where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ESFgunUser esFgunUser : findByCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esFgunUser);
		}
	}

	/**
	 * Returns the number of e s fgun users where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s fgun users
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

			query.append(_SQL_COUNT_ESFGUNUSER_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esFgunUser.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esFgunUser.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esFgunUser.code IS NULL OR esFgunUser.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GUNID_TYPE =
		new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGunId_Type",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GUNID_TYPE =
		new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, ESFgunUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGunId_Type",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ESFgunUserModelImpl.ESFGUNID_COLUMN_BITMASK |
			ESFgunUserModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GUNID_TYPE = new FinderPath(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGunId_Type",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s fgun users where esfGunId = &#63; and type = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @return the matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findByGunId_Type(long esfGunId, int type)
		throws SystemException {
		return findByGunId_Type(esfGunId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s fgun users where esfGunId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @return the range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findByGunId_Type(long esfGunId, int type,
		int start, int end) throws SystemException {
		return findByGunId_Type(esfGunId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s fgun users where esfGunId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findByGunId_Type(long esfGunId, int type,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GUNID_TYPE;
			finderArgs = new Object[] { esfGunId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GUNID_TYPE;
			finderArgs = new Object[] {
					esfGunId, type,
					
					start, end, orderByComparator
				};
		}

		List<ESFgunUser> list = (List<ESFgunUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFgunUser esFgunUser : list) {
				if ((esfGunId != esFgunUser.getEsfGunId()) ||
						(type != esFgunUser.getType())) {
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

			query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_GUNID_TYPE_ESFGUNID_2);

			query.append(_FINDER_COLUMN_GUNID_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunId);

				qPos.add(type);

				if (!pagination) {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFgunUser>(list);
				}
				else {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findByGunId_Type_First(long esfGunId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchByGunId_Type_First(esfGunId, type,
				orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunId=");
		msg.append(esfGunId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the first e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchByGunId_Type_First(long esfGunId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFgunUser> list = findByGunId_Type(esfGunId, type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findByGunId_Type_Last(long esfGunId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchByGunId_Type_Last(esfGunId, type,
				orderByComparator);

		if (esFgunUser != null) {
			return esFgunUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunId=");
		msg.append(esfGunId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchgunUserException(msg.toString());
	}

	/**
	 * Returns the last e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchByGunId_Type_Last(long esfGunId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGunId_Type(esfGunId, type);

		if (count == 0) {
			return null;
		}

		List<ESFgunUser> list = findByGunId_Type(esfGunId, type, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	 *
	 * @param esfGunUserId the primary key of the current e s fgun user
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser[] findByGunId_Type_PrevAndNext(long esfGunUserId,
		long esfGunId, int type, OrderByComparator orderByComparator)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = findByPrimaryKey(esfGunUserId);

		Session session = null;

		try {
			session = openSession();

			ESFgunUser[] array = new ESFgunUserImpl[3];

			array[0] = getByGunId_Type_PrevAndNext(session, esFgunUser,
					esfGunId, type, orderByComparator, true);

			array[1] = esFgunUser;

			array[2] = getByGunId_Type_PrevAndNext(session, esFgunUser,
					esfGunId, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFgunUser getByGunId_Type_PrevAndNext(Session session,
		ESFgunUser esFgunUser, long esfGunId, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNUSER_WHERE);

		query.append(_FINDER_COLUMN_GUNID_TYPE_ESFGUNID_2);

		query.append(_FINDER_COLUMN_GUNID_TYPE_TYPE_2);

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
			query.append(ESFgunUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfGunId);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esFgunUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFgunUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s fgun users where esfGunId = &#63; and type = &#63; from the database.
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGunId_Type(long esfGunId, int type)
		throws SystemException {
		for (ESFgunUser esFgunUser : findByGunId_Type(esfGunId, type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esFgunUser);
		}
	}

	/**
	 * Returns the number of e s fgun users where esfGunId = &#63; and type = &#63;.
	 *
	 * @param esfGunId the esf gun ID
	 * @param type the type
	 * @return the number of matching e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGunId_Type(long esfGunId, int type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GUNID_TYPE;

		Object[] finderArgs = new Object[] { esfGunId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFGUNUSER_WHERE);

			query.append(_FINDER_COLUMN_GUNID_TYPE_ESFGUNID_2);

			query.append(_FINDER_COLUMN_GUNID_TYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunId);

				qPos.add(type);

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

	private static final String _FINDER_COLUMN_GUNID_TYPE_ESFGUNID_2 = "esFgunUser.esfGunId = ? AND ";
	private static final String _FINDER_COLUMN_GUNID_TYPE_TYPE_2 = "esFgunUser.type = ?";

	public ESFgunUserPersistenceImpl() {
		setModelClass(ESFgunUser.class);
	}

	/**
	 * Caches the e s fgun user in the entity cache if it is enabled.
	 *
	 * @param esFgunUser the e s fgun user
	 */
	@Override
	public void cacheResult(ESFgunUser esFgunUser) {
		EntityCacheUtil.putResult(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserImpl.class, esFgunUser.getPrimaryKey(), esFgunUser);

		esFgunUser.resetOriginalValues();
	}

	/**
	 * Caches the e s fgun users in the entity cache if it is enabled.
	 *
	 * @param esFgunUsers the e s fgun users
	 */
	@Override
	public void cacheResult(List<ESFgunUser> esFgunUsers) {
		for (ESFgunUser esFgunUser : esFgunUsers) {
			if (EntityCacheUtil.getResult(
						ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFgunUserImpl.class, esFgunUser.getPrimaryKey()) == null) {
				cacheResult(esFgunUser);
			}
			else {
				esFgunUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s fgun users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFgunUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFgunUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s fgun user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFgunUser esFgunUser) {
		EntityCacheUtil.removeResult(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserImpl.class, esFgunUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFgunUser> esFgunUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFgunUser esFgunUser : esFgunUsers) {
			EntityCacheUtil.removeResult(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFgunUserImpl.class, esFgunUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s fgun user with the primary key. Does not add the e s fgun user to the database.
	 *
	 * @param esfGunUserId the primary key for the new e s fgun user
	 * @return the new e s fgun user
	 */
	@Override
	public ESFgunUser create(long esfGunUserId) {
		ESFgunUser esFgunUser = new ESFgunUserImpl();

		esFgunUser.setNew(true);
		esFgunUser.setPrimaryKey(esfGunUserId);

		return esFgunUser;
	}

	/**
	 * Removes the e s fgun user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfGunUserId the primary key of the e s fgun user
	 * @return the e s fgun user that was removed
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser remove(long esfGunUserId)
		throws NoSuchgunUserException, SystemException {
		return remove((Serializable)esfGunUserId);
	}

	/**
	 * Removes the e s fgun user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s fgun user
	 * @return the e s fgun user that was removed
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser remove(Serializable primaryKey)
		throws NoSuchgunUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFgunUser esFgunUser = (ESFgunUser)session.get(ESFgunUserImpl.class,
					primaryKey);

			if (esFgunUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchgunUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esFgunUser);
		}
		catch (NoSuchgunUserException nsee) {
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
	protected ESFgunUser removeImpl(ESFgunUser esFgunUser)
		throws SystemException {
		esFgunUser = toUnwrappedModel(esFgunUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esFgunUser)) {
				esFgunUser = (ESFgunUser)session.get(ESFgunUserImpl.class,
						esFgunUser.getPrimaryKeyObj());
			}

			if (esFgunUser != null) {
				session.delete(esFgunUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esFgunUser != null) {
			clearCache(esFgunUser);
		}

		return esFgunUser;
	}

	@Override
	public ESFgunUser updateImpl(it.ethica.esf.model.ESFgunUser esFgunUser)
		throws SystemException {
		esFgunUser = toUnwrappedModel(esFgunUser);

		boolean isNew = esFgunUser.isNew();

		ESFgunUserModelImpl esFgunUserModelImpl = (ESFgunUserModelImpl)esFgunUser;

		Session session = null;

		try {
			session = openSession();

			if (esFgunUser.isNew()) {
				session.save(esFgunUser);

				esFgunUser.setNew(false);
			}
			else {
				session.merge(esFgunUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFgunUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esFgunUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esFgunUserModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);

				args = new Object[] { esFgunUserModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);
			}

			if ((esFgunUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esFgunUserModelImpl.getOriginalEsfUserId(),
						esFgunUserModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYU_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_C,
					args);

				args = new Object[] {
						esFgunUserModelImpl.getEsfUserId(),
						esFgunUserModelImpl.getCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYU_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_C,
					args);
			}

			if ((esFgunUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esFgunUserModelImpl.getOriginalEsfUserId(),
						esFgunUserModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYU_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_T,
					args);

				args = new Object[] {
						esFgunUserModelImpl.getEsfUserId(),
						esFgunUserModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYU_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYU_T,
					args);
			}

			if ((esFgunUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esFgunUserModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYT,
					args);

				args = new Object[] { esFgunUserModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYT,
					args);
			}

			if ((esFgunUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGUNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esFgunUserModelImpl.getOriginalEsfGunId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYGUNID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGUNID,
					args);

				args = new Object[] { esFgunUserModelImpl.getEsfGunId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYGUNID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGUNID,
					args);
			}

			if ((esFgunUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esFgunUserModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esFgunUserModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}

			if ((esFgunUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GUNID_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esFgunUserModelImpl.getOriginalEsfGunId(),
						esFgunUserModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GUNID_TYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GUNID_TYPE,
					args);

				args = new Object[] {
						esFgunUserModelImpl.getEsfGunId(),
						esFgunUserModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GUNID_TYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GUNID_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFgunUserImpl.class, esFgunUser.getPrimaryKey(), esFgunUser);

		return esFgunUser;
	}

	protected ESFgunUser toUnwrappedModel(ESFgunUser esFgunUser) {
		if (esFgunUser instanceof ESFgunUserImpl) {
			return esFgunUser;
		}

		ESFgunUserImpl esFgunUserImpl = new ESFgunUserImpl();

		esFgunUserImpl.setNew(esFgunUser.isNew());
		esFgunUserImpl.setPrimaryKey(esFgunUser.getPrimaryKey());

		esFgunUserImpl.setEsfGunUserId(esFgunUser.getEsfGunUserId());
		esFgunUserImpl.setEsfGunId(esFgunUser.getEsfGunId());
		esFgunUserImpl.setEsfUserId(esFgunUser.getEsfUserId());
		esFgunUserImpl.setCode(esFgunUser.getCode());
		esFgunUserImpl.setIsFavorite(esFgunUser.isIsFavorite());
		esFgunUserImpl.setType(esFgunUser.getType());
		esFgunUserImpl.setNote(esFgunUser.getNote());
		esFgunUserImpl.setEsfGunnTypeId(esFgunUser.getEsfGunnTypeId());
		esFgunUserImpl.setEsfGunKindId(esFgunUser.getEsfGunKindId());
		esFgunUserImpl.setTypeId(esFgunUser.getTypeId());
		esFgunUserImpl.setEsfMeasures(esFgunUser.getEsfMeasures());
		esFgunUserImpl.setEsfCaliber(esFgunUser.getEsfCaliber());

		return esFgunUserImpl;
	}

	/**
	 * Returns the e s fgun user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s fgun user
	 * @return the e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchgunUserException, SystemException {
		ESFgunUser esFgunUser = fetchByPrimaryKey(primaryKey);

		if (esFgunUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchgunUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esFgunUser;
	}

	/**
	 * Returns the e s fgun user with the primary key or throws a {@link it.ethica.esf.NoSuchgunUserException} if it could not be found.
	 *
	 * @param esfGunUserId the primary key of the e s fgun user
	 * @return the e s fgun user
	 * @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser findByPrimaryKey(long esfGunUserId)
		throws NoSuchgunUserException, SystemException {
		return findByPrimaryKey((Serializable)esfGunUserId);
	}

	/**
	 * Returns the e s fgun user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s fgun user
	 * @return the e s fgun user, or <code>null</code> if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFgunUser esFgunUser = (ESFgunUser)EntityCacheUtil.getResult(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFgunUserImpl.class, primaryKey);

		if (esFgunUser == _nullESFgunUser) {
			return null;
		}

		if (esFgunUser == null) {
			Session session = null;

			try {
				session = openSession();

				esFgunUser = (ESFgunUser)session.get(ESFgunUserImpl.class,
						primaryKey);

				if (esFgunUser != null) {
					cacheResult(esFgunUser);
				}
				else {
					EntityCacheUtil.putResult(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFgunUserImpl.class, primaryKey, _nullESFgunUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFgunUserModelImpl.ENTITY_CACHE_ENABLED,
					ESFgunUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esFgunUser;
	}

	/**
	 * Returns the e s fgun user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfGunUserId the primary key of the e s fgun user
	 * @return the e s fgun user, or <code>null</code> if a e s fgun user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFgunUser fetchByPrimaryKey(long esfGunUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfGunUserId);
	}

	/**
	 * Returns all the e s fgun users.
	 *
	 * @return the e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s fgun users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @return the range of e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s fgun users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s fgun users
	 * @param end the upper bound of the range of e s fgun users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s fgun users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFgunUser> findAll(int start, int end,
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

		List<ESFgunUser> list = (List<ESFgunUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFGUNUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFGUNUSER;

				if (pagination) {
					sql = sql.concat(ESFgunUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFgunUser>(list);
				}
				else {
					list = (List<ESFgunUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s fgun users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFgunUser esFgunUser : findAll()) {
			remove(esFgunUser);
		}
	}

	/**
	 * Returns the number of e s fgun users.
	 *
	 * @return the number of e s fgun users
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

				Query q = session.createQuery(_SQL_COUNT_ESFGUNUSER);

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
	 * Initializes the e s fgun user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFgunUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFgunUser>> listenersList = new ArrayList<ModelListener<ESFgunUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFgunUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFgunUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFGUNUSER = "SELECT esFgunUser FROM ESFgunUser esFgunUser";
	private static final String _SQL_SELECT_ESFGUNUSER_WHERE = "SELECT esFgunUser FROM ESFgunUser esFgunUser WHERE ";
	private static final String _SQL_COUNT_ESFGUNUSER = "SELECT COUNT(esFgunUser) FROM ESFgunUser esFgunUser";
	private static final String _SQL_COUNT_ESFGUNUSER_WHERE = "SELECT COUNT(esFgunUser) FROM ESFgunUser esFgunUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esFgunUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFgunUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFgunUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFgunUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code", "type"
			});
	private static ESFgunUser _nullESFgunUser = new ESFgunUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFgunUser> toCacheModel() {
				return _nullESFgunUserCacheModel;
			}
		};

	private static CacheModel<ESFgunUser> _nullESFgunUserCacheModel = new CacheModel<ESFgunUser>() {
			@Override
			public ESFgunUser toEntityModel() {
				return _nullESFgunUser;
			}
		};
}