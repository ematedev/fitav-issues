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

import it.ethica.esf.NoSuchRadunoSottotipiRadunoException;
import it.ethica.esf.model.ESFRadunoSottotipiRaduno;
import it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoImpl;
import it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f raduno sottotipi raduno service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoSottotipiRadunoPersistence
 * @see ESFRadunoSottotipiRadunoUtil
 * @generated
 */
public class ESFRadunoSottotipiRadunoPersistenceImpl extends BasePersistenceImpl<ESFRadunoSottotipiRaduno>
	implements ESFRadunoSottotipiRadunoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRadunoSottotipiRadunoUtil} to access the e s f raduno sottotipi raduno persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRadunoSottotipiRadunoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYIDESFRADUNO =
		new FinderPath(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByIdEsfRaduno",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDESFRADUNO =
		new FinderPath(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByfindByIdEsfRaduno", new String[] { Long.class.getName() },
			ESFRadunoSottotipiRadunoModelImpl.ID_ESF_RADUNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYIDESFRADUNO = new FinderPath(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByIdEsfRaduno", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f raduno sottotipi radunos where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @return the matching e s f raduno sottotipi radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipiRaduno> findByfindByIdEsfRaduno(
		long id_esf_raduno) throws SystemException {
		return findByfindByIdEsfRaduno(id_esf_raduno, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno sottotipi radunos where id_esf_raduno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param start the lower bound of the range of e s f raduno sottotipi radunos
	 * @param end the upper bound of the range of e s f raduno sottotipi radunos (not inclusive)
	 * @return the range of matching e s f raduno sottotipi radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipiRaduno> findByfindByIdEsfRaduno(
		long id_esf_raduno, int start, int end) throws SystemException {
		return findByfindByIdEsfRaduno(id_esf_raduno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno sottotipi radunos where id_esf_raduno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param start the lower bound of the range of e s f raduno sottotipi radunos
	 * @param end the upper bound of the range of e s f raduno sottotipi radunos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f raduno sottotipi radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipiRaduno> findByfindByIdEsfRaduno(
		long id_esf_raduno, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDESFRADUNO;
			finderArgs = new Object[] { id_esf_raduno };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYIDESFRADUNO;
			finderArgs = new Object[] {
					id_esf_raduno,
					
					start, end, orderByComparator
				};
		}

		List<ESFRadunoSottotipiRaduno> list = (List<ESFRadunoSottotipiRaduno>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno : list) {
				if ((id_esf_raduno != esfRadunoSottotipiRaduno.getId_esf_raduno())) {
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

			query.append(_SQL_SELECT_ESFRADUNOSOTTOTIPIRADUNO_WHERE);

			query.append(_FINDER_COLUMN_FINDBYIDESFRADUNO_ID_ESF_RADUNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRadunoSottotipiRadunoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				if (!pagination) {
					list = (List<ESFRadunoSottotipiRaduno>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoSottotipiRaduno>(list);
				}
				else {
					list = (List<ESFRadunoSottotipiRaduno>)QueryUtil.list(q,
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
	 * Returns the first e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f raduno sottotipi raduno
	 * @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a matching e s f raduno sottotipi raduno could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno findByfindByIdEsfRaduno_First(
		long id_esf_raduno, OrderByComparator orderByComparator)
		throws NoSuchRadunoSottotipiRadunoException, SystemException {
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno = fetchByfindByIdEsfRaduno_First(id_esf_raduno,
				orderByComparator);

		if (esfRadunoSottotipiRaduno != null) {
			return esfRadunoSottotipiRaduno;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_esf_raduno=");
		msg.append(id_esf_raduno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRadunoSottotipiRadunoException(msg.toString());
	}

	/**
	 * Returns the first e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f raduno sottotipi raduno, or <code>null</code> if a matching e s f raduno sottotipi raduno could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno fetchByfindByIdEsfRaduno_First(
		long id_esf_raduno, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFRadunoSottotipiRaduno> list = findByfindByIdEsfRaduno(id_esf_raduno,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f raduno sottotipi raduno
	 * @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a matching e s f raduno sottotipi raduno could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno findByfindByIdEsfRaduno_Last(
		long id_esf_raduno, OrderByComparator orderByComparator)
		throws NoSuchRadunoSottotipiRadunoException, SystemException {
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno = fetchByfindByIdEsfRaduno_Last(id_esf_raduno,
				orderByComparator);

		if (esfRadunoSottotipiRaduno != null) {
			return esfRadunoSottotipiRaduno;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_esf_raduno=");
		msg.append(id_esf_raduno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRadunoSottotipiRadunoException(msg.toString());
	}

	/**
	 * Returns the last e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f raduno sottotipi raduno, or <code>null</code> if a matching e s f raduno sottotipi raduno could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno fetchByfindByIdEsfRaduno_Last(
		long id_esf_raduno, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByfindByIdEsfRaduno(id_esf_raduno);

		if (count == 0) {
			return null;
		}

		List<ESFRadunoSottotipiRaduno> list = findByfindByIdEsfRaduno(id_esf_raduno,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f raduno sottotipi radunos before and after the current e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno_sottotipi_raduno the primary key of the current e s f raduno sottotipi raduno
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f raduno sottotipi raduno
	 * @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a e s f raduno sottotipi raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno[] findByfindByIdEsfRaduno_PrevAndNext(
		long id_esf_raduno_sottotipi_raduno, long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchRadunoSottotipiRadunoException, SystemException {
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno = findByPrimaryKey(id_esf_raduno_sottotipi_raduno);

		Session session = null;

		try {
			session = openSession();

			ESFRadunoSottotipiRaduno[] array = new ESFRadunoSottotipiRadunoImpl[3];

			array[0] = getByfindByIdEsfRaduno_PrevAndNext(session,
					esfRadunoSottotipiRaduno, id_esf_raduno, orderByComparator,
					true);

			array[1] = esfRadunoSottotipiRaduno;

			array[2] = getByfindByIdEsfRaduno_PrevAndNext(session,
					esfRadunoSottotipiRaduno, id_esf_raduno, orderByComparator,
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

	protected ESFRadunoSottotipiRaduno getByfindByIdEsfRaduno_PrevAndNext(
		Session session, ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno,
		long id_esf_raduno, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRADUNOSOTTOTIPIRADUNO_WHERE);

		query.append(_FINDER_COLUMN_FINDBYIDESFRADUNO_ID_ESF_RADUNO_2);

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
			query.append(ESFRadunoSottotipiRadunoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_esf_raduno);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRadunoSottotipiRaduno);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRadunoSottotipiRaduno> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f raduno sottotipi radunos where id_esf_raduno = &#63; from the database.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByfindByIdEsfRaduno(long id_esf_raduno)
		throws SystemException {
		for (ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno : findByfindByIdEsfRaduno(
				id_esf_raduno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRadunoSottotipiRaduno);
		}
	}

	/**
	 * Returns the number of e s f raduno sottotipi radunos where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @return the number of matching e s f raduno sottotipi radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByIdEsfRaduno(long id_esf_raduno)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYIDESFRADUNO;

		Object[] finderArgs = new Object[] { id_esf_raduno };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRADUNOSOTTOTIPIRADUNO_WHERE);

			query.append(_FINDER_COLUMN_FINDBYIDESFRADUNO_ID_ESF_RADUNO_2);

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

	private static final String _FINDER_COLUMN_FINDBYIDESFRADUNO_ID_ESF_RADUNO_2 =
		"esfRadunoSottotipiRaduno.id_esf_raduno = ?";

	public ESFRadunoSottotipiRadunoPersistenceImpl() {
		setModelClass(ESFRadunoSottotipiRaduno.class);
	}

	/**
	 * Caches the e s f raduno sottotipi raduno in the entity cache if it is enabled.
	 *
	 * @param esfRadunoSottotipiRaduno the e s f raduno sottotipi raduno
	 */
	@Override
	public void cacheResult(ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno) {
		EntityCacheUtil.putResult(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoImpl.class,
			esfRadunoSottotipiRaduno.getPrimaryKey(), esfRadunoSottotipiRaduno);

		esfRadunoSottotipiRaduno.resetOriginalValues();
	}

	/**
	 * Caches the e s f raduno sottotipi radunos in the entity cache if it is enabled.
	 *
	 * @param esfRadunoSottotipiRadunos the e s f raduno sottotipi radunos
	 */
	@Override
	public void cacheResult(
		List<ESFRadunoSottotipiRaduno> esfRadunoSottotipiRadunos) {
		for (ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno : esfRadunoSottotipiRadunos) {
			if (EntityCacheUtil.getResult(
						ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoSottotipiRadunoImpl.class,
						esfRadunoSottotipiRaduno.getPrimaryKey()) == null) {
				cacheResult(esfRadunoSottotipiRaduno);
			}
			else {
				esfRadunoSottotipiRaduno.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f raduno sottotipi radunos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRadunoSottotipiRadunoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRadunoSottotipiRadunoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f raduno sottotipi raduno.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno) {
		EntityCacheUtil.removeResult(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoImpl.class,
			esfRadunoSottotipiRaduno.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFRadunoSottotipiRaduno> esfRadunoSottotipiRadunos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno : esfRadunoSottotipiRadunos) {
			EntityCacheUtil.removeResult(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoSottotipiRadunoImpl.class,
				esfRadunoSottotipiRaduno.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f raduno sottotipi raduno with the primary key. Does not add the e s f raduno sottotipi raduno to the database.
	 *
	 * @param id_esf_raduno_sottotipi_raduno the primary key for the new e s f raduno sottotipi raduno
	 * @return the new e s f raduno sottotipi raduno
	 */
	@Override
	public ESFRadunoSottotipiRaduno create(long id_esf_raduno_sottotipi_raduno) {
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno = new ESFRadunoSottotipiRadunoImpl();

		esfRadunoSottotipiRaduno.setNew(true);
		esfRadunoSottotipiRaduno.setPrimaryKey(id_esf_raduno_sottotipi_raduno);

		return esfRadunoSottotipiRaduno;
	}

	/**
	 * Removes the e s f raduno sottotipi raduno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_esf_raduno_sottotipi_raduno the primary key of the e s f raduno sottotipi raduno
	 * @return the e s f raduno sottotipi raduno that was removed
	 * @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a e s f raduno sottotipi raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno remove(long id_esf_raduno_sottotipi_raduno)
		throws NoSuchRadunoSottotipiRadunoException, SystemException {
		return remove((Serializable)id_esf_raduno_sottotipi_raduno);
	}

	/**
	 * Removes the e s f raduno sottotipi raduno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f raduno sottotipi raduno
	 * @return the e s f raduno sottotipi raduno that was removed
	 * @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a e s f raduno sottotipi raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno remove(Serializable primaryKey)
		throws NoSuchRadunoSottotipiRadunoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno = (ESFRadunoSottotipiRaduno)session.get(ESFRadunoSottotipiRadunoImpl.class,
					primaryKey);

			if (esfRadunoSottotipiRaduno == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRadunoSottotipiRadunoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRadunoSottotipiRaduno);
		}
		catch (NoSuchRadunoSottotipiRadunoException nsee) {
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
	protected ESFRadunoSottotipiRaduno removeImpl(
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno)
		throws SystemException {
		esfRadunoSottotipiRaduno = toUnwrappedModel(esfRadunoSottotipiRaduno);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRadunoSottotipiRaduno)) {
				esfRadunoSottotipiRaduno = (ESFRadunoSottotipiRaduno)session.get(ESFRadunoSottotipiRadunoImpl.class,
						esfRadunoSottotipiRaduno.getPrimaryKeyObj());
			}

			if (esfRadunoSottotipiRaduno != null) {
				session.delete(esfRadunoSottotipiRaduno);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRadunoSottotipiRaduno != null) {
			clearCache(esfRadunoSottotipiRaduno);
		}

		return esfRadunoSottotipiRaduno;
	}

	@Override
	public ESFRadunoSottotipiRaduno updateImpl(
		it.ethica.esf.model.ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno)
		throws SystemException {
		esfRadunoSottotipiRaduno = toUnwrappedModel(esfRadunoSottotipiRaduno);

		boolean isNew = esfRadunoSottotipiRaduno.isNew();

		ESFRadunoSottotipiRadunoModelImpl esfRadunoSottotipiRadunoModelImpl = (ESFRadunoSottotipiRadunoModelImpl)esfRadunoSottotipiRaduno;

		Session session = null;

		try {
			session = openSession();

			if (esfRadunoSottotipiRaduno.isNew()) {
				session.save(esfRadunoSottotipiRaduno);

				esfRadunoSottotipiRaduno.setNew(false);
			}
			else {
				session.merge(esfRadunoSottotipiRaduno);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFRadunoSottotipiRadunoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfRadunoSottotipiRadunoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDESFRADUNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRadunoSottotipiRadunoModelImpl.getOriginalId_esf_raduno()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYIDESFRADUNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDESFRADUNO,
					args);

				args = new Object[] {
						esfRadunoSottotipiRadunoModelImpl.getId_esf_raduno()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYIDESFRADUNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYIDESFRADUNO,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipiRadunoImpl.class,
			esfRadunoSottotipiRaduno.getPrimaryKey(), esfRadunoSottotipiRaduno);

		return esfRadunoSottotipiRaduno;
	}

	protected ESFRadunoSottotipiRaduno toUnwrappedModel(
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno) {
		if (esfRadunoSottotipiRaduno instanceof ESFRadunoSottotipiRadunoImpl) {
			return esfRadunoSottotipiRaduno;
		}

		ESFRadunoSottotipiRadunoImpl esfRadunoSottotipiRadunoImpl = new ESFRadunoSottotipiRadunoImpl();

		esfRadunoSottotipiRadunoImpl.setNew(esfRadunoSottotipiRaduno.isNew());
		esfRadunoSottotipiRadunoImpl.setPrimaryKey(esfRadunoSottotipiRaduno.getPrimaryKey());

		esfRadunoSottotipiRadunoImpl.setId_esf_raduno_sottotipi_raduno(esfRadunoSottotipiRaduno.getId_esf_raduno_sottotipi_raduno());
		esfRadunoSottotipiRadunoImpl.setId_esf_raduno(esfRadunoSottotipiRaduno.getId_esf_raduno());
		esfRadunoSottotipiRadunoImpl.setId_esf_raduno_sottotipo(esfRadunoSottotipiRaduno.getId_esf_raduno_sottotipo());

		return esfRadunoSottotipiRadunoImpl;
	}

	/**
	 * Returns the e s f raduno sottotipi raduno with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno sottotipi raduno
	 * @return the e s f raduno sottotipi raduno
	 * @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a e s f raduno sottotipi raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRadunoSottotipiRadunoException, SystemException {
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno = fetchByPrimaryKey(primaryKey);

		if (esfRadunoSottotipiRaduno == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRadunoSottotipiRadunoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRadunoSottotipiRaduno;
	}

	/**
	 * Returns the e s f raduno sottotipi raduno with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoSottotipiRadunoException} if it could not be found.
	 *
	 * @param id_esf_raduno_sottotipi_raduno the primary key of the e s f raduno sottotipi raduno
	 * @return the e s f raduno sottotipi raduno
	 * @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a e s f raduno sottotipi raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno findByPrimaryKey(
		long id_esf_raduno_sottotipi_raduno)
		throws NoSuchRadunoSottotipiRadunoException, SystemException {
		return findByPrimaryKey((Serializable)id_esf_raduno_sottotipi_raduno);
	}

	/**
	 * Returns the e s f raduno sottotipi raduno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno sottotipi raduno
	 * @return the e s f raduno sottotipi raduno, or <code>null</code> if a e s f raduno sottotipi raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno = (ESFRadunoSottotipiRaduno)EntityCacheUtil.getResult(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoSottotipiRadunoImpl.class, primaryKey);

		if (esfRadunoSottotipiRaduno == _nullESFRadunoSottotipiRaduno) {
			return null;
		}

		if (esfRadunoSottotipiRaduno == null) {
			Session session = null;

			try {
				session = openSession();

				esfRadunoSottotipiRaduno = (ESFRadunoSottotipiRaduno)session.get(ESFRadunoSottotipiRadunoImpl.class,
						primaryKey);

				if (esfRadunoSottotipiRaduno != null) {
					cacheResult(esfRadunoSottotipiRaduno);
				}
				else {
					EntityCacheUtil.putResult(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoSottotipiRadunoImpl.class, primaryKey,
						_nullESFRadunoSottotipiRaduno);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRadunoSottotipiRadunoModelImpl.ENTITY_CACHE_ENABLED,
					ESFRadunoSottotipiRadunoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRadunoSottotipiRaduno;
	}

	/**
	 * Returns the e s f raduno sottotipi raduno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_esf_raduno_sottotipi_raduno the primary key of the e s f raduno sottotipi raduno
	 * @return the e s f raduno sottotipi raduno, or <code>null</code> if a e s f raduno sottotipi raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipiRaduno fetchByPrimaryKey(
		long id_esf_raduno_sottotipi_raduno) throws SystemException {
		return fetchByPrimaryKey((Serializable)id_esf_raduno_sottotipi_raduno);
	}

	/**
	 * Returns all the e s f raduno sottotipi radunos.
	 *
	 * @return the e s f raduno sottotipi radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipiRaduno> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno sottotipi radunos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno sottotipi radunos
	 * @param end the upper bound of the range of e s f raduno sottotipi radunos (not inclusive)
	 * @return the range of e s f raduno sottotipi radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipiRaduno> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno sottotipi radunos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno sottotipi radunos
	 * @param end the upper bound of the range of e s f raduno sottotipi radunos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f raduno sottotipi radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipiRaduno> findAll(int start, int end,
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

		List<ESFRadunoSottotipiRaduno> list = (List<ESFRadunoSottotipiRaduno>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRADUNOSOTTOTIPIRADUNO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRADUNOSOTTOTIPIRADUNO;

				if (pagination) {
					sql = sql.concat(ESFRadunoSottotipiRadunoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRadunoSottotipiRaduno>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoSottotipiRaduno>(list);
				}
				else {
					list = (List<ESFRadunoSottotipiRaduno>)QueryUtil.list(q,
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
	 * Removes all the e s f raduno sottotipi radunos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno : findAll()) {
			remove(esfRadunoSottotipiRaduno);
		}
	}

	/**
	 * Returns the number of e s f raduno sottotipi radunos.
	 *
	 * @return the number of e s f raduno sottotipi radunos
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

				Query q = session.createQuery(_SQL_COUNT_ESFRADUNOSOTTOTIPIRADUNO);

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
	 * Initializes the e s f raduno sottotipi raduno persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRadunoSottotipiRaduno")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRadunoSottotipiRaduno>> listenersList = new ArrayList<ModelListener<ESFRadunoSottotipiRaduno>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRadunoSottotipiRaduno>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRadunoSottotipiRadunoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRADUNOSOTTOTIPIRADUNO = "SELECT esfRadunoSottotipiRaduno FROM ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno";
	private static final String _SQL_SELECT_ESFRADUNOSOTTOTIPIRADUNO_WHERE = "SELECT esfRadunoSottotipiRaduno FROM ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno WHERE ";
	private static final String _SQL_COUNT_ESFRADUNOSOTTOTIPIRADUNO = "SELECT COUNT(esfRadunoSottotipiRaduno) FROM ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno";
	private static final String _SQL_COUNT_ESFRADUNOSOTTOTIPIRADUNO_WHERE = "SELECT COUNT(esfRadunoSottotipiRaduno) FROM ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRadunoSottotipiRaduno.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRadunoSottotipiRaduno exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFRadunoSottotipiRaduno exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRadunoSottotipiRadunoPersistenceImpl.class);
	private static ESFRadunoSottotipiRaduno _nullESFRadunoSottotipiRaduno = new ESFRadunoSottotipiRadunoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRadunoSottotipiRaduno> toCacheModel() {
				return _nullESFRadunoSottotipiRadunoCacheModel;
			}
		};

	private static CacheModel<ESFRadunoSottotipiRaduno> _nullESFRadunoSottotipiRadunoCacheModel =
		new CacheModel<ESFRadunoSottotipiRaduno>() {
			@Override
			public ESFRadunoSottotipiRaduno toEntityModel() {
				return _nullESFRadunoSottotipiRaduno;
			}
		};
}