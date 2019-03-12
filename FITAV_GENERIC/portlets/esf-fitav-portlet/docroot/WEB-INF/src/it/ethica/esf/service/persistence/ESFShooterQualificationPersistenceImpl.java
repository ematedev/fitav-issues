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

import it.ethica.esf.NoSuchShooterQualificationException;
import it.ethica.esf.model.ESFShooterQualification;
import it.ethica.esf.model.impl.ESFShooterQualificationImpl;
import it.ethica.esf.model.impl.ESFShooterQualificationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f shooter qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationPersistence
 * @see ESFShooterQualificationUtil
 * @generated
 */
public class ESFShooterQualificationPersistenceImpl extends BasePersistenceImpl<ESFShooterQualification>
	implements ESFShooterQualificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFShooterQualificationUtil} to access the e s f shooter qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFShooterQualificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFShooterQualificationModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterQualificationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f shooter qualifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter qualifications
	 * @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	 * @return the range of matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter qualifications
	 * @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByUuid(String uuid, int start,
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

		List<ESFShooterQualification> list = (List<ESFShooterQualification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterQualification esfShooterQualification : list) {
				if (!Validator.equals(uuid, esfShooterQualification.getUuid())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATION_WHERE);

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
				query.append(ESFShooterQualificationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterQualification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualification>(list);
				}
				else {
					list = (List<ESFShooterQualification>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter qualification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfShooterQualification != null) {
			return esfShooterQualification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter qualification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShooterQualification> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter qualification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfShooterQualification != null) {
			return esfShooterQualification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter qualification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFShooterQualification> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter qualifications before and after the current e s f shooter qualification in the ordered set where uuid = &#63;.
	 *
	 * @param esfShooterQualificationId the primary key of the current e s f shooter qualification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification[] findByUuid_PrevAndNext(
		long esfShooterQualificationId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = findByPrimaryKey(esfShooterQualificationId);

		Session session = null;

		try {
			session = openSession();

			ESFShooterQualification[] array = new ESFShooterQualificationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfShooterQualification,
					uuid, orderByComparator, true);

			array[1] = esfShooterQualification;

			array[2] = getByUuid_PrevAndNext(session, esfShooterQualification,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFShooterQualification getByUuid_PrevAndNext(Session session,
		ESFShooterQualification esfShooterQualification, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATION_WHERE);

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
			query.append(ESFShooterQualificationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterQualification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterQualification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter qualifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFShooterQualification esfShooterQualification : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterQualification);
		}
	}

	/**
	 * Returns the number of e s f shooter qualifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f shooter qualifications
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfShooterQualification.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfShooterQualification.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfShooterQualification.uuid IS NULL OR esfShooterQualification.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFShooterQualificationModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterQualificationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f shooter qualification where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchShooterQualificationException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByUUID_G(String uuid, long groupId)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = fetchByUUID_G(uuid,
				groupId);

		if (esfShooterQualification == null) {
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

			throw new NoSuchShooterQualificationException(msg.toString());
		}

		return esfShooterQualification;
	}

	/**
	 * Returns the e s f shooter qualification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f shooter qualification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFShooterQualification) {
			ESFShooterQualification esfShooterQualification = (ESFShooterQualification)result;

			if (!Validator.equals(uuid, esfShooterQualification.getUuid()) ||
					(groupId != esfShooterQualification.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATION_WHERE);

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

				List<ESFShooterQualification> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFShooterQualification esfShooterQualification = list.get(0);

					result = esfShooterQualification;

					cacheResult(esfShooterQualification);

					if ((esfShooterQualification.getUuid() == null) ||
							!esfShooterQualification.getUuid().equals(uuid) ||
							(esfShooterQualification.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfShooterQualification);
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
			return (ESFShooterQualification)result;
		}
	}

	/**
	 * Removes the e s f shooter qualification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f shooter qualification that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification removeByUUID_G(String uuid, long groupId)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = findByUUID_G(uuid,
				groupId);

		return remove(esfShooterQualification);
	}

	/**
	 * Returns the number of e s f shooter qualifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f shooter qualifications
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfShooterQualification.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfShooterQualification.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfShooterQualification.uuid IS NULL OR esfShooterQualification.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfShooterQualification.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFShooterQualificationModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterQualificationModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFShooterQualificationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f shooter qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByUuid_C(String uuid,
		long companyId) throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f shooter qualifications
	 * @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	 * @return the range of matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f shooter qualifications
	 * @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByUuid_C(String uuid,
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

		List<ESFShooterQualification> list = (List<ESFShooterQualification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterQualification esfShooterQualification : list) {
				if (!Validator.equals(uuid, esfShooterQualification.getUuid()) ||
						(companyId != esfShooterQualification.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATION_WHERE);

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
				query.append(ESFShooterQualificationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterQualification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualification>(list);
				}
				else {
					list = (List<ESFShooterQualification>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (esfShooterQualification != null) {
			return esfShooterQualification;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFShooterQualification> list = findByUuid_C(uuid, companyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (esfShooterQualification != null) {
			return esfShooterQualification;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFShooterQualification> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter qualifications before and after the current e s f shooter qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfShooterQualificationId the primary key of the current e s f shooter qualification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification[] findByUuid_C_PrevAndNext(
		long esfShooterQualificationId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = findByPrimaryKey(esfShooterQualificationId);

		Session session = null;

		try {
			session = openSession();

			ESFShooterQualification[] array = new ESFShooterQualificationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					esfShooterQualification, uuid, companyId,
					orderByComparator, true);

			array[1] = esfShooterQualification;

			array[2] = getByUuid_C_PrevAndNext(session,
					esfShooterQualification, uuid, companyId,
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

	protected ESFShooterQualification getByUuid_C_PrevAndNext(Session session,
		ESFShooterQualification esfShooterQualification, String uuid,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATION_WHERE);

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
			query.append(ESFShooterQualificationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterQualification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterQualification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter qualifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFShooterQualification esfShooterQualification : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterQualification);
		}
	}

	/**
	 * Returns the number of e s f shooter qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f shooter qualifications
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfShooterQualification.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfShooterQualification.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfShooterQualification.uuid IS NULL OR esfShooterQualification.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfShooterQualification.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ESFShooterQualificationModelImpl.CODE_COLUMN_BITMASK |
			ESFShooterQualificationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f shooter qualifications where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByCode(String code)
		throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualifications where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f shooter qualifications
	 * @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	 * @return the range of matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByCode(String code, int start,
		int end) throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualifications where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f shooter qualifications
	 * @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findByCode(String code, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFShooterQualification> list = (List<ESFShooterQualification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterQualification esfShooterQualification : list) {
				if (!Validator.equals(code, esfShooterQualification.getCode())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATION_WHERE);

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
				query.append(ESFShooterQualificationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterQualification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualification>(list);
				}
				else {
					list = (List<ESFShooterQualification>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter qualification in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = fetchByCode_First(code,
				orderByComparator);

		if (esfShooterQualification != null) {
			return esfShooterQualification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter qualification in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShooterQualification> list = findByCode(code, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter qualification in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = fetchByCode_Last(code,
				orderByComparator);

		if (esfShooterQualification != null) {
			return esfShooterQualification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter qualification in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ESFShooterQualification> list = findByCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter qualifications before and after the current e s f shooter qualification in the ordered set where code = &#63;.
	 *
	 * @param esfShooterQualificationId the primary key of the current e s f shooter qualification
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification[] findByCode_PrevAndNext(
		long esfShooterQualificationId, String code,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = findByPrimaryKey(esfShooterQualificationId);

		Session session = null;

		try {
			session = openSession();

			ESFShooterQualification[] array = new ESFShooterQualificationImpl[3];

			array[0] = getByCode_PrevAndNext(session, esfShooterQualification,
					code, orderByComparator, true);

			array[1] = esfShooterQualification;

			array[2] = getByCode_PrevAndNext(session, esfShooterQualification,
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

	protected ESFShooterQualification getByCode_PrevAndNext(Session session,
		ESFShooterQualification esfShooterQualification, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATION_WHERE);

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
			query.append(ESFShooterQualificationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterQualification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterQualification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter qualifications where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ESFShooterQualification esfShooterQualification : findByCode(
				code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterQualification);
		}
	}

	/**
	 * Returns the number of e s f shooter qualifications where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f shooter qualifications
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATION_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfShooterQualification.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfShooterQualification.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfShooterQualification.code IS NULL OR esfShooterQualification.code = '')";

	public ESFShooterQualificationPersistenceImpl() {
		setModelClass(ESFShooterQualification.class);
	}

	/**
	 * Caches the e s f shooter qualification in the entity cache if it is enabled.
	 *
	 * @param esfShooterQualification the e s f shooter qualification
	 */
	@Override
	public void cacheResult(ESFShooterQualification esfShooterQualification) {
		EntityCacheUtil.putResult(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			esfShooterQualification.getPrimaryKey(), esfShooterQualification);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				esfShooterQualification.getUuid(),
				esfShooterQualification.getGroupId()
			}, esfShooterQualification);

		esfShooterQualification.resetOriginalValues();
	}

	/**
	 * Caches the e s f shooter qualifications in the entity cache if it is enabled.
	 *
	 * @param esfShooterQualifications the e s f shooter qualifications
	 */
	@Override
	public void cacheResult(
		List<ESFShooterQualification> esfShooterQualifications) {
		for (ESFShooterQualification esfShooterQualification : esfShooterQualifications) {
			if (EntityCacheUtil.getResult(
						ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterQualificationImpl.class,
						esfShooterQualification.getPrimaryKey()) == null) {
				cacheResult(esfShooterQualification);
			}
			else {
				esfShooterQualification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f shooter qualifications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFShooterQualificationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFShooterQualificationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f shooter qualification.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFShooterQualification esfShooterQualification) {
		EntityCacheUtil.removeResult(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			esfShooterQualification.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfShooterQualification);
	}

	@Override
	public void clearCache(
		List<ESFShooterQualification> esfShooterQualifications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFShooterQualification esfShooterQualification : esfShooterQualifications) {
			EntityCacheUtil.removeResult(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterQualificationImpl.class,
				esfShooterQualification.getPrimaryKey());

			clearUniqueFindersCache(esfShooterQualification);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFShooterQualification esfShooterQualification) {
		if (esfShooterQualification.isNew()) {
			Object[] args = new Object[] {
					esfShooterQualification.getUuid(),
					esfShooterQualification.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfShooterQualification);
		}
		else {
			ESFShooterQualificationModelImpl esfShooterQualificationModelImpl = (ESFShooterQualificationModelImpl)esfShooterQualification;

			if ((esfShooterQualificationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualification.getUuid(),
						esfShooterQualification.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfShooterQualification);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFShooterQualification esfShooterQualification) {
		ESFShooterQualificationModelImpl esfShooterQualificationModelImpl = (ESFShooterQualificationModelImpl)esfShooterQualification;

		Object[] args = new Object[] {
				esfShooterQualification.getUuid(),
				esfShooterQualification.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfShooterQualificationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfShooterQualificationModelImpl.getOriginalUuid(),
					esfShooterQualificationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f shooter qualification with the primary key. Does not add the e s f shooter qualification to the database.
	 *
	 * @param esfShooterQualificationId the primary key for the new e s f shooter qualification
	 * @return the new e s f shooter qualification
	 */
	@Override
	public ESFShooterQualification create(long esfShooterQualificationId) {
		ESFShooterQualification esfShooterQualification = new ESFShooterQualificationImpl();

		esfShooterQualification.setNew(true);
		esfShooterQualification.setPrimaryKey(esfShooterQualificationId);

		String uuid = PortalUUIDUtil.generate();

		esfShooterQualification.setUuid(uuid);

		return esfShooterQualification;
	}

	/**
	 * Removes the e s f shooter qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfShooterQualificationId the primary key of the e s f shooter qualification
	 * @return the e s f shooter qualification that was removed
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification remove(long esfShooterQualificationId)
		throws NoSuchShooterQualificationException, SystemException {
		return remove((Serializable)esfShooterQualificationId);
	}

	/**
	 * Removes the e s f shooter qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification
	 * @return the e s f shooter qualification that was removed
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification remove(Serializable primaryKey)
		throws NoSuchShooterQualificationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFShooterQualification esfShooterQualification = (ESFShooterQualification)session.get(ESFShooterQualificationImpl.class,
					primaryKey);

			if (esfShooterQualification == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShooterQualificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfShooterQualification);
		}
		catch (NoSuchShooterQualificationException nsee) {
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
	protected ESFShooterQualification removeImpl(
		ESFShooterQualification esfShooterQualification)
		throws SystemException {
		esfShooterQualification = toUnwrappedModel(esfShooterQualification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfShooterQualification)) {
				esfShooterQualification = (ESFShooterQualification)session.get(ESFShooterQualificationImpl.class,
						esfShooterQualification.getPrimaryKeyObj());
			}

			if (esfShooterQualification != null) {
				session.delete(esfShooterQualification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfShooterQualification != null) {
			clearCache(esfShooterQualification);
		}

		return esfShooterQualification;
	}

	@Override
	public ESFShooterQualification updateImpl(
		it.ethica.esf.model.ESFShooterQualification esfShooterQualification)
		throws SystemException {
		esfShooterQualification = toUnwrappedModel(esfShooterQualification);

		boolean isNew = esfShooterQualification.isNew();

		ESFShooterQualificationModelImpl esfShooterQualificationModelImpl = (ESFShooterQualificationModelImpl)esfShooterQualification;

		if (Validator.isNull(esfShooterQualification.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfShooterQualification.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfShooterQualification.isNew()) {
				session.save(esfShooterQualification);

				esfShooterQualification.setNew(false);
			}
			else {
				session.merge(esfShooterQualification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFShooterQualificationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfShooterQualificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfShooterQualificationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfShooterQualificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationModelImpl.getOriginalUuid(),
						esfShooterQualificationModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfShooterQualificationModelImpl.getUuid(),
						esfShooterQualificationModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfShooterQualificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esfShooterQualificationModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationImpl.class,
			esfShooterQualification.getPrimaryKey(), esfShooterQualification);

		clearUniqueFindersCache(esfShooterQualification);
		cacheUniqueFindersCache(esfShooterQualification);

		return esfShooterQualification;
	}

	protected ESFShooterQualification toUnwrappedModel(
		ESFShooterQualification esfShooterQualification) {
		if (esfShooterQualification instanceof ESFShooterQualificationImpl) {
			return esfShooterQualification;
		}

		ESFShooterQualificationImpl esfShooterQualificationImpl = new ESFShooterQualificationImpl();

		esfShooterQualificationImpl.setNew(esfShooterQualification.isNew());
		esfShooterQualificationImpl.setPrimaryKey(esfShooterQualification.getPrimaryKey());

		esfShooterQualificationImpl.setUuid(esfShooterQualification.getUuid());
		esfShooterQualificationImpl.setEsfShooterQualificationId(esfShooterQualification.getEsfShooterQualificationId());
		esfShooterQualificationImpl.setName(esfShooterQualification.getName());
		esfShooterQualificationImpl.setIsJunior(esfShooterQualification.isIsJunior());
		esfShooterQualificationImpl.setGroupId(esfShooterQualification.getGroupId());
		esfShooterQualificationImpl.setCompanyId(esfShooterQualification.getCompanyId());
		esfShooterQualificationImpl.setUserId(esfShooterQualification.getUserId());
		esfShooterQualificationImpl.setUserName(esfShooterQualification.getUserName());
		esfShooterQualificationImpl.setCreateDate(esfShooterQualification.getCreateDate());
		esfShooterQualificationImpl.setModifiedDate(esfShooterQualification.getModifiedDate());
		esfShooterQualificationImpl.setDescription(esfShooterQualification.getDescription());
		esfShooterQualificationImpl.setCode(esfShooterQualification.getCode());

		return esfShooterQualificationImpl;
	}

	/**
	 * Returns the e s f shooter qualification with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification
	 * @return the e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShooterQualificationException, SystemException {
		ESFShooterQualification esfShooterQualification = fetchByPrimaryKey(primaryKey);

		if (esfShooterQualification == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShooterQualificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfShooterQualification;
	}

	/**
	 * Returns the e s f shooter qualification with the primary key or throws a {@link it.ethica.esf.NoSuchShooterQualificationException} if it could not be found.
	 *
	 * @param esfShooterQualificationId the primary key of the e s f shooter qualification
	 * @return the e s f shooter qualification
	 * @throws it.ethica.esf.NoSuchShooterQualificationException if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification findByPrimaryKey(
		long esfShooterQualificationId)
		throws NoSuchShooterQualificationException, SystemException {
		return findByPrimaryKey((Serializable)esfShooterQualificationId);
	}

	/**
	 * Returns the e s f shooter qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification
	 * @return the e s f shooter qualification, or <code>null</code> if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFShooterQualification esfShooterQualification = (ESFShooterQualification)EntityCacheUtil.getResult(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterQualificationImpl.class, primaryKey);

		if (esfShooterQualification == _nullESFShooterQualification) {
			return null;
		}

		if (esfShooterQualification == null) {
			Session session = null;

			try {
				session = openSession();

				esfShooterQualification = (ESFShooterQualification)session.get(ESFShooterQualificationImpl.class,
						primaryKey);

				if (esfShooterQualification != null) {
					cacheResult(esfShooterQualification);
				}
				else {
					EntityCacheUtil.putResult(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterQualificationImpl.class, primaryKey,
						_nullESFShooterQualification);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFShooterQualificationModelImpl.ENTITY_CACHE_ENABLED,
					ESFShooterQualificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfShooterQualification;
	}

	/**
	 * Returns the e s f shooter qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfShooterQualificationId the primary key of the e s f shooter qualification
	 * @return the e s f shooter qualification, or <code>null</code> if a e s f shooter qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualification fetchByPrimaryKey(
		long esfShooterQualificationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfShooterQualificationId);
	}

	/**
	 * Returns all the e s f shooter qualifications.
	 *
	 * @return the e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter qualifications
	 * @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	 * @return the range of e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter qualifications
	 * @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f shooter qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualification> findAll(int start, int end,
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

		List<ESFShooterQualification> list = (List<ESFShooterQualification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSHOOTERQUALIFICATION;

				if (pagination) {
					sql = sql.concat(ESFShooterQualificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFShooterQualification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualification>(list);
				}
				else {
					list = (List<ESFShooterQualification>)QueryUtil.list(q,
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
	 * Removes all the e s f shooter qualifications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFShooterQualification esfShooterQualification : findAll()) {
			remove(esfShooterQualification);
		}
	}

	/**
	 * Returns the number of e s f shooter qualifications.
	 *
	 * @return the number of e s f shooter qualifications
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

				Query q = session.createQuery(_SQL_COUNT_ESFSHOOTERQUALIFICATION);

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
	 * Initializes the e s f shooter qualification persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFShooterQualification")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFShooterQualification>> listenersList = new ArrayList<ModelListener<ESFShooterQualification>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFShooterQualification>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFShooterQualificationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSHOOTERQUALIFICATION = "SELECT esfShooterQualification FROM ESFShooterQualification esfShooterQualification";
	private static final String _SQL_SELECT_ESFSHOOTERQUALIFICATION_WHERE = "SELECT esfShooterQualification FROM ESFShooterQualification esfShooterQualification WHERE ";
	private static final String _SQL_COUNT_ESFSHOOTERQUALIFICATION = "SELECT COUNT(esfShooterQualification) FROM ESFShooterQualification esfShooterQualification";
	private static final String _SQL_COUNT_ESFSHOOTERQUALIFICATION_WHERE = "SELECT COUNT(esfShooterQualification) FROM ESFShooterQualification esfShooterQualification WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfShooterQualification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFShooterQualification exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFShooterQualification exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFShooterQualificationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFShooterQualification _nullESFShooterQualification = new ESFShooterQualificationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFShooterQualification> toCacheModel() {
				return _nullESFShooterQualificationCacheModel;
			}
		};

	private static CacheModel<ESFShooterQualification> _nullESFShooterQualificationCacheModel =
		new CacheModel<ESFShooterQualification>() {
			@Override
			public ESFShooterQualification toEntityModel() {
				return _nullESFShooterQualification;
			}
		};
}