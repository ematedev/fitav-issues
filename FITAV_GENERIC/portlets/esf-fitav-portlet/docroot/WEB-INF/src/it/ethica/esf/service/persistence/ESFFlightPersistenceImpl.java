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

import it.ethica.esf.NoSuchFlightException;
import it.ethica.esf.model.ESFFlight;
import it.ethica.esf.model.impl.ESFFlightImpl;
import it.ethica.esf.model.impl.ESFFlightModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the e s f flight service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFlightPersistence
 * @see ESFFlightUtil
 * @generated
 */
public class ESFFlightPersistenceImpl extends BasePersistenceImpl<ESFFlight>
	implements ESFFlightPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFlightUtil} to access the e s f flight persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFlightImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH = new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesfMatch",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH =
		new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesfMatch",
			new String[] { Long.class.getName() },
			ESFFlightModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCH = new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByesfMatch",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f flights where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatch(long esfMatchId)
		throws SystemException {
		return findByesfMatch(esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f flights where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @return the range of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatch(long esfMatchId, int start, int end)
		throws SystemException {
		return findByesfMatch(esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f flights where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatch(long esfMatchId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFFlight> list = (List<ESFFlight>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFlight esfFlight : list) {
				if ((esfMatchId != esfFlight.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFFLIGHT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFlightModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFlight>(list);
				}
				else {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f flight in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByesfMatch_First(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByesfMatch_First(esfMatchId,
				orderByComparator);

		if (esfFlight != null) {
			return esfFlight;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlightException(msg.toString());
	}

	/**
	 * Returns the first e s f flight in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByesfMatch_First(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFlight> list = findByesfMatch(esfMatchId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f flight in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByesfMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByesfMatch_Last(esfMatchId, orderByComparator);

		if (esfFlight != null) {
			return esfFlight;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlightException(msg.toString());
	}

	/**
	 * Returns the last e s f flight in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByesfMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByesfMatch(esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFFlight> list = findByesfMatch(esfMatchId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f flights before and after the current e s f flight in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfFlightId the primary key of the current e s f flight
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight[] findByesfMatch_PrevAndNext(long esfFlightId,
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = findByPrimaryKey(esfFlightId);

		Session session = null;

		try {
			session = openSession();

			ESFFlight[] array = new ESFFlightImpl[3];

			array[0] = getByesfMatch_PrevAndNext(session, esfFlight,
					esfMatchId, orderByComparator, true);

			array[1] = esfFlight;

			array[2] = getByesfMatch_PrevAndNext(session, esfFlight,
					esfMatchId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFlight getByesfMatch_PrevAndNext(Session session,
		ESFFlight esfFlight, long esfMatchId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFLIGHT_WHERE);

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
			query.append(ESFFlightModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFlight);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFlight> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f flights where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfMatch(long esfMatchId) throws SystemException {
		for (ESFFlight esfFlight : findByesfMatch(esfMatchId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFlight);
		}
	}

	/**
	 * Returns the number of e s f flights where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfMatch(long esfMatchId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCH;

		Object[] finderArgs = new Object[] { esfMatchId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFLIGHT_WHERE);

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

	private static final String _FINDER_COLUMN_ESFMATCH_ESFMATCHID_2 = "esfFlight.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FLIGHTCODE =
		new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByflightCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLIGHTCODE =
		new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByflightCode",
			new String[] { String.class.getName() },
			ESFFlightModelImpl.FLIGHTCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FLIGHTCODE = new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByflightCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f flights where flightCode = &#63;.
	 *
	 * @param flightCode the flight code
	 * @return the matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByflightCode(String flightCode)
		throws SystemException {
		return findByflightCode(flightCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f flights where flightCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param flightCode the flight code
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @return the range of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByflightCode(String flightCode, int start,
		int end) throws SystemException {
		return findByflightCode(flightCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f flights where flightCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param flightCode the flight code
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByflightCode(String flightCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLIGHTCODE;
			finderArgs = new Object[] { flightCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FLIGHTCODE;
			finderArgs = new Object[] { flightCode, start, end, orderByComparator };
		}

		List<ESFFlight> list = (List<ESFFlight>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFlight esfFlight : list) {
				if (!Validator.equals(flightCode, esfFlight.getFlightCode())) {
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

			query.append(_SQL_SELECT_ESFFLIGHT_WHERE);

			boolean bindFlightCode = false;

			if (flightCode == null) {
				query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_1);
			}
			else if (flightCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_3);
			}
			else {
				bindFlightCode = true;

				query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFlightModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFlightCode) {
					qPos.add(flightCode);
				}

				if (!pagination) {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFlight>(list);
				}
				else {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f flight in the ordered set where flightCode = &#63;.
	 *
	 * @param flightCode the flight code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByflightCode_First(String flightCode,
		OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByflightCode_First(flightCode,
				orderByComparator);

		if (esfFlight != null) {
			return esfFlight;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("flightCode=");
		msg.append(flightCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlightException(msg.toString());
	}

	/**
	 * Returns the first e s f flight in the ordered set where flightCode = &#63;.
	 *
	 * @param flightCode the flight code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByflightCode_First(String flightCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFlight> list = findByflightCode(flightCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f flight in the ordered set where flightCode = &#63;.
	 *
	 * @param flightCode the flight code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByflightCode_Last(String flightCode,
		OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByflightCode_Last(flightCode,
				orderByComparator);

		if (esfFlight != null) {
			return esfFlight;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("flightCode=");
		msg.append(flightCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlightException(msg.toString());
	}

	/**
	 * Returns the last e s f flight in the ordered set where flightCode = &#63;.
	 *
	 * @param flightCode the flight code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByflightCode_Last(String flightCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByflightCode(flightCode);

		if (count == 0) {
			return null;
		}

		List<ESFFlight> list = findByflightCode(flightCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f flights before and after the current e s f flight in the ordered set where flightCode = &#63;.
	 *
	 * @param esfFlightId the primary key of the current e s f flight
	 * @param flightCode the flight code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight[] findByflightCode_PrevAndNext(long esfFlightId,
		String flightCode, OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = findByPrimaryKey(esfFlightId);

		Session session = null;

		try {
			session = openSession();

			ESFFlight[] array = new ESFFlightImpl[3];

			array[0] = getByflightCode_PrevAndNext(session, esfFlight,
					flightCode, orderByComparator, true);

			array[1] = esfFlight;

			array[2] = getByflightCode_PrevAndNext(session, esfFlight,
					flightCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFlight getByflightCode_PrevAndNext(Session session,
		ESFFlight esfFlight, String flightCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFLIGHT_WHERE);

		boolean bindFlightCode = false;

		if (flightCode == null) {
			query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_1);
		}
		else if (flightCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_3);
		}
		else {
			bindFlightCode = true;

			query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_2);
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
			query.append(ESFFlightModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFlightCode) {
			qPos.add(flightCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFlight);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFlight> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f flights where flightCode = &#63; from the database.
	 *
	 * @param flightCode the flight code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByflightCode(String flightCode) throws SystemException {
		for (ESFFlight esfFlight : findByflightCode(flightCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFlight);
		}
	}

	/**
	 * Returns the number of e s f flights where flightCode = &#63;.
	 *
	 * @param flightCode the flight code
	 * @return the number of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByflightCode(String flightCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FLIGHTCODE;

		Object[] finderArgs = new Object[] { flightCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFLIGHT_WHERE);

			boolean bindFlightCode = false;

			if (flightCode == null) {
				query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_1);
			}
			else if (flightCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_3);
			}
			else {
				bindFlightCode = true;

				query.append(_FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFlightCode) {
					qPos.add(flightCode);
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

	private static final String _FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_1 = "esfFlight.flightCode IS NULL";
	private static final String _FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_2 = "esfFlight.flightCode = ?";
	private static final String _FINDER_COLUMN_FLIGHTCODE_FLIGHTCODE_3 = "(esfFlight.flightCode IS NULL OR esfFlight.flightCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_F_L_L_C_D =
		new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByesfMatchId_F_L_L_C_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_F_L_L_C_D =
		new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByesfMatchId_F_L_L_C_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			ESFFlightModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFFlightModelImpl.FLIGHTCODE_COLUMN_BITMASK |
			ESFFlightModelImpl.LEAVEDATE_COLUMN_BITMASK |
			ESFFlightModelImpl.LEAVEHOUR_COLUMN_BITMASK |
			ESFFlightModelImpl.COMPANYNAME_COLUMN_BITMASK |
			ESFFlightModelImpl.DEPARTUREAIRPORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_F_L_L_C_D = new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByesfMatchId_F_L_L_C_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @return the matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatchId_F_L_L_C_D(long esfMatchId,
		String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport) throws SystemException {
		return findByesfMatchId_F_L_L_C_D(esfMatchId, flightCode, leaveDate,
			leaveHour, companyName, departureAirport, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @return the range of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatchId_F_L_L_C_D(long esfMatchId,
		String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport, int start, int end)
		throws SystemException {
		return findByesfMatchId_F_L_L_C_D(esfMatchId, flightCode, leaveDate,
			leaveHour, companyName, departureAirport, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatchId_F_L_L_C_D(long esfMatchId,
		String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_F_L_L_C_D;
			finderArgs = new Object[] {
					esfMatchId, flightCode, leaveDate, leaveHour, companyName,
					departureAirport
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_F_L_L_C_D;
			finderArgs = new Object[] {
					esfMatchId, flightCode, leaveDate, leaveHour, companyName,
					departureAirport,
					
					start, end, orderByComparator
				};
		}

		List<ESFFlight> list = (List<ESFFlight>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFlight esfFlight : list) {
				if ((esfMatchId != esfFlight.getEsfMatchId()) ||
						!Validator.equals(flightCode, esfFlight.getFlightCode()) ||
						!Validator.equals(leaveDate, esfFlight.getLeaveDate()) ||
						!Validator.equals(leaveHour, esfFlight.getLeaveHour()) ||
						!Validator.equals(companyName,
							esfFlight.getCompanyName()) ||
						!Validator.equals(departureAirport,
							esfFlight.getDepartureAirport())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(8 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_ESFFLIGHT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_ESFMATCHID_2);

			boolean bindFlightCode = false;

			if (flightCode == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_1);
			}
			else if (flightCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_3);
			}
			else {
				bindFlightCode = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_2);
			}

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEDATE_2);
			}

			boolean bindLeaveHour = false;

			if (leaveHour == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_1);
			}
			else if (leaveHour.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_3);
			}
			else {
				bindLeaveHour = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_2);
			}

			boolean bindCompanyName = false;

			if (companyName == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_1);
			}
			else if (companyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_3);
			}
			else {
				bindCompanyName = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_2);
			}

			boolean bindDepartureAirport = false;

			if (departureAirport == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_1);
			}
			else if (departureAirport.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_3);
			}
			else {
				bindDepartureAirport = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFlightModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (bindFlightCode) {
					qPos.add(flightCode);
				}

				if (bindLeaveDate) {
					qPos.add(CalendarUtil.getTimestamp(leaveDate));
				}

				if (bindLeaveHour) {
					qPos.add(leaveHour);
				}

				if (bindCompanyName) {
					qPos.add(companyName);
				}

				if (bindDepartureAirport) {
					qPos.add(departureAirport);
				}

				if (!pagination) {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFlight>(list);
				}
				else {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByesfMatchId_F_L_L_C_D_First(long esfMatchId,
		String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport,
		OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByesfMatchId_F_L_L_C_D_First(esfMatchId,
				flightCode, leaveDate, leaveHour, companyName,
				departureAirport, orderByComparator);

		if (esfFlight != null) {
			return esfFlight;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", flightCode=");
		msg.append(flightCode);

		msg.append(", leaveDate=");
		msg.append(leaveDate);

		msg.append(", leaveHour=");
		msg.append(leaveHour);

		msg.append(", companyName=");
		msg.append(companyName);

		msg.append(", departureAirport=");
		msg.append(departureAirport);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlightException(msg.toString());
	}

	/**
	 * Returns the first e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByesfMatchId_F_L_L_C_D_First(long esfMatchId,
		String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFlight> list = findByesfMatchId_F_L_L_C_D(esfMatchId,
				flightCode, leaveDate, leaveHour, companyName,
				departureAirport, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByesfMatchId_F_L_L_C_D_Last(long esfMatchId,
		String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport,
		OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByesfMatchId_F_L_L_C_D_Last(esfMatchId,
				flightCode, leaveDate, leaveHour, companyName,
				departureAirport, orderByComparator);

		if (esfFlight != null) {
			return esfFlight;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", flightCode=");
		msg.append(flightCode);

		msg.append(", leaveDate=");
		msg.append(leaveDate);

		msg.append(", leaveHour=");
		msg.append(leaveHour);

		msg.append(", companyName=");
		msg.append(companyName);

		msg.append(", departureAirport=");
		msg.append(departureAirport);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlightException(msg.toString());
	}

	/**
	 * Returns the last e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByesfMatchId_F_L_L_C_D_Last(long esfMatchId,
		String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByesfMatchId_F_L_L_C_D(esfMatchId, flightCode,
				leaveDate, leaveHour, companyName, departureAirport);

		if (count == 0) {
			return null;
		}

		List<ESFFlight> list = findByesfMatchId_F_L_L_C_D(esfMatchId,
				flightCode, leaveDate, leaveHour, companyName,
				departureAirport, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f flights before and after the current e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * @param esfFlightId the primary key of the current e s f flight
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight[] findByesfMatchId_F_L_L_C_D_PrevAndNext(
		long esfFlightId, long esfMatchId, String flightCode, Date leaveDate,
		String leaveHour, String companyName, String departureAirport,
		OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = findByPrimaryKey(esfFlightId);

		Session session = null;

		try {
			session = openSession();

			ESFFlight[] array = new ESFFlightImpl[3];

			array[0] = getByesfMatchId_F_L_L_C_D_PrevAndNext(session,
					esfFlight, esfMatchId, flightCode, leaveDate, leaveHour,
					companyName, departureAirport, orderByComparator, true);

			array[1] = esfFlight;

			array[2] = getByesfMatchId_F_L_L_C_D_PrevAndNext(session,
					esfFlight, esfMatchId, flightCode, leaveDate, leaveHour,
					companyName, departureAirport, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFlight getByesfMatchId_F_L_L_C_D_PrevAndNext(Session session,
		ESFFlight esfFlight, long esfMatchId, String flightCode,
		Date leaveDate, String leaveHour, String companyName,
		String departureAirport, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFLIGHT_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_ESFMATCHID_2);

		boolean bindFlightCode = false;

		if (flightCode == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_1);
		}
		else if (flightCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_3);
		}
		else {
			bindFlightCode = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_2);
		}

		boolean bindLeaveDate = false;

		if (leaveDate == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEDATE_1);
		}
		else {
			bindLeaveDate = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEDATE_2);
		}

		boolean bindLeaveHour = false;

		if (leaveHour == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_1);
		}
		else if (leaveHour.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_3);
		}
		else {
			bindLeaveHour = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_2);
		}

		boolean bindCompanyName = false;

		if (companyName == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_1);
		}
		else if (companyName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_3);
		}
		else {
			bindCompanyName = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_2);
		}

		boolean bindDepartureAirport = false;

		if (departureAirport == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_1);
		}
		else if (departureAirport.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_3);
		}
		else {
			bindDepartureAirport = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_2);
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
			query.append(ESFFlightModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (bindFlightCode) {
			qPos.add(flightCode);
		}

		if (bindLeaveDate) {
			qPos.add(CalendarUtil.getTimestamp(leaveDate));
		}

		if (bindLeaveHour) {
			qPos.add(leaveHour);
		}

		if (bindCompanyName) {
			qPos.add(companyName);
		}

		if (bindDepartureAirport) {
			qPos.add(departureAirport);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFlight);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFlight> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfMatchId_F_L_L_C_D(long esfMatchId,
		String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport) throws SystemException {
		for (ESFFlight esfFlight : findByesfMatchId_F_L_L_C_D(esfMatchId,
				flightCode, leaveDate, leaveHour, companyName,
				departureAirport, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFlight);
		}
	}

	/**
	 * Returns the number of e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param flightCode the flight code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureAirport the departure airport
	 * @return the number of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfMatchId_F_L_L_C_D(long esfMatchId, String flightCode,
		Date leaveDate, String leaveHour, String companyName,
		String departureAirport) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID_F_L_L_C_D;

		Object[] finderArgs = new Object[] {
				esfMatchId, flightCode, leaveDate, leaveHour, companyName,
				departureAirport
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_ESFFLIGHT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_ESFMATCHID_2);

			boolean bindFlightCode = false;

			if (flightCode == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_1);
			}
			else if (flightCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_3);
			}
			else {
				bindFlightCode = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_2);
			}

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEDATE_2);
			}

			boolean bindLeaveHour = false;

			if (leaveHour == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_1);
			}
			else if (leaveHour.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_3);
			}
			else {
				bindLeaveHour = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_2);
			}

			boolean bindCompanyName = false;

			if (companyName == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_1);
			}
			else if (companyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_3);
			}
			else {
				bindCompanyName = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_2);
			}

			boolean bindDepartureAirport = false;

			if (departureAirport == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_1);
			}
			else if (departureAirport.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_3);
			}
			else {
				bindDepartureAirport = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (bindFlightCode) {
					qPos.add(flightCode);
				}

				if (bindLeaveDate) {
					qPos.add(CalendarUtil.getTimestamp(leaveDate));
				}

				if (bindLeaveHour) {
					qPos.add(leaveHour);
				}

				if (bindCompanyName) {
					qPos.add(companyName);
				}

				if (bindDepartureAirport) {
					qPos.add(departureAirport);
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

	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_ESFMATCHID_2 =
		"esfFlight.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_1 =
		"esfFlight.flightCode IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_2 =
		"esfFlight.flightCode = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_FLIGHTCODE_3 =
		"(esfFlight.flightCode IS NULL OR esfFlight.flightCode = '') AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEDATE_1 = "esfFlight.leaveDate IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEDATE_2 = "esfFlight.leaveDate = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_1 = "esfFlight.leaveHour IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_2 = "esfFlight.leaveHour = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_LEAVEHOUR_3 = "(esfFlight.leaveHour IS NULL OR esfFlight.leaveHour = '') AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_1 =
		"esfFlight.companyName IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_2 =
		"esfFlight.companyName = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_COMPANYNAME_3 =
		"(esfFlight.companyName IS NULL OR esfFlight.companyName = '') AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_1 =
		"esfFlight.departureAirport IS NULL";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_2 =
		"esfFlight.departureAirport = ?";
	private static final String _FINDER_COLUMN_ESFMATCHID_F_L_L_C_D_DEPARTUREAIRPORT_3 =
		"(esfFlight.departureAirport IS NULL OR esfFlight.departureAirport = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHESFUSER =
		new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesfMatchEsfUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER =
		new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, ESFFlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesfMatchEsfUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFFlightModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFFlightModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHESFUSER = new FinderPath(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByesfMatchEsfUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws SystemException {
		return findByesfMatchEsfUser(esfMatchId, esfUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @return the range of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatchEsfUser(long esfMatchId,
		long esfUserId, int start, int end) throws SystemException {
		return findByesfMatchEsfUser(esfMatchId, esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findByesfMatchEsfUser(long esfMatchId,
		long esfUserId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER;
			finderArgs = new Object[] { esfMatchId, esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHESFUSER;
			finderArgs = new Object[] {
					esfMatchId, esfUserId,
					
					start, end, orderByComparator
				};
		}

		List<ESFFlight> list = (List<ESFFlight>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFlight esfFlight : list) {
				if ((esfMatchId != esfFlight.getEsfMatchId()) ||
						(esfUserId != esfFlight.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFFLIGHT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHESFUSER_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHESFUSER_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFlightModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFlight>(list);
				}
				else {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByesfMatchEsfUser_First(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByesfMatchEsfUser_First(esfMatchId,
				esfUserId, orderByComparator);

		if (esfFlight != null) {
			return esfFlight;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlightException(msg.toString());
	}

	/**
	 * Returns the first e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByesfMatchEsfUser_First(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFFlight> list = findByesfMatchEsfUser(esfMatchId, esfUserId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByesfMatchEsfUser_Last(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByesfMatchEsfUser_Last(esfMatchId,
				esfUserId, orderByComparator);

		if (esfFlight != null) {
			return esfFlight;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlightException(msg.toString());
	}

	/**
	 * Returns the last e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByesfMatchEsfUser_Last(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByesfMatchEsfUser(esfMatchId, esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFFlight> list = findByesfMatchEsfUser(esfMatchId, esfUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f flights before and after the current e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfFlightId the primary key of the current e s f flight
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight[] findByesfMatchEsfUser_PrevAndNext(long esfFlightId,
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = findByPrimaryKey(esfFlightId);

		Session session = null;

		try {
			session = openSession();

			ESFFlight[] array = new ESFFlightImpl[3];

			array[0] = getByesfMatchEsfUser_PrevAndNext(session, esfFlight,
					esfMatchId, esfUserId, orderByComparator, true);

			array[1] = esfFlight;

			array[2] = getByesfMatchEsfUser_PrevAndNext(session, esfFlight,
					esfMatchId, esfUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFlight getByesfMatchEsfUser_PrevAndNext(Session session,
		ESFFlight esfFlight, long esfMatchId, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFLIGHT_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHESFUSER_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMATCHESFUSER_ESFUSERID_2);

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
			query.append(ESFFlightModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFlight);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFlight> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f flights where esfMatchId = &#63; and esfUserId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws SystemException {
		for (ESFFlight esfFlight : findByesfMatchEsfUser(esfMatchId, esfUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFlight);
		}
	}

	/**
	 * Returns the number of e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHESFUSER;

		Object[] finderArgs = new Object[] { esfMatchId, esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFFLIGHT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHESFUSER_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHESFUSER_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

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

	private static final String _FINDER_COLUMN_ESFMATCHESFUSER_ESFMATCHID_2 = "esfFlight.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHESFUSER_ESFUSERID_2 = "esfFlight.esfUserId = ?";

	public ESFFlightPersistenceImpl() {
		setModelClass(ESFFlight.class);
	}

	/**
	 * Caches the e s f flight in the entity cache if it is enabled.
	 *
	 * @param esfFlight the e s f flight
	 */
	@Override
	public void cacheResult(ESFFlight esfFlight) {
		EntityCacheUtil.putResult(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightImpl.class, esfFlight.getPrimaryKey(), esfFlight);

		esfFlight.resetOriginalValues();
	}

	/**
	 * Caches the e s f flights in the entity cache if it is enabled.
	 *
	 * @param esfFlights the e s f flights
	 */
	@Override
	public void cacheResult(List<ESFFlight> esfFlights) {
		for (ESFFlight esfFlight : esfFlights) {
			if (EntityCacheUtil.getResult(
						ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
						ESFFlightImpl.class, esfFlight.getPrimaryKey()) == null) {
				cacheResult(esfFlight);
			}
			else {
				esfFlight.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f flights.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFlightImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFlightImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f flight.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFFlight esfFlight) {
		EntityCacheUtil.removeResult(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightImpl.class, esfFlight.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFFlight> esfFlights) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFFlight esfFlight : esfFlights) {
			EntityCacheUtil.removeResult(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
				ESFFlightImpl.class, esfFlight.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f flight with the primary key. Does not add the e s f flight to the database.
	 *
	 * @param esfFlightId the primary key for the new e s f flight
	 * @return the new e s f flight
	 */
	@Override
	public ESFFlight create(long esfFlightId) {
		ESFFlight esfFlight = new ESFFlightImpl();

		esfFlight.setNew(true);
		esfFlight.setPrimaryKey(esfFlightId);

		return esfFlight;
	}

	/**
	 * Removes the e s f flight with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFlightId the primary key of the e s f flight
	 * @return the e s f flight that was removed
	 * @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight remove(long esfFlightId)
		throws NoSuchFlightException, SystemException {
		return remove((Serializable)esfFlightId);
	}

	/**
	 * Removes the e s f flight with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f flight
	 * @return the e s f flight that was removed
	 * @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight remove(Serializable primaryKey)
		throws NoSuchFlightException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFFlight esfFlight = (ESFFlight)session.get(ESFFlightImpl.class,
					primaryKey);

			if (esfFlight == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlightException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfFlight);
		}
		catch (NoSuchFlightException nsee) {
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
	protected ESFFlight removeImpl(ESFFlight esfFlight)
		throws SystemException {
		esfFlight = toUnwrappedModel(esfFlight);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfFlight)) {
				esfFlight = (ESFFlight)session.get(ESFFlightImpl.class,
						esfFlight.getPrimaryKeyObj());
			}

			if (esfFlight != null) {
				session.delete(esfFlight);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfFlight != null) {
			clearCache(esfFlight);
		}

		return esfFlight;
	}

	@Override
	public ESFFlight updateImpl(it.ethica.esf.model.ESFFlight esfFlight)
		throws SystemException {
		esfFlight = toUnwrappedModel(esfFlight);

		boolean isNew = esfFlight.isNew();

		ESFFlightModelImpl esfFlightModelImpl = (ESFFlightModelImpl)esfFlight;

		Session session = null;

		try {
			session = openSession();

			if (esfFlight.isNew()) {
				session.save(esfFlight);

				esfFlight.setNew(false);
			}
			else {
				session.merge(esfFlight);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFFlightModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFlightModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFlightModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);

				args = new Object[] { esfFlightModelImpl.getEsfMatchId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);
			}

			if ((esfFlightModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLIGHTCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFlightModelImpl.getOriginalFlightCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FLIGHTCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLIGHTCODE,
					args);

				args = new Object[] { esfFlightModelImpl.getFlightCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FLIGHTCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FLIGHTCODE,
					args);
			}

			if ((esfFlightModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_F_L_L_C_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFlightModelImpl.getOriginalEsfMatchId(),
						esfFlightModelImpl.getOriginalFlightCode(),
						esfFlightModelImpl.getOriginalLeaveDate(),
						esfFlightModelImpl.getOriginalLeaveHour(),
						esfFlightModelImpl.getOriginalCompanyName(),
						esfFlightModelImpl.getOriginalDepartureAirport()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_F_L_L_C_D,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_F_L_L_C_D,
					args);

				args = new Object[] {
						esfFlightModelImpl.getEsfMatchId(),
						esfFlightModelImpl.getFlightCode(),
						esfFlightModelImpl.getLeaveDate(),
						esfFlightModelImpl.getLeaveHour(),
						esfFlightModelImpl.getCompanyName(),
						esfFlightModelImpl.getDepartureAirport()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_F_L_L_C_D,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_F_L_L_C_D,
					args);
			}

			if ((esfFlightModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFlightModelImpl.getOriginalEsfMatchId(),
						esfFlightModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHESFUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER,
					args);

				args = new Object[] {
						esfFlightModelImpl.getEsfMatchId(),
						esfFlightModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHESFUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
			ESFFlightImpl.class, esfFlight.getPrimaryKey(), esfFlight);

		return esfFlight;
	}

	protected ESFFlight toUnwrappedModel(ESFFlight esfFlight) {
		if (esfFlight instanceof ESFFlightImpl) {
			return esfFlight;
		}

		ESFFlightImpl esfFlightImpl = new ESFFlightImpl();

		esfFlightImpl.setNew(esfFlight.isNew());
		esfFlightImpl.setPrimaryKey(esfFlight.getPrimaryKey());

		esfFlightImpl.setEsfFlightId(esfFlight.getEsfFlightId());
		esfFlightImpl.setGroupId(esfFlight.getGroupId());
		esfFlightImpl.setCompanyId(esfFlight.getCompanyId());
		esfFlightImpl.setUserId(esfFlight.getUserId());
		esfFlightImpl.setUserName(esfFlight.getUserName());
		esfFlightImpl.setCreateDate(esfFlight.getCreateDate());
		esfFlightImpl.setModifiedDate(esfFlight.getModifiedDate());
		esfFlightImpl.setLeaveDate(esfFlight.getLeaveDate());
		esfFlightImpl.setLeaveHour(esfFlight.getLeaveHour());
		esfFlightImpl.setArriveDate(esfFlight.getArriveDate());
		esfFlightImpl.setArriveHour(esfFlight.getArriveHour());
		esfFlightImpl.setFlightCode(esfFlight.getFlightCode());
		esfFlightImpl.setCompanyName(esfFlight.getCompanyName());
		esfFlightImpl.setDepartureAirport(esfFlight.getDepartureAirport());
		esfFlightImpl.setArrivalAirport(esfFlight.getArrivalAirport());
		esfFlightImpl.setEsfMatchId(esfFlight.getEsfMatchId());
		esfFlightImpl.setEsfUserId(esfFlight.getEsfUserId());

		return esfFlightImpl;
	}

	/**
	 * Returns the e s f flight with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f flight
	 * @return the e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlightException, SystemException {
		ESFFlight esfFlight = fetchByPrimaryKey(primaryKey);

		if (esfFlight == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlightException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfFlight;
	}

	/**
	 * Returns the e s f flight with the primary key or throws a {@link it.ethica.esf.NoSuchFlightException} if it could not be found.
	 *
	 * @param esfFlightId the primary key of the e s f flight
	 * @return the e s f flight
	 * @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight findByPrimaryKey(long esfFlightId)
		throws NoSuchFlightException, SystemException {
		return findByPrimaryKey((Serializable)esfFlightId);
	}

	/**
	 * Returns the e s f flight with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f flight
	 * @return the e s f flight, or <code>null</code> if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFFlight esfFlight = (ESFFlight)EntityCacheUtil.getResult(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
				ESFFlightImpl.class, primaryKey);

		if (esfFlight == _nullESFFlight) {
			return null;
		}

		if (esfFlight == null) {
			Session session = null;

			try {
				session = openSession();

				esfFlight = (ESFFlight)session.get(ESFFlightImpl.class,
						primaryKey);

				if (esfFlight != null) {
					cacheResult(esfFlight);
				}
				else {
					EntityCacheUtil.putResult(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
						ESFFlightImpl.class, primaryKey, _nullESFFlight);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFlightModelImpl.ENTITY_CACHE_ENABLED,
					ESFFlightImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfFlight;
	}

	/**
	 * Returns the e s f flight with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFlightId the primary key of the e s f flight
	 * @return the e s f flight, or <code>null</code> if a e s f flight with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFlight fetchByPrimaryKey(long esfFlightId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFlightId);
	}

	/**
	 * Returns all the e s f flights.
	 *
	 * @return the e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @return the range of e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f flights
	 * @param end the upper bound of the range of e s f flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f flights
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFlight> findAll(int start, int end,
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

		List<ESFFlight> list = (List<ESFFlight>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFLIGHT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFLIGHT;

				if (pagination) {
					sql = sql.concat(ESFFlightModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFlight>(list);
				}
				else {
					list = (List<ESFFlight>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f flights from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFFlight esfFlight : findAll()) {
			remove(esfFlight);
		}
	}

	/**
	 * Returns the number of e s f flights.
	 *
	 * @return the number of e s f flights
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

				Query q = session.createQuery(_SQL_COUNT_ESFFLIGHT);

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
	 * Initializes the e s f flight persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFFlight")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFFlight>> listenersList = new ArrayList<ModelListener<ESFFlight>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFFlight>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFlightImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFLIGHT = "SELECT esfFlight FROM ESFFlight esfFlight";
	private static final String _SQL_SELECT_ESFFLIGHT_WHERE = "SELECT esfFlight FROM ESFFlight esfFlight WHERE ";
	private static final String _SQL_COUNT_ESFFLIGHT = "SELECT COUNT(esfFlight) FROM ESFFlight esfFlight";
	private static final String _SQL_COUNT_ESFFLIGHT_WHERE = "SELECT COUNT(esfFlight) FROM ESFFlight esfFlight WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfFlight.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFFlight exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFFlight exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFlightPersistenceImpl.class);
	private static ESFFlight _nullESFFlight = new ESFFlightImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFFlight> toCacheModel() {
				return _nullESFFlightCacheModel;
			}
		};

	private static CacheModel<ESFFlight> _nullESFFlightCacheModel = new CacheModel<ESFFlight>() {
			@Override
			public ESFFlight toEntityModel() {
				return _nullESFFlight;
			}
		};
}