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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchUserCategoryException;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.model.impl.ESFUserCategoryImpl;
import it.ethica.esf.model.impl.ESFUserCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f user category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserCategoryPersistence
 * @see ESFUserCategoryUtil
 * @generated
 */
public class ESFUserCategoryPersistenceImpl extends BasePersistenceImpl<ESFUserCategory>
	implements ESFUserCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFUserCategoryUtil} to access the e s f user category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFUserCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryModelImpl.FINDER_CACHE_ENABLED,
			ESFUserCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryModelImpl.FINDER_CACHE_ENABLED,
			ESFUserCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFCATEGORYID =
		new FinderPath(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryModelImpl.FINDER_CACHE_ENABLED,
			ESFUserCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByesfCategoryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFCATEGORYID =
		new FinderPath(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryModelImpl.FINDER_CACHE_ENABLED,
			ESFUserCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesfCategoryId",
			new String[] { Long.class.getName() },
			ESFUserCategoryModelImpl.ESFCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFCATEGORYID = new FinderPath(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByesfCategoryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user categories where esfCategoryId = &#63;.
	 *
	 * @param esfCategoryId the esf category ID
	 * @return the matching e s f user categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserCategory> findByesfCategoryId(long esfCategoryId)
		throws SystemException {
		return findByesfCategoryId(esfCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user categories where esfCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfCategoryId the esf category ID
	 * @param start the lower bound of the range of e s f user categories
	 * @param end the upper bound of the range of e s f user categories (not inclusive)
	 * @return the range of matching e s f user categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserCategory> findByesfCategoryId(long esfCategoryId,
		int start, int end) throws SystemException {
		return findByesfCategoryId(esfCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user categories where esfCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfCategoryId the esf category ID
	 * @param start the lower bound of the range of e s f user categories
	 * @param end the upper bound of the range of e s f user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserCategory> findByesfCategoryId(long esfCategoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFCATEGORYID;
			finderArgs = new Object[] { esfCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFCATEGORYID;
			finderArgs = new Object[] {
					esfCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<ESFUserCategory> list = (List<ESFUserCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserCategory esfUserCategory : list) {
				if ((esfCategoryId != esfUserCategory.getEsfCategoryId())) {
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

			query.append(_SQL_SELECT_ESFUSERCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_ESFCATEGORYID_ESFCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfCategoryId);

				if (!pagination) {
					list = (List<ESFUserCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserCategory>(list);
				}
				else {
					list = (List<ESFUserCategory>)QueryUtil.list(q,
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
	 * Returns the first e s f user category in the ordered set where esfCategoryId = &#63;.
	 *
	 * @param esfCategoryId the esf category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user category
	 * @throws it.ethica.esf.NoSuchUserCategoryException if a matching e s f user category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory findByesfCategoryId_First(long esfCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCategoryException, SystemException {
		ESFUserCategory esfUserCategory = fetchByesfCategoryId_First(esfCategoryId,
				orderByComparator);

		if (esfUserCategory != null) {
			return esfUserCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfCategoryId=");
		msg.append(esfCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCategoryException(msg.toString());
	}

	/**
	 * Returns the first e s f user category in the ordered set where esfCategoryId = &#63;.
	 *
	 * @param esfCategoryId the esf category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory fetchByesfCategoryId_First(long esfCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserCategory> list = findByesfCategoryId(esfCategoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user category in the ordered set where esfCategoryId = &#63;.
	 *
	 * @param esfCategoryId the esf category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user category
	 * @throws it.ethica.esf.NoSuchUserCategoryException if a matching e s f user category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory findByesfCategoryId_Last(long esfCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCategoryException, SystemException {
		ESFUserCategory esfUserCategory = fetchByesfCategoryId_Last(esfCategoryId,
				orderByComparator);

		if (esfUserCategory != null) {
			return esfUserCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfCategoryId=");
		msg.append(esfCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCategoryException(msg.toString());
	}

	/**
	 * Returns the last e s f user category in the ordered set where esfCategoryId = &#63;.
	 *
	 * @param esfCategoryId the esf category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory fetchByesfCategoryId_Last(long esfCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByesfCategoryId(esfCategoryId);

		if (count == 0) {
			return null;
		}

		List<ESFUserCategory> list = findByesfCategoryId(esfCategoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user categories before and after the current e s f user category in the ordered set where esfCategoryId = &#63;.
	 *
	 * @param esfUserCategoryId the primary key of the current e s f user category
	 * @param esfCategoryId the esf category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user category
	 * @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory[] findByesfCategoryId_PrevAndNext(
		long esfUserCategoryId, long esfCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCategoryException, SystemException {
		ESFUserCategory esfUserCategory = findByPrimaryKey(esfUserCategoryId);

		Session session = null;

		try {
			session = openSession();

			ESFUserCategory[] array = new ESFUserCategoryImpl[3];

			array[0] = getByesfCategoryId_PrevAndNext(session, esfUserCategory,
					esfCategoryId, orderByComparator, true);

			array[1] = esfUserCategory;

			array[2] = getByesfCategoryId_PrevAndNext(session, esfUserCategory,
					esfCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFUserCategory getByesfCategoryId_PrevAndNext(Session session,
		ESFUserCategory esfUserCategory, long esfCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_ESFCATEGORYID_ESFCATEGORYID_2);

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
			query.append(ESFUserCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user categories where esfCategoryId = &#63; from the database.
	 *
	 * @param esfCategoryId the esf category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfCategoryId(long esfCategoryId)
		throws SystemException {
		for (ESFUserCategory esfUserCategory : findByesfCategoryId(
				esfCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserCategory);
		}
	}

	/**
	 * Returns the number of e s f user categories where esfCategoryId = &#63;.
	 *
	 * @param esfCategoryId the esf category ID
	 * @return the number of matching e s f user categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfCategoryId(long esfCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFCATEGORYID;

		Object[] finderArgs = new Object[] { esfCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_ESFCATEGORYID_ESFCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfCategoryId);

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

	private static final String _FINDER_COLUMN_ESFCATEGORYID_ESFCATEGORYID_2 = "esfUserCategory.esfCategoryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_U_C_S = new FinderPath(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryModelImpl.FINDER_CACHE_ENABLED,
			ESFUserCategoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByU_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFUserCategoryModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFUserCategoryModelImpl.ESFCATEGORYID_COLUMN_BITMASK |
			ESFUserCategoryModelImpl.ESFSPORTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_C_S = new FinderPath(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the e s f user category where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63; or throws a {@link it.ethica.esf.NoSuchUserCategoryException} if it could not be found.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfCategoryId the esf category ID
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f user category
	 * @throws it.ethica.esf.NoSuchUserCategoryException if a matching e s f user category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory findByU_C_S(long esfUserId, long esfCategoryId,
		long esfSportTypeId)
		throws NoSuchUserCategoryException, SystemException {
		ESFUserCategory esfUserCategory = fetchByU_C_S(esfUserId,
				esfCategoryId, esfSportTypeId);

		if (esfUserCategory == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfUserId=");
			msg.append(esfUserId);

			msg.append(", esfCategoryId=");
			msg.append(esfCategoryId);

			msg.append(", esfSportTypeId=");
			msg.append(esfSportTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserCategoryException(msg.toString());
		}

		return esfUserCategory;
	}

	/**
	 * Returns the e s f user category where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfCategoryId the esf category ID
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory fetchByU_C_S(long esfUserId, long esfCategoryId,
		long esfSportTypeId) throws SystemException {
		return fetchByU_C_S(esfUserId, esfCategoryId, esfSportTypeId, true);
	}

	/**
	 * Returns the e s f user category where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfCategoryId the esf category ID
	 * @param esfSportTypeId the esf sport type ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory fetchByU_C_S(long esfUserId, long esfCategoryId,
		long esfSportTypeId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				esfUserId, esfCategoryId, esfSportTypeId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_U_C_S,
					finderArgs, this);
		}

		if (result instanceof ESFUserCategory) {
			ESFUserCategory esfUserCategory = (ESFUserCategory)result;

			if ((esfUserId != esfUserCategory.getEsfUserId()) ||
					(esfCategoryId != esfUserCategory.getEsfCategoryId()) ||
					(esfSportTypeId != esfUserCategory.getEsfSportTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ESFUSERCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_U_C_S_ESFUSERID_2);

			query.append(_FINDER_COLUMN_U_C_S_ESFCATEGORYID_2);

			query.append(_FINDER_COLUMN_U_C_S_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfCategoryId);

				qPos.add(esfSportTypeId);

				List<ESFUserCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_C_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserCategoryPersistenceImpl.fetchByU_C_S(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUserCategory esfUserCategory = list.get(0);

					result = esfUserCategory;

					cacheResult(esfUserCategory);

					if ((esfUserCategory.getEsfUserId() != esfUserId) ||
							(esfUserCategory.getEsfCategoryId() != esfCategoryId) ||
							(esfUserCategory.getEsfSportTypeId() != esfSportTypeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_C_S,
							finderArgs, esfUserCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_C_S,
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
			return (ESFUserCategory)result;
		}
	}

	/**
	 * Removes the e s f user category where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfCategoryId the esf category ID
	 * @param esfSportTypeId the esf sport type ID
	 * @return the e s f user category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory removeByU_C_S(long esfUserId, long esfCategoryId,
		long esfSportTypeId)
		throws NoSuchUserCategoryException, SystemException {
		ESFUserCategory esfUserCategory = findByU_C_S(esfUserId, esfCategoryId,
				esfSportTypeId);

		return remove(esfUserCategory);
	}

	/**
	 * Returns the number of e s f user categories where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfCategoryId the esf category ID
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f user categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByU_C_S(long esfUserId, long esfCategoryId,
		long esfSportTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_C_S;

		Object[] finderArgs = new Object[] {
				esfUserId, esfCategoryId, esfSportTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFUSERCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_U_C_S_ESFUSERID_2);

			query.append(_FINDER_COLUMN_U_C_S_ESFCATEGORYID_2);

			query.append(_FINDER_COLUMN_U_C_S_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfCategoryId);

				qPos.add(esfSportTypeId);

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

	private static final String _FINDER_COLUMN_U_C_S_ESFUSERID_2 = "esfUserCategory.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_U_C_S_ESFCATEGORYID_2 = "esfUserCategory.esfCategoryId = ? AND ";
	private static final String _FINDER_COLUMN_U_C_S_ESFSPORTTYPEID_2 = "esfUserCategory.esfSportTypeId = ?";

	public ESFUserCategoryPersistenceImpl() {
		setModelClass(ESFUserCategory.class);
	}

	/**
	 * Caches the e s f user category in the entity cache if it is enabled.
	 *
	 * @param esfUserCategory the e s f user category
	 */
	@Override
	public void cacheResult(ESFUserCategory esfUserCategory) {
		EntityCacheUtil.putResult(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryImpl.class, esfUserCategory.getPrimaryKey(),
			esfUserCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_C_S,
			new Object[] {
				esfUserCategory.getEsfUserId(),
				esfUserCategory.getEsfCategoryId(),
				esfUserCategory.getEsfSportTypeId()
			}, esfUserCategory);

		esfUserCategory.resetOriginalValues();
	}

	/**
	 * Caches the e s f user categories in the entity cache if it is enabled.
	 *
	 * @param esfUserCategories the e s f user categories
	 */
	@Override
	public void cacheResult(List<ESFUserCategory> esfUserCategories) {
		for (ESFUserCategory esfUserCategory : esfUserCategories) {
			if (EntityCacheUtil.getResult(
						ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserCategoryImpl.class,
						esfUserCategory.getPrimaryKey()) == null) {
				cacheResult(esfUserCategory);
			}
			else {
				esfUserCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f user categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFUserCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFUserCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f user category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFUserCategory esfUserCategory) {
		EntityCacheUtil.removeResult(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryImpl.class, esfUserCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfUserCategory);
	}

	@Override
	public void clearCache(List<ESFUserCategory> esfUserCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFUserCategory esfUserCategory : esfUserCategories) {
			EntityCacheUtil.removeResult(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserCategoryImpl.class, esfUserCategory.getPrimaryKey());

			clearUniqueFindersCache(esfUserCategory);
		}
	}

	protected void cacheUniqueFindersCache(ESFUserCategory esfUserCategory) {
		if (esfUserCategory.isNew()) {
			Object[] args = new Object[] {
					esfUserCategory.getEsfUserId(),
					esfUserCategory.getEsfCategoryId(),
					esfUserCategory.getEsfSportTypeId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_C_S, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_C_S, args,
				esfUserCategory);
		}
		else {
			ESFUserCategoryModelImpl esfUserCategoryModelImpl = (ESFUserCategoryModelImpl)esfUserCategory;

			if ((esfUserCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_U_C_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserCategory.getEsfUserId(),
						esfUserCategory.getEsfCategoryId(),
						esfUserCategory.getEsfSportTypeId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_C_S, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_C_S, args,
					esfUserCategory);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFUserCategory esfUserCategory) {
		ESFUserCategoryModelImpl esfUserCategoryModelImpl = (ESFUserCategoryModelImpl)esfUserCategory;

		Object[] args = new Object[] {
				esfUserCategory.getEsfUserId(),
				esfUserCategory.getEsfCategoryId(),
				esfUserCategory.getEsfSportTypeId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_C_S, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_C_S, args);

		if ((esfUserCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_U_C_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfUserCategoryModelImpl.getOriginalEsfUserId(),
					esfUserCategoryModelImpl.getOriginalEsfCategoryId(),
					esfUserCategoryModelImpl.getOriginalEsfSportTypeId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_C_S, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_C_S, args);
		}
	}

	/**
	 * Creates a new e s f user category with the primary key. Does not add the e s f user category to the database.
	 *
	 * @param esfUserCategoryId the primary key for the new e s f user category
	 * @return the new e s f user category
	 */
	@Override
	public ESFUserCategory create(long esfUserCategoryId) {
		ESFUserCategory esfUserCategory = new ESFUserCategoryImpl();

		esfUserCategory.setNew(true);
		esfUserCategory.setPrimaryKey(esfUserCategoryId);

		return esfUserCategory;
	}

	/**
	 * Removes the e s f user category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserCategoryId the primary key of the e s f user category
	 * @return the e s f user category that was removed
	 * @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory remove(long esfUserCategoryId)
		throws NoSuchUserCategoryException, SystemException {
		return remove((Serializable)esfUserCategoryId);
	}

	/**
	 * Removes the e s f user category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f user category
	 * @return the e s f user category that was removed
	 * @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory remove(Serializable primaryKey)
		throws NoSuchUserCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFUserCategory esfUserCategory = (ESFUserCategory)session.get(ESFUserCategoryImpl.class,
					primaryKey);

			if (esfUserCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfUserCategory);
		}
		catch (NoSuchUserCategoryException nsee) {
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
	protected ESFUserCategory removeImpl(ESFUserCategory esfUserCategory)
		throws SystemException {
		esfUserCategory = toUnwrappedModel(esfUserCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfUserCategory)) {
				esfUserCategory = (ESFUserCategory)session.get(ESFUserCategoryImpl.class,
						esfUserCategory.getPrimaryKeyObj());
			}

			if (esfUserCategory != null) {
				session.delete(esfUserCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfUserCategory != null) {
			clearCache(esfUserCategory);
		}

		return esfUserCategory;
	}

	@Override
	public ESFUserCategory updateImpl(
		it.ethica.esf.model.ESFUserCategory esfUserCategory)
		throws SystemException {
		esfUserCategory = toUnwrappedModel(esfUserCategory);

		boolean isNew = esfUserCategory.isNew();

		ESFUserCategoryModelImpl esfUserCategoryModelImpl = (ESFUserCategoryModelImpl)esfUserCategory;

		Session session = null;

		try {
			session = openSession();

			if (esfUserCategory.isNew()) {
				session.save(esfUserCategory);

				esfUserCategory.setNew(false);
			}
			else {
				session.merge(esfUserCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFUserCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfUserCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserCategoryModelImpl.getOriginalEsfCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFCATEGORYID,
					args);

				args = new Object[] { esfUserCategoryModelImpl.getEsfCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFCATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserCategoryImpl.class, esfUserCategory.getPrimaryKey(),
			esfUserCategory);

		clearUniqueFindersCache(esfUserCategory);
		cacheUniqueFindersCache(esfUserCategory);

		return esfUserCategory;
	}

	protected ESFUserCategory toUnwrappedModel(ESFUserCategory esfUserCategory) {
		if (esfUserCategory instanceof ESFUserCategoryImpl) {
			return esfUserCategory;
		}

		ESFUserCategoryImpl esfUserCategoryImpl = new ESFUserCategoryImpl();

		esfUserCategoryImpl.setNew(esfUserCategory.isNew());
		esfUserCategoryImpl.setPrimaryKey(esfUserCategory.getPrimaryKey());

		esfUserCategoryImpl.setEsfUserCategoryId(esfUserCategory.getEsfUserCategoryId());
		esfUserCategoryImpl.setGroupId(esfUserCategory.getGroupId());
		esfUserCategoryImpl.setCompanyId(esfUserCategory.getCompanyId());
		esfUserCategoryImpl.setUserId(esfUserCategory.getUserId());
		esfUserCategoryImpl.setUserName(esfUserCategory.getUserName());
		esfUserCategoryImpl.setCreateDate(esfUserCategory.getCreateDate());
		esfUserCategoryImpl.setModifiedDate(esfUserCategory.getModifiedDate());
		esfUserCategoryImpl.setEsfUserId(esfUserCategory.getEsfUserId());
		esfUserCategoryImpl.setStartDate(esfUserCategory.getStartDate());
		esfUserCategoryImpl.setEndDate(esfUserCategory.getEndDate());
		esfUserCategoryImpl.setEsfCategoryId(esfUserCategory.getEsfCategoryId());
		esfUserCategoryImpl.setEsfSportTypeId(esfUserCategory.getEsfSportTypeId());

		return esfUserCategoryImpl;
	}

	/**
	 * Returns the e s f user category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user category
	 * @return the e s f user category
	 * @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserCategoryException, SystemException {
		ESFUserCategory esfUserCategory = fetchByPrimaryKey(primaryKey);

		if (esfUserCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfUserCategory;
	}

	/**
	 * Returns the e s f user category with the primary key or throws a {@link it.ethica.esf.NoSuchUserCategoryException} if it could not be found.
	 *
	 * @param esfUserCategoryId the primary key of the e s f user category
	 * @return the e s f user category
	 * @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory findByPrimaryKey(long esfUserCategoryId)
		throws NoSuchUserCategoryException, SystemException {
		return findByPrimaryKey((Serializable)esfUserCategoryId);
	}

	/**
	 * Returns the e s f user category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user category
	 * @return the e s f user category, or <code>null</code> if a e s f user category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFUserCategory esfUserCategory = (ESFUserCategory)EntityCacheUtil.getResult(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserCategoryImpl.class, primaryKey);

		if (esfUserCategory == _nullESFUserCategory) {
			return null;
		}

		if (esfUserCategory == null) {
			Session session = null;

			try {
				session = openSession();

				esfUserCategory = (ESFUserCategory)session.get(ESFUserCategoryImpl.class,
						primaryKey);

				if (esfUserCategory != null) {
					cacheResult(esfUserCategory);
				}
				else {
					EntityCacheUtil.putResult(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserCategoryImpl.class, primaryKey,
						_nullESFUserCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFUserCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ESFUserCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfUserCategory;
	}

	/**
	 * Returns the e s f user category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfUserCategoryId the primary key of the e s f user category
	 * @return the e s f user category, or <code>null</code> if a e s f user category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserCategory fetchByPrimaryKey(long esfUserCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfUserCategoryId);
	}

	/**
	 * Returns all the e s f user categories.
	 *
	 * @return the e s f user categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user categories
	 * @param end the upper bound of the range of e s f user categories (not inclusive)
	 * @return the range of e s f user categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user categories
	 * @param end the upper bound of the range of e s f user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f user categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserCategory> findAll(int start, int end,
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

		List<ESFUserCategory> list = (List<ESFUserCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFUSERCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFUSERCATEGORY;

				if (pagination) {
					sql = sql.concat(ESFUserCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFUserCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserCategory>(list);
				}
				else {
					list = (List<ESFUserCategory>)QueryUtil.list(q,
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
	 * Removes all the e s f user categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFUserCategory esfUserCategory : findAll()) {
			remove(esfUserCategory);
		}
	}

	/**
	 * Returns the number of e s f user categories.
	 *
	 * @return the number of e s f user categories
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

				Query q = session.createQuery(_SQL_COUNT_ESFUSERCATEGORY);

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
	 * Initializes the e s f user category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFUserCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFUserCategory>> listenersList = new ArrayList<ModelListener<ESFUserCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFUserCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFUserCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFUSERCATEGORY = "SELECT esfUserCategory FROM ESFUserCategory esfUserCategory";
	private static final String _SQL_SELECT_ESFUSERCATEGORY_WHERE = "SELECT esfUserCategory FROM ESFUserCategory esfUserCategory WHERE ";
	private static final String _SQL_COUNT_ESFUSERCATEGORY = "SELECT COUNT(esfUserCategory) FROM ESFUserCategory esfUserCategory";
	private static final String _SQL_COUNT_ESFUSERCATEGORY_WHERE = "SELECT COUNT(esfUserCategory) FROM ESFUserCategory esfUserCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfUserCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFUserCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFUserCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFUserCategoryPersistenceImpl.class);
	private static ESFUserCategory _nullESFUserCategory = new ESFUserCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFUserCategory> toCacheModel() {
				return _nullESFUserCategoryCacheModel;
			}
		};

	private static CacheModel<ESFUserCategory> _nullESFUserCategoryCacheModel = new CacheModel<ESFUserCategory>() {
			@Override
			public ESFUserCategory toEntityModel() {
				return _nullESFUserCategory;
			}
		};
}