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

import it.ethica.esf.NoSuchDocumentException;
import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.impl.ESFDocumentImpl;
import it.ethica.esf.model.impl.ESFDocumentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentPersistence
 * @see ESFDocumentUtil
 * @generated
 */
public class ESFDocumentPersistenceImpl extends BasePersistenceImpl<ESFDocument>
	implements ESFDocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFDocumentUtil} to access the e s f document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFDocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFDocumentModelImpl.UUID_COLUMN_BITMASK |
			ESFDocumentModelImpl.RELEASEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByUuid(String uuid, int start, int end,
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

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if (!Validator.equals(uuid, esfDocument.getUuid())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

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
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByUuid_First(uuid, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByUuid_Last(uuid, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where uuid = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByUuid_PrevAndNext(long esfDocumentId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfDocument, uuid,
					orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByUuid_PrevAndNext(session, esfDocument, uuid,
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

	protected ESFDocument getByUuid_PrevAndNext(Session session,
		ESFDocument esfDocument, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFDocument esfDocument : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f documents
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

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfDocument.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfDocument.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfDocument.uuid IS NULL OR esfDocument.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFDocumentModelImpl.UUID_COLUMN_BITMASK |
			ESFDocumentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f document where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchDocumentException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByUUID_G(uuid, groupId);

		if (esfDocument == null) {
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

			throw new NoSuchDocumentException(msg.toString());
		}

		return esfDocument;
	}

	/**
	 * Returns the e s f document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFDocument) {
			ESFDocument esfDocument = (ESFDocument)result;

			if (!Validator.equals(uuid, esfDocument.getUuid()) ||
					(groupId != esfDocument.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

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

				List<ESFDocument> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFDocument esfDocument = list.get(0);

					result = esfDocument;

					cacheResult(esfDocument);

					if ((esfDocument.getUuid() == null) ||
							!esfDocument.getUuid().equals(uuid) ||
							(esfDocument.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfDocument);
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
			return (ESFDocument)result;
		}
	}

	/**
	 * Removes the e s f document where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f document that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument removeByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByUUID_G(uuid, groupId);

		return remove(esfDocument);
	}

	/**
	 * Returns the number of e s f documents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f documents
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

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfDocument.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfDocument.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfDocument.uuid IS NULL OR esfDocument.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfDocument.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFDocumentModelImpl.UUID_COLUMN_BITMASK |
			ESFDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFDocumentModelImpl.RELEASEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByUuid_C(String uuid, long companyId,
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

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if (!Validator.equals(uuid, esfDocument.getUuid()) ||
						(companyId != esfDocument.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

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
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByUuid_C_PrevAndNext(long esfDocumentId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfDocument, uuid,
					companyId, orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByUuid_C_PrevAndNext(session, esfDocument, uuid,
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

	protected ESFDocument getByUuid_C_PrevAndNext(Session session,
		ESFDocument esfDocument, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFDocument esfDocument : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f documents
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

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfDocument.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfDocument.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfDocument.uuid IS NULL OR esfDocument.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfDocument.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUER = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIssuer",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUER =
		new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIssuer",
			new String[] { String.class.getName() },
			ESFDocumentModelImpl.ISSUER_COLUMN_BITMASK |
			ESFDocumentModelImpl.RELEASEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSUER = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssuer",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f documents where issuer = &#63;.
	 *
	 * @param issuer the issuer
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByIssuer(String issuer)
		throws SystemException {
		return findByIssuer(issuer, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where issuer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issuer the issuer
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByIssuer(String issuer, int start, int end)
		throws SystemException {
		return findByIssuer(issuer, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where issuer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issuer the issuer
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByIssuer(String issuer, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUER;
			finderArgs = new Object[] { issuer };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUER;
			finderArgs = new Object[] { issuer, start, end, orderByComparator };
		}

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if (!Validator.equals(issuer, esfDocument.getIssuer())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

			boolean bindIssuer = false;

			if (issuer == null) {
				query.append(_FINDER_COLUMN_ISSUER_ISSUER_1);
			}
			else if (issuer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ISSUER_ISSUER_3);
			}
			else {
				bindIssuer = true;

				query.append(_FINDER_COLUMN_ISSUER_ISSUER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIssuer) {
					qPos.add(issuer);
				}

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where issuer = &#63;.
	 *
	 * @param issuer the issuer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByIssuer_First(String issuer,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByIssuer_First(issuer, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issuer=");
		msg.append(issuer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where issuer = &#63;.
	 *
	 * @param issuer the issuer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByIssuer_First(String issuer,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByIssuer(issuer, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where issuer = &#63;.
	 *
	 * @param issuer the issuer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByIssuer_Last(String issuer,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByIssuer_Last(issuer, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issuer=");
		msg.append(issuer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where issuer = &#63;.
	 *
	 * @param issuer the issuer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByIssuer_Last(String issuer,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIssuer(issuer);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByIssuer(issuer, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where issuer = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param issuer the issuer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByIssuer_PrevAndNext(long esfDocumentId,
		String issuer, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByIssuer_PrevAndNext(session, esfDocument, issuer,
					orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByIssuer_PrevAndNext(session, esfDocument, issuer,
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

	protected ESFDocument getByIssuer_PrevAndNext(Session session,
		ESFDocument esfDocument, String issuer,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

		boolean bindIssuer = false;

		if (issuer == null) {
			query.append(_FINDER_COLUMN_ISSUER_ISSUER_1);
		}
		else if (issuer.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ISSUER_ISSUER_3);
		}
		else {
			bindIssuer = true;

			query.append(_FINDER_COLUMN_ISSUER_ISSUER_2);
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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIssuer) {
			qPos.add(issuer);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where issuer = &#63; from the database.
	 *
	 * @param issuer the issuer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIssuer(String issuer) throws SystemException {
		for (ESFDocument esfDocument : findByIssuer(issuer, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where issuer = &#63;.
	 *
	 * @param issuer the issuer
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIssuer(String issuer) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISSUER;

		Object[] finderArgs = new Object[] { issuer };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

			boolean bindIssuer = false;

			if (issuer == null) {
				query.append(_FINDER_COLUMN_ISSUER_ISSUER_1);
			}
			else if (issuer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ISSUER_ISSUER_3);
			}
			else {
				bindIssuer = true;

				query.append(_FINDER_COLUMN_ISSUER_ISSUER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIssuer) {
					qPos.add(issuer);
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

	private static final String _FINDER_COLUMN_ISSUER_ISSUER_1 = "esfDocument.issuer IS NULL";
	private static final String _FINDER_COLUMN_ISSUER_ISSUER_2 = "esfDocument.issuer = ?";
	private static final String _FINDER_COLUMN_ISSUER_ISSUER_3 = "(esfDocument.issuer IS NULL OR esfDocument.issuer = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONREFERENCE =
		new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocationReference",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONREFERENCE =
		new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLocationReference", new String[] { String.class.getName() },
			ESFDocumentModelImpl.LOCATIONREFERENCE_COLUMN_BITMASK |
			ESFDocumentModelImpl.RELEASEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATIONREFERENCE = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLocationReference", new String[] { String.class.getName() });

	/**
	 * Returns all the e s f documents where locationReference = &#63;.
	 *
	 * @param locationReference the location reference
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByLocationReference(String locationReference)
		throws SystemException {
		return findByLocationReference(locationReference, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where locationReference = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locationReference the location reference
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByLocationReference(String locationReference,
		int start, int end) throws SystemException {
		return findByLocationReference(locationReference, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where locationReference = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locationReference the location reference
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByLocationReference(String locationReference,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONREFERENCE;
			finderArgs = new Object[] { locationReference };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONREFERENCE;
			finderArgs = new Object[] {
					locationReference,
					
					start, end, orderByComparator
				};
		}

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if (!Validator.equals(locationReference,
							esfDocument.getLocationReference())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

			boolean bindLocationReference = false;

			if (locationReference == null) {
				query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_1);
			}
			else if (locationReference.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_3);
			}
			else {
				bindLocationReference = true;

				query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocationReference) {
					qPos.add(locationReference);
				}

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where locationReference = &#63;.
	 *
	 * @param locationReference the location reference
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByLocationReference_First(String locationReference,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByLocationReference_First(locationReference,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationReference=");
		msg.append(locationReference);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where locationReference = &#63;.
	 *
	 * @param locationReference the location reference
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByLocationReference_First(
		String locationReference, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFDocument> list = findByLocationReference(locationReference, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where locationReference = &#63;.
	 *
	 * @param locationReference the location reference
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByLocationReference_Last(String locationReference,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByLocationReference_Last(locationReference,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationReference=");
		msg.append(locationReference);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where locationReference = &#63;.
	 *
	 * @param locationReference the location reference
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByLocationReference_Last(String locationReference,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocationReference(locationReference);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByLocationReference(locationReference,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where locationReference = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param locationReference the location reference
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByLocationReference_PrevAndNext(
		long esfDocumentId, String locationReference,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByLocationReference_PrevAndNext(session, esfDocument,
					locationReference, orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByLocationReference_PrevAndNext(session, esfDocument,
					locationReference, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFDocument getByLocationReference_PrevAndNext(Session session,
		ESFDocument esfDocument, String locationReference,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

		boolean bindLocationReference = false;

		if (locationReference == null) {
			query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_1);
		}
		else if (locationReference.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_3);
		}
		else {
			bindLocationReference = true;

			query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_2);
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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLocationReference) {
			qPos.add(locationReference);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where locationReference = &#63; from the database.
	 *
	 * @param locationReference the location reference
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLocationReference(String locationReference)
		throws SystemException {
		for (ESFDocument esfDocument : findByLocationReference(
				locationReference, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where locationReference = &#63;.
	 *
	 * @param locationReference the location reference
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLocationReference(String locationReference)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCATIONREFERENCE;

		Object[] finderArgs = new Object[] { locationReference };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

			boolean bindLocationReference = false;

			if (locationReference == null) {
				query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_1);
			}
			else if (locationReference.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_3);
			}
			else {
				bindLocationReference = true;

				query.append(_FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocationReference) {
					qPos.add(locationReference);
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

	private static final String _FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_1 =
		"esfDocument.locationReference IS NULL";
	private static final String _FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_2 =
		"esfDocument.locationReference = ?";
	private static final String _FINDER_COLUMN_LOCATIONREFERENCE_LOCATIONREFERENCE_3 =
		"(esfDocument.locationReference IS NULL OR esfDocument.locationReference = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			ESFDocumentModelImpl.NAME_COLUMN_BITMASK |
			ESFDocumentModelImpl.RELEASEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f documents where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if (!Validator.equals(name, esfDocument.getName())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByName_First(name, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByName_Last(name, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where name = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByName_PrevAndNext(long esfDocumentId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByName_PrevAndNext(session, esfDocument, name,
					orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByName_PrevAndNext(session, esfDocument, name,
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

	protected ESFDocument getByName_PrevAndNext(Session session,
		ESFDocument esfDocument, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ESFDocument esfDocument : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfDocument.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfDocument.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfDocument.name IS NULL OR esfDocument.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMBER = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNumber",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER =
		new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNumber",
			new String[] { Long.class.getName() },
			ESFDocumentModelImpl.NUMBER_COLUMN_BITMASK |
			ESFDocumentModelImpl.RELEASEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBER = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumber",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f documents where number = &#63;.
	 *
	 * @param number the number
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByNumber(long number)
		throws SystemException {
		return findByNumber(number, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByNumber(long number, int start, int end)
		throws SystemException {
		return findByNumber(number, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByNumber(long number, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER;
			finderArgs = new Object[] { number };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMBER;
			finderArgs = new Object[] { number, start, end, orderByComparator };
		}

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if ((number != esfDocument.getNumber())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(number);

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByNumber_First(long number,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByNumber_First(number, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("number=");
		msg.append(number);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByNumber_First(long number,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByNumber(number, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByNumber_Last(long number,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByNumber_Last(number, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("number=");
		msg.append(number);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByNumber_Last(long number,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNumber(number);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByNumber(number, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where number = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByNumber_PrevAndNext(long esfDocumentId,
		long number, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByNumber_PrevAndNext(session, esfDocument, number,
					orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByNumber_PrevAndNext(session, esfDocument, number,
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

	protected ESFDocument getByNumber_PrevAndNext(Session session,
		ESFDocument esfDocument, long number,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);

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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(number);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where number = &#63; from the database.
	 *
	 * @param number the number
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNumber(long number) throws SystemException {
		for (ESFDocument esfDocument : findByNumber(number, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where number = &#63;.
	 *
	 * @param number the number
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNumber(long number) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMBER;

		Object[] finderArgs = new Object[] { number };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(number);

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

	private static final String _FINDER_COLUMN_NUMBER_NUMBER_2 = "esfDocument.number = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_O_O = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByO_O",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_O = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByO_O",
			new String[] { Long.class.getName(), String.class.getName() },
			ESFDocumentModelImpl.OWNERID_COLUMN_BITMASK |
			ESFDocumentModelImpl.OWNERTYPE_COLUMN_BITMASK |
			ESFDocumentModelImpl.RELEASEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_O_O = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByO_O",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the e s f documents where ownerId = &#63; and ownerType = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByO_O(long ownerId, String ownerType)
		throws SystemException {
		return findByO_O(ownerId, ownerType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where ownerId = &#63; and ownerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByO_O(long ownerId, String ownerType,
		int start, int end) throws SystemException {
		return findByO_O(ownerId, ownerType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where ownerId = &#63; and ownerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByO_O(long ownerId, String ownerType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_O;
			finderArgs = new Object[] { ownerId, ownerType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_O_O;
			finderArgs = new Object[] {
					ownerId, ownerType,
					
					start, end, orderByComparator
				};
		}

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if ((ownerId != esfDocument.getOwnerId()) ||
						!Validator.equals(ownerType, esfDocument.getOwnerType())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_O_O_OWNERID_2);

			boolean bindOwnerType = false;

			if (ownerType == null) {
				query.append(_FINDER_COLUMN_O_O_OWNERTYPE_1);
			}
			else if (ownerType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_O_OWNERTYPE_3);
			}
			else {
				bindOwnerType = true;

				query.append(_FINDER_COLUMN_O_O_OWNERTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				if (bindOwnerType) {
					qPos.add(ownerType);
				}

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByO_O_First(long ownerId, String ownerType,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByO_O_First(ownerId, ownerType,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", ownerType=");
		msg.append(ownerType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByO_O_First(long ownerId, String ownerType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByO_O(ownerId, ownerType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByO_O_Last(long ownerId, String ownerType,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByO_O_Last(ownerId, ownerType,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", ownerType=");
		msg.append(ownerType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByO_O_Last(long ownerId, String ownerType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByO_O(ownerId, ownerType);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByO_O(ownerId, ownerType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByO_O_PrevAndNext(long esfDocumentId,
		long ownerId, String ownerType, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByO_O_PrevAndNext(session, esfDocument, ownerId,
					ownerType, orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByO_O_PrevAndNext(session, esfDocument, ownerId,
					ownerType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFDocument getByO_O_PrevAndNext(Session session,
		ESFDocument esfDocument, long ownerId, String ownerType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_O_O_OWNERID_2);

		boolean bindOwnerType = false;

		if (ownerType == null) {
			query.append(_FINDER_COLUMN_O_O_OWNERTYPE_1);
		}
		else if (ownerType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_O_O_OWNERTYPE_3);
		}
		else {
			bindOwnerType = true;

			query.append(_FINDER_COLUMN_O_O_OWNERTYPE_2);
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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		if (bindOwnerType) {
			qPos.add(ownerType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where ownerId = &#63; and ownerType = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByO_O(long ownerId, String ownerType)
		throws SystemException {
		for (ESFDocument esfDocument : findByO_O(ownerId, ownerType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where ownerId = &#63; and ownerType = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param ownerType the owner type
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByO_O(long ownerId, String ownerType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_O_O;

		Object[] finderArgs = new Object[] { ownerId, ownerType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_O_O_OWNERID_2);

			boolean bindOwnerType = false;

			if (ownerType == null) {
				query.append(_FINDER_COLUMN_O_O_OWNERTYPE_1);
			}
			else if (ownerType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_O_OWNERTYPE_3);
			}
			else {
				bindOwnerType = true;

				query.append(_FINDER_COLUMN_O_O_OWNERTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				if (bindOwnerType) {
					qPos.add(ownerType);
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

	private static final String _FINDER_COLUMN_O_O_OWNERID_2 = "esfDocument.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_O_O_OWNERTYPE_1 = "esfDocument.ownerType IS NULL";
	private static final String _FINDER_COLUMN_O_O_OWNERTYPE_2 = "esfDocument.ownerType = ?";
	private static final String _FINDER_COLUMN_O_O_OWNERTYPE_3 = "(esfDocument.ownerType IS NULL OR esfDocument.ownerType = '')";

	public ESFDocumentPersistenceImpl() {
		setModelClass(ESFDocument.class);
	}

	/**
	 * Caches the e s f document in the entity cache if it is enabled.
	 *
	 * @param esfDocument the e s f document
	 */
	@Override
	public void cacheResult(ESFDocument esfDocument) {
		EntityCacheUtil.putResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentImpl.class, esfDocument.getPrimaryKey(), esfDocument);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfDocument.getUuid(), esfDocument.getGroupId() },
			esfDocument);

		esfDocument.resetOriginalValues();
	}

	/**
	 * Caches the e s f documents in the entity cache if it is enabled.
	 *
	 * @param esfDocuments the e s f documents
	 */
	@Override
	public void cacheResult(List<ESFDocument> esfDocuments) {
		for (ESFDocument esfDocument : esfDocuments) {
			if (EntityCacheUtil.getResult(
						ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
						ESFDocumentImpl.class, esfDocument.getPrimaryKey()) == null) {
				cacheResult(esfDocument);
			}
			else {
				esfDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFDocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFDocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f document.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFDocument esfDocument) {
		EntityCacheUtil.removeResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentImpl.class, esfDocument.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfDocument);
	}

	@Override
	public void clearCache(List<ESFDocument> esfDocuments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFDocument esfDocument : esfDocuments) {
			EntityCacheUtil.removeResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
				ESFDocumentImpl.class, esfDocument.getPrimaryKey());

			clearUniqueFindersCache(esfDocument);
		}
	}

	protected void cacheUniqueFindersCache(ESFDocument esfDocument) {
		if (esfDocument.isNew()) {
			Object[] args = new Object[] {
					esfDocument.getUuid(), esfDocument.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfDocument);
		}
		else {
			ESFDocumentModelImpl esfDocumentModelImpl = (ESFDocumentModelImpl)esfDocument;

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocument.getUuid(), esfDocument.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfDocument);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFDocument esfDocument) {
		ESFDocumentModelImpl esfDocumentModelImpl = (ESFDocumentModelImpl)esfDocument;

		Object[] args = new Object[] {
				esfDocument.getUuid(), esfDocument.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfDocumentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfDocumentModelImpl.getOriginalUuid(),
					esfDocumentModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f document with the primary key. Does not add the e s f document to the database.
	 *
	 * @param esfDocumentId the primary key for the new e s f document
	 * @return the new e s f document
	 */
	@Override
	public ESFDocument create(long esfDocumentId) {
		ESFDocument esfDocument = new ESFDocumentImpl();

		esfDocument.setNew(true);
		esfDocument.setPrimaryKey(esfDocumentId);

		String uuid = PortalUUIDUtil.generate();

		esfDocument.setUuid(uuid);

		return esfDocument;
	}

	/**
	 * Removes the e s f document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfDocumentId the primary key of the e s f document
	 * @return the e s f document that was removed
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument remove(long esfDocumentId)
		throws NoSuchDocumentException, SystemException {
		return remove((Serializable)esfDocumentId);
	}

	/**
	 * Removes the e s f document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f document
	 * @return the e s f document that was removed
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument remove(Serializable primaryKey)
		throws NoSuchDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFDocument esfDocument = (ESFDocument)session.get(ESFDocumentImpl.class,
					primaryKey);

			if (esfDocument == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfDocument);
		}
		catch (NoSuchDocumentException nsee) {
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
	protected ESFDocument removeImpl(ESFDocument esfDocument)
		throws SystemException {
		esfDocument = toUnwrappedModel(esfDocument);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfDocument)) {
				esfDocument = (ESFDocument)session.get(ESFDocumentImpl.class,
						esfDocument.getPrimaryKeyObj());
			}

			if (esfDocument != null) {
				session.delete(esfDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfDocument != null) {
			clearCache(esfDocument);
		}

		return esfDocument;
	}

	@Override
	public ESFDocument updateImpl(it.ethica.esf.model.ESFDocument esfDocument)
		throws SystemException {
		esfDocument = toUnwrappedModel(esfDocument);

		boolean isNew = esfDocument.isNew();

		ESFDocumentModelImpl esfDocumentModelImpl = (ESFDocumentModelImpl)esfDocument;

		if (Validator.isNull(esfDocument.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfDocument.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfDocument.isNew()) {
				session.save(esfDocument);

				esfDocument.setNew(false);
			}
			else {
				session.merge(esfDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFDocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfDocumentModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalUuid(),
						esfDocumentModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfDocumentModelImpl.getUuid(),
						esfDocumentModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalIssuer()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSUER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUER,
					args);

				args = new Object[] { esfDocumentModelImpl.getIssuer() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSUER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUER,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONREFERENCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalLocationReference()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONREFERENCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONREFERENCE,
					args);

				args = new Object[] { esfDocumentModelImpl.getLocationReference() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONREFERENCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONREFERENCE,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { esfDocumentModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER,
					args);

				args = new Object[] { esfDocumentModelImpl.getNumber() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_O.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalOwnerId(),
						esfDocumentModelImpl.getOriginalOwnerType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_O, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_O,
					args);

				args = new Object[] {
						esfDocumentModelImpl.getOwnerId(),
						esfDocumentModelImpl.getOwnerType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_O, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_O,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentImpl.class, esfDocument.getPrimaryKey(), esfDocument);

		clearUniqueFindersCache(esfDocument);
		cacheUniqueFindersCache(esfDocument);

		return esfDocument;
	}

	protected ESFDocument toUnwrappedModel(ESFDocument esfDocument) {
		if (esfDocument instanceof ESFDocumentImpl) {
			return esfDocument;
		}

		ESFDocumentImpl esfDocumentImpl = new ESFDocumentImpl();

		esfDocumentImpl.setNew(esfDocument.isNew());
		esfDocumentImpl.setPrimaryKey(esfDocument.getPrimaryKey());

		esfDocumentImpl.setUuid(esfDocument.getUuid());
		esfDocumentImpl.setEsfDocumentId(esfDocument.getEsfDocumentId());
		esfDocumentImpl.setGroupId(esfDocument.getGroupId());
		esfDocumentImpl.setCompanyId(esfDocument.getCompanyId());
		esfDocumentImpl.setUserId(esfDocument.getUserId());
		esfDocumentImpl.setUserName(esfDocument.getUserName());
		esfDocumentImpl.setCreateDate(esfDocument.getCreateDate());
		esfDocumentImpl.setModifiedDate(esfDocument.getModifiedDate());
		esfDocumentImpl.setOwnerId(esfDocument.getOwnerId());
		esfDocumentImpl.setOwnerType(esfDocument.getOwnerType());
		esfDocumentImpl.setName(esfDocument.getName());
		esfDocumentImpl.setNumber(esfDocument.getNumber());
		esfDocumentImpl.setReleaseDate(esfDocument.getReleaseDate());
		esfDocumentImpl.setExpireDate(esfDocument.getExpireDate());
		esfDocumentImpl.setIssuer(esfDocument.getIssuer());
		esfDocumentImpl.setContents(esfDocument.getContents());
		esfDocumentImpl.setLocationReference(esfDocument.getLocationReference());

		return esfDocumentImpl;
	}

	/**
	 * Returns the e s f document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f document
	 * @return the e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByPrimaryKey(primaryKey);

		if (esfDocument == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfDocument;
	}

	/**
	 * Returns the e s f document with the primary key or throws a {@link it.ethica.esf.NoSuchDocumentException} if it could not be found.
	 *
	 * @param esfDocumentId the primary key of the e s f document
	 * @return the e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByPrimaryKey(long esfDocumentId)
		throws NoSuchDocumentException, SystemException {
		return findByPrimaryKey((Serializable)esfDocumentId);
	}

	/**
	 * Returns the e s f document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f document
	 * @return the e s f document, or <code>null</code> if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFDocument esfDocument = (ESFDocument)EntityCacheUtil.getResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
				ESFDocumentImpl.class, primaryKey);

		if (esfDocument == _nullESFDocument) {
			return null;
		}

		if (esfDocument == null) {
			Session session = null;

			try {
				session = openSession();

				esfDocument = (ESFDocument)session.get(ESFDocumentImpl.class,
						primaryKey);

				if (esfDocument != null) {
					cacheResult(esfDocument);
				}
				else {
					EntityCacheUtil.putResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
						ESFDocumentImpl.class, primaryKey, _nullESFDocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
					ESFDocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfDocument;
	}

	/**
	 * Returns the e s f document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfDocumentId the primary key of the e s f document
	 * @return the e s f document, or <code>null</code> if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByPrimaryKey(long esfDocumentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfDocumentId);
	}

	/**
	 * Returns all the e s f documents.
	 *
	 * @return the e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findAll(int start, int end,
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

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFDOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFDOCUMENT;

				if (pagination) {
					sql = sql.concat(ESFDocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f documents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFDocument esfDocument : findAll()) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents.
	 *
	 * @return the number of e s f documents
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

				Query q = session.createQuery(_SQL_COUNT_ESFDOCUMENT);

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
	 * Initializes the e s f document persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFDocument")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFDocument>> listenersList = new ArrayList<ModelListener<ESFDocument>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFDocument>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFDocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFDOCUMENT = "SELECT esfDocument FROM ESFDocument esfDocument";
	private static final String _SQL_SELECT_ESFDOCUMENT_WHERE = "SELECT esfDocument FROM ESFDocument esfDocument WHERE ";
	private static final String _SQL_COUNT_ESFDOCUMENT = "SELECT COUNT(esfDocument) FROM ESFDocument esfDocument";
	private static final String _SQL_COUNT_ESFDOCUMENT_WHERE = "SELECT COUNT(esfDocument) FROM ESFDocument esfDocument WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfDocument.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFDocument exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFDocument exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFDocumentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "number"
			});
	private static ESFDocument _nullESFDocument = new ESFDocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFDocument> toCacheModel() {
				return _nullESFDocumentCacheModel;
			}
		};

	private static CacheModel<ESFDocument> _nullESFDocumentCacheModel = new CacheModel<ESFDocument>() {
			@Override
			public ESFDocument toEntityModel() {
				return _nullESFDocument;
			}
		};
}