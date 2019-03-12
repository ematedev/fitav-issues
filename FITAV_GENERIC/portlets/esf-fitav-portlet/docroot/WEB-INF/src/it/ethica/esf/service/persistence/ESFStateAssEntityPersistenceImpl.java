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

import it.ethica.esf.NoSuchStateAssEntityException;
import it.ethica.esf.model.ESFStateAssEntity;
import it.ethica.esf.model.impl.ESFStateAssEntityImpl;
import it.ethica.esf.model.impl.ESFStateAssEntityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f state ass entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFStateAssEntityPersistence
 * @see ESFStateAssEntityUtil
 * @generated
 */
public class ESFStateAssEntityPersistenceImpl extends BasePersistenceImpl<ESFStateAssEntity>
	implements ESFStateAssEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFStateAssEntityUtil} to access the e s f state ass entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFStateAssEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED,
			ESFStateAssEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED,
			ESFStateAssEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED,
			ESFStateAssEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED,
			ESFStateAssEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassName",
			new String[] { String.class.getName() },
			ESFStateAssEntityModelImpl.CLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAME = new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f state ass entities where className = &#63;.
	 *
	 * @param className the class name
	 * @return the matching e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findByClassName(String className)
		throws SystemException {
		return findByClassName(className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f state ass entities where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of e s f state ass entities
	 * @param end the upper bound of the range of e s f state ass entities (not inclusive)
	 * @return the range of matching e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findByClassName(String className, int start,
		int end) throws SystemException {
		return findByClassName(className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f state ass entities where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of e s f state ass entities
	 * @param end the upper bound of the range of e s f state ass entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findByClassName(String className, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { className };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { className, start, end, orderByComparator };
		}

		List<ESFStateAssEntity> list = (List<ESFStateAssEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFStateAssEntity esfStateAssEntity : list) {
				if (!Validator.equals(className,
							esfStateAssEntity.getClassName())) {
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

			query.append(_SQL_SELECT_ESFSTATEASSENTITY_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFStateAssEntityModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFStateAssEntity>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFStateAssEntity>(list);
				}
				else {
					list = (List<ESFStateAssEntity>)QueryUtil.list(q,
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
	 * Returns the first e s f state ass entity in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f state ass entity
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a matching e s f state ass entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity findByClassName_First(String className,
		OrderByComparator orderByComparator)
		throws NoSuchStateAssEntityException, SystemException {
		ESFStateAssEntity esfStateAssEntity = fetchByClassName_First(className,
				orderByComparator);

		if (esfStateAssEntity != null) {
			return esfStateAssEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStateAssEntityException(msg.toString());
	}

	/**
	 * Returns the first e s f state ass entity in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f state ass entity, or <code>null</code> if a matching e s f state ass entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity fetchByClassName_First(String className,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFStateAssEntity> list = findByClassName(className, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f state ass entity in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f state ass entity
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a matching e s f state ass entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity findByClassName_Last(String className,
		OrderByComparator orderByComparator)
		throws NoSuchStateAssEntityException, SystemException {
		ESFStateAssEntity esfStateAssEntity = fetchByClassName_Last(className,
				orderByComparator);

		if (esfStateAssEntity != null) {
			return esfStateAssEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStateAssEntityException(msg.toString());
	}

	/**
	 * Returns the last e s f state ass entity in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f state ass entity, or <code>null</code> if a matching e s f state ass entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity fetchByClassName_Last(String className,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByClassName(className);

		if (count == 0) {
			return null;
		}

		List<ESFStateAssEntity> list = findByClassName(className, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f state ass entities before and after the current e s f state ass entity in the ordered set where className = &#63;.
	 *
	 * @param esfStateAssEntityPK the primary key of the current e s f state ass entity
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f state ass entity
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity[] findByClassName_PrevAndNext(
		ESFStateAssEntityPK esfStateAssEntityPK, String className,
		OrderByComparator orderByComparator)
		throws NoSuchStateAssEntityException, SystemException {
		ESFStateAssEntity esfStateAssEntity = findByPrimaryKey(esfStateAssEntityPK);

		Session session = null;

		try {
			session = openSession();

			ESFStateAssEntity[] array = new ESFStateAssEntityImpl[3];

			array[0] = getByClassName_PrevAndNext(session, esfStateAssEntity,
					className, orderByComparator, true);

			array[1] = esfStateAssEntity;

			array[2] = getByClassName_PrevAndNext(session, esfStateAssEntity,
					className, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFStateAssEntity getByClassName_PrevAndNext(Session session,
		ESFStateAssEntity esfStateAssEntity, String className,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSTATEASSENTITY_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
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
			query.append(ESFStateAssEntityModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfStateAssEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFStateAssEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f state ass entities where className = &#63; from the database.
	 *
	 * @param className the class name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassName(String className) throws SystemException {
		for (ESFStateAssEntity esfStateAssEntity : findByClassName(className,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfStateAssEntity);
		}
	}

	/**
	 * Returns the number of e s f state ass entities where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassName(String className) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAME;

		Object[] finderArgs = new Object[] { className };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSTATEASSENTITY_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
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

	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_1 = "esfStateAssEntity.id.className IS NULL";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_2 = "esfStateAssEntity.id.className = ?";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_3 = "(esfStateAssEntity.id.className IS NULL OR esfStateAssEntity.id.className = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSTATEID =
		new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED,
			ESFStateAssEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFStateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTATEID =
		new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED,
			ESFStateAssEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFStateId",
			new String[] { Long.class.getName() },
			ESFStateAssEntityModelImpl.ESFSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFSTATEID = new FinderPath(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFStateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f state ass entities where esfStateId = &#63;.
	 *
	 * @param esfStateId the esf state ID
	 * @return the matching e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findByESFStateId(long esfStateId)
		throws SystemException {
		return findByESFStateId(esfStateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f state ass entities where esfStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfStateId the esf state ID
	 * @param start the lower bound of the range of e s f state ass entities
	 * @param end the upper bound of the range of e s f state ass entities (not inclusive)
	 * @return the range of matching e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findByESFStateId(long esfStateId, int start,
		int end) throws SystemException {
		return findByESFStateId(esfStateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f state ass entities where esfStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfStateId the esf state ID
	 * @param start the lower bound of the range of e s f state ass entities
	 * @param end the upper bound of the range of e s f state ass entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findByESFStateId(long esfStateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTATEID;
			finderArgs = new Object[] { esfStateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSTATEID;
			finderArgs = new Object[] { esfStateId, start, end, orderByComparator };
		}

		List<ESFStateAssEntity> list = (List<ESFStateAssEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFStateAssEntity esfStateAssEntity : list) {
				if ((esfStateId != esfStateAssEntity.getEsfStateId())) {
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

			query.append(_SQL_SELECT_ESFSTATEASSENTITY_WHERE);

			query.append(_FINDER_COLUMN_ESFSTATEID_ESFSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFStateAssEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfStateId);

				if (!pagination) {
					list = (List<ESFStateAssEntity>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFStateAssEntity>(list);
				}
				else {
					list = (List<ESFStateAssEntity>)QueryUtil.list(q,
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
	 * Returns the first e s f state ass entity in the ordered set where esfStateId = &#63;.
	 *
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f state ass entity
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a matching e s f state ass entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity findByESFStateId_First(long esfStateId,
		OrderByComparator orderByComparator)
		throws NoSuchStateAssEntityException, SystemException {
		ESFStateAssEntity esfStateAssEntity = fetchByESFStateId_First(esfStateId,
				orderByComparator);

		if (esfStateAssEntity != null) {
			return esfStateAssEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfStateId=");
		msg.append(esfStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStateAssEntityException(msg.toString());
	}

	/**
	 * Returns the first e s f state ass entity in the ordered set where esfStateId = &#63;.
	 *
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f state ass entity, or <code>null</code> if a matching e s f state ass entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity fetchByESFStateId_First(long esfStateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFStateAssEntity> list = findByESFStateId(esfStateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f state ass entity in the ordered set where esfStateId = &#63;.
	 *
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f state ass entity
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a matching e s f state ass entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity findByESFStateId_Last(long esfStateId,
		OrderByComparator orderByComparator)
		throws NoSuchStateAssEntityException, SystemException {
		ESFStateAssEntity esfStateAssEntity = fetchByESFStateId_Last(esfStateId,
				orderByComparator);

		if (esfStateAssEntity != null) {
			return esfStateAssEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfStateId=");
		msg.append(esfStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStateAssEntityException(msg.toString());
	}

	/**
	 * Returns the last e s f state ass entity in the ordered set where esfStateId = &#63;.
	 *
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f state ass entity, or <code>null</code> if a matching e s f state ass entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity fetchByESFStateId_Last(long esfStateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFStateId(esfStateId);

		if (count == 0) {
			return null;
		}

		List<ESFStateAssEntity> list = findByESFStateId(esfStateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f state ass entities before and after the current e s f state ass entity in the ordered set where esfStateId = &#63;.
	 *
	 * @param esfStateAssEntityPK the primary key of the current e s f state ass entity
	 * @param esfStateId the esf state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f state ass entity
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity[] findByESFStateId_PrevAndNext(
		ESFStateAssEntityPK esfStateAssEntityPK, long esfStateId,
		OrderByComparator orderByComparator)
		throws NoSuchStateAssEntityException, SystemException {
		ESFStateAssEntity esfStateAssEntity = findByPrimaryKey(esfStateAssEntityPK);

		Session session = null;

		try {
			session = openSession();

			ESFStateAssEntity[] array = new ESFStateAssEntityImpl[3];

			array[0] = getByESFStateId_PrevAndNext(session, esfStateAssEntity,
					esfStateId, orderByComparator, true);

			array[1] = esfStateAssEntity;

			array[2] = getByESFStateId_PrevAndNext(session, esfStateAssEntity,
					esfStateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFStateAssEntity getByESFStateId_PrevAndNext(Session session,
		ESFStateAssEntity esfStateAssEntity, long esfStateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSTATEASSENTITY_WHERE);

		query.append(_FINDER_COLUMN_ESFSTATEID_ESFSTATEID_2);

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
			query.append(ESFStateAssEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfStateAssEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFStateAssEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f state ass entities where esfStateId = &#63; from the database.
	 *
	 * @param esfStateId the esf state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFStateId(long esfStateId) throws SystemException {
		for (ESFStateAssEntity esfStateAssEntity : findByESFStateId(
				esfStateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfStateAssEntity);
		}
	}

	/**
	 * Returns the number of e s f state ass entities where esfStateId = &#63;.
	 *
	 * @param esfStateId the esf state ID
	 * @return the number of matching e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFStateId(long esfStateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFSTATEID;

		Object[] finderArgs = new Object[] { esfStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSTATEASSENTITY_WHERE);

			query.append(_FINDER_COLUMN_ESFSTATEID_ESFSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_ESFSTATEID_ESFSTATEID_2 = "esfStateAssEntity.id.esfStateId = ?";

	public ESFStateAssEntityPersistenceImpl() {
		setModelClass(ESFStateAssEntity.class);
	}

	/**
	 * Caches the e s f state ass entity in the entity cache if it is enabled.
	 *
	 * @param esfStateAssEntity the e s f state ass entity
	 */
	@Override
	public void cacheResult(ESFStateAssEntity esfStateAssEntity) {
		EntityCacheUtil.putResult(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityImpl.class, esfStateAssEntity.getPrimaryKey(),
			esfStateAssEntity);

		esfStateAssEntity.resetOriginalValues();
	}

	/**
	 * Caches the e s f state ass entities in the entity cache if it is enabled.
	 *
	 * @param esfStateAssEntities the e s f state ass entities
	 */
	@Override
	public void cacheResult(List<ESFStateAssEntity> esfStateAssEntities) {
		for (ESFStateAssEntity esfStateAssEntity : esfStateAssEntities) {
			if (EntityCacheUtil.getResult(
						ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
						ESFStateAssEntityImpl.class,
						esfStateAssEntity.getPrimaryKey()) == null) {
				cacheResult(esfStateAssEntity);
			}
			else {
				esfStateAssEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f state ass entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFStateAssEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFStateAssEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f state ass entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFStateAssEntity esfStateAssEntity) {
		EntityCacheUtil.removeResult(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityImpl.class, esfStateAssEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFStateAssEntity> esfStateAssEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFStateAssEntity esfStateAssEntity : esfStateAssEntities) {
			EntityCacheUtil.removeResult(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
				ESFStateAssEntityImpl.class, esfStateAssEntity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f state ass entity with the primary key. Does not add the e s f state ass entity to the database.
	 *
	 * @param esfStateAssEntityPK the primary key for the new e s f state ass entity
	 * @return the new e s f state ass entity
	 */
	@Override
	public ESFStateAssEntity create(ESFStateAssEntityPK esfStateAssEntityPK) {
		ESFStateAssEntity esfStateAssEntity = new ESFStateAssEntityImpl();

		esfStateAssEntity.setNew(true);
		esfStateAssEntity.setPrimaryKey(esfStateAssEntityPK);

		return esfStateAssEntity;
	}

	/**
	 * Removes the e s f state ass entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfStateAssEntityPK the primary key of the e s f state ass entity
	 * @return the e s f state ass entity that was removed
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity remove(ESFStateAssEntityPK esfStateAssEntityPK)
		throws NoSuchStateAssEntityException, SystemException {
		return remove((Serializable)esfStateAssEntityPK);
	}

	/**
	 * Removes the e s f state ass entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f state ass entity
	 * @return the e s f state ass entity that was removed
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity remove(Serializable primaryKey)
		throws NoSuchStateAssEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFStateAssEntity esfStateAssEntity = (ESFStateAssEntity)session.get(ESFStateAssEntityImpl.class,
					primaryKey);

			if (esfStateAssEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStateAssEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfStateAssEntity);
		}
		catch (NoSuchStateAssEntityException nsee) {
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
	protected ESFStateAssEntity removeImpl(ESFStateAssEntity esfStateAssEntity)
		throws SystemException {
		esfStateAssEntity = toUnwrappedModel(esfStateAssEntity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfStateAssEntity)) {
				esfStateAssEntity = (ESFStateAssEntity)session.get(ESFStateAssEntityImpl.class,
						esfStateAssEntity.getPrimaryKeyObj());
			}

			if (esfStateAssEntity != null) {
				session.delete(esfStateAssEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfStateAssEntity != null) {
			clearCache(esfStateAssEntity);
		}

		return esfStateAssEntity;
	}

	@Override
	public ESFStateAssEntity updateImpl(
		it.ethica.esf.model.ESFStateAssEntity esfStateAssEntity)
		throws SystemException {
		esfStateAssEntity = toUnwrappedModel(esfStateAssEntity);

		boolean isNew = esfStateAssEntity.isNew();

		ESFStateAssEntityModelImpl esfStateAssEntityModelImpl = (ESFStateAssEntityModelImpl)esfStateAssEntity;

		Session session = null;

		try {
			session = openSession();

			if (esfStateAssEntity.isNew()) {
				session.save(esfStateAssEntity);

				esfStateAssEntity.setNew(false);
			}
			else {
				session.merge(esfStateAssEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFStateAssEntityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfStateAssEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfStateAssEntityModelImpl.getOriginalClassName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);

				args = new Object[] { esfStateAssEntityModelImpl.getClassName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);
			}

			if ((esfStateAssEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfStateAssEntityModelImpl.getOriginalEsfStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTATEID,
					args);

				args = new Object[] { esfStateAssEntityModelImpl.getEsfStateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
			ESFStateAssEntityImpl.class, esfStateAssEntity.getPrimaryKey(),
			esfStateAssEntity);

		return esfStateAssEntity;
	}

	protected ESFStateAssEntity toUnwrappedModel(
		ESFStateAssEntity esfStateAssEntity) {
		if (esfStateAssEntity instanceof ESFStateAssEntityImpl) {
			return esfStateAssEntity;
		}

		ESFStateAssEntityImpl esfStateAssEntityImpl = new ESFStateAssEntityImpl();

		esfStateAssEntityImpl.setNew(esfStateAssEntity.isNew());
		esfStateAssEntityImpl.setPrimaryKey(esfStateAssEntity.getPrimaryKey());

		esfStateAssEntityImpl.setEsfStateId(esfStateAssEntity.getEsfStateId());
		esfStateAssEntityImpl.setClassName(esfStateAssEntity.getClassName());

		return esfStateAssEntityImpl;
	}

	/**
	 * Returns the e s f state ass entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f state ass entity
	 * @return the e s f state ass entity
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStateAssEntityException, SystemException {
		ESFStateAssEntity esfStateAssEntity = fetchByPrimaryKey(primaryKey);

		if (esfStateAssEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStateAssEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfStateAssEntity;
	}

	/**
	 * Returns the e s f state ass entity with the primary key or throws a {@link it.ethica.esf.NoSuchStateAssEntityException} if it could not be found.
	 *
	 * @param esfStateAssEntityPK the primary key of the e s f state ass entity
	 * @return the e s f state ass entity
	 * @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity findByPrimaryKey(
		ESFStateAssEntityPK esfStateAssEntityPK)
		throws NoSuchStateAssEntityException, SystemException {
		return findByPrimaryKey((Serializable)esfStateAssEntityPK);
	}

	/**
	 * Returns the e s f state ass entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f state ass entity
	 * @return the e s f state ass entity, or <code>null</code> if a e s f state ass entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFStateAssEntity esfStateAssEntity = (ESFStateAssEntity)EntityCacheUtil.getResult(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
				ESFStateAssEntityImpl.class, primaryKey);

		if (esfStateAssEntity == _nullESFStateAssEntity) {
			return null;
		}

		if (esfStateAssEntity == null) {
			Session session = null;

			try {
				session = openSession();

				esfStateAssEntity = (ESFStateAssEntity)session.get(ESFStateAssEntityImpl.class,
						primaryKey);

				if (esfStateAssEntity != null) {
					cacheResult(esfStateAssEntity);
				}
				else {
					EntityCacheUtil.putResult(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
						ESFStateAssEntityImpl.class, primaryKey,
						_nullESFStateAssEntity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFStateAssEntityModelImpl.ENTITY_CACHE_ENABLED,
					ESFStateAssEntityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfStateAssEntity;
	}

	/**
	 * Returns the e s f state ass entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfStateAssEntityPK the primary key of the e s f state ass entity
	 * @return the e s f state ass entity, or <code>null</code> if a e s f state ass entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStateAssEntity fetchByPrimaryKey(
		ESFStateAssEntityPK esfStateAssEntityPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfStateAssEntityPK);
	}

	/**
	 * Returns all the e s f state ass entities.
	 *
	 * @return the e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f state ass entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f state ass entities
	 * @param end the upper bound of the range of e s f state ass entities (not inclusive)
	 * @return the range of e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f state ass entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f state ass entities
	 * @param end the upper bound of the range of e s f state ass entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f state ass entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStateAssEntity> findAll(int start, int end,
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

		List<ESFStateAssEntity> list = (List<ESFStateAssEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSTATEASSENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSTATEASSENTITY;

				if (pagination) {
					sql = sql.concat(ESFStateAssEntityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFStateAssEntity>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFStateAssEntity>(list);
				}
				else {
					list = (List<ESFStateAssEntity>)QueryUtil.list(q,
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
	 * Removes all the e s f state ass entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFStateAssEntity esfStateAssEntity : findAll()) {
			remove(esfStateAssEntity);
		}
	}

	/**
	 * Returns the number of e s f state ass entities.
	 *
	 * @return the number of e s f state ass entities
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

				Query q = session.createQuery(_SQL_COUNT_ESFSTATEASSENTITY);

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
	 * Initializes the e s f state ass entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFStateAssEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFStateAssEntity>> listenersList = new ArrayList<ModelListener<ESFStateAssEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFStateAssEntity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFStateAssEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSTATEASSENTITY = "SELECT esfStateAssEntity FROM ESFStateAssEntity esfStateAssEntity";
	private static final String _SQL_SELECT_ESFSTATEASSENTITY_WHERE = "SELECT esfStateAssEntity FROM ESFStateAssEntity esfStateAssEntity WHERE ";
	private static final String _SQL_COUNT_ESFSTATEASSENTITY = "SELECT COUNT(esfStateAssEntity) FROM ESFStateAssEntity esfStateAssEntity";
	private static final String _SQL_COUNT_ESFSTATEASSENTITY_WHERE = "SELECT COUNT(esfStateAssEntity) FROM ESFStateAssEntity esfStateAssEntity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfStateAssEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFStateAssEntity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFStateAssEntity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFStateAssEntityPersistenceImpl.class);
	private static ESFStateAssEntity _nullESFStateAssEntity = new ESFStateAssEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFStateAssEntity> toCacheModel() {
				return _nullESFStateAssEntityCacheModel;
			}
		};

	private static CacheModel<ESFStateAssEntity> _nullESFStateAssEntityCacheModel =
		new CacheModel<ESFStateAssEntity>() {
			@Override
			public ESFStateAssEntity toEntityModel() {
				return _nullESFStateAssEntity;
			}
		};
}