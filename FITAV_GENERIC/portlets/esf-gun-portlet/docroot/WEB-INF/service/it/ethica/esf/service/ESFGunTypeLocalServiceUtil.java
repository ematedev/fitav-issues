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
 * Provides the local service utility for ESFGunType. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFGunTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFGunTypeLocalService
 * @see it.ethica.esf.service.base.ESFGunTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFGunTypeLocalServiceImpl
 * @generated
 */
public class ESFGunTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFGunTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f gun type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunType the e s f gun type
	* @return the e s f gun type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType addESFGunType(
		it.ethica.esf.model.ESFGunType esfGunType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFGunType(esfGunType);
	}

	/**
	* Creates a new e s f gun type with the primary key. Does not add the e s f gun type to the database.
	*
	* @param esfGunTypeId the primary key for the new e s f gun type
	* @return the new e s f gun type
	*/
	public static it.ethica.esf.model.ESFGunType createESFGunType(
		long esfGunTypeId) {
		return getService().createESFGunType(esfGunTypeId);
	}

	/**
	* Deletes the e s f gun type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunTypeId the primary key of the e s f gun type
	* @return the e s f gun type that was removed
	* @throws PortalException if a e s f gun type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType deleteESFGunType(
		long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFGunType(esfGunTypeId);
	}

	/**
	* Deletes the e s f gun type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunType the e s f gun type
	* @return the e s f gun type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType deleteESFGunType(
		it.ethica.esf.model.ESFGunType esfGunType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFGunType(esfGunType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFGunType fetchESFGunType(
		long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFGunType(esfGunTypeId);
	}

	/**
	* Returns the e s f gun type with the matching UUID and company.
	*
	* @param uuid the e s f gun type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType fetchESFGunTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFGunTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f gun type matching the UUID and group.
	*
	* @param uuid the e s f gun type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType fetchESFGunTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFGunTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f gun type with the primary key.
	*
	* @param esfGunTypeId the primary key of the e s f gun type
	* @return the e s f gun type
	* @throws PortalException if a e s f gun type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType getESFGunType(
		long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunType(esfGunTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f gun type with the matching UUID and company.
	*
	* @param uuid the e s f gun type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun type
	* @throws PortalException if a matching e s f gun type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType getESFGunTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f gun type matching the UUID and group.
	*
	* @param uuid the e s f gun type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun type
	* @throws PortalException if a matching e s f gun type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType getESFGunTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f gun types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f gun types
	* @param end the upper bound of the range of e s f gun types (not inclusive)
	* @return the range of e s f gun types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGunType> getESFGunTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunTypes(start, end);
	}

	/**
	* Returns the number of e s f gun types.
	*
	* @return the number of e s f gun types
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFGunTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunTypesCount();
	}

	/**
	* Updates the e s f gun type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfGunType the e s f gun type
	* @return the e s f gun type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunType updateESFGunType(
		it.ethica.esf.model.ESFGunType esfGunType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFGunType(esfGunType);
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

	public static java.util.List<it.ethica.esf.model.ESFGunType> getESFGunTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunTypes();
	}

	public static it.ethica.esf.model.ESFGunType addESFGunType(long userId,
		java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFGunType(userId, name, description, serviceContext);
	}

	public static it.ethica.esf.model.ESFGunType updateESFGunType(long userId,
		long esfGunTypeId, java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFGunType(userId, esfGunTypeId, name, description,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFGunType deleteESFGunType(
		long esfGunTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFGunType(esfGunTypeId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFGunTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFGunTypeLocalService.class.getName());

			if (invokableLocalService instanceof ESFGunTypeLocalService) {
				_service = (ESFGunTypeLocalService)invokableLocalService;
			}
			else {
				_service = new ESFGunTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFGunTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFGunTypeLocalService service) {
	}

	private static ESFGunTypeLocalService _service;
}