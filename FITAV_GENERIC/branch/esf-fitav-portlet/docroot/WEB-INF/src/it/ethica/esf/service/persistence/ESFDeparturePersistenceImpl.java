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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchDepartureException;
import it.ethica.esf.model.ESFDeparture;
import it.ethica.esf.model.impl.ESFDepartureImpl;
import it.ethica.esf.model.impl.ESFDepartureModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f departure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDeparturePersistence
 * @see ESFDepartureUtil
 * @generated
 */
public class ESFDeparturePersistenceImpl extends BasePersistenceImpl<ESFDeparture>
	implements ESFDeparturePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFDepartureUtil} to access the e s f departure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFDepartureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesfMatch",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH =
		new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesfMatch",
			new String[] { Long.class.getName() },
			ESFDepartureModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCH = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByesfMatch",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f departures where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatch(long esfMatchId)
		throws SystemException {
		return findByesfMatch(esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f departures where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @return the range of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatch(long esfMatchId, int start, int end)
		throws SystemException {
		return findByesfMatch(esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f departures where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatch(long esfMatchId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFDeparture> list = (List<ESFDeparture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDeparture esfDeparture : list) {
				if ((esfMatchId != esfDeparture.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFDEPARTURE_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDepartureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDeparture>(list);
				}
				else {
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f departure in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findByesfMatch_First(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchByesfMatch_First(esfMatchId,
				orderByComparator);

		if (esfDeparture != null) {
			return esfDeparture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartureException(msg.toString());
	}

	/**
	 * Returns the first e s f departure in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchByesfMatch_First(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDeparture> list = findByesfMatch(esfMatchId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f departure in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findByesfMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchByesfMatch_Last(esfMatchId,
				orderByComparator);

		if (esfDeparture != null) {
			return esfDeparture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartureException(msg.toString());
	}

	/**
	 * Returns the last e s f departure in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchByesfMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByesfMatch(esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFDeparture> list = findByesfMatch(esfMatchId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f departures before and after the current e s f departure in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfDepartureId the primary key of the current e s f departure
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture[] findByesfMatch_PrevAndNext(long esfDepartureId,
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = findByPrimaryKey(esfDepartureId);

		Session session = null;

		try {
			session = openSession();

			ESFDeparture[] array = new ESFDepartureImpl[3];

			array[0] = getByesfMatch_PrevAndNext(session, esfDeparture,
					esfMatchId, orderByComparator, true);

			array[1] = esfDeparture;

			array[2] = getByesfMatch_PrevAndNext(session, esfDeparture,
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

	protected ESFDeparture getByesfMatch_PrevAndNext(Session session,
		ESFDeparture esfDeparture, long esfMatchId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDEPARTURE_WHERE);

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
			query.append(ESFDepartureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDeparture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDeparture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f departures where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfMatch(long esfMatchId) throws SystemException {
		for (ESFDeparture esfDeparture : findByesfMatch(esfMatchId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDeparture);
		}
	}

	/**
	 * Returns the number of e s f departures where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f departures
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

			query.append(_SQL_COUNT_ESFDEPARTURE_WHERE);

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

	private static final String _FINDER_COLUMN_ESFMATCH_ESFMATCHID_2 = "esfDeparture.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycode",
			new String[] { String.class.getName() },
			ESFDepartureModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f departures where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findBycode(String code) throws SystemException {
		return findBycode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f departures where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @return the range of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findBycode(String code, int start, int end)
		throws SystemException {
		return findBycode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f departures where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findBycode(String code, int start, int end,
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

		List<ESFDeparture> list = (List<ESFDeparture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDeparture esfDeparture : list) {
				if (!Validator.equals(code, esfDeparture.getCode())) {
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

			query.append(_SQL_SELECT_ESFDEPARTURE_WHERE);

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
				query.append(ESFDepartureModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDeparture>(list);
				}
				else {
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f departure in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findBycode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchBycode_First(code, orderByComparator);

		if (esfDeparture != null) {
			return esfDeparture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartureException(msg.toString());
	}

	/**
	 * Returns the first e s f departure in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchBycode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDeparture> list = findBycode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f departure in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findBycode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchBycode_Last(code, orderByComparator);

		if (esfDeparture != null) {
			return esfDeparture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartureException(msg.toString());
	}

	/**
	 * Returns the last e s f departure in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchBycode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycode(code);

		if (count == 0) {
			return null;
		}

		List<ESFDeparture> list = findBycode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f departures before and after the current e s f departure in the ordered set where code = &#63;.
	 *
	 * @param esfDepartureId the primary key of the current e s f departure
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture[] findBycode_PrevAndNext(long esfDepartureId,
		String code, OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = findByPrimaryKey(esfDepartureId);

		Session session = null;

		try {
			session = openSession();

			ESFDeparture[] array = new ESFDepartureImpl[3];

			array[0] = getBycode_PrevAndNext(session, esfDeparture, code,
					orderByComparator, true);

			array[1] = esfDeparture;

			array[2] = getBycode_PrevAndNext(session, esfDeparture, code,
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

	protected ESFDeparture getBycode_PrevAndNext(Session session,
		ESFDeparture esfDeparture, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDEPARTURE_WHERE);

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
			query.append(ESFDepartureModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfDeparture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDeparture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f departures where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycode(String code) throws SystemException {
		for (ESFDeparture esfDeparture : findBycode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfDeparture);
		}
	}

	/**
	 * Returns the number of e s f departures where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFDEPARTURE_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfDeparture.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfDeparture.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfDeparture.code IS NULL OR esfDeparture.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_C_L_L_C_D =
		new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByesfMatchId_C_L_L_C_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_C_L_L_C_D =
		new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByesfMatchId_C_L_L_C_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			ESFDepartureModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFDepartureModelImpl.CODE_COLUMN_BITMASK |
			ESFDepartureModelImpl.LEAVEDATE_COLUMN_BITMASK |
			ESFDepartureModelImpl.LEAVEHOUR_COLUMN_BITMASK |
			ESFDepartureModelImpl.COMPANYNAME_COLUMN_BITMASK |
			ESFDepartureModelImpl.DEPARTUREFROM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_C_L_L_C_D = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByesfMatchId_C_L_L_C_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @return the matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatchId_C_L_L_C_D(long esfMatchId,
		String code, Date leaveDate, String leaveHour, String companyName,
		String departureFrom) throws SystemException {
		return findByesfMatchId_C_L_L_C_D(esfMatchId, code, leaveDate,
			leaveHour, companyName, departureFrom, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @return the range of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatchId_C_L_L_C_D(long esfMatchId,
		String code, Date leaveDate, String leaveHour, String companyName,
		String departureFrom, int start, int end) throws SystemException {
		return findByesfMatchId_C_L_L_C_D(esfMatchId, code, leaveDate,
			leaveHour, companyName, departureFrom, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatchId_C_L_L_C_D(long esfMatchId,
		String code, Date leaveDate, String leaveHour, String companyName,
		String departureFrom, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_C_L_L_C_D;
			finderArgs = new Object[] {
					esfMatchId, code, leaveDate, leaveHour, companyName,
					departureFrom
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_C_L_L_C_D;
			finderArgs = new Object[] {
					esfMatchId, code, leaveDate, leaveHour, companyName,
					departureFrom,
					
					start, end, orderByComparator
				};
		}

		List<ESFDeparture> list = (List<ESFDeparture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDeparture esfDeparture : list) {
				if ((esfMatchId != esfDeparture.getEsfMatchId()) ||
						!Validator.equals(code, esfDeparture.getCode()) ||
						!Validator.equals(leaveDate, esfDeparture.getLeaveDate()) ||
						!Validator.equals(leaveHour, esfDeparture.getLeaveHour()) ||
						!Validator.equals(companyName,
							esfDeparture.getCompanyName()) ||
						!Validator.equals(departureFrom,
							esfDeparture.getDepartureFrom())) {
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

			query.append(_SQL_SELECT_ESFDEPARTURE_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_ESFMATCHID_2);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_2);
			}

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEDATE_2);
			}

			boolean bindLeaveHour = false;

			if (leaveHour == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_1);
			}
			else if (leaveHour.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_3);
			}
			else {
				bindLeaveHour = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_2);
			}

			boolean bindCompanyName = false;

			if (companyName == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_1);
			}
			else if (companyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_3);
			}
			else {
				bindCompanyName = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_2);
			}

			boolean bindDepartureFrom = false;

			if (departureFrom == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_1);
			}
			else if (departureFrom.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_3);
			}
			else {
				bindDepartureFrom = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDepartureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (bindCode) {
					qPos.add(code);
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

				if (bindDepartureFrom) {
					qPos.add(departureFrom);
				}

				if (!pagination) {
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDeparture>(list);
				}
				else {
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findByesfMatchId_C_L_L_C_D_First(long esfMatchId,
		String code, Date leaveDate, String leaveHour, String companyName,
		String departureFrom, OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchByesfMatchId_C_L_L_C_D_First(esfMatchId,
				code, leaveDate, leaveHour, companyName, departureFrom,
				orderByComparator);

		if (esfDeparture != null) {
			return esfDeparture;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", code=");
		msg.append(code);

		msg.append(", leaveDate=");
		msg.append(leaveDate);

		msg.append(", leaveHour=");
		msg.append(leaveHour);

		msg.append(", companyName=");
		msg.append(companyName);

		msg.append(", departureFrom=");
		msg.append(departureFrom);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartureException(msg.toString());
	}

	/**
	 * Returns the first e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchByesfMatchId_C_L_L_C_D_First(long esfMatchId,
		String code, Date leaveDate, String leaveHour, String companyName,
		String departureFrom, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFDeparture> list = findByesfMatchId_C_L_L_C_D(esfMatchId, code,
				leaveDate, leaveHour, companyName, departureFrom, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findByesfMatchId_C_L_L_C_D_Last(long esfMatchId,
		String code, Date leaveDate, String leaveHour, String companyName,
		String departureFrom, OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchByesfMatchId_C_L_L_C_D_Last(esfMatchId,
				code, leaveDate, leaveHour, companyName, departureFrom,
				orderByComparator);

		if (esfDeparture != null) {
			return esfDeparture;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", code=");
		msg.append(code);

		msg.append(", leaveDate=");
		msg.append(leaveDate);

		msg.append(", leaveHour=");
		msg.append(leaveHour);

		msg.append(", companyName=");
		msg.append(companyName);

		msg.append(", departureFrom=");
		msg.append(departureFrom);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartureException(msg.toString());
	}

	/**
	 * Returns the last e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchByesfMatchId_C_L_L_C_D_Last(long esfMatchId,
		String code, Date leaveDate, String leaveHour, String companyName,
		String departureFrom, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByesfMatchId_C_L_L_C_D(esfMatchId, code, leaveDate,
				leaveHour, companyName, departureFrom);

		if (count == 0) {
			return null;
		}

		List<ESFDeparture> list = findByesfMatchId_C_L_L_C_D(esfMatchId, code,
				leaveDate, leaveHour, companyName, departureFrom, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f departures before and after the current e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * @param esfDepartureId the primary key of the current e s f departure
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture[] findByesfMatchId_C_L_L_C_D_PrevAndNext(
		long esfDepartureId, long esfMatchId, String code, Date leaveDate,
		String leaveHour, String companyName, String departureFrom,
		OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = findByPrimaryKey(esfDepartureId);

		Session session = null;

		try {
			session = openSession();

			ESFDeparture[] array = new ESFDepartureImpl[3];

			array[0] = getByesfMatchId_C_L_L_C_D_PrevAndNext(session,
					esfDeparture, esfMatchId, code, leaveDate, leaveHour,
					companyName, departureFrom, orderByComparator, true);

			array[1] = esfDeparture;

			array[2] = getByesfMatchId_C_L_L_C_D_PrevAndNext(session,
					esfDeparture, esfMatchId, code, leaveDate, leaveHour,
					companyName, departureFrom, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFDeparture getByesfMatchId_C_L_L_C_D_PrevAndNext(
		Session session, ESFDeparture esfDeparture, long esfMatchId,
		String code, Date leaveDate, String leaveHour, String companyName,
		String departureFrom, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDEPARTURE_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_ESFMATCHID_2);

		boolean bindCode = false;

		if (code == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_1);
		}
		else if (code.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_3);
		}
		else {
			bindCode = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_2);
		}

		boolean bindLeaveDate = false;

		if (leaveDate == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEDATE_1);
		}
		else {
			bindLeaveDate = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEDATE_2);
		}

		boolean bindLeaveHour = false;

		if (leaveHour == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_1);
		}
		else if (leaveHour.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_3);
		}
		else {
			bindLeaveHour = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_2);
		}

		boolean bindCompanyName = false;

		if (companyName == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_1);
		}
		else if (companyName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_3);
		}
		else {
			bindCompanyName = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_2);
		}

		boolean bindDepartureFrom = false;

		if (departureFrom == null) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_1);
		}
		else if (departureFrom.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_3);
		}
		else {
			bindDepartureFrom = true;

			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_2);
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
			query.append(ESFDepartureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (bindCode) {
			qPos.add(code);
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

		if (bindDepartureFrom) {
			qPos.add(departureFrom);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDeparture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDeparture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfMatchId_C_L_L_C_D(long esfMatchId, String code,
		Date leaveDate, String leaveHour, String companyName,
		String departureFrom) throws SystemException {
		for (ESFDeparture esfDeparture : findByesfMatchId_C_L_L_C_D(
				esfMatchId, code, leaveDate, leaveHour, companyName,
				departureFrom, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDeparture);
		}
	}

	/**
	 * Returns the number of e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param code the code
	 * @param leaveDate the leave date
	 * @param leaveHour the leave hour
	 * @param companyName the company name
	 * @param departureFrom the departure from
	 * @return the number of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfMatchId_C_L_L_C_D(long esfMatchId, String code,
		Date leaveDate, String leaveHour, String companyName,
		String departureFrom) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID_C_L_L_C_D;

		Object[] finderArgs = new Object[] {
				esfMatchId, code, leaveDate, leaveHour, companyName,
				departureFrom
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_ESFDEPARTURE_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_ESFMATCHID_2);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_2);
			}

			boolean bindLeaveDate = false;

			if (leaveDate == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEDATE_1);
			}
			else {
				bindLeaveDate = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEDATE_2);
			}

			boolean bindLeaveHour = false;

			if (leaveHour == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_1);
			}
			else if (leaveHour.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_3);
			}
			else {
				bindLeaveHour = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_2);
			}

			boolean bindCompanyName = false;

			if (companyName == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_1);
			}
			else if (companyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_3);
			}
			else {
				bindCompanyName = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_2);
			}

			boolean bindDepartureFrom = false;

			if (departureFrom == null) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_1);
			}
			else if (departureFrom.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_3);
			}
			else {
				bindDepartureFrom = true;

				query.append(_FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (bindCode) {
					qPos.add(code);
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

				if (bindDepartureFrom) {
					qPos.add(departureFrom);
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

	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_ESFMATCHID_2 =
		"esfDeparture.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_1 = "esfDeparture.code IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_2 = "esfDeparture.code = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_CODE_3 = "(esfDeparture.code IS NULL OR esfDeparture.code = '') AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEDATE_1 = "esfDeparture.leaveDate IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEDATE_2 = "esfDeparture.leaveDate = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_1 = "esfDeparture.leaveHour IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_2 = "esfDeparture.leaveHour = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_LEAVEHOUR_3 = "(esfDeparture.leaveHour IS NULL OR esfDeparture.leaveHour = '') AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_1 =
		"esfDeparture.companyName IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_2 =
		"esfDeparture.companyName = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_COMPANYNAME_3 =
		"(esfDeparture.companyName IS NULL OR esfDeparture.companyName = '') AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_1 =
		"esfDeparture.departureFrom IS NULL";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_2 =
		"esfDeparture.departureFrom = ?";
	private static final String _FINDER_COLUMN_ESFMATCHID_C_L_L_C_D_DEPARTUREFROM_3 =
		"(esfDeparture.departureFrom IS NULL OR esfDeparture.departureFrom = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHESFUSER =
		new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesfMatchEsfUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER =
		new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, ESFDepartureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesfMatchEsfUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFDepartureModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFDepartureModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHESFUSER = new FinderPath(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByesfMatchEsfUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatchEsfUser(long esfMatchId,
		long esfUserId) throws SystemException {
		return findByesfMatchEsfUser(esfMatchId, esfUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @return the range of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatchEsfUser(long esfMatchId,
		long esfUserId, int start, int end) throws SystemException {
		return findByesfMatchEsfUser(esfMatchId, esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findByesfMatchEsfUser(long esfMatchId,
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

		List<ESFDeparture> list = (List<ESFDeparture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDeparture esfDeparture : list) {
				if ((esfMatchId != esfDeparture.getEsfMatchId()) ||
						(esfUserId != esfDeparture.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFDEPARTURE_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHESFUSER_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHESFUSER_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDepartureModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDeparture>(list);
				}
				else {
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findByesfMatchEsfUser_First(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchByesfMatchEsfUser_First(esfMatchId,
				esfUserId, orderByComparator);

		if (esfDeparture != null) {
			return esfDeparture;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartureException(msg.toString());
	}

	/**
	 * Returns the first e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchByesfMatchEsfUser_First(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFDeparture> list = findByesfMatchEsfUser(esfMatchId, esfUserId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findByesfMatchEsfUser_Last(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchByesfMatchEsfUser_Last(esfMatchId,
				esfUserId, orderByComparator);

		if (esfDeparture != null) {
			return esfDeparture;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartureException(msg.toString());
	}

	/**
	 * Returns the last e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchByesfMatchEsfUser_Last(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByesfMatchEsfUser(esfMatchId, esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFDeparture> list = findByesfMatchEsfUser(esfMatchId, esfUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f departures before and after the current e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfDepartureId the primary key of the current e s f departure
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture[] findByesfMatchEsfUser_PrevAndNext(
		long esfDepartureId, long esfMatchId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = findByPrimaryKey(esfDepartureId);

		Session session = null;

		try {
			session = openSession();

			ESFDeparture[] array = new ESFDepartureImpl[3];

			array[0] = getByesfMatchEsfUser_PrevAndNext(session, esfDeparture,
					esfMatchId, esfUserId, orderByComparator, true);

			array[1] = esfDeparture;

			array[2] = getByesfMatchEsfUser_PrevAndNext(session, esfDeparture,
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

	protected ESFDeparture getByesfMatchEsfUser_PrevAndNext(Session session,
		ESFDeparture esfDeparture, long esfMatchId, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDEPARTURE_WHERE);

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
			query.append(ESFDepartureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDeparture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDeparture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f departures where esfMatchId = &#63; and esfUserId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws SystemException {
		for (ESFDeparture esfDeparture : findByesfMatchEsfUser(esfMatchId,
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDeparture);
		}
	}

	/**
	 * Returns the number of e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f departures
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

			query.append(_SQL_COUNT_ESFDEPARTURE_WHERE);

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

	private static final String _FINDER_COLUMN_ESFMATCHESFUSER_ESFMATCHID_2 = "esfDeparture.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHESFUSER_ESFUSERID_2 = "esfDeparture.esfUserId = ?";

	public ESFDeparturePersistenceImpl() {
		setModelClass(ESFDeparture.class);
	}

	/**
	 * Caches the e s f departure in the entity cache if it is enabled.
	 *
	 * @param esfDeparture the e s f departure
	 */
	@Override
	public void cacheResult(ESFDeparture esfDeparture) {
		EntityCacheUtil.putResult(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureImpl.class, esfDeparture.getPrimaryKey(), esfDeparture);

		esfDeparture.resetOriginalValues();
	}

	/**
	 * Caches the e s f departures in the entity cache if it is enabled.
	 *
	 * @param esfDepartures the e s f departures
	 */
	@Override
	public void cacheResult(List<ESFDeparture> esfDepartures) {
		for (ESFDeparture esfDeparture : esfDepartures) {
			if (EntityCacheUtil.getResult(
						ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
						ESFDepartureImpl.class, esfDeparture.getPrimaryKey()) == null) {
				cacheResult(esfDeparture);
			}
			else {
				esfDeparture.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f departures.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFDepartureImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFDepartureImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f departure.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFDeparture esfDeparture) {
		EntityCacheUtil.removeResult(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureImpl.class, esfDeparture.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFDeparture> esfDepartures) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFDeparture esfDeparture : esfDepartures) {
			EntityCacheUtil.removeResult(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
				ESFDepartureImpl.class, esfDeparture.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f departure with the primary key. Does not add the e s f departure to the database.
	 *
	 * @param esfDepartureId the primary key for the new e s f departure
	 * @return the new e s f departure
	 */
	@Override
	public ESFDeparture create(long esfDepartureId) {
		ESFDeparture esfDeparture = new ESFDepartureImpl();

		esfDeparture.setNew(true);
		esfDeparture.setPrimaryKey(esfDepartureId);

		return esfDeparture;
	}

	/**
	 * Removes the e s f departure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfDepartureId the primary key of the e s f departure
	 * @return the e s f departure that was removed
	 * @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture remove(long esfDepartureId)
		throws NoSuchDepartureException, SystemException {
		return remove((Serializable)esfDepartureId);
	}

	/**
	 * Removes the e s f departure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f departure
	 * @return the e s f departure that was removed
	 * @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture remove(Serializable primaryKey)
		throws NoSuchDepartureException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFDeparture esfDeparture = (ESFDeparture)session.get(ESFDepartureImpl.class,
					primaryKey);

			if (esfDeparture == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfDeparture);
		}
		catch (NoSuchDepartureException nsee) {
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
	protected ESFDeparture removeImpl(ESFDeparture esfDeparture)
		throws SystemException {
		esfDeparture = toUnwrappedModel(esfDeparture);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfDeparture)) {
				esfDeparture = (ESFDeparture)session.get(ESFDepartureImpl.class,
						esfDeparture.getPrimaryKeyObj());
			}

			if (esfDeparture != null) {
				session.delete(esfDeparture);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfDeparture != null) {
			clearCache(esfDeparture);
		}

		return esfDeparture;
	}

	@Override
	public ESFDeparture updateImpl(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws SystemException {
		esfDeparture = toUnwrappedModel(esfDeparture);

		boolean isNew = esfDeparture.isNew();

		ESFDepartureModelImpl esfDepartureModelImpl = (ESFDepartureModelImpl)esfDeparture;

		Session session = null;

		try {
			session = openSession();

			if (esfDeparture.isNew()) {
				session.save(esfDeparture);

				esfDeparture.setNew(false);
			}
			else {
				session.merge(esfDeparture);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFDepartureModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfDepartureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDepartureModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);

				args = new Object[] { esfDepartureModelImpl.getEsfMatchId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);
			}

			if ((esfDepartureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDepartureModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esfDepartureModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}

			if ((esfDepartureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_C_L_L_C_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDepartureModelImpl.getOriginalEsfMatchId(),
						esfDepartureModelImpl.getOriginalCode(),
						esfDepartureModelImpl.getOriginalLeaveDate(),
						esfDepartureModelImpl.getOriginalLeaveHour(),
						esfDepartureModelImpl.getOriginalCompanyName(),
						esfDepartureModelImpl.getOriginalDepartureFrom()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_C_L_L_C_D,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_C_L_L_C_D,
					args);

				args = new Object[] {
						esfDepartureModelImpl.getEsfMatchId(),
						esfDepartureModelImpl.getCode(),
						esfDepartureModelImpl.getLeaveDate(),
						esfDepartureModelImpl.getLeaveHour(),
						esfDepartureModelImpl.getCompanyName(),
						esfDepartureModelImpl.getDepartureFrom()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_C_L_L_C_D,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_C_L_L_C_D,
					args);
			}

			if ((esfDepartureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDepartureModelImpl.getOriginalEsfMatchId(),
						esfDepartureModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHESFUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER,
					args);

				args = new Object[] {
						esfDepartureModelImpl.getEsfMatchId(),
						esfDepartureModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHESFUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHESFUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
			ESFDepartureImpl.class, esfDeparture.getPrimaryKey(), esfDeparture);

		return esfDeparture;
	}

	protected ESFDeparture toUnwrappedModel(ESFDeparture esfDeparture) {
		if (esfDeparture instanceof ESFDepartureImpl) {
			return esfDeparture;
		}

		ESFDepartureImpl esfDepartureImpl = new ESFDepartureImpl();

		esfDepartureImpl.setNew(esfDeparture.isNew());
		esfDepartureImpl.setPrimaryKey(esfDeparture.getPrimaryKey());

		esfDepartureImpl.setEsfDepartureId(esfDeparture.getEsfDepartureId());
		esfDepartureImpl.setGroupId(esfDeparture.getGroupId());
		esfDepartureImpl.setCompanyId(esfDeparture.getCompanyId());
		esfDepartureImpl.setUserId(esfDeparture.getUserId());
		esfDepartureImpl.setUserName(esfDeparture.getUserName());
		esfDepartureImpl.setCreateDate(esfDeparture.getCreateDate());
		esfDepartureImpl.setModifiedDate(esfDeparture.getModifiedDate());
		esfDepartureImpl.setLeaveDate(esfDeparture.getLeaveDate());
		esfDepartureImpl.setLeaveHour(esfDeparture.getLeaveHour());
		esfDepartureImpl.setArriveDate(esfDeparture.getArriveDate());
		esfDepartureImpl.setArriveHour(esfDeparture.getArriveHour());
		esfDepartureImpl.setCode(esfDeparture.getCode());
		esfDepartureImpl.setCompanyName(esfDeparture.getCompanyName());
		esfDepartureImpl.setDepartureFrom(esfDeparture.getDepartureFrom());
		esfDepartureImpl.setArrivalTo(esfDeparture.getArrivalTo());
		esfDepartureImpl.setEsfMatchId(esfDeparture.getEsfMatchId());
		esfDepartureImpl.setEsfUserId(esfDeparture.getEsfUserId());
		esfDepartureImpl.setIsReturn(esfDeparture.isIsReturn());
		esfDepartureImpl.setMeetingPlace(esfDeparture.getMeetingPlace());
		esfDepartureImpl.setTypeTravel(esfDeparture.getTypeTravel());
		esfDepartureImpl.setStopoverId(esfDeparture.getStopoverId());

		return esfDepartureImpl;
	}

	/**
	 * Returns the e s f departure with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f departure
	 * @return the e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDepartureException, SystemException {
		ESFDeparture esfDeparture = fetchByPrimaryKey(primaryKey);

		if (esfDeparture == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDepartureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfDeparture;
	}

	/**
	 * Returns the e s f departure with the primary key or throws a {@link it.ethica.esf.NoSuchDepartureException} if it could not be found.
	 *
	 * @param esfDepartureId the primary key of the e s f departure
	 * @return the e s f departure
	 * @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture findByPrimaryKey(long esfDepartureId)
		throws NoSuchDepartureException, SystemException {
		return findByPrimaryKey((Serializable)esfDepartureId);
	}

	/**
	 * Returns the e s f departure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f departure
	 * @return the e s f departure, or <code>null</code> if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFDeparture esfDeparture = (ESFDeparture)EntityCacheUtil.getResult(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
				ESFDepartureImpl.class, primaryKey);

		if (esfDeparture == _nullESFDeparture) {
			return null;
		}

		if (esfDeparture == null) {
			Session session = null;

			try {
				session = openSession();

				esfDeparture = (ESFDeparture)session.get(ESFDepartureImpl.class,
						primaryKey);

				if (esfDeparture != null) {
					cacheResult(esfDeparture);
				}
				else {
					EntityCacheUtil.putResult(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
						ESFDepartureImpl.class, primaryKey, _nullESFDeparture);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFDepartureModelImpl.ENTITY_CACHE_ENABLED,
					ESFDepartureImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfDeparture;
	}

	/**
	 * Returns the e s f departure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfDepartureId the primary key of the e s f departure
	 * @return the e s f departure, or <code>null</code> if a e s f departure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDeparture fetchByPrimaryKey(long esfDepartureId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfDepartureId);
	}

	/**
	 * Returns all the e s f departures.
	 *
	 * @return the e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f departures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @return the range of e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f departures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f departures
	 * @param end the upper bound of the range of e s f departures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f departures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDeparture> findAll(int start, int end,
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

		List<ESFDeparture> list = (List<ESFDeparture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFDEPARTURE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFDEPARTURE;

				if (pagination) {
					sql = sql.concat(ESFDepartureModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDeparture>(list);
				}
				else {
					list = (List<ESFDeparture>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f departures from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFDeparture esfDeparture : findAll()) {
			remove(esfDeparture);
		}
	}

	/**
	 * Returns the number of e s f departures.
	 *
	 * @return the number of e s f departures
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

				Query q = session.createQuery(_SQL_COUNT_ESFDEPARTURE);

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
	 * Initializes the e s f departure persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFDeparture")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFDeparture>> listenersList = new ArrayList<ModelListener<ESFDeparture>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFDeparture>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFDepartureImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFDEPARTURE = "SELECT esfDeparture FROM ESFDeparture esfDeparture";
	private static final String _SQL_SELECT_ESFDEPARTURE_WHERE = "SELECT esfDeparture FROM ESFDeparture esfDeparture WHERE ";
	private static final String _SQL_COUNT_ESFDEPARTURE = "SELECT COUNT(esfDeparture) FROM ESFDeparture esfDeparture";
	private static final String _SQL_COUNT_ESFDEPARTURE_WHERE = "SELECT COUNT(esfDeparture) FROM ESFDeparture esfDeparture WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfDeparture.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFDeparture exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFDeparture exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFDeparturePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static ESFDeparture _nullESFDeparture = new ESFDepartureImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFDeparture> toCacheModel() {
				return _nullESFDepartureCacheModel;
			}
		};

	private static CacheModel<ESFDeparture> _nullESFDepartureCacheModel = new CacheModel<ESFDeparture>() {
			@Override
			public ESFDeparture toEntityModel() {
				return _nullESFDeparture;
			}
		};
}