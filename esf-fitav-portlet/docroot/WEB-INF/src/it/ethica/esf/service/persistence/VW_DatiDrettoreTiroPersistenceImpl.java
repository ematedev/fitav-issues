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

import it.ethica.esf.NoSuchVW_DatiDrettoreTiroException;
import it.ethica.esf.model.VW_DatiDrettoreTiro;
import it.ethica.esf.model.impl.VW_DatiDrettoreTiroImpl;
import it.ethica.esf.model.impl.VW_DatiDrettoreTiroModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v w_ dati drettore tiro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_DatiDrettoreTiroPersistence
 * @see VW_DatiDrettoreTiroUtil
 * @generated
 */
public class VW_DatiDrettoreTiroPersistenceImpl extends BasePersistenceImpl<VW_DatiDrettoreTiro>
	implements VW_DatiDrettoreTiroPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VW_DatiDrettoreTiroUtil} to access the v w_ dati drettore tiro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VW_DatiDrettoreTiroImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
			VW_DatiDrettoreTiroModelImpl.FINDER_CACHE_ENABLED,
			VW_DatiDrettoreTiroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
			VW_DatiDrettoreTiroModelImpl.FINDER_CACHE_ENABLED,
			VW_DatiDrettoreTiroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
			VW_DatiDrettoreTiroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID = new FinderPath(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
			VW_DatiDrettoreTiroModelImpl.FINDER_CACHE_ENABLED,
			VW_DatiDrettoreTiroImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByesfShootingDirectorId",
			new String[] { Long.class.getName() },
			VW_DatiDrettoreTiroModelImpl.ESFSHOOTINGDIRECTORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFSHOOTINGDIRECTORID = new FinderPath(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
			VW_DatiDrettoreTiroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByesfShootingDirectorId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the v w_ dati drettore tiro where esfShootingDirectorId = &#63; or throws a {@link it.ethica.esf.NoSuchVW_DatiDrettoreTiroException} if it could not be found.
	 *
	 * @param esfShootingDirectorId the esf shooting director ID
	 * @return the matching v w_ dati drettore tiro
	 * @throws it.ethica.esf.NoSuchVW_DatiDrettoreTiroException if a matching v w_ dati drettore tiro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro findByesfShootingDirectorId(
		long esfShootingDirectorId)
		throws NoSuchVW_DatiDrettoreTiroException, SystemException {
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro = fetchByesfShootingDirectorId(esfShootingDirectorId);

		if (vw_DatiDrettoreTiro == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfShootingDirectorId=");
			msg.append(esfShootingDirectorId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVW_DatiDrettoreTiroException(msg.toString());
		}

		return vw_DatiDrettoreTiro;
	}

	/**
	 * Returns the v w_ dati drettore tiro where esfShootingDirectorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfShootingDirectorId the esf shooting director ID
	 * @return the matching v w_ dati drettore tiro, or <code>null</code> if a matching v w_ dati drettore tiro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro fetchByesfShootingDirectorId(
		long esfShootingDirectorId) throws SystemException {
		return fetchByesfShootingDirectorId(esfShootingDirectorId, true);
	}

	/**
	 * Returns the v w_ dati drettore tiro where esfShootingDirectorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfShootingDirectorId the esf shooting director ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching v w_ dati drettore tiro, or <code>null</code> if a matching v w_ dati drettore tiro could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro fetchByesfShootingDirectorId(
		long esfShootingDirectorId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { esfShootingDirectorId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
					finderArgs, this);
		}

		if (result instanceof VW_DatiDrettoreTiro) {
			VW_DatiDrettoreTiro vw_DatiDrettoreTiro = (VW_DatiDrettoreTiro)result;

			if ((esfShootingDirectorId != vw_DatiDrettoreTiro.getEsfShootingDirectorId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_VW_DATIDRETTORETIRO_WHERE);

			query.append(_FINDER_COLUMN_ESFSHOOTINGDIRECTORID_ESFSHOOTINGDIRECTORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfShootingDirectorId);

				List<VW_DatiDrettoreTiro> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"VW_DatiDrettoreTiroPersistenceImpl.fetchByesfShootingDirectorId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					VW_DatiDrettoreTiro vw_DatiDrettoreTiro = list.get(0);

					result = vw_DatiDrettoreTiro;

					cacheResult(vw_DatiDrettoreTiro);

					if ((vw_DatiDrettoreTiro.getEsfShootingDirectorId() != esfShootingDirectorId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
							finderArgs, vw_DatiDrettoreTiro);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
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
			return (VW_DatiDrettoreTiro)result;
		}
	}

	/**
	 * Removes the v w_ dati drettore tiro where esfShootingDirectorId = &#63; from the database.
	 *
	 * @param esfShootingDirectorId the esf shooting director ID
	 * @return the v w_ dati drettore tiro that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro removeByesfShootingDirectorId(
		long esfShootingDirectorId)
		throws NoSuchVW_DatiDrettoreTiroException, SystemException {
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro = findByesfShootingDirectorId(esfShootingDirectorId);

		return remove(vw_DatiDrettoreTiro);
	}

	/**
	 * Returns the number of v w_ dati drettore tiros where esfShootingDirectorId = &#63;.
	 *
	 * @param esfShootingDirectorId the esf shooting director ID
	 * @return the number of matching v w_ dati drettore tiros
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfShootingDirectorId(long esfShootingDirectorId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFSHOOTINGDIRECTORID;

		Object[] finderArgs = new Object[] { esfShootingDirectorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VW_DATIDRETTORETIRO_WHERE);

			query.append(_FINDER_COLUMN_ESFSHOOTINGDIRECTORID_ESFSHOOTINGDIRECTORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfShootingDirectorId);

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

	private static final String _FINDER_COLUMN_ESFSHOOTINGDIRECTORID_ESFSHOOTINGDIRECTORID_2 =
		"vw_DatiDrettoreTiro.id.esfShootingDirectorId = ?";

	public VW_DatiDrettoreTiroPersistenceImpl() {
		setModelClass(VW_DatiDrettoreTiro.class);
	}

	/**
	 * Caches the v w_ dati drettore tiro in the entity cache if it is enabled.
	 *
	 * @param vw_DatiDrettoreTiro the v w_ dati drettore tiro
	 */
	@Override
	public void cacheResult(VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		EntityCacheUtil.putResult(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
			VW_DatiDrettoreTiroImpl.class, vw_DatiDrettoreTiro.getPrimaryKey(),
			vw_DatiDrettoreTiro);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
			new Object[] { vw_DatiDrettoreTiro.getEsfShootingDirectorId() },
			vw_DatiDrettoreTiro);

		vw_DatiDrettoreTiro.resetOriginalValues();
	}

	/**
	 * Caches the v w_ dati drettore tiros in the entity cache if it is enabled.
	 *
	 * @param vw_DatiDrettoreTiros the v w_ dati drettore tiros
	 */
	@Override
	public void cacheResult(List<VW_DatiDrettoreTiro> vw_DatiDrettoreTiros) {
		for (VW_DatiDrettoreTiro vw_DatiDrettoreTiro : vw_DatiDrettoreTiros) {
			if (EntityCacheUtil.getResult(
						VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
						VW_DatiDrettoreTiroImpl.class,
						vw_DatiDrettoreTiro.getPrimaryKey()) == null) {
				cacheResult(vw_DatiDrettoreTiro);
			}
			else {
				vw_DatiDrettoreTiro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v w_ dati drettore tiros.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VW_DatiDrettoreTiroImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VW_DatiDrettoreTiroImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v w_ dati drettore tiro.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		EntityCacheUtil.removeResult(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
			VW_DatiDrettoreTiroImpl.class, vw_DatiDrettoreTiro.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vw_DatiDrettoreTiro);
	}

	@Override
	public void clearCache(List<VW_DatiDrettoreTiro> vw_DatiDrettoreTiros) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VW_DatiDrettoreTiro vw_DatiDrettoreTiro : vw_DatiDrettoreTiros) {
			EntityCacheUtil.removeResult(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
				VW_DatiDrettoreTiroImpl.class,
				vw_DatiDrettoreTiro.getPrimaryKey());

			clearUniqueFindersCache(vw_DatiDrettoreTiro);
		}
	}

	protected void cacheUniqueFindersCache(
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		if (vw_DatiDrettoreTiro.isNew()) {
			Object[] args = new Object[] {
					vw_DatiDrettoreTiro.getEsfShootingDirectorId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFSHOOTINGDIRECTORID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
				args, vw_DatiDrettoreTiro);
		}
		else {
			VW_DatiDrettoreTiroModelImpl vw_DatiDrettoreTiroModelImpl = (VW_DatiDrettoreTiroModelImpl)vw_DatiDrettoreTiro;

			if ((vw_DatiDrettoreTiroModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vw_DatiDrettoreTiro.getEsfShootingDirectorId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFSHOOTINGDIRECTORID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
					args, vw_DatiDrettoreTiro);
			}
		}
	}

	protected void clearUniqueFindersCache(
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		VW_DatiDrettoreTiroModelImpl vw_DatiDrettoreTiroModelImpl = (VW_DatiDrettoreTiroModelImpl)vw_DatiDrettoreTiro;

		Object[] args = new Object[] {
				vw_DatiDrettoreTiro.getEsfShootingDirectorId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSHOOTINGDIRECTORID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
			args);

		if ((vw_DatiDrettoreTiroModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID.getColumnBitmask()) != 0) {
			args = new Object[] {
					vw_DatiDrettoreTiroModelImpl.getOriginalEsfShootingDirectorId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSHOOTINGDIRECTORID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFSHOOTINGDIRECTORID,
				args);
		}
	}

	/**
	 * Creates a new v w_ dati drettore tiro with the primary key. Does not add the v w_ dati drettore tiro to the database.
	 *
	 * @param vw_DatiDrettoreTiroPK the primary key for the new v w_ dati drettore tiro
	 * @return the new v w_ dati drettore tiro
	 */
	@Override
	public VW_DatiDrettoreTiro create(
		VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK) {
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro = new VW_DatiDrettoreTiroImpl();

		vw_DatiDrettoreTiro.setNew(true);
		vw_DatiDrettoreTiro.setPrimaryKey(vw_DatiDrettoreTiroPK);

		return vw_DatiDrettoreTiro;
	}

	/**
	 * Removes the v w_ dati drettore tiro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vw_DatiDrettoreTiroPK the primary key of the v w_ dati drettore tiro
	 * @return the v w_ dati drettore tiro that was removed
	 * @throws it.ethica.esf.NoSuchVW_DatiDrettoreTiroException if a v w_ dati drettore tiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro remove(
		VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK)
		throws NoSuchVW_DatiDrettoreTiroException, SystemException {
		return remove((Serializable)vw_DatiDrettoreTiroPK);
	}

	/**
	 * Removes the v w_ dati drettore tiro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v w_ dati drettore tiro
	 * @return the v w_ dati drettore tiro that was removed
	 * @throws it.ethica.esf.NoSuchVW_DatiDrettoreTiroException if a v w_ dati drettore tiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro remove(Serializable primaryKey)
		throws NoSuchVW_DatiDrettoreTiroException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VW_DatiDrettoreTiro vw_DatiDrettoreTiro = (VW_DatiDrettoreTiro)session.get(VW_DatiDrettoreTiroImpl.class,
					primaryKey);

			if (vw_DatiDrettoreTiro == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVW_DatiDrettoreTiroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vw_DatiDrettoreTiro);
		}
		catch (NoSuchVW_DatiDrettoreTiroException nsee) {
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
	protected VW_DatiDrettoreTiro removeImpl(
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro) throws SystemException {
		vw_DatiDrettoreTiro = toUnwrappedModel(vw_DatiDrettoreTiro);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vw_DatiDrettoreTiro)) {
				vw_DatiDrettoreTiro = (VW_DatiDrettoreTiro)session.get(VW_DatiDrettoreTiroImpl.class,
						vw_DatiDrettoreTiro.getPrimaryKeyObj());
			}

			if (vw_DatiDrettoreTiro != null) {
				session.delete(vw_DatiDrettoreTiro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vw_DatiDrettoreTiro != null) {
			clearCache(vw_DatiDrettoreTiro);
		}

		return vw_DatiDrettoreTiro;
	}

	@Override
	public VW_DatiDrettoreTiro updateImpl(
		it.ethica.esf.model.VW_DatiDrettoreTiro vw_DatiDrettoreTiro)
		throws SystemException {
		vw_DatiDrettoreTiro = toUnwrappedModel(vw_DatiDrettoreTiro);

		boolean isNew = vw_DatiDrettoreTiro.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vw_DatiDrettoreTiro.isNew()) {
				session.save(vw_DatiDrettoreTiro);

				vw_DatiDrettoreTiro.setNew(false);
			}
			else {
				session.merge(vw_DatiDrettoreTiro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VW_DatiDrettoreTiroModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
			VW_DatiDrettoreTiroImpl.class, vw_DatiDrettoreTiro.getPrimaryKey(),
			vw_DatiDrettoreTiro);

		clearUniqueFindersCache(vw_DatiDrettoreTiro);
		cacheUniqueFindersCache(vw_DatiDrettoreTiro);

		return vw_DatiDrettoreTiro;
	}

	protected VW_DatiDrettoreTiro toUnwrappedModel(
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		if (vw_DatiDrettoreTiro instanceof VW_DatiDrettoreTiroImpl) {
			return vw_DatiDrettoreTiro;
		}

		VW_DatiDrettoreTiroImpl vw_DatiDrettoreTiroImpl = new VW_DatiDrettoreTiroImpl();

		vw_DatiDrettoreTiroImpl.setNew(vw_DatiDrettoreTiro.isNew());
		vw_DatiDrettoreTiroImpl.setPrimaryKey(vw_DatiDrettoreTiro.getPrimaryKey());

		vw_DatiDrettoreTiroImpl.setEsfShootingDirectorId(vw_DatiDrettoreTiro.getEsfShootingDirectorId());
		vw_DatiDrettoreTiroImpl.setNome(vw_DatiDrettoreTiro.getNome());
		vw_DatiDrettoreTiroImpl.setCognome(vw_DatiDrettoreTiro.getCognome());
		vw_DatiDrettoreTiroImpl.setCodiceRegione(vw_DatiDrettoreTiro.getCodiceRegione());

		return vw_DatiDrettoreTiroImpl;
	}

	/**
	 * Returns the v w_ dati drettore tiro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ dati drettore tiro
	 * @return the v w_ dati drettore tiro
	 * @throws it.ethica.esf.NoSuchVW_DatiDrettoreTiroException if a v w_ dati drettore tiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVW_DatiDrettoreTiroException, SystemException {
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro = fetchByPrimaryKey(primaryKey);

		if (vw_DatiDrettoreTiro == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVW_DatiDrettoreTiroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vw_DatiDrettoreTiro;
	}

	/**
	 * Returns the v w_ dati drettore tiro with the primary key or throws a {@link it.ethica.esf.NoSuchVW_DatiDrettoreTiroException} if it could not be found.
	 *
	 * @param vw_DatiDrettoreTiroPK the primary key of the v w_ dati drettore tiro
	 * @return the v w_ dati drettore tiro
	 * @throws it.ethica.esf.NoSuchVW_DatiDrettoreTiroException if a v w_ dati drettore tiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro findByPrimaryKey(
		VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK)
		throws NoSuchVW_DatiDrettoreTiroException, SystemException {
		return findByPrimaryKey((Serializable)vw_DatiDrettoreTiroPK);
	}

	/**
	 * Returns the v w_ dati drettore tiro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ dati drettore tiro
	 * @return the v w_ dati drettore tiro, or <code>null</code> if a v w_ dati drettore tiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro = (VW_DatiDrettoreTiro)EntityCacheUtil.getResult(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
				VW_DatiDrettoreTiroImpl.class, primaryKey);

		if (vw_DatiDrettoreTiro == _nullVW_DatiDrettoreTiro) {
			return null;
		}

		if (vw_DatiDrettoreTiro == null) {
			Session session = null;

			try {
				session = openSession();

				vw_DatiDrettoreTiro = (VW_DatiDrettoreTiro)session.get(VW_DatiDrettoreTiroImpl.class,
						primaryKey);

				if (vw_DatiDrettoreTiro != null) {
					cacheResult(vw_DatiDrettoreTiro);
				}
				else {
					EntityCacheUtil.putResult(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
						VW_DatiDrettoreTiroImpl.class, primaryKey,
						_nullVW_DatiDrettoreTiro);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VW_DatiDrettoreTiroModelImpl.ENTITY_CACHE_ENABLED,
					VW_DatiDrettoreTiroImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vw_DatiDrettoreTiro;
	}

	/**
	 * Returns the v w_ dati drettore tiro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vw_DatiDrettoreTiroPK the primary key of the v w_ dati drettore tiro
	 * @return the v w_ dati drettore tiro, or <code>null</code> if a v w_ dati drettore tiro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_DatiDrettoreTiro fetchByPrimaryKey(
		VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)vw_DatiDrettoreTiroPK);
	}

	/**
	 * Returns all the v w_ dati drettore tiros.
	 *
	 * @return the v w_ dati drettore tiros
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_DatiDrettoreTiro> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v w_ dati drettore tiros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_DatiDrettoreTiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ dati drettore tiros
	 * @param end the upper bound of the range of v w_ dati drettore tiros (not inclusive)
	 * @return the range of v w_ dati drettore tiros
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_DatiDrettoreTiro> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v w_ dati drettore tiros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_DatiDrettoreTiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ dati drettore tiros
	 * @param end the upper bound of the range of v w_ dati drettore tiros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v w_ dati drettore tiros
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_DatiDrettoreTiro> findAll(int start, int end,
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

		List<VW_DatiDrettoreTiro> list = (List<VW_DatiDrettoreTiro>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VW_DATIDRETTORETIRO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VW_DATIDRETTORETIRO;

				if (pagination) {
					sql = sql.concat(VW_DatiDrettoreTiroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VW_DatiDrettoreTiro>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VW_DatiDrettoreTiro>(list);
				}
				else {
					list = (List<VW_DatiDrettoreTiro>)QueryUtil.list(q,
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
	 * Removes all the v w_ dati drettore tiros from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VW_DatiDrettoreTiro vw_DatiDrettoreTiro : findAll()) {
			remove(vw_DatiDrettoreTiro);
		}
	}

	/**
	 * Returns the number of v w_ dati drettore tiros.
	 *
	 * @return the number of v w_ dati drettore tiros
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

				Query q = session.createQuery(_SQL_COUNT_VW_DATIDRETTORETIRO);

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
	 * Initializes the v w_ dati drettore tiro persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.VW_DatiDrettoreTiro")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VW_DatiDrettoreTiro>> listenersList = new ArrayList<ModelListener<VW_DatiDrettoreTiro>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VW_DatiDrettoreTiro>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VW_DatiDrettoreTiroImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VW_DATIDRETTORETIRO = "SELECT vw_DatiDrettoreTiro FROM VW_DatiDrettoreTiro vw_DatiDrettoreTiro";
	private static final String _SQL_SELECT_VW_DATIDRETTORETIRO_WHERE = "SELECT vw_DatiDrettoreTiro FROM VW_DatiDrettoreTiro vw_DatiDrettoreTiro WHERE ";
	private static final String _SQL_COUNT_VW_DATIDRETTORETIRO = "SELECT COUNT(vw_DatiDrettoreTiro) FROM VW_DatiDrettoreTiro vw_DatiDrettoreTiro";
	private static final String _SQL_COUNT_VW_DATIDRETTORETIRO_WHERE = "SELECT COUNT(vw_DatiDrettoreTiro) FROM VW_DatiDrettoreTiro vw_DatiDrettoreTiro WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vw_DatiDrettoreTiro.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VW_DatiDrettoreTiro exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VW_DatiDrettoreTiro exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VW_DatiDrettoreTiroPersistenceImpl.class);
	private static VW_DatiDrettoreTiro _nullVW_DatiDrettoreTiro = new VW_DatiDrettoreTiroImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VW_DatiDrettoreTiro> toCacheModel() {
				return _nullVW_DatiDrettoreTiroCacheModel;
			}
		};

	private static CacheModel<VW_DatiDrettoreTiro> _nullVW_DatiDrettoreTiroCacheModel =
		new CacheModel<VW_DatiDrettoreTiro>() {
			@Override
			public VW_DatiDrettoreTiro toEntityModel() {
				return _nullVW_DatiDrettoreTiro;
			}
		};
}