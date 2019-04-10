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

import it.ethica.esf.NoSuchAirportException;
import it.ethica.esf.model.ESFAirport;
import it.ethica.esf.model.impl.ESFAirportImpl;
import it.ethica.esf.model.impl.ESFAirportModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f airport service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFAirportPersistence
 * @see ESFAirportUtil
 * @generated
 */
public class ESFAirportPersistenceImpl extends BasePersistenceImpl<ESFAirport>
	implements ESFAirportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFAirportUtil} to access the e s f airport persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFAirportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAirportModelImpl.FINDER_CACHE_ENABLED, ESFAirportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAirportModelImpl.FINDER_CACHE_ENABLED, ESFAirportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAirportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFAirportPersistenceImpl() {
		setModelClass(ESFAirport.class);
	}

	/**
	 * Caches the e s f airport in the entity cache if it is enabled.
	 *
	 * @param esfAirport the e s f airport
	 */
	@Override
	public void cacheResult(ESFAirport esfAirport) {
		EntityCacheUtil.putResult(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAirportImpl.class, esfAirport.getPrimaryKey(), esfAirport);

		esfAirport.resetOriginalValues();
	}

	/**
	 * Caches the e s f airports in the entity cache if it is enabled.
	 *
	 * @param esfAirports the e s f airports
	 */
	@Override
	public void cacheResult(List<ESFAirport> esfAirports) {
		for (ESFAirport esfAirport : esfAirports) {
			if (EntityCacheUtil.getResult(
						ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
						ESFAirportImpl.class, esfAirport.getPrimaryKey()) == null) {
				cacheResult(esfAirport);
			}
			else {
				esfAirport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f airports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFAirportImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFAirportImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f airport.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFAirport esfAirport) {
		EntityCacheUtil.removeResult(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAirportImpl.class, esfAirport.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFAirport> esfAirports) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFAirport esfAirport : esfAirports) {
			EntityCacheUtil.removeResult(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
				ESFAirportImpl.class, esfAirport.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f airport with the primary key. Does not add the e s f airport to the database.
	 *
	 * @param esfAirportId the primary key for the new e s f airport
	 * @return the new e s f airport
	 */
	@Override
	public ESFAirport create(long esfAirportId) {
		ESFAirport esfAirport = new ESFAirportImpl();

		esfAirport.setNew(true);
		esfAirport.setPrimaryKey(esfAirportId);

		return esfAirport;
	}

	/**
	 * Removes the e s f airport with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfAirportId the primary key of the e s f airport
	 * @return the e s f airport that was removed
	 * @throws it.ethica.esf.NoSuchAirportException if a e s f airport with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAirport remove(long esfAirportId)
		throws NoSuchAirportException, SystemException {
		return remove((Serializable)esfAirportId);
	}

	/**
	 * Removes the e s f airport with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f airport
	 * @return the e s f airport that was removed
	 * @throws it.ethica.esf.NoSuchAirportException if a e s f airport with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAirport remove(Serializable primaryKey)
		throws NoSuchAirportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFAirport esfAirport = (ESFAirport)session.get(ESFAirportImpl.class,
					primaryKey);

			if (esfAirport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAirportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfAirport);
		}
		catch (NoSuchAirportException nsee) {
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
	protected ESFAirport removeImpl(ESFAirport esfAirport)
		throws SystemException {
		esfAirport = toUnwrappedModel(esfAirport);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfAirport)) {
				esfAirport = (ESFAirport)session.get(ESFAirportImpl.class,
						esfAirport.getPrimaryKeyObj());
			}

			if (esfAirport != null) {
				session.delete(esfAirport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfAirport != null) {
			clearCache(esfAirport);
		}

		return esfAirport;
	}

	@Override
	public ESFAirport updateImpl(it.ethica.esf.model.ESFAirport esfAirport)
		throws SystemException {
		esfAirport = toUnwrappedModel(esfAirport);

		boolean isNew = esfAirport.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfAirport.isNew()) {
				session.save(esfAirport);

				esfAirport.setNew(false);
			}
			else {
				session.merge(esfAirport);
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

		EntityCacheUtil.putResult(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAirportImpl.class, esfAirport.getPrimaryKey(), esfAirport);

		return esfAirport;
	}

	protected ESFAirport toUnwrappedModel(ESFAirport esfAirport) {
		if (esfAirport instanceof ESFAirportImpl) {
			return esfAirport;
		}

		ESFAirportImpl esfAirportImpl = new ESFAirportImpl();

		esfAirportImpl.setNew(esfAirport.isNew());
		esfAirportImpl.setPrimaryKey(esfAirport.getPrimaryKey());

		esfAirportImpl.setEsfAirportId(esfAirport.getEsfAirportId());
		esfAirportImpl.setName(esfAirport.getName());
		esfAirportImpl.setCity(esfAirport.getCity());
		esfAirportImpl.setCountry(esfAirport.getCountry());

		return esfAirportImpl;
	}

	/**
	 * Returns the e s f airport with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f airport
	 * @return the e s f airport
	 * @throws it.ethica.esf.NoSuchAirportException if a e s f airport with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAirport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAirportException, SystemException {
		ESFAirport esfAirport = fetchByPrimaryKey(primaryKey);

		if (esfAirport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAirportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfAirport;
	}

	/**
	 * Returns the e s f airport with the primary key or throws a {@link it.ethica.esf.NoSuchAirportException} if it could not be found.
	 *
	 * @param esfAirportId the primary key of the e s f airport
	 * @return the e s f airport
	 * @throws it.ethica.esf.NoSuchAirportException if a e s f airport with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAirport findByPrimaryKey(long esfAirportId)
		throws NoSuchAirportException, SystemException {
		return findByPrimaryKey((Serializable)esfAirportId);
	}

	/**
	 * Returns the e s f airport with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f airport
	 * @return the e s f airport, or <code>null</code> if a e s f airport with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAirport fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFAirport esfAirport = (ESFAirport)EntityCacheUtil.getResult(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
				ESFAirportImpl.class, primaryKey);

		if (esfAirport == _nullESFAirport) {
			return null;
		}

		if (esfAirport == null) {
			Session session = null;

			try {
				session = openSession();

				esfAirport = (ESFAirport)session.get(ESFAirportImpl.class,
						primaryKey);

				if (esfAirport != null) {
					cacheResult(esfAirport);
				}
				else {
					EntityCacheUtil.putResult(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
						ESFAirportImpl.class, primaryKey, _nullESFAirport);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFAirportModelImpl.ENTITY_CACHE_ENABLED,
					ESFAirportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfAirport;
	}

	/**
	 * Returns the e s f airport with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfAirportId the primary key of the e s f airport
	 * @return the e s f airport, or <code>null</code> if a e s f airport with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAirport fetchByPrimaryKey(long esfAirportId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfAirportId);
	}

	/**
	 * Returns all the e s f airports.
	 *
	 * @return the e s f airports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAirport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f airports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAirportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f airports
	 * @param end the upper bound of the range of e s f airports (not inclusive)
	 * @return the range of e s f airports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAirport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f airports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAirportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f airports
	 * @param end the upper bound of the range of e s f airports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f airports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAirport> findAll(int start, int end,
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

		List<ESFAirport> list = (List<ESFAirport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFAIRPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFAIRPORT;

				if (pagination) {
					sql = sql.concat(ESFAirportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFAirport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFAirport>(list);
				}
				else {
					list = (List<ESFAirport>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f airports from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFAirport esfAirport : findAll()) {
			remove(esfAirport);
		}
	}

	/**
	 * Returns the number of e s f airports.
	 *
	 * @return the number of e s f airports
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

				Query q = session.createQuery(_SQL_COUNT_ESFAIRPORT);

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
	 * Initializes the e s f airport persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFAirport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFAirport>> listenersList = new ArrayList<ModelListener<ESFAirport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFAirport>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFAirportImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFAIRPORT = "SELECT esfAirport FROM ESFAirport esfAirport";
	private static final String _SQL_COUNT_ESFAIRPORT = "SELECT COUNT(esfAirport) FROM ESFAirport esfAirport";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfAirport.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFAirport exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFAirportPersistenceImpl.class);
	private static ESFAirport _nullESFAirport = new ESFAirportImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFAirport> toCacheModel() {
				return _nullESFAirportCacheModel;
			}
		};

	private static CacheModel<ESFAirport> _nullESFAirportCacheModel = new CacheModel<ESFAirport>() {
			@Override
			public ESFAirport toEntityModel() {
				return _nullESFAirport;
			}
		};
}