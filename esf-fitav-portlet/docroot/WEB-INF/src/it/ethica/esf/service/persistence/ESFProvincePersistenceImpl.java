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
import com.liferay.portal.kernel.util.CharPool;
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

import it.ethica.esf.NoSuchProvinceException;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.model.impl.ESFProvinceImpl;
import it.ethica.esf.model.impl.ESFProvinceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f province service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFProvincePersistence
 * @see ESFProvinceUtil
 * @generated
 */
public class ESFProvincePersistenceImpl extends BasePersistenceImpl<ESFProvince>
	implements ESFProvincePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFProvinceUtil} to access the e s f province persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFProvinceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, ESFProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, ESFProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R = new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, ESFProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R = new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, ESFProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R",
			new String[] { String.class.getName(), String.class.getName() },
			ESFProvinceModelImpl.IDREGION_COLUMN_BITMASK |
			ESFProvinceModelImpl.IDCOUNTRY_COLUMN_BITMASK |
			ESFProvinceModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R = new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the e s f provinces where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @return the matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByC_R(String idRegion, String idCountry)
		throws SystemException {
		return findByC_R(idRegion, idCountry, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f provinces where idRegion = &#63; and idCountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param start the lower bound of the range of e s f provinces
	 * @param end the upper bound of the range of e s f provinces (not inclusive)
	 * @return the range of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByC_R(String idRegion, String idCountry,
		int start, int end) throws SystemException {
		return findByC_R(idRegion, idCountry, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f provinces where idRegion = &#63; and idCountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param start the lower bound of the range of e s f provinces
	 * @param end the upper bound of the range of e s f provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByC_R(String idRegion, String idCountry,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R;
			finderArgs = new Object[] { idRegion, idCountry };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R;
			finderArgs = new Object[] {
					idRegion, idCountry,
					
					start, end, orderByComparator
				};
		}

		List<ESFProvince> list = (List<ESFProvince>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFProvince esfProvince : list) {
				if (!Validator.equals(idRegion, esfProvince.getIdRegion()) ||
						!Validator.equals(idCountry, esfProvince.getIdCountry())) {
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

			query.append(_SQL_SELECT_ESFPROVINCE_WHERE);

			boolean bindIdRegion = false;

			if (idRegion == null) {
				query.append(_FINDER_COLUMN_C_R_IDREGION_1);
			}
			else if (idRegion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_IDREGION_3);
			}
			else {
				bindIdRegion = true;

				query.append(_FINDER_COLUMN_C_R_IDREGION_2);
			}

			boolean bindIdCountry = false;

			if (idCountry == null) {
				query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_1);
			}
			else if (idCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_3);
			}
			else {
				bindIdCountry = true;

				query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFProvinceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdRegion) {
					qPos.add(idRegion);
				}

				if (bindIdCountry) {
					qPos.add(idCountry);
				}

				if (!pagination) {
					list = (List<ESFProvince>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFProvince>(list);
				}
				else {
					list = (List<ESFProvince>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince findByC_R_First(String idRegion, String idCountry,
		OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = fetchByC_R_First(idRegion, idCountry,
				orderByComparator);

		if (esfProvince != null) {
			return esfProvince;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idRegion=");
		msg.append(idRegion);

		msg.append(", idCountry=");
		msg.append(idCountry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvinceException(msg.toString());
	}

	/**
	 * Returns the first e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince fetchByC_R_First(String idRegion, String idCountry,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFProvince> list = findByC_R(idRegion, idCountry, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince findByC_R_Last(String idRegion, String idCountry,
		OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = fetchByC_R_Last(idRegion, idCountry,
				orderByComparator);

		if (esfProvince != null) {
			return esfProvince;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idRegion=");
		msg.append(idRegion);

		msg.append(", idCountry=");
		msg.append(idCountry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvinceException(msg.toString());
	}

	/**
	 * Returns the last e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince fetchByC_R_Last(String idRegion, String idCountry,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_R(idRegion, idCountry);

		if (count == 0) {
			return null;
		}

		List<ESFProvince> list = findByC_R(idRegion, idCountry, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f provinces before and after the current e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param esfProvincePK the primary key of the current e s f province
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince[] findByC_R_PrevAndNext(ESFProvincePK esfProvincePK,
		String idRegion, String idCountry, OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = findByPrimaryKey(esfProvincePK);

		Session session = null;

		try {
			session = openSession();

			ESFProvince[] array = new ESFProvinceImpl[3];

			array[0] = getByC_R_PrevAndNext(session, esfProvince, idRegion,
					idCountry, orderByComparator, true);

			array[1] = esfProvince;

			array[2] = getByC_R_PrevAndNext(session, esfProvince, idRegion,
					idCountry, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFProvince getByC_R_PrevAndNext(Session session,
		ESFProvince esfProvince, String idRegion, String idCountry,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPROVINCE_WHERE);

		boolean bindIdRegion = false;

		if (idRegion == null) {
			query.append(_FINDER_COLUMN_C_R_IDREGION_1);
		}
		else if (idRegion.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_IDREGION_3);
		}
		else {
			bindIdRegion = true;

			query.append(_FINDER_COLUMN_C_R_IDREGION_2);
		}

		boolean bindIdCountry = false;

		if (idCountry == null) {
			query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_1);
		}
		else if (idCountry.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_3);
		}
		else {
			bindIdCountry = true;

			query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_2);
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
			query.append(ESFProvinceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIdRegion) {
			qPos.add(idRegion);
		}

		if (bindIdCountry) {
			qPos.add(idCountry);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfProvince);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFProvince> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f provinces where idRegion = &#63; and idCountry = &#63; from the database.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_R(String idRegion, String idCountry)
		throws SystemException {
		for (ESFProvince esfProvince : findByC_R(idRegion, idCountry,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfProvince);
		}
	}

	/**
	 * Returns the number of e s f provinces where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @return the number of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_R(String idRegion, String idCountry)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R;

		Object[] finderArgs = new Object[] { idRegion, idCountry };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFPROVINCE_WHERE);

			boolean bindIdRegion = false;

			if (idRegion == null) {
				query.append(_FINDER_COLUMN_C_R_IDREGION_1);
			}
			else if (idRegion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_IDREGION_3);
			}
			else {
				bindIdRegion = true;

				query.append(_FINDER_COLUMN_C_R_IDREGION_2);
			}

			boolean bindIdCountry = false;

			if (idCountry == null) {
				query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_1);
			}
			else if (idCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_3);
			}
			else {
				bindIdCountry = true;

				query.append(_FINDER_COLUMN_C_R_IDCOUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdRegion) {
					qPos.add(idRegion);
				}

				if (bindIdCountry) {
					qPos.add(idCountry);
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

	private static final String _FINDER_COLUMN_C_R_IDREGION_1 = "esfProvince.id.idRegion IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_IDREGION_2 = "esfProvince.id.idRegion = ? AND ";
	private static final String _FINDER_COLUMN_C_R_IDREGION_3 = "(esfProvince.id.idRegion IS NULL OR esfProvince.id.idRegion = '') AND ";
	private static final String _FINDER_COLUMN_C_R_IDCOUNTRY_1 = "esfProvince.id.idCountry IS NULL";
	private static final String _FINDER_COLUMN_C_R_IDCOUNTRY_2 = "esfProvince.id.idCountry = ?";
	private static final String _FINDER_COLUMN_C_R_IDCOUNTRY_3 = "(esfProvince.id.idCountry IS NULL OR esfProvince.id.idCountry = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYPROVINCENAME =
		new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, ESFProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryProvinceName",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_COUNTRYPROVINCENAME =
		new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCountryProvinceName",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @return the matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByCountryProvinceName(String idCountry,
		String name) throws SystemException {
		return findByCountryProvinceName(idCountry, name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @param start the lower bound of the range of e s f provinces
	 * @param end the upper bound of the range of e s f provinces (not inclusive)
	 * @return the range of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByCountryProvinceName(String idCountry,
		String name, int start, int end) throws SystemException {
		return findByCountryProvinceName(idCountry, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @param start the lower bound of the range of e s f provinces
	 * @param end the upper bound of the range of e s f provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByCountryProvinceName(String idCountry,
		String name, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYPROVINCENAME;
		finderArgs = new Object[] { idCountry, name, start, end, orderByComparator };

		List<ESFProvince> list = (List<ESFProvince>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFProvince esfProvince : list) {
				if (!StringUtil.wildcardMatches(esfProvince.getIdCountry(),
							idCountry, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!StringUtil.wildcardMatches(esfProvince.getName(),
							name, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_ESFPROVINCE_WHERE);

			boolean bindIdCountry = false;

			if (idCountry == null) {
				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_1);
			}
			else if (idCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_3);
			}
			else {
				bindIdCountry = true;

				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_2);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFProvinceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdCountry) {
					qPos.add(idCountry);
				}

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ESFProvince>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFProvince>(list);
				}
				else {
					list = (List<ESFProvince>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince findByCountryProvinceName_First(String idCountry,
		String name, OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = fetchByCountryProvinceName_First(idCountry,
				name, orderByComparator);

		if (esfProvince != null) {
			return esfProvince;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idCountry=");
		msg.append(idCountry);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvinceException(msg.toString());
	}

	/**
	 * Returns the first e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince fetchByCountryProvinceName_First(String idCountry,
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFProvince> list = findByCountryProvinceName(idCountry, name, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince findByCountryProvinceName_Last(String idCountry,
		String name, OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = fetchByCountryProvinceName_Last(idCountry,
				name, orderByComparator);

		if (esfProvince != null) {
			return esfProvince;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idCountry=");
		msg.append(idCountry);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvinceException(msg.toString());
	}

	/**
	 * Returns the last e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince fetchByCountryProvinceName_Last(String idCountry,
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCountryProvinceName(idCountry, name);

		if (count == 0) {
			return null;
		}

		List<ESFProvince> list = findByCountryProvinceName(idCountry, name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f provinces before and after the current e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * @param esfProvincePK the primary key of the current e s f province
	 * @param idCountry the id country
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince[] findByCountryProvinceName_PrevAndNext(
		ESFProvincePK esfProvincePK, String idCountry, String name,
		OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = findByPrimaryKey(esfProvincePK);

		Session session = null;

		try {
			session = openSession();

			ESFProvince[] array = new ESFProvinceImpl[3];

			array[0] = getByCountryProvinceName_PrevAndNext(session,
					esfProvince, idCountry, name, orderByComparator, true);

			array[1] = esfProvince;

			array[2] = getByCountryProvinceName_PrevAndNext(session,
					esfProvince, idCountry, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFProvince getByCountryProvinceName_PrevAndNext(
		Session session, ESFProvince esfProvince, String idCountry,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPROVINCE_WHERE);

		boolean bindIdCountry = false;

		if (idCountry == null) {
			query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_1);
		}
		else if (idCountry.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_3);
		}
		else {
			bindIdCountry = true;

			query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_2);
		}

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_2);
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
			query.append(ESFProvinceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIdCountry) {
			qPos.add(idCountry);
		}

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfProvince);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFProvince> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63; from the database.
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryProvinceName(String idCountry, String name)
		throws SystemException {
		for (ESFProvince esfProvince : findByCountryProvinceName(idCountry,
				name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfProvince);
		}
	}

	/**
	 * Returns the number of e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	 *
	 * @param idCountry the id country
	 * @param name the name
	 * @return the number of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryProvinceName(String idCountry, String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_COUNTRYPROVINCENAME;

		Object[] finderArgs = new Object[] { idCountry, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFPROVINCE_WHERE);

			boolean bindIdCountry = false;

			if (idCountry == null) {
				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_1);
			}
			else if (idCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_3);
			}
			else {
				bindIdCountry = true;

				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_2);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdCountry) {
					qPos.add(idCountry);
				}

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

	private static final String _FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_1 = "esfProvince.id.idCountry LIKE NULL AND ";
	private static final String _FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_2 = "esfProvince.id.idCountry LIKE ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYPROVINCENAME_IDCOUNTRY_3 = "(esfProvince.id.idCountry IS NULL OR esfProvince.id.idCountry LIKE '') AND ";
	private static final String _FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_1 = "esfProvince.name LIKE NULL";
	private static final String _FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_2 = "esfProvince.name LIKE ?";
	private static final String _FINDER_COLUMN_COUNTRYPROVINCENAME_NAME_3 = "(esfProvince.name IS NULL OR esfProvince.name LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROVINCEID =
		new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, ESFProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProvinceId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVINCEID =
		new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, ESFProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProvinceId",
			new String[] { String.class.getName() },
			ESFProvinceModelImpl.IDPROVINCE_COLUMN_BITMASK |
			ESFProvinceModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROVINCEID = new FinderPath(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProvinceId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f provinces where idProvince = &#63;.
	 *
	 * @param idProvince the id province
	 * @return the matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByProvinceId(String idProvince)
		throws SystemException {
		return findByProvinceId(idProvince, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f provinces where idProvince = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idProvince the id province
	 * @param start the lower bound of the range of e s f provinces
	 * @param end the upper bound of the range of e s f provinces (not inclusive)
	 * @return the range of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByProvinceId(String idProvince, int start,
		int end) throws SystemException {
		return findByProvinceId(idProvince, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f provinces where idProvince = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idProvince the id province
	 * @param start the lower bound of the range of e s f provinces
	 * @param end the upper bound of the range of e s f provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findByProvinceId(String idProvince, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVINCEID;
			finderArgs = new Object[] { idProvince };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROVINCEID;
			finderArgs = new Object[] { idProvince, start, end, orderByComparator };
		}

		List<ESFProvince> list = (List<ESFProvince>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFProvince esfProvince : list) {
				if (!Validator.equals(idProvince, esfProvince.getIdProvince())) {
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

			query.append(_SQL_SELECT_ESFPROVINCE_WHERE);

			boolean bindIdProvince = false;

			if (idProvince == null) {
				query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_1);
			}
			else if (idProvince.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_3);
			}
			else {
				bindIdProvince = true;

				query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFProvinceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdProvince) {
					qPos.add(idProvince);
				}

				if (!pagination) {
					list = (List<ESFProvince>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFProvince>(list);
				}
				else {
					list = (List<ESFProvince>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f province in the ordered set where idProvince = &#63;.
	 *
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince findByProvinceId_First(String idProvince,
		OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = fetchByProvinceId_First(idProvince,
				orderByComparator);

		if (esfProvince != null) {
			return esfProvince;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idProvince=");
		msg.append(idProvince);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvinceException(msg.toString());
	}

	/**
	 * Returns the first e s f province in the ordered set where idProvince = &#63;.
	 *
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince fetchByProvinceId_First(String idProvince,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFProvince> list = findByProvinceId(idProvince, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f province in the ordered set where idProvince = &#63;.
	 *
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince findByProvinceId_Last(String idProvince,
		OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = fetchByProvinceId_Last(idProvince,
				orderByComparator);

		if (esfProvince != null) {
			return esfProvince;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idProvince=");
		msg.append(idProvince);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvinceException(msg.toString());
	}

	/**
	 * Returns the last e s f province in the ordered set where idProvince = &#63;.
	 *
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince fetchByProvinceId_Last(String idProvince,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProvinceId(idProvince);

		if (count == 0) {
			return null;
		}

		List<ESFProvince> list = findByProvinceId(idProvince, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f provinces before and after the current e s f province in the ordered set where idProvince = &#63;.
	 *
	 * @param esfProvincePK the primary key of the current e s f province
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince[] findByProvinceId_PrevAndNext(
		ESFProvincePK esfProvincePK, String idProvince,
		OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = findByPrimaryKey(esfProvincePK);

		Session session = null;

		try {
			session = openSession();

			ESFProvince[] array = new ESFProvinceImpl[3];

			array[0] = getByProvinceId_PrevAndNext(session, esfProvince,
					idProvince, orderByComparator, true);

			array[1] = esfProvince;

			array[2] = getByProvinceId_PrevAndNext(session, esfProvince,
					idProvince, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFProvince getByProvinceId_PrevAndNext(Session session,
		ESFProvince esfProvince, String idProvince,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFPROVINCE_WHERE);

		boolean bindIdProvince = false;

		if (idProvince == null) {
			query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_1);
		}
		else if (idProvince.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_3);
		}
		else {
			bindIdProvince = true;

			query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_2);
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
			query.append(ESFProvinceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIdProvince) {
			qPos.add(idProvince);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfProvince);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFProvince> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f provinces where idProvince = &#63; from the database.
	 *
	 * @param idProvince the id province
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProvinceId(String idProvince) throws SystemException {
		for (ESFProvince esfProvince : findByProvinceId(idProvince,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfProvince);
		}
	}

	/**
	 * Returns the number of e s f provinces where idProvince = &#63;.
	 *
	 * @param idProvince the id province
	 * @return the number of matching e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProvinceId(String idProvince) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROVINCEID;

		Object[] finderArgs = new Object[] { idProvince };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFPROVINCE_WHERE);

			boolean bindIdProvince = false;

			if (idProvince == null) {
				query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_1);
			}
			else if (idProvince.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_3);
			}
			else {
				bindIdProvince = true;

				query.append(_FINDER_COLUMN_PROVINCEID_IDPROVINCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdProvince) {
					qPos.add(idProvince);
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

	private static final String _FINDER_COLUMN_PROVINCEID_IDPROVINCE_1 = "esfProvince.id.idProvince IS NULL";
	private static final String _FINDER_COLUMN_PROVINCEID_IDPROVINCE_2 = "esfProvince.id.idProvince = ?";
	private static final String _FINDER_COLUMN_PROVINCEID_IDPROVINCE_3 = "(esfProvince.id.idProvince IS NULL OR esfProvince.id.idProvince = '')";

	public ESFProvincePersistenceImpl() {
		setModelClass(ESFProvince.class);
	}

	/**
	 * Caches the e s f province in the entity cache if it is enabled.
	 *
	 * @param esfProvince the e s f province
	 */
	@Override
	public void cacheResult(ESFProvince esfProvince) {
		EntityCacheUtil.putResult(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceImpl.class, esfProvince.getPrimaryKey(), esfProvince);

		esfProvince.resetOriginalValues();
	}

	/**
	 * Caches the e s f provinces in the entity cache if it is enabled.
	 *
	 * @param esfProvinces the e s f provinces
	 */
	@Override
	public void cacheResult(List<ESFProvince> esfProvinces) {
		for (ESFProvince esfProvince : esfProvinces) {
			if (EntityCacheUtil.getResult(
						ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
						ESFProvinceImpl.class, esfProvince.getPrimaryKey()) == null) {
				cacheResult(esfProvince);
			}
			else {
				esfProvince.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f provinces.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFProvinceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFProvinceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f province.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFProvince esfProvince) {
		EntityCacheUtil.removeResult(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceImpl.class, esfProvince.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFProvince> esfProvinces) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFProvince esfProvince : esfProvinces) {
			EntityCacheUtil.removeResult(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
				ESFProvinceImpl.class, esfProvince.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f province with the primary key. Does not add the e s f province to the database.
	 *
	 * @param esfProvincePK the primary key for the new e s f province
	 * @return the new e s f province
	 */
	@Override
	public ESFProvince create(ESFProvincePK esfProvincePK) {
		ESFProvince esfProvince = new ESFProvinceImpl();

		esfProvince.setNew(true);
		esfProvince.setPrimaryKey(esfProvincePK);

		return esfProvince;
	}

	/**
	 * Removes the e s f province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfProvincePK the primary key of the e s f province
	 * @return the e s f province that was removed
	 * @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince remove(ESFProvincePK esfProvincePK)
		throws NoSuchProvinceException, SystemException {
		return remove((Serializable)esfProvincePK);
	}

	/**
	 * Removes the e s f province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f province
	 * @return the e s f province that was removed
	 * @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince remove(Serializable primaryKey)
		throws NoSuchProvinceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFProvince esfProvince = (ESFProvince)session.get(ESFProvinceImpl.class,
					primaryKey);

			if (esfProvince == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProvinceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfProvince);
		}
		catch (NoSuchProvinceException nsee) {
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
	protected ESFProvince removeImpl(ESFProvince esfProvince)
		throws SystemException {
		esfProvince = toUnwrappedModel(esfProvince);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfProvince)) {
				esfProvince = (ESFProvince)session.get(ESFProvinceImpl.class,
						esfProvince.getPrimaryKeyObj());
			}

			if (esfProvince != null) {
				session.delete(esfProvince);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfProvince != null) {
			clearCache(esfProvince);
		}

		return esfProvince;
	}

	@Override
	public ESFProvince updateImpl(it.ethica.esf.model.ESFProvince esfProvince)
		throws SystemException {
		esfProvince = toUnwrappedModel(esfProvince);

		boolean isNew = esfProvince.isNew();

		ESFProvinceModelImpl esfProvinceModelImpl = (ESFProvinceModelImpl)esfProvince;

		Session session = null;

		try {
			session = openSession();

			if (esfProvince.isNew()) {
				session.save(esfProvince);

				esfProvince.setNew(false);
			}
			else {
				session.merge(esfProvince);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFProvinceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfProvinceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfProvinceModelImpl.getOriginalIdRegion(),
						esfProvinceModelImpl.getOriginalIdCountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R,
					args);

				args = new Object[] {
						esfProvinceModelImpl.getIdRegion(),
						esfProvinceModelImpl.getIdCountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R,
					args);
			}

			if ((esfProvinceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVINCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfProvinceModelImpl.getOriginalIdProvince()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVINCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVINCEID,
					args);

				args = new Object[] { esfProvinceModelImpl.getIdProvince() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVINCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVINCEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ESFProvinceImpl.class, esfProvince.getPrimaryKey(), esfProvince);

		return esfProvince;
	}

	protected ESFProvince toUnwrappedModel(ESFProvince esfProvince) {
		if (esfProvince instanceof ESFProvinceImpl) {
			return esfProvince;
		}

		ESFProvinceImpl esfProvinceImpl = new ESFProvinceImpl();

		esfProvinceImpl.setNew(esfProvince.isNew());
		esfProvinceImpl.setPrimaryKey(esfProvince.getPrimaryKey());

		esfProvinceImpl.setIdProvince(esfProvince.getIdProvince());
		esfProvinceImpl.setIdRegion(esfProvince.getIdRegion());
		esfProvinceImpl.setIdCountry(esfProvince.getIdCountry());
		esfProvinceImpl.setName(esfProvince.getName());

		return esfProvinceImpl;
	}

	/**
	 * Returns the e s f province with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f province
	 * @return the e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProvinceException, SystemException {
		ESFProvince esfProvince = fetchByPrimaryKey(primaryKey);

		if (esfProvince == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProvinceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfProvince;
	}

	/**
	 * Returns the e s f province with the primary key or throws a {@link it.ethica.esf.NoSuchProvinceException} if it could not be found.
	 *
	 * @param esfProvincePK the primary key of the e s f province
	 * @return the e s f province
	 * @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince findByPrimaryKey(ESFProvincePK esfProvincePK)
		throws NoSuchProvinceException, SystemException {
		return findByPrimaryKey((Serializable)esfProvincePK);
	}

	/**
	 * Returns the e s f province with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f province
	 * @return the e s f province, or <code>null</code> if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFProvince esfProvince = (ESFProvince)EntityCacheUtil.getResult(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
				ESFProvinceImpl.class, primaryKey);

		if (esfProvince == _nullESFProvince) {
			return null;
		}

		if (esfProvince == null) {
			Session session = null;

			try {
				session = openSession();

				esfProvince = (ESFProvince)session.get(ESFProvinceImpl.class,
						primaryKey);

				if (esfProvince != null) {
					cacheResult(esfProvince);
				}
				else {
					EntityCacheUtil.putResult(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
						ESFProvinceImpl.class, primaryKey, _nullESFProvince);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFProvinceModelImpl.ENTITY_CACHE_ENABLED,
					ESFProvinceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfProvince;
	}

	/**
	 * Returns the e s f province with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfProvincePK the primary key of the e s f province
	 * @return the e s f province, or <code>null</code> if a e s f province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFProvince fetchByPrimaryKey(ESFProvincePK esfProvincePK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfProvincePK);
	}

	/**
	 * Returns all the e s f provinces.
	 *
	 * @return the e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f provinces
	 * @param end the upper bound of the range of e s f provinces (not inclusive)
	 * @return the range of e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f provinces
	 * @param end the upper bound of the range of e s f provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFProvince> findAll(int start, int end,
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

		List<ESFProvince> list = (List<ESFProvince>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFPROVINCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFPROVINCE;

				if (pagination) {
					sql = sql.concat(ESFProvinceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFProvince>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFProvince>(list);
				}
				else {
					list = (List<ESFProvince>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f provinces from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFProvince esfProvince : findAll()) {
			remove(esfProvince);
		}
	}

	/**
	 * Returns the number of e s f provinces.
	 *
	 * @return the number of e s f provinces
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

				Query q = session.createQuery(_SQL_COUNT_ESFPROVINCE);

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
	 * Initializes the e s f province persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFProvince")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFProvince>> listenersList = new ArrayList<ModelListener<ESFProvince>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFProvince>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFProvinceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFPROVINCE = "SELECT esfProvince FROM ESFProvince esfProvince";
	private static final String _SQL_SELECT_ESFPROVINCE_WHERE = "SELECT esfProvince FROM ESFProvince esfProvince WHERE ";
	private static final String _SQL_COUNT_ESFPROVINCE = "SELECT COUNT(esfProvince) FROM ESFProvince esfProvince";
	private static final String _SQL_COUNT_ESFPROVINCE_WHERE = "SELECT COUNT(esfProvince) FROM ESFProvince esfProvince WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfProvince.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFProvince exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFProvince exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFProvincePersistenceImpl.class);
	private static ESFProvince _nullESFProvince = new ESFProvinceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFProvince> toCacheModel() {
				return _nullESFProvinceCacheModel;
			}
		};

	private static CacheModel<ESFProvince> _nullESFProvinceCacheModel = new CacheModel<ESFProvince>() {
			@Override
			public ESFProvince toEntityModel() {
				return _nullESFProvince;
			}
		};
}