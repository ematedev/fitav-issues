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
 * Provides the local service utility for ESFShootingDirector. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFShootingDirectorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFShootingDirectorLocalService
 * @see it.ethica.esf.service.base.ESFShootingDirectorLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFShootingDirectorLocalServiceImpl
 * @generated
 */
public class ESFShootingDirectorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFShootingDirectorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f shooting director to the database. Also notifies the appropriate model listeners.
	*
	* @param esfShootingDirector the e s f shooting director
	* @return the e s f shooting director that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector addESFShootingDirector(
		it.ethica.esf.model.ESFShootingDirector esfShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFShootingDirector(esfShootingDirector);
	}

	/**
	* Creates a new e s f shooting director with the primary key. Does not add the e s f shooting director to the database.
	*
	* @param esfShootingDirectorId the primary key for the new e s f shooting director
	* @return the new e s f shooting director
	*/
	public static it.ethica.esf.model.ESFShootingDirector createESFShootingDirector(
		long esfShootingDirectorId) {
		return getService().createESFShootingDirector(esfShootingDirectorId);
	}

	/**
	* Deletes the e s f shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShootingDirectorId the primary key of the e s f shooting director
	* @return the e s f shooting director that was removed
	* @throws PortalException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector deleteESFShootingDirector(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFShootingDirector(esfShootingDirectorId);
	}

	/**
	* Deletes the e s f shooting director from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShootingDirector the e s f shooting director
	* @return the e s f shooting director that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector deleteESFShootingDirector(
		it.ethica.esf.model.ESFShootingDirector esfShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFShootingDirector(esfShootingDirector);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFShootingDirector fetchESFShootingDirector(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFShootingDirector(esfShootingDirectorId);
	}

	/**
	* Returns the e s f shooting director with the primary key.
	*
	* @param esfShootingDirectorId the primary key of the e s f shooting director
	* @return the e s f shooting director
	* @throws PortalException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector getESFShootingDirector(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFShootingDirector(esfShootingDirectorId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f shooting directors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @return the range of e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> getESFShootingDirectors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFShootingDirectors(start, end);
	}

	/**
	* Returns the number of e s f shooting directors.
	*
	* @return the number of e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFShootingDirectorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFShootingDirectorsCount();
	}

	/**
	* Updates the e s f shooting director in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfShootingDirector the e s f shooting director
	* @return the e s f shooting director that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector updateESFShootingDirector(
		it.ethica.esf.model.ESFShootingDirector esfShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFShootingDirector(esfShootingDirector);
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

	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId(esfUserId, start, end);
	}

	public static int countByUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserId(esfUserId);
	}

	public static it.ethica.esf.model.ESFShootingDirector findedShDr(
		long esfUserId, long sdqId, long stId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findedShDr(esfUserId, sdqId, stId);
	}

	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll(start, end);
	}

	public static int countTotal()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countTotal();
	}

	/**
	* ricerca i direttori di tiro filtrandoli in base ai parametri
	*
	* @param lastName
	* @param firstName
	* @param cardCode
	* @param regionId
	* @param qualificationId
	* @param sportTypeId
	* @param start
	* @param end
	* @return List<ESFShootingDirector>
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findShootingDirector(
		java.lang.String lastName, java.lang.String firstName,
		java.lang.String cardCode, java.lang.String regionId,
		long qualificationId, long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findShootingDirector(lastName, firstName, cardCode,
			regionId, qualificationId, sportTypeId, start, end);
	}

	/**
	* conta i direttori di tiro filtrandoli in base ai parametri
	*
	* @param lastName
	* @param firstName
	* @param cardCode
	* @param regionId
	* @param qualificationId
	* @param sportTypeId
	* @param start
	* @param end
	* @return List<ESFShootingDirector>
	* @throws SystemException
	*/
	public static int countShootingDirector(java.lang.String lastName,
		java.lang.String firstName, java.lang.String cardCode,
		java.lang.String regionId, long qualificationId, long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countShootingDirector(lastName, firstName, cardCode,
			regionId, qualificationId, sportTypeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFShootingDirectorLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFShootingDirectorLocalService.class.getName());

			if (invokableLocalService instanceof ESFShootingDirectorLocalService) {
				_service = (ESFShootingDirectorLocalService)invokableLocalService;
			}
			else {
				_service = new ESFShootingDirectorLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFShootingDirectorLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFShootingDirectorLocalService service) {
	}

	private static ESFShootingDirectorLocalService _service;
}