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

package it.ethica.esf.renewal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ESFRenewalCompany. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ethica
 * @see ESFRenewalCompanyLocalServiceUtil
 * @see it.ethica.esf.renewal.service.base.ESFRenewalCompanyLocalServiceBaseImpl
 * @see it.ethica.esf.renewal.service.impl.ESFRenewalCompanyLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESFRenewalCompanyLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFRenewalCompanyLocalServiceUtil} to access the e s f renewal company local service. Add custom service methods to {@link it.ethica.esf.renewal.service.impl.ESFRenewalCompanyLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e s f renewal company to the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewalCompany the e s f renewal company
	* @return the e s f renewal company that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany addESFRenewalCompany(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s f renewal company with the primary key. Does not add the e s f renewal company to the database.
	*
	* @param esfRenewalCompanyId the primary key for the new e s f renewal company
	* @return the new e s f renewal company
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany createESFRenewalCompany(
		long esfRenewalCompanyId);

	/**
	* Deletes the e s f renewal company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewalCompanyId the primary key of the e s f renewal company
	* @return the e s f renewal company that was removed
	* @throws PortalException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany deleteESFRenewalCompany(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s f renewal company from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewalCompany the e s f renewal company
	* @return the e s f renewal company that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany deleteESFRenewalCompany(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchESFRenewalCompany(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal company with the primary key.
	*
	* @param esfRenewalCompanyId the primary key of the e s f renewal company
	* @return the e s f renewal company
	* @throws PortalException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.renewal.model.ESFRenewalCompany getESFRenewalCompany(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewal companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @return the range of e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewal companies.
	*
	* @return the number of e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFRenewalCompaniesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s f renewal company in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfRenewalCompany the e s f renewal company
	* @return the e s f renewal company that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany updateESFRenewalCompany(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public it.ethica.esf.renewal.model.ESFRenewalCompany addESFRenewalCompany(
		long userId, long esfOrganizationId, int cardsNumber, int year,
		java.util.Date date, int paymentType, int status, double amount,
		java.lang.String info, java.lang.String accountholder,
		java.util.Date paymentDate, double integrationAmount,
		java.util.Date integrationDate, int integrationType,
		java.lang.String integrationAccountholder, boolean join)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Integer> getAllYears()
		throws com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.renewal.model.ESFRenewalCompany deleteESFRenewalCompany(
		int esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanyByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanyByPaymentType(
		int paymentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanyByYear(
		int year) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanyByP_S(
		int paymentType, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanyByP_Y(
		int paymentType, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanyByS_Y(
		int status, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.renewal.model.ESFRenewalCompany getESFRenewalCompanyByE_Y(
		long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanyByN_C_R_Y(
		java.lang.String name, java.lang.String code, java.lang.String region,
		int year, int start, int end);

	public it.ethica.esf.renewal.model.ESFRenewalCompany updateESFRenewalCompany(
		long esfRenewalCompanyId, long userId, long esfOrganizationId,
		int cardsNumber, int year, java.util.Date date, int paymentType,
		int status, double amount, java.lang.String info,
		java.lang.String accountholder, java.util.Date paymentDate,
		double integrationAmount, java.util.Date integrationDate,
		int integrationType, java.lang.String integrationAccountholder,
		boolean join)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}