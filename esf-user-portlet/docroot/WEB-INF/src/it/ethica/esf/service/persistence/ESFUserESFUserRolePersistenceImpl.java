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

	private static final String _FINDER_COLUMN_ESFUSERID_ESFUSERID_2 = "esfUserESFUserRole.id.esfUserId = ?";

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
	}

	@Override
	public void clearCache(List<ESFUserESFUserRole> esfUserESFUserRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
			EntityCacheUtil.removeResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserESFUserRoleImpl.class, esfUserESFUserRole.getPrimaryKey());
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
		}

		EntityCacheUtil.putResult(ESFUserESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFUserRoleImpl.class, esfUserESFUserRole.getPrimaryKey(),
			esfUserESFUserRole);

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