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
 * Provides the local service utility for ESFState. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFStateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFStateLocalService
 * @see it.ethica.esf.service.base.ESFStateLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFStateLocalServiceImpl
 * @generated
 */
public class ESFStateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFStateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f state to the database. Also notifies the appropriate model listeners.
	*
	* @param esfState the e s f state
	* @return the e s f state that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFState addESFState(
		it.ethica.esf.model.ESFState esfState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFState(esfState);
	}

	/**
	* Creates a new e s f state with the primary key. Does not add the e s f state to the database.
	*
	* @param esfStateId the primary key for the new e s f state
	* @return the new e s f state
	*/
	public static it.ethica.esf.model.ESFState createESFState(long esfStateId) {
		return getService().createESFState(esfStateId);
	}

	/**
	* Deletes the e s f state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfStateId the primary key of the e s f state
	* @return the e s f state that was removed
	* @throws PortalException if a e s f state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFState deleteESFState(long esfStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFState(esfStateId);
	}

	/**
	* Deletes the e s f state from the database. Also notifies the appropriate model listeners.
	*
	* @param esfState the e s f state
	* @return the e s f state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFState deleteESFState(
		it.ethica.esf.model.ESFState esfState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFState(esfState);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFState fetchESFState(long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFState(esfStateId);
	}

	/**
	* Returns the e s f state with the primary key.
	*
	* @param esfStateId the primary key of the e s f state
	* @return the e s f state
	* @throws PortalException if a e s f state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFState getESFState(long esfStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFState(esfStateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f states
	* @param end the upper bound of the range of e s f states (not inclusive)
	* @return the range of e s f states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFState> getESFStates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFStates(start, end);
	}

	/**
	* Returns the number of e s f states.
	*
	* @return the number of e s f states
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFStatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFStatesCount();
	}

	/**
	* Updates the e s f state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfState the e s f state
	* @return the e s f state that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFState updateESFState(
		it.ethica.esf.model.ESFState esfState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFState(esfState);
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

	public static java.util.List<it.ethica.esf.model.ESFState> findESFStates(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFStates(className);
	}

	public static it.ethica.esf.model.ESFState findESFStateById(long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateException {
		return getService().findESFStateById(esfStateId);
	}

	public static java.util.List<it.ethica.esf.model.ESFState> findAllESFStates()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllESFStates();
	}

	public static it.ethica.esf.model.ESFStateAssEntity getESFStateAssEntitybyId_CN(
		long esfStateId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFStateAssEntitybyId_CN(esfStateId, className);
	}

	/**
	* Torna tutti i className associati alle entit� portlet ESF gi� assegnati
	* allo stato con id esfStateId
	*
	* @return entit� portlet ESF gi� assegnati ad uno stato
	* @throws SystemException
	*/
	public static java.util.List<com.liferay.portal.model.ClassName> getESFClassNameAssigned(
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFClassNameAssigned(esfStateId);
	}

	/**
	* Torna tutti i className associati alle entit� portlet ESF e ancora non
	* assegnati allo stato con id esfStateId
	*
	* @return entit� portlet ESF non assegnati ad uno stato
	* @throws SystemException
	*/
	public static java.util.List<com.liferay.portal.model.ClassName> getESFClassNameNotAssigned(
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFClassNameNotAssigned(esfStateId);
	}

	public static it.ethica.esf.model.ESFState addState(java.lang.String name,
		java.lang.String description)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addState(name, description);
	}

	public static it.ethica.esf.model.ESFState updateState(long esfStateId,
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateState(esfStateId, name, description);
	}

	public static it.ethica.esf.model.ESFState deleteState(long esfStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteState(esfStateId);
	}

	public static it.ethica.esf.model.ESFStateAssEntity addESFStateAssEntity(
		long esfStateId, long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFStateAssEntity(esfStateId, classNameId);
	}

	public static it.ethica.esf.model.ESFStateAssEntity deleteESFStateAssEntity(
		long esfStateId, long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFStateAssEntity(esfStateId, classNameId);
	}

	public static it.ethica.esf.model.ESFState checkName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().checkName(name);
	}

	/**
	* Verifica se � stato assegnata una o pi� entit� allo stato con id
	* esfStateId
	*
	* @return true se gia assegnata
	*/
	public static boolean isStateAssEntity(long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isStateAssEntity(esfStateId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFStateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFStateLocalService.class.getName());

			if (invokableLocalService instanceof ESFStateLocalService) {
				_service = (ESFStateLocalService)invokableLocalService;
			}
			else {
				_service = new ESFStateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFStateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFStateLocalService service) {
	}

	private static ESFStateLocalService _service;
}