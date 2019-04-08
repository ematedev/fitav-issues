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
 * Provides the local service utility for ESFPartecipant. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFPartecipantLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFPartecipantLocalService
 * @see it.ethica.esf.service.base.ESFPartecipantLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFPartecipantLocalServiceImpl
 * @generated
 */
public class ESFPartecipantLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFPartecipantLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f partecipant to the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipant the e s f partecipant
	* @return the e s f partecipant that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant addESFPartecipant(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFPartecipant(esfPartecipant);
	}

	/**
	* Creates a new e s f partecipant with the primary key. Does not add the e s f partecipant to the database.
	*
	* @param esfPartecipantId the primary key for the new e s f partecipant
	* @return the new e s f partecipant
	*/
	public static it.ethica.esf.model.ESFPartecipant createESFPartecipant(
		long esfPartecipantId) {
		return getService().createESFPartecipant(esfPartecipantId);
	}

	/**
	* Deletes the e s f partecipant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant that was removed
	* @throws PortalException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant deleteESFPartecipant(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFPartecipant(esfPartecipantId);
	}

	/**
	* Deletes the e s f partecipant from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipant the e s f partecipant
	* @return the e s f partecipant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant deleteESFPartecipant(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFPartecipant(esfPartecipant);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFPartecipant fetchESFPartecipant(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFPartecipant(esfPartecipantId);
	}

	/**
	* Returns the e s f partecipant with the matching UUID and company.
	*
	* @param uuid the e s f partecipant's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchESFPartecipantByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchESFPartecipantByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f partecipant matching the UUID and group.
	*
	* @param uuid the e s f partecipant's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchESFPartecipantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFPartecipantByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f partecipant with the primary key.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant
	* @throws PortalException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant getESFPartecipant(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFPartecipant(esfPartecipantId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f partecipant with the matching UUID and company.
	*
	* @param uuid the e s f partecipant's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f partecipant
	* @throws PortalException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant getESFPartecipantByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFPartecipantByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f partecipant matching the UUID and group.
	*
	* @param uuid the e s f partecipant's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f partecipant
	* @throws PortalException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant getESFPartecipantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFPartecipantByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f partecipants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> getESFPartecipants(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFPartecipants(start, end);
	}

	/**
	* Returns the number of e s f partecipants.
	*
	* @return the number of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFPartecipantsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFPartecipantsCount();
	}

	/**
	* Updates the e s f partecipant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipant the e s f partecipant
	* @return the e s f partecipant that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant updateESFPartecipant(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFPartecipant(esfPartecipant);
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

	public static it.ethica.esf.model.ESFPartecipant getESFPartecipantByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId) {
		return getService()
				   .getESFPartecipantByESFMatchId_ESFUserId(esfMatchId,
			esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFPartecipant> getESFPartecipantsByESFMatchId(
		long esfMatchId) {
		return getService().getESFPartecipantsByESFMatchId(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFPartecipant> getESFPartecipantsByESFMatchId(
		long esfMatchId, int start, int end) {
		return getService()
				   .getESFPartecipantsByESFMatchId(esfMatchId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findPartecipants(
		long idMatch, java.lang.Object[] userIds, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findPartecipants(idMatch, userIds, esfPartecipantTypeId);
	}

	public static it.ethica.esf.model.ESFPartecipant findbyUserId(long userId)
		throws java.lang.Exception {
		return getService().findbyUserId(userId);
	}

	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findPartecipantsByMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findPartecipantsByMatch(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findPartecipantsByTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findPartecipantsByTournament(esfTournamentId);
	}

	public static it.ethica.esf.model.ESFPartecipant getPartecipantByU_M_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPartecipantByU_M_T(esfUserId, esfMatchId,
			esfPartecipantTypeId);
	}

	public static it.ethica.esf.model.ESFPartecipant addESFPartecipant(
		long userId, long esfUserId, long esfMatchId, long esfTeamId, long ct,
		long esfPartecipantTypeId, long result,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFPartecipant(userId, esfUserId, esfMatchId, esfTeamId,
			ct, esfPartecipantTypeId, result, serviceContext);
	}

	public static it.ethica.esf.model.ESFPartecipant deleteESFPartecipant(
		long esfPartecipantId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFPartecipant(esfPartecipantId, serviceContext);
	}

	public static it.ethica.esf.model.ESFPartecipant updateESFPartecipant(
		long userId, long esfPartecipantId, long esfUserId, long esfMatchId,
		long esfTeamId, long ct, long esfPartecipantTypeId, long result,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFPartecipant(userId, esfPartecipantId, esfUserId,
			esfMatchId, esfTeamId, ct, esfPartecipantTypeId, result,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFPartecipantLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFPartecipantLocalService.class.getName());

			if (invokableLocalService instanceof ESFPartecipantLocalService) {
				_service = (ESFPartecipantLocalService)invokableLocalService;
			}
			else {
				_service = new ESFPartecipantLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFPartecipantLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFPartecipantLocalService service) {
	}

	private static ESFPartecipantLocalService _service;
}