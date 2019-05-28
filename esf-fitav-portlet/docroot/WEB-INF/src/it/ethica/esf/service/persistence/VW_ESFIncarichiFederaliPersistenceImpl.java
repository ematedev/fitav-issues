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

import it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException;
import it.ethica.esf.model.VW_ESFIncarichiFederali;
import it.ethica.esf.model.impl.VW_ESFIncarichiFederaliImpl;
import it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v w_ e s f incarichi federali service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ESFIncarichiFederaliPersistence
 * @see VW_ESFIncarichiFederaliUtil
 * @generated
 */
public class VW_ESFIncarichiFederaliPersistenceImpl extends BasePersistenceImpl<VW_ESFIncarichiFederali>
	implements VW_ESFIncarichiFederaliPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VW_ESFIncarichiFederaliUtil} to access the v w_ e s f incarichi federali persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VW_ESFIncarichiFederaliImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliModelImpl.FINDER_CACHE_ENABLED,
			VW_ESFIncarichiFederaliImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliModelImpl.FINDER_CACHE_ENABLED,
			VW_ESFIncarichiFederaliImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LISTAINCARICHI =
		new FinderPath(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliModelImpl.FINDER_CACHE_ENABLED,
			VW_ESFIncarichiFederaliImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylistaIncarichi",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LISTAINCARICHI =
		new FinderPath(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliModelImpl.FINDER_CACHE_ENABLED,
			VW_ESFIncarichiFederaliImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylistaIncarichi",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			VW_ESFIncarichiFederaliModelImpl.ACTIVE__COLUMN_BITMASK |
			VW_ESFIncarichiFederaliModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LISTAINCARICHI = new FinderPath(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylistaIncarichi",
			new String[] { Boolean.class.getName(), Long.class.getName() });

	/**
	 * Returns all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @return the matching v w_ e s f incarichi federalis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFIncarichiFederali> findBylistaIncarichi(boolean active_,
		long esfUserId) throws SystemException {
		return findBylistaIncarichi(active_, esfUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of v w_ e s f incarichi federalis
	 * @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	 * @return the range of matching v w_ e s f incarichi federalis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFIncarichiFederali> findBylistaIncarichi(boolean active_,
		long esfUserId, int start, int end) throws SystemException {
		return findBylistaIncarichi(active_, esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of v w_ e s f incarichi federalis
	 * @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v w_ e s f incarichi federalis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFIncarichiFederali> findBylistaIncarichi(boolean active_,
		long esfUserId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LISTAINCARICHI;
			finderArgs = new Object[] { active_, esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LISTAINCARICHI;
			finderArgs = new Object[] {
					active_, esfUserId,
					
					start, end, orderByComparator
				};
		}

		List<VW_ESFIncarichiFederali> list = (List<VW_ESFIncarichiFederali>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VW_ESFIncarichiFederali vw_esfIncarichiFederali : list) {
				if ((active_ != vw_esfIncarichiFederali.getActive_()) ||
						(esfUserId != vw_esfIncarichiFederali.getEsfUserId())) {
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

			query.append(_SQL_SELECT_VW_ESFINCARICHIFEDERALI_WHERE);

			query.append(_FINDER_COLUMN_LISTAINCARICHI_ACTIVE__2);

			query.append(_FINDER_COLUMN_LISTAINCARICHI_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VW_ESFIncarichiFederaliModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active_);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<VW_ESFIncarichiFederali>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VW_ESFIncarichiFederali>(list);
				}
				else {
					list = (List<VW_ESFIncarichiFederali>)QueryUtil.list(q,
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
	 * Returns the first v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v w_ e s f incarichi federali
	 * @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a matching v w_ e s f incarichi federali could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali findBylistaIncarichi_First(boolean active_,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchVW_ESFIncarichiFederaliException, SystemException {
		VW_ESFIncarichiFederali vw_esfIncarichiFederali = fetchBylistaIncarichi_First(active_,
				esfUserId, orderByComparator);

		if (vw_esfIncarichiFederali != null) {
			return vw_esfIncarichiFederali;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active_=");
		msg.append(active_);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVW_ESFIncarichiFederaliException(msg.toString());
	}

	/**
	 * Returns the first v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v w_ e s f incarichi federali, or <code>null</code> if a matching v w_ e s f incarichi federali could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali fetchBylistaIncarichi_First(
		boolean active_, long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VW_ESFIncarichiFederali> list = findBylistaIncarichi(active_,
				esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v w_ e s f incarichi federali
	 * @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a matching v w_ e s f incarichi federali could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali findBylistaIncarichi_Last(boolean active_,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchVW_ESFIncarichiFederaliException, SystemException {
		VW_ESFIncarichiFederali vw_esfIncarichiFederali = fetchBylistaIncarichi_Last(active_,
				esfUserId, orderByComparator);

		if (vw_esfIncarichiFederali != null) {
			return vw_esfIncarichiFederali;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active_=");
		msg.append(active_);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVW_ESFIncarichiFederaliException(msg.toString());
	}

	/**
	 * Returns the last v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v w_ e s f incarichi federali, or <code>null</code> if a matching v w_ e s f incarichi federali could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali fetchBylistaIncarichi_Last(boolean active_,
		long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBylistaIncarichi(active_, esfUserId);

		if (count == 0) {
			return null;
		}

		List<VW_ESFIncarichiFederali> list = findBylistaIncarichi(active_,
				esfUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v w_ e s f incarichi federalis before and after the current v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	 *
	 * @param vw_esfIncarichiFederaliPK the primary key of the current v w_ e s f incarichi federali
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v w_ e s f incarichi federali
	 * @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali[] findBylistaIncarichi_PrevAndNext(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK, boolean active_,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchVW_ESFIncarichiFederaliException, SystemException {
		VW_ESFIncarichiFederali vw_esfIncarichiFederali = findByPrimaryKey(vw_esfIncarichiFederaliPK);

		Session session = null;

		try {
			session = openSession();

			VW_ESFIncarichiFederali[] array = new VW_ESFIncarichiFederaliImpl[3];

			array[0] = getBylistaIncarichi_PrevAndNext(session,
					vw_esfIncarichiFederali, active_, esfUserId,
					orderByComparator, true);

			array[1] = vw_esfIncarichiFederali;

			array[2] = getBylistaIncarichi_PrevAndNext(session,
					vw_esfIncarichiFederali, active_, esfUserId,
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

	protected VW_ESFIncarichiFederali getBylistaIncarichi_PrevAndNext(
		Session session, VW_ESFIncarichiFederali vw_esfIncarichiFederali,
		boolean active_, long esfUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VW_ESFINCARICHIFEDERALI_WHERE);

		query.append(_FINDER_COLUMN_LISTAINCARICHI_ACTIVE__2);

		query.append(_FINDER_COLUMN_LISTAINCARICHI_ESFUSERID_2);

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
			query.append(VW_ESFIncarichiFederaliModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active_);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vw_esfIncarichiFederali);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VW_ESFIncarichiFederali> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63; from the database.
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylistaIncarichi(boolean active_, long esfUserId)
		throws SystemException {
		for (VW_ESFIncarichiFederali vw_esfIncarichiFederali : findBylistaIncarichi(
				active_, esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vw_esfIncarichiFederali);
		}
	}

	/**
	 * Returns the number of v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	 *
	 * @param active_ the active_
	 * @param esfUserId the esf user ID
	 * @return the number of matching v w_ e s f incarichi federalis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylistaIncarichi(boolean active_, long esfUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LISTAINCARICHI;

		Object[] finderArgs = new Object[] { active_, esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VW_ESFINCARICHIFEDERALI_WHERE);

			query.append(_FINDER_COLUMN_LISTAINCARICHI_ACTIVE__2);

			query.append(_FINDER_COLUMN_LISTAINCARICHI_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active_);

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

	private static final String _FINDER_COLUMN_LISTAINCARICHI_ACTIVE__2 = "vw_esfIncarichiFederali.id.active_ = ? AND ";
	private static final String _FINDER_COLUMN_LISTAINCARICHI_ESFUSERID_2 = "vw_esfIncarichiFederali.id.esfUserId = ?";

	public VW_ESFIncarichiFederaliPersistenceImpl() {
		setModelClass(VW_ESFIncarichiFederali.class);
	}

	/**
	 * Caches the v w_ e s f incarichi federali in the entity cache if it is enabled.
	 *
	 * @param vw_esfIncarichiFederali the v w_ e s f incarichi federali
	 */
	@Override
	public void cacheResult(VW_ESFIncarichiFederali vw_esfIncarichiFederali) {
		EntityCacheUtil.putResult(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliImpl.class,
			vw_esfIncarichiFederali.getPrimaryKey(), vw_esfIncarichiFederali);

		vw_esfIncarichiFederali.resetOriginalValues();
	}

	/**
	 * Caches the v w_ e s f incarichi federalis in the entity cache if it is enabled.
	 *
	 * @param vw_esfIncarichiFederalis the v w_ e s f incarichi federalis
	 */
	@Override
	public void cacheResult(
		List<VW_ESFIncarichiFederali> vw_esfIncarichiFederalis) {
		for (VW_ESFIncarichiFederali vw_esfIncarichiFederali : vw_esfIncarichiFederalis) {
			if (EntityCacheUtil.getResult(
						VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
						VW_ESFIncarichiFederaliImpl.class,
						vw_esfIncarichiFederali.getPrimaryKey()) == null) {
				cacheResult(vw_esfIncarichiFederali);
			}
			else {
				vw_esfIncarichiFederali.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v w_ e s f incarichi federalis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VW_ESFIncarichiFederaliImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VW_ESFIncarichiFederaliImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v w_ e s f incarichi federali.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VW_ESFIncarichiFederali vw_esfIncarichiFederali) {
		EntityCacheUtil.removeResult(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliImpl.class,
			vw_esfIncarichiFederali.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<VW_ESFIncarichiFederali> vw_esfIncarichiFederalis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VW_ESFIncarichiFederali vw_esfIncarichiFederali : vw_esfIncarichiFederalis) {
			EntityCacheUtil.removeResult(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
				VW_ESFIncarichiFederaliImpl.class,
				vw_esfIncarichiFederali.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v w_ e s f incarichi federali with the primary key. Does not add the v w_ e s f incarichi federali to the database.
	 *
	 * @param vw_esfIncarichiFederaliPK the primary key for the new v w_ e s f incarichi federali
	 * @return the new v w_ e s f incarichi federali
	 */
	@Override
	public VW_ESFIncarichiFederali create(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK) {
		VW_ESFIncarichiFederali vw_esfIncarichiFederali = new VW_ESFIncarichiFederaliImpl();

		vw_esfIncarichiFederali.setNew(true);
		vw_esfIncarichiFederali.setPrimaryKey(vw_esfIncarichiFederaliPK);

		return vw_esfIncarichiFederali;
	}

	/**
	 * Removes the v w_ e s f incarichi federali with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	 * @return the v w_ e s f incarichi federali that was removed
	 * @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali remove(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws NoSuchVW_ESFIncarichiFederaliException, SystemException {
		return remove((Serializable)vw_esfIncarichiFederaliPK);
	}

	/**
	 * Removes the v w_ e s f incarichi federali with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v w_ e s f incarichi federali
	 * @return the v w_ e s f incarichi federali that was removed
	 * @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali remove(Serializable primaryKey)
		throws NoSuchVW_ESFIncarichiFederaliException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VW_ESFIncarichiFederali vw_esfIncarichiFederali = (VW_ESFIncarichiFederali)session.get(VW_ESFIncarichiFederaliImpl.class,
					primaryKey);

			if (vw_esfIncarichiFederali == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVW_ESFIncarichiFederaliException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vw_esfIncarichiFederali);
		}
		catch (NoSuchVW_ESFIncarichiFederaliException nsee) {
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
	protected VW_ESFIncarichiFederali removeImpl(
		VW_ESFIncarichiFederali vw_esfIncarichiFederali)
		throws SystemException {
		vw_esfIncarichiFederali = toUnwrappedModel(vw_esfIncarichiFederali);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vw_esfIncarichiFederali)) {
				vw_esfIncarichiFederali = (VW_ESFIncarichiFederali)session.get(VW_ESFIncarichiFederaliImpl.class,
						vw_esfIncarichiFederali.getPrimaryKeyObj());
			}

			if (vw_esfIncarichiFederali != null) {
				session.delete(vw_esfIncarichiFederali);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vw_esfIncarichiFederali != null) {
			clearCache(vw_esfIncarichiFederali);
		}

		return vw_esfIncarichiFederali;
	}

	@Override
	public VW_ESFIncarichiFederali updateImpl(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali)
		throws SystemException {
		vw_esfIncarichiFederali = toUnwrappedModel(vw_esfIncarichiFederali);

		boolean isNew = vw_esfIncarichiFederali.isNew();

		VW_ESFIncarichiFederaliModelImpl vw_esfIncarichiFederaliModelImpl = (VW_ESFIncarichiFederaliModelImpl)vw_esfIncarichiFederali;

		Session session = null;

		try {
			session = openSession();

			if (vw_esfIncarichiFederali.isNew()) {
				session.save(vw_esfIncarichiFederali);

				vw_esfIncarichiFederali.setNew(false);
			}
			else {
				session.merge(vw_esfIncarichiFederali);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VW_ESFIncarichiFederaliModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vw_esfIncarichiFederaliModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LISTAINCARICHI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vw_esfIncarichiFederaliModelImpl.getOriginalActive_(),
						vw_esfIncarichiFederaliModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LISTAINCARICHI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LISTAINCARICHI,
					args);

				args = new Object[] {
						vw_esfIncarichiFederaliModelImpl.getActive_(),
						vw_esfIncarichiFederaliModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LISTAINCARICHI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LISTAINCARICHI,
					args);
			}
		}

		EntityCacheUtil.putResult(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFIncarichiFederaliImpl.class,
			vw_esfIncarichiFederali.getPrimaryKey(), vw_esfIncarichiFederali);

		return vw_esfIncarichiFederali;
	}

	protected VW_ESFIncarichiFederali toUnwrappedModel(
		VW_ESFIncarichiFederali vw_esfIncarichiFederali) {
		if (vw_esfIncarichiFederali instanceof VW_ESFIncarichiFederaliImpl) {
			return vw_esfIncarichiFederali;
		}

		VW_ESFIncarichiFederaliImpl vw_esfIncarichiFederaliImpl = new VW_ESFIncarichiFederaliImpl();

		vw_esfIncarichiFederaliImpl.setNew(vw_esfIncarichiFederali.isNew());
		vw_esfIncarichiFederaliImpl.setPrimaryKey(vw_esfIncarichiFederali.getPrimaryKey());

		vw_esfIncarichiFederaliImpl.setEsfUserId(vw_esfIncarichiFederali.getEsfUserId());
		vw_esfIncarichiFederaliImpl.setEsfFederalRoleId(vw_esfIncarichiFederali.getEsfFederalRoleId());
		vw_esfIncarichiFederaliImpl.setCode_(vw_esfIncarichiFederali.getCode_());
		vw_esfIncarichiFederaliImpl.setDescription(vw_esfIncarichiFederali.getDescription());
		vw_esfIncarichiFederaliImpl.setStartDate(vw_esfIncarichiFederali.getStartDate());
		vw_esfIncarichiFederaliImpl.setEndDate(vw_esfIncarichiFederali.getEndDate());
		vw_esfIncarichiFederaliImpl.setActive_(vw_esfIncarichiFederali.isActive_());

		return vw_esfIncarichiFederaliImpl;
	}

	/**
	 * Returns the v w_ e s f incarichi federali with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ e s f incarichi federali
	 * @return the v w_ e s f incarichi federali
	 * @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVW_ESFIncarichiFederaliException, SystemException {
		VW_ESFIncarichiFederali vw_esfIncarichiFederali = fetchByPrimaryKey(primaryKey);

		if (vw_esfIncarichiFederali == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVW_ESFIncarichiFederaliException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vw_esfIncarichiFederali;
	}

	/**
	 * Returns the v w_ e s f incarichi federali with the primary key or throws a {@link it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException} if it could not be found.
	 *
	 * @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	 * @return the v w_ e s f incarichi federali
	 * @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali findByPrimaryKey(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws NoSuchVW_ESFIncarichiFederaliException, SystemException {
		return findByPrimaryKey((Serializable)vw_esfIncarichiFederaliPK);
	}

	/**
	 * Returns the v w_ e s f incarichi federali with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ e s f incarichi federali
	 * @return the v w_ e s f incarichi federali, or <code>null</code> if a v w_ e s f incarichi federali with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VW_ESFIncarichiFederali vw_esfIncarichiFederali = (VW_ESFIncarichiFederali)EntityCacheUtil.getResult(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
				VW_ESFIncarichiFederaliImpl.class, primaryKey);

		if (vw_esfIncarichiFederali == _nullVW_ESFIncarichiFederali) {
			return null;
		}

		if (vw_esfIncarichiFederali == null) {
			Session session = null;

			try {
				session = openSession();

				vw_esfIncarichiFederali = (VW_ESFIncarichiFederali)session.get(VW_ESFIncarichiFederaliImpl.class,
						primaryKey);

				if (vw_esfIncarichiFederali != null) {
					cacheResult(vw_esfIncarichiFederali);
				}
				else {
					EntityCacheUtil.putResult(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
						VW_ESFIncarichiFederaliImpl.class, primaryKey,
						_nullVW_ESFIncarichiFederali);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VW_ESFIncarichiFederaliModelImpl.ENTITY_CACHE_ENABLED,
					VW_ESFIncarichiFederaliImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vw_esfIncarichiFederali;
	}

	/**
	 * Returns the v w_ e s f incarichi federali with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	 * @return the v w_ e s f incarichi federali, or <code>null</code> if a v w_ e s f incarichi federali with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFIncarichiFederali fetchByPrimaryKey(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vw_esfIncarichiFederaliPK);
	}

	/**
	 * Returns all the v w_ e s f incarichi federalis.
	 *
	 * @return the v w_ e s f incarichi federalis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFIncarichiFederali> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v w_ e s f incarichi federalis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ e s f incarichi federalis
	 * @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	 * @return the range of v w_ e s f incarichi federalis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFIncarichiFederali> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v w_ e s f incarichi federalis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ e s f incarichi federalis
	 * @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v w_ e s f incarichi federalis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFIncarichiFederali> findAll(int start, int end,
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

		List<VW_ESFIncarichiFederali> list = (List<VW_ESFIncarichiFederali>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VW_ESFINCARICHIFEDERALI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VW_ESFINCARICHIFEDERALI;

				if (pagination) {
					sql = sql.concat(VW_ESFIncarichiFederaliModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VW_ESFIncarichiFederali>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VW_ESFIncarichiFederali>(list);
				}
				else {
					list = (List<VW_ESFIncarichiFederali>)QueryUtil.list(q,
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
	 * Removes all the v w_ e s f incarichi federalis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VW_ESFIncarichiFederali vw_esfIncarichiFederali : findAll()) {
			remove(vw_esfIncarichiFederali);
		}
	}

	/**
	 * Returns the number of v w_ e s f incarichi federalis.
	 *
	 * @return the number of v w_ e s f incarichi federalis
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

				Query q = session.createQuery(_SQL_COUNT_VW_ESFINCARICHIFEDERALI);

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
	 * Initializes the v w_ e s f incarichi federali persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.VW_ESFIncarichiFederali")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VW_ESFIncarichiFederali>> listenersList = new ArrayList<ModelListener<VW_ESFIncarichiFederali>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VW_ESFIncarichiFederali>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VW_ESFIncarichiFederaliImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VW_ESFINCARICHIFEDERALI = "SELECT vw_esfIncarichiFederali FROM VW_ESFIncarichiFederali vw_esfIncarichiFederali";
	private static final String _SQL_SELECT_VW_ESFINCARICHIFEDERALI_WHERE = "SELECT vw_esfIncarichiFederali FROM VW_ESFIncarichiFederali vw_esfIncarichiFederali WHERE ";
	private static final String _SQL_COUNT_VW_ESFINCARICHIFEDERALI = "SELECT COUNT(vw_esfIncarichiFederali) FROM VW_ESFIncarichiFederali vw_esfIncarichiFederali";
	private static final String _SQL_COUNT_VW_ESFINCARICHIFEDERALI_WHERE = "SELECT COUNT(vw_esfIncarichiFederali) FROM VW_ESFIncarichiFederali vw_esfIncarichiFederali WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vw_esfIncarichiFederali.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VW_ESFIncarichiFederali exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VW_ESFIncarichiFederali exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VW_ESFIncarichiFederaliPersistenceImpl.class);
	private static VW_ESFIncarichiFederali _nullVW_ESFIncarichiFederali = new VW_ESFIncarichiFederaliImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VW_ESFIncarichiFederali> toCacheModel() {
				return _nullVW_ESFIncarichiFederaliCacheModel;
			}
		};

	private static CacheModel<VW_ESFIncarichiFederali> _nullVW_ESFIncarichiFederaliCacheModel =
		new CacheModel<VW_ESFIncarichiFederali>() {
			@Override
			public VW_ESFIncarichiFederali toEntityModel() {
				return _nullVW_ESFIncarichiFederali;
			}
		};
}