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

package it.ethica.esf.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFUser. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFUserLocalService
 * @see it.ethica.esf.service.base.ESFUserLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFUserLocalServiceImpl
 * @generated
 */
public class ESFUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f user to the database. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser addESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFUser(esfUser);
	}

	/**
	* Creates a new e s f user with the primary key. Does not add the e s f user to the database.
	*
	* @param esfUserId the primary key for the new e s f user
	* @return the new e s f user
	*/
	public static it.ethica.esf.model.ESFUser createESFUser(long esfUserId) {
		return getService().createESFUser(esfUserId);
	}

	/**
	* Deletes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user that was removed
	* @throws PortalException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUser(esfUserId);
	}

	/**
	* Deletes the e s f user from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser deleteESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUser(esfUser);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.ethica.esf.model.ESFUser fetchESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFUser(esfUserId);
	}

	/**
	* Returns the e s f user with the primary key.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user
	* @throws PortalException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser getESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUser(esfUserId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f users
	* @param end the upper bound of the range of e s f users (not inclusive)
	* @return the range of e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> getESFUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUsers(start, end);
	}

	/**
	* Returns the number of e s f users.
	*
	* @return the number of e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUsersCount();
	}

	/**
	* Updates the e s f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser updateESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFUser(esfUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getESFUsersByDeparture(
		long esfDepartureId) {
		return getService().getESFUsersByDeparture(esfDepartureId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getESFUsersByCodeCode(
		java.lang.String code) {
		return getService().getESFUsersByCodeCode(code);
	}

	public static it.ethica.esf.model.ESFUser getESFUserByUserCode(
		long userCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getService().getESFUserByUserCode(userCode);
	}

	public static it.ethica.esf.model.ESFUser getESFUserByCodeUser2(
		long userCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getService().getESFUserByCodeUser2(userCode);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(esfMatchId,
			firstName, lastName, fiscalCode, state, organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId, int start,
		int end) {
		return getService()
				   .getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(esfMatchId,
			firstName, lastName, fiscalCode, state, organizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId, int start,
		int end) {
		return getService()
				   .getESFUserByFirstName_LastName_FiscalCode(firstName,
			lastName, fiscalCode, state, organizationId, start, end);
	}

	public static it.ethica.esf.model.ESFUser getESFUserByFiscalCode(
		java.lang.String fiscalCode) {
		return getService().getESFUserByFiscalCode(fiscalCode);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int start, int end) {
		return getService()
				   .getAllUserByLikeF_L(firstName, lastName, screenName, start,
			end);
	}

	public static int countAllUserByLikeF_L(java.lang.String firstName,
		java.lang.String lastName, java.lang.String screenName) {
		return getService()
				   .countAllUserByLikeF_L(firstName, lastName, screenName);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int state, int start, int end) {
		return getService()
				   .getAllUserByLikeF_L_S(firstName, lastName, screenName,
			state, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int state) {
		return getService()
				   .getAllUserByLikeF_L_S(firstName, lastName, screenName, state);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, int state, long organizationId, int start,
		int end) {
		return getService()
				   .getAllUserByLikeF_C_S(firstName, lastName, cardCode, state,
			organizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, int state, long organizationId) {
		return getService()
				   .getAllUserByLikeF_C_S(firstName, lastName, cardCode, state,
			organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllShooterByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long organizationId, int start, int end) {
		return getService()
				   .getAllShooterByLikeF_C_S(firstName, lastName, cardCode,
			organizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllShooterByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long organizationId) {
		return getService()
				   .getAllShooterByLikeF_C_S(firstName, lastName, cardCode,
			organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllEsfUserByState(
		int state) {
		return getService().getAllEsfUserByState(state);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> getAllEsfUserByState(
		int state, int start, int end) {
		return getService().getAllEsfUserByState(state, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findUserByRoleT_N_S(
		java.lang.String title, java.lang.String name, int state)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService().findUserByRoleT_N_S(title, name, state);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		int stateCard, int stateUser) {
		return getService().findAllShooters(stateCard, stateUser);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser) {
		return getService().findAllShooters(organizationId, stateCard, stateUser);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser, int start, int end) {
		return getService()
				   .findAllShooters(organizationId, stateCard, stateUser,
			start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findRoledUserOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findRoledUserOrganization(organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findRoledUserOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findRoledUserOrganization(organizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser,
		int start, int end) {
		return getService()
				   .findAllShootersByLeafOrgAssigned(organizationId, stateCard,
			esfUserRoleId, stateUser, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser, int start, int end) {
		return getService()
				   .findAllShootersByLeafOrgAssignedName(name, lastName,
			organizationId, stateCard, esfUserRoleId, stateUser, start, end);
	}

	public static int countAllShootersByLeafOrgAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser) {
		return getService()
				   .countAllShootersByLeafOrgAssignedName(name, lastName,
			organizationId, stateCard, esfUserRoleId, stateUser);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser) {
		return getService()
				   .findAllShootersByLeafOrgAssigned(organizationId, stateCard,
			esfUserRoleId, stateUser);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser) {
		return getService()
				   .findAllShootersByLeafOrg(organizationId, stateCard,
			stateUser);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser, int start, int end) {
		return getService()
				   .findAllShootersByLeafOrg(organizationId, stateCard,
			stateUser, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId) {
		return getService().finNationalDelegationESFUsersByMatchId(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllStaff(
		java.lang.Long esfMatchId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String fiscalCode, int state,
		java.lang.Long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllStaff(esfMatchId, firstName, lastName, fiscalCode,
			state, organizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllStaffNamed(
		java.lang.Long esfMatchId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String fiscalCode, int state,
		java.lang.Long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllStaffNamed(esfMatchId, firstName, lastName,
			fiscalCode, state, organizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaffNamed(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findStaffNamed(esfMatchId, firstName, lastName, fiscalCode);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaffNamed(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findStaffNamed(esfMatchId, firstName, lastName, fiscalCode,
			start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaffNamedNational(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findStaffNamedNational(esfMatchId, firstName, lastName,
			fiscalCode);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaffNamedNational(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findStaffNamedNational(esfMatchId, firstName, lastName,
			fiscalCode, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaff(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findStaff(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaff(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findStaff(esfMatchId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		return getService()
				   .finNationalDelegationESFUsersByMatchId(esfMatchId, start,
			end);
	}

	/**
	* Trova lo staff di una specifica gara
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId) {
		return getService()
				   .findNationalDelegationStaffESFUsersByMatchId(esfMatchId);
	}

	/**
	* Trova lo staff di una specifica gara
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		return getService()
				   .findNationalDelegationStaffESFUsersByMatchId(esfMatchId,
			start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId) {
		return getService().findNationalDelegationsESFUsersByMatchId(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		return getService()
				   .findNationalDelegationsESFUsersByMatchId(esfMatchId, start,
			end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId) {
		return getService()
				   .findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(esfMatchId,
			esfPartecipantTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId, int start, int end) {
		return getService()
				   .findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(esfMatchId,
			esfPartecipantTypeId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalShooters() {
		return getService().findNationalShooters();
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalShooters(
		int start, int end) {
		return getService().findNationalShooters(start, end);
	}

	/**
	* Ricerca tutti gli Shooters che possono essere gia' stati associati ad una
	* gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	* non associati (caso <b>isPartecipant</b> = false)
	*
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findNationalPartecipantShooters(idMatch, isPartecipant);
	}

	/**
	* Ricerca tutti gli Shooters che possono essere gia' stati associati ad una
	* gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	* non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findNationalPartecipantShooters(idMatch, isPartecipant,
			start, end);
	}

	/**
	* Ricerca tutti gli Shooters con stato utente <b>stateUser</b> e con stato
	* card <b>stateCard</b> che possono essere gia' stati associati ad una gara
	* con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateCard
	stato della Card
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findPartecipantShooters(stateCard, stateUser, idMatch,
			isPartecipant);
	}

	/**
	* Ricerca tutti gli Shooters con stato utente <b>stateUser</b> e con stato
	* card <b>stateCard</b> che possono essere gia' stati associati ad una gara
	* con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false) I parametri di <b>start</b>
	* e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param stateCard
	stato della Card
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findPartecipantShooters(stateCard, stateUser, idMatch,
			isPartecipant, start, end);
	}

	/**
	* Ricerca tutti gli utenti che sono stati assegnati ad un match nazionale
	* con ruolo Allenatore. L'utetne puÃ¯Â¿Â½ esseree gia' stati associato ad una
	* gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	* non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findNationalPartecipantCoaches(idMatch, isPartecipant);
	}

	/**
	* Ricerca tutti gli utenti che sono stati assegnati ad un match nazionale
	* con ruolo Allenatore. L'utetne puÃ¯Â¿Â½ esseree gia' stati associato ad una
	* gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	* non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findNationalPartecipantCoaches(idMatch, isPartecipant,
			start, end);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Allenatore con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findPartecipantCoaches(stateUser, idMatch, isPartecipant);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Allenatore con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findPartecipantCoaches(stateUser, idMatch, isPartecipant,
			start, end);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Arbitro che possono essere gia' stati
	* associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	* true) o ancora non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findNationalPartecipantReferees(idMatch, isPartecipant);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Arbitro che possono essere gia' stati
	* associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	* true) o ancora non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findNationalPartecipantReferees(idMatch, isPartecipant,
			start, end);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Arbitro con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findPartecipantReferees(stateUser, idMatch, isPartecipant,
			start, end);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Arbitro con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findPartecipantReferees(stateUser, idMatch, isPartecipant);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Medico che possono essere gia' stati
	* associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	* true) o ancora non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService().findNationalPartecipantDoctor(idMatch, isPartecipant);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Medico che possono essere gia' stati
	* associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	* true) o ancora non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findNationalPartecipantDoctor(idMatch, isPartecipant,
			start, end);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Medico con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findPartecipantDoctor(stateUser, idMatch, isPartecipant);
	}

	/**
	* Ricerca tutti gli utenti con ruolo Medico con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findPartecipantDoctor(stateUser, idMatch, isPartecipant,
			start, end);
	}

	public static it.ethica.esf.model.ESFUser addESFUser(long operatorId,
		java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear, boolean male,
		java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, java.lang.String jobTitle,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		java.lang.String birthcity,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFUser(operatorId, code, firstName, middleName,
			lastName, userEmail, fiscalCode, birthdayDay, birthdayMonth,
			birthdayYear, male, skype, facebook, twitter, jobTitle,
			esfEntityState, esfAddresses, phones, birthcity, serviceContext);
	}

	public static it.ethica.esf.model.ESFUser addESFUserInOrganization(
		long userId, java.lang.String code, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.util.Locale locale, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle,
		it.ethica.esf.model.ESFAddress esfAddress,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<com.liferay.portal.model.Phone> phones,
		com.liferay.portal.service.ServiceContext portalUserServiceContext,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFUserInOrganization(userId, code, screenName,
			emailAddress, facebookId, locale, firstName, middleName, lastName,
			prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
			jobTitle, esfAddress, esfEntityState, phones,
			portalUserServiceContext, esfUserServiceContext);
	}

	public static it.ethica.esf.model.ESFUser addESFUserInOrganization(
		long userId, java.lang.String code, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.util.Locale locale, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle,
		it.ethica.esf.model.ESFAddress esfAddress, long esfStateId,
		java.util.List<com.liferay.portal.model.Phone> phones,
		com.liferay.portal.service.ServiceContext portalUserServiceContext,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFUserInOrganization(userId, code, screenName,
			emailAddress, facebookId, locale, firstName, middleName, lastName,
			prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
			jobTitle, esfAddress, esfStateId, phones, portalUserServiceContext,
			esfUserServiceContext);
	}

	public static it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFUser(esfUserId, esfAddresses, serviceContext);
	}

	public static it.ethica.esf.model.ESFUser updateESFUser(long operatorId,
		long esfUserId, java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear, boolean male,
		boolean disable, java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, java.lang.String jobTitle,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		java.lang.String birthcity,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFUser(operatorId, esfUserId, code, firstName,
			middleName, lastName, userEmail, fiscalCode, birthdayDay,
			birthdayMonth, birthdayYear, male, disable, skype, facebook,
			twitter, jobTitle, esfEntityState, esfAddresses, phones, birthcity,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFUser addESFShooter(long operatorId,
		java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear,
		java.lang.String birthcity, java.lang.String nationality, boolean male,
		java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, long typearmy, boolean isSportsGroups,
		java.lang.String job, java.lang.String jobTitle,
		java.lang.String issfIdNumber,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones, boolean privacy1,
		boolean privacy2, boolean privacy3, java.util.Date datePrivacy1,
		java.util.Date datePrivacy2, java.util.Date datePrivacy3,
		boolean validateCF, long codeUser,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFShooter(operatorId, code, firstName, middleName,
			lastName, userEmail, fiscalCode, birthdayDay, birthdayMonth,
			birthdayYear, birthcity, nationality, male, skype, facebook,
			twitter, typearmy, isSportsGroups, job, jobTitle, issfIdNumber,
			esfEntityState, esfCard, esfAddresses, phones, privacy1, privacy2,
			privacy3, datePrivacy1, datePrivacy2, datePrivacy3, validateCF,
			codeUser, esfUserServiceContext);
	}

	public static it.ethica.esf.model.ESFUser updateESFShooter(
		long operatorId, long esfUserId, java.lang.String code,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String userEmail,
		java.lang.String fiscalCode, int birthdayDay, int birthdayMonth,
		int birthdayYear, java.lang.String birthcity,
		java.lang.String nationality, boolean male, boolean disable,
		java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, long typearmy, boolean isSportsGroups,
		java.lang.String job, java.lang.String jobTitle,
		java.lang.String issfIdNumber,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		java.util.Date dateOfDeath, boolean privacy1, boolean privacy2,
		boolean privacy3, java.util.Date datePrivacy1,
		java.util.Date datePrivacy2, java.util.Date datePrivacy3,
		boolean validateCF, long codeUser,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFShooter(operatorId, esfUserId, code, firstName,
			middleName, lastName, userEmail, fiscalCode, birthdayDay,
			birthdayMonth, birthdayYear, birthcity, nationality, male, disable,
			skype, facebook, twitter, typearmy, isSportsGroups, job, jobTitle,
			issfIdNumber, esfEntityState, esfCard, esfAddresses, phones,
			dateOfDeath, privacy1, privacy2, privacy3, datePrivacy1,
			datePrivacy2, datePrivacy3, validateCF, codeUser, serviceContext);
	}

	public static void updateESFUserToESFShooter(long userId, long esfUserId,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFCard> esfCards,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateESFUserToESFShooter(userId, esfUserId, esfCard, esfCards,
			serviceContext);
	}

	public static void addESFUserToESFShooter(long esfUserId, long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		getService().addESFUserToESFShooter(esfUserId, esfCardId);
	}

	public static int countByESFUserRole(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByESFUserRole(esfUserRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserRoles(
		long esfUserId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserRoles(esfUserId, active);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getActiveESFUserRoles(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveESFUserRoles(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllUser()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllUser();
	}

	public static com.liferay.portal.model.User checkEmailAddress(
		java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().checkEmailAddress(emailAddress, serviceContext);
	}

	public static com.liferay.portal.model.User checkScreenName(
		java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().checkScreenName(screenName, serviceContext);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllUserByAgeOnlyPeople()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllUserByAgeOnlyPeople();
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllUserByRolenoNull(
		long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllUserByRolenoNull(roleId, organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findShooterRoleAssignedName(
		java.lang.String name, java.lang.String lastName, long roleId,
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findShooterRoleAssignedName(name, lastName, roleId,
			organizationId, start, end);
	}

	public static int countShooterRoleAssignedName(java.lang.String name,
		java.lang.String lastName, long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countShooterRoleAssignedName(name, lastName, roleId,
			organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaffMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, long fitavId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findStaffMatch(name, lastName, fiscalcode, matchId,
			fitavId, start, end);
	}

	public static int countStaffMatch(java.lang.String name,
		java.lang.String lastName, java.lang.String fiscalcode, long matchId,
		long fitavId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countStaffMatch(name, lastName, fiscalcode, matchId, fitavId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findShooterNotAssociated(
		java.lang.String name, java.lang.String lastName,
		java.lang.String cardCode, long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findShooterNotAssociated(name, lastName, cardCode,
			sportTypeId, start, end);
	}

	public static int countNotNationalShooterBySPT(java.lang.String name,
		java.lang.String lastName, java.lang.String cardCode, long sportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countNotNationalShooterBySPT(name, lastName, cardCode,
			sportTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findALLShooterNotAssociated(
		java.lang.String name, java.lang.String lastName,
		java.lang.String cardCode, long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findALLShooterNotAssociated(name, lastName, cardCode,
			sportTypeId, start, end);
	}

	public static int countALLNotNationalShooterBySPT(java.lang.String name,
		java.lang.String lastName, java.lang.String cardCode, long sportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countALLNotNationalShooterBySPT(name, lastName, cardCode,
			sportTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaffNormalMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findStaffNormalMatch(name, lastName, fiscalcode, matchId,
			start, end);
	}

	public static int countStaffNormalMatch(java.lang.String name,
		java.lang.String lastName, java.lang.String fiscalcode, long matchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countStaffNormalMatch(name, lastName, fiscalcode, matchId);
	}

	public static int countRenwalUser(java.lang.String thisYear,
		java.lang.String lastYear, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countRenwalUser(thisYear, lastYear, orgId);
	}

	public static int countNewUser(java.lang.String endDate,
		java.lang.String startDate, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countNewUser(endDate, startDate, orgId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findByKeyword(
		java.lang.String keyword, java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByKeyword(keyword, columnName);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findShooterByAss(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findShooterByAss(firstName, lastName, cardCode, orgId,
			start, end);
	}

	public static int countShooterByAss(java.lang.String firstName,
		java.lang.String lastName, java.lang.String cardCode, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countShooterByAss(firstName, lastName, cardCode, orgId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findShooterByAssAndNoAss(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findShooterByAssAndNoAss(firstName, lastName, cardCode,
			orgId, start, end);
	}

	public static int countShooterByAssAndNoAss(java.lang.String firstName,
		java.lang.String lastName, java.lang.String cardCode, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countShooterByAssAndNoAss(firstName, lastName, cardCode,
			orgId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findDirectorByMatch(
		java.lang.String firstName, java.lang.String lastName, long matchId,
		long shootingDirectorQualificationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findDirectorByMatch(firstName, lastName, matchId,
			shootingDirectorQualificationId, start, end);
	}

	public static int countDirectorByMatch(java.lang.String firstName,
		java.lang.String lastName, long matchId,
		long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countDirectorByMatch(firstName, lastName, matchId,
			shootingDirectorQualificationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findNewYouthShooter(
		int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findNewYouthShooter(year);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findYouthByCategory(
		long categoryId, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findYouthByCategory(categoryId, year, start, end);
	}

	public static int findYouthByCategoryTotal(long categoryId, int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findYouthByCategoryTotal(categoryId, year);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findNotBDOMemberByAssociatioId(
		java.lang.String lastName, java.lang.String firstName,
		long associationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findNotBDOMemberByAssociatioId(lastName, firstName,
			associationId, start, end);
	}

	public static int countNotBDOMemberByAssociatioId(
		java.lang.String lastName, java.lang.String firstName,
		long associationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countNotBDOMemberByAssociatioId(lastName, firstName,
			associationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAssociatedShooterOrganization(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String card, long associationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAssociatedShooterOrganization(firstName, lastName,
			card, associationId, start, end);
	}

	public static int countAssociatedShooterOrganization(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String card, long associationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countAssociatedShooterOrganization(firstName, lastName,
			card, associationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findByESFFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFFederalRole(esfFederalRoleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFUserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFUserLocalService.class.getName());

			if (invokableLocalService instanceof ESFUserLocalService) {
				_service = (ESFUserLocalService)invokableLocalService;
			}
			else {
				_service = new ESFUserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFUserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFUserLocalService service) {
	}

	private static ESFUserLocalService _service;
}