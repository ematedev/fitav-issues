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
 * Provides the local service utility for ESFOrganizationType. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFOrganizationTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFOrganizationTypeLocalService
 * @see it.ethica.esf.service.base.ESFOrganizationTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFOrganizationTypeLocalServiceImpl
 * @generated
 */
public class ESFOrganizationTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFOrganizationTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f organization type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationType the e s f organization type
	* @return the e s f organization type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType addESFOrganizationType(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFOrganizationType(esfOrganizationType);
	}

	/**
	* Creates a new e s f organization type with the primary key. Does not add the e s f organization type to the database.
	*
	* @param esfOrganizationTypeId the primary key for the new e s f organization type
	* @return the new e s f organization type
	*/
	public static it.ethica.esf.model.ESFOrganizationType createESFOrganizationType(
		long esfOrganizationTypeId) {
		return getService().createESFOrganizationType(esfOrganizationTypeId);
	}

	/**
	* Deletes the e s f organization type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type that was removed
	* @throws PortalException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType deleteESFOrganizationType(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFOrganizationType(esfOrganizationTypeId);
	}

	/**
	* Deletes the e s f organization type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationType the e s f organization type
	* @return the e s f organization type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType deleteESFOrganizationType(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFOrganizationType(esfOrganizationType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFOrganizationType fetchESFOrganizationType(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFOrganizationType(esfOrganizationTypeId);
	}

	/**
	* Returns the e s f organization type with the primary key.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type
	* @throws PortalException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType getESFOrganizationType(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganizationType(esfOrganizationTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f organization types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization types
	* @param end the upper bound of the range of e s f organization types (not inclusive)
	* @return the range of e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> getESFOrganizationTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganizationTypes(start, end);
	}

	/**
	* Returns the number of e s f organization types.
	*
	* @return the number of e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFOrganizationTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganizationTypesCount();
	}

	/**
	* Updates the e s f organization type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationType the e s f organization type
	* @return the e s f organization type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType updateESFOrganizationType(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFOrganizationType(esfOrganizationType);
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

	public static java.util.List<java.lang.String> getOrganizationTypes(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizationTypes(esfOrganizationId);
	}

	public static it.ethica.esf.model.ESFOrganizationType addESFOrganizationType(
		long userId, long esfTypeId, long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFOrganizationType(userId, esfTypeId,
			esfOrganizationId, serviceContext);
	}

	public static it.ethica.esf.model.ESFOrganizationType deleteESFOrganizationType(
		long esfOrganizationTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFOrganizationType(esfOrganizationTypeId,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFOrganizationType updateESFOrganizationType(
		long userId, long esfOrganizationTypeId, long esfTypeId,
		long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFOrganizationType(userId, esfOrganizationTypeId,
			esfTypeId, esfOrganizationId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFOrganizationTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFOrganizationTypeLocalService.class.getName());

			if (invokableLocalService instanceof ESFOrganizationTypeLocalService) {
				_service = (ESFOrganizationTypeLocalService)invokableLocalService;
			}
			else {
				_service = new ESFOrganizationTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFOrganizationTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFOrganizationTypeLocalService service) {
	}

	private static ESFOrganizationTypeLocalService _service;
}