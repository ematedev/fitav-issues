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

import it.ethica.esf.NoSuchCardException;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFCardModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f card service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCardPersistence
 * @see ESFCardUtil
 * @generated
 */
public class ESFCardPersistenceImpl extends BasePersistenceImpl<ESFCard>
	implements ESFCardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFCardUtil} to access the e s f card persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFCardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFCardModelImpl.UUID_COLUMN_BITMASK |
			ESFCardModelImpl.CODENUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f cards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUuid(String uuid, int start, int end,
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

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCard esfCard : list) {
				if (!Validator.equals(uuid, esfCard.getUuid())) {
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

			query.append(_SQL_SELECT_ESFCARD_WHERE);

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
				query.append(ESFCardModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f card in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByUuid_First(uuid, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the first e s f card in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCard> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f card in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByUuid_Last(uuid, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the last e s f card in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFCard> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cards before and after the current e s f card in the ordered set where uuid = &#63;.
	 *
	 * @param esfCardId the primary key of the current e s f card
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard[] findByUuid_PrevAndNext(long esfCardId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByPrimaryKey(esfCardId);

		Session session = null;

		try {
			session = openSession();

			ESFCard[] array = new ESFCardImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfCard, uuid,
					orderByComparator, true);

			array[1] = esfCard;

			array[2] = getByUuid_PrevAndNext(session, esfCard, uuid,
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

	protected ESFCard getByUuid_PrevAndNext(Session session, ESFCard esfCard,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCARD_WHERE);

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
			query.append(ESFCardModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cards where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFCard esfCard : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f cards
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

			query.append(_SQL_COUNT_ESFCARD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfCard.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfCard.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfCard.uuid IS NULL OR esfCard.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFCardModelImpl.UUID_COLUMN_BITMASK |
			ESFCardModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f card where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchCardException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByUUID_G(String uuid, long groupId)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByUUID_G(uuid, groupId);

		if (esfCard == null) {
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

			throw new NoSuchCardException(msg.toString());
		}

		return esfCard;
	}

	/**
	 * Returns the e s f card where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f card where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFCard) {
			ESFCard esfCard = (ESFCard)result;

			if (!Validator.equals(uuid, esfCard.getUuid()) ||
					(groupId != esfCard.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFCARD_WHERE);

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

				List<ESFCard> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFCard esfCard = list.get(0);

					result = esfCard;

					cacheResult(esfCard);

					if ((esfCard.getUuid() == null) ||
							!esfCard.getUuid().equals(uuid) ||
							(esfCard.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfCard);
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
			return (ESFCard)result;
		}
	}

	/**
	 * Removes the e s f card where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f card that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard removeByUUID_G(String uuid, long groupId)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByUUID_G(uuid, groupId);

		return remove(esfCard);
	}

	/**
	 * Returns the number of e s f cards where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f cards
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

			query.append(_SQL_COUNT_ESFCARD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfCard.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfCard.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfCard.uuid IS NULL OR esfCard.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfCard.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFCardModelImpl.UUID_COLUMN_BITMASK |
			ESFCardModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFCardModelImpl.CODENUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f cards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUuid_C(String uuid, long companyId, int start,
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

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCard esfCard : list) {
				if (!Validator.equals(uuid, esfCard.getUuid()) ||
						(companyId != esfCard.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFCARD_WHERE);

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
				query.append(ESFCardModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the first e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCard> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the last e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFCard> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cards before and after the current e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfCardId the primary key of the current e s f card
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard[] findByUuid_C_PrevAndNext(long esfCardId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByPrimaryKey(esfCardId);

		Session session = null;

		try {
			session = openSession();

			ESFCard[] array = new ESFCardImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfCard, uuid,
					companyId, orderByComparator, true);

			array[1] = esfCard;

			array[2] = getByUuid_C_PrevAndNext(session, esfCard, uuid,
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

	protected ESFCard getByUuid_C_PrevAndNext(Session session, ESFCard esfCard,
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

		query.append(_SQL_SELECT_ESFCARD_WHERE);

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
			query.append(ESFCardModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cards where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFCard esfCard : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f cards
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

			query.append(_SQL_COUNT_ESFCARD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfCard.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfCard.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfCard.uuid IS NULL OR esfCard.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfCard.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODEALFA = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodeAlfa",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODEALFA =
		new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodeAlfa",
			new String[] { String.class.getName() },
			ESFCardModelImpl.CODEALFA_COLUMN_BITMASK |
			ESFCardModelImpl.CODENUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODEALFA = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeAlfa",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f cards where codeAlfa = &#63;.
	 *
	 * @param codeAlfa the code alfa
	 * @return the matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByCodeAlfa(String codeAlfa)
		throws SystemException {
		return findByCodeAlfa(codeAlfa, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f cards where codeAlfa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codeAlfa the code alfa
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByCodeAlfa(String codeAlfa, int start, int end)
		throws SystemException {
		return findByCodeAlfa(codeAlfa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards where codeAlfa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codeAlfa the code alfa
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByCodeAlfa(String codeAlfa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODEALFA;
			finderArgs = new Object[] { codeAlfa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODEALFA;
			finderArgs = new Object[] { codeAlfa, start, end, orderByComparator };
		}

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCard esfCard : list) {
				if (!Validator.equals(codeAlfa, esfCard.getCodeAlfa())) {
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

			query.append(_SQL_SELECT_ESFCARD_WHERE);

			boolean bindCodeAlfa = false;

			if (codeAlfa == null) {
				query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_1);
			}
			else if (codeAlfa.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_3);
			}
			else {
				bindCodeAlfa = true;

				query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodeAlfa) {
					qPos.add(codeAlfa);
				}

				if (!pagination) {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f card in the ordered set where codeAlfa = &#63;.
	 *
	 * @param codeAlfa the code alfa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByCodeAlfa_First(String codeAlfa,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByCodeAlfa_First(codeAlfa, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codeAlfa=");
		msg.append(codeAlfa);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the first e s f card in the ordered set where codeAlfa = &#63;.
	 *
	 * @param codeAlfa the code alfa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByCodeAlfa_First(String codeAlfa,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCard> list = findByCodeAlfa(codeAlfa, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f card in the ordered set where codeAlfa = &#63;.
	 *
	 * @param codeAlfa the code alfa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByCodeAlfa_Last(String codeAlfa,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByCodeAlfa_Last(codeAlfa, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codeAlfa=");
		msg.append(codeAlfa);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the last e s f card in the ordered set where codeAlfa = &#63;.
	 *
	 * @param codeAlfa the code alfa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByCodeAlfa_Last(String codeAlfa,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCodeAlfa(codeAlfa);

		if (count == 0) {
			return null;
		}

		List<ESFCard> list = findByCodeAlfa(codeAlfa, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cards before and after the current e s f card in the ordered set where codeAlfa = &#63;.
	 *
	 * @param esfCardId the primary key of the current e s f card
	 * @param codeAlfa the code alfa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard[] findByCodeAlfa_PrevAndNext(long esfCardId,
		String codeAlfa, OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByPrimaryKey(esfCardId);

		Session session = null;

		try {
			session = openSession();

			ESFCard[] array = new ESFCardImpl[3];

			array[0] = getByCodeAlfa_PrevAndNext(session, esfCard, codeAlfa,
					orderByComparator, true);

			array[1] = esfCard;

			array[2] = getByCodeAlfa_PrevAndNext(session, esfCard, codeAlfa,
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

	protected ESFCard getByCodeAlfa_PrevAndNext(Session session,
		ESFCard esfCard, String codeAlfa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCARD_WHERE);

		boolean bindCodeAlfa = false;

		if (codeAlfa == null) {
			query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_1);
		}
		else if (codeAlfa.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_3);
		}
		else {
			bindCodeAlfa = true;

			query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_2);
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
			query.append(ESFCardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCodeAlfa) {
			qPos.add(codeAlfa);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cards where codeAlfa = &#63; from the database.
	 *
	 * @param codeAlfa the code alfa
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCodeAlfa(String codeAlfa) throws SystemException {
		for (ESFCard esfCard : findByCodeAlfa(codeAlfa, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards where codeAlfa = &#63;.
	 *
	 * @param codeAlfa the code alfa
	 * @return the number of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCodeAlfa(String codeAlfa) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODEALFA;

		Object[] finderArgs = new Object[] { codeAlfa };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCARD_WHERE);

			boolean bindCodeAlfa = false;

			if (codeAlfa == null) {
				query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_1);
			}
			else if (codeAlfa.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_3);
			}
			else {
				bindCodeAlfa = true;

				query.append(_FINDER_COLUMN_CODEALFA_CODEALFA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodeAlfa) {
					qPos.add(codeAlfa);
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

	private static final String _FINDER_COLUMN_CODEALFA_CODEALFA_1 = "esfCard.codeAlfa IS NULL";
	private static final String _FINDER_COLUMN_CODEALFA_CODEALFA_2 = "esfCard.codeAlfa = ?";
	private static final String _FINDER_COLUMN_CODEALFA_CODEALFA_3 = "(esfCard.codeAlfa IS NULL OR esfCard.codeAlfa = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ESFCardModelImpl.CODE_COLUMN_BITMASK |
			ESFCardModelImpl.CODENUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f cards where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByCode(String code) throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cards where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByCode(String code, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code, start, end, orderByComparator };
		}

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCard esfCard : list) {
				if (!Validator.equals(code, esfCard.getCode())) {
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

			query.append(_SQL_SELECT_ESFCARD_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCardModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f card in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByCode_First(code, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the first e s f card in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCard> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f card in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByCode_Last(code, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the last e s f card in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ESFCard> list = findByCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cards before and after the current e s f card in the ordered set where code = &#63;.
	 *
	 * @param esfCardId the primary key of the current e s f card
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard[] findByCode_PrevAndNext(long esfCardId, String code,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByPrimaryKey(esfCardId);

		Session session = null;

		try {
			session = openSession();

			ESFCard[] array = new ESFCardImpl[3];

			array[0] = getByCode_PrevAndNext(session, esfCard, code,
					orderByComparator, true);

			array[1] = esfCard;

			array[2] = getByCode_PrevAndNext(session, esfCard, code,
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

	protected ESFCard getByCode_PrevAndNext(Session session, ESFCard esfCard,
		String code, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCARD_WHERE);

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
			query.append(ESFCardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCode) {
			qPos.add(code);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cards where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ESFCard esfCard : findByCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f cards
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

			query.append(_SQL_COUNT_ESFCARD_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfCard.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfCard.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfCard.code IS NULL OR esfCard.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			ESFCardModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK |
			ESFCardModelImpl.CODENUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f cards where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByOrganizationId(long esfOrganizationId)
		throws SystemException {
		return findByOrganizationId(esfOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cards where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByOrganizationId(long esfOrganizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(esfOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByOrganizationId(long esfOrganizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { esfOrganizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					esfOrganizationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCard esfCard : list) {
				if ((esfOrganizationId != esfCard.getEsfOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFCARD_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ESFORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				if (!pagination) {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f card in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByOrganizationId_First(long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByOrganizationId_First(esfOrganizationId,
				orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the first e s f card in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByOrganizationId_First(long esfOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCard> list = findByOrganizationId(esfOrganizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f card in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByOrganizationId_Last(long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByOrganizationId_Last(esfOrganizationId,
				orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the last e s f card in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByOrganizationId_Last(long esfOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(esfOrganizationId);

		if (count == 0) {
			return null;
		}

		List<ESFCard> list = findByOrganizationId(esfOrganizationId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cards before and after the current e s f card in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfCardId the primary key of the current e s f card
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard[] findByOrganizationId_PrevAndNext(long esfCardId,
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByPrimaryKey(esfCardId);

		Session session = null;

		try {
			session = openSession();

			ESFCard[] array = new ESFCardImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, esfCard,
					esfOrganizationId, orderByComparator, true);

			array[1] = esfCard;

			array[2] = getByOrganizationId_PrevAndNext(session, esfCard,
					esfOrganizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFCard getByOrganizationId_PrevAndNext(Session session,
		ESFCard esfCard, long esfOrganizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCARD_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ESFORGANIZATIONID_2);

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
			query.append(ESFCardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cards where esfOrganizationId = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long esfOrganizationId)
		throws SystemException {
		for (ESFCard esfCard : findByOrganizationId(esfOrganizationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the number of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationId(long esfOrganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { esfOrganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCARD_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ESFORGANIZATIONID_2);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ESFORGANIZATIONID_2 =
		"esfCard.esfOrganizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ESFCardModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFCardModelImpl.CODENUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f cards where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUserId(long esfUserId) throws SystemException {
		return findByUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f cards where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUserId(long esfUserId, int start, int end)
		throws SystemException {
		return findByUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByUserId(long esfUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCard esfCard : list) {
				if ((esfUserId != esfCard.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFCARD_WHERE);

			query.append(_FINDER_COLUMN_USERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByUserId_First(esfUserId, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the first e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCard> list = findByUserId(esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByUserId_Last(esfUserId, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the last e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFCard> list = findByUserId(esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cards before and after the current e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfCardId the primary key of the current e s f card
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard[] findByUserId_PrevAndNext(long esfCardId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByPrimaryKey(esfCardId);

		Session session = null;

		try {
			session = openSession();

			ESFCard[] array = new ESFCardImpl[3];

			array[0] = getByUserId_PrevAndNext(session, esfCard, esfUserId,
					orderByComparator, true);

			array[1] = esfCard;

			array[2] = getByUserId_PrevAndNext(session, esfCard, esfUserId,
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

	protected ESFCard getByUserId_PrevAndNext(Session session, ESFCard esfCard,
		long esfUserId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCARD_WHERE);

		query.append(_FINDER_COLUMN_USERID_ESFUSERID_2);

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
			query.append(ESFCardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cards where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long esfUserId) throws SystemException {
		for (ESFCard esfCard : findByUserId(esfUserId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCARD_WHERE);

			query.append(_FINDER_COLUMN_USERID_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_USERID_ESFUSERID_2 = "esfCard.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OLDCODE = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOldCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDCODE =
		new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOldCode",
			new String[] { String.class.getName() },
			ESFCardModelImpl.OLDCODE_COLUMN_BITMASK |
			ESFCardModelImpl.CODENUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OLDCODE = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOldCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f cards where oldCode = &#63;.
	 *
	 * @param oldCode the old code
	 * @return the matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByOldCode(String oldCode)
		throws SystemException {
		return findByOldCode(oldCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cards where oldCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param oldCode the old code
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByOldCode(String oldCode, int start, int end)
		throws SystemException {
		return findByOldCode(oldCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards where oldCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param oldCode the old code
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByOldCode(String oldCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDCODE;
			finderArgs = new Object[] { oldCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OLDCODE;
			finderArgs = new Object[] { oldCode, start, end, orderByComparator };
		}

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCard esfCard : list) {
				if (!Validator.equals(oldCode, esfCard.getOldCode())) {
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

			query.append(_SQL_SELECT_ESFCARD_WHERE);

			boolean bindOldCode = false;

			if (oldCode == null) {
				query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_1);
			}
			else if (oldCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_3);
			}
			else {
				bindOldCode = true;

				query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOldCode) {
					qPos.add(oldCode);
				}

				if (!pagination) {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f card in the ordered set where oldCode = &#63;.
	 *
	 * @param oldCode the old code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByOldCode_First(String oldCode,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByOldCode_First(oldCode, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("oldCode=");
		msg.append(oldCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the first e s f card in the ordered set where oldCode = &#63;.
	 *
	 * @param oldCode the old code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByOldCode_First(String oldCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCard> list = findByOldCode(oldCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f card in the ordered set where oldCode = &#63;.
	 *
	 * @param oldCode the old code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByOldCode_Last(String oldCode,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByOldCode_Last(oldCode, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("oldCode=");
		msg.append(oldCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the last e s f card in the ordered set where oldCode = &#63;.
	 *
	 * @param oldCode the old code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByOldCode_Last(String oldCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOldCode(oldCode);

		if (count == 0) {
			return null;
		}

		List<ESFCard> list = findByOldCode(oldCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cards before and after the current e s f card in the ordered set where oldCode = &#63;.
	 *
	 * @param esfCardId the primary key of the current e s f card
	 * @param oldCode the old code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard[] findByOldCode_PrevAndNext(long esfCardId, String oldCode,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByPrimaryKey(esfCardId);

		Session session = null;

		try {
			session = openSession();

			ESFCard[] array = new ESFCardImpl[3];

			array[0] = getByOldCode_PrevAndNext(session, esfCard, oldCode,
					orderByComparator, true);

			array[1] = esfCard;

			array[2] = getByOldCode_PrevAndNext(session, esfCard, oldCode,
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

	protected ESFCard getByOldCode_PrevAndNext(Session session,
		ESFCard esfCard, String oldCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCARD_WHERE);

		boolean bindOldCode = false;

		if (oldCode == null) {
			query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_1);
		}
		else if (oldCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_3);
		}
		else {
			bindOldCode = true;

			query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_2);
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
			query.append(ESFCardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOldCode) {
			qPos.add(oldCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cards where oldCode = &#63; from the database.
	 *
	 * @param oldCode the old code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOldCode(String oldCode) throws SystemException {
		for (ESFCard esfCard : findByOldCode(oldCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards where oldCode = &#63;.
	 *
	 * @param oldCode the old code
	 * @return the number of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOldCode(String oldCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OLDCODE;

		Object[] finderArgs = new Object[] { oldCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCARD_WHERE);

			boolean bindOldCode = false;

			if (oldCode == null) {
				query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_1);
			}
			else if (oldCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_3);
			}
			else {
				bindOldCode = true;

				query.append(_FINDER_COLUMN_OLDCODE_OLDCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOldCode) {
					qPos.add(oldCode);
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

	private static final String _FINDER_COLUMN_OLDCODE_OLDCODE_1 = "esfCard.oldCode IS NULL";
	private static final String _FINDER_COLUMN_OLDCODE_OLDCODE_2 = "esfCard.oldCode = ?";
	private static final String _FINDER_COLUMN_OLDCODE_OLDCODE_3 = "(esfCard.oldCode IS NULL OR esfCard.oldCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSER = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER =
		new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, ESFCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfUser",
			new String[] { Long.class.getName() },
			ESFCardModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFCardModelImpl.CODENUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSER = new FinderPath(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f cards where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByEsfUser(long esfUserId)
		throws SystemException {
		return findByEsfUser(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f cards where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByEsfUser(long esfUserId, int start, int end)
		throws SystemException {
		return findByEsfUser(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findByEsfUser(long esfUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSER;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCard esfCard : list) {
				if ((esfUserId != esfCard.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFCARD_WHERE);

			query.append(_FINDER_COLUMN_ESFUSER_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByEsfUser_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByEsfUser_First(esfUserId, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the first e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByEsfUser_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCard> list = findByEsfUser(esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByEsfUser_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByEsfUser_Last(esfUserId, orderByComparator);

		if (esfCard != null) {
			return esfCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCardException(msg.toString());
	}

	/**
	 * Returns the last e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByEsfUser_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfUser(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFCard> list = findByEsfUser(esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cards before and after the current e s f card in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfCardId the primary key of the current e s f card
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard[] findByEsfUser_PrevAndNext(long esfCardId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = findByPrimaryKey(esfCardId);

		Session session = null;

		try {
			session = openSession();

			ESFCard[] array = new ESFCardImpl[3];

			array[0] = getByEsfUser_PrevAndNext(session, esfCard, esfUserId,
					orderByComparator, true);

			array[1] = esfCard;

			array[2] = getByEsfUser_PrevAndNext(session, esfCard, esfUserId,
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

	protected ESFCard getByEsfUser_PrevAndNext(Session session,
		ESFCard esfCard, long esfUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCARD_WHERE);

		query.append(_FINDER_COLUMN_ESFUSER_ESFUSERID_2);

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
			query.append(ESFCardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cards where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfUser(long esfUserId) throws SystemException {
		for (ESFCard esfCard : findByEsfUser(esfUserId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfUser(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSER;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCARD_WHERE);

			query.append(_FINDER_COLUMN_ESFUSER_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_ESFUSER_ESFUSERID_2 = "esfCard.esfUserId = ?";

	public ESFCardPersistenceImpl() {
		setModelClass(ESFCard.class);
	}

	/**
	 * Caches the e s f card in the entity cache if it is enabled.
	 *
	 * @param esfCard the e s f card
	 */
	@Override
	public void cacheResult(ESFCard esfCard) {
		EntityCacheUtil.putResult(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardImpl.class, esfCard.getPrimaryKey(), esfCard);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfCard.getUuid(), esfCard.getGroupId() }, esfCard);

		esfCard.resetOriginalValues();
	}

	/**
	 * Caches the e s f cards in the entity cache if it is enabled.
	 *
	 * @param esfCards the e s f cards
	 */
	@Override
	public void cacheResult(List<ESFCard> esfCards) {
		for (ESFCard esfCard : esfCards) {
			if (EntityCacheUtil.getResult(
						ESFCardModelImpl.ENTITY_CACHE_ENABLED,
						ESFCardImpl.class, esfCard.getPrimaryKey()) == null) {
				cacheResult(esfCard);
			}
			else {
				esfCard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f cards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFCardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFCardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f card.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFCard esfCard) {
		EntityCacheUtil.removeResult(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardImpl.class, esfCard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfCard);
	}

	@Override
	public void clearCache(List<ESFCard> esfCards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFCard esfCard : esfCards) {
			EntityCacheUtil.removeResult(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
				ESFCardImpl.class, esfCard.getPrimaryKey());

			clearUniqueFindersCache(esfCard);
		}
	}

	protected void cacheUniqueFindersCache(ESFCard esfCard) {
		if (esfCard.isNew()) {
			Object[] args = new Object[] { esfCard.getUuid(), esfCard.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, esfCard);
		}
		else {
			ESFCardModelImpl esfCardModelImpl = (ESFCardModelImpl)esfCard;

			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCard.getUuid(), esfCard.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfCard);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFCard esfCard) {
		ESFCardModelImpl esfCardModelImpl = (ESFCardModelImpl)esfCard;

		Object[] args = new Object[] { esfCard.getUuid(), esfCard.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfCardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfCardModelImpl.getOriginalUuid(),
					esfCardModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f card with the primary key. Does not add the e s f card to the database.
	 *
	 * @param esfCardId the primary key for the new e s f card
	 * @return the new e s f card
	 */
	@Override
	public ESFCard create(long esfCardId) {
		ESFCard esfCard = new ESFCardImpl();

		esfCard.setNew(true);
		esfCard.setPrimaryKey(esfCardId);

		String uuid = PortalUUIDUtil.generate();

		esfCard.setUuid(uuid);

		return esfCard;
	}

	/**
	 * Removes the e s f card with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfCardId the primary key of the e s f card
	 * @return the e s f card that was removed
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard remove(long esfCardId)
		throws NoSuchCardException, SystemException {
		return remove((Serializable)esfCardId);
	}

	/**
	 * Removes the e s f card with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f card
	 * @return the e s f card that was removed
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard remove(Serializable primaryKey)
		throws NoSuchCardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFCard esfCard = (ESFCard)session.get(ESFCardImpl.class, primaryKey);

			if (esfCard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfCard);
		}
		catch (NoSuchCardException nsee) {
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
	protected ESFCard removeImpl(ESFCard esfCard) throws SystemException {
		esfCard = toUnwrappedModel(esfCard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfCard)) {
				esfCard = (ESFCard)session.get(ESFCardImpl.class,
						esfCard.getPrimaryKeyObj());
			}

			if (esfCard != null) {
				session.delete(esfCard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfCard != null) {
			clearCache(esfCard);
		}

		return esfCard;
	}

	@Override
	public ESFCard updateImpl(it.ethica.esf.model.ESFCard esfCard)
		throws SystemException {
		esfCard = toUnwrappedModel(esfCard);

		boolean isNew = esfCard.isNew();

		ESFCardModelImpl esfCardModelImpl = (ESFCardModelImpl)esfCard;

		if (Validator.isNull(esfCard.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfCard.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfCard.isNew()) {
				session.save(esfCard);

				esfCard.setNew(false);
			}
			else {
				session.merge(esfCard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFCardModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfCardModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfCardModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCardModelImpl.getOriginalUuid(),
						esfCardModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfCardModelImpl.getUuid(),
						esfCardModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODEALFA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCardModelImpl.getOriginalCodeAlfa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODEALFA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODEALFA,
					args);

				args = new Object[] { esfCardModelImpl.getCodeAlfa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODEALFA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODEALFA,
					args);
			}

			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfCardModelImpl.getOriginalCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esfCardModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}

			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCardModelImpl.getOriginalEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { esfCardModelImpl.getEsfOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}

			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCardModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { esfCardModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCardModelImpl.getOriginalOldCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OLDCODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDCODE,
					args);

				args = new Object[] { esfCardModelImpl.getOldCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OLDCODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDCODE,
					args);
			}

			if ((esfCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCardModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER,
					args);

				args = new Object[] { esfCardModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFCardImpl.class, esfCard.getPrimaryKey(), esfCard);

		clearUniqueFindersCache(esfCard);
		cacheUniqueFindersCache(esfCard);

		return esfCard;
	}

	protected ESFCard toUnwrappedModel(ESFCard esfCard) {
		if (esfCard instanceof ESFCardImpl) {
			return esfCard;
		}

		ESFCardImpl esfCardImpl = new ESFCardImpl();

		esfCardImpl.setNew(esfCard.isNew());
		esfCardImpl.setPrimaryKey(esfCard.getPrimaryKey());

		esfCardImpl.setUuid(esfCard.getUuid());
		esfCardImpl.setEsfCardId(esfCard.getEsfCardId());
		esfCardImpl.setGroupId(esfCard.getGroupId());
		esfCardImpl.setCompanyId(esfCard.getCompanyId());
		esfCardImpl.setUserId(esfCard.getUserId());
		esfCardImpl.setUserName(esfCard.getUserName());
		esfCardImpl.setCreateDate(esfCard.getCreateDate());
		esfCardImpl.setModifiedDate(esfCard.getModifiedDate());
		esfCardImpl.setCodeAlfa(esfCard.getCodeAlfa());
		esfCardImpl.setCodeNum(esfCard.getCodeNum());
		esfCardImpl.setEsfUserId(esfCard.getEsfUserId());
		esfCardImpl.setEsfOrganizationId(esfCard.getEsfOrganizationId());
		esfCardImpl.setCode(esfCard.getCode());
		esfCardImpl.setOldCode(esfCard.getOldCode());

		return esfCardImpl;
	}

	/**
	 * Returns the e s f card with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f card
	 * @return the e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCardException, SystemException {
		ESFCard esfCard = fetchByPrimaryKey(primaryKey);

		if (esfCard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfCard;
	}

	/**
	 * Returns the e s f card with the primary key or throws a {@link it.ethica.esf.NoSuchCardException} if it could not be found.
	 *
	 * @param esfCardId the primary key of the e s f card
	 * @return the e s f card
	 * @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard findByPrimaryKey(long esfCardId)
		throws NoSuchCardException, SystemException {
		return findByPrimaryKey((Serializable)esfCardId);
	}

	/**
	 * Returns the e s f card with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f card
	 * @return the e s f card, or <code>null</code> if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFCard esfCard = (ESFCard)EntityCacheUtil.getResult(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
				ESFCardImpl.class, primaryKey);

		if (esfCard == _nullESFCard) {
			return null;
		}

		if (esfCard == null) {
			Session session = null;

			try {
				session = openSession();

				esfCard = (ESFCard)session.get(ESFCardImpl.class, primaryKey);

				if (esfCard != null) {
					cacheResult(esfCard);
				}
				else {
					EntityCacheUtil.putResult(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
						ESFCardImpl.class, primaryKey, _nullESFCard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFCardModelImpl.ENTITY_CACHE_ENABLED,
					ESFCardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfCard;
	}

	/**
	 * Returns the e s f card with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfCardId the primary key of the e s f card
	 * @return the e s f card, or <code>null</code> if a e s f card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCard fetchByPrimaryKey(long esfCardId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfCardId);
	}

	/**
	 * Returns all the e s f cards.
	 *
	 * @return the e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @return the range of e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f cards
	 * @param end the upper bound of the range of e s f cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCard> findAll(int start, int end,
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

		List<ESFCard> list = (List<ESFCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFCARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFCARD;

				if (pagination) {
					sql = sql.concat(ESFCardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCard>(list);
				}
				else {
					list = (List<ESFCard>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f cards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFCard esfCard : findAll()) {
			remove(esfCard);
		}
	}

	/**
	 * Returns the number of e s f cards.
	 *
	 * @return the number of e s f cards
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

				Query q = session.createQuery(_SQL_COUNT_ESFCARD);

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
	 * Initializes the e s f card persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFCard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFCard>> listenersList = new ArrayList<ModelListener<ESFCard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFCard>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFCardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFCARD = "SELECT esfCard FROM ESFCard esfCard";
	private static final String _SQL_SELECT_ESFCARD_WHERE = "SELECT esfCard FROM ESFCard esfCard WHERE ";
	private static final String _SQL_COUNT_ESFCARD = "SELECT COUNT(esfCard) FROM ESFCard esfCard";
	private static final String _SQL_COUNT_ESFCARD_WHERE = "SELECT COUNT(esfCard) FROM ESFCard esfCard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfCard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFCard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFCard exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFCardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFCard _nullESFCard = new ESFCardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFCard> toCacheModel() {
				return _nullESFCardCacheModel;
			}
		};

	private static CacheModel<ESFCard> _nullESFCardCacheModel = new CacheModel<ESFCard>() {
			@Override
			public ESFCard toEntityModel() {
				return _nullESFCard;
			}
		};
}