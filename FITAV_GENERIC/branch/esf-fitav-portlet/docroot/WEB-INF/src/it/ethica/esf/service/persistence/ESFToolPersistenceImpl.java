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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchToolException;
import it.ethica.esf.model.ESFTool;
import it.ethica.esf.model.impl.ESFToolImpl;
import it.ethica.esf.model.impl.ESFToolModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f tool service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFToolPersistence
 * @see ESFToolUtil
 * @generated
 */
public class ESFToolPersistenceImpl extends BasePersistenceImpl<ESFTool>
	implements ESFToolPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFToolUtil} to access the e s f tool persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFToolImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFToolModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f tools where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tools where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @return the range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tools where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByUuid(String uuid, int start, int end,
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

		List<ESFTool> list = (List<ESFTool>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFTool esfTool : list) {
				if (!Validator.equals(uuid, esfTool.getUuid())) {
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

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

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
				query.append(ESFToolModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTool>(list);
				}
				else {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByUuid_First(uuid, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the first e s f tool in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFTool> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByUuid_Last(uuid, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the last e s f tool in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFTool> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tools before and after the current e s f tool in the ordered set where uuid = &#63;.
	 *
	 * @param esfToolId the primary key of the current e s f tool
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool[] findByUuid_PrevAndNext(long esfToolId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = findByPrimaryKey(esfToolId);

		Session session = null;

		try {
			session = openSession();

			ESFTool[] array = new ESFToolImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfTool, uuid,
					orderByComparator, true);

			array[1] = esfTool;

			array[2] = getByUuid_PrevAndNext(session, esfTool, uuid,
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

	protected ESFTool getByUuid_PrevAndNext(Session session, ESFTool esfTool,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOL_WHERE);

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
			query.append(ESFToolModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfTool);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFTool> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tools where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFTool esfTool : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfTool);
		}
	}

	/**
	 * Returns the number of e s f tools where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f tools
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

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfTool.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfTool.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfTool.uuid IS NULL OR esfTool.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFToolModelImpl.UUID_COLUMN_BITMASK |
			ESFToolModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f tool where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByUUID_G(String uuid, long groupId)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByUUID_G(uuid, groupId);

		if (esfTool == null) {
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

			throw new NoSuchToolException(msg.toString());
		}

		return esfTool;
	}

	/**
	 * Returns the e s f tool where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f tool where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFTool) {
			ESFTool esfTool = (ESFTool)result;

			if (!Validator.equals(uuid, esfTool.getUuid()) ||
					(groupId != esfTool.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

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

				List<ESFTool> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFTool esfTool = list.get(0);

					result = esfTool;

					cacheResult(esfTool);

					if ((esfTool.getUuid() == null) ||
							!esfTool.getUuid().equals(uuid) ||
							(esfTool.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfTool);
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
			return (ESFTool)result;
		}
	}

	/**
	 * Removes the e s f tool where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f tool that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool removeByUUID_G(String uuid, long groupId)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = findByUUID_G(uuid, groupId);

		return remove(esfTool);
	}

	/**
	 * Returns the number of e s f tools where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f tools
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

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfTool.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfTool.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfTool.uuid IS NULL OR esfTool.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfTool.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFToolModelImpl.UUID_COLUMN_BITMASK |
			ESFToolModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f tools where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tools where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @return the range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tools where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFTool> list = (List<ESFTool>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFTool esfTool : list) {
				if (!Validator.equals(uuid, esfTool.getUuid()) ||
						(companyId != esfTool.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

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
				query.append(ESFToolModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTool>(list);
				}
				else {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the first e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFTool> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the last e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFTool> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tools before and after the current e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfToolId the primary key of the current e s f tool
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool[] findByUuid_C_PrevAndNext(long esfToolId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = findByPrimaryKey(esfToolId);

		Session session = null;

		try {
			session = openSession();

			ESFTool[] array = new ESFToolImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfTool, uuid,
					companyId, orderByComparator, true);

			array[1] = esfTool;

			array[2] = getByUuid_C_PrevAndNext(session, esfTool, uuid,
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

	protected ESFTool getByUuid_C_PrevAndNext(Session session, ESFTool esfTool,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOL_WHERE);

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
			query.append(ESFToolModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfTool);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFTool> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tools where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFTool esfTool : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfTool);
		}
	}

	/**
	 * Returns the number of e s f tools where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f tools
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

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfTool.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfTool.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfTool.uuid IS NULL OR esfTool.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfTool.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFToolModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f tools where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tools where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @return the range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tools where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByGroupId(long groupId, int start, int end,
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

		List<ESFTool> list = (List<ESFTool>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFTool esfTool : list) {
				if ((groupId != esfTool.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFToolModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTool>(list);
				}
				else {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByGroupId_First(groupId, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the first e s f tool in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFTool> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByGroupId_Last(groupId, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the last e s f tool in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFTool> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tools before and after the current e s f tool in the ordered set where groupId = &#63;.
	 *
	 * @param esfToolId the primary key of the current e s f tool
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool[] findByGroupId_PrevAndNext(long esfToolId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = findByPrimaryKey(esfToolId);

		Session session = null;

		try {
			session = openSession();

			ESFTool[] array = new ESFToolImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfTool, groupId,
					orderByComparator, true);

			array[1] = esfTool;

			array[2] = getByGroupId_PrevAndNext(session, esfTool, groupId,
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

	protected ESFTool getByGroupId_PrevAndNext(Session session,
		ESFTool esfTool, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOL_WHERE);

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
			query.append(ESFToolModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfTool);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFTool> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e s f tools that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f tools that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tools that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @return the range of matching e s f tools that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tools that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tools that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ESFToolModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFToolModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFTool.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESFToolImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESFToolImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ESFTool>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e s f tools before and after the current e s f tool in the ordered set of e s f tools that the user has permission to view where groupId = &#63;.
	 *
	 * @param esfToolId the primary key of the current e s f tool
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool[] filterFindByGroupId_PrevAndNext(long esfToolId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(esfToolId, groupId,
				orderByComparator);
		}

		ESFTool esfTool = findByPrimaryKey(esfToolId);

		Session session = null;

		try {
			session = openSession();

			ESFTool[] array = new ESFToolImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, esfTool,
					groupId, orderByComparator, true);

			array[1] = esfTool;

			array[2] = filterGetByGroupId_PrevAndNext(session, esfTool,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFTool filterGetByGroupId_PrevAndNext(Session session,
		ESFTool esfTool, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ESFToolModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFToolModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFTool.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ESFToolImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ESFToolImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfTool);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFTool> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tools where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFTool esfTool : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfTool);
		}
	}

	/**
	 * Returns the number of e s f tools where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f tools
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

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

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

	/**
	 * Returns the number of e s f tools that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f tools that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ESFTOOL_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFTool.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfTool.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFToolModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f tool where code = &#63; or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByCode(String code)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByCode(code);

		if (esfTool == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchToolException(msg.toString());
		}

		return esfTool;
	}

	/**
	 * Returns the e s f tool where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f tool where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFTool) {
			ESFTool esfTool = (ESFTool)result;

			if (!Validator.equals(code, esfTool.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

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

				List<ESFTool> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFToolPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFTool esfTool = list.get(0);

					result = esfTool;

					cacheResult(esfTool);

					if ((esfTool.getCode() == null) ||
							!esfTool.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfTool);
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
			return (ESFTool)result;
		}
	}

	/**
	 * Removes the e s f tool where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f tool that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool removeByCode(String code)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = findByCode(code);

		return remove(esfTool);
	}

	/**
	 * Returns the number of e s f tools where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f tools
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

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfTool.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfTool.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfTool.code IS NULL OR esfTool.code = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			ESFToolModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f tool where name = &#63; or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByName(String name)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByName(name);

		if (esfTool == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchToolException(msg.toString());
		}

		return esfTool;
	}

	/**
	 * Returns the e s f tool where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the e s f tool where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof ESFTool) {
			ESFTool esfTool = (ESFTool)result;

			if (!Validator.equals(name, esfTool.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

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

				List<ESFTool> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFToolPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFTool esfTool = list.get(0);

					result = esfTool;

					cacheResult(esfTool);

					if ((esfTool.getName() == null) ||
							!esfTool.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, esfTool);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
			return (ESFTool)result;
		}
	}

	/**
	 * Removes the e s f tool where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the e s f tool that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool removeByName(String name)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = findByName(name);

		return remove(esfTool);
	}

	/**
	 * Returns the number of e s f tools where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f tools
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

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfTool.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfTool.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfTool.name IS NULL OR esfTool.name = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_DESCRITPION = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDescritpion",
			new String[] { String.class.getName() },
			ESFToolModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRITPION = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescritpion",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f tool where description = &#63; or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	 *
	 * @param description the description
	 * @return the matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByDescritpion(String description)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByDescritpion(description);

		if (esfTool == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("description=");
			msg.append(description);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchToolException(msg.toString());
		}

		return esfTool;
	}

	/**
	 * Returns the e s f tool where description = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param description the description
	 * @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByDescritpion(String description)
		throws SystemException {
		return fetchByDescritpion(description, true);
	}

	/**
	 * Returns the e s f tool where description = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param description the description
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByDescritpion(String description,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { description };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DESCRITPION,
					finderArgs, this);
		}

		if (result instanceof ESFTool) {
			ESFTool esfTool = (ESFTool)result;

			if (!Validator.equals(description, esfTool.getDescription())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_DESCRITPION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRITPION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRITPION_DESCRIPTION_2);
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

				List<ESFTool> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRITPION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFToolPersistenceImpl.fetchByDescritpion(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFTool esfTool = list.get(0);

					result = esfTool;

					cacheResult(esfTool);

					if ((esfTool.getDescription() == null) ||
							!esfTool.getDescription().equals(description)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRITPION,
							finderArgs, esfTool);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESCRITPION,
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
			return (ESFTool)result;
		}
	}

	/**
	 * Removes the e s f tool where description = &#63; from the database.
	 *
	 * @param description the description
	 * @return the e s f tool that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool removeByDescritpion(String description)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = findByDescritpion(description);

		return remove(esfTool);
	}

	/**
	 * Returns the number of e s f tools where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDescritpion(String description) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCRITPION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_DESCRITPION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRITPION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRITPION_DESCRIPTION_2);
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

	private static final String _FINDER_COLUMN_DESCRITPION_DESCRIPTION_1 = "esfTool.description IS NULL";
	private static final String _FINDER_COLUMN_DESCRITPION_DESCRIPTION_2 = "esfTool.description = ?";
	private static final String _FINDER_COLUMN_DESCRITPION_DESCRIPTION_3 = "(esfTool.description IS NULL OR esfTool.description = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			ESFToolModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f tools where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByType(String type) throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tools where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @return the range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByType(String type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tools where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByType(String type, int start, int end,
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

		List<ESFTool> list = (List<ESFTool>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFTool esfTool : list) {
				if (!Validator.equals(type, esfTool.getType())) {
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

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFToolModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTool>(list);
				}
				else {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByType_First(type, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the first e s f tool in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByType_First(String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFTool> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByType_Last(type, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the last e s f tool in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByType_Last(String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<ESFTool> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tools before and after the current e s f tool in the ordered set where type = &#63;.
	 *
	 * @param esfToolId the primary key of the current e s f tool
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool[] findByType_PrevAndNext(long esfToolId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = findByPrimaryKey(esfToolId);

		Session session = null;

		try {
			session = openSession();

			ESFTool[] array = new ESFToolImpl[3];

			array[0] = getByType_PrevAndNext(session, esfTool, type,
					orderByComparator, true);

			array[1] = esfTool;

			array[2] = getByType_PrevAndNext(session, esfTool, type,
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

	protected ESFTool getByType_PrevAndNext(Session session, ESFTool esfTool,
		String type, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOOL_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);
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
			query.append(ESFToolModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfTool);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFTool> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tools where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(String type) throws SystemException {
		for (ESFTool esfTool : findByType(type, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfTool);
		}
	}

	/**
	 * Returns the number of e s f tools where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(String type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
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

	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "esfTool.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "esfTool.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(esfTool.type IS NULL OR esfTool.type = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_G = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, ESFToolImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFToolModelImpl.ESFTOOLID_COLUMN_BITMASK |
			ESFToolModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_G = new FinderPath(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f tools where esfToolId = &#63; and groupId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @return the matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByT_G(long esfToolId, long groupId)
		throws SystemException {
		return findByT_G(esfToolId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tools where esfToolId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @return the range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByT_G(long esfToolId, long groupId, int start,
		int end) throws SystemException {
		return findByT_G(esfToolId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tools where esfToolId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findByT_G(long esfToolId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G;
			finderArgs = new Object[] { esfToolId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_G;
			finderArgs = new Object[] {
					esfToolId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ESFTool> list = (List<ESFTool>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFTool esfTool : list) {
				if ((esfToolId != esfTool.getEsfToolId()) ||
						(groupId != esfTool.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFTOOL_WHERE);

			query.append(_FINDER_COLUMN_T_G_ESFTOOLID_2);

			query.append(_FINDER_COLUMN_T_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFToolModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfToolId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTool>(list);
				}
				else {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tool in the ordered set where esfToolId = &#63; and groupId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByT_G_First(long esfToolId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByT_G_First(esfToolId, groupId, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfToolId=");
		msg.append(esfToolId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the first e s f tool in the ordered set where esfToolId = &#63; and groupId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByT_G_First(long esfToolId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFTool> list = findByT_G(esfToolId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tool in the ordered set where esfToolId = &#63; and groupId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByT_G_Last(long esfToolId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByT_G_Last(esfToolId, groupId, orderByComparator);

		if (esfTool != null) {
			return esfTool;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfToolId=");
		msg.append(esfToolId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolException(msg.toString());
	}

	/**
	 * Returns the last e s f tool in the ordered set where esfToolId = &#63; and groupId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByT_G_Last(long esfToolId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_G(esfToolId, groupId);

		if (count == 0) {
			return null;
		}

		List<ESFTool> list = findByT_G(esfToolId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the e s f tools that the user has permission to view where esfToolId = &#63; and groupId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @return the matching e s f tools that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> filterFindByT_G(long esfToolId, long groupId)
		throws SystemException {
		return filterFindByT_G(esfToolId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tools that the user has permission to view where esfToolId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @return the range of matching e s f tools that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> filterFindByT_G(long esfToolId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByT_G(esfToolId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tools that the user has permissions to view where esfToolId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tools that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> filterFindByT_G(long esfToolId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByT_G(esfToolId, groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_T_G_ESFTOOLID_2);

		query.append(_FINDER_COLUMN_T_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFTOOL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ESFToolModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFToolModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFTool.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESFToolImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESFToolImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(esfToolId);

			qPos.add(groupId);

			return (List<ESFTool>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes all the e s f tools where esfToolId = &#63; and groupId = &#63; from the database.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_G(long esfToolId, long groupId)
		throws SystemException {
		for (ESFTool esfTool : findByT_G(esfToolId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfTool);
		}
	}

	/**
	 * Returns the number of e s f tools where esfToolId = &#63; and groupId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @return the number of matching e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_G(long esfToolId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_G;

		Object[] finderArgs = new Object[] { esfToolId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFTOOL_WHERE);

			query.append(_FINDER_COLUMN_T_G_ESFTOOLID_2);

			query.append(_FINDER_COLUMN_T_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfToolId);

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

	/**
	 * Returns the number of e s f tools that the user has permission to view where esfToolId = &#63; and groupId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param groupId the group ID
	 * @return the number of matching e s f tools that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByT_G(long esfToolId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByT_G(esfToolId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_ESFTOOL_WHERE);

		query.append(_FINDER_COLUMN_T_G_ESFTOOLID_2);

		query.append(_FINDER_COLUMN_T_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFTool.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(esfToolId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_T_G_ESFTOOLID_2 = "esfTool.esfToolId = ? AND ";
	private static final String _FINDER_COLUMN_T_G_GROUPID_2 = "esfTool.groupId = ?";

	public ESFToolPersistenceImpl() {
		setModelClass(ESFTool.class);
	}

	/**
	 * Caches the e s f tool in the entity cache if it is enabled.
	 *
	 * @param esfTool the e s f tool
	 */
	@Override
	public void cacheResult(ESFTool esfTool) {
		EntityCacheUtil.putResult(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolImpl.class, esfTool.getPrimaryKey(), esfTool);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfTool.getUuid(), esfTool.getGroupId() }, esfTool);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfTool.getCode() }, esfTool);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { esfTool.getName() }, esfTool);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRITPION,
			new Object[] { esfTool.getDescription() }, esfTool);

		esfTool.resetOriginalValues();
	}

	/**
	 * Caches the e s f tools in the entity cache if it is enabled.
	 *
	 * @param esfTools the e s f tools
	 */
	@Override
	public void cacheResult(List<ESFTool> esfTools) {
		for (ESFTool esfTool : esfTools) {
			if (EntityCacheUtil.getResult(
						ESFToolModelImpl.ENTITY_CACHE_ENABLED,
						ESFToolImpl.class, esfTool.getPrimaryKey()) == null) {
				cacheResult(esfTool);
			}
			else {
				esfTool.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f tools.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFToolImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFToolImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f tool.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFTool esfTool) {
		EntityCacheUtil.removeResult(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolImpl.class, esfTool.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfTool);
	}

	@Override
	public void clearCache(List<ESFTool> esfTools) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFTool esfTool : esfTools) {
			EntityCacheUtil.removeResult(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
				ESFToolImpl.class, esfTool.getPrimaryKey());

			clearUniqueFindersCache(esfTool);
		}
	}

	protected void cacheUniqueFindersCache(ESFTool esfTool) {
		if (esfTool.isNew()) {
			Object[] args = new Object[] { esfTool.getUuid(), esfTool.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, esfTool);

			args = new Object[] { esfTool.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, esfTool);

			args = new Object[] { esfTool.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, esfTool);

			args = new Object[] { esfTool.getDescription() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESCRITPION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRITPION, args,
				esfTool);
		}
		else {
			ESFToolModelImpl esfToolModelImpl = (ESFToolModelImpl)esfTool;

			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfTool.getUuid(), esfTool.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfTool);
			}

			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfTool.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfTool);
			}

			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfTool.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					esfTool);
			}

			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DESCRITPION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfTool.getDescription() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESCRITPION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESCRITPION,
					args, esfTool);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFTool esfTool) {
		ESFToolModelImpl esfToolModelImpl = (ESFToolModelImpl)esfTool;

		Object[] args = new Object[] { esfTool.getUuid(), esfTool.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfToolModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfToolModelImpl.getOriginalUuid(),
					esfToolModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { esfTool.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfToolModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfToolModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}

		args = new Object[] { esfTool.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((esfToolModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { esfToolModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}

		args = new Object[] { esfTool.getDescription() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRITPION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESCRITPION, args);

		if ((esfToolModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DESCRITPION.getColumnBitmask()) != 0) {
			args = new Object[] { esfToolModelImpl.getOriginalDescription() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRITPION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESCRITPION, args);
		}
	}

	/**
	 * Creates a new e s f tool with the primary key. Does not add the e s f tool to the database.
	 *
	 * @param esfToolId the primary key for the new e s f tool
	 * @return the new e s f tool
	 */
	@Override
	public ESFTool create(long esfToolId) {
		ESFTool esfTool = new ESFToolImpl();

		esfTool.setNew(true);
		esfTool.setPrimaryKey(esfToolId);

		String uuid = PortalUUIDUtil.generate();

		esfTool.setUuid(uuid);

		return esfTool;
	}

	/**
	 * Removes the e s f tool with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfToolId the primary key of the e s f tool
	 * @return the e s f tool that was removed
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool remove(long esfToolId)
		throws NoSuchToolException, SystemException {
		return remove((Serializable)esfToolId);
	}

	/**
	 * Removes the e s f tool with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f tool
	 * @return the e s f tool that was removed
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool remove(Serializable primaryKey)
		throws NoSuchToolException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFTool esfTool = (ESFTool)session.get(ESFToolImpl.class, primaryKey);

			if (esfTool == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchToolException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfTool);
		}
		catch (NoSuchToolException nsee) {
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
	protected ESFTool removeImpl(ESFTool esfTool) throws SystemException {
		esfTool = toUnwrappedModel(esfTool);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfTool)) {
				esfTool = (ESFTool)session.get(ESFToolImpl.class,
						esfTool.getPrimaryKeyObj());
			}

			if (esfTool != null) {
				session.delete(esfTool);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfTool != null) {
			clearCache(esfTool);
		}

		return esfTool;
	}

	@Override
	public ESFTool updateImpl(it.ethica.esf.model.ESFTool esfTool)
		throws SystemException {
		esfTool = toUnwrappedModel(esfTool);

		boolean isNew = esfTool.isNew();

		ESFToolModelImpl esfToolModelImpl = (ESFToolModelImpl)esfTool;

		if (Validator.isNull(esfTool.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfTool.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfTool.isNew()) {
				session.save(esfTool);

				esfTool.setNew(false);
			}
			else {
				session.merge(esfTool);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFToolModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfToolModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfToolModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolModelImpl.getOriginalUuid(),
						esfToolModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfToolModelImpl.getUuid(),
						esfToolModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfToolModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfToolModelImpl.getOriginalType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { esfToolModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((esfToolModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfToolModelImpl.getOriginalEsfToolId(),
						esfToolModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G,
					args);

				args = new Object[] {
						esfToolModelImpl.getEsfToolId(),
						esfToolModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_G,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
			ESFToolImpl.class, esfTool.getPrimaryKey(), esfTool);

		clearUniqueFindersCache(esfTool);
		cacheUniqueFindersCache(esfTool);

		return esfTool;
	}

	protected ESFTool toUnwrappedModel(ESFTool esfTool) {
		if (esfTool instanceof ESFToolImpl) {
			return esfTool;
		}

		ESFToolImpl esfToolImpl = new ESFToolImpl();

		esfToolImpl.setNew(esfTool.isNew());
		esfToolImpl.setPrimaryKey(esfTool.getPrimaryKey());

		esfToolImpl.setUuid(esfTool.getUuid());
		esfToolImpl.setEsfToolId(esfTool.getEsfToolId());
		esfToolImpl.setGroupId(esfTool.getGroupId());
		esfToolImpl.setCompanyId(esfTool.getCompanyId());
		esfToolImpl.setUserId(esfTool.getUserId());
		esfToolImpl.setUserName(esfTool.getUserName());
		esfToolImpl.setCreateDate(esfTool.getCreateDate());
		esfToolImpl.setModifiedDate(esfTool.getModifiedDate());
		esfToolImpl.setCode(esfTool.getCode());
		esfToolImpl.setName(esfTool.getName());
		esfToolImpl.setDescription(esfTool.getDescription());
		esfToolImpl.setType(esfTool.getType());

		return esfToolImpl;
	}

	/**
	 * Returns the e s f tool with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f tool
	 * @return the e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByPrimaryKey(Serializable primaryKey)
		throws NoSuchToolException, SystemException {
		ESFTool esfTool = fetchByPrimaryKey(primaryKey);

		if (esfTool == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchToolException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfTool;
	}

	/**
	 * Returns the e s f tool with the primary key or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	 *
	 * @param esfToolId the primary key of the e s f tool
	 * @return the e s f tool
	 * @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool findByPrimaryKey(long esfToolId)
		throws NoSuchToolException, SystemException {
		return findByPrimaryKey((Serializable)esfToolId);
	}

	/**
	 * Returns the e s f tool with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f tool
	 * @return the e s f tool, or <code>null</code> if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFTool esfTool = (ESFTool)EntityCacheUtil.getResult(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
				ESFToolImpl.class, primaryKey);

		if (esfTool == _nullESFTool) {
			return null;
		}

		if (esfTool == null) {
			Session session = null;

			try {
				session = openSession();

				esfTool = (ESFTool)session.get(ESFToolImpl.class, primaryKey);

				if (esfTool != null) {
					cacheResult(esfTool);
				}
				else {
					EntityCacheUtil.putResult(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
						ESFToolImpl.class, primaryKey, _nullESFTool);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFToolModelImpl.ENTITY_CACHE_ENABLED,
					ESFToolImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfTool;
	}

	/**
	 * Returns the e s f tool with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfToolId the primary key of the e s f tool
	 * @return the e s f tool, or <code>null</code> if a e s f tool with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTool fetchByPrimaryKey(long esfToolId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfToolId);
	}

	/**
	 * Returns all the e s f tools.
	 *
	 * @return the e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tools.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @return the range of e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tools.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f tools
	 * @param end the upper bound of the range of e s f tools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f tools
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTool> findAll(int start, int end,
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

		List<ESFTool> list = (List<ESFTool>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFTOOL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFTOOL;

				if (pagination) {
					sql = sql.concat(ESFToolModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTool>(list);
				}
				else {
					list = (List<ESFTool>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f tools from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFTool esfTool : findAll()) {
			remove(esfTool);
		}
	}

	/**
	 * Returns the number of e s f tools.
	 *
	 * @return the number of e s f tools
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

				Query q = session.createQuery(_SQL_COUNT_ESFTOOL);

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
	 * Initializes the e s f tool persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFTool")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFTool>> listenersList = new ArrayList<ModelListener<ESFTool>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFTool>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFToolImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFTOOL = "SELECT esfTool FROM ESFTool esfTool";
	private static final String _SQL_SELECT_ESFTOOL_WHERE = "SELECT esfTool FROM ESFTool esfTool WHERE ";
	private static final String _SQL_COUNT_ESFTOOL = "SELECT COUNT(esfTool) FROM ESFTool esfTool";
	private static final String _SQL_COUNT_ESFTOOL_WHERE = "SELECT COUNT(esfTool) FROM ESFTool esfTool WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "esfTool.esfToolId";
	private static final String _FILTER_SQL_SELECT_ESFTOOL_WHERE = "SELECT DISTINCT {esfTool.*} FROM ESFTool esfTool WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFTOOL_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ESFTool.*} FROM (SELECT DISTINCT esfTool.esfToolId FROM ESFTool esfTool WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFTOOL_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ESFTool ON TEMP_TABLE.esfToolId = ESFTool.esfToolId";
	private static final String _FILTER_SQL_COUNT_ESFTOOL_WHERE = "SELECT COUNT(DISTINCT esfTool.esfToolId) AS COUNT_VALUE FROM ESFTool esfTool WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "esfTool";
	private static final String _FILTER_ENTITY_TABLE = "ESFTool";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfTool.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ESFTool.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFTool exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFTool exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFToolPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code", "type"
			});
	private static ESFTool _nullESFTool = new ESFToolImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFTool> toCacheModel() {
				return _nullESFToolCacheModel;
			}
		};

	private static CacheModel<ESFTool> _nullESFToolCacheModel = new CacheModel<ESFTool>() {
			@Override
			public ESFTool toEntityModel() {
				return _nullESFTool;
			}
		};
}