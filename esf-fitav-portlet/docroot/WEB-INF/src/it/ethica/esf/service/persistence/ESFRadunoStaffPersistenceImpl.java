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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchRadunoStaffException;
import it.ethica.esf.model.ESFRadunoStaff;
import it.ethica.esf.model.impl.ESFRadunoStaffImpl;
import it.ethica.esf.model.impl.ESFRadunoStaffModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f raduno staff service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoStaffPersistence
 * @see ESFRadunoStaffUtil
 * @generated
 */
public class ESFRadunoStaffPersistenceImpl extends BasePersistenceImpl<ESFRadunoStaff>
	implements ESFRadunoStaffPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRadunoStaffUtil} to access the e s f raduno staff persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRadunoStaffImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoStaffImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoStaffImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF = new FinderPath(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoStaffImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByfindRadunoStaff",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFRadunoStaffModelImpl.ID_ESF_RADUNO_COLUMN_BITMASK |
			ESFRadunoStaffModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDRADUNOSTAFF = new FinderPath(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindRadunoStaff",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or throws a {@link it.ethica.esf.NoSuchRadunoStaffException} if it could not be found.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @return the matching e s f raduno staff
	 * @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff findByfindRadunoStaff(long id_esf_raduno, long userId)
		throws NoSuchRadunoStaffException, SystemException {
		ESFRadunoStaff esfRadunoStaff = fetchByfindRadunoStaff(id_esf_raduno,
				userId);

		if (esfRadunoStaff == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id_esf_raduno=");
			msg.append(id_esf_raduno);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRadunoStaffException(msg.toString());
		}

		return esfRadunoStaff;
	}

	/**
	 * Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @return the matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff fetchByfindRadunoStaff(long id_esf_raduno, long userId)
		throws SystemException {
		return fetchByfindRadunoStaff(id_esf_raduno, userId, true);
	}

	/**
	 * Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff fetchByfindRadunoStaff(long id_esf_raduno,
		long userId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { id_esf_raduno, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF,
					finderArgs, this);
		}

		if (result instanceof ESFRadunoStaff) {
			ESFRadunoStaff esfRadunoStaff = (ESFRadunoStaff)result;

			if ((id_esf_raduno != esfRadunoStaff.getId_esf_raduno()) ||
					(userId != esfRadunoStaff.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFRADUNOSTAFF_WHERE);

			query.append(_FINDER_COLUMN_FINDRADUNOSTAFF_ID_ESF_RADUNO_2);

			query.append(_FINDER_COLUMN_FINDRADUNOSTAFF_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				qPos.add(userId);

				List<ESFRadunoStaff> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFRadunoStaffPersistenceImpl.fetchByfindRadunoStaff(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFRadunoStaff esfRadunoStaff = list.get(0);

					result = esfRadunoStaff;

					cacheResult(esfRadunoStaff);

					if ((esfRadunoStaff.getId_esf_raduno() != id_esf_raduno) ||
							(esfRadunoStaff.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF,
							finderArgs, esfRadunoStaff);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF,
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
			return (ESFRadunoStaff)result;
		}
	}

	/**
	 * Removes the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; from the database.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @return the e s f raduno staff that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff removeByfindRadunoStaff(long id_esf_raduno,
		long userId) throws NoSuchRadunoStaffException, SystemException {
		ESFRadunoStaff esfRadunoStaff = findByfindRadunoStaff(id_esf_raduno,
				userId);

		return remove(esfRadunoStaff);
	}

	/**
	 * Returns the number of e s f raduno staffs where id_esf_raduno = &#63; and userId = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @return the number of matching e s f raduno staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindRadunoStaff(long id_esf_raduno, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDRADUNOSTAFF;

		Object[] finderArgs = new Object[] { id_esf_raduno, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRADUNOSTAFF_WHERE);

			query.append(_FINDER_COLUMN_FINDRADUNOSTAFF_ID_ESF_RADUNO_2);

			query.append(_FINDER_COLUMN_FINDRADUNOSTAFF_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

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

	private static final String _FINDER_COLUMN_FINDRADUNOSTAFF_ID_ESF_RADUNO_2 = "esfRadunoStaff.id.id_esf_raduno = ? AND ";
	private static final String _FINDER_COLUMN_FINDRADUNOSTAFF_USERID_2 = "esfRadunoStaff.id.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYIDRADUNO =
		new FinderPath(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoStaffImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByfindByIdRaduno",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDRADUNO =
		new FinderPath(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoStaffImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByIdRaduno",
			new String[] { Long.class.getName() },
			ESFRadunoStaffModelImpl.ID_ESF_RADUNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYIDRADUNO = new FinderPath(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByIdRaduno",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f raduno staffs where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @return the matching e s f raduno staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoStaff> findByfindByIdRaduno(long id_esf_raduno)
		throws SystemException {
		return findByfindByIdRaduno(id_esf_raduno, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno staffs where id_esf_raduno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoStaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param start the lower bound of the range of e s f raduno staffs
	 * @param end the upper bound of the range of e s f raduno staffs (not inclusive)
	 * @return the range of matching e s f raduno staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoStaff> findByfindByIdRaduno(long id_esf_raduno,
		int start, int end) throws SystemException {
		return findByfindByIdRaduno(id_esf_raduno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno staffs where id_esf_raduno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoStaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param start the lower bound of the range of e s f raduno staffs
	 * @param end the upper bound of the range of e s f raduno staffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f raduno staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoStaff> findByfindByIdRaduno(long id_esf_raduno,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDRADUNO;
			finderArgs = new Object[] { id_esf_raduno };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYIDRADUNO;
			finderArgs = new Object[] {
					id_esf_raduno,
					
					start, end, orderByComparator
				};
		}

		List<ESFRadunoStaff> list = (List<ESFRadunoStaff>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRadunoStaff esfRadunoStaff : list) {
				if ((id_esf_raduno != esfRadunoStaff.getId_esf_raduno())) {
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

			query.append(_SQL_SELECT_ESFRADUNOSTAFF_WHERE);

			query.append(_FINDER_COLUMN_FINDBYIDRADUNO_ID_ESF_RADUNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRadunoStaffModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				if (!pagination) {
					list = (List<ESFRadunoStaff>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoStaff>(list);
				}
				else {
					list = (List<ESFRadunoStaff>)QueryUtil.list(q,
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
	 * Returns the first e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f raduno staff
	 * @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff findByfindByIdRaduno_First(long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchRadunoStaffException, SystemException {
		ESFRadunoStaff esfRadunoStaff = fetchByfindByIdRaduno_First(id_esf_raduno,
				orderByComparator);

		if (esfRadunoStaff != null) {
			return esfRadunoStaff;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_esf_raduno=");
		msg.append(id_esf_raduno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRadunoStaffException(msg.toString());
	}

	/**
	 * Returns the first e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff fetchByfindByIdRaduno_First(long id_esf_raduno,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRadunoStaff> list = findByfindByIdRaduno(id_esf_raduno, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f raduno staff
	 * @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff findByfindByIdRaduno_Last(long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchRadunoStaffException, SystemException {
		ESFRadunoStaff esfRadunoStaff = fetchByfindByIdRaduno_Last(id_esf_raduno,
				orderByComparator);

		if (esfRadunoStaff != null) {
			return esfRadunoStaff;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_esf_raduno=");
		msg.append(id_esf_raduno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRadunoStaffException(msg.toString());
	}

	/**
	 * Returns the last e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff fetchByfindByIdRaduno_Last(long id_esf_raduno,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfindByIdRaduno(id_esf_raduno);

		if (count == 0) {
			return null;
		}

		List<ESFRadunoStaff> list = findByfindByIdRaduno(id_esf_raduno,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f raduno staffs before and after the current e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param esfRadunoStaffPK the primary key of the current e s f raduno staff
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f raduno staff
	 * @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff[] findByfindByIdRaduno_PrevAndNext(
		ESFRadunoStaffPK esfRadunoStaffPK, long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchRadunoStaffException, SystemException {
		ESFRadunoStaff esfRadunoStaff = findByPrimaryKey(esfRadunoStaffPK);

		Session session = null;

		try {
			session = openSession();

			ESFRadunoStaff[] array = new ESFRadunoStaffImpl[3];

			array[0] = getByfindByIdRaduno_PrevAndNext(session, esfRadunoStaff,
					id_esf_raduno, orderByComparator, true);

			array[1] = esfRadunoStaff;

			array[2] = getByfindByIdRaduno_PrevAndNext(session, esfRadunoStaff,
					id_esf_raduno, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRadunoStaff getByfindByIdRaduno_PrevAndNext(Session session,
		ESFRadunoStaff esfRadunoStaff, long id_esf_raduno,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRADUNOSTAFF_WHERE);

		query.append(_FINDER_COLUMN_FINDBYIDRADUNO_ID_ESF_RADUNO_2);

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
			query.append(ESFRadunoStaffModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_esf_raduno);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRadunoStaff);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRadunoStaff> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f raduno staffs where id_esf_raduno = &#63; from the database.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByfindByIdRaduno(long id_esf_raduno)
		throws SystemException {
		for (ESFRadunoStaff esfRadunoStaff : findByfindByIdRaduno(
				id_esf_raduno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRadunoStaff);
		}
	}

	/**
	 * Returns the number of e s f raduno staffs where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @return the number of matching e s f raduno staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByIdRaduno(long id_esf_raduno)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYIDRADUNO;

		Object[] finderArgs = new Object[] { id_esf_raduno };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRADUNOSTAFF_WHERE);

			query.append(_FINDER_COLUMN_FINDBYIDRADUNO_ID_ESF_RADUNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

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

	private static final String _FINDER_COLUMN_FINDBYIDRADUNO_ID_ESF_RADUNO_2 = "esfRadunoStaff.id.id_esf_raduno = ?";

	public ESFRadunoStaffPersistenceImpl() {
		setModelClass(ESFRadunoStaff.class);
	}

	/**
	 * Caches the e s f raduno staff in the entity cache if it is enabled.
	 *
	 * @param esfRadunoStaff the e s f raduno staff
	 */
	@Override
	public void cacheResult(ESFRadunoStaff esfRadunoStaff) {
		EntityCacheUtil.putResult(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffImpl.class, esfRadunoStaff.getPrimaryKey(),
			esfRadunoStaff);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF,
			new Object[] {
				esfRadunoStaff.getId_esf_raduno(), esfRadunoStaff.getUserId()
			}, esfRadunoStaff);

		esfRadunoStaff.resetOriginalValues();
	}

	/**
	 * Caches the e s f raduno staffs in the entity cache if it is enabled.
	 *
	 * @param esfRadunoStaffs the e s f raduno staffs
	 */
	@Override
	public void cacheResult(List<ESFRadunoStaff> esfRadunoStaffs) {
		for (ESFRadunoStaff esfRadunoStaff : esfRadunoStaffs) {
			if (EntityCacheUtil.getResult(
						ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoStaffImpl.class, esfRadunoStaff.getPrimaryKey()) == null) {
				cacheResult(esfRadunoStaff);
			}
			else {
				esfRadunoStaff.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f raduno staffs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRadunoStaffImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRadunoStaffImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f raduno staff.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRadunoStaff esfRadunoStaff) {
		EntityCacheUtil.removeResult(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffImpl.class, esfRadunoStaff.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfRadunoStaff);
	}

	@Override
	public void clearCache(List<ESFRadunoStaff> esfRadunoStaffs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRadunoStaff esfRadunoStaff : esfRadunoStaffs) {
			EntityCacheUtil.removeResult(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoStaffImpl.class, esfRadunoStaff.getPrimaryKey());

			clearUniqueFindersCache(esfRadunoStaff);
		}
	}

	protected void cacheUniqueFindersCache(ESFRadunoStaff esfRadunoStaff) {
		if (esfRadunoStaff.isNew()) {
			Object[] args = new Object[] {
					esfRadunoStaff.getId_esf_raduno(),
					esfRadunoStaff.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDRADUNOSTAFF,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF,
				args, esfRadunoStaff);
		}
		else {
			ESFRadunoStaffModelImpl esfRadunoStaffModelImpl = (ESFRadunoStaffModelImpl)esfRadunoStaff;

			if ((esfRadunoStaffModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRadunoStaff.getId_esf_raduno(),
						esfRadunoStaff.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDRADUNOSTAFF,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF,
					args, esfRadunoStaff);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFRadunoStaff esfRadunoStaff) {
		ESFRadunoStaffModelImpl esfRadunoStaffModelImpl = (ESFRadunoStaffModelImpl)esfRadunoStaff;

		Object[] args = new Object[] {
				esfRadunoStaff.getId_esf_raduno(), esfRadunoStaff.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDRADUNOSTAFF, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF, args);

		if ((esfRadunoStaffModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfRadunoStaffModelImpl.getOriginalId_esf_raduno(),
					esfRadunoStaffModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDRADUNOSTAFF,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOSTAFF,
				args);
		}
	}

	/**
	 * Creates a new e s f raduno staff with the primary key. Does not add the e s f raduno staff to the database.
	 *
	 * @param esfRadunoStaffPK the primary key for the new e s f raduno staff
	 * @return the new e s f raduno staff
	 */
	@Override
	public ESFRadunoStaff create(ESFRadunoStaffPK esfRadunoStaffPK) {
		ESFRadunoStaff esfRadunoStaff = new ESFRadunoStaffImpl();

		esfRadunoStaff.setNew(true);
		esfRadunoStaff.setPrimaryKey(esfRadunoStaffPK);

		return esfRadunoStaff;
	}

	/**
	 * Removes the e s f raduno staff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfRadunoStaffPK the primary key of the e s f raduno staff
	 * @return the e s f raduno staff that was removed
	 * @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff remove(ESFRadunoStaffPK esfRadunoStaffPK)
		throws NoSuchRadunoStaffException, SystemException {
		return remove((Serializable)esfRadunoStaffPK);
	}

	/**
	 * Removes the e s f raduno staff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f raduno staff
	 * @return the e s f raduno staff that was removed
	 * @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff remove(Serializable primaryKey)
		throws NoSuchRadunoStaffException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRadunoStaff esfRadunoStaff = (ESFRadunoStaff)session.get(ESFRadunoStaffImpl.class,
					primaryKey);

			if (esfRadunoStaff == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRadunoStaffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRadunoStaff);
		}
		catch (NoSuchRadunoStaffException nsee) {
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
	protected ESFRadunoStaff removeImpl(ESFRadunoStaff esfRadunoStaff)
		throws SystemException {
		esfRadunoStaff = toUnwrappedModel(esfRadunoStaff);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRadunoStaff)) {
				esfRadunoStaff = (ESFRadunoStaff)session.get(ESFRadunoStaffImpl.class,
						esfRadunoStaff.getPrimaryKeyObj());
			}

			if (esfRadunoStaff != null) {
				session.delete(esfRadunoStaff);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRadunoStaff != null) {
			clearCache(esfRadunoStaff);
		}

		return esfRadunoStaff;
	}

	@Override
	public ESFRadunoStaff updateImpl(
		it.ethica.esf.model.ESFRadunoStaff esfRadunoStaff)
		throws SystemException {
		esfRadunoStaff = toUnwrappedModel(esfRadunoStaff);

		boolean isNew = esfRadunoStaff.isNew();

		ESFRadunoStaffModelImpl esfRadunoStaffModelImpl = (ESFRadunoStaffModelImpl)esfRadunoStaff;

		Session session = null;

		try {
			session = openSession();

			if (esfRadunoStaff.isNew()) {
				session.save(esfRadunoStaff);

				esfRadunoStaff.setNew(false);
			}
			else {
				session.merge(esfRadunoStaff);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFRadunoStaffModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfRadunoStaffModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDRADUNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRadunoStaffModelImpl.getOriginalId_esf_raduno()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYIDRADUNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDRADUNO,
					args);

				args = new Object[] { esfRadunoStaffModelImpl.getId_esf_raduno() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYIDRADUNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDRADUNO,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoStaffImpl.class, esfRadunoStaff.getPrimaryKey(),
			esfRadunoStaff);

		clearUniqueFindersCache(esfRadunoStaff);
		cacheUniqueFindersCache(esfRadunoStaff);

		return esfRadunoStaff;
	}

	protected ESFRadunoStaff toUnwrappedModel(ESFRadunoStaff esfRadunoStaff) {
		if (esfRadunoStaff instanceof ESFRadunoStaffImpl) {
			return esfRadunoStaff;
		}

		ESFRadunoStaffImpl esfRadunoStaffImpl = new ESFRadunoStaffImpl();

		esfRadunoStaffImpl.setNew(esfRadunoStaff.isNew());
		esfRadunoStaffImpl.setPrimaryKey(esfRadunoStaff.getPrimaryKey());

		esfRadunoStaffImpl.setId_esf_raduno_staff(esfRadunoStaff.getId_esf_raduno_staff());
		esfRadunoStaffImpl.setId_esf_raduno(esfRadunoStaff.getId_esf_raduno());
		esfRadunoStaffImpl.setUserId(esfRadunoStaff.getUserId());

		return esfRadunoStaffImpl;
	}

	/**
	 * Returns the e s f raduno staff with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno staff
	 * @return the e s f raduno staff
	 * @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRadunoStaffException, SystemException {
		ESFRadunoStaff esfRadunoStaff = fetchByPrimaryKey(primaryKey);

		if (esfRadunoStaff == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRadunoStaffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRadunoStaff;
	}

	/**
	 * Returns the e s f raduno staff with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoStaffException} if it could not be found.
	 *
	 * @param esfRadunoStaffPK the primary key of the e s f raduno staff
	 * @return the e s f raduno staff
	 * @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff findByPrimaryKey(ESFRadunoStaffPK esfRadunoStaffPK)
		throws NoSuchRadunoStaffException, SystemException {
		return findByPrimaryKey((Serializable)esfRadunoStaffPK);
	}

	/**
	 * Returns the e s f raduno staff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno staff
	 * @return the e s f raduno staff, or <code>null</code> if a e s f raduno staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRadunoStaff esfRadunoStaff = (ESFRadunoStaff)EntityCacheUtil.getResult(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoStaffImpl.class, primaryKey);

		if (esfRadunoStaff == _nullESFRadunoStaff) {
			return null;
		}

		if (esfRadunoStaff == null) {
			Session session = null;

			try {
				session = openSession();

				esfRadunoStaff = (ESFRadunoStaff)session.get(ESFRadunoStaffImpl.class,
						primaryKey);

				if (esfRadunoStaff != null) {
					cacheResult(esfRadunoStaff);
				}
				else {
					EntityCacheUtil.putResult(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoStaffImpl.class, primaryKey,
						_nullESFRadunoStaff);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRadunoStaffModelImpl.ENTITY_CACHE_ENABLED,
					ESFRadunoStaffImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRadunoStaff;
	}

	/**
	 * Returns the e s f raduno staff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfRadunoStaffPK the primary key of the e s f raduno staff
	 * @return the e s f raduno staff, or <code>null</code> if a e s f raduno staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoStaff fetchByPrimaryKey(ESFRadunoStaffPK esfRadunoStaffPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfRadunoStaffPK);
	}

	/**
	 * Returns all the e s f raduno staffs.
	 *
	 * @return the e s f raduno staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoStaff> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno staffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoStaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno staffs
	 * @param end the upper bound of the range of e s f raduno staffs (not inclusive)
	 * @return the range of e s f raduno staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoStaff> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno staffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoStaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno staffs
	 * @param end the upper bound of the range of e s f raduno staffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f raduno staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoStaff> findAll(int start, int end,
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

		List<ESFRadunoStaff> list = (List<ESFRadunoStaff>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRADUNOSTAFF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRADUNOSTAFF;

				if (pagination) {
					sql = sql.concat(ESFRadunoStaffModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRadunoStaff>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoStaff>(list);
				}
				else {
					list = (List<ESFRadunoStaff>)QueryUtil.list(q,
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
	 * Removes all the e s f raduno staffs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRadunoStaff esfRadunoStaff : findAll()) {
			remove(esfRadunoStaff);
		}
	}

	/**
	 * Returns the number of e s f raduno staffs.
	 *
	 * @return the number of e s f raduno staffs
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

				Query q = session.createQuery(_SQL_COUNT_ESFRADUNOSTAFF);

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
	 * Initializes the e s f raduno staff persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRadunoStaff")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRadunoStaff>> listenersList = new ArrayList<ModelListener<ESFRadunoStaff>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRadunoStaff>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRadunoStaffImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRADUNOSTAFF = "SELECT esfRadunoStaff FROM ESFRadunoStaff esfRadunoStaff";
	private static final String _SQL_SELECT_ESFRADUNOSTAFF_WHERE = "SELECT esfRadunoStaff FROM ESFRadunoStaff esfRadunoStaff WHERE ";
	private static final String _SQL_COUNT_ESFRADUNOSTAFF = "SELECT COUNT(esfRadunoStaff) FROM ESFRadunoStaff esfRadunoStaff";
	private static final String _SQL_COUNT_ESFRADUNOSTAFF_WHERE = "SELECT COUNT(esfRadunoStaff) FROM ESFRadunoStaff esfRadunoStaff WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRadunoStaff.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRadunoStaff exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFRadunoStaff exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRadunoStaffPersistenceImpl.class);
	private static ESFRadunoStaff _nullESFRadunoStaff = new ESFRadunoStaffImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRadunoStaff> toCacheModel() {
				return _nullESFRadunoStaffCacheModel;
			}
		};

	private static CacheModel<ESFRadunoStaff> _nullESFRadunoStaffCacheModel = new CacheModel<ESFRadunoStaff>() {
			@Override
			public ESFRadunoStaff toEntityModel() {
				return _nullESFRadunoStaff;
			}
		};
}