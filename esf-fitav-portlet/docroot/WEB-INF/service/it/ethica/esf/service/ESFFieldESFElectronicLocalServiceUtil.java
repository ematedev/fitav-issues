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
 * Provides the local service utility for ESFFieldESFElectronic. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFFieldESFElectronicLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFFieldESFElectronicLocalService
 * @see it.ethica.esf.service.base.ESFFieldESFElectronicLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFFieldESFElectronicLocalServiceImpl
 * @generated
 */
public class ESFFieldESFElectronicLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFFieldESFElectronicLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f field e s f electronic to the database. Also notifies the appropriate model listeners.
	*
	* @param esfFieldESFElectronic the e s f field e s f electronic
	* @return the e s f field e s f electronic that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic addESFFieldESFElectronic(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFFieldESFElectronic(esfFieldESFElectronic);
	}

	/**
	* Creates a new e s f field e s f electronic with the primary key. Does not add the e s f field e s f electronic to the database.
	*
	* @param id the primary key for the new e s f field e s f electronic
	* @return the new e s f field e s f electronic
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic createESFFieldESFElectronic(
		long id) {
		return getService().createESFFieldESFElectronic(id);
	}

	/**
	* Deletes the e s f field e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic that was removed
	* @throws PortalException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic deleteESFFieldESFElectronic(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFFieldESFElectronic(id);
	}

	/**
	* Deletes the e s f field e s f electronic from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFieldESFElectronic the e s f field e s f electronic
	* @return the e s f field e s f electronic that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic deleteESFFieldESFElectronic(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFFieldESFElectronic(esfFieldESFElectronic);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFFieldESFElectronic fetchESFFieldESFElectronic(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFFieldESFElectronic(id);
	}

	/**
	* Returns the e s f field e s f electronic with the primary key.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic
	* @throws PortalException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic getESFFieldESFElectronic(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFieldESFElectronic(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f field e s f electronics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @return the range of e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> getESFFieldESFElectronics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFieldESFElectronics(start, end);
	}

	/**
	* Returns the number of e s f field e s f electronics.
	*
	* @return the number of e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFFieldESFElectronicsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFieldESFElectronicsCount();
	}

	/**
	* Updates the e s f field e s f electronic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfFieldESFElectronic the e s f field e s f electronic
	* @return the e s f field e s f electronic that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFieldESFElectronic updateESFFieldESFElectronic(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFFieldESFElectronic(esfFieldESFElectronic);
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

	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByFieldId(
		long fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByFieldId(fieldId);
	}

	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByBrandId(
		long brandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBrandId(brandId);
	}

	public static it.ethica.esf.model.ESFFieldESFElectronic findByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByFieldIdBrandIdElectronicId(fieldId, brandId,
			electronicId);
	}

	public static java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByElectronicId(
		long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByElectronicId(electronicId);
	}

	public static it.ethica.esf.model.ESFFieldESFElectronic addESFFieldESFElectronic(
		long brandId, long electronicId, long fieldId,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFFieldESFElectronic(brandId, electronicId, fieldId,
			description, serviceContext);
	}

	public static it.ethica.esf.model.ESFFieldESFElectronic updateESFFieldESFElectronic(
		long esfFieldESFElectronicId, long brandId, long electronicId,
		long fieldId, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFFieldESFElectronic(esfFieldESFElectronicId,
			brandId, electronicId, fieldId, description, serviceContext);
	}

	public static it.ethica.esf.model.ESFFieldESFElectronic deleteESFFieldESFElectronic(
		long esfFieldESFElectronicId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFFieldESFElectronic(esfFieldESFElectronicId,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFFieldESFElectronicLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFFieldESFElectronicLocalService.class.getName());

			if (invokableLocalService instanceof ESFFieldESFElectronicLocalService) {
				_service = (ESFFieldESFElectronicLocalService)invokableLocalService;
			}
			else {
				_service = new ESFFieldESFElectronicLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFFieldESFElectronicLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFFieldESFElectronicLocalService service) {
	}

	private static ESFFieldESFElectronicLocalService _service;
}