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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFOrder. This utility wraps
 * {@link com.ethica.esf.service.impl.ESFOrderLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFOrderLocalService
 * @see com.ethica.esf.service.base.ESFOrderLocalServiceBaseImpl
 * @see com.ethica.esf.service.impl.ESFOrderLocalServiceImpl
 * @generated
 */
public class ESFOrderLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ethica.esf.service.impl.ESFOrderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f order to the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrder the e s f order
	* @return the e s f order that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder addESFOrder(
		com.ethica.esf.model.ESFOrder esfOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFOrder(esfOrder);
	}

	/**
	* Creates a new e s f order with the primary key. Does not add the e s f order to the database.
	*
	* @param esfOrderId the primary key for the new e s f order
	* @return the new e s f order
	*/
	public static com.ethica.esf.model.ESFOrder createESFOrder(long esfOrderId) {
		return getService().createESFOrder(esfOrderId);
	}

	/**
	* Deletes the e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrderId the primary key of the e s f order
	* @return the e s f order that was removed
	* @throws PortalException if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder deleteESFOrder(long esfOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFOrder(esfOrderId);
	}

	/**
	* Deletes the e s f order from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrder the e s f order
	* @return the e s f order that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder deleteESFOrder(
		com.ethica.esf.model.ESFOrder esfOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFOrder(esfOrder);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ethica.esf.model.ESFOrder fetchESFOrder(long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFOrder(esfOrderId);
	}

	/**
	* Returns the e s f order with the primary key.
	*
	* @param esfOrderId the primary key of the e s f order
	* @return the e s f order
	* @throws PortalException if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder getESFOrder(long esfOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrder(esfOrderId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f orders
	* @param end the upper bound of the range of e s f orders (not inclusive)
	* @return the range of e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> getESFOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrders(start, end);
	}

	/**
	* Returns the number of e s f orders.
	*
	* @return the number of e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrdersCount();
	}

	/**
	* Updates the e s f order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfOrder the e s f order
	* @return the e s f order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder updateESFOrder(
		com.ethica.esf.model.ESFOrder esfOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFOrder(esfOrder);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.ethica.esf.model.ESFOrder addESFOrder(
		java.lang.String code, java.lang.String name,
		java.lang.String description, java.util.Date date,
		java.lang.String note, java.lang.String protocolCode,
		java.lang.String attachment, int state, long esfStockistId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFOrder(code, name, description, date, note,
			protocolCode, attachment, state, esfStockistId);
	}

	public static com.ethica.esf.model.ESFOrder deleteESFOrder(long userId,
		long groupId, long folderId, long esfOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFOrder(userId, groupId, folderId, esfOrderId);
	}

	public static com.ethica.esf.model.ESFOrder updateESFOrder(
		long esfOrderId, java.lang.String code, java.lang.String name,
		java.lang.String description, java.util.Date date,
		java.lang.String note, java.lang.String protocolCode,
		java.lang.String attachment, int state, long esfStockistId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFOrder(esfOrderId, code, name, description, date,
			note, protocolCode, attachment, state, esfStockistId);
	}

	public static java.util.List<com.ethica.esf.model.ESFArticle> getAvailableArticles(
		long esfOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAvailableArticles(esfOrderId);
	}

	public static java.util.List<com.ethica.esf.model.ESFOrder> getESFOrdersByESFStockistId(
		long esfStockistId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrdersByESFStockistId(esfStockistId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFOrderLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFOrderLocalService.class.getName());

			if (invokableLocalService instanceof ESFOrderLocalService) {
				_service = (ESFOrderLocalService)invokableLocalService;
			}
			else {
				_service = new ESFOrderLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFOrderLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFOrderLocalService service) {
	}

	private static ESFOrderLocalService _service;
}