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

import it.ethica.esf.NoSuchEventTypeException;
import it.ethica.esf.model.ESFEventType;
import it.ethica.esf.model.impl.ESFEventTypeImpl;
import it.ethica.esf.model.impl.ESFEventTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f event type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFEventTypePersistence
 * @see ESFEventTypeUtil
 * @generated
 */
public class ESFEventTypePersistenceImpl extends BasePersistenceImpl<ESFEventType>
	implements ESFEventTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFEventTypeUtil} to access the e s f event type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFEventTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFEventTypeModelImpl.FINDER_CACHE_ENABLED, ESFEventTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFEventTypeModelImpl.FINDER_CACHE_ENABLED, ESFEventTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFEventTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFEventTypePersistenceImpl() {
		setModelClass(ESFEventType.class);
	}

	/**
	 * Caches the e s f event type in the entity cache if it is enabled.
	 *
	 * @param esfEventType the e s f event type
	 */
	@Override
	public void cacheResult(ESFEventType esfEventType) {
		EntityCacheUtil.putResult(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFEventTypeImpl.class, esfEventType.getPrimaryKey(), esfEventType);

		esfEventType.resetOriginalValues();
	}

	/**
	 * Caches the e s f event types in the entity cache if it is enabled.
	 *
	 * @param esfEventTypes the e s f event types
	 */
	@Override
	public void cacheResult(List<ESFEventType> esfEventTypes) {
		for (ESFEventType esfEventType : esfEventTypes) {
			if (EntityCacheUtil.getResult(
						ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFEventTypeImpl.class, esfEventType.getPrimaryKey()) == null) {
				cacheResult(esfEventType);
			}
			else {
				esfEventType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f event types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFEventTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFEventTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f event type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFEventType esfEventType) {
		EntityCacheUtil.removeResult(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFEventTypeImpl.class, esfEventType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFEventType> esfEventTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFEventType esfEventType : esfEventTypes) {
			EntityCacheUtil.removeResult(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFEventTypeImpl.class, esfEventType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f event type with the primary key. Does not add the e s f event type to the database.
	 *
	 * @param esfEventTypeId the primary key for the new e s f event type
	 * @return the new e s f event type
	 */
	@Override
	public ESFEventType create(long esfEventTypeId) {
		ESFEventType esfEventType = new ESFEventTypeImpl();

		esfEventType.setNew(true);
		esfEventType.setPrimaryKey(esfEventTypeId);

		return esfEventType;
	}

	/**
	 * Removes the e s f event type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfEventTypeId the primary key of the e s f event type
	 * @return the e s f event type that was removed
	 * @throws it.ethica.esf.NoSuchEventTypeException if a e s f event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEventType remove(long esfEventTypeId)
		throws NoSuchEventTypeException, SystemException {
		return remove((Serializable)esfEventTypeId);
	}

	/**
	 * Removes the e s f event type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f event type
	 * @return the e s f event type that was removed
	 * @throws it.ethica.esf.NoSuchEventTypeException if a e s f event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEventType remove(Serializable primaryKey)
		throws NoSuchEventTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFEventType esfEventType = (ESFEventType)session.get(ESFEventTypeImpl.class,
					primaryKey);

			if (esfEventType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfEventType);
		}
		catch (NoSuchEventTypeException nsee) {
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
	protected ESFEventType removeImpl(ESFEventType esfEventType)
		throws SystemException {
		esfEventType = toUnwrappedModel(esfEventType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfEventType)) {
				esfEventType = (ESFEventType)session.get(ESFEventTypeImpl.class,
						esfEventType.getPrimaryKeyObj());
			}

			if (esfEventType != null) {
				session.delete(esfEventType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfEventType != null) {
			clearCache(esfEventType);
		}

		return esfEventType;
	}

	@Override
	public ESFEventType updateImpl(
		it.ethica.esf.model.ESFEventType esfEventType)
		throws SystemException {
		esfEventType = toUnwrappedModel(esfEventType);

		boolean isNew = esfEventType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfEventType.isNew()) {
				session.save(esfEventType);

				esfEventType.setNew(false);
			}
			else {
				session.merge(esfEventType);
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

		EntityCacheUtil.putResult(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFEventTypeImpl.class, esfEventType.getPrimaryKey(), esfEventType);

		return esfEventType;
	}

	protected ESFEventType toUnwrappedModel(ESFEventType esfEventType) {
		if (esfEventType instanceof ESFEventTypeImpl) {
			return esfEventType;
		}

		ESFEventTypeImpl esfEventTypeImpl = new ESFEventTypeImpl();

		esfEventTypeImpl.setNew(esfEventType.isNew());
		esfEventTypeImpl.setPrimaryKey(esfEventType.getPrimaryKey());

		esfEventTypeImpl.setEsfEventTypeId(esfEventType.getEsfEventTypeId());
		esfEventTypeImpl.setGroupId(esfEventType.getGroupId());
		esfEventTypeImpl.setCompanyId(esfEventType.getCompanyId());
		esfEventTypeImpl.setUserId(esfEventType.getUserId());
		esfEventTypeImpl.setUserName(esfEventType.getUserName());
		esfEventTypeImpl.setCreateDate(esfEventType.getCreateDate());
		esfEventTypeImpl.setModifiedDate(esfEventType.getModifiedDate());
		esfEventTypeImpl.setMacrocategory(esfEventType.getMacrocategory());
		esfEventTypeImpl.setEventType(esfEventType.getEventType());

		return esfEventTypeImpl;
	}

	/**
	 * Returns the e s f event type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f event type
	 * @return the e s f event type
	 * @throws it.ethica.esf.NoSuchEventTypeException if a e s f event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEventType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventTypeException, SystemException {
		ESFEventType esfEventType = fetchByPrimaryKey(primaryKey);

		if (esfEventType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfEventType;
	}

	/**
	 * Returns the e s f event type with the primary key or throws a {@link it.ethica.esf.NoSuchEventTypeException} if it could not be found.
	 *
	 * @param esfEventTypeId the primary key of the e s f event type
	 * @return the e s f event type
	 * @throws it.ethica.esf.NoSuchEventTypeException if a e s f event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEventType findByPrimaryKey(long esfEventTypeId)
		throws NoSuchEventTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfEventTypeId);
	}

	/**
	 * Returns the e s f event type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f event type
	 * @return the e s f event type, or <code>null</code> if a e s f event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEventType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFEventType esfEventType = (ESFEventType)EntityCacheUtil.getResult(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFEventTypeImpl.class, primaryKey);

		if (esfEventType == _nullESFEventType) {
			return null;
		}

		if (esfEventType == null) {
			Session session = null;

			try {
				session = openSession();

				esfEventType = (ESFEventType)session.get(ESFEventTypeImpl.class,
						primaryKey);

				if (esfEventType != null) {
					cacheResult(esfEventType);
				}
				else {
					EntityCacheUtil.putResult(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFEventTypeImpl.class, primaryKey, _nullESFEventType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFEventTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFEventTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfEventType;
	}

	/**
	 * Returns the e s f event type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfEventTypeId the primary key of the e s f event type
	 * @return the e s f event type, or <code>null</code> if a e s f event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEventType fetchByPrimaryKey(long esfEventTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfEventTypeId);
	}

	/**
	 * Returns all the e s f event types.
	 *
	 * @return the e s f event types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEventType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f event types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f event types
	 * @param end the upper bound of the range of e s f event types (not inclusive)
	 * @return the range of e s f event types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEventType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f event types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f event types
	 * @param end the upper bound of the range of e s f event types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f event types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEventType> findAll(int start, int end,
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

		List<ESFEventType> list = (List<ESFEventType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFEVENTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFEVENTTYPE;

				if (pagination) {
					sql = sql.concat(ESFEventTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFEventType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFEventType>(list);
				}
				else {
					list = (List<ESFEventType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f event types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFEventType esfEventType : findAll()) {
			remove(esfEventType);
		}
	}

	/**
	 * Returns the number of e s f event types.
	 *
	 * @return the number of e s f event types
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

				Query q = session.createQuery(_SQL_COUNT_ESFEVENTTYPE);

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
	 * Initializes the e s f event type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFEventType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFEventType>> listenersList = new ArrayList<ModelListener<ESFEventType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFEventType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFEventTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFEVENTTYPE = "SELECT esfEventType FROM ESFEventType esfEventType";
	private static final String _SQL_COUNT_ESFEVENTTYPE = "SELECT COUNT(esfEventType) FROM ESFEventType esfEventType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfEventType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFEventType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFEventTypePersistenceImpl.class);
	private static ESFEventType _nullESFEventType = new ESFEventTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFEventType> toCacheModel() {
				return _nullESFEventTypeCacheModel;
			}
		};

	private static CacheModel<ESFEventType> _nullESFEventTypeCacheModel = new CacheModel<ESFEventType>() {
			@Override
			public ESFEventType toEntityModel() {
				return _nullESFEventType;
			}
		};
}