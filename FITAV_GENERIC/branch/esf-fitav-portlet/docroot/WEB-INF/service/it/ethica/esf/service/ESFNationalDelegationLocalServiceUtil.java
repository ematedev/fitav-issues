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
 * Provides the local service utility for ESFNationalDelegation. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFNationalDelegationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFNationalDelegationLocalService
 * @see it.ethica.esf.service.base.ESFNationalDelegationLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFNationalDelegationLocalServiceImpl
 * @generated
 */
public class ESFNationalDelegationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFNationalDelegationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f national delegation to the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalDelegation the e s f national delegation
	* @return the e s f national delegation that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation addESFNationalDelegation(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFNationalDelegation(esfNationalDelegation);
	}

	/**
	* Creates a new e s f national delegation with the primary key. Does not add the e s f national delegation to the database.
	*
	* @param esfNationalDelgationId the primary key for the new e s f national delegation
	* @return the new e s f national delegation
	*/
	public static it.ethica.esf.model.ESFNationalDelegation createESFNationalDelegation(
		long esfNationalDelgationId) {
		return getService().createESFNationalDelegation(esfNationalDelgationId);
	}

	/**
	* Deletes the e s f national delegation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalDelgationId the primary key of the e s f national delegation
	* @return the e s f national delegation that was removed
	* @throws PortalException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation deleteESFNationalDelegation(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFNationalDelegation(esfNationalDelgationId);
	}

	/**
	* Deletes the e s f national delegation from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalDelegation the e s f national delegation
	* @return the e s f national delegation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation deleteESFNationalDelegation(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFNationalDelegation(esfNationalDelegation);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFNationalDelegation fetchESFNationalDelegation(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFNationalDelegation(esfNationalDelgationId);
	}

	/**
	* Returns the e s f national delegation with the primary key.
	*
	* @param esfNationalDelgationId the primary key of the e s f national delegation
	* @return the e s f national delegation
	* @throws PortalException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation getESFNationalDelegation(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFNationalDelegation(esfNationalDelgationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f national delegations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> getESFNationalDelegations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFNationalDelegations(start, end);
	}

	/**
	* Returns the number of e s f national delegations.
	*
	* @return the number of e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFNationalDelegationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFNationalDelegationsCount();
	}

	/**
	* Updates the e s f national delegation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfNationalDelegation the e s f national delegation
	* @return the e s f national delegation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation updateESFNationalDelegation(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFNationalDelegation(esfNationalDelegation);
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

	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> getESFNationalDelegationByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFNationalDelegationByMatchId_PartecipantTypeId(esfMatchId,
			esfPartecipantTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> getESFNationalDelegationByMatchId_PartecipantTypeId_sportTypeId(
		long esfMatchId, long esfPartecipantTypeId, long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFNationalDelegationByMatchId_PartecipantTypeId_sportTypeId(esfMatchId,
			esfPartecipantTypeId, sportTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> getESFNationalDelegationByESFUserId_ESFMatchId(
		long esfUserId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFNationalDelegationByESFUserId_ESFMatchId(esfUserId,
			esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> getESFNationalDelegationByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFNationalDelegationByESFMatchId(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> getPartecipantType_EsfUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartecipantType_EsfUserId(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> getESFNationalDelegationByESFMatchIdNotShooter(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFNationalDelegationByESFMatchIdNotShooter(esfMatchId);
	}

	public static it.ethica.esf.model.ESFNationalDelegation deleteESFNationalDelegation(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFNationalDelegation(esfMatchId, esfUserId);
	}

	public static void changeCard(javax.portlet.ActionRequest actionRequest,
		javax.portlet.ActionResponse actionResponse)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException, javax.portlet.PortletException {
		getService().changeCard(actionRequest, actionResponse);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFNationalDelegationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFNationalDelegationLocalService.class.getName());

			if (invokableLocalService instanceof ESFNationalDelegationLocalService) {
				_service = (ESFNationalDelegationLocalService)invokableLocalService;
			}
			else {
				_service = new ESFNationalDelegationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFNationalDelegationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFNationalDelegationLocalService service) {
	}

	private static ESFNationalDelegationLocalService _service;
}