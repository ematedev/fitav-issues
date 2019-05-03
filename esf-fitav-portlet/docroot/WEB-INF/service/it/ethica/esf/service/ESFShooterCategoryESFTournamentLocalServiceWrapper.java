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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFShooterCategoryESFTournamentLocalService}.
 *
 * @author Ethica
 * @see ESFShooterCategoryESFTournamentLocalService
 * @generated
 */
public class ESFShooterCategoryESFTournamentLocalServiceWrapper
	implements ESFShooterCategoryESFTournamentLocalService,
		ServiceWrapper<ESFShooterCategoryESFTournamentLocalService> {
	public ESFShooterCategoryESFTournamentLocalServiceWrapper(
		ESFShooterCategoryESFTournamentLocalService esfShooterCategoryESFTournamentLocalService) {
		_esfShooterCategoryESFTournamentLocalService = esfShooterCategoryESFTournamentLocalService;
	}

	/**
	* Adds the e s f shooter category e s f tournament to the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterCategoryESFTournament the e s f shooter category e s f tournament
	* @return the e s f shooter category e s f tournament that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament addESFShooterCategoryESFTournament(
		it.ethica.esf.model.ESFShooterCategoryESFTournament esfShooterCategoryESFTournament)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.addESFShooterCategoryESFTournament(esfShooterCategoryESFTournament);
	}

	/**
	* Creates a new e s f shooter category e s f tournament with the primary key. Does not add the e s f shooter category e s f tournament to the database.
	*
	* @param esfShooterCategoryESFTournamentPK the primary key for the new e s f shooter category e s f tournament
	* @return the new e s f shooter category e s f tournament
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament createESFShooterCategoryESFTournament(
		it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK) {
		return _esfShooterCategoryESFTournamentLocalService.createESFShooterCategoryESFTournament(esfShooterCategoryESFTournamentPK);
	}

	/**
	* Deletes the e s f shooter category e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterCategoryESFTournamentPK the primary key of the e s f shooter category e s f tournament
	* @return the e s f shooter category e s f tournament that was removed
	* @throws PortalException if a e s f shooter category e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament deleteESFShooterCategoryESFTournament(
		it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.deleteESFShooterCategoryESFTournament(esfShooterCategoryESFTournamentPK);
	}

	/**
	* Deletes the e s f shooter category e s f tournament from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterCategoryESFTournament the e s f shooter category e s f tournament
	* @return the e s f shooter category e s f tournament that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament deleteESFShooterCategoryESFTournament(
		it.ethica.esf.model.ESFShooterCategoryESFTournament esfShooterCategoryESFTournament)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.deleteESFShooterCategoryESFTournament(esfShooterCategoryESFTournament);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfShooterCategoryESFTournamentLocalService.dynamicQuery();
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
		return _esfShooterCategoryESFTournamentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfShooterCategoryESFTournamentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfShooterCategoryESFTournamentLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _esfShooterCategoryESFTournamentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfShooterCategoryESFTournamentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament fetchESFShooterCategoryESFTournament(
		it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.fetchESFShooterCategoryESFTournament(esfShooterCategoryESFTournamentPK);
	}

	/**
	* Returns the e s f shooter category e s f tournament matching the UUID and group.
	*
	* @param uuid the e s f shooter category e s f tournament's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f shooter category e s f tournament, or <code>null</code> if a matching e s f shooter category e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament fetchESFShooterCategoryESFTournamentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.fetchESFShooterCategoryESFTournamentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f shooter category e s f tournament with the primary key.
	*
	* @param esfShooterCategoryESFTournamentPK the primary key of the e s f shooter category e s f tournament
	* @return the e s f shooter category e s f tournament
	* @throws PortalException if a e s f shooter category e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament getESFShooterCategoryESFTournament(
		it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.getESFShooterCategoryESFTournament(esfShooterCategoryESFTournamentPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f shooter category e s f tournament matching the UUID and group.
	*
	* @param uuid the e s f shooter category e s f tournament's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f shooter category e s f tournament
	* @throws PortalException if a matching e s f shooter category e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament getESFShooterCategoryESFTournamentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.getESFShooterCategoryESFTournamentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f shooter category e s f tournaments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter category e s f tournaments
	* @param end the upper bound of the range of e s f shooter category e s f tournaments (not inclusive)
	* @return the range of e s f shooter category e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterCategoryESFTournament> getESFShooterCategoryESFTournaments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.getESFShooterCategoryESFTournaments(start,
			end);
	}

	/**
	* Returns the number of e s f shooter category e s f tournaments.
	*
	* @return the number of e s f shooter category e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFShooterCategoryESFTournamentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.getESFShooterCategoryESFTournamentsCount();
	}

	/**
	* Updates the e s f shooter category e s f tournament in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfShooterCategoryESFTournament the e s f shooter category e s f tournament
	* @return the e s f shooter category e s f tournament that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament updateESFShooterCategoryESFTournament(
		it.ethica.esf.model.ESFShooterCategoryESFTournament esfShooterCategoryESFTournament)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFTournamentLocalService.updateESFShooterCategoryESFTournament(esfShooterCategoryESFTournament);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfShooterCategoryESFTournamentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfShooterCategoryESFTournamentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfShooterCategoryESFTournamentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFShooterCategoryESFTournamentLocalService getWrappedESFShooterCategoryESFTournamentLocalService() {
		return _esfShooterCategoryESFTournamentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFShooterCategoryESFTournamentLocalService(
		ESFShooterCategoryESFTournamentLocalService esfShooterCategoryESFTournamentLocalService) {
		_esfShooterCategoryESFTournamentLocalService = esfShooterCategoryESFTournamentLocalService;
	}

	@Override
	public ESFShooterCategoryESFTournamentLocalService getWrappedService() {
		return _esfShooterCategoryESFTournamentLocalService;
	}

	@Override
	public void setWrappedService(
		ESFShooterCategoryESFTournamentLocalService esfShooterCategoryESFTournamentLocalService) {
		_esfShooterCategoryESFTournamentLocalService = esfShooterCategoryESFTournamentLocalService;
	}

	private ESFShooterCategoryESFTournamentLocalService _esfShooterCategoryESFTournamentLocalService;
}