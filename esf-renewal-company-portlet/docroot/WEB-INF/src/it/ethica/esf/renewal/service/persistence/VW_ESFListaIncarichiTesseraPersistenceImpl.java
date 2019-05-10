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

package it.ethica.esf.renewal.service.persistence;

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

import it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException;
import it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera;
import it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraImpl;
import it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v w_ e s f lista incarichi tessera service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiTesseraPersistence
 * @see VW_ESFListaIncarichiTesseraUtil
 * @generated
 */
public class VW_ESFListaIncarichiTesseraPersistenceImpl
	extends BasePersistenceImpl<VW_ESFListaIncarichiTessera>
	implements VW_ESFListaIncarichiTesseraPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VW_ESFListaIncarichiTesseraUtil} to access the v w_ e s f lista incarichi tessera persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VW_ESFListaIncarichiTesseraImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraModelImpl.FINDER_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraModelImpl.FINDER_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZZAZIONE =
		new FinderPath(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraModelImpl.FINDER_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorganizzazione",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZZAZIONE =
		new FinderPath(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraModelImpl.FINDER_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorganizzazione",
			new String[] { Long.class.getName() },
			VW_ESFListaIncarichiTesseraModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK |
			VW_ESFListaIncarichiTesseraModelImpl.ENDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZZAZIONE = new FinderPath(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByorganizzazione", new String[] { Long.class.getName() });

	/**
	 * Returns all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching v w_ e s f lista incarichi tesseras
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId) throws SystemException {
		return findByorganizzazione(esfOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	 * @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	 * @return the range of matching v w_ e s f lista incarichi tesseras
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId, int start, int end) throws SystemException {
		return findByorganizzazione(esfOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	 * @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v w_ e s f lista incarichi tesseras
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZZAZIONE;
			finderArgs = new Object[] { esfOrganizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZZAZIONE;
			finderArgs = new Object[] {
					esfOrganizationId,
					
					start, end, orderByComparator
				};
		}

		List<VW_ESFListaIncarichiTessera> list = (List<VW_ESFListaIncarichiTessera>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera : list) {
				if ((esfOrganizationId != vw_esfListaIncarichiTessera.getEsfOrganizationId())) {
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

			query.append(_SQL_SELECT_VW_ESFLISTAINCARICHITESSERA_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZZAZIONE_ESFORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VW_ESFListaIncarichiTesseraModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				if (!pagination) {
					list = (List<VW_ESFListaIncarichiTessera>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VW_ESFListaIncarichiTessera>(list);
				}
				else {
					list = (List<VW_ESFListaIncarichiTessera>)QueryUtil.list(q,
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
	 * Returns the first v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v w_ e s f lista incarichi tessera
	 * @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a matching v w_ e s f lista incarichi tessera could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera findByorganizzazione_First(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchVW_ESFListaIncarichiTesseraException, SystemException {
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera = fetchByorganizzazione_First(esfOrganizationId,
				orderByComparator);

		if (vw_esfListaIncarichiTessera != null) {
			return vw_esfListaIncarichiTessera;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVW_ESFListaIncarichiTesseraException(msg.toString());
	}

	/**
	 * Returns the first v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v w_ e s f lista incarichi tessera, or <code>null</code> if a matching v w_ e s f lista incarichi tessera could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera fetchByorganizzazione_First(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VW_ESFListaIncarichiTessera> list = findByorganizzazione(esfOrganizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v w_ e s f lista incarichi tessera
	 * @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a matching v w_ e s f lista incarichi tessera could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera findByorganizzazione_Last(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchVW_ESFListaIncarichiTesseraException, SystemException {
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera = fetchByorganizzazione_Last(esfOrganizationId,
				orderByComparator);

		if (vw_esfListaIncarichiTessera != null) {
			return vw_esfListaIncarichiTessera;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVW_ESFListaIncarichiTesseraException(msg.toString());
	}

	/**
	 * Returns the last v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v w_ e s f lista incarichi tessera, or <code>null</code> if a matching v w_ e s f lista incarichi tessera could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera fetchByorganizzazione_Last(
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByorganizzazione(esfOrganizationId);

		if (count == 0) {
			return null;
		}

		List<VW_ESFListaIncarichiTessera> list = findByorganizzazione(esfOrganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v w_ e s f lista incarichi tesseras before and after the current v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param vw_esfListaIncarichiTesseraPK the primary key of the current v w_ e s f lista incarichi tessera
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v w_ e s f lista incarichi tessera
	 * @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera[] findByorganizzazione_PrevAndNext(
		VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK,
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchVW_ESFListaIncarichiTesseraException, SystemException {
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera = findByPrimaryKey(vw_esfListaIncarichiTesseraPK);

		Session session = null;

		try {
			session = openSession();

			VW_ESFListaIncarichiTessera[] array = new VW_ESFListaIncarichiTesseraImpl[3];

			array[0] = getByorganizzazione_PrevAndNext(session,
					vw_esfListaIncarichiTessera, esfOrganizationId,
					orderByComparator, true);

			array[1] = vw_esfListaIncarichiTessera;

			array[2] = getByorganizzazione_PrevAndNext(session,
					vw_esfListaIncarichiTessera, esfOrganizationId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VW_ESFListaIncarichiTessera getByorganizzazione_PrevAndNext(
		Session session,
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera,
		long esfOrganizationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VW_ESFLISTAINCARICHITESSERA_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZZAZIONE_ESFORGANIZATIONID_2);

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
			query.append(VW_ESFListaIncarichiTesseraModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vw_esfListaIncarichiTessera);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VW_ESFListaIncarichiTessera> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByorganizzazione(long esfOrganizationId)
		throws SystemException {
		for (VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera : findByorganizzazione(
				esfOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vw_esfListaIncarichiTessera);
		}
	}

	/**
	 * Returns the number of v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the number of matching v w_ e s f lista incarichi tesseras
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByorganizzazione(long esfOrganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZZAZIONE;

		Object[] finderArgs = new Object[] { esfOrganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VW_ESFLISTAINCARICHITESSERA_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZZAZIONE_ESFORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZZAZIONE_ESFORGANIZATIONID_2 =
		"vw_esfListaIncarichiTessera.id.esfOrganizationId = ?";

	public VW_ESFListaIncarichiTesseraPersistenceImpl() {
		setModelClass(VW_ESFListaIncarichiTessera.class);
	}

	/**
	 * Caches the v w_ e s f lista incarichi tessera in the entity cache if it is enabled.
	 *
	 * @param vw_esfListaIncarichiTessera the v w_ e s f lista incarichi tessera
	 */
	@Override
	public void cacheResult(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera) {
		EntityCacheUtil.putResult(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraImpl.class,
			vw_esfListaIncarichiTessera.getPrimaryKey(),
			vw_esfListaIncarichiTessera);

		vw_esfListaIncarichiTessera.resetOriginalValues();
	}

	/**
	 * Caches the v w_ e s f lista incarichi tesseras in the entity cache if it is enabled.
	 *
	 * @param vw_esfListaIncarichiTesseras the v w_ e s f lista incarichi tesseras
	 */
	@Override
	public void cacheResult(
		List<VW_ESFListaIncarichiTessera> vw_esfListaIncarichiTesseras) {
		for (VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera : vw_esfListaIncarichiTesseras) {
			if (EntityCacheUtil.getResult(
						VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
						VW_ESFListaIncarichiTesseraImpl.class,
						vw_esfListaIncarichiTessera.getPrimaryKey()) == null) {
				cacheResult(vw_esfListaIncarichiTessera);
			}
			else {
				vw_esfListaIncarichiTessera.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v w_ e s f lista incarichi tesseras.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VW_ESFListaIncarichiTesseraImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VW_ESFListaIncarichiTesseraImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v w_ e s f lista incarichi tessera.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera) {
		EntityCacheUtil.removeResult(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraImpl.class,
			vw_esfListaIncarichiTessera.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<VW_ESFListaIncarichiTessera> vw_esfListaIncarichiTesseras) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera : vw_esfListaIncarichiTesseras) {
			EntityCacheUtil.removeResult(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
				VW_ESFListaIncarichiTesseraImpl.class,
				vw_esfListaIncarichiTessera.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v w_ e s f lista incarichi tessera with the primary key. Does not add the v w_ e s f lista incarichi tessera to the database.
	 *
	 * @param vw_esfListaIncarichiTesseraPK the primary key for the new v w_ e s f lista incarichi tessera
	 * @return the new v w_ e s f lista incarichi tessera
	 */
	@Override
	public VW_ESFListaIncarichiTessera create(
		VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK) {
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera = new VW_ESFListaIncarichiTesseraImpl();

		vw_esfListaIncarichiTessera.setNew(true);
		vw_esfListaIncarichiTessera.setPrimaryKey(vw_esfListaIncarichiTesseraPK);

		return vw_esfListaIncarichiTessera;
	}

	/**
	 * Removes the v w_ e s f lista incarichi tessera with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	 * @return the v w_ e s f lista incarichi tessera that was removed
	 * @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera remove(
		VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws NoSuchVW_ESFListaIncarichiTesseraException, SystemException {
		return remove((Serializable)vw_esfListaIncarichiTesseraPK);
	}

	/**
	 * Removes the v w_ e s f lista incarichi tessera with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v w_ e s f lista incarichi tessera
	 * @return the v w_ e s f lista incarichi tessera that was removed
	 * @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera remove(Serializable primaryKey)
		throws NoSuchVW_ESFListaIncarichiTesseraException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera = (VW_ESFListaIncarichiTessera)session.get(VW_ESFListaIncarichiTesseraImpl.class,
					primaryKey);

			if (vw_esfListaIncarichiTessera == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVW_ESFListaIncarichiTesseraException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vw_esfListaIncarichiTessera);
		}
		catch (NoSuchVW_ESFListaIncarichiTesseraException nsee) {
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
	protected VW_ESFListaIncarichiTessera removeImpl(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera)
		throws SystemException {
		vw_esfListaIncarichiTessera = toUnwrappedModel(vw_esfListaIncarichiTessera);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vw_esfListaIncarichiTessera)) {
				vw_esfListaIncarichiTessera = (VW_ESFListaIncarichiTessera)session.get(VW_ESFListaIncarichiTesseraImpl.class,
						vw_esfListaIncarichiTessera.getPrimaryKeyObj());
			}

			if (vw_esfListaIncarichiTessera != null) {
				session.delete(vw_esfListaIncarichiTessera);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vw_esfListaIncarichiTessera != null) {
			clearCache(vw_esfListaIncarichiTessera);
		}

		return vw_esfListaIncarichiTessera;
	}

	@Override
	public VW_ESFListaIncarichiTessera updateImpl(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera)
		throws SystemException {
		vw_esfListaIncarichiTessera = toUnwrappedModel(vw_esfListaIncarichiTessera);

		boolean isNew = vw_esfListaIncarichiTessera.isNew();

		VW_ESFListaIncarichiTesseraModelImpl vw_esfListaIncarichiTesseraModelImpl =
			(VW_ESFListaIncarichiTesseraModelImpl)vw_esfListaIncarichiTessera;

		Session session = null;

		try {
			session = openSession();

			if (vw_esfListaIncarichiTessera.isNew()) {
				session.save(vw_esfListaIncarichiTessera);

				vw_esfListaIncarichiTessera.setNew(false);
			}
			else {
				session.merge(vw_esfListaIncarichiTessera);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!VW_ESFListaIncarichiTesseraModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vw_esfListaIncarichiTesseraModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZZAZIONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vw_esfListaIncarichiTesseraModelImpl.getOriginalEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZZAZIONE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZZAZIONE,
					args);

				args = new Object[] {
						vw_esfListaIncarichiTesseraModelImpl.getEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZZAZIONE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZZAZIONE,
					args);
			}
		}

		EntityCacheUtil.putResult(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
			VW_ESFListaIncarichiTesseraImpl.class,
			vw_esfListaIncarichiTessera.getPrimaryKey(),
			vw_esfListaIncarichiTessera);

		return vw_esfListaIncarichiTessera;
	}

	protected VW_ESFListaIncarichiTessera toUnwrappedModel(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera) {
		if (vw_esfListaIncarichiTessera instanceof VW_ESFListaIncarichiTesseraImpl) {
			return vw_esfListaIncarichiTessera;
		}

		VW_ESFListaIncarichiTesseraImpl vw_esfListaIncarichiTesseraImpl = new VW_ESFListaIncarichiTesseraImpl();

		vw_esfListaIncarichiTesseraImpl.setNew(vw_esfListaIncarichiTessera.isNew());
		vw_esfListaIncarichiTesseraImpl.setPrimaryKey(vw_esfListaIncarichiTessera.getPrimaryKey());

		vw_esfListaIncarichiTesseraImpl.setAnniPrecedenti(vw_esfListaIncarichiTessera.getAnniPrecedenti());
		vw_esfListaIncarichiTesseraImpl.setAnnoFineIncarico(vw_esfListaIncarichiTessera.getAnnoFineIncarico());
		vw_esfListaIncarichiTesseraImpl.setAnnoInizioIncarico(vw_esfListaIncarichiTessera.getAnnoInizioIncarico());
		vw_esfListaIncarichiTesseraImpl.setAnnoCorrente(vw_esfListaIncarichiTessera.getAnnoCorrente());
		vw_esfListaIncarichiTesseraImpl.setNomeRuolo(vw_esfListaIncarichiTessera.getNomeRuolo());
		vw_esfListaIncarichiTesseraImpl.setEndDate(vw_esfListaIncarichiTessera.getEndDate());
		vw_esfListaIncarichiTesseraImpl.setStartDate(vw_esfListaIncarichiTessera.getStartDate());
		vw_esfListaIncarichiTesseraImpl.setEsfUserId(vw_esfListaIncarichiTessera.getEsfUserId());
		vw_esfListaIncarichiTesseraImpl.setEsfOrganizationId(vw_esfListaIncarichiTessera.getEsfOrganizationId());
		vw_esfListaIncarichiTesseraImpl.setLastName(vw_esfListaIncarichiTessera.getLastName());
		vw_esfListaIncarichiTesseraImpl.setFirstName(vw_esfListaIncarichiTessera.getFirstName());
		vw_esfListaIncarichiTesseraImpl.setCodiceTessera(vw_esfListaIncarichiTessera.getCodiceTessera());
		vw_esfListaIncarichiTesseraImpl.setDataTesseramento(vw_esfListaIncarichiTessera.getDataTesseramento());
<<<<<<< HEAD
		vw_esfListaIncarichiTesseraImpl.setCodiceFiscale(vw_esfListaIncarichiTessera.getCodiceFiscale());
=======
>>>>>>> origin/master

		return vw_esfListaIncarichiTesseraImpl;
	}

	/**
	 * Returns the v w_ e s f lista incarichi tessera with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ e s f lista incarichi tessera
	 * @return the v w_ e s f lista incarichi tessera
	 * @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVW_ESFListaIncarichiTesseraException, SystemException {
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera = fetchByPrimaryKey(primaryKey);

		if (vw_esfListaIncarichiTessera == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVW_ESFListaIncarichiTesseraException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vw_esfListaIncarichiTessera;
	}

	/**
	 * Returns the v w_ e s f lista incarichi tessera with the primary key or throws a {@link it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException} if it could not be found.
	 *
	 * @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	 * @return the v w_ e s f lista incarichi tessera
	 * @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera findByPrimaryKey(
		VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws NoSuchVW_ESFListaIncarichiTesseraException, SystemException {
		return findByPrimaryKey((Serializable)vw_esfListaIncarichiTesseraPK);
	}

	/**
	 * Returns the v w_ e s f lista incarichi tessera with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v w_ e s f lista incarichi tessera
	 * @return the v w_ e s f lista incarichi tessera, or <code>null</code> if a v w_ e s f lista incarichi tessera with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera = (VW_ESFListaIncarichiTessera)EntityCacheUtil.getResult(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
				VW_ESFListaIncarichiTesseraImpl.class, primaryKey);

		if (vw_esfListaIncarichiTessera == _nullVW_ESFListaIncarichiTessera) {
			return null;
		}

		if (vw_esfListaIncarichiTessera == null) {
			Session session = null;

			try {
				session = openSession();

				vw_esfListaIncarichiTessera = (VW_ESFListaIncarichiTessera)session.get(VW_ESFListaIncarichiTesseraImpl.class,
						primaryKey);

				if (vw_esfListaIncarichiTessera != null) {
					cacheResult(vw_esfListaIncarichiTessera);
				}
				else {
					EntityCacheUtil.putResult(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
						VW_ESFListaIncarichiTesseraImpl.class, primaryKey,
						_nullVW_ESFListaIncarichiTessera);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VW_ESFListaIncarichiTesseraModelImpl.ENTITY_CACHE_ENABLED,
					VW_ESFListaIncarichiTesseraImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vw_esfListaIncarichiTessera;
	}

	/**
	 * Returns the v w_ e s f lista incarichi tessera with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	 * @return the v w_ e s f lista incarichi tessera, or <code>null</code> if a v w_ e s f lista incarichi tessera with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VW_ESFListaIncarichiTessera fetchByPrimaryKey(
		VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vw_esfListaIncarichiTesseraPK);
	}

	/**
	 * Returns all the v w_ e s f lista incarichi tesseras.
	 *
	 * @return the v w_ e s f lista incarichi tesseras
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFListaIncarichiTessera> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v w_ e s f lista incarichi tesseras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	 * @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	 * @return the range of v w_ e s f lista incarichi tesseras
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFListaIncarichiTessera> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v w_ e s f lista incarichi tesseras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	 * @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v w_ e s f lista incarichi tesseras
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VW_ESFListaIncarichiTessera> findAll(int start, int end,
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

		List<VW_ESFListaIncarichiTessera> list = (List<VW_ESFListaIncarichiTessera>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VW_ESFLISTAINCARICHITESSERA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VW_ESFLISTAINCARICHITESSERA;

				if (pagination) {
					sql = sql.concat(VW_ESFListaIncarichiTesseraModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VW_ESFListaIncarichiTessera>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VW_ESFListaIncarichiTessera>(list);
				}
				else {
					list = (List<VW_ESFListaIncarichiTessera>)QueryUtil.list(q,
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
	 * Removes all the v w_ e s f lista incarichi tesseras from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera : findAll()) {
			remove(vw_esfListaIncarichiTessera);
		}
	}

	/**
	 * Returns the number of v w_ e s f lista incarichi tesseras.
	 *
	 * @return the number of v w_ e s f lista incarichi tesseras
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

				Query q = session.createQuery(_SQL_COUNT_VW_ESFLISTAINCARICHITESSERA);

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
	 * Initializes the v w_ e s f lista incarichi tessera persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VW_ESFListaIncarichiTessera>> listenersList = new ArrayList<ModelListener<VW_ESFListaIncarichiTessera>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VW_ESFListaIncarichiTessera>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VW_ESFListaIncarichiTesseraImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VW_ESFLISTAINCARICHITESSERA = "SELECT vw_esfListaIncarichiTessera FROM VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera";
	private static final String _SQL_SELECT_VW_ESFLISTAINCARICHITESSERA_WHERE = "SELECT vw_esfListaIncarichiTessera FROM VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera WHERE ";
	private static final String _SQL_COUNT_VW_ESFLISTAINCARICHITESSERA = "SELECT COUNT(vw_esfListaIncarichiTessera) FROM VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera";
	private static final String _SQL_COUNT_VW_ESFLISTAINCARICHITESSERA_WHERE = "SELECT COUNT(vw_esfListaIncarichiTessera) FROM VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vw_esfListaIncarichiTessera.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VW_ESFListaIncarichiTessera exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VW_ESFListaIncarichiTessera exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VW_ESFListaIncarichiTesseraPersistenceImpl.class);
	private static VW_ESFListaIncarichiTessera _nullVW_ESFListaIncarichiTessera = new VW_ESFListaIncarichiTesseraImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VW_ESFListaIncarichiTessera> toCacheModel() {
				return _nullVW_ESFListaIncarichiTesseraCacheModel;
			}
		};

	private static CacheModel<VW_ESFListaIncarichiTessera> _nullVW_ESFListaIncarichiTesseraCacheModel =
		new CacheModel<VW_ESFListaIncarichiTessera>() {
			@Override
			public VW_ESFListaIncarichiTessera toEntityModel() {
				return _nullVW_ESFListaIncarichiTessera;
			}
		};
}