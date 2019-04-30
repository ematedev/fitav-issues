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

package it.ethica.esf.renewal.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VW_ESFListaIncarichiTessera. This utility wraps
 * {@link it.ethica.esf.renewal.service.impl.VW_ESFListaIncarichiTesseraLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiTesseraLocalService
 * @see it.ethica.esf.renewal.service.base.VW_ESFListaIncarichiTesseraLocalServiceBaseImpl
 * @see it.ethica.esf.renewal.service.impl.VW_ESFListaIncarichiTesseraLocalServiceImpl
 * @generated
 */
public class VW_ESFListaIncarichiTesseraLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.renewal.service.impl.VW_ESFListaIncarichiTesseraLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the v w_ e s f lista incarichi tessera to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiTessera the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera addVW_ESFListaIncarichiTessera(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVW_ESFListaIncarichiTessera(vw_esfListaIncarichiTessera);
	}

	/**
	* Creates a new v w_ e s f lista incarichi tessera with the primary key. Does not add the v w_ e s f lista incarichi tessera to the database.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key for the new v w_ e s f lista incarichi tessera
	* @return the new v w_ e s f lista incarichi tessera
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera createVW_ESFListaIncarichiTessera(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK) {
		return getService()
				   .createVW_ESFListaIncarichiTessera(vw_esfListaIncarichiTesseraPK);
	}

	/**
	* Deletes the v w_ e s f lista incarichi tessera with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera that was removed
	* @throws PortalException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera deleteVW_ESFListaIncarichiTessera(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteVW_ESFListaIncarichiTessera(vw_esfListaIncarichiTesseraPK);
	}

	/**
	* Deletes the v w_ e s f lista incarichi tessera from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiTessera the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera deleteVW_ESFListaIncarichiTessera(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteVW_ESFListaIncarichiTessera(vw_esfListaIncarichiTessera);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera fetchVW_ESFListaIncarichiTessera(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchVW_ESFListaIncarichiTessera(vw_esfListaIncarichiTesseraPK);
	}

	/**
	* Returns the v w_ e s f lista incarichi tessera with the primary key.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera
	* @throws PortalException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera getVW_ESFListaIncarichiTessera(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVW_ESFListaIncarichiTessera(vw_esfListaIncarichiTesseraPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ e s f lista incarichi tesseras.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	* @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	* @return the range of v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> getVW_ESFListaIncarichiTesseras(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_ESFListaIncarichiTesseras(start, end);
	}

	/**
	* Returns the number of v w_ e s f lista incarichi tesseras.
	*
	* @return the number of v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public static int getVW_ESFListaIncarichiTesserasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVW_ESFListaIncarichiTesserasCount();
	}

	/**
	* Updates the v w_ e s f lista incarichi tessera in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiTessera the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera updateVW_ESFListaIncarichiTessera(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVW_ESFListaIncarichiTessera(vw_esfListaIncarichiTessera);
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

	public static java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByorganizzazione(esfOrganizationId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VW_ESFListaIncarichiTesseraLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VW_ESFListaIncarichiTesseraLocalService.class.getName());

			if (invokableLocalService instanceof VW_ESFListaIncarichiTesseraLocalService) {
				_service = (VW_ESFListaIncarichiTesseraLocalService)invokableLocalService;
			}
			else {
				_service = new VW_ESFListaIncarichiTesseraLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VW_ESFListaIncarichiTesseraLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VW_ESFListaIncarichiTesseraLocalService service) {
	}

	private static VW_ESFListaIncarichiTesseraLocalService _service;
}