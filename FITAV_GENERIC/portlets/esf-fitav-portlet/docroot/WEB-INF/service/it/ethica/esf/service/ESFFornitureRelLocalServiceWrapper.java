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
 * Provides a wrapper for {@link ESFFornitureRelLocalService}.
 *
 * @author Ethica
 * @see ESFFornitureRelLocalService
 * @generated
 */
public class ESFFornitureRelLocalServiceWrapper
	implements ESFFornitureRelLocalService,
		ServiceWrapper<ESFFornitureRelLocalService> {
	public ESFFornitureRelLocalServiceWrapper(
		ESFFornitureRelLocalService esfFornitureRelLocalService) {
		_esfFornitureRelLocalService = esfFornitureRelLocalService;
	}

	/**
	* Adds the e s f forniture rel to the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureRel the e s f forniture rel
	* @return the e s f forniture rel that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureRel addESFFornitureRel(
		it.ethica.esf.model.ESFFornitureRel esfFornitureRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.addESFFornitureRel(esfFornitureRel);
	}

	/**
	* Creates a new e s f forniture rel with the primary key. Does not add the e s f forniture rel to the database.
	*
	* @param esfFornitureRelPK the primary key for the new e s f forniture rel
	* @return the new e s f forniture rel
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureRel createESFFornitureRel(
		it.ethica.esf.service.persistence.ESFFornitureRelPK esfFornitureRelPK) {
		return _esfFornitureRelLocalService.createESFFornitureRel(esfFornitureRelPK);
	}

	/**
	* Deletes the e s f forniture rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureRelPK the primary key of the e s f forniture rel
	* @return the e s f forniture rel that was removed
	* @throws PortalException if a e s f forniture rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureRel deleteESFFornitureRel(
		it.ethica.esf.service.persistence.ESFFornitureRelPK esfFornitureRelPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.deleteESFFornitureRel(esfFornitureRelPK);
	}

	/**
	* Deletes the e s f forniture rel from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureRel the e s f forniture rel
	* @return the e s f forniture rel that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureRel deleteESFFornitureRel(
		it.ethica.esf.model.ESFFornitureRel esfFornitureRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.deleteESFFornitureRel(esfFornitureRel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfFornitureRelLocalService.dynamicQuery();
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
		return _esfFornitureRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFornitureRelLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFornitureRelLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfFornitureRelLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfFornitureRelLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFFornitureRel fetchESFFornitureRel(
		it.ethica.esf.service.persistence.ESFFornitureRelPK esfFornitureRelPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.fetchESFFornitureRel(esfFornitureRelPK);
	}

	/**
	* Returns the e s f forniture rel with the primary key.
	*
	* @param esfFornitureRelPK the primary key of the e s f forniture rel
	* @return the e s f forniture rel
	* @throws PortalException if a e s f forniture rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureRel getESFFornitureRel(
		it.ethica.esf.service.persistence.ESFFornitureRelPK esfFornitureRelPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.getESFFornitureRel(esfFornitureRelPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f forniture rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f forniture rels
	* @param end the upper bound of the range of e s f forniture rels (not inclusive)
	* @return the range of e s f forniture rels
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFFornitureRel> getESFFornitureRels(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.getESFFornitureRels(start, end);
	}

	/**
	* Returns the number of e s f forniture rels.
	*
	* @return the number of e s f forniture rels
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFFornitureRelsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.getESFFornitureRelsCount();
	}

	/**
	* Updates the e s f forniture rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureRel the e s f forniture rel
	* @return the e s f forniture rel that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureRel updateESFFornitureRel(
		it.ethica.esf.model.ESFFornitureRel esfFornitureRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRelLocalService.updateESFFornitureRel(esfFornitureRel);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfFornitureRelLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfFornitureRelLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfFornitureRelLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFFornitureRelLocalService getWrappedESFFornitureRelLocalService() {
		return _esfFornitureRelLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFFornitureRelLocalService(
		ESFFornitureRelLocalService esfFornitureRelLocalService) {
		_esfFornitureRelLocalService = esfFornitureRelLocalService;
	}

	@Override
	public ESFFornitureRelLocalService getWrappedService() {
		return _esfFornitureRelLocalService;
	}

	@Override
	public void setWrappedService(
		ESFFornitureRelLocalService esfFornitureRelLocalService) {
		_esfFornitureRelLocalService = esfFornitureRelLocalService;
	}

	private ESFFornitureRelLocalService _esfFornitureRelLocalService;
}