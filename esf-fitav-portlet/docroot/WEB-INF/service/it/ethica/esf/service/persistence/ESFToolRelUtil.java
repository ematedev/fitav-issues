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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFToolRel;

import java.util.List;

/**
 * The persistence utility for the e s f tool rel service. This utility wraps {@link ESFToolRelPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFToolRelPersistence
 * @see ESFToolRelPersistenceImpl
 * @generated
 */
public class ESFToolRelUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ESFToolRel esfToolRel) {
		getPersistence().clearCache(esfToolRel);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ESFToolRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFToolRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFToolRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFToolRel update(ESFToolRel esfToolRel)
		throws SystemException {
		return getPersistence().update(esfToolRel);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFToolRel update(ESFToolRel esfToolRel,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfToolRel, serviceContext);
	}

	/**
	* Returns all the e s f tool rels where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @return the matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByESFToolId(
		long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFToolId(esfToolId);
	}

	/**
	* Returns a range of all the e s f tool rels where esfToolId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfToolId the esf tool ID
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByESFToolId(
		long esfToolId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFToolId(esfToolId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tool rels where esfToolId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfToolId the esf tool ID
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByESFToolId(
		long esfToolId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFToolId(esfToolId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel findByESFToolId_First(
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByESFToolId_First(esfToolId, orderByComparator);
	}

	/**
	* Returns the first e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel fetchByESFToolId_First(
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFToolId_First(esfToolId, orderByComparator);
	}

	/**
	* Returns the last e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel findByESFToolId_Last(
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByESFToolId_Last(esfToolId, orderByComparator);
	}

	/**
	* Returns the last e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel fetchByESFToolId_Last(
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFToolId_Last(esfToolId, orderByComparator);
	}

	/**
	* Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolRelPK the primary key of the current e s f tool rel
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel[] findByESFToolId_PrevAndNext(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK,
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByESFToolId_PrevAndNext(esfToolRelPK, esfToolId,
			orderByComparator);
	}

	/**
	* Removes all the e s f tool rels where esfToolId = &#63; from the database.
	*
	* @param esfToolId the esf tool ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFToolId(long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFToolId(esfToolId);
	}

	/**
	* Returns the number of e s f tool rels where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFToolId(long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFToolId(esfToolId);
	}

	/**
	* Returns all the e s f tool rels where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByN_P(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByN_P(className, classPK);
	}

	/**
	* Returns a range of all the e s f tool rels where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByN_P(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByN_P(className, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tool rels where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByN_P(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByN_P(className, classPK, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel findByN_P_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByN_P_First(className, classPK, orderByComparator);
	}

	/**
	* Returns the first e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel fetchByN_P_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByN_P_First(className, classPK, orderByComparator);
	}

	/**
	* Returns the last e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel findByN_P_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByN_P_Last(className, classPK, orderByComparator);
	}

	/**
	* Returns the last e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel fetchByN_P_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByN_P_Last(className, classPK, orderByComparator);
	}

	/**
	* Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param esfToolRelPK the primary key of the current e s f tool rel
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel[] findByN_P_PrevAndNext(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByN_P_PrevAndNext(esfToolRelPK, className, classPK,
			orderByComparator);
	}

	/**
	* Removes all the e s f tool rels where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByN_P(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByN_P(className, classPK);
	}

	/**
	* Returns the number of e s f tool rels where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByN_P(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByN_P(className, classPK);
	}

	/**
	* Returns all the e s f tool rels where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @return the matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByAssignmentDate(
		java.util.Date assignmentDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAssignmentDate(assignmentDate);
	}

	/**
	* Returns a range of all the e s f tool rels where assignmentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assignmentDate the assignment date
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByAssignmentDate(
		java.util.Date assignmentDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAssignmentDate(assignmentDate, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tool rels where assignmentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assignmentDate the assignment date
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findByAssignmentDate(
		java.util.Date assignmentDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssignmentDate(assignmentDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel findByAssignmentDate_First(
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByAssignmentDate_First(assignmentDate, orderByComparator);
	}

	/**
	* Returns the first e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel fetchByAssignmentDate_First(
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAssignmentDate_First(assignmentDate,
			orderByComparator);
	}

	/**
	* Returns the last e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel findByAssignmentDate_Last(
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByAssignmentDate_Last(assignmentDate, orderByComparator);
	}

	/**
	* Returns the last e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel fetchByAssignmentDate_Last(
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAssignmentDate_Last(assignmentDate, orderByComparator);
	}

	/**
	* Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param esfToolRelPK the primary key of the current e s f tool rel
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel[] findByAssignmentDate_PrevAndNext(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK,
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence()
				   .findByAssignmentDate_PrevAndNext(esfToolRelPK,
			assignmentDate, orderByComparator);
	}

	/**
	* Removes all the e s f tool rels where assignmentDate = &#63; from the database.
	*
	* @param assignmentDate the assignment date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAssignmentDate(java.util.Date assignmentDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAssignmentDate(assignmentDate);
	}

	/**
	* Returns the number of e s f tool rels where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAssignmentDate(java.util.Date assignmentDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAssignmentDate(assignmentDate);
	}

	/**
	* Caches the e s f tool rel in the entity cache if it is enabled.
	*
	* @param esfToolRel the e s f tool rel
	*/
	public static void cacheResult(it.ethica.esf.model.ESFToolRel esfToolRel) {
		getPersistence().cacheResult(esfToolRel);
	}

	/**
	* Caches the e s f tool rels in the entity cache if it is enabled.
	*
	* @param esfToolRels the e s f tool rels
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFToolRel> esfToolRels) {
		getPersistence().cacheResult(esfToolRels);
	}

	/**
	* Creates a new e s f tool rel with the primary key. Does not add the e s f tool rel to the database.
	*
	* @param esfToolRelPK the primary key for the new e s f tool rel
	* @return the new e s f tool rel
	*/
	public static it.ethica.esf.model.ESFToolRel create(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK) {
		return getPersistence().create(esfToolRelPK);
	}

	/**
	* Removes the e s f tool rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfToolRelPK the primary key of the e s f tool rel
	* @return the e s f tool rel that was removed
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel remove(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence().remove(esfToolRelPK);
	}

	public static it.ethica.esf.model.ESFToolRel updateImpl(
		it.ethica.esf.model.ESFToolRel esfToolRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfToolRel);
	}

	/**
	* Returns the e s f tool rel with the primary key or throws a {@link it.ethica.esf.NoSuchToolRelException} if it could not be found.
	*
	* @param esfToolRelPK the primary key of the e s f tool rel
	* @return the e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException {
		return getPersistence().findByPrimaryKey(esfToolRelPK);
	}

	/**
	* Returns the e s f tool rel with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfToolRelPK the primary key of the e s f tool rel
	* @return the e s f tool rel, or <code>null</code> if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFToolRel fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfToolRelPK);
	}

	/**
	* Returns all the e s f tool rels.
	*
	* @return the e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f tool rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f tool rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFToolRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f tool rels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f tool rels.
	*
	* @return the number of e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFToolRelPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFToolRelPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFToolRelPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFToolRelUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFToolRelPersistence persistence) {
	}

	private static ESFToolRelPersistence _persistence;
}