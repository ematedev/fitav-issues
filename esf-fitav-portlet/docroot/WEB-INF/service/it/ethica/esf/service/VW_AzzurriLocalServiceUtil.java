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
 * Provides the local service utility for VW_Azzurri. This utility wraps
 * {@link it.ethica.esf.service.impl.VW_AzzurriLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see VW_AzzurriLocalService
 * @see it.ethica.esf.service.base.VW_AzzurriLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.VW_AzzurriLocalServiceImpl
 * @generated
 */
public class VW_AzzurriLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.VW_AzzurriLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the v w_ azzurri to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Azzurri the v w_ azzurri
	* @return the v w_ azzurri that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Azzurri addVW_Azzurri(
		it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVW_Azzurri(vw_Azzurri);
	}

	/**
	* Creates a new v w_ azzurri with the primary key. Does not add the v w_ azzurri to the database.
	*
	* @param vw_AzzurriPK the primary key for the new v w_ azzurri
	* @return the new v w_ azzurri
	*/
	public static it.ethica.esf.model.VW_Azzurri createVW_Azzurri(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK) {
		return getService().createVW_Azzurri(vw_AzzurriPK);
	}

	/**
	* Deletes the v w_ azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri that was removed
	* @throws PortalException if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Azzurri deleteVW_Azzurri(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVW_Azzurri(vw_AzzurriPK);
	}

	/**
	* Deletes the v w_ azzurri from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Azzurri the v w_ azzurri
	* @return the v w_ azzurri that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Azzurri deleteVW_Azzurri(
		it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVW_Azzurri(vw_Azzurri);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.VW_Azzurri fetchVW_Azzurri(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVW_Azzurri(vw_AzzurriPK);
	}

	/**
	* Returns the v w_ azzurri with the primary key.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri
	* @throws PortalException if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Azzurri getVW_Azzurri(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_Azzurri(vw_AzzurriPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ azzurris
	* @param end the upper bound of the range of v w_ azzurris (not inclusive)
	* @return the range of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Azzurri> getVW_Azzurris(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_Azzurris(start, end);
	}

	/**
	* Returns the number of v w_ azzurris.
	*
	* @return the number of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static int getVW_AzzurrisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_AzzurrisCount();
	}

	/**
	* Updates the v w_ azzurri in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_Azzurri the v w_ azzurri
	* @return the v w_ azzurri that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Azzurri updateVW_Azzurri(
		it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVW_Azzurri(vw_Azzurri);
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

	public static void clearService() {
		_service = null;
	}

	public static VW_AzzurriLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VW_AzzurriLocalService.class.getName());

			if (invokableLocalService instanceof VW_AzzurriLocalService) {
				_service = (VW_AzzurriLocalService)invokableLocalService;
			}
			else {
				_service = new VW_AzzurriLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VW_AzzurriLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VW_AzzurriLocalService service) {
	}

	private static VW_AzzurriLocalService _service;
}