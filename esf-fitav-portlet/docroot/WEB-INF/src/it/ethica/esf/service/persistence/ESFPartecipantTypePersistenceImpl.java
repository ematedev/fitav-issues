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

import it.ethica.esf.NoSuchPartecipantTypeException;
import it.ethica.esf.model.ESFPartecipantType;
import it.ethica.esf.model.impl.ESFPartecipantTypeImpl;
import it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f partecipant type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantTypePersistence
 * @see ESFPartecipantTypeUtil
 * @generated
 */
public class ESFPartecipantTypePersistenceImpl extends BasePersistenceImpl<ESFPartecipantType>
	implements ESFPartecipantTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFPartecipantTypeUtil} to access the e s f partecipant type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFPartecipantTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFPartecipantTypeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f partecipant types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f partecipant types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantType> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f partecipant types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f partecipant types
	 * @param end the upper bound of the range of e s f partecipant types (not inclusive)
	 * @return the range of matching e s f partecipant types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantType> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipant types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f partecipant types
	 * @param end the upper bound of the range of e s f partecipant types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f partecipant types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantType> findByUuid(String uuid, int start, int end,
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

		List<ESFPartecipantType> list = (List<ESFPartecipantType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFPartecipantType esfPartecipantType : list) {
				if (!Validator.equals(uuid, esfPartecipantType.getUuid())) {
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

			query.append(_SQL_SELECT_ESFPARTECIPANTTYPE_WHERE);

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
				query.append(ESFPartecipantTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFPartecipantType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipantType>(list);
				}
				else {
					list = (List<ESFPartecipantType>)QueryUtil.list(q,
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
	 * Returns the first e s f partecipant type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant type
	 * @throws it.ethica.esf.NoSuchPartecipantTypeException if a matching e s f partecipant type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantTypeException, SystemException {
		ESFPartecipantType esfPartecipantType = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfPartecipantType != null) {
			return esfPartecipantType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f partecipant type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant type, or <code>null</code> if a matching e s f partecipant type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFPartecipantType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f partecipant type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant type
	 * @throws it.ethica.esf.NoSuchPartecipantTypeException if a matching e s f partecipant type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantTypeException, SystemException {
		ESFPartecipantType esfPartecipantType = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfPartecipantType != null) {
			return esfPartecipantType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f partecipant type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant type, or <code>null</code> if a matching e s f partecipant type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFPartecipantType> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f partecipant types before and after the current e s f partecipant type in the ordered set where uuid = &#63;.
	 *
	 * @param esfPartecipantTypeId the primary key of the current e s f partecipant type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f partecipant type
	 * @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType[] findByUuid_PrevAndNext(
		long esfPartecipantTypeId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantTypeException, SystemException {
		ESFPartecipantType esfPartecipantType = findByPrimaryKey(esfPartecipantTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFPartecipantType[] array = new ESFPartecipantTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfPartecipantType, uuid,
					orderByComparator, true);

			array[1] = esfPartecipantType;

			array[2] = getByUuid_PrevAndNext(session, esfPartecipantType, uuid,
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

	protected ESFPartecipantType getByUuid_PrevAndNext(Session session,
		ESFPartecipantType esfPartecipantType, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPARTECIPANTTYPE_WHERE);

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
			query.append(ESFPartecipantTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfPartecipantType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFPartecipantType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f partecipant types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFPartecipantType esfPartecipantType : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfPartecipantType);
		}
	}

	/**
	 * Returns the number of e s f partecipant types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f partecipant types
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

			query.append(_SQL_COUNT_ESFPARTECIPANTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfPartecipantType.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfPartecipantType.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfPartecipantType.uuid IS NULL OR esfPartecipantType.uuid = '')";

	public ESFPartecipantTypePersistenceImpl() {
		setModelClass(ESFPartecipantType.class);
	}

	/**
	 * Caches the e s f partecipant type in the entity cache if it is enabled.
	 *
	 * @param esfPartecipantType the e s f partecipant type
	 */
	@Override
	public void cacheResult(ESFPartecipantType esfPartecipantType) {
		EntityCacheUtil.putResult(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeImpl.class, esfPartecipantType.getPrimaryKey(),
			esfPartecipantType);

		esfPartecipantType.resetOriginalValues();
	}

	/**
	 * Caches the e s f partecipant types in the entity cache if it is enabled.
	 *
	 * @param esfPartecipantTypes the e s f partecipant types
	 */
	@Override
	public void cacheResult(List<ESFPartecipantType> esfPartecipantTypes) {
		for (ESFPartecipantType esfPartecipantType : esfPartecipantTypes) {
			if (EntityCacheUtil.getResult(
						ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFPartecipantTypeImpl.class,
						esfPartecipantType.getPrimaryKey()) == null) {
				cacheResult(esfPartecipantType);
			}
			else {
				esfPartecipantType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f partecipant types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFPartecipantTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFPartecipantTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f partecipant type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFPartecipantType esfPartecipantType) {
		EntityCacheUtil.removeResult(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeImpl.class, esfPartecipantType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFPartecipantType> esfPartecipantTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFPartecipantType esfPartecipantType : esfPartecipantTypes) {
			EntityCacheUtil.removeResult(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFPartecipantTypeImpl.class, esfPartecipantType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f partecipant type with the primary key. Does not add the e s f partecipant type to the database.
	 *
	 * @param esfPartecipantTypeId the primary key for the new e s f partecipant type
	 * @return the new e s f partecipant type
	 */
	@Override
	public ESFPartecipantType create(long esfPartecipantTypeId) {
		ESFPartecipantType esfPartecipantType = new ESFPartecipantTypeImpl();

		esfPartecipantType.setNew(true);
		esfPartecipantType.setPrimaryKey(esfPartecipantTypeId);

		String uuid = PortalUUIDUtil.generate();

		esfPartecipantType.setUuid(uuid);

		return esfPartecipantType;
	}

	/**
	 * Removes the e s f partecipant type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfPartecipantTypeId the primary key of the e s f partecipant type
	 * @return the e s f partecipant type that was removed
	 * @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType remove(long esfPartecipantTypeId)
		throws NoSuchPartecipantTypeException, SystemException {
		return remove((Serializable)esfPartecipantTypeId);
	}

	/**
	 * Removes the e s f partecipant type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f partecipant type
	 * @return the e s f partecipant type that was removed
	 * @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType remove(Serializable primaryKey)
		throws NoSuchPartecipantTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFPartecipantType esfPartecipantType = (ESFPartecipantType)session.get(ESFPartecipantTypeImpl.class,
					primaryKey);

			if (esfPartecipantType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPartecipantTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfPartecipantType);
		}
		catch (NoSuchPartecipantTypeException nsee) {
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
	protected ESFPartecipantType removeImpl(
		ESFPartecipantType esfPartecipantType) throws SystemException {
		esfPartecipantType = toUnwrappedModel(esfPartecipantType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfPartecipantType)) {
				esfPartecipantType = (ESFPartecipantType)session.get(ESFPartecipantTypeImpl.class,
						esfPartecipantType.getPrimaryKeyObj());
			}

			if (esfPartecipantType != null) {
				session.delete(esfPartecipantType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfPartecipantType != null) {
			clearCache(esfPartecipantType);
		}

		return esfPartecipantType;
	}

	@Override
	public ESFPartecipantType updateImpl(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType)
		throws SystemException {
		esfPartecipantType = toUnwrappedModel(esfPartecipantType);

		boolean isNew = esfPartecipantType.isNew();

		ESFPartecipantTypeModelImpl esfPartecipantTypeModelImpl = (ESFPartecipantTypeModelImpl)esfPartecipantType;

		if (Validator.isNull(esfPartecipantType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfPartecipantType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfPartecipantType.isNew()) {
				session.save(esfPartecipantType);

				esfPartecipantType.setNew(false);
			}
			else {
				session.merge(esfPartecipantType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFPartecipantTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfPartecipantTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfPartecipantTypeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfPartecipantTypeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantTypeImpl.class, esfPartecipantType.getPrimaryKey(),
			esfPartecipantType);

		return esfPartecipantType;
	}

	protected ESFPartecipantType toUnwrappedModel(
		ESFPartecipantType esfPartecipantType) {
		if (esfPartecipantType instanceof ESFPartecipantTypeImpl) {
			return esfPartecipantType;
		}

		ESFPartecipantTypeImpl esfPartecipantTypeImpl = new ESFPartecipantTypeImpl();

		esfPartecipantTypeImpl.setNew(esfPartecipantType.isNew());
		esfPartecipantTypeImpl.setPrimaryKey(esfPartecipantType.getPrimaryKey());

		esfPartecipantTypeImpl.setUuid(esfPartecipantType.getUuid());
		esfPartecipantTypeImpl.setEsfPartecipantTypeId(esfPartecipantType.getEsfPartecipantTypeId());
		esfPartecipantTypeImpl.setName(esfPartecipantType.getName());

		return esfPartecipantTypeImpl;
	}

	/**
	 * Returns the e s f partecipant type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f partecipant type
	 * @return the e s f partecipant type
	 * @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPartecipantTypeException, SystemException {
		ESFPartecipantType esfPartecipantType = fetchByPrimaryKey(primaryKey);

		if (esfPartecipantType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPartecipantTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfPartecipantType;
	}

	/**
	 * Returns the e s f partecipant type with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantTypeException} if it could not be found.
	 *
	 * @param esfPartecipantTypeId the primary key of the e s f partecipant type
	 * @return the e s f partecipant type
	 * @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType findByPrimaryKey(long esfPartecipantTypeId)
		throws NoSuchPartecipantTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfPartecipantTypeId);
	}

	/**
	 * Returns the e s f partecipant type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f partecipant type
	 * @return the e s f partecipant type, or <code>null</code> if a e s f partecipant type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFPartecipantType esfPartecipantType = (ESFPartecipantType)EntityCacheUtil.getResult(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFPartecipantTypeImpl.class, primaryKey);

		if (esfPartecipantType == _nullESFPartecipantType) {
			return null;
		}

		if (esfPartecipantType == null) {
			Session session = null;

			try {
				session = openSession();

				esfPartecipantType = (ESFPartecipantType)session.get(ESFPartecipantTypeImpl.class,
						primaryKey);

				if (esfPartecipantType != null) {
					cacheResult(esfPartecipantType);
				}
				else {
					EntityCacheUtil.putResult(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFPartecipantTypeImpl.class, primaryKey,
						_nullESFPartecipantType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFPartecipantTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFPartecipantTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfPartecipantType;
	}

	/**
	 * Returns the e s f partecipant type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfPartecipantTypeId the primary key of the e s f partecipant type
	 * @return the e s f partecipant type, or <code>null</code> if a e s f partecipant type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantType fetchByPrimaryKey(long esfPartecipantTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfPartecipantTypeId);
	}

	/**
	 * Returns all the e s f partecipant types.
	 *
	 * @return the e s f partecipant types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f partecipant types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f partecipant types
	 * @param end the upper bound of the range of e s f partecipant types (not inclusive)
	 * @return the range of e s f partecipant types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipant types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f partecipant types
	 * @param end the upper bound of the range of e s f partecipant types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f partecipant types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantType> findAll(int start, int end,
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

		List<ESFPartecipantType> list = (List<ESFPartecipantType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFPARTECIPANTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFPARTECIPANTTYPE;

				if (pagination) {
					sql = sql.concat(ESFPartecipantTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFPartecipantType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipantType>(list);
				}
				else {
					list = (List<ESFPartecipantType>)QueryUtil.list(q,
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
	 * Removes all the e s f partecipant types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFPartecipantType esfPartecipantType : findAll()) {
			remove(esfPartecipantType);
		}
	}

	/**
	 * Returns the number of e s f partecipant types.
	 *
	 * @return the number of e s f partecipant types
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

				Query q = session.createQuery(_SQL_COUNT_ESFPARTECIPANTTYPE);

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
	 * Initializes the e s f partecipant type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFPartecipantType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFPartecipantType>> listenersList = new ArrayList<ModelListener<ESFPartecipantType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFPartecipantType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFPartecipantTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFPARTECIPANTTYPE = "SELECT esfPartecipantType FROM ESFPartecipantType esfPartecipantType";
	private static final String _SQL_SELECT_ESFPARTECIPANTTYPE_WHERE = "SELECT esfPartecipantType FROM ESFPartecipantType esfPartecipantType WHERE ";
	private static final String _SQL_COUNT_ESFPARTECIPANTTYPE = "SELECT COUNT(esfPartecipantType) FROM ESFPartecipantType esfPartecipantType";
	private static final String _SQL_COUNT_ESFPARTECIPANTTYPE_WHERE = "SELECT COUNT(esfPartecipantType) FROM ESFPartecipantType esfPartecipantType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfPartecipantType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFPartecipantType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFPartecipantType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFPartecipantTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFPartecipantType _nullESFPartecipantType = new ESFPartecipantTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFPartecipantType> toCacheModel() {
				return _nullESFPartecipantTypeCacheModel;
			}
		};

	private static CacheModel<ESFPartecipantType> _nullESFPartecipantTypeCacheModel =
		new CacheModel<ESFPartecipantType>() {
			@Override
			public ESFPartecipantType toEntityModel() {
				return _nullESFPartecipantType;
			}
		};
}