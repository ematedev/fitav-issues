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
 * Provides the local service utility for ESFSportType. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFSportTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ethica
 * @see ESFSportTypeLocalService
 * @see it.ethica.esf.service.base.ESFSportTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFSportTypeLocalServiceImpl
 * @generated
 */
public class ESFSportTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFSportTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f sport type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfSportType the e s f sport type
	* @return the e s f sport type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType addESFSportType(
		it.ethica.esf.model.ESFSportType esfSportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFSportType(esfSportType);
	}

	/**
	* Creates a new e s f sport type with the primary key. Does not add the e s f sport type to the database.
	*
	* @param esfSportTypeId the primary key for the new e s f sport type
	* @return the new e s f sport type
	*/
	public static it.ethica.esf.model.ESFSportType createESFSportType(
		long esfSportTypeId) {
		return getService().createESFSportType(esfSportTypeId);
	}

	/**
	* Deletes the e s f sport type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSportTypeId the primary key of the e s f sport type
	* @return the e s f sport type that was removed
	* @throws PortalException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType deleteESFSportType(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFSportType(esfSportTypeId);
	}

	/**
	* Deletes the e s f sport type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSportType the e s f sport type
	* @return the e s f sport type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType deleteESFSportType(
		it.ethica.esf.model.ESFSportType esfSportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFSportType(esfSportType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFSportType fetchESFSportType(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFSportType(esfSportTypeId);
	}

	/**
	* Returns the e s f sport type with the matching UUID and company.
	*
	* @param uuid the e s f sport type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType fetchESFSportTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFSportTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f sport type matching the UUID and group.
	*
	* @param uuid the e s f sport type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType fetchESFSportTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFSportTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f sport type with the primary key.
	*
	* @param esfSportTypeId the primary key of the e s f sport type
	* @return the e s f sport type
	* @throws PortalException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType getESFSportType(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportType(esfSportTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f sport type with the matching UUID and company.
	*
	* @param uuid the e s f sport type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f sport type
	* @throws PortalException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType getESFSportTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f sport type matching the UUID and group.
	*
	* @param uuid the e s f sport type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f sport type
	* @throws PortalException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType getESFSportTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f sport types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFSportType> getESFSportTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportTypes(start, end);
	}

	/**
	* Returns the number of e s f sport types.
	*
	* @return the number of e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFSportTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportTypesCount();
	}

	/**
	* Updates the e s f sport type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfSportType the e s f sport type
	* @return the e s f sport type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSportType updateESFSportType(
		it.ethica.esf.model.ESFSportType esfSportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFSportType(esfSportType);
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

	public static java.util.List<it.ethica.esf.model.ESFSportType> getAllESFSportTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllESFSportTypes();
	}

	public static java.util.List<it.ethica.esf.model.ESFSportType> getAllESFSportTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllESFSportTypes(start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFSportType> getESFSportTypes(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportTypes(groupId);
	}

	public static java.util.List<it.ethica.esf.model.ESFSportType> getESFSportTypes(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportTypes(groupId, start, end);
	}

	public static int getESFSportTypesCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportTypesCountByGroupId(groupId);
	}

	public static java.util.List<it.ethica.esf.model.ESFSportType> getESFSportTypesByESFField(
		long esfFieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSportTypesByESFField(esfFieldId);
	}

	public static it.ethica.esf.model.ESFSportType addESFSportType(
		long userId, java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFSportType(userId, name, description, serviceContext);
	}

	public static it.ethica.esf.model.ESFSportType updateESFSportType(
		long userId, long esfSportTypeId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFSportType(userId, esfSportTypeId, name,
			description, serviceContext);
	}

	public static it.ethica.esf.model.ESFSportType deleteESFSportType(
		long esfSportTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFSportType(esfSportTypeId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFSportTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFSportTypeLocalService.class.getName());

			if (invokableLocalService instanceof ESFSportTypeLocalService) {
				_service = (ESFSportTypeLocalService)invokableLocalService;
			}
			else {
				_service = new ESFSportTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFSportTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFSportTypeLocalService service) {
	}

	private static ESFSportTypeLocalService _service;
}