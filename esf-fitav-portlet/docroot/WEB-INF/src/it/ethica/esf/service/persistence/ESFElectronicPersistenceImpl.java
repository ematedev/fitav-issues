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

import it.ethica.esf.NoSuchElectronicException;
import it.ethica.esf.model.ESFElectronic;
import it.ethica.esf.model.impl.ESFElectronicImpl;
import it.ethica.esf.model.impl.ESFElectronicModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f electronic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFElectronicPersistence
 * @see ESFElectronicUtil
 * @generated
 */
public class ESFElectronicPersistenceImpl extends BasePersistenceImpl<ESFElectronic>
	implements ESFElectronicPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFElectronicUtil} to access the e s f electronic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFElectronicImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFElectronicImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFElectronicModelImpl.FINDER_CACHE_ENABLED,
			ESFElectronicImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFElectronicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFElectronicPersistenceImpl() {
		setModelClass(ESFElectronic.class);
	}

	/**
	 * Caches the e s f electronic in the entity cache if it is enabled.
	 *
	 * @param esfElectronic the e s f electronic
	 */
	@Override
	public void cacheResult(ESFElectronic esfElectronic) {
		EntityCacheUtil.putResult(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFElectronicImpl.class, esfElectronic.getPrimaryKey(),
			esfElectronic);

		esfElectronic.resetOriginalValues();
	}

	/**
	 * Caches the e s f electronics in the entity cache if it is enabled.
	 *
	 * @param esfElectronics the e s f electronics
	 */
	@Override
	public void cacheResult(List<ESFElectronic> esfElectronics) {
		for (ESFElectronic esfElectronic : esfElectronics) {
			if (EntityCacheUtil.getResult(
						ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
						ESFElectronicImpl.class, esfElectronic.getPrimaryKey()) == null) {
				cacheResult(esfElectronic);
			}
			else {
				esfElectronic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f electronics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFElectronicImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFElectronicImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f electronic.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFElectronic esfElectronic) {
		EntityCacheUtil.removeResult(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFElectronicImpl.class, esfElectronic.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFElectronic> esfElectronics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFElectronic esfElectronic : esfElectronics) {
			EntityCacheUtil.removeResult(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
				ESFElectronicImpl.class, esfElectronic.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f electronic with the primary key. Does not add the e s f electronic to the database.
	 *
	 * @param electronicId the primary key for the new e s f electronic
	 * @return the new e s f electronic
	 */
	@Override
	public ESFElectronic create(long electronicId) {
		ESFElectronic esfElectronic = new ESFElectronicImpl();

		esfElectronic.setNew(true);
		esfElectronic.setPrimaryKey(electronicId);

		return esfElectronic;
	}

	/**
	 * Removes the e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electronicId the primary key of the e s f electronic
	 * @return the e s f electronic that was removed
	 * @throws it.ethica.esf.NoSuchElectronicException if a e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFElectronic remove(long electronicId)
		throws NoSuchElectronicException, SystemException {
		return remove((Serializable)electronicId);
	}

	/**
	 * Removes the e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f electronic
	 * @return the e s f electronic that was removed
	 * @throws it.ethica.esf.NoSuchElectronicException if a e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFElectronic remove(Serializable primaryKey)
		throws NoSuchElectronicException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFElectronic esfElectronic = (ESFElectronic)session.get(ESFElectronicImpl.class,
					primaryKey);

			if (esfElectronic == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElectronicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfElectronic);
		}
		catch (NoSuchElectronicException nsee) {
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
	protected ESFElectronic removeImpl(ESFElectronic esfElectronic)
		throws SystemException {
		esfElectronic = toUnwrappedModel(esfElectronic);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfElectronic)) {
				esfElectronic = (ESFElectronic)session.get(ESFElectronicImpl.class,
						esfElectronic.getPrimaryKeyObj());
			}

			if (esfElectronic != null) {
				session.delete(esfElectronic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfElectronic != null) {
			clearCache(esfElectronic);
		}

		return esfElectronic;
	}

	@Override
	public ESFElectronic updateImpl(
		it.ethica.esf.model.ESFElectronic esfElectronic)
		throws SystemException {
		esfElectronic = toUnwrappedModel(esfElectronic);

		boolean isNew = esfElectronic.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfElectronic.isNew()) {
				session.save(esfElectronic);

				esfElectronic.setNew(false);
			}
			else {
				session.merge(esfElectronic);
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

		EntityCacheUtil.putResult(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
			ESFElectronicImpl.class, esfElectronic.getPrimaryKey(),
			esfElectronic);

		return esfElectronic;
	}

	protected ESFElectronic toUnwrappedModel(ESFElectronic esfElectronic) {
		if (esfElectronic instanceof ESFElectronicImpl) {
			return esfElectronic;
		}

		ESFElectronicImpl esfElectronicImpl = new ESFElectronicImpl();

		esfElectronicImpl.setNew(esfElectronic.isNew());
		esfElectronicImpl.setPrimaryKey(esfElectronic.getPrimaryKey());

		esfElectronicImpl.setElectronicId(esfElectronic.getElectronicId());
		esfElectronicImpl.setName(esfElectronic.getName());
		esfElectronicImpl.setDescription(esfElectronic.getDescription());

		return esfElectronicImpl;
	}

	/**
	 * Returns the e s f electronic with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f electronic
	 * @return the e s f electronic
	 * @throws it.ethica.esf.NoSuchElectronicException if a e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFElectronic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElectronicException, SystemException {
		ESFElectronic esfElectronic = fetchByPrimaryKey(primaryKey);

		if (esfElectronic == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElectronicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfElectronic;
	}

	/**
	 * Returns the e s f electronic with the primary key or throws a {@link it.ethica.esf.NoSuchElectronicException} if it could not be found.
	 *
	 * @param electronicId the primary key of the e s f electronic
	 * @return the e s f electronic
	 * @throws it.ethica.esf.NoSuchElectronicException if a e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFElectronic findByPrimaryKey(long electronicId)
		throws NoSuchElectronicException, SystemException {
		return findByPrimaryKey((Serializable)electronicId);
	}

	/**
	 * Returns the e s f electronic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f electronic
	 * @return the e s f electronic, or <code>null</code> if a e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFElectronic fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFElectronic esfElectronic = (ESFElectronic)EntityCacheUtil.getResult(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
				ESFElectronicImpl.class, primaryKey);

		if (esfElectronic == _nullESFElectronic) {
			return null;
		}

		if (esfElectronic == null) {
			Session session = null;

			try {
				session = openSession();

				esfElectronic = (ESFElectronic)session.get(ESFElectronicImpl.class,
						primaryKey);

				if (esfElectronic != null) {
					cacheResult(esfElectronic);
				}
				else {
					EntityCacheUtil.putResult(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
						ESFElectronicImpl.class, primaryKey, _nullESFElectronic);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFElectronicModelImpl.ENTITY_CACHE_ENABLED,
					ESFElectronicImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfElectronic;
	}

	/**
	 * Returns the e s f electronic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electronicId the primary key of the e s f electronic
	 * @return the e s f electronic, or <code>null</code> if a e s f electronic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFElectronic fetchByPrimaryKey(long electronicId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)electronicId);
	}

	/**
	 * Returns all the e s f electronics.
	 *
	 * @return the e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFElectronic> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f electronics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f electronics
	 * @param end the upper bound of the range of e s f electronics (not inclusive)
	 * @return the range of e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFElectronic> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f electronics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f electronics
	 * @param end the upper bound of the range of e s f electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f electronics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFElectronic> findAll(int start, int end,
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

		List<ESFElectronic> list = (List<ESFElectronic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFELECTRONIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFELECTRONIC;

				if (pagination) {
					sql = sql.concat(ESFElectronicModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFElectronic>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFElectronic>(list);
				}
				else {
					list = (List<ESFElectronic>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f electronics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFElectronic esfElectronic : findAll()) {
			remove(esfElectronic);
		}
	}

	/**
	 * Returns the number of e s f electronics.
	 *
	 * @return the number of e s f electronics
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

				Query q = session.createQuery(_SQL_COUNT_ESFELECTRONIC);

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
	 * Initializes the e s f electronic persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFElectronic")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFElectronic>> listenersList = new ArrayList<ModelListener<ESFElectronic>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFElectronic>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFElectronicImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFELECTRONIC = "SELECT esfElectronic FROM ESFElectronic esfElectronic";
	private static final String _SQL_COUNT_ESFELECTRONIC = "SELECT COUNT(esfElectronic) FROM ESFElectronic esfElectronic";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfElectronic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFElectronic exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFElectronicPersistenceImpl.class);
	private static ESFElectronic _nullESFElectronic = new ESFElectronicImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFElectronic> toCacheModel() {
				return _nullESFElectronicCacheModel;
			}
		};

	private static CacheModel<ESFElectronic> _nullESFElectronicCacheModel = new CacheModel<ESFElectronic>() {
			@Override
			public ESFElectronic toEntityModel() {
				return _nullESFElectronic;
			}
		};
}