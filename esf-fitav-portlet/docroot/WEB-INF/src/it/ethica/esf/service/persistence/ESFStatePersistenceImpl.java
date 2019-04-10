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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchStateException;
import it.ethica.esf.model.ESFState;
import it.ethica.esf.model.impl.ESFStateImpl;
import it.ethica.esf.model.impl.ESFStateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFStatePersistence
 * @see ESFStateUtil
 * @generated
 */
public class ESFStatePersistenceImpl extends BasePersistenceImpl<ESFState>
	implements ESFStatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFStateUtil} to access the e s f state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFStateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateModelImpl.FINDER_CACHE_ENABLED, ESFStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateModelImpl.FINDER_CACHE_ENABLED, ESFStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateModelImpl.FINDER_CACHE_ENABLED, ESFStateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			ESFStateModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f state where name = &#63; or throws a {@link it.ethica.esf.NoSuchStateException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching e s f state
	 * @throws it.ethica.esf.NoSuchStateException if a matching e s f state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState findByName(String name)
		throws NoSuchStateException, SystemException {
		ESFState esfState = fetchByName(name);

		if (esfState == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStateException(msg.toString());
		}

		return esfState;
	}

	/**
	 * Returns the e s f state where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching e s f state, or <code>null</code> if a matching e s f state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the e s f state where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f state, or <code>null</code> if a matching e s f state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof ESFState) {
			ESFState esfState = (ESFState)result;

			if (!Validator.equals(name, esfState.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFSTATE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<ESFState> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFStatePersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFState esfState = list.get(0);

					result = esfState;

					cacheResult(esfState);

					if ((esfState.getName() == null) ||
							!esfState.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, esfState);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ESFState)result;
		}
	}

	/**
	 * Removes the e s f state where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the e s f state that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState removeByName(String name)
		throws NoSuchStateException, SystemException {
		ESFState esfState = findByName(name);

		return remove(esfState);
	}

	/**
	 * Returns the number of e s f states where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSTATE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfState.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfState.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfState.name IS NULL OR esfState.name = '')";

	public ESFStatePersistenceImpl() {
		setModelClass(ESFState.class);
	}

	/**
	 * Caches the e s f state in the entity cache if it is enabled.
	 *
	 * @param esfState the e s f state
	 */
	@Override
	public void cacheResult(ESFState esfState) {
		EntityCacheUtil.putResult(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateImpl.class, esfState.getPrimaryKey(), esfState);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { esfState.getName() }, esfState);

		esfState.resetOriginalValues();
	}

	/**
	 * Caches the e s f states in the entity cache if it is enabled.
	 *
	 * @param esfStates the e s f states
	 */
	@Override
	public void cacheResult(List<ESFState> esfStates) {
		for (ESFState esfState : esfStates) {
			if (EntityCacheUtil.getResult(
						ESFStateModelImpl.ENTITY_CACHE_ENABLED,
						ESFStateImpl.class, esfState.getPrimaryKey()) == null) {
				cacheResult(esfState);
			}
			else {
				esfState.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f states.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFStateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFStateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f state.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFState esfState) {
		EntityCacheUtil.removeResult(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateImpl.class, esfState.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfState);
	}

	@Override
	public void clearCache(List<ESFState> esfStates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFState esfState : esfStates) {
			EntityCacheUtil.removeResult(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
				ESFStateImpl.class, esfState.getPrimaryKey());

			clearUniqueFindersCache(esfState);
		}
	}

	protected void cacheUniqueFindersCache(ESFState esfState) {
		if (esfState.isNew()) {
			Object[] args = new Object[] { esfState.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, esfState);
		}
		else {
			ESFStateModelImpl esfStateModelImpl = (ESFStateModelImpl)esfState;

			if ((esfStateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfState.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					esfState);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFState esfState) {
		ESFStateModelImpl esfStateModelImpl = (ESFStateModelImpl)esfState;

		Object[] args = new Object[] { esfState.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((esfStateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { esfStateModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new e s f state with the primary key. Does not add the e s f state to the database.
	 *
	 * @param esfStateId the primary key for the new e s f state
	 * @return the new e s f state
	 */
	@Override
	public ESFState create(long esfStateId) {
		ESFState esfState = new ESFStateImpl();

		esfState.setNew(true);
		esfState.setPrimaryKey(esfStateId);

		return esfState;
	}

	/**
	 * Removes the e s f state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfStateId the primary key of the e s f state
	 * @return the e s f state that was removed
	 * @throws it.ethica.esf.NoSuchStateException if a e s f state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState remove(long esfStateId)
		throws NoSuchStateException, SystemException {
		return remove((Serializable)esfStateId);
	}

	/**
	 * Removes the e s f state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f state
	 * @return the e s f state that was removed
	 * @throws it.ethica.esf.NoSuchStateException if a e s f state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState remove(Serializable primaryKey)
		throws NoSuchStateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFState esfState = (ESFState)session.get(ESFStateImpl.class,
					primaryKey);

			if (esfState == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfState);
		}
		catch (NoSuchStateException nsee) {
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
	protected ESFState removeImpl(ESFState esfState) throws SystemException {
		esfState = toUnwrappedModel(esfState);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfState)) {
				esfState = (ESFState)session.get(ESFStateImpl.class,
						esfState.getPrimaryKeyObj());
			}

			if (esfState != null) {
				session.delete(esfState);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfState != null) {
			clearCache(esfState);
		}

		return esfState;
	}

	@Override
	public ESFState updateImpl(it.ethica.esf.model.ESFState esfState)
		throws SystemException {
		esfState = toUnwrappedModel(esfState);

		boolean isNew = esfState.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfState.isNew()) {
				session.save(esfState);

				esfState.setNew(false);
			}
			else {
				session.merge(esfState);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFStateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateImpl.class, esfState.getPrimaryKey(), esfState);

		clearUniqueFindersCache(esfState);
		cacheUniqueFindersCache(esfState);

		return esfState;
	}

	protected ESFState toUnwrappedModel(ESFState esfState) {
		if (esfState instanceof ESFStateImpl) {
			return esfState;
		}

		ESFStateImpl esfStateImpl = new ESFStateImpl();

		esfStateImpl.setNew(esfState.isNew());
		esfStateImpl.setPrimaryKey(esfState.getPrimaryKey());

		esfStateImpl.setEsfStateId(esfState.getEsfStateId());
		esfStateImpl.setName(esfState.getName());
		esfStateImpl.setDescription(esfState.getDescription());

		return esfStateImpl;
	}

	/**
	 * Returns the e s f state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f state
	 * @return the e s f state
	 * @throws it.ethica.esf.NoSuchStateException if a e s f state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStateException, SystemException {
		ESFState esfState = fetchByPrimaryKey(primaryKey);

		if (esfState == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfState;
	}

	/**
	 * Returns the e s f state with the primary key or throws a {@link it.ethica.esf.NoSuchStateException} if it could not be found.
	 *
	 * @param esfStateId the primary key of the e s f state
	 * @return the e s f state
	 * @throws it.ethica.esf.NoSuchStateException if a e s f state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState findByPrimaryKey(long esfStateId)
		throws NoSuchStateException, SystemException {
		return findByPrimaryKey((Serializable)esfStateId);
	}

	/**
	 * Returns the e s f state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f state
	 * @return the e s f state, or <code>null</code> if a e s f state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFState esfState = (ESFState)EntityCacheUtil.getResult(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
				ESFStateImpl.class, primaryKey);

		if (esfState == _nullESFState) {
			return null;
		}

		if (esfState == null) {
			Session session = null;

			try {
				session = openSession();

				esfState = (ESFState)session.get(ESFStateImpl.class, primaryKey);

				if (esfState != null) {
					cacheResult(esfState);
				}
				else {
					EntityCacheUtil.putResult(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
						ESFStateImpl.class, primaryKey, _nullESFState);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFStateModelImpl.ENTITY_CACHE_ENABLED,
					ESFStateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfState;
	}

	/**
	 * Returns the e s f state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfStateId the primary key of the e s f state
	 * @return the e s f state, or <code>null</code> if a e s f state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFState fetchByPrimaryKey(long esfStateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfStateId);
	}

	/**
	 * Returns all the e s f states.
	 *
	 * @return the e s f states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFState> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f states
	 * @param end the upper bound of the range of e s f states (not inclusive)
	 * @return the range of e s f states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFState> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f states
	 * @param end the upper bound of the range of e s f states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFState> findAll(int start, int end,
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

		List<ESFState> list = (List<ESFState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSTATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSTATE;

				if (pagination) {
					sql = sql.concat(ESFStateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFState>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFState>(list);
				}
				else {
					list = (List<ESFState>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f states from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFState esfState : findAll()) {
			remove(esfState);
		}
	}

	/**
	 * Returns the number of e s f states.
	 *
	 * @return the number of e s f states
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

				Query q = session.createQuery(_SQL_COUNT_ESFSTATE);

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
	 * Initializes the e s f state persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFState")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFState>> listenersList = new ArrayList<ModelListener<ESFState>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFState>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFStateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSTATE = "SELECT esfState FROM ESFState esfState";
	private static final String _SQL_SELECT_ESFSTATE_WHERE = "SELECT esfState FROM ESFState esfState WHERE ";
	private static final String _SQL_COUNT_ESFSTATE = "SELECT COUNT(esfState) FROM ESFState esfState";
	private static final String _SQL_COUNT_ESFSTATE_WHERE = "SELECT COUNT(esfState) FROM ESFState esfState WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfState.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFState exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFState exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFStatePersistenceImpl.class);
	private static ESFState _nullESFState = new ESFStateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFState> toCacheModel() {
				return _nullESFStateCacheModel;
			}
		};

	private static CacheModel<ESFState> _nullESFStateCacheModel = new CacheModel<ESFState>() {
			@Override
			public ESFState toEntityModel() {
				return _nullESFState;
			}
		};
}