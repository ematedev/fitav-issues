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

import it.ethica.esf.model.ESFShooterQualificationESFTournament;

import java.util.List;

/**
 * The persistence utility for the e s f shooter qualification e s f tournament service. This utility wraps {@link ESFShooterQualificationESFTournamentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationESFTournamentPersistence
 * @see ESFShooterQualificationESFTournamentPersistenceImpl
 * @generated
 */
public class ESFShooterQualificationESFTournamentUtil {
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
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		getPersistence().clearCache(esfShooterQualificationESFTournament);
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
	public static List<ESFShooterQualificationESFTournament> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFShooterQualificationESFTournament> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFShooterQualificationESFTournament> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFShooterQualificationESFTournament update(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament)
		throws SystemException {
		return getPersistence().update(esfShooterQualificationESFTournament);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFShooterQualificationESFTournament update(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(esfShooterQualificationESFTournament, serviceContext);
	}

	/**
	* Returns all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @return the range of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f shooter qualification e s f tournaments before and after the current e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the current e s f shooter qualification e s f tournament
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament[] findByUuid_PrevAndNext(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfShooterQualificationESFTournamentPK,
			uuid, orderByComparator);
	}

	/**
	* Removes all the e s f shooter qualification e s f tournaments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f shooter qualification e s f tournaments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFTournamentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f shooter qualification e s f tournament that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f shooter qualification e s f tournaments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @return the matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByESFTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFTournament(esfTournamentId);
	}

	/**
	* Returns a range of all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfTournamentId the esf tournament ID
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @return the range of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByESFTournament(
		long esfTournamentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFTournament(esfTournamentId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfTournamentId the esf tournament ID
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByESFTournament(
		long esfTournamentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFTournament(esfTournamentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament findByESFTournament_First(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence()
				   .findByESFTournament_First(esfTournamentId, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByESFTournament_First(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFTournament_First(esfTournamentId,
			orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament findByESFTournament_Last(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence()
				   .findByESFTournament_Last(esfTournamentId, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByESFTournament_Last(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFTournament_Last(esfTournamentId, orderByComparator);
	}

	/**
	* Returns the e s f shooter qualification e s f tournaments before and after the current e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the current e s f shooter qualification e s f tournament
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament[] findByESFTournament_PrevAndNext(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK,
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence()
				   .findByESFTournament_PrevAndNext(esfShooterQualificationESFTournamentPK,
			esfTournamentId, orderByComparator);
	}

	/**
	* Removes all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63; from the database.
	*
	* @param esfTournamentId the esf tournament ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFTournament(long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFTournament(esfTournamentId);
	}

	/**
	* Returns the number of e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @return the number of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFTournament(long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFTournament(esfTournamentId);
	}

	/**
	* Caches the e s f shooter qualification e s f tournament in the entity cache if it is enabled.
	*
	* @param esfShooterQualificationESFTournament the e s f shooter qualification e s f tournament
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		getPersistence().cacheResult(esfShooterQualificationESFTournament);
	}

	/**
	* Caches the e s f shooter qualification e s f tournaments in the entity cache if it is enabled.
	*
	* @param esfShooterQualificationESFTournaments the e s f shooter qualification e s f tournaments
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> esfShooterQualificationESFTournaments) {
		getPersistence().cacheResult(esfShooterQualificationESFTournaments);
	}

	/**
	* Creates a new e s f shooter qualification e s f tournament with the primary key. Does not add the e s f shooter qualification e s f tournament to the database.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key for the new e s f shooter qualification e s f tournament
	* @return the new e s f shooter qualification e s f tournament
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament create(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK) {
		return getPersistence().create(esfShooterQualificationESFTournamentPK);
	}

	/**
	* Removes the e s f shooter qualification e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	* @return the e s f shooter qualification e s f tournament that was removed
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament remove(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence().remove(esfShooterQualificationESFTournamentPK);
	}

	public static it.ethica.esf.model.ESFShooterQualificationESFTournament updateImpl(
		it.ethica.esf.model.ESFShooterQualificationESFTournament esfShooterQualificationESFTournament)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfShooterQualificationESFTournament);
	}

	/**
	* Returns the e s f shooter qualification e s f tournament with the primary key or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFTournamentException} if it could not be found.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	* @return the e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException {
		return getPersistence()
				   .findByPrimaryKey(esfShooterQualificationESFTournamentPK);
	}

	/**
	* Returns the e s f shooter qualification e s f tournament with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	* @return the e s f shooter qualification e s f tournament, or <code>null</code> if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(esfShooterQualificationESFTournamentPK);
	}

	/**
	* Returns all the e s f shooter qualification e s f tournaments.
	*
	* @return the e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f shooter qualification e s f tournaments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @return the range of e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f tournaments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f shooter qualification e s f tournaments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f shooter qualification e s f tournaments.
	*
	* @return the number of e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFShooterQualificationESFTournamentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFShooterQualificationESFTournamentPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFShooterQualificationESFTournamentPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFShooterQualificationESFTournamentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ESFShooterQualificationESFTournamentPersistence persistence) {
	}

	private static ESFShooterQualificationESFTournamentPersistence _persistence;
}