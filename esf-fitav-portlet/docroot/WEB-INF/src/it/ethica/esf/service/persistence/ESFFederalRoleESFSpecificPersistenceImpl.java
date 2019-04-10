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

import it.ethica.esf.NoSuchFederalRoleESFSpecificException;
import it.ethica.esf.model.ESFFederalRoleESFSpecific;
import it.ethica.esf.model.impl.ESFFederalRoleESFSpecificImpl;
import it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f federal role e s f specific service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFederalRoleESFSpecificPersistence
 * @see ESFFederalRoleESFSpecificUtil
 * @generated
 */
public class ESFFederalRoleESFSpecificPersistenceImpl
	extends BasePersistenceImpl<ESFFederalRoleESFSpecific>
	implements ESFFederalRoleESFSpecificPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFederalRoleESFSpecificUtil} to access the e s f federal role e s f specific persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFederalRoleESFSpecificImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFFederalRoleESFSpecificModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the e s f federal role e s f specifics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f federal role e s f specifics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f federal role e s f specifics
	 * @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	 * @return the range of matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f federal role e s f specifics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f federal role e s f specifics
	 * @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFFederalRoleESFSpecific> list = (List<ESFFederalRoleESFSpecific>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : list) {
				if (!Validator.equals(uuid, esfFederalRoleESFSpecific.getUuid())) {
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

			query.append(_SQL_SELECT_ESFFEDERALROLEESFSPECIFIC_WHERE);

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
				query.append(ESFFederalRoleESFSpecificModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFFederalRoleESFSpecific>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFederalRoleESFSpecific>(list);
				}
				else {
					list = (List<ESFFederalRoleESFSpecific>)QueryUtil.list(q,
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
	 * Returns the first e s f federal role e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfFederalRoleESFSpecific != null) {
			return esfFederalRoleESFSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleESFSpecificException(msg.toString());
	}

	/**
	 * Returns the first e s f federal role e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFederalRoleESFSpecific> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f federal role e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfFederalRoleESFSpecific != null) {
			return esfFederalRoleESFSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleESFSpecificException(msg.toString());
	}

	/**
	 * Returns the last e s f federal role e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFFederalRoleESFSpecific> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f federal role e s f specifics before and after the current e s f federal role e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param esfFederalRoleESFSpecificPK the primary key of the current e s f federal role e s f specific
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific[] findByUuid_PrevAndNext(
		ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = findByPrimaryKey(esfFederalRoleESFSpecificPK);

		Session session = null;

		try {
			session = openSession();

			ESFFederalRoleESFSpecific[] array = new ESFFederalRoleESFSpecificImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					esfFederalRoleESFSpecific, uuid, orderByComparator, true);

			array[1] = esfFederalRoleESFSpecific;

			array[2] = getByUuid_PrevAndNext(session,
					esfFederalRoleESFSpecific, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFederalRoleESFSpecific getByUuid_PrevAndNext(Session session,
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFEDERALROLEESFSPECIFIC_WHERE);

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
			query.append(ESFFederalRoleESFSpecificModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfFederalRoleESFSpecific);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFederalRoleESFSpecific> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f federal role e s f specifics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFederalRoleESFSpecific);
		}
	}

	/**
	 * Returns the number of e s f federal role e s f specifics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f federal role e s f specifics
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

			query.append(_SQL_COUNT_ESFFEDERALROLEESFSPECIFIC_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfFederalRoleESFSpecific.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfFederalRoleESFSpecific.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfFederalRoleESFSpecific.uuid IS NULL OR esfFederalRoleESFSpecific.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPECIFIC = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySpecific",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPECIFIC =
		new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySpecific",
			new String[] { Long.class.getName() },
			ESFFederalRoleESFSpecificModelImpl.ESFSPECIFICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPECIFIC = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySpecific", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f federal role e s f specifics where esfSpecificId = &#63;.
	 *
	 * @param esfSpecificId the esf specific ID
	 * @return the matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findBySpecific(long esfSpecificId)
		throws SystemException {
		return findBySpecific(esfSpecificId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f federal role e s f specifics where esfSpecificId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfSpecificId the esf specific ID
	 * @param start the lower bound of the range of e s f federal role e s f specifics
	 * @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	 * @return the range of matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findBySpecific(long esfSpecificId,
		int start, int end) throws SystemException {
		return findBySpecific(esfSpecificId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f federal role e s f specifics where esfSpecificId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfSpecificId the esf specific ID
	 * @param start the lower bound of the range of e s f federal role e s f specifics
	 * @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findBySpecific(long esfSpecificId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPECIFIC;
			finderArgs = new Object[] { esfSpecificId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPECIFIC;
			finderArgs = new Object[] {
					esfSpecificId,
					
					start, end, orderByComparator
				};
		}

		List<ESFFederalRoleESFSpecific> list = (List<ESFFederalRoleESFSpecific>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : list) {
				if ((esfSpecificId != esfFederalRoleESFSpecific.getEsfSpecificId())) {
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

			query.append(_SQL_SELECT_ESFFEDERALROLEESFSPECIFIC_WHERE);

			query.append(_FINDER_COLUMN_SPECIFIC_ESFSPECIFICID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFederalRoleESFSpecificModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfSpecificId);

				if (!pagination) {
					list = (List<ESFFederalRoleESFSpecific>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFederalRoleESFSpecific>(list);
				}
				else {
					list = (List<ESFFederalRoleESFSpecific>)QueryUtil.list(q,
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
	 * Returns the first e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	 *
	 * @param esfSpecificId the esf specific ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific findBySpecific_First(long esfSpecificId,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = fetchBySpecific_First(esfSpecificId,
				orderByComparator);

		if (esfFederalRoleESFSpecific != null) {
			return esfFederalRoleESFSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfSpecificId=");
		msg.append(esfSpecificId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleESFSpecificException(msg.toString());
	}

	/**
	 * Returns the first e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	 *
	 * @param esfSpecificId the esf specific ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific fetchBySpecific_First(long esfSpecificId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFederalRoleESFSpecific> list = findBySpecific(esfSpecificId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	 *
	 * @param esfSpecificId the esf specific ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific findBySpecific_Last(long esfSpecificId,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = fetchBySpecific_Last(esfSpecificId,
				orderByComparator);

		if (esfFederalRoleESFSpecific != null) {
			return esfFederalRoleESFSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfSpecificId=");
		msg.append(esfSpecificId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleESFSpecificException(msg.toString());
	}

	/**
	 * Returns the last e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	 *
	 * @param esfSpecificId the esf specific ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific fetchBySpecific_Last(long esfSpecificId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySpecific(esfSpecificId);

		if (count == 0) {
			return null;
		}

		List<ESFFederalRoleESFSpecific> list = findBySpecific(esfSpecificId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f federal role e s f specifics before and after the current e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	 *
	 * @param esfFederalRoleESFSpecificPK the primary key of the current e s f federal role e s f specific
	 * @param esfSpecificId the esf specific ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific[] findBySpecific_PrevAndNext(
		ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK,
		long esfSpecificId, OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = findByPrimaryKey(esfFederalRoleESFSpecificPK);

		Session session = null;

		try {
			session = openSession();

			ESFFederalRoleESFSpecific[] array = new ESFFederalRoleESFSpecificImpl[3];

			array[0] = getBySpecific_PrevAndNext(session,
					esfFederalRoleESFSpecific, esfSpecificId,
					orderByComparator, true);

			array[1] = esfFederalRoleESFSpecific;

			array[2] = getBySpecific_PrevAndNext(session,
					esfFederalRoleESFSpecific, esfSpecificId,
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

	protected ESFFederalRoleESFSpecific getBySpecific_PrevAndNext(
		Session session, ESFFederalRoleESFSpecific esfFederalRoleESFSpecific,
		long esfSpecificId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFEDERALROLEESFSPECIFIC_WHERE);

		query.append(_FINDER_COLUMN_SPECIFIC_ESFSPECIFICID_2);

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
			query.append(ESFFederalRoleESFSpecificModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfSpecificId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFederalRoleESFSpecific);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFederalRoleESFSpecific> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f federal role e s f specifics where esfSpecificId = &#63; from the database.
	 *
	 * @param esfSpecificId the esf specific ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySpecific(long esfSpecificId) throws SystemException {
		for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : findBySpecific(
				esfSpecificId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFederalRoleESFSpecific);
		}
	}

	/**
	 * Returns the number of e s f federal role e s f specifics where esfSpecificId = &#63;.
	 *
	 * @param esfSpecificId the esf specific ID
	 * @return the number of matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpecific(long esfSpecificId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPECIFIC;

		Object[] finderArgs = new Object[] { esfSpecificId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFEDERALROLEESFSPECIFIC_WHERE);

			query.append(_FINDER_COLUMN_SPECIFIC_ESFSPECIFICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfSpecificId);

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

	private static final String _FINDER_COLUMN_SPECIFIC_ESFSPECIFICID_2 = "esfFederalRoleESFSpecific.id.esfSpecificId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FEDERALROLE =
		new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFederalRole",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE =
		new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFederalRole",
			new String[] { Long.class.getName() },
			ESFFederalRoleESFSpecificModelImpl.ESFFEDERALROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FEDERALROLE = new FinderPath(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFederalRole", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f federal role e s f specifics where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @return the matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findByFederalRole(
		long esfFederalRoleId) throws SystemException {
		return findByFederalRole(esfFederalRoleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f federal role e s f specifics where esfFederalRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param start the lower bound of the range of e s f federal role e s f specifics
	 * @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	 * @return the range of matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findByFederalRole(
		long esfFederalRoleId, int start, int end) throws SystemException {
		return findByFederalRole(esfFederalRoleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f federal role e s f specifics where esfFederalRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param start the lower bound of the range of e s f federal role e s f specifics
	 * @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findByFederalRole(
		long esfFederalRoleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE;
			finderArgs = new Object[] { esfFederalRoleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FEDERALROLE;
			finderArgs = new Object[] {
					esfFederalRoleId,
					
					start, end, orderByComparator
				};
		}

		List<ESFFederalRoleESFSpecific> list = (List<ESFFederalRoleESFSpecific>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : list) {
				if ((esfFederalRoleId != esfFederalRoleESFSpecific.getEsfFederalRoleId())) {
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

			query.append(_SQL_SELECT_ESFFEDERALROLEESFSPECIFIC_WHERE);

			query.append(_FINDER_COLUMN_FEDERALROLE_ESFFEDERALROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFederalRoleESFSpecificModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFederalRoleId);

				if (!pagination) {
					list = (List<ESFFederalRoleESFSpecific>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFederalRoleESFSpecific>(list);
				}
				else {
					list = (List<ESFFederalRoleESFSpecific>)QueryUtil.list(q,
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
	 * Returns the first e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific findByFederalRole_First(
		long esfFederalRoleId, OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = fetchByFederalRole_First(esfFederalRoleId,
				orderByComparator);

		if (esfFederalRoleESFSpecific != null) {
			return esfFederalRoleESFSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfFederalRoleId=");
		msg.append(esfFederalRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleESFSpecificException(msg.toString());
	}

	/**
	 * Returns the first e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific fetchByFederalRole_First(
		long esfFederalRoleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFFederalRoleESFSpecific> list = findByFederalRole(esfFederalRoleId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific findByFederalRole_Last(
		long esfFederalRoleId, OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = fetchByFederalRole_Last(esfFederalRoleId,
				orderByComparator);

		if (esfFederalRoleESFSpecific != null) {
			return esfFederalRoleESFSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfFederalRoleId=");
		msg.append(esfFederalRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleESFSpecificException(msg.toString());
	}

	/**
	 * Returns the last e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific fetchByFederalRole_Last(
		long esfFederalRoleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFederalRole(esfFederalRoleId);

		if (count == 0) {
			return null;
		}

		List<ESFFederalRoleESFSpecific> list = findByFederalRole(esfFederalRoleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f federal role e s f specifics before and after the current e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleESFSpecificPK the primary key of the current e s f federal role e s f specific
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific[] findByFederalRole_PrevAndNext(
		ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK,
		long esfFederalRoleId, OrderByComparator orderByComparator)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = findByPrimaryKey(esfFederalRoleESFSpecificPK);

		Session session = null;

		try {
			session = openSession();

			ESFFederalRoleESFSpecific[] array = new ESFFederalRoleESFSpecificImpl[3];

			array[0] = getByFederalRole_PrevAndNext(session,
					esfFederalRoleESFSpecific, esfFederalRoleId,
					orderByComparator, true);

			array[1] = esfFederalRoleESFSpecific;

			array[2] = getByFederalRole_PrevAndNext(session,
					esfFederalRoleESFSpecific, esfFederalRoleId,
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

	protected ESFFederalRoleESFSpecific getByFederalRole_PrevAndNext(
		Session session, ESFFederalRoleESFSpecific esfFederalRoleESFSpecific,
		long esfFederalRoleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFEDERALROLEESFSPECIFIC_WHERE);

		query.append(_FINDER_COLUMN_FEDERALROLE_ESFFEDERALROLEID_2);

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
			query.append(ESFFederalRoleESFSpecificModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfFederalRoleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFederalRoleESFSpecific);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFederalRoleESFSpecific> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f federal role e s f specifics where esfFederalRoleId = &#63; from the database.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFederalRole(long esfFederalRoleId)
		throws SystemException {
		for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : findByFederalRole(
				esfFederalRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFederalRoleESFSpecific);
		}
	}

	/**
	 * Returns the number of e s f federal role e s f specifics where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @return the number of matching e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFederalRole(long esfFederalRoleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FEDERALROLE;

		Object[] finderArgs = new Object[] { esfFederalRoleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFEDERALROLEESFSPECIFIC_WHERE);

			query.append(_FINDER_COLUMN_FEDERALROLE_ESFFEDERALROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFederalRoleId);

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

	private static final String _FINDER_COLUMN_FEDERALROLE_ESFFEDERALROLEID_2 = "esfFederalRoleESFSpecific.id.esfFederalRoleId = ?";

	public ESFFederalRoleESFSpecificPersistenceImpl() {
		setModelClass(ESFFederalRoleESFSpecific.class);
	}

	/**
	 * Caches the e s f federal role e s f specific in the entity cache if it is enabled.
	 *
	 * @param esfFederalRoleESFSpecific the e s f federal role e s f specific
	 */
	@Override
	public void cacheResult(ESFFederalRoleESFSpecific esfFederalRoleESFSpecific) {
		EntityCacheUtil.putResult(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			esfFederalRoleESFSpecific.getPrimaryKey(), esfFederalRoleESFSpecific);

		esfFederalRoleESFSpecific.resetOriginalValues();
	}

	/**
	 * Caches the e s f federal role e s f specifics in the entity cache if it is enabled.
	 *
	 * @param esfFederalRoleESFSpecifics the e s f federal role e s f specifics
	 */
	@Override
	public void cacheResult(
		List<ESFFederalRoleESFSpecific> esfFederalRoleESFSpecifics) {
		for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : esfFederalRoleESFSpecifics) {
			if (EntityCacheUtil.getResult(
						ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
						ESFFederalRoleESFSpecificImpl.class,
						esfFederalRoleESFSpecific.getPrimaryKey()) == null) {
				cacheResult(esfFederalRoleESFSpecific);
			}
			else {
				esfFederalRoleESFSpecific.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f federal role e s f specifics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFederalRoleESFSpecificImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFederalRoleESFSpecificImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f federal role e s f specific.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFFederalRoleESFSpecific esfFederalRoleESFSpecific) {
		EntityCacheUtil.removeResult(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			esfFederalRoleESFSpecific.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFFederalRoleESFSpecific> esfFederalRoleESFSpecifics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : esfFederalRoleESFSpecifics) {
			EntityCacheUtil.removeResult(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
				ESFFederalRoleESFSpecificImpl.class,
				esfFederalRoleESFSpecific.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f federal role e s f specific with the primary key. Does not add the e s f federal role e s f specific to the database.
	 *
	 * @param esfFederalRoleESFSpecificPK the primary key for the new e s f federal role e s f specific
	 * @return the new e s f federal role e s f specific
	 */
	@Override
	public ESFFederalRoleESFSpecific create(
		ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK) {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = new ESFFederalRoleESFSpecificImpl();

		esfFederalRoleESFSpecific.setNew(true);
		esfFederalRoleESFSpecific.setPrimaryKey(esfFederalRoleESFSpecificPK);

		String uuid = PortalUUIDUtil.generate();

		esfFederalRoleESFSpecific.setUuid(uuid);

		return esfFederalRoleESFSpecific;
	}

	/**
	 * Removes the e s f federal role e s f specific with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFederalRoleESFSpecificPK the primary key of the e s f federal role e s f specific
	 * @return the e s f federal role e s f specific that was removed
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific remove(
		ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		return remove((Serializable)esfFederalRoleESFSpecificPK);
	}

	/**
	 * Removes the e s f federal role e s f specific with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f federal role e s f specific
	 * @return the e s f federal role e s f specific that was removed
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific remove(Serializable primaryKey)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = (ESFFederalRoleESFSpecific)session.get(ESFFederalRoleESFSpecificImpl.class,
					primaryKey);

			if (esfFederalRoleESFSpecific == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFederalRoleESFSpecificException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfFederalRoleESFSpecific);
		}
		catch (NoSuchFederalRoleESFSpecificException nsee) {
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
	protected ESFFederalRoleESFSpecific removeImpl(
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific)
		throws SystemException {
		esfFederalRoleESFSpecific = toUnwrappedModel(esfFederalRoleESFSpecific);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfFederalRoleESFSpecific)) {
				esfFederalRoleESFSpecific = (ESFFederalRoleESFSpecific)session.get(ESFFederalRoleESFSpecificImpl.class,
						esfFederalRoleESFSpecific.getPrimaryKeyObj());
			}

			if (esfFederalRoleESFSpecific != null) {
				session.delete(esfFederalRoleESFSpecific);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfFederalRoleESFSpecific != null) {
			clearCache(esfFederalRoleESFSpecific);
		}

		return esfFederalRoleESFSpecific;
	}

	@Override
	public ESFFederalRoleESFSpecific updateImpl(
		it.ethica.esf.model.ESFFederalRoleESFSpecific esfFederalRoleESFSpecific)
		throws SystemException {
		esfFederalRoleESFSpecific = toUnwrappedModel(esfFederalRoleESFSpecific);

		boolean isNew = esfFederalRoleESFSpecific.isNew();

		ESFFederalRoleESFSpecificModelImpl esfFederalRoleESFSpecificModelImpl = (ESFFederalRoleESFSpecificModelImpl)esfFederalRoleESFSpecific;

		if (Validator.isNull(esfFederalRoleESFSpecific.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfFederalRoleESFSpecific.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfFederalRoleESFSpecific.isNew()) {
				session.save(esfFederalRoleESFSpecific);

				esfFederalRoleESFSpecific.setNew(false);
			}
			else {
				session.merge(esfFederalRoleESFSpecific);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ESFFederalRoleESFSpecificModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFederalRoleESFSpecificModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFederalRoleESFSpecificModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfFederalRoleESFSpecificModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfFederalRoleESFSpecificModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPECIFIC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFederalRoleESFSpecificModelImpl.getOriginalEsfSpecificId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPECIFIC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPECIFIC,
					args);

				args = new Object[] {
						esfFederalRoleESFSpecificModelImpl.getEsfSpecificId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPECIFIC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPECIFIC,
					args);
			}

			if ((esfFederalRoleESFSpecificModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFederalRoleESFSpecificModelImpl.getOriginalEsfFederalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEDERALROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE,
					args);

				args = new Object[] {
						esfFederalRoleESFSpecificModelImpl.getEsfFederalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEDERALROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleESFSpecificImpl.class,
			esfFederalRoleESFSpecific.getPrimaryKey(), esfFederalRoleESFSpecific);

		return esfFederalRoleESFSpecific;
	}

	protected ESFFederalRoleESFSpecific toUnwrappedModel(
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific) {
		if (esfFederalRoleESFSpecific instanceof ESFFederalRoleESFSpecificImpl) {
			return esfFederalRoleESFSpecific;
		}

		ESFFederalRoleESFSpecificImpl esfFederalRoleESFSpecificImpl = new ESFFederalRoleESFSpecificImpl();

		esfFederalRoleESFSpecificImpl.setNew(esfFederalRoleESFSpecific.isNew());
		esfFederalRoleESFSpecificImpl.setPrimaryKey(esfFederalRoleESFSpecific.getPrimaryKey());

		esfFederalRoleESFSpecificImpl.setUuid(esfFederalRoleESFSpecific.getUuid());
		esfFederalRoleESFSpecificImpl.setEsfSpecificId(esfFederalRoleESFSpecific.getEsfSpecificId());
		esfFederalRoleESFSpecificImpl.setEsfFederalRoleId(esfFederalRoleESFSpecific.getEsfFederalRoleId());

		return esfFederalRoleESFSpecificImpl;
	}

	/**
	 * Returns the e s f federal role e s f specific with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f federal role e s f specific
	 * @return the e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = fetchByPrimaryKey(primaryKey);

		if (esfFederalRoleESFSpecific == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFederalRoleESFSpecificException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfFederalRoleESFSpecific;
	}

	/**
	 * Returns the e s f federal role e s f specific with the primary key or throws a {@link it.ethica.esf.NoSuchFederalRoleESFSpecificException} if it could not be found.
	 *
	 * @param esfFederalRoleESFSpecificPK the primary key of the e s f federal role e s f specific
	 * @return the e s f federal role e s f specific
	 * @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific findByPrimaryKey(
		ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws NoSuchFederalRoleESFSpecificException, SystemException {
		return findByPrimaryKey((Serializable)esfFederalRoleESFSpecificPK);
	}

	/**
	 * Returns the e s f federal role e s f specific with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f federal role e s f specific
	 * @return the e s f federal role e s f specific, or <code>null</code> if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific = (ESFFederalRoleESFSpecific)EntityCacheUtil.getResult(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
				ESFFederalRoleESFSpecificImpl.class, primaryKey);

		if (esfFederalRoleESFSpecific == _nullESFFederalRoleESFSpecific) {
			return null;
		}

		if (esfFederalRoleESFSpecific == null) {
			Session session = null;

			try {
				session = openSession();

				esfFederalRoleESFSpecific = (ESFFederalRoleESFSpecific)session.get(ESFFederalRoleESFSpecificImpl.class,
						primaryKey);

				if (esfFederalRoleESFSpecific != null) {
					cacheResult(esfFederalRoleESFSpecific);
				}
				else {
					EntityCacheUtil.putResult(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
						ESFFederalRoleESFSpecificImpl.class, primaryKey,
						_nullESFFederalRoleESFSpecific);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFederalRoleESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
					ESFFederalRoleESFSpecificImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfFederalRoleESFSpecific;
	}

	/**
	 * Returns the e s f federal role e s f specific with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFederalRoleESFSpecificPK the primary key of the e s f federal role e s f specific
	 * @return the e s f federal role e s f specific, or <code>null</code> if a e s f federal role e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRoleESFSpecific fetchByPrimaryKey(
		ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFederalRoleESFSpecificPK);
	}

	/**
	 * Returns all the e s f federal role e s f specifics.
	 *
	 * @return the e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f federal role e s f specifics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f federal role e s f specifics
	 * @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	 * @return the range of e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f federal role e s f specifics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f federal role e s f specifics
	 * @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f federal role e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRoleESFSpecific> findAll(int start, int end,
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

		List<ESFFederalRoleESFSpecific> list = (List<ESFFederalRoleESFSpecific>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFEDERALROLEESFSPECIFIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFEDERALROLEESFSPECIFIC;

				if (pagination) {
					sql = sql.concat(ESFFederalRoleESFSpecificModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFFederalRoleESFSpecific>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFederalRoleESFSpecific>(list);
				}
				else {
					list = (List<ESFFederalRoleESFSpecific>)QueryUtil.list(q,
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
	 * Removes all the e s f federal role e s f specifics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFFederalRoleESFSpecific esfFederalRoleESFSpecific : findAll()) {
			remove(esfFederalRoleESFSpecific);
		}
	}

	/**
	 * Returns the number of e s f federal role e s f specifics.
	 *
	 * @return the number of e s f federal role e s f specifics
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

				Query q = session.createQuery(_SQL_COUNT_ESFFEDERALROLEESFSPECIFIC);

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
	 * Initializes the e s f federal role e s f specific persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFFederalRoleESFSpecific")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFFederalRoleESFSpecific>> listenersList = new ArrayList<ModelListener<ESFFederalRoleESFSpecific>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFFederalRoleESFSpecific>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFederalRoleESFSpecificImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFEDERALROLEESFSPECIFIC = "SELECT esfFederalRoleESFSpecific FROM ESFFederalRoleESFSpecific esfFederalRoleESFSpecific";
	private static final String _SQL_SELECT_ESFFEDERALROLEESFSPECIFIC_WHERE = "SELECT esfFederalRoleESFSpecific FROM ESFFederalRoleESFSpecific esfFederalRoleESFSpecific WHERE ";
	private static final String _SQL_COUNT_ESFFEDERALROLEESFSPECIFIC = "SELECT COUNT(esfFederalRoleESFSpecific) FROM ESFFederalRoleESFSpecific esfFederalRoleESFSpecific";
	private static final String _SQL_COUNT_ESFFEDERALROLEESFSPECIFIC_WHERE = "SELECT COUNT(esfFederalRoleESFSpecific) FROM ESFFederalRoleESFSpecific esfFederalRoleESFSpecific WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfFederalRoleESFSpecific.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFFederalRoleESFSpecific exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFFederalRoleESFSpecific exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFederalRoleESFSpecificPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFFederalRoleESFSpecific _nullESFFederalRoleESFSpecific = new ESFFederalRoleESFSpecificImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFFederalRoleESFSpecific> toCacheModel() {
				return _nullESFFederalRoleESFSpecificCacheModel;
			}
		};

	private static CacheModel<ESFFederalRoleESFSpecific> _nullESFFederalRoleESFSpecificCacheModel =
		new CacheModel<ESFFederalRoleESFSpecific>() {
			@Override
			public ESFFederalRoleESFSpecific toEntityModel() {
				return _nullESFFederalRoleESFSpecific;
			}
		};
}