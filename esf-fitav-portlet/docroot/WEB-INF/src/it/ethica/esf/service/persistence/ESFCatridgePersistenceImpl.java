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

import it.ethica.esf.NoSuchCatridgeException;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.impl.ESFCatridgeImpl;
import it.ethica.esf.model.impl.ESFCatridgeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f catridge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCatridgePersistence
 * @see ESFCatridgeUtil
 * @generated
 */
public class ESFCatridgePersistenceImpl extends BasePersistenceImpl<ESFCatridge>
	implements ESFCatridgePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFCatridgeUtil} to access the e s f catridge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFCatridgeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, ESFCatridgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, ESFCatridgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, ESFCatridgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, ESFCatridgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFCatridgeModelImpl.UUID_COLUMN_BITMASK |
			ESFCatridgeModelImpl.ESFGUNTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f catridges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f catridges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f catridges
	 * @param end the upper bound of the range of e s f catridges (not inclusive)
	 * @return the range of matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f catridges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f catridges
	 * @param end the upper bound of the range of e s f catridges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByUuid(String uuid, int start, int end,
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

		List<ESFCatridge> list = (List<ESFCatridge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCatridge esfCatridge : list) {
				if (!Validator.equals(uuid, esfCatridge.getUuid())) {
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

			query.append(_SQL_SELECT_ESFCATRIDGE_WHERE);

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
				query.append(ESFCatridgeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFCatridge>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCatridge>(list);
				}
				else {
					list = (List<ESFCatridge>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f catridge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = fetchByUuid_First(uuid, orderByComparator);

		if (esfCatridge != null) {
			return esfCatridge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatridgeException(msg.toString());
	}

	/**
	 * Returns the first e s f catridge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCatridge> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f catridge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = fetchByUuid_Last(uuid, orderByComparator);

		if (esfCatridge != null) {
			return esfCatridge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatridgeException(msg.toString());
	}

	/**
	 * Returns the last e s f catridge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFCatridge> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f catridges before and after the current e s f catridge in the ordered set where uuid = &#63;.
	 *
	 * @param esfCatridgeId the primary key of the current e s f catridge
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge[] findByUuid_PrevAndNext(long esfCatridgeId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = findByPrimaryKey(esfCatridgeId);

		Session session = null;

		try {
			session = openSession();

			ESFCatridge[] array = new ESFCatridgeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfCatridge, uuid,
					orderByComparator, true);

			array[1] = esfCatridge;

			array[2] = getByUuid_PrevAndNext(session, esfCatridge, uuid,
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

	protected ESFCatridge getByUuid_PrevAndNext(Session session,
		ESFCatridge esfCatridge, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCATRIDGE_WHERE);

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
			query.append(ESFCatridgeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfCatridge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCatridge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f catridges where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFCatridge esfCatridge : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCatridge);
		}
	}

	/**
	 * Returns the number of e s f catridges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f catridges
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

			query.append(_SQL_COUNT_ESFCATRIDGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfCatridge.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfCatridge.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfCatridge.uuid IS NULL OR esfCatridge.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, ESFCatridgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, ESFCatridgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfUserId",
			new String[] { Long.class.getName() },
			ESFCatridgeModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFCatridgeModelImpl.ESFGUNTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERID = new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f catridges where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByEsfUserId(long esfUserId)
		throws SystemException {
		return findByEsfUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f catridges where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f catridges
	 * @param end the upper bound of the range of e s f catridges (not inclusive)
	 * @return the range of matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByEsfUserId(long esfUserId, int start, int end)
		throws SystemException {
		return findByEsfUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f catridges where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f catridges
	 * @param end the upper bound of the range of e s f catridges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByEsfUserId(long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFCatridge> list = (List<ESFCatridge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCatridge esfCatridge : list) {
				if ((esfUserId != esfCatridge.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFCATRIDGE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCatridgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFCatridge>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCatridge>(list);
				}
				else {
					list = (List<ESFCatridge>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f catridge in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge findByEsfUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = fetchByEsfUserId_First(esfUserId,
				orderByComparator);

		if (esfCatridge != null) {
			return esfCatridge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatridgeException(msg.toString());
	}

	/**
	 * Returns the first e s f catridge in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge fetchByEsfUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCatridge> list = findByEsfUserId(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f catridge in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge findByEsfUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = fetchByEsfUserId_Last(esfUserId,
				orderByComparator);

		if (esfCatridge != null) {
			return esfCatridge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatridgeException(msg.toString());
	}

	/**
	 * Returns the last e s f catridge in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge fetchByEsfUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFCatridge> list = findByEsfUserId(esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f catridges before and after the current e s f catridge in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfCatridgeId the primary key of the current e s f catridge
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge[] findByEsfUserId_PrevAndNext(long esfCatridgeId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = findByPrimaryKey(esfCatridgeId);

		Session session = null;

		try {
			session = openSession();

			ESFCatridge[] array = new ESFCatridgeImpl[3];

			array[0] = getByEsfUserId_PrevAndNext(session, esfCatridge,
					esfUserId, orderByComparator, true);

			array[1] = esfCatridge;

			array[2] = getByEsfUserId_PrevAndNext(session, esfCatridge,
					esfUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFCatridge getByEsfUserId_PrevAndNext(Session session,
		ESFCatridge esfCatridge, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCATRIDGE_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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
			query.append(ESFCatridgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCatridge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCatridge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f catridges where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfUserId(long esfUserId) throws SystemException {
		for (ESFCatridge esfCatridge : findByEsfUserId(esfUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfCatridge);
		}
	}

	/**
	 * Returns the number of e s f catridges where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfUserId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCATRIDGE_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_ESFUSERID_ESFUSERID_2 = "esfCatridge.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFGUNTYPEID =
		new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, ESFCatridgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfGunTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID =
		new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, ESFCatridgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfGunTypeId",
			new String[] { Long.class.getName() },
			ESFCatridgeModelImpl.ESFGUNTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFGUNTYPEID = new FinderPath(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfGunTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f catridges where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @return the matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByEsfGunTypeId(long esfGunTypeId)
		throws SystemException {
		return findByEsfGunTypeId(esfGunTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f catridges where esfGunTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param start the lower bound of the range of e s f catridges
	 * @param end the upper bound of the range of e s f catridges (not inclusive)
	 * @return the range of matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByEsfGunTypeId(long esfGunTypeId, int start,
		int end) throws SystemException {
		return findByEsfGunTypeId(esfGunTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f catridges where esfGunTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param start the lower bound of the range of e s f catridges
	 * @param end the upper bound of the range of e s f catridges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findByEsfGunTypeId(long esfGunTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID;
			finderArgs = new Object[] { esfGunTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFGUNTYPEID;
			finderArgs = new Object[] {
					esfGunTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFCatridge> list = (List<ESFCatridge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCatridge esfCatridge : list) {
				if ((esfGunTypeId != esfCatridge.getEsfGunTypeId())) {
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

			query.append(_SQL_SELECT_ESFCATRIDGE_WHERE);

			query.append(_FINDER_COLUMN_ESFGUNTYPEID_ESFGUNTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCatridgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunTypeId);

				if (!pagination) {
					list = (List<ESFCatridge>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCatridge>(list);
				}
				else {
					list = (List<ESFCatridge>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f catridge in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge findByEsfGunTypeId_First(long esfGunTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = fetchByEsfGunTypeId_First(esfGunTypeId,
				orderByComparator);

		if (esfCatridge != null) {
			return esfCatridge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunTypeId=");
		msg.append(esfGunTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatridgeException(msg.toString());
	}

	/**
	 * Returns the first e s f catridge in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge fetchByEsfGunTypeId_First(long esfGunTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCatridge> list = findByEsfGunTypeId(esfGunTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f catridge in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge findByEsfGunTypeId_Last(long esfGunTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = fetchByEsfGunTypeId_Last(esfGunTypeId,
				orderByComparator);

		if (esfCatridge != null) {
			return esfCatridge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunTypeId=");
		msg.append(esfGunTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatridgeException(msg.toString());
	}

	/**
	 * Returns the last e s f catridge in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge fetchByEsfGunTypeId_Last(long esfGunTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfGunTypeId(esfGunTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFCatridge> list = findByEsfGunTypeId(esfGunTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f catridges before and after the current e s f catridge in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfCatridgeId the primary key of the current e s f catridge
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge[] findByEsfGunTypeId_PrevAndNext(long esfCatridgeId,
		long esfGunTypeId, OrderByComparator orderByComparator)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = findByPrimaryKey(esfCatridgeId);

		Session session = null;

		try {
			session = openSession();

			ESFCatridge[] array = new ESFCatridgeImpl[3];

			array[0] = getByEsfGunTypeId_PrevAndNext(session, esfCatridge,
					esfGunTypeId, orderByComparator, true);

			array[1] = esfCatridge;

			array[2] = getByEsfGunTypeId_PrevAndNext(session, esfCatridge,
					esfGunTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFCatridge getByEsfGunTypeId_PrevAndNext(Session session,
		ESFCatridge esfCatridge, long esfGunTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCATRIDGE_WHERE);

		query.append(_FINDER_COLUMN_ESFGUNTYPEID_ESFGUNTYPEID_2);

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
			query.append(ESFCatridgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfGunTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCatridge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCatridge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f catridges where esfGunTypeId = &#63; from the database.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfGunTypeId(long esfGunTypeId)
		throws SystemException {
		for (ESFCatridge esfCatridge : findByEsfGunTypeId(esfGunTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfCatridge);
		}
	}

	/**
	 * Returns the number of e s f catridges where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @return the number of matching e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfGunTypeId(long esfGunTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFGUNTYPEID;

		Object[] finderArgs = new Object[] { esfGunTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCATRIDGE_WHERE);

			query.append(_FINDER_COLUMN_ESFGUNTYPEID_ESFGUNTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunTypeId);

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

	private static final String _FINDER_COLUMN_ESFGUNTYPEID_ESFGUNTYPEID_2 = "esfCatridge.esfGunTypeId = ?";

	public ESFCatridgePersistenceImpl() {
		setModelClass(ESFCatridge.class);
	}

	/**
	 * Caches the e s f catridge in the entity cache if it is enabled.
	 *
	 * @param esfCatridge the e s f catridge
	 */
	@Override
	public void cacheResult(ESFCatridge esfCatridge) {
		EntityCacheUtil.putResult(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeImpl.class, esfCatridge.getPrimaryKey(), esfCatridge);

		esfCatridge.resetOriginalValues();
	}

	/**
	 * Caches the e s f catridges in the entity cache if it is enabled.
	 *
	 * @param esfCatridges the e s f catridges
	 */
	@Override
	public void cacheResult(List<ESFCatridge> esfCatridges) {
		for (ESFCatridge esfCatridge : esfCatridges) {
			if (EntityCacheUtil.getResult(
						ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
						ESFCatridgeImpl.class, esfCatridge.getPrimaryKey()) == null) {
				cacheResult(esfCatridge);
			}
			else {
				esfCatridge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f catridges.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFCatridgeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFCatridgeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f catridge.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFCatridge esfCatridge) {
		EntityCacheUtil.removeResult(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeImpl.class, esfCatridge.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFCatridge> esfCatridges) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFCatridge esfCatridge : esfCatridges) {
			EntityCacheUtil.removeResult(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
				ESFCatridgeImpl.class, esfCatridge.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f catridge with the primary key. Does not add the e s f catridge to the database.
	 *
	 * @param esfCatridgeId the primary key for the new e s f catridge
	 * @return the new e s f catridge
	 */
	@Override
	public ESFCatridge create(long esfCatridgeId) {
		ESFCatridge esfCatridge = new ESFCatridgeImpl();

		esfCatridge.setNew(true);
		esfCatridge.setPrimaryKey(esfCatridgeId);

		String uuid = PortalUUIDUtil.generate();

		esfCatridge.setUuid(uuid);

		return esfCatridge;
	}

	/**
	 * Removes the e s f catridge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfCatridgeId the primary key of the e s f catridge
	 * @return the e s f catridge that was removed
	 * @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge remove(long esfCatridgeId)
		throws NoSuchCatridgeException, SystemException {
		return remove((Serializable)esfCatridgeId);
	}

	/**
	 * Removes the e s f catridge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f catridge
	 * @return the e s f catridge that was removed
	 * @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge remove(Serializable primaryKey)
		throws NoSuchCatridgeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFCatridge esfCatridge = (ESFCatridge)session.get(ESFCatridgeImpl.class,
					primaryKey);

			if (esfCatridge == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCatridgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfCatridge);
		}
		catch (NoSuchCatridgeException nsee) {
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
	protected ESFCatridge removeImpl(ESFCatridge esfCatridge)
		throws SystemException {
		esfCatridge = toUnwrappedModel(esfCatridge);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfCatridge)) {
				esfCatridge = (ESFCatridge)session.get(ESFCatridgeImpl.class,
						esfCatridge.getPrimaryKeyObj());
			}

			if (esfCatridge != null) {
				session.delete(esfCatridge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfCatridge != null) {
			clearCache(esfCatridge);
		}

		return esfCatridge;
	}

	@Override
	public ESFCatridge updateImpl(it.ethica.esf.model.ESFCatridge esfCatridge)
		throws SystemException {
		esfCatridge = toUnwrappedModel(esfCatridge);

		boolean isNew = esfCatridge.isNew();

		ESFCatridgeModelImpl esfCatridgeModelImpl = (ESFCatridgeModelImpl)esfCatridge;

		if (Validator.isNull(esfCatridge.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfCatridge.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfCatridge.isNew()) {
				session.save(esfCatridge);

				esfCatridge.setNew(false);
			}
			else {
				session.merge(esfCatridge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFCatridgeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfCatridgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCatridgeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfCatridgeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfCatridgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCatridgeModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);

				args = new Object[] { esfCatridgeModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);
			}

			if ((esfCatridgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCatridgeModelImpl.getOriginalEsfGunTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFGUNTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID,
					args);

				args = new Object[] { esfCatridgeModelImpl.getEsfGunTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFGUNTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
			ESFCatridgeImpl.class, esfCatridge.getPrimaryKey(), esfCatridge);

		return esfCatridge;
	}

	protected ESFCatridge toUnwrappedModel(ESFCatridge esfCatridge) {
		if (esfCatridge instanceof ESFCatridgeImpl) {
			return esfCatridge;
		}

		ESFCatridgeImpl esfCatridgeImpl = new ESFCatridgeImpl();

		esfCatridgeImpl.setNew(esfCatridge.isNew());
		esfCatridgeImpl.setPrimaryKey(esfCatridge.getPrimaryKey());

		esfCatridgeImpl.setUuid(esfCatridge.getUuid());
		esfCatridgeImpl.setEsfCatridgeId(esfCatridge.getEsfCatridgeId());
		esfCatridgeImpl.setEsfUserId(esfCatridge.getEsfUserId());
		esfCatridgeImpl.setEsfGunTypeId(esfCatridge.getEsfGunTypeId());
		esfCatridgeImpl.setCatridgeModel(esfCatridge.getCatridgeModel());
		esfCatridgeImpl.setCatridgeCaliber(esfCatridge.getCatridgeCaliber());
		esfCatridgeImpl.setNote(esfCatridge.getNote());

		return esfCatridgeImpl;
	}

	/**
	 * Returns the e s f catridge with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f catridge
	 * @return the e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCatridgeException, SystemException {
		ESFCatridge esfCatridge = fetchByPrimaryKey(primaryKey);

		if (esfCatridge == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCatridgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfCatridge;
	}

	/**
	 * Returns the e s f catridge with the primary key or throws a {@link it.ethica.esf.NoSuchCatridgeException} if it could not be found.
	 *
	 * @param esfCatridgeId the primary key of the e s f catridge
	 * @return the e s f catridge
	 * @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge findByPrimaryKey(long esfCatridgeId)
		throws NoSuchCatridgeException, SystemException {
		return findByPrimaryKey((Serializable)esfCatridgeId);
	}

	/**
	 * Returns the e s f catridge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f catridge
	 * @return the e s f catridge, or <code>null</code> if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFCatridge esfCatridge = (ESFCatridge)EntityCacheUtil.getResult(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
				ESFCatridgeImpl.class, primaryKey);

		if (esfCatridge == _nullESFCatridge) {
			return null;
		}

		if (esfCatridge == null) {
			Session session = null;

			try {
				session = openSession();

				esfCatridge = (ESFCatridge)session.get(ESFCatridgeImpl.class,
						primaryKey);

				if (esfCatridge != null) {
					cacheResult(esfCatridge);
				}
				else {
					EntityCacheUtil.putResult(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
						ESFCatridgeImpl.class, primaryKey, _nullESFCatridge);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFCatridgeModelImpl.ENTITY_CACHE_ENABLED,
					ESFCatridgeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfCatridge;
	}

	/**
	 * Returns the e s f catridge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfCatridgeId the primary key of the e s f catridge
	 * @return the e s f catridge, or <code>null</code> if a e s f catridge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCatridge fetchByPrimaryKey(long esfCatridgeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfCatridgeId);
	}

	/**
	 * Returns all the e s f catridges.
	 *
	 * @return the e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f catridges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f catridges
	 * @param end the upper bound of the range of e s f catridges (not inclusive)
	 * @return the range of e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f catridges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f catridges
	 * @param end the upper bound of the range of e s f catridges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f catridges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCatridge> findAll(int start, int end,
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

		List<ESFCatridge> list = (List<ESFCatridge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFCATRIDGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFCATRIDGE;

				if (pagination) {
					sql = sql.concat(ESFCatridgeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFCatridge>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCatridge>(list);
				}
				else {
					list = (List<ESFCatridge>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f catridges from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFCatridge esfCatridge : findAll()) {
			remove(esfCatridge);
		}
	}

	/**
	 * Returns the number of e s f catridges.
	 *
	 * @return the number of e s f catridges
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

				Query q = session.createQuery(_SQL_COUNT_ESFCATRIDGE);

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
	 * Initializes the e s f catridge persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFCatridge")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFCatridge>> listenersList = new ArrayList<ModelListener<ESFCatridge>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFCatridge>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFCatridgeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFCATRIDGE = "SELECT esfCatridge FROM ESFCatridge esfCatridge";
	private static final String _SQL_SELECT_ESFCATRIDGE_WHERE = "SELECT esfCatridge FROM ESFCatridge esfCatridge WHERE ";
	private static final String _SQL_COUNT_ESFCATRIDGE = "SELECT COUNT(esfCatridge) FROM ESFCatridge esfCatridge";
	private static final String _SQL_COUNT_ESFCATRIDGE_WHERE = "SELECT COUNT(esfCatridge) FROM ESFCatridge esfCatridge WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfCatridge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFCatridge exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFCatridge exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFCatridgePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFCatridge _nullESFCatridge = new ESFCatridgeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFCatridge> toCacheModel() {
				return _nullESFCatridgeCacheModel;
			}
		};

	private static CacheModel<ESFCatridge> _nullESFCatridgeCacheModel = new CacheModel<ESFCatridge>() {
			@Override
			public ESFCatridge toEntityModel() {
				return _nullESFCatridge;
			}
		};
}