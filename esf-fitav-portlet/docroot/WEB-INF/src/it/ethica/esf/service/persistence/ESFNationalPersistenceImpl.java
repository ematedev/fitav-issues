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
import com.liferay.portal.kernel.util.ArrayUtil;
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

import it.ethica.esf.NoSuchNationalException;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.impl.ESFNationalImpl;
import it.ethica.esf.model.impl.ESFNationalModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the e s f national service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalPersistence
 * @see ESFNationalUtil
 * @generated
 */
public class ESFNationalPersistenceImpl extends BasePersistenceImpl<ESFNational>
	implements ESFNationalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFNationalUtil} to access the e s f national persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFNationalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, ESFNationalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, ESFNationalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENDDATE = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, ESFNationalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEndDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ENDDATE = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByEndDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the e s f nationals where endDate &gt; &#63;.
	 *
	 * @param endDate the end date
	 * @return the matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByEndDate(Date endDate)
		throws SystemException {
		return findByEndDate(endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f nationals where endDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @return the range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByEndDate(Date endDate, int start, int end)
		throws SystemException {
		return findByEndDate(endDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f nationals where endDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByEndDate(Date endDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENDDATE;
		finderArgs = new Object[] { endDate, start, end, orderByComparator };

		List<ESFNational> list = (List<ESFNational>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNational esfNational : list) {
				if ((endDate.getTime() >= esfNational.getEndDate().getTime())) {
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

			query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				if (!pagination) {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNational>(list);
				}
				else {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f national in the ordered set where endDate &gt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findByEndDate_First(Date endDate,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchByEndDate_First(endDate,
				orderByComparator);

		if (esfNational != null) {
			return esfNational;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalException(msg.toString());
	}

	/**
	 * Returns the first e s f national in the ordered set where endDate &gt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchByEndDate_First(Date endDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNational> list = findByEndDate(endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national in the ordered set where endDate &gt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findByEndDate_Last(Date endDate,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchByEndDate_Last(endDate, orderByComparator);

		if (esfNational != null) {
			return esfNational;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalException(msg.toString());
	}

	/**
	 * Returns the last e s f national in the ordered set where endDate &gt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchByEndDate_Last(Date endDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEndDate(endDate);

		if (count == 0) {
			return null;
		}

		List<ESFNational> list = findByEndDate(endDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f nationals before and after the current e s f national in the ordered set where endDate &gt; &#63;.
	 *
	 * @param esfNationalId the primary key of the current e s f national
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational[] findByEndDate_PrevAndNext(long esfNationalId,
		Date endDate, OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = findByPrimaryKey(esfNationalId);

		Session session = null;

		try {
			session = openSession();

			ESFNational[] array = new ESFNationalImpl[3];

			array[0] = getByEndDate_PrevAndNext(session, esfNational, endDate,
					orderByComparator, true);

			array[1] = esfNational;

			array[2] = getByEndDate_PrevAndNext(session, esfNational, endDate,
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

	protected ESFNational getByEndDate_PrevAndNext(Session session,
		ESFNational esfNational, Date endDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

		boolean bindEndDate = false;

		if (endDate == null) {
			query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
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
			query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEndDate) {
			qPos.add(CalendarUtil.getTimestamp(endDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNational);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNational> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f nationals where endDate &gt; &#63; from the database.
	 *
	 * @param endDate the end date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEndDate(Date endDate) throws SystemException {
		for (ESFNational esfNational : findByEndDate(endDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNational);
		}
	}

	/**
	 * Returns the number of e s f nationals where endDate &gt; &#63;.
	 *
	 * @param endDate the end date
	 * @return the number of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEndDate(Date endDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_ENDDATE;

		Object[] finderArgs = new Object[] { endDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFNATIONAL_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_ENDDATE_ENDDATE_1 = "esfNational.endDate > NULL";
	private static final String _FINDER_COLUMN_ENDDATE_ENDDATE_2 = "esfNational.endDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_E_E = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, ESFNationalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByE_E",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_E_E = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByE_E",
			new String[] { Date.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByE_E(Date endDate, long esfSportTypeId)
		throws SystemException {
		return findByE_E(endDate, esfSportTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @return the range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByE_E(Date endDate, long esfSportTypeId,
		int start, int end) throws SystemException {
		return findByE_E(endDate, esfSportTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByE_E(Date endDate, long esfSportTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_E_E;
		finderArgs = new Object[] {
				endDate, esfSportTypeId,
				
				start, end, orderByComparator
			};

		List<ESFNational> list = (List<ESFNational>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNational esfNational : list) {
				if ((endDate.getTime() >= esfNational.getEndDate().getTime()) ||
						(esfSportTypeId != esfNational.getEsfSportTypeId())) {
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

			query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_E_E_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_E_E_ENDDATE_2);
			}

			query.append(_FINDER_COLUMN_E_E_ESFSPORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				qPos.add(esfSportTypeId);

				if (!pagination) {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNational>(list);
				}
				else {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findByE_E_First(Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchByE_E_First(endDate, esfSportTypeId,
				orderByComparator);

		if (esfNational != null) {
			return esfNational;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endDate=");
		msg.append(endDate);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalException(msg.toString());
	}

	/**
	 * Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchByE_E_First(Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNational> list = findByE_E(endDate, esfSportTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findByE_E_Last(Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchByE_E_Last(endDate, esfSportTypeId,
				orderByComparator);

		if (esfNational != null) {
			return esfNational;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endDate=");
		msg.append(endDate);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalException(msg.toString());
	}

	/**
	 * Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchByE_E_Last(Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByE_E(endDate, esfSportTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFNational> list = findByE_E(endDate, esfSportTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f nationals before and after the current e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfNationalId the primary key of the current e s f national
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational[] findByE_E_PrevAndNext(long esfNationalId,
		Date endDate, long esfSportTypeId, OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = findByPrimaryKey(esfNationalId);

		Session session = null;

		try {
			session = openSession();

			ESFNational[] array = new ESFNationalImpl[3];

			array[0] = getByE_E_PrevAndNext(session, esfNational, endDate,
					esfSportTypeId, orderByComparator, true);

			array[1] = esfNational;

			array[2] = getByE_E_PrevAndNext(session, esfNational, endDate,
					esfSportTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFNational getByE_E_PrevAndNext(Session session,
		ESFNational esfNational, Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

		boolean bindEndDate = false;

		if (endDate == null) {
			query.append(_FINDER_COLUMN_E_E_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			query.append(_FINDER_COLUMN_E_E_ENDDATE_2);
		}

		query.append(_FINDER_COLUMN_E_E_ESFSPORTTYPEID_2);

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
			query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEndDate) {
			qPos.add(CalendarUtil.getTimestamp(endDate));
		}

		qPos.add(esfSportTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNational);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNational> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63; from the database.
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByE_E(Date endDate, long esfSportTypeId)
		throws SystemException {
		for (ESFNational esfNational : findByE_E(endDate, esfSportTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNational);
		}
	}

	/**
	 * Returns the number of e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByE_E(Date endDate, long esfSportTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_E_E;

		Object[] finderArgs = new Object[] { endDate, esfSportTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNATIONAL_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_E_E_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_E_E_ENDDATE_2);
			}

			query.append(_FINDER_COLUMN_E_E_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				qPos.add(esfSportTypeId);

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

	private static final String _FINDER_COLUMN_E_E_ENDDATE_1 = "esfNational.endDate > NULL AND ";
	private static final String _FINDER_COLUMN_E_E_ENDDATE_2 = "esfNational.endDate > ? AND ";
	private static final String _FINDER_COLUMN_E_E_ESFSPORTTYPEID_2 = "esfNational.esfSportTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_E = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, ESFNationalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_E",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_E = new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_E",
			new String[] { Date.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @return the matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByU_E(Date endDate, long esfUserId)
		throws SystemException {
		return findByU_E(endDate, esfUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @return the range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByU_E(Date endDate, long esfUserId, int start,
		int end) throws SystemException {
		return findByU_E(endDate, esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findByU_E(Date endDate, long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_E;
		finderArgs = new Object[] {
				endDate, esfUserId,
				
				start, end, orderByComparator
			};

		List<ESFNational> list = (List<ESFNational>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNational esfNational : list) {
				if ((endDate.getTime() >= esfNational.getEndDate().getTime()) ||
						(esfUserId != esfNational.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_U_E_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_U_E_ENDDATE_2);
			}

			query.append(_FINDER_COLUMN_U_E_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNational>(list);
				}
				else {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findByU_E_First(Date endDate, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchByU_E_First(endDate, esfUserId,
				orderByComparator);

		if (esfNational != null) {
			return esfNational;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endDate=");
		msg.append(endDate);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalException(msg.toString());
	}

	/**
	 * Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchByU_E_First(Date endDate, long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNational> list = findByU_E(endDate, esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findByU_E_Last(Date endDate, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchByU_E_Last(endDate, esfUserId,
				orderByComparator);

		if (esfNational != null) {
			return esfNational;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endDate=");
		msg.append(endDate);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalException(msg.toString());
	}

	/**
	 * Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchByU_E_Last(Date endDate, long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByU_E(endDate, esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFNational> list = findByU_E(endDate, esfUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f nationals before and after the current e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param esfNationalId the primary key of the current e s f national
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational[] findByU_E_PrevAndNext(long esfNationalId,
		Date endDate, long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = findByPrimaryKey(esfNationalId);

		Session session = null;

		try {
			session = openSession();

			ESFNational[] array = new ESFNationalImpl[3];

			array[0] = getByU_E_PrevAndNext(session, esfNational, endDate,
					esfUserId, orderByComparator, true);

			array[1] = esfNational;

			array[2] = getByU_E_PrevAndNext(session, esfNational, endDate,
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

	protected ESFNational getByU_E_PrevAndNext(Session session,
		ESFNational esfNational, Date endDate, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

		boolean bindEndDate = false;

		if (endDate == null) {
			query.append(_FINDER_COLUMN_U_E_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			query.append(_FINDER_COLUMN_U_E_ENDDATE_2);
		}

		query.append(_FINDER_COLUMN_U_E_ESFUSERID_2);

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
			query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEndDate) {
			qPos.add(CalendarUtil.getTimestamp(endDate));
		}

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNational);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNational> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63; from the database.
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByU_E(Date endDate, long esfUserId)
		throws SystemException {
		for (ESFNational esfNational : findByU_E(endDate, esfUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNational);
		}
	}

	/**
	 * Returns the number of e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param endDate the end date
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByU_E(Date endDate, long esfUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_E;

		Object[] finderArgs = new Object[] { endDate, esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNATIONAL_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_U_E_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_U_E_ENDDATE_2);
			}

			query.append(_FINDER_COLUMN_U_E_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

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

	private static final String _FINDER_COLUMN_U_E_ENDDATE_1 = "esfNational.endDate > NULL AND ";
	private static final String _FINDER_COLUMN_U_E_ENDDATE_2 = "esfNational.endDate > ? AND ";
	private static final String _FINDER_COLUMN_U_E_ESFUSERID_2 = "esfNational.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTARTDATEENDDATETYPESPORTID =
		new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, ESFNationalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyStartDateEndDateTypeSportId",
			new String[] {
				Date.class.getName(), Date.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_BYSTARTDATEENDDATETYPESPORTID =
		new FinderPath(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBybyStartDateEndDateTypeSportId",
			new String[] {
				Date.class.getName(), Date.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findBybyStartDateEndDateTypeSportId(
		Date startDate, Date endDate, long esfSportTypeId)
		throws SystemException {
		return findBybyStartDateEndDateTypeSportId(startDate, endDate,
			esfSportTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @return the range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findBybyStartDateEndDateTypeSportId(
		Date startDate, Date endDate, long esfSportTypeId, int start, int end)
		throws SystemException {
		return findBybyStartDateEndDateTypeSportId(startDate, endDate,
			esfSportTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findBybyStartDateEndDateTypeSportId(
		Date startDate, Date endDate, long esfSportTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTARTDATEENDDATETYPESPORTID;
		finderArgs = new Object[] {
				startDate, endDate, esfSportTypeId,
				
				start, end, orderByComparator
			};

		List<ESFNational> list = (List<ESFNational>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNational esfNational : list) {
				if ((startDate.getTime() > esfNational.getStartDate().getTime()) ||
						(endDate.getTime() < esfNational.getEndDate().getTime()) ||
						(esfSportTypeId != esfNational.getEsfSportTypeId())) {
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

			query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_2);
			}

			query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ESFSPORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				qPos.add(esfSportTypeId);

				if (!pagination) {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNational>(list);
				}
				else {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findBybyStartDateEndDateTypeSportId_First(
		Date startDate, Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchBybyStartDateEndDateTypeSportId_First(startDate,
				endDate, esfSportTypeId, orderByComparator);

		if (esfNational != null) {
			return esfNational;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startDate=");
		msg.append(startDate);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalException(msg.toString());
	}

	/**
	 * Returns the first e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchBybyStartDateEndDateTypeSportId_First(
		Date startDate, Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNational> list = findBybyStartDateEndDateTypeSportId(startDate,
				endDate, esfSportTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findBybyStartDateEndDateTypeSportId_Last(
		Date startDate, Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchBybyStartDateEndDateTypeSportId_Last(startDate,
				endDate, esfSportTypeId, orderByComparator);

		if (esfNational != null) {
			return esfNational;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startDate=");
		msg.append(startDate);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalException(msg.toString());
	}

	/**
	 * Returns the last e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchBybyStartDateEndDateTypeSportId_Last(
		Date startDate, Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyStartDateEndDateTypeSportId(startDate, endDate,
				esfSportTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFNational> list = findBybyStartDateEndDateTypeSportId(startDate,
				endDate, esfSportTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f nationals before and after the current e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfNationalId the primary key of the current e s f national
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational[] findBybyStartDateEndDateTypeSportId_PrevAndNext(
		long esfNationalId, Date startDate, Date endDate, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = findByPrimaryKey(esfNationalId);

		Session session = null;

		try {
			session = openSession();

			ESFNational[] array = new ESFNationalImpl[3];

			array[0] = getBybyStartDateEndDateTypeSportId_PrevAndNext(session,
					esfNational, startDate, endDate, esfSportTypeId,
					orderByComparator, true);

			array[1] = esfNational;

			array[2] = getBybyStartDateEndDateTypeSportId_PrevAndNext(session,
					esfNational, startDate, endDate, esfSportTypeId,
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

	protected ESFNational getBybyStartDateEndDateTypeSportId_PrevAndNext(
		Session session, ESFNational esfNational, Date startDate, Date endDate,
		long esfSportTypeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

		boolean bindStartDate = false;

		if (startDate == null) {
			query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_2);
		}

		boolean bindEndDate = false;

		if (endDate == null) {
			query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_2);
		}

		query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ESFSPORTTYPEID_2);

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
			query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStartDate) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		if (bindEndDate) {
			qPos.add(CalendarUtil.getTimestamp(endDate));
		}

		qPos.add(esfSportTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNational);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNational> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDates the start dates
	 * @param endDates the end dates
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findBybyStartDateEndDateTypeSportId(
		Date[] startDates, Date[] endDates, long esfSportTypeId)
		throws SystemException {
		return findBybyStartDateEndDateTypeSportId(startDates, endDates,
			esfSportTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDates the start dates
	 * @param endDates the end dates
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @return the range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findBybyStartDateEndDateTypeSportId(
		Date[] startDates, Date[] endDates, long esfSportTypeId, int start,
		int end) throws SystemException {
		return findBybyStartDateEndDateTypeSportId(startDates, endDates,
			esfSportTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDates the start dates
	 * @param endDates the end dates
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findBybyStartDateEndDateTypeSportId(
		Date[] startDates, Date[] endDates, long esfSportTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((startDates != null) && (startDates.length == 1) &&
				(endDates != null) && (endDates.length == 1)) {
			return findBybyStartDateEndDateTypeSportId(startDates[0],
				endDates[0], esfSportTypeId, start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(startDates), StringUtil.merge(endDates),
					esfSportTypeId
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(startDates), StringUtil.merge(endDates),
					esfSportTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNational> list = (List<ESFNational>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTARTDATEENDDATETYPESPORTID,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNational esfNational : list) {
				if (!ArrayUtil.contains(startDates, esfNational.getStartDate()) ||
						!ArrayUtil.contains(endDates, esfNational.getEndDate()) ||
						(esfSportTypeId != esfNational.getEsfSportTypeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_ESFNATIONAL_WHERE);

			boolean conjunctionable = false;

			if ((startDates == null) || (startDates.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < startDates.length; i++) {
					Date startDate = startDates[i];

					if (startDate == null) {
						query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_4);
					}
					else {
						query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_5);
					}

					if ((i + 1) < startDates.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((endDates == null) || (endDates.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < endDates.length; i++) {
					Date endDate = endDates[i];

					if (endDate == null) {
						query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_4);
					}
					else {
						query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_5);
					}

					if ((i + 1) < endDates.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ESFSPORTTYPEID_5);

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDates != null) {
					qPos.add(startDates);
				}

				if (endDates != null) {
					qPos.add(endDates);
				}

				qPos.add(esfSportTypeId);

				if (!pagination) {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNational>(list);
				}
				else {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTARTDATEENDDATETYPESPORTID,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTARTDATEENDDATETYPESPORTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyStartDateEndDateTypeSportId(Date startDate,
		Date endDate, long esfSportTypeId) throws SystemException {
		for (ESFNational esfNational : findBybyStartDateEndDateTypeSportId(
				startDate, endDate, esfSportTypeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfNational);
		}
	}

	/**
	 * Returns the number of e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyStartDateEndDateTypeSportId(Date startDate,
		Date endDate, long esfSportTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_BYSTARTDATEENDDATETYPESPORTID;

		Object[] finderArgs = new Object[] { startDate, endDate, esfSportTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFNATIONAL_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_2);
			}

			query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				qPos.add(esfSportTypeId);

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

	/**
	 * Returns the number of e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	 *
	 * @param startDates the start dates
	 * @param endDates the end dates
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyStartDateEndDateTypeSportId(Date[] startDates,
		Date[] endDates, long esfSportTypeId) throws SystemException {
		Object[] finderArgs = new Object[] {
				StringUtil.merge(startDates), StringUtil.merge(endDates),
				esfSportTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_BYSTARTDATEENDDATETYPESPORTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_ESFNATIONAL_WHERE);

			boolean conjunctionable = false;

			if ((startDates == null) || (startDates.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < startDates.length; i++) {
					Date startDate = startDates[i];

					if (startDate == null) {
						query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_4);
					}
					else {
						query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_5);
					}

					if ((i + 1) < startDates.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((endDates == null) || (endDates.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < endDates.length; i++) {
					Date endDate = endDates[i];

					if (endDate == null) {
						query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_4);
					}
					else {
						query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_5);
					}

					if ((i + 1) < endDates.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ESFSPORTTYPEID_5);

			conjunctionable = true;

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDates != null) {
					qPos.add(startDates);
				}

				if (endDates != null) {
					qPos.add(endDates);
				}

				qPos.add(esfSportTypeId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_BYSTARTDATEENDDATETYPESPORTID,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_BYSTARTDATEENDDATETYPESPORTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_1 =
		"esfNational.startDate >= NULL AND ";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_2 =
		"esfNational.startDate >= ? AND ";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_4 =
		"(" +
		removeConjunction(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_1) +
		")";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_STARTDATE_2) +
		")";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_1 =
		"esfNational.endDate <= NULL AND ";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_2 =
		"esfNational.endDate <= ? AND ";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_4 =
		"(" +
		removeConjunction(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_1) +
		")";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ENDDATE_2) +
		")";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ESFSPORTTYPEID_2 =
		"esfNational.esfSportTypeId = ?";
	private static final String _FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ESFSPORTTYPEID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_BYSTARTDATEENDDATETYPESPORTID_ESFSPORTTYPEID_2) +
		")";

	public ESFNationalPersistenceImpl() {
		setModelClass(ESFNational.class);
	}

	/**
	 * Caches the e s f national in the entity cache if it is enabled.
	 *
	 * @param esfNational the e s f national
	 */
	@Override
	public void cacheResult(ESFNational esfNational) {
		EntityCacheUtil.putResult(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalImpl.class, esfNational.getPrimaryKey(), esfNational);

		esfNational.resetOriginalValues();
	}

	/**
	 * Caches the e s f nationals in the entity cache if it is enabled.
	 *
	 * @param esfNationals the e s f nationals
	 */
	@Override
	public void cacheResult(List<ESFNational> esfNationals) {
		for (ESFNational esfNational : esfNationals) {
			if (EntityCacheUtil.getResult(
						ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
						ESFNationalImpl.class, esfNational.getPrimaryKey()) == null) {
				cacheResult(esfNational);
			}
			else {
				esfNational.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f nationals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFNationalImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFNationalImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f national.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFNational esfNational) {
		EntityCacheUtil.removeResult(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalImpl.class, esfNational.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFNational> esfNationals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFNational esfNational : esfNationals) {
			EntityCacheUtil.removeResult(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
				ESFNationalImpl.class, esfNational.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f national with the primary key. Does not add the e s f national to the database.
	 *
	 * @param esfNationalId the primary key for the new e s f national
	 * @return the new e s f national
	 */
	@Override
	public ESFNational create(long esfNationalId) {
		ESFNational esfNational = new ESFNationalImpl();

		esfNational.setNew(true);
		esfNational.setPrimaryKey(esfNationalId);

		return esfNational;
	}

	/**
	 * Removes the e s f national with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfNationalId the primary key of the e s f national
	 * @return the e s f national that was removed
	 * @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational remove(long esfNationalId)
		throws NoSuchNationalException, SystemException {
		return remove((Serializable)esfNationalId);
	}

	/**
	 * Removes the e s f national with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f national
	 * @return the e s f national that was removed
	 * @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational remove(Serializable primaryKey)
		throws NoSuchNationalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFNational esfNational = (ESFNational)session.get(ESFNationalImpl.class,
					primaryKey);

			if (esfNational == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNationalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfNational);
		}
		catch (NoSuchNationalException nsee) {
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
	protected ESFNational removeImpl(ESFNational esfNational)
		throws SystemException {
		esfNational = toUnwrappedModel(esfNational);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfNational)) {
				esfNational = (ESFNational)session.get(ESFNationalImpl.class,
						esfNational.getPrimaryKeyObj());
			}

			if (esfNational != null) {
				session.delete(esfNational);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfNational != null) {
			clearCache(esfNational);
		}

		return esfNational;
	}

	@Override
	public ESFNational updateImpl(it.ethica.esf.model.ESFNational esfNational)
		throws SystemException {
		esfNational = toUnwrappedModel(esfNational);

		boolean isNew = esfNational.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfNational.isNew()) {
				session.save(esfNational);

				esfNational.setNew(false);
			}
			else {
				session.merge(esfNational);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFNationalModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalImpl.class, esfNational.getPrimaryKey(), esfNational);

		return esfNational;
	}

	protected ESFNational toUnwrappedModel(ESFNational esfNational) {
		if (esfNational instanceof ESFNationalImpl) {
			return esfNational;
		}

		ESFNationalImpl esfNationalImpl = new ESFNationalImpl();

		esfNationalImpl.setNew(esfNational.isNew());
		esfNationalImpl.setPrimaryKey(esfNational.getPrimaryKey());

		esfNationalImpl.setEsfNationalId(esfNational.getEsfNationalId());
		esfNationalImpl.setGroupId(esfNational.getGroupId());
		esfNationalImpl.setCompanyId(esfNational.getCompanyId());
		esfNationalImpl.setUserId(esfNational.getUserId());
		esfNationalImpl.setUserName(esfNational.getUserName());
		esfNationalImpl.setCreateDate(esfNational.getCreateDate());
		esfNationalImpl.setModifiedDate(esfNational.getModifiedDate());
		esfNationalImpl.setEsfUserId(esfNational.getEsfUserId());
		esfNationalImpl.setEsfSportTypeId(esfNational.getEsfSportTypeId());
		esfNationalImpl.setStartDate(esfNational.getStartDate());
		esfNationalImpl.setEndDate(esfNational.getEndDate());
		esfNationalImpl.setBDODate(esfNational.getBDODate());
		esfNationalImpl.setIdInternational(esfNational.getIdInternational());
		esfNationalImpl.setIsUniversity(esfNational.isIsUniversity());
		esfNationalImpl.setIsNational(esfNational.isIsNational());
		esfNationalImpl.setDeliberate(esfNational.getDeliberate());
		esfNationalImpl.setDeliberateDate(esfNational.getDeliberateDate());

		return esfNationalImpl;
	}

	/**
	 * Returns the e s f national with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f national
	 * @return the e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNationalException, SystemException {
		ESFNational esfNational = fetchByPrimaryKey(primaryKey);

		if (esfNational == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNationalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfNational;
	}

	/**
	 * Returns the e s f national with the primary key or throws a {@link it.ethica.esf.NoSuchNationalException} if it could not be found.
	 *
	 * @param esfNationalId the primary key of the e s f national
	 * @return the e s f national
	 * @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational findByPrimaryKey(long esfNationalId)
		throws NoSuchNationalException, SystemException {
		return findByPrimaryKey((Serializable)esfNationalId);
	}

	/**
	 * Returns the e s f national with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f national
	 * @return the e s f national, or <code>null</code> if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFNational esfNational = (ESFNational)EntityCacheUtil.getResult(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
				ESFNationalImpl.class, primaryKey);

		if (esfNational == _nullESFNational) {
			return null;
		}

		if (esfNational == null) {
			Session session = null;

			try {
				session = openSession();

				esfNational = (ESFNational)session.get(ESFNationalImpl.class,
						primaryKey);

				if (esfNational != null) {
					cacheResult(esfNational);
				}
				else {
					EntityCacheUtil.putResult(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
						ESFNationalImpl.class, primaryKey, _nullESFNational);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFNationalModelImpl.ENTITY_CACHE_ENABLED,
					ESFNationalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfNational;
	}

	/**
	 * Returns the e s f national with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfNationalId the primary key of the e s f national
	 * @return the e s f national, or <code>null</code> if a e s f national with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNational fetchByPrimaryKey(long esfNationalId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfNationalId);
	}

	/**
	 * Returns all the e s f nationals.
	 *
	 * @return the e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f nationals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @return the range of e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f nationals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f nationals
	 * @param end the upper bound of the range of e s f nationals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f nationals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNational> findAll(int start, int end,
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

		List<ESFNational> list = (List<ESFNational>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFNATIONAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFNATIONAL;

				if (pagination) {
					sql = sql.concat(ESFNationalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNational>(list);
				}
				else {
					list = (List<ESFNational>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f nationals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFNational esfNational : findAll()) {
			remove(esfNational);
		}
	}

	/**
	 * Returns the number of e s f nationals.
	 *
	 * @return the number of e s f nationals
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

				Query q = session.createQuery(_SQL_COUNT_ESFNATIONAL);

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
	 * Initializes the e s f national persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFNational")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFNational>> listenersList = new ArrayList<ModelListener<ESFNational>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFNational>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFNationalImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFNATIONAL = "SELECT esfNational FROM ESFNational esfNational";
	private static final String _SQL_SELECT_ESFNATIONAL_WHERE = "SELECT esfNational FROM ESFNational esfNational WHERE ";
	private static final String _SQL_COUNT_ESFNATIONAL = "SELECT COUNT(esfNational) FROM ESFNational esfNational";
	private static final String _SQL_COUNT_ESFNATIONAL_WHERE = "SELECT COUNT(esfNational) FROM ESFNational esfNational WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfNational.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFNational exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFNational exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFNationalPersistenceImpl.class);
	private static ESFNational _nullESFNational = new ESFNationalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFNational> toCacheModel() {
				return _nullESFNationalCacheModel;
			}
		};

	private static CacheModel<ESFNational> _nullESFNationalCacheModel = new CacheModel<ESFNational>() {
			@Override
			public ESFNational toEntityModel() {
				return _nullESFNational;
			}
		};
}