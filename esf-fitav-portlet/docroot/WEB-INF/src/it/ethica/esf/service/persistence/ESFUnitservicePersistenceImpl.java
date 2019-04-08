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

import it.ethica.esf.NoSuchUnitserviceException;
import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.model.impl.ESFUnitserviceImpl;
import it.ethica.esf.model.impl.ESFUnitserviceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f unitservice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUnitservicePersistence
 * @see ESFUnitserviceUtil
 * @generated
 */
public class ESFUnitservicePersistenceImpl extends BasePersistenceImpl<ESFUnitservice>
	implements ESFUnitservicePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFUnitserviceUtil} to access the e s f unitservice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFUnitserviceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFUnitserviceModelImpl.UUID_COLUMN_BITMASK |
			ESFUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f unitservices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f unitservices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @return the range of matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f unitservices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByUuid(String uuid, int start, int end,
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

		List<ESFUnitservice> list = (List<ESFUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUnitservice esfUnitservice : list) {
				if (!Validator.equals(uuid, esfUnitservice.getUuid())) {
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

			query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

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
				query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUnitservice>(list);
				}
				else {
					list = (List<ESFUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfUnitservice != null) {
			return esfUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUnitservice> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByUuid_Last(uuid, orderByComparator);

		if (esfUnitservice != null) {
			return esfUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFUnitservice> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f unitservices before and after the current e s f unitservice in the ordered set where uuid = &#63;.
	 *
	 * @param esfUnitserviceId the primary key of the current e s f unitservice
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice[] findByUuid_PrevAndNext(long esfUnitserviceId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = findByPrimaryKey(esfUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFUnitservice[] array = new ESFUnitserviceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfUnitservice, uuid,
					orderByComparator, true);

			array[1] = esfUnitservice;

			array[2] = getByUuid_PrevAndNext(session, esfUnitservice, uuid,
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

	protected ESFUnitservice getByUuid_PrevAndNext(Session session,
		ESFUnitservice esfUnitservice, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

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
			query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f unitservices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFUnitservice esfUnitservice : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUnitservice);
		}
	}

	/**
	 * Returns the number of e s f unitservices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f unitservices
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

			query.append(_SQL_COUNT_ESFUNITSERVICE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfUnitservice.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfUnitservice.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfUnitservice.uuid IS NULL OR esfUnitservice.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFUnitserviceModelImpl.UUID_COLUMN_BITMASK |
			ESFUnitserviceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f unitservice where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchUnitserviceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByUUID_G(String uuid, long groupId)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByUUID_G(uuid, groupId);

		if (esfUnitservice == null) {
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

			throw new NoSuchUnitserviceException(msg.toString());
		}

		return esfUnitservice;
	}

	/**
	 * Returns the e s f unitservice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f unitservice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFUnitservice) {
			ESFUnitservice esfUnitservice = (ESFUnitservice)result;

			if (!Validator.equals(uuid, esfUnitservice.getUuid()) ||
					(groupId != esfUnitservice.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

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

				List<ESFUnitservice> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFUnitservice esfUnitservice = list.get(0);

					result = esfUnitservice;

					cacheResult(esfUnitservice);

					if ((esfUnitservice.getUuid() == null) ||
							!esfUnitservice.getUuid().equals(uuid) ||
							(esfUnitservice.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfUnitservice);
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
			return (ESFUnitservice)result;
		}
	}

	/**
	 * Removes the e s f unitservice where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f unitservice that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice removeByUUID_G(String uuid, long groupId)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = findByUUID_G(uuid, groupId);

		return remove(esfUnitservice);
	}

	/**
	 * Returns the number of e s f unitservices where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f unitservices
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

			query.append(_SQL_COUNT_ESFUNITSERVICE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfUnitservice.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfUnitservice.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfUnitservice.uuid IS NULL OR esfUnitservice.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfUnitservice.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFUnitserviceModelImpl.UUID_COLUMN_BITMASK |
			ESFUnitserviceModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f unitservices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f unitservices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @return the range of matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f unitservices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByUuid_C(String uuid, long companyId,
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

		List<ESFUnitservice> list = (List<ESFUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUnitservice esfUnitservice : list) {
				if (!Validator.equals(uuid, esfUnitservice.getUuid()) ||
						(companyId != esfUnitservice.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

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
				query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUnitservice>(list);
				}
				else {
					list = (List<ESFUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfUnitservice != null) {
			return esfUnitservice;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUnitservice> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfUnitservice != null) {
			return esfUnitservice;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFUnitservice> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f unitservices before and after the current e s f unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfUnitserviceId the primary key of the current e s f unitservice
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice[] findByUuid_C_PrevAndNext(long esfUnitserviceId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = findByPrimaryKey(esfUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFUnitservice[] array = new ESFUnitserviceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfUnitservice, uuid,
					companyId, orderByComparator, true);

			array[1] = esfUnitservice;

			array[2] = getByUuid_C_PrevAndNext(session, esfUnitservice, uuid,
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

	protected ESFUnitservice getByUuid_C_PrevAndNext(Session session,
		ESFUnitservice esfUnitservice, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

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
			query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f unitservices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFUnitservice esfUnitservice : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUnitservice);
		}
	}

	/**
	 * Returns the number of e s f unitservices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f unitservices
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

			query.append(_SQL_COUNT_ESFUNITSERVICE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfUnitservice.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfUnitservice.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfUnitservice.uuid IS NULL OR esfUnitservice.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfUnitservice.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFUnitserviceModelImpl.GROUPID_COLUMN_BITMASK |
			ESFUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f unitservices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f unitservices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @return the range of matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f unitservices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByGroupId(long groupId, int start, int end,
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

		List<ESFUnitservice> list = (List<ESFUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUnitservice esfUnitservice : list) {
				if ((groupId != esfUnitservice.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUnitservice>(list);
				}
				else {
					list = (List<ESFUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByGroupId_First(groupId,
				orderByComparator);

		if (esfUnitservice != null) {
			return esfUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUnitservice> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (esfUnitservice != null) {
			return esfUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFUnitservice> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f unitservices before and after the current e s f unitservice in the ordered set where groupId = &#63;.
	 *
	 * @param esfUnitserviceId the primary key of the current e s f unitservice
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice[] findByGroupId_PrevAndNext(long esfUnitserviceId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = findByPrimaryKey(esfUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFUnitservice[] array = new ESFUnitserviceImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfUnitservice,
					groupId, orderByComparator, true);

			array[1] = esfUnitservice;

			array[2] = getByGroupId_PrevAndNext(session, esfUnitservice,
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

	protected ESFUnitservice getByGroupId_PrevAndNext(Session session,
		ESFUnitservice esfUnitservice, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

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
			query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e s f unitservices that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f unitservices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f unitservices that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @return the range of matching e s f unitservices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f unitservices that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f unitservices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> filterFindByGroupId(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_ESFUNITSERVICE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFUNITSERVICE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFUNITSERVICE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFUnitserviceModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFUnitservice.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ESFUnitserviceImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ESFUnitserviceImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ESFUnitservice>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the e s f unitservices before and after the current e s f unitservice in the ordered set of e s f unitservices that the user has permission to view where groupId = &#63;.
	 *
	 * @param esfUnitserviceId the primary key of the current e s f unitservice
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice[] filterFindByGroupId_PrevAndNext(
		long esfUnitserviceId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(esfUnitserviceId, groupId,
				orderByComparator);
		}

		ESFUnitservice esfUnitservice = findByPrimaryKey(esfUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFUnitservice[] array = new ESFUnitserviceImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, esfUnitservice,
					groupId, orderByComparator, true);

			array[1] = esfUnitservice;

			array[2] = filterGetByGroupId_PrevAndNext(session, esfUnitservice,
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

	protected ESFUnitservice filterGetByGroupId_PrevAndNext(Session session,
		ESFUnitservice esfUnitservice, long groupId,
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
			query.append(_FILTER_SQL_SELECT_ESFUNITSERVICE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ESFUNITSERVICE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ESFUNITSERVICE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ESFUnitserviceModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFUnitservice.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ESFUnitserviceImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ESFUnitserviceImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f unitservices where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFUnitservice esfUnitservice : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUnitservice);
		}
	}

	/**
	 * Returns the number of e s f unitservices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f unitservices
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

			query.append(_SQL_COUNT_ESFUNITSERVICE_WHERE);

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
	 * Returns the number of e s f unitservices that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f unitservices that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ESFUNITSERVICE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ESFUnitservice.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfUnitservice.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDescription",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED,
			ESFUnitserviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDescription",
			new String[] { String.class.getName() },
			ESFUnitserviceModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescription",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f unitservices where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByDescription(String description)
		throws SystemException {
		return findByDescription(description, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f unitservices where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @return the range of matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByDescription(String description,
		int start, int end) throws SystemException {
		return findByDescription(description, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f unitservices where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findByDescription(String description,
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

		List<ESFUnitservice> list = (List<ESFUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUnitservice esfUnitservice : list) {
				if (!Validator.equals(description,
							esfUnitservice.getDescription())) {
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

			query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

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
				query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUnitservice>(list);
				}
				else {
					list = (List<ESFUnitservice>)QueryUtil.list(q,
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
	 * Returns the first e s f unitservice in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByDescription_First(String description,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByDescription_First(description,
				orderByComparator);

		if (esfUnitservice != null) {
			return esfUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitserviceException(msg.toString());
	}

	/**
	 * Returns the first e s f unitservice in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByDescription_First(String description,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUnitservice> list = findByDescription(description, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f unitservice in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByDescription_Last(String description,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByDescription_Last(description,
				orderByComparator);

		if (esfUnitservice != null) {
			return esfUnitservice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitserviceException(msg.toString());
	}

	/**
	 * Returns the last e s f unitservice in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f unitservice, or <code>null</code> if a matching e s f unitservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByDescription_Last(String description,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDescription(description);

		if (count == 0) {
			return null;
		}

		List<ESFUnitservice> list = findByDescription(description, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f unitservices before and after the current e s f unitservice in the ordered set where description = &#63;.
	 *
	 * @param esfUnitserviceId the primary key of the current e s f unitservice
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice[] findByDescription_PrevAndNext(
		long esfUnitserviceId, String description,
		OrderByComparator orderByComparator)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = findByPrimaryKey(esfUnitserviceId);

		Session session = null;

		try {
			session = openSession();

			ESFUnitservice[] array = new ESFUnitserviceImpl[3];

			array[0] = getByDescription_PrevAndNext(session, esfUnitservice,
					description, orderByComparator, true);

			array[1] = esfUnitservice;

			array[2] = getByDescription_PrevAndNext(session, esfUnitservice,
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

	protected ESFUnitservice getByDescription_PrevAndNext(Session session,
		ESFUnitservice esfUnitservice, String description,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUNITSERVICE_WHERE);

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
			query.append(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfUnitservice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUnitservice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f unitservices where description = &#63; from the database.
	 *
	 * @param description the description
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDescription(String description)
		throws SystemException {
		for (ESFUnitservice esfUnitservice : findByDescription(description,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUnitservice);
		}
	}

	/**
	 * Returns the number of e s f unitservices where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching e s f unitservices
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

			query.append(_SQL_COUNT_ESFUNITSERVICE_WHERE);

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

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1 = "esfUnitservice.description IS NULL";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 = "esfUnitservice.description = ?";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3 = "(esfUnitservice.description IS NULL OR esfUnitservice.description = '')";

	public ESFUnitservicePersistenceImpl() {
		setModelClass(ESFUnitservice.class);
	}

	/**
	 * Caches the e s f unitservice in the entity cache if it is enabled.
	 *
	 * @param esfUnitservice the e s f unitservice
	 */
	@Override
	public void cacheResult(ESFUnitservice esfUnitservice) {
		EntityCacheUtil.putResult(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceImpl.class, esfUnitservice.getPrimaryKey(),
			esfUnitservice);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfUnitservice.getUuid(), esfUnitservice.getGroupId() },
			esfUnitservice);

		esfUnitservice.resetOriginalValues();
	}

	/**
	 * Caches the e s f unitservices in the entity cache if it is enabled.
	 *
	 * @param esfUnitservices the e s f unitservices
	 */
	@Override
	public void cacheResult(List<ESFUnitservice> esfUnitservices) {
		for (ESFUnitservice esfUnitservice : esfUnitservices) {
			if (EntityCacheUtil.getResult(
						ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
						ESFUnitserviceImpl.class, esfUnitservice.getPrimaryKey()) == null) {
				cacheResult(esfUnitservice);
			}
			else {
				esfUnitservice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f unitservices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFUnitserviceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFUnitserviceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f unitservice.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFUnitservice esfUnitservice) {
		EntityCacheUtil.removeResult(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceImpl.class, esfUnitservice.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfUnitservice);
	}

	@Override
	public void clearCache(List<ESFUnitservice> esfUnitservices) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFUnitservice esfUnitservice : esfUnitservices) {
			EntityCacheUtil.removeResult(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
				ESFUnitserviceImpl.class, esfUnitservice.getPrimaryKey());

			clearUniqueFindersCache(esfUnitservice);
		}
	}

	protected void cacheUniqueFindersCache(ESFUnitservice esfUnitservice) {
		if (esfUnitservice.isNew()) {
			Object[] args = new Object[] {
					esfUnitservice.getUuid(), esfUnitservice.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfUnitservice);
		}
		else {
			ESFUnitserviceModelImpl esfUnitserviceModelImpl = (ESFUnitserviceModelImpl)esfUnitservice;

			if ((esfUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUnitservice.getUuid(), esfUnitservice.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfUnitservice);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFUnitservice esfUnitservice) {
		ESFUnitserviceModelImpl esfUnitserviceModelImpl = (ESFUnitserviceModelImpl)esfUnitservice;

		Object[] args = new Object[] {
				esfUnitservice.getUuid(), esfUnitservice.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfUnitserviceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfUnitserviceModelImpl.getOriginalUuid(),
					esfUnitserviceModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f unitservice with the primary key. Does not add the e s f unitservice to the database.
	 *
	 * @param esfUnitserviceId the primary key for the new e s f unitservice
	 * @return the new e s f unitservice
	 */
	@Override
	public ESFUnitservice create(long esfUnitserviceId) {
		ESFUnitservice esfUnitservice = new ESFUnitserviceImpl();

		esfUnitservice.setNew(true);
		esfUnitservice.setPrimaryKey(esfUnitserviceId);

		String uuid = PortalUUIDUtil.generate();

		esfUnitservice.setUuid(uuid);

		return esfUnitservice;
	}

	/**
	 * Removes the e s f unitservice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUnitserviceId the primary key of the e s f unitservice
	 * @return the e s f unitservice that was removed
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice remove(long esfUnitserviceId)
		throws NoSuchUnitserviceException, SystemException {
		return remove((Serializable)esfUnitserviceId);
	}

	/**
	 * Removes the e s f unitservice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f unitservice
	 * @return the e s f unitservice that was removed
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice remove(Serializable primaryKey)
		throws NoSuchUnitserviceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFUnitservice esfUnitservice = (ESFUnitservice)session.get(ESFUnitserviceImpl.class,
					primaryKey);

			if (esfUnitservice == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUnitserviceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfUnitservice);
		}
		catch (NoSuchUnitserviceException nsee) {
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
	protected ESFUnitservice removeImpl(ESFUnitservice esfUnitservice)
		throws SystemException {
		esfUnitservice = toUnwrappedModel(esfUnitservice);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfUnitservice)) {
				esfUnitservice = (ESFUnitservice)session.get(ESFUnitserviceImpl.class,
						esfUnitservice.getPrimaryKeyObj());
			}

			if (esfUnitservice != null) {
				session.delete(esfUnitservice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfUnitservice != null) {
			clearCache(esfUnitservice);
		}

		return esfUnitservice;
	}

	@Override
	public ESFUnitservice updateImpl(
		it.ethica.esf.model.ESFUnitservice esfUnitservice)
		throws SystemException {
		esfUnitservice = toUnwrappedModel(esfUnitservice);

		boolean isNew = esfUnitservice.isNew();

		ESFUnitserviceModelImpl esfUnitserviceModelImpl = (ESFUnitserviceModelImpl)esfUnitservice;

		if (Validator.isNull(esfUnitservice.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfUnitservice.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfUnitservice.isNew()) {
				session.save(esfUnitservice);

				esfUnitservice.setNew(false);
			}
			else {
				session.merge(esfUnitservice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFUnitserviceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUnitserviceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfUnitserviceModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUnitserviceModelImpl.getOriginalUuid(),
						esfUnitserviceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfUnitserviceModelImpl.getUuid(),
						esfUnitserviceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUnitserviceModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfUnitserviceModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfUnitserviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUnitserviceModelImpl.getOriginalDescription()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);

				args = new Object[] { esfUnitserviceModelImpl.getDescription() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
			ESFUnitserviceImpl.class, esfUnitservice.getPrimaryKey(),
			esfUnitservice);

		clearUniqueFindersCache(esfUnitservice);
		cacheUniqueFindersCache(esfUnitservice);

		return esfUnitservice;
	}

	protected ESFUnitservice toUnwrappedModel(ESFUnitservice esfUnitservice) {
		if (esfUnitservice instanceof ESFUnitserviceImpl) {
			return esfUnitservice;
		}

		ESFUnitserviceImpl esfUnitserviceImpl = new ESFUnitserviceImpl();

		esfUnitserviceImpl.setNew(esfUnitservice.isNew());
		esfUnitserviceImpl.setPrimaryKey(esfUnitservice.getPrimaryKey());

		esfUnitserviceImpl.setUuid(esfUnitservice.getUuid());
		esfUnitserviceImpl.setEsfUnitserviceId(esfUnitservice.getEsfUnitserviceId());
		esfUnitserviceImpl.setDescription(esfUnitservice.getDescription());
		esfUnitserviceImpl.setGroupId(esfUnitservice.getGroupId());
		esfUnitserviceImpl.setCompanyId(esfUnitservice.getCompanyId());
		esfUnitserviceImpl.setUserId(esfUnitservice.getUserId());
		esfUnitserviceImpl.setUserName(esfUnitservice.getUserName());
		esfUnitserviceImpl.setCreateDate(esfUnitservice.getCreateDate());
		esfUnitserviceImpl.setModifiedDate(esfUnitservice.getModifiedDate());

		return esfUnitserviceImpl;
	}

	/**
	 * Returns the e s f unitservice with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f unitservice
	 * @return the e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUnitserviceException, SystemException {
		ESFUnitservice esfUnitservice = fetchByPrimaryKey(primaryKey);

		if (esfUnitservice == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUnitserviceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfUnitservice;
	}

	/**
	 * Returns the e s f unitservice with the primary key or throws a {@link it.ethica.esf.NoSuchUnitserviceException} if it could not be found.
	 *
	 * @param esfUnitserviceId the primary key of the e s f unitservice
	 * @return the e s f unitservice
	 * @throws it.ethica.esf.NoSuchUnitserviceException if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice findByPrimaryKey(long esfUnitserviceId)
		throws NoSuchUnitserviceException, SystemException {
		return findByPrimaryKey((Serializable)esfUnitserviceId);
	}

	/**
	 * Returns the e s f unitservice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f unitservice
	 * @return the e s f unitservice, or <code>null</code> if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFUnitservice esfUnitservice = (ESFUnitservice)EntityCacheUtil.getResult(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
				ESFUnitserviceImpl.class, primaryKey);

		if (esfUnitservice == _nullESFUnitservice) {
			return null;
		}

		if (esfUnitservice == null) {
			Session session = null;

			try {
				session = openSession();

				esfUnitservice = (ESFUnitservice)session.get(ESFUnitserviceImpl.class,
						primaryKey);

				if (esfUnitservice != null) {
					cacheResult(esfUnitservice);
				}
				else {
					EntityCacheUtil.putResult(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
						ESFUnitserviceImpl.class, primaryKey,
						_nullESFUnitservice);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFUnitserviceModelImpl.ENTITY_CACHE_ENABLED,
					ESFUnitserviceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfUnitservice;
	}

	/**
	 * Returns the e s f unitservice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfUnitserviceId the primary key of the e s f unitservice
	 * @return the e s f unitservice, or <code>null</code> if a e s f unitservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUnitservice fetchByPrimaryKey(long esfUnitserviceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfUnitserviceId);
	}

	/**
	 * Returns all the e s f unitservices.
	 *
	 * @return the e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f unitservices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @return the range of e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f unitservices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f unitservices
	 * @param end the upper bound of the range of e s f unitservices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f unitservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUnitservice> findAll(int start, int end,
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

		List<ESFUnitservice> list = (List<ESFUnitservice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFUNITSERVICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFUNITSERVICE;

				if (pagination) {
					sql = sql.concat(ESFUnitserviceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFUnitservice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUnitservice>(list);
				}
				else {
					list = (List<ESFUnitservice>)QueryUtil.list(q,
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
	 * Removes all the e s f unitservices from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFUnitservice esfUnitservice : findAll()) {
			remove(esfUnitservice);
		}
	}

	/**
	 * Returns the number of e s f unitservices.
	 *
	 * @return the number of e s f unitservices
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

				Query q = session.createQuery(_SQL_COUNT_ESFUNITSERVICE);

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
	 * Initializes the e s f unitservice persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFUnitservice")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFUnitservice>> listenersList = new ArrayList<ModelListener<ESFUnitservice>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFUnitservice>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFUnitserviceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFUNITSERVICE = "SELECT esfUnitservice FROM ESFUnitservice esfUnitservice";
	private static final String _SQL_SELECT_ESFUNITSERVICE_WHERE = "SELECT esfUnitservice FROM ESFUnitservice esfUnitservice WHERE ";
	private static final String _SQL_COUNT_ESFUNITSERVICE = "SELECT COUNT(esfUnitservice) FROM ESFUnitservice esfUnitservice";
	private static final String _SQL_COUNT_ESFUNITSERVICE_WHERE = "SELECT COUNT(esfUnitservice) FROM ESFUnitservice esfUnitservice WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "esfUnitservice.esfUnitserviceId";
	private static final String _FILTER_SQL_SELECT_ESFUNITSERVICE_WHERE = "SELECT DISTINCT {esfUnitservice.*} FROM ESFUnitservice esfUnitservice WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFUNITSERVICE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ESFUnitservice.*} FROM (SELECT DISTINCT esfUnitservice.esfUnitserviceId FROM ESFUnitservice esfUnitservice WHERE ";
	private static final String _FILTER_SQL_SELECT_ESFUNITSERVICE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ESFUnitservice ON TEMP_TABLE.esfUnitserviceId = ESFUnitservice.esfUnitserviceId";
	private static final String _FILTER_SQL_COUNT_ESFUNITSERVICE_WHERE = "SELECT COUNT(DISTINCT esfUnitservice.esfUnitserviceId) AS COUNT_VALUE FROM ESFUnitservice esfUnitservice WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "esfUnitservice";
	private static final String _FILTER_ENTITY_TABLE = "ESFUnitservice";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfUnitservice.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ESFUnitservice.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFUnitservice exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFUnitservice exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFUnitservicePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFUnitservice _nullESFUnitservice = new ESFUnitserviceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFUnitservice> toCacheModel() {
				return _nullESFUnitserviceCacheModel;
			}
		};

	private static CacheModel<ESFUnitservice> _nullESFUnitserviceCacheModel = new CacheModel<ESFUnitservice>() {
			@Override
			public ESFUnitservice toEntityModel() {
				return _nullESFUnitservice;
			}
		};
}