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
 * Provides the local service utility for ESFOrganizationUnitservice. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFOrganizationUnitserviceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFOrganizationUnitserviceLocalService
 * @see it.ethica.esf.service.base.ESFOrganizationUnitserviceLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFOrganizationUnitserviceLocalServiceImpl
 * @generated
 */
public class ESFOrganizationUnitserviceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFOrganizationUnitserviceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f organization unitservice to the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationUnitservice the e s f organization unitservice
	* @return the e s f organization unitservice that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice addESFOrganizationUnitservice(
		it.ethica.esf.model.ESFOrganizationUnitservice esfOrganizationUnitservice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFOrganizationUnitservice(esfOrganizationUnitservice);
	}

	/**
	* Creates a new e s f organization unitservice with the primary key. Does not add the e s f organization unitservice to the database.
	*
	* @param esfOrganizationUnitserviceId the primary key for the new e s f organization unitservice
	* @return the new e s f organization unitservice
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice createESFOrganizationUnitservice(
		long esfOrganizationUnitserviceId) {
		return getService()
				   .createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
	}

	/**
	* Deletes the e s f organization unitservice with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationUnitserviceId the primary key of the e s f organization unitservice
	* @return the e s f organization unitservice that was removed
	* @throws PortalException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice deleteESFOrganizationUnitservice(
		long esfOrganizationUnitserviceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFOrganizationUnitservice(esfOrganizationUnitserviceId);
	}

	/**
	* Deletes the e s f organization unitservice from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationUnitservice the e s f organization unitservice
	* @return the e s f organization unitservice that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice deleteESFOrganizationUnitservice(
		it.ethica.esf.model.ESFOrganizationUnitservice esfOrganizationUnitservice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFOrganizationUnitservice(esfOrganizationUnitservice);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFOrganizationUnitservice fetchESFOrganizationUnitservice(
		long esfOrganizationUnitserviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchESFOrganizationUnitservice(esfOrganizationUnitserviceId);
	}

	/**
	* Returns the e s f organization unitservice with the matching UUID and company.
	*
	* @param uuid the e s f organization unitservice's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice fetchESFOrganizationUnitserviceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchESFOrganizationUnitserviceByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f organization unitservice matching the UUID and group.
	*
	* @param uuid the e s f organization unitservice's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice fetchESFOrganizationUnitserviceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchESFOrganizationUnitserviceByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f organization unitservice with the primary key.
	*
	* @param esfOrganizationUnitserviceId the primary key of the e s f organization unitservice
	* @return the e s f organization unitservice
	* @throws PortalException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice getESFOrganizationUnitservice(
		long esfOrganizationUnitserviceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFOrganizationUnitservice(esfOrganizationUnitserviceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f organization unitservice with the matching UUID and company.
	*
	* @param uuid the e s f organization unitservice's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f organization unitservice
	* @throws PortalException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice getESFOrganizationUnitserviceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFOrganizationUnitserviceByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f organization unitservice matching the UUID and group.
	*
	* @param uuid the e s f organization unitservice's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f organization unitservice
	* @throws PortalException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice getESFOrganizationUnitserviceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFOrganizationUnitserviceByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f organization unitservices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @return the range of e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> getESFOrganizationUnitservices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganizationUnitservices(start, end);
	}

	/**
	* Returns the number of e s f organization unitservices.
	*
	* @return the number of e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFOrganizationUnitservicesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganizationUnitservicesCount();
	}

	/**
	* Updates the e s f organization unitservice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationUnitservice the e s f organization unitservice
	* @return the e s f organization unitservice that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationUnitservice updateESFOrganizationUnitservice(
		it.ethica.esf.model.ESFOrganizationUnitservice esfOrganizationUnitservice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFOrganizationUnitservice(esfOrganizationUnitservice);
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

	public static java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> getAllESFOrganizationUnitservices()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllESFOrganizationUnitservices();
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> getAllESFOrganizationUnitservices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllESFOrganizationUnitservices(start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> getAllESFOrganizationUnitservices(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllESFOrganizationUnitservices(groupId);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> getAllESFOrganizationUnitservices(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAllESFOrganizationUnitservices(groupId, start, end);
	}

	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupId(groupId);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByESFOrganizationId(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByESFOrganizationId(esfOrganizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByESFOrganizationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFOrganizationId(esfOrganizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByESFUnitserviceId(
		long esfUnitserviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFUnitserviceId(esfUnitserviceId);
	}

	public static it.ethica.esf.model.ESFOrganizationUnitservice addESFOrganizationUnitservice(
		long userId, long esfOrganizationId, long esfUnitserviceId,
		long numberUnitservices, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFOrganizationUnitservice(userId, esfOrganizationId,
			esfUnitserviceId, numberUnitservices, description, serviceContext);
	}

	public static it.ethica.esf.model.ESFOrganizationUnitservice updateESFOrganizationUnitservice(
		long userId, long esfOrganizationUnitserviceId, long esfOrganizationId,
		long esfUnitserviceId, long numberUnitservices,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFOrganizationUnitservice(userId,
			esfOrganizationUnitserviceId, esfOrganizationId, esfUnitserviceId,
			numberUnitservices, description, serviceContext);
	}

	public static it.ethica.esf.model.ESFOrganizationUnitservice deleteESFOrganizationUnitservice(
		long esfOrganizationUnitserviceId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFOrganizationUnitservice(esfOrganizationUnitserviceId,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFOrganizationUnitserviceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFOrganizationUnitserviceLocalService.class.getName());

			if (invokableLocalService instanceof ESFOrganizationUnitserviceLocalService) {
				_service = (ESFOrganizationUnitserviceLocalService)invokableLocalService;
			}
			else {
				_service = new ESFOrganizationUnitserviceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFOrganizationUnitserviceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFOrganizationUnitserviceLocalService service) {
	}

	private static ESFOrganizationUnitserviceLocalService _service;
}