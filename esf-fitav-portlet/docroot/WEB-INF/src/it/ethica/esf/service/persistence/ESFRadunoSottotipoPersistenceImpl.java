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

import it.ethica.esf.NoSuchRadunoSottotipoException;
import it.ethica.esf.model.ESFRadunoSottotipo;
import it.ethica.esf.model.impl.ESFRadunoSottotipoImpl;
import it.ethica.esf.model.impl.ESFRadunoSottotipoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f raduno sottotipo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoSottotipoPersistence
 * @see ESFRadunoSottotipoUtil
 * @generated
 */
public class ESFRadunoSottotipoPersistenceImpl extends BasePersistenceImpl<ESFRadunoSottotipo>
	implements ESFRadunoSottotipoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRadunoSottotipoUtil} to access the e s f raduno sottotipo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRadunoSottotipoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipoModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoSottotipoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipoModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoSottotipoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFRadunoSottotipoPersistenceImpl() {
		setModelClass(ESFRadunoSottotipo.class);
	}

	/**
	 * Caches the e s f raduno sottotipo in the entity cache if it is enabled.
	 *
	 * @param esfRadunoSottotipo the e s f raduno sottotipo
	 */
	@Override
	public void cacheResult(ESFRadunoSottotipo esfRadunoSottotipo) {
		EntityCacheUtil.putResult(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipoImpl.class, esfRadunoSottotipo.getPrimaryKey(),
			esfRadunoSottotipo);

		esfRadunoSottotipo.resetOriginalValues();
	}

	/**
	 * Caches the e s f raduno sottotipos in the entity cache if it is enabled.
	 *
	 * @param esfRadunoSottotipos the e s f raduno sottotipos
	 */
	@Override
	public void cacheResult(List<ESFRadunoSottotipo> esfRadunoSottotipos) {
		for (ESFRadunoSottotipo esfRadunoSottotipo : esfRadunoSottotipos) {
			if (EntityCacheUtil.getResult(
						ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoSottotipoImpl.class,
						esfRadunoSottotipo.getPrimaryKey()) == null) {
				cacheResult(esfRadunoSottotipo);
			}
			else {
				esfRadunoSottotipo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f raduno sottotipos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRadunoSottotipoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRadunoSottotipoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f raduno sottotipo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRadunoSottotipo esfRadunoSottotipo) {
		EntityCacheUtil.removeResult(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipoImpl.class, esfRadunoSottotipo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFRadunoSottotipo> esfRadunoSottotipos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRadunoSottotipo esfRadunoSottotipo : esfRadunoSottotipos) {
			EntityCacheUtil.removeResult(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoSottotipoImpl.class, esfRadunoSottotipo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f raduno sottotipo with the primary key. Does not add the e s f raduno sottotipo to the database.
	 *
	 * @param id_esf_raduno_sottotipo the primary key for the new e s f raduno sottotipo
	 * @return the new e s f raduno sottotipo
	 */
	@Override
	public ESFRadunoSottotipo create(long id_esf_raduno_sottotipo) {
		ESFRadunoSottotipo esfRadunoSottotipo = new ESFRadunoSottotipoImpl();

		esfRadunoSottotipo.setNew(true);
		esfRadunoSottotipo.setPrimaryKey(id_esf_raduno_sottotipo);

		return esfRadunoSottotipo;
	}

	/**
	 * Removes the e s f raduno sottotipo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_esf_raduno_sottotipo the primary key of the e s f raduno sottotipo
	 * @return the e s f raduno sottotipo that was removed
	 * @throws it.ethica.esf.NoSuchRadunoSottotipoException if a e s f raduno sottotipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipo remove(long id_esf_raduno_sottotipo)
		throws NoSuchRadunoSottotipoException, SystemException {
		return remove((Serializable)id_esf_raduno_sottotipo);
	}

	/**
	 * Removes the e s f raduno sottotipo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f raduno sottotipo
	 * @return the e s f raduno sottotipo that was removed
	 * @throws it.ethica.esf.NoSuchRadunoSottotipoException if a e s f raduno sottotipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipo remove(Serializable primaryKey)
		throws NoSuchRadunoSottotipoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRadunoSottotipo esfRadunoSottotipo = (ESFRadunoSottotipo)session.get(ESFRadunoSottotipoImpl.class,
					primaryKey);

			if (esfRadunoSottotipo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRadunoSottotipoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRadunoSottotipo);
		}
		catch (NoSuchRadunoSottotipoException nsee) {
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
	protected ESFRadunoSottotipo removeImpl(
		ESFRadunoSottotipo esfRadunoSottotipo) throws SystemException {
		esfRadunoSottotipo = toUnwrappedModel(esfRadunoSottotipo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRadunoSottotipo)) {
				esfRadunoSottotipo = (ESFRadunoSottotipo)session.get(ESFRadunoSottotipoImpl.class,
						esfRadunoSottotipo.getPrimaryKeyObj());
			}

			if (esfRadunoSottotipo != null) {
				session.delete(esfRadunoSottotipo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRadunoSottotipo != null) {
			clearCache(esfRadunoSottotipo);
		}

		return esfRadunoSottotipo;
	}

	@Override
	public ESFRadunoSottotipo updateImpl(
		it.ethica.esf.model.ESFRadunoSottotipo esfRadunoSottotipo)
		throws SystemException {
		esfRadunoSottotipo = toUnwrappedModel(esfRadunoSottotipo);

		boolean isNew = esfRadunoSottotipo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfRadunoSottotipo.isNew()) {
				session.save(esfRadunoSottotipo);

				esfRadunoSottotipo.setNew(false);
			}
			else {
				session.merge(esfRadunoSottotipo);
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

		EntityCacheUtil.putResult(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoSottotipoImpl.class, esfRadunoSottotipo.getPrimaryKey(),
			esfRadunoSottotipo);

		return esfRadunoSottotipo;
	}

	protected ESFRadunoSottotipo toUnwrappedModel(
		ESFRadunoSottotipo esfRadunoSottotipo) {
		if (esfRadunoSottotipo instanceof ESFRadunoSottotipoImpl) {
			return esfRadunoSottotipo;
		}

		ESFRadunoSottotipoImpl esfRadunoSottotipoImpl = new ESFRadunoSottotipoImpl();

		esfRadunoSottotipoImpl.setNew(esfRadunoSottotipo.isNew());
		esfRadunoSottotipoImpl.setPrimaryKey(esfRadunoSottotipo.getPrimaryKey());

		esfRadunoSottotipoImpl.setId_esf_raduno_sottotipo(esfRadunoSottotipo.getId_esf_raduno_sottotipo());
		esfRadunoSottotipoImpl.setDescrizione(esfRadunoSottotipo.getDescrizione());

		return esfRadunoSottotipoImpl;
	}

	/**
	 * Returns the e s f raduno sottotipo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno sottotipo
	 * @return the e s f raduno sottotipo
	 * @throws it.ethica.esf.NoSuchRadunoSottotipoException if a e s f raduno sottotipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRadunoSottotipoException, SystemException {
		ESFRadunoSottotipo esfRadunoSottotipo = fetchByPrimaryKey(primaryKey);

		if (esfRadunoSottotipo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRadunoSottotipoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRadunoSottotipo;
	}

	/**
	 * Returns the e s f raduno sottotipo with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoSottotipoException} if it could not be found.
	 *
	 * @param id_esf_raduno_sottotipo the primary key of the e s f raduno sottotipo
	 * @return the e s f raduno sottotipo
	 * @throws it.ethica.esf.NoSuchRadunoSottotipoException if a e s f raduno sottotipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipo findByPrimaryKey(long id_esf_raduno_sottotipo)
		throws NoSuchRadunoSottotipoException, SystemException {
		return findByPrimaryKey((Serializable)id_esf_raduno_sottotipo);
	}

	/**
	 * Returns the e s f raduno sottotipo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno sottotipo
	 * @return the e s f raduno sottotipo, or <code>null</code> if a e s f raduno sottotipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRadunoSottotipo esfRadunoSottotipo = (ESFRadunoSottotipo)EntityCacheUtil.getResult(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoSottotipoImpl.class, primaryKey);

		if (esfRadunoSottotipo == _nullESFRadunoSottotipo) {
			return null;
		}

		if (esfRadunoSottotipo == null) {
			Session session = null;

			try {
				session = openSession();

				esfRadunoSottotipo = (ESFRadunoSottotipo)session.get(ESFRadunoSottotipoImpl.class,
						primaryKey);

				if (esfRadunoSottotipo != null) {
					cacheResult(esfRadunoSottotipo);
				}
				else {
					EntityCacheUtil.putResult(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoSottotipoImpl.class, primaryKey,
						_nullESFRadunoSottotipo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRadunoSottotipoModelImpl.ENTITY_CACHE_ENABLED,
					ESFRadunoSottotipoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRadunoSottotipo;
	}

	/**
	 * Returns the e s f raduno sottotipo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_esf_raduno_sottotipo the primary key of the e s f raduno sottotipo
	 * @return the e s f raduno sottotipo, or <code>null</code> if a e s f raduno sottotipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoSottotipo fetchByPrimaryKey(long id_esf_raduno_sottotipo)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id_esf_raduno_sottotipo);
	}

	/**
	 * Returns all the e s f raduno sottotipos.
	 *
	 * @return the e s f raduno sottotipos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno sottotipos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno sottotipos
	 * @param end the upper bound of the range of e s f raduno sottotipos (not inclusive)
	 * @return the range of e s f raduno sottotipos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno sottotipos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno sottotipos
	 * @param end the upper bound of the range of e s f raduno sottotipos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f raduno sottotipos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoSottotipo> findAll(int start, int end,
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

		List<ESFRadunoSottotipo> list = (List<ESFRadunoSottotipo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRADUNOSOTTOTIPO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRADUNOSOTTOTIPO;

				if (pagination) {
					sql = sql.concat(ESFRadunoSottotipoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRadunoSottotipo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoSottotipo>(list);
				}
				else {
					list = (List<ESFRadunoSottotipo>)QueryUtil.list(q,
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
	 * Removes all the e s f raduno sottotipos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRadunoSottotipo esfRadunoSottotipo : findAll()) {
			remove(esfRadunoSottotipo);
		}
	}

	/**
	 * Returns the number of e s f raduno sottotipos.
	 *
	 * @return the number of e s f raduno sottotipos
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

				Query q = session.createQuery(_SQL_COUNT_ESFRADUNOSOTTOTIPO);

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
	 * Initializes the e s f raduno sottotipo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRadunoSottotipo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRadunoSottotipo>> listenersList = new ArrayList<ModelListener<ESFRadunoSottotipo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRadunoSottotipo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRadunoSottotipoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRADUNOSOTTOTIPO = "SELECT esfRadunoSottotipo FROM ESFRadunoSottotipo esfRadunoSottotipo";
	private static final String _SQL_COUNT_ESFRADUNOSOTTOTIPO = "SELECT COUNT(esfRadunoSottotipo) FROM ESFRadunoSottotipo esfRadunoSottotipo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRadunoSottotipo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRadunoSottotipo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRadunoSottotipoPersistenceImpl.class);
	private static ESFRadunoSottotipo _nullESFRadunoSottotipo = new ESFRadunoSottotipoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRadunoSottotipo> toCacheModel() {
				return _nullESFRadunoSottotipoCacheModel;
			}
		};

	private static CacheModel<ESFRadunoSottotipo> _nullESFRadunoSottotipoCacheModel =
		new CacheModel<ESFRadunoSottotipo>() {
			@Override
			public ESFRadunoSottotipo toEntityModel() {
				return _nullESFRadunoSottotipo;
			}
		};
}