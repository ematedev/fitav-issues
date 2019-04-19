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

import it.ethica.esf.NoSuchPublicAuthorityException;
import it.ethica.esf.model.ESFPublicAuthority;
import it.ethica.esf.model.impl.ESFPublicAuthorityImpl;
import it.ethica.esf.model.impl.ESFPublicAuthorityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f public authority service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPublicAuthorityPersistence
 * @see ESFPublicAuthorityUtil
 * @generated
 */
public class ESFPublicAuthorityPersistenceImpl extends BasePersistenceImpl<ESFPublicAuthority>
	implements ESFPublicAuthorityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFPublicAuthorityUtil} to access the e s f public authority persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFPublicAuthorityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
			ESFPublicAuthorityModelImpl.FINDER_CACHE_ENABLED,
			ESFPublicAuthorityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
			ESFPublicAuthorityModelImpl.FINDER_CACHE_ENABLED,
			ESFPublicAuthorityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
			ESFPublicAuthorityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFPublicAuthorityPersistenceImpl() {
		setModelClass(ESFPublicAuthority.class);
	}

	/**
	 * Caches the e s f public authority in the entity cache if it is enabled.
	 *
	 * @param esfPublicAuthority the e s f public authority
	 */
	@Override
	public void cacheResult(ESFPublicAuthority esfPublicAuthority) {
		EntityCacheUtil.putResult(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
			ESFPublicAuthorityImpl.class, esfPublicAuthority.getPrimaryKey(),
			esfPublicAuthority);

		esfPublicAuthority.resetOriginalValues();
	}

	/**
	 * Caches the e s f public authorities in the entity cache if it is enabled.
	 *
	 * @param esfPublicAuthorities the e s f public authorities
	 */
	@Override
	public void cacheResult(List<ESFPublicAuthority> esfPublicAuthorities) {
		for (ESFPublicAuthority esfPublicAuthority : esfPublicAuthorities) {
			if (EntityCacheUtil.getResult(
						ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
						ESFPublicAuthorityImpl.class,
						esfPublicAuthority.getPrimaryKey()) == null) {
				cacheResult(esfPublicAuthority);
			}
			else {
				esfPublicAuthority.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f public authorities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFPublicAuthorityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFPublicAuthorityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f public authority.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFPublicAuthority esfPublicAuthority) {
		EntityCacheUtil.removeResult(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
			ESFPublicAuthorityImpl.class, esfPublicAuthority.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFPublicAuthority> esfPublicAuthorities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFPublicAuthority esfPublicAuthority : esfPublicAuthorities) {
			EntityCacheUtil.removeResult(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
				ESFPublicAuthorityImpl.class, esfPublicAuthority.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f public authority with the primary key. Does not add the e s f public authority to the database.
	 *
	 * @param esfPublicAuthorityId the primary key for the new e s f public authority
	 * @return the new e s f public authority
	 */
	@Override
	public ESFPublicAuthority create(long esfPublicAuthorityId) {
		ESFPublicAuthority esfPublicAuthority = new ESFPublicAuthorityImpl();

		esfPublicAuthority.setNew(true);
		esfPublicAuthority.setPrimaryKey(esfPublicAuthorityId);

		return esfPublicAuthority;
	}

	/**
	 * Removes the e s f public authority with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfPublicAuthorityId the primary key of the e s f public authority
	 * @return the e s f public authority that was removed
	 * @throws it.ethica.esf.NoSuchPublicAuthorityException if a e s f public authority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPublicAuthority remove(long esfPublicAuthorityId)
		throws NoSuchPublicAuthorityException, SystemException {
		return remove((Serializable)esfPublicAuthorityId);
	}

	/**
	 * Removes the e s f public authority with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f public authority
	 * @return the e s f public authority that was removed
	 * @throws it.ethica.esf.NoSuchPublicAuthorityException if a e s f public authority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPublicAuthority remove(Serializable primaryKey)
		throws NoSuchPublicAuthorityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFPublicAuthority esfPublicAuthority = (ESFPublicAuthority)session.get(ESFPublicAuthorityImpl.class,
					primaryKey);

			if (esfPublicAuthority == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublicAuthorityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfPublicAuthority);
		}
		catch (NoSuchPublicAuthorityException nsee) {
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
	protected ESFPublicAuthority removeImpl(
		ESFPublicAuthority esfPublicAuthority) throws SystemException {
		esfPublicAuthority = toUnwrappedModel(esfPublicAuthority);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfPublicAuthority)) {
				esfPublicAuthority = (ESFPublicAuthority)session.get(ESFPublicAuthorityImpl.class,
						esfPublicAuthority.getPrimaryKeyObj());
			}

			if (esfPublicAuthority != null) {
				session.delete(esfPublicAuthority);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfPublicAuthority != null) {
			clearCache(esfPublicAuthority);
		}

		return esfPublicAuthority;
	}

	@Override
	public ESFPublicAuthority updateImpl(
		it.ethica.esf.model.ESFPublicAuthority esfPublicAuthority)
		throws SystemException {
		esfPublicAuthority = toUnwrappedModel(esfPublicAuthority);

		boolean isNew = esfPublicAuthority.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfPublicAuthority.isNew()) {
				session.save(esfPublicAuthority);

				esfPublicAuthority.setNew(false);
			}
			else {
				session.merge(esfPublicAuthority);
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

		EntityCacheUtil.putResult(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
			ESFPublicAuthorityImpl.class, esfPublicAuthority.getPrimaryKey(),
			esfPublicAuthority);

		return esfPublicAuthority;
	}

	protected ESFPublicAuthority toUnwrappedModel(
		ESFPublicAuthority esfPublicAuthority) {
		if (esfPublicAuthority instanceof ESFPublicAuthorityImpl) {
			return esfPublicAuthority;
		}

		ESFPublicAuthorityImpl esfPublicAuthorityImpl = new ESFPublicAuthorityImpl();

		esfPublicAuthorityImpl.setNew(esfPublicAuthority.isNew());
		esfPublicAuthorityImpl.setPrimaryKey(esfPublicAuthority.getPrimaryKey());

		esfPublicAuthorityImpl.setEsfPublicAuthorityId(esfPublicAuthority.getEsfPublicAuthorityId());
		esfPublicAuthorityImpl.setCreateDate(esfPublicAuthority.getCreateDate());
		esfPublicAuthorityImpl.setModifiedDate(esfPublicAuthority.getModifiedDate());
		esfPublicAuthorityImpl.setDescription(esfPublicAuthority.getDescription());

		return esfPublicAuthorityImpl;
	}

	/**
	 * Returns the e s f public authority with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f public authority
	 * @return the e s f public authority
	 * @throws it.ethica.esf.NoSuchPublicAuthorityException if a e s f public authority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPublicAuthority findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublicAuthorityException, SystemException {
		ESFPublicAuthority esfPublicAuthority = fetchByPrimaryKey(primaryKey);

		if (esfPublicAuthority == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublicAuthorityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfPublicAuthority;
	}

	/**
	 * Returns the e s f public authority with the primary key or throws a {@link it.ethica.esf.NoSuchPublicAuthorityException} if it could not be found.
	 *
	 * @param esfPublicAuthorityId the primary key of the e s f public authority
	 * @return the e s f public authority
	 * @throws it.ethica.esf.NoSuchPublicAuthorityException if a e s f public authority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPublicAuthority findByPrimaryKey(long esfPublicAuthorityId)
		throws NoSuchPublicAuthorityException, SystemException {
		return findByPrimaryKey((Serializable)esfPublicAuthorityId);
	}

	/**
	 * Returns the e s f public authority with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f public authority
	 * @return the e s f public authority, or <code>null</code> if a e s f public authority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPublicAuthority fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFPublicAuthority esfPublicAuthority = (ESFPublicAuthority)EntityCacheUtil.getResult(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
				ESFPublicAuthorityImpl.class, primaryKey);

		if (esfPublicAuthority == _nullESFPublicAuthority) {
			return null;
		}

		if (esfPublicAuthority == null) {
			Session session = null;

			try {
				session = openSession();

				esfPublicAuthority = (ESFPublicAuthority)session.get(ESFPublicAuthorityImpl.class,
						primaryKey);

				if (esfPublicAuthority != null) {
					cacheResult(esfPublicAuthority);
				}
				else {
					EntityCacheUtil.putResult(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
						ESFPublicAuthorityImpl.class, primaryKey,
						_nullESFPublicAuthority);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFPublicAuthorityModelImpl.ENTITY_CACHE_ENABLED,
					ESFPublicAuthorityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfPublicAuthority;
	}

	/**
	 * Returns the e s f public authority with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfPublicAuthorityId the primary key of the e s f public authority
	 * @return the e s f public authority, or <code>null</code> if a e s f public authority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPublicAuthority fetchByPrimaryKey(long esfPublicAuthorityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfPublicAuthorityId);
	}

	/**
	 * Returns all the e s f public authorities.
	 *
	 * @return the e s f public authorities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPublicAuthority> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f public authorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPublicAuthorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f public authorities
	 * @param end the upper bound of the range of e s f public authorities (not inclusive)
	 * @return the range of e s f public authorities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPublicAuthority> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f public authorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPublicAuthorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f public authorities
	 * @param end the upper bound of the range of e s f public authorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f public authorities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPublicAuthority> findAll(int start, int end,
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

		List<ESFPublicAuthority> list = (List<ESFPublicAuthority>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFPUBLICAUTHORITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFPUBLICAUTHORITY;

				if (pagination) {
					sql = sql.concat(ESFPublicAuthorityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFPublicAuthority>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPublicAuthority>(list);
				}
				else {
					list = (List<ESFPublicAuthority>)QueryUtil.list(q,
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
	 * Removes all the e s f public authorities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFPublicAuthority esfPublicAuthority : findAll()) {
			remove(esfPublicAuthority);
		}
	}

	/**
	 * Returns the number of e s f public authorities.
	 *
	 * @return the number of e s f public authorities
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

				Query q = session.createQuery(_SQL_COUNT_ESFPUBLICAUTHORITY);

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
	 * Initializes the e s f public authority persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFPublicAuthority")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFPublicAuthority>> listenersList = new ArrayList<ModelListener<ESFPublicAuthority>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFPublicAuthority>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFPublicAuthorityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFPUBLICAUTHORITY = "SELECT esfPublicAuthority FROM ESFPublicAuthority esfPublicAuthority";
	private static final String _SQL_COUNT_ESFPUBLICAUTHORITY = "SELECT COUNT(esfPublicAuthority) FROM ESFPublicAuthority esfPublicAuthority";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfPublicAuthority.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFPublicAuthority exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFPublicAuthorityPersistenceImpl.class);
	private static ESFPublicAuthority _nullESFPublicAuthority = new ESFPublicAuthorityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFPublicAuthority> toCacheModel() {
				return _nullESFPublicAuthorityCacheModel;
			}
		};

	private static CacheModel<ESFPublicAuthority> _nullESFPublicAuthorityCacheModel =
		new CacheModel<ESFPublicAuthority>() {
			@Override
			public ESFPublicAuthority toEntityModel() {
				return _nullESFPublicAuthority;
			}
		};
}