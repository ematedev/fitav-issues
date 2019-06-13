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

import it.ethica.esf.NoSuchRadunoTipoException;
import it.ethica.esf.model.ESFRadunoTipo;
import it.ethica.esf.model.impl.ESFRadunoTipoImpl;
import it.ethica.esf.model.impl.ESFRadunoTipoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f raduno tipo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoTipoPersistence
 * @see ESFRadunoTipoUtil
 * @generated
 */
public class ESFRadunoTipoPersistenceImpl extends BasePersistenceImpl<ESFRadunoTipo>
	implements ESFRadunoTipoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRadunoTipoUtil} to access the e s f raduno tipo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRadunoTipoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoTipoModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoTipoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoTipoModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoTipoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoTipoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFRadunoTipoPersistenceImpl() {
		setModelClass(ESFRadunoTipo.class);
	}

	/**
	 * Caches the e s f raduno tipo in the entity cache if it is enabled.
	 *
	 * @param esfRadunoTipo the e s f raduno tipo
	 */
	@Override
	public void cacheResult(ESFRadunoTipo esfRadunoTipo) {
		EntityCacheUtil.putResult(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoTipoImpl.class, esfRadunoTipo.getPrimaryKey(),
			esfRadunoTipo);

		esfRadunoTipo.resetOriginalValues();
	}

	/**
	 * Caches the e s f raduno tipos in the entity cache if it is enabled.
	 *
	 * @param esfRadunoTipos the e s f raduno tipos
	 */
	@Override
	public void cacheResult(List<ESFRadunoTipo> esfRadunoTipos) {
		for (ESFRadunoTipo esfRadunoTipo : esfRadunoTipos) {
			if (EntityCacheUtil.getResult(
						ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoTipoImpl.class, esfRadunoTipo.getPrimaryKey()) == null) {
				cacheResult(esfRadunoTipo);
			}
			else {
				esfRadunoTipo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f raduno tipos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRadunoTipoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRadunoTipoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f raduno tipo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRadunoTipo esfRadunoTipo) {
		EntityCacheUtil.removeResult(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoTipoImpl.class, esfRadunoTipo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFRadunoTipo> esfRadunoTipos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRadunoTipo esfRadunoTipo : esfRadunoTipos) {
			EntityCacheUtil.removeResult(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoTipoImpl.class, esfRadunoTipo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f raduno tipo with the primary key. Does not add the e s f raduno tipo to the database.
	 *
	 * @param id_esf_raduno_tipo the primary key for the new e s f raduno tipo
	 * @return the new e s f raduno tipo
	 */
	@Override
	public ESFRadunoTipo create(long id_esf_raduno_tipo) {
		ESFRadunoTipo esfRadunoTipo = new ESFRadunoTipoImpl();

		esfRadunoTipo.setNew(true);
		esfRadunoTipo.setPrimaryKey(id_esf_raduno_tipo);

		return esfRadunoTipo;
	}

	/**
	 * Removes the e s f raduno tipo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_esf_raduno_tipo the primary key of the e s f raduno tipo
	 * @return the e s f raduno tipo that was removed
	 * @throws it.ethica.esf.NoSuchRadunoTipoException if a e s f raduno tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoTipo remove(long id_esf_raduno_tipo)
		throws NoSuchRadunoTipoException, SystemException {
		return remove((Serializable)id_esf_raduno_tipo);
	}

	/**
	 * Removes the e s f raduno tipo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f raduno tipo
	 * @return the e s f raduno tipo that was removed
	 * @throws it.ethica.esf.NoSuchRadunoTipoException if a e s f raduno tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoTipo remove(Serializable primaryKey)
		throws NoSuchRadunoTipoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRadunoTipo esfRadunoTipo = (ESFRadunoTipo)session.get(ESFRadunoTipoImpl.class,
					primaryKey);

			if (esfRadunoTipo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRadunoTipoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRadunoTipo);
		}
		catch (NoSuchRadunoTipoException nsee) {
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
	protected ESFRadunoTipo removeImpl(ESFRadunoTipo esfRadunoTipo)
		throws SystemException {
		esfRadunoTipo = toUnwrappedModel(esfRadunoTipo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRadunoTipo)) {
				esfRadunoTipo = (ESFRadunoTipo)session.get(ESFRadunoTipoImpl.class,
						esfRadunoTipo.getPrimaryKeyObj());
			}

			if (esfRadunoTipo != null) {
				session.delete(esfRadunoTipo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRadunoTipo != null) {
			clearCache(esfRadunoTipo);
		}

		return esfRadunoTipo;
	}

	@Override
	public ESFRadunoTipo updateImpl(
		it.ethica.esf.model.ESFRadunoTipo esfRadunoTipo)
		throws SystemException {
		esfRadunoTipo = toUnwrappedModel(esfRadunoTipo);

		boolean isNew = esfRadunoTipo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfRadunoTipo.isNew()) {
				session.save(esfRadunoTipo);

				esfRadunoTipo.setNew(false);
			}
			else {
				session.merge(esfRadunoTipo);
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

		EntityCacheUtil.putResult(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoTipoImpl.class, esfRadunoTipo.getPrimaryKey(),
			esfRadunoTipo);

		return esfRadunoTipo;
	}

	protected ESFRadunoTipo toUnwrappedModel(ESFRadunoTipo esfRadunoTipo) {
		if (esfRadunoTipo instanceof ESFRadunoTipoImpl) {
			return esfRadunoTipo;
		}

		ESFRadunoTipoImpl esfRadunoTipoImpl = new ESFRadunoTipoImpl();

		esfRadunoTipoImpl.setNew(esfRadunoTipo.isNew());
		esfRadunoTipoImpl.setPrimaryKey(esfRadunoTipo.getPrimaryKey());

		esfRadunoTipoImpl.setId_esf_raduno_tipo(esfRadunoTipo.getId_esf_raduno_tipo());
		esfRadunoTipoImpl.setDescrizione(esfRadunoTipo.getDescrizione());

		return esfRadunoTipoImpl;
	}

	/**
	 * Returns the e s f raduno tipo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno tipo
	 * @return the e s f raduno tipo
	 * @throws it.ethica.esf.NoSuchRadunoTipoException if a e s f raduno tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoTipo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRadunoTipoException, SystemException {
		ESFRadunoTipo esfRadunoTipo = fetchByPrimaryKey(primaryKey);

		if (esfRadunoTipo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRadunoTipoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRadunoTipo;
	}

	/**
	 * Returns the e s f raduno tipo with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoTipoException} if it could not be found.
	 *
	 * @param id_esf_raduno_tipo the primary key of the e s f raduno tipo
	 * @return the e s f raduno tipo
	 * @throws it.ethica.esf.NoSuchRadunoTipoException if a e s f raduno tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoTipo findByPrimaryKey(long id_esf_raduno_tipo)
		throws NoSuchRadunoTipoException, SystemException {
		return findByPrimaryKey((Serializable)id_esf_raduno_tipo);
	}

	/**
	 * Returns the e s f raduno tipo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno tipo
	 * @return the e s f raduno tipo, or <code>null</code> if a e s f raduno tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoTipo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRadunoTipo esfRadunoTipo = (ESFRadunoTipo)EntityCacheUtil.getResult(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoTipoImpl.class, primaryKey);

		if (esfRadunoTipo == _nullESFRadunoTipo) {
			return null;
		}

		if (esfRadunoTipo == null) {
			Session session = null;

			try {
				session = openSession();

				esfRadunoTipo = (ESFRadunoTipo)session.get(ESFRadunoTipoImpl.class,
						primaryKey);

				if (esfRadunoTipo != null) {
					cacheResult(esfRadunoTipo);
				}
				else {
					EntityCacheUtil.putResult(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoTipoImpl.class, primaryKey, _nullESFRadunoTipo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRadunoTipoModelImpl.ENTITY_CACHE_ENABLED,
					ESFRadunoTipoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRadunoTipo;
	}

	/**
	 * Returns the e s f raduno tipo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_esf_raduno_tipo the primary key of the e s f raduno tipo
	 * @return the e s f raduno tipo, or <code>null</code> if a e s f raduno tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoTipo fetchByPrimaryKey(long id_esf_raduno_tipo)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id_esf_raduno_tipo);
	}

	/**
	 * Returns all the e s f raduno tipos.
	 *
	 * @return the e s f raduno tipos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoTipo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno tipos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoTipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno tipos
	 * @param end the upper bound of the range of e s f raduno tipos (not inclusive)
	 * @return the range of e s f raduno tipos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoTipo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno tipos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoTipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno tipos
	 * @param end the upper bound of the range of e s f raduno tipos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f raduno tipos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoTipo> findAll(int start, int end,
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

		List<ESFRadunoTipo> list = (List<ESFRadunoTipo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRADUNOTIPO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRADUNOTIPO;

				if (pagination) {
					sql = sql.concat(ESFRadunoTipoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRadunoTipo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoTipo>(list);
				}
				else {
					list = (List<ESFRadunoTipo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f raduno tipos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRadunoTipo esfRadunoTipo : findAll()) {
			remove(esfRadunoTipo);
		}
	}

	/**
	 * Returns the number of e s f raduno tipos.
	 *
	 * @return the number of e s f raduno tipos
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

				Query q = session.createQuery(_SQL_COUNT_ESFRADUNOTIPO);

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
	 * Initializes the e s f raduno tipo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRadunoTipo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRadunoTipo>> listenersList = new ArrayList<ModelListener<ESFRadunoTipo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRadunoTipo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRadunoTipoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRADUNOTIPO = "SELECT esfRadunoTipo FROM ESFRadunoTipo esfRadunoTipo";
	private static final String _SQL_COUNT_ESFRADUNOTIPO = "SELECT COUNT(esfRadunoTipo) FROM ESFRadunoTipo esfRadunoTipo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRadunoTipo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRadunoTipo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRadunoTipoPersistenceImpl.class);
	private static ESFRadunoTipo _nullESFRadunoTipo = new ESFRadunoTipoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRadunoTipo> toCacheModel() {
				return _nullESFRadunoTipoCacheModel;
			}
		};

	private static CacheModel<ESFRadunoTipo> _nullESFRadunoTipoCacheModel = new CacheModel<ESFRadunoTipo>() {
			@Override
			public ESFRadunoTipo toEntityModel() {
				return _nullESFRadunoTipo;
			}
		};
}