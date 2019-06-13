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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ESFEntityState. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ethica
 * @see ESFEntityStateLocalServiceUtil
 * @see it.ethica.esf.service.base.ESFEntityStateLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFEntityStateLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESFEntityStateLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFEntityStateLocalServiceUtil} to access the e s f entity state local service. Add custom service methods to {@link it.ethica.esf.service.impl.ESFEntityStateLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e s f entity state to the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityState the e s f entity state
	* @return the e s f entity state that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState addESFEntityState(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s f entity state with the primary key. Does not add the e s f entity state to the database.
	*
	* @param esfEntityStateId the primary key for the new e s f entity state
	* @return the new e s f entity state
	*/
	public it.ethica.esf.model.ESFEntityState createESFEntityState(
		long esfEntityStateId);

	/**
	* Deletes the e s f entity state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state that was removed
	* @throws PortalException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState deleteESFEntityState(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s f entity state from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityState the e s f entity state
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState deleteESFEntityState(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFEntityState fetchESFEntityState(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity state with the primary key.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state
	* @throws PortalException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFEntityState getESFEntityState(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f entity states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFEntityState> getESFEntityStates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states.
	*
	* @return the number of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFEntityStatesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s f entity state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfEntityState the e s f entity state
	* @return the e s f entity state that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState updateESFEntityState(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - classPK; - WHERE CONDITION ( endDate=null )
	*
	* @throws SystemException
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findESFEntityStateByCN(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFEntityState findESFEntityStateByC_PK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - classPK; - esfStateId - WHERE CONDITION ( endDate=null )
	*/
	public it.ethica.esf.model.ESFEntityState findESFEntityStateByC_PK_S(
		java.lang.String className, long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca le entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - esfStateId - WHERE CONDITION ( endDate=null )
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findESFEntityStateByC_S(
		java.lang.String className, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFEntityState> findESFEntityStateCName_CPk(
		java.lang.String className, long classPk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca le entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - esfStateId - WHERE CONDITION ( endDate=null )
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findESFEntityStateByC_S(
		java.lang.String className, long esfStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFEntityState addEntityState(long userId,
		long groupId, long companyId, java.lang.String className, long classPK,
		long esfStateId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFEntityState addEntityState(long userId,
		java.lang.String className, long classPK, long esfStateId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFEntityState addEntityState(long userId,
		java.lang.String className, long classPK, long esfStateId,
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Effettua l'update di tutti i parametri di ESFEntityState settando la data
	* endDate = data attuale
	*/
	public it.ethica.esf.model.ESFEntityState updateEntityState(long userId,
		long esfEntityStateId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - classPK;
	*/
	public it.ethica.esf.model.ESFEntityState findAllESFEntityStateByClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFEntityState> findESShooterLastCardActive(
		long shooterId)
		throws com.liferay.portal.kernel.exception.SystemException;
}