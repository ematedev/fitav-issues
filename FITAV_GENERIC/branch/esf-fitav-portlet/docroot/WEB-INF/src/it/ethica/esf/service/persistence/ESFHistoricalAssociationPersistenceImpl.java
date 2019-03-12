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

import it.ethica.esf.NoSuchHistoricalAssociationException;
import it.ethica.esf.model.ESFHistoricalAssociation;
import it.ethica.esf.model.impl.ESFHistoricalAssociationImpl;
import it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f historical association service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFHistoricalAssociationPersistence
 * @see ESFHistoricalAssociationUtil
 * @generated
 */
public class ESFHistoricalAssociationPersistenceImpl extends BasePersistenceImpl<ESFHistoricalAssociation>
	implements ESFHistoricalAssociationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFHistoricalAssociationUtil} to access the e s f historical association persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFHistoricalAssociationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationModelImpl.FINDER_CACHE_ENABLED,
			ESFHistoricalAssociationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationModelImpl.FINDER_CACHE_ENABLED,
			ESFHistoricalAssociationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORG_DATE = new FinderPath(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationModelImpl.FINDER_CACHE_ENABLED,
			ESFHistoricalAssociationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrg_Date",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_DATE =
		new FinderPath(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationModelImpl.FINDER_CACHE_ENABLED,
			ESFHistoricalAssociationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrg_Date",
			new String[] { Long.class.getName() },
			ESFHistoricalAssociationModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			ESFHistoricalAssociationModelImpl.DATECHANGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORG_DATE = new FinderPath(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrg_Date",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f historical associations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching e s f historical associations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFHistoricalAssociation> findByOrg_Date(long organizationId)
		throws SystemException {
		return findByOrg_Date(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f historical associations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of e s f historical associations
	 * @param end the upper bound of the range of e s f historical associations (not inclusive)
	 * @return the range of matching e s f historical associations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFHistoricalAssociation> findByOrg_Date(long organizationId,
		int start, int end) throws SystemException {
		return findByOrg_Date(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f historical associations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of e s f historical associations
	 * @param end the upper bound of the range of e s f historical associations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f historical associations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFHistoricalAssociation> findByOrg_Date(long organizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_DATE;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORG_DATE;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFHistoricalAssociation> list = (List<ESFHistoricalAssociation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFHistoricalAssociation esfHistoricalAssociation : list) {
				if ((organizationId != esfHistoricalAssociation.getOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFHISTORICALASSOCIATION_WHERE);

			query.append(_FINDER_COLUMN_ORG_DATE_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFHistoricalAssociationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<ESFHistoricalAssociation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFHistoricalAssociation>(list);
				}
				else {
					list = (List<ESFHistoricalAssociation>)QueryUtil.list(q,
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
	 * Returns the first e s f historical association in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f historical association
	 * @throws it.ethica.esf.NoSuchHistoricalAssociationException if a matching e s f historical association could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation findByOrg_Date_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchHistoricalAssociationException, SystemException {
		ESFHistoricalAssociation esfHistoricalAssociation = fetchByOrg_Date_First(organizationId,
				orderByComparator);

		if (esfHistoricalAssociation != null) {
			return esfHistoricalAssociation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHistoricalAssociationException(msg.toString());
	}

	/**
	 * Returns the first e s f historical association in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f historical association, or <code>null</code> if a matching e s f historical association could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation fetchByOrg_Date_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFHistoricalAssociation> list = findByOrg_Date(organizationId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f historical association in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f historical association
	 * @throws it.ethica.esf.NoSuchHistoricalAssociationException if a matching e s f historical association could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation findByOrg_Date_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchHistoricalAssociationException, SystemException {
		ESFHistoricalAssociation esfHistoricalAssociation = fetchByOrg_Date_Last(organizationId,
				orderByComparator);

		if (esfHistoricalAssociation != null) {
			return esfHistoricalAssociation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHistoricalAssociationException(msg.toString());
	}

	/**
	 * Returns the last e s f historical association in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f historical association, or <code>null</code> if a matching e s f historical association could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation fetchByOrg_Date_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrg_Date(organizationId);

		if (count == 0) {
			return null;
		}

		List<ESFHistoricalAssociation> list = findByOrg_Date(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f historical associations before and after the current e s f historical association in the ordered set where organizationId = &#63;.
	 *
	 * @param idHistoricalAssociation the primary key of the current e s f historical association
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f historical association
	 * @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation[] findByOrg_Date_PrevAndNext(
		long idHistoricalAssociation, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchHistoricalAssociationException, SystemException {
		ESFHistoricalAssociation esfHistoricalAssociation = findByPrimaryKey(idHistoricalAssociation);

		Session session = null;

		try {
			session = openSession();

			ESFHistoricalAssociation[] array = new ESFHistoricalAssociationImpl[3];

			array[0] = getByOrg_Date_PrevAndNext(session,
					esfHistoricalAssociation, organizationId,
					orderByComparator, true);

			array[1] = esfHistoricalAssociation;

			array[2] = getByOrg_Date_PrevAndNext(session,
					esfHistoricalAssociation, organizationId,
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

	protected ESFHistoricalAssociation getByOrg_Date_PrevAndNext(
		Session session, ESFHistoricalAssociation esfHistoricalAssociation,
		long organizationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFHISTORICALASSOCIATION_WHERE);

		query.append(_FINDER_COLUMN_ORG_DATE_ORGANIZATIONID_2);

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
			query.append(ESFHistoricalAssociationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfHistoricalAssociation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFHistoricalAssociation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f historical associations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrg_Date(long organizationId) throws SystemException {
		for (ESFHistoricalAssociation esfHistoricalAssociation : findByOrg_Date(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfHistoricalAssociation);
		}
	}

	/**
	 * Returns the number of e s f historical associations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching e s f historical associations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrg_Date(long organizationId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORG_DATE;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFHISTORICALASSOCIATION_WHERE);

			query.append(_FINDER_COLUMN_ORG_DATE_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORG_DATE_ORGANIZATIONID_2 = "esfHistoricalAssociation.organizationId = ?";

	public ESFHistoricalAssociationPersistenceImpl() {
		setModelClass(ESFHistoricalAssociation.class);
	}

	/**
	 * Caches the e s f historical association in the entity cache if it is enabled.
	 *
	 * @param esfHistoricalAssociation the e s f historical association
	 */
	@Override
	public void cacheResult(ESFHistoricalAssociation esfHistoricalAssociation) {
		EntityCacheUtil.putResult(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationImpl.class,
			esfHistoricalAssociation.getPrimaryKey(), esfHistoricalAssociation);

		esfHistoricalAssociation.resetOriginalValues();
	}

	/**
	 * Caches the e s f historical associations in the entity cache if it is enabled.
	 *
	 * @param esfHistoricalAssociations the e s f historical associations
	 */
	@Override
	public void cacheResult(
		List<ESFHistoricalAssociation> esfHistoricalAssociations) {
		for (ESFHistoricalAssociation esfHistoricalAssociation : esfHistoricalAssociations) {
			if (EntityCacheUtil.getResult(
						ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
						ESFHistoricalAssociationImpl.class,
						esfHistoricalAssociation.getPrimaryKey()) == null) {
				cacheResult(esfHistoricalAssociation);
			}
			else {
				esfHistoricalAssociation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f historical associations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFHistoricalAssociationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFHistoricalAssociationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f historical association.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFHistoricalAssociation esfHistoricalAssociation) {
		EntityCacheUtil.removeResult(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationImpl.class,
			esfHistoricalAssociation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFHistoricalAssociation> esfHistoricalAssociations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFHistoricalAssociation esfHistoricalAssociation : esfHistoricalAssociations) {
			EntityCacheUtil.removeResult(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
				ESFHistoricalAssociationImpl.class,
				esfHistoricalAssociation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f historical association with the primary key. Does not add the e s f historical association to the database.
	 *
	 * @param idHistoricalAssociation the primary key for the new e s f historical association
	 * @return the new e s f historical association
	 */
	@Override
	public ESFHistoricalAssociation create(long idHistoricalAssociation) {
		ESFHistoricalAssociation esfHistoricalAssociation = new ESFHistoricalAssociationImpl();

		esfHistoricalAssociation.setNew(true);
		esfHistoricalAssociation.setPrimaryKey(idHistoricalAssociation);

		return esfHistoricalAssociation;
	}

	/**
	 * Removes the e s f historical association with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idHistoricalAssociation the primary key of the e s f historical association
	 * @return the e s f historical association that was removed
	 * @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation remove(long idHistoricalAssociation)
		throws NoSuchHistoricalAssociationException, SystemException {
		return remove((Serializable)idHistoricalAssociation);
	}

	/**
	 * Removes the e s f historical association with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f historical association
	 * @return the e s f historical association that was removed
	 * @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation remove(Serializable primaryKey)
		throws NoSuchHistoricalAssociationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFHistoricalAssociation esfHistoricalAssociation = (ESFHistoricalAssociation)session.get(ESFHistoricalAssociationImpl.class,
					primaryKey);

			if (esfHistoricalAssociation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistoricalAssociationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfHistoricalAssociation);
		}
		catch (NoSuchHistoricalAssociationException nsee) {
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
	protected ESFHistoricalAssociation removeImpl(
		ESFHistoricalAssociation esfHistoricalAssociation)
		throws SystemException {
		esfHistoricalAssociation = toUnwrappedModel(esfHistoricalAssociation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfHistoricalAssociation)) {
				esfHistoricalAssociation = (ESFHistoricalAssociation)session.get(ESFHistoricalAssociationImpl.class,
						esfHistoricalAssociation.getPrimaryKeyObj());
			}

			if (esfHistoricalAssociation != null) {
				session.delete(esfHistoricalAssociation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfHistoricalAssociation != null) {
			clearCache(esfHistoricalAssociation);
		}

		return esfHistoricalAssociation;
	}

	@Override
	public ESFHistoricalAssociation updateImpl(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation)
		throws SystemException {
		esfHistoricalAssociation = toUnwrappedModel(esfHistoricalAssociation);

		boolean isNew = esfHistoricalAssociation.isNew();

		ESFHistoricalAssociationModelImpl esfHistoricalAssociationModelImpl = (ESFHistoricalAssociationModelImpl)esfHistoricalAssociation;

		Session session = null;

		try {
			session = openSession();

			if (esfHistoricalAssociation.isNew()) {
				session.save(esfHistoricalAssociation);

				esfHistoricalAssociation.setNew(false);
			}
			else {
				session.merge(esfHistoricalAssociation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFHistoricalAssociationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfHistoricalAssociationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfHistoricalAssociationModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORG_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_DATE,
					args);

				args = new Object[] {
						esfHistoricalAssociationModelImpl.getOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORG_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG_DATE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
			ESFHistoricalAssociationImpl.class,
			esfHistoricalAssociation.getPrimaryKey(), esfHistoricalAssociation);

		return esfHistoricalAssociation;
	}

	protected ESFHistoricalAssociation toUnwrappedModel(
		ESFHistoricalAssociation esfHistoricalAssociation) {
		if (esfHistoricalAssociation instanceof ESFHistoricalAssociationImpl) {
			return esfHistoricalAssociation;
		}

		ESFHistoricalAssociationImpl esfHistoricalAssociationImpl = new ESFHistoricalAssociationImpl();

		esfHistoricalAssociationImpl.setNew(esfHistoricalAssociation.isNew());
		esfHistoricalAssociationImpl.setPrimaryKey(esfHistoricalAssociation.getPrimaryKey());

		esfHistoricalAssociationImpl.setIdHistoricalAssociation(esfHistoricalAssociation.getIdHistoricalAssociation());
		esfHistoricalAssociationImpl.setName(esfHistoricalAssociation.getName());
		esfHistoricalAssociationImpl.setCode(esfHistoricalAssociation.getCode());
		esfHistoricalAssociationImpl.setDateChange(esfHistoricalAssociation.getDateChange());
		esfHistoricalAssociationImpl.setEndDate(esfHistoricalAssociation.getEndDate());
		esfHistoricalAssociationImpl.setOrganizationId(esfHistoricalAssociation.getOrganizationId());
		esfHistoricalAssociationImpl.setStateId(esfHistoricalAssociation.getStateId());
		esfHistoricalAssociationImpl.setVariationId(esfHistoricalAssociation.getVariationId());

		return esfHistoricalAssociationImpl;
	}

	/**
	 * Returns the e s f historical association with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f historical association
	 * @return the e s f historical association
	 * @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistoricalAssociationException, SystemException {
		ESFHistoricalAssociation esfHistoricalAssociation = fetchByPrimaryKey(primaryKey);

		if (esfHistoricalAssociation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistoricalAssociationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfHistoricalAssociation;
	}

	/**
	 * Returns the e s f historical association with the primary key or throws a {@link it.ethica.esf.NoSuchHistoricalAssociationException} if it could not be found.
	 *
	 * @param idHistoricalAssociation the primary key of the e s f historical association
	 * @return the e s f historical association
	 * @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation findByPrimaryKey(
		long idHistoricalAssociation)
		throws NoSuchHistoricalAssociationException, SystemException {
		return findByPrimaryKey((Serializable)idHistoricalAssociation);
	}

	/**
	 * Returns the e s f historical association with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f historical association
	 * @return the e s f historical association, or <code>null</code> if a e s f historical association with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFHistoricalAssociation esfHistoricalAssociation = (ESFHistoricalAssociation)EntityCacheUtil.getResult(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
				ESFHistoricalAssociationImpl.class, primaryKey);

		if (esfHistoricalAssociation == _nullESFHistoricalAssociation) {
			return null;
		}

		if (esfHistoricalAssociation == null) {
			Session session = null;

			try {
				session = openSession();

				esfHistoricalAssociation = (ESFHistoricalAssociation)session.get(ESFHistoricalAssociationImpl.class,
						primaryKey);

				if (esfHistoricalAssociation != null) {
					cacheResult(esfHistoricalAssociation);
				}
				else {
					EntityCacheUtil.putResult(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
						ESFHistoricalAssociationImpl.class, primaryKey,
						_nullESFHistoricalAssociation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFHistoricalAssociationModelImpl.ENTITY_CACHE_ENABLED,
					ESFHistoricalAssociationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfHistoricalAssociation;
	}

	/**
	 * Returns the e s f historical association with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idHistoricalAssociation the primary key of the e s f historical association
	 * @return the e s f historical association, or <code>null</code> if a e s f historical association with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFHistoricalAssociation fetchByPrimaryKey(
		long idHistoricalAssociation) throws SystemException {
		return fetchByPrimaryKey((Serializable)idHistoricalAssociation);
	}

	/**
	 * Returns all the e s f historical associations.
	 *
	 * @return the e s f historical associations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFHistoricalAssociation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f historical associations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f historical associations
	 * @param end the upper bound of the range of e s f historical associations (not inclusive)
	 * @return the range of e s f historical associations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFHistoricalAssociation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f historical associations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f historical associations
	 * @param end the upper bound of the range of e s f historical associations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f historical associations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFHistoricalAssociation> findAll(int start, int end,
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

		List<ESFHistoricalAssociation> list = (List<ESFHistoricalAssociation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFHISTORICALASSOCIATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFHISTORICALASSOCIATION;

				if (pagination) {
					sql = sql.concat(ESFHistoricalAssociationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFHistoricalAssociation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFHistoricalAssociation>(list);
				}
				else {
					list = (List<ESFHistoricalAssociation>)QueryUtil.list(q,
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
	 * Removes all the e s f historical associations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFHistoricalAssociation esfHistoricalAssociation : findAll()) {
			remove(esfHistoricalAssociation);
		}
	}

	/**
	 * Returns the number of e s f historical associations.
	 *
	 * @return the number of e s f historical associations
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

				Query q = session.createQuery(_SQL_COUNT_ESFHISTORICALASSOCIATION);

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
	 * Initializes the e s f historical association persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFHistoricalAssociation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFHistoricalAssociation>> listenersList = new ArrayList<ModelListener<ESFHistoricalAssociation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFHistoricalAssociation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFHistoricalAssociationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFHISTORICALASSOCIATION = "SELECT esfHistoricalAssociation FROM ESFHistoricalAssociation esfHistoricalAssociation";
	private static final String _SQL_SELECT_ESFHISTORICALASSOCIATION_WHERE = "SELECT esfHistoricalAssociation FROM ESFHistoricalAssociation esfHistoricalAssociation WHERE ";
	private static final String _SQL_COUNT_ESFHISTORICALASSOCIATION = "SELECT COUNT(esfHistoricalAssociation) FROM ESFHistoricalAssociation esfHistoricalAssociation";
	private static final String _SQL_COUNT_ESFHISTORICALASSOCIATION_WHERE = "SELECT COUNT(esfHistoricalAssociation) FROM ESFHistoricalAssociation esfHistoricalAssociation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfHistoricalAssociation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFHistoricalAssociation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFHistoricalAssociation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFHistoricalAssociationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static ESFHistoricalAssociation _nullESFHistoricalAssociation = new ESFHistoricalAssociationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFHistoricalAssociation> toCacheModel() {
				return _nullESFHistoricalAssociationCacheModel;
			}
		};

	private static CacheModel<ESFHistoricalAssociation> _nullESFHistoricalAssociationCacheModel =
		new CacheModel<ESFHistoricalAssociation>() {
			@Override
			public ESFHistoricalAssociation toEntityModel() {
				return _nullESFHistoricalAssociation;
			}
		};
}