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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

import it.ethica.esf.NoSuchSuspensiveShooingDirectorException;
import it.ethica.esf.model.ESFSuspensiveShooingDirector;
import it.ethica.esf.model.impl.ESFSuspensiveShooingDirectorImpl;
import it.ethica.esf.model.impl.ESFSuspensiveShooingDirectorModelImpl;

/**
 * The persistence implementation for the e s f suspensive shooing director service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveShooingDirectorPersistence
 * @see ESFSuspensiveShooingDirectorUtil
 * @generated
 */
public class ESFSuspensiveShooingDirectorPersistenceImpl
	extends BasePersistenceImpl<ESFSuspensiveShooingDirector>
	implements ESFSuspensiveShooingDirectorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFSuspensiveShooingDirectorUtil} to access the e s f suspensive shooing director persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFSuspensiveShooingDirectorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShooingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveShooingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShooingDirectorModelImpl.FINDER_CACHE_ENABLED,
			ESFSuspensiveShooingDirectorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShooingDirectorModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public ESFSuspensiveShooingDirectorPersistenceImpl() {
		setModelClass(ESFSuspensiveShooingDirector.class);
	}

	/**
	 * Caches the e s f suspensive shooing director in the entity cache if it is enabled.
	 *
	 * @param esfSuspensiveShooingDirector the e s f suspensive shooing director
	 */
	@Override
	public void cacheResult(
		ESFSuspensiveShooingDirector esfSuspensiveShooingDirector) {
		EntityCacheUtil.putResult(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShooingDirectorImpl.class,
			esfSuspensiveShooingDirector.getPrimaryKey(),
			esfSuspensiveShooingDirector);

		esfSuspensiveShooingDirector.resetOriginalValues();
	}

	/**
	 * Caches the e s f suspensive shooing directors in the entity cache if it is enabled.
	 *
	 * @param esfSuspensiveShooingDirectors the e s f suspensive shooing directors
	 */
	@Override
	public void cacheResult(
		List<ESFSuspensiveShooingDirector> esfSuspensiveShooingDirectors) {
		for (ESFSuspensiveShooingDirector esfSuspensiveShooingDirector : esfSuspensiveShooingDirectors) {
			if (EntityCacheUtil.getResult(
						ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
						ESFSuspensiveShooingDirectorImpl.class,
						esfSuspensiveShooingDirector.getPrimaryKey()) == null) {
				cacheResult(esfSuspensiveShooingDirector);
			}
			else {
				esfSuspensiveShooingDirector.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f suspensive shooing directors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFSuspensiveShooingDirectorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFSuspensiveShooingDirectorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f suspensive shooing director.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFSuspensiveShooingDirector esfSuspensiveShooingDirector) {
		EntityCacheUtil.removeResult(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShooingDirectorImpl.class,
			esfSuspensiveShooingDirector.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFSuspensiveShooingDirector> esfSuspensiveShooingDirectors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFSuspensiveShooingDirector esfSuspensiveShooingDirector : esfSuspensiveShooingDirectors) {
			EntityCacheUtil.removeResult(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
				ESFSuspensiveShooingDirectorImpl.class,
				esfSuspensiveShooingDirector.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f suspensive shooing director with the primary key. Does not add the e s f suspensive shooing director to the database.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key for the new e s f suspensive shooing director
	 * @return the new e s f suspensive shooing director
	 */
	@Override
	public ESFSuspensiveShooingDirector create(
		long esfSuspensiveShooingDirectorId) {
		ESFSuspensiveShooingDirector esfSuspensiveShooingDirector = new ESFSuspensiveShooingDirectorImpl();

		esfSuspensiveShooingDirector.setNew(true);
		esfSuspensiveShooingDirector.setPrimaryKey(esfSuspensiveShooingDirectorId);

		return esfSuspensiveShooingDirector;
	}

	/**
	 * Removes the e s f suspensive shooing director with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooing director
	 * @return the e s f suspensive shooing director that was removed
	 * @throws it.ethica.esf.NoSuchSuspensiveShooingDirectorException if a e s f suspensive shooing director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShooingDirector remove(
		long esfSuspensiveShooingDirectorId)
		throws NoSuchSuspensiveShooingDirectorException, SystemException {
		return remove((Serializable)esfSuspensiveShooingDirectorId);
	}

	/**
	 * Removes the e s f suspensive shooing director with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f suspensive shooing director
	 * @return the e s f suspensive shooing director that was removed
	 * @throws it.ethica.esf.NoSuchSuspensiveShooingDirectorException if a e s f suspensive shooing director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShooingDirector remove(Serializable primaryKey)
		throws NoSuchSuspensiveShooingDirectorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFSuspensiveShooingDirector esfSuspensiveShooingDirector = (ESFSuspensiveShooingDirector)session.get(ESFSuspensiveShooingDirectorImpl.class,
					primaryKey);

			if (esfSuspensiveShooingDirector == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSuspensiveShooingDirectorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfSuspensiveShooingDirector);
		}
		catch (NoSuchSuspensiveShooingDirectorException nsee) {
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
	protected ESFSuspensiveShooingDirector removeImpl(
		ESFSuspensiveShooingDirector esfSuspensiveShooingDirector)
		throws SystemException {
		esfSuspensiveShooingDirector = toUnwrappedModel(esfSuspensiveShooingDirector);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfSuspensiveShooingDirector)) {
				esfSuspensiveShooingDirector = (ESFSuspensiveShooingDirector)session.get(ESFSuspensiveShooingDirectorImpl.class,
						esfSuspensiveShooingDirector.getPrimaryKeyObj());
			}

			if (esfSuspensiveShooingDirector != null) {
				session.delete(esfSuspensiveShooingDirector);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfSuspensiveShooingDirector != null) {
			clearCache(esfSuspensiveShooingDirector);
		}

		return esfSuspensiveShooingDirector;
	}

	@Override
	public ESFSuspensiveShooingDirector updateImpl(
		it.ethica.esf.model.ESFSuspensiveShooingDirector esfSuspensiveShooingDirector)
		throws SystemException {
		esfSuspensiveShooingDirector = toUnwrappedModel(esfSuspensiveShooingDirector);

		boolean isNew = esfSuspensiveShooingDirector.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfSuspensiveShooingDirector.isNew()) {
				session.save(esfSuspensiveShooingDirector);

				esfSuspensiveShooingDirector.setNew(false);
			}
			else {
				session.merge(esfSuspensiveShooingDirector);
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

		EntityCacheUtil.putResult(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
			ESFSuspensiveShooingDirectorImpl.class,
			esfSuspensiveShooingDirector.getPrimaryKey(),
			esfSuspensiveShooingDirector);

		return esfSuspensiveShooingDirector;
	}

	protected ESFSuspensiveShooingDirector toUnwrappedModel(
		ESFSuspensiveShooingDirector esfSuspensiveShooingDirector) {
		if (esfSuspensiveShooingDirector instanceof ESFSuspensiveShooingDirectorImpl) {
			return esfSuspensiveShooingDirector;
		}

		ESFSuspensiveShooingDirectorImpl esfSuspensiveShooingDirectorImpl = new ESFSuspensiveShooingDirectorImpl();

		esfSuspensiveShooingDirectorImpl.setNew(esfSuspensiveShooingDirector.isNew());
		esfSuspensiveShooingDirectorImpl.setPrimaryKey(esfSuspensiveShooingDirector.getPrimaryKey());

		esfSuspensiveShooingDirectorImpl.setEsfSuspensiveShooingDirectorId(esfSuspensiveShooingDirector.getEsfSuspensiveShooingDirectorId());
		esfSuspensiveShooingDirectorImpl.setEsfData(esfSuspensiveShooingDirector.getEsfData());
		esfSuspensiveShooingDirectorImpl.setEsfCodeData(esfSuspensiveShooingDirector.getEsfCodeData());
		esfSuspensiveShooingDirectorImpl.setEsfStartData(esfSuspensiveShooingDirector.getEsfStartData());
		esfSuspensiveShooingDirectorImpl.setEsfEndData(esfSuspensiveShooingDirector.getEsfEndData());
		esfSuspensiveShooingDirectorImpl.setEsfUserId(esfSuspensiveShooingDirector.getEsfUserId());
		esfSuspensiveShooingDirectorImpl.setCodeUser(esfSuspensiveShooingDirector.getCodeUser());
		esfSuspensiveShooingDirectorImpl.setNote(esfSuspensiveShooingDirector.getNote());
		esfSuspensiveShooingDirectorImpl.setQualif1_Utiliz(esfSuspensiveShooingDirector.getQualif1_Utiliz());
		esfSuspensiveShooingDirectorImpl.setQualif2_Utiliz(esfSuspensiveShooingDirector.getQualif2_Utiliz());
		esfSuspensiveShooingDirectorImpl.setQualif3_Utiliz(esfSuspensiveShooingDirector.getQualif3_Utiliz());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara1_noUtil(esfSuspensiveShooingDirector.getTipo_Gara1_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara2_noUtil(esfSuspensiveShooingDirector.getTipo_Gara2_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara3_noUtil(esfSuspensiveShooingDirector.getTipo_Gara3_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara4_noUtil(esfSuspensiveShooingDirector.getTipo_Gara4_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara5_noUtil(esfSuspensiveShooingDirector.getTipo_Gara5_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara6_noUtil(esfSuspensiveShooingDirector.getTipo_Gara6_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara7_noUtil(esfSuspensiveShooingDirector.getTipo_Gara7_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara8_noUtil(esfSuspensiveShooingDirector.getTipo_Gara8_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara9_noUtil(esfSuspensiveShooingDirector.getTipo_Gara9_noUtil());
		esfSuspensiveShooingDirectorImpl.setTipo_Gara10_noUtil(esfSuspensiveShooingDirector.getTipo_Gara10_noUtil());
		esfSuspensiveShooingDirectorImpl.setEsfVariationData(esfSuspensiveShooingDirector.getEsfVariationData());

		return esfSuspensiveShooingDirectorImpl;
	}

	/**
	 * Returns the e s f suspensive shooing director with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f suspensive shooing director
	 * @return the e s f suspensive shooing director
	 * @throws it.ethica.esf.NoSuchSuspensiveShooingDirectorException if a e s f suspensive shooing director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShooingDirector findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchSuspensiveShooingDirectorException, SystemException {
		ESFSuspensiveShooingDirector esfSuspensiveShooingDirector = fetchByPrimaryKey(primaryKey);

		if (esfSuspensiveShooingDirector == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSuspensiveShooingDirectorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfSuspensiveShooingDirector;
	}

	/**
	 * Returns the e s f suspensive shooing director with the primary key or throws a {@link it.ethica.esf.NoSuchSuspensiveShooingDirectorException} if it could not be found.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooing director
	 * @return the e s f suspensive shooing director
	 * @throws it.ethica.esf.NoSuchSuspensiveShooingDirectorException if a e s f suspensive shooing director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShooingDirector findByPrimaryKey(
		long esfSuspensiveShooingDirectorId)
		throws NoSuchSuspensiveShooingDirectorException, SystemException {
		return findByPrimaryKey((Serializable)esfSuspensiveShooingDirectorId);
	}

	/**
	 * Returns the e s f suspensive shooing director with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f suspensive shooing director
	 * @return the e s f suspensive shooing director, or <code>null</code> if a e s f suspensive shooing director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShooingDirector fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFSuspensiveShooingDirector esfSuspensiveShooingDirector = (ESFSuspensiveShooingDirector)EntityCacheUtil.getResult(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
				ESFSuspensiveShooingDirectorImpl.class, primaryKey);

		if (esfSuspensiveShooingDirector == _nullESFSuspensiveShooingDirector) {
			return null;
		}

		if (esfSuspensiveShooingDirector == null) {
			Session session = null;

			try {
				session = openSession();

				esfSuspensiveShooingDirector = (ESFSuspensiveShooingDirector)session.get(ESFSuspensiveShooingDirectorImpl.class,
						primaryKey);

				if (esfSuspensiveShooingDirector != null) {
					cacheResult(esfSuspensiveShooingDirector);
				}
				else {
					EntityCacheUtil.putResult(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
						ESFSuspensiveShooingDirectorImpl.class, primaryKey,
						_nullESFSuspensiveShooingDirector);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFSuspensiveShooingDirectorModelImpl.ENTITY_CACHE_ENABLED,
					ESFSuspensiveShooingDirectorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfSuspensiveShooingDirector;
	}

	/**
	 * Returns the e s f suspensive shooing director with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooing director
	 * @return the e s f suspensive shooing director, or <code>null</code> if a e s f suspensive shooing director with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSuspensiveShooingDirector fetchByPrimaryKey(
		long esfSuspensiveShooingDirectorId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfSuspensiveShooingDirectorId);
	}

	/**
	 * Returns all the e s f suspensive shooing directors.
	 *
	 * @return the e s f suspensive shooing directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShooingDirector> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f suspensive shooing directors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShooingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f suspensive shooing directors
	 * @param end the upper bound of the range of e s f suspensive shooing directors (not inclusive)
	 * @return the range of e s f suspensive shooing directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShooingDirector> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f suspensive shooing directors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShooingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f suspensive shooing directors
	 * @param end the upper bound of the range of e s f suspensive shooing directors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f suspensive shooing directors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSuspensiveShooingDirector> findAll(int start, int end,
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

		List<ESFSuspensiveShooingDirector> list = (List<ESFSuspensiveShooingDirector>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSUSPENSIVESHOOINGDIRECTOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSUSPENSIVESHOOINGDIRECTOR;

				if (pagination) {
					sql = sql.concat(ESFSuspensiveShooingDirectorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFSuspensiveShooingDirector>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSuspensiveShooingDirector>(list);
				}
				else {
					list = (List<ESFSuspensiveShooingDirector>)QueryUtil.list(q,
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
	 * Removes all the e s f suspensive shooing directors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFSuspensiveShooingDirector esfSuspensiveShooingDirector : findAll()) {
			remove(esfSuspensiveShooingDirector);
		}
	}

	/**
	 * Returns the number of e s f suspensive shooing directors.
	 *
	 * @return the number of e s f suspensive shooing directors
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

				Query q = session.createQuery(_SQL_COUNT_ESFSUSPENSIVESHOOINGDIRECTOR);

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
	 * Initializes the e s f suspensive shooing director persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFSuspensiveShooingDirector")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFSuspensiveShooingDirector>> listenersList = new ArrayList<ModelListener<ESFSuspensiveShooingDirector>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFSuspensiveShooingDirector>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFSuspensiveShooingDirectorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSUSPENSIVESHOOINGDIRECTOR = "SELECT esfSuspensiveShooingDirector FROM ESFSuspensiveShooingDirector esfSuspensiveShooingDirector";
	private static final String _SQL_COUNT_ESFSUSPENSIVESHOOINGDIRECTOR = "SELECT COUNT(esfSuspensiveShooingDirector) FROM ESFSuspensiveShooingDirector esfSuspensiveShooingDirector";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfSuspensiveShooingDirector.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFSuspensiveShooingDirector exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFSuspensiveShooingDirectorPersistenceImpl.class);
	private static ESFSuspensiveShooingDirector _nullESFSuspensiveShooingDirector =
		new ESFSuspensiveShooingDirectorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFSuspensiveShooingDirector> toCacheModel() {
				return _nullESFSuspensiveShooingDirectorCacheModel;
			}
		};

	private static CacheModel<ESFSuspensiveShooingDirector> _nullESFSuspensiveShooingDirectorCacheModel =
		new CacheModel<ESFSuspensiveShooingDirector>() {
			@Override
			public ESFSuspensiveShooingDirector toEntityModel() {
				return _nullESFSuspensiveShooingDirector;
			}
		};
}