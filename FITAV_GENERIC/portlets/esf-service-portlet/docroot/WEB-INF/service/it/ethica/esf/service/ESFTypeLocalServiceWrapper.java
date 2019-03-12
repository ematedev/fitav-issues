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
 * Provides a wrapper for {@link ESFTypeLocalService}.
 *
 * @author Ethica
 * @see ESFTypeLocalService
 * @generated
 */
public class ESFTypeLocalServiceWrapper implements ESFTypeLocalService,
	ServiceWrapper<ESFTypeLocalService> {
	public ESFTypeLocalServiceWrapper(ESFTypeLocalService esfTypeLocalService) {
		_esfTypeLocalService = esfTypeLocalService;
	}

	/**
	* Adds the e s f type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfType the e s f type
	* @return the e s f type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFType addESFType(
		it.ethica.esf.model.ESFType esfType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.addESFType(esfType);
	}

	/**
	* Creates a new e s f type with the primary key. Does not add the e s f type to the database.
	*
	* @param esfTypeId the primary key for the new e s f type
	* @return the new e s f type
	*/
	@Override
	public it.ethica.esf.model.ESFType createESFType(long esfTypeId) {
		return _esfTypeLocalService.createESFType(esfTypeId);
	}

	/**
	* Deletes the e s f type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfTypeId the primary key of the e s f type
	* @return the e s f type that was removed
	* @throws PortalException if a e s f type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFType deleteESFType(long esfTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.deleteESFType(esfTypeId);
	}

	/**
	* Deletes the e s f type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfType the e s f type
	* @return the e s f type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFType deleteESFType(
		it.ethica.esf.model.ESFType esfType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.deleteESFType(esfType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfTypeLocalService.dynamicQuery();
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
		return _esfTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfTypeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFType fetchESFType(long esfTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.fetchESFType(esfTypeId);
	}

	/**
	* Returns the e s f type with the primary key.
	*
	* @param esfTypeId the primary key of the e s f type
	* @return the e s f type
	* @throws PortalException if a e s f type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFType getESFType(long esfTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.getESFType(esfTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f types
	* @param end the upper bound of the range of e s f types (not inclusive)
	* @return the range of e s f types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFType> getESFTypes(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.getESFTypes(start, end);
	}

	/**
	* Returns the number of e s f types.
	*
	* @return the number of e s f types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.getESFTypesCount();
	}

	/**
	* Updates the e s f type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfType the e s f type
	* @return the e s f type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFType updateESFType(
		it.ethica.esf.model.ESFType esfType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.updateESFType(esfType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfTypeLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public it.ethica.esf.model.ESFType findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByCode(code);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFType> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByName(name);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFType> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByName(name, start, end);
	}

	@Override
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.countByName(name);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFType> findByClassName(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByClassName(className);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFType> findByClassName(
		java.lang.String className, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByClassName(className, start, end);
	}

	@Override
	public int countByClassName(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.countByClassName(className);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFType> findByStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByStatus(status);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFType> findByStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByStatus(status, start, end);
	}

	@Override
	public int countByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.countByStatus(status);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFType> findByTypeParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByTypeParentId(parentId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFType> findByTypeParentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.findByTypeParentId(parentId, start, end);
	}

	@Override
	public int countByTypeParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTypeException {
		return _esfTypeLocalService.countByTypeParentId(parentId);
	}

	@Override
	public it.ethica.esf.model.ESFType addESFType(long userId,
		java.lang.String code, java.lang.String name,
		java.lang.String description, java.lang.String className,
		java.lang.String status, long typeParentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.search.SearchException {
		return _esfTypeLocalService.addESFType(userId, code, name, description,
			className, status, typeParentId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFType deleteESFType(long esfTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.deleteESFType(esfTypeId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFType updateESFType(long userId,
		long esfTypeId, java.lang.String code, java.lang.String name,
		java.lang.String description, java.lang.String className,
		java.lang.String status, long typeParentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfTypeLocalService.updateESFType(userId, esfTypeId, code,
			name, description, className, status, typeParentId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFTypeLocalService getWrappedESFTypeLocalService() {
		return _esfTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFTypeLocalService(
		ESFTypeLocalService esfTypeLocalService) {
		_esfTypeLocalService = esfTypeLocalService;
	}

	@Override
	public ESFTypeLocalService getWrappedService() {
		return _esfTypeLocalService;
	}

	@Override
	public void setWrappedService(ESFTypeLocalService esfTypeLocalService) {
		_esfTypeLocalService = esfTypeLocalService;
	}

	private ESFTypeLocalService _esfTypeLocalService;
}