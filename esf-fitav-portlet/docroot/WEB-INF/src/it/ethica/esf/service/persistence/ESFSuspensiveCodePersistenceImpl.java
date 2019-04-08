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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchSuspensiveCodeException;
import it.ethica.esf.model.ESFSuspensiveCode;
import it.ethica.esf.model.impl.ESFSuspensiveCodeImpl;
import it.ethica.esf.model.impl.ESFSuspensiveCodeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f suspensive code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveCodePersistence
 * @see ESFSuspensiveCodeUtil
 * @generated
 */
public class ESFSuspensiveCodePersistenceImpl extends BasePersistenceImpl<ESFSuspensiveCode>
	implements ESFSuspensiveCodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFSuspensiveCodeUtil} to access the e s f suspensive code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFSuspensiveCodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveCodeModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveCodeModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFSuspensiveCodePersistenceImpl() {
		setModelClass(ESFSuspensiveCode.class);
	}

	/**
	 * Caches the e s f suspensive code in the entity cache if it is enabled.
	 *
	 * @param esfSuspensiveCode the e s f suspensive code
	 */
	@Override
	public void cacheResult(ESFSuspensiveCode esfSuspensiveCode) {
		EntityCacheUtil.putResult(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveCodeImpl.class, esfSuspensiveCode.getPrimaryKey(),
			esfSuspensiveCode);

		esfSuspensiveCode.resetOriginalValues();
	}

	/**
	 * Caches the e s f suspensive codes in the entity cache if it is enabled.
	 *
	 * @param esfSuspensiveCodes the e s f suspensive codes
	 */
	@Override
	public void cacheResult(List<ESFSuspensiveCode> esfSuspensiveCodes) {
		for (ESFSuspensiveCode esfSuspensiveCode : esfSuspensiveCodes) {
			if (EntityCacheUtil.getResult(
						ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
						ESFSuspensiveCodeImpl.class,
						esfSuspensiveCode.getPrimaryKey()) == null) {
				cacheResult(esfSuspensiveCode);
			}
			else {
				esfSuspensiveCode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f suspensive codes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFSuspensiveCodeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFSuspensiveCodeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f suspensive code.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFSuspensiveCode esfSuspensiveCode) {
		EntityCacheUtil.removeResult(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveCodeImpl.class, esfSuspensiveCode.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFSuspensiveCode> esfSuspensiveCodes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFSuspensiveCode esfSuspensiveCode : esfSuspensiveCodes) {
			EntityCacheUtil.removeResult(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
				ESFSuspensiveCodeImpl.class, esfSuspensiveCode.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f suspensive code with the primary key. Does not add the e s f suspensive code to the database.
	 *
	 * @param esfSuspensiveCodeId the primary key for the new e s f suspensive code
	 * @return the new e s f suspensive code
	 */
	@Override
	public ESFSuspensiveCode create(long esfSuspensiveCodeId) {
		ESFSuspensiveCode esfSuspensiveCode = new ESFSuspensiveCodeImpl();

		esfSuspensiveCode.setNew(true);
		esfSuspensiveCode.setPrimaryKey(esfSuspensiveCodeId);

		return esfSuspensiveCode;
	}

	/**
	 * Removes the e s f suspensive code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfSuspensiveCodeId the primary key of the e s f suspensive code
	 * @return the e s f suspensive code that was removed
	 * @throws it.ethica.esf.NoSuchSuspensiveCodeException if a e s f suspensive code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveCode remove(long esfSuspensiveCodeId)
		throws NoSuchSuspensiveCodeException, SystemException {
		return remove((Serializable)esfSuspensiveCodeId);
	}

	/**
	 * Removes the e s f suspensive code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f suspensive code
	 * @return the e s f suspensive code that was removed
	 * @throws it.ethica.esf.NoSuchSuspensiveCodeException if a e s f suspensive code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveCode remove(Serializable primaryKey)
		throws NoSuchSuspensiveCodeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFSuspensiveCode esfSuspensiveCode = (ESFSuspensiveCode)session.get(ESFSuspensiveCodeImpl.class,
					primaryKey);

			if (esfSuspensiveCode == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSuspensiveCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfSuspensiveCode);
		}
		catch (NoSuchSuspensiveCodeException nsee) {
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
	protected ESFSuspensiveCode removeImpl(ESFSuspensiveCode esfSuspensiveCode)
		throws SystemException {
		esfSuspensiveCode = toUnwrappedModel(esfSuspensiveCode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfSuspensiveCode)) {
				esfSuspensiveCode = (ESFSuspensiveCode)session.get(ESFSuspensiveCodeImpl.class,
						esfSuspensiveCode.getPrimaryKeyObj());
			}

			if (esfSuspensiveCode != null) {
				session.delete(esfSuspensiveCode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfSuspensiveCode != null) {
			clearCache(esfSuspensiveCode);
		}

		return esfSuspensiveCode;
	}

	@Override
	public ESFSuspensiveCode updateImpl(
		it.ethica.esf.model.ESFSuspensiveCode esfSuspensiveCode)
		throws SystemException {
		esfSuspensiveCode = toUnwrappedModel(esfSuspensiveCode);

		boolean isNew = esfSuspensiveCode.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfSuspensiveCode.isNew()) {
				session.save(esfSuspensiveCode);

				esfSuspensiveCode.setNew(false);
			}
			else {
				session.merge(esfSuspensiveCode);
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

		EntityCacheUtil.putResult(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveCodeImpl.class, esfSuspensiveCode.getPrimaryKey(),
			esfSuspensiveCode);

		return esfSuspensiveCode;
	}

	protected ESFSuspensiveCode toUnwrappedModel(
		ESFSuspensiveCode esfSuspensiveCode) {
		if (esfSuspensiveCode instanceof ESFSuspensiveCodeImpl) {
			return esfSuspensiveCode;
		}

		ESFSuspensiveCodeImpl esfSuspensiveCodeImpl = new ESFSuspensiveCodeImpl();

		esfSuspensiveCodeImpl.setNew(esfSuspensiveCode.isNew());
		esfSuspensiveCodeImpl.setPrimaryKey(esfSuspensiveCode.getPrimaryKey());

		esfSuspensiveCodeImpl.setEsfSuspensiveCodeId(esfSuspensiveCode.getEsfSuspensiveCodeId());
		esfSuspensiveCodeImpl.setCode(esfSuspensiveCode.getCode());
		esfSuspensiveCodeImpl.setDescription(esfSuspensiveCode.getDescription());

		return esfSuspensiveCodeImpl;
	}

	/**
	 * Returns the e s f suspensive code with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f suspensive code
	 * @return the e s f suspensive code
	 * @throws it.ethica.esf.NoSuchSuspensiveCodeException if a e s f suspensive code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveCode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSuspensiveCodeException, SystemException {
		ESFSuspensiveCode esfSuspensiveCode = fetchByPrimaryKey(primaryKey);

		if (esfSuspensiveCode == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSuspensiveCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfSuspensiveCode;
	}

	/**
	 * Returns the e s f suspensive code with the primary key or throws a {@link it.ethica.esf.NoSuchSuspensiveCodeException} if it could not be found.
	 *
	 * @param esfSuspensiveCodeId the primary key of the e s f suspensive code
	 * @return the e s f suspensive code
	 * @throws it.ethica.esf.NoSuchSuspensiveCodeException if a e s f suspensive code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveCode findByPrimaryKey(long esfSuspensiveCodeId)
		throws NoSuchSuspensiveCodeException, SystemException {
		return findByPrimaryKey((Serializable)esfSuspensiveCodeId);
	}

	/**
	 * Returns the e s f suspensive code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f suspensive code
	 * @return the e s f suspensive code, or <code>null</code> if a e s f suspensive code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveCode fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFSuspensiveCode esfSuspensiveCode = (ESFSuspensiveCode)EntityCacheUtil.getResult(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
				ESFSuspensiveCodeImpl.class, primaryKey);

		if (esfSuspensiveCode == _nullESFSuspensiveCode) {
			return null;
		}

		if (esfSuspensiveCode == null) {
			Session session = null;

			try {
				session = openSession();

				esfSuspensiveCode = (ESFSuspensiveCode)session.get(ESFSuspensiveCodeImpl.class,
						primaryKey);

				if (esfSuspensiveCode != null) {
					cacheResult(esfSuspensiveCode);
				}
				else {
					EntityCacheUtil.putResult(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
						ESFSuspensiveCodeImpl.class, primaryKey,
						_nullESFSuspensiveCode);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFSuspensiveCodeModelImpl.ENTITY_CACHE_ENABLED,
					ESFSuspensiveCodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfSuspensiveCode;
	}

	/**
	 * Returns the e s f suspensive code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfSuspensiveCodeId the primary key of the e s f suspensive code
	 * @return the e s f suspensive code, or <code>null</code> if a e s f suspensive code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveCode fetchByPrimaryKey(long esfSuspensiveCodeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfSuspensiveCodeId);
	}

	/**
	 * Returns all the e s f suspensive codes.
	 *
	 * @return the e s f suspensive codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveCode> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f suspensive codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f suspensive codes
	 * @param end the upper bound of the range of e s f suspensive codes (not inclusive)
	 * @return the range of e s f suspensive codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveCode> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f suspensive codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f suspensive codes
	 * @param end the upper bound of the range of e s f suspensive codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f suspensive codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveCode> findAll(int start, int end,
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

		List<ESFSuspensiveCode> list = (List<ESFSuspensiveCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSUSPENSIVECODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSUSPENSIVECODE;

				if (pagination) {
					sql = sql.concat(ESFSuspensiveCodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFSuspensiveCode>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSuspensiveCode>(list);
				}
				else {
					list = (List<ESFSuspensiveCode>)QueryUtil.list(q,
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
	 * Removes all the e s f suspensive codes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFSuspensiveCode esfSuspensiveCode : findAll()) {
			remove(esfSuspensiveCode);
		}
	}

	/**
	 * Returns the number of e s f suspensive codes.
	 *
	 * @return the number of e s f suspensive codes
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

				Query q = session.createQuery(_SQL_COUNT_ESFSUSPENSIVECODE);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the e s f suspensive code persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFSuspensiveCode")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFSuspensiveCode>> listenersList = new ArrayList<ModelListener<ESFSuspensiveCode>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFSuspensiveCode>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFSuspensiveCodeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSUSPENSIVECODE = "SELECT esfSuspensiveCode FROM ESFSuspensiveCode esfSuspensiveCode";
	private static final String _SQL_COUNT_ESFSUSPENSIVECODE = "SELECT COUNT(esfSuspensiveCode) FROM ESFSuspensiveCode esfSuspensiveCode";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfSuspensiveCode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFSuspensiveCode exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFSuspensiveCodePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static ESFSuspensiveCode _nullESFSuspensiveCode = new ESFSuspensiveCodeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFSuspensiveCode> toCacheModel() {
				return _nullESFSuspensiveCodeCacheModel;
			}
		};

	private static CacheModel<ESFSuspensiveCode> _nullESFSuspensiveCodeCacheModel =
		new CacheModel<ESFSuspensiveCode>() {
			@Override
			public ESFSuspensiveCode toEntityModel() {
				return _nullESFSuspensiveCode;
			}
		};
}