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
 * Provides the local service utility for ESFFederalRole. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFFederalRoleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFFederalRoleLocalService
 * @see it.ethica.esf.service.base.ESFFederalRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFFederalRoleLocalServiceImpl
 * @generated
 */
public class ESFFederalRoleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFFederalRoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f federal role to the database. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRole the e s f federal role
	* @return the e s f federal role that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole addESFFederalRole(
		it.ethica.esf.model.ESFFederalRole esfFederalRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFFederalRole(esfFederalRole);
	}

	/**
	* Creates a new e s f federal role with the primary key. Does not add the e s f federal role to the database.
	*
	* @param esfFederalRoleId the primary key for the new e s f federal role
	* @return the new e s f federal role
	*/
	public static it.ethica.esf.model.ESFFederalRole createESFFederalRole(
		long esfFederalRoleId) {
		return getService().createESFFederalRole(esfFederalRoleId);
	}

	/**
	* Deletes the e s f federal role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRoleId the primary key of the e s f federal role
	* @return the e s f federal role that was removed
	* @throws PortalException if a e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole deleteESFFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFFederalRole(esfFederalRoleId);
	}

	/**
	* Deletes the e s f federal role from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRole the e s f federal role
	* @return the e s f federal role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole deleteESFFederalRole(
		it.ethica.esf.model.ESFFederalRole esfFederalRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFFederalRole(esfFederalRole);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFFederalRole fetchESFFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFFederalRole(esfFederalRoleId);
	}

	/**
	* Returns the e s f federal role with the matching UUID and company.
	*
	* @param uuid the e s f federal role's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole fetchESFFederalRoleByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchESFFederalRoleByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f federal role matching the UUID and group.
	*
	* @param uuid the e s f federal role's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole fetchESFFederalRoleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFFederalRoleByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f federal role with the primary key.
	*
	* @param esfFederalRoleId the primary key of the e s f federal role
	* @return the e s f federal role
	* @throws PortalException if a e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole getESFFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFederalRole(esfFederalRoleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f federal role with the matching UUID and company.
	*
	* @param uuid the e s f federal role's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f federal role
	* @throws PortalException if a matching e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole getESFFederalRoleByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFederalRoleByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f federal role matching the UUID and group.
	*
	* @param uuid the e s f federal role's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f federal role
	* @throws PortalException if a matching e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole getESFFederalRoleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFederalRoleByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f federal roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f federal roles
	* @param end the upper bound of the range of e s f federal roles (not inclusive)
	* @return the range of e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFederalRole> getESFFederalRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFederalRoles(start, end);
	}

	/**
	* Returns the number of e s f federal roles.
	*
	* @return the number of e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFFederalRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFederalRolesCount();
	}

	/**
	* Updates the e s f federal role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRole the e s f federal role
	* @return the e s f federal role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFederalRole updateESFFederalRole(
		it.ethica.esf.model.ESFFederalRole esfFederalRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFFederalRole(esfFederalRole);
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

	public static java.util.List<it.ethica.esf.model.ESFFederalRole> findByESFUser(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFUser(userId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findByESFFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFFederalRole(esfFederalRoleId);
	}

	public static it.ethica.esf.model.ESFFederalRole updateEsfFederalRole(
		long esfFederalRoleId, java.lang.String code,
		java.lang.String description, boolean regional, boolean provincial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEsfFederalRole(esfFederalRoleId, code, description,
			regional, provincial);
	}

	public static java.util.List<it.ethica.esf.model.ESFFederalRole> findByCode(
		java.lang.String code) {
		return getService().findByCode(code);
	}

	public static void associateEsfUser(long esfUserId, long esfFederalRoleId,
		long startDate, java.util.Date endDate, long esfSpecificId,
		java.lang.String notes)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.associateEsfUser(esfUserId, esfFederalRoleId, startDate, endDate,
			esfSpecificId, notes);
	}

	public static void deAssociateEsfUser(long esfUserId, long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deAssociateEsfUser(esfUserId, esfFederalRoleId);
	}

	public static it.ethica.esf.model.ESFUserESFFederalRole getAssociation(
		long esfUserId, long esfFederalRoleId, long startDate) {
		return getService()
				   .getAssociation(esfUserId, esfFederalRoleId, startDate);
	}

	public static java.util.Date getActiveAssociationDate(long esfUserId,
		long esfFederalRoleId) {
		return getService().getActiveAssociationDate(esfUserId, esfFederalRoleId);
	}

	public static java.util.Date getEndAssociationDate(long esfUserId,
		long esfFederalRoleId) {
		return getService().getEndAssociationDate(esfUserId, esfFederalRoleId);
	}

	public static void deleteEsfUserEsfFederalRole(long esfUserId,
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEsfUserEsfFederalRole(esfUserId, esfFederalRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> getAssociationsByEsfUser(
		long esfUserId) {
		return getService().getAssociationsByEsfUser(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> getAssociationsByEsfUserActive(
		long esfUserId, boolean active) {
		return getService().getAssociationsByEsfUserActive(esfUserId, active);
	}

	public static boolean isAssociated(long esfUserId, long esfFederalRoleId) {
		return getService().isAssociated(esfUserId, esfFederalRoleId);
	}

	public static void cleanEsfUserAssociation(long esfUserId) {
		getService().cleanEsfUserAssociation(esfUserId);
	}

	public static void cleanEsfFederalRoleAssociation(long esfFederalRoleId) {
		getService().cleanEsfFederalRoleAssociation(esfFederalRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFSpecific> getFederalRoleSpecifics(
		long esfFederalRoleId) {
		return getService().getFederalRoleSpecifics(esfFederalRoleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFFederalRoleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFFederalRoleLocalService.class.getName());

			if (invokableLocalService instanceof ESFFederalRoleLocalService) {
				_service = (ESFFederalRoleLocalService)invokableLocalService;
			}
			else {
				_service = new ESFFederalRoleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFFederalRoleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFFederalRoleLocalService service) {
	}

	private static ESFFederalRoleLocalService _service;
}