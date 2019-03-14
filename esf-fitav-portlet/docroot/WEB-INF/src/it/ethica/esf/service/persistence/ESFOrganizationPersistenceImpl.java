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

import it.ethica.esf.NoSuchOrganizationException;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.model.impl.ESFOrganizationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationPersistence
 * @see ESFOrganizationUtil
 * @generated
 */
public class ESFOrganizationPersistenceImpl extends BasePersistenceImpl<ESFOrganization>
	implements ESFOrganizationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFOrganizationUtil} to access the e s f organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFOrganizationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFOrganizationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f organizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByUuid(String uuid, int start, int end,
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

		List<ESFOrganization> list = (List<ESFOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganization esfOrganization : list) {
				if (!Validator.equals(uuid, esfOrganization.getUuid())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

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
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization>(list);
				}
				else {
					list = (List<ESFOrganization>)QueryUtil.list(q,
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
	 * Returns the first e s f organization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first e s f organization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganization> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last e s f organization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFOrganization> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organizations before and after the current e s f organization in the ordered set where uuid = &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization[] findByUuid_PrevAndNext(long esfOrganizationId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization[] array = new ESFOrganizationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfOrganization, uuid,
					orderByComparator, true);

			array[1] = esfOrganization;

			array[2] = getByUuid_PrevAndNext(session, esfOrganization, uuid,
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

	protected ESFOrganization getByUuid_PrevAndNext(Session session,
		ESFOrganization esfOrganization, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

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
			query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organizations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFOrganization esfOrganization : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganization);
		}
	}

	/**
	 * Returns the number of e s f organizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f organizations
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

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfOrganization.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfOrganization.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfOrganization.uuid IS NULL OR esfOrganization.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFOrganizationModelImpl.UUID_COLUMN_BITMASK |
			ESFOrganizationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f organization where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByUUID_G(String uuid, long groupId)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByUUID_G(uuid, groupId);

		if (esfOrganization == null) {
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

			throw new NoSuchOrganizationException(msg.toString());
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f organization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFOrganization) {
			ESFOrganization esfOrganization = (ESFOrganization)result;

			if (!Validator.equals(uuid, esfOrganization.getUuid()) ||
					(groupId != esfOrganization.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

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

				List<ESFOrganization> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFOrganization esfOrganization = list.get(0);

					result = esfOrganization;

					cacheResult(esfOrganization);

					if ((esfOrganization.getUuid() == null) ||
							!esfOrganization.getUuid().equals(uuid) ||
							(esfOrganization.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfOrganization);
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
			return (ESFOrganization)result;
		}
	}

	/**
	 * Removes the e s f organization where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f organization that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization removeByUUID_G(String uuid, long groupId)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByUUID_G(uuid, groupId);

		return remove(esfOrganization);
	}

	/**
	 * Returns the number of e s f organizations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f organizations
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

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfOrganization.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfOrganization.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfOrganization.uuid IS NULL OR esfOrganization.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfOrganization.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFOrganizationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f organizations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organizations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByGroupId(long groupId, int start,
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

		List<ESFOrganization> list = (List<ESFOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganization esfOrganization : list) {
				if ((groupId != esfOrganization.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization>(list);
				}
				else {
					list = (List<ESFOrganization>)QueryUtil.list(q,
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
	 * Returns the first e s f organization in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByGroupId_First(groupId,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first e s f organization in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganization> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last e s f organization in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFOrganization> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organizations before and after the current e s f organization in the ordered set where groupId = &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization[] findByGroupId_PrevAndNext(long esfOrganizationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization[] array = new ESFOrganizationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfOrganization,
					groupId, orderByComparator, true);

			array[1] = esfOrganization;

			array[2] = getByGroupId_PrevAndNext(session, esfOrganization,
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

	protected ESFOrganization getByGroupId_PrevAndNext(Session session,
		ESFOrganization esfOrganization, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

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
			query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e s f organizations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f organizations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organizations that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of matching e s f organizations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organizations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFOrganizationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFOrganization.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESFOrganizationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESFOrganizationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ESFOrganization>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e s f organizations before and after the current e s f organization in the ordered set of e s f organizations that the user has permission to view where groupId = &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization[] filterFindByGroupId_PrevAndNext(
		long esfOrganizationId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(esfOrganizationId, groupId,
				orderByComparator);
		}

		ESFOrganization esfOrganization = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization[] array = new ESFOrganizationImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, esfOrganization,
					groupId, orderByComparator, true);

			array[1] = esfOrganization;

			array[2] = filterGetByGroupId_PrevAndNext(session, esfOrganization,
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

	protected ESFOrganization filterGetByGroupId_PrevAndNext(Session session,
		ESFOrganization esfOrganization, long groupId,
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
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFOrganizationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFOrganization.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ESFOrganizationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ESFOrganizationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organizations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFOrganization esfOrganization : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganization);
		}
	}

	/**
	 * Returns the number of e s f organizations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f organizations
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

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

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
	 * Returns the number of e s f organizations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f organizations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ESFORGANIZATION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFOrganization.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfOrganization.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFOrganizationModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f organization where code = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByCode(String code)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByCode(code);

		if (esfOrganization == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizationException(msg.toString());
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f organization where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFOrganization) {
			ESFOrganization esfOrganization = (ESFOrganization)result;

			if (!Validator.equals(code, esfOrganization.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

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

				List<ESFOrganization> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFOrganizationPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFOrganization esfOrganization = list.get(0);

					result = esfOrganization;

					cacheResult(esfOrganization);

					if ((esfOrganization.getCode() == null) ||
							!esfOrganization.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfOrganization);
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
			return (ESFOrganization)result;
		}
	}

	/**
	 * Removes the e s f organization where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f organization that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization removeByCode(String code)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByCode(code);

		return remove(esfOrganization);
	}

	/**
	 * Returns the number of e s f organizations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f organizations
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

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfOrganization.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfOrganization.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfOrganization.code IS NULL OR esfOrganization.code = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_VAT = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByVat",
			new String[] { String.class.getName() },
			ESFOrganizationModelImpl.VAT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VAT = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVat",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f organization where vat = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param vat the vat
	 * @return the matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByVat(String vat)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByVat(vat);

		if (esfOrganization == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vat=");
			msg.append(vat);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizationException(msg.toString());
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization where vat = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param vat the vat
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByVat(String vat) throws SystemException {
		return fetchByVat(vat, true);
	}

	/**
	 * Returns the e s f organization where vat = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param vat the vat
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByVat(String vat, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { vat };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VAT,
					finderArgs, this);
		}

		if (result instanceof ESFOrganization) {
			ESFOrganization esfOrganization = (ESFOrganization)result;

			if (!Validator.equals(vat, esfOrganization.getVat())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			boolean bindVat = false;

			if (vat == null) {
				query.append(_FINDER_COLUMN_VAT_VAT_1);
			}
			else if (vat.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VAT_VAT_3);
			}
			else {
				bindVat = true;

				query.append(_FINDER_COLUMN_VAT_VAT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVat) {
					qPos.add(vat);
				}

				List<ESFOrganization> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFOrganizationPersistenceImpl.fetchByVat(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFOrganization esfOrganization = list.get(0);

					result = esfOrganization;

					cacheResult(esfOrganization);

					if ((esfOrganization.getVat() == null) ||
							!esfOrganization.getVat().equals(vat)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAT,
							finderArgs, esfOrganization);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VAT,
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
			return (ESFOrganization)result;
		}
	}

	/**
	 * Removes the e s f organization where vat = &#63; from the database.
	 *
	 * @param vat the vat
	 * @return the e s f organization that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization removeByVat(String vat)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByVat(vat);

		return remove(esfOrganization);
	}

	/**
	 * Returns the number of e s f organizations where vat = &#63;.
	 *
	 * @param vat the vat
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVat(String vat) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VAT;

		Object[] finderArgs = new Object[] { vat };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

			boolean bindVat = false;

			if (vat == null) {
				query.append(_FINDER_COLUMN_VAT_VAT_1);
			}
			else if (vat.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VAT_VAT_3);
			}
			else {
				bindVat = true;

				query.append(_FINDER_COLUMN_VAT_VAT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVat) {
					qPos.add(vat);
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

	private static final String _FINDER_COLUMN_VAT_VAT_1 = "esfOrganization.vat IS NULL";
	private static final String _FINDER_COLUMN_VAT_VAT_2 = "esfOrganization.vat = ?";
	private static final String _FINDER_COLUMN_VAT_VAT_3 = "(esfOrganization.vat IS NULL OR esfOrganization.vat = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_FISCALCODE = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFiscalCode", new String[] { String.class.getName() },
			ESFOrganizationModelImpl.FISCALCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FISCALCODE = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFiscalCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f organization where fiscalCode = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param fiscalCode the fiscal code
	 * @return the matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByFiscalCode(String fiscalCode)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByFiscalCode(fiscalCode);

		if (esfOrganization == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fiscalCode=");
			msg.append(fiscalCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizationException(msg.toString());
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization where fiscalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fiscalCode the fiscal code
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByFiscalCode(String fiscalCode)
		throws SystemException {
		return fetchByFiscalCode(fiscalCode, true);
	}

	/**
	 * Returns the e s f organization where fiscalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fiscalCode the fiscal code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByFiscalCode(String fiscalCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { fiscalCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FISCALCODE,
					finderArgs, this);
		}

		if (result instanceof ESFOrganization) {
			ESFOrganization esfOrganization = (ESFOrganization)result;

			if (!Validator.equals(fiscalCode, esfOrganization.getFiscalCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

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

				List<ESFOrganization> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFOrganizationPersistenceImpl.fetchByFiscalCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFOrganization esfOrganization = list.get(0);

					result = esfOrganization;

					cacheResult(esfOrganization);

					if ((esfOrganization.getFiscalCode() == null) ||
							!esfOrganization.getFiscalCode().equals(fiscalCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE,
							finderArgs, esfOrganization);
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
			return (ESFOrganization)result;
		}
	}

	/**
	 * Removes the e s f organization where fiscalCode = &#63; from the database.
	 *
	 * @param fiscalCode the fiscal code
	 * @return the e s f organization that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization removeByFiscalCode(String fiscalCode)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByFiscalCode(fiscalCode);

		return remove(esfOrganization);
	}

	/**
	 * Returns the number of e s f organizations where fiscalCode = &#63;.
	 *
	 * @param fiscalCode the fiscal code
	 * @return the number of matching e s f organizations
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

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

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

	private static final String _FINDER_COLUMN_FISCALCODE_FISCALCODE_1 = "esfOrganization.fiscalCode IS NULL";
	private static final String _FINDER_COLUMN_FISCALCODE_FISCALCODE_2 = "esfOrganization.fiscalCode = ?";
	private static final String _FINDER_COLUMN_FISCALCODE_FISCALCODE_3 = "(esfOrganization.fiscalCode IS NULL OR esfOrganization.fiscalCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { Integer.class.getName() },
			ESFOrganizationModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the e s f organizations where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByType(int type) throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organizations where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByType(int type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByType(int type, int start, int end,
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

		List<ESFOrganization> list = (List<ESFOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganization esfOrganization : list) {
				if ((type != esfOrganization.getType())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (!pagination) {
					list = (List<ESFOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization>(list);
				}
				else {
					list = (List<ESFOrganization>)QueryUtil.list(q,
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
	 * Returns the first e s f organization in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByType_First(int type,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByType_First(type,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first e s f organization in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByType_First(int type,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganization> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByType_Last(int type,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByType_Last(type,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last e s f organization in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByType_Last(int type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<ESFOrganization> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organizations before and after the current e s f organization in the ordered set where type = &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization[] findByType_PrevAndNext(long esfOrganizationId,
		int type, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization[] array = new ESFOrganizationImpl[3];

			array[0] = getByType_PrevAndNext(session, esfOrganization, type,
					orderByComparator, true);

			array[1] = esfOrganization;

			array[2] = getByType_PrevAndNext(session, esfOrganization, type,
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

	protected ESFOrganization getByType_PrevAndNext(Session session,
		ESFOrganization esfOrganization, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

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
			query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organizations where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(int type) throws SystemException {
		for (ESFOrganization esfOrganization : findByType(type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganization);
		}
	}

	/**
	 * Returns the number of e s f organizations where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(int type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "esfOrganization.type = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTISPORT =
		new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMultiSport",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTISPORT =
		new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMultiSport",
			new String[] { Boolean.class.getName() },
			ESFOrganizationModelImpl.ISMULTISPORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MULTISPORT = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMultiSport",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the e s f organizations where isMultiSport = &#63;.
	 *
	 * @param isMultiSport the is multi sport
	 * @return the matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByMultiSport(boolean isMultiSport)
		throws SystemException {
		return findByMultiSport(isMultiSport, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organizations where isMultiSport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isMultiSport the is multi sport
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByMultiSport(boolean isMultiSport,
		int start, int end) throws SystemException {
		return findByMultiSport(isMultiSport, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations where isMultiSport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isMultiSport the is multi sport
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByMultiSport(boolean isMultiSport,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTISPORT;
			finderArgs = new Object[] { isMultiSport };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTISPORT;
			finderArgs = new Object[] {
					isMultiSport,
					
					start, end, orderByComparator
				};
		}

		List<ESFOrganization> list = (List<ESFOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganization esfOrganization : list) {
				if ((isMultiSport != esfOrganization.getIsMultiSport())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_MULTISPORT_ISMULTISPORT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isMultiSport);

				if (!pagination) {
					list = (List<ESFOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization>(list);
				}
				else {
					list = (List<ESFOrganization>)QueryUtil.list(q,
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
	 * Returns the first e s f organization in the ordered set where isMultiSport = &#63;.
	 *
	 * @param isMultiSport the is multi sport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByMultiSport_First(boolean isMultiSport,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByMultiSport_First(isMultiSport,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isMultiSport=");
		msg.append(isMultiSport);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first e s f organization in the ordered set where isMultiSport = &#63;.
	 *
	 * @param isMultiSport the is multi sport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByMultiSport_First(boolean isMultiSport,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganization> list = findByMultiSport(isMultiSport, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization in the ordered set where isMultiSport = &#63;.
	 *
	 * @param isMultiSport the is multi sport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByMultiSport_Last(boolean isMultiSport,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByMultiSport_Last(isMultiSport,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isMultiSport=");
		msg.append(isMultiSport);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last e s f organization in the ordered set where isMultiSport = &#63;.
	 *
	 * @param isMultiSport the is multi sport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByMultiSport_Last(boolean isMultiSport,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMultiSport(isMultiSport);

		if (count == 0) {
			return null;
		}

		List<ESFOrganization> list = findByMultiSport(isMultiSport, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organizations before and after the current e s f organization in the ordered set where isMultiSport = &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization
	 * @param isMultiSport the is multi sport
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization[] findByMultiSport_PrevAndNext(
		long esfOrganizationId, boolean isMultiSport,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization[] array = new ESFOrganizationImpl[3];

			array[0] = getByMultiSport_PrevAndNext(session, esfOrganization,
					isMultiSport, orderByComparator, true);

			array[1] = esfOrganization;

			array[2] = getByMultiSport_PrevAndNext(session, esfOrganization,
					isMultiSport, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganization getByMultiSport_PrevAndNext(Session session,
		ESFOrganization esfOrganization, boolean isMultiSport,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

		query.append(_FINDER_COLUMN_MULTISPORT_ISMULTISPORT_2);

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
			query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isMultiSport);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organizations where isMultiSport = &#63; from the database.
	 *
	 * @param isMultiSport the is multi sport
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMultiSport(boolean isMultiSport)
		throws SystemException {
		for (ESFOrganization esfOrganization : findByMultiSport(isMultiSport,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganization);
		}
	}

	/**
	 * Returns the number of e s f organizations where isMultiSport = &#63;.
	 *
	 * @param isMultiSport the is multi sport
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMultiSport(boolean isMultiSport)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MULTISPORT;

		Object[] finderArgs = new Object[] { isMultiSport };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_MULTISPORT_ISMULTISPORT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isMultiSport);

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

	private static final String _FINDER_COLUMN_MULTISPORT_ISMULTISPORT_2 = "esfOrganization.isMultiSport = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEGALFORM =
		new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLegalForm",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEGALFORM =
		new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLegalForm",
			new String[] { String.class.getName() },
			ESFOrganizationModelImpl.LEGALFORM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEGALFORM = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLegalForm",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f organizations where legalForm = &#63;.
	 *
	 * @param legalForm the legal form
	 * @return the matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByLegalForm(String legalForm)
		throws SystemException {
		return findByLegalForm(legalForm, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f organizations where legalForm = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param legalForm the legal form
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByLegalForm(String legalForm, int start,
		int end) throws SystemException {
		return findByLegalForm(legalForm, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations where legalForm = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param legalForm the legal form
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByLegalForm(String legalForm, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEGALFORM;
			finderArgs = new Object[] { legalForm };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEGALFORM;
			finderArgs = new Object[] { legalForm, start, end, orderByComparator };
		}

		List<ESFOrganization> list = (List<ESFOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganization esfOrganization : list) {
				if (!Validator.equals(legalForm, esfOrganization.getLegalForm())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			boolean bindLegalForm = false;

			if (legalForm == null) {
				query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_1);
			}
			else if (legalForm.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_3);
			}
			else {
				bindLegalForm = true;

				query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLegalForm) {
					qPos.add(legalForm);
				}

				if (!pagination) {
					list = (List<ESFOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization>(list);
				}
				else {
					list = (List<ESFOrganization>)QueryUtil.list(q,
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
	 * Returns the first e s f organization in the ordered set where legalForm = &#63;.
	 *
	 * @param legalForm the legal form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByLegalForm_First(String legalForm,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByLegalForm_First(legalForm,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("legalForm=");
		msg.append(legalForm);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first e s f organization in the ordered set where legalForm = &#63;.
	 *
	 * @param legalForm the legal form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByLegalForm_First(String legalForm,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganization> list = findByLegalForm(legalForm, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization in the ordered set where legalForm = &#63;.
	 *
	 * @param legalForm the legal form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByLegalForm_Last(String legalForm,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByLegalForm_Last(legalForm,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("legalForm=");
		msg.append(legalForm);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last e s f organization in the ordered set where legalForm = &#63;.
	 *
	 * @param legalForm the legal form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByLegalForm_Last(String legalForm,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLegalForm(legalForm);

		if (count == 0) {
			return null;
		}

		List<ESFOrganization> list = findByLegalForm(legalForm, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organizations before and after the current e s f organization in the ordered set where legalForm = &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization
	 * @param legalForm the legal form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization[] findByLegalForm_PrevAndNext(
		long esfOrganizationId, String legalForm,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization[] array = new ESFOrganizationImpl[3];

			array[0] = getByLegalForm_PrevAndNext(session, esfOrganization,
					legalForm, orderByComparator, true);

			array[1] = esfOrganization;

			array[2] = getByLegalForm_PrevAndNext(session, esfOrganization,
					legalForm, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganization getByLegalForm_PrevAndNext(Session session,
		ESFOrganization esfOrganization, String legalForm,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

		boolean bindLegalForm = false;

		if (legalForm == null) {
			query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_1);
		}
		else if (legalForm.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_3);
		}
		else {
			bindLegalForm = true;

			query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_2);
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
			query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLegalForm) {
			qPos.add(legalForm);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organizations where legalForm = &#63; from the database.
	 *
	 * @param legalForm the legal form
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLegalForm(String legalForm) throws SystemException {
		for (ESFOrganization esfOrganization : findByLegalForm(legalForm,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganization);
		}
	}

	/**
	 * Returns the number of e s f organizations where legalForm = &#63;.
	 *
	 * @param legalForm the legal form
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLegalForm(String legalForm) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEGALFORM;

		Object[] finderArgs = new Object[] { legalForm };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

			boolean bindLegalForm = false;

			if (legalForm == null) {
				query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_1);
			}
			else if (legalForm.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_3);
			}
			else {
				bindLegalForm = true;

				query.append(_FINDER_COLUMN_LEGALFORM_LEGALFORM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLegalForm) {
					qPos.add(legalForm);
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

	private static final String _FINDER_COLUMN_LEGALFORM_LEGALFORM_1 = "esfOrganization.legalForm IS NULL";
	private static final String _FINDER_COLUMN_LEGALFORM_LEGALFORM_2 = "esfOrganization.legalForm = ?";
	private static final String _FINDER_COLUMN_LEGALFORM_LEGALFORM_3 = "(esfOrganization.legalForm IS NULL OR esfOrganization.legalForm = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { String.class.getName() },
			ESFOrganizationModelImpl.CATEGORY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f organizations where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByCategory(String category)
		throws SystemException {
		return findByCategory(category, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f organizations where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByCategory(String category, int start,
		int end) throws SystemException {
		return findByCategory(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByCategory(String category, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { category, start, end, orderByComparator };
		}

		List<ESFOrganization> list = (List<ESFOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganization esfOrganization : list) {
				if (!Validator.equals(category, esfOrganization.getCategory())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

				if (!pagination) {
					list = (List<ESFOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization>(list);
				}
				else {
					list = (List<ESFOrganization>)QueryUtil.list(q,
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
	 * Returns the first e s f organization in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByCategory_First(String category,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByCategory_First(category,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first e s f organization in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByCategory_First(String category,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganization> list = findByCategory(category, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByCategory_Last(String category,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByCategory_Last(category,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last e s f organization in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByCategory_Last(String category,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(category);

		if (count == 0) {
			return null;
		}

		List<ESFOrganization> list = findByCategory(category, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organizations before and after the current e s f organization in the ordered set where category = &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization[] findByCategory_PrevAndNext(
		long esfOrganizationId, String category,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization[] array = new ESFOrganizationImpl[3];

			array[0] = getByCategory_PrevAndNext(session, esfOrganization,
					category, orderByComparator, true);

			array[1] = esfOrganization;

			array[2] = getByCategory_PrevAndNext(session, esfOrganization,
					category, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganization getByCategory_PrevAndNext(Session session,
		ESFOrganization esfOrganization, String category,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
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
			query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategory) {
			qPos.add(category);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organizations where category = &#63; from the database.
	 *
	 * @param category the category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(String category) throws SystemException {
		for (ESFOrganization esfOrganization : findByCategory(category,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganization);
		}
	}

	/**
	 * Returns the number of e s f organizations where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategory(String category) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { category };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_1 = "esfOrganization.category IS NULL";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 = "esfOrganization.category = ?";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 = "(esfOrganization.category IS NULL OR esfOrganization.category = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_C = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFOrganizationModelImpl.CODE_COLUMN_BITMASK |
			ESFOrganizationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f organization where code = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param code the code
	 * @param groupId the group ID
	 * @return the matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByG_C(String code, long groupId)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByG_C(code, groupId);

		if (esfOrganization == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizationException(msg.toString());
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization where code = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param groupId the group ID
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByG_C(String code, long groupId)
		throws SystemException {
		return fetchByG_C(code, groupId, true);
	}

	/**
	 * Returns the e s f organization where code = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByG_C(String code, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { code, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_C,
					finderArgs, this);
		}

		if (result instanceof ESFOrganization) {
			ESFOrganization esfOrganization = (ESFOrganization)result;

			if (!Validator.equals(code, esfOrganization.getCode()) ||
					(groupId != esfOrganization.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_G_C_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_C_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_G_C_CODE_2);
			}

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				qPos.add(groupId);

				List<ESFOrganization> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFOrganizationPersistenceImpl.fetchByG_C(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFOrganization esfOrganization = list.get(0);

					result = esfOrganization;

					cacheResult(esfOrganization);

					if ((esfOrganization.getCode() == null) ||
							!esfOrganization.getCode().equals(code) ||
							(esfOrganization.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
							finderArgs, esfOrganization);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C,
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
			return (ESFOrganization)result;
		}
	}

	/**
	 * Removes the e s f organization where code = &#63; and groupId = &#63; from the database.
	 *
	 * @param code the code
	 * @param groupId the group ID
	 * @return the e s f organization that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization removeByG_C(String code, long groupId)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByG_C(code, groupId);

		return remove(esfOrganization);
	}

	/**
	 * Returns the number of e s f organizations where code = &#63; and groupId = &#63;.
	 *
	 * @param code the code
	 * @param groupId the group ID
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C(String code, long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C;

		Object[] finderArgs = new Object[] { code, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_G_C_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_C_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_G_C_CODE_2);
			}

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
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

	private static final String _FINDER_COLUMN_G_C_CODE_1 = "esfOrganization.code IS NULL AND ";
	private static final String _FINDER_COLUMN_G_C_CODE_2 = "esfOrganization.code = ? AND ";
	private static final String _FINDER_COLUMN_G_C_CODE_3 = "(esfOrganization.code IS NULL OR esfOrganization.code = '') AND ";
	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "esfOrganization.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_V = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_V",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFOrganizationModelImpl.VAT_COLUMN_BITMASK |
			ESFOrganizationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_V = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_V",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f organization where vat = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param vat the vat
	 * @param groupId the group ID
	 * @return the matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByG_V(String vat, long groupId)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByG_V(vat, groupId);

		if (esfOrganization == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vat=");
			msg.append(vat);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizationException(msg.toString());
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization where vat = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param vat the vat
	 * @param groupId the group ID
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByG_V(String vat, long groupId)
		throws SystemException {
		return fetchByG_V(vat, groupId, true);
	}

	/**
	 * Returns the e s f organization where vat = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param vat the vat
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByG_V(String vat, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { vat, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_V,
					finderArgs, this);
		}

		if (result instanceof ESFOrganization) {
			ESFOrganization esfOrganization = (ESFOrganization)result;

			if (!Validator.equals(vat, esfOrganization.getVat()) ||
					(groupId != esfOrganization.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			boolean bindVat = false;

			if (vat == null) {
				query.append(_FINDER_COLUMN_G_V_VAT_1);
			}
			else if (vat.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_V_VAT_3);
			}
			else {
				bindVat = true;

				query.append(_FINDER_COLUMN_G_V_VAT_2);
			}

			query.append(_FINDER_COLUMN_G_V_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVat) {
					qPos.add(vat);
				}

				qPos.add(groupId);

				List<ESFOrganization> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_V,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFOrganizationPersistenceImpl.fetchByG_V(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFOrganization esfOrganization = list.get(0);

					result = esfOrganization;

					cacheResult(esfOrganization);

					if ((esfOrganization.getVat() == null) ||
							!esfOrganization.getVat().equals(vat) ||
							(esfOrganization.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_V,
							finderArgs, esfOrganization);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_V,
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
			return (ESFOrganization)result;
		}
	}

	/**
	 * Removes the e s f organization where vat = &#63; and groupId = &#63; from the database.
	 *
	 * @param vat the vat
	 * @param groupId the group ID
	 * @return the e s f organization that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization removeByG_V(String vat, long groupId)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByG_V(vat, groupId);

		return remove(esfOrganization);
	}

	/**
	 * Returns the number of e s f organizations where vat = &#63; and groupId = &#63;.
	 *
	 * @param vat the vat
	 * @param groupId the group ID
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_V(String vat, long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_V;

		Object[] finderArgs = new Object[] { vat, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

			boolean bindVat = false;

			if (vat == null) {
				query.append(_FINDER_COLUMN_G_V_VAT_1);
			}
			else if (vat.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_V_VAT_3);
			}
			else {
				bindVat = true;

				query.append(_FINDER_COLUMN_G_V_VAT_2);
			}

			query.append(_FINDER_COLUMN_G_V_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVat) {
					qPos.add(vat);
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

	private static final String _FINDER_COLUMN_G_V_VAT_1 = "esfOrganization.vat IS NULL AND ";
	private static final String _FINDER_COLUMN_G_V_VAT_2 = "esfOrganization.vat = ? AND ";
	private static final String _FINDER_COLUMN_G_V_VAT_3 = "(esfOrganization.vat IS NULL OR esfOrganization.vat = '') AND ";
	private static final String _FINDER_COLUMN_G_V_GROUPID_2 = "esfOrganization.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_F = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_F",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFOrganizationModelImpl.FISCALCODE_COLUMN_BITMASK |
			ESFOrganizationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_F = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_F",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f organization where fiscalCode = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param fiscalCode the fiscal code
	 * @param groupId the group ID
	 * @return the matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByG_F(String fiscalCode, long groupId)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByG_F(fiscalCode, groupId);

		if (esfOrganization == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fiscalCode=");
			msg.append(fiscalCode);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizationException(msg.toString());
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization where fiscalCode = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fiscalCode the fiscal code
	 * @param groupId the group ID
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByG_F(String fiscalCode, long groupId)
		throws SystemException {
		return fetchByG_F(fiscalCode, groupId, true);
	}

	/**
	 * Returns the e s f organization where fiscalCode = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fiscalCode the fiscal code
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByG_F(String fiscalCode, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { fiscalCode, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_F,
					finderArgs, this);
		}

		if (result instanceof ESFOrganization) {
			ESFOrganization esfOrganization = (ESFOrganization)result;

			if (!Validator.equals(fiscalCode, esfOrganization.getFiscalCode()) ||
					(groupId != esfOrganization.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			boolean bindFiscalCode = false;

			if (fiscalCode == null) {
				query.append(_FINDER_COLUMN_G_F_FISCALCODE_1);
			}
			else if (fiscalCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_F_FISCALCODE_3);
			}
			else {
				bindFiscalCode = true;

				query.append(_FINDER_COLUMN_G_F_FISCALCODE_2);
			}

			query.append(_FINDER_COLUMN_G_F_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFiscalCode) {
					qPos.add(fiscalCode);
				}

				qPos.add(groupId);

				List<ESFOrganization> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFOrganizationPersistenceImpl.fetchByG_F(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFOrganization esfOrganization = list.get(0);

					result = esfOrganization;

					cacheResult(esfOrganization);

					if ((esfOrganization.getFiscalCode() == null) ||
							!esfOrganization.getFiscalCode().equals(fiscalCode) ||
							(esfOrganization.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F,
							finderArgs, esfOrganization);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F,
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
			return (ESFOrganization)result;
		}
	}

	/**
	 * Removes the e s f organization where fiscalCode = &#63; and groupId = &#63; from the database.
	 *
	 * @param fiscalCode the fiscal code
	 * @param groupId the group ID
	 * @return the e s f organization that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization removeByG_F(String fiscalCode, long groupId)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByG_F(fiscalCode, groupId);

		return remove(esfOrganization);
	}

	/**
	 * Returns the number of e s f organizations where fiscalCode = &#63; and groupId = &#63;.
	 *
	 * @param fiscalCode the fiscal code
	 * @param groupId the group ID
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_F(String fiscalCode, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_F;

		Object[] finderArgs = new Object[] { fiscalCode, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

			boolean bindFiscalCode = false;

			if (fiscalCode == null) {
				query.append(_FINDER_COLUMN_G_F_FISCALCODE_1);
			}
			else if (fiscalCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_F_FISCALCODE_3);
			}
			else {
				bindFiscalCode = true;

				query.append(_FINDER_COLUMN_G_F_FISCALCODE_2);
			}

			query.append(_FINDER_COLUMN_G_F_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFiscalCode) {
					qPos.add(fiscalCode);
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

	private static final String _FINDER_COLUMN_G_F_FISCALCODE_1 = "esfOrganization.fiscalCode IS NULL AND ";
	private static final String _FINDER_COLUMN_G_F_FISCALCODE_2 = "esfOrganization.fiscalCode = ? AND ";
	private static final String _FINDER_COLUMN_G_F_FISCALCODE_3 = "(esfOrganization.fiscalCode IS NULL OR esfOrganization.fiscalCode = '') AND ";
	private static final String _FINDER_COLUMN_G_F_GROUPID_2 = "esfOrganization.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODELIKE = new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCodeLike",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CODELIKE =
		new FinderPath(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCodeLike",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f organizations where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByCodeLike(String code)
		throws SystemException {
		return findByCodeLike(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organizations where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByCodeLike(String code, int start, int end)
		throws SystemException {
		return findByCodeLike(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findByCodeLike(String code, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODELIKE;
		finderArgs = new Object[] { code, start, end, orderByComparator };

		List<ESFOrganization> list = (List<ESFOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganization esfOrganization : list) {
				if (!StringUtil.wildcardMatches(esfOrganization.getCode(),
							code, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false)) {
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

			query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODELIKE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODELIKE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODELIKE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code.toLowerCase());
				}

				if (!pagination) {
					list = (List<ESFOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization>(list);
				}
				else {
					list = (List<ESFOrganization>)QueryUtil.list(q,
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
	 * Returns the first e s f organization in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByCodeLike_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByCodeLike_First(code,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first e s f organization in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByCodeLike_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganization> list = findByCodeLike(code, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByCodeLike_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByCodeLike_Last(code,
				orderByComparator);

		if (esfOrganization != null) {
			return esfOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last e s f organization in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByCodeLike_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCodeLike(code);

		if (count == 0) {
			return null;
		}

		List<ESFOrganization> list = findByCodeLike(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organizations before and after the current e s f organization in the ordered set where code LIKE &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization[] findByCodeLike_PrevAndNext(
		long esfOrganizationId, String code, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization[] array = new ESFOrganizationImpl[3];

			array[0] = getByCodeLike_PrevAndNext(session, esfOrganization,
					code, orderByComparator, true);

			array[1] = esfOrganization;

			array[2] = getByCodeLike_PrevAndNext(session, esfOrganization,
					code, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganization getByCodeLike_PrevAndNext(Session session,
		ESFOrganization esfOrganization, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATION_WHERE);

		boolean bindCode = false;

		if (code == null) {
			query.append(_FINDER_COLUMN_CODELIKE_CODE_1);
		}
		else if (code.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODELIKE_CODE_3);
		}
		else {
			bindCode = true;

			query.append(_FINDER_COLUMN_CODELIKE_CODE_2);
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
			query.append(ESFOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCode) {
			qPos.add(code.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organizations where code LIKE &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCodeLike(String code) throws SystemException {
		for (ESFOrganization esfOrganization : findByCodeLike(code,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganization);
		}
	}

	/**
	 * Returns the number of e s f organizations where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCodeLike(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CODELIKE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATION_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODELIKE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODELIKE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODELIKE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code.toLowerCase());
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

	private static final String _FINDER_COLUMN_CODELIKE_CODE_1 = "esfOrganization.code LIKE NULL";
	private static final String _FINDER_COLUMN_CODELIKE_CODE_2 = "lower(esfOrganization.code) LIKE ?";
	private static final String _FINDER_COLUMN_CODELIKE_CODE_3 = "(esfOrganization.code IS NULL OR esfOrganization.code LIKE '')";

	public ESFOrganizationPersistenceImpl() {
		setModelClass(ESFOrganization.class);
	}

	/**
	 * Caches the e s f organization in the entity cache if it is enabled.
	 *
	 * @param esfOrganization the e s f organization
	 */
	@Override
	public void cacheResult(ESFOrganization esfOrganization) {
		EntityCacheUtil.putResult(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationImpl.class, esfOrganization.getPrimaryKey(),
			esfOrganization);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfOrganization.getUuid(), esfOrganization.getGroupId() },
			esfOrganization);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfOrganization.getCode() }, esfOrganization);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAT,
			new Object[] { esfOrganization.getVat() }, esfOrganization);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE,
			new Object[] { esfOrganization.getFiscalCode() }, esfOrganization);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
			new Object[] { esfOrganization.getCode(), esfOrganization.getGroupId() },
			esfOrganization);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_V,
			new Object[] { esfOrganization.getVat(), esfOrganization.getGroupId() },
			esfOrganization);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F,
			new Object[] {
				esfOrganization.getFiscalCode(), esfOrganization.getGroupId()
			}, esfOrganization);

		esfOrganization.resetOriginalValues();
	}

	/**
	 * Caches the e s f organizations in the entity cache if it is enabled.
	 *
	 * @param esfOrganizations the e s f organizations
	 */
	@Override
	public void cacheResult(List<ESFOrganization> esfOrganizations) {
		for (ESFOrganization esfOrganization : esfOrganizations) {
			if (EntityCacheUtil.getResult(
						ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrganizationImpl.class,
						esfOrganization.getPrimaryKey()) == null) {
				cacheResult(esfOrganization);
			}
			else {
				esfOrganization.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f organizations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFOrganizationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFOrganizationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f organization.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFOrganization esfOrganization) {
		EntityCacheUtil.removeResult(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationImpl.class, esfOrganization.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfOrganization);
	}

	@Override
	public void clearCache(List<ESFOrganization> esfOrganizations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFOrganization esfOrganization : esfOrganizations) {
			EntityCacheUtil.removeResult(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrganizationImpl.class, esfOrganization.getPrimaryKey());

			clearUniqueFindersCache(esfOrganization);
		}
	}

	protected void cacheUniqueFindersCache(ESFOrganization esfOrganization) {
		if (esfOrganization.isNew()) {
			Object[] args = new Object[] {
					esfOrganization.getUuid(), esfOrganization.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfOrganization);

			args = new Object[] { esfOrganization.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
				esfOrganization);

			args = new Object[] { esfOrganization.getVat() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VAT, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAT, args,
				esfOrganization);

			args = new Object[] { esfOrganization.getFiscalCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FISCALCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE, args,
				esfOrganization);

			args = new Object[] {
					esfOrganization.getCode(), esfOrganization.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C, args,
				esfOrganization);

			args = new Object[] {
					esfOrganization.getVat(), esfOrganization.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_V, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_V, args,
				esfOrganization);

			args = new Object[] {
					esfOrganization.getFiscalCode(),
					esfOrganization.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_F, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F, args,
				esfOrganization);
		}
		else {
			ESFOrganizationModelImpl esfOrganizationModelImpl = (ESFOrganizationModelImpl)esfOrganization;

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganization.getUuid(), esfOrganization.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfOrganization);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfOrganization.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfOrganization);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VAT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfOrganization.getVat() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VAT, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VAT, args,
					esfOrganization);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FISCALCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfOrganization.getFiscalCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FISCALCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FISCALCODE,
					args, esfOrganization);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganization.getCode(), esfOrganization.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C, args,
					esfOrganization);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganization.getVat(), esfOrganization.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_V, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_V, args,
					esfOrganization);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_F.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganization.getFiscalCode(),
						esfOrganization.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_F, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F, args,
					esfOrganization);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFOrganization esfOrganization) {
		ESFOrganizationModelImpl esfOrganizationModelImpl = (ESFOrganizationModelImpl)esfOrganization;

		Object[] args = new Object[] {
				esfOrganization.getUuid(), esfOrganization.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfOrganizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfOrganizationModelImpl.getOriginalUuid(),
					esfOrganizationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { esfOrganization.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfOrganizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfOrganizationModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}

		args = new Object[] { esfOrganization.getVat() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAT, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VAT, args);

		if ((esfOrganizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_VAT.getColumnBitmask()) != 0) {
			args = new Object[] { esfOrganizationModelImpl.getOriginalVat() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VAT, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VAT, args);
		}

		args = new Object[] { esfOrganization.getFiscalCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FISCALCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FISCALCODE, args);

		if ((esfOrganizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FISCALCODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfOrganizationModelImpl.getOriginalFiscalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FISCALCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FISCALCODE, args);
		}

		args = new Object[] {
				esfOrganization.getCode(), esfOrganization.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C, args);

		if ((esfOrganizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_C.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfOrganizationModelImpl.getOriginalCode(),
					esfOrganizationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C, args);
		}

		args = new Object[] {
				esfOrganization.getVat(), esfOrganization.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_V, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_V, args);

		if ((esfOrganizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_V.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfOrganizationModelImpl.getOriginalVat(),
					esfOrganizationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_V, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_V, args);
		}

		args = new Object[] {
				esfOrganization.getFiscalCode(), esfOrganization.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_F, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F, args);

		if ((esfOrganizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_F.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfOrganizationModelImpl.getOriginalFiscalCode(),
					esfOrganizationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_F, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F, args);
		}
	}

	/**
	 * Creates a new e s f organization with the primary key. Does not add the e s f organization to the database.
	 *
	 * @param esfOrganizationId the primary key for the new e s f organization
	 * @return the new e s f organization
	 */
	@Override
	public ESFOrganization create(long esfOrganizationId) {
		ESFOrganization esfOrganization = new ESFOrganizationImpl();

		esfOrganization.setNew(true);
		esfOrganization.setPrimaryKey(esfOrganizationId);

		String uuid = PortalUUIDUtil.generate();

		esfOrganization.setUuid(uuid);

		return esfOrganization;
	}

	/**
	 * Removes the e s f organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrganizationId the primary key of the e s f organization
	 * @return the e s f organization that was removed
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization remove(long esfOrganizationId)
		throws NoSuchOrganizationException, SystemException {
		return remove((Serializable)esfOrganizationId);
	}

	/**
	 * Removes the e s f organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f organization
	 * @return the e s f organization that was removed
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization remove(Serializable primaryKey)
		throws NoSuchOrganizationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFOrganization esfOrganization = (ESFOrganization)session.get(ESFOrganizationImpl.class,
					primaryKey);

			if (esfOrganization == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfOrganization);
		}
		catch (NoSuchOrganizationException nsee) {
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
	protected ESFOrganization removeImpl(ESFOrganization esfOrganization)
		throws SystemException {
		esfOrganization = toUnwrappedModel(esfOrganization);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfOrganization)) {
				esfOrganization = (ESFOrganization)session.get(ESFOrganizationImpl.class,
						esfOrganization.getPrimaryKeyObj());
			}

			if (esfOrganization != null) {
				session.delete(esfOrganization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfOrganization != null) {
			clearCache(esfOrganization);
		}

		return esfOrganization;
	}

	@Override
	public ESFOrganization updateImpl(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws SystemException {
		esfOrganization = toUnwrappedModel(esfOrganization);

		boolean isNew = esfOrganization.isNew();

		ESFOrganizationModelImpl esfOrganizationModelImpl = (ESFOrganizationModelImpl)esfOrganization;

		if (Validator.isNull(esfOrganization.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfOrganization.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfOrganization.isNew()) {
				session.save(esfOrganization);

				esfOrganization.setNew(false);
			}
			else {
				session.merge(esfOrganization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFOrganizationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfOrganizationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfOrganizationModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { esfOrganizationModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTISPORT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationModelImpl.getOriginalIsMultiSport()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MULTISPORT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTISPORT,
					args);

				args = new Object[] { esfOrganizationModelImpl.getIsMultiSport() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MULTISPORT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTISPORT,
					args);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEGALFORM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationModelImpl.getOriginalLegalForm()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEGALFORM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEGALFORM,
					args);

				args = new Object[] { esfOrganizationModelImpl.getLegalForm() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEGALFORM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEGALFORM,
					args);
			}

			if ((esfOrganizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationModelImpl.getOriginalCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { esfOrganizationModelImpl.getCategory() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationImpl.class, esfOrganization.getPrimaryKey(),
			esfOrganization);

		clearUniqueFindersCache(esfOrganization);
		cacheUniqueFindersCache(esfOrganization);

		return esfOrganization;
	}

	protected ESFOrganization toUnwrappedModel(ESFOrganization esfOrganization) {
		if (esfOrganization instanceof ESFOrganizationImpl) {
			return esfOrganization;
		}

		ESFOrganizationImpl esfOrganizationImpl = new ESFOrganizationImpl();

		esfOrganizationImpl.setNew(esfOrganization.isNew());
		esfOrganizationImpl.setPrimaryKey(esfOrganization.getPrimaryKey());

		esfOrganizationImpl.setUuid(esfOrganization.getUuid());
		esfOrganizationImpl.setEsfOrganizationId(esfOrganization.getEsfOrganizationId());
		esfOrganizationImpl.setGroupId(esfOrganization.getGroupId());
		esfOrganizationImpl.setCode(esfOrganization.getCode());
		esfOrganizationImpl.setVat(esfOrganization.getVat());
		esfOrganizationImpl.setFiscalCode(esfOrganization.getFiscalCode());
		esfOrganizationImpl.setIbanCode(esfOrganization.getIbanCode());
		esfOrganizationImpl.setIsMultiSport(esfOrganization.isIsMultiSport());
		esfOrganizationImpl.setLegalForm(esfOrganization.getLegalForm());
		esfOrganizationImpl.setCategory(esfOrganization.getCategory());
		esfOrganizationImpl.setEstablishmentDate(esfOrganization.getEstablishmentDate());
		esfOrganizationImpl.setClosureDate(esfOrganization.getClosureDate());
		esfOrganizationImpl.setType(esfOrganization.getType());
		esfOrganizationImpl.setInsertDate(esfOrganization.getInsertDate());
		esfOrganizationImpl.setConiDate(esfOrganization.getConiDate());
		esfOrganizationImpl.setConiCode(esfOrganization.getConiCode());
		esfOrganizationImpl.setDescription(esfOrganization.getDescription());
		esfOrganizationImpl.setIsYouthActive(esfOrganization.isIsYouthActive());
		esfOrganizationImpl.setFirstAffiliationDate(esfOrganization.getFirstAffiliationDate());
		esfOrganizationImpl.setVariations(esfOrganization.getVariations());
		esfOrganizationImpl.setRegionCode(esfOrganization.getRegionCode());
		esfOrganizationImpl.setIdFatherAssociation(esfOrganization.getIdFatherAssociation());
		esfOrganizationImpl.setConstitutiveAct(esfOrganization.isConstitutiveAct());
		esfOrganizationImpl.setRegisteredStatus(esfOrganization.isRegisteredStatus());
		esfOrganizationImpl.setPlanimetrySportsStand(esfOrganization.isPlanimetrySportsStand());
		esfOrganizationImpl.setCertificateFITAV(esfOrganization.isCertificateFITAV());
		esfOrganizationImpl.setNote(esfOrganization.getNote());
		esfOrganizationImpl.setIsSimplyOrganizzation(esfOrganization.isIsSimplyOrganizzation());
		esfOrganizationImpl.setWebSite(esfOrganization.getWebSite());
		esfOrganizationImpl.setIncludeConiReport(esfOrganization.isIncludeConiReport());
		esfOrganizationImpl.setOrganizzationCategory(esfOrganization.getOrganizzationCategory());

		return esfOrganizationImpl;
	}

	/**
	 * Returns the e s f organization with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f organization
	 * @return the e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationException, SystemException {
		ESFOrganization esfOrganization = fetchByPrimaryKey(primaryKey);

		if (esfOrganization == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization with the primary key or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param esfOrganizationId the primary key of the e s f organization
	 * @return the e s f organization
	 * @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization findByPrimaryKey(long esfOrganizationId)
		throws NoSuchOrganizationException, SystemException {
		return findByPrimaryKey((Serializable)esfOrganizationId);
	}

	/**
	 * Returns the e s f organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f organization
	 * @return the e s f organization, or <code>null</code> if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFOrganization esfOrganization = (ESFOrganization)EntityCacheUtil.getResult(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrganizationImpl.class, primaryKey);

		if (esfOrganization == _nullESFOrganization) {
			return null;
		}

		if (esfOrganization == null) {
			Session session = null;

			try {
				session = openSession();

				esfOrganization = (ESFOrganization)session.get(ESFOrganizationImpl.class,
						primaryKey);

				if (esfOrganization != null) {
					cacheResult(esfOrganization);
				}
				else {
					EntityCacheUtil.putResult(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrganizationImpl.class, primaryKey,
						_nullESFOrganization);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFOrganizationModelImpl.ENTITY_CACHE_ENABLED,
					ESFOrganizationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfOrganization;
	}

	/**
	 * Returns the e s f organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfOrganizationId the primary key of the e s f organization
	 * @return the e s f organization, or <code>null</code> if a e s f organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization fetchByPrimaryKey(long esfOrganizationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfOrganizationId);
	}

	/**
	 * Returns all the e s f organizations.
	 *
	 * @return the e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @return the range of e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organizations
	 * @param end the upper bound of the range of e s f organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization> findAll(int start, int end,
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

		List<ESFOrganization> list = (List<ESFOrganization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFORGANIZATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFORGANIZATION;

				if (pagination) {
					sql = sql.concat(ESFOrganizationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFOrganization>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization>(list);
				}
				else {
					list = (List<ESFOrganization>)QueryUtil.list(q,
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
	 * Removes all the e s f organizations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFOrganization esfOrganization : findAll()) {
			remove(esfOrganization);
		}
	}

	/**
	 * Returns the number of e s f organizations.
	 *
	 * @return the number of e s f organizations
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

				Query q = session.createQuery(_SQL_COUNT_ESFORGANIZATION);

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
	 * Initializes the e s f organization persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFOrganization")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFOrganization>> listenersList = new ArrayList<ModelListener<ESFOrganization>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFOrganization>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFOrganizationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFORGANIZATION = "SELECT esfOrganization FROM ESFOrganization esfOrganization";
	private static final String _SQL_SELECT_ESFORGANIZATION_WHERE = "SELECT esfOrganization FROM ESFOrganization esfOrganization WHERE ";
	private static final String _SQL_COUNT_ESFORGANIZATION = "SELECT COUNT(esfOrganization) FROM ESFOrganization esfOrganization";
	private static final String _SQL_COUNT_ESFORGANIZATION_WHERE = "SELECT COUNT(esfOrganization) FROM ESFOrganization esfOrganization WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "esfOrganization.esfOrganizationId";
	private static final String _FILTER_SQL_SELECT_ESFORGANIZATION_WHERE = "SELECT DISTINCT {esfOrganization.*} FROM ESFOrganization esfOrganization WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFORGANIZATION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ESFOrganization.*} FROM (SELECT DISTINCT esfOrganization.esfOrganizationId FROM ESFOrganization esfOrganization WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFORGANIZATION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ESFOrganization ON TEMP_TABLE.esfOrganizationId = ESFOrganization.esfOrganizationId";
	private static final String _FILTER_SQL_COUNT_ESFORGANIZATION_WHERE = "SELECT COUNT(DISTINCT esfOrganization.esfOrganizationId) AS COUNT_VALUE FROM ESFOrganization esfOrganization WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "esfOrganization";
	private static final String _FILTER_ENTITY_TABLE = "ESFOrganization";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfOrganization.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ESFOrganization.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFOrganization exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFOrganization exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFOrganizationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code", "type"
			});
	private static ESFOrganization _nullESFOrganization = new ESFOrganizationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFOrganization> toCacheModel() {
				return _nullESFOrganizationCacheModel;
			}
		};

	private static CacheModel<ESFOrganization> _nullESFOrganizationCacheModel = new CacheModel<ESFOrganization>() {
			@Override
			public ESFOrganization toEntityModel() {
				return _nullESFOrganization;
			}
		};
}