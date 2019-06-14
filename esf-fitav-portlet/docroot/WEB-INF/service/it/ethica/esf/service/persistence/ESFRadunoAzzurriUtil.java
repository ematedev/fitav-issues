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

import it.ethica.esf.model.ESFRadunoAzzurri;

import java.util.List;

/**
 * The persistence utility for the e s f raduno azzurri service. This utility wraps {@link ESFRadunoAzzurriPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoAzzurriPersistence
 * @see ESFRadunoAzzurriPersistenceImpl
 * @generated
 */
public class ESFRadunoAzzurriUtil {
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
	public static void clearCache(ESFRadunoAzzurri esfRadunoAzzurri) {
		getPersistence().clearCache(esfRadunoAzzurri);
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
	public static List<ESFRadunoAzzurri> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFRadunoAzzurri> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFRadunoAzzurri> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFRadunoAzzurri update(ESFRadunoAzzurri esfRadunoAzzurri)
		throws SystemException {
		return getPersistence().update(esfRadunoAzzurri);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFRadunoAzzurri update(ESFRadunoAzzurri esfRadunoAzzurri,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfRadunoAzzurri, serviceContext);
	}

	/**
	* Returns all the e s f raduno azzurris where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findByfindByRaduno(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByRaduno(id_esf_raduno);
	}

	/**
	* Returns a range of all the e s f raduno azzurris where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno azzurris
	* @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	* @return the range of matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findByfindByRaduno(
		long id_esf_raduno, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByRaduno(id_esf_raduno, start, end);
	}

	/**
	* Returns an ordered range of all the e s f raduno azzurris where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno azzurris
	* @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findByfindByRaduno(
		long id_esf_raduno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfindByRaduno(id_esf_raduno, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri findByfindByRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException {
		return getPersistence()
				   .findByfindByRaduno_First(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the first e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno azzurri, or <code>null</code> if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri fetchByfindByRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByRaduno_First(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the last e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri findByfindByRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException {
		return getPersistence()
				   .findByfindByRaduno_Last(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the last e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno azzurri, or <code>null</code> if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri fetchByfindByRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByRaduno_Last(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the e s f raduno azzurris before and after the current e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param esfRadunoAzzurriPK the primary key of the current e s f raduno azzurri
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri[] findByfindByRaduno_PrevAndNext(
		ESFRadunoAzzurriPK esfRadunoAzzurriPK, long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException {
		return getPersistence()
				   .findByfindByRaduno_PrevAndNext(esfRadunoAzzurriPK,
			id_esf_raduno, orderByComparator);
	}

	/**
	* Removes all the e s f raduno azzurris where id_esf_raduno = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfindByRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfindByRaduno(id_esf_raduno);
	}

	/**
	* Returns the number of e s f raduno azzurris where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the number of matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindByRaduno(id_esf_raduno);
	}

	/**
	* Caches the e s f raduno azzurri in the entity cache if it is enabled.
	*
	* @param esfRadunoAzzurri the e s f raduno azzurri
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFRadunoAzzurri esfRadunoAzzurri) {
		getPersistence().cacheResult(esfRadunoAzzurri);
	}

	/**
	* Caches the e s f raduno azzurris in the entity cache if it is enabled.
	*
	* @param esfRadunoAzzurris the e s f raduno azzurris
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> esfRadunoAzzurris) {
		getPersistence().cacheResult(esfRadunoAzzurris);
	}

	/**
	* Creates a new e s f raduno azzurri with the primary key. Does not add the e s f raduno azzurri to the database.
	*
	* @param esfRadunoAzzurriPK the primary key for the new e s f raduno azzurri
	* @return the new e s f raduno azzurri
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri create(
		ESFRadunoAzzurriPK esfRadunoAzzurriPK) {
		return getPersistence().create(esfRadunoAzzurriPK);
	}

	/**
	* Removes the e s f raduno azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	* @return the e s f raduno azzurri that was removed
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri remove(
		ESFRadunoAzzurriPK esfRadunoAzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException {
		return getPersistence().remove(esfRadunoAzzurriPK);
	}

	public static it.ethica.esf.model.ESFRadunoAzzurri updateImpl(
		it.ethica.esf.model.ESFRadunoAzzurri esfRadunoAzzurri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfRadunoAzzurri);
	}

	/**
	* Returns the e s f raduno azzurri with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoAzzurriException} if it could not be found.
	*
	* @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	* @return the e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri findByPrimaryKey(
		ESFRadunoAzzurriPK esfRadunoAzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException {
		return getPersistence().findByPrimaryKey(esfRadunoAzzurriPK);
	}

	/**
	* Returns the e s f raduno azzurri with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	* @return the e s f raduno azzurri, or <code>null</code> if a e s f raduno azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoAzzurri fetchByPrimaryKey(
		ESFRadunoAzzurriPK esfRadunoAzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfRadunoAzzurriPK);
	}

	/**
	* Returns all the e s f raduno azzurris.
	*
	* @return the e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f raduno azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno azzurris
	* @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	* @return the range of e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f raduno azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno azzurris
	* @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f raduno azzurris from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f raduno azzurris.
	*
	* @return the number of e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFRadunoAzzurriPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFRadunoAzzurriPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFRadunoAzzurriPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFRadunoAzzurriUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFRadunoAzzurriPersistence persistence) {
	}

	private static ESFRadunoAzzurriPersistence _persistence;
}