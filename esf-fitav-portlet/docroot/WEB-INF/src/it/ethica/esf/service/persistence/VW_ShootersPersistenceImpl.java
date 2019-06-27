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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchVW_ShootersException;
import it.ethica.esf.model.VW_Shooters;
import it.ethica.esf.model.impl.VW_ShootersImpl;
import it.ethica.esf.model.impl.VW_ShootersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v w_ shooters service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ShootersPersistence
 * @see VW_ShootersUtil
 * @generated
 */
public class VW_ShootersPersistenceImpl extends BasePersistenceImpl<VW_Shooters>
	implements VW_ShootersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VW_ShootersUtil} to access the v w_ shooters persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VW_ShootersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
			VW_ShootersModelImpl.FINDER_CACHE_ENABLED, VW_ShootersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
			VW_ShootersModelImpl.FINDER_CACHE_ENABLED, VW_ShootersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
			VW_ShootersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDBYUSERID = new FinderPath(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
			VW_ShootersModelImpl.FINDER_CACHE_ENABLED, VW_ShootersImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByUserId",
			new String[] { Long.class.getName() },
			VW_ShootersModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYUSERID = new FinderPath(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
			VW_ShootersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the v w_ shooters where userId = &#63; or throws a {@link it.ethica.esf.NoSuchVW_ShootersException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching v w_ shooters
	 * @throws it.ethica.esf.NoSuchVW_ShootersException if a matching v w_ shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters findByfindByUserId(long userId)
		throws NoSuchVW_ShootersException, SystemException {
		VW_Shooters vw_Shooters = fetchByfindByUserId(userId);

		if (vw_Shooters == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVW_ShootersException(msg.toString());
		}

		return vw_Shooters;
	}

	/**
	 * Returns the v w_ shooters where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching v w_ shooters, or <code>null</code> if a matching v w_ shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters fetchByfindByUserId(long userId)
		throws SystemException {
		return fetchByfindByUserId(userId, true);
	}

	/**
	 * Returns the v w_ shooters where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching v w_ shooters, or <code>null</code> if a matching v w_ shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters fetchByfindByUserId(long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
					finderArgs, this);
		}

		if (result instanceof VW_Shooters) {
			VW_Shooters vw_Shooters = (VW_Shooters)result;

			if ((userId != vw_Shooters.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_VW_SHOOTERS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<VW_Shooters> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"VW_ShootersPersistenceImpl.fetchByfindByUserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					VW_Shooters vw_Shooters = list.get(0);

					result = vw_Shooters;

					cacheResult(vw_Shooters);

					if ((vw_Shooters.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
							finderArgs, vw_Shooters);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
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
			return (VW_Shooters)result;
		}
	}

	/**
	 * Removes the v w_ shooters where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the v w_ shooters that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters removeByfindByUserId(long userId)
		throws NoSuchVW_ShootersException, SystemException {
		VW_Shooters vw_Shooters = findByfindByUserId(userId);

		return remove(vw_Shooters);
	}

	/**
	 * Returns the number of v w_ shooterses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching v w_ shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYUSERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VW_SHOOTERS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_FINDBYUSERID_USERID_2 = "vw_Shooters.id.userId = ?";

	public VW_ShootersPersistenceImpl() {
		setModelClass(VW_Shooters.class);
	}

	/**
	 * Caches the v w_ shooters in the entity cache if it is enabled.
	 *
	 * @param vw_Shooters the v w_ shooters
	 */
	@Override
	public void cacheResult(VW_Shooters vw_Shooters) {
		EntityCacheUtil.putResult(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
			VW_ShootersImpl.class, vw_Shooters.getPrimaryKey(), vw_Shooters);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
			new Object[] { vw_Shooters.getUserId() }, vw_Shooters);

		vw_Shooters.resetOriginalValues();
	}

	/**
	 * Caches the v w_ shooterses in the entity cache if it is enabled.
	 *
	 * @param vw_Shooterses the v w_ shooterses
	 */
	@Override
	public void cacheResult(List<VW_Shooters> vw_Shooterses) {
		for (VW_Shooters vw_Shooters : vw_Shooterses) {
			if (EntityCacheUtil.getResult(
						VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
						VW_ShootersImpl.class, vw_Shooters.getPrimaryKey()) == null) {
				cacheResult(vw_Shooters);
			}
			else {
				vw_Shooters.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v w_ shooterses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VW_ShootersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VW_ShootersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v w_ shooters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VW_Shooters vw_Shooters) {
		EntityCacheUtil.removeResult(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
			VW_ShootersImpl.class, vw_Shooters.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vw_Shooters);
	}

	@Override
	public void clearCache(List<VW_Shooters> vw_Shooterses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VW_Shooters vw_Shooters : vw_Shooterses) {
			EntityCacheUtil.removeResult(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
				VW_ShootersImpl.class, vw_Shooters.getPrimaryKey());

			clearUniqueFindersCache(vw_Shooters);
		}
	}

	protected void cacheUniqueFindersCache(VW_Shooters vw_Shooters) {
		if (vw_Shooters.isNew()) {
			Object[] args = new Object[] { vw_Shooters.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYUSERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID, args,
				vw_Shooters);
		}
		else {
			VW_ShootersModelImpl vw_ShootersModelImpl = (VW_ShootersModelImpl)vw_Shooters;

			if ((vw_ShootersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDBYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vw_Shooters.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYUSERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
					args, vw_Shooters);
			}
		}
	}

	protected void clearUniqueFindersCache(VW_Shooters vw_Shooters) {
		VW_ShootersModelImpl vw_ShootersModelImpl = (VW_ShootersModelImpl)vw_Shooters;

		Object[] args = new Object[] { vw_Shooters.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYUSERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYUSERID, args);

		if ((vw_ShootersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDBYUSERID.getColumnBitmask()) != 0) {
			args = new Object[] { vw_ShootersModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYUSERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYUSERID, args);
		}
	}

	/**
	 * Creates a new v w_ shooters with the primary key. Does not add the v w_ shooters to the database.
	 *
	 * @param vw_ShootersPK the primary key for the new v w_ shooters
	 * @return the new v w_ shooters
	 */
	@Override
	public VW_Shooters create(VW_ShootersPK vw_ShootersPK) {
		VW_Shooters vw_Shooters = new VW_ShootersImpl();

		vw_Shooters.setNew(true);
		vw_Shooters.setPrimaryKey(vw_ShootersPK);

		return vw_Shooters;
	}

	/**
	 * Removes the v w_ shooters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vw_ShootersPK the primary key of the v w_ shooters
	 * @return the v w_ shooters that was removed
	 * @throws it.ethica.esf.NoSuchVW_ShootersException if a v w_ shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters remove(VW_ShootersPK vw_ShootersPK)
		throws NoSuchVW_ShootersException, SystemException {
		return remove((Serializable)vw_ShootersPK);
	}

	/**
	 * Removes the v w_ shooters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v w_ shooters
	 * @return the v w_ shooters that was removed
	 * @throws it.ethica.esf.NoSuchVW_ShootersException if a v w_ shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters remove(Serializable primaryKey)
		throws NoSuchVW_ShootersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VW_Shooters vw_Shooters = (VW_Shooters)session.get(VW_ShootersImpl.class,
					primaryKey);

			if (vw_Shooters == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVW_ShootersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vw_Shooters);
		}
		catch (NoSuchVW_ShootersException nsee) {
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
	protected VW_Shooters removeImpl(VW_Shooters vw_Shooters)
		throws SystemException {
		vw_Shooters = toUnwrappedModel(vw_Shooters);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vw_Shooters)) {
				vw_Shooters = (VW_Shooters)session.get(VW_ShootersImpl.class,
						vw_Shooters.getPrimaryKeyObj());
			}

			if (vw_Shooters != null) {
				session.delete(vw_Shooters);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vw_Shooters != null) {
			clearCache(vw_Shooters);
		}

		return vw_Shooters;
	}

	@Override
	public VW_Shooters updateImpl(it.ethica.esf.model.VW_Shooters vw_Shooters)
		throws SystemException {
		vw_Shooters = toUnwrappedModel(vw_Shooters);

		boolean isNew = vw_Shooters.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vw_Shooters.isNew()) {
				session.save(vw_Shooters);

				vw_Shooters.setNew(false);
			}
			else {
				session.merge(vw_Shooters);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VW_ShootersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
			VW_ShootersImpl.class, vw_Shooters.getPrimaryKey(), vw_Shooters);

		clearUniqueFindersCache(vw_Shooters);
		cacheUniqueFindersCache(vw_Shooters);

		return vw_Shooters;
	}

	protected VW_Shooters toUnwrappedModel(VW_Shooters vw_Shooters) {
		if (vw_Shooters instanceof VW_ShootersImpl) {
			return vw_Shooters;
		}

		VW_ShootersImpl vw_ShootersImpl = new VW_ShootersImpl();

		vw_ShootersImpl.setNew(vw_Shooters.isNew());
		vw_ShootersImpl.setPrimaryKey(vw_Shooters.getPrimaryKey());

		vw_ShootersImpl.setUserId(vw_Shooters.getUserId());
		vw_ShootersImpl.setCodiceTessera(vw_Shooters.getCodiceTessera());
		vw_ShootersImpl.setCodiceOrganizzazione(vw_Shooters.getCodiceOrganizzazione());
		vw_ShootersImpl.setNome(vw_Shooters.getNome());
		vw_ShootersImpl.setCognome(vw_Shooters.getCognome());
		vw_ShootersImpl.setEmail(vw_Shooters.getEmail());
		vw_ShootersImpl.setCF(vw_Shooters.getCF());
		vw_ShootersImpl.setOrganizationId(vw_Shooters.getOrganizationId());
		vw_ShootersImpl.setInvitato(vw_Shooters.getInvitato());

		return vw_ShootersImpl;
	}

	/**
	 * Returns the v w_ shooters with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ shooters
	 * @return the v w_ shooters
	 * @throws it.ethica.esf.NoSuchVW_ShootersException if a v w_ shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVW_ShootersException, SystemException {
		VW_Shooters vw_Shooters = fetchByPrimaryKey(primaryKey);

		if (vw_Shooters == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVW_ShootersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vw_Shooters;
	}

	/**
	 * Returns the v w_ shooters with the primary key or throws a {@link it.ethica.esf.NoSuchVW_ShootersException} if it could not be found.
	 *
	 * @param vw_ShootersPK the primary key of the v w_ shooters
	 * @return the v w_ shooters
	 * @throws it.ethica.esf.NoSuchVW_ShootersException if a v w_ shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters findByPrimaryKey(VW_ShootersPK vw_ShootersPK)
		throws NoSuchVW_ShootersException, SystemException {
		return findByPrimaryKey((Serializable)vw_ShootersPK);
	}

	/**
	 * Returns the v w_ shooters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ shooters
	 * @return the v w_ shooters, or <code>null</code> if a v w_ shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VW_Shooters vw_Shooters = (VW_Shooters)EntityCacheUtil.getResult(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
				VW_ShootersImpl.class, primaryKey);

		if (vw_Shooters == _nullVW_Shooters) {
			return null;
		}

		if (vw_Shooters == null) {
			Session session = null;

			try {
				session = openSession();

				vw_Shooters = (VW_Shooters)session.get(VW_ShootersImpl.class,
						primaryKey);

				if (vw_Shooters != null) {
					cacheResult(vw_Shooters);
				}
				else {
					EntityCacheUtil.putResult(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
						VW_ShootersImpl.class, primaryKey, _nullVW_Shooters);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VW_ShootersModelImpl.ENTITY_CACHE_ENABLED,
					VW_ShootersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vw_Shooters;
	}

	/**
	 * Returns the v w_ shooters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vw_ShootersPK the primary key of the v w_ shooters
	 * @return the v w_ shooters, or <code>null</code> if a v w_ shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Shooters fetchByPrimaryKey(VW_ShootersPK vw_ShootersPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vw_ShootersPK);
	}

	/**
	 * Returns all the v w_ shooterses.
	 *
	 * @return the v w_ shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Shooters> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v w_ shooterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ shooterses
	 * @param end the upper bound of the range of v w_ shooterses (not inclusive)
	 * @return the range of v w_ shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Shooters> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v w_ shooterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ shooterses
	 * @param end the upper bound of the range of v w_ shooterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v w_ shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Shooters> findAll(int start, int end,
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

		List<VW_Shooters> list = (List<VW_Shooters>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VW_SHOOTERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VW_SHOOTERS;

				if (pagination) {
					sql = sql.concat(VW_ShootersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VW_Shooters>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VW_Shooters>(list);
				}
				else {
					list = (List<VW_Shooters>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v w_ shooterses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VW_Shooters vw_Shooters : findAll()) {
			remove(vw_Shooters);
		}
	}

	/**
	 * Returns the number of v w_ shooterses.
	 *
	 * @return the number of v w_ shooterses
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

				Query q = session.createQuery(_SQL_COUNT_VW_SHOOTERS);

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
	 * Initializes the v w_ shooters persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.VW_Shooters")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VW_Shooters>> listenersList = new ArrayList<ModelListener<VW_Shooters>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VW_Shooters>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VW_ShootersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VW_SHOOTERS = "SELECT vw_Shooters FROM VW_Shooters vw_Shooters";
	private static final String _SQL_SELECT_VW_SHOOTERS_WHERE = "SELECT vw_Shooters FROM VW_Shooters vw_Shooters WHERE ";
	private static final String _SQL_COUNT_VW_SHOOTERS = "SELECT COUNT(vw_Shooters) FROM VW_Shooters vw_Shooters";
	private static final String _SQL_COUNT_VW_SHOOTERS_WHERE = "SELECT COUNT(vw_Shooters) FROM VW_Shooters vw_Shooters WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vw_Shooters.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VW_Shooters exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VW_Shooters exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VW_ShootersPersistenceImpl.class);
	private static VW_Shooters _nullVW_Shooters = new VW_ShootersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VW_Shooters> toCacheModel() {
				return _nullVW_ShootersCacheModel;
			}
		};

	private static CacheModel<VW_Shooters> _nullVW_ShootersCacheModel = new CacheModel<VW_Shooters>() {
			@Override
			public VW_Shooters toEntityModel() {
				return _nullVW_Shooters;
			}
		};
}