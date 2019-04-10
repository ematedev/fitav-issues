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

import it.ethica.esf.NoSuchUserException;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.model.impl.ESFUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserPersistence
 * @see ESFUserUtil
 * @generated
 */
public class ESFUserPersistenceImpl extends BasePersistenceImpl<ESFUser>
	implements ESFUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFUserUtil} to access the e s f user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFUserModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @return the range of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid(String uuid, int start, int end,
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

		List<ESFUser> list = (List<ESFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUser esfUser : list) {
				if (!Validator.equals(uuid, esfUser.getUuid())) {
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

			query.append(_SQL_SELECT_ESFUSER_WHERE);

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
				query.append(ESFUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUser>(list);
				}
				else {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByUuid_First(uuid, orderByComparator);

		if (esfUser != null) {
			return esfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByUuid_Last(uuid, orderByComparator);

		if (esfUser != null) {
			return esfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFUser> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f users before and after the current e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param esfUserId the primary key of the current e s f user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser[] findByUuid_PrevAndNext(long esfUserId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByPrimaryKey(esfUserId);

		Session session = null;

		try {
			session = openSession();

			ESFUser[] array = new ESFUserImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfUser, uuid,
					orderByComparator, true);

			array[1] = esfUser;

			array[2] = getByUuid_PrevAndNext(session, esfUser, uuid,
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

	protected ESFUser getByUuid_PrevAndNext(Session session, ESFUser esfUser,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSER_WHERE);

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
			query.append(ESFUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e s f users that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> filterFindByUuid(String uuid)
		throws SystemException {
		return filterFindByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f users that the user has permission to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @return the range of matching e s f users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> filterFindByUuid(String uuid, int start, int end)
		throws SystemException {
		return filterFindByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f users that the user has permissions to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> filterFindByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUuid(uuid, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_ESFUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1_SQL);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3_SQL);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2_SQL);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFUserModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFUserModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFUser.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESFUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESFUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindUuid) {
				qPos.add(uuid);
			}

			return (List<ESFUser>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e s f users before and after the current e s f user in the ordered set of e s f users that the user has permission to view where uuid = &#63;.
	 *
	 * @param esfUserId the primary key of the current e s f user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser[] filterFindByUuid_PrevAndNext(long esfUserId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUuid_PrevAndNext(esfUserId, uuid, orderByComparator);
		}

		ESFUser esfUser = findByPrimaryKey(esfUserId);

		Session session = null;

		try {
			session = openSession();

			ESFUser[] array = new ESFUserImpl[3];

			array[0] = filterGetByUuid_PrevAndNext(session, esfUser, uuid,
					orderByComparator, true);

			array[1] = esfUser;

			array[2] = filterGetByUuid_PrevAndNext(session, esfUser, uuid,
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

	protected ESFUser filterGetByUuid_PrevAndNext(Session session,
		ESFUser esfUser, String uuid, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_ESFUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1_SQL);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3_SQL);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2_SQL);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFUserModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFUserModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFUser.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ESFUserImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ESFUserImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFUser esfUser : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUser);
		}
	}

	/**
	 * Returns the number of e s f users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f users
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

			query.append(_SQL_COUNT_ESFUSER_WHERE);

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

	/**
	 * Returns the number of e s f users that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByUuid(String uuid) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByUuid(uuid);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ESFUSER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1_SQL);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3_SQL);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2_SQL);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFUser.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindUuid) {
				qPos.add(uuid);
			}

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfUser.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfUser.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfUser.uuid IS NULL OR esfUser.uuid = '')";
	private static final String _FINDER_COLUMN_UUID_UUID_1_SQL = "esfUser.uuid_ IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2_SQL = "esfUser.uuid_ = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3_SQL = "(esfUser.uuid_ IS NULL OR esfUser.uuid_ = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFUserModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f user where code = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByCode(String code)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByCode(code);

		if (esfUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f user where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFUser) {
			ESFUser esfUser = (ESFUser)result;

			if (!Validator.equals(code, esfUser.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFUSER_WHERE);

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

				List<ESFUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUser esfUser = list.get(0);

					result = esfUser;

					cacheResult(esfUser);

					if ((esfUser.getCode() == null) ||
							!esfUser.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfUser);
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
			return (ESFUser)result;
		}
	}

	/**
	 * Removes the e s f user where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser removeByCode(String code)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByCode(code);

		return remove(esfUser);
	}

	/**
	 * Returns the number of e s f users where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f users
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

			query.append(_SQL_COUNT_ESFUSER_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfUser.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfUser.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfUser.code IS NULL OR esfUser.code = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_FISCALCODE = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFiscalCode",
			new String[] { String.class.getName() },
			ESFUserModelImpl.FISCALCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FISCALCODE = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFiscalCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f user where fiscalCode = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param fiscalCode the fiscal code
	 * @return the matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByFiscalCode(String fiscalCode)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByFiscalCode(fiscalCode);

		if (esfUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fiscalCode=");
			msg.append(fiscalCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user where fiscalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fiscalCode the fiscal code
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByFiscalCode(String fiscalCode)
		throws SystemException {
		return fetchByFiscalCode(fiscalCode, true);
	}

	/**
	 * Returns the e s f user where fiscalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fiscalCode the fiscal code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByFiscalCode(String fiscalCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { fiscalCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FISCALCODE,
					finderArgs, this);
		}

		if (result instanceof ESFUser) {
			ESFUser esfUser = (ESFUser)result;

			if (!Validator.equals(fiscalCode, esfUser.getFiscalCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFUSER_WHERE);

			boolean bindFiscalCode = false;

			if (fiscalCode == null) {
				query.append(_FINDER_COLUMN_FISCALCODE_FISCALCODE_1);
			}
			else if (fiscalCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FISCALCODE_FISCALCODE_3);
			}
			else {
				bindFiscalCode = true;

				query.append(_FINDER_COLUMN_FISCALCODE_FISCALCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFiscalCode) {
					qPos.add(fiscalCode);
				}

				List<ESFUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserPersistenceImpl.fetchByFiscalCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUser esfUser = list.get(0);

					result = esfUser;

					cacheResult(esfUser);

					if ((esfUser.getFiscalCode() == null) ||
							!esfUser.getFiscalCode().equals(fiscalCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE,
							finderArgs, esfUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FISCALCODE,
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
			return (ESFUser)result;
		}
	}

	/**
	 * Removes the e s f user where fiscalCode = &#63; from the database.
	 *
	 * @param fiscalCode the fiscal code
	 * @return the e s f user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser removeByFiscalCode(String fiscalCode)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByFiscalCode(fiscalCode);

		return remove(esfUser);
	}

	/**
	 * Returns the number of e s f users where fiscalCode = &#63;.
	 *
	 * @param fiscalCode the fiscal code
	 * @return the number of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFiscalCode(String fiscalCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FISCALCODE;

		Object[] finderArgs = new Object[] { fiscalCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSER_WHERE);

			boolean bindFiscalCode = false;

			if (fiscalCode == null) {
				query.append(_FINDER_COLUMN_FISCALCODE_FISCALCODE_1);
			}
			else if (fiscalCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FISCALCODE_FISCALCODE_3);
			}
			else {
				bindFiscalCode = true;

				query.append(_FINDER_COLUMN_FISCALCODE_FISCALCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFiscalCode) {
					qPos.add(fiscalCode);
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

	private static final String _FINDER_COLUMN_FISCALCODE_FISCALCODE_1 = "esfUser.fiscalCode IS NULL";
	private static final String _FINDER_COLUMN_FISCALCODE_FISCALCODE_2 = "esfUser.fiscalCode = ?";
	private static final String _FINDER_COLUMN_FISCALCODE_FISCALCODE_3 = "(esfUser.fiscalCode IS NULL OR esfUser.fiscalCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERDID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserdId",
			new String[] { Long.class.getName() },
			ESFUserModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERDID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the e s f user where esfUserId = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByUserdId(long esfUserId)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByUserdId(esfUserId);

		if (esfUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfUserId=");
			msg.append(esfUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user where esfUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUserdId(long esfUserId) throws SystemException {
		return fetchByUserdId(esfUserId, true);
	}

	/**
	 * Returns the e s f user where esfUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUserdId(long esfUserId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { esfUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERDID,
					finderArgs, this);
		}

		if (result instanceof ESFUser) {
			ESFUser esfUser = (ESFUser)result;

			if ((esfUserId != esfUser.getEsfUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_USERDID_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				List<ESFUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserPersistenceImpl.fetchByUserdId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUser esfUser = list.get(0);

					result = esfUser;

					cacheResult(esfUser);

					if ((esfUser.getEsfUserId() != esfUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDID,
							finderArgs, esfUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERDID,
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
			return (ESFUser)result;
		}
	}

	/**
	 * Removes the e s f user where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @return the e s f user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser removeByUserdId(long esfUserId)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByUserdId(esfUserId);

		return remove(esfUser);
	}

	/**
	 * Returns the number of e s f users where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserdId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERDID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_USERDID_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_USERDID_ESFUSERID_2 = "esfUser.esfUserId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODEUSER = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCodeUser",
			new String[] { Long.class.getName() },
			ESFUserModelImpl.CODEUSER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODEUSER = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns the e s f user where codeUser = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param codeUser the code user
	 * @return the matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByCodeUser(long codeUser)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByCodeUser(codeUser);

		if (esfUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("codeUser=");
			msg.append(codeUser);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codeUser the code user
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByCodeUser(long codeUser) throws SystemException {
		return fetchByCodeUser(codeUser, true);
	}

	/**
	 * Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codeUser the code user
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByCodeUser(long codeUser, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { codeUser };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODEUSER,
					finderArgs, this);
		}

		if (result instanceof ESFUser) {
			ESFUser esfUser = (ESFUser)result;

			if ((codeUser != esfUser.getCodeUser())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_CODEUSER_CODEUSER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(codeUser);

				List<ESFUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserPersistenceImpl.fetchByCodeUser(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUser esfUser = list.get(0);

					result = esfUser;

					cacheResult(esfUser);

					if ((esfUser.getCodeUser() != codeUser)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER,
							finderArgs, esfUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEUSER,
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
			return (ESFUser)result;
		}
	}

	/**
	 * Removes the e s f user where codeUser = &#63; from the database.
	 *
	 * @param codeUser the code user
	 * @return the e s f user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser removeByCodeUser(long codeUser)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByCodeUser(codeUser);

		return remove(esfUser);
	}

	/**
	 * Returns the number of e s f users where codeUser = &#63;.
	 *
	 * @param codeUser the code user
	 * @return the number of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCodeUser(long codeUser) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODEUSER;

		Object[] finderArgs = new Object[] { codeUser };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_CODEUSER_CODEUSER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(codeUser);

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

	private static final String _FINDER_COLUMN_CODEUSER_CODEUSER_2 = "esfUser.codeUser = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODEUSER2 = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCodeUser2",
			new String[] { Long.class.getName() },
			ESFUserModelImpl.CODEUSER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODEUSER2 = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeUser2",
			new String[] { Long.class.getName() });

	/**
	 * Returns the e s f user where codeUser = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param codeUser the code user
	 * @return the matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByCodeUser2(long codeUser)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByCodeUser2(codeUser);

		if (esfUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("codeUser=");
			msg.append(codeUser);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codeUser the code user
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByCodeUser2(long codeUser) throws SystemException {
		return fetchByCodeUser2(codeUser, true);
	}

	/**
	 * Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codeUser the code user
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByCodeUser2(long codeUser, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { codeUser };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODEUSER2,
					finderArgs, this);
		}

		if (result instanceof ESFUser) {
			ESFUser esfUser = (ESFUser)result;

			if ((codeUser != esfUser.getCodeUser())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_CODEUSER2_CODEUSER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(codeUser);

				List<ESFUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER2,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserPersistenceImpl.fetchByCodeUser2(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUser esfUser = list.get(0);

					result = esfUser;

					cacheResult(esfUser);

					if ((esfUser.getCodeUser() != codeUser)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER2,
							finderArgs, esfUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEUSER2,
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
			return (ESFUser)result;
		}
	}

	/**
	 * Removes the e s f user where codeUser = &#63; from the database.
	 *
	 * @param codeUser the code user
	 * @return the e s f user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser removeByCodeUser2(long codeUser)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByCodeUser2(codeUser);

		return remove(esfUser);
	}

	/**
	 * Returns the number of e s f users where codeUser = &#63;.
	 *
	 * @param codeUser the code user
	 * @return the number of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCodeUser2(long codeUser) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODEUSER2;

		Object[] finderArgs = new Object[] { codeUser };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_CODEUSER2_CODEUSER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(codeUser);

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

	private static final String _FINDER_COLUMN_CODEUSER2_CODEUSER_2 = "esfUser.codeUser = ?";

	public ESFUserPersistenceImpl() {
		setModelClass(ESFUser.class);
	}

	/**
	 * Caches the e s f user in the entity cache if it is enabled.
	 *
	 * @param esfUser the e s f user
	 */
	@Override
	public void cacheResult(ESFUser esfUser) {
		EntityCacheUtil.putResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserImpl.class, esfUser.getPrimaryKey(), esfUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfUser.getCode() }, esfUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE,
			new Object[] { esfUser.getFiscalCode() }, esfUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDID,
			new Object[] { esfUser.getEsfUserId() }, esfUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER,
			new Object[] { esfUser.getCodeUser() }, esfUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER2,
			new Object[] { esfUser.getCodeUser() }, esfUser);

		esfUser.resetOriginalValues();
	}

	/**
	 * Caches the e s f users in the entity cache if it is enabled.
	 *
	 * @param esfUsers the e s f users
	 */
	@Override
	public void cacheResult(List<ESFUser> esfUsers) {
		for (ESFUser esfUser : esfUsers) {
			if (EntityCacheUtil.getResult(
						ESFUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserImpl.class, esfUser.getPrimaryKey()) == null) {
				cacheResult(esfUser);
			}
			else {
				esfUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFUser esfUser) {
		EntityCacheUtil.removeResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserImpl.class, esfUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfUser);
	}

	@Override
	public void clearCache(List<ESFUser> esfUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFUser esfUser : esfUsers) {
			EntityCacheUtil.removeResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserImpl.class, esfUser.getPrimaryKey());

			clearUniqueFindersCache(esfUser);
		}
	}

	protected void cacheUniqueFindersCache(ESFUser esfUser) {
		if (esfUser.isNew()) {
			Object[] args = new Object[] { esfUser.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, esfUser);

			args = new Object[] { esfUser.getFiscalCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FISCALCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE, args,
				esfUser);

			args = new Object[] { esfUser.getEsfUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERDID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDID, args,
				esfUser);

			args = new Object[] { esfUser.getCodeUser() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODEUSER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER, args,
				esfUser);

			args = new Object[] { esfUser.getCodeUser() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODEUSER2, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER2, args,
				esfUser);
		}
		else {
			ESFUserModelImpl esfUserModelImpl = (ESFUserModelImpl)esfUser;

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfUser.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfUser);
			}

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FISCALCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfUser.getFiscalCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FISCALCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE,
					args, esfUser);
			}

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfUser.getEsfUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERDID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDID, args,
					esfUser);
			}

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODEUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfUser.getCodeUser() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODEUSER, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER, args,
					esfUser);
			}

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODEUSER2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfUser.getCodeUser() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODEUSER2, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEUSER2, args,
					esfUser);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFUser esfUser) {
		ESFUserModelImpl esfUserModelImpl = (ESFUserModelImpl)esfUser;

		Object[] args = new Object[] { esfUser.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfUserModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}

		args = new Object[] { esfUser.getFiscalCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FISCALCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FISCALCODE, args);

		if ((esfUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FISCALCODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfUserModelImpl.getOriginalFiscalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FISCALCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FISCALCODE, args);
		}

		args = new Object[] { esfUser.getEsfUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERDID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERDID, args);

		if ((esfUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERDID.getColumnBitmask()) != 0) {
			args = new Object[] { esfUserModelImpl.getOriginalEsfUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERDID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERDID, args);
		}

		args = new Object[] { esfUser.getCodeUser() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODEUSER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEUSER, args);

		if ((esfUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODEUSER.getColumnBitmask()) != 0) {
			args = new Object[] { esfUserModelImpl.getOriginalCodeUser() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODEUSER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEUSER, args);
		}

		args = new Object[] { esfUser.getCodeUser() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODEUSER2, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEUSER2, args);

		if ((esfUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODEUSER2.getColumnBitmask()) != 0) {
			args = new Object[] { esfUserModelImpl.getOriginalCodeUser() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODEUSER2, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEUSER2, args);
		}
	}

	/**
	 * Creates a new e s f user with the primary key. Does not add the e s f user to the database.
	 *
	 * @param esfUserId the primary key for the new e s f user
	 * @return the new e s f user
	 */
	@Override
	public ESFUser create(long esfUserId) {
		ESFUser esfUser = new ESFUserImpl();

		esfUser.setNew(true);
		esfUser.setPrimaryKey(esfUserId);

		String uuid = PortalUUIDUtil.generate();

		esfUser.setUuid(uuid);

		return esfUser;
	}

	/**
	 * Removes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserId the primary key of the e s f user
	 * @return the e s f user that was removed
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser remove(long esfUserId)
		throws NoSuchUserException, SystemException {
		return remove((Serializable)esfUserId);
	}

	/**
	 * Removes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f user
	 * @return the e s f user that was removed
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser remove(Serializable primaryKey)
		throws NoSuchUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFUser esfUser = (ESFUser)session.get(ESFUserImpl.class, primaryKey);

			if (esfUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfUser);
		}
		catch (NoSuchUserException nsee) {
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
	protected ESFUser removeImpl(ESFUser esfUser) throws SystemException {
		esfUser = toUnwrappedModel(esfUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfUser)) {
				esfUser = (ESFUser)session.get(ESFUserImpl.class,
						esfUser.getPrimaryKeyObj());
			}

			if (esfUser != null) {
				session.delete(esfUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfUser != null) {
			clearCache(esfUser);
		}

		return esfUser;
	}

	@Override
	public ESFUser updateImpl(it.ethica.esf.model.ESFUser esfUser)
		throws SystemException {
		esfUser = toUnwrappedModel(esfUser);

		boolean isNew = esfUser.isNew();

		ESFUserModelImpl esfUserModelImpl = (ESFUserModelImpl)esfUser;

		if (Validator.isNull(esfUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfUser.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfUser.isNew()) {
				session.save(esfUser);

				esfUser.setNew(false);
			}
			else {
				session.merge(esfUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfUserModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfUserModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserImpl.class, esfUser.getPrimaryKey(), esfUser);

		clearUniqueFindersCache(esfUser);
		cacheUniqueFindersCache(esfUser);

		return esfUser;
	}

	protected ESFUser toUnwrappedModel(ESFUser esfUser) {
		if (esfUser instanceof ESFUserImpl) {
			return esfUser;
		}

		ESFUserImpl esfUserImpl = new ESFUserImpl();

		esfUserImpl.setNew(esfUser.isNew());
		esfUserImpl.setPrimaryKey(esfUser.getPrimaryKey());

		esfUserImpl.setUuid(esfUser.getUuid());
		esfUserImpl.setEsfUserId(esfUser.getEsfUserId());
		esfUserImpl.setCode(esfUser.getCode());
		esfUserImpl.setTypearmy(esfUser.getTypearmy());
		esfUserImpl.setFiscalCode(esfUser.getFiscalCode());
		esfUserImpl.setBirthcity(esfUser.getBirthcity());
		esfUserImpl.setNationality(esfUser.getNationality());
		esfUserImpl.setIsSportsGroups(esfUser.isIsSportsGroups());
		esfUserImpl.setJob(esfUser.getJob());
		esfUserImpl.setIssfIdNumber(esfUser.getIssfIdNumber());
		esfUserImpl.setCategoryId(esfUser.getCategoryId());
		esfUserImpl.setPin(esfUser.getPin());
		esfUserImpl.setCodeUser(esfUser.getCodeUser());
		esfUserImpl.setDateOfDeath(esfUser.getDateOfDeath());
		esfUserImpl.setPrivacy1(esfUser.isPrivacy1());
		esfUserImpl.setPrivacy2(esfUser.isPrivacy2());
		esfUserImpl.setPrivacy3(esfUser.isPrivacy3());
		esfUserImpl.setDatePrivacy1(esfUser.getDatePrivacy1());
		esfUserImpl.setDatePrivacy2(esfUser.getDatePrivacy2());
		esfUserImpl.setDatePrivacy3(esfUser.getDatePrivacy3());
		esfUserImpl.setValidateCF(esfUser.isValidateCF());

		return esfUserImpl;
	}

	/**
	 * Returns the e s f user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user
	 * @return the e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByPrimaryKey(primaryKey);

		if (esfUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user with the primary key or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param esfUserId the primary key of the e s f user
	 * @return the e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByPrimaryKey(long esfUserId)
		throws NoSuchUserException, SystemException {
		return findByPrimaryKey((Serializable)esfUserId);
	}

	/**
	 * Returns the e s f user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user
	 * @return the e s f user, or <code>null</code> if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFUser esfUser = (ESFUser)EntityCacheUtil.getResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserImpl.class, primaryKey);

		if (esfUser == _nullESFUser) {
			return null;
		}

		if (esfUser == null) {
			Session session = null;

			try {
				session = openSession();

				esfUser = (ESFUser)session.get(ESFUserImpl.class, primaryKey);

				if (esfUser != null) {
					cacheResult(esfUser);
				}
				else {
					EntityCacheUtil.putResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserImpl.class, primaryKey, _nullESFUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
					ESFUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfUserId the primary key of the e s f user
	 * @return the e s f user, or <code>null</code> if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByPrimaryKey(long esfUserId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfUserId);
	}

	/**
	 * Returns all the e s f users.
	 *
	 * @return the e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @return the range of e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findAll(int start, int end,
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

		List<ESFUser> list = (List<ESFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFUSER;

				if (pagination) {
					sql = sql.concat(ESFUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUser>(list);
				}
				else {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFUser esfUser : findAll()) {
			remove(esfUser);
		}
	}

	/**
	 * Returns the number of e s f users.
	 *
	 * @return the number of e s f users
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

				Query q = session.createQuery(_SQL_COUNT_ESFUSER);

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
	 * Initializes the e s f user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFUser>> listenersList = new ArrayList<ModelListener<ESFUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFUSER = "SELECT esfUser FROM ESFUser esfUser";
	private static final String _SQL_SELECT_ESFUSER_WHERE = "SELECT esfUser FROM ESFUser esfUser WHERE ";
	private static final String _SQL_COUNT_ESFUSER = "SELECT COUNT(esfUser) FROM ESFUser esfUser";
	private static final String _SQL_COUNT_ESFUSER_WHERE = "SELECT COUNT(esfUser) FROM ESFUser esfUser WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "esfUser.esfUserId";
	private static final String _FILTER_SQL_SELECT_ESFUSER_WHERE = "SELECT DISTINCT {esfUser.*} FROM ESFUser esfUser WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFUSER_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ESFUser.*} FROM (SELECT DISTINCT esfUser.esfUserId FROM ESFUser esfUser WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFUSER_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ESFUser ON TEMP_TABLE.esfUserId = ESFUser.esfUserId";
	private static final String _FILTER_SQL_COUNT_ESFUSER_WHERE = "SELECT COUNT(DISTINCT esfUser.esfUserId) AS COUNT_VALUE FROM ESFUser esfUser WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "esfUser";
	private static final String _FILTER_ENTITY_TABLE = "ESFUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfUser.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ESFUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFUser _nullESFUser = new ESFUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFUser> toCacheModel() {
				return _nullESFUserCacheModel;
			}
		};

	private static CacheModel<ESFUser> _nullESFUserCacheModel = new CacheModel<ESFUser>() {
			@Override
			public ESFUser toEntityModel() {
				return _nullESFUser;
			}
		};
}