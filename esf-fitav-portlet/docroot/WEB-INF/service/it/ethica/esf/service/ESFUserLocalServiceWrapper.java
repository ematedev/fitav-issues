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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFUserLocalService}.
 *
 * @author Ethica
 * @see ESFUserLocalService
 * @generated
 */
public class ESFUserLocalServiceWrapper implements ESFUserLocalService,
	ServiceWrapper<ESFUserLocalService> {
	public ESFUserLocalServiceWrapper(ESFUserLocalService esfUserLocalService) {
		_esfUserLocalService = esfUserLocalService;
	}

	/**
	* Adds the e s f user to the database. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser addESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.addESFUser(esfUser);
	}

	/**
	* Creates a new e s f user with the primary key. Does not add the e s f user to the database.
	*
	* @param esfUserId the primary key for the new e s f user
	* @return the new e s f user
	*/
	@Override
	public it.ethica.esf.model.ESFUser createESFUser(long esfUserId) {
		return _esfUserLocalService.createESFUser(esfUserId);
	}

	/**
	* Deletes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user that was removed
	* @throws PortalException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.deleteESFUser(esfUserId);
	}

	/**
	* Deletes the e s f user from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser deleteESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.deleteESFUser(esfUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfUserLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFUser fetchESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.fetchESFUser(esfUserId);
	}

	/**
	* Returns the e s f user with the primary key.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user
	* @throws PortalException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser getESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getESFUser(esfUserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsers(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getESFUsers(start, end);
	}

	/**
	* Returns the number of e s f users.
	*
	* @return the number of e s f users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getESFUsersCount();
	}

	/**
	* Updates the e s f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser updateESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.updateESFUser(esfUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfUserLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsersByDeparture(
		long esfDepartureId) {
		return _esfUserLocalService.getESFUsersByDeparture(esfDepartureId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsersByCodeCode(
		java.lang.String code) {
		return _esfUserLocalService.getESFUsersByCodeCode(code);
	}

	@Override
	public it.ethica.esf.model.ESFUser getESFUserByUserCode(long userCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return _esfUserLocalService.getESFUserByUserCode(userCode);
	}

	@Override
	public it.ethica.esf.model.ESFUser getESFUserByCodeUser2(long userCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return _esfUserLocalService.getESFUserByCodeUser2(userCode);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(esfMatchId,
			firstName, lastName, fiscalCode, state, organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId, int start,
		int end) {
		return _esfUserLocalService.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(esfMatchId,
			firstName, lastName, fiscalCode, state, organizationId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId, int start,
		int end) {
		return _esfUserLocalService.getESFUserByFirstName_LastName_FiscalCode(firstName,
			lastName, fiscalCode, state, organizationId, start, end);
	}

	@Override
	public it.ethica.esf.model.ESFUser getESFUserByFiscalCode(
		java.lang.String fiscalCode) {
		return _esfUserLocalService.getESFUserByFiscalCode(fiscalCode);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int start, int end) {
		return _esfUserLocalService.getAllUserByLikeF_L(firstName, lastName,
			screenName, start, end);
	}

	@Override
	public int countAllUserByLikeF_L(java.lang.String firstName,
		java.lang.String lastName, java.lang.String screenName) {
		return _esfUserLocalService.countAllUserByLikeF_L(firstName, lastName,
			screenName);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int state, int start, int end) {
		return _esfUserLocalService.getAllUserByLikeF_L_S(firstName, lastName,
			screenName, state, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int state) {
		return _esfUserLocalService.getAllUserByLikeF_L_S(firstName, lastName,
			screenName, state);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, int state, long organizationId, int start,
		int end) {
		return _esfUserLocalService.getAllUserByLikeF_C_S(firstName, lastName,
			cardCode, state, organizationId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, int state, long organizationId) {
		return _esfUserLocalService.getAllUserByLikeF_C_S(firstName, lastName,
			cardCode, state, organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllShooterByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long organizationId, int start, int end) {
		return _esfUserLocalService.getAllShooterByLikeF_C_S(firstName,
			lastName, cardCode, organizationId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllShooterByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long organizationId) {
		return _esfUserLocalService.getAllShooterByLikeF_C_S(firstName,
			lastName, cardCode, organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllEsfUserByState(
		int state) {
		return _esfUserLocalService.getAllEsfUserByState(state);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllEsfUserByState(
		int state, int start, int end) {
		return _esfUserLocalService.getAllEsfUserByState(state, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findUserByRoleT_N_S(
		java.lang.String title, java.lang.String name, int state)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findUserByRoleT_N_S(title, name, state);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		int stateCard, int stateUser) {
		return _esfUserLocalService.findAllShooters(stateCard, stateUser);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser) {
		return _esfUserLocalService.findAllShooters(organizationId, stateCard,
			stateUser);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser, int start, int end) {
		return _esfUserLocalService.findAllShooters(organizationId, stateCard,
			stateUser, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findRoledUserOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findRoledUserOrganization(organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findRoledUserOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findRoledUserOrganization(organizationId,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser,
		int start, int end) {
		return _esfUserLocalService.findAllShootersByLeafOrgAssigned(organizationId,
			stateCard, esfUserRoleId, stateUser, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser, int start, int end) {
		return _esfUserLocalService.findAllShootersByLeafOrgAssignedName(name,
			lastName, organizationId, stateCard, esfUserRoleId, stateUser,
			start, end);
	}

	@Override
	public int countAllShootersByLeafOrgAssignedName(java.lang.String name,
		java.lang.String lastName, long organizationId, int stateCard,
		long esfUserRoleId, int stateUser) {
		return _esfUserLocalService.countAllShootersByLeafOrgAssignedName(name,
			lastName, organizationId, stateCard, esfUserRoleId, stateUser);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser) {
		return _esfUserLocalService.findAllShootersByLeafOrgAssigned(organizationId,
			stateCard, esfUserRoleId, stateUser);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser) {
		return _esfUserLocalService.findAllShootersByLeafOrg(organizationId,
			stateCard, stateUser);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser, int start, int end) {
		return _esfUserLocalService.findAllShootersByLeafOrg(organizationId,
			stateCard, stateUser, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId) {
		return _esfUserLocalService.finNationalDelegationESFUsersByMatchId(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllStaff(
		java.lang.Long esfMatchId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String fiscalCode, int state,
		java.lang.Long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findAllStaff(esfMatchId, firstName,
			lastName, fiscalCode, state, organizationId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllStaffNamed(
		java.lang.Long esfMatchId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String fiscalCode, int state,
		java.lang.Long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findAllStaffNamed(esfMatchId, firstName,
			lastName, fiscalCode, state, organizationId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamed(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findStaffNamed(esfMatchId, firstName,
			lastName, fiscalCode);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamed(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findStaffNamed(esfMatchId, firstName,
			lastName, fiscalCode, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamedNational(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findStaffNamedNational(esfMatchId,
			firstName, lastName, fiscalCode);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamedNational(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findStaffNamedNational(esfMatchId,
			firstName, lastName, fiscalCode, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaff(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findStaff(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaff(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findStaff(esfMatchId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		return _esfUserLocalService.finNationalDelegationESFUsersByMatchId(esfMatchId,
			start, end);
	}

	/**
	* Trova lo staff di una specifica gara
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId) {
		return _esfUserLocalService.findNationalDelegationStaffESFUsersByMatchId(esfMatchId);
	}

	/**
	* Trova lo staff di una specifica gara
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		return _esfUserLocalService.findNationalDelegationStaffESFUsersByMatchId(esfMatchId,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId) {
		return _esfUserLocalService.findNationalDelegationsESFUsersByMatchId(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		return _esfUserLocalService.findNationalDelegationsESFUsersByMatchId(esfMatchId,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId) {
		return _esfUserLocalService.findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(esfMatchId,
			esfPartecipantTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId, int start, int end) {
		return _esfUserLocalService.findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(esfMatchId,
			esfPartecipantTypeId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalShooters() {
		return _esfUserLocalService.findNationalShooters();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalShooters(
		int start, int end) {
		return _esfUserLocalService.findNationalShooters(start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findNationalPartecipantShooters(idMatch,
			isPartecipant);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findNationalPartecipantShooters(idMatch,
			isPartecipant, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findPartecipantShooters(stateCard,
			stateUser, idMatch, isPartecipant);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findPartecipantShooters(stateCard,
			stateUser, idMatch, isPartecipant, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findNationalPartecipantCoaches(idMatch,
			isPartecipant);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findNationalPartecipantCoaches(idMatch,
			isPartecipant, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findPartecipantCoaches(stateUser, idMatch,
			isPartecipant);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findPartecipantCoaches(stateUser, idMatch,
			isPartecipant, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findNationalPartecipantReferees(idMatch,
			isPartecipant);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findNationalPartecipantReferees(idMatch,
			isPartecipant, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findPartecipantReferees(stateUser, idMatch,
			isPartecipant, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findPartecipantReferees(stateUser, idMatch,
			isPartecipant);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findNationalPartecipantDoctor(idMatch,
			isPartecipant);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findNationalPartecipantDoctor(idMatch,
			isPartecipant, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findPartecipantDoctor(stateUser, idMatch,
			isPartecipant);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfUserLocalService.findPartecipantDoctor(stateUser, idMatch,
			isPartecipant, start, end);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUser(long operatorId,
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
		return _esfUserLocalService.addESFUser(operatorId, code, firstName,
			middleName, lastName, userEmail, fiscalCode, birthdayDay,
			birthdayMonth, birthdayYear, male, skype, facebook, twitter,
			jobTitle, esfEntityState, esfAddresses, phones, birthcity,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUserInOrganization(long userId,
		java.lang.String code, java.lang.String screenName,
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
		return _esfUserLocalService.addESFUserInOrganization(userId, code,
			screenName, emailAddress, facebookId, locale, firstName,
			middleName, lastName, prefixId, suffixId, male, birthdayMonth,
			birthdayDay, birthdayYear, jobTitle, esfAddress, esfEntityState,
			phones, portalUserServiceContext, esfUserServiceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUserInOrganization(long userId,
		java.lang.String code, java.lang.String screenName,
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
		return _esfUserLocalService.addESFUserInOrganization(userId, code,
			screenName, emailAddress, facebookId, locale, firstName,
			middleName, lastName, prefixId, suffixId, male, birthdayMonth,
			birthdayDay, birthdayYear, jobTitle, esfAddress, esfStateId,
			phones, portalUserServiceContext, esfUserServiceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.deleteESFUser(esfUserId, esfAddresses,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser updateESFUser(long operatorId,
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
		return _esfUserLocalService.updateESFUser(operatorId, esfUserId, code,
			firstName, middleName, lastName, userEmail, fiscalCode,
			birthdayDay, birthdayMonth, birthdayYear, male, disable, skype,
			facebook, twitter, jobTitle, esfEntityState, esfAddresses, phones,
			birthcity, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFShooter(long operatorId,
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
		return _esfUserLocalService.addESFShooter(operatorId, code, firstName,
			middleName, lastName, userEmail, fiscalCode, birthdayDay,
			birthdayMonth, birthdayYear, birthcity, nationality, male, skype,
			facebook, twitter, typearmy, isSportsGroups, job, jobTitle,
			issfIdNumber, esfEntityState, esfCard, esfAddresses, phones,
			privacy1, privacy2, privacy3, datePrivacy1, datePrivacy2,
			datePrivacy3, validateCF, codeUser, esfUserServiceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser updateESFShooter(long operatorId,
		long esfUserId, java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear,
		java.lang.String birthcity, java.lang.String nationality, boolean male,
		boolean disable, java.lang.String skype, java.lang.String facebook,
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
		return _esfUserLocalService.updateESFShooter(operatorId, esfUserId,
			code, firstName, middleName, lastName, userEmail, fiscalCode,
			birthdayDay, birthdayMonth, birthdayYear, birthcity, nationality,
			male, disable, skype, facebook, twitter, typearmy, isSportsGroups,
			job, jobTitle, issfIdNumber, esfEntityState, esfCard, esfAddresses,
			phones, dateOfDeath, privacy1, privacy2, privacy3, datePrivacy1,
			datePrivacy2, datePrivacy3, validateCF, codeUser, serviceContext);
	}

	@Override
	public void updateESFUserToESFShooter(long userId, long esfUserId,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFCard> esfCards,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfUserLocalService.updateESFUserToESFShooter(userId, esfUserId,
			esfCard, esfCards, serviceContext);
	}

	@Override
	public void addESFUserToESFShooter(long esfUserId, long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		_esfUserLocalService.addESFUserToESFShooter(esfUserId, esfCardId);
	}

	@Override
	public int countByESFUserRole(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countByESFUserRole(esfUserRoleId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserRoles(
		long esfUserId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getESFUserRoles(esfUserId, active);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getActiveESFUserRoles(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getActiveESFUserRoles(esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllUser()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findAllUser();
	}

	@Override
	public com.liferay.portal.model.User checkEmailAddress(
		java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.checkEmailAddress(emailAddress,
			serviceContext);
	}

	@Override
	public com.liferay.portal.model.User checkScreenName(
		java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.checkScreenName(screenName, serviceContext);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllUserByAgeOnlyPeople()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findAllUserByAgeOnlyPeople();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllUserByRolenoNull(
		long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findAllUserByRolenoNull(roleId,
			organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findShooterRoleAssignedName(
		java.lang.String name, java.lang.String lastName, long roleId,
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findShooterRoleAssignedName(name, lastName,
			roleId, organizationId, start, end);
	}

	@Override
	public int countShooterRoleAssignedName(java.lang.String name,
		java.lang.String lastName, long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countShooterRoleAssignedName(name,
			lastName, roleId, organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, long fitavId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findStaffMatch(name, lastName, fiscalcode,
			matchId, fitavId, start, end);
	}

	@Override
	public int countStaffMatch(java.lang.String name,
		java.lang.String lastName, java.lang.String fiscalcode, long matchId,
		long fitavId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countStaffMatch(name, lastName, fiscalcode,
			matchId, fitavId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findShooterNotAssociated(
		java.lang.String name, java.lang.String lastName,
		java.lang.String cardCode, long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findShooterNotAssociated(name, lastName,
			cardCode, sportTypeId, start, end);
	}

	@Override
	public int countNotNationalShooterBySPT(java.lang.String name,
		java.lang.String lastName, java.lang.String cardCode, long sportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countNotNationalShooterBySPT(name,
			lastName, cardCode, sportTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findALLShooterNotAssociated(
		java.lang.String name, java.lang.String lastName,
		java.lang.String cardCode, long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findALLShooterNotAssociated(name, lastName,
			cardCode, sportTypeId, start, end);
	}

	@Override
	public int countALLNotNationalShooterBySPT(java.lang.String name,
		java.lang.String lastName, java.lang.String cardCode, long sportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countALLNotNationalShooterBySPT(name,
			lastName, cardCode, sportTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNormalMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findStaffNormalMatch(name, lastName,
			fiscalcode, matchId, start, end);
	}

	@Override
	public int countStaffNormalMatch(java.lang.String name,
		java.lang.String lastName, java.lang.String fiscalcode, long matchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countStaffNormalMatch(name, lastName,
			fiscalcode, matchId);
	}

	@Override
	public int countRenwalUser(java.lang.String thisYear,
		java.lang.String lastYear, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countRenwalUser(thisYear, lastYear, orgId);
	}

	@Override
	public int countNewUser(java.lang.String endDate,
		java.lang.String startDate, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countNewUser(endDate, startDate, orgId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findByKeyword(
		java.lang.String keyword, java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findByKeyword(keyword, columnName);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findShooterByAss(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findShooterByAss(firstName, lastName,
			cardCode, orgId, start, end);
	}

	@Override
	public int countShooterByAss(java.lang.String firstName,
		java.lang.String lastName, java.lang.String cardCode, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countShooterByAss(firstName, lastName,
			cardCode, orgId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findShooterByAssAndNoAss(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findShooterByAssAndNoAss(firstName,
			lastName, cardCode, orgId, start, end);
	}

	@Override
	public int countShooterByAssAndNoAss(java.lang.String firstName,
		java.lang.String lastName, java.lang.String cardCode, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countShooterByAssAndNoAss(firstName,
			lastName, cardCode, orgId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findDirectorByMatch(
		java.lang.String firstName, java.lang.String lastName, long matchId,
		long shootingDirectorQualificationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findDirectorByMatch(firstName, lastName,
			matchId, shootingDirectorQualificationId, start, end);
	}

	@Override
	public int countDirectorByMatch(java.lang.String firstName,
		java.lang.String lastName, long matchId,
		long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countDirectorByMatch(firstName, lastName,
			matchId, shootingDirectorQualificationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNewYouthShooter(
		int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findNewYouthShooter(year);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findYouthByCategory(
		long categoryId, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findYouthByCategory(categoryId, year,
			start, end);
	}

	@Override
	public int findYouthByCategoryTotal(long categoryId, int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findYouthByCategoryTotal(categoryId, year);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNotBDOMemberByAssociatioId(
		java.lang.String lastName, java.lang.String firstName,
		long associationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findNotBDOMemberByAssociatioId(lastName,
			firstName, associationId, start, end);
	}

	@Override
	public int countNotBDOMemberByAssociatioId(java.lang.String lastName,
		java.lang.String firstName, long associationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countNotBDOMemberByAssociatioId(lastName,
			firstName, associationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAssociatedShooterOrganization(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String card, long associationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findAssociatedShooterOrganization(firstName,
			lastName, card, associationId, start, end);
	}

	@Override
	public int countAssociatedShooterOrganization(java.lang.String firstName,
		java.lang.String lastName, java.lang.String card, long associationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countAssociatedShooterOrganization(firstName,
			lastName, card, associationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findByESFFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findByESFFederalRole(esfFederalRoleId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFUserLocalService getWrappedESFUserLocalService() {
		return _esfUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFUserLocalService(
		ESFUserLocalService esfUserLocalService) {
		_esfUserLocalService = esfUserLocalService;
	}

	@Override
	public ESFUserLocalService getWrappedService() {
		return _esfUserLocalService;
	}

	@Override
	public void setWrappedService(ESFUserLocalService esfUserLocalService) {
		_esfUserLocalService = esfUserLocalService;
	}

	private ESFUserLocalService _esfUserLocalService;
}