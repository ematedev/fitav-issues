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

import it.ethica.esf.NoSuchPhoneException;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.impl.ESFPhoneImpl;
import it.ethica.esf.model.impl.ESFPhoneModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f phone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPhonePersistence
 * @see ESFPhoneUtil
 * @generated
 */
public class ESFPhonePersistenceImpl extends BasePersistenceImpl<ESFPhone>
	implements ESFPhonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFPhoneUtil} to access the e s f phone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFPhoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ESFPhoneModelImpl.FINDER_CACHE_ENABLED, ESFPhoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ESFPhoneModelImpl.FINDER_CACHE_ENABLED, ESFPhoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ESFPhoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ESFPhonePersistenceImpl() {
		setModelClass(ESFPhone.class);
	}

	/**
	 * Caches the e s f phone in the entity cache if it is enabled.
	 *
	 * @param esfPhone the e s f phone
	 */
	@Override
	public void cacheResult(ESFPhone esfPhone) {
		EntityCacheUtil.putResult(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ESFPhoneImpl.class, esfPhone.getPrimaryKey(), esfPhone);

		esfPhone.resetOriginalValues();
	}

	/**
	 * Caches the e s f phones in the entity cache if it is enabled.
	 *
	 * @param esfPhones the e s f phones
	 */
	@Override
	public void cacheResult(List<ESFPhone> esfPhones) {
		for (ESFPhone esfPhone : esfPhones) {
			if (EntityCacheUtil.getResult(
						ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
						ESFPhoneImpl.class, esfPhone.getPrimaryKey()) == null) {
				cacheResult(esfPhone);
			}
			else {
				esfPhone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f phones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFPhoneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFPhoneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f phone.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFPhone esfPhone) {
		EntityCacheUtil.removeResult(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ESFPhoneImpl.class, esfPhone.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFPhone> esfPhones) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFPhone esfPhone : esfPhones) {
			EntityCacheUtil.removeResult(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
				ESFPhoneImpl.class, esfPhone.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f phone with the primary key. Does not add the e s f phone to the database.
	 *
	 * @param esfPhoneId the primary key for the new e s f phone
	 * @return the new e s f phone
	 */
	@Override
	public ESFPhone create(long esfPhoneId) {
		ESFPhone esfPhone = new ESFPhoneImpl();

		esfPhone.setNew(true);
		esfPhone.setPrimaryKey(esfPhoneId);

		return esfPhone;
	}

	/**
	 * Removes the e s f phone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfPhoneId the primary key of the e s f phone
	 * @return the e s f phone that was removed
	 * @throws it.ethica.esf.NoSuchPhoneException if a e s f phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPhone remove(long esfPhoneId)
		throws NoSuchPhoneException, SystemException {
		return remove((Serializable)esfPhoneId);
	}

	/**
	 * Removes the e s f phone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f phone
	 * @return the e s f phone that was removed
	 * @throws it.ethica.esf.NoSuchPhoneException if a e s f phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPhone remove(Serializable primaryKey)
		throws NoSuchPhoneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFPhone esfPhone = (ESFPhone)session.get(ESFPhoneImpl.class,
					primaryKey);

			if (esfPhone == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfPhone);
		}
		catch (NoSuchPhoneException nsee) {
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
	protected ESFPhone removeImpl(ESFPhone esfPhone) throws SystemException {
		esfPhone = toUnwrappedModel(esfPhone);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfPhone)) {
				esfPhone = (ESFPhone)session.get(ESFPhoneImpl.class,
						esfPhone.getPrimaryKeyObj());
			}

			if (esfPhone != null) {
				session.delete(esfPhone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfPhone != null) {
			clearCache(esfPhone);
		}

		return esfPhone;
	}

	@Override
	public ESFPhone updateImpl(it.ethica.esf.model.ESFPhone esfPhone)
		throws SystemException {
		esfPhone = toUnwrappedModel(esfPhone);

		boolean isNew = esfPhone.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfPhone.isNew()) {
				session.save(esfPhone);

				esfPhone.setNew(false);
			}
			else {
				session.merge(esfPhone);
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

		EntityCacheUtil.putResult(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
			ESFPhoneImpl.class, esfPhone.getPrimaryKey(), esfPhone);

		return esfPhone;
	}

	protected ESFPhone toUnwrappedModel(ESFPhone esfPhone) {
		if (esfPhone instanceof ESFPhoneImpl) {
			return esfPhone;
		}

		ESFPhoneImpl esfPhoneImpl = new ESFPhoneImpl();

		esfPhoneImpl.setNew(esfPhone.isNew());
		esfPhoneImpl.setPrimaryKey(esfPhone.getPrimaryKey());

		esfPhoneImpl.setEsfPhoneId(esfPhone.getEsfPhoneId());
		esfPhoneImpl.setListTypeId(esfPhone.getListTypeId());

		return esfPhoneImpl;
	}

	/**
	 * Returns the e s f phone with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f phone
	 * @return the e s f phone
	 * @throws it.ethica.esf.NoSuchPhoneException if a e s f phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPhone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhoneException, SystemException {
		ESFPhone esfPhone = fetchByPrimaryKey(primaryKey);

		if (esfPhone == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfPhone;
	}

	/**
	 * Returns the e s f phone with the primary key or throws a {@link it.ethica.esf.NoSuchPhoneException} if it could not be found.
	 *
	 * @param esfPhoneId the primary key of the e s f phone
	 * @return the e s f phone
	 * @throws it.ethica.esf.NoSuchPhoneException if a e s f phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPhone findByPrimaryKey(long esfPhoneId)
		throws NoSuchPhoneException, SystemException {
		return findByPrimaryKey((Serializable)esfPhoneId);
	}

	/**
	 * Returns the e s f phone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f phone
	 * @return the e s f phone, or <code>null</code> if a e s f phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPhone fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFPhone esfPhone = (ESFPhone)EntityCacheUtil.getResult(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
				ESFPhoneImpl.class, primaryKey);

		if (esfPhone == _nullESFPhone) {
			return null;
		}

		if (esfPhone == null) {
			Session session = null;

			try {
				session = openSession();

				esfPhone = (ESFPhone)session.get(ESFPhoneImpl.class, primaryKey);

				if (esfPhone != null) {
					cacheResult(esfPhone);
				}
				else {
					EntityCacheUtil.putResult(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
						ESFPhoneImpl.class, primaryKey, _nullESFPhone);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFPhoneModelImpl.ENTITY_CACHE_ENABLED,
					ESFPhoneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfPhone;
	}

	/**
	 * Returns the e s f phone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfPhoneId the primary key of the e s f phone
	 * @return the e s f phone, or <code>null</code> if a e s f phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFPhone fetchByPrimaryKey(long esfPhoneId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfPhoneId);
	}

	/**
	 * Returns all the e s f phones.
	 *
	 * @return the e s f phones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPhone> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f phones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f phones
	 * @param end the upper bound of the range of e s f phones (not inclusive)
	 * @return the range of e s f phones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPhone> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f phones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPhoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f phones
	 * @param end the upper bound of the range of e s f phones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f phones
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFPhone> findAll(int start, int end,
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

		List<ESFPhone> list = (List<ESFPhone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFPHONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFPHONE;

				if (pagination) {
					sql = sql.concat(ESFPhoneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFPhone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFPhone>(list);
				}
				else {
					list = (List<ESFPhone>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f phones from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFPhone esfPhone : findAll()) {
			remove(esfPhone);
		}
	}

	/**
	 * Returns the number of e s f phones.
	 *
	 * @return the number of e s f phones
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

				Query q = session.createQuery(_SQL_COUNT_ESFPHONE);

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
	 * Initializes the e s f phone persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFPhone")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFPhone>> listenersList = new ArrayList<ModelListener<ESFPhone>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFPhone>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFPhoneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFPHONE = "SELECT esfPhone FROM ESFPhone esfPhone";
	private static final String _SQL_COUNT_ESFPHONE = "SELECT COUNT(esfPhone) FROM ESFPhone esfPhone";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfPhone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFPhone exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFPhonePersistenceImpl.class);
	private static ESFPhone _nullESFPhone = new ESFPhoneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFPhone> toCacheModel() {
				return _nullESFPhoneCacheModel;
			}
		};

	private static CacheModel<ESFPhone> _nullESFPhoneCacheModel = new CacheModel<ESFPhone>() {
			@Override
			public ESFPhone toEntityModel() {
				return _nullESFPhone;
			}
		};
}