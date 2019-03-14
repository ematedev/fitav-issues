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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ESFAddress. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ethica
 * @see ESFAddressLocalServiceUtil
 * @see it.ethica.esf.service.base.ESFAddressLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFAddressLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESFAddressLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFAddressLocalServiceUtil} to access the e s f address local service. Add custom service methods to {@link it.ethica.esf.service.impl.ESFAddressLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e s f address to the database. Also notifies the appropriate model listeners.
	*
	* @param esfAddress the e s f address
	* @return the e s f address that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress addESFAddress(
		it.ethica.esf.model.ESFAddress esfAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s f address with the primary key. Does not add the e s f address to the database.
	*
	* @param esfAddressId the primary key for the new e s f address
	* @return the new e s f address
	*/
	public it.ethica.esf.model.ESFAddress createESFAddress(long esfAddressId);

	/**
	* Deletes the e s f address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfAddressId the primary key of the e s f address
	* @return the e s f address that was removed
	* @throws PortalException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress deleteESFAddress(long esfAddressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s f address from the database. Also notifies the appropriate model listeners.
	*
	* @param esfAddress the e s f address
	* @return the e s f address that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress deleteESFAddress(
		it.ethica.esf.model.ESFAddress esfAddress)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public it.ethica.esf.model.ESFAddress fetchESFAddress(long esfAddressId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f address matching the UUID and group.
	*
	* @param uuid the e s f address's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFAddress fetchESFAddressByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f address with the primary key.
	*
	* @param esfAddressId the primary key of the e s f address
	* @return the e s f address
	* @throws PortalException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFAddress getESFAddress(long esfAddressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f address matching the UUID and group.
	*
	* @param uuid the e s f address's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f address
	* @throws PortalException if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFAddress getESFAddressByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @return the range of e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFAddress> getESFAddresses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f addresses.
	*
	* @return the number of e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFAddressesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s f address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfAddress the e s f address
	* @return the e s f address that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress updateESFAddress(
		it.ethica.esf.model.ESFAddress esfAddress)
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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameRegion(java.lang.String idRegion)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameProvince(java.lang.String idRegion,
		java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameCity(java.lang.String idRegion,
		java.lang.String idProvince, long idCity)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException;

	public java.util.List<it.ethica.esf.model.Country> findAllCountry()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.Country> findAllCountry(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.Region> findAllRegions()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.Region> findByCountry(
		java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.Region> findByCountry(
		java.lang.String idCountry, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.Province> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.Province> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.City> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.City> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ritorna un oggetto ESFAddress sulla base dei parametri in input
	*
	* @param longitude
	* @param latitude
	* @return ESFAddress
	* @throws NoSuchAddressException
	* @throws SystemException
	*/
	public it.ethica.esf.model.ESFAddress findByL_L(double longitude,
		double latitude)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Inserimento dell' elemento ESFAddress
	*
	* @param userId
	* @param longitude
	* @param esfCountryId
	* @param esfRegionId
	* @param esfProvinceId
	* @param esfCityId
	* @param latitude
	* @param className
	* @param classNameId
	* @param classPk
	* @param street1
	* @param street2
	* @param street3
	* @param zip
	* @param typeId
	* @param mailing
	* @param primary
	* @param serviceContext
	* @return ESFAddress
	* @throws SystemException
	* @throws PortalException
	*/
	public it.ethica.esf.model.ESFAddress addESFAddress(long userId,
		double longitude, java.lang.String esfCountryId,
		java.lang.String esfRegionId, java.lang.String esfProvinceId,
		long esfCityId, double latitude, java.lang.String className,
		long classPk, java.lang.String street1, java.lang.String street2,
		java.lang.String street3, java.lang.String zip, int typeId,
		boolean mailing, boolean primary,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Update dell'elemento ESFAddress
	*
	* @param userId
	* @param esfAddressId
	* @param esfCountryId
	* @param esfRegionId
	* @param esfProvinceId
	* @param esfCityId
	* @param latitude
	* @param longitude
	* @param className
	* @param classNameId
	* @param classPk
	* @param street1
	* @param street2
	* @param street3
	* @param zip
	* @param typeId
	* @param mailing
	* @param primary
	* @param serviceContext
	* @return ESFAddress
	* @throws PortalException
	* @throws SystemException
	*/
	public it.ethica.esf.model.ESFAddress updateESFAddress(long userId,
		long esfAddressId, java.lang.String esfCountryId,
		java.lang.String esfRegionId, java.lang.String esfProvinceId,
		long esfCityId, double latitude, double longitude,
		java.lang.String className, long classPk, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String zip, int typeId, boolean mailing, boolean primary,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Delete dell'elemento ESFAddress
	*
	* @param esfAddressId
	* @param serviceContext
	* @return ESFAddress
	* @throws SystemException
	* @throws PortalException
	*/
	public it.ethica.esf.model.ESFAddress deleteESFAddress(long esfAddressId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}