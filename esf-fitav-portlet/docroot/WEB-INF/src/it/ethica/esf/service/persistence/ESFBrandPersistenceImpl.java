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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchBrandException;
import it.ethica.esf.model.ESFBrand;
import it.ethica.esf.model.impl.ESFBrandImpl;
import it.ethica.esf.model.impl.ESFBrandModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f brand service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFBrandPersistence
 * @see ESFBrandUtil
 * @generated
 */
public class ESFBrandPersistenceImpl extends BasePersistenceImpl<ESFBrand>
	implements ESFBrandPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFBrandUtil} to access the e s f brand persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFBrandImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
			ESFBrandModelImpl.FINDER_CACHE_ENABLED, ESFBrandImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
			ESFBrandModelImpl.FINDER_CACHE_ENABLED, ESFBrandImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
			ESFBrandModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFBrandPersistenceImpl() {
		setModelClass(ESFBrand.class);
	}

	/**
	 * Caches the e s f brand in the entity cache if it is enabled.
	 *
	 * @param esfBrand the e s f brand
	 */
	@Override
	public void cacheResult(ESFBrand esfBrand) {
		EntityCacheUtil.putResult(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
			ESFBrandImpl.class, esfBrand.getPrimaryKey(), esfBrand);

		esfBrand.resetOriginalValues();
	}

	/**
	 * Caches the e s f brands in the entity cache if it is enabled.
	 *
	 * @param esfBrands the e s f brands
	 */
	@Override
	public void cacheResult(List<ESFBrand> esfBrands) {
		for (ESFBrand esfBrand : esfBrands) {
			if (EntityCacheUtil.getResult(
						ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
						ESFBrandImpl.class, esfBrand.getPrimaryKey()) == null) {
				cacheResult(esfBrand);
			}
			else {
				esfBrand.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f brands.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFBrandImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFBrandImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f brand.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFBrand esfBrand) {
		EntityCacheUtil.removeResult(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
			ESFBrandImpl.class, esfBrand.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFBrand> esfBrands) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFBrand esfBrand : esfBrands) {
			EntityCacheUtil.removeResult(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
				ESFBrandImpl.class, esfBrand.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f brand with the primary key. Does not add the e s f brand to the database.
	 *
	 * @param brandId the primary key for the new e s f brand
	 * @return the new e s f brand
	 */
	@Override
	public ESFBrand create(long brandId) {
		ESFBrand esfBrand = new ESFBrandImpl();

		esfBrand.setNew(true);
		esfBrand.setPrimaryKey(brandId);

		return esfBrand;
	}

	/**
	 * Removes the e s f brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandId the primary key of the e s f brand
	 * @return the e s f brand that was removed
	 * @throws it.ethica.esf.NoSuchBrandException if a e s f brand with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBrand remove(long brandId)
		throws NoSuchBrandException, SystemException {
		return remove((Serializable)brandId);
	}

	/**
	 * Removes the e s f brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f brand
	 * @return the e s f brand that was removed
	 * @throws it.ethica.esf.NoSuchBrandException if a e s f brand with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBrand remove(Serializable primaryKey)
		throws NoSuchBrandException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFBrand esfBrand = (ESFBrand)session.get(ESFBrandImpl.class,
					primaryKey);

			if (esfBrand == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrandException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfBrand);
		}
		catch (NoSuchBrandException nsee) {
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
	protected ESFBrand removeImpl(ESFBrand esfBrand) throws SystemException {
		esfBrand = toUnwrappedModel(esfBrand);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfBrand)) {
				esfBrand = (ESFBrand)session.get(ESFBrandImpl.class,
						esfBrand.getPrimaryKeyObj());
			}

			if (esfBrand != null) {
				session.delete(esfBrand);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfBrand != null) {
			clearCache(esfBrand);
		}

		return esfBrand;
	}

	@Override
	public ESFBrand updateImpl(it.ethica.esf.model.ESFBrand esfBrand)
		throws SystemException {
		esfBrand = toUnwrappedModel(esfBrand);

		boolean isNew = esfBrand.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfBrand.isNew()) {
				session.save(esfBrand);

				esfBrand.setNew(false);
			}
			else {
				session.merge(esfBrand);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
			ESFBrandImpl.class, esfBrand.getPrimaryKey(), esfBrand);

		return esfBrand;
	}

	protected ESFBrand toUnwrappedModel(ESFBrand esfBrand) {
		if (esfBrand instanceof ESFBrandImpl) {
			return esfBrand;
		}

		ESFBrandImpl esfBrandImpl = new ESFBrandImpl();

		esfBrandImpl.setNew(esfBrand.isNew());
		esfBrandImpl.setPrimaryKey(esfBrand.getPrimaryKey());

		esfBrandImpl.setBrandId(esfBrand.getBrandId());
		esfBrandImpl.setName(esfBrand.getName());
		esfBrandImpl.setDescription(esfBrand.getDescription());

		return esfBrandImpl;
	}

	/**
	 * Returns the e s f brand with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f brand
	 * @return the e s f brand
	 * @throws it.ethica.esf.NoSuchBrandException if a e s f brand with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBrand findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBrandException, SystemException {
		ESFBrand esfBrand = fetchByPrimaryKey(primaryKey);

		if (esfBrand == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBrandException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfBrand;
	}

	/**
	 * Returns the e s f brand with the primary key or throws a {@link it.ethica.esf.NoSuchBrandException} if it could not be found.
	 *
	 * @param brandId the primary key of the e s f brand
	 * @return the e s f brand
	 * @throws it.ethica.esf.NoSuchBrandException if a e s f brand with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBrand findByPrimaryKey(long brandId)
		throws NoSuchBrandException, SystemException {
		return findByPrimaryKey((Serializable)brandId);
	}

	/**
	 * Returns the e s f brand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f brand
	 * @return the e s f brand, or <code>null</code> if a e s f brand with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBrand fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFBrand esfBrand = (ESFBrand)EntityCacheUtil.getResult(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
				ESFBrandImpl.class, primaryKey);

		if (esfBrand == _nullESFBrand) {
			return null;
		}

		if (esfBrand == null) {
			Session session = null;

			try {
				session = openSession();

				esfBrand = (ESFBrand)session.get(ESFBrandImpl.class, primaryKey);

				if (esfBrand != null) {
					cacheResult(esfBrand);
				}
				else {
					EntityCacheUtil.putResult(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
						ESFBrandImpl.class, primaryKey, _nullESFBrand);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFBrandModelImpl.ENTITY_CACHE_ENABLED,
					ESFBrandImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfBrand;
	}

	/**
	 * Returns the e s f brand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandId the primary key of the e s f brand
	 * @return the e s f brand, or <code>null</code> if a e s f brand with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBrand fetchByPrimaryKey(long brandId) throws SystemException {
		return fetchByPrimaryKey((Serializable)brandId);
	}

	/**
	 * Returns all the e s f brands.
	 *
	 * @return the e s f brands
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBrand> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFBrandModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f brands
	 * @param end the upper bound of the range of e s f brands (not inclusive)
	 * @return the range of e s f brands
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBrand> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFBrandModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f brands
	 * @param end the upper bound of the range of e s f brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f brands
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBrand> findAll(int start, int end,
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

		List<ESFBrand> list = (List<ESFBrand>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFBRAND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFBRAND;

				if (pagination) {
					sql = sql.concat(ESFBrandModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFBrand>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFBrand>(list);
				}
				else {
					list = (List<ESFBrand>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f brands from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFBrand esfBrand : findAll()) {
			remove(esfBrand);
		}
	}

	/**
	 * Returns the number of e s f brands.
	 *
	 * @return the number of e s f brands
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

				Query q = session.createQuery(_SQL_COUNT_ESFBRAND);

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
	 * Initializes the e s f brand persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFBrand")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFBrand>> listenersList = new ArrayList<ModelListener<ESFBrand>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFBrand>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFBrandImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFBRAND = "SELECT esfBrand FROM ESFBrand esfBrand";
	private static final String _SQL_COUNT_ESFBRAND = "SELECT COUNT(esfBrand) FROM ESFBrand esfBrand";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfBrand.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFBrand exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFBrandPersistenceImpl.class);
	private static ESFBrand _nullESFBrand = new ESFBrandImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFBrand> toCacheModel() {
				return _nullESFBrandCacheModel;
			}
		};

	private static CacheModel<ESFBrand> _nullESFBrandCacheModel = new CacheModel<ESFBrand>() {
			@Override
			public ESFBrand toEntityModel() {
				return _nullESFBrand;
			}
		};
}