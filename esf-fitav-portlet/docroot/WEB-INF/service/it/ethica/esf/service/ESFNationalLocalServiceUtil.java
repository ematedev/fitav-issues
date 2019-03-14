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
 * Provides the local service utility for ESFNational. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFNationalLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFNationalLocalService
 * @see it.ethica.esf.service.base.ESFNationalLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFNationalLocalServiceImpl
 * @generated
 */
public class ESFNationalLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFNationalLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f national to the database. Also notifies the appropriate model listeners.
	*
	* @param esfNational the e s f national
	* @return the e s f national that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational addESFNational(
		it.ethica.esf.model.ESFNational esfNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFNational(esfNational);
	}

	/**
	* Creates a new e s f national with the primary key. Does not add the e s f national to the database.
	*
	* @param esfNationalId the primary key for the new e s f national
	* @return the new e s f national
	*/
	public static it.ethica.esf.model.ESFNational createESFNational(
		long esfNationalId) {
		return getService().createESFNational(esfNationalId);
	}

	/**
	* Deletes the e s f national with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national that was removed
	* @throws PortalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational deleteESFNational(
		long esfNationalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFNational(esfNationalId);
	}

	/**
	* Deletes the e s f national from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNational the e s f national
	* @return the e s f national that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational deleteESFNational(
		it.ethica.esf.model.ESFNational esfNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFNational(esfNational);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFNational fetchESFNational(
		long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFNational(esfNationalId);
	}

	/**
	* Returns the e s f national with the primary key.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national
	* @throws PortalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational getESFNational(
		long esfNationalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFNational(esfNationalId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f nationals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @return the range of e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNational> getESFNationals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFNationals(start, end);
	}

	/**
	* Returns the number of e s f nationals.
	*
	* @return the number of e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFNationalsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFNationalsCount();
	}

	/**
	* Updates the e s f national in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfNational the e s f national
	* @return the e s f national that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational updateESFNational(
		it.ethica.esf.model.ESFNational esfNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFNational(esfNational);
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

	public static java.util.List<it.ethica.esf.model.ESFNational> getActiveESFNationals(
		long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveESFNationals(esfSportTypeId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFNational> getActiveESFNationals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveESFNationals(start, end);
	}

	public static int countActiveESFNationals(long esfSportTypeId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countActiveESFNationals(esfSportTypeId, start, end);
	}

	public static int countActiveESFNationals()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countActiveESFNationals();
	}

	public static it.ethica.esf.model.ESFNational getActiveESFNational(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveESFNational(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFNational> getActiveESFNational_UserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActiveESFNational_UserId(esfUserId);
	}

	public static boolean isActiveESFNationals(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isActiveESFNationals(esfUserId);
	}

	public static it.ethica.esf.model.ESFNational addESFNational(long userId,
		long esfUserId, long esfSportTypeId, java.util.Date startDate,
		java.util.Date endDate, java.util.Date bdoDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFNational(userId, esfUserId, esfSportTypeId,
			startDate, endDate, bdoDate, serviceContext);
	}

	public static it.ethica.esf.model.ESFNational deleteESFNational(
		long userId, long esfNationalId, java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFNational(userId, esfNationalId, endDate,
			serviceContext);
	}

	public static java.util.List<it.ethica.esf.model.ESFNational> getEXESFNationalUser(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEXESFNationalUser(esfSportTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFNational> findNationalbySportId_MatchId(
		long esfSportTypeId, long matchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findNationalbySportId_MatchId(esfSportTypeId, matchId,
			start, end);
	}

	public static int countNationalbySportId_MatchId(long esfSportTypeId,
		long matchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countNationalbySportId_MatchId(esfSportTypeId, matchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFNational> findNationalFreeMatchIdSportId(
		long matchId, long sportTypeId, int begin, int end) {
		return getService()
				   .findNationalFreeMatchIdSportId(matchId, sportTypeId, begin,
			end);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFNationalLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFNationalLocalService.class.getName());

			if (invokableLocalService instanceof ESFNationalLocalService) {
				_service = (ESFNationalLocalService)invokableLocalService;
			}
			else {
				_service = new ESFNationalLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFNationalLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFNationalLocalService service) {
	}

	private static ESFNationalLocalService _service;
}