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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchSuspensiveShootingDirectorException;
import it.ethica.esf.model.ESFSuspensiveShootingDirector;
import it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the e s f suspensive shooting director service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveShootingDirectorPersistence
 * @see ESFSuspensiveShootingDirectorUtil
 * @generated
 */
public class ESFSuspensiveShootingDirectorPersistenceImpl
	extends BasePersistenceImpl<ESFSuspensiveShootingDirector>
	implements ESFSuspensiveShootingDirectorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFSuspensiveShootingDirectorUtil} to access the e s f suspensive shooting director persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFSuspensiveShootingDirectorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID = new FinderPath(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID =
		new FinderPath(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyUserId",
			new String[] { Long.class.getName() },
			ESFSuspensiveShootingDirectorModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERID = new FinderPath(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyUserId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f suspensive shooting directors where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findBybyUserId(long esfUserId)
		throws SystemException {
		return findBybyUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f suspensive shooting directors where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f suspensive shooting directors
	 * @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	 * @return the range of matching e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findBybyUserId(long esfUserId,
		int start, int end) throws SystemException {
		return findBybyUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f suspensive shooting directors where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f suspensive shooting directors
	 * @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findBybyUserId(long esfUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ESFSuspensiveShootingDirector> list = (List<ESFSuspensiveShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSuspensiveShootingDirector esfSuspensiveShootingDirector : list) {
				if ((esfUserId != esfSuspensiveShootingDirector.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFSUSPENSIVESHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFSuspensiveShootingDirectorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFSuspensiveShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSuspensiveShootingDirector>(list);
				}
				else {
					list = (List<ESFSuspensiveShootingDirector>)QueryUtil.list(q,
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
	 * Returns the first e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f suspensive shooting director
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector findBybyUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = fetchBybyUserId_First(esfUserId,
				orderByComparator);

		if (esfSuspensiveShootingDirector != null) {
			return esfSuspensiveShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSuspensiveShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the first e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector fetchBybyUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSuspensiveShootingDirector> list = findBybyUserId(esfUserId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f suspensive shooting director
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector findBybyUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = fetchBybyUserId_Last(esfUserId,
				orderByComparator);

		if (esfSuspensiveShootingDirector != null) {
			return esfSuspensiveShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSuspensiveShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the last e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector fetchBybyUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFSuspensiveShootingDirector> list = findBybyUserId(esfUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f suspensive shooting directors before and after the current e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key of the current e s f suspensive shooting director
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f suspensive shooting director
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector[] findBybyUserId_PrevAndNext(
		long esfSuspensiveShooingDirectorId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = findByPrimaryKey(esfSuspensiveShooingDirectorId);

		Session session = null;

		try {
			session = openSession();

			ESFSuspensiveShootingDirector[] array = new ESFSuspensiveShootingDirectorImpl[3];

			array[0] = getBybyUserId_PrevAndNext(session,
					esfSuspensiveShootingDirector, esfUserId,
					orderByComparator, true);

			array[1] = esfSuspensiveShootingDirector;

			array[2] = getBybyUserId_PrevAndNext(session,
					esfSuspensiveShootingDirector, esfUserId,
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

	protected ESFSuspensiveShootingDirector getBybyUserId_PrevAndNext(
		Session session,
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector,
		long esfUserId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSUSPENSIVESHOOTINGDIRECTOR_WHERE);

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
			query.append(ESFSuspensiveShootingDirectorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfSuspensiveShootingDirector);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSuspensiveShootingDirector> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f suspensive shooting directors where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyUserId(long esfUserId) throws SystemException {
		for (ESFSuspensiveShootingDirector esfSuspensiveShootingDirector : findBybyUserId(
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfSuspensiveShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f suspensive shooting directors where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f suspensive shooting directors
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

			query.append(_SQL_COUNT_ESFSUSPENSIVESHOOTINGDIRECTOR_WHERE);

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

	private static final String _FINDER_COLUMN_BYUSERID_ESFUSERID_2 = "esfSuspensiveShootingDirector.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE = new FinderPath(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATE = new FinderPath(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDate",
			new String[] { Date.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @return the matching e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findByDate(Date esfEndData,
		long esfUserId) throws SystemException {
		return findByDate(esfEndData, esfUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f suspensive shooting directors
	 * @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	 * @return the range of matching e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findByDate(Date esfEndData,
		long esfUserId, int start, int end) throws SystemException {
		return findByDate(esfEndData, esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f suspensive shooting directors
	 * @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findByDate(Date esfEndData,
		long esfUserId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE;
		finderArgs = new Object[] {
				esfEndData, esfUserId,
				
				start, end, orderByComparator
			};

		List<ESFSuspensiveShootingDirector> list = (List<ESFSuspensiveShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSuspensiveShootingDirector esfSuspensiveShootingDirector : list) {
				if ((esfEndData.getTime() >= esfSuspensiveShootingDirector.getEsfEndData()
																			  .getTime()) ||
						(esfUserId != esfSuspensiveShootingDirector.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFSUSPENSIVESHOOTINGDIRECTOR_WHERE);

			boolean bindEsfEndData = false;

			if (esfEndData == null) {
				query.append(_FINDER_COLUMN_DATE_ESFENDDATA_1);
			}
			else {
				bindEsfEndData = true;

				query.append(_FINDER_COLUMN_DATE_ESFENDDATA_2);
			}

			query.append(_FINDER_COLUMN_DATE_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFSuspensiveShootingDirectorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEsfEndData) {
					qPos.add(CalendarUtil.getTimestamp(esfEndData));
				}

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFSuspensiveShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSuspensiveShootingDirector>(list);
				}
				else {
					list = (List<ESFSuspensiveShootingDirector>)QueryUtil.list(q,
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
	 * Returns the first e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f suspensive shooting director
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector findByDate_First(Date esfEndData,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = fetchByDate_First(esfEndData,
				esfUserId, orderByComparator);

		if (esfSuspensiveShootingDirector != null) {
			return esfSuspensiveShootingDirector;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfEndData=");
		msg.append(esfEndData);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSuspensiveShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the first e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector fetchByDate_First(Date esfEndData,
		long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFSuspensiveShootingDirector> list = findByDate(esfEndData,
				esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f suspensive shooting director
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector findByDate_Last(Date esfEndData,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = fetchByDate_Last(esfEndData,
				esfUserId, orderByComparator);

		if (esfSuspensiveShootingDirector != null) {
			return esfSuspensiveShootingDirector;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfEndData=");
		msg.append(esfEndData);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSuspensiveShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the last e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector fetchByDate_Last(Date esfEndData,
		long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDate(esfEndData, esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFSuspensiveShootingDirector> list = findByDate(esfEndData,
				esfUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f suspensive shooting directors before and after the current e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key of the current e s f suspensive shooting director
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f suspensive shooting director
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector[] findByDate_PrevAndNext(
		long esfSuspensiveShooingDirectorId, Date esfEndData, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = findByPrimaryKey(esfSuspensiveShooingDirectorId);

		Session session = null;

		try {
			session = openSession();

			ESFSuspensiveShootingDirector[] array = new ESFSuspensiveShootingDirectorImpl[3];

			array[0] = getByDate_PrevAndNext(session,
					esfSuspensiveShootingDirector, esfEndData, esfUserId,
					orderByComparator, true);

			array[1] = esfSuspensiveShootingDirector;

			array[2] = getByDate_PrevAndNext(session,
					esfSuspensiveShootingDirector, esfEndData, esfUserId,
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

	protected ESFSuspensiveShootingDirector getByDate_PrevAndNext(
		Session session,
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector,
		Date esfEndData, long esfUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSUSPENSIVESHOOTINGDIRECTOR_WHERE);

		boolean bindEsfEndData = false;

		if (esfEndData == null) {
			query.append(_FINDER_COLUMN_DATE_ESFENDDATA_1);
		}
		else {
			bindEsfEndData = true;

			query.append(_FINDER_COLUMN_DATE_ESFENDDATA_2);
		}

		query.append(_FINDER_COLUMN_DATE_ESFUSERID_2);

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
			query.append(ESFSuspensiveShootingDirectorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEsfEndData) {
			qPos.add(CalendarUtil.getTimestamp(esfEndData));
		}

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfSuspensiveShootingDirector);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSuspensiveShootingDirector> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63; from the database.
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDate(Date esfEndData, long esfUserId)
		throws SystemException {
		for (ESFSuspensiveShootingDirector esfSuspensiveShootingDirector : findByDate(
				esfEndData, esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(esfSuspensiveShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	 *
	 * @param esfEndData the esf end data
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDate(Date esfEndData, long esfUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATE;

		Object[] finderArgs = new Object[] { esfEndData, esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFSUSPENSIVESHOOTINGDIRECTOR_WHERE);

			boolean bindEsfEndData = false;

			if (esfEndData == null) {
				query.append(_FINDER_COLUMN_DATE_ESFENDDATA_1);
			}
			else {
				bindEsfEndData = true;

				query.append(_FINDER_COLUMN_DATE_ESFENDDATA_2);
			}

			query.append(_FINDER_COLUMN_DATE_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEsfEndData) {
					qPos.add(CalendarUtil.getTimestamp(esfEndData));
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

	private static final String _FINDER_COLUMN_DATE_ESFENDDATA_1 = "esfSuspensiveShootingDirector.esfEndData > NULL AND ";
	private static final String _FINDER_COLUMN_DATE_ESFENDDATA_2 = "esfSuspensiveShootingDirector.esfEndData > ? AND ";
	private static final String _FINDER_COLUMN_DATE_ESFUSERID_2 = "esfSuspensiveShootingDirector.esfUserId = ?";

	public ESFSuspensiveShootingDirectorPersistenceImpl() {
		setModelClass(ESFSuspensiveShootingDirector.class);
	}

	/**
	 * Caches the e s f suspensive shooting director in the entity cache if it is enabled.
	 *
	 * @param esfSuspensiveShootingDirector the e s f suspensive shooting director
	 */
	@Override
	public void cacheResult(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector) {
		EntityCacheUtil.putResult(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorImpl.class,
			esfSuspensiveShootingDirector.getPrimaryKey(),
			esfSuspensiveShootingDirector);

		esfSuspensiveShootingDirector.resetOriginalValues();
	}

	/**
	 * Caches the e s f suspensive shooting directors in the entity cache if it is enabled.
	 *
	 * @param esfSuspensiveShootingDirectors the e s f suspensive shooting directors
	 */
	@Override
	public void cacheResult(
		List<ESFSuspensiveShootingDirector> esfSuspensiveShootingDirectors) {
		for (ESFSuspensiveShootingDirector esfSuspensiveShootingDirector : esfSuspensiveShootingDirectors) {
			if (EntityCacheUtil.getResult(
						ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
						ESFSuspensiveShootingDirectorImpl.class,
						esfSuspensiveShootingDirector.getPrimaryKey()) == null) {
				cacheResult(esfSuspensiveShootingDirector);
			}
			else {
				esfSuspensiveShootingDirector.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f suspensive shooting directors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFSuspensiveShootingDirectorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFSuspensiveShootingDirectorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f suspensive shooting director.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector) {
		EntityCacheUtil.removeResult(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorImpl.class,
			esfSuspensiveShootingDirector.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFSuspensiveShootingDirector> esfSuspensiveShootingDirectors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFSuspensiveShootingDirector esfSuspensiveShootingDirector : esfSuspensiveShootingDirectors) {
			EntityCacheUtil.removeResult(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
				ESFSuspensiveShootingDirectorImpl.class,
				esfSuspensiveShootingDirector.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f suspensive shooting director with the primary key. Does not add the e s f suspensive shooting director to the database.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key for the new e s f suspensive shooting director
	 * @return the new e s f suspensive shooting director
	 */
	@Override
	public ESFSuspensiveShootingDirector create(
		long esfSuspensiveShooingDirectorId) {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = new ESFSuspensiveShootingDirectorImpl();

		esfSuspensiveShootingDirector.setNew(true);
		esfSuspensiveShootingDirector.setPrimaryKey(esfSuspensiveShooingDirectorId);

		return esfSuspensiveShootingDirector;
	}

	/**
	 * Removes the e s f suspensive shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	 * @return the e s f suspensive shooting director that was removed
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector remove(
		long esfSuspensiveShooingDirectorId)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		return remove((Serializable)esfSuspensiveShooingDirectorId);
	}

	/**
	 * Removes the e s f suspensive shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f suspensive shooting director
	 * @return the e s f suspensive shooting director that was removed
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector remove(Serializable primaryKey)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = (ESFSuspensiveShootingDirector)session.get(ESFSuspensiveShootingDirectorImpl.class,
					primaryKey);

			if (esfSuspensiveShootingDirector == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSuspensiveShootingDirectorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfSuspensiveShootingDirector);
		}
		catch (NoSuchSuspensiveShootingDirectorException nsee) {
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
	protected ESFSuspensiveShootingDirector removeImpl(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector)
		throws SystemException {
		esfSuspensiveShootingDirector = toUnwrappedModel(esfSuspensiveShootingDirector);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfSuspensiveShootingDirector)) {
				esfSuspensiveShootingDirector = (ESFSuspensiveShootingDirector)session.get(ESFSuspensiveShootingDirectorImpl.class,
						esfSuspensiveShootingDirector.getPrimaryKeyObj());
			}

			if (esfSuspensiveShootingDirector != null) {
				session.delete(esfSuspensiveShootingDirector);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfSuspensiveShootingDirector != null) {
			clearCache(esfSuspensiveShootingDirector);
		}

		return esfSuspensiveShootingDirector;
	}

	@Override
	public ESFSuspensiveShootingDirector updateImpl(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector)
		throws SystemException {
		esfSuspensiveShootingDirector = toUnwrappedModel(esfSuspensiveShootingDirector);

		boolean isNew = esfSuspensiveShootingDirector.isNew();

		ESFSuspensiveShootingDirectorModelImpl esfSuspensiveShootingDirectorModelImpl =
			(ESFSuspensiveShootingDirectorModelImpl)esfSuspensiveShootingDirector;

		Session session = null;

		try {
			session = openSession();

			if (esfSuspensiveShootingDirector.isNew()) {
				session.save(esfSuspensiveShootingDirector);

				esfSuspensiveShootingDirector.setNew(false);
			}
			else {
				session.merge(esfSuspensiveShootingDirector);
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
				!ESFSuspensiveShootingDirectorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfSuspensiveShootingDirectorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSuspensiveShootingDirectorModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);

				args = new Object[] {
						esfSuspensiveShootingDirectorModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShootingDirectorImpl.class,
			esfSuspensiveShootingDirector.getPrimaryKey(),
			esfSuspensiveShootingDirector);

		return esfSuspensiveShootingDirector;
	}

	protected ESFSuspensiveShootingDirector toUnwrappedModel(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector) {
		if (esfSuspensiveShootingDirector instanceof ESFSuspensiveShootingDirectorImpl) {
			return esfSuspensiveShootingDirector;
		}

		ESFSuspensiveShootingDirectorImpl esfSuspensiveShootingDirectorImpl = new ESFSuspensiveShootingDirectorImpl();

		esfSuspensiveShootingDirectorImpl.setNew(esfSuspensiveShootingDirector.isNew());
		esfSuspensiveShootingDirectorImpl.setPrimaryKey(esfSuspensiveShootingDirector.getPrimaryKey());

		esfSuspensiveShootingDirectorImpl.setEsfSuspensiveShooingDirectorId(esfSuspensiveShootingDirector.getEsfSuspensiveShooingDirectorId());
		esfSuspensiveShootingDirectorImpl.setEsfData(esfSuspensiveShootingDirector.getEsfData());
		esfSuspensiveShootingDirectorImpl.setEsfCodeData(esfSuspensiveShootingDirector.getEsfCodeData());
		esfSuspensiveShootingDirectorImpl.setEsfStartData(esfSuspensiveShootingDirector.getEsfStartData());
		esfSuspensiveShootingDirectorImpl.setEsfEndData(esfSuspensiveShootingDirector.getEsfEndData());
		esfSuspensiveShootingDirectorImpl.setEsfUserId(esfSuspensiveShootingDirector.getEsfUserId());
		esfSuspensiveShootingDirectorImpl.setCodeUser(esfSuspensiveShootingDirector.getCodeUser());
		esfSuspensiveShootingDirectorImpl.setCodice_Sosp(esfSuspensiveShootingDirector.getCodice_Sosp());
		esfSuspensiveShootingDirectorImpl.setNote(esfSuspensiveShootingDirector.getNote());
		esfSuspensiveShootingDirectorImpl.setQualif1_Utiliz(esfSuspensiveShootingDirector.getQualif1_Utiliz());
		esfSuspensiveShootingDirectorImpl.setQualif2_Utiliz(esfSuspensiveShootingDirector.getQualif2_Utiliz());
		esfSuspensiveShootingDirectorImpl.setQualif3_Utiliz(esfSuspensiveShootingDirector.getQualif3_Utiliz());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara1_noUtil(esfSuspensiveShootingDirector.getTipo_Gara1_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara2_noUtil(esfSuspensiveShootingDirector.getTipo_Gara2_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara3_noUtil(esfSuspensiveShootingDirector.getTipo_Gara3_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara4_noUtil(esfSuspensiveShootingDirector.getTipo_Gara4_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara5_noUtil(esfSuspensiveShootingDirector.getTipo_Gara5_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara6_noUtil(esfSuspensiveShootingDirector.getTipo_Gara6_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara7_noUtil(esfSuspensiveShootingDirector.getTipo_Gara7_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara8_noUtil(esfSuspensiveShootingDirector.getTipo_Gara8_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara9_noUtil(esfSuspensiveShootingDirector.getTipo_Gara9_noUtil());
		esfSuspensiveShootingDirectorImpl.setTipo_Gara10_noUtil(esfSuspensiveShootingDirector.getTipo_Gara10_noUtil());
		esfSuspensiveShootingDirectorImpl.setEsfVariationData(esfSuspensiveShootingDirector.getEsfVariationData());

		return esfSuspensiveShootingDirectorImpl;
	}

	/**
	 * Returns the e s f suspensive shooting director with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f suspensive shooting director
	 * @return the e s f suspensive shooting director
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = fetchByPrimaryKey(primaryKey);

		if (esfSuspensiveShootingDirector == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSuspensiveShootingDirectorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfSuspensiveShootingDirector;
	}

	/**
	 * Returns the e s f suspensive shooting director with the primary key or throws a {@link it.ethica.esf.NoSuchSuspensiveShootingDirectorException} if it could not be found.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	 * @return the e s f suspensive shooting director
	 * @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector findByPrimaryKey(
		long esfSuspensiveShooingDirectorId)
		throws NoSuchSuspensiveShootingDirectorException, SystemException {
		return findByPrimaryKey((Serializable)esfSuspensiveShooingDirectorId);
	}

	/**
	 * Returns the e s f suspensive shooting director with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f suspensive shooting director
	 * @return the e s f suspensive shooting director, or <code>null</code> if a e s f suspensive shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector = (ESFSuspensiveShootingDirector)EntityCacheUtil.getResult(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
				ESFSuspensiveShootingDirectorImpl.class, primaryKey);

		if (esfSuspensiveShootingDirector == _nullESFSuspensiveShootingDirector) {
			return null;
		}

		if (esfSuspensiveShootingDirector == null) {
			Session session = null;

			try {
				session = openSession();

				esfSuspensiveShootingDirector = (ESFSuspensiveShootingDirector)session.get(ESFSuspensiveShootingDirectorImpl.class,
						primaryKey);

				if (esfSuspensiveShootingDirector != null) {
					cacheResult(esfSuspensiveShootingDirector);
				}
				else {
					EntityCacheUtil.putResult(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
						ESFSuspensiveShootingDirectorImpl.class, primaryKey,
						_nullESFSuspensiveShootingDirector);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFSuspensiveShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
					ESFSuspensiveShootingDirectorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfSuspensiveShootingDirector;
	}

	/**
	 * Returns the e s f suspensive shooting director with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	 * @return the e s f suspensive shooting director, or <code>null</code> if a e s f suspensive shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShootingDirector fetchByPrimaryKey(
		long esfSuspensiveShooingDirectorId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfSuspensiveShooingDirectorId);
	}

	/**
	 * Returns all the e s f suspensive shooting directors.
	 *
	 * @return the e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f suspensive shooting directors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f suspensive shooting directors
	 * @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	 * @return the range of e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f suspensive shooting directors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f suspensive shooting directors
	 * @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f suspensive shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShootingDirector> findAll(int start, int end,
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

		List<ESFSuspensiveShootingDirector> list = (List<ESFSuspensiveShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSUSPENSIVESHOOTINGDIRECTOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSUSPENSIVESHOOTINGDIRECTOR;

				if (pagination) {
					sql = sql.concat(ESFSuspensiveShootingDirectorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFSuspensiveShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSuspensiveShootingDirector>(list);
				}
				else {
					list = (List<ESFSuspensiveShootingDirector>)QueryUtil.list(q,
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
	 * Removes all the e s f suspensive shooting directors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFSuspensiveShootingDirector esfSuspensiveShootingDirector : findAll()) {
			remove(esfSuspensiveShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f suspensive shooting directors.
	 *
	 * @return the number of e s f suspensive shooting directors
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

				Query q = session.createQuery(_SQL_COUNT_ESFSUSPENSIVESHOOTINGDIRECTOR);

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
	 * Initializes the e s f suspensive shooting director persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFSuspensiveShootingDirector")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFSuspensiveShootingDirector>> listenersList =
					new ArrayList<ModelListener<ESFSuspensiveShootingDirector>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFSuspensiveShootingDirector>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFSuspensiveShootingDirectorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSUSPENSIVESHOOTINGDIRECTOR = "SELECT esfSuspensiveShootingDirector FROM ESFSuspensiveShootingDirector esfSuspensiveShootingDirector";
	private static final String _SQL_SELECT_ESFSUSPENSIVESHOOTINGDIRECTOR_WHERE = "SELECT esfSuspensiveShootingDirector FROM ESFSuspensiveShootingDirector esfSuspensiveShootingDirector WHERE ";
	private static final String _SQL_COUNT_ESFSUSPENSIVESHOOTINGDIRECTOR = "SELECT COUNT(esfSuspensiveShootingDirector) FROM ESFSuspensiveShootingDirector esfSuspensiveShootingDirector";
	private static final String _SQL_COUNT_ESFSUSPENSIVESHOOTINGDIRECTOR_WHERE = "SELECT COUNT(esfSuspensiveShootingDirector) FROM ESFSuspensiveShootingDirector esfSuspensiveShootingDirector WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfSuspensiveShootingDirector.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFSuspensiveShootingDirector exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFSuspensiveShootingDirector exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFSuspensiveShootingDirectorPersistenceImpl.class);
	private static ESFSuspensiveShootingDirector _nullESFSuspensiveShootingDirector =
		new ESFSuspensiveShootingDirectorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFSuspensiveShootingDirector> toCacheModel() {
				return _nullESFSuspensiveShootingDirectorCacheModel;
			}
		};

	private static CacheModel<ESFSuspensiveShootingDirector> _nullESFSuspensiveShootingDirectorCacheModel =
		new CacheModel<ESFSuspensiveShootingDirector>() {
			@Override
			public ESFSuspensiveShootingDirector toEntityModel() {
				return _nullESFSuspensiveShootingDirector;
			}
		};
}