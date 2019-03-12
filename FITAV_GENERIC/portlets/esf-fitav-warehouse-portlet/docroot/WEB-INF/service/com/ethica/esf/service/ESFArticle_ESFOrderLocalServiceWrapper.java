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
 * Provides a wrapper for {@link ESFArticle_ESFOrderLocalService}.
 *
 * @author Ethica
 * @see ESFArticle_ESFOrderLocalService
 * @generated
 */
public class ESFArticle_ESFOrderLocalServiceWrapper
	implements ESFArticle_ESFOrderLocalService,
		ServiceWrapper<ESFArticle_ESFOrderLocalService> {
	public ESFArticle_ESFOrderLocalServiceWrapper(
		ESFArticle_ESFOrderLocalService esfArticle_ESFOrderLocalService) {
		_esfArticle_ESFOrderLocalService = esfArticle_ESFOrderLocalService;
	}

	/**
	* Adds the e s f article_ e s f order to the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFOrder the e s f article_ e s f order
	* @return the e s f article_ e s f order that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder addESFArticle_ESFOrder(
		com.ethica.esf.model.ESFArticle_ESFOrder esfArticle_ESFOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.addESFArticle_ESFOrder(esfArticle_ESFOrder);
	}

	/**
	* Creates a new e s f article_ e s f order with the primary key. Does not add the e s f article_ e s f order to the database.
	*
	* @param esfArticle_ESFOrderPK the primary key for the new e s f article_ e s f order
	* @return the new e s f article_ e s f order
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder createESFArticle_ESFOrder(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK) {
		return _esfArticle_ESFOrderLocalService.createESFArticle_ESFOrder(esfArticle_ESFOrderPK);
	}

	/**
	* Deletes the e s f article_ e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFOrderPK the primary key of the e s f article_ e s f order
	* @return the e s f article_ e s f order that was removed
	* @throws PortalException if a e s f article_ e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder deleteESFArticle_ESFOrder(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.deleteESFArticle_ESFOrder(esfArticle_ESFOrderPK);
	}

	/**
	* Deletes the e s f article_ e s f order from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFOrder the e s f article_ e s f order
	* @return the e s f article_ e s f order that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder deleteESFArticle_ESFOrder(
		com.ethica.esf.model.ESFArticle_ESFOrder esfArticle_ESFOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.deleteESFArticle_ESFOrder(esfArticle_ESFOrder);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfArticle_ESFOrderLocalService.dynamicQuery();
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
		return _esfArticle_ESFOrderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfArticle_ESFOrderLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfArticle_ESFOrderLocalService.dynamicQuery(dynamicQuery,
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
		return _esfArticle_ESFOrderLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfArticle_ESFOrderLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder fetchESFArticle_ESFOrder(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.fetchESFArticle_ESFOrder(esfArticle_ESFOrderPK);
	}

	/**
	* Returns the e s f article_ e s f order with the primary key.
	*
	* @param esfArticle_ESFOrderPK the primary key of the e s f article_ e s f order
	* @return the e s f article_ e s f order
	* @throws PortalException if a e s f article_ e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder getESFArticle_ESFOrder(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.getESFArticle_ESFOrder(esfArticle_ESFOrderPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f article_ e s f orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article_ e s f orders
	* @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	* @return the range of e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> getESFArticle_ESFOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.getESFArticle_ESFOrders(start,
			end);
	}

	/**
	* Returns the number of e s f article_ e s f orders.
	*
	* @return the number of e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFArticle_ESFOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.getESFArticle_ESFOrdersCount();
	}

	/**
	* Updates the e s f article_ e s f order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFOrder the e s f article_ e s f order
	* @return the e s f article_ e s f order that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder updateESFArticle_ESFOrder(
		com.ethica.esf.model.ESFArticle_ESFOrder esfArticle_ESFOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.updateESFArticle_ESFOrder(esfArticle_ESFOrder);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfArticle_ESFOrderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfArticle_ESFOrderLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfArticle_ESFOrderLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder addESFArticle_ESFOrder(
		long esfArticleId, long esfOrderId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, double price, double vat, double sale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.addESFArticle_ESFOrder(esfArticleId,
			esfOrderId, xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty,
			xxsQty, otherQty, totalQty, price, vat, sale);
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder updateESFArticle_ESFOrder(
		long esfArticleId, long esfOrderId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, double price, double vat, double sale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.updateESFArticle_ESFOrder(esfArticleId,
			esfOrderId, xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty,
			xxsQty, otherQty, totalQty, price, vat, sale);
	}

	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> findByEsfOrderId(
		long esfOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.findByEsfOrderId(esfOrderId);
	}

	@Override
	public long[] getEsfArticleIdByEsfOrderId(long esfOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFOrderLocalService.getEsfArticleIdByEsfOrderId(esfOrderId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFArticle_ESFOrderLocalService getWrappedESFArticle_ESFOrderLocalService() {
		return _esfArticle_ESFOrderLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFArticle_ESFOrderLocalService(
		ESFArticle_ESFOrderLocalService esfArticle_ESFOrderLocalService) {
		_esfArticle_ESFOrderLocalService = esfArticle_ESFOrderLocalService;
	}

	@Override
	public ESFArticle_ESFOrderLocalService getWrappedService() {
		return _esfArticle_ESFOrderLocalService;
	}

	@Override
	public void setWrappedService(
		ESFArticle_ESFOrderLocalService esfArticle_ESFOrderLocalService) {
		_esfArticle_ESFOrderLocalService = esfArticle_ESFOrderLocalService;
	}

	private ESFArticle_ESFOrderLocalService _esfArticle_ESFOrderLocalService;
}