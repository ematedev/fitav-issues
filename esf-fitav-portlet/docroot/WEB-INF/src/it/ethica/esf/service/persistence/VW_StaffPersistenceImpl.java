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

import it.ethica.esf.NoSuchVW_StaffException;
import it.ethica.esf.model.VW_Staff;
import it.ethica.esf.model.impl.VW_StaffImpl;
import it.ethica.esf.model.impl.VW_StaffModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v w_ staff service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_StaffPersistence
 * @see VW_StaffUtil
 * @generated
 */
public class VW_StaffPersistenceImpl extends BasePersistenceImpl<VW_Staff>
	implements VW_StaffPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VW_StaffUtil} to access the v w_ staff persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VW_StaffImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
			VW_StaffModelImpl.FINDER_CACHE_ENABLED, VW_StaffImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
			VW_StaffModelImpl.FINDER_CACHE_ENABLED, VW_StaffImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
			VW_StaffModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDBYUSERID = new FinderPath(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
			VW_StaffModelImpl.FINDER_CACHE_ENABLED, VW_StaffImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByUserId",
			new String[] { Long.class.getName() },
			VW_StaffModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYUSERID = new FinderPath(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
			VW_StaffModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the v w_ staff where userId = &#63; or throws a {@link it.ethica.esf.NoSuchVW_StaffException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching v w_ staff
	 * @throws it.ethica.esf.NoSuchVW_StaffException if a matching v w_ staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff findByfindByUserId(long userId)
		throws NoSuchVW_StaffException, SystemException {
		VW_Staff vw_Staff = fetchByfindByUserId(userId);

		if (vw_Staff == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVW_StaffException(msg.toString());
		}

		return vw_Staff;
	}

	/**
	 * Returns the v w_ staff where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching v w_ staff, or <code>null</code> if a matching v w_ staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff fetchByfindByUserId(long userId) throws SystemException {
		return fetchByfindByUserId(userId, true);
	}

	/**
	 * Returns the v w_ staff where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching v w_ staff, or <code>null</code> if a matching v w_ staff could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff fetchByfindByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
					finderArgs, this);
		}

		if (result instanceof VW_Staff) {
			VW_Staff vw_Staff = (VW_Staff)result;

			if ((userId != vw_Staff.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_VW_STAFF_WHERE);

			query.append(_FINDER_COLUMN_FINDBYUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<VW_Staff> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"VW_StaffPersistenceImpl.fetchByfindByUserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					VW_Staff vw_Staff = list.get(0);

					result = vw_Staff;

					cacheResult(vw_Staff);

					if ((vw_Staff.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
							finderArgs, vw_Staff);
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
			return (VW_Staff)result;
		}
	}

	/**
	 * Removes the v w_ staff where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the v w_ staff that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff removeByfindByUserId(long userId)
		throws NoSuchVW_StaffException, SystemException {
		VW_Staff vw_Staff = findByfindByUserId(userId);

		return remove(vw_Staff);
	}

	/**
	 * Returns the number of v w_ staffs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching v w_ staffs
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

			query.append(_SQL_COUNT_VW_STAFF_WHERE);

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

	private static final String _FINDER_COLUMN_FINDBYUSERID_USERID_2 = "vw_Staff.id.userId = ?";

	public VW_StaffPersistenceImpl() {
		setModelClass(VW_Staff.class);
	}

	/**
	 * Caches the v w_ staff in the entity cache if it is enabled.
	 *
	 * @param vw_Staff the v w_ staff
	 */
	@Override
	public void cacheResult(VW_Staff vw_Staff) {
		EntityCacheUtil.putResult(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
			VW_StaffImpl.class, vw_Staff.getPrimaryKey(), vw_Staff);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
			new Object[] { vw_Staff.getUserId() }, vw_Staff);

		vw_Staff.resetOriginalValues();
	}

	/**
	 * Caches the v w_ staffs in the entity cache if it is enabled.
	 *
	 * @param vw_Staffs the v w_ staffs
	 */
	@Override
	public void cacheResult(List<VW_Staff> vw_Staffs) {
		for (VW_Staff vw_Staff : vw_Staffs) {
			if (EntityCacheUtil.getResult(
						VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
						VW_StaffImpl.class, vw_Staff.getPrimaryKey()) == null) {
				cacheResult(vw_Staff);
			}
			else {
				vw_Staff.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v w_ staffs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VW_StaffImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VW_StaffImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v w_ staff.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VW_Staff vw_Staff) {
		EntityCacheUtil.removeResult(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
			VW_StaffImpl.class, vw_Staff.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vw_Staff);
	}

	@Override
	public void clearCache(List<VW_Staff> vw_Staffs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VW_Staff vw_Staff : vw_Staffs) {
			EntityCacheUtil.removeResult(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
				VW_StaffImpl.class, vw_Staff.getPrimaryKey());

			clearUniqueFindersCache(vw_Staff);
		}
	}

	protected void cacheUniqueFindersCache(VW_Staff vw_Staff) {
		if (vw_Staff.isNew()) {
			Object[] args = new Object[] { vw_Staff.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYUSERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID, args,
				vw_Staff);
		}
		else {
			VW_StaffModelImpl vw_StaffModelImpl = (VW_StaffModelImpl)vw_Staff;

			if ((vw_StaffModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDBYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vw_Staff.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYUSERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYUSERID,
					args, vw_Staff);
			}
		}
	}

	protected void clearUniqueFindersCache(VW_Staff vw_Staff) {
		VW_StaffModelImpl vw_StaffModelImpl = (VW_StaffModelImpl)vw_Staff;

		Object[] args = new Object[] { vw_Staff.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYUSERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYUSERID, args);

		if ((vw_StaffModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDBYUSERID.getColumnBitmask()) != 0) {
			args = new Object[] { vw_StaffModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYUSERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYUSERID, args);
		}
	}

	/**
	 * Creates a new v w_ staff with the primary key. Does not add the v w_ staff to the database.
	 *
	 * @param vw_StaffPK the primary key for the new v w_ staff
	 * @return the new v w_ staff
	 */
	@Override
	public VW_Staff create(VW_StaffPK vw_StaffPK) {
		VW_Staff vw_Staff = new VW_StaffImpl();

		vw_Staff.setNew(true);
		vw_Staff.setPrimaryKey(vw_StaffPK);

		return vw_Staff;
	}

	/**
	 * Removes the v w_ staff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vw_StaffPK the primary key of the v w_ staff
	 * @return the v w_ staff that was removed
	 * @throws it.ethica.esf.NoSuchVW_StaffException if a v w_ staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff remove(VW_StaffPK vw_StaffPK)
		throws NoSuchVW_StaffException, SystemException {
		return remove((Serializable)vw_StaffPK);
	}

	/**
	 * Removes the v w_ staff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v w_ staff
	 * @return the v w_ staff that was removed
	 * @throws it.ethica.esf.NoSuchVW_StaffException if a v w_ staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff remove(Serializable primaryKey)
		throws NoSuchVW_StaffException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VW_Staff vw_Staff = (VW_Staff)session.get(VW_StaffImpl.class,
					primaryKey);

			if (vw_Staff == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVW_StaffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vw_Staff);
		}
		catch (NoSuchVW_StaffException nsee) {
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
	protected VW_Staff removeImpl(VW_Staff vw_Staff) throws SystemException {
		vw_Staff = toUnwrappedModel(vw_Staff);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vw_Staff)) {
				vw_Staff = (VW_Staff)session.get(VW_StaffImpl.class,
						vw_Staff.getPrimaryKeyObj());
			}

			if (vw_Staff != null) {
				session.delete(vw_Staff);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vw_Staff != null) {
			clearCache(vw_Staff);
		}

		return vw_Staff;
	}

	@Override
	public VW_Staff updateImpl(it.ethica.esf.model.VW_Staff vw_Staff)
		throws SystemException {
		vw_Staff = toUnwrappedModel(vw_Staff);

		boolean isNew = vw_Staff.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vw_Staff.isNew()) {
				session.save(vw_Staff);

				vw_Staff.setNew(false);
			}
			else {
				session.merge(vw_Staff);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VW_StaffModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
			VW_StaffImpl.class, vw_Staff.getPrimaryKey(), vw_Staff);

		clearUniqueFindersCache(vw_Staff);
		cacheUniqueFindersCache(vw_Staff);

		return vw_Staff;
	}

	protected VW_Staff toUnwrappedModel(VW_Staff vw_Staff) {
		if (vw_Staff instanceof VW_StaffImpl) {
			return vw_Staff;
		}

		VW_StaffImpl vw_StaffImpl = new VW_StaffImpl();

		vw_StaffImpl.setNew(vw_Staff.isNew());
		vw_StaffImpl.setPrimaryKey(vw_Staff.getPrimaryKey());

		vw_StaffImpl.setUserId(vw_Staff.getUserId());
		vw_StaffImpl.setEmailAddress(vw_Staff.getEmailAddress());
		vw_StaffImpl.setFirstName(vw_Staff.getFirstName());
		vw_StaffImpl.setLastName(vw_Staff.getLastName());
		vw_StaffImpl.setCreateDate(vw_Staff.getCreateDate());
		vw_StaffImpl.setEsfStartData(vw_Staff.getEsfStartData());
		vw_StaffImpl.setEsfEndData(vw_Staff.getEsfEndData());
		vw_StaffImpl.setRegionId(vw_Staff.getRegionId());
		vw_StaffImpl.setProvinceId(vw_Staff.getProvinceId());
		vw_StaffImpl.setEsfShootingDirectorQualificationDesc(vw_Staff.getEsfShootingDirectorQualificationDesc());
		vw_StaffImpl.setEsfSportTypeId(vw_Staff.getEsfSportTypeId());
		vw_StaffImpl.setName(vw_Staff.getName());
		vw_StaffImpl.setInvitato(vw_Staff.getInvitato());

		return vw_StaffImpl;
	}

	/**
	 * Returns the v w_ staff with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ staff
	 * @return the v w_ staff
	 * @throws it.ethica.esf.NoSuchVW_StaffException if a v w_ staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVW_StaffException, SystemException {
		VW_Staff vw_Staff = fetchByPrimaryKey(primaryKey);

		if (vw_Staff == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVW_StaffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vw_Staff;
	}

	/**
	 * Returns the v w_ staff with the primary key or throws a {@link it.ethica.esf.NoSuchVW_StaffException} if it could not be found.
	 *
	 * @param vw_StaffPK the primary key of the v w_ staff
	 * @return the v w_ staff
	 * @throws it.ethica.esf.NoSuchVW_StaffException if a v w_ staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff findByPrimaryKey(VW_StaffPK vw_StaffPK)
		throws NoSuchVW_StaffException, SystemException {
		return findByPrimaryKey((Serializable)vw_StaffPK);
	}

	/**
	 * Returns the v w_ staff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ staff
	 * @return the v w_ staff, or <code>null</code> if a v w_ staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VW_Staff vw_Staff = (VW_Staff)EntityCacheUtil.getResult(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
				VW_StaffImpl.class, primaryKey);

		if (vw_Staff == _nullVW_Staff) {
			return null;
		}

		if (vw_Staff == null) {
			Session session = null;

			try {
				session = openSession();

				vw_Staff = (VW_Staff)session.get(VW_StaffImpl.class, primaryKey);

				if (vw_Staff != null) {
					cacheResult(vw_Staff);
				}
				else {
					EntityCacheUtil.putResult(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
						VW_StaffImpl.class, primaryKey, _nullVW_Staff);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VW_StaffModelImpl.ENTITY_CACHE_ENABLED,
					VW_StaffImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vw_Staff;
	}

	/**
	 * Returns the v w_ staff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vw_StaffPK the primary key of the v w_ staff
	 * @return the v w_ staff, or <code>null</code> if a v w_ staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_Staff fetchByPrimaryKey(VW_StaffPK vw_StaffPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vw_StaffPK);
	}

	/**
	 * Returns all the v w_ staffs.
	 *
	 * @return the v w_ staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Staff> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v w_ staffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ staffs
	 * @param end the upper bound of the range of v w_ staffs (not inclusive)
	 * @return the range of v w_ staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Staff> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v w_ staffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ staffs
	 * @param end the upper bound of the range of v w_ staffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v w_ staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_Staff> findAll(int start, int end,
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

		List<VW_Staff> list = (List<VW_Staff>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VW_STAFF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VW_STAFF;

				if (pagination) {
					sql = sql.concat(VW_StaffModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VW_Staff>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VW_Staff>(list);
				}
				else {
					list = (List<VW_Staff>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v w_ staffs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VW_Staff vw_Staff : findAll()) {
			remove(vw_Staff);
		}
	}

	/**
	 * Returns the number of v w_ staffs.
	 *
	 * @return the number of v w_ staffs
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

				Query q = session.createQuery(_SQL_COUNT_VW_STAFF);

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
	 * Initializes the v w_ staff persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.VW_Staff")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VW_Staff>> listenersList = new ArrayList<ModelListener<VW_Staff>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VW_Staff>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VW_StaffImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VW_STAFF = "SELECT vw_Staff FROM VW_Staff vw_Staff";
	private static final String _SQL_SELECT_VW_STAFF_WHERE = "SELECT vw_Staff FROM VW_Staff vw_Staff WHERE ";
	private static final String _SQL_COUNT_VW_STAFF = "SELECT COUNT(vw_Staff) FROM VW_Staff vw_Staff";
	private static final String _SQL_COUNT_VW_STAFF_WHERE = "SELECT COUNT(vw_Staff) FROM VW_Staff vw_Staff WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vw_Staff.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VW_Staff exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VW_Staff exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VW_StaffPersistenceImpl.class);
	private static VW_Staff _nullVW_Staff = new VW_StaffImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VW_Staff> toCacheModel() {
				return _nullVW_StaffCacheModel;
			}
		};

	private static CacheModel<VW_Staff> _nullVW_StaffCacheModel = new CacheModel<VW_Staff>() {
			@Override
			public VW_Staff toEntityModel() {
				return _nullVW_Staff;
			}
		};
}