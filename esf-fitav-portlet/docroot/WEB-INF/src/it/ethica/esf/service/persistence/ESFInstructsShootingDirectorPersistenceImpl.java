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

import it.ethica.esf.NoSuchInstructsShootingDirectorException;
import it.ethica.esf.model.ESFInstructsShootingDirector;
import it.ethica.esf.model.impl.ESFInstructsShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFInstructsShootingDirectorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f instructs shooting director service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFInstructsShootingDirectorPersistence
 * @see ESFInstructsShootingDirectorUtil
 * @generated
 */
public class ESFInstructsShootingDirectorPersistenceImpl
	extends BasePersistenceImpl<ESFInstructsShootingDirector>
	implements ESFInstructsShootingDirectorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFInstructsShootingDirectorUtil} to access the e s f instructs shooting director persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFInstructsShootingDirectorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFInstructsShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFInstructsShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFInstructsShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFInstructsShootingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFInstructsShootingDirectorModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public ESFInstructsShootingDirectorPersistenceImpl() {
		setModelClass(ESFInstructsShootingDirector.class);
	}

	/**
	 * Caches the e s f instructs shooting director in the entity cache if it is enabled.
	 *
	 * @param esfInstructsShootingDirector the e s f instructs shooting director
	 */
	@Override
	public void cacheResult(
		ESFInstructsShootingDirector esfInstructsShootingDirector) {
		EntityCacheUtil.putResult(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFInstructsShootingDirectorImpl.class,
			esfInstructsShootingDirector.getPrimaryKey(),
			esfInstructsShootingDirector);

		esfInstructsShootingDirector.resetOriginalValues();
	}

	/**
	 * Caches the e s f instructs shooting directors in the entity cache if it is enabled.
	 *
	 * @param esfInstructsShootingDirectors the e s f instructs shooting directors
	 */
	@Override
	public void cacheResult(
		List<ESFInstructsShootingDirector> esfInstructsShootingDirectors) {
		for (ESFInstructsShootingDirector esfInstructsShootingDirector : esfInstructsShootingDirectors) {
			if (EntityCacheUtil.getResult(
						ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
						ESFInstructsShootingDirectorImpl.class,
						esfInstructsShootingDirector.getPrimaryKey()) == null) {
				cacheResult(esfInstructsShootingDirector);
			}
			else {
				esfInstructsShootingDirector.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f instructs shooting directors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFInstructsShootingDirectorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFInstructsShootingDirectorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f instructs shooting director.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFInstructsShootingDirector esfInstructsShootingDirector) {
		EntityCacheUtil.removeResult(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFInstructsShootingDirectorImpl.class,
			esfInstructsShootingDirector.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFInstructsShootingDirector> esfInstructsShootingDirectors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFInstructsShootingDirector esfInstructsShootingDirector : esfInstructsShootingDirectors) {
			EntityCacheUtil.removeResult(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
				ESFInstructsShootingDirectorImpl.class,
				esfInstructsShootingDirector.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f instructs shooting director with the primary key. Does not add the e s f instructs shooting director to the database.
	 *
	 * @param esfInstructsShootingDirectorId the primary key for the new e s f instructs shooting director
	 * @return the new e s f instructs shooting director
	 */
	@Override
	public ESFInstructsShootingDirector create(
		long esfInstructsShootingDirectorId) {
		ESFInstructsShootingDirector esfInstructsShootingDirector = new ESFInstructsShootingDirectorImpl();

		esfInstructsShootingDirector.setNew(true);
		esfInstructsShootingDirector.setPrimaryKey(esfInstructsShootingDirectorId);

		return esfInstructsShootingDirector;
	}

	/**
	 * Removes the e s f instructs shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfInstructsShootingDirectorId the primary key of the e s f instructs shooting director
	 * @return the e s f instructs shooting director that was removed
	 * @throws it.ethica.esf.NoSuchInstructsShootingDirectorException if a e s f instructs shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFInstructsShootingDirector remove(
		long esfInstructsShootingDirectorId)
		throws NoSuchInstructsShootingDirectorException, SystemException {
		return remove((Serializable)esfInstructsShootingDirectorId);
	}

	/**
	 * Removes the e s f instructs shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f instructs shooting director
	 * @return the e s f instructs shooting director that was removed
	 * @throws it.ethica.esf.NoSuchInstructsShootingDirectorException if a e s f instructs shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFInstructsShootingDirector remove(Serializable primaryKey)
		throws NoSuchInstructsShootingDirectorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFInstructsShootingDirector esfInstructsShootingDirector = (ESFInstructsShootingDirector)session.get(ESFInstructsShootingDirectorImpl.class,
					primaryKey);

			if (esfInstructsShootingDirector == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstructsShootingDirectorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfInstructsShootingDirector);
		}
		catch (NoSuchInstructsShootingDirectorException nsee) {
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
	protected ESFInstructsShootingDirector removeImpl(
		ESFInstructsShootingDirector esfInstructsShootingDirector)
		throws SystemException {
		esfInstructsShootingDirector = toUnwrappedModel(esfInstructsShootingDirector);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfInstructsShootingDirector)) {
				esfInstructsShootingDirector = (ESFInstructsShootingDirector)session.get(ESFInstructsShootingDirectorImpl.class,
						esfInstructsShootingDirector.getPrimaryKeyObj());
			}

			if (esfInstructsShootingDirector != null) {
				session.delete(esfInstructsShootingDirector);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfInstructsShootingDirector != null) {
			clearCache(esfInstructsShootingDirector);
		}

		return esfInstructsShootingDirector;
	}

	@Override
	public ESFInstructsShootingDirector updateImpl(
		it.ethica.esf.model.ESFInstructsShootingDirector esfInstructsShootingDirector)
		throws SystemException {
		esfInstructsShootingDirector = toUnwrappedModel(esfInstructsShootingDirector);

		boolean isNew = esfInstructsShootingDirector.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfInstructsShootingDirector.isNew()) {
				session.save(esfInstructsShootingDirector);

				esfInstructsShootingDirector.setNew(false);
			}
			else {
				session.merge(esfInstructsShootingDirector);
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

		EntityCacheUtil.putResult(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFInstructsShootingDirectorImpl.class,
			esfInstructsShootingDirector.getPrimaryKey(),
			esfInstructsShootingDirector);

		return esfInstructsShootingDirector;
	}

	protected ESFInstructsShootingDirector toUnwrappedModel(
		ESFInstructsShootingDirector esfInstructsShootingDirector) {
		if (esfInstructsShootingDirector instanceof ESFInstructsShootingDirectorImpl) {
			return esfInstructsShootingDirector;
		}

		ESFInstructsShootingDirectorImpl esfInstructsShootingDirectorImpl = new ESFInstructsShootingDirectorImpl();

		esfInstructsShootingDirectorImpl.setNew(esfInstructsShootingDirector.isNew());
		esfInstructsShootingDirectorImpl.setPrimaryKey(esfInstructsShootingDirector.getPrimaryKey());

		esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorId(esfInstructsShootingDirector.getEsfInstructsShootingDirectorId());
		esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorCode(esfInstructsShootingDirector.getEsfInstructsShootingDirectorCode());
		esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorDesc(esfInstructsShootingDirector.getEsfInstructsShootingDirectorDesc());

		return esfInstructsShootingDirectorImpl;
	}

	/**
	 * Returns the e s f instructs shooting director with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f instructs shooting director
	 * @return the e s f instructs shooting director
	 * @throws it.ethica.esf.NoSuchInstructsShootingDirectorException if a e s f instructs shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFInstructsShootingDirector findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchInstructsShootingDirectorException, SystemException {
		ESFInstructsShootingDirector esfInstructsShootingDirector = fetchByPrimaryKey(primaryKey);

		if (esfInstructsShootingDirector == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstructsShootingDirectorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfInstructsShootingDirector;
	}

	/**
	 * Returns the e s f instructs shooting director with the primary key or throws a {@link it.ethica.esf.NoSuchInstructsShootingDirectorException} if it could not be found.
	 *
	 * @param esfInstructsShootingDirectorId the primary key of the e s f instructs shooting director
	 * @return the e s f instructs shooting director
	 * @throws it.ethica.esf.NoSuchInstructsShootingDirectorException if a e s f instructs shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFInstructsShootingDirector findByPrimaryKey(
		long esfInstructsShootingDirectorId)
		throws NoSuchInstructsShootingDirectorException, SystemException {
		return findByPrimaryKey((Serializable)esfInstructsShootingDirectorId);
	}

	/**
	 * Returns the e s f instructs shooting director with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f instructs shooting director
	 * @return the e s f instructs shooting director, or <code>null</code> if a e s f instructs shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFInstructsShootingDirector fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFInstructsShootingDirector esfInstructsShootingDirector = (ESFInstructsShootingDirector)EntityCacheUtil.getResult(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
				ESFInstructsShootingDirectorImpl.class, primaryKey);

		if (esfInstructsShootingDirector == _nullESFInstructsShootingDirector) {
			return null;
		}

		if (esfInstructsShootingDirector == null) {
			Session session = null;

			try {
				session = openSession();

				esfInstructsShootingDirector = (ESFInstructsShootingDirector)session.get(ESFInstructsShootingDirectorImpl.class,
						primaryKey);

				if (esfInstructsShootingDirector != null) {
					cacheResult(esfInstructsShootingDirector);
				}
				else {
					EntityCacheUtil.putResult(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
						ESFInstructsShootingDirectorImpl.class, primaryKey,
						_nullESFInstructsShootingDirector);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFInstructsShootingDirectorModelImpl.ENTITY_CACHE_ENABLED,
					ESFInstructsShootingDirectorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfInstructsShootingDirector;
	}

	/**
	 * Returns the e s f instructs shooting director with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfInstructsShootingDirectorId the primary key of the e s f instructs shooting director
	 * @return the e s f instructs shooting director, or <code>null</code> if a e s f instructs shooting director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFInstructsShootingDirector fetchByPrimaryKey(
		long esfInstructsShootingDirectorId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfInstructsShootingDirectorId);
	}

	/**
	 * Returns all the e s f instructs shooting directors.
	 *
	 * @return the e s f instructs shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFInstructsShootingDirector> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f instructs shooting directors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFInstructsShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f instructs shooting directors
	 * @param end the upper bound of the range of e s f instructs shooting directors (not inclusive)
	 * @return the range of e s f instructs shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFInstructsShootingDirector> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f instructs shooting directors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFInstructsShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f instructs shooting directors
	 * @param end the upper bound of the range of e s f instructs shooting directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f instructs shooting directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFInstructsShootingDirector> findAll(int start, int end,
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

		List<ESFInstructsShootingDirector> list = (List<ESFInstructsShootingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFINSTRUCTSSHOOTINGDIRECTOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFINSTRUCTSSHOOTINGDIRECTOR;

				if (pagination) {
					sql = sql.concat(ESFInstructsShootingDirectorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFInstructsShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFInstructsShootingDirector>(list);
				}
				else {
					list = (List<ESFInstructsShootingDirector>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the e s f instructs shooting directors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFInstructsShootingDirector esfInstructsShootingDirector : findAll()) {
			remove(esfInstructsShootingDirector);
		}
	}

	/**
	 * Returns the number of e s f instructs shooting directors.
	 *
	 * @return the number of e s f instructs shooting directors
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

				Query q = session.createQuery(_SQL_COUNT_ESFINSTRUCTSSHOOTINGDIRECTOR);

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
	 * Initializes the e s f instructs shooting director persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFInstructsShootingDirector")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFInstructsShootingDirector>> listenersList = new ArrayList<ModelListener<ESFInstructsShootingDirector>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFInstructsShootingDirector>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFInstructsShootingDirectorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFINSTRUCTSSHOOTINGDIRECTOR = "SELECT esfInstructsShootingDirector FROM ESFInstructsShootingDirector esfInstructsShootingDirector";
	private static final String _SQL_COUNT_ESFINSTRUCTSSHOOTINGDIRECTOR = "SELECT COUNT(esfInstructsShootingDirector) FROM ESFInstructsShootingDirector esfInstructsShootingDirector";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfInstructsShootingDirector.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFInstructsShootingDirector exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFInstructsShootingDirectorPersistenceImpl.class);
	private static ESFInstructsShootingDirector _nullESFInstructsShootingDirector =
		new ESFInstructsShootingDirectorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFInstructsShootingDirector> toCacheModel() {
				return _nullESFInstructsShootingDirectorCacheModel;
			}
		};

	private static CacheModel<ESFInstructsShootingDirector> _nullESFInstructsShootingDirectorCacheModel =
		new CacheModel<ESFInstructsShootingDirector>() {
			@Override
			public ESFInstructsShootingDirector toEntityModel() {
				return _nullESFInstructsShootingDirector;
			}
		};
}