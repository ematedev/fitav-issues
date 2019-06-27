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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VW_Staff. This utility wraps
 * {@link it.ethica.esf.service.impl.VW_StaffLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see VW_StaffLocalService
 * @see it.ethica.esf.service.base.VW_StaffLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.VW_StaffLocalServiceImpl
 * @generated
 */
public class VW_StaffLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.VW_StaffLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the v w_ staff to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Staff the v w_ staff
	* @return the v w_ staff that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Staff addVW_Staff(
		it.ethica.esf.model.VW_Staff vw_Staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVW_Staff(vw_Staff);
	}

	/**
	* Creates a new v w_ staff with the primary key. Does not add the v w_ staff to the database.
	*
	* @param vw_StaffPK the primary key for the new v w_ staff
	* @return the new v w_ staff
	*/
	public static it.ethica.esf.model.VW_Staff createVW_Staff(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK) {
		return getService().createVW_Staff(vw_StaffPK);
	}

	/**
	* Deletes the v w_ staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_StaffPK the primary key of the v w_ staff
	* @return the v w_ staff that was removed
	* @throws PortalException if a v w_ staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Staff deleteVW_Staff(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVW_Staff(vw_StaffPK);
	}

	/**
	* Deletes the v w_ staff from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Staff the v w_ staff
	* @return the v w_ staff that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Staff deleteVW_Staff(
		it.ethica.esf.model.VW_Staff vw_Staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVW_Staff(vw_Staff);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.VW_Staff fetchVW_Staff(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVW_Staff(vw_StaffPK);
	}

	/**
	* Returns the v w_ staff with the primary key.
	*
	* @param vw_StaffPK the primary key of the v w_ staff
	* @return the v w_ staff
	* @throws PortalException if a v w_ staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Staff getVW_Staff(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_Staff(vw_StaffPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ staffs
	* @param end the upper bound of the range of v w_ staffs (not inclusive)
	* @return the range of v w_ staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Staff> getVW_Staffs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_Staffs(start, end);
	}

	/**
	* Returns the number of v w_ staffs.
	*
	* @return the number of v w_ staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int getVW_StaffsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_StaffsCount();
	}

	/**
	* Updates the v w_ staff in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_Staff the v w_ staff
	* @return the v w_ staff that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Staff updateVW_Staff(
		it.ethica.esf.model.VW_Staff vw_Staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVW_Staff(vw_Staff);
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

	public static it.ethica.esf.model.VW_Staff cercaStaff(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_StaffException {
		return getService().cercaStaff(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VW_StaffLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VW_StaffLocalService.class.getName());

			if (invokableLocalService instanceof VW_StaffLocalService) {
				_service = (VW_StaffLocalService)invokableLocalService;
			}
			else {
				_service = new VW_StaffLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VW_StaffLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VW_StaffLocalService service) {
	}

	private static VW_StaffLocalService _service;
}