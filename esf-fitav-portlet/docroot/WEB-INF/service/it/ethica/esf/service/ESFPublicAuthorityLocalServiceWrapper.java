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
 * Provides a wrapper for {@link ESFPublicAuthorityLocalService}.
 *
 * @author Ethica
 * @see ESFPublicAuthorityLocalService
 * @generated
 */
public class ESFPublicAuthorityLocalServiceWrapper
	implements ESFPublicAuthorityLocalService,
		ServiceWrapper<ESFPublicAuthorityLocalService> {
	public ESFPublicAuthorityLocalServiceWrapper(
		ESFPublicAuthorityLocalService esfPublicAuthorityLocalService) {
		_esfPublicAuthorityLocalService = esfPublicAuthorityLocalService;
	}

	/**
	* Adds the e s f public authority to the database. Also notifies the appropriate model listeners.
	*
	* @param esfPublicAuthority the e s f public authority
	* @return the e s f public authority that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPublicAuthority addESFPublicAuthority(
		it.ethica.esf.model.ESFPublicAuthority esfPublicAuthority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.addESFPublicAuthority(esfPublicAuthority);
	}

	/**
	* Creates a new e s f public authority with the primary key. Does not add the e s f public authority to the database.
	*
	* @param esfPublicAuthorityId the primary key for the new e s f public authority
	* @return the new e s f public authority
	*/
	@Override
	public it.ethica.esf.model.ESFPublicAuthority createESFPublicAuthority(
		long esfPublicAuthorityId) {
		return _esfPublicAuthorityLocalService.createESFPublicAuthority(esfPublicAuthorityId);
	}

	/**
	* Deletes the e s f public authority with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPublicAuthorityId the primary key of the e s f public authority
	* @return the e s f public authority that was removed
	* @throws PortalException if a e s f public authority with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPublicAuthority deleteESFPublicAuthority(
		long esfPublicAuthorityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.deleteESFPublicAuthority(esfPublicAuthorityId);
	}

	/**
	* Deletes the e s f public authority from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPublicAuthority the e s f public authority
	* @return the e s f public authority that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPublicAuthority deleteESFPublicAuthority(
		it.ethica.esf.model.ESFPublicAuthority esfPublicAuthority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.deleteESFPublicAuthority(esfPublicAuthority);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfPublicAuthorityLocalService.dynamicQuery();
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
		return _esfPublicAuthorityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPublicAuthorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfPublicAuthorityLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPublicAuthorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfPublicAuthorityLocalService.dynamicQuery(dynamicQuery,
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
		return _esfPublicAuthorityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfPublicAuthorityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFPublicAuthority fetchESFPublicAuthority(
		long esfPublicAuthorityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.fetchESFPublicAuthority(esfPublicAuthorityId);
	}

	/**
	* Returns the e s f public authority with the primary key.
	*
	* @param esfPublicAuthorityId the primary key of the e s f public authority
	* @return the e s f public authority
	* @throws PortalException if a e s f public authority with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPublicAuthority getESFPublicAuthority(
		long esfPublicAuthorityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.getESFPublicAuthority(esfPublicAuthorityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f public authorities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPublicAuthorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f public authorities
	* @param end the upper bound of the range of e s f public authorities (not inclusive)
	* @return the range of e s f public authorities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFPublicAuthority> getESFPublicAuthorities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.getESFPublicAuthorities(start,
			end);
	}

	/**
	* Returns the number of e s f public authorities.
	*
	* @return the number of e s f public authorities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFPublicAuthoritiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.getESFPublicAuthoritiesCount();
	}

	/**
	* Updates the e s f public authority in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfPublicAuthority the e s f public authority
	* @return the e s f public authority that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPublicAuthority updateESFPublicAuthority(
		it.ethica.esf.model.ESFPublicAuthority esfPublicAuthority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.updateESFPublicAuthority(esfPublicAuthority);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfPublicAuthorityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfPublicAuthorityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfPublicAuthorityLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public it.ethica.esf.model.ESFPublicAuthority saveUpdateESFPublicAuthority(
		it.ethica.esf.model.ESFPublicAuthority authority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPublicAuthorityLocalService.saveUpdateESFPublicAuthority(authority);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFPublicAuthorityLocalService getWrappedESFPublicAuthorityLocalService() {
		return _esfPublicAuthorityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFPublicAuthorityLocalService(
		ESFPublicAuthorityLocalService esfPublicAuthorityLocalService) {
		_esfPublicAuthorityLocalService = esfPublicAuthorityLocalService;
	}

	@Override
	public ESFPublicAuthorityLocalService getWrappedService() {
		return _esfPublicAuthorityLocalService;
	}

	@Override
	public void setWrappedService(
		ESFPublicAuthorityLocalService esfPublicAuthorityLocalService) {
		_esfPublicAuthorityLocalService = esfPublicAuthorityLocalService;
	}

	private ESFPublicAuthorityLocalService _esfPublicAuthorityLocalService;
}