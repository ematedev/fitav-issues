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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFFieldESFElectronic;

import java.util.List;

/**
 * The persistence utility for the e s f field e s f electronic service. This utility wraps {@link ESFFieldESFElectronicPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFieldESFElectronicPersistence
 * @see ESFFieldESFElectronicPersistenceImpl
 * @generated
 */
public class ESFFieldESFElectronicUtil {
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
	public static void clearCache(ESFFieldESFElectronic esfFieldESFElectronic) {
		getPersistence().clearCache(esfFieldESFElectronic);
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
	public static List<ESFFieldESFElectronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFFieldESFElectronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFFieldESFElectronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFFieldESFElectronic update(
		ESFFieldESFElectronic esfFieldESFElectronic) throws SystemException {
		return getPersistence().update(esfFieldESFElectronic);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFFieldESFElectronic update(
		ESFFieldESFElectronic esfFieldESFElectronic,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfFieldESFElectronic, serviceContext);
	}

	/**
	* Returns all the e s f field e s f electronics where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @return the matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByFieldId(
		long fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFieldId(fieldId);
	}

	/**
	* Returns a range of all the e s f field e s f electronics where fieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fieldId the field ID
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @return the range of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByFieldId(
		long fieldId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFieldId(fieldId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f field e s f electronics where fieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fieldId the field ID
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByFieldId(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFieldId(fieldId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic findByFieldId_First(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence().findByFieldId_First(fieldId, orderByComparator);
	}

	/**
	* Returns the first e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByFieldId_First(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFieldId_First(fieldId, orderByComparator);
	}

	/**
	* Returns the last e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic findByFieldId_Last(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence().findByFieldId_Last(fieldId, orderByComparator);
	}

	/**
	* Returns the last e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByFieldId_Last(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFieldId_Last(fieldId, orderByComparator);
	}

	/**
	* Returns the e s f field e s f electronics before and after the current e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param id the primary key of the current e s f field e s f electronic
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic[] findByFieldId_PrevAndNext(
		long id, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence()
				   .findByFieldId_PrevAndNext(id, fieldId, orderByComparator);
	}

	/**
	* Removes all the e s f field e s f electronics where fieldId = &#63; from the database.
	*
	* @param fieldId the field ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFieldId(long fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFieldId(fieldId);
	}

	/**
	* Returns the number of e s f field e s f electronics where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @return the number of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFieldId(long fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFieldId(fieldId);
	}

	/**
	* Returns all the e s f field e s f electronics where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @return the matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByBrandId(
		long brandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrandId(brandId);
	}

	/**
	* Returns a range of all the e s f field e s f electronics where brandId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brandId the brand ID
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @return the range of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByBrandId(
		long brandId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrandId(brandId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f field e s f electronics where brandId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brandId the brand ID
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByBrandId(
		long brandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrandId(brandId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic findByBrandId_First(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence().findByBrandId_First(brandId, orderByComparator);
	}

	/**
	* Returns the first e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByBrandId_First(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBrandId_First(brandId, orderByComparator);
	}

	/**
	* Returns the last e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic findByBrandId_Last(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence().findByBrandId_Last(brandId, orderByComparator);
	}

	/**
	* Returns the last e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByBrandId_Last(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBrandId_Last(brandId, orderByComparator);
	}

	/**
	* Returns the e s f field e s f electronics before and after the current e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param id the primary key of the current e s f field e s f electronic
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic[] findByBrandId_PrevAndNext(
		long id, long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence()
				   .findByBrandId_PrevAndNext(id, brandId, orderByComparator);
	}

	/**
	* Removes all the e s f field e s f electronics where brandId = &#63; from the database.
	*
	* @param brandId the brand ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrandId(long brandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrandId(brandId);
	}

	/**
	* Returns the number of e s f field e s f electronics where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @return the number of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrandId(long brandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrandId(brandId);
	}

	/**
	* Returns all the e s f field e s f electronics where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @return the matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByElectronicId(
		long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByElectronicId(electronicId);
	}

	/**
	* Returns a range of all the e s f field e s f electronics where electronicId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param electronicId the electronic ID
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @return the range of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByElectronicId(
		long electronicId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByElectronicId(electronicId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f field e s f electronics where electronicId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param electronicId the electronic ID
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByElectronicId(
		long electronicId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByElectronicId(electronicId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic findByElectronicId_First(
		long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence()
				   .findByElectronicId_First(electronicId, orderByComparator);
	}

	/**
	* Returns the first e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByElectronicId_First(
		long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByElectronicId_First(electronicId, orderByComparator);
	}

	/**
	* Returns the last e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic findByElectronicId_Last(
		long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence()
				   .findByElectronicId_Last(electronicId, orderByComparator);
	}

	/**
	* Returns the last e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByElectronicId_Last(
		long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByElectronicId_Last(electronicId, orderByComparator);
	}

	/**
	* Returns the e s f field e s f electronics before and after the current e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param id the primary key of the current e s f field e s f electronic
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic[] findByElectronicId_PrevAndNext(
		long id, long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence()
				   .findByElectronicId_PrevAndNext(id, electronicId,
			orderByComparator);
	}

	/**
	* Removes all the e s f field e s f electronics where electronicId = &#63; from the database.
	*
	* @param electronicId the electronic ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByElectronicId(long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByElectronicId(electronicId);
	}

	/**
	* Returns the number of e s f field e s f electronics where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @return the number of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static int countByElectronicId(long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByElectronicId(electronicId);
	}

	/**
	* Returns the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; or throws a {@link it.ethica.esf.NoSuchFieldESFElectronicException} if it could not be found.
	*
	* @param fieldId the field ID
	* @param brandId the brand ID
	* @param electronicId the electronic ID
	* @return the matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic findByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence()
				   .findByFieldIdBrandIdElectronicId(fieldId, brandId,
			electronicId);
	}

	/**
	* Returns the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fieldId the field ID
	* @param brandId the brand ID
	* @param electronicId the electronic ID
	* @return the matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFieldIdBrandIdElectronicId(fieldId, brandId,
			electronicId);
	}

	/**
	* Returns the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fieldId the field ID
	* @param brandId the brand ID
	* @param electronicId the electronic ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFieldIdBrandIdElectronicId(fieldId, brandId,
			electronicId, retrieveFromCache);
	}

	/**
	* Removes the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; from the database.
	*
	* @param fieldId the field ID
	* @param brandId the brand ID
	* @param electronicId the electronic ID
	* @return the e s f field e s f electronic that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic removeByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence()
				   .removeByFieldIdBrandIdElectronicId(fieldId, brandId,
			electronicId);
	}

	/**
	* Returns the number of e s f field e s f electronics where fieldId = &#63; and brandId = &#63; and electronicId = &#63;.
	*
	* @param fieldId the field ID
	* @param brandId the brand ID
	* @param electronicId the electronic ID
	* @return the number of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFieldIdBrandIdElectronicId(long fieldId,
		long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFieldIdBrandIdElectronicId(fieldId, brandId,
			electronicId);
	}

	/**
	* Caches the e s f field e s f electronic in the entity cache if it is enabled.
	*
	* @param esfFieldESFElectronic the e s f field e s f electronic
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic) {
		getPersistence().cacheResult(esfFieldESFElectronic);
	}

	/**
	* Caches the e s f field e s f electronics in the entity cache if it is enabled.
	*
	* @param esfFieldESFElectronics the e s f field e s f electronics
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> esfFieldESFElectronics) {
		getPersistence().cacheResult(esfFieldESFElectronics);
	}

	/**
	* Creates a new e s f field e s f electronic with the primary key. Does not add the e s f field e s f electronic to the database.
	*
	* @param id the primary key for the new e s f field e s f electronic
	* @return the new e s f field e s f electronic
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the e s f field e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic that was removed
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence().remove(id);
	}

	public static it.ethica.esf.model.ESFFieldESFElectronic updateImpl(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfFieldESFElectronic);
	}

	/**
	* Returns the e s f field e s f electronic with the primary key or throws a {@link it.ethica.esf.NoSuchFieldESFElectronicException} if it could not be found.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the e s f field e s f electronic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic, or <code>null</code> if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the e s f field e s f electronics.
	*
	* @return the e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f field e s f electronics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @return the range of e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f field e s f electronics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f field e s f electronics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f field e s f electronics.
	*
	* @return the number of e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFFieldESFElectronicPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFFieldESFElectronicPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFFieldESFElectronicPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFFieldESFElectronicUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFFieldESFElectronicPersistence persistence) {
	}

	private static ESFFieldESFElectronicPersistence _persistence;
}