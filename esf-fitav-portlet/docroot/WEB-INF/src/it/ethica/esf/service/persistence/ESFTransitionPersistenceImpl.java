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

import it.ethica.esf.NoSuchTransitionException;
import it.ethica.esf.model.ESFTransition;
import it.ethica.esf.model.impl.ESFTransitionImpl;
import it.ethica.esf.model.impl.ESFTransitionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f transition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFTransitionPersistence
 * @see ESFTransitionUtil
 * @generated
 */
public class ESFTransitionPersistenceImpl extends BasePersistenceImpl<ESFTransition>
	implements ESFTransitionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFTransitionUtil} to access the e s f transition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFTransitionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
			ESFTransitionModelImpl.FINDER_CACHE_ENABLED,
			ESFTransitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
			ESFTransitionModelImpl.FINDER_CACHE_ENABLED,
			ESFTransitionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
			ESFTransitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFTransitionPersistenceImpl() {
		setModelClass(ESFTransition.class);
	}

	/**
	 * Caches the e s f transition in the entity cache if it is enabled.
	 *
	 * @param esfTransition the e s f transition
	 */
	@Override
	public void cacheResult(ESFTransition esfTransition) {
		EntityCacheUtil.putResult(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
			ESFTransitionImpl.class, esfTransition.getPrimaryKey(),
			esfTransition);

		esfTransition.resetOriginalValues();
	}

	/**
	 * Caches the e s f transitions in the entity cache if it is enabled.
	 *
	 * @param esfTransitions the e s f transitions
	 */
	@Override
	public void cacheResult(List<ESFTransition> esfTransitions) {
		for (ESFTransition esfTransition : esfTransitions) {
			if (EntityCacheUtil.getResult(
						ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
						ESFTransitionImpl.class, esfTransition.getPrimaryKey()) == null) {
				cacheResult(esfTransition);
			}
			else {
				esfTransition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f transitions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFTransitionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFTransitionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f transition.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFTransition esfTransition) {
		EntityCacheUtil.removeResult(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
			ESFTransitionImpl.class, esfTransition.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFTransition> esfTransitions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFTransition esfTransition : esfTransitions) {
			EntityCacheUtil.removeResult(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
				ESFTransitionImpl.class, esfTransition.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f transition with the primary key. Does not add the e s f transition to the database.
	 *
	 * @param esfTransitionId the primary key for the new e s f transition
	 * @return the new e s f transition
	 */
	@Override
	public ESFTransition create(long esfTransitionId) {
		ESFTransition esfTransition = new ESFTransitionImpl();

		esfTransition.setNew(true);
		esfTransition.setPrimaryKey(esfTransitionId);

		return esfTransition;
	}

	/**
	 * Removes the e s f transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfTransitionId the primary key of the e s f transition
	 * @return the e s f transition that was removed
	 * @throws it.ethica.esf.NoSuchTransitionException if a e s f transition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTransition remove(long esfTransitionId)
		throws NoSuchTransitionException, SystemException {
		return remove((Serializable)esfTransitionId);
	}

	/**
	 * Removes the e s f transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f transition
	 * @return the e s f transition that was removed
	 * @throws it.ethica.esf.NoSuchTransitionException if a e s f transition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTransition remove(Serializable primaryKey)
		throws NoSuchTransitionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFTransition esfTransition = (ESFTransition)session.get(ESFTransitionImpl.class,
					primaryKey);

			if (esfTransition == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfTransition);
		}
		catch (NoSuchTransitionException nsee) {
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
	protected ESFTransition removeImpl(ESFTransition esfTransition)
		throws SystemException {
		esfTransition = toUnwrappedModel(esfTransition);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfTransition)) {
				esfTransition = (ESFTransition)session.get(ESFTransitionImpl.class,
						esfTransition.getPrimaryKeyObj());
			}

			if (esfTransition != null) {
				session.delete(esfTransition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfTransition != null) {
			clearCache(esfTransition);
		}

		return esfTransition;
	}

	@Override
	public ESFTransition updateImpl(
		it.ethica.esf.model.ESFTransition esfTransition)
		throws SystemException {
		esfTransition = toUnwrappedModel(esfTransition);

		boolean isNew = esfTransition.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfTransition.isNew()) {
				session.save(esfTransition);

				esfTransition.setNew(false);
			}
			else {
				session.merge(esfTransition);
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

		EntityCacheUtil.putResult(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
			ESFTransitionImpl.class, esfTransition.getPrimaryKey(),
			esfTransition);

		return esfTransition;
	}

	protected ESFTransition toUnwrappedModel(ESFTransition esfTransition) {
		if (esfTransition instanceof ESFTransitionImpl) {
			return esfTransition;
		}

		ESFTransitionImpl esfTransitionImpl = new ESFTransitionImpl();

		esfTransitionImpl.setNew(esfTransition.isNew());
		esfTransitionImpl.setPrimaryKey(esfTransition.getPrimaryKey());

		esfTransitionImpl.setEsfTransitionId(esfTransition.getEsfTransitionId());
		esfTransitionImpl.setEsfUserId(esfTransition.getEsfUserId());
		esfTransitionImpl.setEsfCategoryId(esfTransition.getEsfCategoryId());
		esfTransitionImpl.setSeason(esfTransition.getSeason());

		return esfTransitionImpl;
	}

	/**
	 * Returns the e s f transition with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f transition
	 * @return the e s f transition
	 * @throws it.ethica.esf.NoSuchTransitionException if a e s f transition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTransition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTransitionException, SystemException {
		ESFTransition esfTransition = fetchByPrimaryKey(primaryKey);

		if (esfTransition == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTransitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfTransition;
	}

	/**
	 * Returns the e s f transition with the primary key or throws a {@link it.ethica.esf.NoSuchTransitionException} if it could not be found.
	 *
	 * @param esfTransitionId the primary key of the e s f transition
	 * @return the e s f transition
	 * @throws it.ethica.esf.NoSuchTransitionException if a e s f transition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTransition findByPrimaryKey(long esfTransitionId)
		throws NoSuchTransitionException, SystemException {
		return findByPrimaryKey((Serializable)esfTransitionId);
	}

	/**
	 * Returns the e s f transition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f transition
	 * @return the e s f transition, or <code>null</code> if a e s f transition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTransition fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFTransition esfTransition = (ESFTransition)EntityCacheUtil.getResult(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
				ESFTransitionImpl.class, primaryKey);

		if (esfTransition == _nullESFTransition) {
			return null;
		}

		if (esfTransition == null) {
			Session session = null;

			try {
				session = openSession();

				esfTransition = (ESFTransition)session.get(ESFTransitionImpl.class,
						primaryKey);

				if (esfTransition != null) {
					cacheResult(esfTransition);
				}
				else {
					EntityCacheUtil.putResult(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
						ESFTransitionImpl.class, primaryKey, _nullESFTransition);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFTransitionModelImpl.ENTITY_CACHE_ENABLED,
					ESFTransitionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfTransition;
	}

	/**
	 * Returns the e s f transition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfTransitionId the primary key of the e s f transition
	 * @return the e s f transition, or <code>null</code> if a e s f transition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTransition fetchByPrimaryKey(long esfTransitionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfTransitionId);
	}

	/**
	 * Returns all the e s f transitions.
	 *
	 * @return the e s f transitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTransition> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f transitions
	 * @param end the upper bound of the range of e s f transitions (not inclusive)
	 * @return the range of e s f transitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTransition> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f transitions
	 * @param end the upper bound of the range of e s f transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f transitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTransition> findAll(int start, int end,
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

		List<ESFTransition> list = (List<ESFTransition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFTRANSITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFTRANSITION;

				if (pagination) {
					sql = sql.concat(ESFTransitionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFTransition>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTransition>(list);
				}
				else {
					list = (List<ESFTransition>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f transitions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFTransition esfTransition : findAll()) {
			remove(esfTransition);
		}
	}

	/**
	 * Returns the number of e s f transitions.
	 *
	 * @return the number of e s f transitions
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

				Query q = session.createQuery(_SQL_COUNT_ESFTRANSITION);

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
	 * Initializes the e s f transition persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFTransition")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFTransition>> listenersList = new ArrayList<ModelListener<ESFTransition>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFTransition>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFTransitionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFTRANSITION = "SELECT esfTransition FROM ESFTransition esfTransition";
	private static final String _SQL_COUNT_ESFTRANSITION = "SELECT COUNT(esfTransition) FROM ESFTransition esfTransition";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfTransition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFTransition exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFTransitionPersistenceImpl.class);
	private static ESFTransition _nullESFTransition = new ESFTransitionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFTransition> toCacheModel() {
				return _nullESFTransitionCacheModel;
			}
		};

	private static CacheModel<ESFTransition> _nullESFTransitionCacheModel = new CacheModel<ESFTransition>() {
			@Override
			public ESFTransition toEntityModel() {
				return _nullESFTransition;
			}
		};
}