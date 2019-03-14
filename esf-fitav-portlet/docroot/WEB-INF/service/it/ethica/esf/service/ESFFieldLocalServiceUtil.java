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
 * Provides the local service utility for ESFField. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFFieldLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFFieldLocalService
 * @see it.ethica.esf.service.base.ESFFieldLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFFieldLocalServiceImpl
 * @generated
 */
public class ESFFieldLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFFieldLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f field to the database. Also notifies the appropriate model listeners.
	*
	* @param esfField the e s f field
	* @return the e s f field that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField addESFField(
		it.ethica.esf.model.ESFField esfField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFField(esfField);
	}

	/**
	* Creates a new e s f field with the primary key. Does not add the e s f field to the database.
	*
	* @param esfFieldId the primary key for the new e s f field
	* @return the new e s f field
	*/
	public static it.ethica.esf.model.ESFField createESFField(long esfFieldId) {
		return getService().createESFField(esfFieldId);
	}

	/**
	* Deletes the e s f field with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFieldId the primary key of the e s f field
	* @return the e s f field that was removed
	* @throws PortalException if a e s f field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField deleteESFField(long esfFieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFField(esfFieldId);
	}

	/**
	* Deletes the e s f field from the database. Also notifies the appropriate model listeners.
	*
	* @param esfField the e s f field
	* @return the e s f field that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField deleteESFField(
		it.ethica.esf.model.ESFField esfField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFField(esfField);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFField fetchESFField(long esfFieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFField(esfFieldId);
	}

	/**
	* Returns the e s f field with the matching UUID and company.
	*
	* @param uuid the e s f field's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f field, or <code>null</code> if a matching e s f field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField fetchESFFieldByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFFieldByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f field matching the UUID and group.
	*
	* @param uuid the e s f field's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f field, or <code>null</code> if a matching e s f field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField fetchESFFieldByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFFieldByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f field with the primary key.
	*
	* @param esfFieldId the primary key of the e s f field
	* @return the e s f field
	* @throws PortalException if a e s f field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField getESFField(long esfFieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFField(esfFieldId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f field with the matching UUID and company.
	*
	* @param uuid the e s f field's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f field
	* @throws PortalException if a matching e s f field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField getESFFieldByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFieldByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f field matching the UUID and group.
	*
	* @param uuid the e s f field's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f field
	* @throws PortalException if a matching e s f field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField getESFFieldByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFieldByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f fields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f fields
	* @param end the upper bound of the range of e s f fields (not inclusive)
	* @return the range of e s f fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFField> getESFFields(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFields(start, end);
	}

	/**
	* Returns the number of e s f fields.
	*
	* @return the number of e s f fields
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFFieldsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFieldsCount();
	}

	/**
	* Updates the e s f field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfField the e s f field
	* @return the e s f field that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFField updateESFField(
		it.ethica.esf.model.ESFField esfField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFField(esfField);
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

	public static java.util.List<it.ethica.esf.model.ESFField> getESFFields(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFields(groupId);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> getESFFields(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFields(groupId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> getEsfFieldByState(
		int state) {
		return getService().getEsfFieldByState(state);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> getEsfFieldByState(
		int state, int start, int end) {
		return getService().getEsfFieldByState(state, start, end);
	}

	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupId(groupId);
	}

	public static int countByESFOrganization(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByESFOrganization(esfOrganizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> findByRealOwner(
		long esfStateId, long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRealOwner(esfStateId, esfOrganizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> findByRealOwner(
		long esfStateId, long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByRealOwner(esfStateId, esfOrganizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> findByESFOrganization(
		long esfOrganizationId, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFOrganization(esfOrganizationId, state);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> findByESFOrganization(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFOrganization(esfOrganizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> findByESFOrganization(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFOrganization(esfOrganizationId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> findByESFOrganization(
		long esfOrganizationId, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByESFOrganization(esfOrganizationId, state, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findESFFieldESFSportTypeByField(
		long esfFieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFFieldESFSportTypeByField(esfFieldId);
	}

	public static java.util.List<it.ethica.esf.model.ESFField> findByESFSportTypeId(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByESFSportTypeId(esfSportTypeId);
	}

	public static it.ethica.esf.model.ESFField addESFField(long userId,
		java.lang.String name, long ownerOrganizationId, long esfAddressIdId,
		long esfStateId, long[] esfSportTypeIds, java.lang.String note,
		long billboard, boolean billboardStations, boolean backgroundRampart,
		boolean backgroundNet, boolean backgroundLeadRecovery,
		boolean disabledaccess,
		java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> esfFieldESFElectronics,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFField(userId, name, ownerOrganizationId,
			esfAddressIdId, esfStateId, esfSportTypeIds, note, billboard,
			billboardStations, backgroundRampart, backgroundNet,
			backgroundLeadRecovery, disabledaccess, esfFieldESFElectronics,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFField addESFField(long userId,
		java.lang.String name, long ownerOrganizationId, long esfAddressIdId,
		long[] esfSportTypeIds,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.lang.String note, long billboard, boolean billboardStations,
		boolean backgroundRampart, boolean backgroundNet,
		boolean backgroundLeadRecovery, boolean disabledaccess,
		java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> esfFieldESFElectronics,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFField(userId, name, ownerOrganizationId,
			esfAddressIdId, esfSportTypeIds, esfEntityState, note, billboard,
			billboardStations, backgroundRampart, backgroundNet,
			backgroundLeadRecovery, disabledaccess, esfFieldESFElectronics,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFField updateESFField(long userId,
		long esfFieldId, java.lang.String name, long ownerOrganizationId,
		long esfAddressId, long[] esfSportTypeIds,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.lang.String note, long billboard, boolean billboardStations,
		boolean backgroundRampart, boolean backgroundNet,
		boolean backgroundLeadRecovery, boolean disabledaccess,
		java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> esfFieldESFElectronics,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFField(userId, esfFieldId, name,
			ownerOrganizationId, esfAddressId, esfSportTypeIds, esfEntityState,
			note, billboard, billboardStations, backgroundRampart,
			backgroundNet, backgroundLeadRecovery, disabledaccess,
			esfFieldESFElectronics, serviceContext);
	}

	public static it.ethica.esf.model.ESFField deleteESFField(long esfFieldId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFField(esfFieldId, serviceContext);
	}

	public static it.ethica.esf.model.ESFField giveWayESFField(
		long esfFieldId, long actualOwnerId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .giveWayESFField(esfFieldId, actualOwnerId, serviceContext);
	}

	public static it.ethica.esf.model.ESFField returnESFField(long esfFieldId,
		long actualOwnerId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .returnESFField(esfFieldId, actualOwnerId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFFieldLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFFieldLocalService.class.getName());

			if (invokableLocalService instanceof ESFFieldLocalService) {
				_service = (ESFFieldLocalService)invokableLocalService;
			}
			else {
				_service = new ESFFieldLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFFieldLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFFieldLocalService service) {
	}

	private static ESFFieldLocalService _service;
}