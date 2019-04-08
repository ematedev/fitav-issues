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

import it.ethica.esf.NoSuchRegionException;
import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.impl.ESFRegionImpl;
import it.ethica.esf.model.impl.ESFRegionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRegionPersistence
 * @see ESFRegionUtil
 * @generated
 */
public class ESFRegionPersistenceImpl extends BasePersistenceImpl<ESFRegion>
	implements ESFRegionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRegionUtil} to access the e s f region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRegionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionModelImpl.FINDER_CACHE_ENABLED, ESFRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionModelImpl.FINDER_CACHE_ENABLED, ESFRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRY = new FinderPath(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionModelImpl.FINDER_CACHE_ENABLED, ESFRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountry",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY =
		new FinderPath(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionModelImpl.FINDER_CACHE_ENABLED, ESFRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountry",
			new String[] { String.class.getName() },
			ESFRegionModelImpl.IDCOUNTRY_COLUMN_BITMASK |
			ESFRegionModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRY = new FinderPath(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountry",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f regions where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @return the matching e s f regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRegion> findByCountry(String idCountry)
		throws SystemException {
		return findByCountry(idCountry, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f regions where idCountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param start the lower bound of the range of e s f regions
	 * @param end the upper bound of the range of e s f regions (not inclusive)
	 * @return the range of matching e s f regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRegion> findByCountry(String idCountry, int start, int end)
		throws SystemException {
		return findByCountry(idCountry, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f regions where idCountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idCountry the id country
	 * @param start the lower bound of the range of e s f regions
	 * @param end the upper bound of the range of e s f regions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRegion> findByCountry(String idCountry, int start, int end,
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

		List<ESFRegion> list = (List<ESFRegion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFRegion esfRegion : list) {
				if (!Validator.equals(idCountry, esfRegion.getIdCountry())) {
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

			query.append(_SQL_SELECT_ESFREGION_WHERE);

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
				query.append(ESFRegionModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFRegion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRegion>(list);
				}
				else {
					list = (List<ESFRegion>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f region in the ordered set where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f region
	 * @throws it.ethica.esf.NoSuchRegionException if a matching e s f region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion findByCountry_First(String idCountry,
		OrderByComparator orderByComparator)
		throws NoSuchRegionException, SystemException {
		ESFRegion esfRegion = fetchByCountry_First(idCountry, orderByComparator);

		if (esfRegion != null) {
			return esfRegion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idCountry=");
		msg.append(idCountry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRegionException(msg.toString());
	}

	/**
	 * Returns the first e s f region in the ordered set where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f region, or <code>null</code> if a matching e s f region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion fetchByCountry_First(String idCountry,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFRegion> list = findByCountry(idCountry, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f region in the ordered set where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f region
	 * @throws it.ethica.esf.NoSuchRegionException if a matching e s f region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion findByCountry_Last(String idCountry,
		OrderByComparator orderByComparator)
		throws NoSuchRegionException, SystemException {
		ESFRegion esfRegion = fetchByCountry_Last(idCountry, orderByComparator);

		if (esfRegion != null) {
			return esfRegion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idCountry=");
		msg.append(idCountry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRegionException(msg.toString());
	}

	/**
	 * Returns the last e s f region in the ordered set where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f region, or <code>null</code> if a matching e s f region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion fetchByCountry_Last(String idCountry,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountry(idCountry);

		if (count == 0) {
			return null;
		}

		List<ESFRegion> list = findByCountry(idCountry, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f regions before and after the current e s f region in the ordered set where idCountry = &#63;.
	 *
	 * @param esfRegionPK the primary key of the current e s f region
	 * @param idCountry the id country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f region
	 * @throws it.ethica.esf.NoSuchRegionException if a e s f region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion[] findByCountry_PrevAndNext(ESFRegionPK esfRegionPK,
		String idCountry, OrderByComparator orderByComparator)
		throws NoSuchRegionException, SystemException {
		ESFRegion esfRegion = findByPrimaryKey(esfRegionPK);

		Session session = null;

		try {
			session = openSession();

			ESFRegion[] array = new ESFRegionImpl[3];

			array[0] = getByCountry_PrevAndNext(session, esfRegion, idCountry,
					orderByComparator, true);

			array[1] = esfRegion;

			array[2] = getByCountry_PrevAndNext(session, esfRegion, idCountry,
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

	protected ESFRegion getByCountry_PrevAndNext(Session session,
		ESFRegion esfRegion, String idCountry,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFREGION_WHERE);

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
			query.append(ESFRegionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfRegion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFRegion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f regions where idCountry = &#63; from the database.
	 *
	 * @param idCountry the id country
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountry(String idCountry) throws SystemException {
		for (ESFRegion esfRegion : findByCountry(idCountry, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfRegion);
		}
	}

	/**
	 * Returns the number of e s f regions where idCountry = &#63;.
	 *
	 * @param idCountry the id country
	 * @return the number of matching e s f regions
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

			query.append(_SQL_COUNT_ESFREGION_WHERE);

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

	private static final String _FINDER_COLUMN_COUNTRY_IDCOUNTRY_1 = "esfRegion.id.idCountry IS NULL";
	private static final String _FINDER_COLUMN_COUNTRY_IDCOUNTRY_2 = "esfRegion.id.idCountry = ?";
	private static final String _FINDER_COLUMN_COUNTRY_IDCOUNTRY_3 = "(esfRegion.id.idCountry IS NULL OR esfRegion.id.idCountry = '')";

	public ESFRegionPersistenceImpl() {
		setModelClass(ESFRegion.class);
	}

	/**
	 * Caches the e s f region in the entity cache if it is enabled.
	 *
	 * @param esfRegion the e s f region
	 */
	@Override
	public void cacheResult(ESFRegion esfRegion) {
		EntityCacheUtil.putResult(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionImpl.class, esfRegion.getPrimaryKey(), esfRegion);

		esfRegion.resetOriginalValues();
	}

	/**
	 * Caches the e s f regions in the entity cache if it is enabled.
	 *
	 * @param esfRegions the e s f regions
	 */
	@Override
	public void cacheResult(List<ESFRegion> esfRegions) {
		for (ESFRegion esfRegion : esfRegions) {
			if (EntityCacheUtil.getResult(
						ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
						ESFRegionImpl.class, esfRegion.getPrimaryKey()) == null) {
				cacheResult(esfRegion);
			}
			else {
				esfRegion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f regions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRegionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRegionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f region.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRegion esfRegion) {
		EntityCacheUtil.removeResult(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionImpl.class, esfRegion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFRegion> esfRegions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRegion esfRegion : esfRegions) {
			EntityCacheUtil.removeResult(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
				ESFRegionImpl.class, esfRegion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f region with the primary key. Does not add the e s f region to the database.
	 *
	 * @param esfRegionPK the primary key for the new e s f region
	 * @return the new e s f region
	 */
	@Override
	public ESFRegion create(ESFRegionPK esfRegionPK) {
		ESFRegion esfRegion = new ESFRegionImpl();

		esfRegion.setNew(true);
		esfRegion.setPrimaryKey(esfRegionPK);

		return esfRegion;
	}

	/**
	 * Removes the e s f region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfRegionPK the primary key of the e s f region
	 * @return the e s f region that was removed
	 * @throws it.ethica.esf.NoSuchRegionException if a e s f region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion remove(ESFRegionPK esfRegionPK)
		throws NoSuchRegionException, SystemException {
		return remove((Serializable)esfRegionPK);
	}

	/**
	 * Removes the e s f region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f region
	 * @return the e s f region that was removed
	 * @throws it.ethica.esf.NoSuchRegionException if a e s f region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion remove(Serializable primaryKey)
		throws NoSuchRegionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRegion esfRegion = (ESFRegion)session.get(ESFRegionImpl.class,
					primaryKey);

			if (esfRegion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRegion);
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
	protected ESFRegion removeImpl(ESFRegion esfRegion)
		throws SystemException {
		esfRegion = toUnwrappedModel(esfRegion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRegion)) {
				esfRegion = (ESFRegion)session.get(ESFRegionImpl.class,
						esfRegion.getPrimaryKeyObj());
			}

			if (esfRegion != null) {
				session.delete(esfRegion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRegion != null) {
			clearCache(esfRegion);
		}

		return esfRegion;
	}

	@Override
	public ESFRegion updateImpl(it.ethica.esf.model.ESFRegion esfRegion)
		throws SystemException {
		esfRegion = toUnwrappedModel(esfRegion);

		boolean isNew = esfRegion.isNew();

		ESFRegionModelImpl esfRegionModelImpl = (ESFRegionModelImpl)esfRegion;

		Session session = null;

		try {
			session = openSession();

			if (esfRegion.isNew()) {
				session.save(esfRegion);

				esfRegion.setNew(false);
			}
			else {
				session.merge(esfRegion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFRegionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfRegionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRegionModelImpl.getOriginalIdCountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY,
					args);

				args = new Object[] { esfRegionModelImpl.getIdCountry() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
			ESFRegionImpl.class, esfRegion.getPrimaryKey(), esfRegion);

		return esfRegion;
	}

	protected ESFRegion toUnwrappedModel(ESFRegion esfRegion) {
		if (esfRegion instanceof ESFRegionImpl) {
			return esfRegion;
		}

		ESFRegionImpl esfRegionImpl = new ESFRegionImpl();

		esfRegionImpl.setNew(esfRegion.isNew());
		esfRegionImpl.setPrimaryKey(esfRegion.getPrimaryKey());

		esfRegionImpl.setIdRegion(esfRegion.getIdRegion());
		esfRegionImpl.setIdCountry(esfRegion.getIdCountry());
		esfRegionImpl.setName(esfRegion.getName());

		return esfRegionImpl;
	}

	/**
	 * Returns the e s f region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f region
	 * @return the e s f region
	 * @throws it.ethica.esf.NoSuchRegionException if a e s f region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegionException, SystemException {
		ESFRegion esfRegion = fetchByPrimaryKey(primaryKey);

		if (esfRegion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRegion;
	}

	/**
	 * Returns the e s f region with the primary key or throws a {@link it.ethica.esf.NoSuchRegionException} if it could not be found.
	 *
	 * @param esfRegionPK the primary key of the e s f region
	 * @return the e s f region
	 * @throws it.ethica.esf.NoSuchRegionException if a e s f region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion findByPrimaryKey(ESFRegionPK esfRegionPK)
		throws NoSuchRegionException, SystemException {
		return findByPrimaryKey((Serializable)esfRegionPK);
	}

	/**
	 * Returns the e s f region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f region
	 * @return the e s f region, or <code>null</code> if a e s f region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRegion esfRegion = (ESFRegion)EntityCacheUtil.getResult(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
				ESFRegionImpl.class, primaryKey);

		if (esfRegion == _nullESFRegion) {
			return null;
		}

		if (esfRegion == null) {
			Session session = null;

			try {
				session = openSession();

				esfRegion = (ESFRegion)session.get(ESFRegionImpl.class,
						primaryKey);

				if (esfRegion != null) {
					cacheResult(esfRegion);
				}
				else {
					EntityCacheUtil.putResult(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
						ESFRegionImpl.class, primaryKey, _nullESFRegion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRegionModelImpl.ENTITY_CACHE_ENABLED,
					ESFRegionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRegion;
	}

	/**
	 * Returns the e s f region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfRegionPK the primary key of the e s f region
	 * @return the e s f region, or <code>null</code> if a e s f region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRegion fetchByPrimaryKey(ESFRegionPK esfRegionPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfRegionPK);
	}

	/**
	 * Returns all the e s f regions.
	 *
	 * @return the e s f regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRegion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f regions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f regions
	 * @param end the upper bound of the range of e s f regions (not inclusive)
	 * @return the range of e s f regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRegion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f regions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f regions
	 * @param end the upper bound of the range of e s f regions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRegion> findAll(int start, int end,
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

		List<ESFRegion> list = (List<ESFRegion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFREGION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFREGION;

				if (pagination) {
					sql = sql.concat(ESFRegionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRegion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRegion>(list);
				}
				else {
					list = (List<ESFRegion>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f regions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRegion esfRegion : findAll()) {
			remove(esfRegion);
		}
	}

	/**
	 * Returns the number of e s f regions.
	 *
	 * @return the number of e s f regions
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

				Query q = session.createQuery(_SQL_COUNT_ESFREGION);

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
	 * Initializes the e s f region persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRegion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRegion>> listenersList = new ArrayList<ModelListener<ESFRegion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRegion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRegionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFREGION = "SELECT esfRegion FROM ESFRegion esfRegion";
	private static final String _SQL_SELECT_ESFREGION_WHERE = "SELECT esfRegion FROM ESFRegion esfRegion WHERE ";
	private static final String _SQL_COUNT_ESFREGION = "SELECT COUNT(esfRegion) FROM ESFRegion esfRegion";
	private static final String _SQL_COUNT_ESFREGION_WHERE = "SELECT COUNT(esfRegion) FROM ESFRegion esfRegion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRegion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRegion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFRegion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRegionPersistenceImpl.class);
	private static ESFRegion _nullESFRegion = new ESFRegionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRegion> toCacheModel() {
				return _nullESFRegionCacheModel;
			}
		};

	private static CacheModel<ESFRegion> _nullESFRegionCacheModel = new CacheModel<ESFRegion>() {
			@Override
			public ESFRegion toEntityModel() {
				return _nullESFRegion;
			}
		};
}