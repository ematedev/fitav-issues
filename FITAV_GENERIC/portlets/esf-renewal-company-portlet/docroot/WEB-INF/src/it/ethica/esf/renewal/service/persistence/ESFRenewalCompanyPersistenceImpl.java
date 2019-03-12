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

package it.ethica.esf.renewal.service.persistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;
import it.ethica.esf.renewal.model.ESFRenewalCompany;
import it.ethica.esf.renewal.model.impl.ESFRenewalCompanyImpl;
import it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f renewal company service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRenewalCompanyPersistence
 * @see ESFRenewalCompanyUtil
 * @generated
 */
public class ESFRenewalCompanyPersistenceImpl extends BasePersistenceImpl<ESFRenewalCompany>
	implements ESFRenewalCompanyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRenewalCompanyUtil} to access the e s f renewal company persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRenewalCompanyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ESFRenewalCompanyModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the e s f renewal companies where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByStatus(int status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewal companies where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @return the range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewal companies where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<ESFRenewalCompany> list = (List<ESFRenewalCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewalCompany esfRenewalCompany : list) {
				if ((status != esfRenewalCompany.getStatus())) {
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

			query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewalCompany>(list);
				}
				else {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
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
	 * Returns the first e s f renewal company in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByStatus_First(status,
				orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal company in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRenewalCompany> list = findByStatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByStatus_Last(status,
				orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ESFRenewalCompany> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where status = &#63;.
	 *
	 * @param esfRenewalCompanyId the primary key of the current e s f renewal company
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany[] findByStatus_PrevAndNext(
		long esfRenewalCompanyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = findByPrimaryKey(esfRenewalCompanyId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewalCompany[] array = new ESFRenewalCompanyImpl[3];

			array[0] = getByStatus_PrevAndNext(session, esfRenewalCompany,
					status, orderByComparator, true);

			array[1] = esfRenewalCompany;

			array[2] = getByStatus_PrevAndNext(session, esfRenewalCompany,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewalCompany getByStatus_PrevAndNext(Session session,
		ESFRenewalCompany esfRenewalCompany, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewalCompany);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewalCompany> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewal companies where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (ESFRenewalCompany esfRenewalCompany : findByStatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewalCompany);
		}
	}

	/**
	 * Returns the number of e s f renewal companies where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "esfRenewalCompany.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYear",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] { Integer.class.getName() },
			ESFRenewalCompanyModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the e s f renewal companies where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByYear(int year)
		throws SystemException {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewal companies where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @return the range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByYear(int year, int start, int end)
		throws SystemException {
		return findByYear(year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewal companies where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByYear(int year, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year, start, end, orderByComparator };
		}

		List<ESFRenewalCompany> list = (List<ESFRenewalCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewalCompany esfRenewalCompany : list) {
				if ((year != esfRenewalCompany.getYear())) {
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

			query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				if (!pagination) {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewalCompany>(list);
				}
				else {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
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
	 * Returns the first e s f renewal company in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByYear_First(int year,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByYear_First(year,
				orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal company in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByYear_First(int year,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRenewalCompany> list = findByYear(year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByYear_Last(int year,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByYear_Last(year,
				orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByYear_Last(int year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYear(year);

		if (count == 0) {
			return null;
		}

		List<ESFRenewalCompany> list = findByYear(year, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where year = &#63;.
	 *
	 * @param esfRenewalCompanyId the primary key of the current e s f renewal company
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany[] findByYear_PrevAndNext(
		long esfRenewalCompanyId, int year, OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = findByPrimaryKey(esfRenewalCompanyId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewalCompany[] array = new ESFRenewalCompanyImpl[3];

			array[0] = getByYear_PrevAndNext(session, esfRenewalCompany, year,
					orderByComparator, true);

			array[1] = esfRenewalCompany;

			array[2] = getByYear_PrevAndNext(session, esfRenewalCompany, year,
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

	protected ESFRenewalCompany getByYear_PrevAndNext(Session session,
		ESFRenewalCompany esfRenewalCompany, int year,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

		query.append(_FINDER_COLUMN_YEAR_YEAR_2);

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
			query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewalCompany);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewalCompany> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewal companies where year = &#63; from the database.
	 *
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByYear(int year) throws SystemException {
		for (ESFRenewalCompany esfRenewalCompany : findByYear(year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewalCompany);
		}
	}

	/**
	 * Returns the number of e s f renewal companies where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByYear(int year) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YEAR;

		Object[] finderArgs = new Object[] { year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_YEAR_YEAR_2 = "esfRenewalCompany.year = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYMENTTYPE =
		new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPaymentType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE =
		new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPaymentType",
			new String[] { Integer.class.getName() },
			ESFRenewalCompanyModelImpl.PAYMENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PAYMENTTYPE = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPaymentType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the e s f renewal companies where paymentType = &#63;.
	 *
	 * @param paymentType the payment type
	 * @return the matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByPaymentType(int paymentType)
		throws SystemException {
		return findByPaymentType(paymentType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewal companies where paymentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentType the payment type
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @return the range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByPaymentType(int paymentType,
		int start, int end) throws SystemException {
		return findByPaymentType(paymentType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewal companies where paymentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentType the payment type
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByPaymentType(int paymentType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE;
			finderArgs = new Object[] { paymentType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYMENTTYPE;
			finderArgs = new Object[] { paymentType, start, end, orderByComparator };
		}

		List<ESFRenewalCompany> list = (List<ESFRenewalCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewalCompany esfRenewalCompany : list) {
				if ((paymentType != esfRenewalCompany.getPaymentType())) {
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

			query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(paymentType);

				if (!pagination) {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewalCompany>(list);
				}
				else {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
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
	 * Returns the first e s f renewal company in the ordered set where paymentType = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByPaymentType_First(int paymentType,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByPaymentType_First(paymentType,
				orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentType=");
		msg.append(paymentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal company in the ordered set where paymentType = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByPaymentType_First(int paymentType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRenewalCompany> list = findByPaymentType(paymentType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where paymentType = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByPaymentType_Last(int paymentType,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByPaymentType_Last(paymentType,
				orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentType=");
		msg.append(paymentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where paymentType = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByPaymentType_Last(int paymentType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPaymentType(paymentType);

		if (count == 0) {
			return null;
		}

		List<ESFRenewalCompany> list = findByPaymentType(paymentType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where paymentType = &#63;.
	 *
	 * @param esfRenewalCompanyId the primary key of the current e s f renewal company
	 * @param paymentType the payment type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany[] findByPaymentType_PrevAndNext(
		long esfRenewalCompanyId, int paymentType,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = findByPrimaryKey(esfRenewalCompanyId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewalCompany[] array = new ESFRenewalCompanyImpl[3];

			array[0] = getByPaymentType_PrevAndNext(session, esfRenewalCompany,
					paymentType, orderByComparator, true);

			array[1] = esfRenewalCompany;

			array[2] = getByPaymentType_PrevAndNext(session, esfRenewalCompany,
					paymentType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewalCompany getByPaymentType_PrevAndNext(Session session,
		ESFRenewalCompany esfRenewalCompany, int paymentType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

		query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_2);

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
			query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(paymentType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewalCompany);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewalCompany> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewal companies where paymentType = &#63; from the database.
	 *
	 * @param paymentType the payment type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPaymentType(int paymentType) throws SystemException {
		for (ESFRenewalCompany esfRenewalCompany : findByPaymentType(
				paymentType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewalCompany);
		}
	}

	/**
	 * Returns the number of e s f renewal companies where paymentType = &#63;.
	 *
	 * @param paymentType the payment type
	 * @return the number of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPaymentType(int paymentType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PAYMENTTYPE;

		Object[] finderArgs = new Object[] { paymentType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(paymentType);

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

	private static final String _FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_2 = "esfRenewalCompany.paymentType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_Y = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_Y",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_Y = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_Y",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			ESFRenewalCompanyModelImpl.STATUS_COLUMN_BITMASK |
			ESFRenewalCompanyModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_Y = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_Y",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s f renewal companies where status = &#63; and year = &#63;.
	 *
	 * @param status the status
	 * @param year the year
	 * @return the matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByS_Y(int status, int year)
		throws SystemException {
		return findByS_Y(status, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f renewal companies where status = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param year the year
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @return the range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByS_Y(int status, int year, int start,
		int end) throws SystemException {
		return findByS_Y(status, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewal companies where status = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param year the year
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByS_Y(int status, int year, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_Y;
			finderArgs = new Object[] { status, year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_S_Y;
			finderArgs = new Object[] {
					status, year,
					
					start, end, orderByComparator
				};
		}

		List<ESFRenewalCompany> list = (List<ESFRenewalCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewalCompany esfRenewalCompany : list) {
				if ((status != esfRenewalCompany.getStatus()) ||
						(year != esfRenewalCompany.getYear())) {
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

			query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_S_Y_STATUS_2);

			query.append(_FINDER_COLUMN_S_Y_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(year);

				if (!pagination) {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewalCompany>(list);
				}
				else {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
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
	 * Returns the first e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	 *
	 * @param status the status
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByS_Y_First(int status, int year,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByS_Y_First(status, year,
				orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	 *
	 * @param status the status
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByS_Y_First(int status, int year,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRenewalCompany> list = findByS_Y(status, year, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	 *
	 * @param status the status
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByS_Y_Last(int status, int year,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByS_Y_Last(status, year,
				orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	 *
	 * @param status the status
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByS_Y_Last(int status, int year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_Y(status, year);

		if (count == 0) {
			return null;
		}

		List<ESFRenewalCompany> list = findByS_Y(status, year, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	 *
	 * @param esfRenewalCompanyId the primary key of the current e s f renewal company
	 * @param status the status
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany[] findByS_Y_PrevAndNext(long esfRenewalCompanyId,
		int status, int year, OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = findByPrimaryKey(esfRenewalCompanyId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewalCompany[] array = new ESFRenewalCompanyImpl[3];

			array[0] = getByS_Y_PrevAndNext(session, esfRenewalCompany, status,
					year, orderByComparator, true);

			array[1] = esfRenewalCompany;

			array[2] = getByS_Y_PrevAndNext(session, esfRenewalCompany, status,
					year, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewalCompany getByS_Y_PrevAndNext(Session session,
		ESFRenewalCompany esfRenewalCompany, int status, int year,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

		query.append(_FINDER_COLUMN_S_Y_STATUS_2);

		query.append(_FINDER_COLUMN_S_Y_YEAR_2);

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
			query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewalCompany);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewalCompany> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewal companies where status = &#63; and year = &#63; from the database.
	 *
	 * @param status the status
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_Y(int status, int year) throws SystemException {
		for (ESFRenewalCompany esfRenewalCompany : findByS_Y(status, year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewalCompany);
		}
	}

	/**
	 * Returns the number of e s f renewal companies where status = &#63; and year = &#63;.
	 *
	 * @param status the status
	 * @param year the year
	 * @return the number of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByS_Y(int status, int year) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_S_Y;

		Object[] finderArgs = new Object[] { status, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_S_Y_STATUS_2);

			query.append(_FINDER_COLUMN_S_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_S_Y_STATUS_2 = "esfRenewalCompany.status = ? AND ";
	private static final String _FINDER_COLUMN_S_Y_YEAR_2 = "esfRenewalCompany.year = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_Y = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_Y",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_Y = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_Y",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			ESFRenewalCompanyModelImpl.PAYMENTTYPE_COLUMN_BITMASK |
			ESFRenewalCompanyModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_Y = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_Y",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s f renewal companies where paymentType = &#63; and year = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @return the matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByP_Y(int paymentType, int year)
		throws SystemException {
		return findByP_Y(paymentType, year, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewal companies where paymentType = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @return the range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByP_Y(int paymentType, int year,
		int start, int end) throws SystemException {
		return findByP_Y(paymentType, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewal companies where paymentType = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByP_Y(int paymentType, int year,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_Y;
			finderArgs = new Object[] { paymentType, year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_Y;
			finderArgs = new Object[] {
					paymentType, year,
					
					start, end, orderByComparator
				};
		}

		List<ESFRenewalCompany> list = (List<ESFRenewalCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewalCompany esfRenewalCompany : list) {
				if ((paymentType != esfRenewalCompany.getPaymentType()) ||
						(year != esfRenewalCompany.getYear())) {
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

			query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_P_Y_PAYMENTTYPE_2);

			query.append(_FINDER_COLUMN_P_Y_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(paymentType);

				qPos.add(year);

				if (!pagination) {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewalCompany>(list);
				}
				else {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
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
	 * Returns the first e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByP_Y_First(int paymentType, int year,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByP_Y_First(paymentType,
				year, orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentType=");
		msg.append(paymentType);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByP_Y_First(int paymentType, int year,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRenewalCompany> list = findByP_Y(paymentType, year, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByP_Y_Last(int paymentType, int year,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByP_Y_Last(paymentType,
				year, orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentType=");
		msg.append(paymentType);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByP_Y_Last(int paymentType, int year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByP_Y(paymentType, year);

		if (count == 0) {
			return null;
		}

		List<ESFRenewalCompany> list = findByP_Y(paymentType, year, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	 *
	 * @param esfRenewalCompanyId the primary key of the current e s f renewal company
	 * @param paymentType the payment type
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany[] findByP_Y_PrevAndNext(long esfRenewalCompanyId,
		int paymentType, int year, OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = findByPrimaryKey(esfRenewalCompanyId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewalCompany[] array = new ESFRenewalCompanyImpl[3];

			array[0] = getByP_Y_PrevAndNext(session, esfRenewalCompany,
					paymentType, year, orderByComparator, true);

			array[1] = esfRenewalCompany;

			array[2] = getByP_Y_PrevAndNext(session, esfRenewalCompany,
					paymentType, year, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewalCompany getByP_Y_PrevAndNext(Session session,
		ESFRenewalCompany esfRenewalCompany, int paymentType, int year,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

		query.append(_FINDER_COLUMN_P_Y_PAYMENTTYPE_2);

		query.append(_FINDER_COLUMN_P_Y_YEAR_2);

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
			query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(paymentType);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewalCompany);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewalCompany> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewal companies where paymentType = &#63; and year = &#63; from the database.
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByP_Y(int paymentType, int year)
		throws SystemException {
		for (ESFRenewalCompany esfRenewalCompany : findByP_Y(paymentType, year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewalCompany);
		}
	}

	/**
	 * Returns the number of e s f renewal companies where paymentType = &#63; and year = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param year the year
	 * @return the number of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByP_Y(int paymentType, int year) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_P_Y;

		Object[] finderArgs = new Object[] { paymentType, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_P_Y_PAYMENTTYPE_2);

			query.append(_FINDER_COLUMN_P_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(paymentType);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_P_Y_PAYMENTTYPE_2 = "esfRenewalCompany.paymentType = ? AND ";
	private static final String _FINDER_COLUMN_P_Y_YEAR_2 = "esfRenewalCompany.year = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_S = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_S",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_S",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			ESFRenewalCompanyModelImpl.PAYMENTTYPE_COLUMN_BITMASK |
			ESFRenewalCompanyModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_S = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_S",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s f renewal companies where paymentType = &#63; and status = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @return the matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByP_S(int paymentType, int status)
		throws SystemException {
		return findByP_S(paymentType, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewal companies where paymentType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @return the range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByP_S(int paymentType, int status,
		int start, int end) throws SystemException {
		return findByP_S(paymentType, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewal companies where paymentType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findByP_S(int paymentType, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S;
			finderArgs = new Object[] { paymentType, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_S;
			finderArgs = new Object[] {
					paymentType, status,
					
					start, end, orderByComparator
				};
		}

		List<ESFRenewalCompany> list = (List<ESFRenewalCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRenewalCompany esfRenewalCompany : list) {
				if ((paymentType != esfRenewalCompany.getPaymentType()) ||
						(status != esfRenewalCompany.getStatus())) {
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

			query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_P_S_PAYMENTTYPE_2);

			query.append(_FINDER_COLUMN_P_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(paymentType);

				qPos.add(status);

				if (!pagination) {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewalCompany>(list);
				}
				else {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
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
	 * Returns the first e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByP_S_First(int paymentType, int status,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByP_S_First(paymentType,
				status, orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentType=");
		msg.append(paymentType);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the first e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByP_S_First(int paymentType, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRenewalCompany> list = findByP_S(paymentType, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByP_S_Last(int paymentType, int status,
		OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByP_S_Last(paymentType,
				status, orderByComparator);

		if (esfRenewalCompany != null) {
			return esfRenewalCompany;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("paymentType=");
		msg.append(paymentType);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchESFRenewalCompanyException(msg.toString());
	}

	/**
	 * Returns the last e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByP_S_Last(int paymentType, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByP_S(paymentType, status);

		if (count == 0) {
			return null;
		}

		List<ESFRenewalCompany> list = findByP_S(paymentType, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	 *
	 * @param esfRenewalCompanyId the primary key of the current e s f renewal company
	 * @param paymentType the payment type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany[] findByP_S_PrevAndNext(long esfRenewalCompanyId,
		int paymentType, int status, OrderByComparator orderByComparator)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = findByPrimaryKey(esfRenewalCompanyId);

		Session session = null;

		try {
			session = openSession();

			ESFRenewalCompany[] array = new ESFRenewalCompanyImpl[3];

			array[0] = getByP_S_PrevAndNext(session, esfRenewalCompany,
					paymentType, status, orderByComparator, true);

			array[1] = esfRenewalCompany;

			array[2] = getByP_S_PrevAndNext(session, esfRenewalCompany,
					paymentType, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFRenewalCompany getByP_S_PrevAndNext(Session session,
		ESFRenewalCompany esfRenewalCompany, int paymentType, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

		query.append(_FINDER_COLUMN_P_S_PAYMENTTYPE_2);

		query.append(_FINDER_COLUMN_P_S_STATUS_2);

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
			query.append(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(paymentType);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRenewalCompany);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRenewalCompany> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f renewal companies where paymentType = &#63; and status = &#63; from the database.
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByP_S(int paymentType, int status)
		throws SystemException {
		for (ESFRenewalCompany esfRenewalCompany : findByP_S(paymentType,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRenewalCompany);
		}
	}

	/**
	 * Returns the number of e s f renewal companies where paymentType = &#63; and status = &#63;.
	 *
	 * @param paymentType the payment type
	 * @param status the status
	 * @return the number of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByP_S(int paymentType, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_P_S;

		Object[] finderArgs = new Object[] { paymentType, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_P_S_PAYMENTTYPE_2);

			query.append(_FINDER_COLUMN_P_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(paymentType);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_P_S_PAYMENTTYPE_2 = "esfRenewalCompany.paymentType = ? AND ";
	private static final String _FINDER_COLUMN_P_S_STATUS_2 = "esfRenewalCompany.status = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_E_Y = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByE_Y",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ESFRenewalCompanyModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK |
			ESFRenewalCompanyModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_E_Y = new FinderPath(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_Y",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or throws a {@link it.ethica.esf.renewal.NoSuchESFRenewalCompanyException} if it could not be found.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param year the year
	 * @return the matching e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByE_Y(long esfOrganizationId, int year)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByE_Y(esfOrganizationId, year);

		if (esfRenewalCompany == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfOrganizationId=");
			msg.append(esfOrganizationId);

			msg.append(", year=");
			msg.append(year);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchESFRenewalCompanyException(msg.toString());
		}

		return esfRenewalCompany;
	}

	/**
	 * Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param year the year
	 * @return the matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByE_Y(long esfOrganizationId, int year)
		throws SystemException {
		return fetchByE_Y(esfOrganizationId, year, true);
	}

	/**
	 * Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param year the year
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByE_Y(long esfOrganizationId, int year,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { esfOrganizationId, year };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_E_Y,
					finderArgs, this);
		}

		if (result instanceof ESFRenewalCompany) {
			ESFRenewalCompany esfRenewalCompany = (ESFRenewalCompany)result;

			if ((esfOrganizationId != esfRenewalCompany.getEsfOrganizationId()) ||
					(year != esfRenewalCompany.getYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_E_Y_ESFORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_E_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				qPos.add(year);

				List<ESFRenewalCompany> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_Y,
						finderArgs, list);
				}
				else {
					ESFRenewalCompany esfRenewalCompany = list.get(0);

					result = esfRenewalCompany;

					cacheResult(esfRenewalCompany);

					if ((esfRenewalCompany.getEsfOrganizationId() != esfOrganizationId) ||
							(esfRenewalCompany.getYear() != year)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_Y,
							finderArgs, esfRenewalCompany);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_E_Y,
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
			return (ESFRenewalCompany)result;
		}
	}

	/**
	 * Removes the e s f renewal company where esfOrganizationId = &#63; and year = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param year the year
	 * @return the e s f renewal company that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany removeByE_Y(long esfOrganizationId, int year)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = findByE_Y(esfOrganizationId, year);

		return remove(esfRenewalCompany);
	}

	/**
	 * Returns the number of e s f renewal companies where esfOrganizationId = &#63; and year = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param year the year
	 * @return the number of matching e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByE_Y(long esfOrganizationId, int year)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_E_Y;

		Object[] finderArgs = new Object[] { esfOrganizationId, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRENEWALCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_E_Y_ESFORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_E_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_E_Y_ESFORGANIZATIONID_2 = "esfRenewalCompany.esfOrganizationId = ? AND ";
	private static final String _FINDER_COLUMN_E_Y_YEAR_2 = "esfRenewalCompany.year = ?";

	public ESFRenewalCompanyPersistenceImpl() {
		setModelClass(ESFRenewalCompany.class);
	}

	/**
	 * Caches the e s f renewal company in the entity cache if it is enabled.
	 *
	 * @param esfRenewalCompany the e s f renewal company
	 */
	@Override
	public void cacheResult(ESFRenewalCompany esfRenewalCompany) {
		EntityCacheUtil.putResult(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class, esfRenewalCompany.getPrimaryKey(),
			esfRenewalCompany);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_Y,
			new Object[] {
				esfRenewalCompany.getEsfOrganizationId(),
				esfRenewalCompany.getYear()
			}, esfRenewalCompany);

		esfRenewalCompany.resetOriginalValues();
	}

	/**
	 * Caches the e s f renewal companies in the entity cache if it is enabled.
	 *
	 * @param esfRenewalCompanies the e s f renewal companies
	 */
	@Override
	public void cacheResult(List<ESFRenewalCompany> esfRenewalCompanies) {
		for (ESFRenewalCompany esfRenewalCompany : esfRenewalCompanies) {
			if (EntityCacheUtil.getResult(
						ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
						ESFRenewalCompanyImpl.class,
						esfRenewalCompany.getPrimaryKey()) == null) {
				cacheResult(esfRenewalCompany);
			}
			else {
				esfRenewalCompany.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f renewal companies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRenewalCompanyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRenewalCompanyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f renewal company.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRenewalCompany esfRenewalCompany) {
		EntityCacheUtil.removeResult(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class, esfRenewalCompany.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfRenewalCompany);
	}

	@Override
	public void clearCache(List<ESFRenewalCompany> esfRenewalCompanies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRenewalCompany esfRenewalCompany : esfRenewalCompanies) {
			EntityCacheUtil.removeResult(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
				ESFRenewalCompanyImpl.class, esfRenewalCompany.getPrimaryKey());

			clearUniqueFindersCache(esfRenewalCompany);
		}
	}

	protected void cacheUniqueFindersCache(ESFRenewalCompany esfRenewalCompany) {
		if (esfRenewalCompany.isNew()) {
			Object[] args = new Object[] {
					esfRenewalCompany.getEsfOrganizationId(),
					esfRenewalCompany.getYear()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E_Y, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_Y, args,
				esfRenewalCompany);
		}
		else {
			ESFRenewalCompanyModelImpl esfRenewalCompanyModelImpl = (ESFRenewalCompanyModelImpl)esfRenewalCompany;

			if ((esfRenewalCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_E_Y.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalCompany.getEsfOrganizationId(),
						esfRenewalCompany.getYear()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E_Y, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_Y, args,
					esfRenewalCompany);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFRenewalCompany esfRenewalCompany) {
		ESFRenewalCompanyModelImpl esfRenewalCompanyModelImpl = (ESFRenewalCompanyModelImpl)esfRenewalCompany;

		Object[] args = new Object[] {
				esfRenewalCompany.getEsfOrganizationId(),
				esfRenewalCompany.getYear()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_E_Y, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_E_Y, args);

		if ((esfRenewalCompanyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_E_Y.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfRenewalCompanyModelImpl.getOriginalEsfOrganizationId(),
					esfRenewalCompanyModelImpl.getOriginalYear()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_E_Y, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_E_Y, args);
		}
	}

	/**
	 * Creates a new e s f renewal company with the primary key. Does not add the e s f renewal company to the database.
	 *
	 * @param esfRenewalCompanyId the primary key for the new e s f renewal company
	 * @return the new e s f renewal company
	 */
	@Override
	public ESFRenewalCompany create(long esfRenewalCompanyId) {
		ESFRenewalCompany esfRenewalCompany = new ESFRenewalCompanyImpl();

		esfRenewalCompany.setNew(true);
		esfRenewalCompany.setPrimaryKey(esfRenewalCompanyId);

		return esfRenewalCompany;
	}

	/**
	 * Removes the e s f renewal company with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfRenewalCompanyId the primary key of the e s f renewal company
	 * @return the e s f renewal company that was removed
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany remove(long esfRenewalCompanyId)
		throws NoSuchESFRenewalCompanyException, SystemException {
		return remove((Serializable)esfRenewalCompanyId);
	}

	/**
	 * Removes the e s f renewal company with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f renewal company
	 * @return the e s f renewal company that was removed
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany remove(Serializable primaryKey)
		throws NoSuchESFRenewalCompanyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRenewalCompany esfRenewalCompany = (ESFRenewalCompany)session.get(ESFRenewalCompanyImpl.class,
					primaryKey);

			if (esfRenewalCompany == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchESFRenewalCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRenewalCompany);
		}
		catch (NoSuchESFRenewalCompanyException nsee) {
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
	protected ESFRenewalCompany removeImpl(ESFRenewalCompany esfRenewalCompany)
		throws SystemException {
		esfRenewalCompany = toUnwrappedModel(esfRenewalCompany);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRenewalCompany)) {
				esfRenewalCompany = (ESFRenewalCompany)session.get(ESFRenewalCompanyImpl.class,
						esfRenewalCompany.getPrimaryKeyObj());
			}

			if (esfRenewalCompany != null) {
				session.delete(esfRenewalCompany);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRenewalCompany != null) {
			clearCache(esfRenewalCompany);
		}

		return esfRenewalCompany;
	}

	@Override
	public ESFRenewalCompany updateImpl(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany)
		throws SystemException {
		esfRenewalCompany = toUnwrappedModel(esfRenewalCompany);

		boolean isNew = esfRenewalCompany.isNew();

		ESFRenewalCompanyModelImpl esfRenewalCompanyModelImpl = (ESFRenewalCompanyModelImpl)esfRenewalCompany;

		Session session = null;

		try {
			session = openSession();

			if (esfRenewalCompany.isNew()) {
				session.save(esfRenewalCompany);

				esfRenewalCompany.setNew(false);
			}
			else {
				session.merge(esfRenewalCompany);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFRenewalCompanyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfRenewalCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalCompanyModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { esfRenewalCompanyModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((esfRenewalCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalCompanyModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);

				args = new Object[] { esfRenewalCompanyModelImpl.getYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);
			}

			if ((esfRenewalCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalCompanyModelImpl.getOriginalPaymentType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PAYMENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE,
					args);

				args = new Object[] { esfRenewalCompanyModelImpl.getPaymentType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PAYMENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE,
					args);
			}

			if ((esfRenewalCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_Y.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalCompanyModelImpl.getOriginalStatus(),
						esfRenewalCompanyModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_Y, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_Y,
					args);

				args = new Object[] {
						esfRenewalCompanyModelImpl.getStatus(),
						esfRenewalCompanyModelImpl.getYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_Y, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_Y,
					args);
			}

			if ((esfRenewalCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_Y.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalCompanyModelImpl.getOriginalPaymentType(),
						esfRenewalCompanyModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_Y, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_Y,
					args);

				args = new Object[] {
						esfRenewalCompanyModelImpl.getPaymentType(),
						esfRenewalCompanyModelImpl.getYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_Y, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_Y,
					args);
			}

			if ((esfRenewalCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRenewalCompanyModelImpl.getOriginalPaymentType(),
						esfRenewalCompanyModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S,
					args);

				args = new Object[] {
						esfRenewalCompanyModelImpl.getPaymentType(),
						esfRenewalCompanyModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ESFRenewalCompanyImpl.class, esfRenewalCompany.getPrimaryKey(),
			esfRenewalCompany);

		clearUniqueFindersCache(esfRenewalCompany);
		cacheUniqueFindersCache(esfRenewalCompany);

		return esfRenewalCompany;
	}

	protected ESFRenewalCompany toUnwrappedModel(
		ESFRenewalCompany esfRenewalCompany) {
		if (esfRenewalCompany instanceof ESFRenewalCompanyImpl) {
			return esfRenewalCompany;
		}

		ESFRenewalCompanyImpl esfRenewalCompanyImpl = new ESFRenewalCompanyImpl();

		esfRenewalCompanyImpl.setNew(esfRenewalCompany.isNew());
		esfRenewalCompanyImpl.setPrimaryKey(esfRenewalCompany.getPrimaryKey());

		esfRenewalCompanyImpl.setEsfRenewalCompanyId(esfRenewalCompany.getEsfRenewalCompanyId());
		esfRenewalCompanyImpl.setUserId(esfRenewalCompany.getUserId());
		esfRenewalCompanyImpl.setEsfOrganizationId(esfRenewalCompany.getEsfOrganizationId());
		esfRenewalCompanyImpl.setCardsNumber(esfRenewalCompany.getCardsNumber());
		esfRenewalCompanyImpl.setYear(esfRenewalCompany.getYear());
		esfRenewalCompanyImpl.setDate(esfRenewalCompany.getDate());
		esfRenewalCompanyImpl.setPaymentType(esfRenewalCompany.getPaymentType());
		esfRenewalCompanyImpl.setStatus(esfRenewalCompany.getStatus());
		esfRenewalCompanyImpl.setAmount(esfRenewalCompany.getAmount());
		esfRenewalCompanyImpl.setInfo(esfRenewalCompany.getInfo());
		esfRenewalCompanyImpl.setAccountholder(esfRenewalCompany.getAccountholder());
		esfRenewalCompanyImpl.setPaymentDate(esfRenewalCompany.getPaymentDate());
		esfRenewalCompanyImpl.setIntegrationAmount(esfRenewalCompany.getIntegrationAmount());
		esfRenewalCompanyImpl.setIntegrationDate(esfRenewalCompany.getIntegrationDate());
		esfRenewalCompanyImpl.setIntegrationType(esfRenewalCompany.getIntegrationType());
		esfRenewalCompanyImpl.setIntegrationAccountholder(esfRenewalCompany.getIntegrationAccountholder());
		esfRenewalCompanyImpl.setJoin(esfRenewalCompany.isJoin());

		return esfRenewalCompanyImpl;
	}

	/**
	 * Returns the e s f renewal company with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f renewal company
	 * @return the e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByPrimaryKey(Serializable primaryKey)
		throws NoSuchESFRenewalCompanyException, SystemException {
		ESFRenewalCompany esfRenewalCompany = fetchByPrimaryKey(primaryKey);

		if (esfRenewalCompany == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchESFRenewalCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRenewalCompany;
	}

	/**
	 * Returns the e s f renewal company with the primary key or throws a {@link it.ethica.esf.renewal.NoSuchESFRenewalCompanyException} if it could not be found.
	 *
	 * @param esfRenewalCompanyId the primary key of the e s f renewal company
	 * @return the e s f renewal company
	 * @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany findByPrimaryKey(long esfRenewalCompanyId)
		throws NoSuchESFRenewalCompanyException, SystemException {
		return findByPrimaryKey((Serializable)esfRenewalCompanyId);
	}

	/**
	 * Returns the e s f renewal company with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f renewal company
	 * @return the e s f renewal company, or <code>null</code> if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRenewalCompany esfRenewalCompany = (ESFRenewalCompany)EntityCacheUtil.getResult(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
				ESFRenewalCompanyImpl.class, primaryKey);

		if (esfRenewalCompany == _nullESFRenewalCompany) {
			return null;
		}

		if (esfRenewalCompany == null) {
			Session session = null;

			try {
				session = openSession();

				esfRenewalCompany = (ESFRenewalCompany)session.get(ESFRenewalCompanyImpl.class,
						primaryKey);

				if (esfRenewalCompany != null) {
					cacheResult(esfRenewalCompany);
				}
				else {
					EntityCacheUtil.putResult(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
						ESFRenewalCompanyImpl.class, primaryKey,
						_nullESFRenewalCompany);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRenewalCompanyModelImpl.ENTITY_CACHE_ENABLED,
					ESFRenewalCompanyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRenewalCompany;
	}

	/**
	 * Returns the e s f renewal company with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfRenewalCompanyId the primary key of the e s f renewal company
	 * @return the e s f renewal company, or <code>null</code> if a e s f renewal company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRenewalCompany fetchByPrimaryKey(long esfRenewalCompanyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfRenewalCompanyId);
	}

	/**
	 * Returns all the e s f renewal companies.
	 *
	 * @return the e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f renewal companies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @return the range of e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f renewal companies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f renewal companies
	 * @param end the upper bound of the range of e s f renewal companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f renewal companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRenewalCompany> findAll(int start, int end,
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

		List<ESFRenewalCompany> list = (List<ESFRenewalCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRENEWALCOMPANY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRENEWALCOMPANY;

				if (pagination) {
					sql = sql.concat(ESFRenewalCompanyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRenewalCompany>(list);
				}
				else {
					list = (List<ESFRenewalCompany>)QueryUtil.list(q,
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
	 * Removes all the e s f renewal companies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRenewalCompany esfRenewalCompany : findAll()) {
			remove(esfRenewalCompany);
		}
	}

	/**
	 * Returns the number of e s f renewal companies.
	 *
	 * @return the number of e s f renewal companies
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

				Query q = session.createQuery(_SQL_COUNT_ESFRENEWALCOMPANY);

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
	 * Initializes the e s f renewal company persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.renewal.model.ESFRenewalCompany")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRenewalCompany>> listenersList = new ArrayList<ModelListener<ESFRenewalCompany>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRenewalCompany>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRenewalCompanyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRENEWALCOMPANY = "SELECT esfRenewalCompany FROM ESFRenewalCompany esfRenewalCompany";
	private static final String _SQL_SELECT_ESFRENEWALCOMPANY_WHERE = "SELECT esfRenewalCompany FROM ESFRenewalCompany esfRenewalCompany WHERE ";
	private static final String _SQL_COUNT_ESFRENEWALCOMPANY = "SELECT COUNT(esfRenewalCompany) FROM ESFRenewalCompany esfRenewalCompany";
	private static final String _SQL_COUNT_ESFRENEWALCOMPANY_WHERE = "SELECT COUNT(esfRenewalCompany) FROM ESFRenewalCompany esfRenewalCompany WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRenewalCompany.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRenewalCompany exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFRenewalCompany exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRenewalCompanyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date", "join"
			});
	private static ESFRenewalCompany _nullESFRenewalCompany = new ESFRenewalCompanyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRenewalCompany> toCacheModel() {
				return _nullESFRenewalCompanyCacheModel;
			}
		};

	private static CacheModel<ESFRenewalCompany> _nullESFRenewalCompanyCacheModel =
		new CacheModel<ESFRenewalCompany>() {
			@Override
			public ESFRenewalCompany toEntityModel() {
				return _nullESFRenewalCompany;
			}
		};
}