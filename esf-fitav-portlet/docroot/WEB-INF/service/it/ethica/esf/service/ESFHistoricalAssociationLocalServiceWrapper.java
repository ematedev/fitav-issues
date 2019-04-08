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
 * Provides a wrapper for {@link ESFHistoricalAssociationLocalService}.
 *
 * @author Ethica
 * @see ESFHistoricalAssociationLocalService
 * @generated
 */
public class ESFHistoricalAssociationLocalServiceWrapper
	implements ESFHistoricalAssociationLocalService,
		ServiceWrapper<ESFHistoricalAssociationLocalService> {
	public ESFHistoricalAssociationLocalServiceWrapper(
		ESFHistoricalAssociationLocalService esfHistoricalAssociationLocalService) {
		_esfHistoricalAssociationLocalService = esfHistoricalAssociationLocalService;
	}

	/**
	* Adds the e s f historical association to the database. Also notifies the appropriate model listeners.
	*
	* @param esfHistoricalAssociation the e s f historical association
	* @return the e s f historical association that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation addESFHistoricalAssociation(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.addESFHistoricalAssociation(esfHistoricalAssociation);
	}

	/**
	* Creates a new e s f historical association with the primary key. Does not add the e s f historical association to the database.
	*
	* @param idHistoricalAssociation the primary key for the new e s f historical association
	* @return the new e s f historical association
	*/
	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation createESFHistoricalAssociation(
		long idHistoricalAssociation) {
		return _esfHistoricalAssociationLocalService.createESFHistoricalAssociation(idHistoricalAssociation);
	}

	/**
	* Deletes the e s f historical association with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idHistoricalAssociation the primary key of the e s f historical association
	* @return the e s f historical association that was removed
	* @throws PortalException if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation deleteESFHistoricalAssociation(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.deleteESFHistoricalAssociation(idHistoricalAssociation);
	}

	/**
	* Deletes the e s f historical association from the database. Also notifies the appropriate model listeners.
	*
	* @param esfHistoricalAssociation the e s f historical association
	* @return the e s f historical association that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation deleteESFHistoricalAssociation(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.deleteESFHistoricalAssociation(esfHistoricalAssociation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfHistoricalAssociationLocalService.dynamicQuery();
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
		return _esfHistoricalAssociationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfHistoricalAssociationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfHistoricalAssociationLocalService.dynamicQuery(dynamicQuery,
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
		return _esfHistoricalAssociationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfHistoricalAssociationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation fetchESFHistoricalAssociation(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.fetchESFHistoricalAssociation(idHistoricalAssociation);
	}

	/**
	* Returns the e s f historical association with the primary key.
	*
	* @param idHistoricalAssociation the primary key of the e s f historical association
	* @return the e s f historical association
	* @throws PortalException if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation getESFHistoricalAssociation(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.getESFHistoricalAssociation(idHistoricalAssociation);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f historical associations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @return the range of e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> getESFHistoricalAssociations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.getESFHistoricalAssociations(start,
			end);
	}

	/**
	* Returns the number of e s f historical associations.
	*
	* @return the number of e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFHistoricalAssociationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.getESFHistoricalAssociationsCount();
	}

	/**
	* Updates the e s f historical association in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfHistoricalAssociation the e s f historical association
	* @return the e s f historical association that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation updateESFHistoricalAssociation(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.updateESFHistoricalAssociation(esfHistoricalAssociation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfHistoricalAssociationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfHistoricalAssociationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfHistoricalAssociationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findESFHistoricalAssociationByesfOrganizationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.findESFHistoricalAssociationByesfOrganizationId(esfOrganizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findESFHistoricalAssociationByesfOrganizationId(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.findESFHistoricalAssociationByesfOrganizationId(esfOrganizationId,
			start, end);
	}

	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation addESFHistoricalAssociation(
		long esfOrganizationId, java.lang.String name, java.lang.String code,
		java.lang.Long stateId, java.lang.Long variationId,
		java.lang.String stateVariationDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _esfHistoricalAssociationLocalService.addESFHistoricalAssociation(esfOrganizationId,
			name, code, stateId, variationId, stateVariationDate);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findbyOrg_Date(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfHistoricalAssociationLocalService.findbyOrg_Date(esfOrganizationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFHistoricalAssociationLocalService getWrappedESFHistoricalAssociationLocalService() {
		return _esfHistoricalAssociationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFHistoricalAssociationLocalService(
		ESFHistoricalAssociationLocalService esfHistoricalAssociationLocalService) {
		_esfHistoricalAssociationLocalService = esfHistoricalAssociationLocalService;
	}

	@Override
	public ESFHistoricalAssociationLocalService getWrappedService() {
		return _esfHistoricalAssociationLocalService;
	}

	@Override
	public void setWrappedService(
		ESFHistoricalAssociationLocalService esfHistoricalAssociationLocalService) {
		_esfHistoricalAssociationLocalService = esfHistoricalAssociationLocalService;
	}

	private ESFHistoricalAssociationLocalService _esfHistoricalAssociationLocalService;
}