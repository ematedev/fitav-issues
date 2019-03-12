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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchEntityStateException;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFEntityStateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f entity state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFEntityStatePersistence
 * @see ESFEntityStateUtil
 * @generated
 */
public class ESFEntityStatePersistenceImpl extends BasePersistenceImpl<ESFEntityState>
	implements ESFEntityStatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFEntityStateUtil} to access the e s f entity state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFEntityStateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByESFEntityStateC_PK",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFEntityStateModelImpl.CLASSNAME_COLUMN_BITMASK |
			ESFEntityStateModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFEntityStateC_PK",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByESFEntityStateC_PK(String className,
		long classPK) throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = fetchByESFEntityStateC_PK(className,
				classPK);

		if (esfEntityState == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntityStateException(msg.toString());
		}

		return esfEntityState;
	}

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByESFEntityStateC_PK(String className,
		long classPK) throws SystemException {
		return fetchByESFEntityStateC_PK(className, classPK, true);
	}

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByESFEntityStateC_PK(String className,
		long classPK, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { className, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
					finderArgs, this);
		}

		if (result instanceof ESFEntityState) {
			ESFEntityState esfEntityState = (ESFEntityState)result;

			if (!Validator.equals(className, esfEntityState.getClassName()) ||
					(classPK != esfEntityState.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				List<ESFEntityState> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFEntityStatePersistenceImpl.fetchByESFEntityStateC_PK(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFEntityState esfEntityState = list.get(0);

					result = esfEntityState;

					cacheResult(esfEntityState);

					if ((esfEntityState.getClassName() == null) ||
							!esfEntityState.getClassName().equals(className) ||
							(esfEntityState.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
							finderArgs, esfEntityState);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
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
			return (ESFEntityState)result;
		}
	}

	/**
	 * Removes the e s f entity state where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the e s f entity state that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState removeByESFEntityStateC_PK(String className,
		long classPK) throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = findByESFEntityStateC_PK(className,
				classPK);

		return remove(esfEntityState);
	}

	/**
	 * Returns the number of e s f entity states where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFEntityStateC_PK(String className, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK;

		Object[] finderArgs = new Object[] { className, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_1 = "esfEntityState.className IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_2 = "esfEntityState.className = ? AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSNAME_3 = "(esfEntityState.className IS NULL OR esfEntityState.className = '') AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_CLASSPK_2 = "esfEntityState.classPK = ? AND esfEntityState.endDate is null";
	public static final FinderPath FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByESFEntityStateC_PK_S",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			ESFEntityStateModelImpl.CLASSNAME_COLUMN_BITMASK |
			ESFEntityStateModelImpl.CLASSPK_COLUMN_BITMASK |
			ESFEntityStateModelImpl.ESFSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK_S = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFEntityStateC_PK_S",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param esfStateId the esf state ID
	 * @return the matching e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByESFEntityStateC_PK_S(String className,
		long classPK, long esfStateId)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = fetchByESFEntityStateC_PK_S(className,
				classPK, esfStateId);

		if (esfEntityState == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(", esfStateId=");
			msg.append(esfStateId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntityStateException(msg.toString());
		}

		return esfEntityState;
	}

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param esfStateId the esf state ID
	 * @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByESFEntityStateC_PK_S(String className,
		long classPK, long esfStateId) throws SystemException {
		return fetchByESFEntityStateC_PK_S(className, classPK, esfStateId, true);
	}

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param esfStateId the esf state ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByESFEntityStateC_PK_S(String className,
		long classPK, long esfStateId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { className, classPK, esfStateId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
					finderArgs, this);
		}

		if (result instanceof ESFEntityState) {
			ESFEntityState esfEntityState = (ESFEntityState)result;

			if (!Validator.equals(className, esfEntityState.getClassName()) ||
					(classPK != esfEntityState.getClassPK()) ||
					(esfStateId != esfEntityState.getEsfStateId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSPK_2);

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_ESFSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				qPos.add(esfStateId);

				List<ESFEntityState> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFEntityStatePersistenceImpl.fetchByESFEntityStateC_PK_S(String, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFEntityState esfEntityState = list.get(0);

					result = esfEntityState;

					cacheResult(esfEntityState);

					if ((esfEntityState.getClassName() == null) ||
							!esfEntityState.getClassName().equals(className) ||
							(esfEntityState.getClassPK() != classPK) ||
							(esfEntityState.getEsfStateId() != esfStateId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
							finderArgs, esfEntityState);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
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
			return (ESFEntityState)result;
		}
	}

	/**
	 * Removes the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param esfStateId the esf state ID
	 * @return the e s f entity state that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState removeByESFEntityStateC_PK_S(String className,
		long classPK, long esfStateId)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = findByESFEntityStateC_PK_S(className,
				classPK, esfStateId);

		return remove(esfEntityState);
	}

	/**
	 * Returns the number of e s f entity states where className = &#63; and classPK = &#63; and esfStateId = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param esfStateId the esf state ID
	 * @return the number of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFEntityStateC_PK_S(String className, long classPK,
		long esfStateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK_S;

		Object[] finderArgs = new Object[] { className, classPK, esfStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSPK_2);

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_PK_S_ESFSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				qPos.add(esfStateId);

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

	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_1 = "esfEntityState.className IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_2 = "esfEntityState.className = ? AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSNAME_3 = "(esfEntityState.className IS NULL OR esfEntityState.className = '') AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_S_CLASSPK_2 = "esfEntityState.classPK = ? AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_PK_S_ESFSTATEID_2 =
		"esfEntityState.esfStateId = ? AND esfEntityState.endDate is null";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFENTITYSTATEC_S =
		new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFEntityStateC_S",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATEC_S =
		new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFEntityStateC_S",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFEntityStateModelImpl.CLASSNAME_COLUMN_BITMASK |
			ESFEntityStateModelImpl.ESFSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_S = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFEntityStateC_S",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f entity states where className = &#63; and esfStateId = &#63;.
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @return the matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findByESFEntityStateC_S(String className,
		long esfStateId) throws SystemException {
		return findByESFEntityStateC_S(className, esfStateId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f entity states where className = &#63; and esfStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @param start the lower bound of the range of e s f entity states
	 * @param end the upper bound of the range of e s f entity states (not inclusive)
	 * @return the range of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findByESFEntityStateC_S(String className,
		long esfStateId, int start, int end) throws SystemException {
		return findByESFEntityStateC_S(className, esfStateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f entity states where className = &#63; and esfStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @param start the lower bound of the range of e s f entity states
	 * @param end the upper bound of the range of e s f entity states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findByESFEntityStateC_S(String className,
		long esfStateId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATEC_S;
			finderArgs = new Object[] { className, esfStateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFENTITYSTATEC_S;
			finderArgs = new Object[] {
					className, esfStateId,
					
					start, end, orderByComparator
				};
		}

		List<ESFEntityState> list = (List<ESFEntityState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFEntityState esfEntityState : list) {
				if (!Validator.equals(className, esfEntityState.getClassName()) ||
						(esfStateId != esfEntityState.getEsfStateId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_ESFSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFEntityStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(esfStateId);

				if (!pagination) {
					list = (List<ESFEntityState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFEntityState>(list);
				}
				else {
					list = (List<ESFEntityState>)QueryUtil.list(q,
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
	 * Returns the first e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByESFEntityStateC_S_First(String className,
		long esfStateId, OrderByComparator orderByComparator)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = fetchByESFEntityStateC_S_First(className,
				esfStateId, orderByComparator);

		if (esfEntityState != null) {
			return esfEntityState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", esfStateId=");
		msg.append(esfStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityStateException(msg.toString());
	}

	/**
	 * Returns the first e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByESFEntityStateC_S_First(String className,
		long esfStateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFEntityState> list = findByESFEntityStateC_S(className,
				esfStateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByESFEntityStateC_S_Last(String className,
		long esfStateId, OrderByComparator orderByComparator)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = fetchByESFEntityStateC_S_Last(className,
				esfStateId, orderByComparator);

		if (esfEntityState != null) {
			return esfEntityState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", esfStateId=");
		msg.append(esfStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityStateException(msg.toString());
	}

	/**
	 * Returns the last e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByESFEntityStateC_S_Last(String className,
		long esfStateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFEntityStateC_S(className, esfStateId);

		if (count == 0) {
			return null;
		}

		List<ESFEntityState> list = findByESFEntityStateC_S(className,
				esfStateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f entity states before and after the current e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	 *
	 * @param esfEntityStateId the primary key of the current e s f entity state
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState[] findByESFEntityStateC_S_PrevAndNext(
		long esfEntityStateId, String className, long esfStateId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = findByPrimaryKey(esfEntityStateId);

		Session session = null;

		try {
			session = openSession();

			ESFEntityState[] array = new ESFEntityStateImpl[3];

			array[0] = getByESFEntityStateC_S_PrevAndNext(session,
					esfEntityState, className, esfStateId, orderByComparator,
					true);

			array[1] = esfEntityState;

			array[2] = getByESFEntityStateC_S_PrevAndNext(session,
					esfEntityState, className, esfStateId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFEntityState getByESFEntityStateC_S_PrevAndNext(
		Session session, ESFEntityState esfEntityState, String className,
		long esfStateId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFENTITYSTATE_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_ESFSTATEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ESFEntityStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(esfStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfEntityState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFEntityState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f entity states where className = &#63; and esfStateId = &#63; from the database.
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFEntityStateC_S(String className, long esfStateId)
		throws SystemException {
		for (ESFEntityState esfEntityState : findByESFEntityStateC_S(
				className, esfStateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(esfEntityState);
		}
	}

	/**
	 * Returns the number of e s f entity states where className = &#63; and esfStateId = &#63;.
	 *
	 * @param className the class name
	 * @param esfStateId the esf state ID
	 * @return the number of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFEntityStateC_S(String className, long esfStateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_S;

		Object[] finderArgs = new Object[] { className, esfStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ESFENTITYSTATEC_S_ESFSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(esfStateId);

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

	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_1 = "esfEntityState.className IS NULL AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_2 = "esfEntityState.className = ? AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_S_CLASSNAME_3 = "(esfEntityState.className IS NULL OR esfEntityState.className = '') AND ";
	private static final String _FINDER_COLUMN_ESFENTITYSTATEC_S_ESFSTATEID_2 = "esfEntityState.esfStateId = ? AND esfEntityState.endDate is null";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFENTITYSTATECN =
		new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFEntityStateCN",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATECN =
		new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFEntityStateCN", new String[] { String.class.getName() },
			ESFEntityStateModelImpl.CLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFENTITYSTATECN = new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFEntityStateCN", new String[] { String.class.getName() });

	/**
	 * Returns all the e s f entity states where className = &#63;.
	 *
	 * @param className the class name
	 * @return the matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findByESFEntityStateCN(String className)
		throws SystemException {
		return findByESFEntityStateCN(className, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f entity states where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of e s f entity states
	 * @param end the upper bound of the range of e s f entity states (not inclusive)
	 * @return the range of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findByESFEntityStateCN(String className,
		int start, int end) throws SystemException {
		return findByESFEntityStateCN(className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f entity states where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of e s f entity states
	 * @param end the upper bound of the range of e s f entity states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findByESFEntityStateCN(String className,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATECN;
			finderArgs = new Object[] { className };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFENTITYSTATECN;
			finderArgs = new Object[] { className, start, end, orderByComparator };
		}

		List<ESFEntityState> list = (List<ESFEntityState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFEntityState esfEntityState : list) {
				if (!Validator.equals(className, esfEntityState.getClassName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFEntityStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				if (!pagination) {
					list = (List<ESFEntityState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFEntityState>(list);
				}
				else {
					list = (List<ESFEntityState>)QueryUtil.list(q,
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
	 * Returns the first e s f entity state in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByESFEntityStateCN_First(String className,
		OrderByComparator orderByComparator)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = fetchByESFEntityStateCN_First(className,
				orderByComparator);

		if (esfEntityState != null) {
			return esfEntityState;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityStateException(msg.toString());
	}

	/**
	 * Returns the first e s f entity state in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByESFEntityStateCN_First(String className,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFEntityState> list = findByESFEntityStateCN(className, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f entity state in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByESFEntityStateCN_Last(String className,
		OrderByComparator orderByComparator)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = fetchByESFEntityStateCN_Last(className,
				orderByComparator);

		if (esfEntityState != null) {
			return esfEntityState;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityStateException(msg.toString());
	}

	/**
	 * Returns the last e s f entity state in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByESFEntityStateCN_Last(String className,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFEntityStateCN(className);

		if (count == 0) {
			return null;
		}

		List<ESFEntityState> list = findByESFEntityStateCN(className,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f entity states before and after the current e s f entity state in the ordered set where className = &#63;.
	 *
	 * @param esfEntityStateId the primary key of the current e s f entity state
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState[] findByESFEntityStateCN_PrevAndNext(
		long esfEntityStateId, String className,
		OrderByComparator orderByComparator)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = findByPrimaryKey(esfEntityStateId);

		Session session = null;

		try {
			session = openSession();

			ESFEntityState[] array = new ESFEntityStateImpl[3];

			array[0] = getByESFEntityStateCN_PrevAndNext(session,
					esfEntityState, className, orderByComparator, true);

			array[1] = esfEntityState;

			array[2] = getByESFEntityStateCN_PrevAndNext(session,
					esfEntityState, className, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFEntityState getByESFEntityStateCN_PrevAndNext(
		Session session, ESFEntityState esfEntityState, String className,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFENTITYSTATE_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ESFEntityStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfEntityState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFEntityState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f entity states where className = &#63; from the database.
	 *
	 * @param className the class name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFEntityStateCN(String className)
		throws SystemException {
		for (ESFEntityState esfEntityState : findByESFEntityStateCN(className,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfEntityState);
		}
	}

	/**
	 * Returns the number of e s f entity states where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFEntityStateCN(String className)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFENTITYSTATECN;

		Object[] finderArgs = new Object[] { className };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

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

	private static final String _FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_1 = "esfEntityState.className IS NULL";
	private static final String _FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_2 = "esfEntityState.className = ?";
	private static final String _FINDER_COLUMN_ESFENTITYSTATECN_CLASSNAME_3 = "(esfEntityState.className IS NULL OR esfEntityState.className = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK =
		new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED,
			ESFEntityStateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByAllESFEntityStateClassName_ClassPK",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFEntityStateModelImpl.CLASSNAME_COLUMN_BITMASK |
			ESFEntityStateModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK =
		new FinderPath(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllESFEntityStateClassName_ClassPK",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByAllESFEntityStateClassName_ClassPK(
		String className, long classPK)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = fetchByAllESFEntityStateClassName_ClassPK(className,
				classPK);

		if (esfEntityState == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntityStateException(msg.toString());
		}

		return esfEntityState;
	}

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByAllESFEntityStateClassName_ClassPK(
		String className, long classPK) throws SystemException {
		return fetchByAllESFEntityStateClassName_ClassPK(className, classPK,
			true);
	}

	/**
	 * Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByAllESFEntityStateClassName_ClassPK(
		String className, long classPK, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { className, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
					finderArgs, this);
		}

		if (result instanceof ESFEntityState) {
			ESFEntityState esfEntityState = (ESFEntityState)result;

			if (!Validator.equals(className, esfEntityState.getClassName()) ||
					(classPK != esfEntityState.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				List<ESFEntityState> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFEntityStatePersistenceImpl.fetchByAllESFEntityStateClassName_ClassPK(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFEntityState esfEntityState = list.get(0);

					result = esfEntityState;

					cacheResult(esfEntityState);

					if ((esfEntityState.getClassName() == null) ||
							!esfEntityState.getClassName().equals(className) ||
							(esfEntityState.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
							finderArgs, esfEntityState);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
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
			return (ESFEntityState)result;
		}
	}

	/**
	 * Removes the e s f entity state where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the e s f entity state that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState removeByAllESFEntityStateClassName_ClassPK(
		String className, long classPK)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = findByAllESFEntityStateClassName_ClassPK(className,
				classPK);

		return remove(esfEntityState);
	}

	/**
	 * Returns the number of e s f entity states where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllESFEntityStateClassName_ClassPK(String className,
		long classPK) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK;

		Object[] finderArgs = new Object[] { className, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFENTITYSTATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_1 =
		"esfEntityState.className IS NULL AND ";
	private static final String _FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_2 =
		"esfEntityState.className = ? AND ";
	private static final String _FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSNAME_3 =
		"(esfEntityState.className IS NULL OR esfEntityState.className = '') AND ";
	private static final String _FINDER_COLUMN_ALLESFENTITYSTATECLASSNAME_CLASSPK_CLASSPK_2 =
		"esfEntityState.classPK = ?";

	public ESFEntityStatePersistenceImpl() {
		setModelClass(ESFEntityState.class);
	}

	/**
	 * Caches the e s f entity state in the entity cache if it is enabled.
	 *
	 * @param esfEntityState the e s f entity state
	 */
	@Override
	public void cacheResult(ESFEntityState esfEntityState) {
		EntityCacheUtil.putResult(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateImpl.class, esfEntityState.getPrimaryKey(),
			esfEntityState);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
			new Object[] {
				esfEntityState.getClassName(), esfEntityState.getClassPK()
			}, esfEntityState);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
			new Object[] {
				esfEntityState.getClassName(), esfEntityState.getClassPK(),
				esfEntityState.getEsfStateId()
			}, esfEntityState);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
			new Object[] {
				esfEntityState.getClassName(), esfEntityState.getClassPK()
			}, esfEntityState);

		esfEntityState.resetOriginalValues();
	}

	/**
	 * Caches the e s f entity states in the entity cache if it is enabled.
	 *
	 * @param esfEntityStates the e s f entity states
	 */
	@Override
	public void cacheResult(List<ESFEntityState> esfEntityStates) {
		for (ESFEntityState esfEntityState : esfEntityStates) {
			if (EntityCacheUtil.getResult(
						ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
						ESFEntityStateImpl.class, esfEntityState.getPrimaryKey()) == null) {
				cacheResult(esfEntityState);
			}
			else {
				esfEntityState.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f entity states.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFEntityStateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFEntityStateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f entity state.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFEntityState esfEntityState) {
		EntityCacheUtil.removeResult(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateImpl.class, esfEntityState.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfEntityState);
	}

	@Override
	public void clearCache(List<ESFEntityState> esfEntityStates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFEntityState esfEntityState : esfEntityStates) {
			EntityCacheUtil.removeResult(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
				ESFEntityStateImpl.class, esfEntityState.getPrimaryKey());

			clearUniqueFindersCache(esfEntityState);
		}
	}

	protected void cacheUniqueFindersCache(ESFEntityState esfEntityState) {
		if (esfEntityState.isNew()) {
			Object[] args = new Object[] {
					esfEntityState.getClassName(), esfEntityState.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
				args, esfEntityState);

			args = new Object[] {
					esfEntityState.getClassName(), esfEntityState.getClassPK(),
					esfEntityState.getEsfStateId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK_S,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
				args, esfEntityState);

			args = new Object[] {
					esfEntityState.getClassName(), esfEntityState.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
				args, esfEntityState);
		}
		else {
			ESFEntityStateModelImpl esfEntityStateModelImpl = (ESFEntityStateModelImpl)esfEntityState;

			if ((esfEntityStateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfEntityState.getClassName(),
						esfEntityState.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
					args, esfEntityState);
			}

			if ((esfEntityStateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfEntityState.getClassName(),
						esfEntityState.getClassPK(),
						esfEntityState.getEsfStateId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK_S,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
					args, esfEntityState);
			}

			if ((esfEntityStateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfEntityState.getClassName(),
						esfEntityState.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
					args, esfEntityState);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFEntityState esfEntityState) {
		ESFEntityStateModelImpl esfEntityStateModelImpl = (ESFEntityStateModelImpl)esfEntityState;

		Object[] args = new Object[] {
				esfEntityState.getClassName(), esfEntityState.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
			args);

		if ((esfEntityStateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfEntityStateModelImpl.getOriginalClassName(),
					esfEntityStateModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK,
				args);
		}

		args = new Object[] {
				esfEntityState.getClassName(), esfEntityState.getClassPK(),
				esfEntityState.getEsfStateId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK_S,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
			args);

		if ((esfEntityStateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfEntityStateModelImpl.getOriginalClassName(),
					esfEntityStateModelImpl.getOriginalClassPK(),
					esfEntityStateModelImpl.getOriginalEsfStateId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_PK_S,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFENTITYSTATEC_PK_S,
				args);
		}

		args = new Object[] {
				esfEntityState.getClassName(), esfEntityState.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
			args);

		if ((esfEntityStateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfEntityStateModelImpl.getOriginalClassName(),
					esfEntityStateModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ALLESFENTITYSTATECLASSNAME_CLASSPK,
				args);
		}
	}

	/**
	 * Creates a new e s f entity state with the primary key. Does not add the e s f entity state to the database.
	 *
	 * @param esfEntityStateId the primary key for the new e s f entity state
	 * @return the new e s f entity state
	 */
	@Override
	public ESFEntityState create(long esfEntityStateId) {
		ESFEntityState esfEntityState = new ESFEntityStateImpl();

		esfEntityState.setNew(true);
		esfEntityState.setPrimaryKey(esfEntityStateId);

		return esfEntityState;
	}

	/**
	 * Removes the e s f entity state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfEntityStateId the primary key of the e s f entity state
	 * @return the e s f entity state that was removed
	 * @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState remove(long esfEntityStateId)
		throws NoSuchEntityStateException, SystemException {
		return remove((Serializable)esfEntityStateId);
	}

	/**
	 * Removes the e s f entity state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f entity state
	 * @return the e s f entity state that was removed
	 * @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState remove(Serializable primaryKey)
		throws NoSuchEntityStateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFEntityState esfEntityState = (ESFEntityState)session.get(ESFEntityStateImpl.class,
					primaryKey);

			if (esfEntityState == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntityStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfEntityState);
		}
		catch (NoSuchEntityStateException nsee) {
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
	protected ESFEntityState removeImpl(ESFEntityState esfEntityState)
		throws SystemException {
		esfEntityState = toUnwrappedModel(esfEntityState);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfEntityState)) {
				esfEntityState = (ESFEntityState)session.get(ESFEntityStateImpl.class,
						esfEntityState.getPrimaryKeyObj());
			}

			if (esfEntityState != null) {
				session.delete(esfEntityState);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfEntityState != null) {
			clearCache(esfEntityState);
		}

		return esfEntityState;
	}

	@Override
	public ESFEntityState updateImpl(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws SystemException {
		esfEntityState = toUnwrappedModel(esfEntityState);

		boolean isNew = esfEntityState.isNew();

		ESFEntityStateModelImpl esfEntityStateModelImpl = (ESFEntityStateModelImpl)esfEntityState;

		Session session = null;

		try {
			session = openSession();

			if (esfEntityState.isNew()) {
				session.save(esfEntityState);

				esfEntityState.setNew(false);
			}
			else {
				session.merge(esfEntityState);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFEntityStateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfEntityStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATEC_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfEntityStateModelImpl.getOriginalClassName(),
						esfEntityStateModelImpl.getOriginalEsfStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_S,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATEC_S,
					args);

				args = new Object[] {
						esfEntityStateModelImpl.getClassName(),
						esfEntityStateModelImpl.getEsfStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATEC_S,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATEC_S,
					args);
			}

			if ((esfEntityStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATECN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfEntityStateModelImpl.getOriginalClassName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATECN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATECN,
					args);

				args = new Object[] { esfEntityStateModelImpl.getClassName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFENTITYSTATECN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFENTITYSTATECN,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
			ESFEntityStateImpl.class, esfEntityState.getPrimaryKey(),
			esfEntityState);

		clearUniqueFindersCache(esfEntityState);
		cacheUniqueFindersCache(esfEntityState);

		return esfEntityState;
	}

	protected ESFEntityState toUnwrappedModel(ESFEntityState esfEntityState) {
		if (esfEntityState instanceof ESFEntityStateImpl) {
			return esfEntityState;
		}

		ESFEntityStateImpl esfEntityStateImpl = new ESFEntityStateImpl();

		esfEntityStateImpl.setNew(esfEntityState.isNew());
		esfEntityStateImpl.setPrimaryKey(esfEntityState.getPrimaryKey());

		esfEntityStateImpl.setEsfEntityStateId(esfEntityState.getEsfEntityStateId());
		esfEntityStateImpl.setGroupId(esfEntityState.getGroupId());
		esfEntityStateImpl.setCompanyId(esfEntityState.getCompanyId());
		esfEntityStateImpl.setUserId(esfEntityState.getUserId());
		esfEntityStateImpl.setUserName(esfEntityState.getUserName());
		esfEntityStateImpl.setCreateDate(esfEntityState.getCreateDate());
		esfEntityStateImpl.setModifiedDate(esfEntityState.getModifiedDate());
		esfEntityStateImpl.setClassName(esfEntityState.getClassName());
		esfEntityStateImpl.setClassPK(esfEntityState.getClassPK());
		esfEntityStateImpl.setStartDate(esfEntityState.getStartDate());
		esfEntityStateImpl.setEndDate(esfEntityState.getEndDate());
		esfEntityStateImpl.setEsfStateId(esfEntityState.getEsfStateId());

		return esfEntityStateImpl;
	}

	/**
	 * Returns the e s f entity state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f entity state
	 * @return the e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntityStateException, SystemException {
		ESFEntityState esfEntityState = fetchByPrimaryKey(primaryKey);

		if (esfEntityState == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntityStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfEntityState;
	}

	/**
	 * Returns the e s f entity state with the primary key or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	 *
	 * @param esfEntityStateId the primary key of the e s f entity state
	 * @return the e s f entity state
	 * @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState findByPrimaryKey(long esfEntityStateId)
		throws NoSuchEntityStateException, SystemException {
		return findByPrimaryKey((Serializable)esfEntityStateId);
	}

	/**
	 * Returns the e s f entity state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f entity state
	 * @return the e s f entity state, or <code>null</code> if a e s f entity state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFEntityState esfEntityState = (ESFEntityState)EntityCacheUtil.getResult(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
				ESFEntityStateImpl.class, primaryKey);

		if (esfEntityState == _nullESFEntityState) {
			return null;
		}

		if (esfEntityState == null) {
			Session session = null;

			try {
				session = openSession();

				esfEntityState = (ESFEntityState)session.get(ESFEntityStateImpl.class,
						primaryKey);

				if (esfEntityState != null) {
					cacheResult(esfEntityState);
				}
				else {
					EntityCacheUtil.putResult(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
						ESFEntityStateImpl.class, primaryKey,
						_nullESFEntityState);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFEntityStateModelImpl.ENTITY_CACHE_ENABLED,
					ESFEntityStateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfEntityState;
	}

	/**
	 * Returns the e s f entity state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfEntityStateId the primary key of the e s f entity state
	 * @return the e s f entity state, or <code>null</code> if a e s f entity state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFEntityState fetchByPrimaryKey(long esfEntityStateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfEntityStateId);
	}

	/**
	 * Returns all the e s f entity states.
	 *
	 * @return the e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f entity states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f entity states
	 * @param end the upper bound of the range of e s f entity states (not inclusive)
	 * @return the range of e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f entity states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f entity states
	 * @param end the upper bound of the range of e s f entity states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f entity states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFEntityState> findAll(int start, int end,
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

		List<ESFEntityState> list = (List<ESFEntityState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFENTITYSTATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFENTITYSTATE;

				if (pagination) {
					sql = sql.concat(ESFEntityStateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFEntityState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFEntityState>(list);
				}
				else {
					list = (List<ESFEntityState>)QueryUtil.list(q,
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
	 * Removes all the e s f entity states from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFEntityState esfEntityState : findAll()) {
			remove(esfEntityState);
		}
	}

	/**
	 * Returns the number of e s f entity states.
	 *
	 * @return the number of e s f entity states
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

				Query q = session.createQuery(_SQL_COUNT_ESFENTITYSTATE);

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
	 * Initializes the e s f entity state persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFEntityState")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFEntityState>> listenersList = new ArrayList<ModelListener<ESFEntityState>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFEntityState>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFEntityStateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFENTITYSTATE = "SELECT esfEntityState FROM ESFEntityState esfEntityState";
	private static final String _SQL_SELECT_ESFENTITYSTATE_WHERE = "SELECT esfEntityState FROM ESFEntityState esfEntityState WHERE ";
	private static final String _SQL_COUNT_ESFENTITYSTATE = "SELECT COUNT(esfEntityState) FROM ESFEntityState esfEntityState";
	private static final String _SQL_COUNT_ESFENTITYSTATE_WHERE = "SELECT COUNT(esfEntityState) FROM ESFEntityState esfEntityState WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfEntityState.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFEntityState exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFEntityState exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFEntityStatePersistenceImpl.class);
	private static ESFEntityState _nullESFEntityState = new ESFEntityStateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFEntityState> toCacheModel() {
				return _nullESFEntityStateCacheModel;
			}
		};

	private static CacheModel<ESFEntityState> _nullESFEntityStateCacheModel = new CacheModel<ESFEntityState>() {
			@Override
			public ESFEntityState toEntityModel() {
				return _nullESFEntityState;
			}
		};
}