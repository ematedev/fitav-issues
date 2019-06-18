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

import it.ethica.esf.NoSuchVW_AzzurriException;
import it.ethica.esf.model.VW_Azzurri;
import it.ethica.esf.model.impl.VW_AzzurriImpl;
import it.ethica.esf.model.impl.VW_AzzurriModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v w_ azzurri service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_AzzurriPersistence
 * @see VW_AzzurriUtil
 * @generated
 */
public class VW_AzzurriPersistenceImpl extends BasePersistenceImpl<VW_Azzurri>
	implements VW_AzzurriPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VW_AzzurriUtil} to access the v w_ azzurri persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VW_AzzurriImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
			VW_AzzurriModelImpl.FINDER_CACHE_ENABLED, VW_AzzurriImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
			VW_AzzurriModelImpl.FINDER_CACHE_ENABLED, VW_AzzurriImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
			VW_AzzurriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VW_AzzurriPersistenceImpl() {
		setModelClass(VW_Azzurri.class);
	}

	/**
	 * Caches the v w_ azzurri in the entity cache if it is enabled.
	 *
	 * @param vw_Azzurri the v w_ azzurri
	 */
	@Override
	public void cacheResult(VW_Azzurri vw_Azzurri) {
		EntityCacheUtil.putResult(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
			VW_AzzurriImpl.class, vw_Azzurri.getPrimaryKey(), vw_Azzurri);

		vw_Azzurri.resetOriginalValues();
	}

	/**
	 * Caches the v w_ azzurris in the entity cache if it is enabled.
	 *
	 * @param vw_Azzurris the v w_ azzurris
	 */
	@Override
	public void cacheResult(List<VW_Azzurri> vw_Azzurris) {
		for (VW_Azzurri vw_Azzurri : vw_Azzurris) {
			if (EntityCacheUtil.getResult(
						VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
						VW_AzzurriImpl.class, vw_Azzurri.getPrimaryKey()) == null) {
				cacheResult(vw_Azzurri);
			}
			else {
				vw_Azzurri.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v w_ azzurris.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VW_AzzurriImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VW_AzzurriImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v w_ azzurri.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VW_Azzurri vw_Azzurri) {
		EntityCacheUtil.removeResult(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
			VW_AzzurriImpl.class, vw_Azzurri.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VW_Azzurri> vw_Azzurris) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VW_Azzurri vw_Azzurri : vw_Azzurris) {
			EntityCacheUtil.removeResult(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
				VW_AzzurriImpl.class, vw_Azzurri.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v w_ azzurri with the primary key. Does not add the v w_ azzurri to the database.
	 *
	 * @param vw_AzzurriPK the primary key for the new v w_ azzurri
	 * @return the new v w_ azzurri
	 */
	@Override
	public VW_Azzurri create(VW_AzzurriPK vw_AzzurriPK) {
		VW_Azzurri vw_Azzurri = new VW_AzzurriImpl();

		vw_Azzurri.setNew(true);
		vw_Azzurri.setPrimaryKey(vw_AzzurriPK);

		return vw_Azzurri;
	}

	/**
	 * Removes the v w_ azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vw_AzzurriPK the primary key of the v w_ azzurri
	 * @return the v w_ azzurri that was removed
	 * @throws it.ethica.esf.NoSuchVW_AzzurriException if a v w_ azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Azzurri remove(VW_AzzurriPK vw_AzzurriPK)
		throws NoSuchVW_AzzurriException, SystemException {
		return remove((Serializable)vw_AzzurriPK);
	}

	/**
	 * Removes the v w_ azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v w_ azzurri
	 * @return the v w_ azzurri that was removed
	 * @throws it.ethica.esf.NoSuchVW_AzzurriException if a v w_ azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Azzurri remove(Serializable primaryKey)
		throws NoSuchVW_AzzurriException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VW_Azzurri vw_Azzurri = (VW_Azzurri)session.get(VW_AzzurriImpl.class,
					primaryKey);

			if (vw_Azzurri == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVW_AzzurriException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vw_Azzurri);
		}
		catch (NoSuchVW_AzzurriException nsee) {
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
	protected VW_Azzurri removeImpl(VW_Azzurri vw_Azzurri)
		throws SystemException {
		vw_Azzurri = toUnwrappedModel(vw_Azzurri);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vw_Azzurri)) {
				vw_Azzurri = (VW_Azzurri)session.get(VW_AzzurriImpl.class,
						vw_Azzurri.getPrimaryKeyObj());
			}

			if (vw_Azzurri != null) {
				session.delete(vw_Azzurri);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vw_Azzurri != null) {
			clearCache(vw_Azzurri);
		}

		return vw_Azzurri;
	}

	@Override
	public VW_Azzurri updateImpl(it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws SystemException {
		vw_Azzurri = toUnwrappedModel(vw_Azzurri);

		boolean isNew = vw_Azzurri.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vw_Azzurri.isNew()) {
				session.save(vw_Azzurri);

				vw_Azzurri.setNew(false);
			}
			else {
				session.merge(vw_Azzurri);
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

		EntityCacheUtil.putResult(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
			VW_AzzurriImpl.class, vw_Azzurri.getPrimaryKey(), vw_Azzurri);

		return vw_Azzurri;
	}

	protected VW_Azzurri toUnwrappedModel(VW_Azzurri vw_Azzurri) {
		if (vw_Azzurri instanceof VW_AzzurriImpl) {
			return vw_Azzurri;
		}

		VW_AzzurriImpl vw_AzzurriImpl = new VW_AzzurriImpl();

		vw_AzzurriImpl.setNew(vw_Azzurri.isNew());
		vw_AzzurriImpl.setPrimaryKey(vw_Azzurri.getPrimaryKey());

		vw_AzzurriImpl.setEsfNationalId(vw_Azzurri.getEsfNationalId());
		vw_AzzurriImpl.setUserId(vw_Azzurri.getUserId());
		vw_AzzurriImpl.setUserName(vw_Azzurri.getUserName());
		vw_AzzurriImpl.setEsfUserId(vw_Azzurri.getEsfUserId());
		vw_AzzurriImpl.setEsfSportTypeId(vw_Azzurri.getEsfSportTypeId());
		vw_AzzurriImpl.setStartDate(vw_Azzurri.getStartDate());
		vw_AzzurriImpl.setEndDate(vw_Azzurri.getEndDate());
		vw_AzzurriImpl.setName(vw_Azzurri.getName());
		vw_AzzurriImpl.setDescription(vw_Azzurri.getDescription());
		vw_AzzurriImpl.setInvitato(vw_Azzurri.getInvitato());

		return vw_AzzurriImpl;
	}

	/**
	 * Returns the v w_ azzurri with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ azzurri
	 * @return the v w_ azzurri
	 * @throws it.ethica.esf.NoSuchVW_AzzurriException if a v w_ azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Azzurri findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVW_AzzurriException, SystemException {
		VW_Azzurri vw_Azzurri = fetchByPrimaryKey(primaryKey);

		if (vw_Azzurri == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVW_AzzurriException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vw_Azzurri;
	}

	/**
	 * Returns the v w_ azzurri with the primary key or throws a {@link it.ethica.esf.NoSuchVW_AzzurriException} if it could not be found.
	 *
	 * @param vw_AzzurriPK the primary key of the v w_ azzurri
	 * @return the v w_ azzurri
	 * @throws it.ethica.esf.NoSuchVW_AzzurriException if a v w_ azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Azzurri findByPrimaryKey(VW_AzzurriPK vw_AzzurriPK)
		throws NoSuchVW_AzzurriException, SystemException {
		return findByPrimaryKey((Serializable)vw_AzzurriPK);
	}

	/**
	 * Returns the v w_ azzurri with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ azzurri
	 * @return the v w_ azzurri, or <code>null</code> if a v w_ azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Azzurri fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VW_Azzurri vw_Azzurri = (VW_Azzurri)EntityCacheUtil.getResult(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
				VW_AzzurriImpl.class, primaryKey);

		if (vw_Azzurri == _nullVW_Azzurri) {
			return null;
		}

		if (vw_Azzurri == null) {
			Session session = null;

			try {
				session = openSession();

				vw_Azzurri = (VW_Azzurri)session.get(VW_AzzurriImpl.class,
						primaryKey);

				if (vw_Azzurri != null) {
					cacheResult(vw_Azzurri);
				}
				else {
					EntityCacheUtil.putResult(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
						VW_AzzurriImpl.class, primaryKey, _nullVW_Azzurri);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VW_AzzurriModelImpl.ENTITY_CACHE_ENABLED,
					VW_AzzurriImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vw_Azzurri;
	}

	/**
	 * Returns the v w_ azzurri with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vw_AzzurriPK the primary key of the v w_ azzurri
	 * @return the v w_ azzurri, or <code>null</code> if a v w_ azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Azzurri fetchByPrimaryKey(VW_AzzurriPK vw_AzzurriPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vw_AzzurriPK);
	}

	/**
	 * Returns all the v w_ azzurris.
	 *
	 * @return the v w_ azzurris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Azzurri> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v w_ azzurris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ azzurris
	 * @param end the upper bound of the range of v w_ azzurris (not inclusive)
	 * @return the range of v w_ azzurris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Azzurri> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v w_ azzurris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ azzurris
	 * @param end the upper bound of the range of v w_ azzurris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v w_ azzurris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Azzurri> findAll(int start, int end,
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

		List<VW_Azzurri> list = (List<VW_Azzurri>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VW_AZZURRI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VW_AZZURRI;

				if (pagination) {
					sql = sql.concat(VW_AzzurriModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VW_Azzurri>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VW_Azzurri>(list);
				}
				else {
					list = (List<VW_Azzurri>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v w_ azzurris from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VW_Azzurri vw_Azzurri : findAll()) {
			remove(vw_Azzurri);
		}
	}

	/**
	 * Returns the number of v w_ azzurris.
	 *
	 * @return the number of v w_ azzurris
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

				Query q = session.createQuery(_SQL_COUNT_VW_AZZURRI);

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
	 * Initializes the v w_ azzurri persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.VW_Azzurri")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VW_Azzurri>> listenersList = new ArrayList<ModelListener<VW_Azzurri>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VW_Azzurri>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VW_AzzurriImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VW_AZZURRI = "SELECT vw_Azzurri FROM VW_Azzurri vw_Azzurri";
	private static final String _SQL_COUNT_VW_AZZURRI = "SELECT COUNT(vw_Azzurri) FROM VW_Azzurri vw_Azzurri";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vw_Azzurri.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VW_Azzurri exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VW_AzzurriPersistenceImpl.class);
	private static VW_Azzurri _nullVW_Azzurri = new VW_AzzurriImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VW_Azzurri> toCacheModel() {
				return _nullVW_AzzurriCacheModel;
			}
		};

	private static CacheModel<VW_Azzurri> _nullVW_AzzurriCacheModel = new CacheModel<VW_Azzurri>() {
			@Override
			public VW_Azzurri toEntityModel() {
				return _nullVW_Azzurri;
			}
		};
}