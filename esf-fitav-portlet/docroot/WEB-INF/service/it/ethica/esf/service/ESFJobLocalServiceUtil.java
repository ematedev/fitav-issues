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
 * Provides the local service utility for ESFJob. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFJobLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFJobLocalService
 * @see it.ethica.esf.service.base.ESFJobLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFJobLocalServiceImpl
 * @generated
 */
public class ESFJobLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFJobLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f job to the database. Also notifies the appropriate model listeners.
	*
	* @param esfJob the e s f job
	* @return the e s f job that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFJob addESFJob(
		it.ethica.esf.model.ESFJob esfJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFJob(esfJob);
	}

	/**
	* Creates a new e s f job with the primary key. Does not add the e s f job to the database.
	*
	* @param esfJobId the primary key for the new e s f job
	* @return the new e s f job
	*/
	public static it.ethica.esf.model.ESFJob createESFJob(long esfJobId) {
		return getService().createESFJob(esfJobId);
	}

	/**
	* Deletes the e s f job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfJobId the primary key of the e s f job
	* @return the e s f job that was removed
	* @throws PortalException if a e s f job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFJob deleteESFJob(long esfJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFJob(esfJobId);
	}

	/**
	* Deletes the e s f job from the database. Also notifies the appropriate model listeners.
	*
	* @param esfJob the e s f job
	* @return the e s f job that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFJob deleteESFJob(
		it.ethica.esf.model.ESFJob esfJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFJob(esfJob);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFJob fetchESFJob(long esfJobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFJob(esfJobId);
	}

	/**
	* Returns the e s f job with the primary key.
	*
	* @param esfJobId the primary key of the e s f job
	* @return the e s f job
	* @throws PortalException if a e s f job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFJob getESFJob(long esfJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFJob(esfJobId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f jobs
	* @param end the upper bound of the range of e s f jobs (not inclusive)
	* @return the range of e s f jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFJob> getESFJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFJobs(start, end);
	}

	/**
	* Returns the number of e s f jobs.
	*
	* @return the number of e s f jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFJobsCount();
	}

	/**
	* Updates the e s f job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfJob the e s f job
	* @return the e s f job that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFJob updateESFJob(
		it.ethica.esf.model.ESFJob esfJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFJob(esfJob);
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

	public static java.util.List<it.ethica.esf.model.ESFJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static it.ethica.esf.model.ESFJob addEsfJob(
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEsfJob(serviceContext, name);
	}

	public static it.ethica.esf.model.ESFJob updateEsfJob(
		com.liferay.portal.service.ServiceContext serviceContext, long jobId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEsfJob(serviceContext, jobId, name);
	}

	public static it.ethica.esf.model.ESFJob deleteEsfJob(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEsfJob(jobId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFJobLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFJobLocalService.class.getName());

			if (invokableLocalService instanceof ESFJobLocalService) {
				_service = (ESFJobLocalService)invokableLocalService;
			}
			else {
				_service = new ESFJobLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFJobLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFJobLocalService service) {
	}

	private static ESFJobLocalService _service;
}