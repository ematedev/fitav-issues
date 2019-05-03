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
import com.liferay.portal.kernel.util.CharPool;
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

import it.ethica.esf.NoSuchFieldException;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.impl.ESFFieldImpl;
import it.ethica.esf.model.impl.ESFFieldModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFieldPersistence
 * @see ESFFieldUtil
 * @generated
 */
public class ESFFieldPersistenceImpl extends BasePersistenceImpl<ESFField>
	implements ESFFieldPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFieldUtil} to access the e s f field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFieldImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFFieldModelImpl.UUID_COLUMN_BITMASK |
			ESFFieldModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByUuid(String uuid, int start, int end,
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

		List<ESFField> list = (List<ESFField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFField esfField : list) {
				if (!Validator.equals(uuid, esfField.getUuid())) {
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

			query.append(_SQL_SELECT_ESFFIELD_WHERE);

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
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFField>(list);
				}
				else {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByUuid_First(uuid, orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the first e s f field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFField> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByUuid_Last(uuid, orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the last e s f field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFField> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fields before and after the current e s f field in the ordered set where uuid = &#63;.
	 *
	 * @param esfFieldId the primary key of the current e s f field
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField[] findByUuid_PrevAndNext(long esfFieldId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = findByPrimaryKey(esfFieldId);

		Session session = null;

		try {
			session = openSession();

			ESFField[] array = new ESFFieldImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfField, uuid,
					orderByComparator, true);

			array[1] = esfField;

			array[2] = getByUuid_PrevAndNext(session, esfField, uuid,
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

	protected ESFField getByUuid_PrevAndNext(Session session,
		ESFField esfField, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELD_WHERE);

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
			query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fields where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFField esfField : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfField);
		}
	}

	/**
	 * Returns the number of e s f fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f fields
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

			query.append(_SQL_COUNT_ESFFIELD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfField.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfField.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfField.uuid IS NULL OR esfField.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFieldModelImpl.UUID_COLUMN_BITMASK |
			ESFFieldModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f field where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchFieldException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByUUID_G(String uuid, long groupId)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByUUID_G(uuid, groupId);

		if (esfField == null) {
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

			throw new NoSuchFieldException(msg.toString());
		}

		return esfField;
	}

	/**
	 * Returns the e s f field where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f field where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFField) {
			ESFField esfField = (ESFField)result;

			if (!Validator.equals(uuid, esfField.getUuid()) ||
					(groupId != esfField.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFFIELD_WHERE);

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

				List<ESFField> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFField esfField = list.get(0);

					result = esfField;

					cacheResult(esfField);

					if ((esfField.getUuid() == null) ||
							!esfField.getUuid().equals(uuid) ||
							(esfField.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfField);
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
			return (ESFField)result;
		}
	}

	/**
	 * Removes the e s f field where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f field that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField removeByUUID_G(String uuid, long groupId)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = findByUUID_G(uuid, groupId);

		return remove(esfField);
	}

	/**
	 * Returns the number of e s f fields where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f fields
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

			query.append(_SQL_COUNT_ESFFIELD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfField.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfField.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfField.uuid IS NULL OR esfField.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfField.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFieldModelImpl.UUID_COLUMN_BITMASK |
			ESFFieldModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFFieldModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByUuid_C(String uuid, long companyId, int start,
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

		List<ESFField> list = (List<ESFField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFField esfField : list) {
				if (!Validator.equals(uuid, esfField.getUuid()) ||
						(companyId != esfField.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFFIELD_WHERE);

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
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFField>(list);
				}
				else {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the first e s f field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFField> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the last e s f field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFField> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fields before and after the current e s f field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfFieldId the primary key of the current e s f field
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField[] findByUuid_C_PrevAndNext(long esfFieldId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = findByPrimaryKey(esfFieldId);

		Session session = null;

		try {
			session = openSession();

			ESFField[] array = new ESFFieldImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfField, uuid,
					companyId, orderByComparator, true);

			array[1] = esfField;

			array[2] = getByUuid_C_PrevAndNext(session, esfField, uuid,
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

	protected ESFField getByUuid_C_PrevAndNext(Session session,
		ESFField esfField, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELD_WHERE);

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
			query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fields where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFField esfField : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfField);
		}
	}

	/**
	 * Returns the number of e s f fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f fields
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

			query.append(_SQL_COUNT_ESFFIELD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfField.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfField.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfField.uuid IS NULL OR esfField.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfField.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFFieldModelImpl.GROUPID_COLUMN_BITMASK |
			ESFFieldModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByGroupId(long groupId, int start, int end,
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

		List<ESFField> list = (List<ESFField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFField esfField : list) {
				if ((groupId != esfField.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFFIELD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFField>(list);
				}
				else {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByGroupId_First(groupId, orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the first e s f field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFField> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByGroupId_Last(groupId, orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the last e s f field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFField> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fields before and after the current e s f field in the ordered set where groupId = &#63;.
	 *
	 * @param esfFieldId the primary key of the current e s f field
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField[] findByGroupId_PrevAndNext(long esfFieldId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = findByPrimaryKey(esfFieldId);

		Session session = null;

		try {
			session = openSession();

			ESFField[] array = new ESFFieldImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfField, groupId,
					orderByComparator, true);

			array[1] = esfField;

			array[2] = getByGroupId_PrevAndNext(session, esfField, groupId,
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

	protected ESFField getByGroupId_PrevAndNext(Session session,
		ESFField esfField, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELD_WHERE);

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
			query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e s f fields that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f fields that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of matching e s f fields that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fields that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> filterFindByGroupId(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_ESFFIELD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFFieldModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFField.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESFFieldImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESFFieldImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ESFField>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e s f fields before and after the current e s f field in the ordered set of e s f fields that the user has permission to view where groupId = &#63;.
	 *
	 * @param esfFieldId the primary key of the current e s f field
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField[] filterFindByGroupId_PrevAndNext(long esfFieldId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(esfFieldId, groupId,
				orderByComparator);
		}

		ESFField esfField = findByPrimaryKey(esfFieldId);

		Session session = null;

		try {
			session = openSession();

			ESFField[] array = new ESFFieldImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, esfField,
					groupId, orderByComparator, true);

			array[1] = esfField;

			array[2] = filterGetByGroupId_PrevAndNext(session, esfField,
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

	protected ESFField filterGetByGroupId_PrevAndNext(Session session,
		ESFField esfField, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_ESFFIELD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFFieldModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFField.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ESFFieldImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ESFFieldImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fields where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFField esfField : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfField);
		}
	}

	/**
	 * Returns the number of e s f fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f fields
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

			query.append(_SQL_COUNT_ESFFIELD_WHERE);

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
	 * Returns the number of e s f fields that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f fields that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ESFFIELD_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFField.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfField.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f fields where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
		finderArgs = new Object[] { name, start, end, orderByComparator };

		List<ESFField> list = (List<ESFField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFField esfField : list) {
				if (!StringUtil.wildcardMatches(esfField.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_ESFFIELD_WHERE);

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
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFField>(list);
				}
				else {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f field in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByName_First(name, orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the first e s f field in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFField> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByName_Last(name, orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the last e s f field in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ESFField> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fields before and after the current e s f field in the ordered set where name LIKE &#63;.
	 *
	 * @param esfFieldId the primary key of the current e s f field
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField[] findByName_PrevAndNext(long esfFieldId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = findByPrimaryKey(esfFieldId);

		Session session = null;

		try {
			session = openSession();

			ESFField[] array = new ESFFieldImpl[3];

			array[0] = getByName_PrevAndNext(session, esfField, name,
					orderByComparator, true);

			array[1] = esfField;

			array[2] = getByName_PrevAndNext(session, esfField, name,
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

	protected ESFField getByName_PrevAndNext(Session session,
		ESFField esfField, String name, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELD_WHERE);

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
			query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fields where name LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ESFField esfField : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfField);
		}
	}

	/**
	 * Returns the number of e s f fields where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFIELD_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfField.name LIKE NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfField.name LIKE ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfField.name IS NULL OR esfField.name LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNERORGANIZATIONID =
		new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOwnerOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERORGANIZATIONID =
		new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOwnerOrganizationId", new String[] { Long.class.getName() },
			ESFFieldModelImpl.OWNERORGANIZATIONID_COLUMN_BITMASK |
			ESFFieldModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNERORGANIZATIONID = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOwnerOrganizationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f fields where ownerOrganizationId = &#63;.
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @return the matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByOwnerOrganizationId(long ownerOrganizationId)
		throws SystemException {
		return findByOwnerOrganizationId(ownerOrganizationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields where ownerOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByOwnerOrganizationId(long ownerOrganizationId,
		int start, int end) throws SystemException {
		return findByOwnerOrganizationId(ownerOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields where ownerOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByOwnerOrganizationId(long ownerOrganizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERORGANIZATIONID;
			finderArgs = new Object[] { ownerOrganizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNERORGANIZATIONID;
			finderArgs = new Object[] {
					ownerOrganizationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFField> list = (List<ESFField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFField esfField : list) {
				if ((ownerOrganizationId != esfField.getOwnerOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFFIELD_WHERE);

			query.append(_FINDER_COLUMN_OWNERORGANIZATIONID_OWNERORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerOrganizationId);

				if (!pagination) {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFField>(list);
				}
				else {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f field in the ordered set where ownerOrganizationId = &#63;.
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByOwnerOrganizationId_First(long ownerOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByOwnerOrganizationId_First(ownerOrganizationId,
				orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerOrganizationId=");
		msg.append(ownerOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the first e s f field in the ordered set where ownerOrganizationId = &#63;.
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByOwnerOrganizationId_First(long ownerOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFField> list = findByOwnerOrganizationId(ownerOrganizationId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field in the ordered set where ownerOrganizationId = &#63;.
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByOwnerOrganizationId_Last(long ownerOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByOwnerOrganizationId_Last(ownerOrganizationId,
				orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerOrganizationId=");
		msg.append(ownerOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the last e s f field in the ordered set where ownerOrganizationId = &#63;.
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByOwnerOrganizationId_Last(long ownerOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOwnerOrganizationId(ownerOrganizationId);

		if (count == 0) {
			return null;
		}

		List<ESFField> list = findByOwnerOrganizationId(ownerOrganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fields before and after the current e s f field in the ordered set where ownerOrganizationId = &#63;.
	 *
	 * @param esfFieldId the primary key of the current e s f field
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField[] findByOwnerOrganizationId_PrevAndNext(long esfFieldId,
		long ownerOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = findByPrimaryKey(esfFieldId);

		Session session = null;

		try {
			session = openSession();

			ESFField[] array = new ESFFieldImpl[3];

			array[0] = getByOwnerOrganizationId_PrevAndNext(session, esfField,
					ownerOrganizationId, orderByComparator, true);

			array[1] = esfField;

			array[2] = getByOwnerOrganizationId_PrevAndNext(session, esfField,
					ownerOrganizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFField getByOwnerOrganizationId_PrevAndNext(Session session,
		ESFField esfField, long ownerOrganizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELD_WHERE);

		query.append(_FINDER_COLUMN_OWNERORGANIZATIONID_OWNERORGANIZATIONID_2);

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
			query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fields where ownerOrganizationId = &#63; from the database.
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOwnerOrganizationId(long ownerOrganizationId)
		throws SystemException {
		for (ESFField esfField : findByOwnerOrganizationId(
				ownerOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfField);
		}
	}

	/**
	 * Returns the number of e s f fields where ownerOrganizationId = &#63;.
	 *
	 * @param ownerOrganizationId the owner organization ID
	 * @return the number of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOwnerOrganizationId(long ownerOrganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OWNERORGANIZATIONID;

		Object[] finderArgs = new Object[] { ownerOrganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFIELD_WHERE);

			query.append(_FINDER_COLUMN_OWNERORGANIZATIONID_OWNERORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerOrganizationId);

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

	private static final String _FINDER_COLUMN_OWNERORGANIZATIONID_OWNERORGANIZATIONID_2 =
		"esfField.ownerOrganizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_O = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_O",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_O = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, ESFFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_O",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFFieldModelImpl.GROUPID_COLUMN_BITMASK |
			ESFFieldModelImpl.OWNERORGANIZATIONID_COLUMN_BITMASK |
			ESFFieldModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_O = new FinderPath(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_O",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f fields where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @return the matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByG_O(long groupId, long ownerOrganizationId)
		throws SystemException {
		return findByG_O(groupId, ownerOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByG_O(long groupId, long ownerOrganizationId,
		int start, int end) throws SystemException {
		return findByG_O(groupId, ownerOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findByG_O(long groupId, long ownerOrganizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_O;
			finderArgs = new Object[] { groupId, ownerOrganizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_O;
			finderArgs = new Object[] {
					groupId, ownerOrganizationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFField> list = (List<ESFField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFField esfField : list) {
				if ((groupId != esfField.getGroupId()) ||
						(ownerOrganizationId != esfField.getOwnerOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_O_GROUPID_2);

			query.append(_FINDER_COLUMN_G_O_OWNERORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(ownerOrganizationId);

				if (!pagination) {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFField>(list);
				}
				else {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f field in the ordered set where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByG_O_First(long groupId, long ownerOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByG_O_First(groupId, ownerOrganizationId,
				orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", ownerOrganizationId=");
		msg.append(ownerOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the first e s f field in the ordered set where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByG_O_First(long groupId, long ownerOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFField> list = findByG_O(groupId, ownerOrganizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f field in the ordered set where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByG_O_Last(long groupId, long ownerOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByG_O_Last(groupId, ownerOrganizationId,
				orderByComparator);

		if (esfField != null) {
			return esfField;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", ownerOrganizationId=");
		msg.append(ownerOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFieldException(msg.toString());
	}

	/**
	 * Returns the last e s f field in the ordered set where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f field, or <code>null</code> if a matching e s f field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByG_O_Last(long groupId, long ownerOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_O(groupId, ownerOrganizationId);

		if (count == 0) {
			return null;
		}

		List<ESFField> list = findByG_O(groupId, ownerOrganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f fields before and after the current e s f field in the ordered set where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param esfFieldId the primary key of the current e s f field
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField[] findByG_O_PrevAndNext(long esfFieldId, long groupId,
		long ownerOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = findByPrimaryKey(esfFieldId);

		Session session = null;

		try {
			session = openSession();

			ESFField[] array = new ESFFieldImpl[3];

			array[0] = getByG_O_PrevAndNext(session, esfField, groupId,
					ownerOrganizationId, orderByComparator, true);

			array[1] = esfField;

			array[2] = getByG_O_PrevAndNext(session, esfField, groupId,
					ownerOrganizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFField getByG_O_PrevAndNext(Session session, ESFField esfField,
		long groupId, long ownerOrganizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFIELD_WHERE);

		query.append(_FINDER_COLUMN_G_O_GROUPID_2);

		query.append(_FINDER_COLUMN_G_O_OWNERORGANIZATIONID_2);

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
			query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(ownerOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e s f fields that the user has permission to view where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @return the matching e s f fields that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> filterFindByG_O(long groupId, long ownerOrganizationId)
		throws SystemException {
		return filterFindByG_O(groupId, ownerOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields that the user has permission to view where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of matching e s f fields that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> filterFindByG_O(long groupId,
		long ownerOrganizationId, int start, int end) throws SystemException {
		return filterFindByG_O(groupId, ownerOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields that the user has permissions to view where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f fields that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> filterFindByG_O(long groupId,
		long ownerOrganizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_O(groupId, ownerOrganizationId, start, end,
				orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_ESFFIELD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_O_GROUPID_2);

		query.append(_FINDER_COLUMN_G_O_OWNERORGANIZATIONID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFFieldModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFField.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESFFieldImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESFFieldImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(ownerOrganizationId);

			return (List<ESFField>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e s f fields before and after the current e s f field in the ordered set of e s f fields that the user has permission to view where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param esfFieldId the primary key of the current e s f field
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField[] filterFindByG_O_PrevAndNext(long esfFieldId,
		long groupId, long ownerOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchFieldException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_O_PrevAndNext(esfFieldId, groupId,
				ownerOrganizationId, orderByComparator);
		}

		ESFField esfField = findByPrimaryKey(esfFieldId);

		Session session = null;

		try {
			session = openSession();

			ESFField[] array = new ESFFieldImpl[3];

			array[0] = filterGetByG_O_PrevAndNext(session, esfField, groupId,
					ownerOrganizationId, orderByComparator, true);

			array[1] = esfField;

			array[2] = filterGetByG_O_PrevAndNext(session, esfField, groupId,
					ownerOrganizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFField filterGetByG_O_PrevAndNext(Session session,
		ESFField esfField, long groupId, long ownerOrganizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_O_GROUPID_2);

		query.append(_FINDER_COLUMN_G_O_OWNERORGANIZATIONID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFFieldModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFFieldModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFField.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ESFFieldImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ESFFieldImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(ownerOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f fields where groupId = &#63; and ownerOrganizationId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_O(long groupId, long ownerOrganizationId)
		throws SystemException {
		for (ESFField esfField : findByG_O(groupId, ownerOrganizationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfField);
		}
	}

	/**
	 * Returns the number of e s f fields where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @return the number of matching e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_O(long groupId, long ownerOrganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_O;

		Object[] finderArgs = new Object[] { groupId, ownerOrganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFFIELD_WHERE);

			query.append(_FINDER_COLUMN_G_O_GROUPID_2);

			query.append(_FINDER_COLUMN_G_O_OWNERORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(ownerOrganizationId);

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
	 * Returns the number of e s f fields that the user has permission to view where groupId = &#63; and ownerOrganizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ownerOrganizationId the owner organization ID
	 * @return the number of matching e s f fields that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_O(long groupId, long ownerOrganizationId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_O(groupId, ownerOrganizationId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_ESFFIELD_WHERE);

		query.append(_FINDER_COLUMN_G_O_GROUPID_2);

		query.append(_FINDER_COLUMN_G_O_OWNERORGANIZATIONID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFField.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(ownerOrganizationId);

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

	private static final String _FINDER_COLUMN_G_O_GROUPID_2 = "esfField.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_O_OWNERORGANIZATIONID_2 = "esfField.ownerOrganizationId = ?";

	public ESFFieldPersistenceImpl() {
		setModelClass(ESFField.class);
	}

	/**
	 * Caches the e s f field in the entity cache if it is enabled.
	 *
	 * @param esfField the e s f field
	 */
	@Override
	public void cacheResult(ESFField esfField) {
		EntityCacheUtil.putResult(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldImpl.class, esfField.getPrimaryKey(), esfField);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfField.getUuid(), esfField.getGroupId() }, esfField);

		esfField.resetOriginalValues();
	}

	/**
	 * Caches the e s f fields in the entity cache if it is enabled.
	 *
	 * @param esfFields the e s f fields
	 */
	@Override
	public void cacheResult(List<ESFField> esfFields) {
		for (ESFField esfField : esfFields) {
			if (EntityCacheUtil.getResult(
						ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
						ESFFieldImpl.class, esfField.getPrimaryKey()) == null) {
				cacheResult(esfField);
			}
			else {
				esfField.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f fields.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFieldImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFieldImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f field.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFField esfField) {
		EntityCacheUtil.removeResult(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldImpl.class, esfField.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfField);
	}

	@Override
	public void clearCache(List<ESFField> esfFields) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFField esfField : esfFields) {
			EntityCacheUtil.removeResult(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
				ESFFieldImpl.class, esfField.getPrimaryKey());

			clearUniqueFindersCache(esfField);
		}
	}

	protected void cacheUniqueFindersCache(ESFField esfField) {
		if (esfField.isNew()) {
			Object[] args = new Object[] {
					esfField.getUuid(), esfField.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfField);
		}
		else {
			ESFFieldModelImpl esfFieldModelImpl = (ESFFieldModelImpl)esfField;

			if ((esfFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfField.getUuid(), esfField.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfField);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFField esfField) {
		ESFFieldModelImpl esfFieldModelImpl = (ESFFieldModelImpl)esfField;

		Object[] args = new Object[] { esfField.getUuid(), esfField.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfFieldModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfFieldModelImpl.getOriginalUuid(),
					esfFieldModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f field with the primary key. Does not add the e s f field to the database.
	 *
	 * @param esfFieldId the primary key for the new e s f field
	 * @return the new e s f field
	 */
	@Override
	public ESFField create(long esfFieldId) {
		ESFField esfField = new ESFFieldImpl();

		esfField.setNew(true);
		esfField.setPrimaryKey(esfFieldId);

		String uuid = PortalUUIDUtil.generate();

		esfField.setUuid(uuid);

		return esfField;
	}

	/**
	 * Removes the e s f field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFieldId the primary key of the e s f field
	 * @return the e s f field that was removed
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField remove(long esfFieldId)
		throws NoSuchFieldException, SystemException {
		return remove((Serializable)esfFieldId);
	}

	/**
	 * Removes the e s f field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f field
	 * @return the e s f field that was removed
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField remove(Serializable primaryKey)
		throws NoSuchFieldException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFField esfField = (ESFField)session.get(ESFFieldImpl.class,
					primaryKey);

			if (esfField == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfField);
		}
		catch (NoSuchFieldException nsee) {
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
	protected ESFField removeImpl(ESFField esfField) throws SystemException {
		esfField = toUnwrappedModel(esfField);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfField)) {
				esfField = (ESFField)session.get(ESFFieldImpl.class,
						esfField.getPrimaryKeyObj());
			}

			if (esfField != null) {
				session.delete(esfField);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfField != null) {
			clearCache(esfField);
		}

		return esfField;
	}

	@Override
	public ESFField updateImpl(it.ethica.esf.model.ESFField esfField)
		throws SystemException {
		esfField = toUnwrappedModel(esfField);

		boolean isNew = esfField.isNew();

		ESFFieldModelImpl esfFieldModelImpl = (ESFFieldModelImpl)esfField;

		if (Validator.isNull(esfField.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfField.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfField.isNew()) {
				session.save(esfField);

				esfField.setNew(false);
			}
			else {
				session.merge(esfField);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFFieldModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfFieldModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfFieldModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldModelImpl.getOriginalUuid(),
						esfFieldModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfFieldModelImpl.getUuid(),
						esfFieldModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfFieldModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldModelImpl.getOriginalOwnerOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNERORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERORGANIZATIONID,
					args);

				args = new Object[] { esfFieldModelImpl.getOwnerOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNERORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERORGANIZATIONID,
					args);
			}

			if ((esfFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_O.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFieldModelImpl.getOriginalGroupId(),
						esfFieldModelImpl.getOriginalOwnerOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_O, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_O,
					args);

				args = new Object[] {
						esfFieldModelImpl.getGroupId(),
						esfFieldModelImpl.getOwnerOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_O, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_O,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFFieldImpl.class, esfField.getPrimaryKey(), esfField);

		clearUniqueFindersCache(esfField);
		cacheUniqueFindersCache(esfField);

		return esfField;
	}

	protected ESFField toUnwrappedModel(ESFField esfField) {
		if (esfField instanceof ESFFieldImpl) {
			return esfField;
		}

		ESFFieldImpl esfFieldImpl = new ESFFieldImpl();

		esfFieldImpl.setNew(esfField.isNew());
		esfFieldImpl.setPrimaryKey(esfField.getPrimaryKey());

		esfFieldImpl.setUuid(esfField.getUuid());
		esfFieldImpl.setEsfFieldId(esfField.getEsfFieldId());
		esfFieldImpl.setGroupId(esfField.getGroupId());
		esfFieldImpl.setCompanyId(esfField.getCompanyId());
		esfFieldImpl.setUserId(esfField.getUserId());
		esfFieldImpl.setUserName(esfField.getUserName());
		esfFieldImpl.setCreateDate(esfField.getCreateDate());
		esfFieldImpl.setModifiedDate(esfField.getModifiedDate());
		esfFieldImpl.setName(esfField.getName());
		esfFieldImpl.setOwnerOrganizationId(esfField.getOwnerOrganizationId());
		esfFieldImpl.setEsfAddressId(esfField.getEsfAddressId());

		return esfFieldImpl;
	}

	/**
	 * Returns the e s f field with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f field
	 * @return the e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFieldException, SystemException {
		ESFField esfField = fetchByPrimaryKey(primaryKey);

		if (esfField == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfField;
	}

	/**
	 * Returns the e s f field with the primary key or throws a {@link it.ethica.esf.NoSuchFieldException} if it could not be found.
	 *
	 * @param esfFieldId the primary key of the e s f field
	 * @return the e s f field
	 * @throws it.ethica.esf.NoSuchFieldException if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField findByPrimaryKey(long esfFieldId)
		throws NoSuchFieldException, SystemException {
		return findByPrimaryKey((Serializable)esfFieldId);
	}

	/**
	 * Returns the e s f field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f field
	 * @return the e s f field, or <code>null</code> if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFField esfField = (ESFField)EntityCacheUtil.getResult(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
				ESFFieldImpl.class, primaryKey);

		if (esfField == _nullESFField) {
			return null;
		}

		if (esfField == null) {
			Session session = null;

			try {
				session = openSession();

				esfField = (ESFField)session.get(ESFFieldImpl.class, primaryKey);

				if (esfField != null) {
					cacheResult(esfField);
				}
				else {
					EntityCacheUtil.putResult(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
						ESFFieldImpl.class, primaryKey, _nullESFField);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFieldModelImpl.ENTITY_CACHE_ENABLED,
					ESFFieldImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfField;
	}

	/**
	 * Returns the e s f field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFieldId the primary key of the e s f field
	 * @return the e s f field, or <code>null</code> if a e s f field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFField fetchByPrimaryKey(long esfFieldId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFieldId);
	}

	/**
	 * Returns all the e s f fields.
	 *
	 * @return the e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @return the range of e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f fields
	 * @param end the upper bound of the range of e s f fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFField> findAll(int start, int end,
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

		List<ESFField> list = (List<ESFField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFIELD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFIELD;

				if (pagination) {
					sql = sql.concat(ESFFieldModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFField>(list);
				}
				else {
					list = (List<ESFField>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f fields from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFField esfField : findAll()) {
			remove(esfField);
		}
	}

	/**
	 * Returns the number of e s f fields.
	 *
	 * @return the number of e s f fields
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

				Query q = session.createQuery(_SQL_COUNT_ESFFIELD);

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
	 * Initializes the e s f field persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFField")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFField>> listenersList = new ArrayList<ModelListener<ESFField>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFField>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFieldImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFIELD = "SELECT esfField FROM ESFField esfField";
	private static final String _SQL_SELECT_ESFFIELD_WHERE = "SELECT esfField FROM ESFField esfField WHERE ";
	private static final String _SQL_COUNT_ESFFIELD = "SELECT COUNT(esfField) FROM ESFField esfField";
	private static final String _SQL_COUNT_ESFFIELD_WHERE = "SELECT COUNT(esfField) FROM ESFField esfField WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "esfField.esfFieldId";
	private static final String _FILTER_SQL_SELECT_ESFFIELD_WHERE = "SELECT DISTINCT {esfField.*} FROM ESF_ESFField esfField WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ESF_ESFField.*} FROM (SELECT DISTINCT esfField.esfFieldId FROM ESF_ESFField esfField WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFFIELD_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ESF_ESFField ON TEMP_TABLE.esfFieldId = ESF_ESFField.esfFieldId";
	private static final String _FILTER_SQL_COUNT_ESFFIELD_WHERE = "SELECT COUNT(DISTINCT esfField.esfFieldId) AS COUNT_VALUE FROM ESF_ESFField esfField WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "esfField";
	private static final String _FILTER_ENTITY_TABLE = "ESF_ESFField";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfField.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ESF_ESFField.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFField exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFField exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFieldPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFField _nullESFField = new ESFFieldImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFField> toCacheModel() {
				return _nullESFFieldCacheModel;
			}
		};

	private static CacheModel<ESFField> _nullESFFieldCacheModel = new CacheModel<ESFField>() {
			@Override
			public ESFField toEntityModel() {
				return _nullESFField;
			}
		};
}