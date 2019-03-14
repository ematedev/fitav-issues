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

import it.ethica.esf.NoSuchShootingDirectorQualificationException;
import it.ethica.esf.model.ESFShootingDirectorQualification;
import it.ethica.esf.model.impl.ESFShootingDirectorQualificationImpl;
import it.ethica.esf.model.impl.ESFShootingDirectorQualificationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f shooting director qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirectorQualificationPersistence
 * @see ESFShootingDirectorQualificationUtil
 * @generated
 */
public class ESFShootingDirectorQualificationPersistenceImpl
	extends BasePersistenceImpl<ESFShootingDirectorQualification>
	implements ESFShootingDirectorQualificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFShootingDirectorQualificationUtil} to access the e s f shooting director qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFShootingDirectorQualificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorQualificationModelImpl.FINDER_CACHE_ENABLED,
			ESFShootingDirectorQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorQualificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public ESFShootingDirectorQualificationPersistenceImpl() {
		setModelClass(ESFShootingDirectorQualification.class);
	}

	/**
	 * Caches the e s f shooting director qualification in the entity cache if it is enabled.
	 *
	 * @param esfShootingDirectorQualification the e s f shooting director qualification
	 */
	@Override
	public void cacheResult(
		ESFShootingDirectorQualification esfShootingDirectorQualification) {
		EntityCacheUtil.putResult(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorQualificationImpl.class,
			esfShootingDirectorQualification.getPrimaryKey(),
			esfShootingDirectorQualification);

		esfShootingDirectorQualification.resetOriginalValues();
	}

	/**
	 * Caches the e s f shooting director qualifications in the entity cache if it is enabled.
	 *
	 * @param esfShootingDirectorQualifications the e s f shooting director qualifications
	 */
	@Override
	public void cacheResult(
		List<ESFShootingDirectorQualification> esfShootingDirectorQualifications) {
		for (ESFShootingDirectorQualification esfShootingDirectorQualification : esfShootingDirectorQualifications) {
			if (EntityCacheUtil.getResult(
						ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
						ESFShootingDirectorQualificationImpl.class,
						esfShootingDirectorQualification.getPrimaryKey()) == null) {
				cacheResult(esfShootingDirectorQualification);
			}
			else {
				esfShootingDirectorQualification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f shooting director qualifications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFShootingDirectorQualificationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFShootingDirectorQualificationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f shooting director qualification.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFShootingDirectorQualification esfShootingDirectorQualification) {
		EntityCacheUtil.removeResult(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorQualificationImpl.class,
			esfShootingDirectorQualification.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFShootingDirectorQualification> esfShootingDirectorQualifications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFShootingDirectorQualification esfShootingDirectorQualification : esfShootingDirectorQualifications) {
			EntityCacheUtil.removeResult(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
				ESFShootingDirectorQualificationImpl.class,
				esfShootingDirectorQualification.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f shooting director qualification with the primary key. Does not add the e s f shooting director qualification to the database.
	 *
	 * @param esfShootingDirectorQualificationId the primary key for the new e s f shooting director qualification
	 * @return the new e s f shooting director qualification
	 */
	@Override
	public ESFShootingDirectorQualification create(
		long esfShootingDirectorQualificationId) {
		ESFShootingDirectorQualification esfShootingDirectorQualification = new ESFShootingDirectorQualificationImpl();

		esfShootingDirectorQualification.setNew(true);
		esfShootingDirectorQualification.setPrimaryKey(esfShootingDirectorQualificationId);

		return esfShootingDirectorQualification;
	}

	/**
	 * Removes the e s f shooting director qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfShootingDirectorQualificationId the primary key of the e s f shooting director qualification
	 * @return the e s f shooting director qualification that was removed
	 * @throws it.ethica.esf.NoSuchShootingDirectorQualificationException if a e s f shooting director qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirectorQualification remove(
		long esfShootingDirectorQualificationId)
		throws NoSuchShootingDirectorQualificationException, SystemException {
		return remove((Serializable)esfShootingDirectorQualificationId);
	}

	/**
	 * Removes the e s f shooting director qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f shooting director qualification
	 * @return the e s f shooting director qualification that was removed
	 * @throws it.ethica.esf.NoSuchShootingDirectorQualificationException if a e s f shooting director qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirectorQualification remove(Serializable primaryKey)
		throws NoSuchShootingDirectorQualificationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFShootingDirectorQualification esfShootingDirectorQualification = (ESFShootingDirectorQualification)session.get(ESFShootingDirectorQualificationImpl.class,
					primaryKey);

			if (esfShootingDirectorQualification == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShootingDirectorQualificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfShootingDirectorQualification);
		}
		catch (NoSuchShootingDirectorQualificationException nsee) {
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
	protected ESFShootingDirectorQualification removeImpl(
		ESFShootingDirectorQualification esfShootingDirectorQualification)
		throws SystemException {
		esfShootingDirectorQualification = toUnwrappedModel(esfShootingDirectorQualification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfShootingDirectorQualification)) {
				esfShootingDirectorQualification = (ESFShootingDirectorQualification)session.get(ESFShootingDirectorQualificationImpl.class,
						esfShootingDirectorQualification.getPrimaryKeyObj());
			}

			if (esfShootingDirectorQualification != null) {
				session.delete(esfShootingDirectorQualification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfShootingDirectorQualification != null) {
			clearCache(esfShootingDirectorQualification);
		}

		return esfShootingDirectorQualification;
	}

	@Override
	public ESFShootingDirectorQualification updateImpl(
		it.ethica.esf.model.ESFShootingDirectorQualification esfShootingDirectorQualification)
		throws SystemException {
		esfShootingDirectorQualification = toUnwrappedModel(esfShootingDirectorQualification);

		boolean isNew = esfShootingDirectorQualification.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfShootingDirectorQualification.isNew()) {
				session.save(esfShootingDirectorQualification);

				esfShootingDirectorQualification.setNew(false);
			}
			else {
				session.merge(esfShootingDirectorQualification);
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

		EntityCacheUtil.putResult(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			ESFShootingDirectorQualificationImpl.class,
			esfShootingDirectorQualification.getPrimaryKey(),
			esfShootingDirectorQualification);

		return esfShootingDirectorQualification;
	}

	protected ESFShootingDirectorQualification toUnwrappedModel(
		ESFShootingDirectorQualification esfShootingDirectorQualification) {
		if (esfShootingDirectorQualification instanceof ESFShootingDirectorQualificationImpl) {
			return esfShootingDirectorQualification;
		}

		ESFShootingDirectorQualificationImpl esfShootingDirectorQualificationImpl =
			new ESFShootingDirectorQualificationImpl();

		esfShootingDirectorQualificationImpl.setNew(esfShootingDirectorQualification.isNew());
		esfShootingDirectorQualificationImpl.setPrimaryKey(esfShootingDirectorQualification.getPrimaryKey());

		esfShootingDirectorQualificationImpl.setEsfShootingDirectorQualificationId(esfShootingDirectorQualification.getEsfShootingDirectorQualificationId());
		esfShootingDirectorQualificationImpl.setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualification.getEsfShootingDirectorQualificationDesc());

		return esfShootingDirectorQualificationImpl;
	}

	/**
	 * Returns the e s f shooting director qualification with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooting director qualification
	 * @return the e s f shooting director qualification
	 * @throws it.ethica.esf.NoSuchShootingDirectorQualificationException if a e s f shooting director qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirectorQualification findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchShootingDirectorQualificationException, SystemException {
		ESFShootingDirectorQualification esfShootingDirectorQualification = fetchByPrimaryKey(primaryKey);

		if (esfShootingDirectorQualification == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShootingDirectorQualificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfShootingDirectorQualification;
	}

	/**
	 * Returns the e s f shooting director qualification with the primary key or throws a {@link it.ethica.esf.NoSuchShootingDirectorQualificationException} if it could not be found.
	 *
	 * @param esfShootingDirectorQualificationId the primary key of the e s f shooting director qualification
	 * @return the e s f shooting director qualification
	 * @throws it.ethica.esf.NoSuchShootingDirectorQualificationException if a e s f shooting director qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirectorQualification findByPrimaryKey(
		long esfShootingDirectorQualificationId)
		throws NoSuchShootingDirectorQualificationException, SystemException {
		return findByPrimaryKey((Serializable)esfShootingDirectorQualificationId);
	}

	/**
	 * Returns the e s f shooting director qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooting director qualification
	 * @return the e s f shooting director qualification, or <code>null</code> if a e s f shooting director qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirectorQualification fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFShootingDirectorQualification esfShootingDirectorQualification = (ESFShootingDirectorQualification)EntityCacheUtil.getResult(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
				ESFShootingDirectorQualificationImpl.class, primaryKey);

		if (esfShootingDirectorQualification == _nullESFShootingDirectorQualification) {
			return null;
		}

		if (esfShootingDirectorQualification == null) {
			Session session = null;

			try {
				session = openSession();

				esfShootingDirectorQualification = (ESFShootingDirectorQualification)session.get(ESFShootingDirectorQualificationImpl.class,
						primaryKey);

				if (esfShootingDirectorQualification != null) {
					cacheResult(esfShootingDirectorQualification);
				}
				else {
					EntityCacheUtil.putResult(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
						ESFShootingDirectorQualificationImpl.class, primaryKey,
						_nullESFShootingDirectorQualification);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFShootingDirectorQualificationModelImpl.ENTITY_CACHE_ENABLED,
					ESFShootingDirectorQualificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfShootingDirectorQualification;
	}

	/**
	 * Returns the e s f shooting director qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfShootingDirectorQualificationId the primary key of the e s f shooting director qualification
	 * @return the e s f shooting director qualification, or <code>null</code> if a e s f shooting director qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShootingDirectorQualification fetchByPrimaryKey(
		long esfShootingDirectorQualificationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfShootingDirectorQualificationId);
	}

	/**
	 * Returns all the e s f shooting director qualifications.
	 *
	 * @return the e s f shooting director qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirectorQualification> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooting director qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooting director qualifications
	 * @param end the upper bound of the range of e s f shooting director qualifications (not inclusive)
	 * @return the range of e s f shooting director qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirectorQualification> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooting director qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooting director qualifications
	 * @param end the upper bound of the range of e s f shooting director qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f shooting director qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShootingDirectorQualification> findAll(int start, int end,
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

		List<ESFShootingDirectorQualification> list = (List<ESFShootingDirectorQualification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSHOOTINGDIRECTORQUALIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSHOOTINGDIRECTORQUALIFICATION;

				if (pagination) {
					sql = sql.concat(ESFShootingDirectorQualificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFShootingDirectorQualification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShootingDirectorQualification>(list);
				}
				else {
					list = (List<ESFShootingDirectorQualification>)QueryUtil.list(q,
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
	 * Removes all the e s f shooting director qualifications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFShootingDirectorQualification esfShootingDirectorQualification : findAll()) {
			remove(esfShootingDirectorQualification);
		}
	}

	/**
	 * Returns the number of e s f shooting director qualifications.
	 *
	 * @return the number of e s f shooting director qualifications
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

				Query q = session.createQuery(_SQL_COUNT_ESFSHOOTINGDIRECTORQUALIFICATION);

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
	 * Initializes the e s f shooting director qualification persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFShootingDirectorQualification")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFShootingDirectorQualification>> listenersList =
					new ArrayList<ModelListener<ESFShootingDirectorQualification>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFShootingDirectorQualification>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFShootingDirectorQualificationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSHOOTINGDIRECTORQUALIFICATION = "SELECT esfShootingDirectorQualification FROM ESFShootingDirectorQualification esfShootingDirectorQualification";
	private static final String _SQL_COUNT_ESFSHOOTINGDIRECTORQUALIFICATION = "SELECT COUNT(esfShootingDirectorQualification) FROM ESFShootingDirectorQualification esfShootingDirectorQualification";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfShootingDirectorQualification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFShootingDirectorQualification exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFShootingDirectorQualificationPersistenceImpl.class);
	private static ESFShootingDirectorQualification _nullESFShootingDirectorQualification =
		new ESFShootingDirectorQualificationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFShootingDirectorQualification> toCacheModel() {
				return _nullESFShootingDirectorQualificationCacheModel;
			}
		};

	private static CacheModel<ESFShootingDirectorQualification> _nullESFShootingDirectorQualificationCacheModel =
		new CacheModel<ESFShootingDirectorQualification>() {
			@Override
			public ESFShootingDirectorQualification toEntityModel() {
				return _nullESFShootingDirectorQualification;
			}
		};
}