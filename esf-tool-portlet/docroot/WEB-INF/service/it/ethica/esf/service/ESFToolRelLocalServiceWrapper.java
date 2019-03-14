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
 * Provides a wrapper for {@link ESFToolRelLocalService}.
 *
 * @author Ethica
 * @see ESFToolRelLocalService
 * @generated
 */
public class ESFToolRelLocalServiceWrapper implements ESFToolRelLocalService,
	ServiceWrapper<ESFToolRelLocalService> {
	public ESFToolRelLocalServiceWrapper(
		ESFToolRelLocalService esfToolRelLocalService) {
		_esfToolRelLocalService = esfToolRelLocalService;
	}

	/**
	* Adds the e s f tool rel to the database. Also notifies the appropriate model listeners.
	*
	* @param esfToolRel the e s f tool rel
	* @return the e s f tool rel that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel addESFToolRel(
		it.ethica.esf.model.ESFToolRel esfToolRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.addESFToolRel(esfToolRel);
	}

	/**
	* Creates a new e s f tool rel with the primary key. Does not add the e s f tool rel to the database.
	*
	* @param esfToolRelPK the primary key for the new e s f tool rel
	* @return the new e s f tool rel
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel createESFToolRel(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK) {
		return _esfToolRelLocalService.createESFToolRel(esfToolRelPK);
	}

	/**
	* Deletes the e s f tool rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfToolRelPK the primary key of the e s f tool rel
	* @return the e s f tool rel that was removed
	* @throws PortalException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel deleteESFToolRel(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.deleteESFToolRel(esfToolRelPK);
	}

	/**
	* Deletes the e s f tool rel from the database. Also notifies the appropriate model listeners.
	*
	* @param esfToolRel the e s f tool rel
	* @return the e s f tool rel that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel deleteESFToolRel(
		it.ethica.esf.model.ESFToolRel esfToolRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.deleteESFToolRel(esfToolRel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfToolRelLocalService.dynamicQuery();
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
		return _esfToolRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfToolRelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfToolRelLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfToolRelLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfToolRelLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFToolRel fetchESFToolRel(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.fetchESFToolRel(esfToolRelPK);
	}

	/**
	* Returns the e s f tool rel with the matching UUID and company.
	*
	* @param uuid the e s f tool rel's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel fetchESFToolRelByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.fetchESFToolRelByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f tool rel matching the UUID and group.
	*
	* @param uuid the e s f tool rel's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel fetchESFToolRelByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.fetchESFToolRelByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f tool rel with the primary key.
	*
	* @param esfToolRelPK the primary key of the e s f tool rel
	* @return the e s f tool rel
	* @throws PortalException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel getESFToolRel(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.getESFToolRel(esfToolRelPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f tool rel with the matching UUID and company.
	*
	* @param uuid the e s f tool rel's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f tool rel
	* @throws PortalException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel getESFToolRelByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.getESFToolRelByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f tool rel matching the UUID and group.
	*
	* @param uuid the e s f tool rel's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f tool rel
	* @throws PortalException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel getESFToolRelByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.getESFToolRelByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f tool rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFToolRel> getESFToolRels(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.getESFToolRels(start, end);
	}

	/**
	* Returns the number of e s f tool rels.
	*
	* @return the number of e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFToolRelsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.getESFToolRelsCount();
	}

	/**
	* Updates the e s f tool rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfToolRel the e s f tool rel
	* @return the e s f tool rel that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFToolRel updateESFToolRel(
		it.ethica.esf.model.ESFToolRel esfToolRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRelLocalService.updateESFToolRel(esfToolRel);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfToolRelLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfToolRelLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfToolRelLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFToolRelLocalService getWrappedESFToolRelLocalService() {
		return _esfToolRelLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFToolRelLocalService(
		ESFToolRelLocalService esfToolRelLocalService) {
		_esfToolRelLocalService = esfToolRelLocalService;
	}

	@Override
	public ESFToolRelLocalService getWrappedService() {
		return _esfToolRelLocalService;
	}

	@Override
	public void setWrappedService(ESFToolRelLocalService esfToolRelLocalService) {
		_esfToolRelLocalService = esfToolRelLocalService;
	}

	private ESFToolRelLocalService _esfToolRelLocalService;
}