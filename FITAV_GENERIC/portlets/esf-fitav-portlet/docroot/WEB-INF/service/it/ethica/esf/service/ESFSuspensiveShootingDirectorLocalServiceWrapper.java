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
 * Provides a wrapper for {@link ESFSuspensiveShootingDirectorLocalService}.
 *
 * @author Ethica
 * @see ESFSuspensiveShootingDirectorLocalService
 * @generated
 */
public class ESFSuspensiveShootingDirectorLocalServiceWrapper
	implements ESFSuspensiveShootingDirectorLocalService,
		ServiceWrapper<ESFSuspensiveShootingDirectorLocalService> {
	public ESFSuspensiveShootingDirectorLocalServiceWrapper(
		ESFSuspensiveShootingDirectorLocalService esfSuspensiveShootingDirectorLocalService) {
		_esfSuspensiveShootingDirectorLocalService = esfSuspensiveShootingDirectorLocalService;
	}

	/**
	* Adds the e s f suspensive shooting director to the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveShootingDirector the e s f suspensive shooting director
	* @return the e s f suspensive shooting director that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector addESFSuspensiveShootingDirector(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.addESFSuspensiveShootingDirector(esfSuspensiveShootingDirector);
	}

	/**
	* Creates a new e s f suspensive shooting director with the primary key. Does not add the e s f suspensive shooting director to the database.
	*
	* @param esfSuspensiveShooingDirectorId the primary key for the new e s f suspensive shooting director
	* @return the new e s f suspensive shooting director
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector createESFSuspensiveShootingDirector(
		long esfSuspensiveShooingDirectorId) {
		return _esfSuspensiveShootingDirectorLocalService.createESFSuspensiveShootingDirector(esfSuspensiveShooingDirectorId);
	}

	/**
	* Deletes the e s f suspensive shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	* @return the e s f suspensive shooting director that was removed
	* @throws PortalException if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector deleteESFSuspensiveShootingDirector(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.deleteESFSuspensiveShootingDirector(esfSuspensiveShooingDirectorId);
	}

	/**
	* Deletes the e s f suspensive shooting director from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveShootingDirector the e s f suspensive shooting director
	* @return the e s f suspensive shooting director that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector deleteESFSuspensiveShootingDirector(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.deleteESFSuspensiveShootingDirector(esfSuspensiveShootingDirector);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfSuspensiveShootingDirectorLocalService.dynamicQuery();
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
		return _esfSuspensiveShootingDirectorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfSuspensiveShootingDirectorLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfSuspensiveShootingDirectorLocalService.dynamicQuery(dynamicQuery,
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
		return _esfSuspensiveShootingDirectorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfSuspensiveShootingDirectorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector fetchESFSuspensiveShootingDirector(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.fetchESFSuspensiveShootingDirector(esfSuspensiveShooingDirectorId);
	}

	/**
	* Returns the e s f suspensive shooting director with the primary key.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	* @return the e s f suspensive shooting director
	* @throws PortalException if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector getESFSuspensiveShootingDirector(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.getESFSuspensiveShootingDirector(esfSuspensiveShooingDirectorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f suspensive shooting directors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f suspensive shooting directors
	* @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	* @return the range of e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> getESFSuspensiveShootingDirectors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.getESFSuspensiveShootingDirectors(start,
			end);
	}

	/**
	* Returns the number of e s f suspensive shooting directors.
	*
	* @return the number of e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFSuspensiveShootingDirectorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.getESFSuspensiveShootingDirectorsCount();
	}

	/**
	* Updates the e s f suspensive shooting director in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveShootingDirector the e s f suspensive shooting director
	* @return the e s f suspensive shooting director that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector updateESFSuspensiveShootingDirector(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.updateESFSuspensiveShootingDirector(esfSuspensiveShootingDirector);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfSuspensiveShootingDirectorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfSuspensiveShootingDirectorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfSuspensiveShootingDirectorLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.findByUserId(esfUserId,
			start, end);
	}

	@Override
	public int countByUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.countByUserId(esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.findAll(start, end);
	}

	@Override
	public int countTotal()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.countTotal();
	}

	@Override
	public int findSuspensive(java.util.Date matchData, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveShootingDirectorLocalService.findSuspensive(matchData,
			userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFSuspensiveShootingDirectorLocalService getWrappedESFSuspensiveShootingDirectorLocalService() {
		return _esfSuspensiveShootingDirectorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFSuspensiveShootingDirectorLocalService(
		ESFSuspensiveShootingDirectorLocalService esfSuspensiveShootingDirectorLocalService) {
		_esfSuspensiveShootingDirectorLocalService = esfSuspensiveShootingDirectorLocalService;
	}

	@Override
	public ESFSuspensiveShootingDirectorLocalService getWrappedService() {
		return _esfSuspensiveShootingDirectorLocalService;
	}

	@Override
	public void setWrappedService(
		ESFSuspensiveShootingDirectorLocalService esfSuspensiveShootingDirectorLocalService) {
		_esfSuspensiveShootingDirectorLocalService = esfSuspensiveShootingDirectorLocalService;
	}

	private ESFSuspensiveShootingDirectorLocalService _esfSuspensiveShootingDirectorLocalService;
}