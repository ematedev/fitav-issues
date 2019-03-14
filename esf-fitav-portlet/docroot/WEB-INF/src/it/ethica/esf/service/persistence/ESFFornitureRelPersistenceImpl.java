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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import it.ethica.esf.NoSuchFornitureRelException;
import it.ethica.esf.model.ESFFornitureRel;
import it.ethica.esf.model.impl.ESFFornitureRelImpl;
import it.ethica.esf.model.impl.ESFFornitureRelModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the e s f forniture rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureRelPersistence
 * @see ESFFornitureRelUtil
 * @generated
 */
public class ESFFornitureRelPersistenceImpl extends BasePersistenceImpl<ESFFornitureRel>
	implements ESFFornitureRelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFornitureRelUtil} to access the e s f forniture rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFornitureRelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureRelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTOOLID =
		new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureRelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFToolId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID =
		new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFToolId",
			new String[] { Long.class.getName() },
			ESFFornitureRelModelImpl.ESFTOOLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFTOOLID = new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFToolId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f forniture rels where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @return the matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByESFToolId(long esfToolId)
		throws SystemException {
		return findByESFToolId(esfToolId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f forniture rels where esfToolId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfToolId the esf tool ID
	 * @param start the lower bound of the range of e s f forniture rels
	 * @param end the upper bound of the range of e s f forniture rels (not inclusive)
	 * @return the range of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByESFToolId(long esfToolId, int start,
		int end) throws SystemException {
		return findByESFToolId(esfToolId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture rels where esfToolId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfToolId the esf tool ID
	 * @param start the lower bound of the range of e s f forniture rels
	 * @param end the upper bound of the range of e s f forniture rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByESFToolId(long esfToolId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID;
			finderArgs = new Object[] { esfToolId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTOOLID;
			finderArgs = new Object[] { esfToolId, start, end, orderByComparator };
		}

		List<ESFFornitureRel> list = (List<ESFFornitureRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFornitureRel esfFornitureRel : list) {
				if ((esfToolId != esfFornitureRel.getEsfToolId())) {
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

			query.append(_SQL_SELECT_ESFFORNITUREREL_WHERE);

			query.append(_FINDER_COLUMN_ESFTOOLID_ESFTOOLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfToolId);

				if (!pagination) {
					list = (List<ESFFornitureRel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureRel>(list);
				}
				else {
					list = (List<ESFFornitureRel>)QueryUtil.list(q,
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
	 * Returns the first e s f forniture rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel findByESFToolId_First(long esfToolId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = fetchByESFToolId_First(esfToolId,
				orderByComparator);

		if (esfFornitureRel != null) {
			return esfFornitureRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfToolId=");
		msg.append(esfToolId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureRelException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture rel, or <code>null</code> if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel fetchByESFToolId_First(long esfToolId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFornitureRel> list = findByESFToolId(esfToolId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel findByESFToolId_Last(long esfToolId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = fetchByESFToolId_Last(esfToolId,
				orderByComparator);

		if (esfFornitureRel != null) {
			return esfFornitureRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfToolId=");
		msg.append(esfToolId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureRelException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture rel, or <code>null</code> if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel fetchByESFToolId_Last(long esfToolId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFToolId(esfToolId);

		if (count == 0) {
			return null;
		}

		List<ESFFornitureRel> list = findByESFToolId(esfToolId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f forniture rels before and after the current e s f forniture rel in the ordered set where esfToolId = &#63;.
	 *
	 * @param esfFornitureRelPK the primary key of the current e s f forniture rel
	 * @param esfToolId the esf tool ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel[] findByESFToolId_PrevAndNext(
		ESFFornitureRelPK esfFornitureRelPK, long esfToolId,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = findByPrimaryKey(esfFornitureRelPK);

		Session session = null;

		try {
			session = openSession();

			ESFFornitureRel[] array = new ESFFornitureRelImpl[3];

			array[0] = getByESFToolId_PrevAndNext(session, esfFornitureRel,
					esfToolId, orderByComparator, true);

			array[1] = esfFornitureRel;

			array[2] = getByESFToolId_PrevAndNext(session, esfFornitureRel,
					esfToolId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFornitureRel getByESFToolId_PrevAndNext(Session session,
		ESFFornitureRel esfFornitureRel, long esfToolId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITUREREL_WHERE);

		query.append(_FINDER_COLUMN_ESFTOOLID_ESFTOOLID_2);

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
			query.append(ESFFornitureRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfToolId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFornitureRel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFornitureRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f forniture rels where esfToolId = &#63; from the database.
	 *
	 * @param esfToolId the esf tool ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFToolId(long esfToolId) throws SystemException {
		for (ESFFornitureRel esfFornitureRel : findByESFToolId(esfToolId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFornitureRel);
		}
	}

	/**
	 * Returns the number of e s f forniture rels where esfToolId = &#63;.
	 *
	 * @param esfToolId the esf tool ID
	 * @return the number of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFToolId(long esfToolId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFTOOLID;

		Object[] finderArgs = new Object[] { esfToolId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFORNITUREREL_WHERE);

			query.append(_FINDER_COLUMN_ESFTOOLID_ESFTOOLID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfToolId);

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

	private static final String _FINDER_COLUMN_ESFTOOLID_ESFTOOLID_2 = "esfFornitureRel.id.esfToolId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_N_P = new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureRelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByN_P",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P = new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByN_P",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFornitureRelModelImpl.CLASSNAME_COLUMN_BITMASK |
			ESFFornitureRelModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_N_P = new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_P",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f forniture rels where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByN_P(String className, long classPK)
		throws SystemException {
		return findByN_P(className, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture rels where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of e s f forniture rels
	 * @param end the upper bound of the range of e s f forniture rels (not inclusive)
	 * @return the range of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByN_P(String className, long classPK,
		int start, int end) throws SystemException {
		return findByN_P(className, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture rels where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of e s f forniture rels
	 * @param end the upper bound of the range of e s f forniture rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByN_P(String className, long classPK,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P;
			finderArgs = new Object[] { className, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_N_P;
			finderArgs = new Object[] {
					className, classPK,
					
					start, end, orderByComparator
				};
		}

		List<ESFFornitureRel> list = (List<ESFFornitureRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFornitureRel esfFornitureRel : list) {
				if (!Validator.equals(className, esfFornitureRel.getClassName()) ||
						(classPK != esfFornitureRel.getClassPK())) {
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

			query.append(_SQL_SELECT_ESFFORNITUREREL_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_N_P_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_P_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_N_P_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_N_P_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (!pagination) {
					list = (List<ESFFornitureRel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureRel>(list);
				}
				else {
					list = (List<ESFFornitureRel>)QueryUtil.list(q,
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
	 * Returns the first e s f forniture rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel findByN_P_First(String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = fetchByN_P_First(className, classPK,
				orderByComparator);

		if (esfFornitureRel != null) {
			return esfFornitureRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureRelException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture rel, or <code>null</code> if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel fetchByN_P_First(String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFornitureRel> list = findByN_P(className, classPK, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel findByN_P_Last(String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = fetchByN_P_Last(className, classPK,
				orderByComparator);

		if (esfFornitureRel != null) {
			return esfFornitureRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureRelException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture rel, or <code>null</code> if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel fetchByN_P_Last(String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByN_P(className, classPK);

		if (count == 0) {
			return null;
		}

		List<ESFFornitureRel> list = findByN_P(className, classPK, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f forniture rels before and after the current e s f forniture rel in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param esfFornitureRelPK the primary key of the current e s f forniture rel
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel[] findByN_P_PrevAndNext(
		ESFFornitureRelPK esfFornitureRelPK, String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = findByPrimaryKey(esfFornitureRelPK);

		Session session = null;

		try {
			session = openSession();

			ESFFornitureRel[] array = new ESFFornitureRelImpl[3];

			array[0] = getByN_P_PrevAndNext(session, esfFornitureRel,
					className, classPK, orderByComparator, true);

			array[1] = esfFornitureRel;

			array[2] = getByN_P_PrevAndNext(session, esfFornitureRel,
					className, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFornitureRel getByN_P_PrevAndNext(Session session,
		ESFFornitureRel esfFornitureRel, String className, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITUREREL_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_N_P_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_N_P_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_N_P_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_N_P_CLASSPK_2);

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
			query.append(ESFFornitureRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFornitureRel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFornitureRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f forniture rels where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByN_P(String className, long classPK)
		throws SystemException {
		for (ESFFornitureRel esfFornitureRel : findByN_P(className, classPK,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFornitureRel);
		}
	}

	/**
	 * Returns the number of e s f forniture rels where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByN_P(String className, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_N_P;

		Object[] finderArgs = new Object[] { className, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFFORNITUREREL_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_N_P_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_P_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_N_P_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_N_P_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_N_P_CLASSNAME_1 = "esfFornitureRel.id.className IS NULL AND ";
	private static final String _FINDER_COLUMN_N_P_CLASSNAME_2 = "esfFornitureRel.id.className = ? AND ";
	private static final String _FINDER_COLUMN_N_P_CLASSNAME_3 = "(esfFornitureRel.id.className IS NULL OR esfFornitureRel.id.className = '') AND ";
	private static final String _FINDER_COLUMN_N_P_CLASSPK_2 = "esfFornitureRel.id.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSIGNMENTDATE =
		new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureRelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAssignmentDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE =
		new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAssignmentDate",
			new String[] { Date.class.getName() },
			ESFFornitureRelModelImpl.ASSIGNMENTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSIGNMENTDATE = new FinderPath(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAssignmentDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the e s f forniture rels where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @return the matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByAssignmentDate(Date assignmentDate)
		throws SystemException {
		return findByAssignmentDate(assignmentDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture rels where assignmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assignmentDate the assignment date
	 * @param start the lower bound of the range of e s f forniture rels
	 * @param end the upper bound of the range of e s f forniture rels (not inclusive)
	 * @return the range of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByAssignmentDate(Date assignmentDate,
		int start, int end) throws SystemException {
		return findByAssignmentDate(assignmentDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture rels where assignmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assignmentDate the assignment date
	 * @param start the lower bound of the range of e s f forniture rels
	 * @param end the upper bound of the range of e s f forniture rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findByAssignmentDate(Date assignmentDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE;
			finderArgs = new Object[] { assignmentDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSIGNMENTDATE;
			finderArgs = new Object[] {
					assignmentDate,
					
					start, end, orderByComparator
				};
		}

		List<ESFFornitureRel> list = (List<ESFFornitureRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFornitureRel esfFornitureRel : list) {
				if (!Validator.equals(assignmentDate,
							esfFornitureRel.getAssignmentDate())) {
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

			query.append(_SQL_SELECT_ESFFORNITUREREL_WHERE);

			boolean bindAssignmentDate = false;

			if (assignmentDate == null) {
				query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_1);
			}
			else {
				bindAssignmentDate = true;

				query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFFornitureRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssignmentDate) {
					qPos.add(CalendarUtil.getTimestamp(assignmentDate));
				}

				if (!pagination) {
					list = (List<ESFFornitureRel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureRel>(list);
				}
				else {
					list = (List<ESFFornitureRel>)QueryUtil.list(q,
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
	 * Returns the first e s f forniture rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel findByAssignmentDate_First(Date assignmentDate,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = fetchByAssignmentDate_First(assignmentDate,
				orderByComparator);

		if (esfFornitureRel != null) {
			return esfFornitureRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assignmentDate=");
		msg.append(assignmentDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureRelException(msg.toString());
	}

	/**
	 * Returns the first e s f forniture rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f forniture rel, or <code>null</code> if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel fetchByAssignmentDate_First(Date assignmentDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFornitureRel> list = findByAssignmentDate(assignmentDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f forniture rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel findByAssignmentDate_Last(Date assignmentDate,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = fetchByAssignmentDate_Last(assignmentDate,
				orderByComparator);

		if (esfFornitureRel != null) {
			return esfFornitureRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assignmentDate=");
		msg.append(assignmentDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFornitureRelException(msg.toString());
	}

	/**
	 * Returns the last e s f forniture rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f forniture rel, or <code>null</code> if a matching e s f forniture rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel fetchByAssignmentDate_Last(Date assignmentDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAssignmentDate(assignmentDate);

		if (count == 0) {
			return null;
		}

		List<ESFFornitureRel> list = findByAssignmentDate(assignmentDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f forniture rels before and after the current e s f forniture rel in the ordered set where assignmentDate = &#63;.
	 *
	 * @param esfFornitureRelPK the primary key of the current e s f forniture rel
	 * @param assignmentDate the assignment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel[] findByAssignmentDate_PrevAndNext(
		ESFFornitureRelPK esfFornitureRelPK, Date assignmentDate,
		OrderByComparator orderByComparator)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = findByPrimaryKey(esfFornitureRelPK);

		Session session = null;

		try {
			session = openSession();

			ESFFornitureRel[] array = new ESFFornitureRelImpl[3];

			array[0] = getByAssignmentDate_PrevAndNext(session,
					esfFornitureRel, assignmentDate, orderByComparator, true);

			array[1] = esfFornitureRel;

			array[2] = getByAssignmentDate_PrevAndNext(session,
					esfFornitureRel, assignmentDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFFornitureRel getByAssignmentDate_PrevAndNext(Session session,
		ESFFornitureRel esfFornitureRel, Date assignmentDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFORNITUREREL_WHERE);

		boolean bindAssignmentDate = false;

		if (assignmentDate == null) {
			query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_1);
		}
		else {
			bindAssignmentDate = true;

			query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_2);
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
			query.append(ESFFornitureRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAssignmentDate) {
			qPos.add(CalendarUtil.getTimestamp(assignmentDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfFornitureRel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFornitureRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f forniture rels where assignmentDate = &#63; from the database.
	 *
	 * @param assignmentDate the assignment date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAssignmentDate(Date assignmentDate)
		throws SystemException {
		for (ESFFornitureRel esfFornitureRel : findByAssignmentDate(
				assignmentDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFornitureRel);
		}
	}

	/**
	 * Returns the number of e s f forniture rels where assignmentDate = &#63;.
	 *
	 * @param assignmentDate the assignment date
	 * @return the number of matching e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAssignmentDate(Date assignmentDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSIGNMENTDATE;

		Object[] finderArgs = new Object[] { assignmentDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFFORNITUREREL_WHERE);

			boolean bindAssignmentDate = false;

			if (assignmentDate == null) {
				query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_1);
			}
			else {
				bindAssignmentDate = true;

				query.append(_FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssignmentDate) {
					qPos.add(CalendarUtil.getTimestamp(assignmentDate));
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

	private static final String _FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_1 = "esfFornitureRel.assignmentDate IS NULL";
	private static final String _FINDER_COLUMN_ASSIGNMENTDATE_ASSIGNMENTDATE_2 = "esfFornitureRel.assignmentDate = ?";

	public ESFFornitureRelPersistenceImpl() {
		setModelClass(ESFFornitureRel.class);
	}

	/**
	 * Caches the e s f forniture rel in the entity cache if it is enabled.
	 *
	 * @param esfFornitureRel the e s f forniture rel
	 */
	@Override
	public void cacheResult(ESFFornitureRel esfFornitureRel) {
		EntityCacheUtil.putResult(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelImpl.class, esfFornitureRel.getPrimaryKey(),
			esfFornitureRel);

		esfFornitureRel.resetOriginalValues();
	}

	/**
	 * Caches the e s f forniture rels in the entity cache if it is enabled.
	 *
	 * @param esfFornitureRels the e s f forniture rels
	 */
	@Override
	public void cacheResult(List<ESFFornitureRel> esfFornitureRels) {
		for (ESFFornitureRel esfFornitureRel : esfFornitureRels) {
			if (EntityCacheUtil.getResult(
						ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
						ESFFornitureRelImpl.class,
						esfFornitureRel.getPrimaryKey()) == null) {
				cacheResult(esfFornitureRel);
			}
			else {
				esfFornitureRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f forniture rels.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFornitureRelImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFornitureRelImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f forniture rel.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFFornitureRel esfFornitureRel) {
		EntityCacheUtil.removeResult(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelImpl.class, esfFornitureRel.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFFornitureRel> esfFornitureRels) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFFornitureRel esfFornitureRel : esfFornitureRels) {
			EntityCacheUtil.removeResult(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
				ESFFornitureRelImpl.class, esfFornitureRel.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f forniture rel with the primary key. Does not add the e s f forniture rel to the database.
	 *
	 * @param esfFornitureRelPK the primary key for the new e s f forniture rel
	 * @return the new e s f forniture rel
	 */
	@Override
	public ESFFornitureRel create(ESFFornitureRelPK esfFornitureRelPK) {
		ESFFornitureRel esfFornitureRel = new ESFFornitureRelImpl();

		esfFornitureRel.setNew(true);
		esfFornitureRel.setPrimaryKey(esfFornitureRelPK);

		return esfFornitureRel;
	}

	/**
	 * Removes the e s f forniture rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFornitureRelPK the primary key of the e s f forniture rel
	 * @return the e s f forniture rel that was removed
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel remove(ESFFornitureRelPK esfFornitureRelPK)
		throws NoSuchFornitureRelException, SystemException {
		return remove((Serializable)esfFornitureRelPK);
	}

	/**
	 * Removes the e s f forniture rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f forniture rel
	 * @return the e s f forniture rel that was removed
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel remove(Serializable primaryKey)
		throws NoSuchFornitureRelException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFFornitureRel esfFornitureRel = (ESFFornitureRel)session.get(ESFFornitureRelImpl.class,
					primaryKey);

			if (esfFornitureRel == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFornitureRelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfFornitureRel);
		}
		catch (NoSuchFornitureRelException nsee) {
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
	protected ESFFornitureRel removeImpl(ESFFornitureRel esfFornitureRel)
		throws SystemException {
		esfFornitureRel = toUnwrappedModel(esfFornitureRel);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfFornitureRel)) {
				esfFornitureRel = (ESFFornitureRel)session.get(ESFFornitureRelImpl.class,
						esfFornitureRel.getPrimaryKeyObj());
			}

			if (esfFornitureRel != null) {
				session.delete(esfFornitureRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfFornitureRel != null) {
			clearCache(esfFornitureRel);
		}

		return esfFornitureRel;
	}

	@Override
	public ESFFornitureRel updateImpl(
		it.ethica.esf.model.ESFFornitureRel esfFornitureRel)
		throws SystemException {
		esfFornitureRel = toUnwrappedModel(esfFornitureRel);

		boolean isNew = esfFornitureRel.isNew();

		ESFFornitureRelModelImpl esfFornitureRelModelImpl = (ESFFornitureRelModelImpl)esfFornitureRel;

		Session session = null;

		try {
			session = openSession();

			if (esfFornitureRel.isNew()) {
				session.save(esfFornitureRel);

				esfFornitureRel.setNew(false);
			}
			else {
				session.merge(esfFornitureRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFFornitureRelModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFornitureRelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureRelModelImpl.getOriginalEsfToolId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTOOLID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID,
					args);

				args = new Object[] { esfFornitureRelModelImpl.getEsfToolId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTOOLID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOOLID,
					args);
			}

			if ((esfFornitureRelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureRelModelImpl.getOriginalClassName(),
						esfFornitureRelModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P,
					args);

				args = new Object[] {
						esfFornitureRelModelImpl.getClassName(),
						esfFornitureRelModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_P,
					args);
			}

			if ((esfFornitureRelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFornitureRelModelImpl.getOriginalAssignmentDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNMENTDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE,
					args);

				args = new Object[] { esfFornitureRelModelImpl.getAssignmentDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNMENTDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENTDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureRelImpl.class, esfFornitureRel.getPrimaryKey(),
			esfFornitureRel);

		return esfFornitureRel;
	}

	protected ESFFornitureRel toUnwrappedModel(ESFFornitureRel esfFornitureRel) {
		if (esfFornitureRel instanceof ESFFornitureRelImpl) {
			return esfFornitureRel;
		}

		ESFFornitureRelImpl esfFornitureRelImpl = new ESFFornitureRelImpl();

		esfFornitureRelImpl.setNew(esfFornitureRel.isNew());
		esfFornitureRelImpl.setPrimaryKey(esfFornitureRel.getPrimaryKey());

		esfFornitureRelImpl.setEsfToolId(esfFornitureRel.getEsfToolId());
		esfFornitureRelImpl.setClassName(esfFornitureRel.getClassName());
		esfFornitureRelImpl.setClassPK(esfFornitureRel.getClassPK());
		esfFornitureRelImpl.setGroupId(esfFornitureRel.getGroupId());
		esfFornitureRelImpl.setCompanyId(esfFornitureRel.getCompanyId());
		esfFornitureRelImpl.setUserId(esfFornitureRel.getUserId());
		esfFornitureRelImpl.setUserName(esfFornitureRel.getUserName());
		esfFornitureRelImpl.setCreateDate(esfFornitureRel.getCreateDate());
		esfFornitureRelImpl.setModifiedDate(esfFornitureRel.getModifiedDate());
		esfFornitureRelImpl.setAssignmentDate(esfFornitureRel.getAssignmentDate());

		return esfFornitureRelImpl;
	}

	/**
	 * Returns the e s f forniture rel with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f forniture rel
	 * @return the e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFornitureRelException, SystemException {
		ESFFornitureRel esfFornitureRel = fetchByPrimaryKey(primaryKey);

		if (esfFornitureRel == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFornitureRelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfFornitureRel;
	}

	/**
	 * Returns the e s f forniture rel with the primary key or throws a {@link it.ethica.esf.NoSuchFornitureRelException} if it could not be found.
	 *
	 * @param esfFornitureRelPK the primary key of the e s f forniture rel
	 * @return the e s f forniture rel
	 * @throws it.ethica.esf.NoSuchFornitureRelException if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel findByPrimaryKey(ESFFornitureRelPK esfFornitureRelPK)
		throws NoSuchFornitureRelException, SystemException {
		return findByPrimaryKey((Serializable)esfFornitureRelPK);
	}

	/**
	 * Returns the e s f forniture rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f forniture rel
	 * @return the e s f forniture rel, or <code>null</code> if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFFornitureRel esfFornitureRel = (ESFFornitureRel)EntityCacheUtil.getResult(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
				ESFFornitureRelImpl.class, primaryKey);

		if (esfFornitureRel == _nullESFFornitureRel) {
			return null;
		}

		if (esfFornitureRel == null) {
			Session session = null;

			try {
				session = openSession();

				esfFornitureRel = (ESFFornitureRel)session.get(ESFFornitureRelImpl.class,
						primaryKey);

				if (esfFornitureRel != null) {
					cacheResult(esfFornitureRel);
				}
				else {
					EntityCacheUtil.putResult(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
						ESFFornitureRelImpl.class, primaryKey,
						_nullESFFornitureRel);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFornitureRelModelImpl.ENTITY_CACHE_ENABLED,
					ESFFornitureRelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfFornitureRel;
	}

	/**
	 * Returns the e s f forniture rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFornitureRelPK the primary key of the e s f forniture rel
	 * @return the e s f forniture rel, or <code>null</code> if a e s f forniture rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureRel fetchByPrimaryKey(
		ESFFornitureRelPK esfFornitureRelPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFornitureRelPK);
	}

	/**
	 * Returns all the e s f forniture rels.
	 *
	 * @return the e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f forniture rels
	 * @param end the upper bound of the range of e s f forniture rels (not inclusive)
	 * @return the range of e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f forniture rels
	 * @param end the upper bound of the range of e s f forniture rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f forniture rels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureRel> findAll(int start, int end,
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

		List<ESFFornitureRel> list = (List<ESFFornitureRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFORNITUREREL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFORNITUREREL;

				if (pagination) {
					sql = sql.concat(ESFFornitureRelModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFFornitureRel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureRel>(list);
				}
				else {
					list = (List<ESFFornitureRel>)QueryUtil.list(q,
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
	 * Removes all the e s f forniture rels from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFFornitureRel esfFornitureRel : findAll()) {
			remove(esfFornitureRel);
		}
	}

	/**
	 * Returns the number of e s f forniture rels.
	 *
	 * @return the number of e s f forniture rels
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

				Query q = session.createQuery(_SQL_COUNT_ESFFORNITUREREL);

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
	 * Initializes the e s f forniture rel persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFFornitureRel")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFFornitureRel>> listenersList = new ArrayList<ModelListener<ESFFornitureRel>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFFornitureRel>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFornitureRelImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFORNITUREREL = "SELECT esfFornitureRel FROM ESFFornitureRel esfFornitureRel";
	private static final String _SQL_SELECT_ESFFORNITUREREL_WHERE = "SELECT esfFornitureRel FROM ESFFornitureRel esfFornitureRel WHERE ";
	private static final String _SQL_COUNT_ESFFORNITUREREL = "SELECT COUNT(esfFornitureRel) FROM ESFFornitureRel esfFornitureRel";
	private static final String _SQL_COUNT_ESFFORNITUREREL_WHERE = "SELECT COUNT(esfFornitureRel) FROM ESFFornitureRel esfFornitureRel WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfFornitureRel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFFornitureRel exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFFornitureRel exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFornitureRelPersistenceImpl.class);
	private static ESFFornitureRel _nullESFFornitureRel = new ESFFornitureRelImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFFornitureRel> toCacheModel() {
				return _nullESFFornitureRelCacheModel;
			}
		};

	private static CacheModel<ESFFornitureRel> _nullESFFornitureRelCacheModel = new CacheModel<ESFFornitureRel>() {
			@Override
			public ESFFornitureRel toEntityModel() {
				return _nullESFFornitureRel;
			}
		};
}