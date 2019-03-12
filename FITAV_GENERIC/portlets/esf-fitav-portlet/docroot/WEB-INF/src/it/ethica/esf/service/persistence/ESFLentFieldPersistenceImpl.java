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

import it.ethica.esf.NoSuchLentFieldException;
import it.ethica.esf.model.ESFLentField;
import it.ethica.esf.model.impl.ESFLentFieldImpl;
import it.ethica.esf.model.impl.ESFLentFieldModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f lent field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFLentFieldPersistence
 * @see ESFLentFieldUtil
 * @generated
 */
public class ESFLentFieldPersistenceImpl extends BasePersistenceImpl<ESFLentField>
	implements ESFLentFieldPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFLentFieldUtil} to access the e s f lent field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFLentFieldImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFLentFieldModelImpl.FINDER_CACHE_ENABLED, ESFLentFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFLentFieldModelImpl.FINDER_CACHE_ENABLED, ESFLentFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFLentFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_F_S = new FinderPath(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFLentFieldModelImpl.FINDER_CACHE_ENABLED, ESFLentFieldImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByF_S",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFLentFieldModelImpl.ESFFIELDID_COLUMN_BITMASK |
			ESFLentFieldModelImpl.ESFENTITYSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_F_S = new FinderPath(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFLentFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByF_S",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or throws a {@link it.ethica.esf.NoSuchLentFieldException} if it could not be found.
	 *
	 * @param esfFieldId the esf field ID
	 * @param esfEntityStateId the esf entity state ID
	 * @return the matching e s f lent field
	 * @throws it.ethica.esf.NoSuchLentFieldException if a matching e s f lent field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField findByF_S(long esfFieldId, long esfEntityStateId)
		throws NoSuchLentFieldException, SystemException {
		ESFLentField esfLentField = fetchByF_S(esfFieldId, esfEntityStateId);

		if (esfLentField == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfFieldId=");
			msg.append(esfFieldId);

			msg.append(", esfEntityStateId=");
			msg.append(esfEntityStateId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLentFieldException(msg.toString());
		}

		return esfLentField;
	}

	/**
	 * Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfFieldId the esf field ID
	 * @param esfEntityStateId the esf entity state ID
	 * @return the matching e s f lent field, or <code>null</code> if a matching e s f lent field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField fetchByF_S(long esfFieldId, long esfEntityStateId)
		throws SystemException {
		return fetchByF_S(esfFieldId, esfEntityStateId, true);
	}

	/**
	 * Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfFieldId the esf field ID
	 * @param esfEntityStateId the esf entity state ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f lent field, or <code>null</code> if a matching e s f lent field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField fetchByF_S(long esfFieldId, long esfEntityStateId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { esfFieldId, esfEntityStateId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_F_S,
					finderArgs, this);
		}

		if (result instanceof ESFLentField) {
			ESFLentField esfLentField = (ESFLentField)result;

			if ((esfFieldId != esfLentField.getEsfFieldId()) ||
					(esfEntityStateId != esfLentField.getEsfEntityStateId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFLENTFIELD_WHERE);

			query.append(_FINDER_COLUMN_F_S_ESFFIELDID_2);

			query.append(_FINDER_COLUMN_F_S_ESFENTITYSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFieldId);

				qPos.add(esfEntityStateId);

				List<ESFLentField> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFLentFieldPersistenceImpl.fetchByF_S(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFLentField esfLentField = list.get(0);

					result = esfLentField;

					cacheResult(esfLentField);

					if ((esfLentField.getEsfFieldId() != esfFieldId) ||
							(esfLentField.getEsfEntityStateId() != esfEntityStateId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S,
							finderArgs, esfLentField);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_F_S,
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
			return (ESFLentField)result;
		}
	}

	/**
	 * Removes the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; from the database.
	 *
	 * @param esfFieldId the esf field ID
	 * @param esfEntityStateId the esf entity state ID
	 * @return the e s f lent field that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField removeByF_S(long esfFieldId, long esfEntityStateId)
		throws NoSuchLentFieldException, SystemException {
		ESFLentField esfLentField = findByF_S(esfFieldId, esfEntityStateId);

		return remove(esfLentField);
	}

	/**
	 * Returns the number of e s f lent fields where esfFieldId = &#63; and esfEntityStateId = &#63;.
	 *
	 * @param esfFieldId the esf field ID
	 * @param esfEntityStateId the esf entity state ID
	 * @return the number of matching e s f lent fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByF_S(long esfFieldId, long esfEntityStateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_F_S;

		Object[] finderArgs = new Object[] { esfFieldId, esfEntityStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFLENTFIELD_WHERE);

			query.append(_FINDER_COLUMN_F_S_ESFFIELDID_2);

			query.append(_FINDER_COLUMN_F_S_ESFENTITYSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFieldId);

				qPos.add(esfEntityStateId);

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

	private static final String _FINDER_COLUMN_F_S_ESFFIELDID_2 = "esfLentField.esfFieldId = ? AND ";
	private static final String _FINDER_COLUMN_F_S_ESFENTITYSTATEID_2 = "esfLentField.esfEntityStateId = ?";

	public ESFLentFieldPersistenceImpl() {
		setModelClass(ESFLentField.class);
	}

	/**
	 * Caches the e s f lent field in the entity cache if it is enabled.
	 *
	 * @param esfLentField the e s f lent field
	 */
	@Override
	public void cacheResult(ESFLentField esfLentField) {
		EntityCacheUtil.putResult(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFLentFieldImpl.class, esfLentField.getPrimaryKey(), esfLentField);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S,
			new Object[] {
				esfLentField.getEsfFieldId(), esfLentField.getEsfEntityStateId()
			}, esfLentField);

		esfLentField.resetOriginalValues();
	}

	/**
	 * Caches the e s f lent fields in the entity cache if it is enabled.
	 *
	 * @param esfLentFields the e s f lent fields
	 */
	@Override
	public void cacheResult(List<ESFLentField> esfLentFields) {
		for (ESFLentField esfLentField : esfLentFields) {
			if (EntityCacheUtil.getResult(
						ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
						ESFLentFieldImpl.class, esfLentField.getPrimaryKey()) == null) {
				cacheResult(esfLentField);
			}
			else {
				esfLentField.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f lent fields.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFLentFieldImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFLentFieldImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f lent field.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFLentField esfLentField) {
		EntityCacheUtil.removeResult(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFLentFieldImpl.class, esfLentField.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfLentField);
	}

	@Override
	public void clearCache(List<ESFLentField> esfLentFields) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFLentField esfLentField : esfLentFields) {
			EntityCacheUtil.removeResult(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
				ESFLentFieldImpl.class, esfLentField.getPrimaryKey());

			clearUniqueFindersCache(esfLentField);
		}
	}

	protected void cacheUniqueFindersCache(ESFLentField esfLentField) {
		if (esfLentField.isNew()) {
			Object[] args = new Object[] {
					esfLentField.getEsfFieldId(),
					esfLentField.getEsfEntityStateId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_F_S, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S, args,
				esfLentField);
		}
		else {
			ESFLentFieldModelImpl esfLentFieldModelImpl = (ESFLentFieldModelImpl)esfLentField;

			if ((esfLentFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_F_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfLentField.getEsfFieldId(),
						esfLentField.getEsfEntityStateId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_F_S, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S, args,
					esfLentField);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFLentField esfLentField) {
		ESFLentFieldModelImpl esfLentFieldModelImpl = (ESFLentFieldModelImpl)esfLentField;

		Object[] args = new Object[] {
				esfLentField.getEsfFieldId(), esfLentField.getEsfEntityStateId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_S, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_F_S, args);

		if ((esfLentFieldModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_F_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfLentFieldModelImpl.getOriginalEsfFieldId(),
					esfLentFieldModelImpl.getOriginalEsfEntityStateId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_S, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_F_S, args);
		}
	}

	/**
	 * Creates a new e s f lent field with the primary key. Does not add the e s f lent field to the database.
	 *
	 * @param lentFieldId the primary key for the new e s f lent field
	 * @return the new e s f lent field
	 */
	@Override
	public ESFLentField create(long lentFieldId) {
		ESFLentField esfLentField = new ESFLentFieldImpl();

		esfLentField.setNew(true);
		esfLentField.setPrimaryKey(lentFieldId);

		return esfLentField;
	}

	/**
	 * Removes the e s f lent field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lentFieldId the primary key of the e s f lent field
	 * @return the e s f lent field that was removed
	 * @throws it.ethica.esf.NoSuchLentFieldException if a e s f lent field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField remove(long lentFieldId)
		throws NoSuchLentFieldException, SystemException {
		return remove((Serializable)lentFieldId);
	}

	/**
	 * Removes the e s f lent field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f lent field
	 * @return the e s f lent field that was removed
	 * @throws it.ethica.esf.NoSuchLentFieldException if a e s f lent field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField remove(Serializable primaryKey)
		throws NoSuchLentFieldException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFLentField esfLentField = (ESFLentField)session.get(ESFLentFieldImpl.class,
					primaryKey);

			if (esfLentField == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLentFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfLentField);
		}
		catch (NoSuchLentFieldException nsee) {
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
	protected ESFLentField removeImpl(ESFLentField esfLentField)
		throws SystemException {
		esfLentField = toUnwrappedModel(esfLentField);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfLentField)) {
				esfLentField = (ESFLentField)session.get(ESFLentFieldImpl.class,
						esfLentField.getPrimaryKeyObj());
			}

			if (esfLentField != null) {
				session.delete(esfLentField);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfLentField != null) {
			clearCache(esfLentField);
		}

		return esfLentField;
	}

	@Override
	public ESFLentField updateImpl(
		it.ethica.esf.model.ESFLentField esfLentField)
		throws SystemException {
		esfLentField = toUnwrappedModel(esfLentField);

		boolean isNew = esfLentField.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfLentField.isNew()) {
				session.save(esfLentField);

				esfLentField.setNew(false);
			}
			else {
				session.merge(esfLentField);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFLentFieldModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
			ESFLentFieldImpl.class, esfLentField.getPrimaryKey(), esfLentField);

		clearUniqueFindersCache(esfLentField);
		cacheUniqueFindersCache(esfLentField);

		return esfLentField;
	}

	protected ESFLentField toUnwrappedModel(ESFLentField esfLentField) {
		if (esfLentField instanceof ESFLentFieldImpl) {
			return esfLentField;
		}

		ESFLentFieldImpl esfLentFieldImpl = new ESFLentFieldImpl();

		esfLentFieldImpl.setNew(esfLentField.isNew());
		esfLentFieldImpl.setPrimaryKey(esfLentField.getPrimaryKey());

		esfLentFieldImpl.setLentFieldId(esfLentField.getLentFieldId());
		esfLentFieldImpl.setEsfEntityStateId(esfLentField.getEsfEntityStateId());
		esfLentFieldImpl.setEsfFieldId(esfLentField.getEsfFieldId());
		esfLentFieldImpl.setRealOwnerId(esfLentField.getRealOwnerId());
		esfLentFieldImpl.setActualOwnerId(esfLentField.getActualOwnerId());

		return esfLentFieldImpl;
	}

	/**
	 * Returns the e s f lent field with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f lent field
	 * @return the e s f lent field
	 * @throws it.ethica.esf.NoSuchLentFieldException if a e s f lent field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLentFieldException, SystemException {
		ESFLentField esfLentField = fetchByPrimaryKey(primaryKey);

		if (esfLentField == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLentFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfLentField;
	}

	/**
	 * Returns the e s f lent field with the primary key or throws a {@link it.ethica.esf.NoSuchLentFieldException} if it could not be found.
	 *
	 * @param lentFieldId the primary key of the e s f lent field
	 * @return the e s f lent field
	 * @throws it.ethica.esf.NoSuchLentFieldException if a e s f lent field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField findByPrimaryKey(long lentFieldId)
		throws NoSuchLentFieldException, SystemException {
		return findByPrimaryKey((Serializable)lentFieldId);
	}

	/**
	 * Returns the e s f lent field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f lent field
	 * @return the e s f lent field, or <code>null</code> if a e s f lent field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFLentField esfLentField = (ESFLentField)EntityCacheUtil.getResult(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
				ESFLentFieldImpl.class, primaryKey);

		if (esfLentField == _nullESFLentField) {
			return null;
		}

		if (esfLentField == null) {
			Session session = null;

			try {
				session = openSession();

				esfLentField = (ESFLentField)session.get(ESFLentFieldImpl.class,
						primaryKey);

				if (esfLentField != null) {
					cacheResult(esfLentField);
				}
				else {
					EntityCacheUtil.putResult(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
						ESFLentFieldImpl.class, primaryKey, _nullESFLentField);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFLentFieldModelImpl.ENTITY_CACHE_ENABLED,
					ESFLentFieldImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfLentField;
	}

	/**
	 * Returns the e s f lent field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lentFieldId the primary key of the e s f lent field
	 * @return the e s f lent field, or <code>null</code> if a e s f lent field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFLentField fetchByPrimaryKey(long lentFieldId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)lentFieldId);
	}

	/**
	 * Returns all the e s f lent fields.
	 *
	 * @return the e s f lent fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFLentField> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f lent fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFLentFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f lent fields
	 * @param end the upper bound of the range of e s f lent fields (not inclusive)
	 * @return the range of e s f lent fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFLentField> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f lent fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFLentFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f lent fields
	 * @param end the upper bound of the range of e s f lent fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f lent fields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFLentField> findAll(int start, int end,
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

		List<ESFLentField> list = (List<ESFLentField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFLENTFIELD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFLENTFIELD;

				if (pagination) {
					sql = sql.concat(ESFLentFieldModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFLentField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFLentField>(list);
				}
				else {
					list = (List<ESFLentField>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f lent fields from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFLentField esfLentField : findAll()) {
			remove(esfLentField);
		}
	}

	/**
	 * Returns the number of e s f lent fields.
	 *
	 * @return the number of e s f lent fields
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

				Query q = session.createQuery(_SQL_COUNT_ESFLENTFIELD);

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
	 * Initializes the e s f lent field persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFLentField")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFLentField>> listenersList = new ArrayList<ModelListener<ESFLentField>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFLentField>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFLentFieldImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFLENTFIELD = "SELECT esfLentField FROM ESFLentField esfLentField";
	private static final String _SQL_SELECT_ESFLENTFIELD_WHERE = "SELECT esfLentField FROM ESFLentField esfLentField WHERE ";
	private static final String _SQL_COUNT_ESFLENTFIELD = "SELECT COUNT(esfLentField) FROM ESFLentField esfLentField";
	private static final String _SQL_COUNT_ESFLENTFIELD_WHERE = "SELECT COUNT(esfLentField) FROM ESFLentField esfLentField WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfLentField.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFLentField exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFLentField exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFLentFieldPersistenceImpl.class);
	private static ESFLentField _nullESFLentField = new ESFLentFieldImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFLentField> toCacheModel() {
				return _nullESFLentFieldCacheModel;
			}
		};

	private static CacheModel<ESFLentField> _nullESFLentFieldCacheModel = new CacheModel<ESFLentField>() {
			@Override
			public ESFLentField toEntityModel() {
				return _nullESFLentField;
			}
		};
}