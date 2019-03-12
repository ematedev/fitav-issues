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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import it.ethica.esf.NoSuchUserESFUserRoleException;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.impl.ESFUserESFUserRoleImpl;
import it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the e s f user e s f user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserESFUserRolePersistence
 * @see ESFUserESFUserRoleUtil
 * @generated
 */
public class ESFUserESFUserRolePersistenceImpl extends BasePersistenceImpl<ESFUserESFUserRole>
	implements ESFUserESFUserRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFUserESFUserRoleUtil} to access the e s f user e s f user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFUserESFUserRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERROLEID =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFUserRoleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLEID =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFUserRoleId",
			new String[] { Long.class.getName() },
			ESFUserESFUserRoleModelImpl.ESFUSERROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERROLEID = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFUserRoleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user e s f user roles where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @return the matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserRoleId(long esfUserRoleId)
		throws SystemException {
		return findByESFUserRoleId(esfUserRoleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles where esfUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserRoleId(long esfUserRoleId,
		int start, int end) throws SystemException {
		return findByESFUserRoleId(esfUserRoleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f user roles where esfUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserRoleId(long esfUserRoleId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLEID;
			finderArgs = new Object[] { esfUserRoleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERROLEID;
			finderArgs = new Object[] {
					esfUserRoleId,
					
					start, end, orderByComparator
				};
		}

		List<ESFUserESFUserRole> list = (List<ESFUserESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFUserRole esfUserESFUserRole : list) {
				if ((esfUserRoleId != esfUserESFUserRole.getEsfUserRoleId())) {
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

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERROLEID_ESFUSERROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

				if (!pagination) {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFUserRole>(list);
				}
				else {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFUserRoleId_First(long esfUserRoleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFUserRoleId_First(esfUserRoleId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserRoleId=");
		msg.append(esfUserRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFUserRoleId_First(long esfUserRoleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserESFUserRole> list = findByESFUserRoleId(esfUserRoleId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFUserRoleId_Last(long esfUserRoleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFUserRoleId_Last(esfUserRoleId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserRoleId=");
		msg.append(esfUserRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFUserRoleId_Last(long esfUserRoleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFUserRoleId(esfUserRoleId);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFUserRole> list = findByESFUserRoleId(esfUserRoleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole[] findByESFUserRoleId_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserRoleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByPrimaryKey(esfUserESFUserRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFUserRole[] array = new ESFUserESFUserRoleImpl[3];

			array[0] = getByESFUserRoleId_PrevAndNext(session,
					esfUserESFUserRole, esfUserRoleId, orderByComparator, true);

			array[1] = esfUserESFUserRole;

			array[2] = getByESFUserRoleId_PrevAndNext(session,
					esfUserESFUserRole, esfUserRoleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFUserESFUserRole getByESFUserRoleId_PrevAndNext(
		Session session, ESFUserESFUserRole esfUserESFUserRole,
		long esfUserRoleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERROLEID_ESFUSERROLEID_2);

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
			query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserRoleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f user roles where esfUserRoleId = &#63; from the database.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFUserRoleId(long esfUserRoleId)
		throws SystemException {
		for (ESFUserESFUserRole esfUserESFUserRole : findByESFUserRoleId(
				esfUserRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserESFUserRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFUserRoleId(long esfUserRoleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERROLEID;

		Object[] finderArgs = new Object[] { esfUserRoleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERROLEID_ESFUSERROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

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

	private static final String _FINDER_COLUMN_ESFUSERROLEID_ESFUSERROLEID_2 = "esfUserESFUserRole.id.esfUserRoleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFUserId",
			new String[] { Long.class.getName() },
			ESFUserESFUserRoleModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERID = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user e s f user roles where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserId(long esfUserId)
		throws SystemException {
		return findByESFUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserId(long esfUserId, int start,
		int end) throws SystemException {
		return findByESFUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f user roles where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserId(long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFUserESFUserRole> list = (List<ESFUserESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFUserRole esfUserESFUserRole : list) {
				if ((esfUserId != esfUserESFUserRole.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFUserRole>(list);
				}
				else {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFUserId_First(esfUserId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserESFUserRole> list = findByESFUserId(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFUserId_Last(esfUserId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFUserRole> list = findByESFUserId(esfUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole[] findByESFUserId_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByPrimaryKey(esfUserESFUserRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFUserRole[] array = new ESFUserESFUserRoleImpl[3];

			array[0] = getByESFUserId_PrevAndNext(session, esfUserESFUserRole,
					esfUserId, orderByComparator, true);

			array[1] = esfUserESFUserRole;

			array[2] = getByESFUserId_PrevAndNext(session, esfUserESFUserRole,
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

	protected ESFUserESFUserRole getByESFUserId_PrevAndNext(Session session,
		ESFUserESFUserRole esfUserESFUserRole, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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
			query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f user roles where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFUserId(long esfUserId) throws SystemException {
		for (ESFUserESFUserRole esfUserESFUserRole : findByESFUserId(
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserESFUserRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFUserId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_ESFUSERID_ESFUSERID_2 = "esfUserESFUserRole.id.esfUserId = ? AND esfUserESFUserRole.endDate is null";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERROLE =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFUserRole",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLE =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFUserRole",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			ESFUserESFUserRoleModelImpl.ESFUSERROLEID_COLUMN_BITMASK |
			ESFUserESFUserRoleModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFUserESFUserRoleModelImpl.ENDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERROLE = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFUserRole",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @return the matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserRole(long esfUserRoleId,
		long esfUserId, Date endDate) throws SystemException {
		return findByESFUserRole(esfUserRoleId, esfUserId, endDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserRole(long esfUserRoleId,
		long esfUserId, Date endDate, int start, int end)
		throws SystemException {
		return findByESFUserRole(esfUserRoleId, esfUserId, endDate, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserRole(long esfUserRoleId,
		long esfUserId, Date endDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLE;
			finderArgs = new Object[] { esfUserRoleId, esfUserId, endDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERROLE;
			finderArgs = new Object[] {
					esfUserRoleId, esfUserId, endDate,
					
					start, end, orderByComparator
				};
		}

		List<ESFUserESFUserRole> list = (List<ESFUserESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFUserRole esfUserESFUserRole : list) {
				if ((esfUserRoleId != esfUserESFUserRole.getEsfUserRoleId()) ||
						(esfUserId != esfUserESFUserRole.getEsfUserId()) ||
						!Validator.equals(endDate,
							esfUserESFUserRole.getEndDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERROLE_ESFUSERROLEID_2);

			query.append(_FINDER_COLUMN_ESFUSERROLE_ESFUSERID_2);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_ESFUSERROLE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_ESFUSERROLE_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

				qPos.add(esfUserId);

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				if (!pagination) {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFUserRole>(list);
				}
				else {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFUserRole_First(long esfUserRoleId,
		long esfUserId, Date endDate, OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFUserRole_First(esfUserRoleId,
				esfUserId, endDate, orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserRoleId=");
		msg.append(esfUserRoleId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFUserRole_First(long esfUserRoleId,
		long esfUserId, Date endDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFUserESFUserRole> list = findByESFUserRole(esfUserRoleId,
				esfUserId, endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFUserRole_Last(long esfUserRoleId,
		long esfUserId, Date endDate, OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFUserRole_Last(esfUserRoleId,
				esfUserId, endDate, orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserRoleId=");
		msg.append(esfUserRoleId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFUserRole_Last(long esfUserRoleId,
		long esfUserId, Date endDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFUserRole(esfUserRoleId, esfUserId, endDate);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFUserRole> list = findByESFUserRole(esfUserRoleId,
				esfUserId, endDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole[] findByESFUserRole_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserRoleId,
		long esfUserId, Date endDate, OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByPrimaryKey(esfUserESFUserRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFUserRole[] array = new ESFUserESFUserRoleImpl[3];

			array[0] = getByESFUserRole_PrevAndNext(session,
					esfUserESFUserRole, esfUserRoleId, esfUserId, endDate,
					orderByComparator, true);

			array[1] = esfUserESFUserRole;

			array[2] = getByESFUserRole_PrevAndNext(session,
					esfUserESFUserRole, esfUserRoleId, esfUserId, endDate,
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

	protected ESFUserESFUserRole getByESFUserRole_PrevAndNext(Session session,
		ESFUserESFUserRole esfUserESFUserRole, long esfUserRoleId,
		long esfUserId, Date endDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERROLE_ESFUSERROLEID_2);

		query.append(_FINDER_COLUMN_ESFUSERROLE_ESFUSERID_2);

		boolean bindEndDate = false;

		if (endDate == null) {
			query.append(_FINDER_COLUMN_ESFUSERROLE_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			query.append(_FINDER_COLUMN_ESFUSERROLE_ENDDATE_2);
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
			query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserRoleId);

		qPos.add(esfUserId);

		if (bindEndDate) {
			qPos.add(CalendarUtil.getTimestamp(endDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63; from the database.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFUserRole(long esfUserRoleId, long esfUserId,
		Date endDate) throws SystemException {
		for (ESFUserESFUserRole esfUserESFUserRole : findByESFUserRole(
				esfUserRoleId, esfUserId, endDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUserESFUserRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param endDate the end date
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFUserRole(long esfUserRoleId, long esfUserId,
		Date endDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERROLE;

		Object[] finderArgs = new Object[] { esfUserRoleId, esfUserId, endDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERROLE_ESFUSERROLEID_2);

			query.append(_FINDER_COLUMN_ESFUSERROLE_ESFUSERID_2);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_ESFUSERROLE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_ESFUSERROLE_ENDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

				qPos.add(esfUserId);

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
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

	private static final String _FINDER_COLUMN_ESFUSERROLE_ESFUSERROLEID_2 = "esfUserESFUserRole.id.esfUserRoleId = ? AND ";
	private static final String _FINDER_COLUMN_ESFUSERROLE_ESFUSERID_2 = "esfUserESFUserRole.id.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_ESFUSERROLE_ENDDATE_1 = "esfUserESFUserRole.endDate IS NULL";
	private static final String _FINDER_COLUMN_ESFUSERROLE_ENDDATE_2 = "esfUserESFUserRole.endDate = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ESFU_R = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByESFU_R",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFUserESFUserRoleModelImpl.ESFUSERROLEID_COLUMN_BITMASK |
			ESFUserESFUserRoleModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFU_R = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFU_R",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; or throws a {@link it.ethica.esf.NoSuchUserESFUserRoleException} if it could not be found.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @return the matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFU_R(long esfUserRoleId, long esfUserId)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFU_R(esfUserRoleId,
				esfUserId);

		if (esfUserESFUserRole == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfUserRoleId=");
			msg.append(esfUserRoleId);

			msg.append(", esfUserId=");
			msg.append(esfUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserESFUserRoleException(msg.toString());
		}

		return esfUserESFUserRole;
	}

	/**
	 * Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @return the matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFU_R(long esfUserRoleId, long esfUserId)
		throws SystemException {
		return fetchByESFU_R(esfUserRoleId, esfUserId, true);
	}

	/**
	 * Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFU_R(long esfUserRoleId, long esfUserId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { esfUserRoleId, esfUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ESFU_R,
					finderArgs, this);
		}

		if (result instanceof ESFUserESFUserRole) {
			ESFUserESFUserRole esfUserESFUserRole = (ESFUserESFUserRole)result;

			if ((esfUserRoleId != esfUserESFUserRole.getEsfUserRoleId()) ||
					(esfUserId != esfUserESFUserRole.getEsfUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFU_R_ESFUSERROLEID_2);

			query.append(_FINDER_COLUMN_ESFU_R_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

				qPos.add(esfUserId);

				List<ESFUserESFUserRole> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserESFUserRolePersistenceImpl.fetchByESFU_R(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUserESFUserRole esfUserESFUserRole = list.get(0);

					result = esfUserESFUserRole;

					cacheResult(esfUserESFUserRole);

					if ((esfUserESFUserRole.getEsfUserRoleId() != esfUserRoleId) ||
							(esfUserESFUserRole.getEsfUserId() != esfUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R,
							finderArgs, esfUserESFUserRole);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFU_R,
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
			return (ESFUserESFUserRole)result;
		}
	}

	/**
	 * Removes the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; from the database.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @return the e s f user e s f user role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole removeByESFU_R(long esfUserRoleId, long esfUserId)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByESFU_R(esfUserRoleId,
				esfUserId);

		return remove(esfUserESFUserRole);
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFU_R(long esfUserRoleId, long esfUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFU_R;

		Object[] finderArgs = new Object[] { esfUserRoleId, esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFU_R_ESFUSERROLEID_2);

			query.append(_FINDER_COLUMN_ESFU_R_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

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

	private static final String _FINDER_COLUMN_ESFU_R_ESFUSERROLEID_2 = "esfUserESFUserRole.id.esfUserRoleId = ? AND ";
	private static final String _FINDER_COLUMN_ESFU_R_ESFUSERID_2 = "esfUserESFUserRole.id.esfUserId = ? AND esfUserESFUserRole.endDate is null";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFU_ED = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFU_ED",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFU_ED =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFU_ED",
			new String[] { Long.class.getName() },
			ESFUserESFUserRoleModelImpl.ESFUSERROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFU_ED = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFU_ED",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user e s f user roles where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @return the matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFU_ED(long esfUserRoleId)
		throws SystemException {
		return findByESFU_ED(esfUserRoleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles where esfUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFU_ED(long esfUserRoleId,
		int start, int end) throws SystemException {
		return findByESFU_ED(esfUserRoleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f user roles where esfUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFU_ED(long esfUserRoleId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFU_ED;
			finderArgs = new Object[] { esfUserRoleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFU_ED;
			finderArgs = new Object[] {
					esfUserRoleId,
					
					start, end, orderByComparator
				};
		}

		List<ESFUserESFUserRole> list = (List<ESFUserESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFUserRole esfUserESFUserRole : list) {
				if ((esfUserRoleId != esfUserESFUserRole.getEsfUserRoleId())) {
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

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFU_ED_ESFUSERROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

				if (!pagination) {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFUserRole>(list);
				}
				else {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFU_ED_First(long esfUserRoleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFU_ED_First(esfUserRoleId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserRoleId=");
		msg.append(esfUserRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFU_ED_First(long esfUserRoleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserESFUserRole> list = findByESFU_ED(esfUserRoleId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFU_ED_Last(long esfUserRoleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFU_ED_Last(esfUserRoleId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserRoleId=");
		msg.append(esfUserRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFU_ED_Last(long esfUserRoleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFU_ED(esfUserRoleId);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFUserRole> list = findByESFU_ED(esfUserRoleId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	 *
	 * @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole[] findByESFU_ED_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserRoleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByPrimaryKey(esfUserESFUserRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFUserRole[] array = new ESFUserESFUserRoleImpl[3];

			array[0] = getByESFU_ED_PrevAndNext(session, esfUserESFUserRole,
					esfUserRoleId, orderByComparator, true);

			array[1] = esfUserESFUserRole;

			array[2] = getByESFU_ED_PrevAndNext(session, esfUserESFUserRole,
					esfUserRoleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFUserESFUserRole getByESFU_ED_PrevAndNext(Session session,
		ESFUserESFUserRole esfUserESFUserRole, long esfUserRoleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_ESFU_ED_ESFUSERROLEID_2);

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
			query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserRoleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f user roles where esfUserRoleId = &#63; from the database.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFU_ED(long esfUserRoleId) throws SystemException {
		for (ESFUserESFUserRole esfUserESFUserRole : findByESFU_ED(
				esfUserRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserESFUserRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfUserRoleId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFU_ED(long esfUserRoleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFU_ED;

		Object[] finderArgs = new Object[] { esfUserRoleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFU_ED_ESFUSERROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

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

	private static final String _FINDER_COLUMN_ESFU_ED_ESFUSERROLEID_2 = "esfUserESFUserRole.id.esfUserRoleId = ? AND esfUserESFUserRole.endDate is null";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFO_R = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFO_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFO_R =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFO_R",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFUserESFUserRoleModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK |
			ESFUserESFUserRoleModelImpl.ESFUSERROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFO_R = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFO_R",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @return the matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFO_R(long esfOrganizationId,
		long esfUserRoleId) throws SystemException {
		return findByESFO_R(esfOrganizationId, esfUserRoleId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFO_R(long esfOrganizationId,
		long esfUserRoleId, int start, int end) throws SystemException {
		return findByESFO_R(esfOrganizationId, esfUserRoleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFO_R(long esfOrganizationId,
		long esfUserRoleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFO_R;
			finderArgs = new Object[] { esfOrganizationId, esfUserRoleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFO_R;
			finderArgs = new Object[] {
					esfOrganizationId, esfUserRoleId,
					
					start, end, orderByComparator
				};
		}

		List<ESFUserESFUserRole> list = (List<ESFUserESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFUserRole esfUserESFUserRole : list) {
				if ((esfOrganizationId != esfUserESFUserRole.getEsfOrganizationId()) ||
						(esfUserRoleId != esfUserESFUserRole.getEsfUserRoleId())) {
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

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFO_R_ESFORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ESFO_R_ESFUSERROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				qPos.add(esfUserRoleId);

				if (!pagination) {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFUserRole>(list);
				}
				else {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFO_R_First(long esfOrganizationId,
		long esfUserRoleId, OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFO_R_First(esfOrganizationId,
				esfUserRoleId, orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(", esfUserRoleId=");
		msg.append(esfUserRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFO_R_First(long esfOrganizationId,
		long esfUserRoleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFUserESFUserRole> list = findByESFO_R(esfOrganizationId,
				esfUserRoleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFO_R_Last(long esfOrganizationId,
		long esfUserRoleId, OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFO_R_Last(esfOrganizationId,
				esfUserRoleId, orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(", esfUserRoleId=");
		msg.append(esfUserRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFO_R_Last(long esfOrganizationId,
		long esfUserRoleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFO_R(esfOrganizationId, esfUserRoleId);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFUserRole> list = findByESFO_R(esfOrganizationId,
				esfUserRoleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole[] findByESFO_R_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfOrganizationId,
		long esfUserRoleId, OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByPrimaryKey(esfUserESFUserRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFUserRole[] array = new ESFUserESFUserRoleImpl[3];

			array[0] = getByESFO_R_PrevAndNext(session, esfUserESFUserRole,
					esfOrganizationId, esfUserRoleId, orderByComparator, true);

			array[1] = esfUserESFUserRole;

			array[2] = getByESFO_R_PrevAndNext(session, esfUserESFUserRole,
					esfOrganizationId, esfUserRoleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFUserESFUserRole getByESFO_R_PrevAndNext(Session session,
		ESFUserESFUserRole esfUserESFUserRole, long esfOrganizationId,
		long esfUserRoleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_ESFO_R_ESFORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_ESFO_R_ESFUSERROLEID_2);

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
			query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrganizationId);

		qPos.add(esfUserRoleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFO_R(long esfOrganizationId, long esfUserRoleId)
		throws SystemException {
		for (ESFUserESFUserRole esfUserESFUserRole : findByESFO_R(
				esfOrganizationId, esfUserRoleId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUserESFUserRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param esfUserRoleId the esf user role ID
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFO_R(long esfOrganizationId, long esfUserRoleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFO_R;

		Object[] finderArgs = new Object[] { esfOrganizationId, esfUserRoleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFO_R_ESFORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ESFO_R_ESFUSERROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				qPos.add(esfUserRoleId);

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

	private static final String _FINDER_COLUMN_ESFO_R_ESFORGANIZATIONID_2 = "esfUserESFUserRole.id.esfOrganizationId = ? AND ";
	private static final String _FINDER_COLUMN_ESFO_R_ESFUSERROLEID_2 = "esfUserESFUserRole.id.esfUserRoleId = ? AND esfUserESFUserRole.endDate is null";
	public static final FinderPath FINDER_PATH_FETCH_BY_ESFU_R_O = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByESFU_R_O",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFUserESFUserRoleModelImpl.ESFUSERROLEID_COLUMN_BITMASK |
			ESFUserESFUserRoleModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFUserESFUserRoleModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFU_R_O = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFU_R_O",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63; or throws a {@link it.ethica.esf.NoSuchUserESFUserRoleException} if it could not be found.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFU_R_O(long esfUserRoleId,
		long esfUserId, long esfOrganizationId)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFU_R_O(esfUserRoleId,
				esfUserId, esfOrganizationId);

		if (esfUserESFUserRole == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfUserRoleId=");
			msg.append(esfUserRoleId);

			msg.append(", esfUserId=");
			msg.append(esfUserId);

			msg.append(", esfOrganizationId=");
			msg.append(esfOrganizationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserESFUserRoleException(msg.toString());
		}

		return esfUserESFUserRole;
	}

	/**
	 * Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFU_R_O(long esfUserRoleId,
		long esfUserId, long esfOrganizationId) throws SystemException {
		return fetchByESFU_R_O(esfUserRoleId, esfUserId, esfOrganizationId, true);
	}

	/**
	 * Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param esfOrganizationId the esf organization ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFU_R_O(long esfUserRoleId,
		long esfUserId, long esfOrganizationId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				esfUserRoleId, esfUserId, esfOrganizationId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ESFU_R_O,
					finderArgs, this);
		}

		if (result instanceof ESFUserESFUserRole) {
			ESFUserESFUserRole esfUserESFUserRole = (ESFUserESFUserRole)result;

			if ((esfUserRoleId != esfUserESFUserRole.getEsfUserRoleId()) ||
					(esfUserId != esfUserESFUserRole.getEsfUserId()) ||
					(esfOrganizationId != esfUserESFUserRole.getEsfOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFU_R_O_ESFUSERROLEID_2);

			query.append(_FINDER_COLUMN_ESFU_R_O_ESFUSERID_2);

			query.append(_FINDER_COLUMN_ESFU_R_O_ESFORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

				qPos.add(esfUserId);

				qPos.add(esfOrganizationId);

				List<ESFUserESFUserRole> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R_O,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserESFUserRolePersistenceImpl.fetchByESFU_R_O(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUserESFUserRole esfUserESFUserRole = list.get(0);

					result = esfUserESFUserRole;

					cacheResult(esfUserESFUserRole);

					if ((esfUserESFUserRole.getEsfUserRoleId() != esfUserRoleId) ||
							(esfUserESFUserRole.getEsfUserId() != esfUserId) ||
							(esfUserESFUserRole.getEsfOrganizationId() != esfOrganizationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R_O,
							finderArgs, esfUserESFUserRole);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFU_R_O,
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
			return (ESFUserESFUserRole)result;
		}
	}

	/**
	 * Removes the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63; from the database.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param esfOrganizationId the esf organization ID
	 * @return the e s f user e s f user role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole removeByESFU_R_O(long esfUserRoleId,
		long esfUserId, long esfOrganizationId)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByESFU_R_O(esfUserRoleId,
				esfUserId, esfOrganizationId);

		return remove(esfUserESFUserRole);
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63;.
	 *
	 * @param esfUserRoleId the esf user role ID
	 * @param esfUserId the esf user ID
	 * @param esfOrganizationId the esf organization ID
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFU_R_O(long esfUserRoleId, long esfUserId,
		long esfOrganizationId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFU_R_O;

		Object[] finderArgs = new Object[] {
				esfUserRoleId, esfUserId, esfOrganizationId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFU_R_O_ESFUSERROLEID_2);

			query.append(_FINDER_COLUMN_ESFU_R_O_ESFUSERID_2);

			query.append(_FINDER_COLUMN_ESFU_R_O_ESFORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserRoleId);

				qPos.add(esfUserId);

				qPos.add(esfOrganizationId);

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

	private static final String _FINDER_COLUMN_ESFU_R_O_ESFUSERROLEID_2 = "esfUserESFUserRole.id.esfUserRoleId = ? AND ";
	private static final String _FINDER_COLUMN_ESFU_R_O_ESFUSERID_2 = "esfUserESFUserRole.id.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_ESFU_R_O_ESFORGANIZATIONID_2 = "esfUserESFUserRole.id.esfOrganizationId = ? AND esfUserESFUserRole.endDate is null";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFOrganizationId", new String[] { Long.class.getName() },
			ESFUserESFUserRoleModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFORGANIZATIONID = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFOrganizationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user e s f user roles where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFOrganizationId(
		long esfOrganizationId) throws SystemException {
		return findByESFOrganizationId(esfOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFOrganizationId(
		long esfOrganizationId, int start, int end) throws SystemException {
		return findByESFOrganizationId(esfOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f user roles where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFOrganizationId(
		long esfOrganizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID;
			finderArgs = new Object[] { esfOrganizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORGANIZATIONID;
			finderArgs = new Object[] {
					esfOrganizationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFUserESFUserRole> list = (List<ESFUserESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFUserRole esfUserESFUserRole : list) {
				if ((esfOrganizationId != esfUserESFUserRole.getEsfOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				if (!pagination) {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFUserRole>(list);
				}
				else {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFOrganizationId_First(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFOrganizationId_First(esfOrganizationId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFOrganizationId_First(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFUserESFUserRole> list = findByESFOrganizationId(esfOrganizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFOrganizationId_Last(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFOrganizationId_Last(esfOrganizationId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFOrganizationId_Last(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFOrganizationId(esfOrganizationId);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFUserRole> list = findByESFOrganizationId(esfOrganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole[] findByESFOrganizationId_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByPrimaryKey(esfUserESFUserRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFUserRole[] array = new ESFUserESFUserRoleImpl[3];

			array[0] = getByESFOrganizationId_PrevAndNext(session,
					esfUserESFUserRole, esfOrganizationId, orderByComparator,
					true);

			array[1] = esfUserESFUserRole;

			array[2] = getByESFOrganizationId_PrevAndNext(session,
					esfUserESFUserRole, esfOrganizationId, orderByComparator,
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

	protected ESFUserESFUserRole getByESFOrganizationId_PrevAndNext(
		Session session, ESFUserESFUserRole esfUserESFUserRole,
		long esfOrganizationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

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
			query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f user roles where esfOrganizationId = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFOrganizationId(long esfOrganizationId)
		throws SystemException {
		for (ESFUserESFUserRole esfUserESFUserRole : findByESFOrganizationId(
				esfOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserESFUserRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFOrganizationId(long esfOrganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFORGANIZATIONID;

		Object[] finderArgs = new Object[] { esfOrganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

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

	private static final String _FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2 =
		"esfUserESFUserRole.id.esfOrganizationId = ? AND esfUserESFUserRole.endDate is null";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID_ED =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFUserId_ED",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID_ED =
		new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFUserId_ED",
			new String[] { Long.class.getName() },
			ESFUserESFUserRoleModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERID_ED = new FinderPath(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFUserId_ED",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user e s f user roles where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserId_ED(long esfUserId)
		throws SystemException {
		return findByESFUserId_ED(esfUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserId_ED(long esfUserId,
		int start, int end) throws SystemException {
		return findByESFUserId_ED(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f user roles where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findByESFUserId_ED(long esfUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID_ED;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID_ED;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFUserESFUserRole> list = (List<ESFUserESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFUserRole esfUserESFUserRole : list) {
				if ((esfUserId != esfUserESFUserRole.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ED_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFUserRole>(list);
				}
				else {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFUserId_ED_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFUserId_ED_First(esfUserId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFUserId_ED_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserESFUserRole> list = findByESFUserId_ED(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByESFUserId_ED_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByESFUserId_ED_Last(esfUserId,
				orderByComparator);

		if (esfUserESFUserRole != null) {
			return esfUserESFUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByESFUserId_ED_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFUserId_ED(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFUserRole> list = findByESFUserId_ED(esfUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole[] findByESFUserId_ED_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = findByPrimaryKey(esfUserESFUserRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFUserRole[] array = new ESFUserESFUserRoleImpl[3];

			array[0] = getByESFUserId_ED_PrevAndNext(session,
					esfUserESFUserRole, esfUserId, orderByComparator, true);

			array[1] = esfUserESFUserRole;

			array[2] = getByESFUserId_ED_PrevAndNext(session,
					esfUserESFUserRole, esfUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFUserESFUserRole getByESFUserId_ED_PrevAndNext(
		Session session, ESFUserESFUserRole esfUserESFUserRole, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERID_ED_ESFUSERID_2);

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
			query.append(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f user roles where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFUserId_ED(long esfUserId) throws SystemException {
		for (ESFUserESFUserRole esfUserESFUserRole : findByESFUserId_ED(
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserESFUserRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f user roles where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFUserId_ED(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERID_ED;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ED_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_ESFUSERID_ED_ESFUSERID_2 = "esfUserESFUserRole.id.esfUserId = ? AND esfUserESFUserRole.endDate is null";

	public ESFUserESFUserRolePersistenceImpl() {
		setModelClass(ESFUserESFUserRole.class);
	}

	/**
	 * Caches the e s f user e s f user role in the entity cache if it is enabled.
	 *
	 * @param esfUserESFUserRole the e s f user e s f user role
	 */
	@Override
	public void cacheResult(ESFUserESFUserRole esfUserESFUserRole) {
		EntityCacheUtil.putResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class, esfUserESFUserRole.getPrimaryKey(),
			esfUserESFUserRole);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R,
			new Object[] {
				esfUserESFUserRole.getEsfUserRoleId(),
				esfUserESFUserRole.getEsfUserId()
			}, esfUserESFUserRole);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R_O,
			new Object[] {
				esfUserESFUserRole.getEsfUserRoleId(),
				esfUserESFUserRole.getEsfUserId(),
				esfUserESFUserRole.getEsfOrganizationId()
			}, esfUserESFUserRole);

		esfUserESFUserRole.resetOriginalValues();
	}

	/**
	 * Caches the e s f user e s f user roles in the entity cache if it is enabled.
	 *
	 * @param esfUserESFUserRoles the e s f user e s f user roles
	 */
	@Override
	public void cacheResult(List<ESFUserESFUserRole> esfUserESFUserRoles) {
		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
			if (EntityCacheUtil.getResult(
						ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserESFUserRoleImpl.class,
						esfUserESFUserRole.getPrimaryKey()) == null) {
				cacheResult(esfUserESFUserRole);
			}
			else {
				esfUserESFUserRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f user e s f user roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFUserESFUserRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFUserESFUserRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f user e s f user role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFUserESFUserRole esfUserESFUserRole) {
		EntityCacheUtil.removeResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class, esfUserESFUserRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfUserESFUserRole);
	}

	@Override
	public void clearCache(List<ESFUserESFUserRole> esfUserESFUserRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
			EntityCacheUtil.removeResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserESFUserRoleImpl.class, esfUserESFUserRole.getPrimaryKey());

			clearUniqueFindersCache(esfUserESFUserRole);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFUserESFUserRole esfUserESFUserRole) {
		if (esfUserESFUserRole.isNew()) {
			Object[] args = new Object[] {
					esfUserESFUserRole.getEsfUserRoleId(),
					esfUserESFUserRole.getEsfUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFU_R, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R, args,
				esfUserESFUserRole);

			args = new Object[] {
					esfUserESFUserRole.getEsfUserRoleId(),
					esfUserESFUserRole.getEsfUserId(),
					esfUserESFUserRole.getEsfOrganizationId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFU_R_O, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R_O, args,
				esfUserESFUserRole);
		}
		else {
			ESFUserESFUserRoleModelImpl esfUserESFUserRoleModelImpl = (ESFUserESFUserRoleModelImpl)esfUserESFUserRole;

			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ESFU_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRole.getEsfUserRoleId(),
						esfUserESFUserRole.getEsfUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFU_R, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R, args,
					esfUserESFUserRole);
			}

			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ESFU_R_O.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRole.getEsfUserRoleId(),
						esfUserESFUserRole.getEsfUserId(),
						esfUserESFUserRole.getEsfOrganizationId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFU_R_O, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFU_R_O, args,
					esfUserESFUserRole);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFUserESFUserRole esfUserESFUserRole) {
		ESFUserESFUserRoleModelImpl esfUserESFUserRoleModelImpl = (ESFUserESFUserRoleModelImpl)esfUserESFUserRole;

		Object[] args = new Object[] {
				esfUserESFUserRole.getEsfUserRoleId(),
				esfUserESFUserRole.getEsfUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFU_R, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFU_R, args);

		if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ESFU_R.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfUserESFUserRoleModelImpl.getOriginalEsfUserRoleId(),
					esfUserESFUserRoleModelImpl.getOriginalEsfUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFU_R, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFU_R, args);
		}

		args = new Object[] {
				esfUserESFUserRole.getEsfUserRoleId(),
				esfUserESFUserRole.getEsfUserId(),
				esfUserESFUserRole.getEsfOrganizationId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFU_R_O, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFU_R_O, args);

		if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ESFU_R_O.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfUserESFUserRoleModelImpl.getOriginalEsfUserRoleId(),
					esfUserESFUserRoleModelImpl.getOriginalEsfUserId(),
					esfUserESFUserRoleModelImpl.getOriginalEsfOrganizationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFU_R_O, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFU_R_O, args);
		}
	}

	/**
	 * Creates a new e s f user e s f user role with the primary key. Does not add the e s f user e s f user role to the database.
	 *
	 * @param esfUserESFUserRolePK the primary key for the new e s f user e s f user role
	 * @return the new e s f user e s f user role
	 */
	@Override
	public ESFUserESFUserRole create(ESFUserESFUserRolePK esfUserESFUserRolePK) {
		ESFUserESFUserRole esfUserESFUserRole = new ESFUserESFUserRoleImpl();

		esfUserESFUserRole.setNew(true);
		esfUserESFUserRole.setPrimaryKey(esfUserESFUserRolePK);

		return esfUserESFUserRole;
	}

	/**
	 * Removes the e s f user e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	 * @return the e s f user e s f user role that was removed
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole remove(ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws NoSuchUserESFUserRoleException, SystemException {
		return remove((Serializable)esfUserESFUserRolePK);
	}

	/**
	 * Removes the e s f user e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f user e s f user role
	 * @return the e s f user e s f user role that was removed
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole remove(Serializable primaryKey)
		throws NoSuchUserESFUserRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFUserESFUserRole esfUserESFUserRole = (ESFUserESFUserRole)session.get(ESFUserESFUserRoleImpl.class,
					primaryKey);

			if (esfUserESFUserRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserESFUserRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfUserESFUserRole);
		}
		catch (NoSuchUserESFUserRoleException nsee) {
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
	protected ESFUserESFUserRole removeImpl(
		ESFUserESFUserRole esfUserESFUserRole) throws SystemException {
		esfUserESFUserRole = toUnwrappedModel(esfUserESFUserRole);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfUserESFUserRole)) {
				esfUserESFUserRole = (ESFUserESFUserRole)session.get(ESFUserESFUserRoleImpl.class,
						esfUserESFUserRole.getPrimaryKeyObj());
			}

			if (esfUserESFUserRole != null) {
				session.delete(esfUserESFUserRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfUserESFUserRole != null) {
			clearCache(esfUserESFUserRole);
		}

		return esfUserESFUserRole;
	}

	@Override
	public ESFUserESFUserRole updateImpl(
		it.ethica.esf.model.ESFUserESFUserRole esfUserESFUserRole)
		throws SystemException {
		esfUserESFUserRole = toUnwrappedModel(esfUserESFUserRole);

		boolean isNew = esfUserESFUserRole.isNew();

		ESFUserESFUserRoleModelImpl esfUserESFUserRoleModelImpl = (ESFUserESFUserRoleModelImpl)esfUserESFUserRole;

		Session session = null;

		try {
			session = openSession();

			if (esfUserESFUserRole.isNew()) {
				session.save(esfUserESFUserRole);

				esfUserESFUserRole.setNew(false);
			}
			else {
				session.merge(esfUserESFUserRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFUserESFUserRoleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRoleModelImpl.getOriginalEsfUserRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERROLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLEID,
					args);

				args = new Object[] {
						esfUserESFUserRoleModelImpl.getEsfUserRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERROLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLEID,
					args);
			}

			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRoleModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);

				args = new Object[] { esfUserESFUserRoleModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);
			}

			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRoleModelImpl.getOriginalEsfUserRoleId(),
						esfUserESFUserRoleModelImpl.getOriginalEsfUserId(),
						esfUserESFUserRoleModelImpl.getOriginalEndDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLE,
					args);

				args = new Object[] {
						esfUserESFUserRoleModelImpl.getEsfUserRoleId(),
						esfUserESFUserRoleModelImpl.getEsfUserId(),
						esfUserESFUserRoleModelImpl.getEndDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERROLE,
					args);
			}

			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFU_ED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRoleModelImpl.getOriginalEsfUserRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFU_ED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFU_ED,
					args);

				args = new Object[] {
						esfUserESFUserRoleModelImpl.getEsfUserRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFU_ED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFU_ED,
					args);
			}

			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFO_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRoleModelImpl.getOriginalEsfOrganizationId(),
						esfUserESFUserRoleModelImpl.getOriginalEsfUserRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFO_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFO_R,
					args);

				args = new Object[] {
						esfUserESFUserRoleModelImpl.getEsfOrganizationId(),
						esfUserESFUserRoleModelImpl.getEsfUserRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFO_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFO_R,
					args);
			}

			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRoleModelImpl.getOriginalEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);

				args = new Object[] {
						esfUserESFUserRoleModelImpl.getEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);
			}

			if ((esfUserESFUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID_ED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFUserRoleModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID_ED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID_ED,
					args);

				args = new Object[] { esfUserESFUserRoleModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID_ED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID_ED,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class, esfUserESFUserRole.getPrimaryKey(),
			esfUserESFUserRole);

		clearUniqueFindersCache(esfUserESFUserRole);
		cacheUniqueFindersCache(esfUserESFUserRole);

		return esfUserESFUserRole;
	}

	protected ESFUserESFUserRole toUnwrappedModel(
		ESFUserESFUserRole esfUserESFUserRole) {
		if (esfUserESFUserRole instanceof ESFUserESFUserRoleImpl) {
			return esfUserESFUserRole;
		}

		ESFUserESFUserRoleImpl esfUserESFUserRoleImpl = new ESFUserESFUserRoleImpl();

		esfUserESFUserRoleImpl.setNew(esfUserESFUserRole.isNew());
		esfUserESFUserRoleImpl.setPrimaryKey(esfUserESFUserRole.getPrimaryKey());

		esfUserESFUserRoleImpl.setEsfUserRoleId(esfUserESFUserRole.getEsfUserRoleId());
		esfUserESFUserRoleImpl.setEsfUserId(esfUserESFUserRole.getEsfUserId());
		esfUserESFUserRoleImpl.setEsfOrganizationId(esfUserESFUserRole.getEsfOrganizationId());
		esfUserESFUserRoleImpl.setStartDate(esfUserESFUserRole.getStartDate());
		esfUserESFUserRoleImpl.setEndDate(esfUserESFUserRole.getEndDate());

		return esfUserESFUserRoleImpl;
	}

	/**
	 * Returns the e s f user e s f user role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user e s f user role
	 * @return the e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserESFUserRoleException, SystemException {
		ESFUserESFUserRole esfUserESFUserRole = fetchByPrimaryKey(primaryKey);

		if (esfUserESFUserRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserESFUserRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfUserESFUserRole;
	}

	/**
	 * Returns the e s f user e s f user role with the primary key or throws a {@link it.ethica.esf.NoSuchUserESFUserRoleException} if it could not be found.
	 *
	 * @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	 * @return the e s f user e s f user role
	 * @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole findByPrimaryKey(
		ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws NoSuchUserESFUserRoleException, SystemException {
		return findByPrimaryKey((Serializable)esfUserESFUserRolePK);
	}

	/**
	 * Returns the e s f user e s f user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user e s f user role
	 * @return the e s f user e s f user role, or <code>null</code> if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFUserESFUserRole esfUserESFUserRole = (ESFUserESFUserRole)EntityCacheUtil.getResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserESFUserRoleImpl.class, primaryKey);

		if (esfUserESFUserRole == _nullESFUserESFUserRole) {
			return null;
		}

		if (esfUserESFUserRole == null) {
			Session session = null;

			try {
				session = openSession();

				esfUserESFUserRole = (ESFUserESFUserRole)session.get(ESFUserESFUserRoleImpl.class,
						primaryKey);

				if (esfUserESFUserRole != null) {
					cacheResult(esfUserESFUserRole);
				}
				else {
					EntityCacheUtil.putResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserESFUserRoleImpl.class, primaryKey,
						_nullESFUserESFUserRole);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
					ESFUserESFUserRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfUserESFUserRole;
	}

	/**
	 * Returns the e s f user e s f user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	 * @return the e s f user e s f user role, or <code>null</code> if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole fetchByPrimaryKey(
		ESFUserESFUserRolePK esfUserESFUserRolePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfUserESFUserRolePK);
	}

	/**
	 * Returns all the e s f user e s f user roles.
	 *
	 * @return the e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> findAll(int start, int end,
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

		List<ESFUserESFUserRole> list = (List<ESFUserESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFUSERESFUSERROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFUSERESFUSERROLE;

				if (pagination) {
					sql = sql.concat(ESFUserESFUserRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFUserRole>(list);
				}
				else {
					list = (List<ESFUserESFUserRole>)QueryUtil.list(q,
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
	 * Removes all the e s f user e s f user roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFUserESFUserRole esfUserESFUserRole : findAll()) {
			remove(esfUserESFUserRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f user roles.
	 *
	 * @return the number of e s f user e s f user roles
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

				Query q = session.createQuery(_SQL_COUNT_ESFUSERESFUSERROLE);

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
	 * Initializes the e s f user e s f user role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFUserESFUserRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFUserESFUserRole>> listenersList = new ArrayList<ModelListener<ESFUserESFUserRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFUserESFUserRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFUserESFUserRoleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFUSERESFUSERROLE = "SELECT esfUserESFUserRole FROM ESFUserESFUserRole esfUserESFUserRole";
	private static final String _SQL_SELECT_ESFUSERESFUSERROLE_WHERE = "SELECT esfUserESFUserRole FROM ESFUserESFUserRole esfUserESFUserRole WHERE ";
	private static final String _SQL_COUNT_ESFUSERESFUSERROLE = "SELECT COUNT(esfUserESFUserRole) FROM ESFUserESFUserRole esfUserESFUserRole";
	private static final String _SQL_COUNT_ESFUSERESFUSERROLE_WHERE = "SELECT COUNT(esfUserESFUserRole) FROM ESFUserESFUserRole esfUserESFUserRole WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfUserESFUserRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFUserESFUserRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFUserESFUserRole exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFUserESFUserRolePersistenceImpl.class);
	private static ESFUserESFUserRole _nullESFUserESFUserRole = new ESFUserESFUserRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFUserESFUserRole> toCacheModel() {
				return _nullESFUserESFUserRoleCacheModel;
			}
		};

	private static CacheModel<ESFUserESFUserRole> _nullESFUserESFUserRoleCacheModel =
		new CacheModel<ESFUserESFUserRole>() {
			@Override
			public ESFUserESFUserRole toEntityModel() {
				return _nullESFUserESFUserRole;
			}
		};
}