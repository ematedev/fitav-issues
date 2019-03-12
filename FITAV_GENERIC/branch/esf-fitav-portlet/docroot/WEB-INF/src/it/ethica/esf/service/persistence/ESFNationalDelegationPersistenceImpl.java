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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchNationalDelegationException;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.impl.ESFNationalDelegationImpl;
import it.ethica.esf.model.impl.ESFNationalDelegationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the e s f national delegation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalDelegationPersistence
 * @see ESFNationalDelegationUtil
 * @generated
 */
public class ESFNationalDelegationPersistenceImpl extends BasePersistenceImpl<ESFNationalDelegation>
	implements ESFNationalDelegationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFNationalDelegationUtil} to access the e s f national delegation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFNationalDelegationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSER = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFUser",
			new String[] { Long.class.getName() },
			ESFNationalDelegationModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSER = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f national delegations where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFUser(long esfUserId)
		throws SystemException {
		return findByESFUser(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f national delegations where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @return the range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFUser(long esfUserId, int start,
		int end) throws SystemException {
		return findByESFUser(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national delegations where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFUser(long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSER;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFNationalDelegation> list = (List<ESFNationalDelegation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalDelegation esfNationalDelegation : list) {
				if ((esfUserId != esfNationalDelegation.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_ESFUSER_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalDelegation>(list);
				}
				else {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
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
	 * Returns the first e s f national delegation in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByESFUser_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByESFUser_First(esfUserId,
				orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the first e s f national delegation in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByESFUser_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNationalDelegation> list = findByESFUser(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByESFUser_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByESFUser_Last(esfUserId,
				orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByESFUser_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFUser(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFNationalDelegation> list = findByESFUser(esfUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfNationalDelgationId the primary key of the current e s f national delegation
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation[] findByESFUser_PrevAndNext(
		long esfNationalDelgationId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = findByPrimaryKey(esfNationalDelgationId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalDelegation[] array = new ESFNationalDelegationImpl[3];

			array[0] = getByESFUser_PrevAndNext(session, esfNationalDelegation,
					esfUserId, orderByComparator, true);

			array[1] = esfNationalDelegation;

			array[2] = getByESFUser_PrevAndNext(session, esfNationalDelegation,
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

	protected ESFNationalDelegation getByESFUser_PrevAndNext(Session session,
		ESFNationalDelegation esfNationalDelegation, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

		query.append(_FINDER_COLUMN_ESFUSER_ESFUSERID_2);

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
			query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalDelegation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalDelegation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national delegations where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFUser(long esfUserId) throws SystemException {
		for (ESFNationalDelegation esfNationalDelegation : findByESFUser(
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNationalDelegation);
		}
	}

	/**
	 * Returns the number of e s f national delegations where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFUser(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSER;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_ESFUSER_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_ESFUSER_ESFUSERID_2 = "esfNationalDelegation.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_L = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_L",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_L = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_L",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @return the matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByU_L(long esfUserId, Date leaveDate)
		throws SystemException {
		return findByU_L(esfUserId, leaveDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @return the range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByU_L(long esfUserId,
		Date leaveDate, int start, int end) throws SystemException {
		return findByU_L(esfUserId, leaveDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByU_L(long esfUserId,
		Date leaveDate, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_L;
		finderArgs = new Object[] {
				esfUserId, leaveDate,
				
				start, end, orderByComparator
			};

		List<ESFNationalDelegation> list = (List<ESFNationalDelegation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalDelegation esfNationalDelegation : list) {
				if ((esfUserId != esfNationalDelegation.getEsfUserId()) ||
						(leaveDate.getTime() >= esfNationalDelegation.getLeaveDate()
																		 .getTime())) {
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

			query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_U_L_ESFUSERID_2);

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_U_L_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_U_L_LEAVEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (bindLeaveDate) {
					qPos.add(CalendarUtil.getTimestamp(leaveDate));
				}

				if (!pagination) {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalDelegation>(list);
				}
				else {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
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
	 * Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByU_L_First(long esfUserId,
		Date leaveDate, OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByU_L_First(esfUserId,
				leaveDate, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", leaveDate=");
		msg.append(leaveDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByU_L_First(long esfUserId,
		Date leaveDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFNationalDelegation> list = findByU_L(esfUserId, leaveDate, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByU_L_Last(long esfUserId, Date leaveDate,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByU_L_Last(esfUserId,
				leaveDate, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", leaveDate=");
		msg.append(leaveDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByU_L_Last(long esfUserId,
		Date leaveDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByU_L(esfUserId, leaveDate);

		if (count == 0) {
			return null;
		}

		List<ESFNationalDelegation> list = findByU_L(esfUserId, leaveDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * @param esfNationalDelgationId the primary key of the current e s f national delegation
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation[] findByU_L_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, Date leaveDate,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = findByPrimaryKey(esfNationalDelgationId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalDelegation[] array = new ESFNationalDelegationImpl[3];

			array[0] = getByU_L_PrevAndNext(session, esfNationalDelegation,
					esfUserId, leaveDate, orderByComparator, true);

			array[1] = esfNationalDelegation;

			array[2] = getByU_L_PrevAndNext(session, esfNationalDelegation,
					esfUserId, leaveDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFNationalDelegation getByU_L_PrevAndNext(Session session,
		ESFNationalDelegation esfNationalDelegation, long esfUserId,
		Date leaveDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

		query.append(_FINDER_COLUMN_U_L_ESFUSERID_2);

		boolean bindLeaveDate = false;

		if (leaveDate == null) {
			query.append(_FINDER_COLUMN_U_L_LEAVEDATE_1);
		}
		else {
			bindLeaveDate = true;

			query.append(_FINDER_COLUMN_U_L_LEAVEDATE_2);
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
			query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (bindLeaveDate) {
			qPos.add(CalendarUtil.getTimestamp(leaveDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalDelegation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalDelegation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByU_L(long esfUserId, Date leaveDate)
		throws SystemException {
		for (ESFNationalDelegation esfNationalDelegation : findByU_L(
				esfUserId, leaveDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNationalDelegation);
		}
	}

	/**
	 * Returns the number of e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param leaveDate the leave date
	 * @return the number of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByU_L(long esfUserId, Date leaveDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_L;

		Object[] finderArgs = new Object[] { esfUserId, leaveDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_U_L_ESFUSERID_2);

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_U_L_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_U_L_LEAVEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (bindLeaveDate) {
					qPos.add(CalendarUtil.getTimestamp(leaveDate));
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

	private static final String _FINDER_COLUMN_U_L_ESFUSERID_2 = "esfNationalDelegation.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_U_L_LEAVEDATE_1 = "esfNationalDelegation.leaveDate > NULL";
	private static final String _FINDER_COLUMN_U_L_LEAVEDATE_2 = "esfNationalDelegation.leaveDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHESFPARTECIPANTTYPE =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMatchESFPartecipantType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFPARTECIPANTTYPE =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMatchESFPartecipantType",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFNationalDelegationModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNationalDelegationModelImpl.ESFPARTECIPANTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHESFPARTECIPANTTYPE =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatchESFPartecipantType",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId) throws SystemException {
		return findByESFMatchESFPartecipantType(esfMatchId,
			esfPartecipantTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @return the range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId, int start, int end)
		throws SystemException {
		return findByESFMatchESFPartecipantType(esfMatchId,
			esfPartecipantTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFPARTECIPANTTYPE;
			finderArgs = new Object[] { esfMatchId, esfPartecipantTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHESFPARTECIPANTTYPE;
			finderArgs = new Object[] {
					esfMatchId, esfPartecipantTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNationalDelegation> list = (List<ESFNationalDelegation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalDelegation esfNationalDelegation : list) {
				if ((esfMatchId != esfNationalDelegation.getEsfMatchId()) ||
						(esfPartecipantTypeId != esfNationalDelegation.getEsfPartecipantTypeId())) {
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

			query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHESFPARTECIPANTTYPE_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHESFPARTECIPANTTYPE_ESFPARTECIPANTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfPartecipantTypeId);

				if (!pagination) {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalDelegation>(list);
				}
				else {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
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
	 * Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByESFMatchESFPartecipantType_First(
		long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByESFMatchESFPartecipantType_First(esfMatchId,
				esfPartecipantTypeId, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfPartecipantTypeId=");
		msg.append(esfPartecipantTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByESFMatchESFPartecipantType_First(
		long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNationalDelegation> list = findByESFMatchESFPartecipantType(esfMatchId,
				esfPartecipantTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByESFMatchESFPartecipantType_Last(
		long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByESFMatchESFPartecipantType_Last(esfMatchId,
				esfPartecipantTypeId, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfPartecipantTypeId=");
		msg.append(esfPartecipantTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByESFMatchESFPartecipantType_Last(
		long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatchESFPartecipantType(esfMatchId,
				esfPartecipantTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFNationalDelegation> list = findByESFMatchESFPartecipantType(esfMatchId,
				esfPartecipantTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfNationalDelgationId the primary key of the current e s f national delegation
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation[] findByESFMatchESFPartecipantType_PrevAndNext(
		long esfNationalDelgationId, long esfMatchId,
		long esfPartecipantTypeId, OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = findByPrimaryKey(esfNationalDelgationId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalDelegation[] array = new ESFNationalDelegationImpl[3];

			array[0] = getByESFMatchESFPartecipantType_PrevAndNext(session,
					esfNationalDelegation, esfMatchId, esfPartecipantTypeId,
					orderByComparator, true);

			array[1] = esfNationalDelegation;

			array[2] = getByESFMatchESFPartecipantType_PrevAndNext(session,
					esfNationalDelegation, esfMatchId, esfPartecipantTypeId,
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

	protected ESFNationalDelegation getByESFMatchESFPartecipantType_PrevAndNext(
		Session session, ESFNationalDelegation esfNationalDelegation,
		long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHESFPARTECIPANTTYPE_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMATCHESFPARTECIPANTTYPE_ESFPARTECIPANTTYPEID_2);

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
			query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfPartecipantTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalDelegation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalDelegation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchESFPartecipantType(long esfMatchId,
		long esfPartecipantTypeId) throws SystemException {
		for (ESFNationalDelegation esfNationalDelegation : findByESFMatchESFPartecipantType(
				esfMatchId, esfPartecipantTypeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfNationalDelegation);
		}
	}

	/**
	 * Returns the number of e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the number of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatchESFPartecipantType(long esfMatchId,
		long esfPartecipantTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHESFPARTECIPANTTYPE;

		Object[] finderArgs = new Object[] { esfMatchId, esfPartecipantTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHESFPARTECIPANTTYPE_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHESFPARTECIPANTTYPE_ESFPARTECIPANTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfPartecipantTypeId);

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

	private static final String _FINDER_COLUMN_ESFMATCHESFPARTECIPANTTYPE_ESFMATCHID_2 =
		"esfNationalDelegation.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHESFPARTECIPANTTYPE_ESFPARTECIPANTTYPEID_2 =
		"esfNationalDelegation.esfPartecipantTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH_U =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFMatch_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH_U =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFMatch_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFNationalDelegationModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFNationalDelegationModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCH_U = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFMatch_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatch_U(long esfUserId,
		long esfMatchId) throws SystemException {
		return findByESFMatch_U(esfUserId, esfMatchId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @return the range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatch_U(long esfUserId,
		long esfMatchId, int start, int end) throws SystemException {
		return findByESFMatch_U(esfUserId, esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatch_U(long esfUserId,
		long esfMatchId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH_U;
			finderArgs = new Object[] { esfUserId, esfMatchId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH_U;
			finderArgs = new Object[] {
					esfUserId, esfMatchId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNationalDelegation> list = (List<ESFNationalDelegation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalDelegation esfNationalDelegation : list) {
				if ((esfUserId != esfNationalDelegation.getEsfUserId()) ||
						(esfMatchId != esfNationalDelegation.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_U_ESFUSERID_2);

			query.append(_FINDER_COLUMN_ESFMATCH_U_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalDelegation>(list);
				}
				else {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
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
	 * Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByESFMatch_U_First(long esfUserId,
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByESFMatch_U_First(esfUserId,
				esfMatchId, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByESFMatch_U_First(long esfUserId,
		long esfMatchId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFNationalDelegation> list = findByESFMatch_U(esfUserId,
				esfMatchId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByESFMatch_U_Last(long esfUserId,
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByESFMatch_U_Last(esfUserId,
				esfMatchId, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByESFMatch_U_Last(long esfUserId,
		long esfMatchId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFMatch_U(esfUserId, esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFNationalDelegation> list = findByESFMatch_U(esfUserId,
				esfMatchId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * @param esfNationalDelgationId the primary key of the current e s f national delegation
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation[] findByESFMatch_U_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = findByPrimaryKey(esfNationalDelgationId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalDelegation[] array = new ESFNationalDelegationImpl[3];

			array[0] = getByESFMatch_U_PrevAndNext(session,
					esfNationalDelegation, esfUserId, esfMatchId,
					orderByComparator, true);

			array[1] = esfNationalDelegation;

			array[2] = getByESFMatch_U_PrevAndNext(session,
					esfNationalDelegation, esfUserId, esfMatchId,
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

	protected ESFNationalDelegation getByESFMatch_U_PrevAndNext(
		Session session, ESFNationalDelegation esfNationalDelegation,
		long esfUserId, long esfMatchId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCH_U_ESFUSERID_2);

		query.append(_FINDER_COLUMN_ESFMATCH_U_ESFMATCHID_2);

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
			query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalDelegation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalDelegation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatch_U(long esfUserId, long esfMatchId)
		throws SystemException {
		for (ESFNationalDelegation esfNationalDelegation : findByESFMatch_U(
				esfUserId, esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(esfNationalDelegation);
		}
	}

	/**
	 * Returns the number of e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatch_U(long esfUserId, long esfMatchId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCH_U;

		Object[] finderArgs = new Object[] { esfUserId, esfMatchId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_U_ESFUSERID_2);

			query.append(_FINDER_COLUMN_ESFMATCH_U_ESFMATCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfMatchId);

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

	private static final String _FINDER_COLUMN_ESFMATCH_U_ESFUSERID_2 = "esfNationalDelegation.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCH_U_ESFMATCHID_2 = "esfNationalDelegation.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFMatch",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFMatch",
			new String[] { Long.class.getName() },
			ESFNationalDelegationModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCH = new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFMatch",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f national delegations where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatch(long esfMatchId)
		throws SystemException {
		return findByESFMatch(esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f national delegations where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @return the range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatch(long esfMatchId,
		int start, int end) throws SystemException {
		return findByESFMatch(esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national delegations where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByESFMatch(long esfMatchId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH;
			finderArgs = new Object[] { esfMatchId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH;
			finderArgs = new Object[] { esfMatchId, start, end, orderByComparator };
		}

		List<ESFNationalDelegation> list = (List<ESFNationalDelegation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalDelegation esfNationalDelegation : list) {
				if ((esfMatchId != esfNationalDelegation.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalDelegation>(list);
				}
				else {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
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
	 * Returns the first e s f national delegation in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByESFMatch_First(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByESFMatch_First(esfMatchId,
				orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the first e s f national delegation in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByESFMatch_First(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNationalDelegation> list = findByESFMatch(esfMatchId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByESFMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByESFMatch_Last(esfMatchId,
				orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByESFMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatch(esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFNationalDelegation> list = findByESFMatch(esfMatchId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfNationalDelgationId the primary key of the current e s f national delegation
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation[] findByESFMatch_PrevAndNext(
		long esfNationalDelgationId, long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = findByPrimaryKey(esfNationalDelgationId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalDelegation[] array = new ESFNationalDelegationImpl[3];

			array[0] = getByESFMatch_PrevAndNext(session,
					esfNationalDelegation, esfMatchId, orderByComparator, true);

			array[1] = esfNationalDelegation;

			array[2] = getByESFMatch_PrevAndNext(session,
					esfNationalDelegation, esfMatchId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFNationalDelegation getByESFMatch_PrevAndNext(Session session,
		ESFNationalDelegation esfNationalDelegation, long esfMatchId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

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
			query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalDelegation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalDelegation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national delegations where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatch(long esfMatchId) throws SystemException {
		for (ESFNationalDelegation esfNationalDelegation : findByESFMatch(
				esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNationalDelegation);
		}
	}

	/**
	 * Returns the number of e s f national delegations where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatch(long esfMatchId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCH;

		Object[] finderArgs = new Object[] { esfMatchId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

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

	private static final String _FINDER_COLUMN_ESFMATCH_ESFMATCHID_2 = "esfNationalDelegation.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTECIPANTTYPE_ESFUSERID =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPartecipantType_EsfUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTECIPANTTYPE_ESFUSERID =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPartecipantType_EsfUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFNationalDelegationModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFNationalDelegationModelImpl.ESFPARTECIPANTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARTECIPANTTYPE_ESFUSERID =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPartecipantType_EsfUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId) throws SystemException {
		return findByPartecipantType_EsfUserId(esfUserId, esfPartecipantTypeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @return the range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId, int start, int end)
		throws SystemException {
		return findByPartecipantType_EsfUserId(esfUserId, esfPartecipantTypeId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTECIPANTTYPE_ESFUSERID;
			finderArgs = new Object[] { esfUserId, esfPartecipantTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTECIPANTTYPE_ESFUSERID;
			finderArgs = new Object[] {
					esfUserId, esfPartecipantTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNationalDelegation> list = (List<ESFNationalDelegation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalDelegation esfNationalDelegation : list) {
				if ((esfUserId != esfNationalDelegation.getEsfUserId()) ||
						(esfPartecipantTypeId != esfNationalDelegation.getEsfPartecipantTypeId())) {
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

			query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_PARTECIPANTTYPE_ESFUSERID_ESFUSERID_2);

			query.append(_FINDER_COLUMN_PARTECIPANTTYPE_ESFUSERID_ESFPARTECIPANTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfPartecipantTypeId);

				if (!pagination) {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalDelegation>(list);
				}
				else {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
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
	 * Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByPartecipantType_EsfUserId_First(
		long esfUserId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByPartecipantType_EsfUserId_First(esfUserId,
				esfPartecipantTypeId, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", esfPartecipantTypeId=");
		msg.append(esfPartecipantTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByPartecipantType_EsfUserId_First(
		long esfUserId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNationalDelegation> list = findByPartecipantType_EsfUserId(esfUserId,
				esfPartecipantTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByPartecipantType_EsfUserId_Last(
		long esfUserId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByPartecipantType_EsfUserId_Last(esfUserId,
				esfPartecipantTypeId, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", esfPartecipantTypeId=");
		msg.append(esfPartecipantTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByPartecipantType_EsfUserId_Last(
		long esfUserId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPartecipantType_EsfUserId(esfUserId,
				esfPartecipantTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFNationalDelegation> list = findByPartecipantType_EsfUserId(esfUserId,
				esfPartecipantTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfNationalDelgationId the primary key of the current e s f national delegation
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation[] findByPartecipantType_EsfUserId_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = findByPrimaryKey(esfNationalDelgationId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalDelegation[] array = new ESFNationalDelegationImpl[3];

			array[0] = getByPartecipantType_EsfUserId_PrevAndNext(session,
					esfNationalDelegation, esfUserId, esfPartecipantTypeId,
					orderByComparator, true);

			array[1] = esfNationalDelegation;

			array[2] = getByPartecipantType_EsfUserId_PrevAndNext(session,
					esfNationalDelegation, esfUserId, esfPartecipantTypeId,
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

	protected ESFNationalDelegation getByPartecipantType_EsfUserId_PrevAndNext(
		Session session, ESFNationalDelegation esfNationalDelegation,
		long esfUserId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

		query.append(_FINDER_COLUMN_PARTECIPANTTYPE_ESFUSERID_ESFUSERID_2);

		query.append(_FINDER_COLUMN_PARTECIPANTTYPE_ESFUSERID_ESFPARTECIPANTTYPEID_2);

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
			query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		qPos.add(esfPartecipantTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalDelegation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalDelegation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPartecipantType_EsfUserId(long esfUserId,
		long esfPartecipantTypeId) throws SystemException {
		for (ESFNationalDelegation esfNationalDelegation : findByPartecipantType_EsfUserId(
				esfUserId, esfPartecipantTypeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfNationalDelegation);
		}
	}

	/**
	 * Returns the number of e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the number of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPartecipantType_EsfUserId(long esfUserId,
		long esfPartecipantTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARTECIPANTTYPE_ESFUSERID;

		Object[] finderArgs = new Object[] { esfUserId, esfPartecipantTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_PARTECIPANTTYPE_ESFUSERID_ESFUSERID_2);

			query.append(_FINDER_COLUMN_PARTECIPANTTYPE_ESFUSERID_ESFPARTECIPANTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfPartecipantTypeId);

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

	private static final String _FINDER_COLUMN_PARTECIPANTTYPE_ESFUSERID_ESFUSERID_2 =
		"esfNationalDelegation.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_PARTECIPANTTYPE_ESFUSERID_ESFPARTECIPANTTYPEID_2 =
		"esfNationalDelegation.esfPartecipantTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPartcipanType_MatchId_SportTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPartcipanType_MatchId_SportTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFNationalDelegationModelImpl.ESFSPORTTYPEID_COLUMN_BITMASK |
			ESFNationalDelegationModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNationalDelegationModelImpl.ESFPARTECIPANTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID =
		new FinderPath(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPartcipanType_MatchId_SportTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByPartcipanType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId)
		throws SystemException {
		return findByPartcipanType_MatchId_SportTypeId(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @return the range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByPartcipanType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		int start, int end) throws SystemException {
		return findByPartcipanType_MatchId_SportTypeId(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findByPartcipanType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID;
			finderArgs = new Object[] {
					esfSportTypeId, esfMatchId, esfPartecipantTypeId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID;
			finderArgs = new Object[] {
					esfSportTypeId, esfMatchId, esfPartecipantTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNationalDelegation> list = (List<ESFNationalDelegation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalDelegation esfNationalDelegation : list) {
				if ((esfSportTypeId != esfNationalDelegation.getEsfSportTypeId()) ||
						(esfMatchId != esfNationalDelegation.getEsfMatchId()) ||
						(esfPartecipantTypeId != esfNationalDelegation.getEsfPartecipantTypeId())) {
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

			query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFSPORTTYPEID_2);

			query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFPARTECIPANTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfSportTypeId);

				qPos.add(esfMatchId);

				qPos.add(esfPartecipantTypeId);

				if (!pagination) {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalDelegation>(list);
				}
				else {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
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
	 * Returns the first e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByPartcipanType_MatchId_SportTypeId_First(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByPartcipanType_MatchId_SportTypeId_First(esfSportTypeId,
				esfMatchId, esfPartecipantTypeId, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(", esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfPartecipantTypeId=");
		msg.append(esfPartecipantTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the first e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByPartcipanType_MatchId_SportTypeId_First(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNationalDelegation> list = findByPartcipanType_MatchId_SportTypeId(esfSportTypeId,
				esfMatchId, esfPartecipantTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByPartcipanType_MatchId_SportTypeId_Last(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByPartcipanType_MatchId_SportTypeId_Last(esfSportTypeId,
				esfMatchId, esfPartecipantTypeId, orderByComparator);

		if (esfNationalDelegation != null) {
			return esfNationalDelegation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(", esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfPartecipantTypeId=");
		msg.append(esfPartecipantTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalDelegationException(msg.toString());
	}

	/**
	 * Returns the last e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByPartcipanType_MatchId_SportTypeId_Last(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPartcipanType_MatchId_SportTypeId(esfSportTypeId,
				esfMatchId, esfPartecipantTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFNationalDelegation> list = findByPartcipanType_MatchId_SportTypeId(esfSportTypeId,
				esfMatchId, esfPartecipantTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfNationalDelgationId the primary key of the current e s f national delegation
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation[] findByPartcipanType_MatchId_SportTypeId_PrevAndNext(
		long esfNationalDelgationId, long esfSportTypeId, long esfMatchId,
		long esfPartecipantTypeId, OrderByComparator orderByComparator)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = findByPrimaryKey(esfNationalDelgationId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalDelegation[] array = new ESFNationalDelegationImpl[3];

			array[0] = getByPartcipanType_MatchId_SportTypeId_PrevAndNext(session,
					esfNationalDelegation, esfSportTypeId, esfMatchId,
					esfPartecipantTypeId, orderByComparator, true);

			array[1] = esfNationalDelegation;

			array[2] = getByPartcipanType_MatchId_SportTypeId_PrevAndNext(session,
					esfNationalDelegation, esfSportTypeId, esfMatchId,
					esfPartecipantTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFNationalDelegation getByPartcipanType_MatchId_SportTypeId_PrevAndNext(
		Session session, ESFNationalDelegation esfNationalDelegation,
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONALDELEGATION_WHERE);

		query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFSPORTTYPEID_2);

		query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFPARTECIPANTTYPEID_2);

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
			query.append(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfSportTypeId);

		qPos.add(esfMatchId);

		qPos.add(esfPartecipantTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalDelegation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalDelegation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPartcipanType_MatchId_SportTypeId(long esfSportTypeId,
		long esfMatchId, long esfPartecipantTypeId) throws SystemException {
		for (ESFNationalDelegation esfNationalDelegation : findByPartcipanType_MatchId_SportTypeId(
				esfSportTypeId, esfMatchId, esfPartecipantTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNationalDelegation);
		}
	}

	/**
	 * Returns the number of e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the number of matching e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPartcipanType_MatchId_SportTypeId(long esfSportTypeId,
		long esfMatchId, long esfPartecipantTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID;

		Object[] finderArgs = new Object[] {
				esfSportTypeId, esfMatchId, esfPartecipantTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFNATIONALDELEGATION_WHERE);

			query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFSPORTTYPEID_2);

			query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFPARTECIPANTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfSportTypeId);

				qPos.add(esfMatchId);

				qPos.add(esfPartecipantTypeId);

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

	private static final String _FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFSPORTTYPEID_2 =
		"esfNationalDelegation.esfSportTypeId = ? AND ";
	private static final String _FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFMATCHID_2 =
		"esfNationalDelegation.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_PARTCIPANTYPE_MATCHID_SPORTTYPEID_ESFPARTECIPANTTYPEID_2 =
		"esfNationalDelegation.esfPartecipantTypeId = ?";

	public ESFNationalDelegationPersistenceImpl() {
		setModelClass(ESFNationalDelegation.class);
	}

	/**
	 * Caches the e s f national delegation in the entity cache if it is enabled.
	 *
	 * @param esfNationalDelegation the e s f national delegation
	 */
	@Override
	public void cacheResult(ESFNationalDelegation esfNationalDelegation) {
		EntityCacheUtil.putResult(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			esfNationalDelegation.getPrimaryKey(), esfNationalDelegation);

		esfNationalDelegation.resetOriginalValues();
	}

	/**
	 * Caches the e s f national delegations in the entity cache if it is enabled.
	 *
	 * @param esfNationalDelegations the e s f national delegations
	 */
	@Override
	public void cacheResult(List<ESFNationalDelegation> esfNationalDelegations) {
		for (ESFNationalDelegation esfNationalDelegation : esfNationalDelegations) {
			if (EntityCacheUtil.getResult(
						ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
						ESFNationalDelegationImpl.class,
						esfNationalDelegation.getPrimaryKey()) == null) {
				cacheResult(esfNationalDelegation);
			}
			else {
				esfNationalDelegation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f national delegations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFNationalDelegationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFNationalDelegationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f national delegation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFNationalDelegation esfNationalDelegation) {
		EntityCacheUtil.removeResult(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			esfNationalDelegation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFNationalDelegation> esfNationalDelegations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFNationalDelegation esfNationalDelegation : esfNationalDelegations) {
			EntityCacheUtil.removeResult(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
				ESFNationalDelegationImpl.class,
				esfNationalDelegation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f national delegation with the primary key. Does not add the e s f national delegation to the database.
	 *
	 * @param esfNationalDelgationId the primary key for the new e s f national delegation
	 * @return the new e s f national delegation
	 */
	@Override
	public ESFNationalDelegation create(long esfNationalDelgationId) {
		ESFNationalDelegation esfNationalDelegation = new ESFNationalDelegationImpl();

		esfNationalDelegation.setNew(true);
		esfNationalDelegation.setPrimaryKey(esfNationalDelgationId);

		return esfNationalDelegation;
	}

	/**
	 * Removes the e s f national delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfNationalDelgationId the primary key of the e s f national delegation
	 * @return the e s f national delegation that was removed
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation remove(long esfNationalDelgationId)
		throws NoSuchNationalDelegationException, SystemException {
		return remove((Serializable)esfNationalDelgationId);
	}

	/**
	 * Removes the e s f national delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f national delegation
	 * @return the e s f national delegation that was removed
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation remove(Serializable primaryKey)
		throws NoSuchNationalDelegationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFNationalDelegation esfNationalDelegation = (ESFNationalDelegation)session.get(ESFNationalDelegationImpl.class,
					primaryKey);

			if (esfNationalDelegation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNationalDelegationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfNationalDelegation);
		}
		catch (NoSuchNationalDelegationException nsee) {
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
	protected ESFNationalDelegation removeImpl(
		ESFNationalDelegation esfNationalDelegation) throws SystemException {
		esfNationalDelegation = toUnwrappedModel(esfNationalDelegation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfNationalDelegation)) {
				esfNationalDelegation = (ESFNationalDelegation)session.get(ESFNationalDelegationImpl.class,
						esfNationalDelegation.getPrimaryKeyObj());
			}

			if (esfNationalDelegation != null) {
				session.delete(esfNationalDelegation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfNationalDelegation != null) {
			clearCache(esfNationalDelegation);
		}

		return esfNationalDelegation;
	}

	@Override
	public ESFNationalDelegation updateImpl(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation)
		throws SystemException {
		esfNationalDelegation = toUnwrappedModel(esfNationalDelegation);

		boolean isNew = esfNationalDelegation.isNew();

		ESFNationalDelegationModelImpl esfNationalDelegationModelImpl = (ESFNationalDelegationModelImpl)esfNationalDelegation;

		Session session = null;

		try {
			session = openSession();

			if (esfNationalDelegation.isNew()) {
				session.save(esfNationalDelegation);

				esfNationalDelegation.setNew(false);
			}
			else {
				session.merge(esfNationalDelegation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFNationalDelegationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfNationalDelegationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalDelegationModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER,
					args);

				args = new Object[] {
						esfNationalDelegationModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER,
					args);
			}

			if ((esfNationalDelegationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFPARTECIPANTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalDelegationModelImpl.getOriginalEsfMatchId(),
						esfNationalDelegationModelImpl.getOriginalEsfPartecipantTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHESFPARTECIPANTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFPARTECIPANTTYPE,
					args);

				args = new Object[] {
						esfNationalDelegationModelImpl.getEsfMatchId(),
						esfNationalDelegationModelImpl.getEsfPartecipantTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHESFPARTECIPANTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFPARTECIPANTTYPE,
					args);
			}

			if ((esfNationalDelegationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalDelegationModelImpl.getOriginalEsfUserId(),
						esfNationalDelegationModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH_U,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH_U,
					args);

				args = new Object[] {
						esfNationalDelegationModelImpl.getEsfUserId(),
						esfNationalDelegationModelImpl.getEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH_U,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH_U,
					args);
			}

			if ((esfNationalDelegationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalDelegationModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);

				args = new Object[] {
						esfNationalDelegationModelImpl.getEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);
			}

			if ((esfNationalDelegationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTECIPANTTYPE_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalDelegationModelImpl.getOriginalEsfUserId(),
						esfNationalDelegationModelImpl.getOriginalEsfPartecipantTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTECIPANTTYPE_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTECIPANTTYPE_ESFUSERID,
					args);

				args = new Object[] {
						esfNationalDelegationModelImpl.getEsfUserId(),
						esfNationalDelegationModelImpl.getEsfPartecipantTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTECIPANTTYPE_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTECIPANTTYPE_ESFUSERID,
					args);
			}

			if ((esfNationalDelegationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalDelegationModelImpl.getOriginalEsfSportTypeId(),
						esfNationalDelegationModelImpl.getOriginalEsfMatchId(),
						esfNationalDelegationModelImpl.getOriginalEsfPartecipantTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID,
					args);

				args = new Object[] {
						esfNationalDelegationModelImpl.getEsfSportTypeId(),
						esfNationalDelegationModelImpl.getEsfMatchId(),
						esfNationalDelegationModelImpl.getEsfPartecipantTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTCIPANTYPE_MATCHID_SPORTTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalDelegationImpl.class,
			esfNationalDelegation.getPrimaryKey(), esfNationalDelegation);

		return esfNationalDelegation;
	}

	protected ESFNationalDelegation toUnwrappedModel(
		ESFNationalDelegation esfNationalDelegation) {
		if (esfNationalDelegation instanceof ESFNationalDelegationImpl) {
			return esfNationalDelegation;
		}

		ESFNationalDelegationImpl esfNationalDelegationImpl = new ESFNationalDelegationImpl();

		esfNationalDelegationImpl.setNew(esfNationalDelegation.isNew());
		esfNationalDelegationImpl.setPrimaryKey(esfNationalDelegation.getPrimaryKey());

		esfNationalDelegationImpl.setEsfUserId(esfNationalDelegation.getEsfUserId());
		esfNationalDelegationImpl.setGroupId(esfNationalDelegation.getGroupId());
		esfNationalDelegationImpl.setCompanyId(esfNationalDelegation.getCompanyId());
		esfNationalDelegationImpl.setUserId(esfNationalDelegation.getUserId());
		esfNationalDelegationImpl.setUserName(esfNationalDelegation.getUserName());
		esfNationalDelegationImpl.setCreateDate(esfNationalDelegation.getCreateDate());
		esfNationalDelegationImpl.setModifiedDate(esfNationalDelegation.getModifiedDate());
		esfNationalDelegationImpl.setLeaveDate(esfNationalDelegation.getLeaveDate());
		esfNationalDelegationImpl.setReturnDate(esfNationalDelegation.getReturnDate());
		esfNationalDelegationImpl.setEsfMatchId(esfNationalDelegation.getEsfMatchId());
		esfNationalDelegationImpl.setEsfSportTypeId(esfNationalDelegation.getEsfSportTypeId());
		esfNationalDelegationImpl.setEsfGunId1(esfNationalDelegation.getEsfGunId1());
		esfNationalDelegationImpl.setEsfGunId2(esfNationalDelegation.getEsfGunId2());
		esfNationalDelegationImpl.setEsfNationalDelgationId(esfNationalDelegation.getEsfNationalDelgationId());
		esfNationalDelegationImpl.setEsfPartecipantTypeId(esfNationalDelegation.getEsfPartecipantTypeId());

		return esfNationalDelegationImpl;
	}

	/**
	 * Returns the e s f national delegation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f national delegation
	 * @return the e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNationalDelegationException, SystemException {
		ESFNationalDelegation esfNationalDelegation = fetchByPrimaryKey(primaryKey);

		if (esfNationalDelegation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNationalDelegationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfNationalDelegation;
	}

	/**
	 * Returns the e s f national delegation with the primary key or throws a {@link it.ethica.esf.NoSuchNationalDelegationException} if it could not be found.
	 *
	 * @param esfNationalDelgationId the primary key of the e s f national delegation
	 * @return the e s f national delegation
	 * @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation findByPrimaryKey(long esfNationalDelgationId)
		throws NoSuchNationalDelegationException, SystemException {
		return findByPrimaryKey((Serializable)esfNationalDelgationId);
	}

	/**
	 * Returns the e s f national delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f national delegation
	 * @return the e s f national delegation, or <code>null</code> if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFNationalDelegation esfNationalDelegation = (ESFNationalDelegation)EntityCacheUtil.getResult(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
				ESFNationalDelegationImpl.class, primaryKey);

		if (esfNationalDelegation == _nullESFNationalDelegation) {
			return null;
		}

		if (esfNationalDelegation == null) {
			Session session = null;

			try {
				session = openSession();

				esfNationalDelegation = (ESFNationalDelegation)session.get(ESFNationalDelegationImpl.class,
						primaryKey);

				if (esfNationalDelegation != null) {
					cacheResult(esfNationalDelegation);
				}
				else {
					EntityCacheUtil.putResult(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
						ESFNationalDelegationImpl.class, primaryKey,
						_nullESFNationalDelegation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFNationalDelegationModelImpl.ENTITY_CACHE_ENABLED,
					ESFNationalDelegationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfNationalDelegation;
	}

	/**
	 * Returns the e s f national delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfNationalDelgationId the primary key of the e s f national delegation
	 * @return the e s f national delegation, or <code>null</code> if a e s f national delegation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalDelegation fetchByPrimaryKey(long esfNationalDelgationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfNationalDelgationId);
	}

	/**
	 * Returns all the e s f national delegations.
	 *
	 * @return the e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @return the range of e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f national delegations
	 * @param end the upper bound of the range of e s f national delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f national delegations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalDelegation> findAll(int start, int end,
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

		List<ESFNationalDelegation> list = (List<ESFNationalDelegation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFNATIONALDELEGATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFNATIONALDELEGATION;

				if (pagination) {
					sql = sql.concat(ESFNationalDelegationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalDelegation>(list);
				}
				else {
					list = (List<ESFNationalDelegation>)QueryUtil.list(q,
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
	 * Removes all the e s f national delegations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFNationalDelegation esfNationalDelegation : findAll()) {
			remove(esfNationalDelegation);
		}
	}

	/**
	 * Returns the number of e s f national delegations.
	 *
	 * @return the number of e s f national delegations
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

				Query q = session.createQuery(_SQL_COUNT_ESFNATIONALDELEGATION);

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
	 * Initializes the e s f national delegation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFNationalDelegation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFNationalDelegation>> listenersList = new ArrayList<ModelListener<ESFNationalDelegation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFNationalDelegation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFNationalDelegationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFNATIONALDELEGATION = "SELECT esfNationalDelegation FROM ESFNationalDelegation esfNationalDelegation";
	private static final String _SQL_SELECT_ESFNATIONALDELEGATION_WHERE = "SELECT esfNationalDelegation FROM ESFNationalDelegation esfNationalDelegation WHERE ";
	private static final String _SQL_COUNT_ESFNATIONALDELEGATION = "SELECT COUNT(esfNationalDelegation) FROM ESFNationalDelegation esfNationalDelegation";
	private static final String _SQL_COUNT_ESFNATIONALDELEGATION_WHERE = "SELECT COUNT(esfNationalDelegation) FROM ESFNationalDelegation esfNationalDelegation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfNationalDelegation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFNationalDelegation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFNationalDelegation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFNationalDelegationPersistenceImpl.class);
	private static ESFNationalDelegation _nullESFNationalDelegation = new ESFNationalDelegationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFNationalDelegation> toCacheModel() {
				return _nullESFNationalDelegationCacheModel;
			}
		};

	private static CacheModel<ESFNationalDelegation> _nullESFNationalDelegationCacheModel =
		new CacheModel<ESFNationalDelegation>() {
			@Override
			public ESFNationalDelegation toEntityModel() {
				return _nullESFNationalDelegation;
			}
		};
}