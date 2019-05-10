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

import it.ethica.esf.model.VW_ESFListaIncarichi;

import java.util.List;

/**
 * The persistence utility for the v w_ e s f lista incarichi service. This utility wraps {@link VW_ESFListaIncarichiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiPersistence
 * @see VW_ESFListaIncarichiPersistenceImpl
 * @generated
 */
public class VW_ESFListaIncarichiUtil {
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
	public static void clearCache(VW_ESFListaIncarichi vw_esfListaIncarichi) {
		getPersistence().clearCache(vw_esfListaIncarichi);
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
	public static List<VW_ESFListaIncarichi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VW_ESFListaIncarichi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VW_ESFListaIncarichi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VW_ESFListaIncarichi update(
		VW_ESFListaIncarichi vw_esfListaIncarichi) throws SystemException {
		return getPersistence().update(vw_esfListaIncarichi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VW_ESFListaIncarichi update(
		VW_ESFListaIncarichi vw_esfListaIncarichi, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(vw_esfListaIncarichi, serviceContext);
	}

	/**
	* Returns all the v w_ e s f lista incarichis where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findByorganizzazione(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByorganizzazione(esfOrganizationId);
	}

	/**
	* Returns a range of all the v w_ e s f lista incarichis where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @return the range of matching v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findByorganizzazione(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByorganizzazione(esfOrganizationId, start, end);
	}

	/**
	* Returns an ordered range of all the v w_ e s f lista incarichis where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findByorganizzazione(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByorganizzazione(esfOrganizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f lista incarichi
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a matching v w_ e s f lista incarichi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi findByorganizzazione_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException {
		return getPersistence()
				   .findByorganizzazione_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the first v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f lista incarichi, or <code>null</code> if a matching v w_ e s f lista incarichi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi fetchByorganizzazione_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByorganizzazione_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f lista incarichi
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a matching v w_ e s f lista incarichi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi findByorganizzazione_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException {
		return getPersistence()
				   .findByorganizzazione_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f lista incarichi, or <code>null</code> if a matching v w_ e s f lista incarichi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi fetchByorganizzazione_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByorganizzazione_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the v w_ e s f lista incarichis before and after the current v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param vw_esfListaIncarichiPK the primary key of the current v w_ e s f lista incarichi
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v w_ e s f lista incarichi
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi[] findByorganizzazione_PrevAndNext(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK,
		long esfOrganizationId,
=======
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK, long esfOrganizationId,
>>>>>>> origin/master
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException {
		return getPersistence()
				   .findByorganizzazione_PrevAndNext(vw_esfListaIncarichiPK,
			esfOrganizationId, orderByComparator);
	}

	/**
	* Removes all the v w_ e s f lista incarichis where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByorganizzazione(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByorganizzazione(esfOrganizationId);
	}

	/**
	* Returns the number of v w_ e s f lista incarichis where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static int countByorganizzazione(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByorganizzazione(esfOrganizationId);
	}

	/**
	* Caches the v w_ e s f lista incarichi in the entity cache if it is enabled.
	*
	* @param vw_esfListaIncarichi the v w_ e s f lista incarichi
	*/
	public static void cacheResult(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi) {
		getPersistence().cacheResult(vw_esfListaIncarichi);
	}

	/**
	* Caches the v w_ e s f lista incarichis in the entity cache if it is enabled.
	*
	* @param vw_esfListaIncarichis the v w_ e s f lista incarichis
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> vw_esfListaIncarichis) {
		getPersistence().cacheResult(vw_esfListaIncarichis);
	}

	/**
	* Creates a new v w_ e s f lista incarichi with the primary key. Does not add the v w_ e s f lista incarichi to the database.
	*
	* @param vw_esfListaIncarichiPK the primary key for the new v w_ e s f lista incarichi
	* @return the new v w_ e s f lista incarichi
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi create(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK) {
=======
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK) {
>>>>>>> origin/master
		return getPersistence().create(vw_esfListaIncarichiPK);
	}

	/**
	* Removes the v w_ e s f lista incarichi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was removed
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi remove(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
=======
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
>>>>>>> origin/master
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException {
		return getPersistence().remove(vw_esfListaIncarichiPK);
	}

	public static it.ethica.esf.model.VW_ESFListaIncarichi updateImpl(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vw_esfListaIncarichi);
	}

	/**
	* Returns the v w_ e s f lista incarichi with the primary key or throws a {@link it.ethica.esf.NoSuchVW_ESFListaIncarichiException} if it could not be found.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi findByPrimaryKey(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
=======
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
>>>>>>> origin/master
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException {
		return getPersistence().findByPrimaryKey(vw_esfListaIncarichiPK);
	}

	/**
	* Returns the v w_ e s f lista incarichi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi, or <code>null</code> if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi fetchByPrimaryKey(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
=======
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
>>>>>>> origin/master
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vw_esfListaIncarichiPK);
	}

	/**
	* Returns all the v w_ e s f lista incarichis.
	*
	* @return the v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v w_ e s f lista incarichis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @return the range of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v w_ e s f lista incarichis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v w_ e s f lista incarichis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v w_ e s f lista incarichis.
	*
	* @return the number of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VW_ESFListaIncarichiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VW_ESFListaIncarichiPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					VW_ESFListaIncarichiPersistence.class.getName());

			ReferenceRegistry.registerReference(VW_ESFListaIncarichiUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VW_ESFListaIncarichiPersistence persistence) {
	}

	private static VW_ESFListaIncarichiPersistence _persistence;
}