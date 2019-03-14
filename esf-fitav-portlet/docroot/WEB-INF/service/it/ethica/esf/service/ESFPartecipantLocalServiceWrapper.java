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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFPartecipantLocalService}.
 *
 * @author Ethica
 * @see ESFPartecipantLocalService
 * @generated
 */
public class ESFPartecipantLocalServiceWrapper
	implements ESFPartecipantLocalService,
		ServiceWrapper<ESFPartecipantLocalService> {
	public ESFPartecipantLocalServiceWrapper(
		ESFPartecipantLocalService esfPartecipantLocalService) {
		_esfPartecipantLocalService = esfPartecipantLocalService;
	}

	/**
	* Adds the e s f partecipant to the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipant the e s f partecipant
	* @return the e s f partecipant that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipant addESFPartecipant(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.addESFPartecipant(esfPartecipant);
	}

	/**
	* Creates a new e s f partecipant with the primary key. Does not add the e s f partecipant to the database.
	*
	* @param esfPartecipantId the primary key for the new e s f partecipant
	* @return the new e s f partecipant
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipant createESFPartecipant(
		long esfPartecipantId) {
		return _esfPartecipantLocalService.createESFPartecipant(esfPartecipantId);
	}

	/**
	* Deletes the e s f partecipant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant that was removed
	* @throws PortalException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipant deleteESFPartecipant(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.deleteESFPartecipant(esfPartecipantId);
	}

	/**
	* Deletes the e s f partecipant from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipant the e s f partecipant
	* @return the e s f partecipant that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipant deleteESFPartecipant(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.deleteESFPartecipant(esfPartecipant);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfPartecipantLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant fetchESFPartecipant(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.fetchESFPartecipant(esfPartecipantId);
	}

	/**
	* Returns the e s f partecipant with the matching UUID and company.
	*
	* @param uuid the e s f partecipant's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipant fetchESFPartecipantByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.fetchESFPartecipantByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f partecipant matching the UUID and group.
	*
	* @param uuid the e s f partecipant's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipant fetchESFPartecipantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.fetchESFPartecipantByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f partecipant with the primary key.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant
	* @throws PortalException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipant getESFPartecipant(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.getESFPartecipant(esfPartecipantId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public it.ethica.esf.model.ESFPartecipant getESFPartecipantByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.getESFPartecipantByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public it.ethica.esf.model.ESFPartecipant getESFPartecipantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.getESFPartecipantByUuidAndGroupId(uuid,
			groupId);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipant> getESFPartecipants(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.getESFPartecipants(start, end);
	}

	/**
	* Returns the number of e s f partecipants.
	*
	* @return the number of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFPartecipantsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.getESFPartecipantsCount();
	}

	/**
	* Updates the e s f partecipant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipant the e s f partecipant
	* @return the e s f partecipant that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipant updateESFPartecipant(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.updateESFPartecipant(esfPartecipant);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfPartecipantLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfPartecipantLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfPartecipantLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant getESFPartecipantByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId) {
		return _esfPartecipantLocalService.getESFPartecipantByESFMatchId_ESFUserId(esfMatchId,
			esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipant> getESFPartecipantsByESFMatchId(
		long esfMatchId) {
		return _esfPartecipantLocalService.getESFPartecipantsByESFMatchId(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipant> getESFPartecipantsByESFMatchId(
		long esfMatchId, int start, int end) {
		return _esfPartecipantLocalService.getESFPartecipantsByESFMatchId(esfMatchId,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findPartecipants(
		long idMatch, java.lang.Object[] userIds, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.findPartecipants(idMatch, userIds,
			esfPartecipantTypeId);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant findbyUserId(long userId)
		throws java.lang.Exception {
		return _esfPartecipantLocalService.findbyUserId(userId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findPartecipantsByMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.findPartecipantsByMatch(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findPartecipantsByTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.findPartecipantsByTournament(esfTournamentId);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant getPartecipantByU_M_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.getPartecipantByU_M_T(esfUserId,
			esfMatchId, esfPartecipantTypeId);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant addESFPartecipant(long userId,
		long esfUserId, long esfMatchId, long esfTeamId, long ct,
		long esfPartecipantTypeId, long result,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.addESFPartecipant(userId, esfUserId,
			esfMatchId, esfTeamId, ct, esfPartecipantTypeId, result,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant deleteESFPartecipant(
		long esfPartecipantId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.deleteESFPartecipant(esfPartecipantId,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant updateESFPartecipant(
		long userId, long esfPartecipantId, long esfUserId, long esfMatchId,
		long esfTeamId, long ct, long esfPartecipantTypeId, long result,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantLocalService.updateESFPartecipant(userId,
			esfPartecipantId, esfUserId, esfMatchId, esfTeamId, ct,
			esfPartecipantTypeId, result, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFPartecipantLocalService getWrappedESFPartecipantLocalService() {
		return _esfPartecipantLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFPartecipantLocalService(
		ESFPartecipantLocalService esfPartecipantLocalService) {
		_esfPartecipantLocalService = esfPartecipantLocalService;
	}

	@Override
	public ESFPartecipantLocalService getWrappedService() {
		return _esfPartecipantLocalService;
	}

	@Override
	public void setWrappedService(
		ESFPartecipantLocalService esfPartecipantLocalService) {
		_esfPartecipantLocalService = esfPartecipantLocalService;
	}

	private ESFPartecipantLocalService _esfPartecipantLocalService;
}