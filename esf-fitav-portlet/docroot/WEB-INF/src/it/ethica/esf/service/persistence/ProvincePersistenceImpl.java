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

import it.ethica.esf.NoSuchProvinceException;
import it.ethica.esf.model.Province;
import it.ethica.esf.model.impl.ProvinceImpl;
import it.ethica.esf.model.impl.ProvinceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the province service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ProvincePersistence
 * @see ProvinceUtil
 * @generated
 */
public class ProvincePersistenceImpl extends BasePersistenceImpl<Province>
	implements ProvincePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProvinceUtil} to access the province persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProvinceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceModelImpl.FINDER_CACHE_ENABLED, ProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceModelImpl.FINDER_CACHE_ENABLED, ProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R = new FinderPath(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceModelImpl.FINDER_CACHE_ENABLED, ProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R = new FinderPath(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceModelImpl.FINDER_CACHE_ENABLED, ProvinceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R",
			new String[] { String.class.getName(), String.class.getName() },
			ProvinceModelImpl.IDREGION_COLUMN_BITMASK |
			ProvinceModelImpl.IDCOUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R = new FinderPath(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the provinces where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @return the matching provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Province> findByC_R(String idRegion, String idCountry)
		throws SystemException {
		return findByC_R(idRegion, idCountry, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provinces where idRegion = &#63; and idCountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param start the lower bound of the range of provinces
	 * @param end the upper bound of the range of provinces (not inclusive)
	 * @return the range of matching provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Province> findByC_R(String idRegion, String idCountry,
		int start, int end) throws SystemException {
		return findByC_R(idRegion, idCountry, start, end, null);
	}

	/**
	 * Returns an ordered range of all the provinces where idRegion = &#63; and idCountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param start the lower bound of the range of provinces
	 * @param end the upper bound of the range of provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Province> findByC_R(String idRegion, String idCountry,
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

		List<Province> list = (List<Province>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Province province : list) {
				if (!Validator.equals(idRegion, province.getIdRegion()) ||
						!Validator.equals(idCountry, province.getIdCountry())) {
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

			query.append(_SQL_SELECT_PROVINCE_WHERE);

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
				query.append(ProvinceModelImpl.ORDER_BY_JPQL);
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
					list = (List<Province>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Province>(list);
				}
				else {
					list = (List<Province>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching province
	 * @throws it.ethica.esf.NoSuchProvinceException if a matching province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province findByC_R_First(String idRegion, String idCountry,
		OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		Province province = fetchByC_R_First(idRegion, idCountry,
				orderByComparator);

		if (province != null) {
			return province;
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
	 * Returns the first province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching province, or <code>null</code> if a matching province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province fetchByC_R_First(String idRegion, String idCountry,
		OrderByComparator orderByComparator) throws SystemException {
		List<Province> list = findByC_R(idRegion, idCountry, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching province
	 * @throws it.ethica.esf.NoSuchProvinceException if a matching province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province findByC_R_Last(String idRegion, String idCountry,
		OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		Province province = fetchByC_R_Last(idRegion, idCountry,
				orderByComparator);

		if (province != null) {
			return province;
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
	 * Returns the last province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching province, or <code>null</code> if a matching province could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province fetchByC_R_Last(String idRegion, String idCountry,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_R(idRegion, idCountry);

		if (count == 0) {
			return null;
		}

		List<Province> list = findByC_R(idRegion, idCountry, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provinces before and after the current province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param provincePK the primary key of the current province
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next province
	 * @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province[] findByC_R_PrevAndNext(ProvincePK provincePK,
		String idRegion, String idCountry, OrderByComparator orderByComparator)
		throws NoSuchProvinceException, SystemException {
		Province province = findByPrimaryKey(provincePK);

		Session session = null;

		try {
			session = openSession();

			Province[] array = new ProvinceImpl[3];

			array[0] = getByC_R_PrevAndNext(session, province, idRegion,
					idCountry, orderByComparator, true);

			array[1] = province;

			array[2] = getByC_R_PrevAndNext(session, province, idRegion,
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

	protected Province getByC_R_PrevAndNext(Session session, Province province,
		String idRegion, String idCountry, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROVINCE_WHERE);

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
			query.append(ProvinceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(province);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Province> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the provinces where idRegion = &#63; and idCountry = &#63; from the database.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_R(String idRegion, String idCountry)
		throws SystemException {
		for (Province province : findByC_R(idRegion, idCountry,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(province);
		}
	}

	/**
	 * Returns the number of provinces where idRegion = &#63; and idCountry = &#63;.
	 *
	 * @param idRegion the id region
	 * @param idCountry the id country
	 * @return the number of matching provinces
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

			query.append(_SQL_COUNT_PROVINCE_WHERE);

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

	private static final String _FINDER_COLUMN_C_R_IDREGION_1 = "province.id.idRegion IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_IDREGION_2 = "province.id.idRegion = ? AND ";
	private static final String _FINDER_COLUMN_C_R_IDREGION_3 = "(province.id.idRegion IS NULL OR province.id.idRegion = '') AND ";
	private static final String _FINDER_COLUMN_C_R_IDCOUNTRY_1 = "province.id.idCountry IS NULL";
	private static final String _FINDER_COLUMN_C_R_IDCOUNTRY_2 = "province.id.idCountry = ?";
	private static final String _FINDER_COLUMN_C_R_IDCOUNTRY_3 = "(province.id.idCountry IS NULL OR province.id.idCountry = '')";

	public ProvincePersistenceImpl() {
		setModelClass(Province.class);
	}

	/**
	 * Caches the province in the entity cache if it is enabled.
	 *
	 * @param province the province
	 */
	@Override
	public void cacheResult(Province province) {
		EntityCacheUtil.putResult(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceImpl.class, province.getPrimaryKey(), province);

		province.resetOriginalValues();
	}

	/**
	 * Caches the provinces in the entity cache if it is enabled.
	 *
	 * @param provinces the provinces
	 */
	@Override
	public void cacheResult(List<Province> provinces) {
		for (Province province : provinces) {
			if (EntityCacheUtil.getResult(
						ProvinceModelImpl.ENTITY_CACHE_ENABLED,
						ProvinceImpl.class, province.getPrimaryKey()) == null) {
				cacheResult(province);
			}
			else {
				province.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all provinces.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProvinceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProvinceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the province.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Province province) {
		EntityCacheUtil.removeResult(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceImpl.class, province.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Province> provinces) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Province province : provinces) {
			EntityCacheUtil.removeResult(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
				ProvinceImpl.class, province.getPrimaryKey());
		}
	}

	/**
	 * Creates a new province with the primary key. Does not add the province to the database.
	 *
	 * @param provincePK the primary key for the new province
	 * @return the new province
	 */
	@Override
	public Province create(ProvincePK provincePK) {
		Province province = new ProvinceImpl();

		province.setNew(true);
		province.setPrimaryKey(provincePK);

		return province;
	}

	/**
	 * Removes the province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param provincePK the primary key of the province
	 * @return the province that was removed
	 * @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province remove(ProvincePK provincePK)
		throws NoSuchProvinceException, SystemException {
		return remove((Serializable)provincePK);
	}

	/**
	 * Removes the province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the province
	 * @return the province that was removed
	 * @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province remove(Serializable primaryKey)
		throws NoSuchProvinceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Province province = (Province)session.get(ProvinceImpl.class,
					primaryKey);

			if (province == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProvinceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(province);
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
	protected Province removeImpl(Province province) throws SystemException {
		province = toUnwrappedModel(province);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(province)) {
				province = (Province)session.get(ProvinceImpl.class,
						province.getPrimaryKeyObj());
			}

			if (province != null) {
				session.delete(province);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (province != null) {
			clearCache(province);
		}

		return province;
	}

	@Override
	public Province updateImpl(it.ethica.esf.model.Province province)
		throws SystemException {
		province = toUnwrappedModel(province);

		boolean isNew = province.isNew();

		ProvinceModelImpl provinceModelImpl = (ProvinceModelImpl)province;

		Session session = null;

		try {
			session = openSession();

			if (province.isNew()) {
				session.save(province);

				province.setNew(false);
			}
			else {
				session.merge(province);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProvinceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((provinceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						provinceModelImpl.getOriginalIdRegion(),
						provinceModelImpl.getOriginalIdCountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R,
					args);

				args = new Object[] {
						provinceModelImpl.getIdRegion(),
						provinceModelImpl.getIdCountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R,
					args);
			}
		}

		EntityCacheUtil.putResult(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
			ProvinceImpl.class, province.getPrimaryKey(), province);

		return province;
	}

	protected Province toUnwrappedModel(Province province) {
		if (province instanceof ProvinceImpl) {
			return province;
		}

		ProvinceImpl provinceImpl = new ProvinceImpl();

		provinceImpl.setNew(province.isNew());
		provinceImpl.setPrimaryKey(province.getPrimaryKey());

		provinceImpl.setIdProvince(province.getIdProvince());
		provinceImpl.setIdRegion(province.getIdRegion());
		provinceImpl.setIdCountry(province.getIdCountry());
		provinceImpl.setName(province.getName());

		return provinceImpl;
	}

	/**
	 * Returns the province with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the province
	 * @return the province
	 * @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProvinceException, SystemException {
		Province province = fetchByPrimaryKey(primaryKey);

		if (province == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProvinceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return province;
	}

	/**
	 * Returns the province with the primary key or throws a {@link it.ethica.esf.NoSuchProvinceException} if it could not be found.
	 *
	 * @param provincePK the primary key of the province
	 * @return the province
	 * @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province findByPrimaryKey(ProvincePK provincePK)
		throws NoSuchProvinceException, SystemException {
		return findByPrimaryKey((Serializable)provincePK);
	}

	/**
	 * Returns the province with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the province
	 * @return the province, or <code>null</code> if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Province province = (Province)EntityCacheUtil.getResult(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
				ProvinceImpl.class, primaryKey);

		if (province == _nullProvince) {
			return null;
		}

		if (province == null) {
			Session session = null;

			try {
				session = openSession();

				province = (Province)session.get(ProvinceImpl.class, primaryKey);

				if (province != null) {
					cacheResult(province);
				}
				else {
					EntityCacheUtil.putResult(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
						ProvinceImpl.class, primaryKey, _nullProvince);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProvinceModelImpl.ENTITY_CACHE_ENABLED,
					ProvinceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return province;
	}

	/**
	 * Returns the province with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param provincePK the primary key of the province
	 * @return the province, or <code>null</code> if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province fetchByPrimaryKey(ProvincePK provincePK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)provincePK);
	}

	/**
	 * Returns all the provinces.
	 *
	 * @return the provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Province> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of provinces
	 * @param end the upper bound of the range of provinces (not inclusive)
	 * @return the range of provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Province> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of provinces
	 * @param end the upper bound of the range of provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Province> findAll(int start, int end,
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

		List<Province> list = (List<Province>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROVINCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROVINCE;

				if (pagination) {
					sql = sql.concat(ProvinceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Province>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Province>(list);
				}
				else {
					list = (List<Province>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the provinces from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Province province : findAll()) {
			remove(province);
		}
	}

	/**
	 * Returns the number of provinces.
	 *
	 * @return the number of provinces
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

				Query q = session.createQuery(_SQL_COUNT_PROVINCE);

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
	 * Initializes the province persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.Province")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Province>> listenersList = new ArrayList<ModelListener<Province>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Province>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProvinceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROVINCE = "SELECT province FROM Province province";
	private static final String _SQL_SELECT_PROVINCE_WHERE = "SELECT province FROM Province province WHERE ";
	private static final String _SQL_COUNT_PROVINCE = "SELECT COUNT(province) FROM Province province";
	private static final String _SQL_COUNT_PROVINCE_WHERE = "SELECT COUNT(province) FROM Province province WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "province.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Province exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Province exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProvincePersistenceImpl.class);
	private static Province _nullProvince = new ProvinceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Province> toCacheModel() {
				return _nullProvinceCacheModel;
			}
		};

	private static CacheModel<Province> _nullProvinceCacheModel = new CacheModel<Province>() {
			@Override
			public Province toEntityModel() {
				return _nullProvince;
			}
		};
}