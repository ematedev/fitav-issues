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
 * Provides a wrapper for {@link ESFSuspensiveCodeLocalService}.
 *
 * @author Ethica
 * @see ESFSuspensiveCodeLocalService
 * @generated
 */
public class ESFSuspensiveCodeLocalServiceWrapper
	implements ESFSuspensiveCodeLocalService,
		ServiceWrapper<ESFSuspensiveCodeLocalService> {
	public ESFSuspensiveCodeLocalServiceWrapper(
		ESFSuspensiveCodeLocalService esfSuspensiveCodeLocalService) {
		_esfSuspensiveCodeLocalService = esfSuspensiveCodeLocalService;
	}

	/**
	* Adds the e s f suspensive code to the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveCode the e s f suspensive code
	* @return the e s f suspensive code that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveCode addESFSuspensiveCode(
		it.ethica.esf.model.ESFSuspensiveCode esfSuspensiveCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.addESFSuspensiveCode(esfSuspensiveCode);
	}

	/**
	* Creates a new e s f suspensive code with the primary key. Does not add the e s f suspensive code to the database.
	*
	* @param esfSuspensiveCodeId the primary key for the new e s f suspensive code
	* @return the new e s f suspensive code
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveCode createESFSuspensiveCode(
		long esfSuspensiveCodeId) {
		return _esfSuspensiveCodeLocalService.createESFSuspensiveCode(esfSuspensiveCodeId);
	}

	/**
	* Deletes the e s f suspensive code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveCodeId the primary key of the e s f suspensive code
	* @return the e s f suspensive code that was removed
	* @throws PortalException if a e s f suspensive code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveCode deleteESFSuspensiveCode(
		long esfSuspensiveCodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.deleteESFSuspensiveCode(esfSuspensiveCodeId);
	}

	/**
	* Deletes the e s f suspensive code from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveCode the e s f suspensive code
	* @return the e s f suspensive code that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveCode deleteESFSuspensiveCode(
		it.ethica.esf.model.ESFSuspensiveCode esfSuspensiveCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.deleteESFSuspensiveCode(esfSuspensiveCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfSuspensiveCodeLocalService.dynamicQuery();
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
		return _esfSuspensiveCodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfSuspensiveCodeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfSuspensiveCodeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfSuspensiveCodeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfSuspensiveCodeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFSuspensiveCode fetchESFSuspensiveCode(
		long esfSuspensiveCodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.fetchESFSuspensiveCode(esfSuspensiveCodeId);
	}

	/**
	* Returns the e s f suspensive code with the primary key.
	*
	* @param esfSuspensiveCodeId the primary key of the e s f suspensive code
	* @return the e s f suspensive code
	* @throws PortalException if a e s f suspensive code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveCode getESFSuspensiveCode(
		long esfSuspensiveCodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.getESFSuspensiveCode(esfSuspensiveCodeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f suspensive codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f suspensive codes
	* @param end the upper bound of the range of e s f suspensive codes (not inclusive)
	* @return the range of e s f suspensive codes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFSuspensiveCode> getESFSuspensiveCodes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.getESFSuspensiveCodes(start, end);
	}

	/**
	* Returns the number of e s f suspensive codes.
	*
	* @return the number of e s f suspensive codes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFSuspensiveCodesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.getESFSuspensiveCodesCount();
	}

	/**
	* Updates the e s f suspensive code in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveCode the e s f suspensive code
	* @return the e s f suspensive code that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSuspensiveCode updateESFSuspensiveCode(
		it.ethica.esf.model.ESFSuspensiveCode esfSuspensiveCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.updateESFSuspensiveCode(esfSuspensiveCode);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfSuspensiveCodeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfSuspensiveCodeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfSuspensiveCodeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSuspensiveCode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.findAll(start, end);
	}

	@Override
	public int conutTotal()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSuspensiveCodeLocalService.conutTotal();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFSuspensiveCodeLocalService getWrappedESFSuspensiveCodeLocalService() {
		return _esfSuspensiveCodeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFSuspensiveCodeLocalService(
		ESFSuspensiveCodeLocalService esfSuspensiveCodeLocalService) {
		_esfSuspensiveCodeLocalService = esfSuspensiveCodeLocalService;
	}

	@Override
	public ESFSuspensiveCodeLocalService getWrappedService() {
		return _esfSuspensiveCodeLocalService;
	}

	@Override
	public void setWrappedService(
		ESFSuspensiveCodeLocalService esfSuspensiveCodeLocalService) {
		_esfSuspensiveCodeLocalService = esfSuspensiveCodeLocalService;
	}

	private ESFSuspensiveCodeLocalService _esfSuspensiveCodeLocalService;
}