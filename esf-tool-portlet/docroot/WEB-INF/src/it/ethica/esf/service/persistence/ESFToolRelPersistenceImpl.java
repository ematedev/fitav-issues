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

import it.ethica.esf.NoSuchToolRelException;
import it.ethica.esf.model.ESFToolRel;
import it.ethica.esf.model.impl.ESFToolRelImpl;
import it.ethica.esf.model.impl.ESFToolRelModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f tool rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFToolRelPersistence
 * @see ESFToolRelUtil
 * @generated
 */
public class ESFToolRelPersistenceImpl extends BasePersistenceImpl<ESFToolRel>
	implements ESFToolRelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFToolRelUtil} to access the e s f tool rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFToolRelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFToolRelModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f tool rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tool rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @return the range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tool rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByUuid(String uuid, int start, int end,
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

		List<ESFToolRel> list = (List<ESFToolRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFToolRel esfToolRel : list) {
				if (!Validator.equals(uuid, esfToolRel.getUuid())) {
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

			query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

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
				query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFToolRel>(list);
				}
				else {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByUuid_First(uuid, orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the first e s f tool rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFToolRel> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByUuid_Last(uuid, orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFToolRel> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where uuid = &#63;.
	 *
	 * @param esfToolRelPK the primary key of the current e s f tool rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel[] findByUuid_PrevAndNext(ESFToolRelPK esfToolRelPK,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = findByPrimaryKey(esfToolRelPK);

		Session session = null;

		try {
			session = openSession();

			ESFToolRel[] array = new ESFToolRelImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfToolRel, uuid,
					orderByComparator, true);

			array[1] = esfToolRel;

			array[2] = getByUuid_PrevAndNext(session, esfToolRel, uuid,
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

	protected ESFToolRel getByUuid_PrevAndNext(Session session,
		ESFToolRel esfToolRel, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

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
			query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfToolRel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFToolRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tool rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFToolRel esfToolRel : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfToolRel);
		}
	}

	/**
	 * Returns the number of e s f tool rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f tool rels
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

			query.append(_SQL_COUNT_ESFTOOLREL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfToolRel.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfToolRel.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfToolRel.uuid IS NULL OR esfToolRel.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFToolRelModelImpl.UUID_COLUMN_BITMASK |
			ESFToolRelModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f tool rel where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchToolRelException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByUUID_G(String uuid, long groupId)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByUUID_G(uuid, groupId);

		if (esfToolRel == null) {
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

			throw new NoSuchToolRelException(msg.toString());
		}

		return esfToolRel;
	}

	/**
	 * Returns the e s f tool rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f tool rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFToolRel) {
			ESFToolRel esfToolRel = (ESFToolRel)result;

			if (!Validator.equals(uuid, esfToolRel.getUuid()) ||
					(groupId != esfToolRel.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

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

				List<ESFToolRel> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFToolRel esfToolRel = list.get(0);

					result = esfToolRel;

					cacheResult(esfToolRel);

					if ((esfToolRel.getUuid() == null) ||
							!esfToolRel.getUuid().equals(uuid) ||
							(esfToolRel.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfToolRel);
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
			return (ESFToolRel)result;
		}
	}

	/**
	 * Removes the e s f tool rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f tool rel that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = findByUUID_G(uuid, groupId);

		return remove(esfToolRel);
	}

	/**
	 * Returns the number of e s f tool rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f tool rels
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

			query.append(_SQL_COUNT_ESFTOOLREL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfToolRel.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfToolRel.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfToolRel.uuid IS NULL OR esfToolRel.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfToolRel.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFToolRelModelImpl.UUID_COLUMN_BITMASK |
			ESFToolRelModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f tool rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tool rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @return the range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tool rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByUuid_C(String uuid, long companyId,
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

		List<ESFToolRel> list = (List<ESFToolRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFToolRel esfToolRel : list) {
				if (!Validator.equals(uuid, esfToolRel.getUuid()) ||
						(companyId != esfToolRel.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

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
				query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFToolRel>(list);
				}
				else {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the first e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFToolRel> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFToolRel> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfToolRelPK the primary key of the current e s f tool rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel[] findByUuid_C_PrevAndNext(ESFToolRelPK esfToolRelPK,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = findByPrimaryKey(esfToolRelPK);

		Session session = null;

		try {
			session = openSession();

			ESFToolRel[] array = new ESFToolRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfToolRel, uuid,
					companyId, orderByComparator, true);

			array[1] = esfToolRel;

			array[2] = getByUuid_C_PrevAndNext(session, esfToolRel, uuid,
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

	protected ESFToolRel getByUuid_C_PrevAndNext(Session session,
		ESFToolRel esfToolRel, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

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
			query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfToolRel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFToolRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tool rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFToolRel esfToolRel : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfToolRel);
		}
	}

	/**
	 * Returns the number of e s f tool rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f tool rels
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

			query.append(_SQL_COUNT_ESFTOOLREL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfToolRel.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfToolRel.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfToolRel.uuid IS NULL OR esfToolRel.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfToolRel.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTOOLID =
		new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFToolId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID =
		new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFToolId",
			new String[] { Long.class.getName() },
			ESFToolRelModelImpl.ESFTOOLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFTOOLID = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFToolId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f tool rels where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @return the matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByESFToolId(long esfToolId)
		throws SystemException {
		return findByESFToolId(esfToolId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f tool rels where esfToolId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfToolId the esf tool ID
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @return the range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByESFToolId(long esfToolId, int start, int end)
		throws SystemException {
		return findByESFToolId(esfToolId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tool rels where esfToolId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfToolId the esf tool ID
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByESFToolId(long esfToolId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID;
			finderArgs = new Object[] { esfToolId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTOOLID;
			finderArgs = new Object[] { esfToolId, start, end, orderByComparator };
		}

		List<ESFToolRel> list = (List<ESFToolRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFToolRel esfToolRel : list) {
				if ((esfToolId != esfToolRel.getEsfToolId())) {
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

			query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

			query.append(_FINDER_COLUMN_ESFTOOLID_ESFTOOLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfToolId);

				if (!pagination) {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFToolRel>(list);
				}
				else {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByESFToolId_First(long esfToolId,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByESFToolId_First(esfToolId,
				orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfToolId=");
		msg.append(esfToolId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the first e s f tool rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByESFToolId_First(long esfToolId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFToolRel> list = findByESFToolId(esfToolId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByESFToolId_Last(long esfToolId,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByESFToolId_Last(esfToolId,
				orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfToolId=");
		msg.append(esfToolId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByESFToolId_Last(long esfToolId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFToolId(esfToolId);

		if (count == 0) {
			return null;
		}

		List<ESFToolRel> list = findByESFToolId(esfToolId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolRelPK the primary key of the current e s f tool rel
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel[] findByESFToolId_PrevAndNext(ESFToolRelPK esfToolRelPK,
		long esfToolId, OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = findByPrimaryKey(esfToolRelPK);

		Session session = null;

		try {
			session = openSession();

			ESFToolRel[] array = new ESFToolRelImpl[3];

			array[0] = getByESFToolId_PrevAndNext(session, esfToolRel,
					esfToolId, orderByComparator, true);

			array[1] = esfToolRel;

			array[2] = getByESFToolId_PrevAndNext(session, esfToolRel,
					esfToolId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFToolRel getByESFToolId_PrevAndNext(Session session,
		ESFToolRel esfToolRel, long esfToolId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

		query.append(_FINDER_COLUMN_ESFTOOLID_ESFTOOLID_2);

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
			query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfToolId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfToolRel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFToolRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tool rels where esfToolId = &#63; from the database.
	 *
	 * @param esfToolId the esf tool ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFToolId(long esfToolId) throws SystemException {
		for (ESFToolRel esfToolRel : findByESFToolId(esfToolId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfToolRel);
		}
	}

	/**
	 * Returns the number of e s f tool rels where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @return the number of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFToolId(long esfToolId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFTOOLID;

		Object[] finderArgs = new Object[] { esfToolId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFTOOLREL_WHERE);

			query.append(_FINDER_COLUMN_ESFTOOLID_ESFTOOLID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfToolId);

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

	private static final String _FINDER_COLUMN_ESFTOOLID_ESFTOOLID_2 = "esfToolRel.id.esfToolId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_N_P = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByN_P",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByN_P",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFToolRelModelImpl.CLASSNAME_COLUMN_BITMASK |
			ESFToolRelModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_N_P = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_P",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f tool rels where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByN_P(String className, long classPK)
		throws SystemException {
		return findByN_P(className, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tool rels where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @return the range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByN_P(String className, long classPK,
		int start, int end) throws SystemException {
		return findByN_P(className, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tool rels where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByN_P(String className, long classPK,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P;
			finderArgs = new Object[] { className, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_N_P;
			finderArgs = new Object[] {
					className, classPK,
					
					start, end, orderByComparator
				};
		}

		List<ESFToolRel> list = (List<ESFToolRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFToolRel esfToolRel : list) {
				if (!Validator.equals(className, esfToolRel.getClassName()) ||
						(classPK != esfToolRel.getClassPK())) {
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

			query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_N_P_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_P_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_N_P_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_N_P_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (!pagination) {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFToolRel>(list);
				}
				else {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByN_P_First(String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByN_P_First(className, classPK,
				orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the first e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByN_P_First(String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFToolRel> list = findByN_P(className, classPK, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByN_P_Last(String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByN_P_Last(className, classPK,
				orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByN_P_Last(String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByN_P(className, classPK);

		if (count == 0) {
			return null;
		}

		List<ESFToolRel> list = findByN_P(className, classPK, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param esfToolRelPK the primary key of the current e s f tool rel
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel[] findByN_P_PrevAndNext(ESFToolRelPK esfToolRelPK,
		String className, long classPK, OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = findByPrimaryKey(esfToolRelPK);

		Session session = null;

		try {
			session = openSession();

			ESFToolRel[] array = new ESFToolRelImpl[3];

			array[0] = getByN_P_PrevAndNext(session, esfToolRel, className,
					classPK, orderByComparator, true);

			array[1] = esfToolRel;

			array[2] = getByN_P_PrevAndNext(session, esfToolRel, className,
					classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFToolRel getByN_P_PrevAndNext(Session session,
		ESFToolRel esfToolRel, String className, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_N_P_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_N_P_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_N_P_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_N_P_CLASSPK_2);

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
			query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfToolRel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFToolRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tool rels where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByN_P(String className, long classPK)
		throws SystemException {
		for (ESFToolRel esfToolRel : findByN_P(className, classPK,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfToolRel);
		}
	}

	/**
	 * Returns the number of e s f tool rels where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByN_P(String className, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_N_P;

		Object[] finderArgs = new Object[] { className, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFTOOLREL_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_N_P_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_P_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_N_P_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_N_P_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_N_P_CLASSNAME_1 = "esfToolRel.id.className IS NULL AND ";
	private static final String _FINDER_COLUMN_N_P_CLASSNAME_2 = "esfToolRel.id.className = ? AND ";
	private static final String _FINDER_COLUMN_N_P_CLASSNAME_3 = "(esfToolRel.id.className IS NULL OR esfToolRel.id.className = '') AND ";
	private static final String _FINDER_COLUMN_N_P_CLASSPK_2 = "esfToolRel.id.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSIGNMENTDATE =
		new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAssignmentDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE =
		new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, ESFToolRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAssignmentDate",
			new String[] { Date.class.getName() },
			ESFToolRelModelImpl.ASSIGNMENTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSIGNMENTDATE = new FinderPath(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAssignmentDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the e s f tool rels where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @return the matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByAssignmentDate(Date assignmentDate)
		throws SystemException {
		return findByAssignmentDate(assignmentDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tool rels where assignmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assignmentDate the assignment date
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @return the range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByAssignmentDate(Date assignmentDate,
		int start, int end) throws SystemException {
		return findByAssignmentDate(assignmentDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tool rels where assignmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assignmentDate the assignment date
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findByAssignmentDate(Date assignmentDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE;
			finderArgs = new Object[] { assignmentDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSIGNMENTDATE;
			finderArgs = new Object[] {
					assignmentDate,
					
					start, end, orderByComparator
				};
		}

		List<ESFToolRel> list = (List<ESFToolRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFToolRel esfToolRel : list) {
				if (!Validator.equals(assignmentDate,
							esfToolRel.getAssignmentDate())) {
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

			query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

			boolean bindAssignmentDate = false;

			if (assignmentDate == null) {
				query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_1);
			}
			else {
				bindAssignmentDate = true;

				query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssignmentDate) {
					qPos.add(CalendarUtil.getTimestamp(assignmentDate));
				}

				if (!pagination) {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFToolRel>(list);
				}
				else {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByAssignmentDate_First(Date assignmentDate,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByAssignmentDate_First(assignmentDate,
				orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assignmentDate=");
		msg.append(assignmentDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the first e s f tool rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByAssignmentDate_First(Date assignmentDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFToolRel> list = findByAssignmentDate(assignmentDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByAssignmentDate_Last(Date assignmentDate,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByAssignmentDate_Last(assignmentDate,
				orderByComparator);

		if (esfToolRel != null) {
			return esfToolRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assignmentDate=");
		msg.append(assignmentDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolRelException(msg.toString());
	}

	/**
	 * Returns the last e s f tool rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByAssignmentDate_Last(Date assignmentDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAssignmentDate(assignmentDate);

		if (count == 0) {
			return null;
		}

		List<ESFToolRel> list = findByAssignmentDate(assignmentDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param esfToolRelPK the primary key of the current e s f tool rel
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel[] findByAssignmentDate_PrevAndNext(
		ESFToolRelPK esfToolRelPK, Date assignmentDate,
		OrderByComparator orderByComparator)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = findByPrimaryKey(esfToolRelPK);

		Session session = null;

		try {
			session = openSession();

			ESFToolRel[] array = new ESFToolRelImpl[3];

			array[0] = getByAssignmentDate_PrevAndNext(session, esfToolRel,
					assignmentDate, orderByComparator, true);

			array[1] = esfToolRel;

			array[2] = getByAssignmentDate_PrevAndNext(session, esfToolRel,
					assignmentDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFToolRel getByAssignmentDate_PrevAndNext(Session session,
		ESFToolRel esfToolRel, Date assignmentDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOLREL_WHERE);

		boolean bindAssignmentDate = false;

		if (assignmentDate == null) {
			query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_1);
		}
		else {
			bindAssignmentDate = true;

			query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_2);
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
			query.append(ESFToolRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAssignmentDate) {
			qPos.add(CalendarUtil.getTimestamp(assignmentDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfToolRel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFToolRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tool rels where assignmentDate = &#63; from the database.
	 *
	 * @param assignmentDate the assignment date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAssignmentDate(Date assignmentDate)
		throws SystemException {
		for (ESFToolRel esfToolRel : findByAssignmentDate(assignmentDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfToolRel);
		}
	}

	/**
	 * Returns the number of e s f tool rels where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @return the number of matching e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAssignmentDate(Date assignmentDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSIGNMENTDATE;

		Object[] finderArgs = new Object[] { assignmentDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFTOOLREL_WHERE);

			boolean bindAssignmentDate = false;

			if (assignmentDate == null) {
				query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_1);
			}
			else {
				bindAssignmentDate = true;

				query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssignmentDate) {
					qPos.add(CalendarUtil.getTimestamp(assignmentDate));
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

	private static final String _FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_1 = "esfToolRel.assignmentDate IS NULL";
	private static final String _FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_2 = "esfToolRel.assignmentDate = ?";

	public ESFToolRelPersistenceImpl() {
		setModelClass(ESFToolRel.class);
	}

	/**
	 * Caches the e s f tool rel in the entity cache if it is enabled.
	 *
	 * @param esfToolRel the e s f tool rel
	 */
	@Override
	public void cacheResult(ESFToolRel esfToolRel) {
		EntityCacheUtil.putResult(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelImpl.class, esfToolRel.getPrimaryKey(), esfToolRel);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfToolRel.getUuid(), esfToolRel.getGroupId() },
			esfToolRel);

		esfToolRel.resetOriginalValues();
	}

	/**
	 * Caches the e s f tool rels in the entity cache if it is enabled.
	 *
	 * @param esfToolRels the e s f tool rels
	 */
	@Override
	public void cacheResult(List<ESFToolRel> esfToolRels) {
		for (ESFToolRel esfToolRel : esfToolRels) {
			if (EntityCacheUtil.getResult(
						ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
						ESFToolRelImpl.class, esfToolRel.getPrimaryKey()) == null) {
				cacheResult(esfToolRel);
			}
			else {
				esfToolRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f tool rels.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFToolRelImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFToolRelImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f tool rel.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFToolRel esfToolRel) {
		EntityCacheUtil.removeResult(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelImpl.class, esfToolRel.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfToolRel);
	}

	@Override
	public void clearCache(List<ESFToolRel> esfToolRels) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFToolRel esfToolRel : esfToolRels) {
			EntityCacheUtil.removeResult(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
				ESFToolRelImpl.class, esfToolRel.getPrimaryKey());

			clearUniqueFindersCache(esfToolRel);
		}
	}

	protected void cacheUniqueFindersCache(ESFToolRel esfToolRel) {
		if (esfToolRel.isNew()) {
			Object[] args = new Object[] {
					esfToolRel.getUuid(), esfToolRel.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfToolRel);
		}
		else {
			ESFToolRelModelImpl esfToolRelModelImpl = (ESFToolRelModelImpl)esfToolRel;

			if ((esfToolRelModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolRel.getUuid(), esfToolRel.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfToolRel);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFToolRel esfToolRel) {
		ESFToolRelModelImpl esfToolRelModelImpl = (ESFToolRelModelImpl)esfToolRel;

		Object[] args = new Object[] {
				esfToolRel.getUuid(), esfToolRel.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfToolRelModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfToolRelModelImpl.getOriginalUuid(),
					esfToolRelModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f tool rel with the primary key. Does not add the e s f tool rel to the database.
	 *
	 * @param esfToolRelPK the primary key for the new e s f tool rel
	 * @return the new e s f tool rel
	 */
	@Override
	public ESFToolRel create(ESFToolRelPK esfToolRelPK) {
		ESFToolRel esfToolRel = new ESFToolRelImpl();

		esfToolRel.setNew(true);
		esfToolRel.setPrimaryKey(esfToolRelPK);

		String uuid = PortalUUIDUtil.generate();

		esfToolRel.setUuid(uuid);

		return esfToolRel;
	}

	/**
	 * Removes the e s f tool rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfToolRelPK the primary key of the e s f tool rel
	 * @return the e s f tool rel that was removed
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel remove(ESFToolRelPK esfToolRelPK)
		throws NoSuchToolRelException, SystemException {
		return remove((Serializable)esfToolRelPK);
	}

	/**
	 * Removes the e s f tool rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f tool rel
	 * @return the e s f tool rel that was removed
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel remove(Serializable primaryKey)
		throws NoSuchToolRelException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFToolRel esfToolRel = (ESFToolRel)session.get(ESFToolRelImpl.class,
					primaryKey);

			if (esfToolRel == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchToolRelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfToolRel);
		}
		catch (NoSuchToolRelException nsee) {
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
	protected ESFToolRel removeImpl(ESFToolRel esfToolRel)
		throws SystemException {
		esfToolRel = toUnwrappedModel(esfToolRel);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfToolRel)) {
				esfToolRel = (ESFToolRel)session.get(ESFToolRelImpl.class,
						esfToolRel.getPrimaryKeyObj());
			}

			if (esfToolRel != null) {
				session.delete(esfToolRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfToolRel != null) {
			clearCache(esfToolRel);
		}

		return esfToolRel;
	}

	@Override
	public ESFToolRel updateImpl(it.ethica.esf.model.ESFToolRel esfToolRel)
		throws SystemException {
		esfToolRel = toUnwrappedModel(esfToolRel);

		boolean isNew = esfToolRel.isNew();

		ESFToolRelModelImpl esfToolRelModelImpl = (ESFToolRelModelImpl)esfToolRel;

		if (Validator.isNull(esfToolRel.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfToolRel.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfToolRel.isNew()) {
				session.save(esfToolRel);

				esfToolRel.setNew(false);
			}
			else {
				session.merge(esfToolRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFToolRelModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfToolRelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolRelModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfToolRelModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfToolRelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolRelModelImpl.getOriginalUuid(),
						esfToolRelModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfToolRelModelImpl.getUuid(),
						esfToolRelModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfToolRelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolRelModelImpl.getOriginalEsfToolId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTOOLID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID,
					args);

				args = new Object[] { esfToolRelModelImpl.getEsfToolId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTOOLID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID,
					args);
			}

			if ((esfToolRelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolRelModelImpl.getOriginalClassName(),
						esfToolRelModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P,
					args);

				args = new Object[] {
						esfToolRelModelImpl.getClassName(),
						esfToolRelModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P,
					args);
			}

			if ((esfToolRelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolRelModelImpl.getOriginalAssignmentDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNMENTDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE,
					args);

				args = new Object[] { esfToolRelModelImpl.getAssignmentDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNMENTDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolRelImpl.class, esfToolRel.getPrimaryKey(), esfToolRel);

		clearUniqueFindersCache(esfToolRel);
		cacheUniqueFindersCache(esfToolRel);

		return esfToolRel;
	}

	protected ESFToolRel toUnwrappedModel(ESFToolRel esfToolRel) {
		if (esfToolRel instanceof ESFToolRelImpl) {
			return esfToolRel;
		}

		ESFToolRelImpl esfToolRelImpl = new ESFToolRelImpl();

		esfToolRelImpl.setNew(esfToolRel.isNew());
		esfToolRelImpl.setPrimaryKey(esfToolRel.getPrimaryKey());

		esfToolRelImpl.setUuid(esfToolRel.getUuid());
		esfToolRelImpl.setGroupId(esfToolRel.getGroupId());
		esfToolRelImpl.setCompanyId(esfToolRel.getCompanyId());
		esfToolRelImpl.setUserId(esfToolRel.getUserId());
		esfToolRelImpl.setUserName(esfToolRel.getUserName());
		esfToolRelImpl.setCreateDate(esfToolRel.getCreateDate());
		esfToolRelImpl.setModifiedDate(esfToolRel.getModifiedDate());
		esfToolRelImpl.setAssignmentDate(esfToolRel.getAssignmentDate());
		esfToolRelImpl.setEsfToolId(esfToolRel.getEsfToolId());
		esfToolRelImpl.setClassName(esfToolRel.getClassName());
		esfToolRelImpl.setClassPK(esfToolRel.getClassPK());

		return esfToolRelImpl;
	}

	/**
	 * Returns the e s f tool rel with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f tool rel
	 * @return the e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchToolRelException, SystemException {
		ESFToolRel esfToolRel = fetchByPrimaryKey(primaryKey);

		if (esfToolRel == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchToolRelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfToolRel;
	}

	/**
	 * Returns the e s f tool rel with the primary key or throws a {@link it.ethica.esf.NoSuchToolRelException} if it could not be found.
	 *
	 * @param esfToolRelPK the primary key of the e s f tool rel
	 * @return the e s f tool rel
	 * @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel findByPrimaryKey(ESFToolRelPK esfToolRelPK)
		throws NoSuchToolRelException, SystemException {
		return findByPrimaryKey((Serializable)esfToolRelPK);
	}

	/**
	 * Returns the e s f tool rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f tool rel
	 * @return the e s f tool rel, or <code>null</code> if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFToolRel esfToolRel = (ESFToolRel)EntityCacheUtil.getResult(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
				ESFToolRelImpl.class, primaryKey);

		if (esfToolRel == _nullESFToolRel) {
			return null;
		}

		if (esfToolRel == null) {
			Session session = null;

			try {
				session = openSession();

				esfToolRel = (ESFToolRel)session.get(ESFToolRelImpl.class,
						primaryKey);

				if (esfToolRel != null) {
					cacheResult(esfToolRel);
				}
				else {
					EntityCacheUtil.putResult(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
						ESFToolRelImpl.class, primaryKey, _nullESFToolRel);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFToolRelModelImpl.ENTITY_CACHE_ENABLED,
					ESFToolRelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfToolRel;
	}

	/**
	 * Returns the e s f tool rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfToolRelPK the primary key of the e s f tool rel
	 * @return the e s f tool rel, or <code>null</code> if a e s f tool rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFToolRel fetchByPrimaryKey(ESFToolRelPK esfToolRelPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfToolRelPK);
	}

	/**
	 * Returns all the e s f tool rels.
	 *
	 * @return the e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tool rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @return the range of e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tool rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f tool rels
	 * @param end the upper bound of the range of e s f tool rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f tool rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFToolRel> findAll(int start, int end,
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

		List<ESFToolRel> list = (List<ESFToolRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFTOOLREL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFTOOLREL;

				if (pagination) {
					sql = sql.concat(ESFToolRelModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFToolRel>(list);
				}
				else {
					list = (List<ESFToolRel>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f tool rels from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFToolRel esfToolRel : findAll()) {
			remove(esfToolRel);
		}
	}

	/**
	 * Returns the number of e s f tool rels.
	 *
	 * @return the number of e s f tool rels
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

				Query q = session.createQuery(_SQL_COUNT_ESFTOOLREL);

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
	 * Initializes the e s f tool rel persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFToolRel")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFToolRel>> listenersList = new ArrayList<ModelListener<ESFToolRel>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFToolRel>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFToolRelImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFTOOLREL = "SELECT esfToolRel FROM ESFToolRel esfToolRel";
	private static final String _SQL_SELECT_ESFTOOLREL_WHERE = "SELECT esfToolRel FROM ESFToolRel esfToolRel WHERE ";
	private static final String _SQL_COUNT_ESFTOOLREL = "SELECT COUNT(esfToolRel) FROM ESFToolRel esfToolRel";
	private static final String _SQL_COUNT_ESFTOOLREL_WHERE = "SELECT COUNT(esfToolRel) FROM ESFToolRel esfToolRel WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfToolRel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFToolRel exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFToolRel exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFToolRelPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFToolRel _nullESFToolRel = new ESFToolRelImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFToolRel> toCacheModel() {
				return _nullESFToolRelCacheModel;
			}
		};

	private static CacheModel<ESFToolRel> _nullESFToolRelCacheModel = new CacheModel<ESFToolRel>() {
			@Override
			public ESFToolRel toEntityModel() {
				return _nullESFToolRel;
			}
		};
}