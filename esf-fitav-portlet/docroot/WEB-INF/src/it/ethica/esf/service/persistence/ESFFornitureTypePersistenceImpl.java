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

import it.ethica.esf.NoSuchFornitureTypeException;
import it.ethica.esf.model.ESFFornitureType;
import it.ethica.esf.model.impl.ESFFornitureTypeImpl;
import it.ethica.esf.model.impl.ESFFornitureTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f forniture type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureTypePersistence
 * @see ESFFornitureTypeUtil
 * @generated
 */
public class ESFFornitureTypePersistenceImpl extends BasePersistenceImpl<ESFFornitureType>
	implements ESFFornitureTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFornitureTypeUtil} to access the e s f forniture type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFornitureTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFFornitureTypeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f forniture types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @return the range of matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByUuid(String uuid, int start, int end,
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

		List<ESFFornitureType> list = (List<ESFFornitureType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFornitureType esfFornitureType : list) {
				if (!Validator.equals(uuid, esfFornitureType.getUuid())) {
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

			query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

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
				query.append(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFFornitureType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureType>(list);
				}
				else {
					list = (List<ESFFornitureType>)QueryUtil.list(q,
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
	 * Returns the first e s f forniture type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfFornitureType != null) {
			return esfFornitureType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFornitureType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfFornitureType != null) {
			return esfFornitureType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFFornitureType> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f forniture types before and after the current e s f forniture type in the ordered set where uuid = &#63;.
	 *
	 * @param esfFornitureTypeId the primary key of the current e s f forniture type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType[] findByUuid_PrevAndNext(long esfFornitureTypeId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = findByPrimaryKey(esfFornitureTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFFornitureType[] array = new ESFFornitureTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfFornitureType, uuid,
					orderByComparator, true);

			array[1] = esfFornitureType;

			array[2] = getByUuid_PrevAndNext(session, esfFornitureType, uuid,
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

	protected ESFFornitureType getByUuid_PrevAndNext(Session session,
		ESFFornitureType esfFornitureType, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

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
			query.append(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfFornitureType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFornitureType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f forniture types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFFornitureType esfFornitureType : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFornitureType);
		}
	}

	/**
	 * Returns the number of e s f forniture types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f forniture types
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

			query.append(_SQL_COUNT_ESFFORNITURETYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfFornitureType.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfFornitureType.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfFornitureType.uuid IS NULL OR esfFornitureType.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFornitureTypeModelImpl.UUID_COLUMN_BITMASK |
			ESFFornitureTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f forniture type where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureTypeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByUUID_G(String uuid, long groupId)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByUUID_G(uuid, groupId);

		if (esfFornitureType == null) {
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

			throw new NoSuchFornitureTypeException(msg.toString());
		}

		return esfFornitureType;
	}

	/**
	 * Returns the e s f forniture type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f forniture type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFFornitureType) {
			ESFFornitureType esfFornitureType = (ESFFornitureType)result;

			if (!Validator.equals(uuid, esfFornitureType.getUuid()) ||
					(groupId != esfFornitureType.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

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

				List<ESFFornitureType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFFornitureType esfFornitureType = list.get(0);

					result = esfFornitureType;

					cacheResult(esfFornitureType);

					if ((esfFornitureType.getUuid() == null) ||
							!esfFornitureType.getUuid().equals(uuid) ||
							(esfFornitureType.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfFornitureType);
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
			return (ESFFornitureType)result;
		}
	}

	/**
	 * Removes the e s f forniture type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f forniture type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType removeByUUID_G(String uuid, long groupId)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = findByUUID_G(uuid, groupId);

		return remove(esfFornitureType);
	}

	/**
	 * Returns the number of e s f forniture types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f forniture types
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

			query.append(_SQL_COUNT_ESFFORNITURETYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfFornitureType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfFornitureType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfFornitureType.uuid IS NULL OR esfFornitureType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfFornitureType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFornitureTypeModelImpl.UUID_COLUMN_BITMASK |
			ESFFornitureTypeModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f forniture types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @return the range of matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByUuid_C(String uuid, long companyId,
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

		List<ESFFornitureType> list = (List<ESFFornitureType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFornitureType esfFornitureType : list) {
				if (!Validator.equals(uuid, esfFornitureType.getUuid()) ||
						(companyId != esfFornitureType.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

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
				query.append(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFFornitureType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureType>(list);
				}
				else {
					list = (List<ESFFornitureType>)QueryUtil.list(q,
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
	 * Returns the first e s f forniture type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (esfFornitureType != null) {
			return esfFornitureType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFornitureType> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfFornitureType != null) {
			return esfFornitureType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFFornitureType> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f forniture types before and after the current e s f forniture type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfFornitureTypeId the primary key of the current e s f forniture type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType[] findByUuid_C_PrevAndNext(
		long esfFornitureTypeId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = findByPrimaryKey(esfFornitureTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFFornitureType[] array = new ESFFornitureTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfFornitureType, uuid,
					companyId, orderByComparator, true);

			array[1] = esfFornitureType;

			array[2] = getByUuid_C_PrevAndNext(session, esfFornitureType, uuid,
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

	protected ESFFornitureType getByUuid_C_PrevAndNext(Session session,
		ESFFornitureType esfFornitureType, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

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
			query.append(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfFornitureType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFornitureType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f forniture types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFFornitureType esfFornitureType : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFornitureType);
		}
	}

	/**
	 * Returns the number of e s f forniture types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f forniture types
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

			query.append(_SQL_COUNT_ESFFORNITURETYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfFornitureType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfFornitureType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfFornitureType.uuid IS NULL OR esfFornitureType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfFornitureType.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFFornitureTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f forniture types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @return the range of matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFFornitureType> list = (List<ESFFornitureType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFornitureType esfFornitureType : list) {
				if ((groupId != esfFornitureType.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFFornitureType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureType>(list);
				}
				else {
					list = (List<ESFFornitureType>)QueryUtil.list(q,
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
	 * Returns the first e s f forniture type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByGroupId_First(groupId,
				orderByComparator);

		if (esfFornitureType != null) {
			return esfFornitureType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFornitureType> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (esfFornitureType != null) {
			return esfFornitureType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFFornitureType> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f forniture types before and after the current e s f forniture type in the ordered set where groupId = &#63;.
	 *
	 * @param esfFornitureTypeId the primary key of the current e s f forniture type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType[] findByGroupId_PrevAndNext(
		long esfFornitureTypeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = findByPrimaryKey(esfFornitureTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFFornitureType[] array = new ESFFornitureTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfFornitureType,
					groupId, orderByComparator, true);

			array[1] = esfFornitureType;

			array[2] = getByGroupId_PrevAndNext(session, esfFornitureType,
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

	protected ESFFornitureType getByGroupId_PrevAndNext(Session session,
		ESFFornitureType esfFornitureType, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

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
			query.append(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFornitureType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFornitureType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f forniture types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFFornitureType esfFornitureType : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFornitureType);
		}
	}

	/**
	 * Returns the number of e s f forniture types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f forniture types
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

			query.append(_SQL_COUNT_ESFFORNITURETYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfFornitureType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDescription",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDescription",
			new String[] { String.class.getName() },
			ESFFornitureTypeModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescription",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f forniture types where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByDescription(String description)
		throws SystemException {
		return findByDescription(description, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture types where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @return the range of matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByDescription(String description,
		int start, int end) throws SystemException {
		return findByDescription(description, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture types where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findByDescription(String description,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION;
			finderArgs = new Object[] { description };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION;
			finderArgs = new Object[] { description, start, end, orderByComparator };
		}

		List<ESFFornitureType> list = (List<ESFFornitureType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFornitureType esfFornitureType : list) {
				if (!Validator.equals(description,
							esfFornitureType.getDescription())) {
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

			query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<ESFFornitureType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureType>(list);
				}
				else {
					list = (List<ESFFornitureType>)QueryUtil.list(q,
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
	 * Returns the first e s f forniture type in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByDescription_First(String description,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByDescription_First(description,
				orderByComparator);

		if (esfFornitureType != null) {
			return esfFornitureType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture type in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByDescription_First(String description,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFornitureType> list = findByDescription(description, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture type in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByDescription_Last(String description,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByDescription_Last(description,
				orderByComparator);

		if (esfFornitureType != null) {
			return esfFornitureType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture type in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByDescription_Last(String description,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDescription(description);

		if (count == 0) {
			return null;
		}

		List<ESFFornitureType> list = findByDescription(description, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f forniture types before and after the current e s f forniture type in the ordered set where description = &#63;.
	 *
	 * @param esfFornitureTypeId the primary key of the current e s f forniture type
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType[] findByDescription_PrevAndNext(
		long esfFornitureTypeId, String description,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = findByPrimaryKey(esfFornitureTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFFornitureType[] array = new ESFFornitureTypeImpl[3];

			array[0] = getByDescription_PrevAndNext(session, esfFornitureType,
					description, orderByComparator, true);

			array[1] = esfFornitureType;

			array[2] = getByDescription_PrevAndNext(session, esfFornitureType,
					description, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFornitureType getByDescription_PrevAndNext(Session session,
		ESFFornitureType esfFornitureType, String description,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITURETYPE_WHERE);

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
			query.append(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDescription) {
			qPos.add(description);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFornitureType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFornitureType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f forniture types where description = &#63; from the database.
	 *
	 * @param description the description
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDescription(String description)
		throws SystemException {
		for (ESFFornitureType esfFornitureType : findByDescription(
				description, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFornitureType);
		}
	}

	/**
	 * Returns the number of e s f forniture types where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching e s f forniture types
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

			query.append(_SQL_COUNT_ESFFORNITURETYPE_WHERE);

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

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1 = "esfFornitureType.description IS NULL";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 = "esfFornitureType.description = ?";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3 = "(esfFornitureType.description IS NULL OR esfFornitureType.description = '')";

	public ESFFornitureTypePersistenceImpl() {
		setModelClass(ESFFornitureType.class);
	}

	/**
	 * Caches the e s f forniture type in the entity cache if it is enabled.
	 *
	 * @param esfFornitureType the e s f forniture type
	 */
	@Override
	public void cacheResult(ESFFornitureType esfFornitureType) {
		EntityCacheUtil.putResult(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, esfFornitureType.getPrimaryKey(),
			esfFornitureType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				esfFornitureType.getUuid(), esfFornitureType.getGroupId()
			}, esfFornitureType);

		esfFornitureType.resetOriginalValues();
	}

	/**
	 * Caches the e s f forniture types in the entity cache if it is enabled.
	 *
	 * @param esfFornitureTypes the e s f forniture types
	 */
	@Override
	public void cacheResult(List<ESFFornitureType> esfFornitureTypes) {
		for (ESFFornitureType esfFornitureType : esfFornitureTypes) {
			if (EntityCacheUtil.getResult(
						ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFFornitureTypeImpl.class,
						esfFornitureType.getPrimaryKey()) == null) {
				cacheResult(esfFornitureType);
			}
			else {
				esfFornitureType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f forniture types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFornitureTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFornitureTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f forniture type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFFornitureType esfFornitureType) {
		EntityCacheUtil.removeResult(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, esfFornitureType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfFornitureType);
	}

	@Override
	public void clearCache(List<ESFFornitureType> esfFornitureTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFFornitureType esfFornitureType : esfFornitureTypes) {
			EntityCacheUtil.removeResult(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFFornitureTypeImpl.class, esfFornitureType.getPrimaryKey());

			clearUniqueFindersCache(esfFornitureType);
		}
	}

	protected void cacheUniqueFindersCache(ESFFornitureType esfFornitureType) {
		if (esfFornitureType.isNew()) {
			Object[] args = new Object[] {
					esfFornitureType.getUuid(), esfFornitureType.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfFornitureType);
		}
		else {
			ESFFornitureTypeModelImpl esfFornitureTypeModelImpl = (ESFFornitureTypeModelImpl)esfFornitureType;

			if ((esfFornitureTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureType.getUuid(),
						esfFornitureType.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfFornitureType);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFFornitureType esfFornitureType) {
		ESFFornitureTypeModelImpl esfFornitureTypeModelImpl = (ESFFornitureTypeModelImpl)esfFornitureType;

		Object[] args = new Object[] {
				esfFornitureType.getUuid(), esfFornitureType.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfFornitureTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfFornitureTypeModelImpl.getOriginalUuid(),
					esfFornitureTypeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f forniture type with the primary key. Does not add the e s f forniture type to the database.
	 *
	 * @param esfFornitureTypeId the primary key for the new e s f forniture type
	 * @return the new e s f forniture type
	 */
	@Override
	public ESFFornitureType create(long esfFornitureTypeId) {
		ESFFornitureType esfFornitureType = new ESFFornitureTypeImpl();

		esfFornitureType.setNew(true);
		esfFornitureType.setPrimaryKey(esfFornitureTypeId);

		String uuid = PortalUUIDUtil.generate();

		esfFornitureType.setUuid(uuid);

		return esfFornitureType;
	}

	/**
	 * Removes the e s f forniture type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFornitureTypeId the primary key of the e s f forniture type
	 * @return the e s f forniture type that was removed
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType remove(long esfFornitureTypeId)
		throws NoSuchFornitureTypeException, SystemException {
		return remove((Serializable)esfFornitureTypeId);
	}

	/**
	 * Removes the e s f forniture type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f forniture type
	 * @return the e s f forniture type that was removed
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType remove(Serializable primaryKey)
		throws NoSuchFornitureTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFFornitureType esfFornitureType = (ESFFornitureType)session.get(ESFFornitureTypeImpl.class,
					primaryKey);

			if (esfFornitureType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFornitureTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfFornitureType);
		}
		catch (NoSuchFornitureTypeException nsee) {
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
	protected ESFFornitureType removeImpl(ESFFornitureType esfFornitureType)
		throws SystemException {
		esfFornitureType = toUnwrappedModel(esfFornitureType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfFornitureType)) {
				esfFornitureType = (ESFFornitureType)session.get(ESFFornitureTypeImpl.class,
						esfFornitureType.getPrimaryKeyObj());
			}

			if (esfFornitureType != null) {
				session.delete(esfFornitureType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfFornitureType != null) {
			clearCache(esfFornitureType);
		}

		return esfFornitureType;
	}

	@Override
	public ESFFornitureType updateImpl(
		it.ethica.esf.model.ESFFornitureType esfFornitureType)
		throws SystemException {
		esfFornitureType = toUnwrappedModel(esfFornitureType);

		boolean isNew = esfFornitureType.isNew();

		ESFFornitureTypeModelImpl esfFornitureTypeModelImpl = (ESFFornitureTypeModelImpl)esfFornitureType;

		if (Validator.isNull(esfFornitureType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfFornitureType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfFornitureType.isNew()) {
				session.save(esfFornitureType);

				esfFornitureType.setNew(false);
			}
			else {
				session.merge(esfFornitureType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFFornitureTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFornitureTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureTypeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfFornitureTypeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfFornitureTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureTypeModelImpl.getOriginalUuid(),
						esfFornitureTypeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfFornitureTypeModelImpl.getUuid(),
						esfFornitureTypeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfFornitureTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfFornitureTypeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfFornitureTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureTypeModelImpl.getOriginalDescription()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);

				args = new Object[] { esfFornitureTypeModelImpl.getDescription() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureTypeImpl.class, esfFornitureType.getPrimaryKey(),
			esfFornitureType);

		clearUniqueFindersCache(esfFornitureType);
		cacheUniqueFindersCache(esfFornitureType);

		return esfFornitureType;
	}

	protected ESFFornitureType toUnwrappedModel(
		ESFFornitureType esfFornitureType) {
		if (esfFornitureType instanceof ESFFornitureTypeImpl) {
			return esfFornitureType;
		}

		ESFFornitureTypeImpl esfFornitureTypeImpl = new ESFFornitureTypeImpl();

		esfFornitureTypeImpl.setNew(esfFornitureType.isNew());
		esfFornitureTypeImpl.setPrimaryKey(esfFornitureType.getPrimaryKey());

		esfFornitureTypeImpl.setUuid(esfFornitureType.getUuid());
		esfFornitureTypeImpl.setEsfFornitureTypeId(esfFornitureType.getEsfFornitureTypeId());
		esfFornitureTypeImpl.setDescription(esfFornitureType.getDescription());
		esfFornitureTypeImpl.setGroupId(esfFornitureType.getGroupId());
		esfFornitureTypeImpl.setCompanyId(esfFornitureType.getCompanyId());
		esfFornitureTypeImpl.setUserId(esfFornitureType.getUserId());
		esfFornitureTypeImpl.setUserName(esfFornitureType.getUserName());
		esfFornitureTypeImpl.setCreateDate(esfFornitureType.getCreateDate());
		esfFornitureTypeImpl.setModifiedDate(esfFornitureType.getModifiedDate());

		return esfFornitureTypeImpl;
	}

	/**
	 * Returns the e s f forniture type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f forniture type
	 * @return the e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFornitureTypeException, SystemException {
		ESFFornitureType esfFornitureType = fetchByPrimaryKey(primaryKey);

		if (esfFornitureType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFornitureTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfFornitureType;
	}

	/**
	 * Returns the e s f forniture type with the primary key or throws a {@link it.ethica.esf.NoSuchFornitureTypeException} if it could not be found.
	 *
	 * @param esfFornitureTypeId the primary key of the e s f forniture type
	 * @return the e s f forniture type
	 * @throws it.ethica.esf.NoSuchFornitureTypeException if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType findByPrimaryKey(long esfFornitureTypeId)
		throws NoSuchFornitureTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfFornitureTypeId);
	}

	/**
	 * Returns the e s f forniture type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f forniture type
	 * @return the e s f forniture type, or <code>null</code> if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFFornitureType esfFornitureType = (ESFFornitureType)EntityCacheUtil.getResult(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFFornitureTypeImpl.class, primaryKey);

		if (esfFornitureType == _nullESFFornitureType) {
			return null;
		}

		if (esfFornitureType == null) {
			Session session = null;

			try {
				session = openSession();

				esfFornitureType = (ESFFornitureType)session.get(ESFFornitureTypeImpl.class,
						primaryKey);

				if (esfFornitureType != null) {
					cacheResult(esfFornitureType);
				}
				else {
					EntityCacheUtil.putResult(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFFornitureTypeImpl.class, primaryKey,
						_nullESFFornitureType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFornitureTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFFornitureTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfFornitureType;
	}

	/**
	 * Returns the e s f forniture type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFornitureTypeId the primary key of the e s f forniture type
	 * @return the e s f forniture type, or <code>null</code> if a e s f forniture type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureType fetchByPrimaryKey(long esfFornitureTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFornitureTypeId);
	}

	/**
	 * Returns all the e s f forniture types.
	 *
	 * @return the e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @return the range of e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f forniture types
	 * @param end the upper bound of the range of e s f forniture types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f forniture types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureType> findAll(int start, int end,
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

		List<ESFFornitureType> list = (List<ESFFornitureType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFORNITURETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFORNITURETYPE;

				if (pagination) {
					sql = sql.concat(ESFFornitureTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFFornitureType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureType>(list);
				}
				else {
					list = (List<ESFFornitureType>)QueryUtil.list(q,
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
	 * Removes all the e s f forniture types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFFornitureType esfFornitureType : findAll()) {
			remove(esfFornitureType);
		}
	}

	/**
	 * Returns the number of e s f forniture types.
	 *
	 * @return the number of e s f forniture types
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

				Query q = session.createQuery(_SQL_COUNT_ESFFORNITURETYPE);

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
	 * Initializes the e s f forniture type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFFornitureType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFFornitureType>> listenersList = new ArrayList<ModelListener<ESFFornitureType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFFornitureType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFornitureTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFORNITURETYPE = "SELECT esfFornitureType FROM ESFFornitureType esfFornitureType";
	private static final String _SQL_SELECT_ESFFORNITURETYPE_WHERE = "SELECT esfFornitureType FROM ESFFornitureType esfFornitureType WHERE ";
	private static final String _SQL_COUNT_ESFFORNITURETYPE = "SELECT COUNT(esfFornitureType) FROM ESFFornitureType esfFornitureType";
	private static final String _SQL_COUNT_ESFFORNITURETYPE_WHERE = "SELECT COUNT(esfFornitureType) FROM ESFFornitureType esfFornitureType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfFornitureType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFFornitureType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFFornitureType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFornitureTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFFornitureType _nullESFFornitureType = new ESFFornitureTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFFornitureType> toCacheModel() {
				return _nullESFFornitureTypeCacheModel;
			}
		};

	private static CacheModel<ESFFornitureType> _nullESFFornitureTypeCacheModel = new CacheModel<ESFFornitureType>() {
			@Override
			public ESFFornitureType toEntityModel() {
				return _nullESFFornitureType;
			}
		};
}