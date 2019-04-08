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

import it.ethica.esf.NoSuchOrganizationUnitserviceException;
import it.ethica.esf.model.ESFOrganizationUnitservice;
import it.ethica.esf.model.impl.ESFOrganizationUnitserviceImpl;
import it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f organization unitservice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationUnitservicePersistence
 * @see ESFOrganizationUnitserviceUtil
 * @generated
 */
public class ESFOrganizationUnitservicePersistenceImpl
	extends BasePersistenceImpl<ESFOrganizationUnitservice>
	implements ESFOrganizationUnitservicePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFOrganizationUnitserviceUtil} to access the e s f organization unitservice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFOrganizationUnitserviceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFOrganizationUnitserviceModelImpl.UUID_COLUMN_BITMASK |
			ESFOrganizationUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the e s f organization unitservices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization unitservices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @return the range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization unitservices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByUuid(String uuid, int start,
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

		List<ESFOrganizationUnitservice> list = (List<ESFOrganizationUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganizationUnitservice esfOrganizationUnitservice : list) {
				if (!Validator.equals(uuid, esfOrganizationUnitservice.getUuid())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

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
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationUnitservice>(list);
				}
				else {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f organization unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f organization unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganizationUnitservice> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFOrganizationUnitservice> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice[] findByUuid_PrevAndNext(
		long esfOrganizationUnitserviceId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = findByPrimaryKey(esfOrganizationUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganizationUnitservice[] array = new ESFOrganizationUnitserviceImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					esfOrganizationUnitservice, uuid, orderByComparator, true);

			array[1] = esfOrganizationUnitservice;

			array[2] = getByUuid_PrevAndNext(session,
					esfOrganizationUnitservice, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganizationUnitservice getByUuid_PrevAndNext(
		Session session, ESFOrganizationUnitservice esfOrganizationUnitservice,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

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
			query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganizationUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganizationUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organization unitservices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFOrganizationUnitservice esfOrganizationUnitservice : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganizationUnitservice);
		}
	}

	/**
	 * Returns the number of e s f organization unitservices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f organization unitservices
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

			query.append(_SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfOrganizationUnitservice.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfOrganizationUnitservice.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfOrganizationUnitservice.uuid IS NULL OR esfOrganizationUnitservice.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFOrganizationUnitserviceModelImpl.UUID_COLUMN_BITMASK |
			ESFOrganizationUnitserviceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f organization unitservice where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationUnitserviceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByUUID_G(String uuid, long groupId)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByUUID_G(uuid,
				groupId);

		if (esfOrganizationUnitservice == null) {
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

			throw new NoSuchOrganizationUnitserviceException(msg.toString());
		}

		return esfOrganizationUnitservice;
	}

	/**
	 * Returns the e s f organization unitservice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f organization unitservice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFOrganizationUnitservice) {
			ESFOrganizationUnitservice esfOrganizationUnitservice = (ESFOrganizationUnitservice)result;

			if (!Validator.equals(uuid, esfOrganizationUnitservice.getUuid()) ||
					(groupId != esfOrganizationUnitservice.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

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

				List<ESFOrganizationUnitservice> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFOrganizationUnitservice esfOrganizationUnitservice = list.get(0);

					result = esfOrganizationUnitservice;

					cacheResult(esfOrganizationUnitservice);

					if ((esfOrganizationUnitservice.getUuid() == null) ||
							!esfOrganizationUnitservice.getUuid().equals(uuid) ||
							(esfOrganizationUnitservice.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfOrganizationUnitservice);
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
			return (ESFOrganizationUnitservice)result;
		}
	}

	/**
	 * Removes the e s f organization unitservice where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f organization unitservice that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice removeByUUID_G(String uuid, long groupId)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = findByUUID_G(uuid,
				groupId);

		return remove(esfOrganizationUnitservice);
	}

	/**
	 * Returns the number of e s f organization unitservices where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f organization unitservices
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

			query.append(_SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfOrganizationUnitservice.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfOrganizationUnitservice.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfOrganizationUnitservice.uuid IS NULL OR esfOrganizationUnitservice.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfOrganizationUnitservice.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFOrganizationUnitserviceModelImpl.UUID_COLUMN_BITMASK |
			ESFOrganizationUnitserviceModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFOrganizationUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f organization unitservices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByUuid_C(String uuid,
		long companyId) throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization unitservices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @return the range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization unitservices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByUuid_C(String uuid,
		long companyId, int start, int end, OrderByComparator orderByComparator)
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

		List<ESFOrganizationUnitservice> list = (List<ESFOrganizationUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganizationUnitservice esfOrganizationUnitservice : list) {
				if (!Validator.equals(uuid, esfOrganizationUnitservice.getUuid()) ||
						(companyId != esfOrganizationUnitservice.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

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
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationUnitservice>(list);
				}
				else {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFOrganizationUnitservice> list = findByUuid_C(uuid, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFOrganizationUnitservice> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice[] findByUuid_C_PrevAndNext(
		long esfOrganizationUnitserviceId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = findByPrimaryKey(esfOrganizationUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganizationUnitservice[] array = new ESFOrganizationUnitserviceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					esfOrganizationUnitservice, uuid, companyId,
					orderByComparator, true);

			array[1] = esfOrganizationUnitservice;

			array[2] = getByUuid_C_PrevAndNext(session,
					esfOrganizationUnitservice, uuid, companyId,
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

	protected ESFOrganizationUnitservice getByUuid_C_PrevAndNext(
		Session session, ESFOrganizationUnitservice esfOrganizationUnitservice,
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

		query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

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
			query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganizationUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganizationUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organization unitservices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFOrganizationUnitservice esfOrganizationUnitservice : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganizationUnitservice);
		}
	}

	/**
	 * Returns the number of e s f organization unitservices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f organization unitservices
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

			query.append(_SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfOrganizationUnitservice.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfOrganizationUnitservice.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfOrganizationUnitservice.uuid IS NULL OR esfOrganizationUnitservice.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfOrganizationUnitservice.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFOrganizationUnitserviceModelImpl.GROUPID_COLUMN_BITMASK |
			ESFOrganizationUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f organization unitservices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization unitservices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @return the range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByGroupId(long groupId,
		int start, int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization unitservices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByGroupId(long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ESFOrganizationUnitservice> list = (List<ESFOrganizationUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganizationUnitservice esfOrganizationUnitservice : list) {
				if ((groupId != esfOrganizationUnitservice.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationUnitservice>(list);
				}
				else {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f organization unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByGroupId_First(groupId,
				orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f organization unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrganizationUnitservice> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFOrganizationUnitservice> list = findByGroupId(groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice[] findByGroupId_PrevAndNext(
		long esfOrganizationUnitserviceId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = findByPrimaryKey(esfOrganizationUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganizationUnitservice[] array = new ESFOrganizationUnitserviceImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					esfOrganizationUnitservice, groupId, orderByComparator, true);

			array[1] = esfOrganizationUnitservice;

			array[2] = getByGroupId_PrevAndNext(session,
					esfOrganizationUnitservice, groupId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganizationUnitservice getByGroupId_PrevAndNext(
		Session session, ESFOrganizationUnitservice esfOrganizationUnitservice,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

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
			query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganizationUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganizationUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e s f organization unitservices that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f organization unitservices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization unitservices that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @return the range of matching e s f organization unitservices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> filterFindByGroupId(long groupId,
		int start, int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization unitservices that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization unitservices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> filterFindByGroupId(long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFOrganizationUnitservice.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS,
					ESFOrganizationUnitserviceImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE,
					ESFOrganizationUnitserviceImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
				getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set of e s f organization unitservices that the user has permission to view where groupId = &#63;.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice[] filterFindByGroupId_PrevAndNext(
		long esfOrganizationUnitserviceId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(esfOrganizationUnitserviceId,
				groupId, orderByComparator);
		}

		ESFOrganizationUnitservice esfOrganizationUnitservice = findByPrimaryKey(esfOrganizationUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganizationUnitservice[] array = new ESFOrganizationUnitserviceImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session,
					esfOrganizationUnitservice, groupId, orderByComparator, true);

			array[1] = esfOrganizationUnitservice;

			array[2] = filterGetByGroupId_PrevAndNext(session,
					esfOrganizationUnitservice, groupId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganizationUnitservice filterGetByGroupId_PrevAndNext(
		Session session, ESFOrganizationUnitservice esfOrganizationUnitservice,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFOrganizationUnitservice.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS,
				ESFOrganizationUnitserviceImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE,
				ESFOrganizationUnitserviceImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganizationUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganizationUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organization unitservices where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFOrganizationUnitservice esfOrganizationUnitservice : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganizationUnitservice);
		}
	}

	/**
	 * Returns the number of e s f organization unitservices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f organization unitservices
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

			query.append(_SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE);

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
	 * Returns the number of e s f organization unitservices that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f organization unitservices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFOrganizationUnitservice.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfOrganizationUnitservice.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEsfOrganizationId", new String[] { Long.class.getName() },
			ESFOrganizationUnitserviceModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK |
			ESFOrganizationUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFORGANIZATIONID = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEsfOrganizationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f organization unitservices where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByEsfOrganizationId(
		long esfOrganizationId) throws SystemException {
		return findByEsfOrganizationId(esfOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization unitservices where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @return the range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByEsfOrganizationId(
		long esfOrganizationId, int start, int end) throws SystemException {
		return findByEsfOrganizationId(esfOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization unitservices where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByEsfOrganizationId(
		long esfOrganizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFOrganizationUnitservice> list = (List<ESFOrganizationUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganizationUnitservice esfOrganizationUnitservice : list) {
				if ((esfOrganizationId != esfOrganizationUnitservice.getEsfOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

			query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				if (!pagination) {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationUnitservice>(list);
				}
				else {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByEsfOrganizationId_First(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByEsfOrganizationId_First(esfOrganizationId,
				orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByEsfOrganizationId_First(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFOrganizationUnitservice> list = findByEsfOrganizationId(esfOrganizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByEsfOrganizationId_Last(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByEsfOrganizationId_Last(esfOrganizationId,
				orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByEsfOrganizationId_Last(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByEsfOrganizationId(esfOrganizationId);

		if (count == 0) {
			return null;
		}

		List<ESFOrganizationUnitservice> list = findByEsfOrganizationId(esfOrganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice[] findByEsfOrganizationId_PrevAndNext(
		long esfOrganizationUnitserviceId, long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = findByPrimaryKey(esfOrganizationUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganizationUnitservice[] array = new ESFOrganizationUnitserviceImpl[3];

			array[0] = getByEsfOrganizationId_PrevAndNext(session,
					esfOrganizationUnitservice, esfOrganizationId,
					orderByComparator, true);

			array[1] = esfOrganizationUnitservice;

			array[2] = getByEsfOrganizationId_PrevAndNext(session,
					esfOrganizationUnitservice, esfOrganizationId,
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

	protected ESFOrganizationUnitservice getByEsfOrganizationId_PrevAndNext(
		Session session, ESFOrganizationUnitservice esfOrganizationUnitservice,
		long esfOrganizationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

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
			query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganizationUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganizationUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organization unitservices where esfOrganizationId = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfOrganizationId(long esfOrganizationId)
		throws SystemException {
		for (ESFOrganizationUnitservice esfOrganizationUnitservice : findByEsfOrganizationId(
				esfOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganizationUnitservice);
		}
	}

	/**
	 * Returns the number of e s f organization unitservices where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the number of matching e s f organization unitservices
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

			query.append(_SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE);

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
		"esfOrganizationUnitservice.esfOrganizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUNITSERVICEID =
		new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfUnitserviceId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUNITSERVICEID =
		new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEsfUnitserviceId", new String[] { Long.class.getName() },
			ESFOrganizationUnitserviceModelImpl.ESFUNITSERVICEID_COLUMN_BITMASK |
			ESFOrganizationUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUNITSERVICEID = new FinderPath(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEsfUnitserviceId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f organization unitservices where esfUnitserviceId = &#63;.
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @return the matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByEsfUnitserviceId(
		long esfUnitserviceId) throws SystemException {
		return findByEsfUnitserviceId(esfUnitserviceId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization unitservices where esfUnitserviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @return the range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByEsfUnitserviceId(
		long esfUnitserviceId, int start, int end) throws SystemException {
		return findByEsfUnitserviceId(esfUnitserviceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization unitservices where esfUnitserviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findByEsfUnitserviceId(
		long esfUnitserviceId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUNITSERVICEID;
			finderArgs = new Object[] { esfUnitserviceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUNITSERVICEID;
			finderArgs = new Object[] {
					esfUnitserviceId,
					
					start, end, orderByComparator
				};
		}

		List<ESFOrganizationUnitservice> list = (List<ESFOrganizationUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganizationUnitservice esfOrganizationUnitservice : list) {
				if ((esfUnitserviceId != esfOrganizationUnitservice.getEsfUnitserviceId())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

			query.append(_FINDER_COLUMN_ESFUNITSERVICEID_ESFUNITSERVICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUnitserviceId);

				if (!pagination) {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationUnitservice>(list);
				}
				else {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByEsfUnitserviceId_First(
		long esfUnitserviceId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByEsfUnitserviceId_First(esfUnitserviceId,
				orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUnitserviceId=");
		msg.append(esfUnitserviceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByEsfUnitserviceId_First(
		long esfUnitserviceId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFOrganizationUnitservice> list = findByEsfUnitserviceId(esfUnitserviceId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByEsfUnitserviceId_Last(
		long esfUnitserviceId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByEsfUnitserviceId_Last(esfUnitserviceId,
				orderByComparator);

		if (esfOrganizationUnitservice != null) {
			return esfOrganizationUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUnitserviceId=");
		msg.append(esfUnitserviceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByEsfUnitserviceId_Last(
		long esfUnitserviceId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByEsfUnitserviceId(esfUnitserviceId);

		if (count == 0) {
			return null;
		}

		List<ESFOrganizationUnitservice> list = findByEsfUnitserviceId(esfUnitserviceId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	 * @param esfUnitserviceId the esf unitservice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice[] findByEsfUnitserviceId_PrevAndNext(
		long esfOrganizationUnitserviceId, long esfUnitserviceId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = findByPrimaryKey(esfOrganizationUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganizationUnitservice[] array = new ESFOrganizationUnitserviceImpl[3];

			array[0] = getByEsfUnitserviceId_PrevAndNext(session,
					esfOrganizationUnitservice, esfUnitserviceId,
					orderByComparator, true);

			array[1] = esfOrganizationUnitservice;

			array[2] = getByEsfUnitserviceId_PrevAndNext(session,
					esfOrganizationUnitservice, esfUnitserviceId,
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

	protected ESFOrganizationUnitservice getByEsfUnitserviceId_PrevAndNext(
		Session session, ESFOrganizationUnitservice esfOrganizationUnitservice,
		long esfUnitserviceId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE);

		query.append(_FINDER_COLUMN_ESFUNITSERVICEID_ESFUNITSERVICEID_2);

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
			query.append(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUnitserviceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganizationUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganizationUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organization unitservices where esfUnitserviceId = &#63; from the database.
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfUnitserviceId(long esfUnitserviceId)
		throws SystemException {
		for (ESFOrganizationUnitservice esfOrganizationUnitservice : findByEsfUnitserviceId(
				esfUnitserviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganizationUnitservice);
		}
	}

	/**
	 * Returns the number of e s f organization unitservices where esfUnitserviceId = &#63;.
	 *
	 * @param esfUnitserviceId the esf unitservice ID
	 * @return the number of matching e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfUnitserviceId(long esfUnitserviceId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUNITSERVICEID;

		Object[] finderArgs = new Object[] { esfUnitserviceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE);

			query.append(_FINDER_COLUMN_ESFUNITSERVICEID_ESFUNITSERVICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUnitserviceId);

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

	private static final String _FINDER_COLUMN_ESFUNITSERVICEID_ESFUNITSERVICEID_2 =
		"esfOrganizationUnitservice.esfUnitserviceId = ?";

	public ESFOrganizationUnitservicePersistenceImpl() {
		setModelClass(ESFOrganizationUnitservice.class);
	}

	/**
	 * Caches the e s f organization unitservice in the entity cache if it is enabled.
	 *
	 * @param esfOrganizationUnitservice the e s f organization unitservice
	 */
	@Override
	public void cacheResult(
		ESFOrganizationUnitservice esfOrganizationUnitservice) {
		EntityCacheUtil.putResult(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			esfOrganizationUnitservice.getPrimaryKey(),
			esfOrganizationUnitservice);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				esfOrganizationUnitservice.getUuid(),
				esfOrganizationUnitservice.getGroupId()
			}, esfOrganizationUnitservice);

		esfOrganizationUnitservice.resetOriginalValues();
	}

	/**
	 * Caches the e s f organization unitservices in the entity cache if it is enabled.
	 *
	 * @param esfOrganizationUnitservices the e s f organization unitservices
	 */
	@Override
	public void cacheResult(
		List<ESFOrganizationUnitservice> esfOrganizationUnitservices) {
		for (ESFOrganizationUnitservice esfOrganizationUnitservice : esfOrganizationUnitservices) {
			if (EntityCacheUtil.getResult(
						ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrganizationUnitserviceImpl.class,
						esfOrganizationUnitservice.getPrimaryKey()) == null) {
				cacheResult(esfOrganizationUnitservice);
			}
			else {
				esfOrganizationUnitservice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f organization unitservices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFOrganizationUnitserviceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFOrganizationUnitserviceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f organization unitservice.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFOrganizationUnitservice esfOrganizationUnitservice) {
		EntityCacheUtil.removeResult(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			esfOrganizationUnitservice.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfOrganizationUnitservice);
	}

	@Override
	public void clearCache(
		List<ESFOrganizationUnitservice> esfOrganizationUnitservices) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFOrganizationUnitservice esfOrganizationUnitservice : esfOrganizationUnitservices) {
			EntityCacheUtil.removeResult(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrganizationUnitserviceImpl.class,
				esfOrganizationUnitservice.getPrimaryKey());

			clearUniqueFindersCache(esfOrganizationUnitservice);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFOrganizationUnitservice esfOrganizationUnitservice) {
		if (esfOrganizationUnitservice.isNew()) {
			Object[] args = new Object[] {
					esfOrganizationUnitservice.getUuid(),
					esfOrganizationUnitservice.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfOrganizationUnitservice);
		}
		else {
			ESFOrganizationUnitserviceModelImpl esfOrganizationUnitserviceModelImpl =
				(ESFOrganizationUnitserviceModelImpl)esfOrganizationUnitservice;

			if ((esfOrganizationUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationUnitservice.getUuid(),
						esfOrganizationUnitservice.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfOrganizationUnitservice);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFOrganizationUnitservice esfOrganizationUnitservice) {
		ESFOrganizationUnitserviceModelImpl esfOrganizationUnitserviceModelImpl = (ESFOrganizationUnitserviceModelImpl)esfOrganizationUnitservice;

		Object[] args = new Object[] {
				esfOrganizationUnitservice.getUuid(),
				esfOrganizationUnitservice.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfOrganizationUnitserviceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfOrganizationUnitserviceModelImpl.getOriginalUuid(),
					esfOrganizationUnitserviceModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f organization unitservice with the primary key. Does not add the e s f organization unitservice to the database.
	 *
	 * @param esfOrganizationUnitserviceId the primary key for the new e s f organization unitservice
	 * @return the new e s f organization unitservice
	 */
	@Override
	public ESFOrganizationUnitservice create(long esfOrganizationUnitserviceId) {
		ESFOrganizationUnitservice esfOrganizationUnitservice = new ESFOrganizationUnitserviceImpl();

		esfOrganizationUnitservice.setNew(true);
		esfOrganizationUnitservice.setPrimaryKey(esfOrganizationUnitserviceId);

		String uuid = PortalUUIDUtil.generate();

		esfOrganizationUnitservice.setUuid(uuid);

		return esfOrganizationUnitservice;
	}

	/**
	 * Removes the e s f organization unitservice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the e s f organization unitservice
	 * @return the e s f organization unitservice that was removed
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice remove(long esfOrganizationUnitserviceId)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		return remove((Serializable)esfOrganizationUnitserviceId);
	}

	/**
	 * Removes the e s f organization unitservice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f organization unitservice
	 * @return the e s f organization unitservice that was removed
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice remove(Serializable primaryKey)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFOrganizationUnitservice esfOrganizationUnitservice = (ESFOrganizationUnitservice)session.get(ESFOrganizationUnitserviceImpl.class,
					primaryKey);

			if (esfOrganizationUnitservice == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationUnitserviceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfOrganizationUnitservice);
		}
		catch (NoSuchOrganizationUnitserviceException nsee) {
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
	protected ESFOrganizationUnitservice removeImpl(
		ESFOrganizationUnitservice esfOrganizationUnitservice)
		throws SystemException {
		esfOrganizationUnitservice = toUnwrappedModel(esfOrganizationUnitservice);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfOrganizationUnitservice)) {
				esfOrganizationUnitservice = (ESFOrganizationUnitservice)session.get(ESFOrganizationUnitserviceImpl.class,
						esfOrganizationUnitservice.getPrimaryKeyObj());
			}

			if (esfOrganizationUnitservice != null) {
				session.delete(esfOrganizationUnitservice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfOrganizationUnitservice != null) {
			clearCache(esfOrganizationUnitservice);
		}

		return esfOrganizationUnitservice;
	}

	@Override
	public ESFOrganizationUnitservice updateImpl(
		it.ethica.esf.model.ESFOrganizationUnitservice esfOrganizationUnitservice)
		throws SystemException {
		esfOrganizationUnitservice = toUnwrappedModel(esfOrganizationUnitservice);

		boolean isNew = esfOrganizationUnitservice.isNew();

		ESFOrganizationUnitserviceModelImpl esfOrganizationUnitserviceModelImpl = (ESFOrganizationUnitserviceModelImpl)esfOrganizationUnitservice;

		if (Validator.isNull(esfOrganizationUnitservice.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfOrganizationUnitservice.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfOrganizationUnitservice.isNew()) {
				session.save(esfOrganizationUnitservice);

				esfOrganizationUnitservice.setNew(false);
			}
			else {
				session.merge(esfOrganizationUnitservice);
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
				!ESFOrganizationUnitserviceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfOrganizationUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfOrganizationUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getOriginalUuid(),
						esfOrganizationUnitserviceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getUuid(),
						esfOrganizationUnitserviceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfOrganizationUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfOrganizationUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getOriginalEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);

				args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);
			}

			if ((esfOrganizationUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUNITSERVICEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getOriginalEsfUnitserviceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUNITSERVICEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUNITSERVICEID,
					args);

				args = new Object[] {
						esfOrganizationUnitserviceModelImpl.getEsfUnitserviceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUNITSERVICEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUNITSERVICEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganizationUnitserviceImpl.class,
			esfOrganizationUnitservice.getPrimaryKey(),
			esfOrganizationUnitservice);

		clearUniqueFindersCache(esfOrganizationUnitservice);
		cacheUniqueFindersCache(esfOrganizationUnitservice);

		return esfOrganizationUnitservice;
	}

	protected ESFOrganizationUnitservice toUnwrappedModel(
		ESFOrganizationUnitservice esfOrganizationUnitservice) {
		if (esfOrganizationUnitservice instanceof ESFOrganizationUnitserviceImpl) {
			return esfOrganizationUnitservice;
		}

		ESFOrganizationUnitserviceImpl esfOrganizationUnitserviceImpl = new ESFOrganizationUnitserviceImpl();

		esfOrganizationUnitserviceImpl.setNew(esfOrganizationUnitservice.isNew());
		esfOrganizationUnitserviceImpl.setPrimaryKey(esfOrganizationUnitservice.getPrimaryKey());

		esfOrganizationUnitserviceImpl.setUuid(esfOrganizationUnitservice.getUuid());
		esfOrganizationUnitserviceImpl.setEsfOrganizationUnitserviceId(esfOrganizationUnitservice.getEsfOrganizationUnitserviceId());
		esfOrganizationUnitserviceImpl.setEsfOrganizationId(esfOrganizationUnitservice.getEsfOrganizationId());
		esfOrganizationUnitserviceImpl.setEsfUnitserviceId(esfOrganizationUnitservice.getEsfUnitserviceId());
		esfOrganizationUnitserviceImpl.setNumberUnitservices(esfOrganizationUnitservice.getNumberUnitservices());
		esfOrganizationUnitserviceImpl.setDescription(esfOrganizationUnitservice.getDescription());
		esfOrganizationUnitserviceImpl.setGroupId(esfOrganizationUnitservice.getGroupId());
		esfOrganizationUnitserviceImpl.setCompanyId(esfOrganizationUnitservice.getCompanyId());
		esfOrganizationUnitserviceImpl.setUserId(esfOrganizationUnitservice.getUserId());
		esfOrganizationUnitserviceImpl.setUserName(esfOrganizationUnitservice.getUserName());
		esfOrganizationUnitserviceImpl.setCreateDate(esfOrganizationUnitservice.getCreateDate());
		esfOrganizationUnitserviceImpl.setModifiedDate(esfOrganizationUnitservice.getModifiedDate());

		return esfOrganizationUnitserviceImpl;
	}

	/**
	 * Returns the e s f organization unitservice with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f organization unitservice
	 * @return the e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = fetchByPrimaryKey(primaryKey);

		if (esfOrganizationUnitservice == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationUnitserviceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfOrganizationUnitservice;
	}

	/**
	 * Returns the e s f organization unitservice with the primary key or throws a {@link it.ethica.esf.NoSuchOrganizationUnitserviceException} if it could not be found.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the e s f organization unitservice
	 * @return the e s f organization unitservice
	 * @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice findByPrimaryKey(
		long esfOrganizationUnitserviceId)
		throws NoSuchOrganizationUnitserviceException, SystemException {
		return findByPrimaryKey((Serializable)esfOrganizationUnitserviceId);
	}

	/**
	 * Returns the e s f organization unitservice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f organization unitservice
	 * @return the e s f organization unitservice, or <code>null</code> if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFOrganizationUnitservice esfOrganizationUnitservice = (ESFOrganizationUnitservice)EntityCacheUtil.getResult(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrganizationUnitserviceImpl.class, primaryKey);

		if (esfOrganizationUnitservice == _nullESFOrganizationUnitservice) {
			return null;
		}

		if (esfOrganizationUnitservice == null) {
			Session session = null;

			try {
				session = openSession();

				esfOrganizationUnitservice = (ESFOrganizationUnitservice)session.get(ESFOrganizationUnitserviceImpl.class,
						primaryKey);

				if (esfOrganizationUnitservice != null) {
					cacheResult(esfOrganizationUnitservice);
				}
				else {
					EntityCacheUtil.putResult(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrganizationUnitserviceImpl.class, primaryKey,
						_nullESFOrganizationUnitservice);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFOrganizationUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
					ESFOrganizationUnitserviceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfOrganizationUnitservice;
	}

	/**
	 * Returns the e s f organization unitservice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfOrganizationUnitserviceId the primary key of the e s f organization unitservice
	 * @return the e s f organization unitservice, or <code>null</code> if a e s f organization unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationUnitservice fetchByPrimaryKey(
		long esfOrganizationUnitserviceId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfOrganizationUnitserviceId);
	}

	/**
	 * Returns all the e s f organization unitservices.
	 *
	 * @return the e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization unitservices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @return the range of e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization unitservices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organization unitservices
	 * @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f organization unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationUnitservice> findAll(int start, int end,
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

		List<ESFOrganizationUnitservice> list = (List<ESFOrganizationUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFORGANIZATIONUNITSERVICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFORGANIZATIONUNITSERVICE;

				if (pagination) {
					sql = sql.concat(ESFOrganizationUnitserviceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganizationUnitservice>(list);
				}
				else {
					list = (List<ESFOrganizationUnitservice>)QueryUtil.list(q,
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
	 * Removes all the e s f organization unitservices from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFOrganizationUnitservice esfOrganizationUnitservice : findAll()) {
			remove(esfOrganizationUnitservice);
		}
	}

	/**
	 * Returns the number of e s f organization unitservices.
	 *
	 * @return the number of e s f organization unitservices
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

				Query q = session.createQuery(_SQL_COUNT_ESFORGANIZATIONUNITSERVICE);

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
	 * Initializes the e s f organization unitservice persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFOrganizationUnitservice")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFOrganizationUnitservice>> listenersList = new ArrayList<ModelListener<ESFOrganizationUnitservice>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFOrganizationUnitservice>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFOrganizationUnitserviceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFORGANIZATIONUNITSERVICE = "SELECT esfOrganizationUnitservice FROM ESFOrganizationUnitservice esfOrganizationUnitservice";
	private static final String _SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE = "SELECT esfOrganizationUnitservice FROM ESFOrganizationUnitservice esfOrganizationUnitservice WHERE ";
	private static final String _SQL_COUNT_ESFORGANIZATIONUNITSERVICE = "SELECT COUNT(esfOrganizationUnitservice) FROM ESFOrganizationUnitservice esfOrganizationUnitservice";
	private static final String _SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE = "SELECT COUNT(esfOrganizationUnitservice) FROM ESFOrganizationUnitservice esfOrganizationUnitservice WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "esfOrganizationUnitservice.esfOrganizationUnitserviceId";
	private static final String _FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_WHERE =
		"SELECT DISTINCT {esfOrganizationUnitservice.*} FROM ESFOrganizationUnitservice esfOrganizationUnitservice WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ESFOrganizationUnitservice.*} FROM (SELECT DISTINCT esfOrganizationUnitservice.esfOrganizationUnitserviceId FROM ESFOrganizationUnitservice esfOrganizationUnitservice WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFORGANIZATIONUNITSERVICE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ESFOrganizationUnitservice ON TEMP_TABLE.esfOrganizationUnitserviceId = ESFOrganizationUnitservice.esfOrganizationUnitserviceId";
	private static final String _FILTER_SQL_COUNT_ESFORGANIZATIONUNITSERVICE_WHERE =
		"SELECT COUNT(DISTINCT esfOrganizationUnitservice.esfOrganizationUnitserviceId) AS COUNT_VALUE FROM ESFOrganizationUnitservice esfOrganizationUnitservice WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "esfOrganizationUnitservice";
	private static final String _FILTER_ENTITY_TABLE = "ESFOrganizationUnitservice";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfOrganizationUnitservice.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ESFOrganizationUnitservice.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFOrganizationUnitservice exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFOrganizationUnitservice exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFOrganizationUnitservicePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFOrganizationUnitservice _nullESFOrganizationUnitservice = new ESFOrganizationUnitserviceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFOrganizationUnitservice> toCacheModel() {
				return _nullESFOrganizationUnitserviceCacheModel;
			}
		};

	private static CacheModel<ESFOrganizationUnitservice> _nullESFOrganizationUnitserviceCacheModel =
		new CacheModel<ESFOrganizationUnitservice>() {
			@Override
			public ESFOrganizationUnitservice toEntityModel() {
				return _nullESFOrganizationUnitservice;
			}
		};
}