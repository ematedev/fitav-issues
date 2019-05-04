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

import it.ethica.esf.NoSuchvw_datidirettoretiroException;
import it.ethica.esf.model.impl.vw_datidirettoretiroImpl;
import it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl;
import it.ethica.esf.model.vw_datidirettoretiro;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vw_datidirettoretiro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see vw_datidirettoretiroPersistence
 * @see vw_datidirettoretiroUtil
 * @generated
 */
public class vw_datidirettoretiroPersistenceImpl extends BasePersistenceImpl<vw_datidirettoretiro>
	implements vw_datidirettoretiroPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vw_datidirettoretiroUtil} to access the vw_datidirettoretiro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = vw_datidirettoretiroImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
			vw_datidirettoretiroModelImpl.FINDER_CACHE_ENABLED,
			vw_datidirettoretiroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
			vw_datidirettoretiroModelImpl.FINDER_CACHE_ENABLED,
			vw_datidirettoretiroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
			vw_datidirettoretiroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public vw_datidirettoretiroPersistenceImpl() {
		setModelClass(vw_datidirettoretiro.class);
	}

	/**
	 * Caches the vw_datidirettoretiro in the entity cache if it is enabled.
	 *
	 * @param vw_datidirettoretiro the vw_datidirettoretiro
	 */
	@Override
	public void cacheResult(vw_datidirettoretiro vw_datidirettoretiro) {
		EntityCacheUtil.putResult(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
			vw_datidirettoretiroImpl.class,
			vw_datidirettoretiro.getPrimaryKey(), vw_datidirettoretiro);

		vw_datidirettoretiro.resetOriginalValues();
	}

	/**
	 * Caches the vw_datidirettoretiros in the entity cache if it is enabled.
	 *
	 * @param vw_datidirettoretiros the vw_datidirettoretiros
	 */
	@Override
	public void cacheResult(List<vw_datidirettoretiro> vw_datidirettoretiros) {
		for (vw_datidirettoretiro vw_datidirettoretiro : vw_datidirettoretiros) {
			if (EntityCacheUtil.getResult(
						vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
						vw_datidirettoretiroImpl.class,
						vw_datidirettoretiro.getPrimaryKey()) == null) {
				cacheResult(vw_datidirettoretiro);
			}
			else {
				vw_datidirettoretiro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vw_datidirettoretiros.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(vw_datidirettoretiroImpl.class.getName());
		}

		EntityCacheUtil.clearCache(vw_datidirettoretiroImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vw_datidirettoretiro.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(vw_datidirettoretiro vw_datidirettoretiro) {
		EntityCacheUtil.removeResult(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
			vw_datidirettoretiroImpl.class, vw_datidirettoretiro.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<vw_datidirettoretiro> vw_datidirettoretiros) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (vw_datidirettoretiro vw_datidirettoretiro : vw_datidirettoretiros) {
			EntityCacheUtil.removeResult(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
				vw_datidirettoretiroImpl.class,
				vw_datidirettoretiro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vw_datidirettoretiro with the primary key. Does not add the vw_datidirettoretiro to the database.
	 *
	 * @param vw_datidirettoretiroPK the primary key for the new vw_datidirettoretiro
	 * @return the new vw_datidirettoretiro
	 */
	@Override
	public vw_datidirettoretiro create(
		vw_datidirettoretiroPK vw_datidirettoretiroPK) {
		vw_datidirettoretiro vw_datidirettoretiro = new vw_datidirettoretiroImpl();

		vw_datidirettoretiro.setNew(true);
		vw_datidirettoretiro.setPrimaryKey(vw_datidirettoretiroPK);

		return vw_datidirettoretiro;
	}

	/**
	 * Removes the vw_datidirettoretiro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	 * @return the vw_datidirettoretiro that was removed
	 * @throws it.ethica.esf.NoSuchvw_datidirettoretiroException if a vw_datidirettoretiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vw_datidirettoretiro remove(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws NoSuchvw_datidirettoretiroException, SystemException {
		return remove((Serializable)vw_datidirettoretiroPK);
	}

	/**
	 * Removes the vw_datidirettoretiro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vw_datidirettoretiro
	 * @return the vw_datidirettoretiro that was removed
	 * @throws it.ethica.esf.NoSuchvw_datidirettoretiroException if a vw_datidirettoretiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vw_datidirettoretiro remove(Serializable primaryKey)
		throws NoSuchvw_datidirettoretiroException, SystemException {
		Session session = null;

		try {
			session = openSession();

			vw_datidirettoretiro vw_datidirettoretiro = (vw_datidirettoretiro)session.get(vw_datidirettoretiroImpl.class,
					primaryKey);

			if (vw_datidirettoretiro == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchvw_datidirettoretiroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vw_datidirettoretiro);
		}
		catch (NoSuchvw_datidirettoretiroException nsee) {
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
	protected vw_datidirettoretiro removeImpl(
		vw_datidirettoretiro vw_datidirettoretiro) throws SystemException {
		vw_datidirettoretiro = toUnwrappedModel(vw_datidirettoretiro);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vw_datidirettoretiro)) {
				vw_datidirettoretiro = (vw_datidirettoretiro)session.get(vw_datidirettoretiroImpl.class,
						vw_datidirettoretiro.getPrimaryKeyObj());
			}

			if (vw_datidirettoretiro != null) {
				session.delete(vw_datidirettoretiro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vw_datidirettoretiro != null) {
			clearCache(vw_datidirettoretiro);
		}

		return vw_datidirettoretiro;
	}

	@Override
	public vw_datidirettoretiro updateImpl(
		it.ethica.esf.model.vw_datidirettoretiro vw_datidirettoretiro)
		throws SystemException {
		vw_datidirettoretiro = toUnwrappedModel(vw_datidirettoretiro);

		boolean isNew = vw_datidirettoretiro.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vw_datidirettoretiro.isNew()) {
				session.save(vw_datidirettoretiro);

				vw_datidirettoretiro.setNew(false);
			}
			else {
				session.merge(vw_datidirettoretiro);
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

		EntityCacheUtil.putResult(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
			vw_datidirettoretiroImpl.class,
			vw_datidirettoretiro.getPrimaryKey(), vw_datidirettoretiro);

		return vw_datidirettoretiro;
	}

	protected vw_datidirettoretiro toUnwrappedModel(
		vw_datidirettoretiro vw_datidirettoretiro) {
		if (vw_datidirettoretiro instanceof vw_datidirettoretiroImpl) {
			return vw_datidirettoretiro;
		}

		vw_datidirettoretiroImpl vw_datidirettoretiroImpl = new vw_datidirettoretiroImpl();

		vw_datidirettoretiroImpl.setNew(vw_datidirettoretiro.isNew());
		vw_datidirettoretiroImpl.setPrimaryKey(vw_datidirettoretiro.getPrimaryKey());

		vw_datidirettoretiroImpl.setEsfshootingdirectorid(vw_datidirettoretiro.getEsfshootingdirectorid());
		vw_datidirettoretiroImpl.setNome(vw_datidirettoretiro.getNome());
		vw_datidirettoretiroImpl.setCognome(vw_datidirettoretiro.getCognome());
		vw_datidirettoretiroImpl.setEsfstartdata(vw_datidirettoretiro.getEsfstartdata());
		vw_datidirettoretiroImpl.setCategoryid(vw_datidirettoretiro.getCategoryid());
		vw_datidirettoretiroImpl.setNumerotessera(vw_datidirettoretiro.getNumerotessera());
		vw_datidirettoretiroImpl.setCodiceregione(vw_datidirettoretiro.getCodiceregione());

		return vw_datidirettoretiroImpl;
	}

	/**
	 * Returns the vw_datidirettoretiro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vw_datidirettoretiro
	 * @return the vw_datidirettoretiro
	 * @throws it.ethica.esf.NoSuchvw_datidirettoretiroException if a vw_datidirettoretiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vw_datidirettoretiro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchvw_datidirettoretiroException, SystemException {
		vw_datidirettoretiro vw_datidirettoretiro = fetchByPrimaryKey(primaryKey);

		if (vw_datidirettoretiro == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchvw_datidirettoretiroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vw_datidirettoretiro;
	}

	/**
	 * Returns the vw_datidirettoretiro with the primary key or throws a {@link it.ethica.esf.NoSuchvw_datidirettoretiroException} if it could not be found.
	 *
	 * @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	 * @return the vw_datidirettoretiro
	 * @throws it.ethica.esf.NoSuchvw_datidirettoretiroException if a vw_datidirettoretiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vw_datidirettoretiro findByPrimaryKey(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws NoSuchvw_datidirettoretiroException, SystemException {
		return findByPrimaryKey((Serializable)vw_datidirettoretiroPK);
	}

	/**
	 * Returns the vw_datidirettoretiro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vw_datidirettoretiro
	 * @return the vw_datidirettoretiro, or <code>null</code> if a vw_datidirettoretiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vw_datidirettoretiro fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		vw_datidirettoretiro vw_datidirettoretiro = (vw_datidirettoretiro)EntityCacheUtil.getResult(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
				vw_datidirettoretiroImpl.class, primaryKey);

		if (vw_datidirettoretiro == _nullvw_datidirettoretiro) {
			return null;
		}

		if (vw_datidirettoretiro == null) {
			Session session = null;

			try {
				session = openSession();

				vw_datidirettoretiro = (vw_datidirettoretiro)session.get(vw_datidirettoretiroImpl.class,
						primaryKey);

				if (vw_datidirettoretiro != null) {
					cacheResult(vw_datidirettoretiro);
				}
				else {
					EntityCacheUtil.putResult(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
						vw_datidirettoretiroImpl.class, primaryKey,
						_nullvw_datidirettoretiro);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(vw_datidirettoretiroModelImpl.ENTITY_CACHE_ENABLED,
					vw_datidirettoretiroImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vw_datidirettoretiro;
	}

	/**
	 * Returns the vw_datidirettoretiro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	 * @return the vw_datidirettoretiro, or <code>null</code> if a vw_datidirettoretiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vw_datidirettoretiro fetchByPrimaryKey(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vw_datidirettoretiroPK);
	}

	/**
	 * Returns all the vw_datidirettoretiros.
	 *
	 * @return the vw_datidirettoretiros
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<vw_datidirettoretiro> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vw_datidirettoretiros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vw_datidirettoretiros
	 * @param end the upper bound of the range of vw_datidirettoretiros (not inclusive)
	 * @return the range of vw_datidirettoretiros
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<vw_datidirettoretiro> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vw_datidirettoretiros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vw_datidirettoretiros
	 * @param end the upper bound of the range of vw_datidirettoretiros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vw_datidirettoretiros
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<vw_datidirettoretiro> findAll(int start, int end,
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

		List<vw_datidirettoretiro> list = (List<vw_datidirettoretiro>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VW_DATIDIRETTORETIRO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VW_DATIDIRETTORETIRO;

				if (pagination) {
					sql = sql.concat(vw_datidirettoretiroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<vw_datidirettoretiro>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<vw_datidirettoretiro>(list);
				}
				else {
					list = (List<vw_datidirettoretiro>)QueryUtil.list(q,
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
	 * Removes all the vw_datidirettoretiros from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (vw_datidirettoretiro vw_datidirettoretiro : findAll()) {
			remove(vw_datidirettoretiro);
		}
	}

	/**
	 * Returns the number of vw_datidirettoretiros.
	 *
	 * @return the number of vw_datidirettoretiros
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

				Query q = session.createQuery(_SQL_COUNT_VW_DATIDIRETTORETIRO);

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
	 * Initializes the vw_datidirettoretiro persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.vw_datidirettoretiro")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<vw_datidirettoretiro>> listenersList = new ArrayList<ModelListener<vw_datidirettoretiro>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<vw_datidirettoretiro>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(vw_datidirettoretiroImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VW_DATIDIRETTORETIRO = "SELECT vw_datidirettoretiro FROM vw_datidirettoretiro vw_datidirettoretiro";
	private static final String _SQL_COUNT_VW_DATIDIRETTORETIRO = "SELECT COUNT(vw_datidirettoretiro) FROM vw_datidirettoretiro vw_datidirettoretiro";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vw_datidirettoretiro.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No vw_datidirettoretiro exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(vw_datidirettoretiroPersistenceImpl.class);
	private static vw_datidirettoretiro _nullvw_datidirettoretiro = new vw_datidirettoretiroImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<vw_datidirettoretiro> toCacheModel() {
				return _nullvw_datidirettoretiroCacheModel;
			}
		};

	private static CacheModel<vw_datidirettoretiro> _nullvw_datidirettoretiroCacheModel =
		new CacheModel<vw_datidirettoretiro>() {
			@Override
			public vw_datidirettoretiro toEntityModel() {
				return _nullvw_datidirettoretiro;
			}
		};
}