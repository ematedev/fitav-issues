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

import it.ethica.esf.NoSuchCountryException;
import it.ethica.esf.model.ESFCountry;
import it.ethica.esf.model.impl.ESFCountryImpl;
import it.ethica.esf.model.impl.ESFCountryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCountryPersistence
 * @see ESFCountryUtil
 * @generated
 */
public class ESFCountryPersistenceImpl extends BasePersistenceImpl<ESFCountry>
	implements ESFCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFCountryUtil} to access the e s f country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCountryModelImpl.FINDER_CACHE_ENABLED, ESFCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCountryModelImpl.FINDER_CACHE_ENABLED, ESFCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFCountryPersistenceImpl() {
		setModelClass(ESFCountry.class);
	}

	/**
	 * Caches the e s f country in the entity cache if it is enabled.
	 *
	 * @param esfCountry the e s f country
	 */
	@Override
	public void cacheResult(ESFCountry esfCountry) {
		EntityCacheUtil.putResult(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCountryImpl.class, esfCountry.getPrimaryKey(), esfCountry);

		esfCountry.resetOriginalValues();
	}

	/**
	 * Caches the e s f countries in the entity cache if it is enabled.
	 *
	 * @param esfCountries the e s f countries
	 */
	@Override
	public void cacheResult(List<ESFCountry> esfCountries) {
		for (ESFCountry esfCountry : esfCountries) {
			if (EntityCacheUtil.getResult(
						ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
						ESFCountryImpl.class, esfCountry.getPrimaryKey()) == null) {
				cacheResult(esfCountry);
			}
			else {
				esfCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFCountry esfCountry) {
		EntityCacheUtil.removeResult(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCountryImpl.class, esfCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFCountry> esfCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFCountry esfCountry : esfCountries) {
			EntityCacheUtil.removeResult(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
				ESFCountryImpl.class, esfCountry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f country with the primary key. Does not add the e s f country to the database.
	 *
	 * @param idCountry the primary key for the new e s f country
	 * @return the new e s f country
	 */
	@Override
	public ESFCountry create(String idCountry) {
		ESFCountry esfCountry = new ESFCountryImpl();

		esfCountry.setNew(true);
		esfCountry.setPrimaryKey(idCountry);

		return esfCountry;
	}

	/**
	 * Removes the e s f country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idCountry the primary key of the e s f country
	 * @return the e s f country that was removed
	 * @throws it.ethica.esf.NoSuchCountryException if a e s f country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCountry remove(String idCountry)
		throws NoSuchCountryException, SystemException {
		return remove((Serializable)idCountry);
	}

	/**
	 * Removes the e s f country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f country
	 * @return the e s f country that was removed
	 * @throws it.ethica.esf.NoSuchCountryException if a e s f country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCountry remove(Serializable primaryKey)
		throws NoSuchCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFCountry esfCountry = (ESFCountry)session.get(ESFCountryImpl.class,
					primaryKey);

			if (esfCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfCountry);
		}
		catch (NoSuchCountryException nsee) {
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
	protected ESFCountry removeImpl(ESFCountry esfCountry)
		throws SystemException {
		esfCountry = toUnwrappedModel(esfCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfCountry)) {
				esfCountry = (ESFCountry)session.get(ESFCountryImpl.class,
						esfCountry.getPrimaryKeyObj());
			}

			if (esfCountry != null) {
				session.delete(esfCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfCountry != null) {
			clearCache(esfCountry);
		}

		return esfCountry;
	}

	@Override
	public ESFCountry updateImpl(it.ethica.esf.model.ESFCountry esfCountry)
		throws SystemException {
		esfCountry = toUnwrappedModel(esfCountry);

		boolean isNew = esfCountry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfCountry.isNew()) {
				session.save(esfCountry);

				esfCountry.setNew(false);
			}
			else {
				session.merge(esfCountry);
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

		EntityCacheUtil.putResult(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCountryImpl.class, esfCountry.getPrimaryKey(), esfCountry);

		return esfCountry;
	}

	protected ESFCountry toUnwrappedModel(ESFCountry esfCountry) {
		if (esfCountry instanceof ESFCountryImpl) {
			return esfCountry;
		}

		ESFCountryImpl esfCountryImpl = new ESFCountryImpl();

		esfCountryImpl.setNew(esfCountry.isNew());
		esfCountryImpl.setPrimaryKey(esfCountry.getPrimaryKey());

		esfCountryImpl.setIdCountry(esfCountry.getIdCountry());
		esfCountryImpl.setName(esfCountry.getName());

		return esfCountryImpl;
	}

	/**
	 * Returns the e s f country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f country
	 * @return the e s f country
	 * @throws it.ethica.esf.NoSuchCountryException if a e s f country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCountryException, SystemException {
		ESFCountry esfCountry = fetchByPrimaryKey(primaryKey);

		if (esfCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfCountry;
	}

	/**
	 * Returns the e s f country with the primary key or throws a {@link it.ethica.esf.NoSuchCountryException} if it could not be found.
	 *
	 * @param idCountry the primary key of the e s f country
	 * @return the e s f country
	 * @throws it.ethica.esf.NoSuchCountryException if a e s f country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCountry findByPrimaryKey(String idCountry)
		throws NoSuchCountryException, SystemException {
		return findByPrimaryKey((Serializable)idCountry);
	}

	/**
	 * Returns the e s f country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f country
	 * @return the e s f country, or <code>null</code> if a e s f country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCountry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFCountry esfCountry = (ESFCountry)EntityCacheUtil.getResult(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
				ESFCountryImpl.class, primaryKey);

		if (esfCountry == _nullESFCountry) {
			return null;
		}

		if (esfCountry == null) {
			Session session = null;

			try {
				session = openSession();

				esfCountry = (ESFCountry)session.get(ESFCountryImpl.class,
						primaryKey);

				if (esfCountry != null) {
					cacheResult(esfCountry);
				}
				else {
					EntityCacheUtil.putResult(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
						ESFCountryImpl.class, primaryKey, _nullESFCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFCountryModelImpl.ENTITY_CACHE_ENABLED,
					ESFCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfCountry;
	}

	/**
	 * Returns the e s f country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idCountry the primary key of the e s f country
	 * @return the e s f country, or <code>null</code> if a e s f country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCountry fetchByPrimaryKey(String idCountry)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)idCountry);
	}

	/**
	 * Returns all the e s f countries.
	 *
	 * @return the e s f countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCountry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f countries
	 * @param end the upper bound of the range of e s f countries (not inclusive)
	 * @return the range of e s f countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f countries
	 * @param end the upper bound of the range of e s f countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCountry> findAll(int start, int end,
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

		List<ESFCountry> list = (List<ESFCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFCOUNTRY;

				if (pagination) {
					sql = sql.concat(ESFCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFCountry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCountry>(list);
				}
				else {
					list = (List<ESFCountry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFCountry esfCountry : findAll()) {
			remove(esfCountry);
		}
	}

	/**
	 * Returns the number of e s f countries.
	 *
	 * @return the number of e s f countries
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

				Query q = session.createQuery(_SQL_COUNT_ESFCOUNTRY);

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
	 * Initializes the e s f country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFCountry>> listenersList = new ArrayList<ModelListener<ESFCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFCOUNTRY = "SELECT esfCountry FROM ESFCountry esfCountry";
	private static final String _SQL_COUNT_ESFCOUNTRY = "SELECT COUNT(esfCountry) FROM ESFCountry esfCountry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFCountry exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFCountryPersistenceImpl.class);
	private static ESFCountry _nullESFCountry = new ESFCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFCountry> toCacheModel() {
				return _nullESFCountryCacheModel;
			}
		};

	private static CacheModel<ESFCountry> _nullESFCountryCacheModel = new CacheModel<ESFCountry>() {
			@Override
			public ESFCountry toEntityModel() {
				return _nullESFCountry;
			}
		};
}