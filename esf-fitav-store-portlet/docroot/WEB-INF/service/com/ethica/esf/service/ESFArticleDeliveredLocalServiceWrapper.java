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

package com.ethica.esf.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFArticleDeliveredLocalService}.
 *
 * @author Ethica
 * @see ESFArticleDeliveredLocalService
 * @generated
 */
public class ESFArticleDeliveredLocalServiceWrapper
	implements ESFArticleDeliveredLocalService,
		ServiceWrapper<ESFArticleDeliveredLocalService> {
	public ESFArticleDeliveredLocalServiceWrapper(
		ESFArticleDeliveredLocalService esfArticleDeliveredLocalService) {
		_esfArticleDeliveredLocalService = esfArticleDeliveredLocalService;
	}

	/**
	* Adds the e s f article delivered to the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleDelivered the e s f article delivered
	* @return the e s f article delivered that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleDelivered addESFArticleDelivered(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.addESFArticleDelivered(esfArticleDelivered);
	}

	/**
	* Creates a new e s f article delivered with the primary key. Does not add the e s f article delivered to the database.
	*
	* @param esfArticleDeliveredId the primary key for the new e s f article delivered
	* @return the new e s f article delivered
	*/
	@Override
	public com.ethica.esf.model.ESFArticleDelivered createESFArticleDelivered(
		long esfArticleDeliveredId) {
		return _esfArticleDeliveredLocalService.createESFArticleDelivered(esfArticleDeliveredId);
	}

	/**
	* Deletes the e s f article delivered with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleDeliveredId the primary key of the e s f article delivered
	* @return the e s f article delivered that was removed
	* @throws PortalException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleDelivered deleteESFArticleDelivered(
		long esfArticleDeliveredId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.deleteESFArticleDelivered(esfArticleDeliveredId);
	}

	/**
	* Deletes the e s f article delivered from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleDelivered the e s f article delivered
	* @return the e s f article delivered that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleDelivered deleteESFArticleDelivered(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.deleteESFArticleDelivered(esfArticleDelivered);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfArticleDeliveredLocalService.dynamicQuery();
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
		return _esfArticleDeliveredLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfArticleDeliveredLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfArticleDeliveredLocalService.dynamicQuery(dynamicQuery,
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
		return _esfArticleDeliveredLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfArticleDeliveredLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ethica.esf.model.ESFArticleDelivered fetchESFArticleDelivered(
		long esfArticleDeliveredId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.fetchESFArticleDelivered(esfArticleDeliveredId);
	}

	/**
	* Returns the e s f article delivered with the primary key.
	*
	* @param esfArticleDeliveredId the primary key of the e s f article delivered
	* @return the e s f article delivered
	* @throws PortalException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleDelivered getESFArticleDelivered(
		long esfArticleDeliveredId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.getESFArticleDelivered(esfArticleDeliveredId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f article delivereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @return the range of e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> getESFArticleDelivereds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.getESFArticleDelivereds(start,
			end);
	}

	/**
	* Returns the number of e s f article delivereds.
	*
	* @return the number of e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFArticleDeliveredsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.getESFArticleDeliveredsCount();
	}

	/**
	* Updates the e s f article delivered in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfArticleDelivered the e s f article delivered
	* @return the e s f article delivered that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleDelivered updateESFArticleDelivered(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.updateESFArticleDelivered(esfArticleDelivered);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfArticleDeliveredLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfArticleDeliveredLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfArticleDeliveredLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.ethica.esf.model.ESFArticleDelivered addESFArticleDelivered(
		java.lang.String description, java.util.Date dateD, long esfArticleId,
		long esfShooterId, long xxxlQty, long xxlQty, long xlQty, long lQty,
		long mQty, long sQty, long xsQty, long xxsQty, long otherQty,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.addESFArticleDelivered(description,
			dateD, esfArticleId, esfShooterId, xxxlQty, xxlQty, xlQty, lQty,
			mQty, sQty, xsQty, xxsQty, otherQty, serviceContext);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link it.ethica.esf.service.ESFArticleDeliveredLocalServiceUtil} to
	* access the e s f article delivered local service.
	*/
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> getESFArticleDeliveredByArticleId(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleDeliveredLocalService.getESFArticleDeliveredByArticleId(esfArticleId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFArticleDeliveredLocalService getWrappedESFArticleDeliveredLocalService() {
		return _esfArticleDeliveredLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFArticleDeliveredLocalService(
		ESFArticleDeliveredLocalService esfArticleDeliveredLocalService) {
		_esfArticleDeliveredLocalService = esfArticleDeliveredLocalService;
	}

	@Override
	public ESFArticleDeliveredLocalService getWrappedService() {
		return _esfArticleDeliveredLocalService;
	}

	@Override
	public void setWrappedService(
		ESFArticleDeliveredLocalService esfArticleDeliveredLocalService) {
		_esfArticleDeliveredLocalService = esfArticleDeliveredLocalService;
	}

	private ESFArticleDeliveredLocalService _esfArticleDeliveredLocalService;
}