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
 * Provides the local service utility for ESFGunKind. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFGunKindLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFGunKindLocalService
 * @see it.ethica.esf.service.base.ESFGunKindLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFGunKindLocalServiceImpl
 * @generated
 */
public class ESFGunKindLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFGunKindLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f gun kind to the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunKind the e s f gun kind
	* @return the e s f gun kind that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind addESFGunKind(
		it.ethica.esf.model.ESFGunKind esfGunKind)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFGunKind(esfGunKind);
	}

	/**
	* Creates a new e s f gun kind with the primary key. Does not add the e s f gun kind to the database.
	*
	* @param esfGunKindId the primary key for the new e s f gun kind
	* @return the new e s f gun kind
	*/
	public static it.ethica.esf.model.ESFGunKind createESFGunKind(
		long esfGunKindId) {
		return getService().createESFGunKind(esfGunKindId);
	}

	/**
	* Deletes the e s f gun kind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunKindId the primary key of the e s f gun kind
	* @return the e s f gun kind that was removed
	* @throws PortalException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind deleteESFGunKind(
		long esfGunKindId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFGunKind(esfGunKindId);
	}

	/**
	* Deletes the e s f gun kind from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunKind the e s f gun kind
	* @return the e s f gun kind that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind deleteESFGunKind(
		it.ethica.esf.model.ESFGunKind esfGunKind)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFGunKind(esfGunKind);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFGunKind fetchESFGunKind(
		long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFGunKind(esfGunKindId);
	}

	/**
	* Returns the e s f gun kind with the matching UUID and company.
	*
	* @param uuid the e s f gun kind's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind fetchESFGunKindByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFGunKindByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f gun kind matching the UUID and group.
	*
	* @param uuid the e s f gun kind's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind fetchESFGunKindByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFGunKindByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f gun kind with the primary key.
	*
	* @param esfGunKindId the primary key of the e s f gun kind
	* @return the e s f gun kind
	* @throws PortalException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind getESFGunKind(
		long esfGunKindId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKind(esfGunKindId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f gun kind with the matching UUID and company.
	*
	* @param uuid the e s f gun kind's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun kind
	* @throws PortalException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind getESFGunKindByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKindByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f gun kind matching the UUID and group.
	*
	* @param uuid the e s f gun kind's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun kind
	* @throws PortalException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind getESFGunKindByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKindByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f gun kinds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @return the range of e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKinds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKinds(start, end);
	}

	/**
	* Returns the number of e s f gun kinds.
	*
	* @return the number of e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFGunKindsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKindsCount();
	}

	/**
	* Updates the e s f gun kind in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfGunKind the e s f gun kind
	* @return the e s f gun kind that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGunKind updateESFGunKind(
		it.ethica.esf.model.ESFGunKind esfGunKind)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFGunKind(esfGunKind);
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

	public static java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKindsByLikeN_D_M(
		java.lang.String name, java.lang.String description,
		java.lang.String model, long esfGunTypeId) {
		return getService()
				   .getESFGunKindsByLikeN_D_M(name, description, model,
			esfGunTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKindsByLikeN_D_M(
		java.lang.String name, java.lang.String description,
		java.lang.String model, long esfGunTypeId, int start, int end) {
		return getService()
				   .getESFGunKindsByLikeN_D_M(name, description, model,
			esfGunTypeId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKinds()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKinds();
	}

	public static java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKindsByESFGunType(
		long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKindsByESFGunType(esfGunTypeId);
	}

	public static it.ethica.esf.model.ESFGunKind getESFGunKindsById(
		long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKindsById(esfGunKindId);
	}

	public static java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKindsByESFGunType(
		long esfGunTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKindsByESFGunType(esfGunTypeId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFGunKind> getESFRifle(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunTypeException {
		return getService().getESFRifle(start, end);
	}

	public static int countESFRifle()
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunTypeException {
		return getService().countESFRifle();
	}

	public static int getESFGunKindCountByESFGunType(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunKindCountByESFGunType(esfGunTypeId);
	}

	public static it.ethica.esf.model.ESFGunKind addESFGunKind(long userId,
		java.lang.String name, java.lang.String description, long esfGunTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFGunKind(userId, name, description, esfGunTypeId,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFGunKind updateESFGunKind(long userId,
		long esfGunKindId, java.lang.String name, java.lang.String description,
		long esfGunTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFGunKind(userId, esfGunKindId, name, description,
			esfGunTypeId, serviceContext);
	}

	public static it.ethica.esf.model.ESFGunKind deleteESFGunKind(
		long esfGunKindId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFGunKind(esfGunKindId, serviceContext);
	}

	public static it.ethica.esf.model.ESFGunKind checkNome(
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().checkNome(name, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFGunKindLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFGunKindLocalService.class.getName());

			if (invokableLocalService instanceof ESFGunKindLocalService) {
				_service = (ESFGunKindLocalService)invokableLocalService;
			}
			else {
				_service = new ESFGunKindLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFGunKindLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFGunKindLocalService service) {
	}

	private static ESFGunKindLocalService _service;
}