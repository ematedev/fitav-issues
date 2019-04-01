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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ESFCane. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ethica
 * @see ESFCaneLocalServiceUtil
 * @see it.ethica.esf.service.base.ESFCaneLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFCaneLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESFCaneLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFCaneLocalServiceUtil} to access the e s f cane local service. Add custom service methods to {@link it.ethica.esf.service.impl.ESFCaneLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e s f cane to the database. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCane addESFCane(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s f cane with the primary key. Does not add the e s f cane to the database.
	*
	* @param esfCaneId the primary key for the new e s f cane
	* @return the new e s f cane
	*/
	public it.ethica.esf.model.ESFCane createESFCane(long esfCaneId);

	/**
	* Deletes the e s f cane with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCaneId the primary key of the e s f cane
	* @return the e s f cane that was removed
	* @throws PortalException if a e s f cane with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCane deleteESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s f cane from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCane deleteESFCane(
		it.ethica.esf.model.ESFCane esfCane)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public it.ethica.esf.model.ESFCane fetchESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f cane with the primary key.
	*
	* @param esfCaneId the primary key of the e s f cane
	* @return the e s f cane
	* @throws PortalException if a e s f cane with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCane getESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f canes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCaneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f canes
	* @param end the upper bound of the range of e s f canes (not inclusive)
	* @return the range of e s f canes
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCanes(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f canes.
	*
	* @return the number of e s f canes
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFCanesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s f cane in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCane updateESFCane(
		it.ethica.esf.model.ESFCane esfCane)
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

	public it.ethica.esf.model.ESFCane addESFCane(long userId,
		long esfGunKindId, long esgGunTypeId, long esfUserId,
		long esfOrganizationId, java.lang.String code, long caneCaliber,
		int typology, java.lang.String measures, boolean isFavoriteGun,
		long shooterId, java.lang.String shooter_note,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFCane updateESFCane(long userId,
		long esfCaneId, long esfGunKindId, long esgGunTypeId, long esfUserId,
		java.lang.String code, long caneCaliber, int typology,
		java.lang.String measures, boolean isFavoriteGun, long shooterId,
		java.lang.String shooter_note, long gunUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFCane deleteESFCane(long esfCaneId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base dell'utente.
	*
	* @param esfUserId l'identificativo dell'utente
	* @return List<ESFCane>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCanesByUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base dell'utente.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @param esfUserId l'identificativo dell'utente
	* @param start
	* @param end
	* @return List<ESFCane>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCanesByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFCane.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @return List<ESFCane>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCanes()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base del codice e della tipologia
	* dell'arma.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @return List<ESFCane>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCaneByLikeC_K(
		java.lang.String code, long esfGunKindId);

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base del codice e della tipologia
	* dell'arma.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param start
	* @param end
	* @return List<ESFCane>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCaneByLikeC_K(
		java.lang.String code, long esfGunKindId, int start, int end);

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base del codice dell'arma, della tipologia
	* dell'arma e dell'utente.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e il <b>esfUserId</b>
	* e' in equal.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param esfUserId l'identificativo dell'utente
	* @return List<ESFCane>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId);

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base del codice dell'arma, della tipologia
	* dell'arma e dell'utente.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e il <b>esfUserId</b>
	* e' in equal.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param esfUserId l'identificativo dell'utente
	* @param start
	* @param end
	* @return List<ESFCane>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT_C_K_U(
		long esfGunTypeId, java.lang.String code, long esfGunKindId,
		long esfUserId, int start, int end);

	public int countESFGunByLikeT_C_K_U(long esfGunTypeId,
		java.lang.String code, long esfGunKindId, long esfUserId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT_K(
		long esfGunTypeId, long esfGunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countESFGunByLikeT_K(long esfGunTypeId, long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT(
		long esfGunTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countESFGunByLikeT(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getFullName(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameMod(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameM(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameT(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFCane checkCode(java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getCanebyK(
		long gunKindId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCane> getCanebyKindId(
		long gunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countCanebyKindId(long gunKindId)
		throws com.liferay.portal.kernel.exception.SystemException;
}