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
 * Provides the local service utility for ESFArticle_ESFUser. This utility wraps
 * {@link com.ethica.esf.service.impl.ESFArticle_ESFUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFArticle_ESFUserLocalService
 * @see com.ethica.esf.service.base.ESFArticle_ESFUserLocalServiceBaseImpl
 * @see com.ethica.esf.service.impl.ESFArticle_ESFUserLocalServiceImpl
 * @generated
 */
public class ESFArticle_ESFUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ethica.esf.service.impl.ESFArticle_ESFUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f article_ e s f user to the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUser the e s f article_ e s f user
	* @return the e s f article_ e s f user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser addESFArticle_ESFUser(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFArticle_ESFUser(esfArticle_ESFUser);
	}

	/**
	* Creates a new e s f article_ e s f user with the primary key. Does not add the e s f article_ e s f user to the database.
	*
	* @param esfArticle_ESFUserPK the primary key for the new e s f article_ e s f user
	* @return the new e s f article_ e s f user
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser createESFArticle_ESFUser(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK) {
		return getService().createESFArticle_ESFUser(esfArticle_ESFUserPK);
	}

	/**
	* Deletes the e s f article_ e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	* @return the e s f article_ e s f user that was removed
	* @throws PortalException if a e s f article_ e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser deleteESFArticle_ESFUser(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFArticle_ESFUser(esfArticle_ESFUserPK);
	}

	/**
	* Deletes the e s f article_ e s f user from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUser the e s f article_ e s f user
	* @return the e s f article_ e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser deleteESFArticle_ESFUser(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFArticle_ESFUser(esfArticle_ESFUser);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ethica.esf.model.ESFArticle_ESFUser fetchESFArticle_ESFUser(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFArticle_ESFUser(esfArticle_ESFUserPK);
	}

	/**
	* Returns the e s f article_ e s f user with the primary key.
	*
	* @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	* @return the e s f article_ e s f user
	* @throws PortalException if a e s f article_ e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser getESFArticle_ESFUser(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFArticle_ESFUser(esfArticle_ESFUserPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> getESFArticle_ESFUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFArticle_ESFUsers(start, end);
	}

	/**
	* Returns the number of e s f article_ e s f users.
	*
	* @return the number of e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFArticle_ESFUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFArticle_ESFUsersCount();
	}

	/**
	* Updates the e s f article_ e s f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUser the e s f article_ e s f user
	* @return the e s f article_ e s f user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser updateESFArticle_ESFUser(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFArticle_ESFUser(esfArticle_ESFUser);
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

	public static com.ethica.esf.model.ESFArticle_ESFUser addESFArticle_ESFUser(
		long esfArticleId, long esfUserId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, java.lang.String description,
		java.util.Date deliveryDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFArticle_ESFUser(esfArticleId, esfUserId, xxxlQty,
			xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty, otherQty, totalQty,
			description, deliveryDate);
	}

	public static com.ethica.esf.model.ESFArticle_ESFUser updateESFArticle_ESFUser(
		long esfArticleId, long esfUserId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, java.lang.String description,
		java.util.Date deliveryDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFArticle_ESFUser(esfArticleId, esfUserId, xxxlQty,
			xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty, otherQty, totalQty,
			description, deliveryDate);
	}

	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> findByEsfArticleId(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEsfArticleId(esfArticleId);
	}

	public static long[] getEsfUserIdByEsfArticleId(long esfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEsfUserIdByEsfArticleId(esfArticleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFArticle_ESFUserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFArticle_ESFUserLocalService.class.getName());

			if (invokableLocalService instanceof ESFArticle_ESFUserLocalService) {
				_service = (ESFArticle_ESFUserLocalService)invokableLocalService;
			}
			else {
				_service = new ESFArticle_ESFUserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFArticle_ESFUserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFArticle_ESFUserLocalService service) {
	}

	private static ESFArticle_ESFUserLocalService _service;
}