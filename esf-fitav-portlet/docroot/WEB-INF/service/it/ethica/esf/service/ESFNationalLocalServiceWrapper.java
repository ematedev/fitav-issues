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
 * Provides a wrapper for {@link ESFNationalLocalService}.
 *
 * @author Ethica
 * @see ESFNationalLocalService
 * @generated
 */
public class ESFNationalLocalServiceWrapper implements ESFNationalLocalService,
	ServiceWrapper<ESFNationalLocalService> {
	public ESFNationalLocalServiceWrapper(
		ESFNationalLocalService esfNationalLocalService) {
		_esfNationalLocalService = esfNationalLocalService;
	}

	/**
	* Adds the e s f national to the database. Also notifies the appropriate model listeners.
	*
	* @param esfNational the e s f national
	* @return the e s f national that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNational addESFNational(
		it.ethica.esf.model.ESFNational esfNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.addESFNational(esfNational);
	}

	/**
	* Creates a new e s f national with the primary key. Does not add the e s f national to the database.
	*
	* @param esfNationalId the primary key for the new e s f national
	* @return the new e s f national
	*/
	@Override
	public it.ethica.esf.model.ESFNational createESFNational(long esfNationalId) {
		return _esfNationalLocalService.createESFNational(esfNationalId);
	}

	/**
	* Deletes the e s f national with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national that was removed
	* @throws PortalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNational deleteESFNational(long esfNationalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.deleteESFNational(esfNationalId);
	}

	/**
	* Deletes the e s f national from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNational the e s f national
	* @return the e s f national that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNational deleteESFNational(
		it.ethica.esf.model.ESFNational esfNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.deleteESFNational(esfNational);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfNationalLocalService.dynamicQuery();
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
		return _esfNationalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfNationalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfNationalLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _esfNationalLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfNationalLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFNational fetchESFNational(long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.fetchESFNational(esfNationalId);
	}

	/**
	* Returns the e s f national with the primary key.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national
	* @throws PortalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNational getESFNational(long esfNationalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getESFNational(esfNationalId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f nationals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @return the range of e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFNational> getESFNationals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getESFNationals(start, end);
	}

	/**
	* Returns the number of e s f nationals.
	*
	* @return the number of e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFNationalsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getESFNationalsCount();
	}

	/**
	* Updates the e s f national in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfNational the e s f national
	* @return the e s f national that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNational updateESFNational(
		it.ethica.esf.model.ESFNational esfNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.updateESFNational(esfNational);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfNationalLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfNationalLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfNationalLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNational> getActiveESFNationals(
		long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getActiveESFNationals(esfSportTypeId,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNational> getActiveESFNationals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getActiveESFNationals(start, end);
	}

	@Override
	public int countActiveESFNationals(long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.countActiveESFNationals(esfSportTypeId,
			start, end);
	}

	@Override
	public int countActiveESFNationals()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.countActiveESFNationals();
	}

	@Override
	public it.ethica.esf.model.ESFNational getActiveESFNational(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getActiveESFNational(esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNational> getActiveESFNational_UserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getActiveESFNational_UserId(esfUserId);
	}

	@Override
	public boolean isActiveESFNationals(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.isActiveESFNationals(esfUserId);
	}

	@Override
	public it.ethica.esf.model.ESFNational addESFNational(long userId,
		long esfUserId, long esfSportTypeId, java.util.Date startDate,
		java.util.Date endDate, java.util.Date bdoDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.addESFNational(userId, esfUserId,
			esfSportTypeId, startDate, endDate, bdoDate, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFNational deleteESFNational(long userId,
		long esfNationalId, java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.deleteESFNational(userId,
			esfNationalId, endDate, serviceContext);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNational> getEXESFNationalUser(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.getEXESFNationalUser(esfSportTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNational> findNationalbySportId_MatchId(
		long esfSportTypeId, long matchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.findNationalbySportId_MatchId(esfSportTypeId,
			matchId, start, end);
	}

	@Override
	public int countNationalbySportId_MatchId(long esfSportTypeId, long matchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalLocalService.countNationalbySportId_MatchId(esfSportTypeId,
			matchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNational> findNationalFreeMatchIdSportId(
		long matchId, long sportTypeId, int begin, int end) {
		return _esfNationalLocalService.findNationalFreeMatchIdSportId(matchId,
			sportTypeId, begin, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFNationalLocalService getWrappedESFNationalLocalService() {
		return _esfNationalLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFNationalLocalService(
		ESFNationalLocalService esfNationalLocalService) {
		_esfNationalLocalService = esfNationalLocalService;
	}

	@Override
	public ESFNationalLocalService getWrappedService() {
		return _esfNationalLocalService;
	}

	@Override
	public void setWrappedService(
		ESFNationalLocalService esfNationalLocalService) {
		_esfNationalLocalService = esfNationalLocalService;
	}

	private ESFNationalLocalService _esfNationalLocalService;
}