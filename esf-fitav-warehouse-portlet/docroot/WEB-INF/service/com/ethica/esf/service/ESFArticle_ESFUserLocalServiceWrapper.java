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
 * Provides a wrapper for {@link ESFArticle_ESFUserLocalService}.
 *
 * @author Ethica
 * @see ESFArticle_ESFUserLocalService
 * @generated
 */
public class ESFArticle_ESFUserLocalServiceWrapper
	implements ESFArticle_ESFUserLocalService,
		ServiceWrapper<ESFArticle_ESFUserLocalService> {
	public ESFArticle_ESFUserLocalServiceWrapper(
		ESFArticle_ESFUserLocalService esfArticle_ESFUserLocalService) {
		_esfArticle_ESFUserLocalService = esfArticle_ESFUserLocalService;
	}

	/**
	* Adds the e s f article_ e s f user to the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUser the e s f article_ e s f user
	* @return the e s f article_ e s f user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser addESFArticle_ESFUser(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.addESFArticle_ESFUser(esfArticle_ESFUser);
	}

	/**
	* Creates a new e s f article_ e s f user with the primary key. Does not add the e s f article_ e s f user to the database.
	*
	* @param esfArticle_ESFUserPK the primary key for the new e s f article_ e s f user
	* @return the new e s f article_ e s f user
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser createESFArticle_ESFUser(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK) {
		return _esfArticle_ESFUserLocalService.createESFArticle_ESFUser(esfArticle_ESFUserPK);
	}

	/**
	* Deletes the e s f article_ e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	* @return the e s f article_ e s f user that was removed
	* @throws PortalException if a e s f article_ e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser deleteESFArticle_ESFUser(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.deleteESFArticle_ESFUser(esfArticle_ESFUserPK);
	}

	/**
	* Deletes the e s f article_ e s f user from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUser the e s f article_ e s f user
	* @return the e s f article_ e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser deleteESFArticle_ESFUser(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.deleteESFArticle_ESFUser(esfArticle_ESFUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfArticle_ESFUserLocalService.dynamicQuery();
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
		return _esfArticle_ESFUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfArticle_ESFUserLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfArticle_ESFUserLocalService.dynamicQuery(dynamicQuery,
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
		return _esfArticle_ESFUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfArticle_ESFUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser fetchESFArticle_ESFUser(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.fetchESFArticle_ESFUser(esfArticle_ESFUserPK);
	}

	/**
	* Returns the e s f article_ e s f user with the primary key.
	*
	* @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	* @return the e s f article_ e s f user
	* @throws PortalException if a e s f article_ e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser getESFArticle_ESFUser(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.getESFArticle_ESFUser(esfArticle_ESFUserPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f article_ e s f users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article_ e s f users
	* @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	* @return the range of e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> getESFArticle_ESFUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.getESFArticle_ESFUsers(start, end);
	}

	/**
	* Returns the number of e s f article_ e s f users.
	*
	* @return the number of e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFArticle_ESFUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.getESFArticle_ESFUsersCount();
	}

	/**
	* Updates the e s f article_ e s f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUser the e s f article_ e s f user
	* @return the e s f article_ e s f user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser updateESFArticle_ESFUser(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.updateESFArticle_ESFUser(esfArticle_ESFUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfArticle_ESFUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfArticle_ESFUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfArticle_ESFUserLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser addESFArticle_ESFUser(
		long esfArticleId, long esfUserId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, java.lang.String description,
		java.util.Date deliveryDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.addESFArticle_ESFUser(esfArticleId,
			esfUserId, xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty,
			otherQty, totalQty, description, deliveryDate);
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser updateESFArticle_ESFUser(
		long esfArticleId, long esfUserId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, java.lang.String description,
		java.util.Date deliveryDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.updateESFArticle_ESFUser(esfArticleId,
			esfUserId, xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty,
			otherQty, totalQty, description, deliveryDate);
	}

	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> findByEsfArticleId(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.findByEsfArticleId(esfArticleId);
	}

	@Override
	public long[] getEsfUserIdByEsfArticleId(long esfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUserLocalService.getEsfUserIdByEsfArticleId(esfArticleId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFArticle_ESFUserLocalService getWrappedESFArticle_ESFUserLocalService() {
		return _esfArticle_ESFUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFArticle_ESFUserLocalService(
		ESFArticle_ESFUserLocalService esfArticle_ESFUserLocalService) {
		_esfArticle_ESFUserLocalService = esfArticle_ESFUserLocalService;
	}

	@Override
	public ESFArticle_ESFUserLocalService getWrappedService() {
		return _esfArticle_ESFUserLocalService;
	}

	@Override
	public void setWrappedService(
		ESFArticle_ESFUserLocalService esfArticle_ESFUserLocalService) {
		_esfArticle_ESFUserLocalService = esfArticle_ESFUserLocalService;
	}

	private ESFArticle_ESFUserLocalService _esfArticle_ESFUserLocalService;
}