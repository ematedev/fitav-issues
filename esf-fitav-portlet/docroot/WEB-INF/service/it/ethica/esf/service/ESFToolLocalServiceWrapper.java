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
 * Provides a wrapper for {@link ESFToolLocalService}.
 *
 * @author Ethica
 * @see ESFToolLocalService
 * @generated
 */
public class ESFToolLocalServiceWrapper implements ESFToolLocalService,
	ServiceWrapper<ESFToolLocalService> {
	public ESFToolLocalServiceWrapper(ESFToolLocalService esfToolLocalService) {
		_esfToolLocalService = esfToolLocalService;
	}

	/**
	* Adds the e s f tool to the database. Also notifies the appropriate model listeners.
	*
	* @param esfTool the e s f tool
	* @return the e s f tool that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool addESFTool(
		it.ethica.esf.model.ESFTool esfTool)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.addESFTool(esfTool);
	}

	/**
	* Creates a new e s f tool with the primary key. Does not add the e s f tool to the database.
	*
	* @param esfToolId the primary key for the new e s f tool
	* @return the new e s f tool
	*/
	@Override
	public it.ethica.esf.model.ESFTool createESFTool(long esfToolId) {
		return _esfToolLocalService.createESFTool(esfToolId);
	}

	/**
	* Deletes the e s f tool with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfToolId the primary key of the e s f tool
	* @return the e s f tool that was removed
	* @throws PortalException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool deleteESFTool(long esfToolId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.deleteESFTool(esfToolId);
	}

	/**
	* Deletes the e s f tool from the database. Also notifies the appropriate model listeners.
	*
	* @param esfTool the e s f tool
	* @return the e s f tool that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool deleteESFTool(
		it.ethica.esf.model.ESFTool esfTool)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.deleteESFTool(esfTool);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfToolLocalService.dynamicQuery();
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
		return _esfToolLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfToolLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfToolLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfToolLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfToolLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFTool fetchESFTool(long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.fetchESFTool(esfToolId);
	}

	/**
	* Returns the e s f tool with the matching UUID and company.
	*
	* @param uuid the e s f tool's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool fetchESFToolByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.fetchESFToolByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f tool matching the UUID and group.
	*
	* @param uuid the e s f tool's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool fetchESFToolByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.fetchESFToolByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f tool with the primary key.
	*
	* @param esfToolId the primary key of the e s f tool
	* @return the e s f tool
	* @throws PortalException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool getESFTool(long esfToolId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.getESFTool(esfToolId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f tool with the matching UUID and company.
	*
	* @param uuid the e s f tool's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f tool
	* @throws PortalException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool getESFToolByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.getESFToolByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f tool matching the UUID and group.
	*
	* @param uuid the e s f tool's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f tool
	* @throws PortalException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool getESFToolByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.getESFToolByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f tools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of e s f tools
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFTool> getESFTools(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.getESFTools(start, end);
	}

	/**
	* Returns the number of e s f tools.
	*
	* @return the number of e s f tools
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFToolsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.getESFToolsCount();
	}

	/**
	* Updates the e s f tool in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfTool the e s f tool
	* @return the e s f tool that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTool updateESFTool(
		it.ethica.esf.model.ESFTool esfTool)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.updateESFTool(esfTool);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfToolLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfToolLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfToolLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFTool> findByT_G(
		long esfToolId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.findByT_G(esfToolId, groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFTool> findByT_G(
		long esfToolId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.findByT_G(esfToolId, groupId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFTool> findByTools(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return _esfToolLocalService.findByTools(className, classPK);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFTool> findByTools(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return _esfToolLocalService.findByTools(className, classPK, start, end);
	}

	@Override
	public it.ethica.esf.model.ESFTool addESFTool(long userId,
		java.lang.String code, java.lang.String name,
		java.lang.String description, java.lang.String type,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.addESFTool(userId, code, name, description,
			type, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFTool updateESFTool(long userId,
		long esfToolId, java.lang.String code, java.lang.String name,
		java.lang.String description, java.lang.String type,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.updateESFTool(userId, esfToolId, code,
			name, description, type, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFTool deleteESFTool(long esfToolId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.deleteESFTool(esfToolId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFToolRel addESFToolREL(long userId,
		long classPK, long esfToolId, java.lang.String className,
		java.util.Date assignmentDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.addESFToolREL(userId, classPK, esfToolId,
			className, assignmentDate, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFToolRel updateESFToolREL(long userId,
		long classPKOld, long esfToolIdOld, java.lang.String classNameOld,
		long classPKNew, long esfToolIdNew, java.lang.String classNameNew,
		java.util.Date assignmentDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.updateESFToolREL(userId, classPKOld,
			esfToolIdOld, classNameOld, classPKNew, esfToolIdNew, classNameNew,
			assignmentDate, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFToolRel deleteESFToolREL(long classPK,
		long esfToolId, java.lang.String className,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolLocalService.deleteESFToolREL(classPK, esfToolId,
			className, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFToolLocalService getWrappedESFToolLocalService() {
		return _esfToolLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFToolLocalService(
		ESFToolLocalService esfToolLocalService) {
		_esfToolLocalService = esfToolLocalService;
	}

	@Override
	public ESFToolLocalService getWrappedService() {
		return _esfToolLocalService;
	}

	@Override
	public void setWrappedService(ESFToolLocalService esfToolLocalService) {
		_esfToolLocalService = esfToolLocalService;
	}

	private ESFToolLocalService _esfToolLocalService;
}