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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import it.ethica.esf.NoSuchDocumentException;
import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.impl.ESFDocumentImpl;
import it.ethica.esf.model.impl.ESFDocumentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentPersistence
 * @see ESFDocumentUtil
 * @generated
 */
public class ESFDocumentPersistenceImpl extends BasePersistenceImpl<ESFDocument>
	implements ESFDocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFDocumentUtil} to access the e s f document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFDocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ESFDocumentModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f documents where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByCode(String code) throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByCode(String code, int start, int end,
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

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if (!Validator.equals(code, esfDocument.getCode())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

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
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByCode_First(code, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByCode_Last(code, orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where code = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByCode_PrevAndNext(long esfDocumentId,
		String code, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByCode_PrevAndNext(session, esfDocument, code,
					orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByCode_PrevAndNext(session, esfDocument, code,
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

	protected ESFDocument getByCode_PrevAndNext(Session session,
		ESFDocument esfDocument, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ESFDocument esfDocument : findByCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfDocument.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfDocument.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfDocument.code IS NULL OR esfDocument.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesfUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesfUserId",
			new String[] { Long.class.getName() },
			ESFDocumentModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERID = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByesfUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f documents where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByesfUserId(long esfUserId)
		throws SystemException {
		return findByesfUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f documents where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByesfUserId(long esfUserId, int start, int end)
		throws SystemException {
		return findByesfUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByesfUserId(long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if ((esfUserId != esfDocument.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByesfUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByesfUserId_First(esfUserId,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByesfUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByesfUserId(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByesfUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByesfUserId_Last(esfUserId,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByesfUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByesfUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByesfUserId(esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByesfUserId_PrevAndNext(long esfDocumentId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByesfUserId_PrevAndNext(session, esfDocument,
					esfUserId, orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByesfUserId_PrevAndNext(session, esfDocument,
					esfUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFDocument getByesfUserId_PrevAndNext(Session session,
		ESFDocument esfDocument, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByesfUserId(long esfUserId) throws SystemException {
		for (ESFDocument esfDocument : findByesfUserId(esfUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByesfUserId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

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

	private static final String _FINDER_COLUMN_ESFUSERID_ESFUSERID_2 = "esfDocument.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_U = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_U",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_U = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_U",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFDocumentModelImpl.TYPE_COLUMN_BITMASK |
			ESFDocumentModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_U = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_U",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f documents where type = &#63; and esfUserId = &#63;.
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByT_U(String type, long esfUserId)
		throws SystemException {
		return findByT_U(type, esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f documents where type = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByT_U(String type, long esfUserId, int start,
		int end) throws SystemException {
		return findByT_U(type, esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where type = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByT_U(String type, long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_U;
			finderArgs = new Object[] { type, esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_U;
			finderArgs = new Object[] {
					type, esfUserId,
					
					start, end, orderByComparator
				};
		}

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if (!Validator.equals(type, esfDocument.getType()) ||
						(esfUserId != esfDocument.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_T_U_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_U_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_T_U_TYPE_2);
			}

			query.append(_FINDER_COLUMN_T_U_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByT_U_First(String type, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByT_U_First(type, esfUserId,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByT_U_First(String type, long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByT_U(type, esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByT_U_Last(String type, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByT_U_Last(type, esfUserId,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByT_U_Last(String type, long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_U(type, esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByT_U(type, esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByT_U_PrevAndNext(long esfDocumentId, String type,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByT_U_PrevAndNext(session, esfDocument, type,
					esfUserId, orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByT_U_PrevAndNext(session, esfDocument, type,
					esfUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFDocument getByT_U_PrevAndNext(Session session,
		ESFDocument esfDocument, String type, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_T_U_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_T_U_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_T_U_TYPE_2);
		}

		query.append(_FINDER_COLUMN_T_U_ESFUSERID_2);

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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where type = &#63; and esfUserId = &#63; from the database.
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_U(String type, long esfUserId)
		throws SystemException {
		for (ESFDocument esfDocument : findByT_U(type, esfUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where type = &#63; and esfUserId = &#63;.
	 *
	 * @param type the type
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_U(String type, long esfUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_U;

		Object[] finderArgs = new Object[] { type, esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_T_U_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_U_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_T_U_TYPE_2);
			}

			query.append(_FINDER_COLUMN_T_U_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				qPos.add(esfUserId);

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

	private static final String _FINDER_COLUMN_T_U_TYPE_1 = "esfDocument.type IS NULL AND ";
	private static final String _FINDER_COLUMN_T_U_TYPE_2 = "esfDocument.type = ? AND ";
	private static final String _FINDER_COLUMN_T_U_TYPE_3 = "(esfDocument.type IS NULL OR esfDocument.type = '') AND ";
	private static final String _FINDER_COLUMN_T_U_ESFUSERID_2 = "esfDocument.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_ED = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_ED",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ED = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, ESFDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_ED",
			new String[] { Long.class.getName(), Date.class.getName() },
			ESFDocumentModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFDocumentModelImpl.EXPIRATIONDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_ED = new FinderPath(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_ED",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @return the matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByU_ED(long esfUserId, Date expirationDate)
		throws SystemException {
		return findByU_ED(esfUserId, expirationDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByU_ED(long esfUserId, Date expirationDate,
		int start, int end) throws SystemException {
		return findByU_ED(esfUserId, expirationDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findByU_ED(long esfUserId, Date expirationDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ED;
			finderArgs = new Object[] { esfUserId, expirationDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_ED;
			finderArgs = new Object[] {
					esfUserId, expirationDate,
					
					start, end, orderByComparator
				};
		}

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFDocument esfDocument : list) {
				if ((esfUserId != esfDocument.getEsfUserId()) ||
						!Validator.equals(expirationDate,
							esfDocument.getExpirationDate())) {
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

			query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_U_ED_ESFUSERID_2);

			boolean bindExpirationDate = false;

			if (expirationDate == null) {
				query.append(_FINDER_COLUMN_U_ED_EXPIRATIONDATE_1);
			}
			else {
				bindExpirationDate = true;

				query.append(_FINDER_COLUMN_U_ED_EXPIRATIONDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (bindExpirationDate) {
					qPos.add(CalendarUtil.getTimestamp(expirationDate));
				}

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByU_ED_First(long esfUserId, Date expirationDate,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByU_ED_First(esfUserId, expirationDate,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", expirationDate=");
		msg.append(expirationDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByU_ED_First(long esfUserId, Date expirationDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFDocument> list = findByU_ED(esfUserId, expirationDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByU_ED_Last(long esfUserId, Date expirationDate,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByU_ED_Last(esfUserId, expirationDate,
				orderByComparator);

		if (esfDocument != null) {
			return esfDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", expirationDate=");
		msg.append(expirationDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByU_ED_Last(long esfUserId, Date expirationDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByU_ED(esfUserId, expirationDate);

		if (count == 0) {
			return null;
		}

		List<ESFDocument> list = findByU_ED(esfUserId, expirationDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f documents before and after the current e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * @param esfDocumentId the primary key of the current e s f document
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument[] findByU_ED_PrevAndNext(long esfDocumentId,
		long esfUserId, Date expirationDate, OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = findByPrimaryKey(esfDocumentId);

		Session session = null;

		try {
			session = openSession();

			ESFDocument[] array = new ESFDocumentImpl[3];

			array[0] = getByU_ED_PrevAndNext(session, esfDocument, esfUserId,
					expirationDate, orderByComparator, true);

			array[1] = esfDocument;

			array[2] = getByU_ED_PrevAndNext(session, esfDocument, esfUserId,
					expirationDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFDocument getByU_ED_PrevAndNext(Session session,
		ESFDocument esfDocument, long esfUserId, Date expirationDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_U_ED_ESFUSERID_2);

		boolean bindExpirationDate = false;

		if (expirationDate == null) {
			query.append(_FINDER_COLUMN_U_ED_EXPIRATIONDATE_1);
		}
		else {
			bindExpirationDate = true;

			query.append(_FINDER_COLUMN_U_ED_EXPIRATIONDATE_2);
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
			query.append(ESFDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (bindExpirationDate) {
			qPos.add(CalendarUtil.getTimestamp(expirationDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f documents where esfUserId = &#63; and expirationDate = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByU_ED(long esfUserId, Date expirationDate)
		throws SystemException {
		for (ESFDocument esfDocument : findByU_ED(esfUserId, expirationDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param expirationDate the expiration date
	 * @return the number of matching e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByU_ED(long esfUserId, Date expirationDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_ED;

		Object[] finderArgs = new Object[] { esfUserId, expirationDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_U_ED_ESFUSERID_2);

			boolean bindExpirationDate = false;

			if (expirationDate == null) {
				query.append(_FINDER_COLUMN_U_ED_EXPIRATIONDATE_1);
			}
			else {
				bindExpirationDate = true;

				query.append(_FINDER_COLUMN_U_ED_EXPIRATIONDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (bindExpirationDate) {
					qPos.add(CalendarUtil.getTimestamp(expirationDate));
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

	private static final String _FINDER_COLUMN_U_ED_ESFUSERID_2 = "esfDocument.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_U_ED_EXPIRATIONDATE_1 = "esfDocument.expirationDate IS NULL";
	private static final String _FINDER_COLUMN_U_ED_EXPIRATIONDATE_2 = "esfDocument.expirationDate = ?";

	public ESFDocumentPersistenceImpl() {
		setModelClass(ESFDocument.class);
	}

	/**
	 * Caches the e s f document in the entity cache if it is enabled.
	 *
	 * @param esfDocument the e s f document
	 */
	@Override
	public void cacheResult(ESFDocument esfDocument) {
		EntityCacheUtil.putResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentImpl.class, esfDocument.getPrimaryKey(), esfDocument);

		esfDocument.resetOriginalValues();
	}

	/**
	 * Caches the e s f documents in the entity cache if it is enabled.
	 *
	 * @param esfDocuments the e s f documents
	 */
	@Override
	public void cacheResult(List<ESFDocument> esfDocuments) {
		for (ESFDocument esfDocument : esfDocuments) {
			if (EntityCacheUtil.getResult(
						ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
						ESFDocumentImpl.class, esfDocument.getPrimaryKey()) == null) {
				cacheResult(esfDocument);
			}
			else {
				esfDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFDocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFDocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f document.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFDocument esfDocument) {
		EntityCacheUtil.removeResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentImpl.class, esfDocument.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFDocument> esfDocuments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFDocument esfDocument : esfDocuments) {
			EntityCacheUtil.removeResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
				ESFDocumentImpl.class, esfDocument.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f document with the primary key. Does not add the e s f document to the database.
	 *
	 * @param esfDocumentId the primary key for the new e s f document
	 * @return the new e s f document
	 */
	@Override
	public ESFDocument create(long esfDocumentId) {
		ESFDocument esfDocument = new ESFDocumentImpl();

		esfDocument.setNew(true);
		esfDocument.setPrimaryKey(esfDocumentId);

		return esfDocument;
	}

	/**
	 * Removes the e s f document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfDocumentId the primary key of the e s f document
	 * @return the e s f document that was removed
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument remove(long esfDocumentId)
		throws NoSuchDocumentException, SystemException {
		return remove((Serializable)esfDocumentId);
	}

	/**
	 * Removes the e s f document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f document
	 * @return the e s f document that was removed
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument remove(Serializable primaryKey)
		throws NoSuchDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFDocument esfDocument = (ESFDocument)session.get(ESFDocumentImpl.class,
					primaryKey);

			if (esfDocument == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfDocument);
		}
		catch (NoSuchDocumentException nsee) {
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
	protected ESFDocument removeImpl(ESFDocument esfDocument)
		throws SystemException {
		esfDocument = toUnwrappedModel(esfDocument);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfDocument)) {
				esfDocument = (ESFDocument)session.get(ESFDocumentImpl.class,
						esfDocument.getPrimaryKeyObj());
			}

			if (esfDocument != null) {
				session.delete(esfDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfDocument != null) {
			clearCache(esfDocument);
		}

		return esfDocument;
	}

	@Override
	public ESFDocument updateImpl(it.ethica.esf.model.ESFDocument esfDocument)
		throws SystemException {
		esfDocument = toUnwrappedModel(esfDocument);

		boolean isNew = esfDocument.isNew();

		ESFDocumentModelImpl esfDocumentModelImpl = (ESFDocumentModelImpl)esfDocument;

		Session session = null;

		try {
			session = openSession();

			if (esfDocument.isNew()) {
				session.save(esfDocument);

				esfDocument.setNew(false);
			}
			else {
				session.merge(esfDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFDocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esfDocumentModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);

				args = new Object[] { esfDocumentModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalType(),
						esfDocumentModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_U,
					args);

				args = new Object[] {
						esfDocumentModelImpl.getType(),
						esfDocumentModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_U,
					args);
			}

			if ((esfDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfDocumentModelImpl.getOriginalEsfUserId(),
						esfDocumentModelImpl.getOriginalExpirationDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_ED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ED,
					args);

				args = new Object[] {
						esfDocumentModelImpl.getEsfUserId(),
						esfDocumentModelImpl.getExpirationDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_ED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ED,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ESFDocumentImpl.class, esfDocument.getPrimaryKey(), esfDocument);

		return esfDocument;
	}

	protected ESFDocument toUnwrappedModel(ESFDocument esfDocument) {
		if (esfDocument instanceof ESFDocumentImpl) {
			return esfDocument;
		}

		ESFDocumentImpl esfDocumentImpl = new ESFDocumentImpl();

		esfDocumentImpl.setNew(esfDocument.isNew());
		esfDocumentImpl.setPrimaryKey(esfDocument.getPrimaryKey());

		esfDocumentImpl.setEsfDocumentId(esfDocument.getEsfDocumentId());
		esfDocumentImpl.setGroupId(esfDocument.getGroupId());
		esfDocumentImpl.setCompanyId(esfDocument.getCompanyId());
		esfDocumentImpl.setUserId(esfDocument.getUserId());
		esfDocumentImpl.setUserName(esfDocument.getUserName());
		esfDocumentImpl.setCreateDate(esfDocument.getCreateDate());
		esfDocumentImpl.setModifiedDate(esfDocument.getModifiedDate());
		esfDocumentImpl.setCode(esfDocument.getCode());
		esfDocumentImpl.setReleasedBy(esfDocument.getReleasedBy());
		esfDocumentImpl.setReleaseDate(esfDocument.getReleaseDate());
		esfDocumentImpl.setExpirationDate(esfDocument.getExpirationDate());
		esfDocumentImpl.setEsfUserId(esfDocument.getEsfUserId());
		esfDocumentImpl.setType(esfDocument.getType());
		esfDocumentImpl.setPath(esfDocument.getPath());

		return esfDocumentImpl;
	}

	/**
	 * Returns the e s f document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f document
	 * @return the e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentException, SystemException {
		ESFDocument esfDocument = fetchByPrimaryKey(primaryKey);

		if (esfDocument == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfDocument;
	}

	/**
	 * Returns the e s f document with the primary key or throws a {@link it.ethica.esf.NoSuchDocumentException} if it could not be found.
	 *
	 * @param esfDocumentId the primary key of the e s f document
	 * @return the e s f document
	 * @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument findByPrimaryKey(long esfDocumentId)
		throws NoSuchDocumentException, SystemException {
		return findByPrimaryKey((Serializable)esfDocumentId);
	}

	/**
	 * Returns the e s f document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f document
	 * @return the e s f document, or <code>null</code> if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFDocument esfDocument = (ESFDocument)EntityCacheUtil.getResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
				ESFDocumentImpl.class, primaryKey);

		if (esfDocument == _nullESFDocument) {
			return null;
		}

		if (esfDocument == null) {
			Session session = null;

			try {
				session = openSession();

				esfDocument = (ESFDocument)session.get(ESFDocumentImpl.class,
						primaryKey);

				if (esfDocument != null) {
					cacheResult(esfDocument);
				}
				else {
					EntityCacheUtil.putResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
						ESFDocumentImpl.class, primaryKey, _nullESFDocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFDocumentModelImpl.ENTITY_CACHE_ENABLED,
					ESFDocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfDocument;
	}

	/**
	 * Returns the e s f document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfDocumentId the primary key of the e s f document
	 * @return the e s f document, or <code>null</code> if a e s f document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFDocument fetchByPrimaryKey(long esfDocumentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfDocumentId);
	}

	/**
	 * Returns all the e s f documents.
	 *
	 * @return the e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @return the range of e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f documents
	 * @param end the upper bound of the range of e s f documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFDocument> findAll(int start, int end,
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

		List<ESFDocument> list = (List<ESFDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFDOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFDOCUMENT;

				if (pagination) {
					sql = sql.concat(ESFDocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFDocument>(list);
				}
				else {
					list = (List<ESFDocument>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f documents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFDocument esfDocument : findAll()) {
			remove(esfDocument);
		}
	}

	/**
	 * Returns the number of e s f documents.
	 *
	 * @return the number of e s f documents
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

				Query q = session.createQuery(_SQL_COUNT_ESFDOCUMENT);

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
	 * Initializes the e s f document persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFDocument")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFDocument>> listenersList = new ArrayList<ModelListener<ESFDocument>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFDocument>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFDocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFDOCUMENT = "SELECT esfDocument FROM ESFDocument esfDocument";
	private static final String _SQL_SELECT_ESFDOCUMENT_WHERE = "SELECT esfDocument FROM ESFDocument esfDocument WHERE ";
	private static final String _SQL_COUNT_ESFDOCUMENT = "SELECT COUNT(esfDocument) FROM ESFDocument esfDocument";
	private static final String _SQL_COUNT_ESFDOCUMENT_WHERE = "SELECT COUNT(esfDocument) FROM ESFDocument esfDocument WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfDocument.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFDocument exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFDocument exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFDocumentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code", "type", "path"
			});
	private static ESFDocument _nullESFDocument = new ESFDocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFDocument> toCacheModel() {
				return _nullESFDocumentCacheModel;
			}
		};

	private static CacheModel<ESFDocument> _nullESFDocumentCacheModel = new CacheModel<ESFDocument>() {
			@Override
			public ESFDocument toEntityModel() {
				return _nullESFDocument;
			}
		};
}