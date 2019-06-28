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

import it.ethica.esf.NoSuchRadunoException;
import it.ethica.esf.model.ESFRaduno;
import it.ethica.esf.model.impl.ESFRadunoImpl;
import it.ethica.esf.model.impl.ESFRadunoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f raduno service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoPersistence
 * @see ESFRadunoUtil
 * @generated
 */
public class ESFRadunoPersistenceImpl extends BasePersistenceImpl<ESFRaduno>
	implements ESFRadunoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRadunoUtil} to access the e s f raduno persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRadunoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoModelImpl.FINDER_CACHE_ENABLED, ESFRadunoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoModelImpl.FINDER_CACHE_ENABLED, ESFRadunoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFRadunoPersistenceImpl() {
		setModelClass(ESFRaduno.class);
	}

	/**
	 * Caches the e s f raduno in the entity cache if it is enabled.
	 *
	 * @param esfRaduno the e s f raduno
	 */
	@Override
	public void cacheResult(ESFRaduno esfRaduno) {
		EntityCacheUtil.putResult(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoImpl.class, esfRaduno.getPrimaryKey(), esfRaduno);

		esfRaduno.resetOriginalValues();
	}

	/**
	 * Caches the e s f radunos in the entity cache if it is enabled.
	 *
	 * @param esfRadunos the e s f radunos
	 */
	@Override
	public void cacheResult(List<ESFRaduno> esfRadunos) {
		for (ESFRaduno esfRaduno : esfRadunos) {
			if (EntityCacheUtil.getResult(
						ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoImpl.class, esfRaduno.getPrimaryKey()) == null) {
				cacheResult(esfRaduno);
			}
			else {
				esfRaduno.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f radunos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRadunoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRadunoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f raduno.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRaduno esfRaduno) {
		EntityCacheUtil.removeResult(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoImpl.class, esfRaduno.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFRaduno> esfRadunos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRaduno esfRaduno : esfRadunos) {
			EntityCacheUtil.removeResult(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoImpl.class, esfRaduno.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f raduno with the primary key. Does not add the e s f raduno to the database.
	 *
	 * @param id_esf_raduno the primary key for the new e s f raduno
	 * @return the new e s f raduno
	 */
	@Override
	public ESFRaduno create(long id_esf_raduno) {
		ESFRaduno esfRaduno = new ESFRadunoImpl();

		esfRaduno.setNew(true);
		esfRaduno.setPrimaryKey(id_esf_raduno);

		return esfRaduno;
	}

	/**
	 * Removes the e s f raduno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_esf_raduno the primary key of the e s f raduno
	 * @return the e s f raduno that was removed
	 * @throws it.ethica.esf.NoSuchRadunoException if a e s f raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRaduno remove(long id_esf_raduno)
		throws NoSuchRadunoException, SystemException {
		return remove((Serializable)id_esf_raduno);
	}

	/**
	 * Removes the e s f raduno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f raduno
	 * @return the e s f raduno that was removed
	 * @throws it.ethica.esf.NoSuchRadunoException if a e s f raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRaduno remove(Serializable primaryKey)
		throws NoSuchRadunoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRaduno esfRaduno = (ESFRaduno)session.get(ESFRadunoImpl.class,
					primaryKey);

			if (esfRaduno == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRadunoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRaduno);
		}
		catch (NoSuchRadunoException nsee) {
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
	protected ESFRaduno removeImpl(ESFRaduno esfRaduno)
		throws SystemException {
		esfRaduno = toUnwrappedModel(esfRaduno);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRaduno)) {
				esfRaduno = (ESFRaduno)session.get(ESFRadunoImpl.class,
						esfRaduno.getPrimaryKeyObj());
			}

			if (esfRaduno != null) {
				session.delete(esfRaduno);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRaduno != null) {
			clearCache(esfRaduno);
		}

		return esfRaduno;
	}

	@Override
	public ESFRaduno updateImpl(it.ethica.esf.model.ESFRaduno esfRaduno)
		throws SystemException {
		esfRaduno = toUnwrappedModel(esfRaduno);

		boolean isNew = esfRaduno.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfRaduno.isNew()) {
				session.save(esfRaduno);

				esfRaduno.setNew(false);
			}
			else {
				session.merge(esfRaduno);
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

		EntityCacheUtil.putResult(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoImpl.class, esfRaduno.getPrimaryKey(), esfRaduno);

		return esfRaduno;
	}

	protected ESFRaduno toUnwrappedModel(ESFRaduno esfRaduno) {
		if (esfRaduno instanceof ESFRadunoImpl) {
			return esfRaduno;
		}

		ESFRadunoImpl esfRadunoImpl = new ESFRadunoImpl();

		esfRadunoImpl.setNew(esfRaduno.isNew());
		esfRadunoImpl.setPrimaryKey(esfRaduno.getPrimaryKey());

		esfRadunoImpl.setId_esf_raduno(esfRaduno.getId_esf_raduno());
		esfRadunoImpl.setCodice(esfRaduno.getCodice());
		esfRadunoImpl.setData_inizio(esfRaduno.getData_inizio());
		esfRadunoImpl.setData_fine(esfRaduno.getData_fine());
		esfRadunoImpl.setTipo_raduno(esfRaduno.getTipo_raduno());
		esfRadunoImpl.setId_sottotipo_raduno(esfRaduno.getId_sottotipo_raduno());
		esfRadunoImpl.setNote(esfRaduno.getNote());
		esfRadunoImpl.setId_associazione_ospitante(esfRaduno.getId_associazione_ospitante());
		esfRadunoImpl.setAltra_sede_ospitante(esfRaduno.getAltra_sede_ospitante());

		return esfRadunoImpl;
	}

	/**
	 * Returns the e s f raduno with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno
	 * @return the e s f raduno
	 * @throws it.ethica.esf.NoSuchRadunoException if a e s f raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRaduno findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRadunoException, SystemException {
		ESFRaduno esfRaduno = fetchByPrimaryKey(primaryKey);

		if (esfRaduno == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRadunoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRaduno;
	}

	/**
	 * Returns the e s f raduno with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoException} if it could not be found.
	 *
	 * @param id_esf_raduno the primary key of the e s f raduno
	 * @return the e s f raduno
	 * @throws it.ethica.esf.NoSuchRadunoException if a e s f raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRaduno findByPrimaryKey(long id_esf_raduno)
		throws NoSuchRadunoException, SystemException {
		return findByPrimaryKey((Serializable)id_esf_raduno);
	}

	/**
	 * Returns the e s f raduno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno
	 * @return the e s f raduno, or <code>null</code> if a e s f raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRaduno fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRaduno esfRaduno = (ESFRaduno)EntityCacheUtil.getResult(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoImpl.class, primaryKey);

		if (esfRaduno == _nullESFRaduno) {
			return null;
		}

		if (esfRaduno == null) {
			Session session = null;

			try {
				session = openSession();

				esfRaduno = (ESFRaduno)session.get(ESFRadunoImpl.class,
						primaryKey);

				if (esfRaduno != null) {
					cacheResult(esfRaduno);
				}
				else {
					EntityCacheUtil.putResult(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoImpl.class, primaryKey, _nullESFRaduno);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRadunoModelImpl.ENTITY_CACHE_ENABLED,
					ESFRadunoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRaduno;
	}

	/**
	 * Returns the e s f raduno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_esf_raduno the primary key of the e s f raduno
	 * @return the e s f raduno, or <code>null</code> if a e s f raduno with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRaduno fetchByPrimaryKey(long id_esf_raduno)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id_esf_raduno);
	}

	/**
	 * Returns all the e s f radunos.
	 *
	 * @return the e s f radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRaduno> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f radunos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f radunos
	 * @param end the upper bound of the range of e s f radunos (not inclusive)
	 * @return the range of e s f radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRaduno> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f radunos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f radunos
	 * @param end the upper bound of the range of e s f radunos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f radunos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRaduno> findAll(int start, int end,
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

		List<ESFRaduno> list = (List<ESFRaduno>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRADUNO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRADUNO;

				if (pagination) {
					sql = sql.concat(ESFRadunoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRaduno>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRaduno>(list);
				}
				else {
					list = (List<ESFRaduno>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f radunos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRaduno esfRaduno : findAll()) {
			remove(esfRaduno);
		}
	}

	/**
	 * Returns the number of e s f radunos.
	 *
	 * @return the number of e s f radunos
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

				Query q = session.createQuery(_SQL_COUNT_ESFRADUNO);

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
	 * Initializes the e s f raduno persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRaduno")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRaduno>> listenersList = new ArrayList<ModelListener<ESFRaduno>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRaduno>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRadunoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRADUNO = "SELECT esfRaduno FROM ESFRaduno esfRaduno";
	private static final String _SQL_COUNT_ESFRADUNO = "SELECT COUNT(esfRaduno) FROM ESFRaduno esfRaduno";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRaduno.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRaduno exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRadunoPersistenceImpl.class);
	private static ESFRaduno _nullESFRaduno = new ESFRadunoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRaduno> toCacheModel() {
				return _nullESFRadunoCacheModel;
			}
		};

	private static CacheModel<ESFRaduno> _nullESFRadunoCacheModel = new CacheModel<ESFRaduno>() {
			@Override
			public ESFRaduno toEntityModel() {
				return _nullESFRaduno;
			}
		};
}