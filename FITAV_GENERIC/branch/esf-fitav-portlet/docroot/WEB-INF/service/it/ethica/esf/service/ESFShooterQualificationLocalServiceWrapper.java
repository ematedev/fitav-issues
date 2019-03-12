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
 * Provides a wrapper for {@link ESFShooterQualificationLocalService}.
 *
 * @author Ethica
 * @see ESFShooterQualificationLocalService
 * @generated
 */
public class ESFShooterQualificationLocalServiceWrapper
	implements ESFShooterQualificationLocalService,
		ServiceWrapper<ESFShooterQualificationLocalService> {
	public ESFShooterQualificationLocalServiceWrapper(
		ESFShooterQualificationLocalService esfShooterQualificationLocalService) {
		_esfShooterQualificationLocalService = esfShooterQualificationLocalService;
	}

	/**
	* Adds the e s f shooter qualification to the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualification the e s f shooter qualification
	* @return the e s f shooter qualification that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification addESFShooterQualification(
		it.ethica.esf.model.ESFShooterQualification esfShooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.addESFShooterQualification(esfShooterQualification);
	}

	/**
	* Creates a new e s f shooter qualification with the primary key. Does not add the e s f shooter qualification to the database.
	*
	* @param esfShooterQualificationId the primary key for the new e s f shooter qualification
	* @return the new e s f shooter qualification
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification createESFShooterQualification(
		long esfShooterQualificationId) {
		return _esfShooterQualificationLocalService.createESFShooterQualification(esfShooterQualificationId);
	}

	/**
	* Deletes the e s f shooter qualification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualificationId the primary key of the e s f shooter qualification
	* @return the e s f shooter qualification that was removed
	* @throws PortalException if a e s f shooter qualification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification deleteESFShooterQualification(
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.deleteESFShooterQualification(esfShooterQualificationId);
	}

	/**
	* Deletes the e s f shooter qualification from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualification the e s f shooter qualification
	* @return the e s f shooter qualification that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification deleteESFShooterQualification(
		it.ethica.esf.model.ESFShooterQualification esfShooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.deleteESFShooterQualification(esfShooterQualification);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfShooterQualificationLocalService.dynamicQuery();
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
		return _esfShooterQualificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfShooterQualificationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfShooterQualificationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _esfShooterQualificationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfShooterQualificationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualification fetchESFShooterQualification(
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.fetchESFShooterQualification(esfShooterQualificationId);
	}

	/**
	* Returns the e s f shooter qualification with the matching UUID and company.
	*
	* @param uuid the e s f shooter qualification's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification fetchESFShooterQualificationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.fetchESFShooterQualificationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f shooter qualification matching the UUID and group.
	*
	* @param uuid the e s f shooter qualification's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f shooter qualification, or <code>null</code> if a matching e s f shooter qualification could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification fetchESFShooterQualificationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.fetchESFShooterQualificationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f shooter qualification with the primary key.
	*
	* @param esfShooterQualificationId the primary key of the e s f shooter qualification
	* @return the e s f shooter qualification
	* @throws PortalException if a e s f shooter qualification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification getESFShooterQualification(
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.getESFShooterQualification(esfShooterQualificationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f shooter qualification with the matching UUID and company.
	*
	* @param uuid the e s f shooter qualification's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f shooter qualification
	* @throws PortalException if a matching e s f shooter qualification could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification getESFShooterQualificationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.getESFShooterQualificationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f shooter qualification matching the UUID and group.
	*
	* @param uuid the e s f shooter qualification's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f shooter qualification
	* @throws PortalException if a matching e s f shooter qualification could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification getESFShooterQualificationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.getESFShooterQualificationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f shooter qualifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter qualifications
	* @param end the upper bound of the range of e s f shooter qualifications (not inclusive)
	* @return the range of e s f shooter qualifications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterQualification> getESFShooterQualifications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.getESFShooterQualifications(start,
			end);
	}

	/**
	* Returns the number of e s f shooter qualifications.
	*
	* @return the number of e s f shooter qualifications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFShooterQualificationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.getESFShooterQualificationsCount();
	}

	/**
	* Updates the e s f shooter qualification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualification the e s f shooter qualification
	* @return the e s f shooter qualification that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualification updateESFShooterQualification(
		it.ethica.esf.model.ESFShooterQualification esfShooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.updateESFShooterQualification(esfShooterQualification);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfShooterQualificationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfShooterQualificationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfShooterQualificationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterQualification> getESFShooterQualifications()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.getESFShooterQualifications();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterQualification> getESFShooterCategories(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationException {
		return _esfShooterQualificationLocalService.getESFShooterCategories(esfTournamentId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterQualification> findByMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationException {
		return _esfShooterQualificationLocalService.findByMatchId(esfMatchId);
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualification addESFShooterQualification(
		long userId, java.lang.String name, java.lang.String description,
		java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.addESFShooterQualification(userId,
			name, description, code, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualification updateESFShooterQualification(
		long esfShooterQualificationId, java.lang.String name,
		java.lang.String description, java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.updateESFShooterQualification(esfShooterQualificationId,
			name, description, code, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualification deleteESFShooterQualification(
		long esfShooterQualificationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationLocalService.deleteESFShooterQualification(esfShooterQualificationId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFShooterQualificationLocalService getWrappedESFShooterQualificationLocalService() {
		return _esfShooterQualificationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFShooterQualificationLocalService(
		ESFShooterQualificationLocalService esfShooterQualificationLocalService) {
		_esfShooterQualificationLocalService = esfShooterQualificationLocalService;
	}

	@Override
	public ESFShooterQualificationLocalService getWrappedService() {
		return _esfShooterQualificationLocalService;
	}

	@Override
	public void setWrappedService(
		ESFShooterQualificationLocalService esfShooterQualificationLocalService) {
		_esfShooterQualificationLocalService = esfShooterQualificationLocalService;
	}

	private ESFShooterQualificationLocalService _esfShooterQualificationLocalService;
}