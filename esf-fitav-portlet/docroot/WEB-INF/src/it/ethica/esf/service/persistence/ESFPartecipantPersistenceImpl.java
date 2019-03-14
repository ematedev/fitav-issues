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

import it.ethica.esf.NoSuchPartecipantException;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.impl.ESFPartecipantImpl;
import it.ethica.esf.model.impl.ESFPartecipantModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f partecipant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantPersistence
 * @see ESFPartecipantUtil
 * @generated
 */
public class ESFPartecipantPersistenceImpl extends BasePersistenceImpl<ESFPartecipant>
	implements ESFPartecipantPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFPartecipantUtil} to access the e s f partecipant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFPartecipantImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFPartecipantModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f partecipants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f partecipants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @return the range of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByUuid(String uuid, int start, int end,
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

		List<ESFPartecipant> list = (List<ESFPartecipant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFPartecipant esfPartecipant : list) {
				if (!Validator.equals(uuid, esfPartecipant.getUuid())) {
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

			query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

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
				query.append(ESFPartecipantModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFPartecipant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipant>(list);
				}
				else {
					list = (List<ESFPartecipant>)QueryUtil.list(q,
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
	 * Returns the first e s f partecipant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfPartecipant != null) {
			return esfPartecipant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantException(msg.toString());
	}

	/**
	 * Returns the first e s f partecipant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFPartecipant> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f partecipant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByUuid_Last(uuid, orderByComparator);

		if (esfPartecipant != null) {
			return esfPartecipant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantException(msg.toString());
	}

	/**
	 * Returns the last e s f partecipant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFPartecipant> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where uuid = &#63;.
	 *
	 * @param esfPartecipantId the primary key of the current e s f partecipant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant[] findByUuid_PrevAndNext(long esfPartecipantId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = findByPrimaryKey(esfPartecipantId);

		Session session = null;

		try {
			session = openSession();

			ESFPartecipant[] array = new ESFPartecipantImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfPartecipant, uuid,
					orderByComparator, true);

			array[1] = esfPartecipant;

			array[2] = getByUuid_PrevAndNext(session, esfPartecipant, uuid,
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

	protected ESFPartecipant getByUuid_PrevAndNext(Session session,
		ESFPartecipant esfPartecipant, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

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
			query.append(ESFPartecipantModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfPartecipant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFPartecipant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f partecipants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFPartecipant esfPartecipant : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfPartecipant);
		}
	}

	/**
	 * Returns the number of e s f partecipants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f partecipants
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

			query.append(_SQL_COUNT_ESFPARTECIPANT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfPartecipant.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfPartecipant.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfPartecipant.uuid IS NULL OR esfPartecipant.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFPartecipantModelImpl.UUID_COLUMN_BITMASK |
			ESFPartecipantModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByUUID_G(String uuid, long groupId)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByUUID_G(uuid, groupId);

		if (esfPartecipant == null) {
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

			throw new NoSuchPartecipantException(msg.toString());
		}

		return esfPartecipant;
	}

	/**
	 * Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFPartecipant) {
			ESFPartecipant esfPartecipant = (ESFPartecipant)result;

			if (!Validator.equals(uuid, esfPartecipant.getUuid()) ||
					(groupId != esfPartecipant.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

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

				List<ESFPartecipant> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFPartecipant esfPartecipant = list.get(0);

					result = esfPartecipant;

					cacheResult(esfPartecipant);

					if ((esfPartecipant.getUuid() == null) ||
							!esfPartecipant.getUuid().equals(uuid) ||
							(esfPartecipant.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfPartecipant);
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
			return (ESFPartecipant)result;
		}
	}

	/**
	 * Removes the e s f partecipant where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f partecipant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant removeByUUID_G(String uuid, long groupId)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = findByUUID_G(uuid, groupId);

		return remove(esfPartecipant);
	}

	/**
	 * Returns the number of e s f partecipants where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f partecipants
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

			query.append(_SQL_COUNT_ESFPARTECIPANT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfPartecipant.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfPartecipant.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfPartecipant.uuid IS NULL OR esfPartecipant.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfPartecipant.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFPartecipantModelImpl.UUID_COLUMN_BITMASK |
			ESFPartecipantModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @return the range of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByUuid_C(String uuid, long companyId,
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

		List<ESFPartecipant> list = (List<ESFPartecipant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFPartecipant esfPartecipant : list) {
				if (!Validator.equals(uuid, esfPartecipant.getUuid()) ||
						(companyId != esfPartecipant.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

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
				query.append(ESFPartecipantModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFPartecipant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipant>(list);
				}
				else {
					list = (List<ESFPartecipant>)QueryUtil.list(q,
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
	 * Returns the first e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfPartecipant != null) {
			return esfPartecipant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantException(msg.toString());
	}

	/**
	 * Returns the first e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFPartecipant> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfPartecipant != null) {
			return esfPartecipant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantException(msg.toString());
	}

	/**
	 * Returns the last e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFPartecipant> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfPartecipantId the primary key of the current e s f partecipant
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant[] findByUuid_C_PrevAndNext(long esfPartecipantId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = findByPrimaryKey(esfPartecipantId);

		Session session = null;

		try {
			session = openSession();

			ESFPartecipant[] array = new ESFPartecipantImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfPartecipant, uuid,
					companyId, orderByComparator, true);

			array[1] = esfPartecipant;

			array[2] = getByUuid_C_PrevAndNext(session, esfPartecipant, uuid,
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

	protected ESFPartecipant getByUuid_C_PrevAndNext(Session session,
		ESFPartecipant esfPartecipant, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

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
			query.append(ESFPartecipantModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfPartecipant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFPartecipant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f partecipants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFPartecipant esfPartecipant : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfPartecipant);
		}
	}

	/**
	 * Returns the number of e s f partecipants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f partecipants
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

			query.append(_SQL_COUNT_ESFPARTECIPANT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfPartecipant.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfPartecipant.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfPartecipant.uuid IS NULL OR esfPartecipant.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfPartecipant.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MATCH = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMatch",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCH = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMatch",
			new String[] { Long.class.getName() },
			ESFPartecipantModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATCH = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMatch",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f partecipants where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByMatch(long esfMatchId)
		throws SystemException {
		return findByMatch(esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f partecipants where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @return the range of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByMatch(long esfMatchId, int start, int end)
		throws SystemException {
		return findByMatch(esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipants where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByMatch(long esfMatchId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCH;
			finderArgs = new Object[] { esfMatchId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MATCH;
			finderArgs = new Object[] { esfMatchId, start, end, orderByComparator };
		}

		List<ESFPartecipant> list = (List<ESFPartecipant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFPartecipant esfPartecipant : list) {
				if ((esfMatchId != esfPartecipant.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

			query.append(_FINDER_COLUMN_MATCH_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFPartecipantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFPartecipant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipant>(list);
				}
				else {
					list = (List<ESFPartecipant>)QueryUtil.list(q,
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
	 * Returns the first e s f partecipant in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByMatch_First(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByMatch_First(esfMatchId,
				orderByComparator);

		if (esfPartecipant != null) {
			return esfPartecipant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantException(msg.toString());
	}

	/**
	 * Returns the first e s f partecipant in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByMatch_First(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFPartecipant> list = findByMatch(esfMatchId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f partecipant in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByMatch_Last(esfMatchId,
				orderByComparator);

		if (esfPartecipant != null) {
			return esfPartecipant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantException(msg.toString());
	}

	/**
	 * Returns the last e s f partecipant in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMatch(esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFPartecipant> list = findByMatch(esfMatchId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfPartecipantId the primary key of the current e s f partecipant
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant[] findByMatch_PrevAndNext(long esfPartecipantId,
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = findByPrimaryKey(esfPartecipantId);

		Session session = null;

		try {
			session = openSession();

			ESFPartecipant[] array = new ESFPartecipantImpl[3];

			array[0] = getByMatch_PrevAndNext(session, esfPartecipant,
					esfMatchId, orderByComparator, true);

			array[1] = esfPartecipant;

			array[2] = getByMatch_PrevAndNext(session, esfPartecipant,
					esfMatchId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFPartecipant getByMatch_PrevAndNext(Session session,
		ESFPartecipant esfPartecipant, long esfMatchId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

		query.append(_FINDER_COLUMN_MATCH_ESFMATCHID_2);

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
			query.append(ESFPartecipantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfPartecipant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFPartecipant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f partecipants where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMatch(long esfMatchId) throws SystemException {
		for (ESFPartecipant esfPartecipant : findByMatch(esfMatchId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfPartecipant);
		}
	}

	/**
	 * Returns the number of e s f partecipants where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMatch(long esfMatchId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATCH;

		Object[] finderArgs = new Object[] { esfMatchId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFPARTECIPANT_WHERE);

			query.append(_FINDER_COLUMN_MATCH_ESFMATCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

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

	private static final String _FINDER_COLUMN_MATCH_ESFMATCHID_2 = "esfPartecipant.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_M_T = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByM_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByM_T",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFPartecipantModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFPartecipantModelImpl.ESFPARTECIPANTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_M_T = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByM_T",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByM_T(long esfMatchId,
		long esfPartecipantTypeId) throws SystemException {
		return findByM_T(esfMatchId, esfPartecipantTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @return the range of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByM_T(long esfMatchId,
		long esfPartecipantTypeId, int start, int end)
		throws SystemException {
		return findByM_T(esfMatchId, esfPartecipantTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findByM_T(long esfMatchId,
		long esfPartecipantTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T;
			finderArgs = new Object[] { esfMatchId, esfPartecipantTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_M_T;
			finderArgs = new Object[] {
					esfMatchId, esfPartecipantTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFPartecipant> list = (List<ESFPartecipant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFPartecipant esfPartecipant : list) {
				if ((esfMatchId != esfPartecipant.getEsfMatchId()) ||
						(esfPartecipantTypeId != esfPartecipant.getEsfPartecipantTypeId())) {
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

			query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

			query.append(_FINDER_COLUMN_M_T_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_M_T_ESFPARTECIPANTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFPartecipantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfPartecipantTypeId);

				if (!pagination) {
					list = (List<ESFPartecipant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipant>(list);
				}
				else {
					list = (List<ESFPartecipant>)QueryUtil.list(q,
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
	 * Returns the first e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByM_T_First(long esfMatchId,
		long esfPartecipantTypeId, OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByM_T_First(esfMatchId,
				esfPartecipantTypeId, orderByComparator);

		if (esfPartecipant != null) {
			return esfPartecipant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfPartecipantTypeId=");
		msg.append(esfPartecipantTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantException(msg.toString());
	}

	/**
	 * Returns the first e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByM_T_First(long esfMatchId,
		long esfPartecipantTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFPartecipant> list = findByM_T(esfMatchId, esfPartecipantTypeId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByM_T_Last(long esfMatchId,
		long esfPartecipantTypeId, OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByM_T_Last(esfMatchId,
				esfPartecipantTypeId, orderByComparator);

		if (esfPartecipant != null) {
			return esfPartecipant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfPartecipantTypeId=");
		msg.append(esfPartecipantTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantException(msg.toString());
	}

	/**
	 * Returns the last e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByM_T_Last(long esfMatchId,
		long esfPartecipantTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByM_T(esfMatchId, esfPartecipantTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFPartecipant> list = findByM_T(esfMatchId, esfPartecipantTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfPartecipantId the primary key of the current e s f partecipant
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant[] findByM_T_PrevAndNext(long esfPartecipantId,
		long esfMatchId, long esfPartecipantTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = findByPrimaryKey(esfPartecipantId);

		Session session = null;

		try {
			session = openSession();

			ESFPartecipant[] array = new ESFPartecipantImpl[3];

			array[0] = getByM_T_PrevAndNext(session, esfPartecipant,
					esfMatchId, esfPartecipantTypeId, orderByComparator, true);

			array[1] = esfPartecipant;

			array[2] = getByM_T_PrevAndNext(session, esfPartecipant,
					esfMatchId, esfPartecipantTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFPartecipant getByM_T_PrevAndNext(Session session,
		ESFPartecipant esfPartecipant, long esfMatchId,
		long esfPartecipantTypeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

		query.append(_FINDER_COLUMN_M_T_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_M_T_ESFPARTECIPANTTYPEID_2);

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
			query.append(ESFPartecipantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfPartecipantTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfPartecipant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFPartecipant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByM_T(long esfMatchId, long esfPartecipantTypeId)
		throws SystemException {
		for (ESFPartecipant esfPartecipant : findByM_T(esfMatchId,
				esfPartecipantTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfPartecipant);
		}
	}

	/**
	 * Returns the number of e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the number of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByM_T(long esfMatchId, long esfPartecipantTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_M_T;

		Object[] finderArgs = new Object[] { esfMatchId, esfPartecipantTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFPARTECIPANT_WHERE);

			query.append(_FINDER_COLUMN_M_T_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_M_T_ESFPARTECIPANTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfPartecipantTypeId);

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

	private static final String _FINDER_COLUMN_M_T_ESFMATCHID_2 = "esfPartecipant.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_M_T_ESFPARTECIPANTTYPEID_2 = "esfPartecipant.esfPartecipantTypeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_U_M_T = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByU_M_T",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFPartecipantModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFPartecipantModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFPartecipantModelImpl.ESFPARTECIPANTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_M_T = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_M_T",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByU_M_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByU_M_T(esfUserId, esfMatchId,
				esfPartecipantTypeId);

		if (esfPartecipant == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfUserId=");
			msg.append(esfUserId);

			msg.append(", esfMatchId=");
			msg.append(esfMatchId);

			msg.append(", esfPartecipantTypeId=");
			msg.append(esfPartecipantTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPartecipantException(msg.toString());
		}

		return esfPartecipant;
	}

	/**
	 * Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByU_M_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId) throws SystemException {
		return fetchByU_M_T(esfUserId, esfMatchId, esfPartecipantTypeId, true);
	}

	/**
	 * Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByU_M_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				esfUserId, esfMatchId, esfPartecipantTypeId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_U_M_T,
					finderArgs, this);
		}

		if (result instanceof ESFPartecipant) {
			ESFPartecipant esfPartecipant = (ESFPartecipant)result;

			if ((esfUserId != esfPartecipant.getEsfUserId()) ||
					(esfMatchId != esfPartecipant.getEsfMatchId()) ||
					(esfPartecipantTypeId != esfPartecipant.getEsfPartecipantTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

			query.append(_FINDER_COLUMN_U_M_T_ESFUSERID_2);

			query.append(_FINDER_COLUMN_U_M_T_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_U_M_T_ESFPARTECIPANTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfMatchId);

				qPos.add(esfPartecipantTypeId);

				List<ESFPartecipant> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_M_T,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFPartecipantPersistenceImpl.fetchByU_M_T(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFPartecipant esfPartecipant = list.get(0);

					result = esfPartecipant;

					cacheResult(esfPartecipant);

					if ((esfPartecipant.getEsfUserId() != esfUserId) ||
							(esfPartecipant.getEsfMatchId() != esfMatchId) ||
							(esfPartecipant.getEsfPartecipantTypeId() != esfPartecipantTypeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_M_T,
							finderArgs, esfPartecipant);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_M_T,
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
			return (ESFPartecipant)result;
		}
	}

	/**
	 * Removes the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the e s f partecipant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant removeByU_M_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = findByU_M_T(esfUserId, esfMatchId,
				esfPartecipantTypeId);

		return remove(esfPartecipant);
	}

	/**
	 * Returns the number of e s f partecipants where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfMatchId the esf match ID
	 * @param esfPartecipantTypeId the esf partecipant type ID
	 * @return the number of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByU_M_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_M_T;

		Object[] finderArgs = new Object[] {
				esfUserId, esfMatchId, esfPartecipantTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFPARTECIPANT_WHERE);

			query.append(_FINDER_COLUMN_U_M_T_ESFUSERID_2);

			query.append(_FINDER_COLUMN_U_M_T_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_U_M_T_ESFPARTECIPANTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfMatchId);

				qPos.add(esfPartecipantTypeId);

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

	private static final String _FINDER_COLUMN_U_M_T_ESFUSERID_2 = "esfPartecipant.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_U_M_T_ESFMATCHID_2 = "esfPartecipant.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_U_M_T_ESFPARTECIPANTTYPEID_2 = "esfPartecipant.esfPartecipantTypeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserId", new String[] { Long.class.getName() },
			ESFPartecipantModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the e s f partecipant where userId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByUserId(long userId)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByUserId(userId);

		if (esfPartecipant == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPartecipantException(msg.toString());
		}

		return esfPartecipant;
	}

	/**
	 * Returns the e s f partecipant where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the e s f partecipant where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof ESFPartecipant) {
			ESFPartecipant esfPartecipant = (ESFPartecipant)result;

			if ((userId != esfPartecipant.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFPARTECIPANT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<ESFPartecipant> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFPartecipantPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFPartecipant esfPartecipant = list.get(0);

					result = esfPartecipant;

					cacheResult(esfPartecipant);

					if ((esfPartecipant.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, esfPartecipant);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
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
			return (ESFPartecipant)result;
		}
	}

	/**
	 * Removes the e s f partecipant where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the e s f partecipant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant removeByUserId(long userId)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = findByUserId(userId);

		return remove(esfPartecipant);
	}

	/**
	 * Returns the number of e s f partecipants where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFPARTECIPANT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "esfPartecipant.userId = ?";

	public ESFPartecipantPersistenceImpl() {
		setModelClass(ESFPartecipant.class);
	}

	/**
	 * Caches the e s f partecipant in the entity cache if it is enabled.
	 *
	 * @param esfPartecipant the e s f partecipant
	 */
	@Override
	public void cacheResult(ESFPartecipant esfPartecipant) {
		EntityCacheUtil.putResult(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantImpl.class, esfPartecipant.getPrimaryKey(),
			esfPartecipant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfPartecipant.getUuid(), esfPartecipant.getGroupId() },
			esfPartecipant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_M_T,
			new Object[] {
				esfPartecipant.getEsfUserId(), esfPartecipant.getEsfMatchId(),
				esfPartecipant.getEsfPartecipantTypeId()
			}, esfPartecipant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { esfPartecipant.getUserId() }, esfPartecipant);

		esfPartecipant.resetOriginalValues();
	}

	/**
	 * Caches the e s f partecipants in the entity cache if it is enabled.
	 *
	 * @param esfPartecipants the e s f partecipants
	 */
	@Override
	public void cacheResult(List<ESFPartecipant> esfPartecipants) {
		for (ESFPartecipant esfPartecipant : esfPartecipants) {
			if (EntityCacheUtil.getResult(
						ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
						ESFPartecipantImpl.class, esfPartecipant.getPrimaryKey()) == null) {
				cacheResult(esfPartecipant);
			}
			else {
				esfPartecipant.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f partecipants.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFPartecipantImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFPartecipantImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f partecipant.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFPartecipant esfPartecipant) {
		EntityCacheUtil.removeResult(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantImpl.class, esfPartecipant.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfPartecipant);
	}

	@Override
	public void clearCache(List<ESFPartecipant> esfPartecipants) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFPartecipant esfPartecipant : esfPartecipants) {
			EntityCacheUtil.removeResult(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
				ESFPartecipantImpl.class, esfPartecipant.getPrimaryKey());

			clearUniqueFindersCache(esfPartecipant);
		}
	}

	protected void cacheUniqueFindersCache(ESFPartecipant esfPartecipant) {
		if (esfPartecipant.isNew()) {
			Object[] args = new Object[] {
					esfPartecipant.getUuid(), esfPartecipant.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfPartecipant);

			args = new Object[] {
					esfPartecipant.getEsfUserId(),
					esfPartecipant.getEsfMatchId(),
					esfPartecipant.getEsfPartecipantTypeId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_M_T, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_M_T, args,
				esfPartecipant);

			args = new Object[] { esfPartecipant.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				esfPartecipant);
		}
		else {
			ESFPartecipantModelImpl esfPartecipantModelImpl = (ESFPartecipantModelImpl)esfPartecipant;

			if ((esfPartecipantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfPartecipant.getUuid(), esfPartecipant.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfPartecipant);
			}

			if ((esfPartecipantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_U_M_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfPartecipant.getEsfUserId(),
						esfPartecipant.getEsfMatchId(),
						esfPartecipant.getEsfPartecipantTypeId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_M_T, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_M_T, args,
					esfPartecipant);
			}

			if ((esfPartecipantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfPartecipant.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					esfPartecipant);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFPartecipant esfPartecipant) {
		ESFPartecipantModelImpl esfPartecipantModelImpl = (ESFPartecipantModelImpl)esfPartecipant;

		Object[] args = new Object[] {
				esfPartecipant.getUuid(), esfPartecipant.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfPartecipantModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfPartecipantModelImpl.getOriginalUuid(),
					esfPartecipantModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				esfPartecipant.getEsfUserId(), esfPartecipant.getEsfMatchId(),
				esfPartecipant.getEsfPartecipantTypeId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_M_T, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_M_T, args);

		if ((esfPartecipantModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_U_M_T.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfPartecipantModelImpl.getOriginalEsfUserId(),
					esfPartecipantModelImpl.getOriginalEsfMatchId(),
					esfPartecipantModelImpl.getOriginalEsfPartecipantTypeId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_M_T, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_M_T, args);
		}

		args = new Object[] { esfPartecipant.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((esfPartecipantModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { esfPartecipantModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new e s f partecipant with the primary key. Does not add the e s f partecipant to the database.
	 *
	 * @param esfPartecipantId the primary key for the new e s f partecipant
	 * @return the new e s f partecipant
	 */
	@Override
	public ESFPartecipant create(long esfPartecipantId) {
		ESFPartecipant esfPartecipant = new ESFPartecipantImpl();

		esfPartecipant.setNew(true);
		esfPartecipant.setPrimaryKey(esfPartecipantId);

		String uuid = PortalUUIDUtil.generate();

		esfPartecipant.setUuid(uuid);

		return esfPartecipant;
	}

	/**
	 * Removes the e s f partecipant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfPartecipantId the primary key of the e s f partecipant
	 * @return the e s f partecipant that was removed
	 * @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant remove(long esfPartecipantId)
		throws NoSuchPartecipantException, SystemException {
		return remove((Serializable)esfPartecipantId);
	}

	/**
	 * Removes the e s f partecipant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f partecipant
	 * @return the e s f partecipant that was removed
	 * @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant remove(Serializable primaryKey)
		throws NoSuchPartecipantException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFPartecipant esfPartecipant = (ESFPartecipant)session.get(ESFPartecipantImpl.class,
					primaryKey);

			if (esfPartecipant == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPartecipantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfPartecipant);
		}
		catch (NoSuchPartecipantException nsee) {
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
	protected ESFPartecipant removeImpl(ESFPartecipant esfPartecipant)
		throws SystemException {
		esfPartecipant = toUnwrappedModel(esfPartecipant);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfPartecipant)) {
				esfPartecipant = (ESFPartecipant)session.get(ESFPartecipantImpl.class,
						esfPartecipant.getPrimaryKeyObj());
			}

			if (esfPartecipant != null) {
				session.delete(esfPartecipant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfPartecipant != null) {
			clearCache(esfPartecipant);
		}

		return esfPartecipant;
	}

	@Override
	public ESFPartecipant updateImpl(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws SystemException {
		esfPartecipant = toUnwrappedModel(esfPartecipant);

		boolean isNew = esfPartecipant.isNew();

		ESFPartecipantModelImpl esfPartecipantModelImpl = (ESFPartecipantModelImpl)esfPartecipant;

		if (Validator.isNull(esfPartecipant.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfPartecipant.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfPartecipant.isNew()) {
				session.save(esfPartecipant);

				esfPartecipant.setNew(false);
			}
			else {
				session.merge(esfPartecipant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFPartecipantModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfPartecipantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfPartecipantModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfPartecipantModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfPartecipantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfPartecipantModelImpl.getOriginalUuid(),
						esfPartecipantModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfPartecipantModelImpl.getUuid(),
						esfPartecipantModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfPartecipantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfPartecipantModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCH,
					args);

				args = new Object[] { esfPartecipantModelImpl.getEsfMatchId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCH,
					args);
			}

			if ((esfPartecipantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfPartecipantModelImpl.getOriginalEsfMatchId(),
						esfPartecipantModelImpl.getOriginalEsfPartecipantTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_M_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T,
					args);

				args = new Object[] {
						esfPartecipantModelImpl.getEsfMatchId(),
						esfPartecipantModelImpl.getEsfPartecipantTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_M_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_T,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantImpl.class, esfPartecipant.getPrimaryKey(),
			esfPartecipant);

		clearUniqueFindersCache(esfPartecipant);
		cacheUniqueFindersCache(esfPartecipant);

		return esfPartecipant;
	}

	protected ESFPartecipant toUnwrappedModel(ESFPartecipant esfPartecipant) {
		if (esfPartecipant instanceof ESFPartecipantImpl) {
			return esfPartecipant;
		}

		ESFPartecipantImpl esfPartecipantImpl = new ESFPartecipantImpl();

		esfPartecipantImpl.setNew(esfPartecipant.isNew());
		esfPartecipantImpl.setPrimaryKey(esfPartecipant.getPrimaryKey());

		esfPartecipantImpl.setUuid(esfPartecipant.getUuid());
		esfPartecipantImpl.setEsfPartecipantId(esfPartecipant.getEsfPartecipantId());
		esfPartecipantImpl.setGroupId(esfPartecipant.getGroupId());
		esfPartecipantImpl.setCompanyId(esfPartecipant.getCompanyId());
		esfPartecipantImpl.setUserId(esfPartecipant.getUserId());
		esfPartecipantImpl.setUserName(esfPartecipant.getUserName());
		esfPartecipantImpl.setCreateDate(esfPartecipant.getCreateDate());
		esfPartecipantImpl.setModifiedDate(esfPartecipant.getModifiedDate());
		esfPartecipantImpl.setEsfUserId(esfPartecipant.getEsfUserId());
		esfPartecipantImpl.setEsfMatchId(esfPartecipant.getEsfMatchId());
		esfPartecipantImpl.setEsfTeamId(esfPartecipant.getEsfTeamId());
		esfPartecipantImpl.setCt(esfPartecipant.getCt());
		esfPartecipantImpl.setEsfPartecipantTypeId(esfPartecipant.getEsfPartecipantTypeId());
		esfPartecipantImpl.setResult(esfPartecipant.getResult());

		return esfPartecipantImpl;
	}

	/**
	 * Returns the e s f partecipant with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f partecipant
	 * @return the e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPartecipantException, SystemException {
		ESFPartecipant esfPartecipant = fetchByPrimaryKey(primaryKey);

		if (esfPartecipant == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPartecipantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfPartecipant;
	}

	/**
	 * Returns the e s f partecipant with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	 *
	 * @param esfPartecipantId the primary key of the e s f partecipant
	 * @return the e s f partecipant
	 * @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant findByPrimaryKey(long esfPartecipantId)
		throws NoSuchPartecipantException, SystemException {
		return findByPrimaryKey((Serializable)esfPartecipantId);
	}

	/**
	 * Returns the e s f partecipant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f partecipant
	 * @return the e s f partecipant, or <code>null</code> if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFPartecipant esfPartecipant = (ESFPartecipant)EntityCacheUtil.getResult(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
				ESFPartecipantImpl.class, primaryKey);

		if (esfPartecipant == _nullESFPartecipant) {
			return null;
		}

		if (esfPartecipant == null) {
			Session session = null;

			try {
				session = openSession();

				esfPartecipant = (ESFPartecipant)session.get(ESFPartecipantImpl.class,
						primaryKey);

				if (esfPartecipant != null) {
					cacheResult(esfPartecipant);
				}
				else {
					EntityCacheUtil.putResult(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
						ESFPartecipantImpl.class, primaryKey,
						_nullESFPartecipant);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFPartecipantModelImpl.ENTITY_CACHE_ENABLED,
					ESFPartecipantImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfPartecipant;
	}

	/**
	 * Returns the e s f partecipant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfPartecipantId the primary key of the e s f partecipant
	 * @return the e s f partecipant, or <code>null</code> if a e s f partecipant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipant fetchByPrimaryKey(long esfPartecipantId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfPartecipantId);
	}

	/**
	 * Returns all the e s f partecipants.
	 *
	 * @return the e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f partecipants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @return the range of e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f partecipants
	 * @param end the upper bound of the range of e s f partecipants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f partecipants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipant> findAll(int start, int end,
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

		List<ESFPartecipant> list = (List<ESFPartecipant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFPARTECIPANT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFPARTECIPANT;

				if (pagination) {
					sql = sql.concat(ESFPartecipantModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFPartecipant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipant>(list);
				}
				else {
					list = (List<ESFPartecipant>)QueryUtil.list(q,
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
	 * Removes all the e s f partecipants from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFPartecipant esfPartecipant : findAll()) {
			remove(esfPartecipant);
		}
	}

	/**
	 * Returns the number of e s f partecipants.
	 *
	 * @return the number of e s f partecipants
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

				Query q = session.createQuery(_SQL_COUNT_ESFPARTECIPANT);

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
	 * Initializes the e s f partecipant persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFPartecipant")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFPartecipant>> listenersList = new ArrayList<ModelListener<ESFPartecipant>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFPartecipant>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFPartecipantImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFPARTECIPANT = "SELECT esfPartecipant FROM ESFPartecipant esfPartecipant";
	private static final String _SQL_SELECT_ESFPARTECIPANT_WHERE = "SELECT esfPartecipant FROM ESFPartecipant esfPartecipant WHERE ";
	private static final String _SQL_COUNT_ESFPARTECIPANT = "SELECT COUNT(esfPartecipant) FROM ESFPartecipant esfPartecipant";
	private static final String _SQL_COUNT_ESFPARTECIPANT_WHERE = "SELECT COUNT(esfPartecipant) FROM ESFPartecipant esfPartecipant WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfPartecipant.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFPartecipant exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFPartecipant exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFPartecipantPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFPartecipant _nullESFPartecipant = new ESFPartecipantImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFPartecipant> toCacheModel() {
				return _nullESFPartecipantCacheModel;
			}
		};

	private static CacheModel<ESFPartecipant> _nullESFPartecipantCacheModel = new CacheModel<ESFPartecipant>() {
			@Override
			public ESFPartecipant toEntityModel() {
				return _nullESFPartecipant;
			}
		};
}