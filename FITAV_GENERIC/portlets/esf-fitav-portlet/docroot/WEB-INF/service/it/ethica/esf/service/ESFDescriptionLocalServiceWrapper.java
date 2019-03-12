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
 * Provides a wrapper for {@link ESFDescriptionLocalService}.
 *
 * @author Ethica
 * @see ESFDescriptionLocalService
 * @generated
 */
public class ESFDescriptionLocalServiceWrapper
	implements ESFDescriptionLocalService,
		ServiceWrapper<ESFDescriptionLocalService> {
	public ESFDescriptionLocalServiceWrapper(
		ESFDescriptionLocalService esfDescriptionLocalService) {
		_esfDescriptionLocalService = esfDescriptionLocalService;
	}

	/**
	* Adds the e s f description to the database. Also notifies the appropriate model listeners.
	*
	* @param esfDescription the e s f description
	* @return the e s f description that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDescription addESFDescription(
		it.ethica.esf.model.ESFDescription esfDescription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.addESFDescription(esfDescription);
	}

	/**
	* Creates a new e s f description with the primary key. Does not add the e s f description to the database.
	*
	* @param esfDescriptionId the primary key for the new e s f description
	* @return the new e s f description
	*/
	@Override
	public it.ethica.esf.model.ESFDescription createESFDescription(
		long esfDescriptionId) {
		return _esfDescriptionLocalService.createESFDescription(esfDescriptionId);
	}

	/**
	* Deletes the e s f description with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDescriptionId the primary key of the e s f description
	* @return the e s f description that was removed
	* @throws PortalException if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDescription deleteESFDescription(
		long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.deleteESFDescription(esfDescriptionId);
	}

	/**
	* Deletes the e s f description from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDescription the e s f description
	* @return the e s f description that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDescription deleteESFDescription(
		it.ethica.esf.model.ESFDescription esfDescription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.deleteESFDescription(esfDescription);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfDescriptionLocalService.dynamicQuery();
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
		return _esfDescriptionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfDescriptionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfDescriptionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfDescriptionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfDescriptionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFDescription fetchESFDescription(
		long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.fetchESFDescription(esfDescriptionId);
	}

	/**
	* Returns the e s f description with the primary key.
	*
	* @param esfDescriptionId the primary key of the e s f description
	* @return the e s f description
	* @throws PortalException if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDescription getESFDescription(
		long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.getESFDescription(esfDescriptionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f descriptions
	* @param end the upper bound of the range of e s f descriptions (not inclusive)
	* @return the range of e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFDescription> getESFDescriptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.getESFDescriptions(start, end);
	}

	/**
	* Returns the number of e s f descriptions.
	*
	* @return the number of e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFDescriptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.getESFDescriptionsCount();
	}

	/**
	* Updates the e s f description in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfDescription the e s f description
	* @return the e s f description that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDescription updateESFDescription(
		it.ethica.esf.model.ESFDescription esfDescription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.updateESFDescription(esfDescription);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfDescriptionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfDescriptionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfDescriptionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDescription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.findAll();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDescription> findAllByNational(
		boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.findAllByNational(isNational);
	}

	@Override
	public it.ethica.esf.model.ESFDescription addEsfDescription(
		java.lang.String name, boolean IsNational,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.addEsfDescription(name, IsNational,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFDescription updateEsfDescription(
		long esfDescriptionId, java.lang.String name, boolean IsNational,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.updateEsfDescription(esfDescriptionId,
			name, IsNational, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFDescription deleteEsfDescription(
		long esfDescriptionId, javax.portlet.ActionRequest request)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException {
		return _esfDescriptionLocalService.deleteEsfDescription(esfDescriptionId,
			request);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDescription> getESFDescriptionsByMatchUser(
		java.util.List<it.ethica.esf.model.ESFNationalMatchResult> results)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDescriptionLocalService.getESFDescriptionsByMatchUser(results);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFDescriptionLocalService getWrappedESFDescriptionLocalService() {
		return _esfDescriptionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFDescriptionLocalService(
		ESFDescriptionLocalService esfDescriptionLocalService) {
		_esfDescriptionLocalService = esfDescriptionLocalService;
	}

	@Override
	public ESFDescriptionLocalService getWrappedService() {
		return _esfDescriptionLocalService;
	}

	@Override
	public void setWrappedService(
		ESFDescriptionLocalService esfDescriptionLocalService) {
		_esfDescriptionLocalService = esfDescriptionLocalService;
	}

	private ESFDescriptionLocalService _esfDescriptionLocalService;
}