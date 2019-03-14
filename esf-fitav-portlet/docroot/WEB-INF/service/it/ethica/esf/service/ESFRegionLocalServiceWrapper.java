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
 * Provides a wrapper for {@link ESFRegionLocalService}.
 *
 * @author Ethica
 * @see ESFRegionLocalService
 * @generated
 */
public class ESFRegionLocalServiceWrapper implements ESFRegionLocalService,
	ServiceWrapper<ESFRegionLocalService> {
	public ESFRegionLocalServiceWrapper(
		ESFRegionLocalService esfRegionLocalService) {
		_esfRegionLocalService = esfRegionLocalService;
	}

	/**
	* Adds the e s f region to the database. Also notifies the appropriate model listeners.
	*
	* @param esfRegion the e s f region
	* @return the e s f region that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRegion addESFRegion(
		it.ethica.esf.model.ESFRegion esfRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.addESFRegion(esfRegion);
	}

	/**
	* Creates a new e s f region with the primary key. Does not add the e s f region to the database.
	*
	* @param esfRegionPK the primary key for the new e s f region
	* @return the new e s f region
	*/
	@Override
	public it.ethica.esf.model.ESFRegion createESFRegion(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK) {
		return _esfRegionLocalService.createESFRegion(esfRegionPK);
	}

	/**
	* Deletes the e s f region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRegionPK the primary key of the e s f region
	* @return the e s f region that was removed
	* @throws PortalException if a e s f region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRegion deleteESFRegion(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.deleteESFRegion(esfRegionPK);
	}

	/**
	* Deletes the e s f region from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRegion the e s f region
	* @return the e s f region that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRegion deleteESFRegion(
		it.ethica.esf.model.ESFRegion esfRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.deleteESFRegion(esfRegion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfRegionLocalService.dynamicQuery();
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
		return _esfRegionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfRegionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfRegionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfRegionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfRegionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFRegion fetchESFRegion(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.fetchESFRegion(esfRegionPK);
	}

	/**
	* Returns the e s f region with the primary key.
	*
	* @param esfRegionPK the primary key of the e s f region
	* @return the e s f region
	* @throws PortalException if a e s f region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRegion getESFRegion(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.getESFRegion(esfRegionPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f regions
	* @param end the upper bound of the range of e s f regions (not inclusive)
	* @return the range of e s f regions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFRegion> getESFRegions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.getESFRegions(start, end);
	}

	/**
	* Returns the number of e s f regions.
	*
	* @return the number of e s f regions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFRegionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.getESFRegionsCount();
	}

	/**
	* Updates the e s f region in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfRegion the e s f region
	* @return the e s f region that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRegion updateESFRegion(
		it.ethica.esf.model.ESFRegion esfRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRegionLocalService.updateESFRegion(esfRegion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfRegionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfRegionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfRegionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.ESFRegion getByRegionId(java.lang.String id) {
		return _esfRegionLocalService.getByRegionId(id);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRegion> getAllRegionByCountryId(
		java.lang.String id) {
		return _esfRegionLocalService.getAllRegionByCountryId(id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFRegionLocalService getWrappedESFRegionLocalService() {
		return _esfRegionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFRegionLocalService(
		ESFRegionLocalService esfRegionLocalService) {
		_esfRegionLocalService = esfRegionLocalService;
	}

	@Override
	public ESFRegionLocalService getWrappedService() {
		return _esfRegionLocalService;
	}

	@Override
	public void setWrappedService(ESFRegionLocalService esfRegionLocalService) {
		_esfRegionLocalService = esfRegionLocalService;
	}

	private ESFRegionLocalService _esfRegionLocalService;
}