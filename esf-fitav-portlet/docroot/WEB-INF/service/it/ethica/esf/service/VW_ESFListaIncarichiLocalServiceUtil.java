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
 * Provides the local service utility for VW_ESFListaIncarichi. This utility wraps
 * {@link it.ethica.esf.service.impl.VW_ESFListaIncarichiLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiLocalService
 * @see it.ethica.esf.service.base.VW_ESFListaIncarichiLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.VW_ESFListaIncarichiLocalServiceImpl
 * @generated
 */
public class VW_ESFListaIncarichiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.VW_ESFListaIncarichiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the v w_ e s f lista incarichi to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichi the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi addVW_ESFListaIncarichi(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVW_ESFListaIncarichi(vw_esfListaIncarichi);
	}

	/**
	* Creates a new v w_ e s f lista incarichi with the primary key. Does not add the v w_ e s f lista incarichi to the database.
	*
	* @param vw_esfListaIncarichiPK the primary key for the new v w_ e s f lista incarichi
	* @return the new v w_ e s f lista incarichi
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi createVW_ESFListaIncarichi(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK) {
		return getService().createVW_ESFListaIncarichi(vw_esfListaIncarichiPK);
	}

	/**
	* Deletes the v w_ e s f lista incarichi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was removed
	* @throws PortalException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi deleteVW_ESFListaIncarichi(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVW_ESFListaIncarichi(vw_esfListaIncarichiPK);
	}

	/**
	* Deletes the v w_ e s f lista incarichi from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichi the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi deleteVW_ESFListaIncarichi(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVW_ESFListaIncarichi(vw_esfListaIncarichi);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.VW_ESFListaIncarichi fetchVW_ESFListaIncarichi(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVW_ESFListaIncarichi(vw_esfListaIncarichiPK);
	}

	/**
	* Returns the v w_ e s f lista incarichi with the primary key.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi
	* @throws PortalException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi getVW_ESFListaIncarichi(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_ESFListaIncarichi(vw_esfListaIncarichiPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ e s f lista incarichis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @return the range of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> getVW_ESFListaIncarichis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_ESFListaIncarichis(start, end);
	}

	/**
	* Returns the number of v w_ e s f lista incarichis.
	*
	* @return the number of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public static int getVW_ESFListaIncarichisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_ESFListaIncarichisCount();
	}

	/**
	* Updates the v w_ e s f lista incarichi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichi the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFListaIncarichi updateVW_ESFListaIncarichi(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVW_ESFListaIncarichi(vw_esfListaIncarichi);
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

	public static java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findByorganizzazione(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByorganizzazione(esfOrganizationId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VW_ESFListaIncarichiLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VW_ESFListaIncarichiLocalService.class.getName());

			if (invokableLocalService instanceof VW_ESFListaIncarichiLocalService) {
				_service = (VW_ESFListaIncarichiLocalService)invokableLocalService;
			}
			else {
				_service = new VW_ESFListaIncarichiLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VW_ESFListaIncarichiLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VW_ESFListaIncarichiLocalService service) {
	}

	private static VW_ESFListaIncarichiLocalService _service;
}