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

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFFieldESFElectronic;

/**
 * The persistence interface for the e s f field e s f electronic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFieldESFElectronicPersistenceImpl
 * @see ESFFieldESFElectronicUtil
 * @generated
 */
public interface ESFFieldESFElectronicPersistence extends BasePersistence<ESFFieldESFElectronic> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFFieldESFElectronicUtil} to access the e s f field e s f electronic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f field e s f electronics where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @return the matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByFieldId(
		long fieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByFieldId(
		long fieldId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByFieldId(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic findByFieldId_First(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the first e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByFieldId_First(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic findByFieldId_Last(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the last e s f field e s f electronic in the ordered set where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByFieldId_Last(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFFieldESFElectronic[] findByFieldId_PrevAndNext(
		long id, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Removes all the e s f field e s f electronics where fieldId = &#63; from the database.
	*
	* @param fieldId the field ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFieldId(long fieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f field e s f electronics where fieldId = &#63;.
	*
	* @param fieldId the field ID
	* @return the number of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public int countByFieldId(long fieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f field e s f electronics where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @return the matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByBrandId(
		long brandId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByBrandId(
		long brandId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByBrandId(
		long brandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic findByBrandId_First(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the first e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByBrandId_First(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic findByBrandId_Last(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the last e s f field e s f electronic in the ordered set where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByBrandId_Last(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFFieldESFElectronic[] findByBrandId_PrevAndNext(
		long id, long brandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Removes all the e s f field e s f electronics where brandId = &#63; from the database.
	*
	* @param brandId the brand ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBrandId(long brandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f field e s f electronics where brandId = &#63;.
	*
	* @param brandId the brand ID
	* @return the number of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public int countByBrandId(long brandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f field e s f electronics where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @return the matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByElectronicId(
		long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByElectronicId(
		long electronicId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByElectronicId(
		long electronicId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic findByElectronicId_First(
		long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the first e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByElectronicId_First(
		long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic findByElectronicId_Last(
		long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the last e s f field e s f electronic in the ordered set where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByElectronicId_Last(
		long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFFieldESFElectronic[] findByElectronicId_PrevAndNext(
		long id, long electronicId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Removes all the e s f field e s f electronics where electronicId = &#63; from the database.
	*
	* @param electronicId the electronic ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByElectronicId(long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f field e s f electronics where electronicId = &#63;.
	*
	* @param electronicId the electronic ID
	* @return the number of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public int countByElectronicId(long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFFieldESFElectronic findByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fieldId the field ID
	* @param brandId the brand ID
	* @param electronicId the electronic ID
	* @return the matching e s f field e s f electronic, or <code>null</code> if a matching e s f field e s f electronic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f field e s f electronic where fieldId = &#63; and brandId = &#63; and electronicId = &#63; from the database.
	*
	* @param fieldId the field ID
	* @param brandId the brand ID
	* @param electronicId the electronic ID
	* @return the e s f field e s f electronic that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic removeByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the number of e s f field e s f electronics where fieldId = &#63; and brandId = &#63; and electronicId = &#63;.
	*
	* @param fieldId the field ID
	* @param brandId the brand ID
	* @param electronicId the electronic ID
	* @return the number of matching e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public int countByFieldIdBrandIdElectronicId(long fieldId, long brandId,
		long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f field e s f electronic in the entity cache if it is enabled.
	*
	* @param esfFieldESFElectronic the e s f field e s f electronic
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic);

	/**
	* Caches the e s f field e s f electronics in the entity cache if it is enabled.
	*
	* @param esfFieldESFElectronics the e s f field e s f electronics
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> esfFieldESFElectronics);

	/**
	* Creates a new e s f field e s f electronic with the primary key. Does not add the e s f field e s f electronic to the database.
	*
	* @param id the primary key for the new e s f field e s f electronic
	* @return the new e s f field e s f electronic
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic create(long id);

	/**
	* Removes the e s f field e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic that was removed
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	public it.ethica.esf.model.ESFFieldESFElectronic updateImpl(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f field e s f electronic with the primary key or throws a {@link it.ethica.esf.NoSuchFieldESFElectronicException} if it could not be found.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic
	* @throws it.ethica.esf.NoSuchFieldESFElectronicException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFElectronicException;

	/**
	* Returns the e s f field e s f electronic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic, or <code>null</code> if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFElectronic fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f field e s f electronics.
	*
	* @return the e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f field e s f electronics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f field e s f electronics.
	*
	* @return the number of e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}