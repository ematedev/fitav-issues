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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchCityException;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.impl.ESFCityImpl;
import it.ethica.esf.model.impl.ESFCityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCityPersistence
 * @see ESFCityUtil
 * @generated
 */
public class ESFCityPersistenceImpl extends BasePersistenceImpl<ESFCity>
	implements ESFCityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFCityUtil} to access the e s f city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFCityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, ESFCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, ESFCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_P = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, ESFCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, ESFCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ESFCityModelImpl.IDCOUNTRY_COLUMN_BITMASK |
			ESFCityModelImpl.IDREGION_COLUMN_BITMASK |
			ESFCityModelImpl.IDPROVINCE_COLUMN_BITMASK |
			ESFCityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R_P = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @return the matching e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findByC_R_P(String idCountry, String idRegion,
		String idProvince) throws SystemException {
		return findByC_R_P(idCountry, idRegion, idProvince, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param start the lower bound of the range of e s f cities
	 * @param end the upper bound of the range of e s f cities (not inclusive)
	 * @return the range of matching e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findByC_R_P(String idCountry, String idRegion,
		String idProvince, int start, int end) throws SystemException {
		return findByC_R_P(idCountry, idRegion, idProvince, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param start the lower bound of the range of e s f cities
	 * @param end the upper bound of the range of e s f cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findByC_R_P(String idCountry, String idRegion,
		String idProvince, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P;
			finderArgs = new Object[] { idCountry, idRegion, idProvince };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_P;
			finderArgs = new Object[] {
					idCountry, idRegion, idProvince,
					
					start, end, orderByComparator
				};
		}

		List<ESFCity> list = (List<ESFCity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCity esfCity : list) {
				if (!Validator.equals(idCountry, esfCity.getIdCountry()) ||
						!Validator.equals(idRegion, esfCity.getIdRegion()) ||
						!Validator.equals(idProvince, esfCity.getIdProvince())) {
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

			query.append(_SQL_SELECT_ESFCITY_WHERE);

			boolean bindIdCountry = false;

			if (idCountry == null) {
				query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_1);
			}
			else if (idCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_3);
			}
			else {
				bindIdCountry = true;

				query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_2);
			}

			boolean bindIdRegion = false;

			if (idRegion == null) {
				query.append(_FINDER_COLUMN_C_R_P_IDREGION_1);
			}
			else if (idRegion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_IDREGION_3);
			}
			else {
				bindIdRegion = true;

				query.append(_FINDER_COLUMN_C_R_P_IDREGION_2);
			}

			boolean bindIdProvince = false;

			if (idProvince == null) {
				query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_1);
			}
			else if (idProvince.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_3);
			}
			else {
				bindIdProvince = true;

				query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCityModelImpl.ORDER_BY_JPQL);
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

				if (bindIdRegion) {
					qPos.add(idRegion);
				}

				if (bindIdProvince) {
					qPos.add(idProvince);
				}

				if (!pagination) {
					list = (List<ESFCity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCity>(list);
				}
				else {
					list = (List<ESFCity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f city
	 * @throws it.ethica.esf.NoSuchCityException if a matching e s f city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity findByC_R_P_First(String idCountry, String idRegion,
		String idProvince, OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		ESFCity esfCity = fetchByC_R_P_First(idCountry, idRegion, idProvince,
				orderByComparator);

		if (esfCity != null) {
			return esfCity;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idCountry=");
		msg.append(idCountry);

		msg.append(", idRegion=");
		msg.append(idRegion);

		msg.append(", idProvince=");
		msg.append(idProvince);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityException(msg.toString());
	}

	/**
	 * Returns the first e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f city, or <code>null</code> if a matching e s f city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity fetchByC_R_P_First(String idCountry, String idRegion,
		String idProvince, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFCity> list = findByC_R_P(idCountry, idRegion, idProvince, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f city
	 * @throws it.ethica.esf.NoSuchCityException if a matching e s f city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity findByC_R_P_Last(String idCountry, String idRegion,
		String idProvince, OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		ESFCity esfCity = fetchByC_R_P_Last(idCountry, idRegion, idProvince,
				orderByComparator);

		if (esfCity != null) {
			return esfCity;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idCountry=");
		msg.append(idCountry);

		msg.append(", idRegion=");
		msg.append(idRegion);

		msg.append(", idProvince=");
		msg.append(idProvince);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityException(msg.toString());
	}

	/**
	 * Returns the last e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f city, or <code>null</code> if a matching e s f city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity fetchByC_R_P_Last(String idCountry, String idRegion,
		String idProvince, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_R_P(idCountry, idRegion, idProvince);

		if (count == 0) {
			return null;
		}

		List<ESFCity> list = findByC_R_P(idCountry, idRegion, idProvince,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cities before and after the current e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param esfCityPK the primary key of the current e s f city
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f city
	 * @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity[] findByC_R_P_PrevAndNext(ESFCityPK esfCityPK,
		String idCountry, String idRegion, String idProvince,
		OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		ESFCity esfCity = findByPrimaryKey(esfCityPK);

		Session session = null;

		try {
			session = openSession();

			ESFCity[] array = new ESFCityImpl[3];

			array[0] = getByC_R_P_PrevAndNext(session, esfCity, idCountry,
					idRegion, idProvince, orderByComparator, true);

			array[1] = esfCity;

			array[2] = getByC_R_P_PrevAndNext(session, esfCity, idCountry,
					idRegion, idProvince, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFCity getByC_R_P_PrevAndNext(Session session, ESFCity esfCity,
		String idCountry, String idRegion, String idProvince,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCITY_WHERE);

		boolean bindIdCountry = false;

		if (idCountry == null) {
			query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_1);
		}
		else if (idCountry.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_3);
		}
		else {
			bindIdCountry = true;

			query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_2);
		}

		boolean bindIdRegion = false;

		if (idRegion == null) {
			query.append(_FINDER_COLUMN_C_R_P_IDREGION_1);
		}
		else if (idRegion.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_P_IDREGION_3);
		}
		else {
			bindIdRegion = true;

			query.append(_FINDER_COLUMN_C_R_P_IDREGION_2);
		}

		boolean bindIdProvince = false;

		if (idProvince == null) {
			query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_1);
		}
		else if (idProvince.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_3);
		}
		else {
			bindIdProvince = true;

			query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_2);
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
			query.append(ESFCityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIdCountry) {
			qPos.add(idCountry);
		}

		if (bindIdRegion) {
			qPos.add(idRegion);
		}

		if (bindIdProvince) {
			qPos.add(idProvince);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63; from the database.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_R_P(String idCountry, String idRegion,
		String idProvince) throws SystemException {
		for (ESFCity esfCity : findByC_R_P(idCountry, idRegion, idProvince,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfCity);
		}
	}

	/**
	 * Returns the number of e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @return the number of matching e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_R_P(String idCountry, String idRegion, String idProvince)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R_P;

		Object[] finderArgs = new Object[] { idCountry, idRegion, idProvince };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFCITY_WHERE);

			boolean bindIdCountry = false;

			if (idCountry == null) {
				query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_1);
			}
			else if (idCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_3);
			}
			else {
				bindIdCountry = true;

				query.append(_FINDER_COLUMN_C_R_P_IDCOUNTRY_2);
			}

			boolean bindIdRegion = false;

			if (idRegion == null) {
				query.append(_FINDER_COLUMN_C_R_P_IDREGION_1);
			}
			else if (idRegion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_IDREGION_3);
			}
			else {
				bindIdRegion = true;

				query.append(_FINDER_COLUMN_C_R_P_IDREGION_2);
			}

			boolean bindIdProvince = false;

			if (idProvince == null) {
				query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_1);
			}
			else if (idProvince.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_3);
			}
			else {
				bindIdProvince = true;

				query.append(_FINDER_COLUMN_C_R_P_IDPROVINCE_2);
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

				if (bindIdRegion) {
					qPos.add(idRegion);
				}

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

	private static final String _FINDER_COLUMN_C_R_P_IDCOUNTRY_1 = "esfCity.id.idCountry IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDCOUNTRY_2 = "esfCity.id.idCountry = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDCOUNTRY_3 = "(esfCity.id.idCountry IS NULL OR esfCity.id.idCountry = '') AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDREGION_1 = "esfCity.id.idRegion IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDREGION_2 = "esfCity.id.idRegion = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDREGION_3 = "(esfCity.id.idRegion IS NULL OR esfCity.id.idRegion = '') AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDPROVINCE_1 = "esfCity.id.idProvince IS NULL";
	private static final String _FINDER_COLUMN_C_R_P_IDPROVINCE_2 = "esfCity.id.idProvince = ?";
	private static final String _FINDER_COLUMN_C_R_P_IDPROVINCE_3 = "(esfCity.id.idProvince IS NULL OR esfCity.id.idProvince = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, ESFCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, ESFCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			ESFCityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f cities where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cities where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f cities
	 * @param end the upper bound of the range of e s f cities (not inclusive)
	 * @return the range of matching e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cities where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f cities
	 * @param end the upper bound of the range of e s f cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findByName(String name, int start, int end,
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

		List<ESFCity> list = (List<ESFCity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCity esfCity : list) {
				if (!Validator.equals(name, esfCity.getName())) {
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

			query.append(_SQL_SELECT_ESFCITY_WHERE);

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
				query.append(ESFCityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				if (!pagination) {
					list = (List<ESFCity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCity>(list);
				}
				else {
					list = (List<ESFCity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f city in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f city
	 * @throws it.ethica.esf.NoSuchCityException if a matching e s f city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		ESFCity esfCity = fetchByName_First(name, orderByComparator);

		if (esfCity != null) {
			return esfCity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityException(msg.toString());
	}

	/**
	 * Returns the first e s f city in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f city, or <code>null</code> if a matching e s f city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCity> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f city in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f city
	 * @throws it.ethica.esf.NoSuchCityException if a matching e s f city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		ESFCity esfCity = fetchByName_Last(name, orderByComparator);

		if (esfCity != null) {
			return esfCity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityException(msg.toString());
	}

	/**
	 * Returns the last e s f city in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f city, or <code>null</code> if a matching e s f city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ESFCity> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f cities before and after the current e s f city in the ordered set where name = &#63;.
	 *
	 * @param esfCityPK the primary key of the current e s f city
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f city
	 * @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity[] findByName_PrevAndNext(ESFCityPK esfCityPK, String name,
		OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		ESFCity esfCity = findByPrimaryKey(esfCityPK);

		Session session = null;

		try {
			session = openSession();

			ESFCity[] array = new ESFCityImpl[3];

			array[0] = getByName_PrevAndNext(session, esfCity, name,
					orderByComparator, true);

			array[1] = esfCity;

			array[2] = getByName_PrevAndNext(session, esfCity, name,
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

	protected ESFCity getByName_PrevAndNext(Session session, ESFCity esfCity,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCITY_WHERE);

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
			query.append(ESFCityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f cities where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ESFCity esfCity : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCity);
		}
	}

	/**
	 * Returns the number of e s f cities where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f cities
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

			query.append(_SQL_COUNT_ESFCITY_WHERE);

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
					qPos.add(name.toLowerCase());
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfCity.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "lower(esfCity.name) = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfCity.name IS NULL OR esfCity.name = '')";

	public ESFCityPersistenceImpl() {
		setModelClass(ESFCity.class);
	}

	/**
	 * Caches the e s f city in the entity cache if it is enabled.
	 *
	 * @param esfCity the e s f city
	 */
	@Override
	public void cacheResult(ESFCity esfCity) {
		EntityCacheUtil.putResult(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityImpl.class, esfCity.getPrimaryKey(), esfCity);

		esfCity.resetOriginalValues();
	}

	/**
	 * Caches the e s f cities in the entity cache if it is enabled.
	 *
	 * @param esfCities the e s f cities
	 */
	@Override
	public void cacheResult(List<ESFCity> esfCities) {
		for (ESFCity esfCity : esfCities) {
			if (EntityCacheUtil.getResult(
						ESFCityModelImpl.ENTITY_CACHE_ENABLED,
						ESFCityImpl.class, esfCity.getPrimaryKey()) == null) {
				cacheResult(esfCity);
			}
			else {
				esfCity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f cities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFCityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFCityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f city.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFCity esfCity) {
		EntityCacheUtil.removeResult(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityImpl.class, esfCity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFCity> esfCities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFCity esfCity : esfCities) {
			EntityCacheUtil.removeResult(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
				ESFCityImpl.class, esfCity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f city with the primary key. Does not add the e s f city to the database.
	 *
	 * @param esfCityPK the primary key for the new e s f city
	 * @return the new e s f city
	 */
	@Override
	public ESFCity create(ESFCityPK esfCityPK) {
		ESFCity esfCity = new ESFCityImpl();

		esfCity.setNew(true);
		esfCity.setPrimaryKey(esfCityPK);

		return esfCity;
	}

	/**
	 * Removes the e s f city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfCityPK the primary key of the e s f city
	 * @return the e s f city that was removed
	 * @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity remove(ESFCityPK esfCityPK)
		throws NoSuchCityException, SystemException {
		return remove((Serializable)esfCityPK);
	}

	/**
	 * Removes the e s f city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f city
	 * @return the e s f city that was removed
	 * @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity remove(Serializable primaryKey)
		throws NoSuchCityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFCity esfCity = (ESFCity)session.get(ESFCityImpl.class, primaryKey);

			if (esfCity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfCity);
		}
		catch (NoSuchCityException nsee) {
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
	protected ESFCity removeImpl(ESFCity esfCity) throws SystemException {
		esfCity = toUnwrappedModel(esfCity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfCity)) {
				esfCity = (ESFCity)session.get(ESFCityImpl.class,
						esfCity.getPrimaryKeyObj());
			}

			if (esfCity != null) {
				session.delete(esfCity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfCity != null) {
			clearCache(esfCity);
		}

		return esfCity;
	}

	@Override
	public ESFCity updateImpl(it.ethica.esf.model.ESFCity esfCity)
		throws SystemException {
		esfCity = toUnwrappedModel(esfCity);

		boolean isNew = esfCity.isNew();

		ESFCityModelImpl esfCityModelImpl = (ESFCityModelImpl)esfCity;

		Session session = null;

		try {
			session = openSession();

			if (esfCity.isNew()) {
				session.save(esfCity);

				esfCity.setNew(false);
			}
			else {
				session.merge(esfCity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFCityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfCityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCityModelImpl.getOriginalIdCountry(),
						esfCityModelImpl.getOriginalIdRegion(),
						esfCityModelImpl.getOriginalIdProvince()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P,
					args);

				args = new Object[] {
						esfCityModelImpl.getIdCountry(),
						esfCityModelImpl.getIdRegion(),
						esfCityModelImpl.getIdProvince()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P,
					args);
			}

			if ((esfCityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfCityModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { esfCityModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
			ESFCityImpl.class, esfCity.getPrimaryKey(), esfCity);

		return esfCity;
	}

	protected ESFCity toUnwrappedModel(ESFCity esfCity) {
		if (esfCity instanceof ESFCityImpl) {
			return esfCity;
		}

		ESFCityImpl esfCityImpl = new ESFCityImpl();

		esfCityImpl.setNew(esfCity.isNew());
		esfCityImpl.setPrimaryKey(esfCity.getPrimaryKey());

		esfCityImpl.setIdCity(esfCity.getIdCity());
		esfCityImpl.setIdProvince(esfCity.getIdProvince());
		esfCityImpl.setIdRegion(esfCity.getIdRegion());
		esfCityImpl.setIdCountry(esfCity.getIdCountry());
		esfCityImpl.setZip(esfCity.getZip());
		esfCityImpl.setName(esfCity.getName());
		esfCityImpl.setLatitude(esfCity.getLatitude());
		esfCityImpl.setLongitude(esfCity.getLongitude());
		esfCityImpl.setAltitude(esfCity.getAltitude());
		esfCityImpl.setWebsite(esfCity.getWebsite());

		return esfCityImpl;
	}

	/**
	 * Returns the e s f city with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f city
	 * @return the e s f city
	 * @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCityException, SystemException {
		ESFCity esfCity = fetchByPrimaryKey(primaryKey);

		if (esfCity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfCity;
	}

	/**
	 * Returns the e s f city with the primary key or throws a {@link it.ethica.esf.NoSuchCityException} if it could not be found.
	 *
	 * @param esfCityPK the primary key of the e s f city
	 * @return the e s f city
	 * @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity findByPrimaryKey(ESFCityPK esfCityPK)
		throws NoSuchCityException, SystemException {
		return findByPrimaryKey((Serializable)esfCityPK);
	}

	/**
	 * Returns the e s f city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f city
	 * @return the e s f city, or <code>null</code> if a e s f city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFCity esfCity = (ESFCity)EntityCacheUtil.getResult(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
				ESFCityImpl.class, primaryKey);

		if (esfCity == _nullESFCity) {
			return null;
		}

		if (esfCity == null) {
			Session session = null;

			try {
				session = openSession();

				esfCity = (ESFCity)session.get(ESFCityImpl.class, primaryKey);

				if (esfCity != null) {
					cacheResult(esfCity);
				}
				else {
					EntityCacheUtil.putResult(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
						ESFCityImpl.class, primaryKey, _nullESFCity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFCityModelImpl.ENTITY_CACHE_ENABLED,
					ESFCityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfCity;
	}

	/**
	 * Returns the e s f city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfCityPK the primary key of the e s f city
	 * @return the e s f city, or <code>null</code> if a e s f city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCity fetchByPrimaryKey(ESFCityPK esfCityPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfCityPK);
	}

	/**
	 * Returns all the e s f cities.
	 *
	 * @return the e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f cities
	 * @param end the upper bound of the range of e s f cities (not inclusive)
	 * @return the range of e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f cities
	 * @param end the upper bound of the range of e s f cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCity> findAll(int start, int end,
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

		List<ESFCity> list = (List<ESFCity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFCITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFCITY;

				if (pagination) {
					sql = sql.concat(ESFCityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFCity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCity>(list);
				}
				else {
					list = (List<ESFCity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f cities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFCity esfCity : findAll()) {
			remove(esfCity);
		}
	}

	/**
	 * Returns the number of e s f cities.
	 *
	 * @return the number of e s f cities
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

				Query q = session.createQuery(_SQL_COUNT_ESFCITY);

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
	 * Initializes the e s f city persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFCity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFCity>> listenersList = new ArrayList<ModelListener<ESFCity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFCity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFCityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFCITY = "SELECT esfCity FROM ESFCity esfCity";
	private static final String _SQL_SELECT_ESFCITY_WHERE = "SELECT esfCity FROM ESFCity esfCity WHERE ";
	private static final String _SQL_COUNT_ESFCITY = "SELECT COUNT(esfCity) FROM ESFCity esfCity";
	private static final String _SQL_COUNT_ESFCITY_WHERE = "SELECT COUNT(esfCity) FROM ESFCity esfCity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfCity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFCity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFCity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFCityPersistenceImpl.class);
	private static ESFCity _nullESFCity = new ESFCityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFCity> toCacheModel() {
				return _nullESFCityCacheModel;
			}
		};

	private static CacheModel<ESFCity> _nullESFCityCacheModel = new CacheModel<ESFCity>() {
			@Override
			public ESFCity toEntityModel() {
				return _nullESFCity;
			}
		};
}