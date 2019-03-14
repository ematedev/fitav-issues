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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchCaneException;
import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.impl.ESFCaneImpl;
import it.ethica.esf.model.impl.ESFCaneModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f cane service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCanePersistence
 * @see ESFCaneUtil
 * @generated
 */
public class ESFCanePersistenceImpl extends BasePersistenceImpl<ESFCane>
	implements ESFCanePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFCaneUtil} to access the e s f cane persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFCaneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFCaneModelImpl.UUID_COLUMN_BITMASK |
			ESFCaneModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f canes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f canes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @return the range of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f canes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<ESFCane> list = (List<ESFCane>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCane esfCane : list) {
				if (!Validator.equals(uuid, esfCane.getUuid())) {
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

			query.append(_SQL_SELECT_ESFCANE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCaneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCane>(list);
				}
				else {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first e s f cane in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByUuid_First(uuid, orderByComparator);

		if (esfCane != null) {
			return esfCane;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCaneException(msg.toString());
	}

	/**
	 * Returns the first e s f cane in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCane> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f cane in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByUuid_Last(uuid, orderByComparator);

		if (esfCane != null) {
			return esfCane;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCaneException(msg.toString());
	}

	/**
	 * Returns the last e s f cane in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFCane> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f canes before and after the current e s f cane in the ordered set where uuid = &#63;.
	 *
	 * @param esfCaneId the primary key of the current e s f cane
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane[] findByUuid_PrevAndNext(long esfCaneId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = findByPrimaryKey(esfCaneId);

		Session session = null;

		try {
			session = openSession();

			ESFCane[] array = new ESFCaneImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfCane, uuid,
					orderByComparator, true);

			array[1] = esfCane;

			array[2] = getByUuid_PrevAndNext(session, esfCane, uuid,
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

	protected ESFCane getByUuid_PrevAndNext(Session session, ESFCane esfCane,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCANE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(ESFCaneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCane);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCane> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f canes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFCane esfCane : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCane);
		}
	}

	/**
	 * Returns the number of e s f canes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCANE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfCane.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfCane.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfCane.uuid IS NULL OR esfCane.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfUserId",
			new String[] { Long.class.getName() },
			ESFCaneModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFCaneModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERID = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f canes where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfUserId(long esfUserId)
		throws SystemException {
		return findByEsfUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f canes where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @return the range of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfUserId(long esfUserId, int start, int end)
		throws SystemException {
		return findByEsfUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f canes where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfUserId(long esfUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFCane> list = (List<ESFCane>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCane esfCane : list) {
				if ((esfUserId != esfCane.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFCANE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCaneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCane>(list);
				}
				else {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first e s f cane in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByEsfUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByEsfUserId_First(esfUserId, orderByComparator);

		if (esfCane != null) {
			return esfCane;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCaneException(msg.toString());
	}

	/**
	 * Returns the first e s f cane in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByEsfUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCane> list = findByEsfUserId(esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f cane in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByEsfUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByEsfUserId_Last(esfUserId, orderByComparator);

		if (esfCane != null) {
			return esfCane;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCaneException(msg.toString());
	}

	/**
	 * Returns the last e s f cane in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByEsfUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFCane> list = findByEsfUserId(esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f canes before and after the current e s f cane in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfCaneId the primary key of the current e s f cane
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane[] findByEsfUserId_PrevAndNext(long esfCaneId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = findByPrimaryKey(esfCaneId);

		Session session = null;

		try {
			session = openSession();

			ESFCane[] array = new ESFCaneImpl[3];

			array[0] = getByEsfUserId_PrevAndNext(session, esfCane, esfUserId,
					orderByComparator, true);

			array[1] = esfCane;

			array[2] = getByEsfUserId_PrevAndNext(session, esfCane, esfUserId,
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

	protected ESFCane getByEsfUserId_PrevAndNext(Session session,
		ESFCane esfCane, long esfUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCANE_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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
			query.append(ESFCaneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCane);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCane> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f canes where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfUserId(long esfUserId) throws SystemException {
		for (ESFCane esfCane : findByEsfUserId(esfUserId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCane);
		}
	}

	/**
	 * Returns the number of e s f canes where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfUserId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCANE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_ESFUSERID_ESFUSERID_2 = "esfCane.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEsfOrganizationId", new String[] { Long.class.getName() },
			ESFCaneModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK |
			ESFCaneModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFORGANIZATIONID = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEsfOrganizationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f canes where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfOrganizationId(long esfOrganizationId)
		throws SystemException {
		return findByEsfOrganizationId(esfOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f canes where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @return the range of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfOrganizationId(long esfOrganizationId,
		int start, int end) throws SystemException {
		return findByEsfOrganizationId(esfOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f canes where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfOrganizationId(long esfOrganizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ESFCane> list = (List<ESFCane>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCane esfCane : list) {
				if ((esfOrganizationId != esfCane.getEsfOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFCANE_WHERE);

			query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCaneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				if (!pagination) {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCane>(list);
				}
				else {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first e s f cane in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByEsfOrganizationId_First(long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByEsfOrganizationId_First(esfOrganizationId,
				orderByComparator);

		if (esfCane != null) {
			return esfCane;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCaneException(msg.toString());
	}

	/**
	 * Returns the first e s f cane in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByEsfOrganizationId_First(long esfOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCane> list = findByEsfOrganizationId(esfOrganizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f cane in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByEsfOrganizationId_Last(long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByEsfOrganizationId_Last(esfOrganizationId,
				orderByComparator);

		if (esfCane != null) {
			return esfCane;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCaneException(msg.toString());
	}

	/**
	 * Returns the last e s f cane in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByEsfOrganizationId_Last(long esfOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfOrganizationId(esfOrganizationId);

		if (count == 0) {
			return null;
		}

		List<ESFCane> list = findByEsfOrganizationId(esfOrganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f canes before and after the current e s f cane in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfCaneId the primary key of the current e s f cane
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane[] findByEsfOrganizationId_PrevAndNext(long esfCaneId,
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = findByPrimaryKey(esfCaneId);

		Session session = null;

		try {
			session = openSession();

			ESFCane[] array = new ESFCaneImpl[3];

			array[0] = getByEsfOrganizationId_PrevAndNext(session, esfCane,
					esfOrganizationId, orderByComparator, true);

			array[1] = esfCane;

			array[2] = getByEsfOrganizationId_PrevAndNext(session, esfCane,
					esfOrganizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFCane getByEsfOrganizationId_PrevAndNext(Session session,
		ESFCane esfCane, long esfOrganizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCANE_WHERE);

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
			query.append(ESFCaneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCane);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCane> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f canes where esfOrganizationId = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfOrganizationId(long esfOrganizationId)
		throws SystemException {
		for (ESFCane esfCane : findByEsfOrganizationId(esfOrganizationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfCane);
		}
	}

	/**
	 * Returns the number of e s f canes where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the number of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfOrganizationId(long esfOrganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFORGANIZATIONID;

		Object[] finderArgs = new Object[] { esfOrganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCANE_WHERE);

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
		"esfCane.esfOrganizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFGUNKINDID =
		new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfGunKindId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID =
		new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfGunKindId",
			new String[] { Long.class.getName() },
			ESFCaneModelImpl.ESFGUNKINDID_COLUMN_BITMASK |
			ESFCaneModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFGUNKINDID = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfGunKindId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f canes where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @return the matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfGunKindId(long esfGunKindId)
		throws SystemException {
		return findByEsfGunKindId(esfGunKindId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f canes where esfGunKindId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @return the range of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfGunKindId(long esfGunKindId, int start,
		int end) throws SystemException {
		return findByEsfGunKindId(esfGunKindId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f canes where esfGunKindId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findByEsfGunKindId(long esfGunKindId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID;
			finderArgs = new Object[] { esfGunKindId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFGUNKINDID;
			finderArgs = new Object[] {
					esfGunKindId,
					
					start, end, orderByComparator
				};
		}

		List<ESFCane> list = (List<ESFCane>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCane esfCane : list) {
				if ((esfGunKindId != esfCane.getEsfGunKindId())) {
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

			query.append(_SQL_SELECT_ESFCANE_WHERE);

			query.append(_FINDER_COLUMN_ESFGUNKINDID_ESFGUNKINDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCaneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunKindId);

				if (!pagination) {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCane>(list);
				}
				else {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first e s f cane in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByEsfGunKindId_First(long esfGunKindId,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByEsfGunKindId_First(esfGunKindId,
				orderByComparator);

		if (esfCane != null) {
			return esfCane;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunKindId=");
		msg.append(esfGunKindId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCaneException(msg.toString());
	}

	/**
	 * Returns the first e s f cane in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByEsfGunKindId_First(long esfGunKindId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCane> list = findByEsfGunKindId(esfGunKindId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f cane in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByEsfGunKindId_Last(long esfGunKindId,
		OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByEsfGunKindId_Last(esfGunKindId,
				orderByComparator);

		if (esfCane != null) {
			return esfCane;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunKindId=");
		msg.append(esfGunKindId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCaneException(msg.toString());
	}

	/**
	 * Returns the last e s f cane in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByEsfGunKindId_Last(long esfGunKindId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfGunKindId(esfGunKindId);

		if (count == 0) {
			return null;
		}

		List<ESFCane> list = findByEsfGunKindId(esfGunKindId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f canes before and after the current e s f cane in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfCaneId the primary key of the current e s f cane
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane[] findByEsfGunKindId_PrevAndNext(long esfCaneId,
		long esfGunKindId, OrderByComparator orderByComparator)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = findByPrimaryKey(esfCaneId);

		Session session = null;

		try {
			session = openSession();

			ESFCane[] array = new ESFCaneImpl[3];

			array[0] = getByEsfGunKindId_PrevAndNext(session, esfCane,
					esfGunKindId, orderByComparator, true);

			array[1] = esfCane;

			array[2] = getByEsfGunKindId_PrevAndNext(session, esfCane,
					esfGunKindId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFCane getByEsfGunKindId_PrevAndNext(Session session,
		ESFCane esfCane, long esfGunKindId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCANE_WHERE);

		query.append(_FINDER_COLUMN_ESFGUNKINDID_ESFGUNKINDID_2);

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
			query.append(ESFCaneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfGunKindId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCane);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCane> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f canes where esfGunKindId = &#63; from the database.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfGunKindId(long esfGunKindId)
		throws SystemException {
		for (ESFCane esfCane : findByEsfGunKindId(esfGunKindId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfCane);
		}
	}

	/**
	 * Returns the number of e s f canes where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @return the number of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfGunKindId(long esfGunKindId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFGUNKINDID;

		Object[] finderArgs = new Object[] { esfGunKindId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCANE_WHERE);

			query.append(_FINDER_COLUMN_ESFGUNKINDID_ESFGUNKINDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunKindId);

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

	private static final String _FINDER_COLUMN_ESFGUNKINDID_ESFGUNKINDID_2 = "esfCane.esfGunKindId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, ESFCaneImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFCaneModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f cane where code = &#63; or throws a {@link it.ethica.esf.NoSuchCaneException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByCode(String code)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByCode(code);

		if (esfCane == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCaneException(msg.toString());
		}

		return esfCane;
	}

	/**
	 * Returns the e s f cane where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f cane where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f cane, or <code>null</code> if a matching e s f cane could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFCane) {
			ESFCane esfCane = (ESFCane)result;

			if (!Validator.equals(code, esfCane.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFCANE_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				List<ESFCane> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFCanePersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFCane esfCane = list.get(0);

					result = esfCane;

					cacheResult(esfCane);

					if ((esfCane.getCode() == null) ||
							!esfCane.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfCane);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
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
			return (ESFCane)result;
		}
	}

	/**
	 * Removes the e s f cane where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f cane that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane removeByCode(String code)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = findByCode(code);

		return remove(esfCane);
	}

	/**
	 * Returns the number of e s f canes where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCANE_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfCane.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfCane.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfCane.code IS NULL OR esfCane.code = '')";

	public ESFCanePersistenceImpl() {
		setModelClass(ESFCane.class);
	}

	/**
	 * Caches the e s f cane in the entity cache if it is enabled.
	 *
	 * @param esfCane the e s f cane
	 */
	@Override
	public void cacheResult(ESFCane esfCane) {
		EntityCacheUtil.putResult(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneImpl.class, esfCane.getPrimaryKey(), esfCane);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfCane.getCode() }, esfCane);

		esfCane.resetOriginalValues();
	}

	/**
	 * Caches the e s f canes in the entity cache if it is enabled.
	 *
	 * @param esfCanes the e s f canes
	 */
	@Override
	public void cacheResult(List<ESFCane> esfCanes) {
		for (ESFCane esfCane : esfCanes) {
			if (EntityCacheUtil.getResult(
						ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
						ESFCaneImpl.class, esfCane.getPrimaryKey()) == null) {
				cacheResult(esfCane);
			}
			else {
				esfCane.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f canes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFCaneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFCaneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f cane.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFCane esfCane) {
		EntityCacheUtil.removeResult(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneImpl.class, esfCane.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfCane);
	}

	@Override
	public void clearCache(List<ESFCane> esfCanes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFCane esfCane : esfCanes) {
			EntityCacheUtil.removeResult(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
				ESFCaneImpl.class, esfCane.getPrimaryKey());

			clearUniqueFindersCache(esfCane);
		}
	}

	protected void cacheUniqueFindersCache(ESFCane esfCane) {
		if (esfCane.isNew()) {
			Object[] args = new Object[] { esfCane.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, esfCane);
		}
		else {
			ESFCaneModelImpl esfCaneModelImpl = (ESFCaneModelImpl)esfCane;

			if ((esfCaneModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfCane.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfCane);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFCane esfCane) {
		ESFCaneModelImpl esfCaneModelImpl = (ESFCaneModelImpl)esfCane;

		Object[] args = new Object[] { esfCane.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfCaneModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfCaneModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new e s f cane with the primary key. Does not add the e s f cane to the database.
	 *
	 * @param esfCaneId the primary key for the new e s f cane
	 * @return the new e s f cane
	 */
	@Override
	public ESFCane create(long esfCaneId) {
		ESFCane esfCane = new ESFCaneImpl();

		esfCane.setNew(true);
		esfCane.setPrimaryKey(esfCaneId);

		String uuid = PortalUUIDUtil.generate();

		esfCane.setUuid(uuid);

		return esfCane;
	}

	/**
	 * Removes the e s f cane with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfCaneId the primary key of the e s f cane
	 * @return the e s f cane that was removed
	 * @throws it.ethica.esf.NoSuchCaneException if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane remove(long esfCaneId)
		throws NoSuchCaneException, SystemException {
		return remove((Serializable)esfCaneId);
	}

	/**
	 * Removes the e s f cane with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f cane
	 * @return the e s f cane that was removed
	 * @throws it.ethica.esf.NoSuchCaneException if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane remove(Serializable primaryKey)
		throws NoSuchCaneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFCane esfCane = (ESFCane)session.get(ESFCaneImpl.class, primaryKey);

			if (esfCane == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCaneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfCane);
		}
		catch (NoSuchCaneException nsee) {
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
	protected ESFCane removeImpl(ESFCane esfCane) throws SystemException {
		esfCane = toUnwrappedModel(esfCane);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfCane)) {
				esfCane = (ESFCane)session.get(ESFCaneImpl.class,
						esfCane.getPrimaryKeyObj());
			}

			if (esfCane != null) {
				session.delete(esfCane);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfCane != null) {
			clearCache(esfCane);
		}

		return esfCane;
	}

	@Override
	public ESFCane updateImpl(it.ethica.esf.model.ESFCane esfCane)
		throws SystemException {
		esfCane = toUnwrappedModel(esfCane);

		boolean isNew = esfCane.isNew();

		ESFCaneModelImpl esfCaneModelImpl = (ESFCaneModelImpl)esfCane;

		if (Validator.isNull(esfCane.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfCane.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfCane.isNew()) {
				session.save(esfCane);

				esfCane.setNew(false);
			}
			else {
				session.merge(esfCane);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFCaneModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfCaneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfCaneModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfCaneModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfCaneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCaneModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);

				args = new Object[] { esfCaneModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);
			}

			if ((esfCaneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCaneModelImpl.getOriginalEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);

				args = new Object[] { esfCaneModelImpl.getEsfOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);
			}

			if ((esfCaneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCaneModelImpl.getOriginalEsfGunKindId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFGUNKINDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID,
					args);

				args = new Object[] { esfCaneModelImpl.getEsfGunKindId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFGUNKINDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
			ESFCaneImpl.class, esfCane.getPrimaryKey(), esfCane);

		clearUniqueFindersCache(esfCane);
		cacheUniqueFindersCache(esfCane);

		return esfCane;
	}

	protected ESFCane toUnwrappedModel(ESFCane esfCane) {
		if (esfCane instanceof ESFCaneImpl) {
			return esfCane;
		}

		ESFCaneImpl esfCaneImpl = new ESFCaneImpl();

		esfCaneImpl.setNew(esfCane.isNew());
		esfCaneImpl.setPrimaryKey(esfCane.getPrimaryKey());

		esfCaneImpl.setUuid(esfCane.getUuid());
		esfCaneImpl.setEsfCaneId(esfCane.getEsfCaneId());
		esfCaneImpl.setEsfUserId(esfCane.getEsfUserId());
		esfCaneImpl.setCode(esfCane.getCode());
		esfCaneImpl.setEsfGunKindId(esfCane.getEsfGunKindId());
		esfCaneImpl.setEsfOrganizationId(esfCane.getEsfOrganizationId());
		esfCaneImpl.setCaneCaliber(esfCane.getCaneCaliber());
		esfCaneImpl.setIsFavoriteGun(esfCane.isIsFavoriteGun());
		esfCaneImpl.setTypeId(esfCane.getTypeId());
		esfCaneImpl.setMeasures(esfCane.getMeasures());
		esfCaneImpl.setShooterId(esfCane.getShooterId());
		esfCaneImpl.setEsfGunTypeId(esfCane.getEsfGunTypeId());

		return esfCaneImpl;
	}

	/**
	 * Returns the e s f cane with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f cane
	 * @return the e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCaneException, SystemException {
		ESFCane esfCane = fetchByPrimaryKey(primaryKey);

		if (esfCane == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCaneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfCane;
	}

	/**
	 * Returns the e s f cane with the primary key or throws a {@link it.ethica.esf.NoSuchCaneException} if it could not be found.
	 *
	 * @param esfCaneId the primary key of the e s f cane
	 * @return the e s f cane
	 * @throws it.ethica.esf.NoSuchCaneException if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane findByPrimaryKey(long esfCaneId)
		throws NoSuchCaneException, SystemException {
		return findByPrimaryKey((Serializable)esfCaneId);
	}

	/**
	 * Returns the e s f cane with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f cane
	 * @return the e s f cane, or <code>null</code> if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFCane esfCane = (ESFCane)EntityCacheUtil.getResult(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
				ESFCaneImpl.class, primaryKey);

		if (esfCane == _nullESFCane) {
			return null;
		}

		if (esfCane == null) {
			Session session = null;

			try {
				session = openSession();

				esfCane = (ESFCane)session.get(ESFCaneImpl.class, primaryKey);

				if (esfCane != null) {
					cacheResult(esfCane);
				}
				else {
					EntityCacheUtil.putResult(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
						ESFCaneImpl.class, primaryKey, _nullESFCane);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFCaneModelImpl.ENTITY_CACHE_ENABLED,
					ESFCaneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfCane;
	}

	/**
	 * Returns the e s f cane with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfCaneId the primary key of the e s f cane
	 * @return the e s f cane, or <code>null</code> if a e s f cane with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCane fetchByPrimaryKey(long esfCaneId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfCaneId);
	}

	/**
	 * Returns all the e s f canes.
	 *
	 * @return the e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f canes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @return the range of e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f canes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f canes
	 * @param end the upper bound of the range of e s f canes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f canes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCane> findAll(int start, int end,
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

		List<ESFCane> list = (List<ESFCane>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFCANE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFCANE;

				if (pagination) {
					sql = sql.concat(ESFCaneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCane>(list);
				}
				else {
					list = (List<ESFCane>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the e s f canes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFCane esfCane : findAll()) {
			remove(esfCane);
		}
	}

	/**
	 * Returns the number of e s f canes.
	 *
	 * @return the number of e s f canes
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

				Query q = session.createQuery(_SQL_COUNT_ESFCANE);

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
	 * Initializes the e s f cane persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFCane")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFCane>> listenersList = new ArrayList<ModelListener<ESFCane>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFCane>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFCaneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFCANE = "SELECT esfCane FROM ESFCane esfCane";
	private static final String _SQL_SELECT_ESFCANE_WHERE = "SELECT esfCane FROM ESFCane esfCane WHERE ";
	private static final String _SQL_COUNT_ESFCANE = "SELECT COUNT(esfCane) FROM ESFCane esfCane";
	private static final String _SQL_COUNT_ESFCANE_WHERE = "SELECT COUNT(esfCane) FROM ESFCane esfCane WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfCane.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFCane exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFCane exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFCanePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFCane _nullESFCane = new ESFCaneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFCane> toCacheModel() {
				return _nullESFCaneCacheModel;
			}
		};

	private static CacheModel<ESFCane> _nullESFCaneCacheModel = new CacheModel<ESFCane>() {
			@Override
			public ESFCane toEntityModel() {
				return _nullESFCane;
			}
		};
}