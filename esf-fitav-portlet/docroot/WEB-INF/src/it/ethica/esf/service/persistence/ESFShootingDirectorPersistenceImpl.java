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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchShootingDirectorException;
import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.impl.ESFShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFShootingDirectorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f shooting director service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirectorPersistence
 * @see ESFShootingDirectorUtil
 * @generated
 */
public class ESFShootingDirectorPersistenceImpl extends BasePersistenceImpl<ESFShootingDirector>
	implements ESFShootingDirectorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFShootingDirectorUtil} to access the e s f shooting director persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFShootingDirectorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyUserId",
			new String[] { Long.class.getName() },
			ESFShootingDirectorModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFShootingDirectorModelImpl.SHOOTINGDIRECTORQUALIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERID = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f shooting directors where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyUserId(Long esfUserId)
		throws SystemException {
		return findBybyUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f shooting directors where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @return the range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyUserId(Long esfUserId, int start,
		int end) throws SystemException {
		return findBybyUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooting directors where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyUserId(Long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFShootingDirector> list = (List<ESFShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShootingDirector esfShootingDirector : list) {
				if (!Validator.equals(esfUserId,
							esfShootingDirector.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId.longValue());

				if (!pagination) {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShootingDirector>(list);
				}
				else {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
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
	 * Returns the first e s f shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyUserId_First(Long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyUserId_First(esfUserId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the first e s f shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyUserId_First(Long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShootingDirector> list = findBybyUserId(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyUserId_Last(Long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyUserId_Last(esfUserId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyUserId_Last(Long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFShootingDirector> list = findBybyUserId(esfUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfShootingDirectorId the primary key of the current e s f shooting director
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector[] findBybyUserId_PrevAndNext(
		long esfShootingDirectorId, Long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = findByPrimaryKey(esfShootingDirectorId);

		Session session = null;

		try {
			session = openSession();

			ESFShootingDirector[] array = new ESFShootingDirectorImpl[3];

			array[0] = getBybyUserId_PrevAndNext(session, esfShootingDirector,
					esfUserId, orderByComparator, true);

			array[1] = esfShootingDirector;

			array[2] = getBybyUserId_PrevAndNext(session, esfShootingDirector,
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

	protected ESFShootingDirector getBybyUserId_PrevAndNext(Session session,
		ESFShootingDirector esfShootingDirector, Long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

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
			query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShootingDirector);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShootingDirector> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooting directors where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyUserId(Long esfUserId) throws SystemException {
		for (ESFShootingDirector esfShootingDirector : findBybyUserId(
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f shooting directors where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyUserId(Long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYUSERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId.longValue());

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

	private static final String _FINDER_COLUMN_BYUSERID_ESFUSERID_2 = "esfShootingDirector.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSHOOTINGDIRECTORQUALIFICATIONID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyShootingDirectorQualificationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSHOOTINGDIRECTORQUALIFICATIONID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyShootingDirectorQualificationId",
			new String[] { Long.class.getName() },
			ESFShootingDirectorModelImpl.SHOOTINGDIRECTORQUALIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYSHOOTINGDIRECTORQUALIFICATIONID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyShootingDirectorQualificationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f shooting directors where shootingDirectorQualificationId = &#63;.
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @return the matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyShootingDirectorQualificationId(
		Long shootingDirectorQualificationId) throws SystemException {
		return findBybyShootingDirectorQualificationId(shootingDirectorQualificationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooting directors where shootingDirectorQualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @return the range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyShootingDirectorQualificationId(
		Long shootingDirectorQualificationId, int start, int end)
		throws SystemException {
		return findBybyShootingDirectorQualificationId(shootingDirectorQualificationId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooting directors where shootingDirectorQualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyShootingDirectorQualificationId(
		Long shootingDirectorQualificationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSHOOTINGDIRECTORQUALIFICATIONID;
			finderArgs = new Object[] { shootingDirectorQualificationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSHOOTINGDIRECTORQUALIFICATIONID;
			finderArgs = new Object[] {
					shootingDirectorQualificationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFShootingDirector> list = (List<ESFShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShootingDirector esfShootingDirector : list) {
				if (!Validator.equals(shootingDirectorQualificationId,
							esfShootingDirector.getShootingDirectorQualificationId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYSHOOTINGDIRECTORQUALIFICATIONID_SHOOTINGDIRECTORQUALIFICATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(shootingDirectorQualificationId.longValue());

				if (!pagination) {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShootingDirector>(list);
				}
				else {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
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
	 * Returns the first e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyShootingDirectorQualificationId_First(
		Long shootingDirectorQualificationId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyShootingDirectorQualificationId_First(shootingDirectorQualificationId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shootingDirectorQualificationId=");
		msg.append(shootingDirectorQualificationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the first e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyShootingDirectorQualificationId_First(
		Long shootingDirectorQualificationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShootingDirector> list = findBybyShootingDirectorQualificationId(shootingDirectorQualificationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyShootingDirectorQualificationId_Last(
		Long shootingDirectorQualificationId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyShootingDirectorQualificationId_Last(shootingDirectorQualificationId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shootingDirectorQualificationId=");
		msg.append(shootingDirectorQualificationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyShootingDirectorQualificationId_Last(
		Long shootingDirectorQualificationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyShootingDirectorQualificationId(shootingDirectorQualificationId);

		if (count == 0) {
			return null;
		}

		List<ESFShootingDirector> list = findBybyShootingDirectorQualificationId(shootingDirectorQualificationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	 *
	 * @param esfShootingDirectorId the primary key of the current e s f shooting director
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector[] findBybyShootingDirectorQualificationId_PrevAndNext(
		long esfShootingDirectorId, Long shootingDirectorQualificationId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = findByPrimaryKey(esfShootingDirectorId);

		Session session = null;

		try {
			session = openSession();

			ESFShootingDirector[] array = new ESFShootingDirectorImpl[3];

			array[0] = getBybyShootingDirectorQualificationId_PrevAndNext(session,
					esfShootingDirector, shootingDirectorQualificationId,
					orderByComparator, true);

			array[1] = esfShootingDirector;

			array[2] = getBybyShootingDirectorQualificationId_PrevAndNext(session,
					esfShootingDirector, shootingDirectorQualificationId,
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

	protected ESFShootingDirector getBybyShootingDirectorQualificationId_PrevAndNext(
		Session session, ESFShootingDirector esfShootingDirector,
		Long shootingDirectorQualificationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

		query.append(_FINDER_COLUMN_BYSHOOTINGDIRECTORQUALIFICATIONID_SHOOTINGDIRECTORQUALIFICATIONID_2);

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
			query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(shootingDirectorQualificationId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShootingDirector);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShootingDirector> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooting directors where shootingDirectorQualificationId = &#63; from the database.
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyShootingDirectorQualificationId(
		Long shootingDirectorQualificationId) throws SystemException {
		for (ESFShootingDirector esfShootingDirector : findBybyShootingDirectorQualificationId(
				shootingDirectorQualificationId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f shooting directors where shootingDirectorQualificationId = &#63;.
	 *
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @return the number of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyShootingDirectorQualificationId(
		Long shootingDirectorQualificationId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYSHOOTINGDIRECTORQUALIFICATIONID;

		Object[] finderArgs = new Object[] { shootingDirectorQualificationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYSHOOTINGDIRECTORQUALIFICATIONID_SHOOTINGDIRECTORQUALIFICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(shootingDirectorQualificationId.longValue());

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

	private static final String _FINDER_COLUMN_BYSHOOTINGDIRECTORQUALIFICATIONID_SHOOTINGDIRECTORQUALIFICATIONID_2 =
		"esfShootingDirector.shootingDirectorQualificationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSPORTTYPEID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybySportTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSPORTTYPEID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybySportTypeId",
			new String[] { Long.class.getName() },
			ESFShootingDirectorModelImpl.SPORTTYPEID_COLUMN_BITMASK |
			ESFShootingDirectorModelImpl.SHOOTINGDIRECTORQUALIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYSPORTTYPEID = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybySportTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f shooting directors where sportTypeId = &#63;.
	 *
	 * @param sportTypeId the sport type ID
	 * @return the matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybySportTypeId(Long sportTypeId)
		throws SystemException {
		return findBybySportTypeId(sportTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooting directors where sportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sportTypeId the sport type ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @return the range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybySportTypeId(Long sportTypeId,
		int start, int end) throws SystemException {
		return findBybySportTypeId(sportTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooting directors where sportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sportTypeId the sport type ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybySportTypeId(Long sportTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSPORTTYPEID;
			finderArgs = new Object[] { sportTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSPORTTYPEID;
			finderArgs = new Object[] { sportTypeId, start, end, orderByComparator };
		}

		List<ESFShootingDirector> list = (List<ESFShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShootingDirector esfShootingDirector : list) {
				if (!Validator.equals(sportTypeId,
							esfShootingDirector.getSportTypeId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYSPORTTYPEID_SPORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sportTypeId.longValue());

				if (!pagination) {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShootingDirector>(list);
				}
				else {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
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
	 * Returns the first e s f shooting director in the ordered set where sportTypeId = &#63;.
	 *
	 * @param sportTypeId the sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybySportTypeId_First(Long sportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybySportTypeId_First(sportTypeId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sportTypeId=");
		msg.append(sportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the first e s f shooting director in the ordered set where sportTypeId = &#63;.
	 *
	 * @param sportTypeId the sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybySportTypeId_First(Long sportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShootingDirector> list = findBybySportTypeId(sportTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where sportTypeId = &#63;.
	 *
	 * @param sportTypeId the sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybySportTypeId_Last(Long sportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybySportTypeId_Last(sportTypeId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sportTypeId=");
		msg.append(sportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where sportTypeId = &#63;.
	 *
	 * @param sportTypeId the sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybySportTypeId_Last(Long sportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybySportTypeId(sportTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFShootingDirector> list = findBybySportTypeId(sportTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where sportTypeId = &#63;.
	 *
	 * @param esfShootingDirectorId the primary key of the current e s f shooting director
	 * @param sportTypeId the sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector[] findBybySportTypeId_PrevAndNext(
		long esfShootingDirectorId, Long sportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = findByPrimaryKey(esfShootingDirectorId);

		Session session = null;

		try {
			session = openSession();

			ESFShootingDirector[] array = new ESFShootingDirectorImpl[3];

			array[0] = getBybySportTypeId_PrevAndNext(session,
					esfShootingDirector, sportTypeId, orderByComparator, true);

			array[1] = esfShootingDirector;

			array[2] = getBybySportTypeId_PrevAndNext(session,
					esfShootingDirector, sportTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFShootingDirector getBybySportTypeId_PrevAndNext(
		Session session, ESFShootingDirector esfShootingDirector,
		Long sportTypeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

		query.append(_FINDER_COLUMN_BYSPORTTYPEID_SPORTTYPEID_2);

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
			query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sportTypeId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShootingDirector);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShootingDirector> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooting directors where sportTypeId = &#63; from the database.
	 *
	 * @param sportTypeId the sport type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybySportTypeId(Long sportTypeId)
		throws SystemException {
		for (ESFShootingDirector esfShootingDirector : findBybySportTypeId(
				sportTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f shooting directors where sportTypeId = &#63;.
	 *
	 * @param sportTypeId the sport type ID
	 * @return the number of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybySportTypeId(Long sportTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYSPORTTYPEID;

		Object[] finderArgs = new Object[] { sportTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYSPORTTYPEID_SPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sportTypeId.longValue());

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

	private static final String _FINDER_COLUMN_BYSPORTTYPEID_SPORTTYPEID_2 = "esfShootingDirector.sportTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYREGIONID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyRegionId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYREGIONID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyRegionId",
			new String[] { String.class.getName() },
			ESFShootingDirectorModelImpl.REGIONID_COLUMN_BITMASK |
			ESFShootingDirectorModelImpl.SHOOTINGDIRECTORQUALIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYREGIONID = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyRegionId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f shooting directors where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyRegionId(String regionId)
		throws SystemException {
		return findBybyRegionId(regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f shooting directors where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @return the range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyRegionId(String regionId,
		int start, int end) throws SystemException {
		return findBybyRegionId(regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooting directors where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyRegionId(String regionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYREGIONID;
			finderArgs = new Object[] { regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYREGIONID;
			finderArgs = new Object[] { regionId, start, end, orderByComparator };
		}

		List<ESFShootingDirector> list = (List<ESFShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShootingDirector esfShootingDirector : list) {
				if (!Validator.equals(regionId,
							esfShootingDirector.getRegionId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

			boolean bindRegionId = false;

			if (regionId == null) {
				query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_1);
			}
			else if (regionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_3);
			}
			else {
				bindRegionId = true;

				query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionId) {
					qPos.add(regionId);
				}

				if (!pagination) {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShootingDirector>(list);
				}
				else {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
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
	 * Returns the first e s f shooting director in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyRegionId_First(String regionId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyRegionId_First(regionId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the first e s f shooting director in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyRegionId_First(String regionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShootingDirector> list = findBybyRegionId(regionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyRegionId_Last(String regionId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyRegionId_Last(regionId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyRegionId_Last(String regionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyRegionId(regionId);

		if (count == 0) {
			return null;
		}

		List<ESFShootingDirector> list = findBybyRegionId(regionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where regionId = &#63;.
	 *
	 * @param esfShootingDirectorId the primary key of the current e s f shooting director
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector[] findBybyRegionId_PrevAndNext(
		long esfShootingDirectorId, String regionId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = findByPrimaryKey(esfShootingDirectorId);

		Session session = null;

		try {
			session = openSession();

			ESFShootingDirector[] array = new ESFShootingDirectorImpl[3];

			array[0] = getBybyRegionId_PrevAndNext(session,
					esfShootingDirector, regionId, orderByComparator, true);

			array[1] = esfShootingDirector;

			array[2] = getBybyRegionId_PrevAndNext(session,
					esfShootingDirector, regionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFShootingDirector getBybyRegionId_PrevAndNext(Session session,
		ESFShootingDirector esfShootingDirector, String regionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

		boolean bindRegionId = false;

		if (regionId == null) {
			query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_1);
		}
		else if (regionId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_3);
		}
		else {
			bindRegionId = true;

			query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_2);
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
			query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRegionId) {
			qPos.add(regionId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShootingDirector);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShootingDirector> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooting directors where regionId = &#63; from the database.
	 *
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyRegionId(String regionId) throws SystemException {
		for (ESFShootingDirector esfShootingDirector : findBybyRegionId(
				regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f shooting directors where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the number of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyRegionId(String regionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYREGIONID;

		Object[] finderArgs = new Object[] { regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSHOOTINGDIRECTOR_WHERE);

			boolean bindRegionId = false;

			if (regionId == null) {
				query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_1);
			}
			else if (regionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_3);
			}
			else {
				bindRegionId = true;

				query.append(_FINDER_COLUMN_BYREGIONID_REGIONID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionId) {
					qPos.add(regionId);
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

	private static final String _FINDER_COLUMN_BYREGIONID_REGIONID_1 = "esfShootingDirector.regionId IS NULL";
	private static final String _FINDER_COLUMN_BYREGIONID_REGIONID_2 = "esfShootingDirector.regionId = ?";
	private static final String _FINDER_COLUMN_BYREGIONID_REGIONID_3 = "(esfShootingDirector.regionId IS NULL OR esfShootingDirector.regionId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYPROVINCEID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyProvinceId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYPROVINCEID =
		new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyProvinceId",
			new String[] { String.class.getName() },
			ESFShootingDirectorModelImpl.PROVINCEID_COLUMN_BITMASK |
			ESFShootingDirectorModelImpl.SHOOTINGDIRECTORQUALIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYPROVINCEID = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyProvinceId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f shooting directors where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @return the matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyProvinceId(String provinceId)
		throws SystemException {
		return findBybyProvinceId(provinceId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooting directors where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @return the range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyProvinceId(String provinceId,
		int start, int end) throws SystemException {
		return findBybyProvinceId(provinceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooting directors where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findBybyProvinceId(String provinceId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYPROVINCEID;
			finderArgs = new Object[] { provinceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYPROVINCEID;
			finderArgs = new Object[] { provinceId, start, end, orderByComparator };
		}

		List<ESFShootingDirector> list = (List<ESFShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShootingDirector esfShootingDirector : list) {
				if (!Validator.equals(provinceId,
							esfShootingDirector.getProvinceId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

			boolean bindProvinceId = false;

			if (provinceId == null) {
				query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_1);
			}
			else if (provinceId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_3);
			}
			else {
				bindProvinceId = true;

				query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProvinceId) {
					qPos.add(provinceId);
				}

				if (!pagination) {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShootingDirector>(list);
				}
				else {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
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
	 * Returns the first e s f shooting director in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyProvinceId_First(String provinceId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyProvinceId_First(provinceId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provinceId=");
		msg.append(provinceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the first e s f shooting director in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyProvinceId_First(String provinceId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShootingDirector> list = findBybyProvinceId(provinceId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyProvinceId_Last(String provinceId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyProvinceId_Last(provinceId,
				orderByComparator);

		if (esfShootingDirector != null) {
			return esfShootingDirector;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provinceId=");
		msg.append(provinceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShootingDirectorException(msg.toString());
	}

	/**
	 * Returns the last e s f shooting director in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyProvinceId_Last(String provinceId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyProvinceId(provinceId);

		if (count == 0) {
			return null;
		}

		List<ESFShootingDirector> list = findBybyProvinceId(provinceId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where provinceId = &#63;.
	 *
	 * @param esfShootingDirectorId the primary key of the current e s f shooting director
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector[] findBybyProvinceId_PrevAndNext(
		long esfShootingDirectorId, String provinceId,
		OrderByComparator orderByComparator)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = findByPrimaryKey(esfShootingDirectorId);

		Session session = null;

		try {
			session = openSession();

			ESFShootingDirector[] array = new ESFShootingDirectorImpl[3];

			array[0] = getBybyProvinceId_PrevAndNext(session,
					esfShootingDirector, provinceId, orderByComparator, true);

			array[1] = esfShootingDirector;

			array[2] = getBybyProvinceId_PrevAndNext(session,
					esfShootingDirector, provinceId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFShootingDirector getBybyProvinceId_PrevAndNext(
		Session session, ESFShootingDirector esfShootingDirector,
		String provinceId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

		boolean bindProvinceId = false;

		if (provinceId == null) {
			query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_1);
		}
		else if (provinceId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_3);
		}
		else {
			bindProvinceId = true;

			query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_2);
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
			query.append(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindProvinceId) {
			qPos.add(provinceId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShootingDirector);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShootingDirector> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooting directors where provinceId = &#63; from the database.
	 *
	 * @param provinceId the province ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyProvinceId(String provinceId)
		throws SystemException {
		for (ESFShootingDirector esfShootingDirector : findBybyProvinceId(
				provinceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f shooting directors where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @return the number of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyProvinceId(String provinceId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYPROVINCEID;

		Object[] finderArgs = new Object[] { provinceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSHOOTINGDIRECTOR_WHERE);

			boolean bindProvinceId = false;

			if (provinceId == null) {
				query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_1);
			}
			else if (provinceId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_3);
			}
			else {
				bindProvinceId = true;

				query.append(_FINDER_COLUMN_BYPROVINCEID_PROVINCEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProvinceId) {
					qPos.add(provinceId);
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

	private static final String _FINDER_COLUMN_BYPROVINCEID_PROVINCEID_1 = "esfShootingDirector.provinceId IS NULL";
	private static final String _FINDER_COLUMN_BYPROVINCEID_PROVINCEID_2 = "esfShootingDirector.provinceId = ?";
	private static final String _FINDER_COLUMN_BYPROVINCEID_PROVINCEID_3 = "(esfShootingDirector.provinceId IS NULL OR esfShootingDirector.provinceId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBybyUserId_SDQId_STId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFShootingDirectorModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFShootingDirectorModelImpl.SHOOTINGDIRECTORQUALIFICATIONID_COLUMN_BITMASK |
			ESFShootingDirectorModelImpl.SPORTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERID_SDQID_STID = new FinderPath(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyUserId_SDQId_STId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; or throws a {@link it.ethica.esf.NoSuchShootingDirectorException} if it could not be found.
	 *
	 * @param esfUserId the esf user ID
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param sportTypeId the sport type ID
	 * @return the matching e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findBybyUserId_SDQId_STId(Long esfUserId,
		Long shootingDirectorQualificationId, Long sportTypeId)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchBybyUserId_SDQId_STId(esfUserId,
				shootingDirectorQualificationId, sportTypeId);

		if (esfShootingDirector == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfUserId=");
			msg.append(esfUserId);

			msg.append(", shootingDirectorQualificationId=");
			msg.append(shootingDirectorQualificationId);

			msg.append(", sportTypeId=");
			msg.append(sportTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchShootingDirectorException(msg.toString());
		}

		return esfShootingDirector;
	}

	/**
	 * Returns the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param sportTypeId the sport type ID
	 * @return the matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyUserId_SDQId_STId(Long esfUserId,
		Long shootingDirectorQualificationId, Long sportTypeId)
		throws SystemException {
		return fetchBybyUserId_SDQId_STId(esfUserId,
			shootingDirectorQualificationId, sportTypeId, true);
	}

	/**
	 * Returns the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param sportTypeId the sport type ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchBybyUserId_SDQId_STId(Long esfUserId,
		Long shootingDirectorQualificationId, Long sportTypeId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				esfUserId, shootingDirectorQualificationId, sportTypeId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
					finderArgs, this);
		}

		if (result instanceof ESFShootingDirector) {
			ESFShootingDirector esfShootingDirector = (ESFShootingDirector)result;

			if (!Validator.equals(esfUserId, esfShootingDirector.getEsfUserId()) ||
					!Validator.equals(shootingDirectorQualificationId,
						esfShootingDirector.getShootingDirectorQualificationId()) ||
					!Validator.equals(sportTypeId,
						esfShootingDirector.getSportTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_SDQID_STID_ESFUSERID_2);

			query.append(_FINDER_COLUMN_BYUSERID_SDQID_STID_SHOOTINGDIRECTORQUALIFICATIONID_2);

			query.append(_FINDER_COLUMN_BYUSERID_SDQID_STID_SPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId.longValue());

				qPos.add(shootingDirectorQualificationId.longValue());

				qPos.add(sportTypeId.longValue());

				List<ESFShootingDirector> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFShootingDirectorPersistenceImpl.fetchBybyUserId_SDQId_STId(Long, Long, Long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFShootingDirector esfShootingDirector = list.get(0);

					result = esfShootingDirector;

					cacheResult(esfShootingDirector);

					if ((esfShootingDirector.getEsfUserId() != esfUserId) ||
							(esfShootingDirector.getShootingDirectorQualificationId() != shootingDirectorQualificationId) ||
							(esfShootingDirector.getSportTypeId() != sportTypeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
							finderArgs, esfShootingDirector);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
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
			return (ESFShootingDirector)result;
		}
	}

	/**
	 * Removes the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param sportTypeId the sport type ID
	 * @return the e s f shooting director that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector removeBybyUserId_SDQId_STId(Long esfUserId,
		Long shootingDirectorQualificationId, Long sportTypeId)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = findBybyUserId_SDQId_STId(esfUserId,
				shootingDirectorQualificationId, sportTypeId);

		return remove(esfShootingDirector);
	}

	/**
	 * Returns the number of e s f shooting directors where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param shootingDirectorQualificationId the shooting director qualification ID
	 * @param sportTypeId the sport type ID
	 * @return the number of matching e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyUserId_SDQId_STId(Long esfUserId,
		Long shootingDirectorQualificationId, Long sportTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYUSERID_SDQID_STID;

		Object[] finderArgs = new Object[] {
				esfUserId, shootingDirectorQualificationId, sportTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFSHOOTINGDIRECTOR_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_SDQID_STID_ESFUSERID_2);

			query.append(_FINDER_COLUMN_BYUSERID_SDQID_STID_SHOOTINGDIRECTORQUALIFICATIONID_2);

			query.append(_FINDER_COLUMN_BYUSERID_SDQID_STID_SPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId.longValue());

				qPos.add(shootingDirectorQualificationId.longValue());

				qPos.add(sportTypeId.longValue());

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

	private static final String _FINDER_COLUMN_BYUSERID_SDQID_STID_ESFUSERID_2 = "esfShootingDirector.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_BYUSERID_SDQID_STID_SHOOTINGDIRECTORQUALIFICATIONID_2 =
		"esfShootingDirector.shootingDirectorQualificationId = ? AND ";
	private static final String _FINDER_COLUMN_BYUSERID_SDQID_STID_SPORTTYPEID_2 =
		"esfShootingDirector.sportTypeId = ?";

	public ESFShootingDirectorPersistenceImpl() {
		setModelClass(ESFShootingDirector.class);
	}

	/**
	 * Caches the e s f shooting director in the entity cache if it is enabled.
	 *
	 * @param esfShootingDirector the e s f shooting director
	 */
	@Override
	public void cacheResult(ESFShootingDirector esfShootingDirector) {
		EntityCacheUtil.putResult(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorImpl.class, esfShootingDirector.getPrimaryKey(),
			esfShootingDirector);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
			new Object[] {
				esfShootingDirector.getEsfUserId(),
				esfShootingDirector.getShootingDirectorQualificationId(),
				esfShootingDirector.getSportTypeId()
			}, esfShootingDirector);

		esfShootingDirector.resetOriginalValues();
	}

	/**
	 * Caches the e s f shooting directors in the entity cache if it is enabled.
	 *
	 * @param esfShootingDirectors the e s f shooting directors
	 */
	@Override
	public void cacheResult(List<ESFShootingDirector> esfShootingDirectors) {
		for (ESFShootingDirector esfShootingDirector : esfShootingDirectors) {
			if (EntityCacheUtil.getResult(
						ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
						ESFShootingDirectorImpl.class,
						esfShootingDirector.getPrimaryKey()) == null) {
				cacheResult(esfShootingDirector);
			}
			else {
				esfShootingDirector.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f shooting directors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFShootingDirectorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFShootingDirectorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f shooting director.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFShootingDirector esfShootingDirector) {
		EntityCacheUtil.removeResult(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorImpl.class, esfShootingDirector.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfShootingDirector);
	}

	@Override
	public void clearCache(List<ESFShootingDirector> esfShootingDirectors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFShootingDirector esfShootingDirector : esfShootingDirectors) {
			EntityCacheUtil.removeResult(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
				ESFShootingDirectorImpl.class,
				esfShootingDirector.getPrimaryKey());

			clearUniqueFindersCache(esfShootingDirector);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFShootingDirector esfShootingDirector) {
		if (esfShootingDirector.isNew()) {
			Object[] args = new Object[] {
					esfShootingDirector.getEsfUserId(),
					esfShootingDirector.getShootingDirectorQualificationId(),
					esfShootingDirector.getSportTypeId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYUSERID_SDQID_STID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
				args, esfShootingDirector);
		}
		else {
			ESFShootingDirectorModelImpl esfShootingDirectorModelImpl = (ESFShootingDirectorModelImpl)esfShootingDirector;

			if ((esfShootingDirectorModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShootingDirector.getEsfUserId(),
						esfShootingDirector.getShootingDirectorQualificationId(),
						esfShootingDirector.getSportTypeId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYUSERID_SDQID_STID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
					args, esfShootingDirector);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFShootingDirector esfShootingDirector) {
		ESFShootingDirectorModelImpl esfShootingDirectorModelImpl = (ESFShootingDirectorModelImpl)esfShootingDirector;

		Object[] args = new Object[] {
				esfShootingDirector.getEsfUserId(),
				esfShootingDirector.getShootingDirectorQualificationId(),
				esfShootingDirector.getSportTypeId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID_SDQID_STID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
			args);

		if ((esfShootingDirectorModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfShootingDirectorModelImpl.getOriginalEsfUserId(),
					esfShootingDirectorModelImpl.getOriginalShootingDirectorQualificationId(),
					esfShootingDirectorModelImpl.getOriginalSportTypeId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID_SDQID_STID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYUSERID_SDQID_STID,
				args);
		}
	}

	/**
	 * Creates a new e s f shooting director with the primary key. Does not add the e s f shooting director to the database.
	 *
	 * @param esfShootingDirectorId the primary key for the new e s f shooting director
	 * @return the new e s f shooting director
	 */
	@Override
	public ESFShootingDirector create(long esfShootingDirectorId) {
		ESFShootingDirector esfShootingDirector = new ESFShootingDirectorImpl();

		esfShootingDirector.setNew(true);
		esfShootingDirector.setPrimaryKey(esfShootingDirectorId);

		return esfShootingDirector;
	}

	/**
	 * Removes the e s f shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfShootingDirectorId the primary key of the e s f shooting director
	 * @return the e s f shooting director that was removed
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector remove(long esfShootingDirectorId)
		throws NoSuchShootingDirectorException, SystemException {
		return remove((Serializable)esfShootingDirectorId);
	}

	/**
	 * Removes the e s f shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f shooting director
	 * @return the e s f shooting director that was removed
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector remove(Serializable primaryKey)
		throws NoSuchShootingDirectorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFShootingDirector esfShootingDirector = (ESFShootingDirector)session.get(ESFShootingDirectorImpl.class,
					primaryKey);

			if (esfShootingDirector == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShootingDirectorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfShootingDirector);
		}
		catch (NoSuchShootingDirectorException nsee) {
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
	protected ESFShootingDirector removeImpl(
		ESFShootingDirector esfShootingDirector) throws SystemException {
		esfShootingDirector = toUnwrappedModel(esfShootingDirector);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfShootingDirector)) {
				esfShootingDirector = (ESFShootingDirector)session.get(ESFShootingDirectorImpl.class,
						esfShootingDirector.getPrimaryKeyObj());
			}

			if (esfShootingDirector != null) {
				session.delete(esfShootingDirector);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfShootingDirector != null) {
			clearCache(esfShootingDirector);
		}

		return esfShootingDirector;
	}

	@Override
	public ESFShootingDirector updateImpl(
		it.ethica.esf.model.ESFShootingDirector esfShootingDirector)
		throws SystemException {
		esfShootingDirector = toUnwrappedModel(esfShootingDirector);

		boolean isNew = esfShootingDirector.isNew();

		ESFShootingDirectorModelImpl esfShootingDirectorModelImpl = (ESFShootingDirectorModelImpl)esfShootingDirector;

		Session session = null;

		try {
			session = openSession();

			if (esfShootingDirector.isNew()) {
				session.save(esfShootingDirector);

				esfShootingDirector.setNew(false);
			}
			else {
				session.merge(esfShootingDirector);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFShootingDirectorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfShootingDirectorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShootingDirectorModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);

				args = new Object[] { esfShootingDirectorModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);
			}

			if ((esfShootingDirectorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSHOOTINGDIRECTORQUALIFICATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShootingDirectorModelImpl.getOriginalShootingDirectorQualificationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSHOOTINGDIRECTORQUALIFICATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSHOOTINGDIRECTORQUALIFICATIONID,
					args);

				args = new Object[] {
						esfShootingDirectorModelImpl.getShootingDirectorQualificationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSHOOTINGDIRECTORQUALIFICATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSHOOTINGDIRECTORQUALIFICATIONID,
					args);
			}

			if ((esfShootingDirectorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSPORTTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShootingDirectorModelImpl.getOriginalSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSPORTTYPEID,
					args);

				args = new Object[] {
						esfShootingDirectorModelImpl.getSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSPORTTYPEID,
					args);
			}

			if ((esfShootingDirectorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYREGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShootingDirectorModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYREGIONID,
					args);

				args = new Object[] { esfShootingDirectorModelImpl.getRegionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYREGIONID,
					args);
			}

			if ((esfShootingDirectorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYPROVINCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShootingDirectorModelImpl.getOriginalProvinceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYPROVINCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYPROVINCEID,
					args);

				args = new Object[] { esfShootingDirectorModelImpl.getProvinceId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYPROVINCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYPROVINCEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorImpl.class, esfShootingDirector.getPrimaryKey(),
			esfShootingDirector);

		clearUniqueFindersCache(esfShootingDirector);
		cacheUniqueFindersCache(esfShootingDirector);

		return esfShootingDirector;
	}

	protected ESFShootingDirector toUnwrappedModel(
		ESFShootingDirector esfShootingDirector) {
		if (esfShootingDirector instanceof ESFShootingDirectorImpl) {
			return esfShootingDirector;
		}

		ESFShootingDirectorImpl esfShootingDirectorImpl = new ESFShootingDirectorImpl();

		esfShootingDirectorImpl.setNew(esfShootingDirector.isNew());
		esfShootingDirectorImpl.setPrimaryKey(esfShootingDirector.getPrimaryKey());

		esfShootingDirectorImpl.setEsfShootingDirectorId(esfShootingDirector.getEsfShootingDirectorId());
		esfShootingDirectorImpl.setEsfCodeData(esfShootingDirector.getEsfCodeData());
		esfShootingDirectorImpl.setEsfStartData(esfShootingDirector.getEsfStartData());
		esfShootingDirectorImpl.setEsfEndData(esfShootingDirector.getEsfEndData());
		esfShootingDirectorImpl.setEsfUserId(esfShootingDirector.getEsfUserId());
		esfShootingDirectorImpl.setCodeUser(esfShootingDirector.getCodeUser());
		esfShootingDirectorImpl.setShootingDirectorQualificationId(esfShootingDirector.getShootingDirectorQualificationId());
		esfShootingDirectorImpl.setSportTypeId(esfShootingDirector.getSportTypeId());
		esfShootingDirectorImpl.setRegionId(esfShootingDirector.getRegionId());
		esfShootingDirectorImpl.setProvinceId(esfShootingDirector.getProvinceId());
		esfShootingDirectorImpl.setFlagCrea(esfShootingDirector.getFlagCrea());
		esfShootingDirectorImpl.setDateVar(esfShootingDirector.getDateVar());

		return esfShootingDirectorImpl;
	}

	/**
	 * Returns the e s f shooting director with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooting director
	 * @return the e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShootingDirectorException, SystemException {
		ESFShootingDirector esfShootingDirector = fetchByPrimaryKey(primaryKey);

		if (esfShootingDirector == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShootingDirectorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfShootingDirector;
	}

	/**
	 * Returns the e s f shooting director with the primary key or throws a {@link it.ethica.esf.NoSuchShootingDirectorException} if it could not be found.
	 *
	 * @param esfShootingDirectorId the primary key of the e s f shooting director
	 * @return the e s f shooting director
	 * @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector findByPrimaryKey(long esfShootingDirectorId)
		throws NoSuchShootingDirectorException, SystemException {
		return findByPrimaryKey((Serializable)esfShootingDirectorId);
	}

	/**
	 * Returns the e s f shooting director with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooting director
	 * @return the e s f shooting director, or <code>null</code> if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFShootingDirector esfShootingDirector = (ESFShootingDirector)EntityCacheUtil.getResult(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
				ESFShootingDirectorImpl.class, primaryKey);

		if (esfShootingDirector == _nullESFShootingDirector) {
			return null;
		}

		if (esfShootingDirector == null) {
			Session session = null;

			try {
				session = openSession();

				esfShootingDirector = (ESFShootingDirector)session.get(ESFShootingDirectorImpl.class,
						primaryKey);

				if (esfShootingDirector != null) {
					cacheResult(esfShootingDirector);
				}
				else {
					EntityCacheUtil.putResult(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
						ESFShootingDirectorImpl.class, primaryKey,
						_nullESFShootingDirector);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
					ESFShootingDirectorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfShootingDirector;
	}

	/**
	 * Returns the e s f shooting director with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfShootingDirectorId the primary key of the e s f shooting director
	 * @return the e s f shooting director, or <code>null</code> if a e s f shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirector fetchByPrimaryKey(long esfShootingDirectorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfShootingDirectorId);
	}

	/**
	 * Returns all the e s f shooting directors.
	 *
	 * @return the e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooting directors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @return the range of e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooting directors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooting directors
	 * @param end the upper bound of the range of e s f shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirector> findAll(int start, int end,
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

		List<ESFShootingDirector> list = (List<ESFShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSHOOTINGDIRECTOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSHOOTINGDIRECTOR;

				if (pagination) {
					sql = sql.concat(ESFShootingDirectorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShootingDirector>(list);
				}
				else {
					list = (List<ESFShootingDirector>)QueryUtil.list(q,
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
	 * Removes all the e s f shooting directors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFShootingDirector esfShootingDirector : findAll()) {
			remove(esfShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f shooting directors.
	 *
	 * @return the number of e s f shooting directors
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

				Query q = session.createQuery(_SQL_COUNT_ESFSHOOTINGDIRECTOR);

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
	 * Initializes the e s f shooting director persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFShootingDirector")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFShootingDirector>> listenersList = new ArrayList<ModelListener<ESFShootingDirector>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFShootingDirector>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFShootingDirectorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSHOOTINGDIRECTOR = "SELECT esfShootingDirector FROM ESFShootingDirector esfShootingDirector";
	private static final String _SQL_SELECT_ESFSHOOTINGDIRECTOR_WHERE = "SELECT esfShootingDirector FROM ESFShootingDirector esfShootingDirector WHERE ";
	private static final String _SQL_COUNT_ESFSHOOTINGDIRECTOR = "SELECT COUNT(esfShootingDirector) FROM ESFShootingDirector esfShootingDirector";
	private static final String _SQL_COUNT_ESFSHOOTINGDIRECTOR_WHERE = "SELECT COUNT(esfShootingDirector) FROM ESFShootingDirector esfShootingDirector WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfShootingDirector.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFShootingDirector exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFShootingDirector exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFShootingDirectorPersistenceImpl.class);
	private static ESFShootingDirector _nullESFShootingDirector = new ESFShootingDirectorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFShootingDirector> toCacheModel() {
				return _nullESFShootingDirectorCacheModel;
			}
		};

	private static CacheModel<ESFShootingDirector> _nullESFShootingDirectorCacheModel =
		new CacheModel<ESFShootingDirector>() {
			@Override
			public ESFShootingDirector toEntityModel() {
				return _nullESFShootingDirector;
			}
		};
}