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

import it.ethica.esf.NoSuchRegionException;
import it.ethica.esf.model.Region;
import it.ethica.esf.model.impl.RegionImpl;
import it.ethica.esf.model.impl.RegionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see RegionPersistence
 * @see RegionUtil
 * @generated
 */
public class RegionPersistenceImpl extends BasePersistenceImpl<Region>
	implements RegionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RegionUtil} to access the region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RegionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRY = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountry",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY =
		new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, RegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountry",
			new String[] { String.class.getName() },
			RegionModelImpl.IDCOUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRY = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountry",
			new String[] { String.class.getName() });

	/**
	 * Returns all the regions where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @return the matching regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Region> findByCountry(String idCountry)
		throws SystemException {
		return findByCountry(idCountry, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the regions where idCountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param start the lower bound of the range of regions
	 * @param end the upper bound of the range of regions (not inclusive)
	 * @return the range of matching regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Region> findByCountry(String idCountry, int start, int end)
		throws SystemException {
		return findByCountry(idCountry, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regions where idCountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param start the lower bound of the range of regions
	 * @param end the upper bound of the range of regions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Region> findByCountry(String idCountry, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY;
			finderArgs = new Object[] { idCountry };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRY;
			finderArgs = new Object[] { idCountry, start, end, orderByComparator };
		}

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Region region : list) {
				if (!Validator.equals(idCountry, region.getIdCountry())) {
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

			query.append(_SQL_SELECT_REGION_WHERE);

			boolean bindIdCountry = false;

			if (idCountry == null) {
				query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_1);
			}
			else if (idCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_3);
			}
			else {
				bindIdCountry = true;

				query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RegionModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<Region>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Region>(list);
				}
				else {
					list = (List<Region>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first region in the ordered set where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching region
	 * @throws it.ethica.esf.NoSuchRegionException if a matching region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region findByCountry_First(String idCountry,
		OrderByComparator orderByComparator)
		throws NoSuchRegionException, SystemException {
		Region region = fetchByCountry_First(idCountry, orderByComparator);

		if (region != null) {
			return region;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idCountry=");
		msg.append(idCountry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRegionException(msg.toString());
	}

	/**
	 * Returns the first region in the ordered set where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching region, or <code>null</code> if a matching region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region fetchByCountry_First(String idCountry,
		OrderByComparator orderByComparator) throws SystemException {
		List<Region> list = findByCountry(idCountry, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last region in the ordered set where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching region
	 * @throws it.ethica.esf.NoSuchRegionException if a matching region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region findByCountry_Last(String idCountry,
		OrderByComparator orderByComparator)
		throws NoSuchRegionException, SystemException {
		Region region = fetchByCountry_Last(idCountry, orderByComparator);

		if (region != null) {
			return region;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idCountry=");
		msg.append(idCountry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRegionException(msg.toString());
	}

	/**
	 * Returns the last region in the ordered set where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching region, or <code>null</code> if a matching region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region fetchByCountry_Last(String idCountry,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountry(idCountry);

		if (count == 0) {
			return null;
		}

		List<Region> list = findByCountry(idCountry, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regions before and after the current region in the ordered set where idCountry = &#63;.
	 *
	 * @param regionPK the primary key of the current region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next region
	 * @throws it.ethica.esf.NoSuchRegionException if a region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region[] findByCountry_PrevAndNext(RegionPK regionPK,
		String idCountry, OrderByComparator orderByComparator)
		throws NoSuchRegionException, SystemException {
		Region region = findByPrimaryKey(regionPK);

		Session session = null;

		try {
			session = openSession();

			Region[] array = new RegionImpl[3];

			array[0] = getByCountry_PrevAndNext(session, region, idCountry,
					orderByComparator, true);

			array[1] = region;

			array[2] = getByCountry_PrevAndNext(session, region, idCountry,
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

	protected Region getByCountry_PrevAndNext(Session session, Region region,
		String idCountry, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REGION_WHERE);

		boolean bindIdCountry = false;

		if (idCountry == null) {
			query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_1);
		}
		else if (idCountry.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_3);
		}
		else {
			bindIdCountry = true;

			query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_2);
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
			query.append(RegionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIdCountry) {
			qPos.add(idCountry);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(region);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Region> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regions where idCountry = &#63; from the database.
	 *
	 * @param idCountry the id country
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountry(String idCountry) throws SystemException {
		for (Region region : findByCountry(idCountry, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(region);
		}
	}

	/**
	 * Returns the number of regions where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @return the number of matching regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountry(String idCountry) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRY;

		Object[] finderArgs = new Object[] { idCountry };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGION_WHERE);

			boolean bindIdCountry = false;

			if (idCountry == null) {
				query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_1);
			}
			else if (idCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_3);
			}
			else {
				bindIdCountry = true;

				query.append(_FINDER_COLUMN_COUNTRY_IDCOUNTRY_2);
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

	private static final String _FINDER_COLUMN_COUNTRY_IDCOUNTRY_1 = "region.id.idCountry IS NULL";
	private static final String _FINDER_COLUMN_COUNTRY_IDCOUNTRY_2 = "region.id.idCountry = ?";
	private static final String _FINDER_COLUMN_COUNTRY_IDCOUNTRY_3 = "(region.id.idCountry IS NULL OR region.id.idCountry = '')";

	public RegionPersistenceImpl() {
		setModelClass(Region.class);
	}

	/**
	 * Caches the region in the entity cache if it is enabled.
	 *
	 * @param region the region
	 */
	@Override
	public void cacheResult(Region region) {
		EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionImpl.class, region.getPrimaryKey(), region);

		region.resetOriginalValues();
	}

	/**
	 * Caches the regions in the entity cache if it is enabled.
	 *
	 * @param regions the regions
	 */
	@Override
	public void cacheResult(List<Region> regions) {
		for (Region region : regions) {
			if (EntityCacheUtil.getResult(
						RegionModelImpl.ENTITY_CACHE_ENABLED, RegionImpl.class,
						region.getPrimaryKey()) == null) {
				cacheResult(region);
			}
			else {
				region.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all regions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RegionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RegionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the region.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Region region) {
		EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionImpl.class, region.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Region> regions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Region region : regions) {
			EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
				RegionImpl.class, region.getPrimaryKey());
		}
	}

	/**
	 * Creates a new region with the primary key. Does not add the region to the database.
	 *
	 * @param regionPK the primary key for the new region
	 * @return the new region
	 */
	@Override
	public Region create(RegionPK regionPK) {
		Region region = new RegionImpl();

		region.setNew(true);
		region.setPrimaryKey(regionPK);

		return region;
	}

	/**
	 * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param regionPK the primary key of the region
	 * @return the region that was removed
	 * @throws it.ethica.esf.NoSuchRegionException if a region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region remove(RegionPK regionPK)
		throws NoSuchRegionException, SystemException {
		return remove((Serializable)regionPK);
	}

	/**
	 * Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the region
	 * @return the region that was removed
	 * @throws it.ethica.esf.NoSuchRegionException if a region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region remove(Serializable primaryKey)
		throws NoSuchRegionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Region region = (Region)session.get(RegionImpl.class, primaryKey);

			if (region == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(region);
		}
		catch (NoSuchRegionException nsee) {
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
	protected Region removeImpl(Region region) throws SystemException {
		region = toUnwrappedModel(region);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(region)) {
				region = (Region)session.get(RegionImpl.class,
						region.getPrimaryKeyObj());
			}

			if (region != null) {
				session.delete(region);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (region != null) {
			clearCache(region);
		}

		return region;
	}

	@Override
	public Region updateImpl(it.ethica.esf.model.Region region)
		throws SystemException {
		region = toUnwrappedModel(region);

		boolean isNew = region.isNew();

		RegionModelImpl regionModelImpl = (RegionModelImpl)region;

		Session session = null;

		try {
			session = openSession();

			if (region.isNew()) {
				session.save(region);

				region.setNew(false);
			}
			else {
				session.merge(region);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RegionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((regionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						regionModelImpl.getOriginalIdCountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY,
					args);

				args = new Object[] { regionModelImpl.getIdCountry() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionImpl.class, region.getPrimaryKey(), region);

		return region;
	}

	protected Region toUnwrappedModel(Region region) {
		if (region instanceof RegionImpl) {
			return region;
		}

		RegionImpl regionImpl = new RegionImpl();

		regionImpl.setNew(region.isNew());
		regionImpl.setPrimaryKey(region.getPrimaryKey());

		regionImpl.setIdRegion(region.getIdRegion());
		regionImpl.setIdCountry(region.getIdCountry());
		regionImpl.setName(region.getName());

		return regionImpl;
	}

	/**
	 * Returns the region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the region
	 * @return the region
	 * @throws it.ethica.esf.NoSuchRegionException if a region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegionException, SystemException {
		Region region = fetchByPrimaryKey(primaryKey);

		if (region == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return region;
	}

	/**
	 * Returns the region with the primary key or throws a {@link it.ethica.esf.NoSuchRegionException} if it could not be found.
	 *
	 * @param regionPK the primary key of the region
	 * @return the region
	 * @throws it.ethica.esf.NoSuchRegionException if a region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region findByPrimaryKey(RegionPK regionPK)
		throws NoSuchRegionException, SystemException {
		return findByPrimaryKey((Serializable)regionPK);
	}

	/**
	 * Returns the region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the region
	 * @return the region, or <code>null</code> if a region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Region region = (Region)EntityCacheUtil.getResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
				RegionImpl.class, primaryKey);

		if (region == _nullRegion) {
			return null;
		}

		if (region == null) {
			Session session = null;

			try {
				session = openSession();

				region = (Region)session.get(RegionImpl.class, primaryKey);

				if (region != null) {
					cacheResult(region);
				}
				else {
					EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
						RegionImpl.class, primaryKey, _nullRegion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
					RegionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return region;
	}

	/**
	 * Returns the region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param regionPK the primary key of the region
	 * @return the region, or <code>null</code> if a region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Region fetchByPrimaryKey(RegionPK regionPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)regionPK);
	}

	/**
	 * Returns all the regions.
	 *
	 * @return the regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Region> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regions
	 * @param end the upper bound of the range of regions (not inclusive)
	 * @return the range of regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Region> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the regions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regions
	 * @param end the upper bound of the range of regions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Region> findAll(int start, int end,
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

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REGION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REGION;

				if (pagination) {
					sql = sql.concat(RegionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Region>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Region>(list);
				}
				else {
					list = (List<Region>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the regions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Region region : findAll()) {
			remove(region);
		}
	}

	/**
	 * Returns the number of regions.
	 *
	 * @return the number of regions
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

				Query q = session.createQuery(_SQL_COUNT_REGION);

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
	 * Initializes the region persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.Region")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Region>> listenersList = new ArrayList<ModelListener<Region>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Region>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RegionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REGION = "SELECT region FROM Region region";
	private static final String _SQL_SELECT_REGION_WHERE = "SELECT region FROM Region region WHERE ";
	private static final String _SQL_COUNT_REGION = "SELECT COUNT(region) FROM Region region";
	private static final String _SQL_COUNT_REGION_WHERE = "SELECT COUNT(region) FROM Region region WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "region.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Region exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Region exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RegionPersistenceImpl.class);
	private static Region _nullRegion = new RegionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Region> toCacheModel() {
				return _nullRegionCacheModel;
			}
		};

	private static CacheModel<Region> _nullRegionCacheModel = new CacheModel<Region>() {
			@Override
			public Region toEntityModel() {
				return _nullRegion;
			}
		};
}