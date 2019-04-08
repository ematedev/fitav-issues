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

import it.ethica.esf.NoSuchDescriptionException;
import it.ethica.esf.model.ESFDescription;
import it.ethica.esf.model.impl.ESFDescriptionImpl;
import it.ethica.esf.model.impl.ESFDescriptionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f description service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDescriptionPersistence
 * @see ESFDescriptionUtil
 * @generated
 */
public class ESFDescriptionPersistenceImpl extends BasePersistenceImpl<ESFDescription>
	implements ESFDescriptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFDescriptionUtil} to access the e s f description persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFDescriptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionModelImpl.FINDER_CACHE_ENABLED,
			ESFDescriptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionModelImpl.FINDER_CACHE_ENABLED,
			ESFDescriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISNATIONAL =
		new FinderPath(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionModelImpl.FINDER_CACHE_ENABLED,
			ESFDescriptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIsNational",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL =
		new FinderPath(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionModelImpl.FINDER_CACHE_ENABLED,
			ESFDescriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsNational",
			new String[] { Boolean.class.getName() },
			ESFDescriptionModelImpl.ISNATIONAL_COLUMN_BITMASK |
			ESFDescriptionModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISNATIONAL = new FinderPath(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsNational",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the e s f descriptions where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @return the matching e s f descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDescription> findByIsNational(boolean isNational)
		throws SystemException {
		return findByIsNational(isNational, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f descriptions where isNational = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isNational the is national
	 * @param start the lower bound of the range of e s f descriptions
	 * @param end the upper bound of the range of e s f descriptions (not inclusive)
	 * @return the range of matching e s f descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDescription> findByIsNational(boolean isNational, int start,
		int end) throws SystemException {
		return findByIsNational(isNational, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f descriptions where isNational = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isNational the is national
	 * @param start the lower bound of the range of e s f descriptions
	 * @param end the upper bound of the range of e s f descriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDescription> findByIsNational(boolean isNational, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL;
			finderArgs = new Object[] { isNational };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISNATIONAL;
			finderArgs = new Object[] { isNational, start, end, orderByComparator };
		}

		List<ESFDescription> list = (List<ESFDescription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDescription esfDescription : list) {
				if ((isNational != esfDescription.getIsNational())) {
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

			query.append(_SQL_SELECT_ESFDESCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_ISNATIONAL_ISNATIONAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDescriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isNational);

				if (!pagination) {
					list = (List<ESFDescription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDescription>(list);
				}
				else {
					list = (List<ESFDescription>)QueryUtil.list(q,
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
	 * Returns the first e s f description in the ordered set where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f description
	 * @throws it.ethica.esf.NoSuchDescriptionException if a matching e s f description could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription findByIsNational_First(boolean isNational,
		OrderByComparator orderByComparator)
		throws NoSuchDescriptionException, SystemException {
		ESFDescription esfDescription = fetchByIsNational_First(isNational,
				orderByComparator);

		if (esfDescription != null) {
			return esfDescription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isNational=");
		msg.append(isNational);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDescriptionException(msg.toString());
	}

	/**
	 * Returns the first e s f description in the ordered set where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f description, or <code>null</code> if a matching e s f description could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription fetchByIsNational_First(boolean isNational,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDescription> list = findByIsNational(isNational, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f description in the ordered set where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f description
	 * @throws it.ethica.esf.NoSuchDescriptionException if a matching e s f description could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription findByIsNational_Last(boolean isNational,
		OrderByComparator orderByComparator)
		throws NoSuchDescriptionException, SystemException {
		ESFDescription esfDescription = fetchByIsNational_Last(isNational,
				orderByComparator);

		if (esfDescription != null) {
			return esfDescription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isNational=");
		msg.append(isNational);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDescriptionException(msg.toString());
	}

	/**
	 * Returns the last e s f description in the ordered set where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f description, or <code>null</code> if a matching e s f description could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription fetchByIsNational_Last(boolean isNational,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsNational(isNational);

		if (count == 0) {
			return null;
		}

		List<ESFDescription> list = findByIsNational(isNational, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f descriptions before and after the current e s f description in the ordered set where isNational = &#63;.
	 *
	 * @param esfDescriptionId the primary key of the current e s f description
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f description
	 * @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription[] findByIsNational_PrevAndNext(
		long esfDescriptionId, boolean isNational,
		OrderByComparator orderByComparator)
		throws NoSuchDescriptionException, SystemException {
		ESFDescription esfDescription = findByPrimaryKey(esfDescriptionId);

		Session session = null;

		try {
			session = openSession();

			ESFDescription[] array = new ESFDescriptionImpl[3];

			array[0] = getByIsNational_PrevAndNext(session, esfDescription,
					isNational, orderByComparator, true);

			array[1] = esfDescription;

			array[2] = getByIsNational_PrevAndNext(session, esfDescription,
					isNational, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFDescription getByIsNational_PrevAndNext(Session session,
		ESFDescription esfDescription, boolean isNational,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDESCRIPTION_WHERE);

		query.append(_FINDER_COLUMN_ISNATIONAL_ISNATIONAL_2);

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
			query.append(ESFDescriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isNational);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDescription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDescription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f descriptions where isNational = &#63; from the database.
	 *
	 * @param isNational the is national
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsNational(boolean isNational)
		throws SystemException {
		for (ESFDescription esfDescription : findByIsNational(isNational,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDescription);
		}
	}

	/**
	 * Returns the number of e s f descriptions where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @return the number of matching e s f descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIsNational(boolean isNational) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISNATIONAL;

		Object[] finderArgs = new Object[] { isNational };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFDESCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_ISNATIONAL_ISNATIONAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isNational);

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

	private static final String _FINDER_COLUMN_ISNATIONAL_ISNATIONAL_2 = "esfDescription.isNational = ?";

	public ESFDescriptionPersistenceImpl() {
		setModelClass(ESFDescription.class);
	}

	/**
	 * Caches the e s f description in the entity cache if it is enabled.
	 *
	 * @param esfDescription the e s f description
	 */
	@Override
	public void cacheResult(ESFDescription esfDescription) {
		EntityCacheUtil.putResult(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionImpl.class, esfDescription.getPrimaryKey(),
			esfDescription);

		esfDescription.resetOriginalValues();
	}

	/**
	 * Caches the e s f descriptions in the entity cache if it is enabled.
	 *
	 * @param esfDescriptions the e s f descriptions
	 */
	@Override
	public void cacheResult(List<ESFDescription> esfDescriptions) {
		for (ESFDescription esfDescription : esfDescriptions) {
			if (EntityCacheUtil.getResult(
						ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
						ESFDescriptionImpl.class, esfDescription.getPrimaryKey()) == null) {
				cacheResult(esfDescription);
			}
			else {
				esfDescription.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f descriptions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFDescriptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFDescriptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f description.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFDescription esfDescription) {
		EntityCacheUtil.removeResult(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionImpl.class, esfDescription.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFDescription> esfDescriptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFDescription esfDescription : esfDescriptions) {
			EntityCacheUtil.removeResult(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
				ESFDescriptionImpl.class, esfDescription.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f description with the primary key. Does not add the e s f description to the database.
	 *
	 * @param esfDescriptionId the primary key for the new e s f description
	 * @return the new e s f description
	 */
	@Override
	public ESFDescription create(long esfDescriptionId) {
		ESFDescription esfDescription = new ESFDescriptionImpl();

		esfDescription.setNew(true);
		esfDescription.setPrimaryKey(esfDescriptionId);

		return esfDescription;
	}

	/**
	 * Removes the e s f description with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfDescriptionId the primary key of the e s f description
	 * @return the e s f description that was removed
	 * @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription remove(long esfDescriptionId)
		throws NoSuchDescriptionException, SystemException {
		return remove((Serializable)esfDescriptionId);
	}

	/**
	 * Removes the e s f description with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f description
	 * @return the e s f description that was removed
	 * @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription remove(Serializable primaryKey)
		throws NoSuchDescriptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFDescription esfDescription = (ESFDescription)session.get(ESFDescriptionImpl.class,
					primaryKey);

			if (esfDescription == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDescriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfDescription);
		}
		catch (NoSuchDescriptionException nsee) {
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
	protected ESFDescription removeImpl(ESFDescription esfDescription)
		throws SystemException {
		esfDescription = toUnwrappedModel(esfDescription);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfDescription)) {
				esfDescription = (ESFDescription)session.get(ESFDescriptionImpl.class,
						esfDescription.getPrimaryKeyObj());
			}

			if (esfDescription != null) {
				session.delete(esfDescription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfDescription != null) {
			clearCache(esfDescription);
		}

		return esfDescription;
	}

	@Override
	public ESFDescription updateImpl(
		it.ethica.esf.model.ESFDescription esfDescription)
		throws SystemException {
		esfDescription = toUnwrappedModel(esfDescription);

		boolean isNew = esfDescription.isNew();

		ESFDescriptionModelImpl esfDescriptionModelImpl = (ESFDescriptionModelImpl)esfDescription;

		Session session = null;

		try {
			session = openSession();

			if (esfDescription.isNew()) {
				session.save(esfDescription);

				esfDescription.setNew(false);
			}
			else {
				session.merge(esfDescription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFDescriptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfDescriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDescriptionModelImpl.getOriginalIsNational()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISNATIONAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL,
					args);

				args = new Object[] { esfDescriptionModelImpl.getIsNational() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISNATIONAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ESFDescriptionImpl.class, esfDescription.getPrimaryKey(),
			esfDescription);

		return esfDescription;
	}

	protected ESFDescription toUnwrappedModel(ESFDescription esfDescription) {
		if (esfDescription instanceof ESFDescriptionImpl) {
			return esfDescription;
		}

		ESFDescriptionImpl esfDescriptionImpl = new ESFDescriptionImpl();

		esfDescriptionImpl.setNew(esfDescription.isNew());
		esfDescriptionImpl.setPrimaryKey(esfDescription.getPrimaryKey());

		esfDescriptionImpl.setEsfDescriptionId(esfDescription.getEsfDescriptionId());
		esfDescriptionImpl.setIsNational(esfDescription.isIsNational());
		esfDescriptionImpl.setName(esfDescription.getName());

		return esfDescriptionImpl;
	}

	/**
	 * Returns the e s f description with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f description
	 * @return the e s f description
	 * @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDescriptionException, SystemException {
		ESFDescription esfDescription = fetchByPrimaryKey(primaryKey);

		if (esfDescription == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDescriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfDescription;
	}

	/**
	 * Returns the e s f description with the primary key or throws a {@link it.ethica.esf.NoSuchDescriptionException} if it could not be found.
	 *
	 * @param esfDescriptionId the primary key of the e s f description
	 * @return the e s f description
	 * @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription findByPrimaryKey(long esfDescriptionId)
		throws NoSuchDescriptionException, SystemException {
		return findByPrimaryKey((Serializable)esfDescriptionId);
	}

	/**
	 * Returns the e s f description with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f description
	 * @return the e s f description, or <code>null</code> if a e s f description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFDescription esfDescription = (ESFDescription)EntityCacheUtil.getResult(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
				ESFDescriptionImpl.class, primaryKey);

		if (esfDescription == _nullESFDescription) {
			return null;
		}

		if (esfDescription == null) {
			Session session = null;

			try {
				session = openSession();

				esfDescription = (ESFDescription)session.get(ESFDescriptionImpl.class,
						primaryKey);

				if (esfDescription != null) {
					cacheResult(esfDescription);
				}
				else {
					EntityCacheUtil.putResult(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
						ESFDescriptionImpl.class, primaryKey,
						_nullESFDescription);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFDescriptionModelImpl.ENTITY_CACHE_ENABLED,
					ESFDescriptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfDescription;
	}

	/**
	 * Returns the e s f description with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfDescriptionId the primary key of the e s f description
	 * @return the e s f description, or <code>null</code> if a e s f description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDescription fetchByPrimaryKey(long esfDescriptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfDescriptionId);
	}

	/**
	 * Returns all the e s f descriptions.
	 *
	 * @return the e s f descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDescription> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f descriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f descriptions
	 * @param end the upper bound of the range of e s f descriptions (not inclusive)
	 * @return the range of e s f descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDescription> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f descriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f descriptions
	 * @param end the upper bound of the range of e s f descriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDescription> findAll(int start, int end,
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

		List<ESFDescription> list = (List<ESFDescription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFDESCRIPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFDESCRIPTION;

				if (pagination) {
					sql = sql.concat(ESFDescriptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFDescription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDescription>(list);
				}
				else {
					list = (List<ESFDescription>)QueryUtil.list(q,
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
	 * Removes all the e s f descriptions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFDescription esfDescription : findAll()) {
			remove(esfDescription);
		}
	}

	/**
	 * Returns the number of e s f descriptions.
	 *
	 * @return the number of e s f descriptions
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

				Query q = session.createQuery(_SQL_COUNT_ESFDESCRIPTION);

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
	 * Initializes the e s f description persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFDescription")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFDescription>> listenersList = new ArrayList<ModelListener<ESFDescription>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFDescription>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFDescriptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFDESCRIPTION = "SELECT esfDescription FROM ESFDescription esfDescription";
	private static final String _SQL_SELECT_ESFDESCRIPTION_WHERE = "SELECT esfDescription FROM ESFDescription esfDescription WHERE ";
	private static final String _SQL_COUNT_ESFDESCRIPTION = "SELECT COUNT(esfDescription) FROM ESFDescription esfDescription";
	private static final String _SQL_COUNT_ESFDESCRIPTION_WHERE = "SELECT COUNT(esfDescription) FROM ESFDescription esfDescription WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfDescription.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFDescription exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFDescription exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFDescriptionPersistenceImpl.class);
	private static ESFDescription _nullESFDescription = new ESFDescriptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFDescription> toCacheModel() {
				return _nullESFDescriptionCacheModel;
			}
		};

	private static CacheModel<ESFDescription> _nullESFDescriptionCacheModel = new CacheModel<ESFDescription>() {
			@Override
			public ESFDescription toEntityModel() {
				return _nullESFDescription;
			}
		};
}