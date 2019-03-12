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

import it.ethica.esf.NoSuchDocumentTypeException;
import it.ethica.esf.model.ESFDocumentType;
import it.ethica.esf.model.impl.ESFDocumentTypeImpl;
import it.ethica.esf.model.impl.ESFDocumentTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f document type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentTypePersistence
 * @see ESFDocumentTypeUtil
 * @generated
 */
public class ESFDocumentTypePersistenceImpl extends BasePersistenceImpl<ESFDocumentType>
	implements ESFDocumentTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFDocumentTypeUtil} to access the e s f document type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFDocumentTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFDocumentTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFDocumentTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFDocumentTypePersistenceImpl() {
		setModelClass(ESFDocumentType.class);
	}

	/**
	 * Caches the e s f document type in the entity cache if it is enabled.
	 *
	 * @param esfDocumentType the e s f document type
	 */
	@Override
	public void cacheResult(ESFDocumentType esfDocumentType) {
		EntityCacheUtil.putResult(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentTypeImpl.class, esfDocumentType.getPrimaryKey(),
			esfDocumentType);

		esfDocumentType.resetOriginalValues();
	}

	/**
	 * Caches the e s f document types in the entity cache if it is enabled.
	 *
	 * @param esfDocumentTypes the e s f document types
	 */
	@Override
	public void cacheResult(List<ESFDocumentType> esfDocumentTypes) {
		for (ESFDocumentType esfDocumentType : esfDocumentTypes) {
			if (EntityCacheUtil.getResult(
						ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFDocumentTypeImpl.class,
						esfDocumentType.getPrimaryKey()) == null) {
				cacheResult(esfDocumentType);
			}
			else {
				esfDocumentType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f document types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFDocumentTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFDocumentTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f document type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFDocumentType esfDocumentType) {
		EntityCacheUtil.removeResult(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentTypeImpl.class, esfDocumentType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFDocumentType> esfDocumentTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFDocumentType esfDocumentType : esfDocumentTypes) {
			EntityCacheUtil.removeResult(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFDocumentTypeImpl.class, esfDocumentType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f document type with the primary key. Does not add the e s f document type to the database.
	 *
	 * @param esfDocumentTypeId the primary key for the new e s f document type
	 * @return the new e s f document type
	 */
	@Override
	public ESFDocumentType create(long esfDocumentTypeId) {
		ESFDocumentType esfDocumentType = new ESFDocumentTypeImpl();

		esfDocumentType.setNew(true);
		esfDocumentType.setPrimaryKey(esfDocumentTypeId);

		return esfDocumentType;
	}

	/**
	 * Removes the e s f document type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfDocumentTypeId the primary key of the e s f document type
	 * @return the e s f document type that was removed
	 * @throws it.ethica.esf.NoSuchDocumentTypeException if a e s f document type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocumentType remove(long esfDocumentTypeId)
		throws NoSuchDocumentTypeException, SystemException {
		return remove((Serializable)esfDocumentTypeId);
	}

	/**
	 * Removes the e s f document type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f document type
	 * @return the e s f document type that was removed
	 * @throws it.ethica.esf.NoSuchDocumentTypeException if a e s f document type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocumentType remove(Serializable primaryKey)
		throws NoSuchDocumentTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFDocumentType esfDocumentType = (ESFDocumentType)session.get(ESFDocumentTypeImpl.class,
					primaryKey);

			if (esfDocumentType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfDocumentType);
		}
		catch (NoSuchDocumentTypeException nsee) {
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
	protected ESFDocumentType removeImpl(ESFDocumentType esfDocumentType)
		throws SystemException {
		esfDocumentType = toUnwrappedModel(esfDocumentType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfDocumentType)) {
				esfDocumentType = (ESFDocumentType)session.get(ESFDocumentTypeImpl.class,
						esfDocumentType.getPrimaryKeyObj());
			}

			if (esfDocumentType != null) {
				session.delete(esfDocumentType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfDocumentType != null) {
			clearCache(esfDocumentType);
		}

		return esfDocumentType;
	}

	@Override
	public ESFDocumentType updateImpl(
		it.ethica.esf.model.ESFDocumentType esfDocumentType)
		throws SystemException {
		esfDocumentType = toUnwrappedModel(esfDocumentType);

		boolean isNew = esfDocumentType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfDocumentType.isNew()) {
				session.save(esfDocumentType);

				esfDocumentType.setNew(false);
			}
			else {
				session.merge(esfDocumentType);
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

		EntityCacheUtil.putResult(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentTypeImpl.class, esfDocumentType.getPrimaryKey(),
			esfDocumentType);

		return esfDocumentType;
	}

	protected ESFDocumentType toUnwrappedModel(ESFDocumentType esfDocumentType) {
		if (esfDocumentType instanceof ESFDocumentTypeImpl) {
			return esfDocumentType;
		}

		ESFDocumentTypeImpl esfDocumentTypeImpl = new ESFDocumentTypeImpl();

		esfDocumentTypeImpl.setNew(esfDocumentType.isNew());
		esfDocumentTypeImpl.setPrimaryKey(esfDocumentType.getPrimaryKey());

		esfDocumentTypeImpl.setEsfDocumentTypeId(esfDocumentType.getEsfDocumentTypeId());
		esfDocumentTypeImpl.setGroupId(esfDocumentType.getGroupId());
		esfDocumentTypeImpl.setCompanyId(esfDocumentType.getCompanyId());
		esfDocumentTypeImpl.setUserId(esfDocumentType.getUserId());
		esfDocumentTypeImpl.setUserName(esfDocumentType.getUserName());
		esfDocumentTypeImpl.setCreateDate(esfDocumentType.getCreateDate());
		esfDocumentTypeImpl.setModifiedDate(esfDocumentType.getModifiedDate());
		esfDocumentTypeImpl.setEsfDocumentId(esfDocumentType.getEsfDocumentId());
		esfDocumentTypeImpl.setEsfTypeId(esfDocumentType.getEsfTypeId());

		return esfDocumentTypeImpl;
	}

	/**
	 * Returns the e s f document type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f document type
	 * @return the e s f document type
	 * @throws it.ethica.esf.NoSuchDocumentTypeException if a e s f document type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocumentType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentTypeException, SystemException {
		ESFDocumentType esfDocumentType = fetchByPrimaryKey(primaryKey);

		if (esfDocumentType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfDocumentType;
	}

	/**
	 * Returns the e s f document type with the primary key or throws a {@link it.ethica.esf.NoSuchDocumentTypeException} if it could not be found.
	 *
	 * @param esfDocumentTypeId the primary key of the e s f document type
	 * @return the e s f document type
	 * @throws it.ethica.esf.NoSuchDocumentTypeException if a e s f document type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocumentType findByPrimaryKey(long esfDocumentTypeId)
		throws NoSuchDocumentTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfDocumentTypeId);
	}

	/**
	 * Returns the e s f document type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f document type
	 * @return the e s f document type, or <code>null</code> if a e s f document type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocumentType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFDocumentType esfDocumentType = (ESFDocumentType)EntityCacheUtil.getResult(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFDocumentTypeImpl.class, primaryKey);

		if (esfDocumentType == _nullESFDocumentType) {
			return null;
		}

		if (esfDocumentType == null) {
			Session session = null;

			try {
				session = openSession();

				esfDocumentType = (ESFDocumentType)session.get(ESFDocumentTypeImpl.class,
						primaryKey);

				if (esfDocumentType != null) {
					cacheResult(esfDocumentType);
				}
				else {
					EntityCacheUtil.putResult(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFDocumentTypeImpl.class, primaryKey,
						_nullESFDocumentType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFDocumentTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFDocumentTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfDocumentType;
	}

	/**
	 * Returns the e s f document type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfDocumentTypeId the primary key of the e s f document type
	 * @return the e s f document type, or <code>null</code> if a e s f document type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocumentType fetchByPrimaryKey(long esfDocumentTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfDocumentTypeId);
	}

	/**
	 * Returns all the e s f document types.
	 *
	 * @return the e s f document types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocumentType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f document types
	 * @param end the upper bound of the range of e s f document types (not inclusive)
	 * @return the range of e s f document types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocumentType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f document types
	 * @param end the upper bound of the range of e s f document types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f document types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocumentType> findAll(int start, int end,
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

		List<ESFDocumentType> list = (List<ESFDocumentType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFDOCUMENTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFDOCUMENTTYPE;

				if (pagination) {
					sql = sql.concat(ESFDocumentTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFDocumentType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocumentType>(list);
				}
				else {
					list = (List<ESFDocumentType>)QueryUtil.list(q,
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
	 * Removes all the e s f document types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFDocumentType esfDocumentType : findAll()) {
			remove(esfDocumentType);
		}
	}

	/**
	 * Returns the number of e s f document types.
	 *
	 * @return the number of e s f document types
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

				Query q = session.createQuery(_SQL_COUNT_ESFDOCUMENTTYPE);

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
	 * Initializes the e s f document type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFDocumentType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFDocumentType>> listenersList = new ArrayList<ModelListener<ESFDocumentType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFDocumentType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFDocumentTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFDOCUMENTTYPE = "SELECT esfDocumentType FROM ESFDocumentType esfDocumentType";
	private static final String _SQL_COUNT_ESFDOCUMENTTYPE = "SELECT COUNT(esfDocumentType) FROM ESFDocumentType esfDocumentType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfDocumentType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFDocumentType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFDocumentTypePersistenceImpl.class);
	private static ESFDocumentType _nullESFDocumentType = new ESFDocumentTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFDocumentType> toCacheModel() {
				return _nullESFDocumentTypeCacheModel;
			}
		};

	private static CacheModel<ESFDocumentType> _nullESFDocumentTypeCacheModel = new CacheModel<ESFDocumentType>() {
			@Override
			public ESFDocumentType toEntityModel() {
				return _nullESFDocumentType;
			}
		};
}