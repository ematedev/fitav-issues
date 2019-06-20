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

import it.ethica.esf.NoSuchRadunoAzzurriException;
import it.ethica.esf.model.ESFRadunoAzzurri;
import it.ethica.esf.model.impl.ESFRadunoAzzurriImpl;
import it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f raduno azzurri service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoAzzurriPersistence
 * @see ESFRadunoAzzurriUtil
 * @generated
 */
public class ESFRadunoAzzurriPersistenceImpl extends BasePersistenceImpl<ESFRadunoAzzurri>
	implements ESFRadunoAzzurriPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFRadunoAzzurriUtil} to access the e s f raduno azzurri persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFRadunoAzzurriImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoAzzurriModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoAzzurriImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoAzzurriModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoAzzurriImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoAzzurriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI = new FinderPath(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoAzzurriModelImpl.FINDER_CACHE_ENABLED,
			ESFRadunoAzzurriImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByfindRadunoAzzurri",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFRadunoAzzurriModelImpl.ID_ESF_RADUNO_COLUMN_BITMASK |
			ESFRadunoAzzurriModelImpl.ESFNATIONALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDRADUNOAZZURRI = new FinderPath(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoAzzurriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindRadunoAzzurri",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f raduno azzurri where id_esf_raduno = &#63; and esfNationalId = &#63; or throws a {@link it.ethica.esf.NoSuchRadunoAzzurriException} if it could not be found.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param esfNationalId the esf national ID
	 * @return the matching e s f raduno azzurri
	 * @throws it.ethica.esf.NoSuchRadunoAzzurriException if a matching e s f raduno azzurri could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri findByfindRadunoAzzurri(long id_esf_raduno,
		long esfNationalId)
		throws NoSuchRadunoAzzurriException, SystemException {
		ESFRadunoAzzurri esfRadunoAzzurri = fetchByfindRadunoAzzurri(id_esf_raduno,
				esfNationalId);

		if (esfRadunoAzzurri == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id_esf_raduno=");
			msg.append(id_esf_raduno);

			msg.append(", esfNationalId=");
			msg.append(esfNationalId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRadunoAzzurriException(msg.toString());
		}

		return esfRadunoAzzurri;
	}

	/**
	 * Returns the e s f raduno azzurri where id_esf_raduno = &#63; and esfNationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param esfNationalId the esf national ID
	 * @return the matching e s f raduno azzurri, or <code>null</code> if a matching e s f raduno azzurri could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri fetchByfindRadunoAzzurri(long id_esf_raduno,
		long esfNationalId) throws SystemException {
		return fetchByfindRadunoAzzurri(id_esf_raduno, esfNationalId, true);
	}

	/**
	 * Returns the e s f raduno azzurri where id_esf_raduno = &#63; and esfNationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param esfNationalId the esf national ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f raduno azzurri, or <code>null</code> if a matching e s f raduno azzurri could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri fetchByfindRadunoAzzurri(long id_esf_raduno,
		long esfNationalId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id_esf_raduno, esfNationalId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
					finderArgs, this);
		}

		if (result instanceof ESFRadunoAzzurri) {
			ESFRadunoAzzurri esfRadunoAzzurri = (ESFRadunoAzzurri)result;

			if ((id_esf_raduno != esfRadunoAzzurri.getId_esf_raduno()) ||
					(esfNationalId != esfRadunoAzzurri.getEsfNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFRADUNOAZZURRI_WHERE);

			query.append(_FINDER_COLUMN_FINDRADUNOAZZURRI_ID_ESF_RADUNO_2);

			query.append(_FINDER_COLUMN_FINDRADUNOAZZURRI_ESFNATIONALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				qPos.add(esfNationalId);

				List<ESFRadunoAzzurri> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFRadunoAzzurriPersistenceImpl.fetchByfindRadunoAzzurri(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFRadunoAzzurri esfRadunoAzzurri = list.get(0);

					result = esfRadunoAzzurri;

					cacheResult(esfRadunoAzzurri);

					if ((esfRadunoAzzurri.getId_esf_raduno() != id_esf_raduno) ||
							(esfRadunoAzzurri.getEsfNationalId() != esfNationalId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
							finderArgs, esfRadunoAzzurri);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
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
			return (ESFRadunoAzzurri)result;
		}
	}

	/**
	 * Removes the e s f raduno azzurri where id_esf_raduno = &#63; and esfNationalId = &#63; from the database.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param esfNationalId the esf national ID
	 * @return the e s f raduno azzurri that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri removeByfindRadunoAzzurri(long id_esf_raduno,
		long esfNationalId)
		throws NoSuchRadunoAzzurriException, SystemException {
		ESFRadunoAzzurri esfRadunoAzzurri = findByfindRadunoAzzurri(id_esf_raduno,
				esfNationalId);

		return remove(esfRadunoAzzurri);
	}

	/**
	 * Returns the number of e s f raduno azzurris where id_esf_raduno = &#63; and esfNationalId = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param esfNationalId the esf national ID
	 * @return the number of matching e s f raduno azzurris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindRadunoAzzurri(long id_esf_raduno, long esfNationalId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDRADUNOAZZURRI;

		Object[] finderArgs = new Object[] { id_esf_raduno, esfNationalId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRADUNOAZZURRI_WHERE);

			query.append(_FINDER_COLUMN_FINDRADUNOAZZURRI_ID_ESF_RADUNO_2);

			query.append(_FINDER_COLUMN_FINDRADUNOAZZURRI_ESFNATIONALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				qPos.add(esfNationalId);

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

	private static final String _FINDER_COLUMN_FINDRADUNOAZZURRI_ID_ESF_RADUNO_2 =
		"esfRadunoAzzurri.id.id_esf_raduno = ? AND ";
	private static final String _FINDER_COLUMN_FINDRADUNOAZZURRI_ESFNATIONALID_2 =
		"esfRadunoAzzurri.id.esfNationalId = ?";

	public ESFRadunoAzzurriPersistenceImpl() {
		setModelClass(ESFRadunoAzzurri.class);
	}

	/**
	 * Caches the e s f raduno azzurri in the entity cache if it is enabled.
	 *
	 * @param esfRadunoAzzurri the e s f raduno azzurri
	 */
	@Override
	public void cacheResult(ESFRadunoAzzurri esfRadunoAzzurri) {
		EntityCacheUtil.putResult(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoAzzurriImpl.class, esfRadunoAzzurri.getPrimaryKey(),
			esfRadunoAzzurri);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
			new Object[] {
				esfRadunoAzzurri.getId_esf_raduno(),
				esfRadunoAzzurri.getEsfNationalId()
			}, esfRadunoAzzurri);

		esfRadunoAzzurri.resetOriginalValues();
	}

	/**
	 * Caches the e s f raduno azzurris in the entity cache if it is enabled.
	 *
	 * @param esfRadunoAzzurris the e s f raduno azzurris
	 */
	@Override
	public void cacheResult(List<ESFRadunoAzzurri> esfRadunoAzzurris) {
		for (ESFRadunoAzzurri esfRadunoAzzurri : esfRadunoAzzurris) {
			if (EntityCacheUtil.getResult(
						ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoAzzurriImpl.class,
						esfRadunoAzzurri.getPrimaryKey()) == null) {
				cacheResult(esfRadunoAzzurri);
			}
			else {
				esfRadunoAzzurri.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f raduno azzurris.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFRadunoAzzurriImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFRadunoAzzurriImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f raduno azzurri.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFRadunoAzzurri esfRadunoAzzurri) {
		EntityCacheUtil.removeResult(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoAzzurriImpl.class, esfRadunoAzzurri.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfRadunoAzzurri);
	}

	@Override
	public void clearCache(List<ESFRadunoAzzurri> esfRadunoAzzurris) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFRadunoAzzurri esfRadunoAzzurri : esfRadunoAzzurris) {
			EntityCacheUtil.removeResult(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoAzzurriImpl.class, esfRadunoAzzurri.getPrimaryKey());

			clearUniqueFindersCache(esfRadunoAzzurri);
		}
	}

	protected void cacheUniqueFindersCache(ESFRadunoAzzurri esfRadunoAzzurri) {
		if (esfRadunoAzzurri.isNew()) {
			Object[] args = new Object[] {
					esfRadunoAzzurri.getId_esf_raduno(),
					esfRadunoAzzurri.getEsfNationalId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDRADUNOAZZURRI,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
				args, esfRadunoAzzurri);
		}
		else {
			ESFRadunoAzzurriModelImpl esfRadunoAzzurriModelImpl = (ESFRadunoAzzurriModelImpl)esfRadunoAzzurri;

			if ((esfRadunoAzzurriModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRadunoAzzurri.getId_esf_raduno(),
						esfRadunoAzzurri.getEsfNationalId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDRADUNOAZZURRI,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
					args, esfRadunoAzzurri);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFRadunoAzzurri esfRadunoAzzurri) {
		ESFRadunoAzzurriModelImpl esfRadunoAzzurriModelImpl = (ESFRadunoAzzurriModelImpl)esfRadunoAzzurri;

		Object[] args = new Object[] {
				esfRadunoAzzurri.getId_esf_raduno(),
				esfRadunoAzzurri.getEsfNationalId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDRADUNOAZZURRI,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
			args);

		if ((esfRadunoAzzurriModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfRadunoAzzurriModelImpl.getOriginalId_esf_raduno(),
					esfRadunoAzzurriModelImpl.getOriginalEsfNationalId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDRADUNOAZZURRI,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOAZZURRI,
				args);
		}
	}

	/**
	 * Creates a new e s f raduno azzurri with the primary key. Does not add the e s f raduno azzurri to the database.
	 *
	 * @param esfRadunoAzzurriPK the primary key for the new e s f raduno azzurri
	 * @return the new e s f raduno azzurri
	 */
	@Override
	public ESFRadunoAzzurri create(ESFRadunoAzzurriPK esfRadunoAzzurriPK) {
		ESFRadunoAzzurri esfRadunoAzzurri = new ESFRadunoAzzurriImpl();

		esfRadunoAzzurri.setNew(true);
		esfRadunoAzzurri.setPrimaryKey(esfRadunoAzzurriPK);

		return esfRadunoAzzurri;
	}

	/**
	 * Removes the e s f raduno azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	 * @return the e s f raduno azzurri that was removed
	 * @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri remove(ESFRadunoAzzurriPK esfRadunoAzzurriPK)
		throws NoSuchRadunoAzzurriException, SystemException {
		return remove((Serializable)esfRadunoAzzurriPK);
	}

	/**
	 * Removes the e s f raduno azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f raduno azzurri
	 * @return the e s f raduno azzurri that was removed
	 * @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri remove(Serializable primaryKey)
		throws NoSuchRadunoAzzurriException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFRadunoAzzurri esfRadunoAzzurri = (ESFRadunoAzzurri)session.get(ESFRadunoAzzurriImpl.class,
					primaryKey);

			if (esfRadunoAzzurri == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRadunoAzzurriException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRadunoAzzurri);
		}
		catch (NoSuchRadunoAzzurriException nsee) {
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
	protected ESFRadunoAzzurri removeImpl(ESFRadunoAzzurri esfRadunoAzzurri)
		throws SystemException {
		esfRadunoAzzurri = toUnwrappedModel(esfRadunoAzzurri);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRadunoAzzurri)) {
				esfRadunoAzzurri = (ESFRadunoAzzurri)session.get(ESFRadunoAzzurriImpl.class,
						esfRadunoAzzurri.getPrimaryKeyObj());
			}

			if (esfRadunoAzzurri != null) {
				session.delete(esfRadunoAzzurri);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRadunoAzzurri != null) {
			clearCache(esfRadunoAzzurri);
		}

		return esfRadunoAzzurri;
	}

	@Override
	public ESFRadunoAzzurri updateImpl(
		it.ethica.esf.model.ESFRadunoAzzurri esfRadunoAzzurri)
		throws SystemException {
		esfRadunoAzzurri = toUnwrappedModel(esfRadunoAzzurri);

		boolean isNew = esfRadunoAzzurri.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfRadunoAzzurri.isNew()) {
				session.save(esfRadunoAzzurri);

				esfRadunoAzzurri.setNew(false);
			}
			else {
				session.merge(esfRadunoAzzurri);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFRadunoAzzurriModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
			ESFRadunoAzzurriImpl.class, esfRadunoAzzurri.getPrimaryKey(),
			esfRadunoAzzurri);

		clearUniqueFindersCache(esfRadunoAzzurri);
		cacheUniqueFindersCache(esfRadunoAzzurri);

		return esfRadunoAzzurri;
	}

	protected ESFRadunoAzzurri toUnwrappedModel(
		ESFRadunoAzzurri esfRadunoAzzurri) {
		if (esfRadunoAzzurri instanceof ESFRadunoAzzurriImpl) {
			return esfRadunoAzzurri;
		}

		ESFRadunoAzzurriImpl esfRadunoAzzurriImpl = new ESFRadunoAzzurriImpl();

		esfRadunoAzzurriImpl.setNew(esfRadunoAzzurri.isNew());
		esfRadunoAzzurriImpl.setPrimaryKey(esfRadunoAzzurri.getPrimaryKey());

		esfRadunoAzzurriImpl.setId_esf_raduno_azzurri(esfRadunoAzzurri.getId_esf_raduno_azzurri());
		esfRadunoAzzurriImpl.setId_esf_raduno(esfRadunoAzzurri.getId_esf_raduno());
		esfRadunoAzzurriImpl.setEsfNationalId(esfRadunoAzzurri.getEsfNationalId());

		return esfRadunoAzzurriImpl;
	}

	/**
	 * Returns the e s f raduno azzurri with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno azzurri
	 * @return the e s f raduno azzurri
	 * @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRadunoAzzurriException, SystemException {
		ESFRadunoAzzurri esfRadunoAzzurri = fetchByPrimaryKey(primaryKey);

		if (esfRadunoAzzurri == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRadunoAzzurriException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRadunoAzzurri;
	}

	/**
	 * Returns the e s f raduno azzurri with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoAzzurriException} if it could not be found.
	 *
	 * @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	 * @return the e s f raduno azzurri
	 * @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri findByPrimaryKey(
		ESFRadunoAzzurriPK esfRadunoAzzurriPK)
		throws NoSuchRadunoAzzurriException, SystemException {
		return findByPrimaryKey((Serializable)esfRadunoAzzurriPK);
	}

	/**
	 * Returns the e s f raduno azzurri with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f raduno azzurri
	 * @return the e s f raduno azzurri, or <code>null</code> if a e s f raduno azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFRadunoAzzurri esfRadunoAzzurri = (ESFRadunoAzzurri)EntityCacheUtil.getResult(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
				ESFRadunoAzzurriImpl.class, primaryKey);

		if (esfRadunoAzzurri == _nullESFRadunoAzzurri) {
			return null;
		}

		if (esfRadunoAzzurri == null) {
			Session session = null;

			try {
				session = openSession();

				esfRadunoAzzurri = (ESFRadunoAzzurri)session.get(ESFRadunoAzzurriImpl.class,
						primaryKey);

				if (esfRadunoAzzurri != null) {
					cacheResult(esfRadunoAzzurri);
				}
				else {
					EntityCacheUtil.putResult(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
						ESFRadunoAzzurriImpl.class, primaryKey,
						_nullESFRadunoAzzurri);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFRadunoAzzurriModelImpl.ENTITY_CACHE_ENABLED,
					ESFRadunoAzzurriImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRadunoAzzurri;
	}

	/**
	 * Returns the e s f raduno azzurri with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	 * @return the e s f raduno azzurri, or <code>null</code> if a e s f raduno azzurri with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFRadunoAzzurri fetchByPrimaryKey(
		ESFRadunoAzzurriPK esfRadunoAzzurriPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfRadunoAzzurriPK);
	}

	/**
	 * Returns all the e s f raduno azzurris.
	 *
	 * @return the e s f raduno azzurris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoAzzurri> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f raduno azzurris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno azzurris
	 * @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	 * @return the range of e s f raduno azzurris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoAzzurri> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f raduno azzurris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f raduno azzurris
	 * @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f raduno azzurris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFRadunoAzzurri> findAll(int start, int end,
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

		List<ESFRadunoAzzurri> list = (List<ESFRadunoAzzurri>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRADUNOAZZURRI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRADUNOAZZURRI;

				if (pagination) {
					sql = sql.concat(ESFRadunoAzzurriModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFRadunoAzzurri>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFRadunoAzzurri>(list);
				}
				else {
					list = (List<ESFRadunoAzzurri>)QueryUtil.list(q,
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
	 * Removes all the e s f raduno azzurris from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFRadunoAzzurri esfRadunoAzzurri : findAll()) {
			remove(esfRadunoAzzurri);
		}
	}

	/**
	 * Returns the number of e s f raduno azzurris.
	 *
	 * @return the number of e s f raduno azzurris
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

				Query q = session.createQuery(_SQL_COUNT_ESFRADUNOAZZURRI);

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
	 * Initializes the e s f raduno azzurri persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFRadunoAzzurri")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFRadunoAzzurri>> listenersList = new ArrayList<ModelListener<ESFRadunoAzzurri>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFRadunoAzzurri>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFRadunoAzzurriImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRADUNOAZZURRI = "SELECT esfRadunoAzzurri FROM ESFRadunoAzzurri esfRadunoAzzurri";
	private static final String _SQL_SELECT_ESFRADUNOAZZURRI_WHERE = "SELECT esfRadunoAzzurri FROM ESFRadunoAzzurri esfRadunoAzzurri WHERE ";
	private static final String _SQL_COUNT_ESFRADUNOAZZURRI = "SELECT COUNT(esfRadunoAzzurri) FROM ESFRadunoAzzurri esfRadunoAzzurri";
	private static final String _SQL_COUNT_ESFRADUNOAZZURRI_WHERE = "SELECT COUNT(esfRadunoAzzurri) FROM ESFRadunoAzzurri esfRadunoAzzurri WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRadunoAzzurri.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFRadunoAzzurri exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFRadunoAzzurri exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFRadunoAzzurriPersistenceImpl.class);
	private static ESFRadunoAzzurri _nullESFRadunoAzzurri = new ESFRadunoAzzurriImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFRadunoAzzurri> toCacheModel() {
				return _nullESFRadunoAzzurriCacheModel;
			}
		};

	private static CacheModel<ESFRadunoAzzurri> _nullESFRadunoAzzurriCacheModel = new CacheModel<ESFRadunoAzzurri>() {
			@Override
			public ESFRadunoAzzurri toEntityModel() {
				return _nullESFRadunoAzzurri;
			}
		};
}