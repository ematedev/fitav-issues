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

package it.ethica.esf.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFRenewalLocalService}.
 *
 * @author Ethica
 * @see ESFRenewalLocalService
 * @generated
 */
public class ESFRenewalLocalServiceWrapper implements ESFRenewalLocalService,
	ServiceWrapper<ESFRenewalLocalService> {
	public ESFRenewalLocalServiceWrapper(
		ESFRenewalLocalService esfRenewalLocalService) {
		_esfRenewalLocalService = esfRenewalLocalService;
	}

	/**
	* Adds the e s f renewal to the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewal the e s f renewal
	* @return the e s f renewal that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRenewal addESFRenewal(
		it.ethica.esf.model.ESFRenewal esfRenewal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.addESFRenewal(esfRenewal);
	}

	/**
	* Creates a new e s f renewal with the primary key. Does not add the e s f renewal to the database.
	*
	* @param esfRenewalId the primary key for the new e s f renewal
	* @return the new e s f renewal
	*/
	@Override
	public it.ethica.esf.model.ESFRenewal createESFRenewal(long esfRenewalId) {
		return _esfRenewalLocalService.createESFRenewal(esfRenewalId);
	}

	/**
	* Deletes the e s f renewal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewalId the primary key of the e s f renewal
	* @return the e s f renewal that was removed
	* @throws PortalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRenewal deleteESFRenewal(long esfRenewalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.deleteESFRenewal(esfRenewalId);
	}

	/**
	* Deletes the e s f renewal from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewal the e s f renewal
	* @return the e s f renewal that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRenewal deleteESFRenewal(
		it.ethica.esf.model.ESFRenewal esfRenewal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.deleteESFRenewal(esfRenewal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfRenewalLocalService.dynamicQuery();
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
		return _esfRenewalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfRenewalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfRenewalLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfRenewalLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfRenewalLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFRenewal fetchESFRenewal(long esfRenewalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.fetchESFRenewal(esfRenewalId);
	}

	/**
	* Returns the e s f renewal with the primary key.
	*
	* @param esfRenewalId the primary key of the e s f renewal
	* @return the e s f renewal
	* @throws PortalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRenewal getESFRenewal(long esfRenewalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.getESFRenewal(esfRenewalId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f renewals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> getESFRenewals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.getESFRenewals(start, end);
	}

	/**
	* Returns the number of e s f renewals.
	*
	* @return the number of e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFRenewalsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.getESFRenewalsCount();
	}

	/**
	* Updates the e s f renewal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfRenewal the e s f renewal
	* @return the e s f renewal that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRenewal updateESFRenewal(
		it.ethica.esf.model.ESFRenewal esfRenewal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.updateESFRenewal(esfRenewal);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfRenewalLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfRenewalLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfRenewalLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByESFRenewalUser_id(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByESFRenewalUser_id(userId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findAll();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByRegion(
		long currentOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByRegion(currentOrganizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByRegion(
		long currentOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByRegion(currentOrganizationId,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrgId_IsTotal(
		long currentOrganizationId, boolean isTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByOrgId_IsTotal(currentOrganizationId,
			isTotal);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByRenewalFatherId(
		long renewalFatherId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByRenewalFatherId(renewalFatherId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrg_Year(
		long orgId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByOrg_Year(orgId, year);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByReason_IsTotal(
		java.lang.String reason, boolean isTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByReason_IsTotal(reason, isTotal);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByRenewalFatherId_OrgId(
		long renewalFatherId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByRenewalFatherId_OrgId(renewalFatherId,
			organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrgId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalLocalService.findByOrgId(organizationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFRenewalLocalService getWrappedESFRenewalLocalService() {
		return _esfRenewalLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFRenewalLocalService(
		ESFRenewalLocalService esfRenewalLocalService) {
		_esfRenewalLocalService = esfRenewalLocalService;
	}

	@Override
	public ESFRenewalLocalService getWrappedService() {
		return _esfRenewalLocalService;
	}

	@Override
	public void setWrappedService(ESFRenewalLocalService esfRenewalLocalService) {
		_esfRenewalLocalService = esfRenewalLocalService;
	}

	private ESFRenewalLocalService _esfRenewalLocalService;
}