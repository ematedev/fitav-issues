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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchRenewalException;
import it.ethica.esf.model.ESFRenewal;
import it.ethica.esf.model.impl.ESFRenewalImpl;
import it.ethica.esf.model.impl.ESFRenewalModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f renewal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRenewalPersistence
 * @see ESFRenewalUtil
 * @generated
 */
public class ESFRenewalPersistenceImpl extends BasePersistenceImpl<ESFRenewal>
	implements ESFRenewalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRenewalUtil} to access the e s f renewal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRenewalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFRENEWALUSER =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFRenewalUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFRENEWALUSER =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFRenewalUser",
			new String[] { Long.class.getName() },
			ESFRenewalModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFRENEWALUSER = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFRenewalUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f renewals where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByESFRenewalUser(long userId)
		throws SystemException {
		return findByESFRenewalUser(userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewals where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @return the range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByESFRenewalUser(long userId, int start, int end)
		throws SystemException {
		return findByESFRenewalUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewals where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByESFRenewalUser(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFRENEWALUSER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFRENEWALUSER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<ESFRenewal> list = (List<ESFRenewal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewal esfRenewal : list) {
				if ((userId != esfRenewal.getUserId())) {
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

			query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

			query.append(_FINDER_COLUMN_ESFRENEWALUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewal>(list);
				}
				else {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f renewal in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByESFRenewalUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByESFRenewalUser_First(userId,
				orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByESFRenewalUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRenewal> list = findByESFRenewalUser(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByESFRenewalUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByESFRenewalUser_Last(userId,
				orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByESFRenewalUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFRenewalUser(userId);

		if (count == 0) {
			return null;
		}

		List<ESFRenewal> list = findByESFRenewalUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewals before and after the current e s f renewal in the ordered set where userId = &#63;.
	 *
	 * @param esfRenewalId the primary key of the current e s f renewal
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal[] findByESFRenewalUser_PrevAndNext(long esfRenewalId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = findByPrimaryKey(esfRenewalId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewal[] array = new ESFRenewalImpl[3];

			array[0] = getByESFRenewalUser_PrevAndNext(session, esfRenewal,
					userId, orderByComparator, true);

			array[1] = esfRenewal;

			array[2] = getByESFRenewalUser_PrevAndNext(session, esfRenewal,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewal getByESFRenewalUser_PrevAndNext(Session session,
		ESFRenewal esfRenewal, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

		query.append(_FINDER_COLUMN_ESFRENEWALUSER_USERID_2);

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
			query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewals where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFRenewalUser(long userId) throws SystemException {
		for (ESFRenewal esfRenewal : findByESFRenewalUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewal);
		}
	}

	/**
	 * Returns the number of e s f renewals where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFRenewalUser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFRENEWALUSER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRENEWAL_WHERE);

			query.append(_FINDER_COLUMN_ESFRENEWALUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_ESFRENEWALUSER_USERID_2 = "esfRenewal.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGID_ISTOTAL =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrgId_IsTotal",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_ISTOTAL =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrgId_IsTotal",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ESFRenewalModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			ESFRenewalModelImpl.ISTOTAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID_ISTOTAL = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrgId_IsTotal",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the e s f renewals where organizationId = &#63; and isTotal = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @return the matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrgId_IsTotal(long organizationId,
		boolean isTotal) throws SystemException {
		return findByOrgId_IsTotal(organizationId, isTotal, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewals where organizationId = &#63; and isTotal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @return the range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrgId_IsTotal(long organizationId,
		boolean isTotal, int start, int end) throws SystemException {
		return findByOrgId_IsTotal(organizationId, isTotal, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewals where organizationId = &#63; and isTotal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrgId_IsTotal(long organizationId,
		boolean isTotal, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_ISTOTAL;
			finderArgs = new Object[] { organizationId, isTotal };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGID_ISTOTAL;
			finderArgs = new Object[] {
					organizationId, isTotal,
					
					start, end, orderByComparator
				};
		}

		List<ESFRenewal> list = (List<ESFRenewal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewal esfRenewal : list) {
				if ((organizationId != esfRenewal.getOrganizationId()) ||
						(isTotal != esfRenewal.getIsTotal())) {
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

			query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

			query.append(_FINDER_COLUMN_ORGID_ISTOTAL_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGID_ISTOTAL_ISTOTAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(isTotal);

				if (!pagination) {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewal>(list);
				}
				else {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByOrgId_IsTotal_First(long organizationId,
		boolean isTotal, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByOrgId_IsTotal_First(organizationId,
				isTotal, orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", isTotal=");
		msg.append(isTotal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByOrgId_IsTotal_First(long organizationId,
		boolean isTotal, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFRenewal> list = findByOrgId_IsTotal(organizationId, isTotal, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByOrgId_IsTotal_Last(long organizationId,
		boolean isTotal, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByOrgId_IsTotal_Last(organizationId,
				isTotal, orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", isTotal=");
		msg.append(isTotal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByOrgId_IsTotal_Last(long organizationId,
		boolean isTotal, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrgId_IsTotal(organizationId, isTotal);

		if (count == 0) {
			return null;
		}

		List<ESFRenewal> list = findByOrgId_IsTotal(organizationId, isTotal,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewals before and after the current e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	 *
	 * @param esfRenewalId the primary key of the current e s f renewal
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal[] findByOrgId_IsTotal_PrevAndNext(long esfRenewalId,
		long organizationId, boolean isTotal,
		OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = findByPrimaryKey(esfRenewalId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewal[] array = new ESFRenewalImpl[3];

			array[0] = getByOrgId_IsTotal_PrevAndNext(session, esfRenewal,
					organizationId, isTotal, orderByComparator, true);

			array[1] = esfRenewal;

			array[2] = getByOrgId_IsTotal_PrevAndNext(session, esfRenewal,
					organizationId, isTotal, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewal getByOrgId_IsTotal_PrevAndNext(Session session,
		ESFRenewal esfRenewal, long organizationId, boolean isTotal,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

		query.append(_FINDER_COLUMN_ORGID_ISTOTAL_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_ORGID_ISTOTAL_ISTOTAL_2);

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
			query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(isTotal);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewals where organizationId = &#63; and isTotal = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrgId_IsTotal(long organizationId, boolean isTotal)
		throws SystemException {
		for (ESFRenewal esfRenewal : findByOrgId_IsTotal(organizationId,
				isTotal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewal);
		}
	}

	/**
	 * Returns the number of e s f renewals where organizationId = &#63; and isTotal = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param isTotal the is total
	 * @return the number of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrgId_IsTotal(long organizationId, boolean isTotal)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGID_ISTOTAL;

		Object[] finderArgs = new Object[] { organizationId, isTotal };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRENEWAL_WHERE);

			query.append(_FINDER_COLUMN_ORGID_ISTOTAL_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGID_ISTOTAL_ISTOTAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(isTotal);

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

	private static final String _FINDER_COLUMN_ORGID_ISTOTAL_ORGANIZATIONID_2 = "esfRenewal.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORGID_ISTOTAL_ISTOTAL_2 = "esfRenewal.isTotal = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RENEWALFATHERID =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRenewalFatherId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RENEWALFATHERID =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRenewalFatherId",
			new String[] { Long.class.getName() },
			ESFRenewalModelImpl.RENEWALFATHERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RENEWALFATHERID = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRenewalFatherId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f renewals where renewalFatherId = &#63;.
	 *
	 * @param renewalFatherId the renewal father ID
	 * @return the matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByRenewalFatherId(long renewalFatherId)
		throws SystemException {
		return findByRenewalFatherId(renewalFatherId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewals where renewalFatherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param renewalFatherId the renewal father ID
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @return the range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByRenewalFatherId(long renewalFatherId,
		int start, int end) throws SystemException {
		return findByRenewalFatherId(renewalFatherId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewals where renewalFatherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param renewalFatherId the renewal father ID
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByRenewalFatherId(long renewalFatherId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RENEWALFATHERID;
			finderArgs = new Object[] { renewalFatherId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RENEWALFATHERID;
			finderArgs = new Object[] {
					renewalFatherId,
					
					start, end, orderByComparator
				};
		}

		List<ESFRenewal> list = (List<ESFRenewal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewal esfRenewal : list) {
				if ((renewalFatherId != esfRenewal.getRenewalFatherId())) {
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

			query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

			query.append(_FINDER_COLUMN_RENEWALFATHERID_RENEWALFATHERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(renewalFatherId);

				if (!pagination) {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewal>(list);
				}
				else {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f renewal in the ordered set where renewalFatherId = &#63;.
	 *
	 * @param renewalFatherId the renewal father ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByRenewalFatherId_First(long renewalFatherId,
		OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByRenewalFatherId_First(renewalFatherId,
				orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("renewalFatherId=");
		msg.append(renewalFatherId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal in the ordered set where renewalFatherId = &#63;.
	 *
	 * @param renewalFatherId the renewal father ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByRenewalFatherId_First(long renewalFatherId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRenewal> list = findByRenewalFatherId(renewalFatherId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal in the ordered set where renewalFatherId = &#63;.
	 *
	 * @param renewalFatherId the renewal father ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByRenewalFatherId_Last(long renewalFatherId,
		OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByRenewalFatherId_Last(renewalFatherId,
				orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("renewalFatherId=");
		msg.append(renewalFatherId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal in the ordered set where renewalFatherId = &#63;.
	 *
	 * @param renewalFatherId the renewal father ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByRenewalFatherId_Last(long renewalFatherId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRenewalFatherId(renewalFatherId);

		if (count == 0) {
			return null;
		}

		List<ESFRenewal> list = findByRenewalFatherId(renewalFatherId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewals before and after the current e s f renewal in the ordered set where renewalFatherId = &#63;.
	 *
	 * @param esfRenewalId the primary key of the current e s f renewal
	 * @param renewalFatherId the renewal father ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal[] findByRenewalFatherId_PrevAndNext(long esfRenewalId,
		long renewalFatherId, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = findByPrimaryKey(esfRenewalId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewal[] array = new ESFRenewalImpl[3];

			array[0] = getByRenewalFatherId_PrevAndNext(session, esfRenewal,
					renewalFatherId, orderByComparator, true);

			array[1] = esfRenewal;

			array[2] = getByRenewalFatherId_PrevAndNext(session, esfRenewal,
					renewalFatherId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewal getByRenewalFatherId_PrevAndNext(Session session,
		ESFRenewal esfRenewal, long renewalFatherId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

		query.append(_FINDER_COLUMN_RENEWALFATHERID_RENEWALFATHERID_2);

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
			query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(renewalFatherId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewals where renewalFatherId = &#63; from the database.
	 *
	 * @param renewalFatherId the renewal father ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRenewalFatherId(long renewalFatherId)
		throws SystemException {
		for (ESFRenewal esfRenewal : findByRenewalFatherId(renewalFatherId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewal);
		}
	}

	/**
	 * Returns the number of e s f renewals where renewalFatherId = &#63;.
	 *
	 * @param renewalFatherId the renewal father ID
	 * @return the number of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRenewalFatherId(long renewalFatherId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RENEWALFATHERID;

		Object[] finderArgs = new Object[] { renewalFatherId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRENEWAL_WHERE);

			query.append(_FINDER_COLUMN_RENEWALFATHERID_RENEWALFATHERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(renewalFatherId);

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

	private static final String _FINDER_COLUMN_RENEWALFATHERID_RENEWALFATHERID_2 =
		"esfRenewal.renewalFatherId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGID_REASON =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrgId_Reason",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_REASON =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrgId_Reason",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFRenewalModelImpl.PAYMENTREASON_COLUMN_BITMASK |
			ESFRenewalModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID_REASON = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrgId_Reason",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f renewals where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @return the matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrgId_Reason(String paymentReason,
		long organizationId) throws SystemException {
		return findByOrgId_Reason(paymentReason, organizationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewals where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @return the range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrgId_Reason(String paymentReason,
		long organizationId, int start, int end) throws SystemException {
		return findByOrgId_Reason(paymentReason, organizationId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the e s f renewals where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrgId_Reason(String paymentReason,
		long organizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_REASON;
			finderArgs = new Object[] { paymentReason, organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGID_REASON;
			finderArgs = new Object[] {
					paymentReason, organizationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFRenewal> list = (List<ESFRenewal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewal esfRenewal : list) {
				if (!Validator.equals(paymentReason,
							esfRenewal.getPaymentReason()) ||
						(organizationId != esfRenewal.getOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

			boolean bindPaymentReason = false;

			if (paymentReason == null) {
				query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_1);
			}
			else if (paymentReason.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_3);
			}
			else {
				bindPaymentReason = true;

				query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_2);
			}

			query.append(_FINDER_COLUMN_ORGID_REASON_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPaymentReason) {
					qPos.add(paymentReason);
				}

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewal>(list);
				}
				else {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByOrgId_Reason_First(String paymentReason,
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByOrgId_Reason_First(paymentReason,
				organizationId, orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentReason=");
		msg.append(paymentReason);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByOrgId_Reason_First(String paymentReason,
		long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFRenewal> list = findByOrgId_Reason(paymentReason,
				organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByOrgId_Reason_Last(String paymentReason,
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByOrgId_Reason_Last(paymentReason,
				organizationId, orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentReason=");
		msg.append(paymentReason);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByOrgId_Reason_Last(String paymentReason,
		long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrgId_Reason(paymentReason, organizationId);

		if (count == 0) {
			return null;
		}

		List<ESFRenewal> list = findByOrgId_Reason(paymentReason,
				organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewals before and after the current e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * @param esfRenewalId the primary key of the current e s f renewal
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal[] findByOrgId_Reason_PrevAndNext(long esfRenewalId,
		String paymentReason, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = findByPrimaryKey(esfRenewalId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewal[] array = new ESFRenewalImpl[3];

			array[0] = getByOrgId_Reason_PrevAndNext(session, esfRenewal,
					paymentReason, organizationId, orderByComparator, true);

			array[1] = esfRenewal;

			array[2] = getByOrgId_Reason_PrevAndNext(session, esfRenewal,
					paymentReason, organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewal getByOrgId_Reason_PrevAndNext(Session session,
		ESFRenewal esfRenewal, String paymentReason, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

		boolean bindPaymentReason = false;

		if (paymentReason == null) {
			query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_1);
		}
		else if (paymentReason.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_3);
		}
		else {
			bindPaymentReason = true;

			query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_2);
		}

		query.append(_FINDER_COLUMN_ORGID_REASON_ORGANIZATIONID_2);

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
			query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPaymentReason) {
			qPos.add(paymentReason);
		}

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewals where paymentReason = &#63; and organizationId = &#63; from the database.
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrgId_Reason(String paymentReason, long organizationId)
		throws SystemException {
		for (ESFRenewal esfRenewal : findByOrgId_Reason(paymentReason,
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewal);
		}
	}

	/**
	 * Returns the number of e s f renewals where paymentReason = &#63; and organizationId = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param organizationId the organization ID
	 * @return the number of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrgId_Reason(String paymentReason, long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGID_REASON;

		Object[] finderArgs = new Object[] { paymentReason, organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRENEWAL_WHERE);

			boolean bindPaymentReason = false;

			if (paymentReason == null) {
				query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_1);
			}
			else if (paymentReason.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_3);
			}
			else {
				bindPaymentReason = true;

				query.append(_FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_2);
			}

			query.append(_FINDER_COLUMN_ORGID_REASON_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPaymentReason) {
					qPos.add(paymentReason);
				}

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_1 = "esfRenewal.paymentReason IS NULL AND ";
	private static final String _FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_2 = "esfRenewal.paymentReason = ? AND ";
	private static final String _FINDER_COLUMN_ORGID_REASON_PAYMENTREASON_3 = "(esfRenewal.paymentReason IS NULL OR esfRenewal.paymentReason = '') AND ";
	private static final String _FINDER_COLUMN_ORGID_REASON_ORGANIZATIONID_2 = "esfRenewal.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REASON_ISTOTAL =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReason_IsTotal",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REASON_ISTOTAL =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReason_IsTotal",
			new String[] { String.class.getName(), Boolean.class.getName() },
			ESFRenewalModelImpl.PAYMENTREASON_COLUMN_BITMASK |
			ESFRenewalModelImpl.ISTOTAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REASON_ISTOTAL = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReason_IsTotal",
			new String[] { String.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the e s f renewals where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @return the matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByReason_IsTotal(String paymentReason,
		boolean isTotal) throws SystemException {
		return findByReason_IsTotal(paymentReason, isTotal, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewals where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @return the range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByReason_IsTotal(String paymentReason,
		boolean isTotal, int start, int end) throws SystemException {
		return findByReason_IsTotal(paymentReason, isTotal, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewals where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByReason_IsTotal(String paymentReason,
		boolean isTotal, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REASON_ISTOTAL;
			finderArgs = new Object[] { paymentReason, isTotal };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REASON_ISTOTAL;
			finderArgs = new Object[] {
					paymentReason, isTotal,
					
					start, end, orderByComparator
				};
		}

		List<ESFRenewal> list = (List<ESFRenewal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewal esfRenewal : list) {
				if (!Validator.equals(paymentReason,
							esfRenewal.getPaymentReason()) ||
						(isTotal != esfRenewal.getIsTotal())) {
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

			query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

			boolean bindPaymentReason = false;

			if (paymentReason == null) {
				query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_1);
			}
			else if (paymentReason.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_3);
			}
			else {
				bindPaymentReason = true;

				query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_2);
			}

			query.append(_FINDER_COLUMN_REASON_ISTOTAL_ISTOTAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPaymentReason) {
					qPos.add(paymentReason);
				}

				qPos.add(isTotal);

				if (!pagination) {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewal>(list);
				}
				else {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByReason_IsTotal_First(String paymentReason,
		boolean isTotal, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByReason_IsTotal_First(paymentReason,
				isTotal, orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentReason=");
		msg.append(paymentReason);

		msg.append(", isTotal=");
		msg.append(isTotal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByReason_IsTotal_First(String paymentReason,
		boolean isTotal, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFRenewal> list = findByReason_IsTotal(paymentReason, isTotal, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByReason_IsTotal_Last(String paymentReason,
		boolean isTotal, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByReason_IsTotal_Last(paymentReason,
				isTotal, orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentReason=");
		msg.append(paymentReason);

		msg.append(", isTotal=");
		msg.append(isTotal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByReason_IsTotal_Last(String paymentReason,
		boolean isTotal, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByReason_IsTotal(paymentReason, isTotal);

		if (count == 0) {
			return null;
		}

		List<ESFRenewal> list = findByReason_IsTotal(paymentReason, isTotal,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewals before and after the current e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * @param esfRenewalId the primary key of the current e s f renewal
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal[] findByReason_IsTotal_PrevAndNext(long esfRenewalId,
		String paymentReason, boolean isTotal,
		OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = findByPrimaryKey(esfRenewalId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewal[] array = new ESFRenewalImpl[3];

			array[0] = getByReason_IsTotal_PrevAndNext(session, esfRenewal,
					paymentReason, isTotal, orderByComparator, true);

			array[1] = esfRenewal;

			array[2] = getByReason_IsTotal_PrevAndNext(session, esfRenewal,
					paymentReason, isTotal, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewal getByReason_IsTotal_PrevAndNext(Session session,
		ESFRenewal esfRenewal, String paymentReason, boolean isTotal,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

		boolean bindPaymentReason = false;

		if (paymentReason == null) {
			query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_1);
		}
		else if (paymentReason.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_3);
		}
		else {
			bindPaymentReason = true;

			query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_2);
		}

		query.append(_FINDER_COLUMN_REASON_ISTOTAL_ISTOTAL_2);

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
			query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPaymentReason) {
			qPos.add(paymentReason);
		}

		qPos.add(isTotal);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewals where paymentReason = &#63; and isTotal = &#63; from the database.
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReason_IsTotal(String paymentReason, boolean isTotal)
		throws SystemException {
		for (ESFRenewal esfRenewal : findByReason_IsTotal(paymentReason,
				isTotal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewal);
		}
	}

	/**
	 * Returns the number of e s f renewals where paymentReason = &#63; and isTotal = &#63;.
	 *
	 * @param paymentReason the payment reason
	 * @param isTotal the is total
	 * @return the number of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReason_IsTotal(String paymentReason, boolean isTotal)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REASON_ISTOTAL;

		Object[] finderArgs = new Object[] { paymentReason, isTotal };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRENEWAL_WHERE);

			boolean bindPaymentReason = false;

			if (paymentReason == null) {
				query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_1);
			}
			else if (paymentReason.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_3);
			}
			else {
				bindPaymentReason = true;

				query.append(_FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_2);
			}

			query.append(_FINDER_COLUMN_REASON_ISTOTAL_ISTOTAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPaymentReason) {
					qPos.add(paymentReason);
				}

				qPos.add(isTotal);

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

	private static final String _FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_1 = "esfRenewal.paymentReason IS NULL AND ";
	private static final String _FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_2 = "esfRenewal.paymentReason = ? AND ";
	private static final String _FINDER_COLUMN_REASON_ISTOTAL_PAYMENTREASON_3 = "(esfRenewal.paymentReason IS NULL OR esfRenewal.paymentReason = '') AND ";
	private static final String _FINDER_COLUMN_REASON_ISTOTAL_ISTOTAL_2 = "esfRenewal.isTotal = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORG_YEAR = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrg_Year",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_YEAR =
		new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, ESFRenewalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrg_Year",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ESFRenewalModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			ESFRenewalModelImpl.REPORTINGYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORG_YEAR = new FinderPath(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrg_Year",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s f renewals where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @return the matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrg_Year(long organizationId,
		int reportingYear) throws SystemException {
		return findByOrg_Year(organizationId, reportingYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewals where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @return the range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrg_Year(long organizationId,
		int reportingYear, int start, int end) throws SystemException {
		return findByOrg_Year(organizationId, reportingYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewals where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findByOrg_Year(long organizationId,
		int reportingYear, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_YEAR;
			finderArgs = new Object[] { organizationId, reportingYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORG_YEAR;
			finderArgs = new Object[] {
					organizationId, reportingYear,
					
					start, end, orderByComparator
				};
		}

		List<ESFRenewal> list = (List<ESFRenewal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewal esfRenewal : list) {
				if ((organizationId != esfRenewal.getOrganizationId()) ||
						(reportingYear != esfRenewal.getReportingYear())) {
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

			query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

			query.append(_FINDER_COLUMN_ORG_YEAR_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORG_YEAR_REPORTINGYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(reportingYear);

				if (!pagination) {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewal>(list);
				}
				else {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByOrg_Year_First(long organizationId,
		int reportingYear, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByOrg_Year_First(organizationId,
				reportingYear, orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", reportingYear=");
		msg.append(reportingYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByOrg_Year_First(long organizationId,
		int reportingYear, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFRenewal> list = findByOrg_Year(organizationId, reportingYear,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByOrg_Year_Last(long organizationId,
		int reportingYear, OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByOrg_Year_Last(organizationId,
				reportingYear, orderByComparator);

		if (esfRenewal != null) {
			return esfRenewal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", reportingYear=");
		msg.append(reportingYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRenewalException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByOrg_Year_Last(long organizationId,
		int reportingYear, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrg_Year(organizationId, reportingYear);

		if (count == 0) {
			return null;
		}

		List<ESFRenewal> list = findByOrg_Year(organizationId, reportingYear,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewals before and after the current e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * @param esfRenewalId the primary key of the current e s f renewal
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal[] findByOrg_Year_PrevAndNext(long esfRenewalId,
		long organizationId, int reportingYear,
		OrderByComparator orderByComparator)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = findByPrimaryKey(esfRenewalId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewal[] array = new ESFRenewalImpl[3];

			array[0] = getByOrg_Year_PrevAndNext(session, esfRenewal,
					organizationId, reportingYear, orderByComparator, true);

			array[1] = esfRenewal;

			array[2] = getByOrg_Year_PrevAndNext(session, esfRenewal,
					organizationId, reportingYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewal getByOrg_Year_PrevAndNext(Session session,
		ESFRenewal esfRenewal, long organizationId, int reportingYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWAL_WHERE);

		query.append(_FINDER_COLUMN_ORG_YEAR_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_ORG_YEAR_REPORTINGYEAR_2);

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
			query.append(ESFRenewalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(reportingYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewals where organizationId = &#63; and reportingYear = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrg_Year(long organizationId, int reportingYear)
		throws SystemException {
		for (ESFRenewal esfRenewal : findByOrg_Year(organizationId,
				reportingYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewal);
		}
	}

	/**
	 * Returns the number of e s f renewals where organizationId = &#63; and reportingYear = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param reportingYear the reporting year
	 * @return the number of matching e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrg_Year(long organizationId, int reportingYear)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORG_YEAR;

		Object[] finderArgs = new Object[] { organizationId, reportingYear };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRENEWAL_WHERE);

			query.append(_FINDER_COLUMN_ORG_YEAR_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORG_YEAR_REPORTINGYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(reportingYear);

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

	private static final String _FINDER_COLUMN_ORG_YEAR_ORGANIZATIONID_2 = "esfRenewal.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORG_YEAR_REPORTINGYEAR_2 = "esfRenewal.reportingYear = ?";

	public ESFRenewalPersistenceImpl() {
		setModelClass(ESFRenewal.class);
	}

	/**
	 * Caches the e s f renewal in the entity cache if it is enabled.
	 *
	 * @param esfRenewal the e s f renewal
	 */
	@Override
	public void cacheResult(ESFRenewal esfRenewal) {
		EntityCacheUtil.putResult(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalImpl.class, esfRenewal.getPrimaryKey(), esfRenewal);

		esfRenewal.resetOriginalValues();
	}

	/**
	 * Caches the e s f renewals in the entity cache if it is enabled.
	 *
	 * @param esfRenewals the e s f renewals
	 */
	@Override
	public void cacheResult(List<ESFRenewal> esfRenewals) {
		for (ESFRenewal esfRenewal : esfRenewals) {
			if (EntityCacheUtil.getResult(
						ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
						ESFRenewalImpl.class, esfRenewal.getPrimaryKey()) == null) {
				cacheResult(esfRenewal);
			}
			else {
				esfRenewal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f renewals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRenewalImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRenewalImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f renewal.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRenewal esfRenewal) {
		EntityCacheUtil.removeResult(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalImpl.class, esfRenewal.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFRenewal> esfRenewals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRenewal esfRenewal : esfRenewals) {
			EntityCacheUtil.removeResult(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
				ESFRenewalImpl.class, esfRenewal.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f renewal with the primary key. Does not add the e s f renewal to the database.
	 *
	 * @param esfRenewalId the primary key for the new e s f renewal
	 * @return the new e s f renewal
	 */
	@Override
	public ESFRenewal create(long esfRenewalId) {
		ESFRenewal esfRenewal = new ESFRenewalImpl();

		esfRenewal.setNew(true);
		esfRenewal.setPrimaryKey(esfRenewalId);

		return esfRenewal;
	}

	/**
	 * Removes the e s f renewal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfRenewalId the primary key of the e s f renewal
	 * @return the e s f renewal that was removed
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal remove(long esfRenewalId)
		throws NoSuchRenewalException, SystemException {
		return remove((Serializable)esfRenewalId);
	}

	/**
	 * Removes the e s f renewal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f renewal
	 * @return the e s f renewal that was removed
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal remove(Serializable primaryKey)
		throws NoSuchRenewalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRenewal esfRenewal = (ESFRenewal)session.get(ESFRenewalImpl.class,
					primaryKey);

			if (esfRenewal == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRenewalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRenewal);
		}
		catch (NoSuchRenewalException nsee) {
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
	protected ESFRenewal removeImpl(ESFRenewal esfRenewal)
		throws SystemException {
		esfRenewal = toUnwrappedModel(esfRenewal);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRenewal)) {
				esfRenewal = (ESFRenewal)session.get(ESFRenewalImpl.class,
						esfRenewal.getPrimaryKeyObj());
			}

			if (esfRenewal != null) {
				session.delete(esfRenewal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRenewal != null) {
			clearCache(esfRenewal);
		}

		return esfRenewal;
	}

	@Override
	public ESFRenewal updateImpl(it.ethica.esf.model.ESFRenewal esfRenewal)
		throws SystemException {
		esfRenewal = toUnwrappedModel(esfRenewal);

		boolean isNew = esfRenewal.isNew();

		ESFRenewalModelImpl esfRenewalModelImpl = (ESFRenewalModelImpl)esfRenewal;

		Session session = null;

		try {
			session = openSession();

			if (esfRenewal.isNew()) {
				session.save(esfRenewal);

				esfRenewal.setNew(false);
			}
			else {
				session.merge(esfRenewal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFRenewalModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfRenewalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFRENEWALUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFRENEWALUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFRENEWALUSER,
					args);

				args = new Object[] { esfRenewalModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFRENEWALUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFRENEWALUSER,
					args);
			}

			if ((esfRenewalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_ISTOTAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalModelImpl.getOriginalOrganizationId(),
						esfRenewalModelImpl.getOriginalIsTotal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGID_ISTOTAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_ISTOTAL,
					args);

				args = new Object[] {
						esfRenewalModelImpl.getOrganizationId(),
						esfRenewalModelImpl.getIsTotal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGID_ISTOTAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_ISTOTAL,
					args);
			}

			if ((esfRenewalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RENEWALFATHERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalModelImpl.getOriginalRenewalFatherId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RENEWALFATHERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RENEWALFATHERID,
					args);

				args = new Object[] { esfRenewalModelImpl.getRenewalFatherId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RENEWALFATHERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RENEWALFATHERID,
					args);
			}

			if ((esfRenewalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_REASON.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalModelImpl.getOriginalPaymentReason(),
						esfRenewalModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGID_REASON,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_REASON,
					args);

				args = new Object[] {
						esfRenewalModelImpl.getPaymentReason(),
						esfRenewalModelImpl.getOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGID_REASON,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGID_REASON,
					args);
			}

			if ((esfRenewalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REASON_ISTOTAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalModelImpl.getOriginalPaymentReason(),
						esfRenewalModelImpl.getOriginalIsTotal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REASON_ISTOTAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REASON_ISTOTAL,
					args);

				args = new Object[] {
						esfRenewalModelImpl.getPaymentReason(),
						esfRenewalModelImpl.getIsTotal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REASON_ISTOTAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REASON_ISTOTAL,
					args);
			}

			if ((esfRenewalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalModelImpl.getOriginalOrganizationId(),
						esfRenewalModelImpl.getOriginalReportingYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORG_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_YEAR,
					args);

				args = new Object[] {
						esfRenewalModelImpl.getOrganizationId(),
						esfRenewalModelImpl.getReportingYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORG_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_YEAR,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalImpl.class, esfRenewal.getPrimaryKey(), esfRenewal);

		return esfRenewal;
	}

	protected ESFRenewal toUnwrappedModel(ESFRenewal esfRenewal) {
		if (esfRenewal instanceof ESFRenewalImpl) {
			return esfRenewal;
		}

		ESFRenewalImpl esfRenewalImpl = new ESFRenewalImpl();

		esfRenewalImpl.setNew(esfRenewal.isNew());
		esfRenewalImpl.setPrimaryKey(esfRenewal.getPrimaryKey());

		esfRenewalImpl.setEsfRenewalId(esfRenewal.getEsfRenewalId());
		esfRenewalImpl.setCompanyId(esfRenewal.getCompanyId());
		esfRenewalImpl.setUserId(esfRenewal.getUserId());
		esfRenewalImpl.setModifiedDate(esfRenewal.getModifiedDate());
		esfRenewalImpl.setQuantity(esfRenewal.getQuantity());
		esfRenewalImpl.setPaymentReason(esfRenewal.getPaymentReason());
		esfRenewalImpl.setPaymentType(esfRenewal.getPaymentType());
		esfRenewalImpl.setPaymentDate(esfRenewal.getPaymentDate());
		esfRenewalImpl.setPaymentReceived(esfRenewal.isPaymentReceived());
		esfRenewalImpl.setCreateDate(esfRenewal.getCreateDate());
		esfRenewalImpl.setGroupId(esfRenewal.getGroupId());
		esfRenewalImpl.setInfo(esfRenewal.getInfo());
		esfRenewalImpl.setMadeBy(esfRenewal.getMadeBy());
		esfRenewalImpl.setAmount(esfRenewal.getAmount());
		esfRenewalImpl.setOrganizationId(esfRenewal.getOrganizationId());
		esfRenewalImpl.setReportingYear(esfRenewal.getReportingYear());
		esfRenewalImpl.setAmountTotal(esfRenewal.getAmountTotal());
		esfRenewalImpl.setIsTotal(esfRenewal.isIsTotal());
		esfRenewalImpl.setRenewalFatherId(esfRenewal.getRenewalFatherId());
		esfRenewalImpl.setAffiliates(esfRenewal.isAffiliates());

		return esfRenewalImpl;
	}

	/**
	 * Returns the e s f renewal with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f renewal
	 * @return the e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRenewalException, SystemException {
		ESFRenewal esfRenewal = fetchByPrimaryKey(primaryKey);

		if (esfRenewal == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRenewalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRenewal;
	}

	/**
	 * Returns the e s f renewal with the primary key or throws a {@link it.ethica.esf.NoSuchRenewalException} if it could not be found.
	 *
	 * @param esfRenewalId the primary key of the e s f renewal
	 * @return the e s f renewal
	 * @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal findByPrimaryKey(long esfRenewalId)
		throws NoSuchRenewalException, SystemException {
		return findByPrimaryKey((Serializable)esfRenewalId);
	}

	/**
	 * Returns the e s f renewal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f renewal
	 * @return the e s f renewal, or <code>null</code> if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRenewal esfRenewal = (ESFRenewal)EntityCacheUtil.getResult(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
				ESFRenewalImpl.class, primaryKey);

		if (esfRenewal == _nullESFRenewal) {
			return null;
		}

		if (esfRenewal == null) {
			Session session = null;

			try {
				session = openSession();

				esfRenewal = (ESFRenewal)session.get(ESFRenewalImpl.class,
						primaryKey);

				if (esfRenewal != null) {
					cacheResult(esfRenewal);
				}
				else {
					EntityCacheUtil.putResult(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
						ESFRenewalImpl.class, primaryKey, _nullESFRenewal);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRenewalModelImpl.ENTITY_CACHE_ENABLED,
					ESFRenewalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRenewal;
	}

	/**
	 * Returns the e s f renewal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfRenewalId the primary key of the e s f renewal
	 * @return the e s f renewal, or <code>null</code> if a e s f renewal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewal fetchByPrimaryKey(long esfRenewalId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfRenewalId);
	}

	/**
	 * Returns all the e s f renewals.
	 *
	 * @return the e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @return the range of e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f renewals
	 * @param end the upper bound of the range of e s f renewals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f renewals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewal> findAll(int start, int end,
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

		List<ESFRenewal> list = (List<ESFRenewal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRENEWAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRENEWAL;

				if (pagination) {
					sql = sql.concat(ESFRenewalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewal>(list);
				}
				else {
					list = (List<ESFRenewal>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f renewals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRenewal esfRenewal : findAll()) {
			remove(esfRenewal);
		}
	}

	/**
	 * Returns the number of e s f renewals.
	 *
	 * @return the number of e s f renewals
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

				Query q = session.createQuery(_SQL_COUNT_ESFRENEWAL);

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
	 * Initializes the e s f renewal persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRenewal")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRenewal>> listenersList = new ArrayList<ModelListener<ESFRenewal>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRenewal>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRenewalImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRENEWAL = "SELECT esfRenewal FROM ESFRenewal esfRenewal";
	private static final String _SQL_SELECT_ESFRENEWAL_WHERE = "SELECT esfRenewal FROM ESFRenewal esfRenewal WHERE ";
	private static final String _SQL_COUNT_ESFRENEWAL = "SELECT COUNT(esfRenewal) FROM ESFRenewal esfRenewal";
	private static final String _SQL_COUNT_ESFRENEWAL_WHERE = "SELECT COUNT(esfRenewal) FROM ESFRenewal esfRenewal WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRenewal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRenewal exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFRenewal exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRenewalPersistenceImpl.class);
	private static ESFRenewal _nullESFRenewal = new ESFRenewalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRenewal> toCacheModel() {
				return _nullESFRenewalCacheModel;
			}
		};

	private static CacheModel<ESFRenewal> _nullESFRenewalCacheModel = new CacheModel<ESFRenewal>() {
			@Override
			public ESFRenewal toEntityModel() {
				return _nullESFRenewal;
			}
		};
}