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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchAnnualFreeCardException;
import it.ethica.esf.model.ESFAnnualFreeCard;
import it.ethica.esf.model.impl.ESFAnnualFreeCardImpl;
import it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f annual free card service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualFreeCardPersistence
 * @see ESFAnnualFreeCardUtil
 * @generated
 */
public class ESFAnnualFreeCardPersistenceImpl extends BasePersistenceImpl<ESFAnnualFreeCard>
	implements ESFAnnualFreeCardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFAnnualFreeCardUtil} to access the e s f annual free card persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFAnnualFreeCardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardModelImpl.FINDER_CACHE_ENABLED,
			ESFAnnualFreeCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardModelImpl.FINDER_CACHE_ENABLED,
			ESFAnnualFreeCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardModelImpl.FINDER_CACHE_ENABLED,
			ESFAnnualFreeCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardModelImpl.FINDER_CACHE_ENABLED,
			ESFAnnualFreeCardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycode",
			new String[] { String.class.getName() },
			ESFAnnualFreeCardModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f annual free cards where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f annual free cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualFreeCard> findBycode(String code)
		throws SystemException {
		return findBycode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f annual free cards where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f annual free cards
	 * @param end the upper bound of the range of e s f annual free cards (not inclusive)
	 * @return the range of matching e s f annual free cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualFreeCard> findBycode(String code, int start, int end)
		throws SystemException {
		return findBycode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f annual free cards where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f annual free cards
	 * @param end the upper bound of the range of e s f annual free cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f annual free cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualFreeCard> findBycode(String code, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code, start, end, orderByComparator };
		}

		List<ESFAnnualFreeCard> list = (List<ESFAnnualFreeCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFAnnualFreeCard esfAnnualFreeCard : list) {
				if (!Validator.equals(code, esfAnnualFreeCard.getCode())) {
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

			query.append(_SQL_SELECT_ESFANNUALFREECARD_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFAnnualFreeCardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				if (!pagination) {
					list = (List<ESFAnnualFreeCard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFAnnualFreeCard>(list);
				}
				else {
					list = (List<ESFAnnualFreeCard>)QueryUtil.list(q,
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
	 * Returns the first e s f annual free card in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f annual free card
	 * @throws it.ethica.esf.NoSuchAnnualFreeCardException if a matching e s f annual free card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard findBycode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchAnnualFreeCardException, SystemException {
		ESFAnnualFreeCard esfAnnualFreeCard = fetchBycode_First(code,
				orderByComparator);

		if (esfAnnualFreeCard != null) {
			return esfAnnualFreeCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnnualFreeCardException(msg.toString());
	}

	/**
	 * Returns the first e s f annual free card in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f annual free card, or <code>null</code> if a matching e s f annual free card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard fetchBycode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFAnnualFreeCard> list = findBycode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f annual free card in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f annual free card
	 * @throws it.ethica.esf.NoSuchAnnualFreeCardException if a matching e s f annual free card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard findBycode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchAnnualFreeCardException, SystemException {
		ESFAnnualFreeCard esfAnnualFreeCard = fetchBycode_Last(code,
				orderByComparator);

		if (esfAnnualFreeCard != null) {
			return esfAnnualFreeCard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnnualFreeCardException(msg.toString());
	}

	/**
	 * Returns the last e s f annual free card in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f annual free card, or <code>null</code> if a matching e s f annual free card could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard fetchBycode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycode(code);

		if (count == 0) {
			return null;
		}

		List<ESFAnnualFreeCard> list = findBycode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f annual free cards before and after the current e s f annual free card in the ordered set where code = &#63;.
	 *
	 * @param annualFreeCardId the primary key of the current e s f annual free card
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f annual free card
	 * @throws it.ethica.esf.NoSuchAnnualFreeCardException if a e s f annual free card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard[] findBycode_PrevAndNext(long annualFreeCardId,
		String code, OrderByComparator orderByComparator)
		throws NoSuchAnnualFreeCardException, SystemException {
		ESFAnnualFreeCard esfAnnualFreeCard = findByPrimaryKey(annualFreeCardId);

		Session session = null;

		try {
			session = openSession();

			ESFAnnualFreeCard[] array = new ESFAnnualFreeCardImpl[3];

			array[0] = getBycode_PrevAndNext(session, esfAnnualFreeCard, code,
					orderByComparator, true);

			array[1] = esfAnnualFreeCard;

			array[2] = getBycode_PrevAndNext(session, esfAnnualFreeCard, code,
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

	protected ESFAnnualFreeCard getBycode_PrevAndNext(Session session,
		ESFAnnualFreeCard esfAnnualFreeCard, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFANNUALFREECARD_WHERE);

		boolean bindCode = false;

		if (code == null) {
			query.append(_FINDER_COLUMN_CODE_CODE_1);
		}
		else if (code.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODE_CODE_3);
		}
		else {
			bindCode = true;

			query.append(_FINDER_COLUMN_CODE_CODE_2);
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
			query.append(ESFAnnualFreeCardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCode) {
			qPos.add(code);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfAnnualFreeCard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFAnnualFreeCard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f annual free cards where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycode(String code) throws SystemException {
		for (ESFAnnualFreeCard esfAnnualFreeCard : findBycode(code,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfAnnualFreeCard);
		}
	}

	/**
	 * Returns the number of e s f annual free cards where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f annual free cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFANNUALFREECARD_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfAnnualFreeCard.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfAnnualFreeCard.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfAnnualFreeCard.code IS NULL OR esfAnnualFreeCard.code = '')";

	public ESFAnnualFreeCardPersistenceImpl() {
		setModelClass(ESFAnnualFreeCard.class);
	}

	/**
	 * Caches the e s f annual free card in the entity cache if it is enabled.
	 *
	 * @param esfAnnualFreeCard the e s f annual free card
	 */
	@Override
	public void cacheResult(ESFAnnualFreeCard esfAnnualFreeCard) {
		EntityCacheUtil.putResult(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardImpl.class, esfAnnualFreeCard.getPrimaryKey(),
			esfAnnualFreeCard);

		esfAnnualFreeCard.resetOriginalValues();
	}

	/**
	 * Caches the e s f annual free cards in the entity cache if it is enabled.
	 *
	 * @param esfAnnualFreeCards the e s f annual free cards
	 */
	@Override
	public void cacheResult(List<ESFAnnualFreeCard> esfAnnualFreeCards) {
		for (ESFAnnualFreeCard esfAnnualFreeCard : esfAnnualFreeCards) {
			if (EntityCacheUtil.getResult(
						ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
						ESFAnnualFreeCardImpl.class,
						esfAnnualFreeCard.getPrimaryKey()) == null) {
				cacheResult(esfAnnualFreeCard);
			}
			else {
				esfAnnualFreeCard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f annual free cards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFAnnualFreeCardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFAnnualFreeCardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f annual free card.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFAnnualFreeCard esfAnnualFreeCard) {
		EntityCacheUtil.removeResult(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardImpl.class, esfAnnualFreeCard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFAnnualFreeCard> esfAnnualFreeCards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFAnnualFreeCard esfAnnualFreeCard : esfAnnualFreeCards) {
			EntityCacheUtil.removeResult(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
				ESFAnnualFreeCardImpl.class, esfAnnualFreeCard.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f annual free card with the primary key. Does not add the e s f annual free card to the database.
	 *
	 * @param annualFreeCardId the primary key for the new e s f annual free card
	 * @return the new e s f annual free card
	 */
	@Override
	public ESFAnnualFreeCard create(long annualFreeCardId) {
		ESFAnnualFreeCard esfAnnualFreeCard = new ESFAnnualFreeCardImpl();

		esfAnnualFreeCard.setNew(true);
		esfAnnualFreeCard.setPrimaryKey(annualFreeCardId);

		return esfAnnualFreeCard;
	}

	/**
	 * Removes the e s f annual free card with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param annualFreeCardId the primary key of the e s f annual free card
	 * @return the e s f annual free card that was removed
	 * @throws it.ethica.esf.NoSuchAnnualFreeCardException if a e s f annual free card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard remove(long annualFreeCardId)
		throws NoSuchAnnualFreeCardException, SystemException {
		return remove((Serializable)annualFreeCardId);
	}

	/**
	 * Removes the e s f annual free card with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f annual free card
	 * @return the e s f annual free card that was removed
	 * @throws it.ethica.esf.NoSuchAnnualFreeCardException if a e s f annual free card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard remove(Serializable primaryKey)
		throws NoSuchAnnualFreeCardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFAnnualFreeCard esfAnnualFreeCard = (ESFAnnualFreeCard)session.get(ESFAnnualFreeCardImpl.class,
					primaryKey);

			if (esfAnnualFreeCard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnnualFreeCardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfAnnualFreeCard);
		}
		catch (NoSuchAnnualFreeCardException nsee) {
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
	protected ESFAnnualFreeCard removeImpl(ESFAnnualFreeCard esfAnnualFreeCard)
		throws SystemException {
		esfAnnualFreeCard = toUnwrappedModel(esfAnnualFreeCard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfAnnualFreeCard)) {
				esfAnnualFreeCard = (ESFAnnualFreeCard)session.get(ESFAnnualFreeCardImpl.class,
						esfAnnualFreeCard.getPrimaryKeyObj());
			}

			if (esfAnnualFreeCard != null) {
				session.delete(esfAnnualFreeCard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfAnnualFreeCard != null) {
			clearCache(esfAnnualFreeCard);
		}

		return esfAnnualFreeCard;
	}

	@Override
	public ESFAnnualFreeCard updateImpl(
		it.ethica.esf.model.ESFAnnualFreeCard esfAnnualFreeCard)
		throws SystemException {
		esfAnnualFreeCard = toUnwrappedModel(esfAnnualFreeCard);

		boolean isNew = esfAnnualFreeCard.isNew();

		ESFAnnualFreeCardModelImpl esfAnnualFreeCardModelImpl = (ESFAnnualFreeCardModelImpl)esfAnnualFreeCard;

		Session session = null;

		try {
			session = openSession();

			if (esfAnnualFreeCard.isNew()) {
				session.save(esfAnnualFreeCard);

				esfAnnualFreeCard.setNew(false);
			}
			else {
				session.merge(esfAnnualFreeCard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFAnnualFreeCardModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfAnnualFreeCardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfAnnualFreeCardModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esfAnnualFreeCardModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
			ESFAnnualFreeCardImpl.class, esfAnnualFreeCard.getPrimaryKey(),
			esfAnnualFreeCard);

		return esfAnnualFreeCard;
	}

	protected ESFAnnualFreeCard toUnwrappedModel(
		ESFAnnualFreeCard esfAnnualFreeCard) {
		if (esfAnnualFreeCard instanceof ESFAnnualFreeCardImpl) {
			return esfAnnualFreeCard;
		}

		ESFAnnualFreeCardImpl esfAnnualFreeCardImpl = new ESFAnnualFreeCardImpl();

		esfAnnualFreeCardImpl.setNew(esfAnnualFreeCard.isNew());
		esfAnnualFreeCardImpl.setPrimaryKey(esfAnnualFreeCard.getPrimaryKey());

		esfAnnualFreeCardImpl.setAnnualFreeCardId(esfAnnualFreeCard.getAnnualFreeCardId());
		esfAnnualFreeCardImpl.setCompanyId(esfAnnualFreeCard.getCompanyId());
		esfAnnualFreeCardImpl.setUserId(esfAnnualFreeCard.getUserId());
		esfAnnualFreeCardImpl.setUserName(esfAnnualFreeCard.getUserName());
		esfAnnualFreeCardImpl.setCreateDate(esfAnnualFreeCard.getCreateDate());
		esfAnnualFreeCardImpl.setModifiedDate(esfAnnualFreeCard.getModifiedDate());
		esfAnnualFreeCardImpl.setAssId(esfAnnualFreeCard.getAssId());
		esfAnnualFreeCardImpl.setCode(esfAnnualFreeCard.getCode());
		esfAnnualFreeCardImpl.setCardCode(esfAnnualFreeCard.getCardCode());
		esfAnnualFreeCardImpl.setAssCode(esfAnnualFreeCard.getAssCode());
		esfAnnualFreeCardImpl.setAssName(esfAnnualFreeCard.getAssName());

		return esfAnnualFreeCardImpl;
	}

	/**
	 * Returns the e s f annual free card with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f annual free card
	 * @return the e s f annual free card
	 * @throws it.ethica.esf.NoSuchAnnualFreeCardException if a e s f annual free card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnnualFreeCardException, SystemException {
		ESFAnnualFreeCard esfAnnualFreeCard = fetchByPrimaryKey(primaryKey);

		if (esfAnnualFreeCard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnnualFreeCardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfAnnualFreeCard;
	}

	/**
	 * Returns the e s f annual free card with the primary key or throws a {@link it.ethica.esf.NoSuchAnnualFreeCardException} if it could not be found.
	 *
	 * @param annualFreeCardId the primary key of the e s f annual free card
	 * @return the e s f annual free card
	 * @throws it.ethica.esf.NoSuchAnnualFreeCardException if a e s f annual free card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard findByPrimaryKey(long annualFreeCardId)
		throws NoSuchAnnualFreeCardException, SystemException {
		return findByPrimaryKey((Serializable)annualFreeCardId);
	}

	/**
	 * Returns the e s f annual free card with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f annual free card
	 * @return the e s f annual free card, or <code>null</code> if a e s f annual free card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFAnnualFreeCard esfAnnualFreeCard = (ESFAnnualFreeCard)EntityCacheUtil.getResult(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
				ESFAnnualFreeCardImpl.class, primaryKey);

		if (esfAnnualFreeCard == _nullESFAnnualFreeCard) {
			return null;
		}

		if (esfAnnualFreeCard == null) {
			Session session = null;

			try {
				session = openSession();

				esfAnnualFreeCard = (ESFAnnualFreeCard)session.get(ESFAnnualFreeCardImpl.class,
						primaryKey);

				if (esfAnnualFreeCard != null) {
					cacheResult(esfAnnualFreeCard);
				}
				else {
					EntityCacheUtil.putResult(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
						ESFAnnualFreeCardImpl.class, primaryKey,
						_nullESFAnnualFreeCard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFAnnualFreeCardModelImpl.ENTITY_CACHE_ENABLED,
					ESFAnnualFreeCardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfAnnualFreeCard;
	}

	/**
	 * Returns the e s f annual free card with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param annualFreeCardId the primary key of the e s f annual free card
	 * @return the e s f annual free card, or <code>null</code> if a e s f annual free card with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAnnualFreeCard fetchByPrimaryKey(long annualFreeCardId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)annualFreeCardId);
	}

	/**
	 * Returns all the e s f annual free cards.
	 *
	 * @return the e s f annual free cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualFreeCard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f annual free cards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f annual free cards
	 * @param end the upper bound of the range of e s f annual free cards (not inclusive)
	 * @return the range of e s f annual free cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualFreeCard> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f annual free cards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f annual free cards
	 * @param end the upper bound of the range of e s f annual free cards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f annual free cards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAnnualFreeCard> findAll(int start, int end,
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

		List<ESFAnnualFreeCard> list = (List<ESFAnnualFreeCard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFANNUALFREECARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFANNUALFREECARD;

				if (pagination) {
					sql = sql.concat(ESFAnnualFreeCardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFAnnualFreeCard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFAnnualFreeCard>(list);
				}
				else {
					list = (List<ESFAnnualFreeCard>)QueryUtil.list(q,
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
	 * Removes all the e s f annual free cards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFAnnualFreeCard esfAnnualFreeCard : findAll()) {
			remove(esfAnnualFreeCard);
		}
	}

	/**
	 * Returns the number of e s f annual free cards.
	 *
	 * @return the number of e s f annual free cards
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

				Query q = session.createQuery(_SQL_COUNT_ESFANNUALFREECARD);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the e s f annual free card persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFAnnualFreeCard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFAnnualFreeCard>> listenersList = new ArrayList<ModelListener<ESFAnnualFreeCard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFAnnualFreeCard>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFAnnualFreeCardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFANNUALFREECARD = "SELECT esfAnnualFreeCard FROM ESFAnnualFreeCard esfAnnualFreeCard";
	private static final String _SQL_SELECT_ESFANNUALFREECARD_WHERE = "SELECT esfAnnualFreeCard FROM ESFAnnualFreeCard esfAnnualFreeCard WHERE ";
	private static final String _SQL_COUNT_ESFANNUALFREECARD = "SELECT COUNT(esfAnnualFreeCard) FROM ESFAnnualFreeCard esfAnnualFreeCard";
	private static final String _SQL_COUNT_ESFANNUALFREECARD_WHERE = "SELECT COUNT(esfAnnualFreeCard) FROM ESFAnnualFreeCard esfAnnualFreeCard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfAnnualFreeCard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFAnnualFreeCard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFAnnualFreeCard exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFAnnualFreeCardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static ESFAnnualFreeCard _nullESFAnnualFreeCard = new ESFAnnualFreeCardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFAnnualFreeCard> toCacheModel() {
				return _nullESFAnnualFreeCardCacheModel;
			}
		};

	private static CacheModel<ESFAnnualFreeCard> _nullESFAnnualFreeCardCacheModel =
		new CacheModel<ESFAnnualFreeCard>() {
			@Override
			public ESFAnnualFreeCard toEntityModel() {
				return _nullESFAnnualFreeCard;
			}
		};
}