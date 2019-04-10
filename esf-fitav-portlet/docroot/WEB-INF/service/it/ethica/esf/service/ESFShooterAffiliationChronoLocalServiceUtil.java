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
 * Provides the local service utility for ESFShooterAffiliationChrono. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFShooterAffiliationChronoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFShooterAffiliationChronoLocalService
 * @see it.ethica.esf.service.base.ESFShooterAffiliationChronoLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFShooterAffiliationChronoLocalServiceImpl
 * @generated
 */
public class ESFShooterAffiliationChronoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFShooterAffiliationChronoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f shooter affiliation chrono to the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterAffiliationChrono the e s f shooter affiliation chrono
	* @return the e s f shooter affiliation chrono that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono addESFShooterAffiliationChrono(
		it.ethica.esf.model.ESFShooterAffiliationChrono esfShooterAffiliationChrono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFShooterAffiliationChrono(esfShooterAffiliationChrono);
	}

	/**
	* Creates a new e s f shooter affiliation chrono with the primary key. Does not add the e s f shooter affiliation chrono to the database.
	*
	* @param esfShooterAffiliationChronoId the primary key for the new e s f shooter affiliation chrono
	* @return the new e s f shooter affiliation chrono
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono createESFShooterAffiliationChrono(
		long esfShooterAffiliationChronoId) {
		return getService()
				   .createESFShooterAffiliationChrono(esfShooterAffiliationChronoId);
	}

	/**
	* Deletes the e s f shooter affiliation chrono with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterAffiliationChronoId the primary key of the e s f shooter affiliation chrono
	* @return the e s f shooter affiliation chrono that was removed
	* @throws PortalException if a e s f shooter affiliation chrono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono deleteESFShooterAffiliationChrono(
		long esfShooterAffiliationChronoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFShooterAffiliationChrono(esfShooterAffiliationChronoId);
	}

	/**
	* Deletes the e s f shooter affiliation chrono from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterAffiliationChrono the e s f shooter affiliation chrono
	* @return the e s f shooter affiliation chrono that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono deleteESFShooterAffiliationChrono(
		it.ethica.esf.model.ESFShooterAffiliationChrono esfShooterAffiliationChrono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFShooterAffiliationChrono(esfShooterAffiliationChrono);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFShooterAffiliationChrono fetchESFShooterAffiliationChrono(
		long esfShooterAffiliationChronoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchESFShooterAffiliationChrono(esfShooterAffiliationChronoId);
	}

	/**
	* Returns the e s f shooter affiliation chrono with the primary key.
	*
	* @param esfShooterAffiliationChronoId the primary key of the e s f shooter affiliation chrono
	* @return the e s f shooter affiliation chrono
	* @throws PortalException if a e s f shooter affiliation chrono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono getESFShooterAffiliationChrono(
		long esfShooterAffiliationChronoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFShooterAffiliationChrono(esfShooterAffiliationChronoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f shooter affiliation chronos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @return the range of e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> getESFShooterAffiliationChronos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFShooterAffiliationChronos(start, end);
	}

	/**
	* Returns the number of e s f shooter affiliation chronos.
	*
	* @return the number of e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFShooterAffiliationChronosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFShooterAffiliationChronosCount();
	}

	/**
	* Updates the e s f shooter affiliation chrono in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfShooterAffiliationChrono the e s f shooter affiliation chrono
	* @return the e s f shooter affiliation chrono that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono updateESFShooterAffiliationChrono(
		it.ethica.esf.model.ESFShooterAffiliationChrono esfShooterAffiliationChrono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFShooterAffiliationChrono(esfShooterAffiliationChrono);
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

	public static boolean affiliated(long shooterId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().affiliated(shooterId, year);
	}

	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findbyDate(
		java.util.Date data, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyDate(data, start, end);
	}

	public static int countByDate(java.util.Date data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDate(data);
	}

	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findChronobyDate(
		java.lang.String data, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findChronobyDate(data, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findChronobyCardAndYear(
		java.lang.String card, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findChronobyCardAndYear(card, year);
	}

	public static int countChronoByDate(java.lang.String data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countChronoByDate(data);
	}

	public static int countShooterByYear(java.lang.String startDateStr,
		java.lang.String organizationCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countShooterByYear(startDateStr, organizationCode);
	}

	public static int countShooterThisYear(java.lang.String startDateStr,
		java.lang.String organizationCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countShooterThisYear(startDateStr, organizationCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFShooterAffiliationChronoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFShooterAffiliationChronoLocalService.class.getName());

			if (invokableLocalService instanceof ESFShooterAffiliationChronoLocalService) {
				_service = (ESFShooterAffiliationChronoLocalService)invokableLocalService;
			}
			else {
				_service = new ESFShooterAffiliationChronoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFShooterAffiliationChronoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFShooterAffiliationChronoLocalService service) {
	}

	private static ESFShooterAffiliationChronoLocalService _service;
}