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

import it.ethica.esf.NoSuchCityException;
import it.ethica.esf.model.City;
import it.ethica.esf.model.impl.CityImpl;
import it.ethica.esf.model.impl.CityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see CityPersistence
 * @see CityUtil
 * @generated
 */
public class CityPersistenceImpl extends BasePersistenceImpl<City>
	implements CityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CityUtil} to access the city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityModelImpl.FINDER_CACHE_ENABLED, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityModelImpl.FINDER_CACHE_ENABLED, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_P = new FinderPath(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityModelImpl.FINDER_CACHE_ENABLED, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P = new FinderPath(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityModelImpl.FINDER_CACHE_ENABLED, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			CityModelImpl.IDCOUNTRY_COLUMN_BITMASK |
			CityModelImpl.IDREGION_COLUMN_BITMASK |
			CityModelImpl.IDPROVINCE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R_P = new FinderPath(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R_P",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @return the matching cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<City> findByC_R_P(String idCountry, String idRegion,
		String idProvince) throws SystemException {
		return findByC_R_P(idCountry, idRegion, idProvince, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of matching cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<City> findByC_R_P(String idCountry, String idRegion,
		String idProvince, int start, int end) throws SystemException {
		return findByC_R_P(idCountry, idRegion, idProvince, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<City> findByC_R_P(String idCountry, String idRegion,
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

		List<City> list = (List<City>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (City city : list) {
				if (!Validator.equals(idCountry, city.getIdCountry()) ||
						!Validator.equals(idRegion, city.getIdRegion()) ||
						!Validator.equals(idProvince, city.getIdProvince())) {
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

			query.append(_SQL_SELECT_CITY_WHERE);

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
				query.append(CityModelImpl.ORDER_BY_JPQL);
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
					list = (List<City>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<City>(list);
				}
				else {
					list = (List<City>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws it.ethica.esf.NoSuchCityException if a matching city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City findByC_R_P_First(String idCountry, String idRegion,
		String idProvince, OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		City city = fetchByC_R_P_First(idCountry, idRegion, idProvince,
				orderByComparator);

		if (city != null) {
			return city;
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
	 * Returns the first city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City fetchByC_R_P_First(String idCountry, String idRegion,
		String idProvince, OrderByComparator orderByComparator)
		throws SystemException {
		List<City> list = findByC_R_P(idCountry, idRegion, idProvince, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws it.ethica.esf.NoSuchCityException if a matching city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City findByC_R_P_Last(String idCountry, String idRegion,
		String idProvince, OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		City city = fetchByC_R_P_Last(idCountry, idRegion, idProvince,
				orderByComparator);

		if (city != null) {
			return city;
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
	 * Returns the last city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City fetchByC_R_P_Last(String idCountry, String idRegion,
		String idProvince, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_R_P(idCountry, idRegion, idProvince);

		if (count == 0) {
			return null;
		}

		List<City> list = findByC_R_P(idCountry, idRegion, idProvince,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cities before and after the current city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param cityPK the primary key of the current city
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City[] findByC_R_P_PrevAndNext(CityPK cityPK, String idCountry,
		String idRegion, String idProvince, OrderByComparator orderByComparator)
		throws NoSuchCityException, SystemException {
		City city = findByPrimaryKey(cityPK);

		Session session = null;

		try {
			session = openSession();

			City[] array = new CityImpl[3];

			array[0] = getByC_R_P_PrevAndNext(session, city, idCountry,
					idRegion, idProvince, orderByComparator, true);

			array[1] = city;

			array[2] = getByC_R_P_PrevAndNext(session, city, idCountry,
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

	protected City getByC_R_P_PrevAndNext(Session session, City city,
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

		query.append(_SQL_SELECT_CITY_WHERE);

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
			query.append(CityModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(city);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<City> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63; from the database.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_R_P(String idCountry, String idRegion,
		String idProvince) throws SystemException {
		for (City city : findByC_R_P(idCountry, idRegion, idProvince,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(city);
		}
	}

	/**
	 * Returns the number of cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	 *
	 * @param idCountry the id country
	 * @param idRegion the id region
	 * @param idProvince the id province
	 * @return the number of matching cities
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

			query.append(_SQL_COUNT_CITY_WHERE);

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

	private static final String _FINDER_COLUMN_C_R_P_IDCOUNTRY_1 = "city.id.idCountry IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDCOUNTRY_2 = "city.id.idCountry = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDCOUNTRY_3 = "(city.id.idCountry IS NULL OR city.id.idCountry = '') AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDREGION_1 = "city.id.idRegion IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDREGION_2 = "city.id.idRegion = ? AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDREGION_3 = "(city.id.idRegion IS NULL OR city.id.idRegion = '') AND ";
	private static final String _FINDER_COLUMN_C_R_P_IDPROVINCE_1 = "city.id.idProvince IS NULL";
	private static final String _FINDER_COLUMN_C_R_P_IDPROVINCE_2 = "city.id.idProvince = ?";
	private static final String _FINDER_COLUMN_C_R_P_IDPROVINCE_3 = "(city.id.idProvince IS NULL OR city.id.idProvince = '')";

	public CityPersistenceImpl() {
		setModelClass(City.class);
	}

	/**
	 * Caches the city in the entity cache if it is enabled.
	 *
	 * @param city the city
	 */
	@Override
	public void cacheResult(City city) {
		EntityCacheUtil.putResult(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityImpl.class, city.getPrimaryKey(), city);

		city.resetOriginalValues();
	}

	/**
	 * Caches the cities in the entity cache if it is enabled.
	 *
	 * @param cities the cities
	 */
	@Override
	public void cacheResult(List<City> cities) {
		for (City city : cities) {
			if (EntityCacheUtil.getResult(CityModelImpl.ENTITY_CACHE_ENABLED,
						CityImpl.class, city.getPrimaryKey()) == null) {
				cacheResult(city);
			}
			else {
				city.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the city.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(City city) {
		EntityCacheUtil.removeResult(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityImpl.class, city.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<City> cities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (City city : cities) {
			EntityCacheUtil.removeResult(CityModelImpl.ENTITY_CACHE_ENABLED,
				CityImpl.class, city.getPrimaryKey());
		}
	}

	/**
	 * Creates a new city with the primary key. Does not add the city to the database.
	 *
	 * @param cityPK the primary key for the new city
	 * @return the new city
	 */
	@Override
	public City create(CityPK cityPK) {
		City city = new CityImpl();

		city.setNew(true);
		city.setPrimaryKey(cityPK);

		return city;
	}

	/**
	 * Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityPK the primary key of the city
	 * @return the city that was removed
	 * @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City remove(CityPK cityPK)
		throws NoSuchCityException, SystemException {
		return remove((Serializable)cityPK);
	}

	/**
	 * Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the city
	 * @return the city that was removed
	 * @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City remove(Serializable primaryKey)
		throws NoSuchCityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			City city = (City)session.get(CityImpl.class, primaryKey);

			if (city == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(city);
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
	protected City removeImpl(City city) throws SystemException {
		city = toUnwrappedModel(city);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(city)) {
				city = (City)session.get(CityImpl.class, city.getPrimaryKeyObj());
			}

			if (city != null) {
				session.delete(city);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (city != null) {
			clearCache(city);
		}

		return city;
	}

	@Override
	public City updateImpl(it.ethica.esf.model.City city)
		throws SystemException {
		city = toUnwrappedModel(city);

		boolean isNew = city.isNew();

		CityModelImpl cityModelImpl = (CityModelImpl)city;

		Session session = null;

		try {
			session = openSession();

			if (city.isNew()) {
				session.save(city);

				city.setNew(false);
			}
			else {
				session.merge(city);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cityModelImpl.getOriginalIdCountry(),
						cityModelImpl.getOriginalIdRegion(),
						cityModelImpl.getOriginalIdProvince()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P,
					args);

				args = new Object[] {
						cityModelImpl.getIdCountry(),
						cityModelImpl.getIdRegion(),
						cityModelImpl.getIdProvince()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_P,
					args);
			}
		}

		EntityCacheUtil.putResult(CityModelImpl.ENTITY_CACHE_ENABLED,
			CityImpl.class, city.getPrimaryKey(), city);

		return city;
	}

	protected City toUnwrappedModel(City city) {
		if (city instanceof CityImpl) {
			return city;
		}

		CityImpl cityImpl = new CityImpl();

		cityImpl.setNew(city.isNew());
		cityImpl.setPrimaryKey(city.getPrimaryKey());

		cityImpl.setIdCity(city.getIdCity());
		cityImpl.setIdProvince(city.getIdProvince());
		cityImpl.setIdRegion(city.getIdRegion());
		cityImpl.setIdCountry(city.getIdCountry());
		cityImpl.setZip(city.getZip());
		cityImpl.setName(city.getName());
		cityImpl.setLatitude(city.getLatitude());
		cityImpl.setLongitude(city.getLongitude());
		cityImpl.setAltitude(city.getAltitude());
		cityImpl.setWebsite(city.getWebsite());

		return cityImpl;
	}

	/**
	 * Returns the city with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the city
	 * @return the city
	 * @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCityException, SystemException {
		City city = fetchByPrimaryKey(primaryKey);

		if (city == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return city;
	}

	/**
	 * Returns the city with the primary key or throws a {@link it.ethica.esf.NoSuchCityException} if it could not be found.
	 *
	 * @param cityPK the primary key of the city
	 * @return the city
	 * @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City findByPrimaryKey(CityPK cityPK)
		throws NoSuchCityException, SystemException {
		return findByPrimaryKey((Serializable)cityPK);
	}

	/**
	 * Returns the city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the city
	 * @return the city, or <code>null</code> if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		City city = (City)EntityCacheUtil.getResult(CityModelImpl.ENTITY_CACHE_ENABLED,
				CityImpl.class, primaryKey);

		if (city == _nullCity) {
			return null;
		}

		if (city == null) {
			Session session = null;

			try {
				session = openSession();

				city = (City)session.get(CityImpl.class, primaryKey);

				if (city != null) {
					cacheResult(city);
				}
				else {
					EntityCacheUtil.putResult(CityModelImpl.ENTITY_CACHE_ENABLED,
						CityImpl.class, primaryKey, _nullCity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CityModelImpl.ENTITY_CACHE_ENABLED,
					CityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return city;
	}

	/**
	 * Returns the city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cityPK the primary key of the city
	 * @return the city, or <code>null</code> if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City fetchByPrimaryKey(CityPK cityPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)cityPK);
	}

	/**
	 * Returns all the cities.
	 *
	 * @return the cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<City> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<City> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<City> findAll(int start, int end,
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

		List<City> list = (List<City>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CITY;

				if (pagination) {
					sql = sql.concat(CityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<City>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<City>(list);
				}
				else {
					list = (List<City>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the cities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (City city : findAll()) {
			remove(city);
		}
	}

	/**
	 * Returns the number of cities.
	 *
	 * @return the number of cities
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

				Query q = session.createQuery(_SQL_COUNT_CITY);

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
	 * Initializes the city persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.City")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<City>> listenersList = new ArrayList<ModelListener<City>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<City>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CITY = "SELECT city FROM City city";
	private static final String _SQL_SELECT_CITY_WHERE = "SELECT city FROM City city WHERE ";
	private static final String _SQL_COUNT_CITY = "SELECT COUNT(city) FROM City city";
	private static final String _SQL_COUNT_CITY_WHERE = "SELECT COUNT(city) FROM City city WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "city.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No City exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No City exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CityPersistenceImpl.class);
	private static City _nullCity = new CityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<City> toCacheModel() {
				return _nullCityCacheModel;
			}
		};

	private static CacheModel<City> _nullCityCacheModel = new CacheModel<City>() {
			@Override
			public City toEntityModel() {
				return _nullCity;
			}
		};
}