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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchPartecipantInfoException;
import it.ethica.esf.model.ESFPartecipantInfo;
import it.ethica.esf.model.impl.ESFPartecipantInfoImpl;
import it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f partecipant info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantInfoPersistence
 * @see ESFPartecipantInfoUtil
 * @generated
 */
public class ESFPartecipantInfoPersistenceImpl extends BasePersistenceImpl<ESFPartecipantInfo>
	implements ESFPartecipantInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFPartecipantInfoUtil} to access the e s f partecipant info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFPartecipantInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME_L_P =
		new FinderPath(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFirstName_L_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME_L_P =
		new FinderPath(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoModelImpl.FINDER_CACHE_ENABLED,
			ESFPartecipantInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFirstName_L_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			ESFPartecipantInfoModelImpl.FIRSTNAME_COLUMN_BITMASK |
			ESFPartecipantInfoModelImpl.LASTNAME_COLUMN_BITMASK |
			ESFPartecipantInfoModelImpl.PROTOCOL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAME_L_P = new FinderPath(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFirstName_L_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @return the matching e s f partecipant infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantInfo> findByFirstName_L_P(String firstName,
		String lastName, long protocol) throws SystemException {
		return findByFirstName_L_P(firstName, lastName, protocol,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @param start the lower bound of the range of e s f partecipant infos
	 * @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	 * @return the range of matching e s f partecipant infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantInfo> findByFirstName_L_P(String firstName,
		String lastName, long protocol, int start, int end)
		throws SystemException {
		return findByFirstName_L_P(firstName, lastName, protocol, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @param start the lower bound of the range of e s f partecipant infos
	 * @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f partecipant infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantInfo> findByFirstName_L_P(String firstName,
		String lastName, long protocol, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME_L_P;
			finderArgs = new Object[] { firstName, lastName, protocol };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME_L_P;
			finderArgs = new Object[] {
					firstName, lastName, protocol,
					
					start, end, orderByComparator
				};
		}

		List<ESFPartecipantInfo> list = (List<ESFPartecipantInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFPartecipantInfo esfPartecipantInfo : list) {
				if (!Validator.equals(firstName,
							esfPartecipantInfo.getFirstName()) ||
						!Validator.equals(lastName,
							esfPartecipantInfo.getLastName()) ||
						(protocol != esfPartecipantInfo.getProtocol())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ESFPARTECIPANTINFO_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_2);
			}

			query.append(_FINDER_COLUMN_FIRSTNAME_L_P_PROTOCOL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFPartecipantInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (bindLastName) {
					qPos.add(lastName);
				}

				qPos.add(protocol);

				if (!pagination) {
					list = (List<ESFPartecipantInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipantInfo>(list);
				}
				else {
					list = (List<ESFPartecipantInfo>)QueryUtil.list(q,
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
	 * Returns the first e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant info
	 * @throws it.ethica.esf.NoSuchPartecipantInfoException if a matching e s f partecipant info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo findByFirstName_L_P_First(String firstName,
		String lastName, long protocol, OrderByComparator orderByComparator)
		throws NoSuchPartecipantInfoException, SystemException {
		ESFPartecipantInfo esfPartecipantInfo = fetchByFirstName_L_P_First(firstName,
				lastName, protocol, orderByComparator);

		if (esfPartecipantInfo != null) {
			return esfPartecipantInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(", protocol=");
		msg.append(protocol);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantInfoException(msg.toString());
	}

	/**
	 * Returns the first e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f partecipant info, or <code>null</code> if a matching e s f partecipant info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo fetchByFirstName_L_P_First(String firstName,
		String lastName, long protocol, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFPartecipantInfo> list = findByFirstName_L_P(firstName,
				lastName, protocol, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant info
	 * @throws it.ethica.esf.NoSuchPartecipantInfoException if a matching e s f partecipant info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo findByFirstName_L_P_Last(String firstName,
		String lastName, long protocol, OrderByComparator orderByComparator)
		throws NoSuchPartecipantInfoException, SystemException {
		ESFPartecipantInfo esfPartecipantInfo = fetchByFirstName_L_P_Last(firstName,
				lastName, protocol, orderByComparator);

		if (esfPartecipantInfo != null) {
			return esfPartecipantInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(", protocol=");
		msg.append(protocol);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartecipantInfoException(msg.toString());
	}

	/**
	 * Returns the last e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f partecipant info, or <code>null</code> if a matching e s f partecipant info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo fetchByFirstName_L_P_Last(String firstName,
		String lastName, long protocol, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFirstName_L_P(firstName, lastName, protocol);

		if (count == 0) {
			return null;
		}

		List<ESFPartecipantInfo> list = findByFirstName_L_P(firstName,
				lastName, protocol, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f partecipant infos before and after the current e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * @param esfPartecipantInfoId the primary key of the current e s f partecipant info
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f partecipant info
	 * @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo[] findByFirstName_L_P_PrevAndNext(
		long esfPartecipantInfoId, String firstName, String lastName,
		long protocol, OrderByComparator orderByComparator)
		throws NoSuchPartecipantInfoException, SystemException {
		ESFPartecipantInfo esfPartecipantInfo = findByPrimaryKey(esfPartecipantInfoId);

		Session session = null;

		try {
			session = openSession();

			ESFPartecipantInfo[] array = new ESFPartecipantInfoImpl[3];

			array[0] = getByFirstName_L_P_PrevAndNext(session,
					esfPartecipantInfo, firstName, lastName, protocol,
					orderByComparator, true);

			array[1] = esfPartecipantInfo;

			array[2] = getByFirstName_L_P_PrevAndNext(session,
					esfPartecipantInfo, firstName, lastName, protocol,
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

	protected ESFPartecipantInfo getByFirstName_L_P_PrevAndNext(
		Session session, ESFPartecipantInfo esfPartecipantInfo,
		String firstName, String lastName, long protocol,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPARTECIPANTINFO_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_2);
		}

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_2);
		}

		query.append(_FINDER_COLUMN_FIRSTNAME_L_P_PROTOCOL_2);

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
			query.append(ESFPartecipantInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		if (bindLastName) {
			qPos.add(lastName);
		}

		qPos.add(protocol);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfPartecipantInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFPartecipantInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFirstName_L_P(String firstName, String lastName,
		long protocol) throws SystemException {
		for (ESFPartecipantInfo esfPartecipantInfo : findByFirstName_L_P(
				firstName, lastName, protocol, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfPartecipantInfo);
		}
	}

	/**
	 * Returns the number of e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param protocol the protocol
	 * @return the number of matching e s f partecipant infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFirstName_L_P(String firstName, String lastName,
		long protocol) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRSTNAME_L_P;

		Object[] finderArgs = new Object[] { firstName, lastName, protocol };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFPARTECIPANTINFO_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_2);
			}

			query.append(_FINDER_COLUMN_FIRSTNAME_L_P_PROTOCOL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (bindLastName) {
					qPos.add(lastName);
				}

				qPos.add(protocol);

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

	private static final String _FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_1 = "esfPartecipantInfo.firstName IS NULL AND ";
	private static final String _FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_2 = "esfPartecipantInfo.firstName = ? AND ";
	private static final String _FINDER_COLUMN_FIRSTNAME_L_P_FIRSTNAME_3 = "(esfPartecipantInfo.firstName IS NULL OR esfPartecipantInfo.firstName = '') AND ";
	private static final String _FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_1 = "esfPartecipantInfo.lastName IS NULL AND ";
	private static final String _FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_2 = "esfPartecipantInfo.lastName = ? AND ";
	private static final String _FINDER_COLUMN_FIRSTNAME_L_P_LASTNAME_3 = "(esfPartecipantInfo.lastName IS NULL OR esfPartecipantInfo.lastName = '') AND ";
	private static final String _FINDER_COLUMN_FIRSTNAME_L_P_PROTOCOL_2 = "esfPartecipantInfo.protocol = ?";

	public ESFPartecipantInfoPersistenceImpl() {
		setModelClass(ESFPartecipantInfo.class);
	}

	/**
	 * Caches the e s f partecipant info in the entity cache if it is enabled.
	 *
	 * @param esfPartecipantInfo the e s f partecipant info
	 */
	@Override
	public void cacheResult(ESFPartecipantInfo esfPartecipantInfo) {
		EntityCacheUtil.putResult(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoImpl.class, esfPartecipantInfo.getPrimaryKey(),
			esfPartecipantInfo);

		esfPartecipantInfo.resetOriginalValues();
	}

	/**
	 * Caches the e s f partecipant infos in the entity cache if it is enabled.
	 *
	 * @param esfPartecipantInfos the e s f partecipant infos
	 */
	@Override
	public void cacheResult(List<ESFPartecipantInfo> esfPartecipantInfos) {
		for (ESFPartecipantInfo esfPartecipantInfo : esfPartecipantInfos) {
			if (EntityCacheUtil.getResult(
						ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
						ESFPartecipantInfoImpl.class,
						esfPartecipantInfo.getPrimaryKey()) == null) {
				cacheResult(esfPartecipantInfo);
			}
			else {
				esfPartecipantInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f partecipant infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFPartecipantInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFPartecipantInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f partecipant info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFPartecipantInfo esfPartecipantInfo) {
		EntityCacheUtil.removeResult(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoImpl.class, esfPartecipantInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFPartecipantInfo> esfPartecipantInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFPartecipantInfo esfPartecipantInfo : esfPartecipantInfos) {
			EntityCacheUtil.removeResult(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
				ESFPartecipantInfoImpl.class, esfPartecipantInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f partecipant info with the primary key. Does not add the e s f partecipant info to the database.
	 *
	 * @param esfPartecipantInfoId the primary key for the new e s f partecipant info
	 * @return the new e s f partecipant info
	 */
	@Override
	public ESFPartecipantInfo create(long esfPartecipantInfoId) {
		ESFPartecipantInfo esfPartecipantInfo = new ESFPartecipantInfoImpl();

		esfPartecipantInfo.setNew(true);
		esfPartecipantInfo.setPrimaryKey(esfPartecipantInfoId);

		return esfPartecipantInfo;
	}

	/**
	 * Removes the e s f partecipant info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfPartecipantInfoId the primary key of the e s f partecipant info
	 * @return the e s f partecipant info that was removed
	 * @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo remove(long esfPartecipantInfoId)
		throws NoSuchPartecipantInfoException, SystemException {
		return remove((Serializable)esfPartecipantInfoId);
	}

	/**
	 * Removes the e s f partecipant info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f partecipant info
	 * @return the e s f partecipant info that was removed
	 * @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo remove(Serializable primaryKey)
		throws NoSuchPartecipantInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFPartecipantInfo esfPartecipantInfo = (ESFPartecipantInfo)session.get(ESFPartecipantInfoImpl.class,
					primaryKey);

			if (esfPartecipantInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPartecipantInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfPartecipantInfo);
		}
		catch (NoSuchPartecipantInfoException nsee) {
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
	protected ESFPartecipantInfo removeImpl(
		ESFPartecipantInfo esfPartecipantInfo) throws SystemException {
		esfPartecipantInfo = toUnwrappedModel(esfPartecipantInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfPartecipantInfo)) {
				esfPartecipantInfo = (ESFPartecipantInfo)session.get(ESFPartecipantInfoImpl.class,
						esfPartecipantInfo.getPrimaryKeyObj());
			}

			if (esfPartecipantInfo != null) {
				session.delete(esfPartecipantInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfPartecipantInfo != null) {
			clearCache(esfPartecipantInfo);
		}

		return esfPartecipantInfo;
	}

	@Override
	public ESFPartecipantInfo updateImpl(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws SystemException {
		esfPartecipantInfo = toUnwrappedModel(esfPartecipantInfo);

		boolean isNew = esfPartecipantInfo.isNew();

		ESFPartecipantInfoModelImpl esfPartecipantInfoModelImpl = (ESFPartecipantInfoModelImpl)esfPartecipantInfo;

		Session session = null;

		try {
			session = openSession();

			if (esfPartecipantInfo.isNew()) {
				session.save(esfPartecipantInfo);

				esfPartecipantInfo.setNew(false);
			}
			else {
				session.merge(esfPartecipantInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFPartecipantInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfPartecipantInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME_L_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfPartecipantInfoModelImpl.getOriginalFirstName(),
						esfPartecipantInfoModelImpl.getOriginalLastName(),
						esfPartecipantInfoModelImpl.getOriginalProtocol()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME_L_P,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME_L_P,
					args);

				args = new Object[] {
						esfPartecipantInfoModelImpl.getFirstName(),
						esfPartecipantInfoModelImpl.getLastName(),
						esfPartecipantInfoModelImpl.getProtocol()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME_L_P,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME_L_P,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
			ESFPartecipantInfoImpl.class, esfPartecipantInfo.getPrimaryKey(),
			esfPartecipantInfo);

		return esfPartecipantInfo;
	}

	protected ESFPartecipantInfo toUnwrappedModel(
		ESFPartecipantInfo esfPartecipantInfo) {
		if (esfPartecipantInfo instanceof ESFPartecipantInfoImpl) {
			return esfPartecipantInfo;
		}

		ESFPartecipantInfoImpl esfPartecipantInfoImpl = new ESFPartecipantInfoImpl();

		esfPartecipantInfoImpl.setNew(esfPartecipantInfo.isNew());
		esfPartecipantInfoImpl.setPrimaryKey(esfPartecipantInfo.getPrimaryKey());

		esfPartecipantInfoImpl.setEsfPartecipantInfoId(esfPartecipantInfo.getEsfPartecipantInfoId());
		esfPartecipantInfoImpl.setGroupId(esfPartecipantInfo.getGroupId());
		esfPartecipantInfoImpl.setCompanyId(esfPartecipantInfo.getCompanyId());
		esfPartecipantInfoImpl.setUserId(esfPartecipantInfo.getUserId());
		esfPartecipantInfoImpl.setUserName(esfPartecipantInfo.getUserName());
		esfPartecipantInfoImpl.setCreateDate(esfPartecipantInfo.getCreateDate());
		esfPartecipantInfoImpl.setModifiedDate(esfPartecipantInfo.getModifiedDate());
		esfPartecipantInfoImpl.setIsPortalUser(esfPartecipantInfo.isIsPortalUser());
		esfPartecipantInfoImpl.setEsfUserId(esfPartecipantInfo.getEsfUserId());
		esfPartecipantInfoImpl.setProtocol(esfPartecipantInfo.getProtocol());
		esfPartecipantInfoImpl.setFirstName(esfPartecipantInfo.getFirstName());
		esfPartecipantInfoImpl.setLastName(esfPartecipantInfo.getLastName());
		esfPartecipantInfoImpl.setPlaceOfBirth(esfPartecipantInfo.getPlaceOfBirth());
		esfPartecipantInfoImpl.setDateOfBirth(esfPartecipantInfo.getDateOfBirth());
		esfPartecipantInfoImpl.setResidenceCity(esfPartecipantInfo.getResidenceCity());
		esfPartecipantInfoImpl.setProvince(esfPartecipantInfo.getProvince());
		esfPartecipantInfoImpl.setZip(esfPartecipantInfo.getZip());
		esfPartecipantInfoImpl.setAddress(esfPartecipantInfo.getAddress());
		esfPartecipantInfoImpl.setPhonNumber(esfPartecipantInfo.getPhonNumber());
		esfPartecipantInfoImpl.setEmail(esfPartecipantInfo.getEmail());
		esfPartecipantInfoImpl.setMaritialStatus(esfPartecipantInfo.getMaritialStatus());
		esfPartecipantInfoImpl.setFiscalCode(esfPartecipantInfo.getFiscalCode());
		esfPartecipantInfoImpl.setPassport(esfPartecipantInfo.getPassport());
		esfPartecipantInfoImpl.setReleasedBy(esfPartecipantInfo.getReleasedBy());
		esfPartecipantInfoImpl.setPassportReleaseDate(esfPartecipantInfo.getPassportReleaseDate());
		esfPartecipantInfoImpl.setPassportExpirationDate(esfPartecipantInfo.getPassportExpirationDate());
		esfPartecipantInfoImpl.setEuropeanCardNumber(esfPartecipantInfo.getEuropeanCardNumber());
		esfPartecipantInfoImpl.setEuropeanCardReleaseDate(esfPartecipantInfo.getEuropeanCardReleaseDate());
		esfPartecipantInfoImpl.setEuropeanCardExpirationDate(esfPartecipantInfo.getEuropeanCardExpirationDate());
		esfPartecipantInfoImpl.setGunLicenceNumber(esfPartecipantInfo.getGunLicenceNumber());
		esfPartecipantInfoImpl.setGunLicenceReleaseDate(esfPartecipantInfo.getGunLicenceReleaseDate());
		esfPartecipantInfoImpl.setGunLicenceExpirationDate(esfPartecipantInfo.getGunLicenceExpirationDate());
		esfPartecipantInfoImpl.setFirstGunType(esfPartecipantInfo.getFirstGunType());
		esfPartecipantInfoImpl.setFirstGunKind(esfPartecipantInfo.getFirstGunKind());
		esfPartecipantInfoImpl.setFirstGunCaliber(esfPartecipantInfo.getFirstGunCaliber());
		esfPartecipantInfoImpl.setFirstGunCode(esfPartecipantInfo.getFirstGunCode());
		esfPartecipantInfoImpl.setFirstGunExtraCanes(esfPartecipantInfo.getFirstGunExtraCanes());
		esfPartecipantInfoImpl.setSecondGunType(esfPartecipantInfo.getSecondGunType());
		esfPartecipantInfoImpl.setSecondGunKind(esfPartecipantInfo.getSecondGunKind());
		esfPartecipantInfoImpl.setSecondGunCaliber(esfPartecipantInfo.getSecondGunCaliber());
		esfPartecipantInfoImpl.setSecondGunCode(esfPartecipantInfo.getSecondGunCode());
		esfPartecipantInfoImpl.setSecondGunExtraCanes(esfPartecipantInfo.getSecondGunExtraCanes());
		esfPartecipantInfoImpl.setGunCartridgeType(esfPartecipantInfo.getGunCartridgeType());
		esfPartecipantInfoImpl.setGunCartridgeKind(esfPartecipantInfo.getGunCartridgeKind());
		esfPartecipantInfoImpl.setCartridgeCaliber(esfPartecipantInfo.getCartridgeCaliber());
		esfPartecipantInfoImpl.setEsfMatchId(esfPartecipantInfo.getEsfMatchId());
		esfPartecipantInfoImpl.setEsfGunTypeIdOne(esfPartecipantInfo.getEsfGunTypeIdOne());
		esfPartecipantInfoImpl.setEsfGunKindIdOne(esfPartecipantInfo.getEsfGunKindIdOne());
		esfPartecipantInfoImpl.setEsfGunTypeIdTwo(esfPartecipantInfo.getEsfGunTypeIdTwo());
		esfPartecipantInfoImpl.setEsfGunKindIdTwo(esfPartecipantInfo.getEsfGunKindIdTwo());

		return esfPartecipantInfoImpl;
	}

	/**
	 * Returns the e s f partecipant info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f partecipant info
	 * @return the e s f partecipant info
	 * @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPartecipantInfoException, SystemException {
		ESFPartecipantInfo esfPartecipantInfo = fetchByPrimaryKey(primaryKey);

		if (esfPartecipantInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPartecipantInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfPartecipantInfo;
	}

	/**
	 * Returns the e s f partecipant info with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantInfoException} if it could not be found.
	 *
	 * @param esfPartecipantInfoId the primary key of the e s f partecipant info
	 * @return the e s f partecipant info
	 * @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo findByPrimaryKey(long esfPartecipantInfoId)
		throws NoSuchPartecipantInfoException, SystemException {
		return findByPrimaryKey((Serializable)esfPartecipantInfoId);
	}

	/**
	 * Returns the e s f partecipant info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f partecipant info
	 * @return the e s f partecipant info, or <code>null</code> if a e s f partecipant info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFPartecipantInfo esfPartecipantInfo = (ESFPartecipantInfo)EntityCacheUtil.getResult(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
				ESFPartecipantInfoImpl.class, primaryKey);

		if (esfPartecipantInfo == _nullESFPartecipantInfo) {
			return null;
		}

		if (esfPartecipantInfo == null) {
			Session session = null;

			try {
				session = openSession();

				esfPartecipantInfo = (ESFPartecipantInfo)session.get(ESFPartecipantInfoImpl.class,
						primaryKey);

				if (esfPartecipantInfo != null) {
					cacheResult(esfPartecipantInfo);
				}
				else {
					EntityCacheUtil.putResult(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
						ESFPartecipantInfoImpl.class, primaryKey,
						_nullESFPartecipantInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFPartecipantInfoModelImpl.ENTITY_CACHE_ENABLED,
					ESFPartecipantInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfPartecipantInfo;
	}

	/**
	 * Returns the e s f partecipant info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfPartecipantInfoId the primary key of the e s f partecipant info
	 * @return the e s f partecipant info, or <code>null</code> if a e s f partecipant info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPartecipantInfo fetchByPrimaryKey(long esfPartecipantInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfPartecipantInfoId);
	}

	/**
	 * Returns all the e s f partecipant infos.
	 *
	 * @return the e s f partecipant infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f partecipant infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f partecipant infos
	 * @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	 * @return the range of e s f partecipant infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f partecipant infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f partecipant infos
	 * @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f partecipant infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPartecipantInfo> findAll(int start, int end,
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

		List<ESFPartecipantInfo> list = (List<ESFPartecipantInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFPARTECIPANTINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFPARTECIPANTINFO;

				if (pagination) {
					sql = sql.concat(ESFPartecipantInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFPartecipantInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPartecipantInfo>(list);
				}
				else {
					list = (List<ESFPartecipantInfo>)QueryUtil.list(q,
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
	 * Removes all the e s f partecipant infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFPartecipantInfo esfPartecipantInfo : findAll()) {
			remove(esfPartecipantInfo);
		}
	}

	/**
	 * Returns the number of e s f partecipant infos.
	 *
	 * @return the number of e s f partecipant infos
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

				Query q = session.createQuery(_SQL_COUNT_ESFPARTECIPANTINFO);

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

	/**
	 * Initializes the e s f partecipant info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFPartecipantInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFPartecipantInfo>> listenersList = new ArrayList<ModelListener<ESFPartecipantInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFPartecipantInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFPartecipantInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFPARTECIPANTINFO = "SELECT esfPartecipantInfo FROM ESFPartecipantInfo esfPartecipantInfo";
	private static final String _SQL_SELECT_ESFPARTECIPANTINFO_WHERE = "SELECT esfPartecipantInfo FROM ESFPartecipantInfo esfPartecipantInfo WHERE ";
	private static final String _SQL_COUNT_ESFPARTECIPANTINFO = "SELECT COUNT(esfPartecipantInfo) FROM ESFPartecipantInfo esfPartecipantInfo";
	private static final String _SQL_COUNT_ESFPARTECIPANTINFO_WHERE = "SELECT COUNT(esfPartecipantInfo) FROM ESFPartecipantInfo esfPartecipantInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfPartecipantInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFPartecipantInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFPartecipantInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFPartecipantInfoPersistenceImpl.class);
	private static ESFPartecipantInfo _nullESFPartecipantInfo = new ESFPartecipantInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFPartecipantInfo> toCacheModel() {
				return _nullESFPartecipantInfoCacheModel;
			}
		};

	private static CacheModel<ESFPartecipantInfo> _nullESFPartecipantInfoCacheModel =
		new CacheModel<ESFPartecipantInfo>() {
			@Override
			public ESFPartecipantInfo toEntityModel() {
				return _nullESFPartecipantInfo;
			}
		};
}