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

import it.ethica.esf.NoSuchShooterAffiliationChronoException;
import it.ethica.esf.model.ESFShooterAffiliationChrono;
import it.ethica.esf.model.impl.ESFShooterAffiliationChronoImpl;
import it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the e s f shooter affiliation chrono service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterAffiliationChronoPersistence
 * @see ESFShooterAffiliationChronoUtil
 * @generated
 */
public class ESFShooterAffiliationChronoPersistenceImpl
	extends BasePersistenceImpl<ESFShooterAffiliationChrono>
	implements ESFShooterAffiliationChronoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFShooterAffiliationChronoUtil} to access the e s f shooter affiliation chrono persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFShooterAffiliationChronoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDYEAR =
		new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdYear",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDYEAR =
		new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdYear",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ESFShooterAffiliationChronoModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFShooterAffiliationChronoModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDYEAR = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdYear",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63;.
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @return the matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByUserIdYear(long esfuserId,
		int year) throws SystemException {
		return findByUserIdYear(esfuserId, year, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @param start the lower bound of the range of e s f shooter affiliation chronos
	 * @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	 * @return the range of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByUserIdYear(long esfuserId,
		int year, int start, int end) throws SystemException {
		return findByUserIdYear(esfuserId, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @param start the lower bound of the range of e s f shooter affiliation chronos
	 * @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByUserIdYear(long esfuserId,
		int year, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDYEAR;
			finderArgs = new Object[] { esfuserId, year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDYEAR;
			finderArgs = new Object[] {
					esfuserId, year,
					
					start, end, orderByComparator
				};
		}

		List<ESFShooterAffiliationChrono> list = (List<ESFShooterAffiliationChrono>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : list) {
				if ((esfuserId != esfShooterAffiliationChrono.getEsfuserId()) ||
						(year != esfShooterAffiliationChrono.getYear())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

			query.append(_FINDER_COLUMN_USERIDYEAR_ESFUSERID_2);

			query.append(_FINDER_COLUMN_USERIDYEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShooterAffiliationChronoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfuserId);

				qPos.add(year);

				if (!pagination) {
					list = (List<ESFShooterAffiliationChrono>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterAffiliationChrono>(list);
				}
				else {
					list = (List<ESFShooterAffiliationChrono>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono findByUserIdYear_First(long esfuserId,
		int year, OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = fetchByUserIdYear_First(esfuserId,
				year, orderByComparator);

		if (esfShooterAffiliationChrono != null) {
			return esfShooterAffiliationChrono;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfuserId=");
		msg.append(esfuserId);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterAffiliationChronoException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono fetchByUserIdYear_First(long esfuserId,
		int year, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFShooterAffiliationChrono> list = findByUserIdYear(esfuserId,
				year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono findByUserIdYear_Last(long esfuserId,
		int year, OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = fetchByUserIdYear_Last(esfuserId,
				year, orderByComparator);

		if (esfShooterAffiliationChrono != null) {
			return esfShooterAffiliationChrono;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfuserId=");
		msg.append(esfuserId);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterAffiliationChronoException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono fetchByUserIdYear_Last(long esfuserId,
		int year, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdYear(esfuserId, year);

		if (count == 0) {
			return null;
		}

		List<ESFShooterAffiliationChrono> list = findByUserIdYear(esfuserId,
				year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter affiliation chronos before and after the current e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	 *
	 * @param esfShooterAffiliationChronoId the primary key of the current e s f shooter affiliation chrono
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono[] findByUserIdYear_PrevAndNext(
		long esfShooterAffiliationChronoId, long esfuserId, int year,
		OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = findByPrimaryKey(esfShooterAffiliationChronoId);

		Session session = null;

		try {
			session = openSession();

			ESFShooterAffiliationChrono[] array = new ESFShooterAffiliationChronoImpl[3];

			array[0] = getByUserIdYear_PrevAndNext(session,
					esfShooterAffiliationChrono, esfuserId, year,
					orderByComparator, true);

			array[1] = esfShooterAffiliationChrono;

			array[2] = getByUserIdYear_PrevAndNext(session,
					esfShooterAffiliationChrono, esfuserId, year,
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

	protected ESFShooterAffiliationChrono getByUserIdYear_PrevAndNext(
		Session session,
		ESFShooterAffiliationChrono esfShooterAffiliationChrono,
		long esfuserId, int year, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

		query.append(_FINDER_COLUMN_USERIDYEAR_ESFUSERID_2);

		query.append(_FINDER_COLUMN_USERIDYEAR_YEAR_2);

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
			query.append(ESFShooterAffiliationChronoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfuserId);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterAffiliationChrono);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterAffiliationChrono> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63; from the database.
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdYear(long esfuserId, int year)
		throws SystemException {
		for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : findByUserIdYear(
				esfuserId, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterAffiliationChrono);
		}
	}

	/**
	 * Returns the number of e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63;.
	 *
	 * @param esfuserId the esfuser ID
	 * @param year the year
	 * @return the number of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdYear(long esfuserId, int year)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDYEAR;

		Object[] finderArgs = new Object[] { esfuserId, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

			query.append(_FINDER_COLUMN_USERIDYEAR_ESFUSERID_2);

			query.append(_FINDER_COLUMN_USERIDYEAR_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfuserId);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_USERIDYEAR_ESFUSERID_2 = "esfShooterAffiliationChrono.esfuserId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDYEAR_YEAR_2 = "esfShooterAffiliationChrono.year = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CARDYEAR = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCardYear",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDYEAR =
		new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCardYear",
			new String[] { String.class.getName(), Integer.class.getName() },
			ESFShooterAffiliationChronoModelImpl.CARD_COLUMN_BITMASK |
			ESFShooterAffiliationChronoModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARDYEAR = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCardYear",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s f shooter affiliation chronos where card = &#63; and year = &#63;.
	 *
	 * @param card the card
	 * @param year the year
	 * @return the matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByCardYear(String card,
		int year) throws SystemException {
		return findByCardYear(card, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f shooter affiliation chronos where card = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param card the card
	 * @param year the year
	 * @param start the lower bound of the range of e s f shooter affiliation chronos
	 * @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	 * @return the range of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByCardYear(String card,
		int year, int start, int end) throws SystemException {
		return findByCardYear(card, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter affiliation chronos where card = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param card the card
	 * @param year the year
	 * @param start the lower bound of the range of e s f shooter affiliation chronos
	 * @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByCardYear(String card,
		int year, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDYEAR;
			finderArgs = new Object[] { card, year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CARDYEAR;
			finderArgs = new Object[] { card, year, start, end, orderByComparator };
		}

		List<ESFShooterAffiliationChrono> list = (List<ESFShooterAffiliationChrono>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : list) {
				if (!Validator.equals(card,
							esfShooterAffiliationChrono.getCard()) ||
						(year != esfShooterAffiliationChrono.getYear())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

			boolean bindCard = false;

			if (card == null) {
				query.append(_FINDER_COLUMN_CARDYEAR_CARD_1);
			}
			else if (card.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CARDYEAR_CARD_3);
			}
			else {
				bindCard = true;

				query.append(_FINDER_COLUMN_CARDYEAR_CARD_2);
			}

			query.append(_FINDER_COLUMN_CARDYEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShooterAffiliationChronoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCard) {
					qPos.add(card);
				}

				qPos.add(year);

				if (!pagination) {
					list = (List<ESFShooterAffiliationChrono>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterAffiliationChrono>(list);
				}
				else {
					list = (List<ESFShooterAffiliationChrono>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	 *
	 * @param card the card
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono findByCardYear_First(String card,
		int year, OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = fetchByCardYear_First(card,
				year, orderByComparator);

		if (esfShooterAffiliationChrono != null) {
			return esfShooterAffiliationChrono;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("card=");
		msg.append(card);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterAffiliationChronoException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	 *
	 * @param card the card
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono fetchByCardYear_First(String card,
		int year, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFShooterAffiliationChrono> list = findByCardYear(card, year, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	 *
	 * @param card the card
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono findByCardYear_Last(String card,
		int year, OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = fetchByCardYear_Last(card,
				year, orderByComparator);

		if (esfShooterAffiliationChrono != null) {
			return esfShooterAffiliationChrono;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("card=");
		msg.append(card);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterAffiliationChronoException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	 *
	 * @param card the card
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono fetchByCardYear_Last(String card,
		int year, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCardYear(card, year);

		if (count == 0) {
			return null;
		}

		List<ESFShooterAffiliationChrono> list = findByCardYear(card, year,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter affiliation chronos before and after the current e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	 *
	 * @param esfShooterAffiliationChronoId the primary key of the current e s f shooter affiliation chrono
	 * @param card the card
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono[] findByCardYear_PrevAndNext(
		long esfShooterAffiliationChronoId, String card, int year,
		OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = findByPrimaryKey(esfShooterAffiliationChronoId);

		Session session = null;

		try {
			session = openSession();

			ESFShooterAffiliationChrono[] array = new ESFShooterAffiliationChronoImpl[3];

			array[0] = getByCardYear_PrevAndNext(session,
					esfShooterAffiliationChrono, card, year, orderByComparator,
					true);

			array[1] = esfShooterAffiliationChrono;

			array[2] = getByCardYear_PrevAndNext(session,
					esfShooterAffiliationChrono, card, year, orderByComparator,
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

	protected ESFShooterAffiliationChrono getByCardYear_PrevAndNext(
		Session session,
		ESFShooterAffiliationChrono esfShooterAffiliationChrono, String card,
		int year, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

		boolean bindCard = false;

		if (card == null) {
			query.append(_FINDER_COLUMN_CARDYEAR_CARD_1);
		}
		else if (card.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CARDYEAR_CARD_3);
		}
		else {
			bindCard = true;

			query.append(_FINDER_COLUMN_CARDYEAR_CARD_2);
		}

		query.append(_FINDER_COLUMN_CARDYEAR_YEAR_2);

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
			query.append(ESFShooterAffiliationChronoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCard) {
			qPos.add(card);
		}

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterAffiliationChrono);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterAffiliationChrono> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter affiliation chronos where card = &#63; and year = &#63; from the database.
	 *
	 * @param card the card
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCardYear(String card, int year)
		throws SystemException {
		for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : findByCardYear(
				card, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterAffiliationChrono);
		}
	}

	/**
	 * Returns the number of e s f shooter affiliation chronos where card = &#63; and year = &#63;.
	 *
	 * @param card the card
	 * @param year the year
	 * @return the number of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCardYear(String card, int year) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARDYEAR;

		Object[] finderArgs = new Object[] { card, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

			boolean bindCard = false;

			if (card == null) {
				query.append(_FINDER_COLUMN_CARDYEAR_CARD_1);
			}
			else if (card.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CARDYEAR_CARD_3);
			}
			else {
				bindCard = true;

				query.append(_FINDER_COLUMN_CARDYEAR_CARD_2);
			}

			query.append(_FINDER_COLUMN_CARDYEAR_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCard) {
					qPos.add(card);
				}

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_CARDYEAR_CARD_1 = "esfShooterAffiliationChrono.card IS NULL AND ";
	private static final String _FINDER_COLUMN_CARDYEAR_CARD_2 = "esfShooterAffiliationChrono.card = ? AND ";
	private static final String _FINDER_COLUMN_CARDYEAR_CARD_3 = "(esfShooterAffiliationChrono.card IS NULL OR esfShooterAffiliationChrono.card = '') AND ";
	private static final String _FINDER_COLUMN_CARDYEAR_YEAR_2 = "esfShooterAffiliationChrono.year = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDate",
			new String[] { Date.class.getName() },
			ESFShooterAffiliationChronoModelImpl.AFFILIATIONDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATE = new FinderPath(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDate", new String[] { Date.class.getName() });

	/**
	 * Returns all the e s f shooter affiliation chronos where affiliationDate = &#63;.
	 *
	 * @param affiliationDate the affiliation date
	 * @return the matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByDate(Date affiliationDate)
		throws SystemException {
		return findByDate(affiliationDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter affiliation chronos where affiliationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param affiliationDate the affiliation date
	 * @param start the lower bound of the range of e s f shooter affiliation chronos
	 * @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	 * @return the range of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByDate(Date affiliationDate,
		int start, int end) throws SystemException {
		return findByDate(affiliationDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter affiliation chronos where affiliationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param affiliationDate the affiliation date
	 * @param start the lower bound of the range of e s f shooter affiliation chronos
	 * @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findByDate(Date affiliationDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { affiliationDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] {
					affiliationDate,
					
					start, end, orderByComparator
				};
		}

		List<ESFShooterAffiliationChrono> list = (List<ESFShooterAffiliationChrono>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : list) {
				if (!Validator.equals(affiliationDate,
							esfShooterAffiliationChrono.getAffiliationDate())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

			boolean bindAffiliationDate = false;

			if (affiliationDate == null) {
				query.append(_FINDER_COLUMN_DATE_AFFILIATIONDATE_1);
			}
			else {
				bindAffiliationDate = true;

				query.append(_FINDER_COLUMN_DATE_AFFILIATIONDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShooterAffiliationChronoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAffiliationDate) {
					qPos.add(CalendarUtil.getTimestamp(affiliationDate));
				}

				if (!pagination) {
					list = (List<ESFShooterAffiliationChrono>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterAffiliationChrono>(list);
				}
				else {
					list = (List<ESFShooterAffiliationChrono>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	 *
	 * @param affiliationDate the affiliation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono findByDate_First(Date affiliationDate,
		OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = fetchByDate_First(affiliationDate,
				orderByComparator);

		if (esfShooterAffiliationChrono != null) {
			return esfShooterAffiliationChrono;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("affiliationDate=");
		msg.append(affiliationDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterAffiliationChronoException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	 *
	 * @param affiliationDate the affiliation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono fetchByDate_First(Date affiliationDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShooterAffiliationChrono> list = findByDate(affiliationDate, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	 *
	 * @param affiliationDate the affiliation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono findByDate_Last(Date affiliationDate,
		OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = fetchByDate_Last(affiliationDate,
				orderByComparator);

		if (esfShooterAffiliationChrono != null) {
			return esfShooterAffiliationChrono;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("affiliationDate=");
		msg.append(affiliationDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterAffiliationChronoException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	 *
	 * @param affiliationDate the affiliation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono fetchByDate_Last(Date affiliationDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDate(affiliationDate);

		if (count == 0) {
			return null;
		}

		List<ESFShooterAffiliationChrono> list = findByDate(affiliationDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter affiliation chronos before and after the current e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	 *
	 * @param esfShooterAffiliationChronoId the primary key of the current e s f shooter affiliation chrono
	 * @param affiliationDate the affiliation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono[] findByDate_PrevAndNext(
		long esfShooterAffiliationChronoId, Date affiliationDate,
		OrderByComparator orderByComparator)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = findByPrimaryKey(esfShooterAffiliationChronoId);

		Session session = null;

		try {
			session = openSession();

			ESFShooterAffiliationChrono[] array = new ESFShooterAffiliationChronoImpl[3];

			array[0] = getByDate_PrevAndNext(session,
					esfShooterAffiliationChrono, affiliationDate,
					orderByComparator, true);

			array[1] = esfShooterAffiliationChrono;

			array[2] = getByDate_PrevAndNext(session,
					esfShooterAffiliationChrono, affiliationDate,
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

	protected ESFShooterAffiliationChrono getByDate_PrevAndNext(
		Session session,
		ESFShooterAffiliationChrono esfShooterAffiliationChrono,
		Date affiliationDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

		boolean bindAffiliationDate = false;

		if (affiliationDate == null) {
			query.append(_FINDER_COLUMN_DATE_AFFILIATIONDATE_1);
		}
		else {
			bindAffiliationDate = true;

			query.append(_FINDER_COLUMN_DATE_AFFILIATIONDATE_2);
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
			query.append(ESFShooterAffiliationChronoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAffiliationDate) {
			qPos.add(CalendarUtil.getTimestamp(affiliationDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterAffiliationChrono);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterAffiliationChrono> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter affiliation chronos where affiliationDate = &#63; from the database.
	 *
	 * @param affiliationDate the affiliation date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDate(Date affiliationDate) throws SystemException {
		for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : findByDate(
				affiliationDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterAffiliationChrono);
		}
	}

	/**
	 * Returns the number of e s f shooter affiliation chronos where affiliationDate = &#63;.
	 *
	 * @param affiliationDate the affiliation date
	 * @return the number of matching e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDate(Date affiliationDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DATE;

		Object[] finderArgs = new Object[] { affiliationDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSHOOTERAFFILIATIONCHRONO_WHERE);

			boolean bindAffiliationDate = false;

			if (affiliationDate == null) {
				query.append(_FINDER_COLUMN_DATE_AFFILIATIONDATE_1);
			}
			else {
				bindAffiliationDate = true;

				query.append(_FINDER_COLUMN_DATE_AFFILIATIONDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAffiliationDate) {
					qPos.add(CalendarUtil.getTimestamp(affiliationDate));
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

	private static final String _FINDER_COLUMN_DATE_AFFILIATIONDATE_1 = "esfShooterAffiliationChrono.affiliationDate IS NULL";
	private static final String _FINDER_COLUMN_DATE_AFFILIATIONDATE_2 = "esfShooterAffiliationChrono.affiliationDate = ?";

	public ESFShooterAffiliationChronoPersistenceImpl() {
		setModelClass(ESFShooterAffiliationChrono.class);
	}

	/**
	 * Caches the e s f shooter affiliation chrono in the entity cache if it is enabled.
	 *
	 * @param esfShooterAffiliationChrono the e s f shooter affiliation chrono
	 */
	@Override
	public void cacheResult(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		EntityCacheUtil.putResult(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			esfShooterAffiliationChrono.getPrimaryKey(),
			esfShooterAffiliationChrono);

		esfShooterAffiliationChrono.resetOriginalValues();
	}

	/**
	 * Caches the e s f shooter affiliation chronos in the entity cache if it is enabled.
	 *
	 * @param esfShooterAffiliationChronos the e s f shooter affiliation chronos
	 */
	@Override
	public void cacheResult(
		List<ESFShooterAffiliationChrono> esfShooterAffiliationChronos) {
		for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : esfShooterAffiliationChronos) {
			if (EntityCacheUtil.getResult(
						ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterAffiliationChronoImpl.class,
						esfShooterAffiliationChrono.getPrimaryKey()) == null) {
				cacheResult(esfShooterAffiliationChrono);
			}
			else {
				esfShooterAffiliationChrono.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f shooter affiliation chronos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFShooterAffiliationChronoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFShooterAffiliationChronoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f shooter affiliation chrono.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		EntityCacheUtil.removeResult(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			esfShooterAffiliationChrono.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFShooterAffiliationChrono> esfShooterAffiliationChronos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : esfShooterAffiliationChronos) {
			EntityCacheUtil.removeResult(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterAffiliationChronoImpl.class,
				esfShooterAffiliationChrono.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f shooter affiliation chrono with the primary key. Does not add the e s f shooter affiliation chrono to the database.
	 *
	 * @param esfShooterAffiliationChronoId the primary key for the new e s f shooter affiliation chrono
	 * @return the new e s f shooter affiliation chrono
	 */
	@Override
	public ESFShooterAffiliationChrono create(
		long esfShooterAffiliationChronoId) {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = new ESFShooterAffiliationChronoImpl();

		esfShooterAffiliationChrono.setNew(true);
		esfShooterAffiliationChrono.setPrimaryKey(esfShooterAffiliationChronoId);

		return esfShooterAffiliationChrono;
	}

	/**
	 * Removes the e s f shooter affiliation chrono with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfShooterAffiliationChronoId the primary key of the e s f shooter affiliation chrono
	 * @return the e s f shooter affiliation chrono that was removed
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono remove(
		long esfShooterAffiliationChronoId)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		return remove((Serializable)esfShooterAffiliationChronoId);
	}

	/**
	 * Removes the e s f shooter affiliation chrono with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f shooter affiliation chrono
	 * @return the e s f shooter affiliation chrono that was removed
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono remove(Serializable primaryKey)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFShooterAffiliationChrono esfShooterAffiliationChrono = (ESFShooterAffiliationChrono)session.get(ESFShooterAffiliationChronoImpl.class,
					primaryKey);

			if (esfShooterAffiliationChrono == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShooterAffiliationChronoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfShooterAffiliationChrono);
		}
		catch (NoSuchShooterAffiliationChronoException nsee) {
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
	protected ESFShooterAffiliationChrono removeImpl(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono)
		throws SystemException {
		esfShooterAffiliationChrono = toUnwrappedModel(esfShooterAffiliationChrono);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfShooterAffiliationChrono)) {
				esfShooterAffiliationChrono = (ESFShooterAffiliationChrono)session.get(ESFShooterAffiliationChronoImpl.class,
						esfShooterAffiliationChrono.getPrimaryKeyObj());
			}

			if (esfShooterAffiliationChrono != null) {
				session.delete(esfShooterAffiliationChrono);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfShooterAffiliationChrono != null) {
			clearCache(esfShooterAffiliationChrono);
		}

		return esfShooterAffiliationChrono;
	}

	@Override
	public ESFShooterAffiliationChrono updateImpl(
		it.ethica.esf.model.ESFShooterAffiliationChrono esfShooterAffiliationChrono)
		throws SystemException {
		esfShooterAffiliationChrono = toUnwrappedModel(esfShooterAffiliationChrono);

		boolean isNew = esfShooterAffiliationChrono.isNew();

		ESFShooterAffiliationChronoModelImpl esfShooterAffiliationChronoModelImpl =
			(ESFShooterAffiliationChronoModelImpl)esfShooterAffiliationChrono;

		Session session = null;

		try {
			session = openSession();

			if (esfShooterAffiliationChrono.isNew()) {
				session.save(esfShooterAffiliationChrono);

				esfShooterAffiliationChrono.setNew(false);
			}
			else {
				session.merge(esfShooterAffiliationChrono);
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
				!ESFShooterAffiliationChronoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfShooterAffiliationChronoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterAffiliationChronoModelImpl.getOriginalEsfuserId(),
						esfShooterAffiliationChronoModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDYEAR,
					args);

				args = new Object[] {
						esfShooterAffiliationChronoModelImpl.getEsfuserId(),
						esfShooterAffiliationChronoModelImpl.getYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDYEAR,
					args);
			}

			if ((esfShooterAffiliationChronoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterAffiliationChronoModelImpl.getOriginalCard(),
						esfShooterAffiliationChronoModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARDYEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDYEAR,
					args);

				args = new Object[] {
						esfShooterAffiliationChronoModelImpl.getCard(),
						esfShooterAffiliationChronoModelImpl.getYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARDYEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDYEAR,
					args);
			}

			if ((esfShooterAffiliationChronoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterAffiliationChronoModelImpl.getOriginalAffiliationDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);

				args = new Object[] {
						esfShooterAffiliationChronoModelImpl.getAffiliationDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterAffiliationChronoImpl.class,
			esfShooterAffiliationChrono.getPrimaryKey(),
			esfShooterAffiliationChrono);

		return esfShooterAffiliationChrono;
	}

	protected ESFShooterAffiliationChrono toUnwrappedModel(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		if (esfShooterAffiliationChrono instanceof ESFShooterAffiliationChronoImpl) {
			return esfShooterAffiliationChrono;
		}

		ESFShooterAffiliationChronoImpl esfShooterAffiliationChronoImpl = new ESFShooterAffiliationChronoImpl();

		esfShooterAffiliationChronoImpl.setNew(esfShooterAffiliationChrono.isNew());
		esfShooterAffiliationChronoImpl.setPrimaryKey(esfShooterAffiliationChrono.getPrimaryKey());

		esfShooterAffiliationChronoImpl.setEsfShooterAffiliationChronoId(esfShooterAffiliationChrono.getEsfShooterAffiliationChronoId());
		esfShooterAffiliationChronoImpl.setEsfuserId(esfShooterAffiliationChrono.getEsfuserId());
		esfShooterAffiliationChronoImpl.setAffiliationDate(esfShooterAffiliationChrono.getAffiliationDate());
		esfShooterAffiliationChronoImpl.setYear(esfShooterAffiliationChrono.getYear());
		esfShooterAffiliationChronoImpl.setVcampo(esfShooterAffiliationChrono.getVcampo());
		esfShooterAffiliationChronoImpl.setPaymentDate(esfShooterAffiliationChrono.getPaymentDate());
		esfShooterAffiliationChronoImpl.setPayment(esfShooterAffiliationChrono.getPayment());
		esfShooterAffiliationChronoImpl.setCard(esfShooterAffiliationChrono.getCard());
		esfShooterAffiliationChronoImpl.setEsfOrganization(esfShooterAffiliationChrono.getEsfOrganization());
		esfShooterAffiliationChronoImpl.setNote(esfShooterAffiliationChrono.getNote());

		return esfShooterAffiliationChronoImpl;
	}

	/**
	 * Returns the e s f shooter affiliation chrono with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter affiliation chrono
	 * @return the e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = fetchByPrimaryKey(primaryKey);

		if (esfShooterAffiliationChrono == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShooterAffiliationChronoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfShooterAffiliationChrono;
	}

	/**
	 * Returns the e s f shooter affiliation chrono with the primary key or throws a {@link it.ethica.esf.NoSuchShooterAffiliationChronoException} if it could not be found.
	 *
	 * @param esfShooterAffiliationChronoId the primary key of the e s f shooter affiliation chrono
	 * @return the e s f shooter affiliation chrono
	 * @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono findByPrimaryKey(
		long esfShooterAffiliationChronoId)
		throws NoSuchShooterAffiliationChronoException, SystemException {
		return findByPrimaryKey((Serializable)esfShooterAffiliationChronoId);
	}

	/**
	 * Returns the e s f shooter affiliation chrono with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter affiliation chrono
	 * @return the e s f shooter affiliation chrono, or <code>null</code> if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFShooterAffiliationChrono esfShooterAffiliationChrono = (ESFShooterAffiliationChrono)EntityCacheUtil.getResult(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterAffiliationChronoImpl.class, primaryKey);

		if (esfShooterAffiliationChrono == _nullESFShooterAffiliationChrono) {
			return null;
		}

		if (esfShooterAffiliationChrono == null) {
			Session session = null;

			try {
				session = openSession();

				esfShooterAffiliationChrono = (ESFShooterAffiliationChrono)session.get(ESFShooterAffiliationChronoImpl.class,
						primaryKey);

				if (esfShooterAffiliationChrono != null) {
					cacheResult(esfShooterAffiliationChrono);
				}
				else {
					EntityCacheUtil.putResult(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterAffiliationChronoImpl.class, primaryKey,
						_nullESFShooterAffiliationChrono);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFShooterAffiliationChronoModelImpl.ENTITY_CACHE_ENABLED,
					ESFShooterAffiliationChronoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfShooterAffiliationChrono;
	}

	/**
	 * Returns the e s f shooter affiliation chrono with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfShooterAffiliationChronoId the primary key of the e s f shooter affiliation chrono
	 * @return the e s f shooter affiliation chrono, or <code>null</code> if a e s f shooter affiliation chrono with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterAffiliationChrono fetchByPrimaryKey(
		long esfShooterAffiliationChronoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfShooterAffiliationChronoId);
	}

	/**
	 * Returns all the e s f shooter affiliation chronos.
	 *
	 * @return the e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter affiliation chronos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter affiliation chronos
	 * @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	 * @return the range of e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter affiliation chronos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter affiliation chronos
	 * @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f shooter affiliation chronos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterAffiliationChrono> findAll(int start, int end,
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

		List<ESFShooterAffiliationChrono> list = (List<ESFShooterAffiliationChrono>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO;

				if (pagination) {
					sql = sql.concat(ESFShooterAffiliationChronoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFShooterAffiliationChrono>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterAffiliationChrono>(list);
				}
				else {
					list = (List<ESFShooterAffiliationChrono>)QueryUtil.list(q,
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
	 * Removes all the e s f shooter affiliation chronos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFShooterAffiliationChrono esfShooterAffiliationChrono : findAll()) {
			remove(esfShooterAffiliationChrono);
		}
	}

	/**
	 * Returns the number of e s f shooter affiliation chronos.
	 *
	 * @return the number of e s f shooter affiliation chronos
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

				Query q = session.createQuery(_SQL_COUNT_ESFSHOOTERAFFILIATIONCHRONO);

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
	 * Initializes the e s f shooter affiliation chrono persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFShooterAffiliationChrono")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFShooterAffiliationChrono>> listenersList = new ArrayList<ModelListener<ESFShooterAffiliationChrono>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFShooterAffiliationChrono>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFShooterAffiliationChronoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO = "SELECT esfShooterAffiliationChrono FROM ESFShooterAffiliationChrono esfShooterAffiliationChrono";
	private static final String _SQL_SELECT_ESFSHOOTERAFFILIATIONCHRONO_WHERE = "SELECT esfShooterAffiliationChrono FROM ESFShooterAffiliationChrono esfShooterAffiliationChrono WHERE ";
	private static final String _SQL_COUNT_ESFSHOOTERAFFILIATIONCHRONO = "SELECT COUNT(esfShooterAffiliationChrono) FROM ESFShooterAffiliationChrono esfShooterAffiliationChrono";
	private static final String _SQL_COUNT_ESFSHOOTERAFFILIATIONCHRONO_WHERE = "SELECT COUNT(esfShooterAffiliationChrono) FROM ESFShooterAffiliationChrono esfShooterAffiliationChrono WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfShooterAffiliationChrono.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFShooterAffiliationChrono exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFShooterAffiliationChrono exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFShooterAffiliationChronoPersistenceImpl.class);
	private static ESFShooterAffiliationChrono _nullESFShooterAffiliationChrono = new ESFShooterAffiliationChronoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFShooterAffiliationChrono> toCacheModel() {
				return _nullESFShooterAffiliationChronoCacheModel;
			}
		};

	private static CacheModel<ESFShooterAffiliationChrono> _nullESFShooterAffiliationChronoCacheModel =
		new CacheModel<ESFShooterAffiliationChrono>() {
			@Override
			public ESFShooterAffiliationChrono toEntityModel() {
				return _nullESFShooterAffiliationChrono;
			}
		};
}