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

import it.ethica.esf.NoSuchFieldESFSportTypeException;
import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.model.impl.ESFFieldESFSportTypeImpl;
import it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f field e s f sport type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFieldESFSportTypePersistence
 * @see ESFFieldESFSportTypeUtil
 * @generated
 */
public class ESFFieldESFSportTypePersistenceImpl extends BasePersistenceImpl<ESFFieldESFSportType>
	implements ESFFieldESFSportTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFieldESFSportTypeUtil} to access the e s f field e s f sport type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFieldESFSportTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFFIELDID =
		new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesfFieldId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFFIELDID =
		new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesfFieldId",
			new String[] { Long.class.getName() },
			ESFFieldESFSportTypeModelImpl.ESFFIELDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFFIELDID = new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByesfFieldId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f field e s f sport types where esfFieldId = &#63;.
	 *
	 * @param esfFieldId the esf field ID
	 * @return the matching e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findByesfFieldId(long esfFieldId)
		throws SystemException {
		return findByesfFieldId(esfFieldId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f field e s f sport types where esfFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfFieldId the esf field ID
	 * @param start the lower bound of the range of e s f field e s f sport types
	 * @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	 * @return the range of matching e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findByesfFieldId(long esfFieldId,
		int start, int end) throws SystemException {
		return findByesfFieldId(esfFieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f field e s f sport types where esfFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfFieldId the esf field ID
	 * @param start the lower bound of the range of e s f field e s f sport types
	 * @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findByesfFieldId(long esfFieldId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFFIELDID;
			finderArgs = new Object[] { esfFieldId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFFIELDID;
			finderArgs = new Object[] { esfFieldId, start, end, orderByComparator };
		}

		List<ESFFieldESFSportType> list = (List<ESFFieldESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFieldESFSportType esfFieldESFSportType : list) {
				if ((esfFieldId != esfFieldESFSportType.getEsfFieldId())) {
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

			query.append(_SQL_SELECT_ESFFIELDESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_ESFFIELDID_ESFFIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFieldESFSportTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFieldId);

				if (!pagination) {
					list = (List<ESFFieldESFSportType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFieldESFSportType>(list);
				}
				else {
					list = (List<ESFFieldESFSportType>)QueryUtil.list(q,
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
	 * Returns the first e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	 *
	 * @param esfFieldId the esf field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f sport type
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a matching e s f field e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType findByesfFieldId_First(long esfFieldId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFSportTypeException, SystemException {
		ESFFieldESFSportType esfFieldESFSportType = fetchByesfFieldId_First(esfFieldId,
				orderByComparator);

		if (esfFieldESFSportType != null) {
			return esfFieldESFSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfFieldId=");
		msg.append(esfFieldId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	 *
	 * @param esfFieldId the esf field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f sport type, or <code>null</code> if a matching e s f field e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType fetchByesfFieldId_First(long esfFieldId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFieldESFSportType> list = findByesfFieldId(esfFieldId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	 *
	 * @param esfFieldId the esf field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f sport type
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a matching e s f field e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType findByesfFieldId_Last(long esfFieldId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFSportTypeException, SystemException {
		ESFFieldESFSportType esfFieldESFSportType = fetchByesfFieldId_Last(esfFieldId,
				orderByComparator);

		if (esfFieldESFSportType != null) {
			return esfFieldESFSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfFieldId=");
		msg.append(esfFieldId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	 *
	 * @param esfFieldId the esf field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f sport type, or <code>null</code> if a matching e s f field e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType fetchByesfFieldId_Last(long esfFieldId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByesfFieldId(esfFieldId);

		if (count == 0) {
			return null;
		}

		List<ESFFieldESFSportType> list = findByesfFieldId(esfFieldId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f field e s f sport types before and after the current e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	 *
	 * @param esfFieldESFSportTypePK the primary key of the current e s f field e s f sport type
	 * @param esfFieldId the esf field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field e s f sport type
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType[] findByesfFieldId_PrevAndNext(
		ESFFieldESFSportTypePK esfFieldESFSportTypePK, long esfFieldId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFSportTypeException, SystemException {
		ESFFieldESFSportType esfFieldESFSportType = findByPrimaryKey(esfFieldESFSportTypePK);

		Session session = null;

		try {
			session = openSession();

			ESFFieldESFSportType[] array = new ESFFieldESFSportTypeImpl[3];

			array[0] = getByesfFieldId_PrevAndNext(session,
					esfFieldESFSportType, esfFieldId, orderByComparator, true);

			array[1] = esfFieldESFSportType;

			array[2] = getByesfFieldId_PrevAndNext(session,
					esfFieldESFSportType, esfFieldId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFieldESFSportType getByesfFieldId_PrevAndNext(
		Session session, ESFFieldESFSportType esfFieldESFSportType,
		long esfFieldId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELDESFSPORTTYPE_WHERE);

		query.append(_FINDER_COLUMN_ESFFIELDID_ESFFIELDID_2);

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
			query.append(ESFFieldESFSportTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfFieldId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFieldESFSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFieldESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f field e s f sport types where esfFieldId = &#63; from the database.
	 *
	 * @param esfFieldId the esf field ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfFieldId(long esfFieldId) throws SystemException {
		for (ESFFieldESFSportType esfFieldESFSportType : findByesfFieldId(
				esfFieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFieldESFSportType);
		}
	}

	/**
	 * Returns the number of e s f field e s f sport types where esfFieldId = &#63;.
	 *
	 * @param esfFieldId the esf field ID
	 * @return the number of matching e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfFieldId(long esfFieldId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFFIELDID;

		Object[] finderArgs = new Object[] { esfFieldId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFIELDESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_ESFFIELDID_ESFFIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFieldId);

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

	private static final String _FINDER_COLUMN_ESFFIELDID_ESFFIELDID_2 = "esfFieldESFSportType.id.esfFieldId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSPORTTYPEID =
		new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesfSportTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSPORTTYPEID =
		new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesfSportTypeId",
			new String[] { Long.class.getName() },
			ESFFieldESFSportTypeModelImpl.ESFSPORTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFSPORTTYPEID = new FinderPath(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByesfSportTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f field e s f sport types where esfSportTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findByesfSportTypeId(long esfSportTypeId)
		throws SystemException {
		return findByesfSportTypeId(esfSportTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f field e s f sport types where esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f field e s f sport types
	 * @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	 * @return the range of matching e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findByesfSportTypeId(
		long esfSportTypeId, int start, int end) throws SystemException {
		return findByesfSportTypeId(esfSportTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f field e s f sport types where esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f field e s f sport types
	 * @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findByesfSportTypeId(
		long esfSportTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSPORTTYPEID;
			finderArgs = new Object[] { esfSportTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSPORTTYPEID;
			finderArgs = new Object[] {
					esfSportTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFFieldESFSportType> list = (List<ESFFieldESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFieldESFSportType esfFieldESFSportType : list) {
				if ((esfSportTypeId != esfFieldESFSportType.getEsfSportTypeId())) {
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

			query.append(_SQL_SELECT_ESFFIELDESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFieldESFSportTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfSportTypeId);

				if (!pagination) {
					list = (List<ESFFieldESFSportType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFieldESFSportType>(list);
				}
				else {
					list = (List<ESFFieldESFSportType>)QueryUtil.list(q,
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
	 * Returns the first e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f sport type
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a matching e s f field e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType findByesfSportTypeId_First(
		long esfSportTypeId, OrderByComparator orderByComparator)
		throws NoSuchFieldESFSportTypeException, SystemException {
		ESFFieldESFSportType esfFieldESFSportType = fetchByesfSportTypeId_First(esfSportTypeId,
				orderByComparator);

		if (esfFieldESFSportType != null) {
			return esfFieldESFSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f sport type, or <code>null</code> if a matching e s f field e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType fetchByesfSportTypeId_First(
		long esfSportTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFFieldESFSportType> list = findByesfSportTypeId(esfSportTypeId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f sport type
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a matching e s f field e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType findByesfSportTypeId_Last(long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFSportTypeException, SystemException {
		ESFFieldESFSportType esfFieldESFSportType = fetchByesfSportTypeId_Last(esfSportTypeId,
				orderByComparator);

		if (esfFieldESFSportType != null) {
			return esfFieldESFSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f sport type, or <code>null</code> if a matching e s f field e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType fetchByesfSportTypeId_Last(
		long esfSportTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByesfSportTypeId(esfSportTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFFieldESFSportType> list = findByesfSportTypeId(esfSportTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f field e s f sport types before and after the current e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	 *
	 * @param esfFieldESFSportTypePK the primary key of the current e s f field e s f sport type
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field e s f sport type
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType[] findByesfSportTypeId_PrevAndNext(
		ESFFieldESFSportTypePK esfFieldESFSportTypePK, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFSportTypeException, SystemException {
		ESFFieldESFSportType esfFieldESFSportType = findByPrimaryKey(esfFieldESFSportTypePK);

		Session session = null;

		try {
			session = openSession();

			ESFFieldESFSportType[] array = new ESFFieldESFSportTypeImpl[3];

			array[0] = getByesfSportTypeId_PrevAndNext(session,
					esfFieldESFSportType, esfSportTypeId, orderByComparator,
					true);

			array[1] = esfFieldESFSportType;

			array[2] = getByesfSportTypeId_PrevAndNext(session,
					esfFieldESFSportType, esfSportTypeId, orderByComparator,
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

	protected ESFFieldESFSportType getByesfSportTypeId_PrevAndNext(
		Session session, ESFFieldESFSportType esfFieldESFSportType,
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

		query.append(_SQL_SELECT_ESFFIELDESFSPORTTYPE_WHERE);

		query.append(_FINDER_COLUMN_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

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
			query.append(ESFFieldESFSportTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfSportTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFieldESFSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFieldESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f field e s f sport types where esfSportTypeId = &#63; from the database.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfSportTypeId(long esfSportTypeId)
		throws SystemException {
		for (ESFFieldESFSportType esfFieldESFSportType : findByesfSportTypeId(
				esfSportTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFieldESFSportType);
		}
	}

	/**
	 * Returns the number of e s f field e s f sport types where esfSportTypeId = &#63;.
	 *
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfSportTypeId(long esfSportTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFSPORTTYPEID;

		Object[] finderArgs = new Object[] { esfSportTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFIELDESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_ESFSPORTTYPEID_ESFSPORTTYPEID_2 = "esfFieldESFSportType.id.esfSportTypeId = ?";

	public ESFFieldESFSportTypePersistenceImpl() {
		setModelClass(ESFFieldESFSportType.class);
	}

	/**
	 * Caches the e s f field e s f sport type in the entity cache if it is enabled.
	 *
	 * @param esfFieldESFSportType the e s f field e s f sport type
	 */
	@Override
	public void cacheResult(ESFFieldESFSportType esfFieldESFSportType) {
		EntityCacheUtil.putResult(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class,
			esfFieldESFSportType.getPrimaryKey(), esfFieldESFSportType);

		esfFieldESFSportType.resetOriginalValues();
	}

	/**
	 * Caches the e s f field e s f sport types in the entity cache if it is enabled.
	 *
	 * @param esfFieldESFSportTypes the e s f field e s f sport types
	 */
	@Override
	public void cacheResult(List<ESFFieldESFSportType> esfFieldESFSportTypes) {
		for (ESFFieldESFSportType esfFieldESFSportType : esfFieldESFSportTypes) {
			if (EntityCacheUtil.getResult(
						ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFFieldESFSportTypeImpl.class,
						esfFieldESFSportType.getPrimaryKey()) == null) {
				cacheResult(esfFieldESFSportType);
			}
			else {
				esfFieldESFSportType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f field e s f sport types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFieldESFSportTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFieldESFSportTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f field e s f sport type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFFieldESFSportType esfFieldESFSportType) {
		EntityCacheUtil.removeResult(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class, esfFieldESFSportType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFFieldESFSportType> esfFieldESFSportTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFFieldESFSportType esfFieldESFSportType : esfFieldESFSportTypes) {
			EntityCacheUtil.removeResult(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFFieldESFSportTypeImpl.class,
				esfFieldESFSportType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f field e s f sport type with the primary key. Does not add the e s f field e s f sport type to the database.
	 *
	 * @param esfFieldESFSportTypePK the primary key for the new e s f field e s f sport type
	 * @return the new e s f field e s f sport type
	 */
	@Override
	public ESFFieldESFSportType create(
		ESFFieldESFSportTypePK esfFieldESFSportTypePK) {
		ESFFieldESFSportType esfFieldESFSportType = new ESFFieldESFSportTypeImpl();

		esfFieldESFSportType.setNew(true);
		esfFieldESFSportType.setPrimaryKey(esfFieldESFSportTypePK);

		return esfFieldESFSportType;
	}

	/**
	 * Removes the e s f field e s f sport type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFieldESFSportTypePK the primary key of the e s f field e s f sport type
	 * @return the e s f field e s f sport type that was removed
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType remove(
		ESFFieldESFSportTypePK esfFieldESFSportTypePK)
		throws NoSuchFieldESFSportTypeException, SystemException {
		return remove((Serializable)esfFieldESFSportTypePK);
	}

	/**
	 * Removes the e s f field e s f sport type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f field e s f sport type
	 * @return the e s f field e s f sport type that was removed
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType remove(Serializable primaryKey)
		throws NoSuchFieldESFSportTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFFieldESFSportType esfFieldESFSportType = (ESFFieldESFSportType)session.get(ESFFieldESFSportTypeImpl.class,
					primaryKey);

			if (esfFieldESFSportType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFieldESFSportTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfFieldESFSportType);
		}
		catch (NoSuchFieldESFSportTypeException nsee) {
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
	protected ESFFieldESFSportType removeImpl(
		ESFFieldESFSportType esfFieldESFSportType) throws SystemException {
		esfFieldESFSportType = toUnwrappedModel(esfFieldESFSportType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfFieldESFSportType)) {
				esfFieldESFSportType = (ESFFieldESFSportType)session.get(ESFFieldESFSportTypeImpl.class,
						esfFieldESFSportType.getPrimaryKeyObj());
			}

			if (esfFieldESFSportType != null) {
				session.delete(esfFieldESFSportType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfFieldESFSportType != null) {
			clearCache(esfFieldESFSportType);
		}

		return esfFieldESFSportType;
	}

	@Override
	public ESFFieldESFSportType updateImpl(
		it.ethica.esf.model.ESFFieldESFSportType esfFieldESFSportType)
		throws SystemException {
		esfFieldESFSportType = toUnwrappedModel(esfFieldESFSportType);

		boolean isNew = esfFieldESFSportType.isNew();

		ESFFieldESFSportTypeModelImpl esfFieldESFSportTypeModelImpl = (ESFFieldESFSportTypeModelImpl)esfFieldESFSportType;

		Session session = null;

		try {
			session = openSession();

			if (esfFieldESFSportType.isNew()) {
				session.save(esfFieldESFSportType);

				esfFieldESFSportType.setNew(false);
			}
			else {
				session.merge(esfFieldESFSportType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFFieldESFSportTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFieldESFSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFFIELDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldESFSportTypeModelImpl.getOriginalEsfFieldId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFFIELDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFFIELDID,
					args);

				args = new Object[] {
						esfFieldESFSportTypeModelImpl.getEsfFieldId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFFIELDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFFIELDID,
					args);
			}

			if ((esfFieldESFSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSPORTTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldESFSportTypeModelImpl.getOriginalEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSPORTTYPEID,
					args);

				args = new Object[] {
						esfFieldESFSportTypeModelImpl.getEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSPORTTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFSportTypeImpl.class,
			esfFieldESFSportType.getPrimaryKey(), esfFieldESFSportType);

		return esfFieldESFSportType;
	}

	protected ESFFieldESFSportType toUnwrappedModel(
		ESFFieldESFSportType esfFieldESFSportType) {
		if (esfFieldESFSportType instanceof ESFFieldESFSportTypeImpl) {
			return esfFieldESFSportType;
		}

		ESFFieldESFSportTypeImpl esfFieldESFSportTypeImpl = new ESFFieldESFSportTypeImpl();

		esfFieldESFSportTypeImpl.setNew(esfFieldESFSportType.isNew());
		esfFieldESFSportTypeImpl.setPrimaryKey(esfFieldESFSportType.getPrimaryKey());

		esfFieldESFSportTypeImpl.setEsfFieldId(esfFieldESFSportType.getEsfFieldId());
		esfFieldESFSportTypeImpl.setEsfSportTypeId(esfFieldESFSportType.getEsfSportTypeId());
		esfFieldESFSportTypeImpl.setGroupId(esfFieldESFSportType.getGroupId());
		esfFieldESFSportTypeImpl.setCompanyId(esfFieldESFSportType.getCompanyId());
		esfFieldESFSportTypeImpl.setUserId(esfFieldESFSportType.getUserId());
		esfFieldESFSportTypeImpl.setUserName(esfFieldESFSportType.getUserName());
		esfFieldESFSportTypeImpl.setCreateDate(esfFieldESFSportType.getCreateDate());
		esfFieldESFSportTypeImpl.setModifiedDate(esfFieldESFSportType.getModifiedDate());

		return esfFieldESFSportTypeImpl;
	}

	/**
	 * Returns the e s f field e s f sport type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f field e s f sport type
	 * @return the e s f field e s f sport type
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFieldESFSportTypeException, SystemException {
		ESFFieldESFSportType esfFieldESFSportType = fetchByPrimaryKey(primaryKey);

		if (esfFieldESFSportType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFieldESFSportTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfFieldESFSportType;
	}

	/**
	 * Returns the e s f field e s f sport type with the primary key or throws a {@link it.ethica.esf.NoSuchFieldESFSportTypeException} if it could not be found.
	 *
	 * @param esfFieldESFSportTypePK the primary key of the e s f field e s f sport type
	 * @return the e s f field e s f sport type
	 * @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType findByPrimaryKey(
		ESFFieldESFSportTypePK esfFieldESFSportTypePK)
		throws NoSuchFieldESFSportTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfFieldESFSportTypePK);
	}

	/**
	 * Returns the e s f field e s f sport type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f field e s f sport type
	 * @return the e s f field e s f sport type, or <code>null</code> if a e s f field e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFFieldESFSportType esfFieldESFSportType = (ESFFieldESFSportType)EntityCacheUtil.getResult(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFFieldESFSportTypeImpl.class, primaryKey);

		if (esfFieldESFSportType == _nullESFFieldESFSportType) {
			return null;
		}

		if (esfFieldESFSportType == null) {
			Session session = null;

			try {
				session = openSession();

				esfFieldESFSportType = (ESFFieldESFSportType)session.get(ESFFieldESFSportTypeImpl.class,
						primaryKey);

				if (esfFieldESFSportType != null) {
					cacheResult(esfFieldESFSportType);
				}
				else {
					EntityCacheUtil.putResult(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFFieldESFSportTypeImpl.class, primaryKey,
						_nullESFFieldESFSportType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFieldESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFFieldESFSportTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfFieldESFSportType;
	}

	/**
	 * Returns the e s f field e s f sport type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFieldESFSportTypePK the primary key of the e s f field e s f sport type
	 * @return the e s f field e s f sport type, or <code>null</code> if a e s f field e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFSportType fetchByPrimaryKey(
		ESFFieldESFSportTypePK esfFieldESFSportTypePK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFieldESFSportTypePK);
	}

	/**
	 * Returns all the e s f field e s f sport types.
	 *
	 * @return the e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f field e s f sport types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f field e s f sport types
	 * @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	 * @return the range of e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f field e s f sport types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f field e s f sport types
	 * @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f field e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFSportType> findAll(int start, int end,
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

		List<ESFFieldESFSportType> list = (List<ESFFieldESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFIELDESFSPORTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFIELDESFSPORTTYPE;

				if (pagination) {
					sql = sql.concat(ESFFieldESFSportTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFFieldESFSportType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFieldESFSportType>(list);
				}
				else {
					list = (List<ESFFieldESFSportType>)QueryUtil.list(q,
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
	 * Removes all the e s f field e s f sport types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFFieldESFSportType esfFieldESFSportType : findAll()) {
			remove(esfFieldESFSportType);
		}
	}

	/**
	 * Returns the number of e s f field e s f sport types.
	 *
	 * @return the number of e s f field e s f sport types
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

				Query q = session.createQuery(_SQL_COUNT_ESFFIELDESFSPORTTYPE);

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
	 * Initializes the e s f field e s f sport type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFFieldESFSportType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFFieldESFSportType>> listenersList = new ArrayList<ModelListener<ESFFieldESFSportType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFFieldESFSportType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFieldESFSportTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFIELDESFSPORTTYPE = "SELECT esfFieldESFSportType FROM ESFFieldESFSportType esfFieldESFSportType";
	private static final String _SQL_SELECT_ESFFIELDESFSPORTTYPE_WHERE = "SELECT esfFieldESFSportType FROM ESFFieldESFSportType esfFieldESFSportType WHERE ";
	private static final String _SQL_COUNT_ESFFIELDESFSPORTTYPE = "SELECT COUNT(esfFieldESFSportType) FROM ESFFieldESFSportType esfFieldESFSportType";
	private static final String _SQL_COUNT_ESFFIELDESFSPORTTYPE_WHERE = "SELECT COUNT(esfFieldESFSportType) FROM ESFFieldESFSportType esfFieldESFSportType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfFieldESFSportType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFFieldESFSportType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFFieldESFSportType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFieldESFSportTypePersistenceImpl.class);
	private static ESFFieldESFSportType _nullESFFieldESFSportType = new ESFFieldESFSportTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFFieldESFSportType> toCacheModel() {
				return _nullESFFieldESFSportTypeCacheModel;
			}
		};

	private static CacheModel<ESFFieldESFSportType> _nullESFFieldESFSportTypeCacheModel =
		new CacheModel<ESFFieldESFSportType>() {
			@Override
			public ESFFieldESFSportType toEntityModel() {
				return _nullESFFieldESFSportType;
			}
		};
}