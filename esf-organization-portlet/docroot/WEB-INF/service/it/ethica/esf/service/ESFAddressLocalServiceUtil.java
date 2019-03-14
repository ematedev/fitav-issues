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
 * Provides the local service utility for ESFAddress. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFAddressLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFAddressLocalService
 * @see it.ethica.esf.service.base.ESFAddressLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFAddressLocalServiceImpl
 * @generated
 */
public class ESFAddressLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFAddressLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f address to the database. Also notifies the appropriate model listeners.
	*
	* @param esfAddress the e s f address
	* @return the e s f address that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAddress addESFAddress(
		it.ethica.esf.model.ESFAddress esfAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFAddress(esfAddress);
	}

	/**
	* Creates a new e s f address with the primary key. Does not add the e s f address to the database.
	*
	* @param esfAddressId the primary key for the new e s f address
	* @return the new e s f address
	*/
	public static it.ethica.esf.model.ESFAddress createESFAddress(
		long esfAddressId) {
		return getService().createESFAddress(esfAddressId);
	}

	/**
	* Deletes the e s f address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfAddressId the primary key of the e s f address
	* @return the e s f address that was removed
	* @throws PortalException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAddress deleteESFAddress(
		long esfAddressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFAddress(esfAddressId);
	}

	/**
	* Deletes the e s f address from the database. Also notifies the appropriate model listeners.
	*
	* @param esfAddress the e s f address
	* @return the e s f address that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAddress deleteESFAddress(
		it.ethica.esf.model.ESFAddress esfAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFAddress(esfAddress);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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

	public static it.ethica.esf.model.ESFAddress fetchESFAddress(
		long esfAddressId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFAddress(esfAddressId);
	}

	/**
	* Returns the e s f address matching the UUID and group.
	*
	* @param uuid the e s f address's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAddress fetchESFAddressByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFAddressByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f address with the primary key.
	*
	* @param esfAddressId the primary key of the e s f address
	* @return the e s f address
	* @throws PortalException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAddress getESFAddress(
		long esfAddressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFAddress(esfAddressId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f address matching the UUID and group.
	*
	* @param uuid the e s f address's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f address
	* @throws PortalException if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAddress getESFAddressByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFAddressByUuidAndGroupId(uuid, groupId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFAddress> getESFAddresses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFAddresses(start, end);
	}

	/**
	* Returns the number of e s f addresses.
	*
	* @return the number of e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFAddressesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFAddressesCount();
	}

	/**
	* Updates the e s f address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfAddress the e s f address
	* @return the e s f address that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAddress updateESFAddress(
		it.ethica.esf.model.ESFAddress esfAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFAddress(esfAddress);
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

	public static it.ethica.esf.model.ESFAddress findByL_L(double longitude,
		double latitude)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException {
		return getService().findByL_L(longitude, latitude);
	}

	public static java.util.List<it.ethica.esf.model.ESFAddress> getESFAddresses(
		long companyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFAddresses(companyId, className, classPK);
	}

	public static it.ethica.esf.model.ESFAddress addESFAddress(long userId,
		double longitude, java.lang.String esfCountryId,
		java.lang.String esfRegionId, java.lang.String esfProvinceId,
		java.lang.String esfCityId, double latitude,
		java.lang.String className, long classPk, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String zip, int typeId, boolean mailing, boolean primary,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFAddress(userId, longitude, esfCountryId, esfRegionId,
			esfProvinceId, esfCityId, latitude, className, classPk, street1,
			street2, street3, zip, typeId, mailing, primary, serviceContext);
	}

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
	public static it.ethica.esf.model.ESFAddress updateESFAddress(long userId,
		long esfAddressId, java.lang.String esfCountryId,
		java.lang.String esfRegionId, java.lang.String esfProvinceId,
		java.lang.String esfCityId, double latitude, double longitude,
		java.lang.String className, long classPk, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String zip, int typeId, boolean mailing, boolean primary,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFAddress(userId, esfAddressId, esfCountryId,
			esfRegionId, esfProvinceId, esfCityId, latitude, longitude,
			className, classPk, street1, street2, street3, zip, typeId,
			mailing, primary, serviceContext);
	}

	/**
	* Delete dell'elemento ESFAddress
	*
	* @param esfAddressId
	* @param serviceContext
	* @return ESFAddress
	* @throws SystemException
	* @throws PortalException
	*/
	public static it.ethica.esf.model.ESFAddress deleteESFAddress(
		long esfAddressId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFAddress(esfAddressId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFAddressLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFAddressLocalService.class.getName());

			if (invokableLocalService instanceof ESFAddressLocalService) {
				_service = (ESFAddressLocalService)invokableLocalService;
			}
			else {
				_service = new ESFAddressLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFAddressLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFAddressLocalService service) {
	}

	private static ESFAddressLocalService _service;
}