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
 * Provides a wrapper for {@link ESFBillLocalService}.
 *
 * @author Ethica
 * @see ESFBillLocalService
 * @generated
 */
public class ESFBillLocalServiceWrapper implements ESFBillLocalService,
	ServiceWrapper<ESFBillLocalService> {
	public ESFBillLocalServiceWrapper(ESFBillLocalService esfBillLocalService) {
		_esfBillLocalService = esfBillLocalService;
	}

	/**
	* Adds the e s f bill to the database. Also notifies the appropriate model listeners.
	*
	* @param esfBill the e s f bill
	* @return the e s f bill that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFBill addESFBill(
		com.ethica.esf.model.ESFBill esfBill)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.addESFBill(esfBill);
	}

	/**
	* Creates a new e s f bill with the primary key. Does not add the e s f bill to the database.
	*
	* @param esfBillId the primary key for the new e s f bill
	* @return the new e s f bill
	*/
	@Override
	public com.ethica.esf.model.ESFBill createESFBill(long esfBillId) {
		return _esfBillLocalService.createESFBill(esfBillId);
	}

	/**
	* Deletes the e s f bill with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfBillId the primary key of the e s f bill
	* @return the e s f bill that was removed
	* @throws PortalException if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFBill deleteESFBill(long esfBillId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.deleteESFBill(esfBillId);
	}

	/**
	* Deletes the e s f bill from the database. Also notifies the appropriate model listeners.
	*
	* @param esfBill the e s f bill
	* @return the e s f bill that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFBill deleteESFBill(
		com.ethica.esf.model.ESFBill esfBill)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.deleteESFBill(esfBill);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfBillLocalService.dynamicQuery();
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
		return _esfBillLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfBillLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfBillLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfBillLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfBillLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ethica.esf.model.ESFBill fetchESFBill(long esfBillId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.fetchESFBill(esfBillId);
	}

	/**
	* Returns the e s f bill with the primary key.
	*
	* @param esfBillId the primary key of the e s f bill
	* @return the e s f bill
	* @throws PortalException if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFBill getESFBill(long esfBillId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.getESFBill(esfBillId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f bills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f bills
	* @param end the upper bound of the range of e s f bills (not inclusive)
	* @return the range of e s f bills
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ethica.esf.model.ESFBill> getESFBills(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.getESFBills(start, end);
	}

	/**
	* Returns the number of e s f bills.
	*
	* @return the number of e s f bills
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFBillsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.getESFBillsCount();
	}

	/**
	* Updates the e s f bill in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfBill the e s f bill
	* @return the e s f bill that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFBill updateESFBill(
		com.ethica.esf.model.ESFBill esfBill)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.updateESFBill(esfBill);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfBillLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfBillLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfBillLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.ethica.esf.model.ESFBill addESFBill(long esfArticleId,
		long esfOrderId, java.lang.String billNumber, long xxxlQty,
		long xxlQty, long xlQty, long lQty, long mQty, long sQty, long xsQty,
		long xxsQty, long otherQty, long totalQty)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.addESFBill(esfArticleId, esfOrderId,
			billNumber, xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty,
			xxsQty, otherQty, totalQty);
	}

	@Override
	public java.util.List<com.ethica.esf.model.ESFBill> findByEA_EO(
		long esfArticleId, long esfOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.findByEA_EO(esfArticleId, esfOrderId);
	}

	@Override
	public com.ethica.esf.model.ESFBill updateESFBill(long esfBillId,
		long esfArticleId, long esfOrderId, java.lang.String billNumber,
		long xxxlQty, long xxlQty, long xlQty, long lQty, long mQty, long sQty,
		long xsQty, long xxsQty, long otherQty, long totalQty)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBillLocalService.updateESFBill(esfBillId, esfArticleId,
			esfOrderId, billNumber, xxxlQty, xxlQty, xlQty, lQty, mQty, sQty,
			xsQty, xxsQty, otherQty, totalQty);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFBillLocalService getWrappedESFBillLocalService() {
		return _esfBillLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFBillLocalService(
		ESFBillLocalService esfBillLocalService) {
		_esfBillLocalService = esfBillLocalService;
	}

	@Override
	public ESFBillLocalService getWrappedService() {
		return _esfBillLocalService;
	}

	@Override
	public void setWrappedService(ESFBillLocalService esfBillLocalService) {
		_esfBillLocalService = esfBillLocalService;
	}

	private ESFBillLocalService _esfBillLocalService;
}