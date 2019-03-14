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
	* Returns the e s f user with the matching UUID and company.
	*
	* @param uuid the e s f user's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser fetchESFUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.fetchESFUserByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f user matching the UUID and group.
	*
	* @param uuid the e s f user's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser fetchESFUserByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.fetchESFUserByUuidAndGroupId(uuid, groupId);
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
	* Returns the e s f user with the matching UUID and company.
	*
	* @param uuid the e s f user's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f user
	* @throws PortalException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser getESFUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getESFUserByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f user matching the UUID and group.
	*
	* @param uuid the e s f user's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f user
	* @throws PortalException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFUser getESFUserByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.getESFUserByUuidAndGroupId(uuid, groupId);
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
	public java.util.List<it.ethica.esf.model.ESFUser> findByPortalUserId(
		long portalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findByPortalUserId(portalUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findByPortalUserId(
		long portalUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.findByPortalUserId(portalUserId, start, end);
	}

	@Override
	public int countByPortalUserId(long portalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.countByPortalUserId(portalUserId);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUser(long userId,
		java.lang.String screenName, java.lang.String emailAddress,
		long facebookId, java.util.Locale locale, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle,
		com.liferay.portal.service.ServiceContext portalUserServiceContext,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.addESFUser(userId, screenName,
			emailAddress, facebookId, locale, firstName, middleName, lastName,
			prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
			jobTitle, portalUserServiceContext, esfUserServiceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUser(long userId,
		long portalUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.addESFUser(userId, portalUserId,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId,
		long portalUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.deleteESFUser(esfUserId, portalUserId,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.deleteESFUser(esfUserId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser updateESFUser(long userId,
		long esfUserId, java.lang.String emailAddress,
		java.lang.String firstName, java.lang.String lastName, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.updateESFUser(userId, esfUserId,
			emailAddress, firstName, lastName, male, birthdayMonth,
			birthdayDay, birthdayYear, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFUser updateESFUser(long userId,
		long esfUserId, long portalUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUserLocalService.updateESFUser(userId, esfUserId,
			portalUserId, serviceContext);
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