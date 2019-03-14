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

import it.ethica.esf.NoSuchFieldESFElectronicException;
import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.model.impl.ESFFieldESFElectronicImpl;
import it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f field e s f electronic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFieldESFElectronicPersistence
 * @see ESFFieldESFElectronicUtil
 * @generated
 */
public class ESFFieldESFElectronicPersistenceImpl extends BasePersistenceImpl<ESFFieldESFElectronic>
	implements ESFFieldESFElectronicPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFieldESFElectronicUtil} to access the e s f field e s f electronic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFieldESFElectronicImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELDID = new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFieldId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDID =
		new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFieldId",
			new String[] { Long.class.getName() },
			ESFFieldESFElectronicModelImpl.FIELDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIELDID = new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFieldId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f field e s f electronics where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByFieldId(long fieldId)
		throws SystemException {
		return findByFieldId(fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f field e s f electronics where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of e s f field e s f electronics
	 * @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	 * @return the range of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByFieldId(long fieldId, int start,
		int end) throws SystemException {
		return findByFieldId(fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f field e s f electronics where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of e s f field e s f electronics
	 * @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByFieldId(long fieldId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDID;
			finderArgs = new Object[] { fieldId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELDID;
			finderArgs = new Object[] { fieldId, start, end, orderByComparator };
		}

		List<ESFFieldESFElectronic> list = (List<ESFFieldESFElectronic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFieldESFElectronic esfFieldESFElectronic : list) {
				if ((fieldId != esfFieldESFElectronic.getFieldId())) {
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

			query.append(_SQL_SELECT_ESFFIELDESFELECTRONIC_WHERE);

			query.append(_FINDER_COLUMN_FIELDID_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFieldESFElectronicModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				if (!pagination) {
					list = (List<ESFFieldESFElectronic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFieldESFElectronic>(list);
				}
				else {
					list = (List<ESFFieldESFElectronic>)QueryUtil.list(q,
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
	 * Returns the first e s f field e s f electronic in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByFieldId_First(long fieldId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = fetchByFieldId_First(fieldId,
				orderByComparator);

		if (esfFieldESFElectronic != null) {
			return esfFieldESFElectronic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFElectronicException(msg.toString());
	}

	/**
	 * Returns the first e s f field e s f electronic in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByFieldId_First(long fieldId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFieldESFElectronic> list = findByFieldId(fieldId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field e s f electronic in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByFieldId_Last(long fieldId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = fetchByFieldId_Last(fieldId,
				orderByComparator);

		if (esfFieldESFElectronic != null) {
			return esfFieldESFElectronic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFElectronicException(msg.toString());
	}

	/**
	 * Returns the last e s f field e s f electronic in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByFieldId_Last(long fieldId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFieldId(fieldId);

		if (count == 0) {
			return null;
		}

		List<ESFFieldESFElectronic> list = findByFieldId(fieldId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f field e s f electronics before and after the current e s f field e s f electronic in the ordered set where fieldId = &#63;.
	 *
	 * @param id the primary key of the current e s f field e s f electronic
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic[] findByFieldId_PrevAndNext(long id,
		long fieldId, OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ESFFieldESFElectronic[] array = new ESFFieldESFElectronicImpl[3];

			array[0] = getByFieldId_PrevAndNext(session, esfFieldESFElectronic,
					fieldId, orderByComparator, true);

			array[1] = esfFieldESFElectronic;

			array[2] = getByFieldId_PrevAndNext(session, esfFieldESFElectronic,
					fieldId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFieldESFElectronic getByFieldId_PrevAndNext(Session session,
		ESFFieldESFElectronic esfFieldESFElectronic, long fieldId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELDESFELECTRONIC_WHERE);

		query.append(_FINDER_COLUMN_FIELDID_FIELDID_2);

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
			query.append(ESFFieldESFElectronicModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fieldId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFieldESFElectronic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFieldESFElectronic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f field e s f electronics where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFieldId(long fieldId) throws SystemException {
		for (ESFFieldESFElectronic esfFieldESFElectronic : findByFieldId(
				fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFieldESFElectronic);
		}
	}

	/**
	 * Returns the number of e s f field e s f electronics where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFieldId(long fieldId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELDID;

		Object[] finderArgs = new Object[] { fieldId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFIELDESFELECTRONIC_WHERE);

			query.append(_FINDER_COLUMN_FIELDID_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

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

	private static final String _FINDER_COLUMN_FIELDID_FIELDID_2 = "esfFieldESFElectronic.fieldId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BRANDID = new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrandId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANDID =
		new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrandId",
			new String[] { Long.class.getName() },
			ESFFieldESFElectronicModelImpl.BRANDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRANDID = new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrandId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f field e s f electronics where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByBrandId(long brandId)
		throws SystemException {
		return findByBrandId(brandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f field e s f electronics where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of e s f field e s f electronics
	 * @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	 * @return the range of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByBrandId(long brandId, int start,
		int end) throws SystemException {
		return findByBrandId(brandId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f field e s f electronics where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of e s f field e s f electronics
	 * @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByBrandId(long brandId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANDID;
			finderArgs = new Object[] { brandId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BRANDID;
			finderArgs = new Object[] { brandId, start, end, orderByComparator };
		}

		List<ESFFieldESFElectronic> list = (List<ESFFieldESFElectronic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFieldESFElectronic esfFieldESFElectronic : list) {
				if ((brandId != esfFieldESFElectronic.getBrandId())) {
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

			query.append(_SQL_SELECT_ESFFIELDESFELECTRONIC_WHERE);

			query.append(_FINDER_COLUMN_BRANDID_BRANDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFieldESFElectronicModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brandId);

				if (!pagination) {
					list = (List<ESFFieldESFElectronic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFieldESFElectronic>(list);
				}
				else {
					list = (List<ESFFieldESFElectronic>)QueryUtil.list(q,
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
	 * Returns the first e s f field e s f electronic in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByBrandId_First(long brandId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = fetchByBrandId_First(brandId,
				orderByComparator);

		if (esfFieldESFElectronic != null) {
			return esfFieldESFElectronic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brandId=");
		msg.append(brandId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFElectronicException(msg.toString());
	}

	/**
	 * Returns the first e s f field e s f electronic in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByBrandId_First(long brandId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFieldESFElectronic> list = findByBrandId(brandId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field e s f electronic in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByBrandId_Last(long brandId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = fetchByBrandId_Last(brandId,
				orderByComparator);

		if (esfFieldESFElectronic != null) {
			return esfFieldESFElectronic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brandId=");
		msg.append(brandId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFElectronicException(msg.toString());
	}

	/**
	 * Returns the last e s f field e s f electronic in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByBrandId_Last(long brandId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBrandId(brandId);

		if (count == 0) {
			return null;
		}

		List<ESFFieldESFElectronic> list = findByBrandId(brandId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f field e s f electronics before and after the current e s f field e s f electronic in the ordered set where brandId = &#63;.
	 *
	 * @param id the primary key of the current e s f field e s f electronic
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic[] findByBrandId_PrevAndNext(long id,
		long brandId, OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ESFFieldESFElectronic[] array = new ESFFieldESFElectronicImpl[3];

			array[0] = getByBrandId_PrevAndNext(session, esfFieldESFElectronic,
					brandId, orderByComparator, true);

			array[1] = esfFieldESFElectronic;

			array[2] = getByBrandId_PrevAndNext(session, esfFieldESFElectronic,
					brandId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFieldESFElectronic getByBrandId_PrevAndNext(Session session,
		ESFFieldESFElectronic esfFieldESFElectronic, long brandId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELDESFELECTRONIC_WHERE);

		query.append(_FINDER_COLUMN_BRANDID_BRANDID_2);

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
			query.append(ESFFieldESFElectronicModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(brandId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFieldESFElectronic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFieldESFElectronic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f field e s f electronics where brandId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBrandId(long brandId) throws SystemException {
		for (ESFFieldESFElectronic esfFieldESFElectronic : findByBrandId(
				brandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFieldESFElectronic);
		}
	}

	/**
	 * Returns the number of e s f field e s f electronics where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the number of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBrandId(long brandId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRANDID;

		Object[] finderArgs = new Object[] { brandId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFIELDESFELECTRONIC_WHERE);

			query.append(_FINDER_COLUMN_BRANDID_BRANDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brandId);

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

	private static final String _FINDER_COLUMN_BRANDID_BRANDID_2 = "esfFieldESFElectronic.brandId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ELECTRONICID =
		new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByElectronicId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELECTRONICID =
		new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByElectronicId",
			new String[] { Long.class.getName() },
			ESFFieldESFElectronicModelImpl.ELECTRONICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ELECTRONICID = new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByElectronicId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f field e s f electronics where electronicId = &#63;.
	 *
	 * @param electronicId the electronic ID
	 * @return the matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByElectronicId(long electronicId)
		throws SystemException {
		return findByElectronicId(electronicId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f field e s f electronics where electronicId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param electronicId the electronic ID
	 * @param start the lower bound of the range of e s f field e s f electronics
	 * @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	 * @return the range of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByElectronicId(long electronicId,
		int start, int end) throws SystemException {
		return findByElectronicId(electronicId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f field e s f electronics where electronicId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param electronicId the electronic ID
	 * @param start the lower bound of the range of e s f field e s f electronics
	 * @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findByElectronicId(long electronicId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELECTRONICID;
			finderArgs = new Object[] { electronicId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ELECTRONICID;
			finderArgs = new Object[] {
					electronicId,
					
					start, end, orderByComparator
				};
		}

		List<ESFFieldESFElectronic> list = (List<ESFFieldESFElectronic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFieldESFElectronic esfFieldESFElectronic : list) {
				if ((electronicId != esfFieldESFElectronic.getElectronicId())) {
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

			query.append(_SQL_SELECT_ESFFIELDESFELECTRONIC_WHERE);

			query.append(_FINDER_COLUMN_ELECTRONICID_ELECTRONICID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFieldESFElectronicModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(electronicId);

				if (!pagination) {
					list = (List<ESFFieldESFElectronic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFieldESFElectronic>(list);
				}
				else {
					list = (List<ESFFieldESFElectronic>)QueryUtil.list(q,
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
	 * Returns the first e s f field e s f electronic in the ordered set where electronicId = &#63;.
	 *
	 * @param electronicId the electronic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByElectronicId_First(long electronicId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = fetchByElectronicId_First(electronicId,
				orderByComparator);

		if (esfFieldESFElectronic != null) {
			return esfFieldESFElectronic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("electronicId=");
		msg.append(electronicId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFElectronicException(msg.toString());
	}

	/**
	 * Returns the first e s f field e s f electronic in the ordered set where electronicId = &#63;.
	 *
	 * @param electronicId the electronic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByElectronicId_First(long electronicId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFieldESFElectronic> list = findByElectronicId(electronicId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field e s f electronic in the ordered set where electronicId = &#63;.
	 *
	 * @param electronicId the electronic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByElectronicId_Last(long electronicId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = fetchByElectronicId_Last(electronicId,
				orderByComparator);

		if (esfFieldESFElectronic != null) {
			return esfFieldESFElectronic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("electronicId=");
		msg.append(electronicId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldESFElectronicException(msg.toString());
	}

	/**
	 * Returns the last e s f field e s f electronic in the ordered set where electronicId = &#63;.
	 *
	 * @param electronicId the electronic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByElectronicId_Last(long electronicId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByElectronicId(electronicId);

		if (count == 0) {
			return null;
		}

		List<ESFFieldESFElectronic> list = findByElectronicId(electronicId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f field e s f electronics before and after the current e s f field e s f electronic in the ordered set where electronicId = &#63;.
	 *
	 * @param id the primary key of the current e s f field e s f electronic
	 * @param electronicId the electronic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic[] findByElectronicId_PrevAndNext(long id,
		long electronicId, OrderByComparator orderByComparator)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ESFFieldESFElectronic[] array = new ESFFieldESFElectronicImpl[3];

			array[0] = getByElectronicId_PrevAndNext(session,
					esfFieldESFElectronic, electronicId, orderByComparator, true);

			array[1] = esfFieldESFElectronic;

			array[2] = getByElectronicId_PrevAndNext(session,
					esfFieldESFElectronic, electronicId, orderByComparator,
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

	protected ESFFieldESFElectronic getByElectronicId_PrevAndNext(
		Session session, ESFFieldESFElectronic esfFieldESFElectronic,
		long electronicId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELDESFELECTRONIC_WHERE);

		query.append(_FINDER_COLUMN_ELECTRONICID_ELECTRONICID_2);

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
			query.append(ESFFieldESFElectronicModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(electronicId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFieldESFElectronic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFieldESFElectronic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f field e s f electronics where electronicId = &#63; from the database.
	 *
	 * @param electronicId the electronic ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByElectronicId(long electronicId)
		throws SystemException {
		for (ESFFieldESFElectronic esfFieldESFElectronic : findByElectronicId(
				electronicId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFieldESFElectronic);
		}
	}

	/**
	 * Returns the number of e s f field e s f electronics where electronicId = &#63;.
	 *
	 * @param electronicId the electronic ID
	 * @return the number of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByElectronicId(long electronicId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ELECTRONICID;

		Object[] finderArgs = new Object[] { electronicId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFIELDESFELECTRONIC_WHERE);

			query.append(_FINDER_COLUMN_ELECTRONICID_ELECTRONICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(electronicId);

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

	private static final String _FINDER_COLUMN_ELECTRONICID_ELECTRONICID_2 = "esfFieldESFElectronic.electronicId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID =
		new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFieldIdBrandIdElectronicId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFFieldESFElectronicModelImpl.FIELDID_COLUMN_BITMASK |
			ESFFieldESFElectronicModelImpl.BRANDID_COLUMN_BITMASK |
			ESFFieldESFElectronicModelImpl.ELECTRONICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIELDIDBRANDIDELECTRONICID =
		new FinderPath(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFieldIdBrandIdElectronicId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; or throws a {@link it.ethica.esf.NoSuchFieldESFElectronicException} if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @param brandId the brand ID
	 * @param electronicId the electronic ID
	 * @return the matching e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = fetchByFieldIdBrandIdElectronicId(fieldId,
				brandId, electronicId);

		if (esfFieldESFElectronic == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fieldId=");
			msg.append(fieldId);

			msg.append(", brandId=");
			msg.append(brandId);

			msg.append(", electronicId=");
			msg.append(electronicId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFieldESFElectronicException(msg.toString());
		}

		return esfFieldESFElectronic;
	}

	/**
	 * Returns the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param brandId the brand ID
	 * @param electronicId the electronic ID
	 * @return the matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws SystemException {
		return fetchByFieldIdBrandIdElectronicId(fieldId, brandId,
			electronicId, true);
	}

	/**
	 * Returns the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param brandId the brand ID
	 * @param electronicId the electronic ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { fieldId, brandId, electronicId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
					finderArgs, this);
		}

		if (result instanceof ESFFieldESFElectronic) {
			ESFFieldESFElectronic esfFieldESFElectronic = (ESFFieldESFElectronic)result;

			if ((fieldId != esfFieldESFElectronic.getFieldId()) ||
					(brandId != esfFieldESFElectronic.getBrandId()) ||
					(electronicId != esfFieldESFElectronic.getElectronicId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ESFFIELDESFELECTRONIC_WHERE);

			query.append(_FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_FIELDID_2);

			query.append(_FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_BRANDID_2);

			query.append(_FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_ELECTRONICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				qPos.add(brandId);

				qPos.add(electronicId);

				List<ESFFieldESFElectronic> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFFieldESFElectronicPersistenceImpl.fetchByFieldIdBrandIdElectronicId(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFFieldESFElectronic esfFieldESFElectronic = list.get(0);

					result = esfFieldESFElectronic;

					cacheResult(esfFieldESFElectronic);

					if ((esfFieldESFElectronic.getFieldId() != fieldId) ||
							(esfFieldESFElectronic.getBrandId() != brandId) ||
							(esfFieldESFElectronic.getElectronicId() != electronicId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
							finderArgs, esfFieldESFElectronic);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
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
			return (ESFFieldESFElectronic)result;
		}
	}

	/**
	 * Removes the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param brandId the brand ID
	 * @param electronicId the electronic ID
	 * @return the e s f field e s f electronic that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic removeByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = findByFieldIdBrandIdElectronicId(fieldId,
				brandId, electronicId);

		return remove(esfFieldESFElectronic);
	}

	/**
	 * Returns the number of e s f field e s f electronics where fieldId = &#63; and brandId = &#63; and electronicId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param brandId the brand ID
	 * @param electronicId the electronic ID
	 * @return the number of matching e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFieldIdBrandIdElectronicId(long fieldId, long brandId,
		long electronicId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELDIDBRANDIDELECTRONICID;

		Object[] finderArgs = new Object[] { fieldId, brandId, electronicId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFFIELDESFELECTRONIC_WHERE);

			query.append(_FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_FIELDID_2);

			query.append(_FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_BRANDID_2);

			query.append(_FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_ELECTRONICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				qPos.add(brandId);

				qPos.add(electronicId);

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

	private static final String _FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_FIELDID_2 =
		"esfFieldESFElectronic.fieldId = ? AND ";
	private static final String _FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_BRANDID_2 =
		"esfFieldESFElectronic.brandId = ? AND ";
	private static final String _FINDER_COLUMN_FIELDIDBRANDIDELECTRONICID_ELECTRONICID_2 =
		"esfFieldESFElectronic.electronicId = ?";

	public ESFFieldESFElectronicPersistenceImpl() {
		setModelClass(ESFFieldESFElectronic.class);
	}

	/**
	 * Caches the e s f field e s f electronic in the entity cache if it is enabled.
	 *
	 * @param esfFieldESFElectronic the e s f field e s f electronic
	 */
	@Override
	public void cacheResult(ESFFieldESFElectronic esfFieldESFElectronic) {
		EntityCacheUtil.putResult(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			esfFieldESFElectronic.getPrimaryKey(), esfFieldESFElectronic);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
			new Object[] {
				esfFieldESFElectronic.getFieldId(),
				esfFieldESFElectronic.getBrandId(),
				esfFieldESFElectronic.getElectronicId()
			}, esfFieldESFElectronic);

		esfFieldESFElectronic.resetOriginalValues();
	}

	/**
	 * Caches the e s f field e s f electronics in the entity cache if it is enabled.
	 *
	 * @param esfFieldESFElectronics the e s f field e s f electronics
	 */
	@Override
	public void cacheResult(List<ESFFieldESFElectronic> esfFieldESFElectronics) {
		for (ESFFieldESFElectronic esfFieldESFElectronic : esfFieldESFElectronics) {
			if (EntityCacheUtil.getResult(
						ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
						ESFFieldESFElectronicImpl.class,
						esfFieldESFElectronic.getPrimaryKey()) == null) {
				cacheResult(esfFieldESFElectronic);
			}
			else {
				esfFieldESFElectronic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f field e s f electronics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFieldESFElectronicImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFieldESFElectronicImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f field e s f electronic.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFFieldESFElectronic esfFieldESFElectronic) {
		EntityCacheUtil.removeResult(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			esfFieldESFElectronic.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfFieldESFElectronic);
	}

	@Override
	public void clearCache(List<ESFFieldESFElectronic> esfFieldESFElectronics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFFieldESFElectronic esfFieldESFElectronic : esfFieldESFElectronics) {
			EntityCacheUtil.removeResult(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
				ESFFieldESFElectronicImpl.class,
				esfFieldESFElectronic.getPrimaryKey());

			clearUniqueFindersCache(esfFieldESFElectronic);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFFieldESFElectronic esfFieldESFElectronic) {
		if (esfFieldESFElectronic.isNew()) {
			Object[] args = new Object[] {
					esfFieldESFElectronic.getFieldId(),
					esfFieldESFElectronic.getBrandId(),
					esfFieldESFElectronic.getElectronicId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDIDBRANDIDELECTRONICID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
				args, esfFieldESFElectronic);
		}
		else {
			ESFFieldESFElectronicModelImpl esfFieldESFElectronicModelImpl = (ESFFieldESFElectronicModelImpl)esfFieldESFElectronic;

			if ((esfFieldESFElectronicModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldESFElectronic.getFieldId(),
						esfFieldESFElectronic.getBrandId(),
						esfFieldESFElectronic.getElectronicId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDIDBRANDIDELECTRONICID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
					args, esfFieldESFElectronic);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFFieldESFElectronic esfFieldESFElectronic) {
		ESFFieldESFElectronicModelImpl esfFieldESFElectronicModelImpl = (ESFFieldESFElectronicModelImpl)esfFieldESFElectronic;

		Object[] args = new Object[] {
				esfFieldESFElectronic.getFieldId(),
				esfFieldESFElectronic.getBrandId(),
				esfFieldESFElectronic.getElectronicId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDIDBRANDIDELECTRONICID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
			args);

		if ((esfFieldESFElectronicModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfFieldESFElectronicModelImpl.getOriginalFieldId(),
					esfFieldESFElectronicModelImpl.getOriginalBrandId(),
					esfFieldESFElectronicModelImpl.getOriginalElectronicId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDIDBRANDIDELECTRONICID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDIDBRANDIDELECTRONICID,
				args);
		}
	}

	/**
	 * Creates a new e s f field e s f electronic with the primary key. Does not add the e s f field e s f electronic to the database.
	 *
	 * @param id the primary key for the new e s f field e s f electronic
	 * @return the new e s f field e s f electronic
	 */
	@Override
	public ESFFieldESFElectronic create(long id) {
		ESFFieldESFElectronic esfFieldESFElectronic = new ESFFieldESFElectronicImpl();

		esfFieldESFElectronic.setNew(true);
		esfFieldESFElectronic.setPrimaryKey(id);

		return esfFieldESFElectronic;
	}

	/**
	 * Removes the e s f field e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e s f field e s f electronic
	 * @return the e s f field e s f electronic that was removed
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic remove(long id)
		throws NoSuchFieldESFElectronicException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the e s f field e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f field e s f electronic
	 * @return the e s f field e s f electronic that was removed
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic remove(Serializable primaryKey)
		throws NoSuchFieldESFElectronicException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFFieldESFElectronic esfFieldESFElectronic = (ESFFieldESFElectronic)session.get(ESFFieldESFElectronicImpl.class,
					primaryKey);

			if (esfFieldESFElectronic == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFieldESFElectronicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfFieldESFElectronic);
		}
		catch (NoSuchFieldESFElectronicException nsee) {
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
	protected ESFFieldESFElectronic removeImpl(
		ESFFieldESFElectronic esfFieldESFElectronic) throws SystemException {
		esfFieldESFElectronic = toUnwrappedModel(esfFieldESFElectronic);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfFieldESFElectronic)) {
				esfFieldESFElectronic = (ESFFieldESFElectronic)session.get(ESFFieldESFElectronicImpl.class,
						esfFieldESFElectronic.getPrimaryKeyObj());
			}

			if (esfFieldESFElectronic != null) {
				session.delete(esfFieldESFElectronic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfFieldESFElectronic != null) {
			clearCache(esfFieldESFElectronic);
		}

		return esfFieldESFElectronic;
	}

	@Override
	public ESFFieldESFElectronic updateImpl(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws SystemException {
		esfFieldESFElectronic = toUnwrappedModel(esfFieldESFElectronic);

		boolean isNew = esfFieldESFElectronic.isNew();

		ESFFieldESFElectronicModelImpl esfFieldESFElectronicModelImpl = (ESFFieldESFElectronicModelImpl)esfFieldESFElectronic;

		Session session = null;

		try {
			session = openSession();

			if (esfFieldESFElectronic.isNew()) {
				session.save(esfFieldESFElectronic);

				esfFieldESFElectronic.setNew(false);
			}
			else {
				session.merge(esfFieldESFElectronic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFFieldESFElectronicModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFieldESFElectronicModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldESFElectronicModelImpl.getOriginalFieldId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDID,
					args);

				args = new Object[] { esfFieldESFElectronicModelImpl.getFieldId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDID,
					args);
			}

			if ((esfFieldESFElectronicModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldESFElectronicModelImpl.getOriginalBrandId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRANDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANDID,
					args);

				args = new Object[] { esfFieldESFElectronicModelImpl.getBrandId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRANDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANDID,
					args);
			}

			if ((esfFieldESFElectronicModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELECTRONICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldESFElectronicModelImpl.getOriginalElectronicId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ELECTRONICID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELECTRONICID,
					args);

				args = new Object[] {
						esfFieldESFElectronicModelImpl.getElectronicId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ELECTRONICID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELECTRONICID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldESFElectronicImpl.class,
			esfFieldESFElectronic.getPrimaryKey(), esfFieldESFElectronic);

		clearUniqueFindersCache(esfFieldESFElectronic);
		cacheUniqueFindersCache(esfFieldESFElectronic);

		return esfFieldESFElectronic;
	}

	protected ESFFieldESFElectronic toUnwrappedModel(
		ESFFieldESFElectronic esfFieldESFElectronic) {
		if (esfFieldESFElectronic instanceof ESFFieldESFElectronicImpl) {
			return esfFieldESFElectronic;
		}

		ESFFieldESFElectronicImpl esfFieldESFElectronicImpl = new ESFFieldESFElectronicImpl();

		esfFieldESFElectronicImpl.setNew(esfFieldESFElectronic.isNew());
		esfFieldESFElectronicImpl.setPrimaryKey(esfFieldESFElectronic.getPrimaryKey());

		esfFieldESFElectronicImpl.setId(esfFieldESFElectronic.getId());
		esfFieldESFElectronicImpl.setBrandId(esfFieldESFElectronic.getBrandId());
		esfFieldESFElectronicImpl.setElectronicId(esfFieldESFElectronic.getElectronicId());
		esfFieldESFElectronicImpl.setFieldId(esfFieldESFElectronic.getFieldId());
		esfFieldESFElectronicImpl.setDescription(esfFieldESFElectronic.getDescription());

		return esfFieldESFElectronicImpl;
	}

	/**
	 * Returns the e s f field e s f electronic with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f field e s f electronic
	 * @return the e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFieldESFElectronicException, SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = fetchByPrimaryKey(primaryKey);

		if (esfFieldESFElectronic == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFieldESFElectronicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfFieldESFElectronic;
	}

	/**
	 * Returns the e s f field e s f electronic with the primary key or throws a {@link it.ethica.esf.NoSuchFieldESFElectronicException} if it could not be found.
	 *
	 * @param id the primary key of the e s f field e s f electronic
	 * @return the e s f field e s f electronic
	 * @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic findByPrimaryKey(long id)
		throws NoSuchFieldESFElectronicException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the e s f field e s f electronic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f field e s f electronic
	 * @return the e s f field e s f electronic, or <code>null</code> if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFFieldESFElectronic esfFieldESFElectronic = (ESFFieldESFElectronic)EntityCacheUtil.getResult(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
				ESFFieldESFElectronicImpl.class, primaryKey);

		if (esfFieldESFElectronic == _nullESFFieldESFElectronic) {
			return null;
		}

		if (esfFieldESFElectronic == null) {
			Session session = null;

			try {
				session = openSession();

				esfFieldESFElectronic = (ESFFieldESFElectronic)session.get(ESFFieldESFElectronicImpl.class,
						primaryKey);

				if (esfFieldESFElectronic != null) {
					cacheResult(esfFieldESFElectronic);
				}
				else {
					EntityCacheUtil.putResult(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
						ESFFieldESFElectronicImpl.class, primaryKey,
						_nullESFFieldESFElectronic);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFieldESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
					ESFFieldESFElectronicImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfFieldESFElectronic;
	}

	/**
	 * Returns the e s f field e s f electronic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e s f field e s f electronic
	 * @return the e s f field e s f electronic, or <code>null</code> if a e s f field e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFieldESFElectronic fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the e s f field e s f electronics.
	 *
	 * @return the e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f field e s f electronics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f field e s f electronics
	 * @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	 * @return the range of e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f field e s f electronics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f field e s f electronics
	 * @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f field e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFieldESFElectronic> findAll(int start, int end,
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

		List<ESFFieldESFElectronic> list = (List<ESFFieldESFElectronic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFIELDESFELECTRONIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFIELDESFELECTRONIC;

				if (pagination) {
					sql = sql.concat(ESFFieldESFElectronicModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFFieldESFElectronic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFieldESFElectronic>(list);
				}
				else {
					list = (List<ESFFieldESFElectronic>)QueryUtil.list(q,
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
	 * Removes all the e s f field e s f electronics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFFieldESFElectronic esfFieldESFElectronic : findAll()) {
			remove(esfFieldESFElectronic);
		}
	}

	/**
	 * Returns the number of e s f field e s f electronics.
	 *
	 * @return the number of e s f field e s f electronics
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

				Query q = session.createQuery(_SQL_COUNT_ESFFIELDESFELECTRONIC);

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
	 * Initializes the e s f field e s f electronic persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFFieldESFElectronic")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFFieldESFElectronic>> listenersList = new ArrayList<ModelListener<ESFFieldESFElectronic>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFFieldESFElectronic>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFieldESFElectronicImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFIELDESFELECTRONIC = "SELECT esfFieldESFElectronic FROM ESFFieldESFElectronic esfFieldESFElectronic";
	private static final String _SQL_SELECT_ESFFIELDESFELECTRONIC_WHERE = "SELECT esfFieldESFElectronic FROM ESFFieldESFElectronic esfFieldESFElectronic WHERE ";
	private static final String _SQL_COUNT_ESFFIELDESFELECTRONIC = "SELECT COUNT(esfFieldESFElectronic) FROM ESFFieldESFElectronic esfFieldESFElectronic";
	private static final String _SQL_COUNT_ESFFIELDESFELECTRONIC_WHERE = "SELECT COUNT(esfFieldESFElectronic) FROM ESFFieldESFElectronic esfFieldESFElectronic WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfFieldESFElectronic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFFieldESFElectronic exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFFieldESFElectronic exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFieldESFElectronicPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static ESFFieldESFElectronic _nullESFFieldESFElectronic = new ESFFieldESFElectronicImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFFieldESFElectronic> toCacheModel() {
				return _nullESFFieldESFElectronicCacheModel;
			}
		};

	private static CacheModel<ESFFieldESFElectronic> _nullESFFieldESFElectronicCacheModel =
		new CacheModel<ESFFieldESFElectronic>() {
			@Override
			public ESFFieldESFElectronic toEntityModel() {
				return _nullESFFieldESFElectronic;
			}
		};
}