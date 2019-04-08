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

import it.ethica.esf.NoSuchAnnualConiReportException;
import it.ethica.esf.model.ESFAnnualConiReport;
import it.ethica.esf.model.impl.ESFAnnualConiReportImpl;
import it.ethica.esf.model.impl.ESFAnnualConiReportModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f annual coni report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualConiReportPersistence
 * @see ESFAnnualConiReportUtil
 * @generated
 */
public class ESFAnnualConiReportPersistenceImpl extends BasePersistenceImpl<ESFAnnualConiReport>
	implements ESFAnnualConiReportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFAnnualConiReportUtil} to access the e s f annual coni report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFAnnualConiReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualConiReportModelImpl.FINDER_CACHE_ENABLED,
			ESFAnnualConiReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualConiReportModelImpl.FINDER_CACHE_ENABLED,
			ESFAnnualConiReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualConiReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ASSYEAR = new FinderPath(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualConiReportModelImpl.FINDER_CACHE_ENABLED,
			ESFAnnualConiReportImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByAssYear",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ESFAnnualConiReportModelImpl.ASSID_COLUMN_BITMASK |
			ESFAnnualConiReportModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSYEAR = new FinderPath(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualConiReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAssYear",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the e s f annual coni report where assId = &#63; and year = &#63; or throws a {@link it.ethica.esf.NoSuchAnnualConiReportException} if it could not be found.
	 *
	 * @param assId the ass ID
	 * @param year the year
	 * @return the matching e s f annual coni report
	 * @throws it.ethica.esf.NoSuchAnnualConiReportException if a matching e s f annual coni report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport findByAssYear(long assId, int year)
		throws NoSuchAnnualConiReportException, SystemException {
		ESFAnnualConiReport esfAnnualConiReport = fetchByAssYear(assId, year);

		if (esfAnnualConiReport == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assId=");
			msg.append(assId);

			msg.append(", year=");
			msg.append(year);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAnnualConiReportException(msg.toString());
		}

		return esfAnnualConiReport;
	}

	/**
	 * Returns the e s f annual coni report where assId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assId the ass ID
	 * @param year the year
	 * @return the matching e s f annual coni report, or <code>null</code> if a matching e s f annual coni report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport fetchByAssYear(long assId, int year)
		throws SystemException {
		return fetchByAssYear(assId, year, true);
	}

	/**
	 * Returns the e s f annual coni report where assId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assId the ass ID
	 * @param year the year
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f annual coni report, or <code>null</code> if a matching e s f annual coni report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport fetchByAssYear(long assId, int year,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { assId, year };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ASSYEAR,
					finderArgs, this);
		}

		if (result instanceof ESFAnnualConiReport) {
			ESFAnnualConiReport esfAnnualConiReport = (ESFAnnualConiReport)result;

			if ((assId != esfAnnualConiReport.getAssId()) ||
					(year != esfAnnualConiReport.getYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFANNUALCONIREPORT_WHERE);

			query.append(_FINDER_COLUMN_ASSYEAR_ASSID_2);

			query.append(_FINDER_COLUMN_ASSYEAR_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assId);

				qPos.add(year);

				List<ESFAnnualConiReport> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSYEAR,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFAnnualConiReportPersistenceImpl.fetchByAssYear(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFAnnualConiReport esfAnnualConiReport = list.get(0);

					result = esfAnnualConiReport;

					cacheResult(esfAnnualConiReport);

					if ((esfAnnualConiReport.getAssId() != assId) ||
							(esfAnnualConiReport.getYear() != year)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSYEAR,
							finderArgs, esfAnnualConiReport);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSYEAR,
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
			return (ESFAnnualConiReport)result;
		}
	}

	/**
	 * Removes the e s f annual coni report where assId = &#63; and year = &#63; from the database.
	 *
	 * @param assId the ass ID
	 * @param year the year
	 * @return the e s f annual coni report that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport removeByAssYear(long assId, int year)
		throws NoSuchAnnualConiReportException, SystemException {
		ESFAnnualConiReport esfAnnualConiReport = findByAssYear(assId, year);

		return remove(esfAnnualConiReport);
	}

	/**
	 * Returns the number of e s f annual coni reports where assId = &#63; and year = &#63;.
	 *
	 * @param assId the ass ID
	 * @param year the year
	 * @return the number of matching e s f annual coni reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAssYear(long assId, int year) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSYEAR;

		Object[] finderArgs = new Object[] { assId, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFANNUALCONIREPORT_WHERE);

			query.append(_FINDER_COLUMN_ASSYEAR_ASSID_2);

			query.append(_FINDER_COLUMN_ASSYEAR_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assId);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_ASSYEAR_ASSID_2 = "esfAnnualConiReport.assId = ? AND ";
	private static final String _FINDER_COLUMN_ASSYEAR_YEAR_2 = "esfAnnualConiReport.year = ?";

	public ESFAnnualConiReportPersistenceImpl() {
		setModelClass(ESFAnnualConiReport.class);
	}

	/**
	 * Caches the e s f annual coni report in the entity cache if it is enabled.
	 *
	 * @param esfAnnualConiReport the e s f annual coni report
	 */
	@Override
	public void cacheResult(ESFAnnualConiReport esfAnnualConiReport) {
		EntityCacheUtil.putResult(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualConiReportImpl.class, esfAnnualConiReport.getPrimaryKey(),
			esfAnnualConiReport);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSYEAR,
			new Object[] {
				esfAnnualConiReport.getAssId(), esfAnnualConiReport.getYear()
			}, esfAnnualConiReport);

		esfAnnualConiReport.resetOriginalValues();
	}

	/**
	 * Caches the e s f annual coni reports in the entity cache if it is enabled.
	 *
	 * @param esfAnnualConiReports the e s f annual coni reports
	 */
	@Override
	public void cacheResult(List<ESFAnnualConiReport> esfAnnualConiReports) {
		for (ESFAnnualConiReport esfAnnualConiReport : esfAnnualConiReports) {
			if (EntityCacheUtil.getResult(
						ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
						ESFAnnualConiReportImpl.class,
						esfAnnualConiReport.getPrimaryKey()) == null) {
				cacheResult(esfAnnualConiReport);
			}
			else {
				esfAnnualConiReport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f annual coni reports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFAnnualConiReportImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFAnnualConiReportImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f annual coni report.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFAnnualConiReport esfAnnualConiReport) {
		EntityCacheUtil.removeResult(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualConiReportImpl.class, esfAnnualConiReport.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfAnnualConiReport);
	}

	@Override
	public void clearCache(List<ESFAnnualConiReport> esfAnnualConiReports) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFAnnualConiReport esfAnnualConiReport : esfAnnualConiReports) {
			EntityCacheUtil.removeResult(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
				ESFAnnualConiReportImpl.class,
				esfAnnualConiReport.getPrimaryKey());

			clearUniqueFindersCache(esfAnnualConiReport);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFAnnualConiReport esfAnnualConiReport) {
		if (esfAnnualConiReport.isNew()) {
			Object[] args = new Object[] {
					esfAnnualConiReport.getAssId(),
					esfAnnualConiReport.getYear()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSYEAR, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSYEAR, args,
				esfAnnualConiReport);
		}
		else {
			ESFAnnualConiReportModelImpl esfAnnualConiReportModelImpl = (ESFAnnualConiReportModelImpl)esfAnnualConiReport;

			if ((esfAnnualConiReportModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ASSYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfAnnualConiReport.getAssId(),
						esfAnnualConiReport.getYear()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSYEAR, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ASSYEAR, args,
					esfAnnualConiReport);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFAnnualConiReport esfAnnualConiReport) {
		ESFAnnualConiReportModelImpl esfAnnualConiReportModelImpl = (ESFAnnualConiReportModelImpl)esfAnnualConiReport;

		Object[] args = new Object[] {
				esfAnnualConiReport.getAssId(), esfAnnualConiReport.getYear()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSYEAR, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSYEAR, args);

		if ((esfAnnualConiReportModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ASSYEAR.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfAnnualConiReportModelImpl.getOriginalAssId(),
					esfAnnualConiReportModelImpl.getOriginalYear()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSYEAR, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ASSYEAR, args);
		}
	}

	/**
	 * Creates a new e s f annual coni report with the primary key. Does not add the e s f annual coni report to the database.
	 *
	 * @param annualConiReportId the primary key for the new e s f annual coni report
	 * @return the new e s f annual coni report
	 */
	@Override
	public ESFAnnualConiReport create(long annualConiReportId) {
		ESFAnnualConiReport esfAnnualConiReport = new ESFAnnualConiReportImpl();

		esfAnnualConiReport.setNew(true);
		esfAnnualConiReport.setPrimaryKey(annualConiReportId);

		return esfAnnualConiReport;
	}

	/**
	 * Removes the e s f annual coni report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param annualConiReportId the primary key of the e s f annual coni report
	 * @return the e s f annual coni report that was removed
	 * @throws it.ethica.esf.NoSuchAnnualConiReportException if a e s f annual coni report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport remove(long annualConiReportId)
		throws NoSuchAnnualConiReportException, SystemException {
		return remove((Serializable)annualConiReportId);
	}

	/**
	 * Removes the e s f annual coni report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f annual coni report
	 * @return the e s f annual coni report that was removed
	 * @throws it.ethica.esf.NoSuchAnnualConiReportException if a e s f annual coni report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport remove(Serializable primaryKey)
		throws NoSuchAnnualConiReportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFAnnualConiReport esfAnnualConiReport = (ESFAnnualConiReport)session.get(ESFAnnualConiReportImpl.class,
					primaryKey);

			if (esfAnnualConiReport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnnualConiReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfAnnualConiReport);
		}
		catch (NoSuchAnnualConiReportException nsee) {
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
	protected ESFAnnualConiReport removeImpl(
		ESFAnnualConiReport esfAnnualConiReport) throws SystemException {
		esfAnnualConiReport = toUnwrappedModel(esfAnnualConiReport);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfAnnualConiReport)) {
				esfAnnualConiReport = (ESFAnnualConiReport)session.get(ESFAnnualConiReportImpl.class,
						esfAnnualConiReport.getPrimaryKeyObj());
			}

			if (esfAnnualConiReport != null) {
				session.delete(esfAnnualConiReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfAnnualConiReport != null) {
			clearCache(esfAnnualConiReport);
		}

		return esfAnnualConiReport;
	}

	@Override
	public ESFAnnualConiReport updateImpl(
		it.ethica.esf.model.ESFAnnualConiReport esfAnnualConiReport)
		throws SystemException {
		esfAnnualConiReport = toUnwrappedModel(esfAnnualConiReport);

		boolean isNew = esfAnnualConiReport.isNew();

		Session session = null;

		try {
			session = openSession();

			if (esfAnnualConiReport.isNew()) {
				session.save(esfAnnualConiReport);

				esfAnnualConiReport.setNew(false);
			}
			else {
				session.merge(esfAnnualConiReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFAnnualConiReportModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualConiReportImpl.class, esfAnnualConiReport.getPrimaryKey(),
			esfAnnualConiReport);

		clearUniqueFindersCache(esfAnnualConiReport);
		cacheUniqueFindersCache(esfAnnualConiReport);

		return esfAnnualConiReport;
	}

	protected ESFAnnualConiReport toUnwrappedModel(
		ESFAnnualConiReport esfAnnualConiReport) {
		if (esfAnnualConiReport instanceof ESFAnnualConiReportImpl) {
			return esfAnnualConiReport;
		}

		ESFAnnualConiReportImpl esfAnnualConiReportImpl = new ESFAnnualConiReportImpl();

		esfAnnualConiReportImpl.setNew(esfAnnualConiReport.isNew());
		esfAnnualConiReportImpl.setPrimaryKey(esfAnnualConiReport.getPrimaryKey());

		esfAnnualConiReportImpl.setAnnualConiReportId(esfAnnualConiReport.getAnnualConiReportId());
		esfAnnualConiReportImpl.setAssId(esfAnnualConiReport.getAssId());
		esfAnnualConiReportImpl.setYear(esfAnnualConiReport.getYear());

		return esfAnnualConiReportImpl;
	}

	/**
	 * Returns the e s f annual coni report with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f annual coni report
	 * @return the e s f annual coni report
	 * @throws it.ethica.esf.NoSuchAnnualConiReportException if a e s f annual coni report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnnualConiReportException, SystemException {
		ESFAnnualConiReport esfAnnualConiReport = fetchByPrimaryKey(primaryKey);

		if (esfAnnualConiReport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnnualConiReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfAnnualConiReport;
	}

	/**
	 * Returns the e s f annual coni report with the primary key or throws a {@link it.ethica.esf.NoSuchAnnualConiReportException} if it could not be found.
	 *
	 * @param annualConiReportId the primary key of the e s f annual coni report
	 * @return the e s f annual coni report
	 * @throws it.ethica.esf.NoSuchAnnualConiReportException if a e s f annual coni report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport findByPrimaryKey(long annualConiReportId)
		throws NoSuchAnnualConiReportException, SystemException {
		return findByPrimaryKey((Serializable)annualConiReportId);
	}

	/**
	 * Returns the e s f annual coni report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f annual coni report
	 * @return the e s f annual coni report, or <code>null</code> if a e s f annual coni report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFAnnualConiReport esfAnnualConiReport = (ESFAnnualConiReport)EntityCacheUtil.getResult(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
				ESFAnnualConiReportImpl.class, primaryKey);

		if (esfAnnualConiReport == _nullESFAnnualConiReport) {
			return null;
		}

		if (esfAnnualConiReport == null) {
			Session session = null;

			try {
				session = openSession();

				esfAnnualConiReport = (ESFAnnualConiReport)session.get(ESFAnnualConiReportImpl.class,
						primaryKey);

				if (esfAnnualConiReport != null) {
					cacheResult(esfAnnualConiReport);
				}
				else {
					EntityCacheUtil.putResult(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
						ESFAnnualConiReportImpl.class, primaryKey,
						_nullESFAnnualConiReport);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFAnnualConiReportModelImpl.ENTITY_CACHE_ENABLED,
					ESFAnnualConiReportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfAnnualConiReport;
	}

	/**
	 * Returns the e s f annual coni report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param annualConiReportId the primary key of the e s f annual coni report
	 * @return the e s f annual coni report, or <code>null</code> if a e s f annual coni report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualConiReport fetchByPrimaryKey(long annualConiReportId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)annualConiReportId);
	}

	/**
	 * Returns all the e s f annual coni reports.
	 *
	 * @return the e s f annual coni reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualConiReport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f annual coni reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualConiReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f annual coni reports
	 * @param end the upper bound of the range of e s f annual coni reports (not inclusive)
	 * @return the range of e s f annual coni reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualConiReport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f annual coni reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualConiReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f annual coni reports
	 * @param end the upper bound of the range of e s f annual coni reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f annual coni reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualConiReport> findAll(int start, int end,
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

		List<ESFAnnualConiReport> list = (List<ESFAnnualConiReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFANNUALCONIREPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFANNUALCONIREPORT;

				if (pagination) {
					sql = sql.concat(ESFAnnualConiReportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFAnnualConiReport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFAnnualConiReport>(list);
				}
				else {
					list = (List<ESFAnnualConiReport>)QueryUtil.list(q,
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
	 * Removes all the e s f annual coni reports from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFAnnualConiReport esfAnnualConiReport : findAll()) {
			remove(esfAnnualConiReport);
		}
	}

	/**
	 * Returns the number of e s f annual coni reports.
	 *
	 * @return the number of e s f annual coni reports
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

				Query q = session.createQuery(_SQL_COUNT_ESFANNUALCONIREPORT);

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
	 * Initializes the e s f annual coni report persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFAnnualConiReport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFAnnualConiReport>> listenersList = new ArrayList<ModelListener<ESFAnnualConiReport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFAnnualConiReport>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFAnnualConiReportImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFANNUALCONIREPORT = "SELECT esfAnnualConiReport FROM ESFAnnualConiReport esfAnnualConiReport";
	private static final String _SQL_SELECT_ESFANNUALCONIREPORT_WHERE = "SELECT esfAnnualConiReport FROM ESFAnnualConiReport esfAnnualConiReport WHERE ";
	private static final String _SQL_COUNT_ESFANNUALCONIREPORT = "SELECT COUNT(esfAnnualConiReport) FROM ESFAnnualConiReport esfAnnualConiReport";
	private static final String _SQL_COUNT_ESFANNUALCONIREPORT_WHERE = "SELECT COUNT(esfAnnualConiReport) FROM ESFAnnualConiReport esfAnnualConiReport WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfAnnualConiReport.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFAnnualConiReport exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFAnnualConiReport exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFAnnualConiReportPersistenceImpl.class);
	private static ESFAnnualConiReport _nullESFAnnualConiReport = new ESFAnnualConiReportImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFAnnualConiReport> toCacheModel() {
				return _nullESFAnnualConiReportCacheModel;
			}
		};

	private static CacheModel<ESFAnnualConiReport> _nullESFAnnualConiReportCacheModel =
		new CacheModel<ESFAnnualConiReport>() {
			@Override
			public ESFAnnualConiReport toEntityModel() {
				return _nullESFAnnualConiReport;
			}
		};
}