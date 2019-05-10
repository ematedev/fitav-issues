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

import it.ethica.esf.model.VW_DatiDrettoreTiro;

import java.util.List;

/**
 * The persistence utility for the v w_ dati drettore tiro service. This utility wraps {@link VW_DatiDrettoreTiroPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_DatiDrettoreTiroPersistence
 * @see VW_DatiDrettoreTiroPersistenceImpl
 * @generated
 */
public class VW_DatiDrettoreTiroUtil {
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
	public static void clearCache(VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		getPersistence().clearCache(vw_DatiDrettoreTiro);
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
	public static List<VW_DatiDrettoreTiro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VW_DatiDrettoreTiro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VW_DatiDrettoreTiro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VW_DatiDrettoreTiro update(
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro) throws SystemException {
		return getPersistence().update(vw_DatiDrettoreTiro);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VW_DatiDrettoreTiro update(
		VW_DatiDrettoreTiro vw_DatiDrettoreTiro, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(vw_DatiDrettoreTiro, serviceContext);
	}

	/**
	* Returns the v w_ dati drettore tiro where esfShootingDirectorId = &#63; or throws a {@link it.ethica.esf.NoSuchVW_DatiDrettoreTiroException} if it could not be found.
	*
	* @param esfShootingDirectorId the esf shooting director ID
	* @return the matching v w_ dati drettore tiro
	* @throws it.ethica.esf.NoSuchVW_DatiDrettoreTiroException if a matching v w_ dati drettore tiro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_DatiDrettoreTiro findByesfShootingDirectorId(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_DatiDrettoreTiroException {
		return getPersistence()
				   .findByesfShootingDirectorId(esfShootingDirectorId);
	}

	/**
	* Returns the v w_ dati drettore tiro where esfShootingDirectorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfShootingDirectorId the esf shooting director ID
	* @return the matching v w_ dati drettore tiro, or <code>null</code> if a matching v w_ dati drettore tiro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_DatiDrettoreTiro fetchByesfShootingDirectorId(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfShootingDirectorId(esfShootingDirectorId);
	}

	/**
	* Returns the v w_ dati drettore tiro where esfShootingDirectorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfShootingDirectorId the esf shooting director ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching v w_ dati drettore tiro, or <code>null</code> if a matching v w_ dati drettore tiro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_DatiDrettoreTiro fetchByesfShootingDirectorId(
		long esfShootingDirectorId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfShootingDirectorId(esfShootingDirectorId,
			retrieveFromCache);
	}

	/**
	* Removes the v w_ dati drettore tiro where esfShootingDirectorId = &#63; from the database.
	*
	* @param esfShootingDirectorId the esf shooting director ID
	* @return the v w_ dati drettore tiro that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_DatiDrettoreTiro removeByesfShootingDirectorId(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_DatiDrettoreTiroException {
		return getPersistence()
				   .removeByesfShootingDirectorId(esfShootingDirectorId);
	}

	/**
	* Returns the number of v w_ dati drettore tiros where esfShootingDirectorId = &#63;.
	*
	* @param esfShootingDirectorId the esf shooting director ID
	* @return the number of matching v w_ dati drettore tiros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByesfShootingDirectorId(long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByesfShootingDirectorId(esfShootingDirectorId);
	}

	/**
	* Caches the v w_ dati drettore tiro in the entity cache if it is enabled.
	*
	* @param vw_DatiDrettoreTiro the v w_ dati drettore tiro
	*/
	public static void cacheResult(
		it.ethica.esf.model.VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		getPersistence().cacheResult(vw_DatiDrettoreTiro);
	}

	/**
	* Caches the v w_ dati drettore tiros in the entity cache if it is enabled.
	*
	* @param vw_DatiDrettoreTiros the v w_ dati drettore tiros
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.VW_DatiDrettoreTiro> vw_DatiDrettoreTiros) {
		getPersistence().cacheResult(vw_DatiDrettoreTiros);
	}

	/**
	* Creates a new v w_ dati drettore tiro with the primary key. Does not add the v w_ dati drettore tiro to the database.
	*
	* @param vw_DatiDrettoreTiroPK the primary key for the new v w_ dati drettore tiro
	* @return the new v w_ dati drettore tiro
	*/
	public static it.ethica.esf.model.VW_DatiDrettoreTiro create(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK) {
=======
		VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK) {
>>>>>>> origin/master
		return getPersistence().create(vw_DatiDrettoreTiroPK);
	}

	/**
	* Removes the v w_ dati drettore tiro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_DatiDrettoreTiroPK the primary key of the v w_ dati drettore tiro
	* @return the v w_ dati drettore tiro that was removed
	* @throws it.ethica.esf.NoSuchVW_DatiDrettoreTiroException if a v w_ dati drettore tiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_DatiDrettoreTiro remove(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK)
=======
		VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK)
>>>>>>> origin/master
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_DatiDrettoreTiroException {
		return getPersistence().remove(vw_DatiDrettoreTiroPK);
	}

	public static it.ethica.esf.model.VW_DatiDrettoreTiro updateImpl(
		it.ethica.esf.model.VW_DatiDrettoreTiro vw_DatiDrettoreTiro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vw_DatiDrettoreTiro);
	}

	/**
	* Returns the v w_ dati drettore tiro with the primary key or throws a {@link it.ethica.esf.NoSuchVW_DatiDrettoreTiroException} if it could not be found.
	*
	* @param vw_DatiDrettoreTiroPK the primary key of the v w_ dati drettore tiro
	* @return the v w_ dati drettore tiro
	* @throws it.ethica.esf.NoSuchVW_DatiDrettoreTiroException if a v w_ dati drettore tiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_DatiDrettoreTiro findByPrimaryKey(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK)
=======
		VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK)
>>>>>>> origin/master
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_DatiDrettoreTiroException {
		return getPersistence().findByPrimaryKey(vw_DatiDrettoreTiroPK);
	}

	/**
	* Returns the v w_ dati drettore tiro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_DatiDrettoreTiroPK the primary key of the v w_ dati drettore tiro
	* @return the v w_ dati drettore tiro, or <code>null</code> if a v w_ dati drettore tiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_DatiDrettoreTiro fetchByPrimaryKey(
<<<<<<< HEAD
		it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK)
=======
		VW_DatiDrettoreTiroPK vw_DatiDrettoreTiroPK)
>>>>>>> origin/master
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vw_DatiDrettoreTiroPK);
	}

	/**
	* Returns all the v w_ dati drettore tiros.
	*
	* @return the v w_ dati drettore tiros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_DatiDrettoreTiro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v w_ dati drettore tiros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_DatiDrettoreTiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ dati drettore tiros
	* @param end the upper bound of the range of v w_ dati drettore tiros (not inclusive)
	* @return the range of v w_ dati drettore tiros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_DatiDrettoreTiro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v w_ dati drettore tiros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_DatiDrettoreTiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ dati drettore tiros
	* @param end the upper bound of the range of v w_ dati drettore tiros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ dati drettore tiros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_DatiDrettoreTiro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v w_ dati drettore tiros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v w_ dati drettore tiros.
	*
	* @return the number of v w_ dati drettore tiros
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VW_DatiDrettoreTiroPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VW_DatiDrettoreTiroPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					VW_DatiDrettoreTiroPersistence.class.getName());

			ReferenceRegistry.registerReference(VW_DatiDrettoreTiroUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VW_DatiDrettoreTiroPersistence persistence) {
	}

	private static VW_DatiDrettoreTiroPersistence _persistence;
}