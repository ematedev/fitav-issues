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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFSpecific. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFSpecificLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFSpecificLocalService
 * @see it.ethica.esf.service.base.ESFSpecificLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFSpecificLocalServiceImpl
 * @generated
 */
public class ESFSpecificLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFSpecificLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f specific to the database. Also notifies the appropriate model listeners.
	*
	* @param esfSpecific the e s f specific
	* @return the e s f specific that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific addESFSpecific(
		it.ethica.esf.model.ESFSpecific esfSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFSpecific(esfSpecific);
	}

	/**
	* Creates a new e s f specific with the primary key. Does not add the e s f specific to the database.
	*
	* @param esfSpecificId the primary key for the new e s f specific
	* @return the new e s f specific
	*/
	public static it.ethica.esf.model.ESFSpecific createESFSpecific(
		long esfSpecificId) {
		return getService().createESFSpecific(esfSpecificId);
	}

	/**
	* Deletes the e s f specific with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSpecificId the primary key of the e s f specific
	* @return the e s f specific that was removed
	* @throws PortalException if a e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific deleteESFSpecific(
		long esfSpecificId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFSpecific(esfSpecificId);
	}

	/**
	* Deletes the e s f specific from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSpecific the e s f specific
	* @return the e s f specific that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific deleteESFSpecific(
		it.ethica.esf.model.ESFSpecific esfSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFSpecific(esfSpecific);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFSpecific fetchESFSpecific(
		long esfSpecificId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFSpecific(esfSpecificId);
	}

	/**
	* Returns the e s f specific with the matching UUID and company.
	*
	* @param uuid the e s f specific's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific fetchESFSpecificByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFSpecificByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f specific matching the UUID and group.
	*
	* @param uuid the e s f specific's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific fetchESFSpecificByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFSpecificByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f specific with the primary key.
	*
	* @param esfSpecificId the primary key of the e s f specific
	* @return the e s f specific
	* @throws PortalException if a e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific getESFSpecific(
		long esfSpecificId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSpecific(esfSpecificId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f specific with the matching UUID and company.
	*
	* @param uuid the e s f specific's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f specific
	* @throws PortalException if a matching e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific getESFSpecificByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSpecificByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f specific matching the UUID and group.
	*
	* @param uuid the e s f specific's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f specific
	* @throws PortalException if a matching e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific getESFSpecificByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSpecificByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f specifics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f specifics
	* @param end the upper bound of the range of e s f specifics (not inclusive)
	* @return the range of e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFSpecific> getESFSpecifics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSpecifics(start, end);
	}

	/**
	* Returns the number of e s f specifics.
	*
	* @return the number of e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFSpecificsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFSpecificsCount();
	}

	/**
	* Updates the e s f specific in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfSpecific the e s f specific
	* @return the e s f specific that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSpecific updateESFSpecific(
		it.ethica.esf.model.ESFSpecific esfSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFSpecific(esfSpecific);
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

	public static void clearService() {
		_service = null;
	}

	public static ESFSpecificLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFSpecificLocalService.class.getName());

			if (invokableLocalService instanceof ESFSpecificLocalService) {
				_service = (ESFSpecificLocalService)invokableLocalService;
			}
			else {
				_service = new ESFSpecificLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFSpecificLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFSpecificLocalService service) {
	}

	private static ESFSpecificLocalService _service;
}