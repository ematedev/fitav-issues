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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera;

import java.util.List;

/**
 * The persistence utility for the v w_ e s f lista incarichi tessera service. This utility wraps {@link VW_ESFListaIncarichiTesseraPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiTesseraPersistence
 * @see VW_ESFListaIncarichiTesseraPersistenceImpl
 * @generated
 */
public class VW_ESFListaIncarichiTesseraUtil {
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
	public static void clearCache(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera) {
		getPersistence().clearCache(vw_esfListaIncarichiTessera);
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
	public static List<VW_ESFListaIncarichiTessera> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VW_ESFListaIncarichiTessera> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VW_ESFListaIncarichiTessera> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VW_ESFListaIncarichiTessera update(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera)
		throws SystemException {
		return getPersistence().update(vw_esfListaIncarichiTessera);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VW_ESFListaIncarichiTessera update(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(vw_esfListaIncarichiTessera, serviceContext);
	}

	/**
	* Returns all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByorganizzazione(esfOrganizationId);
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
	public static java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByorganizzazione(esfOrganizationId, start, end);
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
	public static java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByorganizzazione(esfOrganizationId, start, end,
			orderByComparator);
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
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera findByorganizzazione_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException {
		return getPersistence()
				   .findByorganizzazione_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the first v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f lista incarichi tessera, or <code>null</code> if a matching v w_ e s f lista incarichi tessera could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera fetchByorganizzazione_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByorganizzazione_First(esfOrganizationId,
			orderByComparator);
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
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera findByorganizzazione_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException {
		return getPersistence()
				   .findByorganizzazione_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f lista incarichi tessera, or <code>null</code> if a matching v w_ e s f lista incarichi tessera could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera fetchByorganizzazione_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByorganizzazione_Last(esfOrganizationId,
			orderByComparator);
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
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera[] findByorganizzazione_PrevAndNext(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK,
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException {
		return getPersistence()
				   .findByorganizzazione_PrevAndNext(vw_esfListaIncarichiTesseraPK,
			esfOrganizationId, orderByComparator);
	}

	/**
	* Removes all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByorganizzazione(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByorganizzazione(esfOrganizationId);
	}

	/**
	* Returns the number of v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public static int countByorganizzazione(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByorganizzazione(esfOrganizationId);
	}

	/**
	* Caches the v w_ e s f lista incarichi tessera in the entity cache if it is enabled.
	*
	* @param vw_esfListaIncarichiTessera the v w_ e s f lista incarichi tessera
	*/
	public static void cacheResult(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera) {
		getPersistence().cacheResult(vw_esfListaIncarichiTessera);
	}

	/**
	* Caches the v w_ e s f lista incarichi tesseras in the entity cache if it is enabled.
	*
	* @param vw_esfListaIncarichiTesseras the v w_ e s f lista incarichi tesseras
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> vw_esfListaIncarichiTesseras) {
		getPersistence().cacheResult(vw_esfListaIncarichiTesseras);
	}

	/**
	* Creates a new v w_ e s f lista incarichi tessera with the primary key. Does not add the v w_ e s f lista incarichi tessera to the database.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key for the new v w_ e s f lista incarichi tessera
	* @return the new v w_ e s f lista incarichi tessera
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera create(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK) {
		return getPersistence().create(vw_esfListaIncarichiTesseraPK);
	}

	/**
	* Removes the v w_ e s f lista incarichi tessera with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera that was removed
	* @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera remove(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException {
		return getPersistence().remove(vw_esfListaIncarichiTesseraPK);
	}

	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera updateImpl(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vw_esfListaIncarichiTessera);
	}

	/**
	* Returns the v w_ e s f lista incarichi tessera with the primary key or throws a {@link it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException} if it could not be found.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera
	* @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera findByPrimaryKey(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException {
		return getPersistence().findByPrimaryKey(vw_esfListaIncarichiTesseraPK);
	}

	/**
	* Returns the v w_ e s f lista incarichi tessera with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera, or <code>null</code> if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera fetchByPrimaryKey(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vw_esfListaIncarichiTesseraPK);
	}

	/**
	* Returns all the v w_ e s f lista incarichi tesseras.
	*
	* @return the v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v w_ e s f lista incarichi tesseras from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v w_ e s f lista incarichi tesseras.
	*
	* @return the number of v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VW_ESFListaIncarichiTesseraPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VW_ESFListaIncarichiTesseraPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.renewal.service.ClpSerializer.getServletContextName(),
					VW_ESFListaIncarichiTesseraPersistence.class.getName());

			ReferenceRegistry.registerReference(VW_ESFListaIncarichiTesseraUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		VW_ESFListaIncarichiTesseraPersistence persistence) {
	}

	private static VW_ESFListaIncarichiTesseraPersistence _persistence;
}