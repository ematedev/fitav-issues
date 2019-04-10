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

import it.ethica.esf.NoSuchFornitureUserException;
import it.ethica.esf.model.ESFFornitureUser;
import it.ethica.esf.model.impl.ESFFornitureUserImpl;
import it.ethica.esf.model.impl.ESFFornitureUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f forniture user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureUserPersistence
 * @see ESFFornitureUserUtil
 * @generated
 */
public class ESFFornitureUserPersistenceImpl extends BasePersistenceImpl<ESFFornitureUser>
	implements ESFFornitureUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFornitureUserUtil} to access the e s f forniture user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFornitureUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureUserModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureUserModelImpl.FINDER_CACHE_ENABLED,
			ESFFornitureUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFFornitureUserPersistenceImpl() {
		setModelClass(ESFFornitureUser.class);
	}

	/**
	 * Caches the e s f forniture user in the entity cache if it is enabled.
	 *
	 * @param esfFornitureUser the e s f forniture user
	 */
	@Override
	public void cacheResult(ESFFornitureUser esfFornitureUser) {
		EntityCacheUtil.putResult(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureUserImpl.class, esfFornitureUser.getPrimaryKey(),
			esfFornitureUser);

		esfFornitureUser.resetOriginalValues();
	}

	/**
	 * Caches the e s f forniture users in the entity cache if it is enabled.
	 *
	 * @param esfFornitureUsers the e s f forniture users
	 */
	@Override
	public void cacheResult(List<ESFFornitureUser> esfFornitureUsers) {
		for (ESFFornitureUser esfFornitureUser : esfFornitureUsers) {
			if (EntityCacheUtil.getResult(
						ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFFornitureUserImpl.class,
						esfFornitureUser.getPrimaryKey()) == null) {
				cacheResult(esfFornitureUser);
			}
			else {
				esfFornitureUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f forniture users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFornitureUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFornitureUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f forniture user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFFornitureUser esfFornitureUser) {
		EntityCacheUtil.removeResult(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureUserImpl.class, esfFornitureUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFFornitureUser> esfFornitureUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFFornitureUser esfFornitureUser : esfFornitureUsers) {
			EntityCacheUtil.removeResult(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFFornitureUserImpl.class, esfFornitureUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f forniture user with the primary key. Does not add the e s f forniture user to the database.
	 *
	 * @param esfFornitureUserID the primary key for the new e s f forniture user
	 * @return the new e s f forniture user
	 */
	@Override
	public ESFFornitureUser create(long esfFornitureUserID) {
		ESFFornitureUser esfFornitureUser = new ESFFornitureUserImpl();

		esfFornitureUser.setNew(true);
		esfFornitureUser.setPrimaryKey(esfFornitureUserID);

		return esfFornitureUser;
	}

	/**
	 * Removes the e s f forniture user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFornitureUserID the primary key of the e s f forniture user
	 * @return the e s f forniture user that was removed
	 * @throws it.ethica.esf.NoSuchFornitureUserException if a e s f forniture user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureUser remove(long esfFornitureUserID)
		throws NoSuchFornitureUserException, SystemException {
		return remove((Serializable)esfFornitureUserID);
	}

	/**
	 * Removes the e s f forniture user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f forniture user
	 * @return the e s f forniture user that was removed
	 * @throws it.ethica.esf.NoSuchFornitureUserException if a e s f forniture user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureUser remove(Serializable primaryKey)
		throws NoSuchFornitureUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFFornitureUser esfFornitureUser = (ESFFornitureUser)session.get(ESFFornitureUserImpl.class,
					primaryKey);

			if (esfFornitureUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFornitureUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfFornitureUser);
		}
		catch (NoSuchFornitureUserException nsee) {
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
	protected ESFFornitureUser removeImpl(ESFFornitureUser esfFornitureUser)
		throws SystemException {
		esfFornitureUser = toUnwrappedModel(esfFornitureUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfFornitureUser)) {
				esfFornitureUser = (ESFFornitureUser)session.get(ESFFornitureUserImpl.class,
						esfFornitureUser.getPrimaryKeyObj());
			}

			if (esfFornitureUser != null) {
				session.delete(esfFornitureUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfFornitureUser != null) {
			clearCache(esfFornitureUser);
		}

		return esfFornitureUser;
	}

	@Override
	public ESFFornitureUser updateImpl(
		it.ethica.esf.model.ESFFornitureUser esfFornitureUser)
		throws SystemException {
		esfFornitureUser = toUnwrappedModel(esfFornitureUser);

		boolean isNew = esfFornitureUser.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfFornitureUser.isNew()) {
				session.save(esfFornitureUser);

				esfFornitureUser.setNew(false);
			}
			else {
				session.merge(esfFornitureUser);
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

		EntityCacheUtil.putResult(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFFornitureUserImpl.class, esfFornitureUser.getPrimaryKey(),
			esfFornitureUser);

		return esfFornitureUser;
	}

	protected ESFFornitureUser toUnwrappedModel(
		ESFFornitureUser esfFornitureUser) {
		if (esfFornitureUser instanceof ESFFornitureUserImpl) {
			return esfFornitureUser;
		}

		ESFFornitureUserImpl esfFornitureUserImpl = new ESFFornitureUserImpl();

		esfFornitureUserImpl.setNew(esfFornitureUser.isNew());
		esfFornitureUserImpl.setPrimaryKey(esfFornitureUser.getPrimaryKey());

		esfFornitureUserImpl.setEsfIDForniture(esfFornitureUser.getEsfIDForniture());
		esfFornitureUserImpl.setEsfIdUser(esfFornitureUser.getEsfIdUser());
		esfFornitureUserImpl.setEsfQuantity(esfFornitureUser.getEsfQuantity());
		esfFornitureUserImpl.setEsfDateAssign(esfFornitureUser.getEsfDateAssign());
		esfFornitureUserImpl.setEsfFornitureUserID(esfFornitureUser.getEsfFornitureUserID());

		return esfFornitureUserImpl;
	}

	/**
	 * Returns the e s f forniture user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f forniture user
	 * @return the e s f forniture user
	 * @throws it.ethica.esf.NoSuchFornitureUserException if a e s f forniture user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFornitureUserException, SystemException {
		ESFFornitureUser esfFornitureUser = fetchByPrimaryKey(primaryKey);

		if (esfFornitureUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFornitureUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfFornitureUser;
	}

	/**
	 * Returns the e s f forniture user with the primary key or throws a {@link it.ethica.esf.NoSuchFornitureUserException} if it could not be found.
	 *
	 * @param esfFornitureUserID the primary key of the e s f forniture user
	 * @return the e s f forniture user
	 * @throws it.ethica.esf.NoSuchFornitureUserException if a e s f forniture user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureUser findByPrimaryKey(long esfFornitureUserID)
		throws NoSuchFornitureUserException, SystemException {
		return findByPrimaryKey((Serializable)esfFornitureUserID);
	}

	/**
	 * Returns the e s f forniture user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f forniture user
	 * @return the e s f forniture user, or <code>null</code> if a e s f forniture user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFFornitureUser esfFornitureUser = (ESFFornitureUser)EntityCacheUtil.getResult(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFFornitureUserImpl.class, primaryKey);

		if (esfFornitureUser == _nullESFFornitureUser) {
			return null;
		}

		if (esfFornitureUser == null) {
			Session session = null;

			try {
				session = openSession();

				esfFornitureUser = (ESFFornitureUser)session.get(ESFFornitureUserImpl.class,
						primaryKey);

				if (esfFornitureUser != null) {
					cacheResult(esfFornitureUser);
				}
				else {
					EntityCacheUtil.putResult(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFFornitureUserImpl.class, primaryKey,
						_nullESFFornitureUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFornitureUserModelImpl.ENTITY_CACHE_ENABLED,
					ESFFornitureUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfFornitureUser;
	}

	/**
	 * Returns the e s f forniture user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFornitureUserID the primary key of the e s f forniture user
	 * @return the e s f forniture user, or <code>null</code> if a e s f forniture user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFornitureUser fetchByPrimaryKey(long esfFornitureUserID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFornitureUserID);
	}

	/**
	 * Returns all the e s f forniture users.
	 *
	 * @return the e s f forniture users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f forniture users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f forniture users
	 * @param end the upper bound of the range of e s f forniture users (not inclusive)
	 * @return the range of e s f forniture users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f forniture users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f forniture users
	 * @param end the upper bound of the range of e s f forniture users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f forniture users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFornitureUser> findAll(int start, int end,
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

		List<ESFFornitureUser> list = (List<ESFFornitureUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFORNITUREUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFORNITUREUSER;

				if (pagination) {
					sql = sql.concat(ESFFornitureUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFFornitureUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFornitureUser>(list);
				}
				else {
					list = (List<ESFFornitureUser>)QueryUtil.list(q,
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
	 * Removes all the e s f forniture users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFFornitureUser esfFornitureUser : findAll()) {
			remove(esfFornitureUser);
		}
	}

	/**
	 * Returns the number of e s f forniture users.
	 *
	 * @return the number of e s f forniture users
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

				Query q = session.createQuery(_SQL_COUNT_ESFFORNITUREUSER);

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
	 * Initializes the e s f forniture user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFFornitureUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFFornitureUser>> listenersList = new ArrayList<ModelListener<ESFFornitureUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFFornitureUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFornitureUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFORNITUREUSER = "SELECT esfFornitureUser FROM ESFFornitureUser esfFornitureUser";
	private static final String _SQL_COUNT_ESFFORNITUREUSER = "SELECT COUNT(esfFornitureUser) FROM ESFFornitureUser esfFornitureUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfFornitureUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFFornitureUser exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFornitureUserPersistenceImpl.class);
	private static ESFFornitureUser _nullESFFornitureUser = new ESFFornitureUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFFornitureUser> toCacheModel() {
				return _nullESFFornitureUserCacheModel;
			}
		};

	private static CacheModel<ESFFornitureUser> _nullESFFornitureUserCacheModel = new CacheModel<ESFFornitureUser>() {
			@Override
			public ESFFornitureUser toEntityModel() {
				return _nullESFFornitureUser;
			}
		};
}