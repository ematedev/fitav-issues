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

import it.ethica.esf.NoSuchCategoryException;
import it.ethica.esf.model.ESFCategory;
import it.ethica.esf.model.impl.ESFCategoryImpl;
import it.ethica.esf.model.impl.ESFCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCategoryPersistence
 * @see ESFCategoryUtil
 * @generated
 */
public class ESFCategoryPersistenceImpl extends BasePersistenceImpl<ESFCategory>
	implements ESFCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFCategoryUtil} to access the e s f category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCategoryModelImpl.FINDER_CACHE_ENABLED, ESFCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCategoryModelImpl.FINDER_CACHE_ENABLED, ESFCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFCategoryPersistenceImpl() {
		setModelClass(ESFCategory.class);
	}

	/**
	 * Caches the e s f category in the entity cache if it is enabled.
	 *
	 * @param esfCategory the e s f category
	 */
	@Override
	public void cacheResult(ESFCategory esfCategory) {
		EntityCacheUtil.putResult(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCategoryImpl.class, esfCategory.getPrimaryKey(), esfCategory);

		esfCategory.resetOriginalValues();
	}

	/**
	 * Caches the e s f categories in the entity cache if it is enabled.
	 *
	 * @param esfCategories the e s f categories
	 */
	@Override
	public void cacheResult(List<ESFCategory> esfCategories) {
		for (ESFCategory esfCategory : esfCategories) {
			if (EntityCacheUtil.getResult(
						ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ESFCategoryImpl.class, esfCategory.getPrimaryKey()) == null) {
				cacheResult(esfCategory);
			}
			else {
				esfCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFCategory esfCategory) {
		EntityCacheUtil.removeResult(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCategoryImpl.class, esfCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFCategory> esfCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFCategory esfCategory : esfCategories) {
			EntityCacheUtil.removeResult(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ESFCategoryImpl.class, esfCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f category with the primary key. Does not add the e s f category to the database.
	 *
	 * @param esfCategoryId the primary key for the new e s f category
	 * @return the new e s f category
	 */
	@Override
	public ESFCategory create(long esfCategoryId) {
		ESFCategory esfCategory = new ESFCategoryImpl();

		esfCategory.setNew(true);
		esfCategory.setPrimaryKey(esfCategoryId);

		return esfCategory;
	}

	/**
	 * Removes the e s f category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfCategoryId the primary key of the e s f category
	 * @return the e s f category that was removed
	 * @throws it.ethica.esf.NoSuchCategoryException if a e s f category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCategory remove(long esfCategoryId)
		throws NoSuchCategoryException, SystemException {
		return remove((Serializable)esfCategoryId);
	}

	/**
	 * Removes the e s f category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f category
	 * @return the e s f category that was removed
	 * @throws it.ethica.esf.NoSuchCategoryException if a e s f category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCategory remove(Serializable primaryKey)
		throws NoSuchCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFCategory esfCategory = (ESFCategory)session.get(ESFCategoryImpl.class,
					primaryKey);

			if (esfCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfCategory);
		}
		catch (NoSuchCategoryException nsee) {
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
	protected ESFCategory removeImpl(ESFCategory esfCategory)
		throws SystemException {
		esfCategory = toUnwrappedModel(esfCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfCategory)) {
				esfCategory = (ESFCategory)session.get(ESFCategoryImpl.class,
						esfCategory.getPrimaryKeyObj());
			}

			if (esfCategory != null) {
				session.delete(esfCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfCategory != null) {
			clearCache(esfCategory);
		}

		return esfCategory;
	}

	@Override
	public ESFCategory updateImpl(it.ethica.esf.model.ESFCategory esfCategory)
		throws SystemException {
		esfCategory = toUnwrappedModel(esfCategory);

		boolean isNew = esfCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfCategory.isNew()) {
				session.save(esfCategory);

				esfCategory.setNew(false);
			}
			else {
				session.merge(esfCategory);
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

		EntityCacheUtil.putResult(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ESFCategoryImpl.class, esfCategory.getPrimaryKey(), esfCategory);

		return esfCategory;
	}

	protected ESFCategory toUnwrappedModel(ESFCategory esfCategory) {
		if (esfCategory instanceof ESFCategoryImpl) {
			return esfCategory;
		}

		ESFCategoryImpl esfCategoryImpl = new ESFCategoryImpl();

		esfCategoryImpl.setNew(esfCategory.isNew());
		esfCategoryImpl.setPrimaryKey(esfCategory.getPrimaryKey());

		esfCategoryImpl.setEsfCategoryId(esfCategory.getEsfCategoryId());
		esfCategoryImpl.setName(esfCategory.getName());
		esfCategoryImpl.setDescription(esfCategory.getDescription());

		return esfCategoryImpl;
	}

	/**
	 * Returns the e s f category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f category
	 * @return the e s f category
	 * @throws it.ethica.esf.NoSuchCategoryException if a e s f category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryException, SystemException {
		ESFCategory esfCategory = fetchByPrimaryKey(primaryKey);

		if (esfCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfCategory;
	}

	/**
	 * Returns the e s f category with the primary key or throws a {@link it.ethica.esf.NoSuchCategoryException} if it could not be found.
	 *
	 * @param esfCategoryId the primary key of the e s f category
	 * @return the e s f category
	 * @throws it.ethica.esf.NoSuchCategoryException if a e s f category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCategory findByPrimaryKey(long esfCategoryId)
		throws NoSuchCategoryException, SystemException {
		return findByPrimaryKey((Serializable)esfCategoryId);
	}

	/**
	 * Returns the e s f category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f category
	 * @return the e s f category, or <code>null</code> if a e s f category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFCategory esfCategory = (ESFCategory)EntityCacheUtil.getResult(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ESFCategoryImpl.class, primaryKey);

		if (esfCategory == _nullESFCategory) {
			return null;
		}

		if (esfCategory == null) {
			Session session = null;

			try {
				session = openSession();

				esfCategory = (ESFCategory)session.get(ESFCategoryImpl.class,
						primaryKey);

				if (esfCategory != null) {
					cacheResult(esfCategory);
				}
				else {
					EntityCacheUtil.putResult(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ESFCategoryImpl.class, primaryKey, _nullESFCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ESFCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfCategory;
	}

	/**
	 * Returns the e s f category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfCategoryId the primary key of the e s f category
	 * @return the e s f category, or <code>null</code> if a e s f category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCategory fetchByPrimaryKey(long esfCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfCategoryId);
	}

	/**
	 * Returns all the e s f categories.
	 *
	 * @return the e s f categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f categories
	 * @param end the upper bound of the range of e s f categories (not inclusive)
	 * @return the range of e s f categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f categories
	 * @param end the upper bound of the range of e s f categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCategory> findAll(int start, int end,
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

		List<ESFCategory> list = (List<ESFCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFCATEGORY;

				if (pagination) {
					sql = sql.concat(ESFCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCategory>(list);
				}
				else {
					list = (List<ESFCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFCategory esfCategory : findAll()) {
			remove(esfCategory);
		}
	}

	/**
	 * Returns the number of e s f categories.
	 *
	 * @return the number of e s f categories
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

				Query q = session.createQuery(_SQL_COUNT_ESFCATEGORY);

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
	 * Initializes the e s f category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFCategory>> listenersList = new ArrayList<ModelListener<ESFCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFCATEGORY = "SELECT esfCategory FROM ESFCategory esfCategory";
	private static final String _SQL_COUNT_ESFCATEGORY = "SELECT COUNT(esfCategory) FROM ESFCategory esfCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFCategory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFCategoryPersistenceImpl.class);
	private static ESFCategory _nullESFCategory = new ESFCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFCategory> toCacheModel() {
				return _nullESFCategoryCacheModel;
			}
		};

	private static CacheModel<ESFCategory> _nullESFCategoryCacheModel = new CacheModel<ESFCategory>() {
			@Override
			public ESFCategory toEntityModel() {
				return _nullESFCategory;
			}
		};
}