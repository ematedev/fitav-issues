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
 * Provides the local service utility for ESFUserESFFederalRole. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFUserESFFederalRoleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFUserESFFederalRoleLocalService
 * @see it.ethica.esf.service.base.ESFUserESFFederalRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFUserESFFederalRoleLocalServiceImpl
 * @generated
 */
public class ESFUserESFFederalRoleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFUserESFFederalRoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f user e s f federal role to the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFFederalRole the e s f user e s f federal role
	* @return the e s f user e s f federal role that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole addESFUserESFFederalRole(
		it.ethica.esf.model.ESFUserESFFederalRole esfUserESFFederalRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFUserESFFederalRole(esfUserESFFederalRole);
	}

	/**
	* Creates a new e s f user e s f federal role with the primary key. Does not add the e s f user e s f federal role to the database.
	*
	* @param esfUserESFFederalRolePK the primary key for the new e s f user e s f federal role
	* @return the new e s f user e s f federal role
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole createESFUserESFFederalRole(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK) {
		return getService().createESFUserESFFederalRole(esfUserESFFederalRolePK);
	}

	/**
	* Deletes the e s f user e s f federal role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFFederalRolePK the primary key of the e s f user e s f federal role
	* @return the e s f user e s f federal role that was removed
	* @throws PortalException if a e s f user e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole deleteESFUserESFFederalRole(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserESFFederalRole(esfUserESFFederalRolePK);
	}

	/**
	* Deletes the e s f user e s f federal role from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFFederalRole the e s f user e s f federal role
	* @return the e s f user e s f federal role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole deleteESFUserESFFederalRole(
		it.ethica.esf.model.ESFUserESFFederalRole esfUserESFFederalRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserESFFederalRole(esfUserESFFederalRole);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFUserESFFederalRole fetchESFUserESFFederalRole(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFUserESFFederalRole(esfUserESFFederalRolePK);
	}

	/**
	* Returns the e s f user e s f federal role with the primary key.
	*
	* @param esfUserESFFederalRolePK the primary key of the e s f user e s f federal role
	* @return the e s f user e s f federal role
	* @throws PortalException if a e s f user e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole getESFUserESFFederalRole(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFFederalRole(esfUserESFFederalRolePK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f user e s f federal roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @return the range of e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> getESFUserESFFederalRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFFederalRoles(start, end);
	}

	/**
	* Returns the number of e s f user e s f federal roles.
	*
	* @return the number of e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFUserESFFederalRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserESFFederalRolesCount();
	}

	/**
	* Updates the e s f user e s f federal role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFFederalRole the e s f user e s f federal role
	* @return the e s f user e s f federal role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole updateESFUserESFFederalRole(
		it.ethica.esf.model.ESFUserESFFederalRole esfUserESFFederalRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFUserESFFederalRole(esfUserESFFederalRole);
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

	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByEsfFederalRoleId(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEsfFederalRoleId(esfFederalRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByEsfUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEsfUserId(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByEsfUserIdAndActive(
		long esfUserId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEsfUserIdAndActive(esfUserId, active);
	}

	public static it.ethica.esf.model.ESFUserESFFederalRole findByEsfUserIdAndEsfFederalRoleIdActive(
		long esfUserId, long esfFederalRoleId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getService()
				   .findByEsfUserIdAndEsfFederalRoleIdActive(esfUserId,
			esfFederalRoleId, active);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFUserESFFederalRoleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFUserESFFederalRoleLocalService.class.getName());

			if (invokableLocalService instanceof ESFUserESFFederalRoleLocalService) {
				_service = (ESFUserESFFederalRoleLocalService)invokableLocalService;
			}
			else {
				_service = new ESFUserESFFederalRoleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFUserESFFederalRoleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFUserESFFederalRoleLocalService service) {
	}

	private static ESFUserESFFederalRoleLocalService _service;
}