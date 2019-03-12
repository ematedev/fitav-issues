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
 * Provides the local service utility for ESFUserESFUserRole. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFUserESFUserRoleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFUserESFUserRoleLocalService
 * @see it.ethica.esf.service.base.ESFUserESFUserRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFUserESFUserRoleLocalServiceImpl
 * @generated
 */
public class ESFUserESFUserRoleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFUserESFUserRoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f user e s f user role to the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFUserRole the e s f user e s f user role
	* @return the e s f user e s f user role that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole addESFUserESFUserRole(
		it.ethica.esf.model.ESFUserESFUserRole esfUserESFUserRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFUserESFUserRole(esfUserESFUserRole);
	}

	/**
	* Creates a new e s f user e s f user role with the primary key. Does not add the e s f user e s f user role to the database.
	*
	* @param esfUserESFUserRolePK the primary key for the new e s f user e s f user role
	* @return the new e s f user e s f user role
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole createESFUserESFUserRole(
		it.ethica.esf.service.persistence.ESFUserESFUserRolePK esfUserESFUserRolePK) {
		return getService().createESFUserESFUserRole(esfUserESFUserRolePK);
	}

	/**
	* Deletes the e s f user e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	* @return the e s f user e s f user role that was removed
	* @throws PortalException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole deleteESFUserESFUserRole(
		it.ethica.esf.service.persistence.ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserESFUserRole(esfUserESFUserRolePK);
	}

	/**
	* Deletes the e s f user e s f user role from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFUserRole the e s f user e s f user role
	* @return the e s f user e s f user role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole deleteESFUserESFUserRole(
		it.ethica.esf.model.ESFUserESFUserRole esfUserESFUserRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserESFUserRole(esfUserESFUserRole);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFUserESFUserRole fetchESFUserESFUserRole(
		it.ethica.esf.service.persistence.ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFUserESFUserRole(esfUserESFUserRolePK);
	}

	/**
	* Returns the e s f user e s f user role with the primary key.
	*
	* @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	* @return the e s f user e s f user role
	* @throws PortalException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole getESFUserESFUserRole(
		it.ethica.esf.service.persistence.ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRole(esfUserESFUserRolePK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f user e s f user roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRoles(start, end);
	}

	/**
	* Returns the number of e s f user e s f user roles.
	*
	* @return the number of e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFUserESFUserRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRolesCount();
	}

	/**
	* Updates the e s f user e s f user role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFUserRole the e s f user e s f user role
	* @return the e s f user e s f user role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole updateESFUserESFUserRole(
		it.ethica.esf.model.ESFUserESFUserRole esfUserESFUserRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFUserESFUserRole(esfUserESFUserRole);
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

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findESFUserESFRolesByEsfUserRoleId(
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService().findESFUserESFRolesByEsfUserRoleId(esfUserRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findESFUserESFRolesByEsfOrganizzationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findESFUserESFRolesByEsfOrganizzationId(esfOrganizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findESFUserESFRolesAll()
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService().findESFUserESFRolesAll();
	}

	public static it.ethica.esf.model.ESFUserESFUserRole findESFUserESFRoleByPrimaryKey(
		long esfUserId, long esfUserRoleId, long esfOrganizationId,
		java.util.Date startDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findESFUserESFRoleByPrimaryKey(esfUserId, esfUserRoleId,
			esfOrganizationId, startDate);
	}

	public static it.ethica.esf.model.ESFUserESFUserRole findESFUserESFRoleByU_R_O(
		long esfUserId, long esfUserRoleId, long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findESFUserESFRoleByU_R_O(esfUserId, esfUserRoleId,
			esfOrganizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findESFUserESFRoleByO_R(
		long esfOrganizationId, long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService()
				   .findESFUserESFRoleByO_R(esfOrganizationId, esfUserRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getAllESFUserESFUserRoleByESFUserId(
		long esfUserId, int start, int end) {
		return getService()
				   .getAllESFUserESFUserRoleByESFUserId(esfUserId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleByESFUserId_ED(
		long esfUserId) {
		return getService().getESFUserESFUserRoleByESFUserId_ED(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRoleByOrganizationId(organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFUserESFUserRoleByOrganizationId(organizationId,
			start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleAllStaff(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRoleAllStaff(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleAllStaff(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRoleAllStaff(esfMatchId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleAllNationalStaff(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFUserESFUserRoleAllNationalStaff(esfMatchId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleAllNationalStaff(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRoleAllNationalStaff(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleStaff(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRoleStaff(esfMatchId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserESFUserRoleStaff(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFUserRoleStaff(esfMatchId);
	}

	public static int getAllESFUserESFUserRoleCountByESFUserId(long esfUserId) {
		return getService().getAllESFUserESFUserRoleCountByESFUserId(esfUserId);
	}

	public static it.ethica.esf.model.ESFUserESFUserRole addESFUserESFRole(
		long esfUserId, long esfUserRoleId, long esfOrganizationId,
		java.util.Date startDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFUserESFRole(esfUserId, esfUserRoleId,
			esfOrganizationId, startDate);
	}

	public static it.ethica.esf.model.ESFUserESFUserRole addESFUserESFRoleMigr(
		long esfUserId, long esfUserRoleId, long esfOrganizationId,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFUserESFRoleMigr(esfUserId, esfUserRoleId,
			esfOrganizationId, startDate, endDate);
	}

	public static it.ethica.esf.model.ESFUserESFUserRole updateESFUserESFRole(
		long esfUserId, long esfUserRoleId, long esfOrganizationId,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFUserESFRole(esfUserId, esfUserRoleId,
			esfOrganizationId, endDate, serviceContext);
	}

	/**
	* Trova tutti gli ESFUserRole sulla base dei seguenti parametri: -
	* esfUserRoleId, - WHERE CONDITION (endDate IS Null)
	*
	* @param esfUserRoleId
	* @return
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUSerRoleByR_ED(
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUSerRoleByR_ED(esfUserRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findbyBDOUserRolenoEnd(
		long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService().findbyBDOUserRolenoEnd(roleId, organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findbyBDORole(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getService().findbyBDORole(organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findStaffRole(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findStaffRole(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFUserESFUserRoleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFUserESFUserRoleLocalService.class.getName());

			if (invokableLocalService instanceof ESFUserESFUserRoleLocalService) {
				_service = (ESFUserESFUserRoleLocalService)invokableLocalService;
			}
			else {
				_service = new ESFUserESFUserRoleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFUserESFUserRoleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFUserESFUserRoleLocalService service) {
	}

	private static ESFUserESFUserRoleLocalService _service;
}