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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFgunUser. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFgunUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFgunUserLocalService
 * @see it.ethica.esf.service.base.ESFgunUserLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFgunUserLocalServiceImpl
 * @generated
 */
public class ESFgunUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFgunUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s fgun user to the database. Also notifies the appropriate model listeners.
	*
	* @param esFgunUser the e s fgun user
	* @return the e s fgun user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser addESFgunUser(
		it.ethica.esf.model.ESFgunUser esFgunUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFgunUser(esFgunUser);
	}

	/**
	* Creates a new e s fgun user with the primary key. Does not add the e s fgun user to the database.
	*
	* @param esfGunUserId the primary key for the new e s fgun user
	* @return the new e s fgun user
	*/
	public static it.ethica.esf.model.ESFgunUser createESFgunUser(
		long esfGunUserId) {
		return getService().createESFgunUser(esfGunUserId);
	}

	/**
	* Deletes the e s fgun user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user that was removed
	* @throws PortalException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser deleteESFgunUser(
		long esfGunUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFgunUser(esfGunUserId);
	}

	/**
	* Deletes the e s fgun user from the database. Also notifies the appropriate model listeners.
	*
	* @param esFgunUser the e s fgun user
	* @return the e s fgun user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser deleteESFgunUser(
		it.ethica.esf.model.ESFgunUser esFgunUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFgunUser(esFgunUser);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFgunUser fetchESFgunUser(
		long esfGunUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFgunUser(esfGunUserId);
	}

	/**
	* Returns the e s fgun user with the primary key.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user
	* @throws PortalException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser getESFgunUser(
		long esfGunUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFgunUser(esfGunUserId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s fgun users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> getESFgunUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFgunUsers(start, end);
	}

	/**
	* Returns the number of e s fgun users.
	*
	* @return the number of e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFgunUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFgunUsersCount();
	}

	/**
	* Updates the e s fgun user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esFgunUser the e s fgun user
	* @return the e s fgun user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser updateESFgunUser(
		it.ethica.esf.model.ESFgunUser esFgunUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFgunUser(esFgunUser);
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

	public static it.ethica.esf.model.ESFgunUser addESFGunUser(long esfGunId,
		long esfUserId, java.lang.String code, boolean isFavoriteGun, int type,
		java.lang.String note, long esfGunTypeId, long esfGunKindId,
		int typeId, java.lang.String esfMeasures, long esfCaliber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFGunUser(esfGunId, esfUserId, code, isFavoriteGun,
			type, note, esfGunTypeId, esfGunKindId, typeId, esfMeasures,
			esfCaliber, serviceContext);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> getESFGunByLikeC_K_T(
		java.lang.String code, long kind, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunByLikeC_K_T(code, kind, type, start, end);
	}

	public static int countESFGunByLikeC_K_T(java.lang.String code, long kind,
		int type) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countESFGunByLikeC_K_T(code, kind, type);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> getESFGunByLikeS_T(
		long esfShooterId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunByLikeS_T(esfShooterId, type, start, end);
	}

	public static int countESFGunByLikeS_T(long esfShooterId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countESFGunByLikeS_T(esfShooterId, type);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> getESFGunByT(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunByT(type, start, end);
	}

	public static int countESFGunByT(int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countESFGunByT(type);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> findbyESFGunId(
		long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyESFGunId(esfGunId);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> findbyESFGunId_Type(
		long esfGunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyESFGunId_Type(esfGunId, type);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> findbyCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyCode(code);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> findbyGunId_Type(
		long gunId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyGunId_Type(gunId, type, start, end);
	}

	public static int countbyGunId_Type(long gunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countbyGunId_Type(gunId, type);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> findbyKind_Shooter(
		java.lang.String name, java.lang.String lastName, long kindId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findbyKind_Shooter(name, lastName, kindId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> findCanebyKind_Shooter(
		java.lang.String name, java.lang.String lastName, long kindId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findCanebyKind_Shooter(name, lastName, kindId, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFgunUserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFgunUserLocalService.class.getName());

			if (invokableLocalService instanceof ESFgunUserLocalService) {
				_service = (ESFgunUserLocalService)invokableLocalService;
			}
			else {
				_service = new ESFgunUserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFgunUserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFgunUserLocalService service) {
	}

	private static ESFgunUserLocalService _service;
}