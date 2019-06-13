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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchRadunoFilesException;
import it.ethica.esf.model.ESFRadunoFiles;
import it.ethica.esf.model.impl.ESFRadunoFilesImpl;
import it.ethica.esf.model.impl.ESFRadunoFilesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f raduno files service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoFilesPersistence
 * @see ESFRadunoFilesUtil
 * @generated
 */
public class ESFRadunoFilesPersistenceImpl extends BasePersistenceImpl<ESFRadunoFiles>
	implements ESFRadunoFilesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRadunoFilesUtil} to access the e s f raduno files persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRadunoFilesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoFilesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoFilesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYRADUNO =
		new FinderPath(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoFilesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByfindByRaduno",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO =
		new FinderPath(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoFilesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByRaduno",
			new String[] { Long.class.getName() },
			ESFRadunoFilesModelImpl.ID_ESF_RADUNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYRADUNO = new FinderPath(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByRaduno",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f raduno fileses where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @return the matching e s f raduno fileses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoFiles> findByfindByRaduno(long id_esf_raduno)
		throws SystemException {
		return findByfindByRaduno(id_esf_raduno, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno fileses where id_esf_raduno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param start the lower bound of the range of e s f raduno fileses
	 * @param end the upper bound of the range of e s f raduno fileses (not inclusive)
	 * @return the range of matching e s f raduno fileses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoFiles> findByfindByRaduno(long id_esf_raduno,
		int start, int end) throws SystemException {
		return findByfindByRaduno(id_esf_raduno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno fileses where id_esf_raduno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param start the lower bound of the range of e s f raduno fileses
	 * @param end the upper bound of the range of e s f raduno fileses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f raduno fileses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoFiles> findByfindByRaduno(long id_esf_raduno,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO;
			finderArgs = new Object[] { id_esf_raduno };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYRADUNO;
			finderArgs = new Object[] {
					id_esf_raduno,
					
					start, end, orderByComparator
				};
		}

		List<ESFRadunoFiles> list = (List<ESFRadunoFiles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRadunoFiles esfRadunoFiles : list) {
				if ((id_esf_raduno != esfRadunoFiles.getId_esf_raduno())) {
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

			query.append(_SQL_SELECT_ESFRADUNOFILES_WHERE);

			query.append(_FINDER_COLUMN_FINDBYRADUNO_ID_ESF_RADUNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRadunoFilesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				if (!pagination) {
					list = (List<ESFRadunoFiles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoFiles>(list);
				}
				else {
					list = (List<ESFRadunoFiles>)QueryUtil.list(q,
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
	 * Returns the first e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f raduno files
	 * @throws it.ethica.esf.NoSuchRadunoFilesException if a matching e s f raduno files could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles findByfindByRaduno_First(long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchRadunoFilesException, SystemException {
		ESFRadunoFiles esfRadunoFiles = fetchByfindByRaduno_First(id_esf_raduno,
				orderByComparator);

		if (esfRadunoFiles != null) {
			return esfRadunoFiles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_esf_raduno=");
		msg.append(id_esf_raduno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRadunoFilesException(msg.toString());
	}

	/**
	 * Returns the first e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f raduno files, or <code>null</code> if a matching e s f raduno files could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles fetchByfindByRaduno_First(long id_esf_raduno,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRadunoFiles> list = findByfindByRaduno(id_esf_raduno, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f raduno files
	 * @throws it.ethica.esf.NoSuchRadunoFilesException if a matching e s f raduno files could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles findByfindByRaduno_Last(long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchRadunoFilesException, SystemException {
		ESFRadunoFiles esfRadunoFiles = fetchByfindByRaduno_Last(id_esf_raduno,
				orderByComparator);

		if (esfRadunoFiles != null) {
			return esfRadunoFiles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_esf_raduno=");
		msg.append(id_esf_raduno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRadunoFilesException(msg.toString());
	}

	/**
	 * Returns the last e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f raduno files, or <code>null</code> if a matching e s f raduno files could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles fetchByfindByRaduno_Last(long id_esf_raduno,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfindByRaduno(id_esf_raduno);

		if (count == 0) {
			return null;
		}

		List<ESFRadunoFiles> list = findByfindByRaduno(id_esf_raduno,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f raduno fileses before and after the current e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno_files the primary key of the current e s f raduno files
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f raduno files
	 * @throws it.ethica.esf.NoSuchRadunoFilesException if a e s f raduno files with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles[] findByfindByRaduno_PrevAndNext(
		long id_esf_raduno_files, long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchRadunoFilesException, SystemException {
		ESFRadunoFiles esfRadunoFiles = findByPrimaryKey(id_esf_raduno_files);

		Session session = null;

		try {
			session = openSession();

			ESFRadunoFiles[] array = new ESFRadunoFilesImpl[3];

			array[0] = getByfindByRaduno_PrevAndNext(session, esfRadunoFiles,
					id_esf_raduno, orderByComparator, true);

			array[1] = esfRadunoFiles;

			array[2] = getByfindByRaduno_PrevAndNext(session, esfRadunoFiles,
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

	protected ESFRadunoFiles getByfindByRaduno_PrevAndNext(Session session,
		ESFRadunoFiles esfRadunoFiles, long id_esf_raduno,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRADUNOFILES_WHERE);

		query.append(_FINDER_COLUMN_FINDBYRADUNO_ID_ESF_RADUNO_2);

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
			query.append(ESFRadunoFilesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_esf_raduno);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRadunoFiles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRadunoFiles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f raduno fileses where id_esf_raduno = &#63; from the database.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByfindByRaduno(long id_esf_raduno)
		throws SystemException {
		for (ESFRadunoFiles esfRadunoFiles : findByfindByRaduno(id_esf_raduno,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRadunoFiles);
		}
	}

	/**
	 * Returns the number of e s f raduno fileses where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @return the number of matching e s f raduno fileses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByRaduno(long id_esf_raduno)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYRADUNO;

		Object[] finderArgs = new Object[] { id_esf_raduno };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRADUNOFILES_WHERE);

			query.append(_FINDER_COLUMN_FINDBYRADUNO_ID_ESF_RADUNO_2);

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

	private static final String _FINDER_COLUMN_FINDBYRADUNO_ID_ESF_RADUNO_2 = "esfRadunoFiles.id_esf_raduno = ?";

	public ESFRadunoFilesPersistenceImpl() {
		setModelClass(ESFRadunoFiles.class);
	}

	/**
	 * Caches the e s f raduno files in the entity cache if it is enabled.
	 *
	 * @param esfRadunoFiles the e s f raduno files
	 */
	@Override
	public void cacheResult(ESFRadunoFiles esfRadunoFiles) {
		EntityCacheUtil.putResult(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesImpl.class, esfRadunoFiles.getPrimaryKey(),
			esfRadunoFiles);

		esfRadunoFiles.resetOriginalValues();
	}

	/**
	 * Caches the e s f raduno fileses in the entity cache if it is enabled.
	 *
	 * @param esfRadunoFileses the e s f raduno fileses
	 */
	@Override
	public void cacheResult(List<ESFRadunoFiles> esfRadunoFileses) {
		for (ESFRadunoFiles esfRadunoFiles : esfRadunoFileses) {
			if (EntityCacheUtil.getResult(
						ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoFilesImpl.class, esfRadunoFiles.getPrimaryKey()) == null) {
				cacheResult(esfRadunoFiles);
			}
			else {
				esfRadunoFiles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f raduno fileses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRadunoFilesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRadunoFilesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f raduno files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRadunoFiles esfRadunoFiles) {
		EntityCacheUtil.removeResult(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesImpl.class, esfRadunoFiles.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFRadunoFiles> esfRadunoFileses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRadunoFiles esfRadunoFiles : esfRadunoFileses) {
			EntityCacheUtil.removeResult(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoFilesImpl.class, esfRadunoFiles.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f raduno files with the primary key. Does not add the e s f raduno files to the database.
	 *
	 * @param id_esf_raduno_files the primary key for the new e s f raduno files
	 * @return the new e s f raduno files
	 */
	@Override
	public ESFRadunoFiles create(long id_esf_raduno_files) {
		ESFRadunoFiles esfRadunoFiles = new ESFRadunoFilesImpl();

		esfRadunoFiles.setNew(true);
		esfRadunoFiles.setPrimaryKey(id_esf_raduno_files);

		return esfRadunoFiles;
	}

	/**
	 * Removes the e s f raduno files with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_esf_raduno_files the primary key of the e s f raduno files
	 * @return the e s f raduno files that was removed
	 * @throws it.ethica.esf.NoSuchRadunoFilesException if a e s f raduno files with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles remove(long id_esf_raduno_files)
		throws NoSuchRadunoFilesException, SystemException {
		return remove((Serializable)id_esf_raduno_files);
	}

	/**
	 * Removes the e s f raduno files with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f raduno files
	 * @return the e s f raduno files that was removed
	 * @throws it.ethica.esf.NoSuchRadunoFilesException if a e s f raduno files with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles remove(Serializable primaryKey)
		throws NoSuchRadunoFilesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRadunoFiles esfRadunoFiles = (ESFRadunoFiles)session.get(ESFRadunoFilesImpl.class,
					primaryKey);

			if (esfRadunoFiles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRadunoFilesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRadunoFiles);
		}
		catch (NoSuchRadunoFilesException nsee) {
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
	protected ESFRadunoFiles removeImpl(ESFRadunoFiles esfRadunoFiles)
		throws SystemException {
		esfRadunoFiles = toUnwrappedModel(esfRadunoFiles);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRadunoFiles)) {
				esfRadunoFiles = (ESFRadunoFiles)session.get(ESFRadunoFilesImpl.class,
						esfRadunoFiles.getPrimaryKeyObj());
			}

			if (esfRadunoFiles != null) {
				session.delete(esfRadunoFiles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRadunoFiles != null) {
			clearCache(esfRadunoFiles);
		}

		return esfRadunoFiles;
	}

	@Override
	public ESFRadunoFiles updateImpl(
		it.ethica.esf.model.ESFRadunoFiles esfRadunoFiles)
		throws SystemException {
		esfRadunoFiles = toUnwrappedModel(esfRadunoFiles);

		boolean isNew = esfRadunoFiles.isNew();

		ESFRadunoFilesModelImpl esfRadunoFilesModelImpl = (ESFRadunoFilesModelImpl)esfRadunoFiles;

		Session session = null;

		try {
			session = openSession();

			if (esfRadunoFiles.isNew()) {
				session.save(esfRadunoFiles);

				esfRadunoFiles.setNew(false);
			}
			else {
				session.merge(esfRadunoFiles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFRadunoFilesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfRadunoFilesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRadunoFilesModelImpl.getOriginalId_esf_raduno()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYRADUNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO,
					args);

				args = new Object[] { esfRadunoFilesModelImpl.getId_esf_raduno() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYRADUNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoFilesImpl.class, esfRadunoFiles.getPrimaryKey(),
			esfRadunoFiles);

		return esfRadunoFiles;
	}

	protected ESFRadunoFiles toUnwrappedModel(ESFRadunoFiles esfRadunoFiles) {
		if (esfRadunoFiles instanceof ESFRadunoFilesImpl) {
			return esfRadunoFiles;
		}

		ESFRadunoFilesImpl esfRadunoFilesImpl = new ESFRadunoFilesImpl();

		esfRadunoFilesImpl.setNew(esfRadunoFiles.isNew());
		esfRadunoFilesImpl.setPrimaryKey(esfRadunoFiles.getPrimaryKey());

		esfRadunoFilesImpl.setId_esf_raduno_files(esfRadunoFiles.getId_esf_raduno_files());
		esfRadunoFilesImpl.setId_esf_raduno(esfRadunoFiles.getId_esf_raduno());
		esfRadunoFilesImpl.setNome(esfRadunoFiles.getNome());
		esfRadunoFilesImpl.setPath(esfRadunoFiles.getPath());

		return esfRadunoFilesImpl;
	}

	/**
	 * Returns the e s f raduno files with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno files
	 * @return the e s f raduno files
	 * @throws it.ethica.esf.NoSuchRadunoFilesException if a e s f raduno files with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRadunoFilesException, SystemException {
		ESFRadunoFiles esfRadunoFiles = fetchByPrimaryKey(primaryKey);

		if (esfRadunoFiles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRadunoFilesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRadunoFiles;
	}

	/**
	 * Returns the e s f raduno files with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoFilesException} if it could not be found.
	 *
	 * @param id_esf_raduno_files the primary key of the e s f raduno files
	 * @return the e s f raduno files
	 * @throws it.ethica.esf.NoSuchRadunoFilesException if a e s f raduno files with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles findByPrimaryKey(long id_esf_raduno_files)
		throws NoSuchRadunoFilesException, SystemException {
		return findByPrimaryKey((Serializable)id_esf_raduno_files);
	}

	/**
	 * Returns the e s f raduno files with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno files
	 * @return the e s f raduno files, or <code>null</code> if a e s f raduno files with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRadunoFiles esfRadunoFiles = (ESFRadunoFiles)EntityCacheUtil.getResult(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoFilesImpl.class, primaryKey);

		if (esfRadunoFiles == _nullESFRadunoFiles) {
			return null;
		}

		if (esfRadunoFiles == null) {
			Session session = null;

			try {
				session = openSession();

				esfRadunoFiles = (ESFRadunoFiles)session.get(ESFRadunoFilesImpl.class,
						primaryKey);

				if (esfRadunoFiles != null) {
					cacheResult(esfRadunoFiles);
				}
				else {
					EntityCacheUtil.putResult(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoFilesImpl.class, primaryKey,
						_nullESFRadunoFiles);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRadunoFilesModelImpl.ENTITY_CACHE_ENABLED,
					ESFRadunoFilesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRadunoFiles;
	}

	/**
	 * Returns the e s f raduno files with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_esf_raduno_files the primary key of the e s f raduno files
	 * @return the e s f raduno files, or <code>null</code> if a e s f raduno files with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoFiles fetchByPrimaryKey(long id_esf_raduno_files)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id_esf_raduno_files);
	}

	/**
	 * Returns all the e s f raduno fileses.
	 *
	 * @return the e s f raduno fileses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoFiles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno fileses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno fileses
	 * @param end the upper bound of the range of e s f raduno fileses (not inclusive)
	 * @return the range of e s f raduno fileses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoFiles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno fileses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno fileses
	 * @param end the upper bound of the range of e s f raduno fileses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f raduno fileses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoFiles> findAll(int start, int end,
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

		List<ESFRadunoFiles> list = (List<ESFRadunoFiles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRADUNOFILES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRADUNOFILES;

				if (pagination) {
					sql = sql.concat(ESFRadunoFilesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRadunoFiles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoFiles>(list);
				}
				else {
					list = (List<ESFRadunoFiles>)QueryUtil.list(q,
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
	 * Removes all the e s f raduno fileses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRadunoFiles esfRadunoFiles : findAll()) {
			remove(esfRadunoFiles);
		}
	}

	/**
	 * Returns the number of e s f raduno fileses.
	 *
	 * @return the number of e s f raduno fileses
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

				Query q = session.createQuery(_SQL_COUNT_ESFRADUNOFILES);

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
	 * Initializes the e s f raduno files persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRadunoFiles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRadunoFiles>> listenersList = new ArrayList<ModelListener<ESFRadunoFiles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRadunoFiles>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRadunoFilesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRADUNOFILES = "SELECT esfRadunoFiles FROM ESFRadunoFiles esfRadunoFiles";
	private static final String _SQL_SELECT_ESFRADUNOFILES_WHERE = "SELECT esfRadunoFiles FROM ESFRadunoFiles esfRadunoFiles WHERE ";
	private static final String _SQL_COUNT_ESFRADUNOFILES = "SELECT COUNT(esfRadunoFiles) FROM ESFRadunoFiles esfRadunoFiles";
	private static final String _SQL_COUNT_ESFRADUNOFILES_WHERE = "SELECT COUNT(esfRadunoFiles) FROM ESFRadunoFiles esfRadunoFiles WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRadunoFiles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRadunoFiles exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFRadunoFiles exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRadunoFilesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"path"
			});
	private static ESFRadunoFiles _nullESFRadunoFiles = new ESFRadunoFilesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRadunoFiles> toCacheModel() {
				return _nullESFRadunoFilesCacheModel;
			}
		};

	private static CacheModel<ESFRadunoFiles> _nullESFRadunoFilesCacheModel = new CacheModel<ESFRadunoFiles>() {
			@Override
			public ESFRadunoFiles toEntityModel() {
				return _nullESFRadunoFiles;
			}
		};
}