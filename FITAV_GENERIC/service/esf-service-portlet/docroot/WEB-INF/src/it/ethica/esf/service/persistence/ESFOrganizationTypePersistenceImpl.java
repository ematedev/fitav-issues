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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchOrganizationTypeException;
import it.ethica.esf.model.ESFOrganizationType;
import it.ethica.esf.model.impl.ESFOrganizationTypeImpl;
import it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f organization type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationTypePersistence
 * @see ESFOrganizationTypeUtil
 * @generated
 */
public class ESFOrganizationTypePersistenceImpl extends BasePersistenceImpl<ESFOrganizationType>
	implements ESFOrganizationTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFOrganizationTypeUtil} to access the e s f organization type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFOrganizationTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFOrganizationId", new String[] { Long.class.getName() },
			ESFOrganizationTypeModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFORGANIZATIONID = new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFOrganizationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f organization types where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId) throws SystemException {
		return findByESFOrganizationId(esfOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization types where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f organization types
	 * @param end the upper bound of the range of e s f organization types (not inclusive)
	 * @return the range of matching e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId, int start, int end) throws SystemException {
		return findByESFOrganizationId(esfOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization types where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f organization types
	 * @param end the upper bound of the range of e s f organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID;
			finderArgs = new Object[] { esfOrganizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORGANIZATIONID;
			finderArgs = new Object[] {
					esfOrganizationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFOrganizationType> list = (List<ESFOrganizationType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganizationType esfOrganizationType : list) {
				if ((esfOrganizationId != esfOrganizationType.getEsfOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				if (!pagination) {
					list = (List<ESFOrganizationType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationType>(list);
				}
				else {
					list = (List<ESFOrganizationType>)QueryUtil.list(q,
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
	 * Returns the first e s f organization type in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization type
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType findByESFOrganizationId_First(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationTypeException, SystemException {
		ESFOrganizationType esfOrganizationType = fetchByESFOrganizationId_First(esfOrganizationId,
				orderByComparator);

		if (esfOrganizationType != null) {
			return esfOrganizationType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f organization type in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType fetchByESFOrganizationId_First(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFOrganizationType> list = findByESFOrganizationId(esfOrganizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization type in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization type
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType findByESFOrganizationId_Last(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationTypeException, SystemException {
		ESFOrganizationType esfOrganizationType = fetchByESFOrganizationId_Last(esfOrganizationId,
				orderByComparator);

		if (esfOrganizationType != null) {
			return esfOrganizationType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f organization type in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType fetchByESFOrganizationId_Last(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFOrganizationId(esfOrganizationId);

		if (count == 0) {
			return null;
		}

		List<ESFOrganizationType> list = findByESFOrganizationId(esfOrganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organization types before and after the current e s f organization type in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationTypeId the primary key of the current e s f organization type
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization type
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType[] findByESFOrganizationId_PrevAndNext(
		long esfOrganizationTypeId, long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationTypeException, SystemException {
		ESFOrganizationType esfOrganizationType = findByPrimaryKey(esfOrganizationTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganizationType[] array = new ESFOrganizationTypeImpl[3];

			array[0] = getByESFOrganizationId_PrevAndNext(session,
					esfOrganizationType, esfOrganizationId, orderByComparator,
					true);

			array[1] = esfOrganizationType;

			array[2] = getByESFOrganizationId_PrevAndNext(session,
					esfOrganizationType, esfOrganizationId, orderByComparator,
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

	protected ESFOrganizationType getByESFOrganizationId_PrevAndNext(
		Session session, ESFOrganizationType esfOrganizationType,
		long esfOrganizationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATIONTYPE_WHERE);

		query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

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
			query.append(ESFOrganizationTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganizationType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganizationType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organization types where esfOrganizationId = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFOrganizationId(long esfOrganizationId)
		throws SystemException {
		for (ESFOrganizationType esfOrganizationType : findByESFOrganizationId(
				esfOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganizationType);
		}
	}

	/**
	 * Returns the number of e s f organization types where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the number of matching e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFOrganizationId(long esfOrganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFORGANIZATIONID;

		Object[] finderArgs = new Object[] { esfOrganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

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

	private static final String _FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2 =
		"esfOrganizationType.esfOrganizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTYPEID =
		new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTYPEID =
		new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFTypeId",
			new String[] { Long.class.getName() },
			ESFOrganizationTypeModelImpl.ESFTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFTYPEID = new FinderPath(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f organization types where esfTypeId = &#63;.
	 *
	 * @param esfTypeId the esf type ID
	 * @return the matching e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findByESFTypeId(long esfTypeId)
		throws SystemException {
		return findByESFTypeId(esfTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f organization types where esfTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfTypeId the esf type ID
	 * @param start the lower bound of the range of e s f organization types
	 * @param end the upper bound of the range of e s f organization types (not inclusive)
	 * @return the range of matching e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findByESFTypeId(long esfTypeId, int start,
		int end) throws SystemException {
		return findByESFTypeId(esfTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization types where esfTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfTypeId the esf type ID
	 * @param start the lower bound of the range of e s f organization types
	 * @param end the upper bound of the range of e s f organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findByESFTypeId(long esfTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTYPEID;
			finderArgs = new Object[] { esfTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTYPEID;
			finderArgs = new Object[] { esfTypeId, start, end, orderByComparator };
		}

		List<ESFOrganizationType> list = (List<ESFOrganizationType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganizationType esfOrganizationType : list) {
				if ((esfTypeId != esfOrganizationType.getEsfTypeId())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_ESFTYPEID_ESFTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfTypeId);

				if (!pagination) {
					list = (List<ESFOrganizationType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationType>(list);
				}
				else {
					list = (List<ESFOrganizationType>)QueryUtil.list(q,
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
	 * Returns the first e s f organization type in the ordered set where esfTypeId = &#63;.
	 *
	 * @param esfTypeId the esf type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization type
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType findByESFTypeId_First(long esfTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationTypeException, SystemException {
		ESFOrganizationType esfOrganizationType = fetchByESFTypeId_First(esfTypeId,
				orderByComparator);

		if (esfOrganizationType != null) {
			return esfOrganizationType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfTypeId=");
		msg.append(esfTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f organization type in the ordered set where esfTypeId = &#63;.
	 *
	 * @param esfTypeId the esf type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType fetchByESFTypeId_First(long esfTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganizationType> list = findByESFTypeId(esfTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization type in the ordered set where esfTypeId = &#63;.
	 *
	 * @param esfTypeId the esf type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization type
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType findByESFTypeId_Last(long esfTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationTypeException, SystemException {
		ESFOrganizationType esfOrganizationType = fetchByESFTypeId_Last(esfTypeId,
				orderByComparator);

		if (esfOrganizationType != null) {
			return esfOrganizationType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfTypeId=");
		msg.append(esfTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f organization type in the ordered set where esfTypeId = &#63;.
	 *
	 * @param esfTypeId the esf type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType fetchByESFTypeId_Last(long esfTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFTypeId(esfTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFOrganizationType> list = findByESFTypeId(esfTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organization types before and after the current e s f organization type in the ordered set where esfTypeId = &#63;.
	 *
	 * @param esfOrganizationTypeId the primary key of the current e s f organization type
	 * @param esfTypeId the esf type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization type
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType[] findByESFTypeId_PrevAndNext(
		long esfOrganizationTypeId, long esfTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationTypeException, SystemException {
		ESFOrganizationType esfOrganizationType = findByPrimaryKey(esfOrganizationTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganizationType[] array = new ESFOrganizationTypeImpl[3];

			array[0] = getByESFTypeId_PrevAndNext(session, esfOrganizationType,
					esfTypeId, orderByComparator, true);

			array[1] = esfOrganizationType;

			array[2] = getByESFTypeId_PrevAndNext(session, esfOrganizationType,
					esfTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganizationType getByESFTypeId_PrevAndNext(Session session,
		ESFOrganizationType esfOrganizationType, long esfTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATIONTYPE_WHERE);

		query.append(_FINDER_COLUMN_ESFTYPEID_ESFTYPEID_2);

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
			query.append(ESFOrganizationTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganizationType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganizationType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organization types where esfTypeId = &#63; from the database.
	 *
	 * @param esfTypeId the esf type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFTypeId(long esfTypeId) throws SystemException {
		for (ESFOrganizationType esfOrganizationType : findByESFTypeId(
				esfTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganizationType);
		}
	}

	/**
	 * Returns the number of e s f organization types where esfTypeId = &#63;.
	 *
	 * @param esfTypeId the esf type ID
	 * @return the number of matching e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFTypeId(long esfTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFTYPEID;

		Object[] finderArgs = new Object[] { esfTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_ESFTYPEID_ESFTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfTypeId);

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

	private static final String _FINDER_COLUMN_ESFTYPEID_ESFTYPEID_2 = "esfOrganizationType.esfTypeId = ?";

	public ESFOrganizationTypePersistenceImpl() {
		setModelClass(ESFOrganizationType.class);
	}

	/**
	 * Caches the e s f organization type in the entity cache if it is enabled.
	 *
	 * @param esfOrganizationType the e s f organization type
	 */
	@Override
	public void cacheResult(ESFOrganizationType esfOrganizationType) {
		EntityCacheUtil.putResult(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class, esfOrganizationType.getPrimaryKey(),
			esfOrganizationType);

		esfOrganizationType.resetOriginalValues();
	}

	/**
	 * Caches the e s f organization types in the entity cache if it is enabled.
	 *
	 * @param esfOrganizationTypes the e s f organization types
	 */
	@Override
	public void cacheResult(List<ESFOrganizationType> esfOrganizationTypes) {
		for (ESFOrganizationType esfOrganizationType : esfOrganizationTypes) {
			if (EntityCacheUtil.getResult(
						ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrganizationTypeImpl.class,
						esfOrganizationType.getPrimaryKey()) == null) {
				cacheResult(esfOrganizationType);
			}
			else {
				esfOrganizationType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f organization types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFOrganizationTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFOrganizationTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f organization type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFOrganizationType esfOrganizationType) {
		EntityCacheUtil.removeResult(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class, esfOrganizationType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFOrganizationType> esfOrganizationTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFOrganizationType esfOrganizationType : esfOrganizationTypes) {
			EntityCacheUtil.removeResult(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrganizationTypeImpl.class,
				esfOrganizationType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f organization type with the primary key. Does not add the e s f organization type to the database.
	 *
	 * @param esfOrganizationTypeId the primary key for the new e s f organization type
	 * @return the new e s f organization type
	 */
	@Override
	public ESFOrganizationType create(long esfOrganizationTypeId) {
		ESFOrganizationType esfOrganizationType = new ESFOrganizationTypeImpl();

		esfOrganizationType.setNew(true);
		esfOrganizationType.setPrimaryKey(esfOrganizationTypeId);

		return esfOrganizationType;
	}

	/**
	 * Removes the e s f organization type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrganizationTypeId the primary key of the e s f organization type
	 * @return the e s f organization type that was removed
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType remove(long esfOrganizationTypeId)
		throws NoSuchOrganizationTypeException, SystemException {
		return remove((Serializable)esfOrganizationTypeId);
	}

	/**
	 * Removes the e s f organization type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f organization type
	 * @return the e s f organization type that was removed
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType remove(Serializable primaryKey)
		throws NoSuchOrganizationTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFOrganizationType esfOrganizationType = (ESFOrganizationType)session.get(ESFOrganizationTypeImpl.class,
					primaryKey);

			if (esfOrganizationType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfOrganizationType);
		}
		catch (NoSuchOrganizationTypeException nsee) {
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
	protected ESFOrganizationType removeImpl(
		ESFOrganizationType esfOrganizationType) throws SystemException {
		esfOrganizationType = toUnwrappedModel(esfOrganizationType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfOrganizationType)) {
				esfOrganizationType = (ESFOrganizationType)session.get(ESFOrganizationTypeImpl.class,
						esfOrganizationType.getPrimaryKeyObj());
			}

			if (esfOrganizationType != null) {
				session.delete(esfOrganizationType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfOrganizationType != null) {
			clearCache(esfOrganizationType);
		}

		return esfOrganizationType;
	}

	@Override
	public ESFOrganizationType updateImpl(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws SystemException {
		esfOrganizationType = toUnwrappedModel(esfOrganizationType);

		boolean isNew = esfOrganizationType.isNew();

		ESFOrganizationTypeModelImpl esfOrganizationTypeModelImpl = (ESFOrganizationTypeModelImpl)esfOrganizationType;

		Session session = null;

		try {
			session = openSession();

			if (esfOrganizationType.isNew()) {
				session.save(esfOrganizationType);

				esfOrganizationType.setNew(false);
			}
			else {
				session.merge(esfOrganizationType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFOrganizationTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfOrganizationTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationTypeModelImpl.getOriginalEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);

				args = new Object[] {
						esfOrganizationTypeModelImpl.getEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);
			}

			if ((esfOrganizationTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationTypeModelImpl.getOriginalEsfTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTYPEID,
					args);

				args = new Object[] { esfOrganizationTypeModelImpl.getEsfTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationTypeImpl.class, esfOrganizationType.getPrimaryKey(),
			esfOrganizationType);

		return esfOrganizationType;
	}

	protected ESFOrganizationType toUnwrappedModel(
		ESFOrganizationType esfOrganizationType) {
		if (esfOrganizationType instanceof ESFOrganizationTypeImpl) {
			return esfOrganizationType;
		}

		ESFOrganizationTypeImpl esfOrganizationTypeImpl = new ESFOrganizationTypeImpl();

		esfOrganizationTypeImpl.setNew(esfOrganizationType.isNew());
		esfOrganizationTypeImpl.setPrimaryKey(esfOrganizationType.getPrimaryKey());

		esfOrganizationTypeImpl.setEsfOrganizationTypeId(esfOrganizationType.getEsfOrganizationTypeId());
		esfOrganizationTypeImpl.setGroupId(esfOrganizationType.getGroupId());
		esfOrganizationTypeImpl.setCompanyId(esfOrganizationType.getCompanyId());
		esfOrganizationTypeImpl.setUserId(esfOrganizationType.getUserId());
		esfOrganizationTypeImpl.setUserName(esfOrganizationType.getUserName());
		esfOrganizationTypeImpl.setCreateDate(esfOrganizationType.getCreateDate());
		esfOrganizationTypeImpl.setModifiedDate(esfOrganizationType.getModifiedDate());
		esfOrganizationTypeImpl.setEsfOrganizationId(esfOrganizationType.getEsfOrganizationId());
		esfOrganizationTypeImpl.setEsfTypeId(esfOrganizationType.getEsfTypeId());

		return esfOrganizationTypeImpl;
	}

	/**
	 * Returns the e s f organization type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f organization type
	 * @return the e s f organization type
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationTypeException, SystemException {
		ESFOrganizationType esfOrganizationType = fetchByPrimaryKey(primaryKey);

		if (esfOrganizationType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfOrganizationType;
	}

	/**
	 * Returns the e s f organization type with the primary key or throws a {@link it.ethica.esf.NoSuchOrganizationTypeException} if it could not be found.
	 *
	 * @param esfOrganizationTypeId the primary key of the e s f organization type
	 * @return the e s f organization type
	 * @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType findByPrimaryKey(long esfOrganizationTypeId)
		throws NoSuchOrganizationTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfOrganizationTypeId);
	}

	/**
	 * Returns the e s f organization type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f organization type
	 * @return the e s f organization type, or <code>null</code> if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFOrganizationType esfOrganizationType = (ESFOrganizationType)EntityCacheUtil.getResult(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrganizationTypeImpl.class, primaryKey);

		if (esfOrganizationType == _nullESFOrganizationType) {
			return null;
		}

		if (esfOrganizationType == null) {
			Session session = null;

			try {
				session = openSession();

				esfOrganizationType = (ESFOrganizationType)session.get(ESFOrganizationTypeImpl.class,
						primaryKey);

				if (esfOrganizationType != null) {
					cacheResult(esfOrganizationType);
				}
				else {
					EntityCacheUtil.putResult(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrganizationTypeImpl.class, primaryKey,
						_nullESFOrganizationType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFOrganizationTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFOrganizationTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfOrganizationType;
	}

	/**
	 * Returns the e s f organization type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfOrganizationTypeId the primary key of the e s f organization type
	 * @return the e s f organization type, or <code>null</code> if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType fetchByPrimaryKey(long esfOrganizationTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfOrganizationTypeId);
	}

	/**
	 * Returns all the e s f organization types.
	 *
	 * @return the e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organization types
	 * @param end the upper bound of the range of e s f organization types (not inclusive)
	 * @return the range of e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organization types
	 * @param end the upper bound of the range of e s f organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> findAll(int start, int end,
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

		List<ESFOrganizationType> list = (List<ESFOrganizationType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFORGANIZATIONTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFORGANIZATIONTYPE;

				if (pagination) {
					sql = sql.concat(ESFOrganizationTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFOrganizationType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationType>(list);
				}
				else {
					list = (List<ESFOrganizationType>)QueryUtil.list(q,
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
	 * Removes all the e s f organization types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFOrganizationType esfOrganizationType : findAll()) {
			remove(esfOrganizationType);
		}
	}

	/**
	 * Returns the number of e s f organization types.
	 *
	 * @return the number of e s f organization types
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

				Query q = session.createQuery(_SQL_COUNT_ESFORGANIZATIONTYPE);

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
	 * Initializes the e s f organization type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFOrganizationType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFOrganizationType>> listenersList = new ArrayList<ModelListener<ESFOrganizationType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFOrganizationType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFOrganizationTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFORGANIZATIONTYPE = "SELECT esfOrganizationType FROM ESFOrganizationType esfOrganizationType";
	private static final String _SQL_SELECT_ESFORGANIZATIONTYPE_WHERE = "SELECT esfOrganizationType FROM ESFOrganizationType esfOrganizationType WHERE ";
	private static final String _SQL_COUNT_ESFORGANIZATIONTYPE = "SELECT COUNT(esfOrganizationType) FROM ESFOrganizationType esfOrganizationType";
	private static final String _SQL_COUNT_ESFORGANIZATIONTYPE_WHERE = "SELECT COUNT(esfOrganizationType) FROM ESFOrganizationType esfOrganizationType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfOrganizationType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFOrganizationType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFOrganizationType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFOrganizationTypePersistenceImpl.class);
	private static ESFOrganizationType _nullESFOrganizationType = new ESFOrganizationTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFOrganizationType> toCacheModel() {
				return _nullESFOrganizationTypeCacheModel;
			}
		};

	private static CacheModel<ESFOrganizationType> _nullESFOrganizationTypeCacheModel =
		new CacheModel<ESFOrganizationType>() {
			@Override
			public ESFOrganizationType toEntityModel() {
				return _nullESFOrganizationType;
			}
		};
}