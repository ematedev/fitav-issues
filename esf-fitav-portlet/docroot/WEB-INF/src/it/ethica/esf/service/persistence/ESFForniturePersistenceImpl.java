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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import it.ethica.esf.NoSuchFornitureException;
import it.ethica.esf.model.ESFForniture;
import it.ethica.esf.model.impl.ESFFornitureImpl;
import it.ethica.esf.model.impl.ESFFornitureModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f forniture service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFForniturePersistence
 * @see ESFFornitureUtil
 * @generated
 */
public class ESFForniturePersistenceImpl extends BasePersistenceImpl<ESFForniture>
	implements ESFForniturePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFornitureUtil} to access the e s f forniture persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFornitureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFFornitureModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f fornitures where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByUuid(String uuid, int start, int end,
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

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFForniture esfForniture : list) {
				if (!Validator.equals(uuid, esfForniture.getUuid())) {
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

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

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
				query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f forniture in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByUuid_First(uuid, orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFForniture> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByUuid_Last(uuid, orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFForniture> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fornitures before and after the current e s f forniture in the ordered set where uuid = &#63;.
	 *
	 * @param esfFornitureId the primary key of the current e s f forniture
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture[] findByUuid_PrevAndNext(long esfFornitureId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByPrimaryKey(esfFornitureId);

		Session session = null;

		try {
			session = openSession();

			ESFForniture[] array = new ESFFornitureImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfForniture, uuid,
					orderByComparator, true);

			array[1] = esfForniture;

			array[2] = getByUuid_PrevAndNext(session, esfForniture, uuid,
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

	protected ESFForniture getByUuid_PrevAndNext(Session session,
		ESFForniture esfForniture, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

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
			query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfForniture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFForniture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fornitures where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFForniture esfForniture : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f fornitures
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

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfForniture.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfForniture.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfForniture.uuid IS NULL OR esfForniture.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFornitureModelImpl.UUID_COLUMN_BITMASK |
			ESFFornitureModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f forniture where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByUUID_G(String uuid, long groupId)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByUUID_G(uuid, groupId);

		if (esfForniture == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFornitureException(msg.toString());
		}

		return esfForniture;
	}

	/**
	 * Returns the e s f forniture where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f forniture where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFForniture) {
			ESFForniture esfForniture = (ESFForniture)result;

			if (!Validator.equals(uuid, esfForniture.getUuid()) ||
					(groupId != esfForniture.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<ESFForniture> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFForniture esfForniture = list.get(0);

					result = esfForniture;

					cacheResult(esfForniture);

					if ((esfForniture.getUuid() == null) ||
							!esfForniture.getUuid().equals(uuid) ||
							(esfForniture.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfForniture);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (ESFForniture)result;
		}
	}

	/**
	 * Removes the e s f forniture where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f forniture that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture removeByUUID_G(String uuid, long groupId)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByUUID_G(uuid, groupId);

		return remove(esfForniture);
	}

	/**
	 * Returns the number of e s f fornitures where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfForniture.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfForniture.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfForniture.uuid IS NULL OR esfForniture.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfForniture.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFornitureModelImpl.UUID_COLUMN_BITMASK |
			ESFFornitureModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFForniture esfForniture : list) {
				if (!Validator.equals(uuid, esfForniture.getUuid()) ||
						(companyId != esfForniture.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFForniture> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFForniture> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fornitures before and after the current e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfFornitureId the primary key of the current e s f forniture
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture[] findByUuid_C_PrevAndNext(long esfFornitureId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByPrimaryKey(esfFornitureId);

		Session session = null;

		try {
			session = openSession();

			ESFForniture[] array = new ESFFornitureImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfForniture, uuid,
					companyId, orderByComparator, true);

			array[1] = esfForniture;

			array[2] = getByUuid_C_PrevAndNext(session, esfForniture, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFForniture getByUuid_C_PrevAndNext(Session session,
		ESFForniture esfForniture, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfForniture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFForniture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fornitures where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFForniture esfForniture : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfForniture.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfForniture.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfForniture.uuid IS NULL OR esfForniture.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfForniture.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFFornitureModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f fornitures where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFForniture esfForniture : list) {
				if ((groupId != esfForniture.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f forniture in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByGroupId_First(groupId,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFForniture> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFForniture> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fornitures before and after the current e s f forniture in the ordered set where groupId = &#63;.
	 *
	 * @param esfFornitureId the primary key of the current e s f forniture
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture[] findByGroupId_PrevAndNext(long esfFornitureId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByPrimaryKey(esfFornitureId);

		Session session = null;

		try {
			session = openSession();

			ESFForniture[] array = new ESFFornitureImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfForniture, groupId,
					orderByComparator, true);

			array[1] = esfForniture;

			array[2] = getByGroupId_PrevAndNext(session, esfForniture, groupId,
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

	protected ESFForniture getByGroupId_PrevAndNext(Session session,
		ESFForniture esfForniture, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfForniture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFForniture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fornitures where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFForniture esfForniture : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfForniture.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFFornitureModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f forniture where code = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByCode(String code)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByCode(code);

		if (esfForniture == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFornitureException(msg.toString());
		}

		return esfForniture;
	}

	/**
	 * Returns the e s f forniture where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f forniture where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFForniture) {
			ESFForniture esfForniture = (ESFForniture)result;

			if (!Validator.equals(code, esfForniture.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

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

				List<ESFForniture> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFForniturePersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFForniture esfForniture = list.get(0);

					result = esfForniture;

					cacheResult(esfForniture);

					if ((esfForniture.getCode() == null) ||
							!esfForniture.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfForniture);
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
			return (ESFForniture)result;
		}
	}

	/**
	 * Removes the e s f forniture where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f forniture that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture removeByCode(String code)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByCode(code);

		return remove(esfForniture);
	}

	/**
	 * Returns the number of e s f fornitures where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f fornitures
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

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfForniture.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfForniture.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfForniture.code IS NULL OR esfForniture.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			ESFFornitureModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f fornitures where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFForniture esfForniture : list) {
				if (!Validator.equals(name, esfForniture.getName())) {
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

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f forniture in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByName_First(name, orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFForniture> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByName_Last(name, orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ESFForniture> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fornitures before and after the current e s f forniture in the ordered set where name = &#63;.
	 *
	 * @param esfFornitureId the primary key of the current e s f forniture
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture[] findByName_PrevAndNext(long esfFornitureId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByPrimaryKey(esfFornitureId);

		Session session = null;

		try {
			session = openSession();

			ESFForniture[] array = new ESFFornitureImpl[3];

			array[0] = getByName_PrevAndNext(session, esfForniture, name,
					orderByComparator, true);

			array[1] = esfForniture;

			array[2] = getByName_PrevAndNext(session, esfForniture, name,
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

	protected ESFForniture getByName_PrevAndNext(Session session,
		ESFForniture esfForniture, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfForniture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFForniture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fornitures where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ESFForniture esfForniture : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfForniture.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfForniture.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfForniture.name IS NULL OR esfForniture.name = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_DESCRIPTION = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDescription",
			new String[] { String.class.getName() },
			ESFFornitureModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescription",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f forniture where description = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	 *
	 * @param description the description
	 * @return the matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByDescription(String description)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByDescription(description);

		if (esfForniture == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("description=");
			msg.append(description);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFornitureException(msg.toString());
		}

		return esfForniture;
	}

	/**
	 * Returns the e s f forniture where description = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param description the description
	 * @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByDescription(String description)
		throws SystemException {
		return fetchByDescription(description, true);
	}

	/**
	 * Returns the e s f forniture where description = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param description the description
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByDescription(String description,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { description };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DESCRIPTION,
					finderArgs, this);
		}

		if (result instanceof ESFForniture) {
			ESFForniture esfForniture = (ESFForniture)result;

			if (!Validator.equals(description, esfForniture.getDescription())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
				}

				List<ESFForniture> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRIPTION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFForniturePersistenceImpl.fetchByDescription(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFForniture esfForniture = list.get(0);

					result = esfForniture;

					cacheResult(esfForniture);

					if ((esfForniture.getDescription() == null) ||
							!esfForniture.getDescription().equals(description)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRIPTION,
							finderArgs, esfForniture);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESCRIPTION,
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
			return (ESFForniture)result;
		}
	}

	/**
	 * Removes the e s f forniture where description = &#63; from the database.
	 *
	 * @param description the description
	 * @return the e s f forniture that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture removeByDescription(String description)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByDescription(description);

		return remove(esfForniture);
	}

	/**
	 * Returns the number of e s f fornitures where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDescription(String description) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCRIPTION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
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

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1 = "esfForniture.description IS NULL";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 = "esfForniture.description = ?";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3 = "(esfForniture.description IS NULL OR esfForniture.description = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { Long.class.getName() },
			ESFFornitureModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f fornitures where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByType(long type) throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByType(long type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByType(long type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFForniture esfForniture : list) {
				if ((type != esfForniture.getType())) {
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

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (!pagination) {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f forniture in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByType_First(long type,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByType_First(type, orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByType_First(long type,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFForniture> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByType_Last(long type,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByType_Last(type, orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByType_Last(long type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<ESFForniture> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fornitures before and after the current e s f forniture in the ordered set where type = &#63;.
	 *
	 * @param esfFornitureId the primary key of the current e s f forniture
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture[] findByType_PrevAndNext(long esfFornitureId,
		long type, OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByPrimaryKey(esfFornitureId);

		Session session = null;

		try {
			session = openSession();

			ESFForniture[] array = new ESFFornitureImpl[3];

			array[0] = getByType_PrevAndNext(session, esfForniture, type,
					orderByComparator, true);

			array[1] = esfForniture;

			array[2] = getByType_PrevAndNext(session, esfForniture, type,
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

	protected ESFForniture getByType_PrevAndNext(Session session,
		ESFForniture esfForniture, long type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

		query.append(_FINDER_COLUMN_TYPE_TYPE_2);

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
			query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfForniture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFForniture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fornitures where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(long type) throws SystemException {
		for (ESFForniture esfForniture : findByType(type, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(long type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "esfForniture.type = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSERTDATE =
		new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInsertDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSERTDATE =
		new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInsertDate",
			new String[] { Date.class.getName() },
			ESFFornitureModelImpl.INSERTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSERTDATE = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInsertDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the e s f fornitures where insertDate = &#63;.
	 *
	 * @param insertDate the insert date
	 * @return the matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByInsertDate(Date insertDate)
		throws SystemException {
		return findByInsertDate(insertDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures where insertDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param insertDate the insert date
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByInsertDate(Date insertDate, int start,
		int end) throws SystemException {
		return findByInsertDate(insertDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures where insertDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param insertDate the insert date
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByInsertDate(Date insertDate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSERTDATE;
			finderArgs = new Object[] { insertDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSERTDATE;
			finderArgs = new Object[] { insertDate, start, end, orderByComparator };
		}

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFForniture esfForniture : list) {
				if (!Validator.equals(insertDate, esfForniture.getInsertDate())) {
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

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			boolean bindInsertDate = false;

			if (insertDate == null) {
				query.append(_FINDER_COLUMN_INSERTDATE_INSERTDATE_1);
			}
			else {
				bindInsertDate = true;

				query.append(_FINDER_COLUMN_INSERTDATE_INSERTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindInsertDate) {
					qPos.add(CalendarUtil.getTimestamp(insertDate));
				}

				if (!pagination) {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f forniture in the ordered set where insertDate = &#63;.
	 *
	 * @param insertDate the insert date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByInsertDate_First(Date insertDate,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByInsertDate_First(insertDate,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("insertDate=");
		msg.append(insertDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture in the ordered set where insertDate = &#63;.
	 *
	 * @param insertDate the insert date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByInsertDate_First(Date insertDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFForniture> list = findByInsertDate(insertDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture in the ordered set where insertDate = &#63;.
	 *
	 * @param insertDate the insert date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByInsertDate_Last(Date insertDate,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByInsertDate_Last(insertDate,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("insertDate=");
		msg.append(insertDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture in the ordered set where insertDate = &#63;.
	 *
	 * @param insertDate the insert date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByInsertDate_Last(Date insertDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByInsertDate(insertDate);

		if (count == 0) {
			return null;
		}

		List<ESFForniture> list = findByInsertDate(insertDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fornitures before and after the current e s f forniture in the ordered set where insertDate = &#63;.
	 *
	 * @param esfFornitureId the primary key of the current e s f forniture
	 * @param insertDate the insert date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture[] findByInsertDate_PrevAndNext(long esfFornitureId,
		Date insertDate, OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByPrimaryKey(esfFornitureId);

		Session session = null;

		try {
			session = openSession();

			ESFForniture[] array = new ESFFornitureImpl[3];

			array[0] = getByInsertDate_PrevAndNext(session, esfForniture,
					insertDate, orderByComparator, true);

			array[1] = esfForniture;

			array[2] = getByInsertDate_PrevAndNext(session, esfForniture,
					insertDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFForniture getByInsertDate_PrevAndNext(Session session,
		ESFForniture esfForniture, Date insertDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

		boolean bindInsertDate = false;

		if (insertDate == null) {
			query.append(_FINDER_COLUMN_INSERTDATE_INSERTDATE_1);
		}
		else {
			bindInsertDate = true;

			query.append(_FINDER_COLUMN_INSERTDATE_INSERTDATE_2);
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
			query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindInsertDate) {
			qPos.add(CalendarUtil.getTimestamp(insertDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfForniture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFForniture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fornitures where insertDate = &#63; from the database.
	 *
	 * @param insertDate the insert date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByInsertDate(Date insertDate) throws SystemException {
		for (ESFForniture esfForniture : findByInsertDate(insertDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures where insertDate = &#63;.
	 *
	 * @param insertDate the insert date
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInsertDate(Date insertDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSERTDATE;

		Object[] finderArgs = new Object[] { insertDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			boolean bindInsertDate = false;

			if (insertDate == null) {
				query.append(_FINDER_COLUMN_INSERTDATE_INSERTDATE_1);
			}
			else {
				bindInsertDate = true;

				query.append(_FINDER_COLUMN_INSERTDATE_INSERTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindInsertDate) {
					qPos.add(CalendarUtil.getTimestamp(insertDate));
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

	private static final String _FINDER_COLUMN_INSERTDATE_INSERTDATE_1 = "esfForniture.insertDate IS NULL";
	private static final String _FINDER_COLUMN_INSERTDATE_INSERTDATE_2 = "esfForniture.insertDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMBERFORNITURES =
		new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNumberFornitures",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBERFORNITURES =
		new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNumberFornitures", new String[] { Long.class.getName() },
			ESFFornitureModelImpl.NUMBERFORNITURES_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBERFORNITURES = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNumberFornitures", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f fornitures where numberFornitures = &#63;.
	 *
	 * @param numberFornitures the number fornitures
	 * @return the matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByNumberFornitures(long numberFornitures)
		throws SystemException {
		return findByNumberFornitures(numberFornitures, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures where numberFornitures = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numberFornitures the number fornitures
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByNumberFornitures(long numberFornitures,
		int start, int end) throws SystemException {
		return findByNumberFornitures(numberFornitures, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures where numberFornitures = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numberFornitures the number fornitures
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByNumberFornitures(long numberFornitures,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBERFORNITURES;
			finderArgs = new Object[] { numberFornitures };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMBERFORNITURES;
			finderArgs = new Object[] {
					numberFornitures,
					
					start, end, orderByComparator
				};
		}

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFForniture esfForniture : list) {
				if ((numberFornitures != esfForniture.getNumberFornitures())) {
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

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			query.append(_FINDER_COLUMN_NUMBERFORNITURES_NUMBERFORNITURES_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberFornitures);

				if (!pagination) {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f forniture in the ordered set where numberFornitures = &#63;.
	 *
	 * @param numberFornitures the number fornitures
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByNumberFornitures_First(long numberFornitures,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByNumberFornitures_First(numberFornitures,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numberFornitures=");
		msg.append(numberFornitures);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture in the ordered set where numberFornitures = &#63;.
	 *
	 * @param numberFornitures the number fornitures
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByNumberFornitures_First(long numberFornitures,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFForniture> list = findByNumberFornitures(numberFornitures, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture in the ordered set where numberFornitures = &#63;.
	 *
	 * @param numberFornitures the number fornitures
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByNumberFornitures_Last(long numberFornitures,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByNumberFornitures_Last(numberFornitures,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numberFornitures=");
		msg.append(numberFornitures);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture in the ordered set where numberFornitures = &#63;.
	 *
	 * @param numberFornitures the number fornitures
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByNumberFornitures_Last(long numberFornitures,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNumberFornitures(numberFornitures);

		if (count == 0) {
			return null;
		}

		List<ESFForniture> list = findByNumberFornitures(numberFornitures,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fornitures before and after the current e s f forniture in the ordered set where numberFornitures = &#63;.
	 *
	 * @param esfFornitureId the primary key of the current e s f forniture
	 * @param numberFornitures the number fornitures
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture[] findByNumberFornitures_PrevAndNext(
		long esfFornitureId, long numberFornitures,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = findByPrimaryKey(esfFornitureId);

		Session session = null;

		try {
			session = openSession();

			ESFForniture[] array = new ESFFornitureImpl[3];

			array[0] = getByNumberFornitures_PrevAndNext(session, esfForniture,
					numberFornitures, orderByComparator, true);

			array[1] = esfForniture;

			array[2] = getByNumberFornitures_PrevAndNext(session, esfForniture,
					numberFornitures, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFForniture getByNumberFornitures_PrevAndNext(Session session,
		ESFForniture esfForniture, long numberFornitures,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

		query.append(_FINDER_COLUMN_NUMBERFORNITURES_NUMBERFORNITURES_2);

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
			query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(numberFornitures);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfForniture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFForniture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fornitures where numberFornitures = &#63; from the database.
	 *
	 * @param numberFornitures the number fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNumberFornitures(long numberFornitures)
		throws SystemException {
		for (ESFForniture esfForniture : findByNumberFornitures(
				numberFornitures, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures where numberFornitures = &#63;.
	 *
	 * @param numberFornitures the number fornitures
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNumberFornitures(long numberFornitures)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMBERFORNITURES;

		Object[] finderArgs = new Object[] { numberFornitures };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			query.append(_FINDER_COLUMN_NUMBERFORNITURES_NUMBERFORNITURES_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberFornitures);

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

	private static final String _FINDER_COLUMN_NUMBERFORNITURES_NUMBERFORNITURES_2 =
		"esfForniture.numberFornitures = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_G = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, ESFFornitureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFFornitureModelImpl.ESFFORNITUREID_COLUMN_BITMASK |
			ESFFornitureModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_G = new FinderPath(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @return the matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByT_G(long esfFornitureId, long groupId)
		throws SystemException {
		return findByT_G(esfFornitureId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByT_G(long esfFornitureId, long groupId,
		int start, int end) throws SystemException {
		return findByT_G(esfFornitureId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findByT_G(long esfFornitureId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G;
			finderArgs = new Object[] { esfFornitureId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_G;
			finderArgs = new Object[] {
					esfFornitureId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFForniture esfForniture : list) {
				if ((esfFornitureId != esfForniture.getEsfFornitureId()) ||
						(groupId != esfForniture.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFFORNITURE_WHERE);

			query.append(_FINDER_COLUMN_T_G_ESFFORNITUREID_2);

			query.append(_FINDER_COLUMN_T_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFornitureId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByT_G_First(long esfFornitureId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByT_G_First(esfFornitureId, groupId,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfFornitureId=");
		msg.append(esfFornitureId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByT_G_First(long esfFornitureId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFForniture> list = findByT_G(esfFornitureId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByT_G_Last(long esfFornitureId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByT_G_Last(esfFornitureId, groupId,
				orderByComparator);

		if (esfForniture != null) {
			return esfForniture;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfFornitureId=");
		msg.append(esfFornitureId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByT_G_Last(long esfFornitureId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_G(esfFornitureId, groupId);

		if (count == 0) {
			return null;
		}

		List<ESFForniture> list = findByT_G(esfFornitureId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63; from the database.
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_G(long esfFornitureId, long groupId)
		throws SystemException {
		for (ESFForniture esfForniture : findByT_G(esfFornitureId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	 *
	 * @param esfFornitureId the esf forniture ID
	 * @param groupId the group ID
	 * @return the number of matching e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_G(long esfFornitureId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_G;

		Object[] finderArgs = new Object[] { esfFornitureId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFFORNITURE_WHERE);

			query.append(_FINDER_COLUMN_T_G_ESFFORNITUREID_2);

			query.append(_FINDER_COLUMN_T_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFornitureId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_T_G_ESFFORNITUREID_2 = "esfForniture.esfFornitureId = ? AND ";
	private static final String _FINDER_COLUMN_T_G_GROUPID_2 = "esfForniture.groupId = ?";

	public ESFForniturePersistenceImpl() {
		setModelClass(ESFForniture.class);
	}

	/**
	 * Caches the e s f forniture in the entity cache if it is enabled.
	 *
	 * @param esfForniture the e s f forniture
	 */
	@Override
	public void cacheResult(ESFForniture esfForniture) {
		EntityCacheUtil.putResult(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureImpl.class, esfForniture.getPrimaryKey(), esfForniture);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfForniture.getUuid(), esfForniture.getGroupId() },
			esfForniture);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfForniture.getCode() }, esfForniture);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRIPTION,
			new Object[] { esfForniture.getDescription() }, esfForniture);

		esfForniture.resetOriginalValues();
	}

	/**
	 * Caches the e s f fornitures in the entity cache if it is enabled.
	 *
	 * @param esfFornitures the e s f fornitures
	 */
	@Override
	public void cacheResult(List<ESFForniture> esfFornitures) {
		for (ESFForniture esfForniture : esfFornitures) {
			if (EntityCacheUtil.getResult(
						ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
						ESFFornitureImpl.class, esfForniture.getPrimaryKey()) == null) {
				cacheResult(esfForniture);
			}
			else {
				esfForniture.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f fornitures.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFornitureImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFornitureImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f forniture.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFForniture esfForniture) {
		EntityCacheUtil.removeResult(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureImpl.class, esfForniture.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfForniture);
	}

	@Override
	public void clearCache(List<ESFForniture> esfFornitures) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFForniture esfForniture : esfFornitures) {
			EntityCacheUtil.removeResult(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
				ESFFornitureImpl.class, esfForniture.getPrimaryKey());

			clearUniqueFindersCache(esfForniture);
		}
	}

	protected void cacheUniqueFindersCache(ESFForniture esfForniture) {
		if (esfForniture.isNew()) {
			Object[] args = new Object[] {
					esfForniture.getUuid(), esfForniture.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfForniture);

			args = new Object[] { esfForniture.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
				esfForniture);

			args = new Object[] { esfForniture.getDescription() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRIPTION, args,
				esfForniture);
		}
		else {
			ESFFornitureModelImpl esfFornitureModelImpl = (ESFFornitureModelImpl)esfForniture;

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfForniture.getUuid(), esfForniture.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfForniture);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfForniture.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfForniture);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfForniture.getDescription() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRIPTION,
					args, esfForniture);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFForniture esfForniture) {
		ESFFornitureModelImpl esfFornitureModelImpl = (ESFFornitureModelImpl)esfForniture;

		Object[] args = new Object[] {
				esfForniture.getUuid(), esfForniture.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfFornitureModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfFornitureModelImpl.getOriginalUuid(),
					esfFornitureModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { esfForniture.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfFornitureModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfFornitureModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}

		args = new Object[] { esfForniture.getDescription() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESCRIPTION, args);

		if ((esfFornitureModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DESCRIPTION.getColumnBitmask()) != 0) {
			args = new Object[] { esfFornitureModelImpl.getOriginalDescription() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESCRIPTION, args);
		}
	}

	/**
	 * Creates a new e s f forniture with the primary key. Does not add the e s f forniture to the database.
	 *
	 * @param esfFornitureId the primary key for the new e s f forniture
	 * @return the new e s f forniture
	 */
	@Override
	public ESFForniture create(long esfFornitureId) {
		ESFForniture esfForniture = new ESFFornitureImpl();

		esfForniture.setNew(true);
		esfForniture.setPrimaryKey(esfFornitureId);

		String uuid = PortalUUIDUtil.generate();

		esfForniture.setUuid(uuid);

		return esfForniture;
	}

	/**
	 * Removes the e s f forniture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFornitureId the primary key of the e s f forniture
	 * @return the e s f forniture that was removed
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture remove(long esfFornitureId)
		throws NoSuchFornitureException, SystemException {
		return remove((Serializable)esfFornitureId);
	}

	/**
	 * Removes the e s f forniture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f forniture
	 * @return the e s f forniture that was removed
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture remove(Serializable primaryKey)
		throws NoSuchFornitureException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFForniture esfForniture = (ESFForniture)session.get(ESFFornitureImpl.class,
					primaryKey);

			if (esfForniture == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFornitureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfForniture);
		}
		catch (NoSuchFornitureException nsee) {
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
	protected ESFForniture removeImpl(ESFForniture esfForniture)
		throws SystemException {
		esfForniture = toUnwrappedModel(esfForniture);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfForniture)) {
				esfForniture = (ESFForniture)session.get(ESFFornitureImpl.class,
						esfForniture.getPrimaryKeyObj());
			}

			if (esfForniture != null) {
				session.delete(esfForniture);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfForniture != null) {
			clearCache(esfForniture);
		}

		return esfForniture;
	}

	@Override
	public ESFForniture updateImpl(
		it.ethica.esf.model.ESFForniture esfForniture)
		throws SystemException {
		esfForniture = toUnwrappedModel(esfForniture);

		boolean isNew = esfForniture.isNew();

		ESFFornitureModelImpl esfFornitureModelImpl = (ESFFornitureModelImpl)esfForniture;

		if (Validator.isNull(esfForniture.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfForniture.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfForniture.isNew()) {
				session.save(esfForniture);

				esfForniture.setNew(false);
			}
			else {
				session.merge(esfForniture);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFFornitureModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfFornitureModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureModelImpl.getOriginalUuid(),
						esfFornitureModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfFornitureModelImpl.getUuid(),
						esfFornitureModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfFornitureModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { esfFornitureModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { esfFornitureModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSERTDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureModelImpl.getOriginalInsertDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSERTDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSERTDATE,
					args);

				args = new Object[] { esfFornitureModelImpl.getInsertDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSERTDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSERTDATE,
					args);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBERFORNITURES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureModelImpl.getOriginalNumberFornitures()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBERFORNITURES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBERFORNITURES,
					args);

				args = new Object[] { esfFornitureModelImpl.getNumberFornitures() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBERFORNITURES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBERFORNITURES,
					args);
			}

			if ((esfFornitureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureModelImpl.getOriginalEsfFornitureId(),
						esfFornitureModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G,
					args);

				args = new Object[] {
						esfFornitureModelImpl.getEsfFornitureId(),
						esfFornitureModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureImpl.class, esfForniture.getPrimaryKey(), esfForniture);

		clearUniqueFindersCache(esfForniture);
		cacheUniqueFindersCache(esfForniture);

		return esfForniture;
	}

	protected ESFForniture toUnwrappedModel(ESFForniture esfForniture) {
		if (esfForniture instanceof ESFFornitureImpl) {
			return esfForniture;
		}

		ESFFornitureImpl esfFornitureImpl = new ESFFornitureImpl();

		esfFornitureImpl.setNew(esfForniture.isNew());
		esfFornitureImpl.setPrimaryKey(esfForniture.getPrimaryKey());

		esfFornitureImpl.setUuid(esfForniture.getUuid());
		esfFornitureImpl.setEsfFornitureId(esfForniture.getEsfFornitureId());
		esfFornitureImpl.setGroupId(esfForniture.getGroupId());
		esfFornitureImpl.setCompanyId(esfForniture.getCompanyId());
		esfFornitureImpl.setUserId(esfForniture.getUserId());
		esfFornitureImpl.setUserName(esfForniture.getUserName());
		esfFornitureImpl.setCreateDate(esfForniture.getCreateDate());
		esfFornitureImpl.setModifiedDate(esfForniture.getModifiedDate());
		esfFornitureImpl.setCode(esfForniture.getCode());
		esfFornitureImpl.setName(esfForniture.getName());
		esfFornitureImpl.setDescription(esfForniture.getDescription());
		esfFornitureImpl.setType(esfForniture.getType());
		esfFornitureImpl.setInsertDate(esfForniture.getInsertDate());
		esfFornitureImpl.setNumberFornitures(esfForniture.getNumberFornitures());
		esfFornitureImpl.setSize(esfForniture.getSize());

		return esfFornitureImpl;
	}

	/**
	 * Returns the e s f forniture with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f forniture
	 * @return the e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFornitureException, SystemException {
		ESFForniture esfForniture = fetchByPrimaryKey(primaryKey);

		if (esfForniture == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFornitureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfForniture;
	}

	/**
	 * Returns the e s f forniture with the primary key or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	 *
	 * @param esfFornitureId the primary key of the e s f forniture
	 * @return the e s f forniture
	 * @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture findByPrimaryKey(long esfFornitureId)
		throws NoSuchFornitureException, SystemException {
		return findByPrimaryKey((Serializable)esfFornitureId);
	}

	/**
	 * Returns the e s f forniture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f forniture
	 * @return the e s f forniture, or <code>null</code> if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFForniture esfForniture = (ESFForniture)EntityCacheUtil.getResult(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
				ESFFornitureImpl.class, primaryKey);

		if (esfForniture == _nullESFForniture) {
			return null;
		}

		if (esfForniture == null) {
			Session session = null;

			try {
				session = openSession();

				esfForniture = (ESFForniture)session.get(ESFFornitureImpl.class,
						primaryKey);

				if (esfForniture != null) {
					cacheResult(esfForniture);
				}
				else {
					EntityCacheUtil.putResult(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
						ESFFornitureImpl.class, primaryKey, _nullESFForniture);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFornitureModelImpl.ENTITY_CACHE_ENABLED,
					ESFFornitureImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfForniture;
	}

	/**
	 * Returns the e s f forniture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFornitureId the primary key of the e s f forniture
	 * @return the e s f forniture, or <code>null</code> if a e s f forniture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFForniture fetchByPrimaryKey(long esfFornitureId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFornitureId);
	}

	/**
	 * Returns all the e s f fornitures.
	 *
	 * @return the e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fornitures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @return the range of e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fornitures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f fornitures
	 * @param end the upper bound of the range of e s f fornitures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f fornitures
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFForniture> findAll(int start, int end,
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

		List<ESFForniture> list = (List<ESFForniture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFORNITURE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFORNITURE;

				if (pagination) {
					sql = sql.concat(ESFFornitureModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFForniture>(list);
				}
				else {
					list = (List<ESFForniture>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f fornitures from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFForniture esfForniture : findAll()) {
			remove(esfForniture);
		}
	}

	/**
	 * Returns the number of e s f fornitures.
	 *
	 * @return the number of e s f fornitures
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

				Query q = session.createQuery(_SQL_COUNT_ESFFORNITURE);

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
	 * Initializes the e s f forniture persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFForniture")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFForniture>> listenersList = new ArrayList<ModelListener<ESFForniture>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFForniture>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFornitureImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFORNITURE = "SELECT esfForniture FROM ESFForniture esfForniture";
	private static final String _SQL_SELECT_ESFFORNITURE_WHERE = "SELECT esfForniture FROM ESFForniture esfForniture WHERE ";
	private static final String _SQL_COUNT_ESFFORNITURE = "SELECT COUNT(esfForniture) FROM ESFForniture esfForniture";
	private static final String _SQL_COUNT_ESFFORNITURE_WHERE = "SELECT COUNT(esfForniture) FROM ESFForniture esfForniture WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfForniture.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFForniture exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFForniture exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFForniturePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code", "type", "size"
			});
	private static ESFForniture _nullESFForniture = new ESFFornitureImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFForniture> toCacheModel() {
				return _nullESFFornitureCacheModel;
			}
		};

	private static CacheModel<ESFForniture> _nullESFFornitureCacheModel = new CacheModel<ESFForniture>() {
			@Override
			public ESFForniture toEntityModel() {
				return _nullESFForniture;
			}
		};
}